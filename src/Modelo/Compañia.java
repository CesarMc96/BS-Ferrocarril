package Modelo;

public class Compañia {

    private Integer id_compañia;
    private String nombre;

    public Compañia(Integer id_compañia, String nombre) {
        this.id_compañia = id_compañia;
        this.nombre = nombre;
    }

    public Compañia(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_compañia() {
        return id_compañia;
    }

    public void setId_compañia(Integer id_compañia) {
        this.id_compañia = id_compañia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
