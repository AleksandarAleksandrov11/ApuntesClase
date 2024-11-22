package preubas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SQL {
	private final String usuario = "root";
	private final String password = "linarespajero"; // Cambié 'pasword' por 'password'
	private final String url = "jdbc:mysql://localhost:3306/Pruebas";

	private Connection conectar() throws SQLException {
		try {
			// Asegúrate de que el conector JDBC de MySQL esté en tu classpath
			return DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos: " + e.getMessage());
			throw e; // Re-lanzar la excepción si no puedes conectarte
		}
	}

	public void meterPersona(List<Persona> personas) {
		resetearTabla("PERSONA");
		for (Persona persona : personas) {
			String query = "INSERT INTO Persona (CODIGO, NOMBRE, LIKINGS, FECHADENACIMIENTO) VALUES (?,?,?,?)";
			try (PreparedStatement parteDeLaQuery = conectar().prepareStatement(query)) {
				parteDeLaQuery.setInt(1, persona.getCodigo());
				parteDeLaQuery.setString(2, persona.getNombre());
				parteDeLaQuery.setString(3, persona.getLikings());
				Date sqlDate = new Date(persona.getFehcadenacimiento().getTime());
				parteDeLaQuery.setDate(4, sqlDate);

				parteDeLaQuery.executeUpdate();
				System.out.println("Persona metido con exito.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void meterPersonaChupi(List<PersonaChupi> personasChupi) {
		resetearTabla("PERSONASCHUPI");
		for (PersonaChupi persona : personasChupi) {
			String query = "INSERT INTO PERSONASCHUPI (CODIGO,LIKINGS) VALUES (?,?)";
			try (PreparedStatement parteDeLaQuery = conectar().prepareStatement(query)) {
				parteDeLaQuery.setInt(1, persona.getCodigo());
				parteDeLaQuery.setString(2, persona.getLikings());
				parteDeLaQuery.executeUpdate();
				System.out.println("PersonaChupi metido con exito.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void quitarPerosnaPorCodigo(int codigo) {
		String query = "DELETE FROM Persona WHERE CODIGO = (?)";

		try (PreparedStatement partedelaquery = conectar().prepareStatement(query)) {
			partedelaquery.setInt(1, codigo);
			partedelaquery.executeUpdate();
			System.out.println("persona elimianda exitosamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quitarPersonaPorLikings(String likings) {
		String query = "DELETE FROM Persona WHERE LIKINGS LIKE ?";

		try (PreparedStatement partedelaquery = conectar().prepareStatement(query)) {
			partedelaquery.setString(1, "%" + likings + "%");

			partedelaquery.executeUpdate();
			System.out.println("quitado la persona godly");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void chuparDatos() {
		String query = "SELECT CODIGO, NOMBRE, LIKINGS, FECHADENACIMIENTO FROM Persona";

		try (Statement partedelaquery = conectar().createStatement();
				ResultSet rs = partedelaquery.executeQuery(query)) {

			System.out.println("Estos son los datos");

			while (rs.next()) {
				int id = rs.getInt("CODIGO");
				String nombre = rs.getString("NOMBRE");
				String likings = rs.getString("LIKINGS");
				Date fechan = rs.getDate("FECHADENACIMIENTO");

				System.out.println(id + " " + nombre + " " + likings + " " + fechan);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarDatosEnAmbasTablas() {
		String actualizar = "UPDATE PERSONA SET LIKINGS = 'comer culos'";

		try (Statement query = conectar().createStatement()) {
			query.executeUpdate(actualizar);
			System.out.println("tabla actualizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualizarChupi = "UPDATE PERSONASCHUPI SET LIKINGS = 'comer culos'";

		try (Statement query = conectar().createStatement()) {
			query.executeUpdate(actualizarChupi);
			System.out.println("tabla actualizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void resetearTabla(String tabla) {
		String eliminar = "DELETE FROM " + tabla;
		try (Statement query = conectar().createStatement()) {
			// Ejecuta la consulta para crear la tabla en la base de datos
			query.execute(eliminar);
			System.out.println("Tabla eliminada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}