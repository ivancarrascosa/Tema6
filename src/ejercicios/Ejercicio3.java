package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		double mediaEdad = 0;
		double mediaAlturas = 0;
		String nombres = "";
		int cont = 0;
		try (Scanner reader = new Scanner(new FileReader("src/ficheros/Alumnos.txt"))) {
			while(reader.hasNext()) {
				nombres += reader.next() + ", ";
				mediaEdad += reader.nextInt();
				mediaAlturas += reader.nextDouble();
				cont++;
			}
			mediaEdad /= cont;
			mediaAlturas /= cont;
			nombres = nombres.substring(0, nombres.length() - 2);
			System.out.println(nombres);
			System.out.println("Edad media: " + mediaEdad);
			System.out.println("Altura media: " + mediaAlturas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
