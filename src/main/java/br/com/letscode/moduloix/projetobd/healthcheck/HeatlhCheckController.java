package br.com.letscode.moduloix.projetobd.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeatlhCheckController {
    @GetMapping("/healthCheck")
    @ResponseBody
    public String healthCheck(){
        return "Server Running!";
    }
}
