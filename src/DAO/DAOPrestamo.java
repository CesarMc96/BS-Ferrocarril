package DAO;

import Modelo.Prestamo;

public interface DAOPrestamo {
	
	int registrarPrestamo( Prestamo prestamo );
	
	Prestamo buscarPrestamo( Integer numeroPrestamo );
	
	Prestamo buscarPrestamoUsuario( Integer numUsuario );
	
	Prestamo buscarPrestamoLibro( String titulo );
	
	Prestamo buscarPrestamoPorLibro( String folio );
	
	Prestamo buscarPrestamoPorLibro( Integer numLibro ); //
	
	int editarPrestamo( Integer numeroPrestamo, Prestamo prestamo );

	int editarPrestamoUsuario( Integer numUsuario, Prestamo prestamo );
	
	int editarPrestamoNumPrestamo( String titulo, Prestamo prestamo);
	
	int editarPrestamoNumUsuario( String folio, Prestamo prestamo );
	
	int editarPrestamoTitulo( Integer numLibro, Prestamo prestamo );
	
	int eliminarPrestamoNumPrestamo( Integer numeroPrestamo );

	int eliminarPrestamoNumUsuario( String nombre, String apPat, String apMat );
	
	int eliminarPrestamoTitulo( String titulo );
	
	int eliminarPrestamo( String folio );
	
	int eliminarPrestamo( Integer numLibro );

}
