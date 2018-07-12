package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataSourceImpl {

    private String usuario = "postgres";
    private String contrasena = "toor";
    private String puerto = "5432";
    private String protocolo = "jdbc:postgresql://localhost:" + puerto + "/BS-Ferrocarril"; //Falta la Base de Datos
    private Connection conexion = null;

    public DataSourceImpl() {

    }

    public void iniciarConexion() {

        try {

            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(protocolo, usuario, contrasena);
//            JOptionPane.showMessageDialog(null, " Se ha Establecido la Conecion a la Base de Datos Correctamente",
//                    "Conexion Realizada Exitosamente", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {

            e.getMessage();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " No Se ha Logrado Establecer una Conexion con el Servidor!.",
                    "Conexion Fallida", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void cerrarConexion() {

        try {

            conexion.close();

            JOptionPane.showMessageDialog(null, "La Conexion Se ha Finalizado!. \nConexion Finalizada Exitosamente!. \n ",
                    "Se Cerro la Conexion!. \n ", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "La Conexion No Se ha Finalizado!. \nConexion Finalizada Sin Exito!. \n ",
                    "No Se Pudo Cerrar la Conexion!. \n ", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Object ejecutarConsulta(String consulta) {

        Statement st = null;
        ResultSet rs = null;

        try {

            iniciarConexion();
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);

        } catch (Exception e) {

            e.getMessage();
            e.printStackTrace();
            cerrarConexion();

        }

        return rs;
    }

    public int ejecutarActualizacion(String consulta) {

        Statement st = null;

        System.out.println("1 " + consulta);
        try {
            st = conexion.createStatement();
            st.executeUpdate(consulta);
            return 1;

        } catch (Exception e) {

            e.getMessage();
            e.printStackTrace();
            return 0;

        }

    }

    public Connection getConexion() {
        return conexion;
    }

}
