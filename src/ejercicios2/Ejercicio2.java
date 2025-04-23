package ejercicios2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int opc;
		
		Scanner reader = new Scanner(System.in);
		try (BufferedWriter escritura = new BufferedWriter(new FileWriter("src//ficheros//libroFirmas.txt"))) {
			mostrarMenu();
			opc = reader.nextInt();
			reader.nextLine();
			while(opc != 3) {
				
			}
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
