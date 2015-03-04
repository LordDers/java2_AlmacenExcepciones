package com.zubiri.almacen;

//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
	
		int seleccion = -1;
		Scanner sc = new Scanner(System.in);
		Productos productos = null;
		
		try {
			//Leemos la lista de distribuidores del fichero.
			Distribuidores.leerDistribuidores(args[0]);
		} catch (FileNotFoundException fichero_no_encontrado) {
			System.out.println("Fichero incorrecto.");
			System.out.print("Introduzca el nombre el fichero: ");
			Distribuidores.leerDistribuidores(sc.next());
		}
		
		do {
			try {
				//Visualiza por terminal (stdout) las opciones del men�
				System.out.println("Mostrar distribuidores---------------------------1");
				System.out.println("Solicitar productos------------------------------2");
				System.out.println("Mostrar productos--------------------------------3");
				System.out.println("SALIR DEL PROGRAMA-------------------------------4");
				   
				seleccion = sc.nextInt();
				switch (seleccion) {
					
					case 1: //Mostrar distribuidores
						Distribuidores.mostrarDistribuidores();
						break;
						
					case 2: //Solicitar productos
						productos = new Productos(sc);
						break;
					case 3: //Mostrar productos
						try {
							productos.mostrarProductos();
						} catch(NullPointerException e) {
							System.out.println("\nNo has solicitado productos. "
							+ "\nA continuación, se le pedirá los productos.\n");
							productos = new Productos(sc);
							productos.mostrarProductos();
						} /*finally {
							System.out.println("Productos solicitados y mostrados correctamente.\n");
						}*/
						break;
					case 4: //Salimos
						break;
					default:
						System.out.println("No ha insertado la opción correcta");
				}
			} catch (InputMismatchException e) {
				 System.out.println("Debes introducir un número.\n");
				 sc.nextLine();
			}	
		} while (seleccion != 4);
		System.out.println("Gracias por usar nuestro programa. Que tenga un buen día!");
		sc.close();
	}

}
