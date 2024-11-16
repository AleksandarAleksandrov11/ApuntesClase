import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Gg {
	
	public void writeAlumnos(List<Alumno> alumnos, String file) {
		JSONArray array = new JSONArray();
		for (Alumno alumno : alumnos) {
			JSONObject datos = new JSONObject();
			datos.put("nia", alumno.getNia());
			datos.put("nombre", alumno.getNombre());
			datos.put("apellido", alumno.getApellidos());
			datos.put("genero", alumno.getGenero());
			datos.put("nacimiento", alumno.convertirFecha(alumno.getNacimiento()));
			datos.put("ciclo", alumno.getCiclo());
			datos.put("curso", alumno.getCurso());
			datos.put("grupo", alumno.getGrupo());
			array.add(datos);
		}
		jsonToFile(array.toJSONString(), file);
	}
	
	private void jsonToFile(String json, String file) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write(json);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readJsonAlumnos(String file) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("d-M-yyyy");
		try {
			List<JSONObject> array = (List<JSONObject>) (new JSONParser().parse(new FileReader(file)));
			for (JSONObject a : array) {
				System.out.println(new Alumno(
						Integer.parseInt(a.get("nia").toString()),
						(String) a.get("nombre"),
						(String) a.get("apellido"),
						(a.get("genero").toString()).charAt(0),
						LocalDate.parse((String)a.get("nacimiento"), formato),
						(String)a.get("ciclo"),
						(String)a.get("curso"),
						(String)a.get("grupo")
						).toString());
				System.out.println("---------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
