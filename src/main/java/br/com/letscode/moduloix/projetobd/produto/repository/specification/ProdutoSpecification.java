package br.com.letscode.moduloix.projetobd.produto.repository.specification;

import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import org.springframework.data.jpa.domain.Specification;


public class ProdutoSpecification {

    public static Specification<Produto> filterByCodigo(String codigo) {
        return ((root, query, buider) ->
                buider.equal(root.get("codigo"), codigo));
    }
}
