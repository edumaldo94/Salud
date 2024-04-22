package com.softulp.exploradordefarmacias.ui.listaDeFarmacias;

import java.io.Serializable;

public class Farmacia implements Serializable {
    private String nombre,dirección,horarios;
    private int foto;

    public Farmacia(String nombre, String dirección, String horarios, int foto) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.horarios = horarios;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
