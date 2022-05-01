package br.com.letscode.moduloix.projetobd.authorities.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityKey implements Serializable {

    @Column(name = "username")
    private String userName;

    @Column(name = "authority")
    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorityKey)) return false;
        AuthorityKey that = (AuthorityKey) o;
        return getUserName().equals(that.getUserName()) && getAuthority().equals(that.getAuthority());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getAuthority());
    }
}
