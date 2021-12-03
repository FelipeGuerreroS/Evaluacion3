package com.fguerrero.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table (name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private int cantidad;
	private Double subtotal;
	
	@Column(updatable = false)
	private Date createAt;
	
	private Date updateAt;
	
	/*@OneToMany(mappedBy ="venta", fetch = FetchType.LAZY)
	private List<Producto> productos;*/

	public Venta() {
		super();
	}

	public Venta(int cantidad, Double subtotal, List<Producto> productos) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		//this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	/*public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}*/
	@PrePersist
    protected void onCreate(){
        this.createAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateAt = new Date();
    }
	
}
