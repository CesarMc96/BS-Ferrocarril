
package BD;

import Modelo.Prestamo;
import java.util.ArrayList;

public class ControladorPrestamo {
    
    private ArrayList<Prestamo> db;

    public ControladorPrestamo(ArrayList<Prestamo> cargarPrestamos) {
        db = cargarPrestamos;
    }

    public void agregar(Prestamo p) {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int prestamo, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM prestamo WHERE id_prestamo = " + prestamo +";");
    }

    public ArrayList<Prestamo> getDb() {
        return db;
    }

    public void setDb(ArrayList<Prestamo> db) {
        this.db = db;
    }

    public Prestamo buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Prestamo p) {
        db.set(indice, p);
    }
    
}
