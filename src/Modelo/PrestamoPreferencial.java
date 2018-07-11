
package Modelo;

import java.sql.Date;

public class PrestamoPreferencial {

    private Integer idPrestamo;
    private Libro libro;
    private Integer numPrestamo;
    private Date fechaPrestaomo;

    public PrestamoPreferencial() {
    }

    public PrestamoPreferencial(Integer idPrestamo, Libro libro, Integer numPrestamo, Date fechaPrestaomo) {

        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.numPrestamo = numPrestamo;
        this.fechaPrestaomo = fechaPrestaomo;
    }

    public PrestamoPreferencial(Libro libro, Integer numPrestamo, Date fechaPrestaomo) {

        this.libro = libro;
        this.numPrestamo = numPrestamo;
        this.fechaPrestaomo = fechaPrestaomo;
    }

    @Override
    public String toString() {
        return "Libro : " + this.libro + ". Numero de Prestamo : " + this.numPrestamo + ". Fecha del Prestamo : " + this.fechaPrestaomo + ". \n ";
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getNumPrestamo() {
        return numPrestamo;
    }

    public void setNumPrestamo(Integer numPrestamo) {
        this.numPrestamo = numPrestamo;
    }

    public Date getFechaPrestaomo() {
        return fechaPrestaomo;
    }

    public void setFechaPrestaomo(Date fechaPrestaomo) {
        this.fechaPrestaomo = fechaPrestaomo;
    }
    
}
