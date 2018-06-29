
package BD;

import Modelo.Libro;
import java.util.*;
import javax.swing.table.*;

public class ModeloLibros extends AbstractTableModel {

    private final ArrayList<Libro> coleccion;

    public ModeloLibros(ArrayList<Libro> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getFolio();
            case 1:
                return temporal.getTitulo();
            case 2:
                return temporal.getAutor();
            case 3:
                return temporal.getIsbn();
            case 4:
                return temporal.getEditorial();
            case 5:
                return temporal.getAnio();
            case 6:
                return temporal.getPais();
            case 7:
                return temporal.getEstante();
            case 8:
                return temporal.getSala();
            case 9:
                return temporal.getDescripcion();
            case 10:
                return temporal.getStatus();
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
                return "Usuario";
            case 2:
                return "ContraseÃ±a";
            case 3:
                return "Rol";
            case 4:
                return "Acceso";
            default:
                throw new AssertionError();
        }
    }

}
