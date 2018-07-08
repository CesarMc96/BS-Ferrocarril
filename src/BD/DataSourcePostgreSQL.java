package BD;

import Modelo.Autor;
import Modelo.Compañia;
import Modelo.Editorial;
import Modelo.Juego;
import Modelo.Multimedia;
import Modelo.Pais;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSourcePostgreSQL implements DataSource {

    private Connection connection;
    private Statement st;
    private ArrayList arreglo;

    public DataSourcePostgreSQL() {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BS-Ferrocarril", "postgres", "toor");
            this.st = this.connection.createStatement();
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
            Logger.getLogger(DataSourcePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        System.out.println("Opened database successfully");
    }

    @Override
    public Object ejecutarConsulta(String consulta) {
        System.out.println(consulta);
        ResultSet rs = null;
        try {
            rs = st.executeQuery(consulta);
            System.out.println(rs);

            while (rs.next()) {
                String nombre = rs.getString(1);
                System.out.println(nombre);
            }

            rs.close();
            st.close();
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        return (Object) rs;
    }

    @Override
    public int ejecutarActualizacion(String consulta) {
        System.out.println(consulta);
        int columnas = 0;
        try {
            columnas = this.st.executeUpdate(consulta);
            connection.close();
        } catch (SQLException ex) {
        }
        return columnas;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataSourcePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList crearArreglo(String consulta, String tipo) {
        System.out.println(consulta);
        ResultSet rs = null;

        arreglo = new ArrayList();

        try {
            rs = st.executeQuery(consulta);
            System.out.println(rs);

            if ("Autor".equals(tipo)) {
                while (rs.next()) {
                    String nombre = rs.getString(2);
                    //System.out.println(nombre);
                    arreglo.add(new Autor(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
            }

            if ("Editorial".equals(tipo)) {
                while (rs.next()) {
                    arreglo.add(new Editorial(rs.getInt(1), rs.getString(2)));
                }
            }

            if ("Usuario".equals(tipo)) {
                while (rs.next()) {
                    arreglo.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9)));
                }
            }

            if("Juego".equals(tipo)){
                while (rs.next()) {
                    arreglo.add(new Juego(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                }
            }
            

            rs.close();
            st.close();
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
        return arreglo;
    }

}
