
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Reporte implements Serializable {
    
    private Integer idReporte;
    private Integer numLibrosPrestados;
    private Autor autorMasSolicitado;
    private Libro libroMasPrestado;
    private Integer[] numLibrosDisponibles;
    private Integer numLibrosAgregados;
    private ArrayList<Libro> librosAgregados;
    
    public Reporte() {
		
	}

    public Reporte(Integer idReporte, Integer numLibrosPrestados, Autor autorMasSolicitado, Libro libroMasPrestado,
            Integer[] numLibrosDisponibles, Integer numLibrosAgregados) {

        this.idReporte = idReporte;
        this.numLibrosPrestados = numLibrosPrestados;
        this.autorMasSolicitado = autorMasSolicitado;
        this.libroMasPrestado = libroMasPrestado;
        this.numLibrosDisponibles = numLibrosDisponibles;
        this.numLibrosAgregados = numLibrosAgregados;
    }

    public Reporte(Integer numLibrosPrestados, Autor autorMasSolicitado, Libro libroMasPrestado,
            Integer[] numLibrosDisponibles, Integer numLibrosAgregados, ArrayList<Libro> librosAgregados) {
        super();
        this.numLibrosPrestados = numLibrosPrestados;
        this.autorMasSolicitado = autorMasSolicitado;
        this.libroMasPrestado = libroMasPrestado;
        this.numLibrosDisponibles = numLibrosDisponibles;
        this.numLibrosAgregados = numLibrosAgregados;
        this.librosAgregados = librosAgregados;
    }

    @Override
    public String toString() {
        return " Reporte : " + " Numero de Libros Prestados : " + this.numLibrosPrestados + ". "
                + "Autor Mas Solicitado : " + this.autorMasSolicitado + ". "
                + "Libro Mas Prestado : " + this.libroMasPrestado + ". \n\n"
                + "Numero de Libros Disponibles : " + this.numLibrosDisponibles[0] + ". "
                + "Numero de Libros No Disponibles : " + this.numLibrosDisponibles[1] + ". "
                + "Numero de Libros Agregados : " + this.numLibrosAgregados + ". \n\n "
                + "Lista de Libros Agregados : \n\n " + this.librosAgregados + ". \n ";
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Integer getNumLibrosPrestados() {
        return numLibrosPrestados;
    }

    public void setNumLibrosPrestados(Integer numLibrosPrestados) {
        this.numLibrosPrestados = numLibrosPrestados;
    }

    public Autor getAutorMasSolicitado() {
        return autorMasSolicitado;
    }

    public void setAutorMasSolicitado(Autor autorMasSolicitado) {
        this.autorMasSolicitado = autorMasSolicitado;
    }

    public Libro getLibroMasPrestado() {
        return libroMasPrestado;
    }

    public void setLibroMasPrestado(Libro libroMasPrestado) {
        this.libroMasPrestado = libroMasPrestado;
    }

    public Integer[] getNumLibrosDisponibles() {
        return numLibrosDisponibles;
    }

    public void setNumLibrosDisponibles(Integer[] numLibrosDisponibles) {
        this.numLibrosDisponibles = numLibrosDisponibles;
    }

    public Integer getNumLibrosAgregados() {
        return numLibrosAgregados;
    }

    public void setNumLibrosAgregados(Integer numLibrosAgregados) {
        this.numLibrosAgregados = numLibrosAgregados;
    }

    public ArrayList<Libro> getLibrosAgregados() {
        return librosAgregados;
    }

    public void setLibrosAgregados(ArrayList<Libro> librosAgregados) {
        this.librosAgregados = librosAgregados;
    }

}
