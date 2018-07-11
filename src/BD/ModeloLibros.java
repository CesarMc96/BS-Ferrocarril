
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
                return "Folio";
            case 1:
                return "Titulo";
            case 2:
                return "Autor";
            case 3:
                return "ISBN";
            case 4:
                return "Editorial";
            case 5 :
                return "Año";
            case 6 :
                return "Pais";
            case 7 :
                return "Estante";
            case 8 :
                return "Sala";
            case 9 :
                return "Descripcion";
            case 10 :
                return "Status";
            default:
                throw new AssertionError();
        }
    }

}
