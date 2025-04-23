package ejercicios2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		String linea;

		int contLineas = 0;

		int contChar = 0;

		int contPalabras = 0;

		try (BufferedReader lectura = new BufferedReader(new FileReader("src//ficheros//carta.txt"))) {
			linea = lectura.readLine();
			while (linea != null) {
				for (int i = 0; i < linea.length(); i++) {
					if (!(i == 0 && linea.charAt(i) == ' ')) {
						if (linea.charAt(i) == ' ') {
							contPalabras++;
						}
					}
				}
				contChar += linea.length();
				contLineas++;
				contPalabras++;
				linea = lectura.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(contLineas + " " + contPalabras + " " + contChar);

	}

}
