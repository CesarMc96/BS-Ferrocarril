package Modelo;

public class Status {

    private Integer idStatus;
    private String descripcion;

    public Status() {
    }

    public Status(Integer idStatus, String descripcion) {
        this.idStatus = idStatus;
        this.descripcion = descripcion;
    }

    public Status(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Status : " + this.descripcion + ". \n ";
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
