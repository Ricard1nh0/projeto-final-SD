package com.projetofinal.ms_pedidos.controller;

import com.projetofinal.ms_pedidos.model.Order;
import com.projetofinal.ms_pedidos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class OrderController {
    
    @Autowired private OrderRepository repository;

    @PostMapping
    public Order criarPedido(@RequestBody Order pedido) {
        double total = pedido.getItens().stream()
            .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
            .sum();
        pedido.setValorTotal(total);
        return repository.save(pedido);
    }
    
    @GetMapping
    public List<Order> listar() {
        return repository.findAll();
    }
}