package DAO;

import java.util.ArrayList;

import Modelo.Autor;
import Modelo.Libro;
import Modelo.PrestamoPreferencial;

public interface DAOReporte {
	
	int registrarPrestamoRef( PrestamoPreferencial prestamo );
	
	int editarPrestamo( String folio );
	
	int actualizarPrestamo( String isbn );
	
	int actualizarPrestamo( Integer idPrestamo );
	
	Integer numLibrosPrestados( String mes );
	
	Autor autorMasSolicitado( String mes );
	
	Libro libroMasPrestado( String mes );
	
	Integer[] numLibrosDisponibles();
	
	ArrayList<Libro> numLibrosAgregados( String mes );
	

}
