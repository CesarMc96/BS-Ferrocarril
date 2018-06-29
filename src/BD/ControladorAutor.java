package BD;

import Modelo.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControladorAutor {

    private ArrayList<Autor> db;

    public ControladorAutor(ArrayList<Autor> cargarAutores) {
        db = cargarAutores;
    }

    public void agregar(Autor p) throws IOException {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int autor, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM autor WHERE id_autor = " + autor +";");
    }

    public ArrayList<Autor> getDb() {
        return db;
    }

    public void setDb(ArrayList<Autor> db) {
        this.db = db;
    }

    public Autor buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Autor p) {
        db.set(indice, p);
    }

}
