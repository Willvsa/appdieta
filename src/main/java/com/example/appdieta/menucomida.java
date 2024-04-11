package com.example.appdieta;

public class menucomida {
    private int id;
    private String nombre;
    private String descripcion;
    private String objetivo; // Puede ser 'perder_peso' o 'aumentar_peso'


    public menucomida(int id, String nombre, String descripcion, String objetivo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}

