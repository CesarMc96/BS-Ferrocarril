package Modelo;

public class Pais {

    private Integer idPais;
    private String nombre;

    public Pais(Integer idPais, String nombre) {
        this.idPais = idPais;
        this.nombre = nombre;
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return " Pais : " + this.nombre + ". \n ";
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
