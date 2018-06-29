package DAO;

import Modelo.Usuario;

public interface DAOUsuario {
	
	int registrarUsuario( Usuario usuario );
	
	Usuario buscarUsuario( String numCredencial );
	
	Usuario buscarUsuario( String nombre, String apPaterno );
	
	int editarUsuario( String numCredencial, Usuario usuario );

	int editarUsuario( String nombre, String apPaterno, Usuario usuario );
	
	int eliminarUsuario( String numCredencial );
	
	int eliminarUsuario( String nombre, String apPaterno );
	
}
