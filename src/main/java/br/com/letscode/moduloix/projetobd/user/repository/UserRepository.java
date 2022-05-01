package br.com.letscode.moduloix.projetobd.user.repository;

import br.com.letscode.moduloix.projetobd.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
