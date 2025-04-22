package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		String fecha;

		int temperaturaMax;

		int temperaturaMin;

		int opc;

		String linea;

		Scanner reader = new Scanner(System.in);

		try (BufferedWriter escritura = new BufferedWriter(new FileWriter("src//ficheros//meteorologia.txt", true))) {
			mostrarMenu();
			opc = reader.nextInt();
			reader.nextLine();
			while (opc != 3) {
				if (opc == 1) {
					System.out.println("Introduzca la fecha:");
					fecha = reader.nextLine();
					System.out.println("Introduzca la temperatura máxima:");
					temperaturaMax = reader.nextInt();
					reader.nextLine();
					System.out.println("Introduzca la temperatura mínima:");
					temperaturaMin = reader.nextInt();
					reader.nextLine();
					escritura.write(fecha + "," + temperaturaMax + "," + temperaturaMin);
					escritura.newLine();
					escritura.flush();
				} else if (opc == 2) {
					try (BufferedReader lectura = new BufferedReader(
							new FileReader("src//ficheros//meteorologia.txt"))) {

						linea = lectura.readLine();
						while (linea != null) {
							System.out.println(linea);
							linea = lectura.readLine();
						}
					}
				} else {
					System.out.println("Opcion no válida.");
				}
				mostrarMenu();
				opc = reader.nextInt();
				reader.nextLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		reader.close();

	}

	static void mostrarMenu() {
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");
	}

}
