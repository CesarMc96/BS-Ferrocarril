package DAO;

public interface DataSource {
	
	//SELECT ...
	
	public Object ejecutarConsulta( String conulta );
	
	// INSERT, UPDATE, DELETE ...
	
	public int ejecutarActualizacion( String consulta );

}
