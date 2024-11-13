package apuntes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    
    // URL de conexión JDBC a la base de datos MySQL en localhost con el puerto predeterminado y la base de datos "mi_base_de_datos"
    private static final String URL = "jdbc:mysql://localhost:3306/miau";

    // Nombre de usuario para acceder a la base de datos
    private static final String USER = "usuario";
    
    // Contraseña del usuario para acceder a la base de datos
    private static final String PASSWORD = "contraseña";
    /**
     * Método para establecer la conexión a la base de datos.
     * 
     * @return Connection - objeto Connection para la conexión a la base de datos
     * @throws SQLException si ocurre algún error en la conexión
     */
    private static Connection connect() throws SQLException {
        // Se establece la conexión a la base de datos utilizando DriverManager
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Método para crear una tabla en la base de datos.
     * 
     * @param conn - Objeto Connection que representa la conexión a la base de datos
     * @throws SQLException si ocurre algún error durante la creación de la tabla
     */
    private static void createTable(Connection conn) throws SQLException {
        // Consulta SQL para crear una tabla llamada "usuarios" con columnas de id, nombre y correo
        String createTableSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
                              + "id INT AUTO_INCREMENT PRIMARY KEY, "
                              + "nombre VARCHAR(45), "
                              + "correo VARCHAR(69))";

        // Se utiliza un Statement para ejecutar la consulta de creación de tabla
        try (Statement stmt = conn.createStatement()) {
            // Ejecuta la consulta para crear la tabla en la base de datos
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'usuarios' creada o ya existente.");
        }
    }

    /**
     * Método para insertar datos en la tabla "usuarios".
     * 
     * @param conn - Objeto Connection para la conexión
     * @param nombre - Nombre del usuario que se va a insertar
     * @param correo - Correo electrónico del usuario que se va a insertar
     * @throws SQLException si ocurre algún error durante la inserción de datos
     */
    private static void insertData(Connection conn, String nombre, String correo) throws SQLException {
        // Consulta SQL para insertar datos en la tabla "usuarios" con valores de nombre y correo
        String insertSQL = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";

        // Utiliza PreparedStatement para prevenir inyecciones SQL y gestionar parámetros dinámicos
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            // Se establece el valor del primer parámetro en el PreparedStatement (nombre)
            pstmt.setString(1, nombre);
            
            // Se establece el valor del segundo parámetro en el PreparedStatement (correo)
            pstmt.setString(2, correo);
            
            // Ejecuta la inserción y obtiene el número de filas afectadas
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " fila(s) insertada(s) en la tabla 'usuarios'.");
        }
    }

    /**
     * Método para leer y mostrar los datos de la tabla "usuarios".
     * 
     * @param conn - Objeto Connection que representa la conexión a la base de datos
     * @throws SQLException si ocurre algún error durante la lectura de datos
     */
    private static void readData(Connection conn) throws SQLException {
        // Consulta SQL para seleccionar todos los datos de la tabla "usuarios"
        String selectSQL = "SELECT * FROM usuarios";

        // Se usa Statement para ejecutar la consulta de selección
        try (Statement stmt = conn.createStatement();
             // ResultSet contiene los datos obtenidos de la consulta
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("Datos en la tabla 'usuarios':");

            // Itera sobre el ResultSet para leer y mostrar cada fila de resultados
            while (rs.next()) {
                // Obtiene el valor de la columna "id" como entero
                int id = rs.getInt("id");
                
                // Obtiene el valor de la columna "nombre" como cadena de texto
                String nombre = rs.getString("nombre");
                
                // Obtiene el valor de la columna "correo" como cadena de texto
                String correo = rs.getString("correo");
                
                // Muestra los datos de la fila actual en la consola
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Correo: " + correo);
            }
        }
    }
    
    public static void main(String[] args) {
        // Conexión a la base de datos y ejecución de operaciones SQL
        try (Connection conn = connect()) {
            if (conn != null) {
                // Llama al método para crear una tabla
                createTable(conn);
                
                // Llama al método para insertar datos en la tabla
                insertData(conn, "Juan Perez", "juan.perez@example.com");
                insertData(conn, "Ana López", "ana.lopez@example.com");

                // Llama al método para leer y mostrar datos de la tabla
                readData(conn);
            }
        } catch (SQLException e) {
            // Manejo de excepciones SQL en caso de que haya errores de conexión o ejecución
            e.printStackTrace();
        }
    }
}
