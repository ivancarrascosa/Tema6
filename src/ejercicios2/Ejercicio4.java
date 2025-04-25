package ejercicios2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class Ejercicio4 {

	public static void main(String[] args) {
		TreeMap<String, Integer> alfabeto = new TreeMap<String, Integer>();
		String[] codificado;
		int cont = 1;
		String linea;
		String caracterActual;
		try (BufferedReader lectura = new BufferedReader(new FileReader("src//ficheros//codec.txt"))) {
			for (String letra : lectura.readLine().split(" ")) {
				alfabeto.put(letra, cont);
				cont++;
			}
			;
			codificado = lectura.readLine().split(" ");
			try (BufferedReader lecturaCarta = new BufferedReader(new FileReader("src//ficheros//carta.txt"))) {
				try (BufferedWriter escrituraCifrada = new BufferedWriter(
						new FileWriter("src//ficheros//cifrado.txt"))) {
					linea = lecturaCarta.readLine();
					while (linea != null) {
						for (int i = 0; i < linea.length(); i++) {
							caracterActual = linea.charAt(i) + "";
							if (alfabeto.containsKey(caracterActual)) {
								escrituraCifrada.append(codificado[alfabeto.get(caracterActual)]);
							} else {
								escrituraCifrada.append(caracterActual);
							}
						}
						escrituraCifrada.newLine();
						linea = lecturaCarta.readLine();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
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
