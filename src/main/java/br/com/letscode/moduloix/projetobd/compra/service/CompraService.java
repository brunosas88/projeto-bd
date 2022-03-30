package br.com.letscode.moduloix.projetobd.compra.service;

import br.com.letscode.moduloix.projetobd.compra.dto.RequisicaoCompra;
import br.com.letscode.moduloix.projetobd.compra.dto.RespostaCompra;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compra.repository.CompraRepository;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.compraproduto.repository.CompraProdutoRepository;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import br.com.letscode.moduloix.projetobd.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final ProdutoService produtoService;
    private final CompraProdutoRepository compraProdutoRepository;

    public RespostaCompra cadastraCompra(RequisicaoCompra requisicaoCompra) {
        Compra novaCompra = new Compra();
        novaCompra.setDataCompra(LocalDateTime.now());
        novaCompra.setCpfCliente(requisicaoCompra.getCpf());
        novaCompra.setValorTotal(0F);
        requisicaoCompra.getPedido().forEach( pedido -> {
            Produto produto = produtoService.buscarPorCodigo(pedido.getCodigoProduto());
            novaCompra.setValorTotal( (produto.getPreco() * pedido.getQtdProduto()) + novaCompra.getValorTotal() );
            CompraProduto novoPedido = new CompraProduto();
            novoPedido.setProduto(produto);
            novoPedido.setQtd(pedido.getQtdProduto());
            novoPedido.setCompra(novaCompra);
            novaCompra.adicionarPedidoLista(novoPedido);
        });
        Compra finalNovaCompra = compraRepository.save(novaCompra);
        compraProdutoRepository.saveAll(finalNovaCompra.getPedidos());

        return RespostaCompra.convertCompraToRespostaCompra(finalNovaCompra);
    }

    public List<RespostaCompra> listaCompras () {
        return compraRepository.findAll().stream().map(RespostaCompra::convertCompraToRespostaCompra).collect(Collectors.toList());
    }
}
