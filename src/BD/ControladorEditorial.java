package BD;

import Modelo.*;
import java.util.ArrayList;

public class ControladorEditorial {

    private ArrayList<Editorial> db;

    public ControladorEditorial(ArrayList<Editorial> cargarEditorial) {
        db = cargarEditorial;
    }

    public void agregar(Editorial p)  {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int Editorial, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM editorial WHERE id_editorial = " + Editorial +";");
    }

    public ArrayList<Editorial> getDb() {
        return db;
    }

    public void setDb(ArrayList<Editorial> db) {
        this.db = db;
    }

    public Editorial buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Editorial p) {
        db.set(indice, p);
    }

}
