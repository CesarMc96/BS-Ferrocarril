package BD;

import Modelo.*;
import java.util.ArrayList;

public class ControladorJuegos {

    private ArrayList<Juego> db;

    public ControladorJuegos(ArrayList<Juego> cargarJuegos) {
        db = cargarJuegos;
    }

    public void agregar(Juego p) {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int juego, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM juegos WHERE id_juegos = " + juego +";");
    }

    public ArrayList<Juego> getDb() {
        return db;
    }

    public void setDb(ArrayList<Juego> db) {
        this.db = db;
    }

    public Juego buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Juego p) {
        db.set(indice, p);
    }

}
