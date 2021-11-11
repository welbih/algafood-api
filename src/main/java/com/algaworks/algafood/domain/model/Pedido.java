package com.algaworks.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusPedido status;

    @Column(nullable = false)
    private BigDecimal subtotal;
    @Column(nullable = false)
    private BigDecimal taxaFrete;
    @Column(nullable = false)
    private BigDecimal valorTotal;

    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataCriacao;

    @Column(columnDefinition = "datetime")
    private LocalDateTime dataConfirmacao;
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataCancelamento;
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataEntrega;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "usuario_cliente_id", nullable = false)
    private Usuario cliente;

    @Embedded
    private Endereco endereco;
}
