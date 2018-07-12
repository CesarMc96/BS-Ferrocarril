package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import Modelo.Autor;
import Modelo.Editorial;
import Modelo.Estante;
import Modelo.Libro;
import Modelo.Pais;
import Modelo.PrestamoPreferencial;
import Modelo.Sala;
import Modelo.Status;

public class DAOReporteImpl implements DAOReporte {

    private DataSourceImpl ds;
    private Integer anio;

    public DAOReporteImpl() {

        ds = new DataSourceImpl();
        Calendar cal = Calendar.getInstance();
        anio = cal.get(Calendar.YEAR);

    }

    @Override
    public int registrarPrestamoRef(PrestamoPreferencial prestamo) {

        int id = 0, idPersona = 0, valor = 0;
        String registro = null;
        this.ds.iniciarConexion();

        // ----------------------------------
        registro = "INSERT INTO prestamo_preferencial ( libro_id, num_prestamo, fecha_prestamo ) VALUES ( "
                + prestamo.getLibro().getIdLibro() + ", "
                + prestamo.getNumPrestamo() + ", '"
                + prestamo.getFechaPrestaomo() + "' );";

        //ds = new DataSourceImpl();
        valor = this.ds.ejecutarActualizacion(registro);

        return valor;

    }

    @Override
    public int editarPrestamo(String folio) {

        int valor = 0, id = 0, numPrestamo = 0;
        ResultSet rs = null;
        String update = null;

        rs = (ResultSet) ds.ejecutarConsulta("SELECT t1.id_prestamo_ref, t1.num_prestamo FROM prestamo_preferencial "
                + "t1 INNER JOIN libro t2 on t1.libro_id = t2.id_libro WHERE t2.folio = '" + folio + "'; ");

        try {

            if (rs.next()) {

                id = rs.getInt(1);
                numPrestamo = rs.getInt(2);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        numPrestamo = numPrestamo + 1;

        update = "UPDATE prestamo_preferencial SET "
                + " num_prestamo = " + numPrestamo
                + "WHERE id_prestamo_ref = " + id;

        valor = valor + ds.ejecutarActualizacion(update);

        return valor;

    }

    @Override
    public int actualizarPrestamo(String isbn) {

        int valor = 0, id = 0, numPrestamo = 0;
        ResultSet rs = null;
        String update = null;

        rs = (ResultSet) ds.ejecutarConsulta("SELECT t1.id_prestamo_ref, t1.num_prestamo FROM prestamo_preferencial "
                + "t1 INNER JOIN libro t2 on t1.libro_id = t2.id_libro WHERE t2.isbn = '" + isbn + "'; ");

        try {

            if (rs.next()) {

                id = rs.getInt(1);
                numPrestamo = rs.getInt(2);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        numPrestamo = numPrestamo + 1;

        update = "UPDATE prestamo_preferencial SET "
                + " num_prestamo = " + numPrestamo
                + "WHERE id_prestamo_ref = " + id;

        valor = valor + ds.ejecutarActualizacion(update);

        return valor;

    }

    @Override
    public int actualizarPrestamo(Integer idPrestamo) {

        int valor = 0, id = 0, numPrestamo = 0;
        ResultSet rs = null;
        String update = null;

        rs = (ResultSet) ds.ejecutarConsulta("SELECT t1.id_prestamo_ref, t1.num_prestamo FROM prestamo_preferencial "
                + "t1 INNER JOIN libro t2 on t1.libro_id = t2.id_libro WHERE t1.id_prestamo_ref = " + idPrestamo);

        try {

            if (rs.next()) {

                id = rs.getInt(1);
                numPrestamo = rs.getInt(2);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        numPrestamo = numPrestamo + 1;

        update = "UPDATE prestamo_preferencial SET "
                + " num_prestamo = " + numPrestamo
                + "WHERE id_prestamo_ref = " + id;

        valor = valor + ds.ejecutarActualizacion(update);

        return valor;

    }

    @Override
    public Integer numLibrosPrestados(String mes) {

        int valor = 0, id = 0;
        Integer numerosMes = 0, numeroMes = 0;
        ResultSet rs = null;
        String update = null;

        numeroMes = getMes(mes);

        rs = (ResultSet) ds.ejecutarConsulta("SELECT COUNT(*) FROM prestamo_preferencial WHERE "
                + "(SELECT extract(month from fecha_prestamo ) ) = " + numeroMes + "AND (Select extract(year from  now() ) = "
                + anio + ");");

        try {

            if (rs.next()) {

                numerosMes = rs.getInt(1);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        return numerosMes;

    }

    @Override
    public Autor autorMasSolicitado(String mes) {

        int valor = 0, id = 0;
        Integer numerosMes = 0, numeroMes = 0;
        ResultSet rs = null;
        String update = null;
        Autor autor = null;
        numeroMes = getMes(mes);

        rs = (ResultSet) ds.ejecutarConsulta("Select nombre, apellidos from autor where id_autor = ( Select autor_id From libro "
                + "Where id_libro = (Select libro_id From prestamo_preferencial Where num_prestamo = (Select Max(num_prestamo) "
                + "From prestamo_preferencial Where (Select extract(month from fecha_prestamo ) ) = " + numeroMes
                + "AND (Select extract(year from  now() ) = " + anio + " ) ) ) )");

        try {

            if (rs.next()) {

                autor = new Autor(rs.getString(1), rs.getString(2));

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        return autor;

    }

    @Override
    public Libro libroMasPrestado(String mes) {

        int valor = 0, id = 0;
        Integer numerosMes = 0, numeroMes = 0;
        ResultSet rs = null;
        String update = null;
        Libro libro = null;
        numeroMes = getMes(mes);

        rs = (ResultSet) ds.ejecutarConsulta("Select t1.folio, t1.titulo, t2.nombre, t2.apellidos, t1.isbn, "
                + "t3.nombre, t1.anio, t4.nombre, t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion From libro t1 "
                + "inner join autor t2 on autor_id = id_autor inner join editorial t3 on editorial_id = id_editorial inner join pais t4 "
                + "on pais_id = id_pais inner join estante t5 on estante_id = id_estante inner join status t6 on status_id = id_status "
                + "Where t1.id_libro = ( Select libro_id From prestamo_preferencial Where num_prestamo = "
                + "(Select Max(num_prestamo) From prestamo_preferencial Where (Select extract(month from fecha_prestamo ) ) = "
                + numeroMes + "AND (Select extract(year from  now() ) = " + anio + " ) ) )");

        try {

            if (rs.next()) {

                libro = new Libro(rs.getString(1), rs.getString(2), new Autor(rs.getString(3), rs.getString(4)), rs.getString(5),
                        new Editorial(rs.getString(6)), rs.getInt(7), new Pais(rs.getString(8)),
                        new Estante(rs.getInt(9), rs.getString(10)), new Sala(rs.getString(11)), rs.getString(12),
                        new Status(rs.getString(13)));

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        return libro;

    }

    @Override
    public Integer[] numLibrosDisponibles() {

        int valor = 0, id = 0;
        Integer[] disponibilidad = new Integer[2];
        ResultSet rs = null, rs2 = null;
        String update = null;

        rs = (ResultSet) ds.ejecutarConsulta("Select Count(*) from libro where status_id = 2 ");
        rs2 = (ResultSet) ds.ejecutarConsulta("Select Count(*) from libro where status_id <> 2 ");

        try {

            if (rs.next()) {

                disponibilidad[0] = rs.getInt(1);

            }

            if (rs2.next()) {

                disponibilidad[1] = rs2.getInt(1);

            }

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

        return disponibilidad;

    }

    @Override
    public ArrayList<Libro> numLibrosAgregados(String mes) {

        ResultSet rs;
        Statement st = null;
        String sentencia;

        ArrayList<Libro> libros = new ArrayList<>();
        Integer numMes = getMes(mes);

        sentencia = "SELECT t1.folio, t1.titulo, t2.nombre, t2.apellidos, t1.isbn, t3.nombre, t1.anio, t4.nombre, "
                + "t5.estante, t5.nivel, t1.sala_id, t1.descripcion, t6.descripcion FROM 	libro t1 INNER JOIN autor t2 ON "
                + "autor_id = id_autor INNER JOIN editorial t3 ON editorial_id = id_editorial INNER JOIN pais t4  ON "
                + "pais_id = id_pais INNER JOIN estante t5 ON estante_id = id_estante INNER JOIN status t6 ON "
                + "status_id = id_status WHERE (SELECT extract(month from fecha_registro ) ) = "
                + numMes + "AND (Select extract(year from  now( ) ) = " + anio + " );";

        rs = (ResultSet) ds.ejecutarConsulta(sentencia);

        try {

            while (rs.next()) {

                libros.add(new Libro(rs.getString(1), rs.getString(2), new Autor(rs.getString(3), rs.getString(4)),
                        rs.getString(5), new Editorial(rs.getString(6)), rs.getInt(7), new Pais(rs.getString(8)),
                        new Estante(rs.getInt(9), rs.getString(10)), new Sala(rs.getInt(11)), rs.getString(12),
                        new Status(rs.getString(13))));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return libros;

    }

    private Integer getMes(String nombre) {

        Integer mes = 0;

        if (nombre.equals("Enero")) {
            mes = 1;
        } else if (nombre.equals("Febrero")) {
            mes = 2;
        } else if (nombre.equals("Marzo")) {
            mes = 3;
        } else if (nombre.equals("Abril")) {
            mes = 4;
        } else if (nombre.equals("Mayo")) {
            mes = 5;
        } else if (nombre.equals("Junio")) {
            mes = 6;
        } else if (nombre.equals("Julio")) {
            mes = 7;
        } else if (nombre.equals("Agosto")) {
            mes = 8;
        } else if (nombre.equals("Septiembre")) {
            mes = 9;
        } else if (nombre.equals("Octubre")) {
            mes = 10;
        } else if (nombre.equals("Noviembre")) {
            mes = 11;
        } else if (nombre.equals("Diciembre")) {
            mes = 12;
        } else {
            mes = -1;
        }

        return mes;

    }

    public DataSourceImpl getDs() {
        return ds;
    }

    public void setDs(DataSourceImpl ds) {
        this.ds = ds;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

}
