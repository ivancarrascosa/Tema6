package ejercicios2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int opc;
		
		Scanner reader = new Scanner(System.in);
		
		HashSet<String> conjuntoNombres = new HashSet<>();
		
		cargarNombreDesdeFichero(conjuntoNombres);
		
		String nombreFirmar;
		
		try (BufferedWriter escritura = new BufferedWriter(new FileWriter("src//ficheros//libroFirmas.txt", true))) {
			mostrarMenu();
			opc = reader.nextInt();
			reader.nextLine();
			while(opc != 3) {
				if(opc == 1) {
					System.out.println("Introduzca el nombre con el que quiere firmar:");
					nombreFirmar = reader.nextLine();
					if (conjuntoNombres.contains(nombreFirmar)) {
						System.out.println("El nombre ya está en el libro.");
					} else {
						conjuntoNombres.add(nombreFirmar);
						escritura.append(nombreFirmar);
						escritura.newLine();
						escritura.flush();
						System.out.println("Nombre añadido correctamente.");
					}
				} else if (opc == 2) {
					for (String nombre : conjuntoNombres) {
						System.out.println(nombre);
					}
				}
				mostrarMenu();
				opc = reader.nextInt();
				reader.nextLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader.close();

	}
	
	private static void cargarNombreDesdeFichero(HashSet<String> conjuntoNombres) {
		try (BufferedReader lectura = new BufferedReader(new FileReader("src//ficheros//libroFirmas.txt"))) {
			String nombre;
			nombre = lectura.readLine();
			while (nombre != null) {
				conjuntoNombres.add(nombre);
				nombre = lectura.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void mostrarMenu() {
		System.out.println("Elija una opción:");
		System.out.println("1. Firmar");
		System.out.println("2. Mostrar firmas");
		System.out.println("3. Salir");
	}
}
