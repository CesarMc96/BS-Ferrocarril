package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {
	
	private DataSourceImpl ds;
	private ArrayList<Usuario> usuarios;
	
	public DAOUsuarioImpl() {
		
		ds = new DataSourceImpl();
		usuarios = new ArrayList<>();
		
	}
	
	public ArrayList<Usuario> listarUsuarios() {
		
		ResultSet rs;
		Statement st = null;
		String sentencia;
		
		sentencia = "SELECT nombre, ap_paterno, ap_materno, num_credencial,"
				+ " direccion, telefono, correo, fecha_alta  FROM usuario";
		
		rs = (ResultSet) ds.ejecutarConsulta(sentencia);
		
		try {
			
			while ( rs.next() ) {
				
				usuarios.add( new Usuario( rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getDate(8) ) );
				
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return usuarios;
		
	}

	@Override
	public int registrarUsuario(Usuario usuario) {

		int id = 0, idPersona = 0, valor = 0;
		String registro = null;
		this.ds.iniciarConexion();
		
		// ----------------------------------
		
		registro = "INSERT INTO usuario ( nombre, ap_paterno, ap_materno, num_credencial, "
				+ "direccion, telefono, correo, fecha_alta ) " +
		" VALUES ( '" + usuario.getNombre() + "', '" +
		usuario.getApPaterno() + "', '" +
		usuario.getApMaterno() + "', '" +
		usuario.getNumCredencial() + "', '" +
		usuario.getDireccion() + "', '" +
		usuario.getTelefono() + "', '" +
		usuario.getCorreo() + "', '" +
		usuario.getFechaAlta() + "' ); ";
		
		//ds = new DataSourceImpl();
		valor = this.ds.ejecutarActualizacion(registro);
		
		return valor;
		
	}

	@Override
	public Usuario buscarUsuario(String numCredencial) {

		this.ds.iniciarConexion();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta("SELECT  nombre, ap_paterno, ap_materno, num_credencial, " +
		"direccion, telefono, correo, fecha_alta FROM usuario WHERE num_credencial = '" + numCredencial + "'" );
		
		Usuario nuevoUsuario = new Usuario();
		
		try {
			
			while( rs.next() ) {
				
				nuevoUsuario.setNombre( rs.getString(1) );
				nuevoUsuario.setApPaterno( rs.getString(2) );
				nuevoUsuario.setApMaterno( rs.getString(3) );
				nuevoUsuario.setNumCredencial( rs.getString(4) );
				nuevoUsuario.setDireccion( rs.getString(5) );
				nuevoUsuario.setTelefono( rs.getString(6) );
				nuevoUsuario.setCorreo( rs.getString(7) );
				nuevoUsuario.setFechaAlta( rs.getDate(8) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoUsuario;
		
	}

	@Override
	public Usuario buscarUsuario(String nombre, String apPaterno) {

		this.ds.iniciarConexion();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta("SELECT  nombre, ap_paterno, ap_materno, num_credencial, " +
		"direccion, telefono, correo, fecha_alta FROM usuario WHERE nombre = '" + nombre + "' AND ap_paterno = '" + apPaterno + "'" );
		
		Usuario nuevoUsuario = new Usuario();
		
		try {
			
			while( rs.next() ) {
				
				nuevoUsuario.setNombre( rs.getString(1) );
				nuevoUsuario.setApPaterno( rs.getString(2) );
				nuevoUsuario.setApMaterno( rs.getString(3) );
				nuevoUsuario.setNumCredencial( rs.getString(4) );
				nuevoUsuario.setDireccion( rs.getString(5) );
				nuevoUsuario.setTelefono( rs.getString(6) );
				nuevoUsuario.setCorreo( rs.getString(7) );
				nuevoUsuario.setFechaAlta( rs.getDate(8) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoUsuario;
		
	}

	@Override
	public int editarUsuario(String numCredencial, Usuario usuario) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("SELECT * FROM usuario WHERE num_credencial = '" + 
		numCredencial + "'" );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE usuario SET " 
				+ " nombre = '" + usuario.getNombre()
				+ "', ap_paterno = '" + usuario.getApPaterno()
				+ "', ap_materno = '" + usuario.getApMaterno()
				+ "', num_credencial = '" + usuario.getNumCredencial()
				+ "', direccion = '" + usuario.getDireccion()
				+ "', telefono = '" + usuario.getTelefono()
				+ "', correo = '" + usuario.getCorreo()
				+ "', fecha_alta = '" + usuario.getFechaAlta()
				+ "' WHERE id_usuario = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}

	@Override
	public int editarUsuario(String nombre, String apPaterno, Usuario usuario) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("SELECT * FROM usuario WHERE nombre = '" + 
		nombre + "'" + " AND ap_paterno = '" + apPaterno + "'" );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE usuario SET " 
				+ " nombre = '" + usuario.getNombre()
				+ "', ap_paterno = '" + usuario.getApPaterno()
				+ "', ap_materno = '" + usuario.getApMaterno()
				+ "', num_credencial = '" + usuario.getNumCredencial()
				+ "', direccion = '" + usuario.getDireccion()
				+ "', telefono = '" + usuario.getTelefono()
				+ "', correo = '" + usuario.getCorreo()
				+ "', fecha_alta = '" + usuario.getFechaAlta()
				+ "' WHERE id_autor = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}

	@Override
	public int eliminarUsuario(String numCredencial) {

		int valor = 0, id = 0;
		//this.ds.iniciarConexion();
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM usuario WHERE num_credencial = '" + numCredencial + 
				"' ";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarUsuario(String nombre, String apPaterno) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM usuario WHERE nombre = '" + nombre + 
				"' AND ap_paterno = '" + apPaterno + "' ";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}
	
	

	public DataSourceImpl getDs() {
		return ds;
	}

	public void setDs(DataSourceImpl ds) {
		this.ds = ds;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	

}
