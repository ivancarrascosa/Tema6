package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio7 {

	public static void main(String[] args) {
		TreeMap<String, Integer> agendaTelefono = new TreeMap<>();

		int opc;

		String nombre;

		int telefono;
		Scanner reader = new Scanner(System.in);
		
		cargarAgendaDesdeTxt(agendaTelefono);
		
		mostrarMenu();
		opc = reader.nextInt();
		reader.nextLine();
		while (opc != 4) {
			if (opc == 1) {
				System.out.println("Introduzca el nombre de la persona que quiere añadir en la agenda.");
				nombre = reader.nextLine();
				System.out.println("Introduzca su numero de teléfono");
				telefono = reader.nextInt();
				reader.nextLine();
				if (agendaTelefono.size() == 20) {
					System.out.println("La agenda ya está llena, tiene 20 contactos.");
				} else if (agendaTelefono.containsKey(nombre)) {
					System.out.println("Ese nombre ya está incluido en la agenda, no se ha podido añadir");
				} else {
					agendaTelefono.put(nombre, telefono);
					System.out.println("Contacto añadido correctamente.");
				}
			} else if (opc == 2) {
				System.out.println("Introduzca el nombre que desea buscar:");
				nombre = reader.nextLine();
				Integer telefonoBuscar = agendaTelefono.get(nombre);
				if (telefonoBuscar != null) {
					System.out.println(telefonoBuscar);
				} else {
					System.out.println("Nombre no encontrado.");
				}
			} else if (opc == 3) {
				for (Map.Entry<String, Integer> contacto : agendaTelefono.entrySet()) {
					System.out.println(contacto.getKey() + ": " + contacto.getValue());
				}
			} else {
				System.out.println("Opción no válida.");
			}
			mostrarMenu();
			opc = reader.nextInt();
			reader.nextLine();
		}
		guardarMapEnTxt(agendaTelefono);
		reader.close();
	}

	public static void guardarMapEnTxt(TreeMap<String, Integer> agendaTelefono) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//ficheros//AgendaTelefonica.txt"))) {
			for (Map.Entry<String, Integer> contacto : agendaTelefono.entrySet()) {
				writer.write(contacto.getKey() + ": " + contacto.getValue());
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cargarAgendaDesdeTxt(TreeMap<String, Integer> agendaTelefono) {
		String linea;
		String[] nombreTelefono;
		try(BufferedReader lectura = new BufferedReader(new FileReader("src//ficheros//AgendaTelefonica.txt"))) {
			linea = lectura.readLine();
			while(linea != null) {
				nombreTelefono = linea.split(": ");
				agendaTelefono.put(nombreTelefono[0], Integer.parseInt(nombreTelefono[1]));
				linea = lectura.readLine();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	static void mostrarMenu() {
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir.");
	}
}
