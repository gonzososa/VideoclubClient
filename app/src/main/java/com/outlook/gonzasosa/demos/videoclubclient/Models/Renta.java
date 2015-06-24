package com.outlook.gonzasosa.demos.videoclubclient.Models;

public class Renta {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(int idTitulo) {
        this.idTitulo = idTitulo;
    }

    public int getIdRecargo() {
        return idRecargo;
    }

    public void setIdRecargo(int idRecargo) {
        this.idRecargo = idRecargo;
    }

    private int id;
    private int idCliente;
    private int idTitulo;
    private int idRecargo;
}
