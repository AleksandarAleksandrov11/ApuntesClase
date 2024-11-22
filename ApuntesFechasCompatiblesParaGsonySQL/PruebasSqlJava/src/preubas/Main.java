package preubas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Persona> personas = new ArrayList<Persona>();
	private static List<PersonaChupi> personasChupi = new ArrayList<PersonaChupi>();
	private static Scanner abielto = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			System.out.println("dame la fecha");
			Date date;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(abielto.nextLine());
				personas.add(new Persona(i, "Mohamed sumbul", "explotar", date));
				personasChupi.add(new PersonaChupi(i, "explotar"));

			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		SQL sql = new SQL();
		
		sql.meterPersonaChupi(personasChupi);
		sql.meterPersona(personas);
		sql.modificarDatosEnAmbasTablas();

//		sql.quitarPerosnaPorCodigo(0);
//		sql.quitarPersonaPorLikings("exp");
		sql.chuparDatos();

	}

}
