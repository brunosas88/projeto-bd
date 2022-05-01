package br.com.letscode.moduloix.projetobd.user.dto;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private List<String> roles;

    public static User convertToModel(UserDTO dto, Compra userCompra) {
        User user = new User();
        user.setEnabled(true);
        user.setPassword(dto.getPassword());
        user.setUserName(dto.getUserName());
        user.setUserCompra(userCompra);
        return user;
    }
}
