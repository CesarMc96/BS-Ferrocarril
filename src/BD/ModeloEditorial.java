
package BD;

import Modelo.Editorial;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloEditorial extends  AbstractTableModel {
    
    
    private final ArrayList<Editorial> coleccion;

    public ModeloEditorial(ArrayList<Editorial> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Editorial temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getNombre();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Editorial";
            default:
                throw new AssertionError();
        }
    }
    
}
