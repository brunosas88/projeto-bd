package br.com.letscode.moduloix.projetobd.user.model;

import br.com.letscode.moduloix.projetobd.authorities.model.Authority;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Authority> authorities = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_compra")
    private Compra userCompra;


}
