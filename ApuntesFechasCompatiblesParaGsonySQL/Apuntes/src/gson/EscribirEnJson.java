package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EscribirEnJson {
	public static void main(String[] args) {
		// Crear algunos miembros de equipo
		Miembro miembro1 = new Miembro("Juan", 30, "Desarrollador", true);
		Miembro miembro2 = new Miembro("Marta", 27, "Diseñadora", false);

		// Crear la empresa con datos
		Empresa empresa = new Empresa("Includify", 2021, Arrays.asList(miembro1, miembro2), true, null);

		// Crear un objeto Gson para convertir el objeto a JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Convertir el objeto Java a JSON y escribirlo en un archivo
		try (FileWriter writer = new FileWriter("empresa.json")) {
			gson.toJson(empresa, writer);
			System.out.println("Archivo JSON creado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
