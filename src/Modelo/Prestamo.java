package Modelo;

import java.sql.Date;

public class Prestamo {

    private Integer idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Integer numeroRenovacion;
    private String titulo;
    private String autor;
    private String editorial;
    private String nombreUsuario;
    private String numCredencial;
    private String observaciones;
    private String accion;

    public Prestamo(Integer idPrestamo, Date fechaPrestamo, Date fechaDevolucion, Integer numeroRenovacion, String titulo, String autor, String editorial, String nombreUsuario, String numCredencial, String observaciones, String accion) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.numeroRenovacion = numeroRenovacion;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.nombreUsuario = nombreUsuario;
        this.numCredencial = numCredencial;
        this.observaciones = observaciones;
        this.accion = accion;
    }

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Integer numeroRenovacion, String titulo, String autor, String editorial, String nombreUsuario, String numCredencial, String observaciones, String accion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.numeroRenovacion = numeroRenovacion;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.nombreUsuario = nombreUsuario;
        this.numCredencial = numCredencial;
        this.observaciones = observaciones;
        this.accion = accion;
    }

    public Prestamo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return " Prestamo : " + " Fecha Prestamo : " + this.fechaPrestamo + ". Numero de Renovacion : " + this.numeroRenovacion
                + ". Titulo : " + this.titulo + ". Autor : " + this.autor + ". Editorial : " + this.editorial + ". Usuario : "
                + this.nombreUsuario + ". Numero de Credencial : " + this.numCredencial + ". Observaciones : " + this.observaciones
                + ". Accion : " + this.accion + ". \n ";
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getNumeroRenovacion() {
        return numeroRenovacion;
    }

    public void setNumeroRenovacion(Integer numeroRenovacion) {
        this.numeroRenovacion = numeroRenovacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNumCredencial() {
        return numCredencial;
    }

    public void setNumCredencial(String numCredencial) {
        this.numCredencial = numCredencial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
