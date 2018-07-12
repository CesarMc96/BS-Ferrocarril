
package BD;

import Modelo.Prestamo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloPrestamos extends AbstractTableModel {
    
     private final ArrayList<Prestamo> coleccion;
     
     
    public ModeloPrestamos(ArrayList<Prestamo> arreglo) {
        coleccion = arreglo;
    }

    @Override
    public int getRowCount() {
        return coleccion.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prestamo temporal = coleccion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return temporal.getFechaPrestamo();
            case 1:
                return temporal.getFechaDevolucion();
            case 2:
                return temporal.getNumeroRenovacion();
            case 3:
                return temporal.getNombreUsuario();
            case 4:
                return temporal.getNumCredencial();
            case 5:
                return temporal.getTitulo();
            case 6:
                return temporal.getAutor();
            case 7:
                return temporal.getEditorial();
            case 8:
                return temporal.getObservaciones();
            case 9:
                return temporal.getAccion();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Fecha Prestamo";
            case 1:
                return "Fecha Devolucion";
            case 2:
                return "Numero Renovacion";
            case 3:
                return "Usuario";
            case 4:
                return "Numero Credencial";
            case 5 :
                return "Libro";
            case 6 :
                return "Autor";
            case 7 :
                return "Editorial";
            case 8 :
                return "Observaciones";
            case 9 :
                return "Acciones";
            default:
                throw new AssertionError();
        }
    }
    
}
