package br.com.letscode.moduloix.projetobd.compra.service;

import br.com.letscode.moduloix.projetobd.compra.dto.RequisicaoCompraDTO;
import br.com.letscode.moduloix.projetobd.compra.dto.RespostaCompraDTO;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compra.dto.CompraPedidoDTO;
import br.com.letscode.moduloix.projetobd.compra.repository.CompraRepository;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.compraproduto.repository.CompraProdutoRepository;
import br.com.letscode.moduloix.projetobd.compraproduto.service.CompraProdutoService;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import br.com.letscode.moduloix.projetobd.produto.model.QProduto;
import br.com.letscode.moduloix.projetobd.produto.service.ProdutoService;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final CompraProdutoService compraProdutoService;
    private final ProdutoService produtoService;

    public RespostaCompraDTO cadastraCompra(RequisicaoCompraDTO requisicaoCompraDTO) {
        Compra novaCompra = new Compra();
        novaCompra.setDataCompra(LocalDateTime.now());
        novaCompra.setCpfCliente(requisicaoCompraDTO.getCpf());
        novaCompra.setValorTotal(0F);
        novaCompra.setValorTotal(calcularValorTotalPedidos(requisicaoCompraDTO.getPedido()));
        novaCompra.getPedidos().addAll( requisicaoCompraDTO.getPedido()
                .stream()
                .map(novoPedido -> {
                    try {
                        return compraProdutoService.salvarPedido(novoPedido, novaCompra);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList())
        );
        Compra novaCompraComIdRegistrado = compraRepository.save(novaCompra);
        compraProdutoService.salvarCompraProdutoChave(novaCompraComIdRegistrado.getPedidos());
        return RespostaCompraDTO.convertCompraToRespostaCompra(novaCompraComIdRegistrado);
    }

    public Page<RespostaCompraDTO> listaCompras (Predicate predicate, Pageable pageable) {
        return compraRepository.findAll(predicate, pageable).map(RespostaCompraDTO::convertCompraToRespostaCompra);
    }

    private Float calcularValorTotalPedidos (List<CompraPedidoDTO> pedidosDTO) {
        Float valorTotal = 0F;
        for (CompraPedidoDTO pedidoDTO : pedidosDTO) {
            Produto produto = produtoService.buscarProdutoPorCodigo(pedidoDTO.getCodigoProduto());
            valorTotal = valorTotal + ( produto.getPreco() * pedidoDTO.getQtdProduto() );
        }
        return valorTotal;
    }



}
