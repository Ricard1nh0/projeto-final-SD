package com.projetofinal.ms_produtos.repository;

import com.projetofinal.ms_produtos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}