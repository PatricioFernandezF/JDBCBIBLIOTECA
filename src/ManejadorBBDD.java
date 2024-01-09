import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ManejadorBBDD {
	
	final static String DB_URL = "jdbc:mysql://localhost/biblioteca";
	final static String USER = "root";
	final static String PASS = "";

	static Connection con;

	public static void establecerConexion() {
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se puede establecer conexión");
		}

	}
	
	public static void crearTablaLibro() throws SQLException {

		Statement stmt = con.createStatement();

		String sql = "CREATE TABLE LIBRO " + "(id INTEGER not NULL AUTO_INCREMENT, " + " nombre VARCHAR(255),  PRIMARY KEY ( id ))";

		stmt.executeUpdate(sql);
		System.out.println("Tabla creada");

	}
	
	
	
	public static void cerrarConexion() {
		
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void imprimirLibros() throws SQLException {
		
		System.out.println("El listado:");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Libro");
     
        while (rs.next()) {
           System.out.print("ID: " + rs.getInt("id"));
           //System.out.print(", Edad: " + rs.getInt("edad"));
           System.out.println(", Nombre: " + rs.getString("nombre"));
           //System.out.println(", Apellidos: " + rs.getString("apellidos"));
        }
}
	
	public static void borrarTablaLibro() throws SQLException {

		Statement stmt = con.createStatement();

		String sql = "DROP TABLE LIBRO";

		stmt.executeUpdate(sql);
		System.out.println("Tabla borrada");

	}
	
	
	public static void insertarDatosLibrosP() throws SQLException {
		
		for (int i = 0; i < libros.length; i++) {
			String sql = "INSERT INTO LIBRO (nombre) VALUES (?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,libros[i]);
			preparedStatement.executeUpdate();

		}
		
		System.out.println("Datos insertados");
		
	}
	
	
	public static void insertarDatosLibrosS() throws SQLException {
		
		for (int i = 0; i < libros.length; i++) {
			String sql = "INSERT INTO LIBRO (nombre) VALUES ('"+libros[i]+"')";
			Statement statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);

		}
		
		System.out.println("Datos insertados");
		
	}
	
	
	final static String[] libros = {
		    "Cien años de soledad",
		    "El Gran Gatsby",
		    "1984",
		    "Matar un ruiseñor",
		    "El Señor de los Anillos",
		    "El Hobbit",
		    "Orgullo y prejuicio",
		    "En busca del tiempo perdido",
		    "Don Quijote de la Mancha",
		    "Moby Dick",
		    "Ulises",
		    "Crimen y castigo",
		    "Los juegos del hambre",
		    "Harry Potter y la piedra filosofal",
		    "Las aventuras de Sherlock Holmes",
		    "El Alquimista",
		    "El nombre del viento",
		    "El corazón de las tinieblas",
		    "Drácula",
		    "Las uvas de la ira",
		    "La Odisea",
		    "La Ilíada",
		    "Los miserables",
		    "Crimen en el expreso de Oriente",
		    "La sombra del viento",
		    "El retrato de Dorian Gray",
		    "Los hombres me explican cosas",
		    "El código Da Vinci",
		    "Los hombres que no amaban a las mujeres",
		    "Las ventajas de ser invisible",
		    "La chica del tren",
		    "Los pilares de la Tierra",
		    "Los hombres son de Marte, las mujeres de Venus",
		    "Los hombres me explican cosas",
		    "La naranja mecánica",
		    "El lobo estepario",
		    "El arte de la guerra",
		    "1984",
		    "Los juegos del hambre",
		    "El principito",
		    "El señor de las moscas",
		    "La carretera",
		    "Matar a un ruiseñor",
		    "Cincuenta sombras de Grey",
		    "El guardián entre el centeno",
		    "La chica del tren",
		    "La insoportable levedad del ser",
		    "Mujer en punto cero",
		    "El cuaderno de Maya",
		    "Un mundo feliz",
		    "Fahrenheit 451",
		    "Los hombres me explican cosas",
		    "Los hombres son de Marte, las mujeres de Venus",
		    "El código Da Vinci",
		    "Harry Potter y la piedra filosofal",
		    "El nombre del viento",
		    "Las crónicas de Narnia",
		    "Los juegos del hambre",
		    "El retrato de Dorian Gray",
		    "Drácula",
		    "Crimen y castigo",
		    "La sombra del viento",
		    "El guardián entre el centeno",
		    "Cien años de soledad",
		    "El amor en los tiempos del cólera",
		    "Crónica de una muerte anunciada",
		    "Rayuela",
		    "Pedro Páramo",
		    "Los detectives salvajes",
		    "Ficciones",
		    "Ray Bradbury",
		    "La carretera",
		    "Sapiens: De animales a dioses",
		    "Homo Deus",
		    "El arte de amar",
		    "El ser y la nada",
		    "Así habló Zaratustra",
		    "La interpretación de los sueños",
		    "Psicología de la mentira",
		    "El origen de las especies",
		    "El mundo de Sofía",
		    "El viaje a la alquimia",
		    "Los diarios de Adán y Eva",
		    "El jardín secreto",
		    "La ladrona de libros",
		    "Los tres mosqueteros",
		    "Don Quijote de la Mancha",
		    "La Odisea",
		    "La Ilíada",
		    "Robinson Crusoe",
		    "Moby Dick",
		    "La isla del tesoro",
		    "Los miserables",
		    "Crimen en el expreso de Oriente",
		    "Crimen y castigo",
		    "El retrato de Dorian Gray",
		    "El Gran Gatsby",
		    "La naranja mecánica",
		    "El lobo estepario",
		    "El principito",
		    "El señor de las moscas",
		    "El guardian entre el centeno",
		    "La carretera",
		    "Matar a un ruiseñor",
		    "Las aventuras de Sherlock Holmes",
		    "La sombra del viento",
		    "El Alquimista",
		    "El nombre del viento",
		    "Los juegos del hambre",
		    "Harry Potter y la piedra filosofal",
		    "Las uvas de la ira",
		    "La Odisea",
		    "La Ilíada",
		    "Los miserables",
		    "Crimen en el expreso de Oriente",
		    "La sombra del viento",
		    "El retrato de Dorian Gray"
		};


}
