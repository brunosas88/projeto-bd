package br.com.letscode.moduloix.projetobd.compra.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoCompraDTO {
    private String cpf;
    private List<CompraPedidoDTO> pedido;
}
