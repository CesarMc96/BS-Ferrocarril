package DAO;

import Modelo.Autor;

public interface DAOAutor {

    int registrarAutor(Autor autor);

    Autor buscarAutor(Integer idAutor);

    Autor buscarAutor(String nombre, String apellidos);

    int editarAutor(Integer idAutor, Autor autor);

    int editarAutor(String nombre, String apellidos, Autor autor);

    int eliminarAutor(Integer idAutor);

    int eliminarAutor(String nombre, String apellidos);

}
