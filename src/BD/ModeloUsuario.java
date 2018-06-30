
package BD;

import Modelo.Usuario;
import java.util.*;
import javax.swing.table.*;

public class ModeloUsuario extends AbstractTableModel {

    private final ArrayList<Usuario> coleccion;

    public ModeloUsuario(ArrayList<Usuario> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getNombre();
            case 1:
                return temporal.getApPaterno();
            case 2:
                return temporal.getApMaterno();
            case 3:
                return temporal.getNumCredencial();
            case 4:
                return temporal.getDireccion();
            case 5:
                return temporal.getTelefono();
            case 6:
                return temporal.getCorreo();
            case 7:
                return temporal.getFechaAlta();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido Paterno";
            case 2:
                return "Apellido Materno";
            case 3:
                return "# Credencial";
            case 4:
                return "Direccion";
            case 5:
                return "Telefono";
            case 6:
                return "Correo";
            case 7:
                return "Fecha Alta";
            default:
                throw new AssertionError();
        }
    }

}
