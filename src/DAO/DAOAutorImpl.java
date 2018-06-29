package DAO;

import BD.DataSourcePostgreSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Autor;

public class DAOAutorImpl implements DAOAutor {

    private DataSourceImpl ds;
    private ArrayList<Autor> autores;

    public DAOAutorImpl() {
        ds = new DataSourceImpl();
        autores = new ArrayList<>();
    }

    public ArrayList<Autor> listarAutores() {
        ResultSet rs;
        Statement st = null;
        String sentencia;

        sentencia = "SELECT id_autor, nombre, apellidos FROM autor";

        rs = (ResultSet) ds.ejecutarConsulta(sentencia);

        try {

            while (rs.next()) {

                autores.add(new Autor(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return autores;
    }

    @Override
    public int registrarAutor(Autor autor) {
        int id = 0, idPersona = 0, valor = 0;
        String registro = null;

        // ----------------------------------
        registro = "INSERT INTO autor ( nombre, apellidos ) "
                + " VALUES ( '" + autor.getNombre() + "', '"
                + autor.getApellidos() + "' ); ";

        //ds = new DataSourceImpl();
        new DataSourcePostgreSQL();
        valor = this.ds.ejecutarActualizacion(registro);
        
        System.out.println(registro);
        return valor;

    }

    @Override
    public Autor buscarAutor(Integer idAutor) {
        ResultSet rs = (ResultSet) ds.ejecutarConsulta("SELECT id_autor,  nombre, apellidos " + "FROM autor WHERE id_autor = " + idAutor);

        Autor nuevoAutor = new Autor();

        try {
            while (rs.next()) {
                nuevoAutor.setIdAutor(rs.getInt(1));
                nuevoAutor.setNombre(rs.getString(2));
                nuevoAutor.setApellidos(rs.getString(3));
            }
        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();
        }
        return nuevoAutor;
    }

    @Override
    public Autor buscarAutor(String nombre, String apPaterno) {
        ResultSet rs = (ResultSet) ds.ejecutarConsulta("SELECT id_autor,  nombre, apellidos "
                + "FROM autor WHERE nombre = '" + nombre + "' AND apellidos = '" + apPaterno + "'");

        Autor nuevoAutor = new Autor();

        try {

            while (rs.next()) {

                nuevoAutor.setIdAutor(rs.getInt(1));
                nuevoAutor.setNombre(rs.getString(2));
                nuevoAutor.setApellidos(rs.getString(3));

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        return nuevoAutor;

    }

    @Override
    public int editarAutor(Integer idAutor, Autor autor) {

        int valor = 0, id = 0;
        ResultSet rs = null;
        String update = null;

        rs = (ResultSet) ds.ejecutarConsulta("SELECT * FROM autor WHERE id_autor = "
                + idAutor);

        try {

            if (rs.next()) {

                id = rs.getInt(1);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        update = "UPDATE autor SET "
                + " nombre = '" + autor.getNombre()
                + "', ap_paterno = '" + autor.getApellidos()
                + "' WHERE id_autor = " + id;

        valor = valor + ds.ejecutarActualizacion(update);

        return valor;

    }

    @Override
    public int editarAutor(String nombre, String apellidos, Autor autor) {

        int valor = 0, id = 0;
        ResultSet rs = null;
        String update = null;

        rs = (ResultSet) ds.ejecutarConsulta("SELECT * FROM autor WHERE nombre = '"
                + nombre + "' AND apellidos = '" + apellidos + "'");

        try {

            if (rs.next()) {

                id = rs.getInt(1);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        update = "UPDATE autor SET "
                + " nombre = '" + autor.getNombre()
                + "', ap_paterno = '" + autor.getApellidos()
                + "' WHERE id_autor = " + id;

        valor = valor + ds.ejecutarActualizacion(update);

        return valor;

    }

    @Override
    public int eliminarAutor(Integer idAutor) {

        int valor = 0, id = 0;
        ResultSet rs = null;
        String delete = null;

        delete = "DELETE FROM autor WHERE id_autor = " + idAutor + ";";

        valor = this.ds.ejecutarActualizacion(delete);

        return valor;

    }

    @Override
    public int eliminarAutor(String nombre, String apellidos) {

        int valor = 0, id = 0;
        ResultSet rs = null;
        String delete = null;

        delete = "DELETE FROM autor WHERE nombre = '" + nombre + "' AND apellidos = '"
                + apellidos + "';";

        valor = this.ds.ejecutarActualizacion(delete);

        return valor;

    }

    public Object[] autoresToArray() {

        Object[] array = null;

        ResultSet rs;
        Statement st = null;
        String sentencia;

        sentencia = "SELECT nombre, apellidos FROM autor ORDER BY nombre ASC";

        rs = (ResultSet) ds.ejecutarConsulta(sentencia);

        try {

            while (rs.next()) {

                autores.add(new Autor(rs.getString(1), rs.getString(2)));

            }

            array = new Object[autores.size()];

            for (int i = 0; i < autores.size(); i++) {

                array[i] = autores.get(i);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return array;

    }

    public DataSourceImpl getDs() {
        return ds;
    }

    public void setDs(DataSourceImpl ds) {
        this.ds = ds;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

}
