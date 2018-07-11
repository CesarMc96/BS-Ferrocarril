
package BD;

import DAO.DAOReporteImpl;
import Modelo.Autor;
import Modelo.Libro;
import Modelo.Reporte;
import java.util.ArrayList;

public class ControladorReporte {
    
    private ArrayList<Reporte> db;
    private DAOReporteImpl daoReporte;

    public ControladorReporte() {
        
        db = new ArrayList<>();
        daoReporte = new DAOReporteImpl();
        
    }
    
     public ControladorReporte(ArrayList<Reporte> cargarReporte) {
        db = cargarReporte;
    }

    public void agregar(Reporte p) {
        db.add(p);
    }

    public void guardar() {

    }

    public void eliminar(int reporte, int row) {
        db.remove(row);
        DataSourcePostgreSQL dws = new DataSourcePostgreSQL();
        dws.ejecutarActualizacion("DELETE FROM reporte WHERE id_reporte = " + reporte +";");
    }

    public ArrayList<Reporte> getDb() {
        return db;
    }

    public void setDb(ArrayList<Reporte> db) {
        this.db = db;
    }

    public Reporte buscar(int indice) {
        return db.get(indice);
    }

    public void modificar(int indice, Reporte p) {
        db.set(indice, p);
    }
}
