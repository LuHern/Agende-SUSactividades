package com.example.agendesusactividades.entidades;

public class Actividades {

    private String nombre;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_culminacion;
    private String usuario_encargado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_culminacion() {
        return fecha_culminacion;
    }

    public void setFecha_culminacion(String fecha_culminacion) {
        this.fecha_culminacion = fecha_culminacion;
    }

    public String getUsuario_encargado() {
        return usuario_encargado;
    }

    public void setUsuario_encargado(String usuario_encargado) {
        this.usuario_encargado = usuario_encargado;
    }
}
