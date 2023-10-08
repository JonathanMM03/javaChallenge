/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.methaporce.modelo;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author jonat
 */
public class Gestor {

    private LinkedList<Pelicula> peliculas = new LinkedList<>();

    public LinkedList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(LinkedList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    /**
     * Metodo para agregar pelicula al LinkedList peliculas
     *
     * @param titulo
     */
    public void agregarPelicula(String titulo) {
        Pelicula p = new Pelicula(titulo);
        peliculas.push(p);
        JOptionPane.showMessageDialog(null, String.format("Pelicula %d %s fue registrado con éxito", p.getId(), p.getNombre()), "Pelicula registrada con exito", INFORMATION_MESSAGE);
    }

    /**
     * Método para eliminar película usando el título de la película
     *
     * @param titulo Título de la película
     */
    public void eliminarPelicula(String titulo) {
        // Verifica si la lista de películas no está vacía
        if (!peliculas.isEmpty()) {
            // Recorre todas las películas en la lista
            for (int i = 0; i < peliculas.size(); i++) {
                Pelicula p = peliculas.get(i);
                // Comprueba si el título de la película coincide
                if (titulo.equals(p.getNombre())) {
                    // Muestra un mensaje de éxito
                    JOptionPane.showMessageDialog(null, String.format("Película %d %s fue eliminada con éxito", p.getId(), p.getNombre()), "Película eliminada con éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Elimina la película de la lista
                    peliculas.remove(i);
                    break; // Sale del bucle después de eliminar la película
                }
            }
        } else {
            // Muestra un mensaje de error si no hay películas disponibles
            JOptionPane.showMessageDialog(null, "No hay películas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para mostrar todas las peliculas
     */
    public void registroPeliculas() {
        String msg = "";
        for (Pelicula p : peliculas) {
            msg += String.format("\nPelicula %d %s %b", p.getId(), p.getNombre(), p.isDisponibilidad());
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    /**
     * Metodo para mostrar todas las peliculas disponibles
     */
    public void registroPeliculasDisponibles() {
        String msg = "";
        if (!peliculas.isEmpty()) {
            for (Pelicula p : peliculas) {
                if (p.isDisponibilidad() == true) {
                    msg += String.format("\nPelicula %d %s %b", p.getId(), p.getNombre(), p.isDisponibilidad());
                }
            }
            JOptionPane.showMessageDialog(null, msg, "Lista de peliculas", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay peliculas disponibles", "Lista de peliculas", INFORMATION_MESSAGE);
        }
    }

    /**
     * Método para mostrar todas las películas no disponibles
     */
    public void registroPeliculasNoDisponibles() {
        String msg = "";
        if (!peliculas.isEmpty()) {
            for (Pelicula p : peliculas) {
                if (!p.isDisponibilidad()) {
                    msg += String.format("\nPelícula %d %s %b", p.getId(), p.getNombre(), p.isDisponibilidad());
                }
            }
        }

        if (!msg.isEmpty()) {
            JOptionPane.showMessageDialog(null, msg, "Lista de películas no disponibles", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todas las películas están disponibles", "Lista de películas no disponibles", INFORMATION_MESSAGE);
        }
    }

    /**
     * Metodo que permite marcar como disponible una pelicula por su id
     *
     * @param id ID de la pelicula
     */
    public void marcarPeliculaComoDisponible(int id) {
        Pelicula p = new Pelicula();
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                p = peliculas.get(i);
                p.setDisponibilidad(true);
                break;
            }
        }

        // En caso de que no exita la pelicula
        if (p != null) {
            p.setDisponibilidad(true);
        } else {
            JOptionPane.showMessageDialog(null, String.format("La película con el ID %d no existe.", id, "Pelicula no encontrada", JOptionPane.ERROR_MESSAGE));
        }
    }

    /**
     * Método que permite rentar una película por ID
     *
     * @param id ID de la película
     */
    public void rentarPelicula(int id) {
        Pelicula p = null; // Inicializamos p como null
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                p = peliculas.get(i);
                break; // Salimos del bucle cuando encontramos la película
            }
        }

        // Verificamos si encontramos la película por ID
        if (p != null) {
            if (p.isDisponibilidad()) {
                p.setDisponibilidad(false); // Marcamos la película como no disponible
                JOptionPane.showMessageDialog(null, String.format("Película con ID %d rentada con éxito.", id), "Película rentada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, String.format("La película con ID %d ya está rentada.", id), "Película no disponible", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, String.format("La película con el ID %d no existe.", id), "Película no encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
