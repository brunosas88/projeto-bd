package br.com.letscode.moduloix.projetobd.produto.controller;

import br.com.letscode.moduloix.projetobd.produto.dto.ProdutoDTO;
import br.com.letscode.moduloix.projetobd.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto (@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.cadastrarProduto(produtoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos () {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }
}
