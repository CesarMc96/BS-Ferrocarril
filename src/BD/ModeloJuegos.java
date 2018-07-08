
package BD;

import Modelo.Juego;
import java.util.*;
import javax.swing.table.*;

public class ModeloJuegos extends AbstractTableModel {

    private final ArrayList<Juego> coleccion;

    public ModeloJuegos(ArrayList<Juego> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Juego temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getNombre();
            case 1:
                return temporal.getCantidad();
            case 2:
                return temporal.getPiezas();
            case 3:
                return temporal.getAccesorios();
            case 4:
                return temporal.getDescripcion();
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
                return "Cantidad";
            case 2:
                return "Piezas";
            case 3:
                return "Accesorios";
            case 4:
                return "Descripcion";
            default:
                throw new AssertionError();
        }
    }

}
