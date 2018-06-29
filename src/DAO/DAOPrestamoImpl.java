package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Prestamo;

public class DAOPrestamoImpl implements DAOPrestamo {
	
	private DataSourceImpl ds;
	private ArrayList<Prestamo> prestamos;
	
	public DAOPrestamoImpl() {

		ds = new DataSourceImpl();
		prestamos = new ArrayList<>();
		
	}
	
	public ArrayList<Prestamo> listarPrestamo() {
		
		ResultSet rs;
		Statement st = null;
		String sentencia;
		
		sentencia = "Select t1.id_prestamo, t1.fecha_prestamo, t1.fecha_devolucion, t1.num_renovacion, t2.nombre, t2.ap_paterno, " +
		"t2.ap_materno, t2.num_credencial, t3.titulo, t4.nombre, t4.apellidos, t5.nombre, t6.descripcion, t1.observaciones " +
		"From prestamo t1 inner join usuario t2 on usuario_id = id_usuario inner join libro t3 on libro_id = id_libro " +
		"inner join autor t4 on autor_id = id_autor inner join editorial t5 on editorial_id = id_editorial " + 
		"inner join acciones t6 on accion_id = id_acciones";
		
		rs = (ResultSet) ds.ejecutarConsulta(sentencia);
		
		try {
			
			while ( rs.next() ) {
				
				prestamos.add( new Prestamo(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(9), rs.getString(10) + 
						" " + rs.getString(11), rs.getString(12), rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7), 
						rs.getString(8), rs.getString(14), rs.getString(13) ) );
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return prestamos;
		
	}

	@Override
	public int registrarPrestamo(Prestamo prestamo) {
		
		return 0;
		
	}

	@Override
	public Prestamo buscarPrestamo(Integer numeroPrestamo) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_prestamo, t1.fecha_prestamo, t1.fecha_devolucion, " + 
		" t1.num_renovacion, t2.nombre, t2.ap_paterno, t2.ap_materno, t2.num_credencial, t3.titulo, t4.nombre, t4.apellidos, " +
		"t5.nombre, t6.descripcion, t1.observaciones From prestamo t1 inner join usuario t2 on usuario_id = id_usuario " +
		"inner join libro t3 on libro_id = id_libro inner join autor t4 on autor_id = id_autor inner join " +
		"editorial t5 on editorial_id = id_editorial inner join acciones t6 on accion_id = id_acciones WHERE " +
		"t1.id_prestamo = "+ numeroPrestamo );
		
		Prestamo nuevoPrestamo = new Prestamo();
		
		try {
			
			while( rs.next() ) {
				
				nuevoPrestamo.setIdPrestamo( rs.getInt(1) );
				nuevoPrestamo.setFechaPrestamo( rs.getDate(2) );
				nuevoPrestamo.setFechaDevolucion( rs.getDate(3) );
				nuevoPrestamo.setNumeroRenovacion( rs.getInt(4) );
				nuevoPrestamo.setNombreUsuario( rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) );
				nuevoPrestamo.setNumCredencial( rs.getString(8) );
				nuevoPrestamo.setTitulo( rs.getString(9) );
				nuevoPrestamo.setAutor( rs.getString(10) + " " + rs.getString(11) );
				nuevoPrestamo.setEditorial( rs.getString(12) );
				nuevoPrestamo.setAccion( rs.getString(13) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoPrestamo;
		
	}

	@Override
	public Prestamo buscarPrestamoUsuario(Integer numUsuario) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_prestamo, t1.fecha_prestamo, t1.fecha_devolucion, " + 
		" t1.num_renovacion, t2.nombre, t2.ap_paterno, t2.ap_materno, t2.num_credencial, t3.titulo, t4.nombre, t4.apellidos, " +
		"t5.nombre, t6.descripcion, t1.observaciones From prestamo t1 inner join usuario t2 on usuario_id = id_usuario " +
		"inner join libro t3 on libro_id = id_libro inner join autor t4 on autor_id = id_autor inner join " +
		"editorial t5 on editorial_id = id_editorial inner join acciones t6 on accion_id = id_acciones WHERE " +
		"t1.usuario_id = " + numUsuario );
		
		Prestamo nuevoPrestamo = new Prestamo();
		
		try {
			
			while( rs.next() ) {
				
				nuevoPrestamo.setIdPrestamo( rs.getInt(1) );
				nuevoPrestamo.setFechaPrestamo( rs.getDate(2) );
				nuevoPrestamo.setFechaDevolucion( rs.getDate(3) );
				nuevoPrestamo.setNumeroRenovacion( rs.getInt(4) );
				nuevoPrestamo.setNombreUsuario( rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) );
				nuevoPrestamo.setNumCredencial( rs.getString(8) );
				nuevoPrestamo.setTitulo( rs.getString(9) );
				nuevoPrestamo.setAutor( rs.getString(10) + " " + rs.getString(11) );
				nuevoPrestamo.setEditorial( rs.getString(12) );
				nuevoPrestamo.setAccion( rs.getString(13) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoPrestamo;
		
	}

	@Override
	public Prestamo buscarPrestamoLibro(String titulo) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_prestamo, t1.fecha_prestamo, t1.fecha_devolucion, " + 
		" t1.num_renovacion, t2.nombre, t2.ap_paterno, t2.ap_materno, t2.num_credencial, t3.titulo, t4.nombre, t4.apellidos, " +
		"t5.nombre, t6.descripcion, t1.observaciones From prestamo t1 inner join usuario t2 on usuario_id = id_usuario " +
		"inner join libro t3 on libro_id = id_libro inner join autor t4 on autor_id = id_autor inner join " +
		"editorial t5 on editorial_id = id_editorial inner join acciones t6 on accion_id = id_acciones WHERE " +
		"t3.titulo = '"+ titulo + "'" );
		
		Prestamo nuevoPrestamo = new Prestamo();
		
		try {
			
			while( rs.next() ) {
				
				nuevoPrestamo.setIdPrestamo( rs.getInt(1) );
				nuevoPrestamo.setFechaPrestamo( rs.getDate(2) );
				nuevoPrestamo.setFechaDevolucion( rs.getDate(3) );
				nuevoPrestamo.setNumeroRenovacion( rs.getInt(4) );
				nuevoPrestamo.setNombreUsuario( rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) );
				nuevoPrestamo.setNumCredencial( rs.getString(8) );
				nuevoPrestamo.setTitulo( rs.getString(9) );
				nuevoPrestamo.setAutor( rs.getString(10) + " " + rs.getString(11) );
				nuevoPrestamo.setEditorial( rs.getString(12) );
				nuevoPrestamo.setAccion( rs.getString(13) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoPrestamo;
		
	}

	@Override
	public Prestamo buscarPrestamoPorLibro(String folio) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_prestamo, t1.fecha_prestamo, t1.fecha_devolucion, " + 
		" t1.num_renovacion, t2.nombre, t2.ap_paterno, t2.ap_materno, t2.num_credencial, t3.titulo, t4.nombre, t4.apellidos, " +
		"t5.nombre, t6.descripcion, t1.observaciones From prestamo t1 inner join usuario t2 on usuario_id = id_usuario " +
		"inner join libro t3 on libro_id = id_libro inner join autor t4 on autor_id = id_autor inner join " +
		"editorial t5 on editorial_id = id_editorial inner join acciones t6 on accion_id = id_acciones WHERE " +
		"t3.folio = '"+ folio + "'" );
		
		Prestamo nuevoPrestamo = new Prestamo();
		
		try {
			
			while( rs.next() ) {
				
				nuevoPrestamo.setIdPrestamo( rs.getInt(1) );
				nuevoPrestamo.setFechaPrestamo( rs.getDate(2) );
				nuevoPrestamo.setFechaDevolucion( rs.getDate(3) );
				nuevoPrestamo.setNumeroRenovacion( rs.getInt(4) );
				nuevoPrestamo.setNombreUsuario( rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) );
				nuevoPrestamo.setNumCredencial( rs.getString(8) );
				nuevoPrestamo.setTitulo( rs.getString(9) );
				nuevoPrestamo.setAutor( rs.getString(10) + " " + rs.getString(11) );
				nuevoPrestamo.setEditorial( rs.getString(12) );
				nuevoPrestamo.setAccion( rs.getString(13) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoPrestamo;
		
	}

	@Override
	public Prestamo buscarPrestamoPorLibro(Integer numLibro) {

		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_prestamo, t1.fecha_prestamo, t1.fecha_devolucion, " + 
		" t1.num_renovacion, t2.nombre, t2.ap_paterno, t2.ap_materno, t2.num_credencial, t3.titulo, t4.nombre, t4.apellidos, " +
		"t5.nombre, t6.descripcion, t1.observaciones From prestamo t1 inner join usuario t2 on usuario_id = id_usuario " +
		"inner join libro t3 on libro_id = id_libro inner join autor t4 on autor_id = id_autor inner join " +
		"editorial t5 on editorial_id = id_editorial inner join acciones t6 on accion_id = id_acciones WHERE " +
		"t3.id_libro = "+ numLibro );
		
		Prestamo nuevoPrestamo = new Prestamo();
		
		try {
			
			while( rs.next() ) {
				
				nuevoPrestamo.setIdPrestamo( rs.getInt(1) );
				nuevoPrestamo.setFechaPrestamo( rs.getDate(2) );
				nuevoPrestamo.setFechaDevolucion( rs.getDate(3) );
				nuevoPrestamo.setNumeroRenovacion( rs.getInt(4) );
				nuevoPrestamo.setNombreUsuario( rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) );
				nuevoPrestamo.setNumCredencial( rs.getString(8) );
				nuevoPrestamo.setTitulo( rs.getString(9) );
				nuevoPrestamo.setAutor( rs.getString(10) + " " + rs.getString(11) );
				nuevoPrestamo.setEditorial( rs.getString(12) );
				nuevoPrestamo.setAccion( rs.getString(13) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoPrestamo;
		
	}

	@Override
	public int editarPrestamo(Integer numeroPrestamo, Prestamo prestamo) {

		return 0;
		
	}

	@Override
	public int editarPrestamoUsuario(Integer numUsuario, Prestamo prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarPrestamoNumPrestamo(String titulo, Prestamo prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarPrestamoNumUsuario(String folio, Prestamo prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editarPrestamoTitulo(Integer numLibro, Prestamo prestamo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarPrestamoNumPrestamo(Integer numeroPrestamo) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM prestamo WHERE id_prestamo = " + numeroPrestamo + ";";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarPrestamoNumUsuario(String nombre, String apPat, String apMat) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "Delete From prestamo Where usuario_id in ( SELECT t1.usuario_id FROM prestamo t1 INNER JOIN usuario t2 " + 
		"ON t1.usuario_id = t2.id_usuario WHERE t2.nombre = '" + nombre + "' AND t2.ap_paterno = '" + apPat + 
		"' AND t2.ap_materno = '" + apMat + "' )";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarPrestamoTitulo(String titulo) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "Delete From prestamo Where usuario_id in ( SELECT t1.usuario_id FROM prestamo t1 INNER JOIN usuario t2 " + 
		"ON t1.usuario_id = t2.id_usuario WHERE t2.titulo = '" + titulo + "' )";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarPrestamo(String folio) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "Delete From prestamo Where usuario_id in ( SELECT t1.usuario_id FROM prestamo t1 INNER JOIN usuario t2 " + 
		"ON t1.usuario_id = t2.id_usuario WHERE t2.folio = '" + folio + "' )";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarPrestamo(Integer numLibro) {

		int valor = 0, id = 0;
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM prestamo WHERE libro_id = " + numLibro + ";";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}
	
	
	

}
