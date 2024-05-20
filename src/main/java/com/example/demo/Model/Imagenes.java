package com.example.demo.Model;

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
	
	@Column(name = "Imagenes", columnDefinition="LONGBLOB")
	private byte[] imagenes;
	
	@Column(name = "producto_id")
    private Long productoId;
	public Imagenes() {}

	public Imagenes(Long id, byte[] imagenes, Long productoId) {
        this.id = id;
        this.imagenes = imagenes;
        this.productoId = productoId;
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

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}	
	
}
