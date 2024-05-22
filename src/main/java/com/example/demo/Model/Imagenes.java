package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "imagenesProd")
public class Imagenes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Imagenes", columnDefinition = "LONGBLOB")
    private byte[] imagenes;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonBackReference
    private ProductosJava producto;

    public Imagenes() {}

    public Imagenes(Long id, byte[] imagenes, ProductosJava producto) {
        this.id = id;
        this.imagenes = imagenes;
        this.producto = producto;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(byte[] imagenes) {
		this.imagenes = imagenes;
	}

	public ProductosJava getProducto() {
		return producto;
	}

	public void setProducto(ProductosJava producto) {
		this.producto = producto;
	}

		
	
}
