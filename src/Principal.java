import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {
		
		ManejadorBBDD.establecerConexion();
		//ManejadorBBDD.crearTablaLibro();
		//ManejadorBBDD.insertarDatosLibrosS();
		//ManejadorBBDD.imprimirLibros();
		//ManejadorBBDD.borrarTablaLibro();
		ManejadorBBDD.cerrarConexion();

	}

}
