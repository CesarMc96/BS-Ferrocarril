
package Modelo;

public class Juego {
    
    private Integer idJuego;
    private String nombre;
    private Integer cantidad;
    private String piezas;
    private String accesorios;
    private String descripcion;

    public Juego(Integer idJuego, String nombre, Integer cantidad, String piezas, String accesorios, String descripcion) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.piezas = piezas;
        this.accesorios = accesorios;
        this.descripcion = descripcion;
    }

    public Juego(String nombre, Integer cantidad, String piezas, String accesorios, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.piezas = piezas;
        this.accesorios = accesorios;
        this.descripcion = descripcion;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getPiezas() {
        return piezas;
    }

    public void setPiezas(String piezas) {
        this.piezas = piezas;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Juego{" + "idJuego=" + idJuego + ", nombre=" + nombre + ", cantidad=" + cantidad + ", piezas=" + piezas + ", accesorios=" + accesorios + ", descripcion=" + descripcion + '}';
    }
    
    
}
