package br.com.letscode.moduloix.projetobd.compraproduto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CompraProdutoChave implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_produto")
    private Integer idProduto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompraProdutoChave)) return false;
        CompraProdutoChave that = (CompraProdutoChave) o;
        return getIdCompra().equals(that.getIdCompra()) && getIdProduto().equals(that.getIdProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCompra(), getIdProduto());
    }
}
