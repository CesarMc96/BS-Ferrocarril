package BD;

import Modelo.*;
import java.util.ArrayList;

public class ControladorLibro {

    private ArrayList<Libro> db;

    public ControladorLibro(ArrayList<Libro> cargarLibros) {
        db = cargarLibros;
        System.err.println(db);
    }

    public void agregar(Libro p) {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int Libro, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM libro WHERE id_libro = " + Libro +";");
    }

    public ArrayList<Libro> getDb() {
        return db;
    }

    public void setDb(ArrayList<Libro> db) {
        this.db = db;
    }

    public Libro buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Libro p) {
        db.set(indice, p);
    }

}
