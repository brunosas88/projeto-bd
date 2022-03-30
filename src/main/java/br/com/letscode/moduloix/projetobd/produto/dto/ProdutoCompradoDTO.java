package br.com.letscode.moduloix.projetobd.produto.dto;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoCompradoDTO {
    private String codigo;
    private Float preco;
    private Integer qtdComprada;

    public static List<ProdutoCompradoDTO> converterListaProdutoParaListaProdutoCompradoDTO (Compra compra) {
        List<ProdutoCompradoDTO> produtos = new ArrayList<>();



        for (int i = 0; i < compra.getProdutos().size(); i++) {
            ProdutoCompradoDTO produtoComprado = new ProdutoCompradoDTO();
            produtoComprado.setCodigo(compra.getProdutos().get(i).getCodigo());
            produtoComprado.setPreco(compra.getProdutos().get(i).getPreco());
            produtoComprado.setQtdComprada(compra.getPedidos().get(i).getQtd());
            produtos.add(produtoComprado);
        }
        return produtos;
    }
}
