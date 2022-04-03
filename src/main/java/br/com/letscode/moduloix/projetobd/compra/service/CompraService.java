package br.com.letscode.moduloix.projetobd.compra.service;

import br.com.letscode.moduloix.projetobd.compra.dto.RequisicaoCompra;
import br.com.letscode.moduloix.projetobd.compra.dto.RespostaCompra;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compra.repository.CompraRepository;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.compraproduto.repository.CompraProdutoRepository;
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

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;
    private final ProdutoService produtoService;
    private final CompraProdutoRepository compraProdutoRepository;
    private final EntityManager entityManager;

    public RespostaCompra cadastraCompra(RequisicaoCompra requisicaoCompra) {
        Compra novaCompra = new Compra();
        novaCompra.setDataCompra(LocalDateTime.now());
        novaCompra.setCpfCliente(requisicaoCompra.getCpf());
        novaCompra.setValorTotal(0F);
        requisicaoCompra.getPedido().forEach( pedido -> {
            Produto produto = buscaProdutoPorCodigo(pedido.getCodigoProduto());
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

    public Page<RespostaCompra> listaCompras (Predicate predicate, Pageable pageable) {
        return compraRepository.findAll(predicate, pageable).map(RespostaCompra::convertCompraToRespostaCompra);
    }

    private Produto buscaProdutoPorCodigo(String codigo) {
        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
        QProduto produto = QProduto.produto;
        return query.select(produto).from(produto).where(produto.codigo.eq(codigo)).fetchOne();
    }



}
