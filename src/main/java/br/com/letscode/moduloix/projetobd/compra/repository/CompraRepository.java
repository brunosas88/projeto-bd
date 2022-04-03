package br.com.letscode.moduloix.projetobd.compra.repository;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>, QuerydslPredicateExecutor<Compra> {

}
