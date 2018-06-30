package BD;

import Modelo.*;
import java.util.ArrayList;

public class ControladorUsuario {

    private ArrayList<Usuario> db;

    public ControladorUsuario(ArrayList<Usuario> cargarUsuario) {
        db = cargarUsuario;
    }

    public void agregar(Usuario p) {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int Usuario, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM usuario WHERE id_usuario = " + Usuario +";");
    }

    public ArrayList<Usuario> getDb() {
        return db;
    }

    public void setDb(ArrayList<Usuario> db) {
        this.db = db;
    }

    public Usuario buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Usuario p) {
        db.set(indice, p);
    }

}
