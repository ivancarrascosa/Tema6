package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int suma = 0;
		double media;
		int cont = 0;
		try (Scanner reader = new Scanner (new FileReader("src//ficheros//Enteros.txt"))) {
			while(reader.hasNextInt()) {
				suma += reader.nextInt();
				cont++;
			}
			media = suma/cont;
			System.out.println("La media es: " + media);
			System.out.println("La suma es: " + suma);
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
