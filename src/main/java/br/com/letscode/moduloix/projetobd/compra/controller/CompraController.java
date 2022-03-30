package br.com.letscode.moduloix.projetobd.compra.controller;

import br.com.letscode.moduloix.projetobd.compra.dto.RequisicaoCompra;
import br.com.letscode.moduloix.projetobd.compra.dto.RespostaCompra;
import br.com.letscode.moduloix.projetobd.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<RespostaCompra> cadastrarCompra (@RequestBody RequisicaoCompra requisicaoCompra) {
        return ResponseEntity.ok(compraService.cadastraCompra(requisicaoCompra));
    }
    @GetMapping
    public ResponseEntity<List<RespostaCompra>> listarCompras () {
        return ResponseEntity.ok(compraService.listaCompras());
    }

}
