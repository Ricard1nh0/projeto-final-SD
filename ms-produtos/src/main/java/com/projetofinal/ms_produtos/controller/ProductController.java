package com.projetofinal.ms_produtos.controller;

import com.projetofinal.ms_produtos.model.Product;
import com.projetofinal.ms_produtos.repository.ProductRepository;
import com.projetofinal.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired private ProductRepository repository;
    @Autowired private Environment env;

    @GetMapping
    public List<Product> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product buscar(@PathVariable Long id) {
        // Log para demonstrar balanceamento de carga no vídeo
        System.out.println("Porta respondendo: " + env.getProperty("local.server.port"));
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    }
    
    @PostMapping("/setup")
    public String setup() {
        repository.save(new Product("Notebook Gamer", 4500.00, 10));
        repository.save(new Product("Mouse Sem Fio", 50.00, 100));
        repository.save(new Product("Teclado Mecânico", 150.00, 20));
        return "Banco de dados populado!";
    }
}