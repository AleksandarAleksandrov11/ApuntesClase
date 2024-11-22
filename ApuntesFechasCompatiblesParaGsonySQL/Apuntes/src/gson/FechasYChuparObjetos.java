package gson;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FechasYChuparObjetos {
	private static List<MiausMiaus> lista = new ArrayList<>();

	public static void main(String[] args) {
		// Crear fecha usando el constructor correcto
		try {
			Date date  = new SimpleDateFormat("yyyy-MM-dd").parse("2001-02-01");

			// Agregar elementos a la lista
			for (int i = 0; i < 5; i++) {
				lista.add(new MiausMiaus("shacki", "los porros", date, i));
			}

			// Configurar Gson con formato de fecha personalizado
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd").create();

			// Serializar a archivo JSON
			try (FileWriter fw = new FileWriter("datos.json")) {
				gson.toJson(lista, fw);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Deserializar desde JSON
			String json = gson.toJson(lista);
			List<MiausMiaus> deserializedList = gson.fromJson(json, new TypeToken<List<MiausMiaus>>() {}.getType());

			// Imprimir resultados deserializados
			for (MiausMiaus miausMiaus : deserializedList) {
				System.out.println(miausMiaus.toString());
				Date lele = miausMiaus.getFechadenacimiento();
				System.out.println(lele);
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}