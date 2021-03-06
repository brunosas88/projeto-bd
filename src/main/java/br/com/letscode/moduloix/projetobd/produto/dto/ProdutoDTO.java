package br.com.letscode.moduloix.projetobd.produto.dto;

import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoDTO {
    private String codigo;
    private Float preco;
    private Integer qtdDisponivel;

    public static ProdutoDTO convertProdutoToDTO (Produto produto) {
        return new ProdutoDTO(produto.getCodigo(), produto.getPreco(), produto.getQtdDisponivel());
    }

}
