package br.com.letscode.moduloix.projetobd.produto.service;

import br.com.letscode.moduloix.projetobd.produto.dto.ProdutoDTO;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import br.com.letscode.moduloix.projetobd.produto.repository.ProdutoRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final EntityManager entityManager;

    public ProdutoDTO cadastrarProduto (ProdutoDTO produtoDTO) {
        return ProdutoDTO.convertProdutoToDTO(produtoRepository.save(Produto.convertProdutoDTO(produtoDTO)));
    }

    public Page<ProdutoDTO> listarProdutos(Predicate predicate, Pageable pageable) {
        return produtoRepository.findAll(predicate, pageable).map(ProdutoDTO::convertProdutoToDTO);
    }

}
