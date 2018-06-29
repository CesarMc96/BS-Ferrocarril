
package BD;

import Modelo.Autor;
import java.util.*;
import javax.swing.table.*;

public class ModeloAutor extends AbstractTableModel {

    private final ArrayList<Autor> coleccion;

    public ModeloAutor(ArrayList<Autor> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getNombre();
            case 1:
                return temporal.getApellidos();
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
                return "Apellidos";
            default:
                throw new AssertionError();
        }
    }

}
