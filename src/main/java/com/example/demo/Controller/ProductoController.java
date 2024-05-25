package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<ProductosJava> getProductoById(@PathVariable Long id_Producto) {
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

	@Transactional
	@PutMapping("/{id_Producto}")
	public ResponseEntity<ProductosJava> guardarProducto(@PathVariable Long id_Producto,
			@RequestBody ProductosJava productoActualizado) {
		ProductosJava productos = productoService.getProductosJava(id_Producto);
		if (productos == null)
			throw new RecursoNoEncontradoExcepcion("El id recibido no existe: " + id_Producto);
		productos.setNombre(productoActualizado.getNombre());
		productos.setCantidad(productoActualizado.getCantidad());
		productos.setMarca(productoActualizado.getMarca());
		productos.setModelo(productoActualizado.getModelo());
		productos.setVoltaje(productoActualizado.getVoltaje());
		productos.setPotencia(productoActualizado.getPotencia());
		productos.setPrecio(productoActualizado.getPrecio());
		productos.setLumenes(productoActualizado.getLumenes());
		productos.setAtenuable(productoActualizado.getAtenuable());
		productos.setVidaUtil(productoActualizado.getVidaUtil());
		productos.setDimensiones(productoActualizado.getDimensiones());
		productos.setAngulo(productoActualizado.getAngulo());
		productos.setDescripcion(productoActualizado.getDescripcion());
		productos.setCategoria(productoActualizado.getCategoria());
		return ResponseEntity.ok(productos);
	}
	
	@Transactional
	@DeleteMapping("/{id_Producto}")	
	public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Long id_Producto){
		ProductosJava producto = productoService.getProductosJava(id_Producto);
		
		if(producto == null)
			throw new RecursoNoEncontradoExcepcion("El id proporcionado no existe: "+id_Producto);
		productoService.eliminarProducto(producto);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Eliminado", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}

}
