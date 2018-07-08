package DAO;

import java.time.Period;
import java.util.ArrayList;
import DAO.DAOAutorImpl;
import DAO.DAOEditorialImpl;
import DAO.DAOLibroImpl;
import DAO.DAOPrestamoImpl;
import DAO.DAOUsuarioImpl;
import DAO.DataSourceImpl;
import Modelo.Autor;
import Modelo.Editorial;
import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Usuario;

public class Controlador {

    private DataSourceImpl ds;
    private DAOAutorImpl daoAutor;
    private DAOEditorialImpl daoEditorial;
    private DAOLibroImpl daoLibro;
    private DAOPrestamoImpl daoPrestamo;
    private DAOUsuarioImpl daoUsuario;
    private Object[][] matriz;

    public Controlador() {

        daoAutor = new DAOAutorImpl();
        daoEditorial = new DAOEditorialImpl();
        daoLibro = new DAOLibroImpl();
        daoPrestamo = new DAOPrestamoImpl();
        daoUsuario = new DAOUsuarioImpl();
    }

    public int registrarAutor(Autor autor) {

        return daoAutor.registrarAutor(autor);

    }

    public Autor buscarAutor(Integer idAutor) {

        Autor autor = null;

        autor = daoAutor.buscarAutor(idAutor);

        return autor;

    }

    public Autor buscarAutor(String nombre, String apellidos) {

        Autor autor;
        autor = daoAutor.buscarAutor(nombre, apellidos);

        return autor;

    }

    public int editarAutor(Integer idAutor, Autor autor) {

        return daoAutor.editarAutor(idAutor, autor);

    }

    public int editarAutor(String nombre, String apellido, Autor autor) {

        return daoAutor.editarAutor(nombre, apellido, autor);

    }

    public int eliminarAutor(Integer idAutor) {

        return daoAutor.eliminarAutor(idAutor);

    }

    public int eliminarAutor(String nombre, String apellidos) {

        return daoAutor.eliminarAutor(nombre, apellidos);

    }

    public int registrarEditorial(Editorial editorial) {

        return daoEditorial.registrarEditorial(editorial);

    }

    public Editorial buscarEditorial(Integer idEditorial) {

        return daoEditorial.buscarEditorial(idEditorial);

    }

    public Editorial buscarEditorial(String nombre) {

        return daoEditorial.buscarEditorial(nombre);

    }

    public int editarEditorial(Integer idEditorial, Editorial editorial) {

        return daoEditorial.editarEditorial(idEditorial, editorial);

    }

    public int editarEditorial(String nombre, Editorial editorial) {

        return daoEditorial.editarEditorial(nombre, editorial);

    }

    public int eliminarEditorial(Integer idEditorial) {

        return daoEditorial.eliminarEditorial(idEditorial);

    }

    public int editarEditorial(String nombre) {

        return daoEditorial.eliminarEditorial(nombre);

    }

    public int registrarLibro(Libro libro) {

        return daoLibro.registrarLibro(libro);

    }

    public Libro buscarLibro(Integer idLibro) {

        return daoLibro.buscarLibro(idLibro);

    }

    public Libro buscarLibro(String folio) {

        return daoLibro.buscarLibro(folio);

    }

    public Libro buscarLibro(String nombre, String apellido) {

        return daoLibro.buscarLibroAutor(nombre, apellido);

    }

    public Libro buscarLibroPorTitulo(String titulo) {

        return daoLibro.buscarLibroPorTitulo(titulo);

    }

    public int editarLibro(Integer idLibro, Libro libro) {

        return daoLibro.editarLibro(idLibro, libro);

    }

    public int editarLibro(String folio, Libro libro) {

        return daoLibro.editarLibro(folio, libro);

    }

    public int editarrLibro(String nombre, String apellido, Libro libro) {

        return daoLibro.editarLibroAutor(nombre, apellido, libro);

    }

    public int editarLibroPorTitulo(String titulo, Libro libro) {

        return daoLibro.editarLibroPorTitulo(titulo, libro);

    }

    public int eliminarLibro(Integer idLibro) {

        return daoLibro.eliminarLibro(idLibro);

    }

    public int eliminarLibro(String folio) {

        return daoLibro.eliminarLibro(folio);

    }

    public int eliminarLibroPorTitulo(String titulo) {

        return daoLibro.eliminarLibroPorTitulo(titulo);

    }

    public int registrarPrestamo(Prestamo prestamo) {

        return daoPrestamo.registrarPrestamo(prestamo);

    }

    public Prestamo buscarPrestamo(Integer numPrestamo) {

        return daoPrestamo.buscarPrestamo(numPrestamo);

    }

    public Prestamo buscarPrestamo(String titulo) {

        return daoPrestamo.buscarPrestamoLibro(titulo);

    }

    public Prestamo buscarPrestamoLibro(Integer numLibro) {

        return daoPrestamo.buscarPrestamoPorLibro(numLibro);

    }

    public Prestamo buscarPrestamoPorFolio(String folio) {

        return daoPrestamo.buscarPrestamoPorLibro(folio);

    }

    public Prestamo buscarPrestamoUsuario(Integer numUsuario) {

        return daoPrestamo.buscarPrestamoUsuario(numUsuario);

    }

    public int editarPrestamo(Integer numeroPrestamo, Prestamo prestamo) {

        return daoPrestamo.editarPrestamo(numeroPrestamo, prestamo);

    }

    public int editarPrestamo(String titulo, Prestamo prestamo) {

        return daoPrestamo.editarPrestamoNumPrestamo(titulo, prestamo);

    }

    public int editarPrestamoPorFolio(String folio, Prestamo prestamo) {

        return daoPrestamo.editarPrestamoNumUsuario(folio, prestamo);

    }

    public int editarPrestamoLibro(Integer numLibro, Prestamo prestamo) {

        return daoPrestamo.editarPrestamoTitulo(numLibro, prestamo);

    }

    public int editarPrestamoUsuario(Integer numUsuario, Prestamo prestamo) {

        return daoPrestamo.editarPrestamoUsuario(numUsuario, prestamo);

    }

    public int eliminarPrestamo(Integer numLibro) {

        return daoPrestamo.eliminarPrestamo(numLibro);

    }

    public int eliminarPrestamo(String folio) {

        return daoPrestamo.eliminarPrestamo(folio);

    }

    public int eliminarPrestamoo(Integer numPrestamo) {

        return daoPrestamo.eliminarPrestamoNumPrestamo(numPrestamo);

    }

    public int eliminarPrestamoPorUsuario(String nombre, String apPat, String apMat) {

        return daoPrestamo.eliminarPrestamoNumUsuario(nombre, apPat, apMat);

    }

    public int eliminarPrestamoPorTitulo(String titulo) {

        return daoPrestamo.eliminarPrestamoTitulo(titulo);

    }

    public int registrarUsuario(Usuario usuario) {

        return daoUsuario.registrarUsuario(usuario);

    }

    public Usuario buscarUsuario(String numCredencial) {

        return daoUsuario.buscarUsuario(numCredencial);

    }

    public Usuario buscarUsuario(String nombre, String apPaterno) {

        return daoUsuario.buscarUsuario(nombre, apPaterno);

    }

    public int editarUsuario(String numCredencial, Usuario usuario) {

        return daoUsuario.editarUsuario(numCredencial, usuario);

    }

    public int editarUsuario(String nombre, String apPat, Usuario usuario) {

        return daoUsuario.editarUsuario(nombre, apPat, usuario);

    }

    public int eliminarUsuario(String numCredencial) {

        return daoUsuario.eliminarUsuario(numCredencial);

    }

    public int eliminarUsuario(String nombre, String apPat) {

        return daoUsuario.eliminarUsuario(nombre, apPat);

    }

    // Faltan Para Convertir a Matriz, Para Llenar ComboBox
    public ArrayList<Autor> listarAutores() {

        ArrayList<Autor> autores;

        autores = daoAutor.listarAutores();

        return autores;

    }

    public ArrayList<Editorial> listarEditoriales() {

        ArrayList<Editorial> editoriales;

        editoriales = daoEditorial.listarEditoriales();

        return editoriales;

    }

    public ArrayList<Libro> listarLibros() {

        ArrayList<Libro> libros;

        libros = daoLibro.listarLibros();

        return libros;

    }

    public ArrayList<Prestamo> listarPrestamos() {

        ArrayList<Prestamo> prestamos;

        prestamos = daoPrestamo.listarPrestamo();

        return prestamos;

    }

    public ArrayList<Usuario> listarUsuarios() {

        ArrayList<Usuario> usuarios;

        usuarios = daoUsuario.listarUsuarios();

        return usuarios;

    }

    public Object[][] toMatrizAutores() {

        ArrayList<Autor> autors = listarAutores();

        matriz = new Object[autors.size()][3];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][0] = autors.get(i).getIdAutor();
                matriz[i][1] = autors.get(i).getNombre();
                matriz[i][2] = autors.get(i).getApellidos();

            }

        }

        return matriz;

    }

    public Object[][] toMatrizEditoriales() {

        ArrayList<Editorial> editorials = listarEditoriales();

        matriz = new Object[editorials.size()][2];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][0] = editorials.get(i).getIdEditorial();
                matriz[i][1] = editorials.get(i).getNombre();

            }

        }

        return matriz;

    }

    public Object[][] toMatrizLibros() {

        ArrayList<Libro> libros = listarLibros();

        matriz = new Object[libros.size()][12];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][0] = libros.get(i).getIdLibro();
                matriz[i][1] = libros.get(i).getFolio();
                matriz[i][3] = libros.get(i).getTitulo();
                matriz[i][4] = libros.get(i).getAutor();
                matriz[i][5] = libros.get(i).getIsbn();
                matriz[i][6] = libros.get(i).getEditorial();
                matriz[i][7] = libros.get(i).getAnio();
                matriz[i][8] = libros.get(i).getPais();
                matriz[i][9] = libros.get(i).getEstante();
                matriz[i][10] = libros.get(i).getSala();
                matriz[i][11] = libros.get(i).getDescripcion();
                matriz[i][12] = libros.get(i).getStatus();

            }

        }

        return matriz;

    }

    public Object[][] toMatrizPrestamos() {

        ArrayList<Prestamo> prestamos = listarPrestamos();

        matriz = new Object[prestamos.size()][12];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][0] = prestamos.get(i).getIdPrestamo();
                matriz[i][1] = prestamos.get(i).getFechaPrestamo();
                matriz[i][3] = prestamos.get(i).getFechaDevolucion();
                matriz[i][4] = prestamos.get(i).getNumeroRenovacion();
                matriz[i][5] = prestamos.get(i).getTitulo();
                matriz[i][6] = prestamos.get(i).getAutor();
                matriz[i][7] = prestamos.get(i).getEditorial();
                matriz[i][8] = prestamos.get(i).getNombreUsuario();
                matriz[i][9] = prestamos.get(i).getNumCredencial();
                matriz[i][10] = prestamos.get(i).getObservaciones();
                matriz[i][11] = prestamos.get(i).getAccion();

            }

        }

        return matriz;

    }

    public Object[][] toMatrizUsuarios() {

        ArrayList<Usuario> usuarios = listarUsuarios();

        matriz = new Object[usuarios.size()][12];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][0] = usuarios.get(i).getIdUsuario();
                matriz[i][1] = usuarios.get(i).getNombre();
                matriz[i][3] = usuarios.get(i).getApPaterno();
                matriz[i][4] = usuarios.get(i).getApMaterno();
                matriz[i][5] = usuarios.get(i).getNumCredencial();
                matriz[i][6] = usuarios.get(i).getDireccion();
                matriz[i][7] = usuarios.get(i).getTelefono();
                matriz[i][8] = usuarios.get(i).getCorreo();
                matriz[i][9] = usuarios.get(i).getFechaAlta();

            }

        }

        return matriz;

    }

    // Falta Convertir a Array las Opciones de JComboBox
    public Object[] auotoresToArray() {

        Object[] array = daoAutor.autoresToArray();

        return array;

    }

    public Object[] editorialesToArray() {

        Object[] array = daoEditorial.editorialestoArray();

        return array;

    }

}
