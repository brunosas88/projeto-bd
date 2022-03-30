package br.com.letscode.moduloix.projetobd.compraproduto.model;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "compra_produto")
public class CompraProduto {

    @EmbeddedId
    private CompraProdutoChave id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private Integer qtd;

}
