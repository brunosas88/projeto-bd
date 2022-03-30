package br.com.letscode.moduloix.projetobd.compra.dto;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.compraproduto.dto.CompraProdutoDTO;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RespostaCompra {

    private String dataCompra;
    private String cpfCliente;
    private Float valorTotal;
    private List<CompraProdutoDTO> pedidos = new ArrayList<>();

    public static RespostaCompra convertCompraToRespostaCompra(Compra compra) {
        RespostaCompra respostaCompra = new RespostaCompra();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        respostaCompra.setDataCompra(compra.getDataCompra().format(formato));
        respostaCompra.setCpfCliente(compra.getCpfCliente());
        respostaCompra.setValorTotal(compra.getValorTotal());
        respostaCompra.setPedidos(compra.getPedidos().stream().map(CompraProdutoDTO::converterCompraProdutoParaDTO).collect(Collectors.toList()));
        return respostaCompra;
    }



}
