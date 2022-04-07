package br.com.letscode.moduloix.projetobd.produto.controller;

import br.com.letscode.moduloix.projetobd.produto.dto.ProdutoDTO;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import br.com.letscode.moduloix.projetobd.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/mercado/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/admin/cadastro-produtos")
    public ResponseEntity<ProdutoDTO> cadastrarProduto (@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.cadastrarProduto(produtoDTO));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<ProdutoDTO>> listarProdutos (@QuerydslPredicate(root = Produto.class) Predicate predicate, Pageable pageable) {
        return ResponseEntity.ok(produtoService.listarProdutos(predicate, pageable));
    }
}
