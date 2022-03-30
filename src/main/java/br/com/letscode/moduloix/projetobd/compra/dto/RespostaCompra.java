package br.com.letscode.moduloix.projetobd.compra.dto;

import br.com.letscode.moduloix.projetobd.compra.model.Compra;
import br.com.letscode.moduloix.projetobd.produto.dto.ProdutoCompradoDTO;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RespostaCompra {

    private String dataCompra;
    private String cpfCliente;
    private Float valorTotal;
    private List<ProdutoCompradoDTO> produtos = new ArrayList<>();

    public static RespostaCompra convertCompraToRespostaCompra(Compra compra) {
        RespostaCompra respostaCompra = new RespostaCompra();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        respostaCompra.setDataCompra(compra.getDataCompra().format(formato));
        respostaCompra.setCpfCliente(compra.getCpfCliente());
        respostaCompra.setValorTotal(compra.getValorTotal());
        respostaCompra.setProdutos(ProdutoCompradoDTO.converterListaProdutoParaListaProdutoCompradoDTO(compra));
        return respostaCompra;
    }



}
