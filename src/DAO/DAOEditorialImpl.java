package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Editorial;

public class DAOEditorialImpl implements DAOEditorial {
	
	private DataSourceImpl ds;
	private ArrayList<Editorial> editoriales;
	
	public DAOEditorialImpl() {

		ds = new DataSourceImpl();
		editoriales = new ArrayList<>();
		
	}
	
	
	public ArrayList<Editorial> listarEditoriales() {
		
		ResultSet rs;
		Statement st = null;
		String sentencia;
		
		sentencia = "SELECT id_editorial, nombre FROM editorial";
		
		rs = (ResultSet) ds.ejecutarConsulta(sentencia);
		
		try {
			
			while ( rs.next() ) {
				
				editoriales.add( new Editorial( rs.getInt(1), rs.getString(2) ) );
				
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return editoriales;
		
	}


	@Override
	public int registrarEditorial(Editorial editorial) {

		int id = 0, idPersona = 0, valor = 0;
		String registro = null;
		
		// ----------------------------------
		
		registro = "INSERT INTO editorial ( nombre ) " +
		" VALUES ( '" + editorial.getNombre() + "';";
		
		//ds = new DataSourceImpl();
		valor = this.ds.ejecutarActualizacion(registro);
		
		return valor;
		
	}


	@Override
	public Editorial buscarEditorial(Integer idEditorial) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("SELECT id_editorial, nombre "
				+ "FROM editorial WHERE id_editorial = " + idEditorial );
		
		Editorial nuevaEditorial = new Editorial();
		
		try {
			
			while( rs.next() ) {
				
				nuevaEditorial.setIdEditorial( rs.getInt(1) );
				nuevaEditorial.setNombre( rs.getString(2) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevaEditorial;
		
	}


	@Override
	public Editorial buscarEditorial(String nombre) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("SELECT id_editorial, nombre "
				+ "FROM editorial WHERE nombre = '" + nombre + "'; " );
		
		Editorial nuevaEditorial = new Editorial();
		
		try {
			
			while( rs.next() ) {
				
				nuevaEditorial.setIdEditorial( rs.getInt(1) );
				nuevaEditorial.setNombre( rs.getString(2) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevaEditorial;
		
	}


	@Override
	public int editarEditorial(Integer idEditorial, Editorial editorial) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("SELECT * FROM editorial WHERE id_editorial = " + 
		idEditorial );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE editorial SET " 
				+ " nombre = '" + editorial.getNombre()
				+ "' WHERE id_editorial = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}


	@Override
	public int editarEditorial(String nombre, Editorial editorial) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("SELECT * FROM editorial WHERE nombre = '" + 
		nombre + "'; " );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE editorial SET " 
				+ " nombre = '" + editorial.getNombre()
				+ "' WHERE id_editorial = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}


	@Override
	public int eliminarEditorial(Integer idEditorial) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM editorial WHERE id_editorial = " + idEditorial + ";";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}


	@Override
	public int eliminarEditorial(String nombre) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM editorial WHERE nombre = '" + nombre + "';";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}
	
	
	public Object[] editorialestoArray() {
		
		ResultSet rs;
		Statement st = null;
		String sentencia;
		Object[] array = null;
		
		sentencia = "SELECT nombre FROM editorial ORDER BY nombre ASC";
		
		rs = (ResultSet) ds.ejecutarConsulta(sentencia);
		
		try {
			
			while ( rs.next() ) {
				
				editoriales.add( new Editorial( rs.getInt(1), rs.getString(2) ) );
				
			}
			
			array = new Object[ editoriales.size() ];
			
			for (int i = 0; i < array.length; i++) {
				
				array[i] = editoriales.get(i);
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return array;
		
	}
	
	

}
