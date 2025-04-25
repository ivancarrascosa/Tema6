package ejercicios2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		int cont = 0;
		
		boolean more;
		
		Scanner reader = new Scanner(System.in);
		
		String linea;
		try (BufferedReader lectura = new BufferedReader(new FileReader("src//ficheros//Ej3Boletin2.txt"))) {
			System.out.println("Escribe more si quiere leer las siguientes 24 líneas");
			more = reader.nextLine().equals("more");
			while(more) {
				linea = lectura.readLine();
				while (linea != null && cont < 24) {
					System.out.println(linea);
					linea = lectura.readLine();
					cont++;
				}
				cont = 0;
				if(linea == null) {
					more = false;
					System.out.println("No hay mas información en el fichero");
				} else {
					System.out.println("Escribe more si quiere leer las siguientes 24 líneas");
					more = reader.nextLine().equals("more");
					if(more) {
						System.out.println(linea);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
