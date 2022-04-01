package br.com.letscode.moduloix.projetobd.produto.repository;

import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>, JpaSpecificationExecutor {

    Produto findProdutoByCodigo(String codigo);

}
