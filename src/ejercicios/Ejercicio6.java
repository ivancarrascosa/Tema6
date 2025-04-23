package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio6 {

	public static void main(String[] args) {
		ArrayList<Integer> listaNumeros = new ArrayList<>();
		lecturaArchivo(listaNumeros);
		escrituraNumerosOrdenados(listaNumeros);

	}

	public static void escrituraNumerosOrdenados(ArrayList<Integer> listaNumeros) {
		try(BufferedWriter escritura = new BufferedWriter(new FileWriter("src//ficheros//numerosOrdenados.txt"))) {
			for(int numeroLista : listaNumeros) {
				escritura.write(String.valueOf(numeroLista));
				escritura.newLine();
			}
			escritura.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void lecturaArchivo(ArrayList<Integer> listaNumeros) {
		String numero;
		try(BufferedReader lectura = new BufferedReader(new FileReader("src//ficheros//EnterosEjercicio6"))) {
			numero = lectura.readLine();
			while(numero != null) {
				listaNumeros.add(Integer.parseInt(numero));
				numero = lectura.readLine();
			}
			listaNumeros.sort((a,b) -> a-b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
