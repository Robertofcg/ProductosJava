package com.example.demo.Model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Productos_JAVA")
public class ProductosJava {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "Cantidad")
	private Integer cantidad;

	@Column(name = "Marca", length = 50)
	private String marca;

	@Column(name = "Modelo", length = 50)
	private String modelo;

	@Column(name = "Voltaje", length = 20)
	private String voltaje;

	@Column(name = "Potencia", precision = 10, scale = 2)
	private BigDecimal potencia;

	@Column(name = "Precio", nullable = false, precision = 10, scale = 2)
	private BigDecimal precio;

	@Column(name = "Lumenes")
	private Integer lumenes;

	@Column(name = "atenuable")
	private String atenuable; // Cambiado a tipo String

	@Column(name = "VidaUtil", length = 50)
	private String vidaUtil;

	@Column(name = "Dimensiones", length = 50)
	private String dimensiones;

	@Column(name = "Angulo", precision = 5, scale = 2)
	private BigDecimal angulo;

	@Column(name = "Descripcion", columnDefinition = "TEXT")
	private String descripcion;

	@Column(name = "Imagenes", columnDefinition = "LONGBLOB")
	private byte[] imagenes;

	@Column(name = "Categoria", length = 45)
	private String categoria;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
	private List<Imagenes> imagenesProd;
	
	public ProductosJava() {}

	public ProductosJava(Long id, String nombre, Integer cantidad, String marca, String modelo, String voltaje,
			BigDecimal potencia, BigDecimal precio, Integer lumenes, String atenuable, String vidaUtil,
			String dimensiones, BigDecimal angulo, String descripcion, byte[] imagenes, String categoria,
			List<Imagenes> imagenesProd) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.marca = marca;
		this.modelo = modelo;
		this.voltaje = voltaje;
		this.potencia = potencia;
		this.precio = precio;
		this.lumenes = lumenes;
		this.atenuable = atenuable;
		this.vidaUtil = vidaUtil;
		this.dimensiones = dimensiones;
		this.angulo = angulo;
		this.descripcion = descripcion;
		this.imagenes = imagenes;
		this.categoria = categoria;
		this.imagenesProd = imagenesProd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(String voltaje) {
		this.voltaje = voltaje;
	}

	public BigDecimal getPotencia() {
		return potencia;
	}

	public void setPotencia(BigDecimal potencia) {
		this.potencia = potencia;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getLumenes() {
		return lumenes;
	}

	public void setLumenes(Integer lumenes) {
		this.lumenes = lumenes;
	}

	public String getAtenuable() {
		return atenuable;
	}

	public void setAtenuable(String atenuable) {
		this.atenuable = atenuable;
	}

	public String getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(String vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public BigDecimal getAngulo() {
		return angulo;
	}

	public void setAngulo(BigDecimal angulo) {
		this.angulo = angulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(byte[] imagenes) {
		this.imagenes = imagenes;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Imagenes> getImagenesProd() {
		return imagenesProd;
	}

	public void setImagenesProd(List<Imagenes> imagenesProd) {
		this.imagenesProd = imagenesProd;
	}	
	
}
	

