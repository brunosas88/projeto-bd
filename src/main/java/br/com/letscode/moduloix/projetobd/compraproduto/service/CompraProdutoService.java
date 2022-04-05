package br.com.letscode.moduloix.projetobd.compraproduto.service;

import br.com.letscode.moduloix.projetobd.compra.dto.CompraPedidoDTO;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.compraproduto.repository.CompraProdutoRepository;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import br.com.letscode.moduloix.projetobd.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraProdutoService {

    private final CompraProdutoRepository compraProdutoRepository;
    private final ProdutoService produtoService;

    public void salvarCompraProdutoChave (List<CompraProduto> pedidos){
        compraProdutoRepository.saveAll(pedidos);
    }

    public CompraProduto salvarPedido (CompraPedidoDTO pedidoDTO, Compra novaCompra) {
        CompraProduto novoPedido = new CompraProduto();
        Produto produtoPedido = controleEstoqueVenda(pedidoDTO.getCodigoProduto(), pedidoDTO.getQtdProduto());
        novoPedido.setProduto(produtoPedido);
        novoPedido.setQtd(pedidoDTO.getQtdProduto());
        novoPedido.setCompra(novaCompra);
        return novoPedido;
    }

    public Produto controleEstoqueVenda (String codigo, Integer qtdRetirada) {
        Produto produtoEstoque = produtoService.buscarProdutoPorCodigo(codigo);
        produtoEstoque.setQtdDisponivel(produtoEstoque.getQtdDisponivel() - qtdRetirada);
        return produtoService.atualizarProduto(produtoEstoque);}


}
