package com.zubiri.almacen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Productos {
	
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();	
	
	public Productos(Scanner sc) throws Exception {

	int seleccion = -1;
	int seleccionPro = -1;
		
		do {
		    try {
		    	System.out.println("¿Cuantos productos quieres insertar? ");
		    	seleccion = sc.nextInt();
		    } catch (InputMismatchException e) {
		        System.out.println("Debes introducir un número.\n");
		        sc.nextLine();
		    }
		} while (seleccion < 0);
		
		for (int i = 0; i < seleccion; i++) {
			do {
				try {
				System.out.println("¿Qué producto quieres insertar?");
				System.out.println("MANZANA:--------1");
				System.out.println("LECHE:----------2");
				System.out.println("LECHUGA:--------3");
				seleccionPro = sc.nextInt();
				
				} catch (InputMismatchException e) {
					 System.out.println("Debes introducir un número.\n");
					 sc.nextLine();
				}
			} while (seleccionPro != 1 && seleccionPro != 2 && seleccionPro != 3);
		    
			switch(seleccionPro) {
				case 1:
					Manzana manzana = new Manzana(sc);
					listaProductos.add(manzana);
					break;
				case 2:
					Leche leche = new Leche(sc);
					listaProductos.add(leche);
					break;
				case 3:
					Lechuga lechuga = new Lechuga(sc);
					listaProductos.add(lechuga);
					break;
				default:
					System.out.println("No ha insertado la opción correcta.");
					break;
			}	
		}
	} 
		 
	public void mostrarProductos() {
		
		if (listaProductos.size() == 0) {
			System.out.println("No se han cargado los productos");
		}
		for (int i = 0;i < listaProductos.size();i++) {
			Producto producto = listaProductos.get(i);
			producto.mostrarProducto(); //dispatching din�mico a partir de polimorfismo
		}
	}

}
