package DAO;

import Modelo.Editorial;

public interface DAOEditorial {
	
	int registrarEditorial( Editorial editorial );
	
	Editorial buscarEditorial( Integer idEditorial );
	
	Editorial buscarEditorial( String nombre );
	
	int editarEditorial( Integer idEditorial, Editorial editorial );

	int editarEditorial( String nombre, Editorial editorial );
	
	int eliminarEditorial( Integer idEditorial );
	
	int eliminarEditorial( String nombre );

}
