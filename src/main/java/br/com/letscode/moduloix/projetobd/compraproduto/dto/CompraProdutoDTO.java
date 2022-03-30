package br.com.letscode.moduloix.projetobd.compraproduto.dto;

import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraProdutoDTO {

    private String codigo;
    private Float preco;
    private Integer qtd;

    public static CompraProdutoDTO converterCompraProdutoParaDTO (CompraProduto compraProduto) {
        return new CompraProdutoDTO(compraProduto.getProduto().getCodigo(), compraProduto.getProduto().getPreco(), compraProduto.getQtd());
    }
}
