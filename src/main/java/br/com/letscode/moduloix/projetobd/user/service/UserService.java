package br.com.letscode.moduloix.projetobd.user.service;

import br.com.letscode.moduloix.projetobd.authorities.model.Authority;
import br.com.letscode.moduloix.projetobd.authorities.repository.AuthorityRepository;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compra.repository.CompraRepository;
import br.com.letscode.moduloix.projetobd.compra.service.CompraService;
import br.com.letscode.moduloix.projetobd.user.dto.UserDTO;
import br.com.letscode.moduloix.projetobd.user.model.User;
import br.com.letscode.moduloix.projetobd.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final CompraRepository compraRepository;

    public void registerUser(UserDTO userDTO) {
        Compra userComra = compraRepository.getById(44);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User newUser = userRepository.save(UserDTO.convertToModel(userDTO, userComra));
        userDTO.getRoles().forEach(roles -> saveAuthority(newUser, roles));

    }

    public void saveAuthority(User user, String role) {
        Authority authority = Authority.convert(user, "ROLE_" + role);
        authorityRepository.save(authority);
    }

}
