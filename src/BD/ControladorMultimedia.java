package BD;

import Modelo.*;
import java.util.ArrayList;

public class ControladorMultimedia {

    private ArrayList<Multimedia> db;

    public ControladorMultimedia(ArrayList<Multimedia> cargarMultimedia) {
        db = cargarMultimedia;
    }

    public void agregar(Multimedia p) {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int Multimedia, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM multimedia WHERE id_multimedia = " + Multimedia +";");
    }

    public ArrayList<Multimedia> getDb() {
        return db;
    }

    public void setDb(ArrayList<Multimedia> db) {
        this.db = db;
    }

    public Multimedia buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Multimedia p) {
        db.set(indice, p);
    }

}
