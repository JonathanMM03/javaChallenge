/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.methaporce.modelo;

/**
 *
 * @author jonat
 */
public class Pelicula {
    private static int n=0;
    private int id;
    private String nombre;
    private boolean disponibilidad;

    public Pelicula() {
        this.id = n++;
    }

    public Pelicula(String nombre) {
        this.id = n++;
        this.nombre = nombre;
        this.disponibilidad = true;
    }

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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", disponibilidad=" + disponibilidad + '}';
    }
}
