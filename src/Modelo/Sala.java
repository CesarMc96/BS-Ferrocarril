package Modelo;

public class Sala {

    private Integer idSala;
    private String descripcion;

    public Sala(Integer idSala, String descripcion) {
        this.idSala = idSala;
        this.descripcion = descripcion;
    }

    public Sala(Integer idSala) {
        if (idSala == 1) {
            this.descripcion = "Infantil";
        } else if (idSala == 2) {
            this.descripcion = "Juvenil";
        } else if (idSala == 3) {
            this.descripcion = "Bebeteca";
        }
    }

    public Sala(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return " Sala : " + this.descripcion + ". \n ";
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
