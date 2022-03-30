package br.com.letscode.moduloix.projetobd.compra.service;

import br.com.letscode.moduloix.projetobd.compra.dto.RequisicaoCompra;
import br.com.letscode.moduloix.projetobd.compra.dto.RespostaCompra;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compra.repository.CompraRepository;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
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

    public RespostaCompra cadastraCompra(RequisicaoCompra requisicaoCompra) {
        Compra novaCompra = new Compra();
        novaCompra.setDataCompra(LocalDateTime.now());
        novaCompra.setCpfCliente(requisicaoCompra.getCpf());
        // PRECISA ADICIONAR O SET VALOR TOTAL
        novaCompra.setValorTotal(9999F);
        requisicaoCompra.getPedido().forEach( pedido -> {
            Produto produto = produtoService.buscarPorCodigo(pedido.getCodigoProduto());
            novaCompra.adicionarProdutoLista(produto);
            CompraProduto novoPedido = new CompraProduto();
            novoPedido.setProduto(produto);
            novoPedido.setQtd(pedido.getQtdProduto());
            novoPedido.setCompra(novaCompra);
            novaCompra.adicionarPedidoLista(novoPedido);
        });
        return RespostaCompra.convertCompraToRespostaCompra(compraRepository.save(novaCompra));
    }

    public List<RespostaCompra> listaCompras () {
        return compraRepository.findAll().stream().map(RespostaCompra::convertCompraToRespostaCompra).collect(Collectors.toList());
    }
}
