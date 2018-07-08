
package BD;

import Modelo.Multimedia;
import java.util.*;
import javax.swing.table.*;

public class ModeloMultimedia extends AbstractTableModel {

    private final ArrayList<Multimedia> coleccion;

    public ModeloMultimedia(ArrayList<Multimedia> arreglo) {
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
        Multimedia temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getTitulo();
            case 1:
                return temporal.getAutor();
            case 2:
                return temporal.getAnio();
            case 3:
                return temporal.getPais();
            case 4:
                return temporal.getCompañia();
            case 5:
                return temporal.getEditorial();
            case 6:
                return temporal.getFormato();
            case 7:
                return temporal.getCopias();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Titulo";
            case 1:
                return "Autor";
            case 2:
                return "Año";
            case 3:
                return "Pais";
            case 4:
                return "Compañia";
            case 5:
                return "Editorial";
            case 6:
                return "Formato";
            case 7:
                return "Copias";
            default:
                throw new AssertionError();
        }
    }

}
