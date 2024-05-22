package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ProductosJava;
import com.example.demo.Service.ProductoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Transactional
	@GetMapping
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "https://robertofcg.github.io")
	public List<ProductosJava> getAll() {
		return productoService.getProductosJava();
	}

	@Transactional
	@GetMapping("/{id_Producto}")
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "https://robertofcg.github.io")
	public Optional<ProductosJava> getPersonById(@PathVariable("id_Producto") Long id_Producto) {
		return productoService.getProductosJava(id_Producto);
	}

	@Transactional
	@PostMapping("/insertar")
    public ResponseEntity<?> insertarProducto(@RequestBody ProductosJava producto) {
        productoService.RegistrarProducto(producto);
        return ResponseEntity.ok("Producto creado exitosamente");
    }

}
