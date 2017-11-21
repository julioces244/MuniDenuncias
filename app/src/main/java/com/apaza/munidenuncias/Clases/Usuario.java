package com.apaza.munidenuncias.Clases;

/**
 * Created by Julio Cesar on 15/11/2017.
 */

public class Usuario {

    private Integer id;
    private String username;
    private String password;
    private String nombres;
    private String correo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nombres='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    public Usuario(Integer id, String username, String password, String nombres, String correo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombres = nombres;
        this.correo = correo;



    }
}
