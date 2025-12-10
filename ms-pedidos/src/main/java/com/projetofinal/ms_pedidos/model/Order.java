package com.projetofinal.ms_pedidos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private Double valorTotal;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private List<OrderItem> itens = new ArrayList<>();

    // Getters e Setters
    public Long getId() { return id; }
    public LocalDateTime getDataPedido() { return dataPedido; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public List<OrderItem> getItens() { return itens; }
    public void setItens(List<OrderItem> itens) { this.itens = itens; }
}