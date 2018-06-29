package Modelo;

import java.sql.Date;

public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String numCredencial;
    private String direccion;
    private String telefono;
    private String correo;
    private Date fechaAlta;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String apPaterno, String apMaterno, String numCredencial, String direccion, String telefono, String correo, Date fechaAlta) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.numCredencial = numCredencial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
    }

    public Usuario(String nombre, String apPaterno, String apMaterno, String numCredencial, String direccion, String telefono, String correo, Date fechaAlta) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.numCredencial = numCredencial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return " Usuario : " + this.nombre + " " + this.apPaterno + " " + this.apMaterno
                + ". Numero de Credencial : " + this.numCredencial + ". Direccion : " + this.direccion
                + ". Telefono : " + this.telefono + " e-mail : " + this.correo + ". \n ";
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNumCredencial() {
        return numCredencial;
    }

    public void setNumCredencial(String numCredencial) {
        this.numCredencial = numCredencial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
