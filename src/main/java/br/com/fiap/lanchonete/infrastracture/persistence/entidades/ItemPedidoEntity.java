package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import br.com.fiap.lanchonete.domain.ItemPedido;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "itens_pedidos")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private ProdutoEntity produto;
    private Integer quantidade;
    private BigDecimal preco;

    @Deprecated
    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(Long id, ProdutoEntity produto, Integer quantidade, BigDecimal preco) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedidoEntity(ItemPedido itemPedido) {
        this(itemPedido.getId(), new ProdutoEntity(itemPedido.getProduto()), itemPedido.getQuantidade(),
                itemPedido.getPrecoTotal());
    }

    public ItemPedido toItemPedido() {
        return new ItemPedido(this.id, this.produto.toProduto(), this.quantidade);
    }
}
