package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		String nombreYEdad;
		try(BufferedWriter in = new BufferedWriter(new FileWriter("src//ficheros//Ejercicio5.txt", true))) {
			Scanner reader = new Scanner(System.in);
			System.out.println("Introduzca su nombre y edad:");
			nombreYEdad = reader.nextLine();
			in.write(nombreYEdad);
			in.newLine();
			in.flush();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
