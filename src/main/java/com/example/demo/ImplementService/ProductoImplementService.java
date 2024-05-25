package com.example.demo.ImplementService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Model.ProductosJava;
import com.example.demo.Repository.ProductoRepository;
import com.example.demo.Service.ProductoService;

@Service
public class ProductoImplementService implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<ProductosJava> getProductosJava() {
		return productoRepository.findAll();

	}

	@Override
	public ProductosJava getProductosJava(Long id) {
		ProductosJava producto = productoRepository.findById(id).orElse(null);
		return producto;
	}

	@Override
    public ProductosJava RegistrarProducto(ProductosJava producto) {
        return productoRepository.save(producto);
    }

	@Override
	public void eliminarProducto(ProductosJava producto) {
		productoRepository.delete(producto);		
	}

}
