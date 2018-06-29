package DAO;

import Modelo.Libro;

public interface DAOLibro {
	
	int registrarLibro ( Libro libro );
	
	Libro buscarLibro( Integer idLibro );
	
	Libro buscarLibro( String folio );
	
	Libro buscarLibroPorTitulo( String titulo );
	
	Libro buscarLibroAutor( String nombre, String apellidos );
	
	int editarLibro( Integer idLibro, Libro libro );
	
	int editarLibro( String folio, Libro libro );
	
	int editarLibroPorTitulo( String titulo, Libro libro);
	
	int editarLibroAutor( String nombre, String apellidos, Libro libro );
	
	int eliminarLibro( Integer idLibro );
	
	int eliminarLibro( String folio );
	
	int eliminarLibroPorTitulo( String titulo );

}
