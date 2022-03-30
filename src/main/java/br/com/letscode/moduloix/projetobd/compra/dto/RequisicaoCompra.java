package br.com.letscode.moduloix.projetobd.compra.dto;

import br.com.letscode.moduloix.projetobd.compraproduto.dto.CompraProdutoDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoCompra {
    private String cpf;
    private List<CompraProdutoDTO> pedido;
}
