package com.projetofinal.ms_pedidos.repository;
import com.projetofinal.ms_pedidos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {}