package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		String cosasParaEscribir;
		try (BufferedWriter in = new BufferedWriter(new FileWriter("src//ficheros//Ejercicio4.txt"))) {
			Scanner reader = new Scanner (System.in);
			System.out.println("Introduzca lo que quiere escribir en el archivo:");
			cosasParaEscribir = reader.nextLine();
			while (!cosasParaEscribir.equals("fin")) {
				in.write(cosasParaEscribir);
				in.newLine();
				System.out.println("Introduzca lo que quiere escribir en el archivo:");
				cosasParaEscribir = reader.nextLine();
			}
			in.flush();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
