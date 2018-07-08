package Modelo;

public class Acciones {

    private Integer id_acciones;
    private String descripcion;

    public Acciones(Integer id_acciones, String descripcion) {
        this.id_acciones = id_acciones;
        this.descripcion = descripcion;
    }

    public Integer getId_acciones() {
        return id_acciones;
    }

    public void setId_acciones(Integer id_acciones) {
        this.id_acciones = id_acciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Acciones{" + "id_acciones=" + id_acciones + ", descripcion=" + descripcion + '}';
    }

}
