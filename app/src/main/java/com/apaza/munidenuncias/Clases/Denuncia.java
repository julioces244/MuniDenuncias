
package com.apaza.munidenuncias.Clases;



public class Denuncia {

    private Integer id;
    private Integer usuarios_id;
    private String titulo;
    private String comentario;
    private String imagen;

    public Denuncia(Integer id, Integer usuarios_id, String titulo, String comentario, String imagen) {
        this.id = id;
        this.usuarios_id = usuarios_id;
        this.titulo = titulo;
        this.comentario = comentario;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(Integer usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Denuncia{" +
                "id=" + id +
                ", usuarios_id=" + usuarios_id +
                ", titulo='" + titulo + '\'' +
                ", comentario='" + comentario + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
