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
import com.example.demo.RecursoNoEncontradoExcepcion.RecursoNoEncontradoExcepcion;
import com.example.demo.Service.ProductoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(path = "api/productos")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://robertofcg.github.io")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Transactional
	@GetMapping

	public List<ProductosJava> getAll() {
		return productoService.getProductosJava();
	}

	@Transactional
	@GetMapping("/{id_Producto}")
	public ResponseEntity<ProductosJava> getPersonById(@PathVariable Long id_Producto) {
		ProductosJava productos = productoService.getProductosJava(id_Producto);
		if (productos == null)
			throw new RecursoNoEncontradoExcepcion("No se encontro el producto id: " + id_Producto);
		return ResponseEntity.ok(productos);

	}

	@Transactional
	@PostMapping("/insertar")
	public ProductosJava insertarProducto(@RequestBody ProductosJava producto) {
		return productoService.RegistrarProducto(producto);
	}

}
