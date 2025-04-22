package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		String ruta = "src//ficheros//NumerosReales.txt";
		double suma = 0;
		double media;
		double numero;
		int cont = 0;
		
		try {
			Scanner reader = new Scanner(new FileReader(ruta));
			
			while(reader.hasNextDouble()) {
				numero = reader.nextDouble();
				suma += numero;
				cont++;
			}
			
			media = suma/cont;
			System.out.println("Suma total = " + suma);
			System.out.println("Media = " + media);
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero: " + e.getMessage());
		}

	}

}
