package br.com.letscode.moduloix.projetobd.compra.controller;

import br.com.letscode.moduloix.projetobd.compra.dto.RequisicaoCompraDTO;
import br.com.letscode.moduloix.projetobd.compra.dto.RespostaCompraDTO;
import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compra.service.CompraService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<RespostaCompraDTO> cadastrarCompra (@RequestBody RequisicaoCompraDTO requisicaoCompra) {
        return ResponseEntity.ok(compraService.cadastraCompra(requisicaoCompra));
    }
    @GetMapping
    public ResponseEntity<Page<RespostaCompraDTO>> listarCompras (@QuerydslPredicate(root = Compra.class) Predicate predicate, Pageable pageable) {
        return ResponseEntity.ok(compraService.listaCompras(predicate, pageable));

    }

}
