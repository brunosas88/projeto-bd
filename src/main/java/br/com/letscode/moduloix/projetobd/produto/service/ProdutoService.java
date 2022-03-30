package br.com.letscode.moduloix.projetobd.produto.service;

import br.com.letscode.moduloix.projetobd.produto.dto.ProdutoDTO;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import br.com.letscode.moduloix.projetobd.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoDTO cadastrarProduto (ProdutoDTO produtoDTO) {
        return ProdutoDTO.convertProdutoToDTO(produtoRepository.save(Produto.convertProdutoDTO(produtoDTO)));
    }

    public List<ProdutoDTO> listarProdutos () {
        return produtoRepository.findAll().stream().map(ProdutoDTO::convertProdutoToDTO).collect(Collectors.toList());
    }

    public Produto buscarPorCodigo (String codigo) {
        return produtoRepository.findProdutoByCodigo(codigo);
    }

}
