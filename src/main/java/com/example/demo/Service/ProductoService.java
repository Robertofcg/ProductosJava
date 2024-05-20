package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.ProductosJava;

public interface ProductoService {
	
	List<ProductosJava> getProductosJava();
	Optional<ProductosJava> getProductosJava(Long id);

}
