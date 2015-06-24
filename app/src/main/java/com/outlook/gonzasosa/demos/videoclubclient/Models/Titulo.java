package com.outlook.gonzasosa.demos.videoclubclient.Models;


public class Titulo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int id_genero) {
        this.idGenero = id_genero;
    }

    private int id;
    private String titulo;
    private int idGenero;
}
