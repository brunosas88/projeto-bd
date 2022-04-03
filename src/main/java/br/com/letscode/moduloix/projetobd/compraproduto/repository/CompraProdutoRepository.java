package br.com.letscode.moduloix.projetobd.compraproduto.repository;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProdutoChave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProdutoRepository extends JpaRepository<CompraProduto, CompraProdutoChave> {

}
