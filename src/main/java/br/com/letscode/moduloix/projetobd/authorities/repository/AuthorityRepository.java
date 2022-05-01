package br.com.letscode.moduloix.projetobd.authorities.repository;

import br.com.letscode.moduloix.projetobd.authorities.model.Authority;
import br.com.letscode.moduloix.projetobd.authorities.model.AuthorityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityKey> {
}
