package DAO;

public class Test {

	public static void main(String[] args) {
		
		DataSourceImpl ds = new DataSourceImpl();
		ds.iniciarConexion();
		
		ds.cerrarConexion();
		
	}
	
}
