package Modelo;

public class Editorial {

    private Integer idEditorial;
    private String nombre;

    public Editorial() {
    }

    public Editorial(Integer idEditorial, String nombre) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Editorial : " + this.nombre + ". \n ";
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
