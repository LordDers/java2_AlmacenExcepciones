/**
 * 
 */
package com.zubiri.almacen;

import java.util.Scanner;

/**
 * @author xoni
 *
 */
//public abstract class Producto 
public abstract class Producto {
	
	private Distribuidor distribuidor;
	private String marca;
	private Double precio;
	private String procedencia;
	
	public Producto(Distribuidor distribuidor, String marca, Double precio, String procedencia) {
		
		this.distribuidor = distribuidor;
		this.marca = marca;
		this.precio = precio;
		this.procedencia = procedencia;
	}
	
	public Producto(Scanner sc) {
		
		System.out.println("Marca del producto:");
		this.setMarca(sc.next());
		System.out.println("Precio del producto:");
		this.setMarca(sc.next());
		System.out.println("Procedencia del producto:");
		this.setProcedencia(sc.next());
		System.out.println("Distribuidor del producto:");
		this.setDistribuidor(Distribuidores.buscarDistribuidor(sc.next()));
		//Distribuidor distribuidor = buscarDistribuidor(sc.next());
		//this.setDistribuidor(distribuidor);
		
		
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void mostrarProducto() {
		System.out.println("distribuidor: " + this.getDistribuidor().getNombre());
		System.out.println("marca:" + this.getMarca());
		System.out.println("prodecendia:" + this.getProcedencia());
		System.out.println("precio: " + this.getPrecio());
	}
}