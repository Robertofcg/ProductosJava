package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ProductosJava;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosJava, Long> {

}
