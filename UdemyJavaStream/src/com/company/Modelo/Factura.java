package com.company.Modelo;

public class Factura {

    private String descripsion;
    private Usuario usuario;

    public Factura(String descripsion) {
        this.descripsion = descripsion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripsion() {
        return descripsion;
    }

    public void setDescripsion(String descripsion) {
        this.descripsion = descripsion;
    }
}
