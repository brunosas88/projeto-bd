package br.com.letscode.moduloix.projetobd.compra.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraPedido {

    private String codigoProduto;
    private Integer qtdProduto;

}
