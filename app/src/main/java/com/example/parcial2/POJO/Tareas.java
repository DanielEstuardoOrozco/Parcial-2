package com.example.parcial2.POJO;

public class Tareas {
    private int id, estado;
    private String descripcion, fecha;

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public int getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }
}
