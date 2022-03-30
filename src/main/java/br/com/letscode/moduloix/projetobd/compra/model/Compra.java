package br.com.letscode.moduloix.projetobd.compra.model;

import br.com.letscode.moduloix.projetobd.compraproduto.model.CompraProduto;
import br.com.letscode.moduloix.projetobd.produto.model.Produto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_compra")
    private LocalDateTime dataCompra;

    @Column(name = "cpf_cliente")
    private String cpfCliente;

    @Column(name = "valot_total", columnDefinition = "valot_total >= 0")
    private Float valorTotal;

    @ManyToMany
    @JoinTable(name = "compra_produto",
            joinColumns = {@JoinColumn(name = "id_compra")},
            inverseJoinColumns = {@JoinColumn(name = "id_produto")}
    )
    private List<Produto> produtos = new ArrayList<>();

    @OneToMany(mappedBy = "compra")
    private List<CompraProduto> pedidos = new ArrayList<>();

    public void adicionarProdutoLista (Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarPedidoLista (CompraProduto pedido) {
        this.pedidos.add(pedido);
    }


}
