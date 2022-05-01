package br.com.letscode.moduloix.projetobd.user.controller;

import br.com.letscode.moduloix.projetobd.user.dto.UserDTO;
import br.com.letscode.moduloix.projetobd.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
    }

}
