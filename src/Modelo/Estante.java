package Modelo;

public class Estante {

    private Integer idEstante;
    private Integer estante;
    private String nivel;

    public Estante() {
    }

    public Estante(Integer idEstante, Integer estante, String nivel) {
        this.idEstante = idEstante;
        this.estante = estante;
        this.nivel = nivel;
    }

    public Estante(Integer estante, String nivel) {
        this.estante = estante;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return " Estante : " + this.estante + " - " + this.nivel + ". \n ";
    }

    public Integer getIdEstante() {
        return idEstante;
    }

    public void setIdEstante(Integer idEstante) {
        this.idEstante = idEstante;
    }

    public Integer getEstante() {
        return estante;
    }

    public void setEstante(Integer estante) {
        this.estante = estante;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
