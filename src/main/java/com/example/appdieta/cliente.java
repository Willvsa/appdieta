package com.example.appdieta;

import javafx.event.ActionEvent;

public class cliente {
    private int id;
    private String nombre;
    private int edad;
    private float peso;
    private float altura;

    // Constructor
    public cliente(int id, String nombre, int edad, float peso, float altura) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void guardarDatos(ActionEvent actionEvent) {
    }
}

