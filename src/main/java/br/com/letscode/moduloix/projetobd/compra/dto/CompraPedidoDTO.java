package br.com.letscode.moduloix.projetobd.compra.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraPedidoDTO {

    private String codigoProduto;
    private Integer qtdProduto;

}
