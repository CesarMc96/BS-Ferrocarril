package Modelo;

public class Multimedia {

    private Integer id_multimedia;
    private String titulo;
    private String autor;
    private String anio;
    private Pais pais;
    private Compañia compañia;
    private Editorial editorial;
    private String formato;
    private Integer copias;

    public Multimedia(Integer id_multimedia, String titulo, String autor, String anio, Pais pais, Compañia compañia, Editorial editorial, String formato, Integer copias) {
        this.id_multimedia = id_multimedia;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.pais = pais;
        this.compañia = compañia;
        this.editorial = editorial;
        this.formato = formato;
        this.copias = copias;
    }

    public Multimedia(String titulo, String autor, String anio, Pais pais, Compañia compañia, Editorial editorial, String formato, Integer copias) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.pais = pais;
        this.compañia = compañia;
        this.editorial = editorial;
        this.formato = formato;
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Multimedia{" + "id_multimedia=" + id_multimedia + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", pais=" + pais + ", compa\u00f1ia=" + compañia + ", editorial=" + editorial + ", formato=" + formato + ", copias=" + copias + '}';
    }

    public Integer getId_multimedia() {
        return id_multimedia;
    }

    public void setId_multimedia(Integer id_multimedia) {
        this.id_multimedia = id_multimedia;
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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Compañia getCompañia() {
        return compañia;
    }

    public void setCompañia(Compañia compañia) {
        this.compañia = compañia;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getCopias() {
        return copias;
    }

    public void setCopias(Integer copias) {
        this.copias = copias;
    }

}
