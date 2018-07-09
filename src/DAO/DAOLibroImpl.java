package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Autor;
import Modelo.Editorial;
import Modelo.Estante;
import Modelo.Libro;
import Modelo.Pais;
import Modelo.Sala;
import Modelo.Status;

public class DAOLibroImpl implements DAOLibro {
	
	private DataSourceImpl ds;
	private ArrayList<Libro> libros;
	
	public DAOLibroImpl() {

		ds = new DataSourceImpl();
		libros = new ArrayList<>();
		
	}
	
	public ArrayList<Libro> listarLibros() {
		
		ResultSet rs;
		Statement st = null;
		String sentencia;
		
		sentencia = "Select t1.id_multimedia, t1.titulo, t1.autor, t1.anio, t2.pais, t3."
                        + ", t2.nombre, t2.apellidos, t1.isbn, t3.nombre, t1.año, t4.nombre," +
		"t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From  libro t1 inner join autor t2 on " +
		"autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial inner join pais t4  on pais_id = id_pais " + 
		"inner join estante t5 on estante_id = id_estante inner join status t6 on status_id = id_status ";
		
		rs = (ResultSet) ds.ejecutarConsulta(sentencia);
		
		try {
			
			while ( rs.next() ) {
				
				libros.add( new Libro( rs.getInt(1), rs.getString(2), rs.getString(3), new Autor( rs.getString(4), rs.getString(5) ),
						rs.getString(6), new Editorial( rs.getString(7) ), rs.getInt(8), new Pais( rs.getString(9) ),
						new Estante( rs.getInt(10), rs.getString(11) ),  new Sala( rs.getInt(12) ), rs.getString(13), 
						new Status( rs.getString(14) ) ) );
				
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return libros;
		
	}

	@Override
	public int registrarLibro(Libro libro) {

		int id = 0, idPersona = 0, valor = 0;
		String registro = null;
		this.ds.iniciarConexion();
		
		// ----------------------------------
		registro = "INSERT INTO libro ( folio, titulo, autor_id, isbn, editorial_id, a�o, pais_id, estante_id, sala_id, " +
		"descripcion, status_id ) " +
		" VALUES ( '" + libro.getFolio() + "', '" +
				libro.getTitulo() + "', " +
				libro.getAutor().getIdAutor() + ", '" +
				libro.getIsbn() + "', " +
				libro.getEditorial().getIdEditorial() + ", " +
				libro.getAnio() + ", " +
				libro.getPais().getIdPais() + ", " +
				libro.getEstante().getIdEstante() + ", " +
				libro.getSala().getIdSala() + ", '" +
				libro.getDescripcion() + "' " +
				libro.getStatus().getIdStatus() + "; ";
		
		
		//ds = new DataSourceImpl();
		valor = this.ds.ejecutarActualizacion(registro);
		
		return valor;
		
	}

	@Override
	public Libro buscarLibro(Integer idLibro) {

		this.ds.iniciarConexion();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_libro, t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
		"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " +
		" libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
		"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join status t6 on " +
		"status_id = id_status WHERE t1.id_libro = " + idLibro );
		
		Libro nuevoLibro = new Libro();
		
		try {
			
			while( rs.next() ) {
				
				nuevoLibro.setIdLibro( rs.getInt(1) );
				nuevoLibro.setFolio( rs.getString(2) );
				nuevoLibro.setTitulo( rs.getString(3) );
				nuevoLibro.setAutor( new Autor(rs.getString(4), rs.getString(5) ) );
				nuevoLibro.setIsbn( rs.getString(6) );
				nuevoLibro.setEditorial( new Editorial( rs.getString(7) ) );
				nuevoLibro.setAño( rs.getInt(8) );
				nuevoLibro.setPais( new Pais( rs.getString(9) ) );
				nuevoLibro.setEstante( new Estante(rs.getInt(10), rs.getString(11) ) );
				nuevoLibro.setSala( new Sala( rs.getInt(12) ) );
				nuevoLibro.setDescripcion( rs.getString(13) );
				nuevoLibro.setStatus( new Status( rs.getString(14) ) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoLibro;
		
	}

	@Override
	public Libro buscarLibro(String folio) {

		this.ds.iniciarConexion();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_libro, t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
				"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " +
				" libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
				"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join status t6 on " +
				"status_id = id_status WHERE t1.folio = '" + folio + "'" );
		
		Libro nuevoLibro = new Libro();
		
		try {
			
			while( rs.next() ) {
				
				nuevoLibro.setIdLibro( rs.getInt(1) );
				nuevoLibro.setFolio( rs.getString(2) );
				nuevoLibro.setTitulo( rs.getString(3) );
				nuevoLibro.setAutor( new Autor(rs.getString(4), rs.getString(5) ) );
				nuevoLibro.setIsbn( rs.getString(6) );
				nuevoLibro.setEditorial( new Editorial( rs.getString(7) ) );
				nuevoLibro.setAño( rs.getInt(8) );
				nuevoLibro.setPais( new Pais( rs.getString(9) ) );
				nuevoLibro.setEstante( new Estante(rs.getInt(10), rs.getString(11) ) );
				nuevoLibro.setSala( new Sala( rs.getInt(12) ) );
				nuevoLibro.setDescripcion( rs.getString(13) );
				nuevoLibro.setStatus( new Status( rs.getString(14) ) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoLibro;
		
	}
	

	@Override
	public Libro buscarLibroPorTitulo(String titulo) {

		this.ds.iniciarConexion();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_libro, t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
				"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " +
				" libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
				"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join status t6 on " +
				"status_id = id_status WHERE t1.titulo = '" + titulo + "'" );
		
		Libro nuevoLibro = new Libro();
		
		try {
			
			while( rs.next() ) {
				
				nuevoLibro.setIdLibro( rs.getInt(1) );
				nuevoLibro.setFolio( rs.getString(2) );
				nuevoLibro.setTitulo( rs.getString(3) );
				nuevoLibro.setAutor( new Autor(rs.getString(4), rs.getString(5) ) );
				nuevoLibro.setIsbn( rs.getString(6) );
				nuevoLibro.setEditorial( new Editorial( rs.getString(7) ) );
				nuevoLibro.setAño( rs.getInt(8) );
				nuevoLibro.setPais( new Pais( rs.getString(9) ) );
				nuevoLibro.setEstante( new Estante(rs.getInt(10), rs.getString(11) ) );
				nuevoLibro.setSala( new Sala( rs.getInt(12) ) );
				nuevoLibro.setDescripcion( rs.getString(13) );
				nuevoLibro.setStatus( new Status( rs.getString(14) ) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoLibro;
		
	}

	@Override
	public Libro buscarLibroAutor(String nombre, String apellido) {
		
		this.ds.iniciarConexion();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta("Select t1.id_libro, t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
		"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " + 
		"libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
		"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join " + 
		"status t6 on status_id = id_status Where ( t2.nombre = '" + nombre + "' ) or ( t2.apellidos = '" + apellido + "') or " + 
		"( t2.nombre = '" + nombre + "' and t2.apellidos = '" + apellido + "') " );
		
		Libro nuevoLibro = new Libro();
		
		try {
			
			while( rs.next() ) {
				
				nuevoLibro.setIdLibro( rs.getInt(1) );
				nuevoLibro.setFolio( rs.getString(2) );
				nuevoLibro.setTitulo( rs.getString(3) );
				nuevoLibro.setAutor( new Autor(rs.getString(4), rs.getString(5) ) );
				nuevoLibro.setIsbn( rs.getString(6) );
				nuevoLibro.setEditorial( new Editorial( rs.getString(7) ) );
				nuevoLibro.setAño( rs.getInt(8) );
				nuevoLibro.setPais( new Pais( rs.getString(9) ) );
				nuevoLibro.setEstante( new Estante(rs.getInt(10), rs.getString(11) ) );
				nuevoLibro.setSala( new Sala( rs.getInt(12) ) );
				nuevoLibro.setDescripcion( rs.getString(13) );
				nuevoLibro.setStatus( new Status( rs.getString(14) ) );
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		return nuevoLibro;
		
	}

	@Override
	public int editarLibro(Integer idLibro, Libro libro) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("Select t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
		"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " + 
		"libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
		"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join " + 
		"status t6 on status_id = id_status Where t1.id_libro = " + idLibro );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE libro SET " 
				+ " folio = '" + libro.getFolio()
				+ "' titulo = '" + libro.getTitulo()
				+ "' autor_id = '" + libro.getAutor().getIdAutor()
				+ "' isbn = '" + libro.getIsbn()
				+ "' editorial_id = " + libro.getEditorial().getIdEditorial()
				+ " a�o = " + libro.getAnio()
				+ " pais_id = " + libro.getPais().getIdPais()
				+ " estante_id = " + libro.getEstante().getIdEstante()
				+ " sala_id = " + libro.getSala().getIdSala()
				+ " descripcion = '" + libro.getDescripcion()
				+ "' status_id = " + libro.getStatus().getIdStatus()
				+ " WHERE id_libro = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}

	@Override
	public int editarLibro(String folio, Libro libro) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("Select t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
		"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " + 
		"libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
		"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join " + 
		"status t6 on status_id = id_status Where t1.folio = '" + folio + "'" );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE libro SET " 
				+ " folio = '" + libro.getFolio()
				+ "' titulo = '" + libro.getTitulo()
				+ "' autor_id = '" + libro.getAutor().getIdAutor()
				+ "' isbn = '" + libro.getIsbn()
				+ "' editorial_id = " + libro.getEditorial().getIdEditorial()
				+ " a�o = " + libro.getAnio()
				+ " pais_id = " + libro.getPais().getIdPais()
				+ " estante_id = " + libro.getEstante().getIdEstante()
				+ " sala_id = " + libro.getSala().getIdSala()
				+ " descripcion = '" + libro.getDescripcion()
				+ "' status_id = " + libro.getStatus().getIdStatus()
				+ " WHERE id_libro = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}

	@Override
	public int editarLibroPorTitulo(String titulo, Libro libro) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("Select t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
		"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " + 
		"libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
		"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join " + 
		"status t6 on status_id = id_status Where t1.titulo = '" + titulo + "'" );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE libro SET " 
				+ " folio = '" + libro.getFolio()
				+ "' titulo = '" + libro.getTitulo()
				+ "' autor_id = '" + libro.getAutor().getIdAutor()
				+ "' isbn = '" + libro.getIsbn()
				+ "' editorial_id = " + libro.getEditorial().getIdEditorial()
				+ " a�o = " + libro.getAnio()
				+ " pais_id = " + libro.getPais().getIdPais()
				+ " estante_id = " + libro.getEstante().getIdEstante()
				+ " sala_id = " + libro.getSala().getIdSala()
				+ " descripcion = '" + libro.getDescripcion()
				+ "' status_id = " + libro.getStatus().getIdStatus()
				+ " WHERE id_libro = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}

	@Override
	public int editarLibroAutor(String nombre, String apellido, Libro libro) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String update = null;
		
		rs = (ResultSet) ds.ejecutarConsulta("Select t1.folio, t1.titulo, t2.nombre, t2.apellidos, " +
		"t1.isbn, t3.nombre, t1.a�o, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From " + 
		"libro t1 inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial " +
		"inner join pais t4 on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join " + 
		"status t6 on status_id = id_status Where ( t2.nombre = '" + nombre + "' ) or ( t2.apellidos = '" + apellido + "') or " + 
		"( t2.nombre = '" + nombre + "' and t2.apellidos = '" + apellido + "') " );
		
		try {
			
			if ( rs.next() ) {
				
				id = rs.getInt(1);
				
			}
			
		} catch ( SQLException e ) {
			
			e.getMessage();
			e.printStackTrace();
			
		}
		
		
		update = "UPDATE libro SET " 
				+ " folio = '" + libro.getFolio()
				+ "' titulo = '" + libro.getTitulo()
				+ "' autor_id = '" + libro.getAutor().getIdAutor()
				+ "' isbn = '" + libro.getIsbn()
				+ "' editorial_id = " + libro.getEditorial().getIdEditorial()
				+ " a�o = " + libro.getAnio()
				+ " pais_id = " + libro.getPais().getIdPais()
				+ " estante_id = " + libro.getEstante().getIdEstante()
				+ " sala_id = " + libro.getSala().getIdSala()
				+ " descripcion = '" + libro.getDescripcion()
				+ "' status_id = " + libro.getStatus().getIdStatus()
				+ " WHERE id_libro = " + id;
		
		valor = valor + ds.ejecutarActualizacion(update);
		
		
		return valor;
		
	}

	@Override
	public int eliminarLibro(Integer idLibro) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM libro WHERE id_libro = " + idLibro + ";";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarLibro(String folio) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM libro WHERE folio = '" + folio + "';";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}

	@Override
	public int eliminarLibroPorTitulo(String titulo) {

		int valor = 0, id = 0;
		this.ds.iniciarConexion();
		ResultSet rs = null;
		String delete = null;
		
		delete = "DELETE FROM libro WHERE titulo = '" + titulo + "';";
		
		valor = this.ds.ejecutarActualizacion(delete);
		
		return valor;
		
	}
	

}
