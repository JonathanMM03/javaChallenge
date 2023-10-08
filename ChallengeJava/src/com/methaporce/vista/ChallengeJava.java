/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.methaporce.vista;

import com.methaporce.modelo.Gestor;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jonat
 */
public class ChallengeJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Configurar la codificación de caracteres UTF-8
        System.setProperty("file.encoding", "UTF-8");
        // Para ingresar los datos usaremos Scanner
        Scanner sc = new Scanner(System.in);

        // Agregamos un objeto Gestor para consumir los métodos
        Gestor g = new Gestor();
        
        // Agregamos peliculas por defecto
        g.agregarPelicula("John Wick");
        g.agregarPelicula("Harry Potter");

        String menu = """
                  1. Agregar película
                  2. Eliminar película
                  3. Listar películas
                  4. Listar películas disponibles
                  5. Listar películas no disponibles
                  6. Rentar película
                  7. Devolver película
                  8. Salir
                  """;
        byte opcion = 0;

        do {
            opcion = Byte.parseByte(JOptionPane.showInputDialog(null,menu));
            switch (opcion) {
                case 1:
                    // Opción para registrar una película con su nombre
                    String titulo = JOptionPane.showInputDialog(null,"Nombre de la película","Datos de la pelicula",JOptionPane.INFORMATION_MESSAGE);
                    g.agregarPelicula(titulo);
                    break;
                case 2:
                    // Opción para eliminar una película con su nombre
                    String titulo1 = JOptionPane.showInputDialog(null,"Nombre de la película a eliminar","Datos de la pelicula",JOptionPane.INFORMATION_MESSAGE);
                    g.eliminarPelicula(titulo1);
                    break;
                case 3:
                    // Opción para listar las películas
                    g.registroPeliculas();
                    break;
                case 4:
                    // Opción para listar las películas disponibles
                    g.registroPeliculasDisponibles();
                    break;
                case 5:
                    // Opción para listar las películas no disponibles
                    g.registroPeliculasNoDisponibles();
                    break;
                case 6:
                    // Mostramos las películas disponibles
                    g.registroPeliculasDisponibles();
                    // Preguntamos cuál quiere rentar
                    int noPelicula = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Qué película le gustaría rentar?"));
                    g.rentarPelicula(noPelicula);
                    break;
                case 7:
                    // Mostramos las películas no disponibles
                    g.registroPeliculasNoDisponibles();
                    // Preguntamos cuál quiere rentar
                    int opcion1 = Integer.parseInt(JOptionPane.showInputDialog("¿Qué película devolverá?"));
                    g.marcarPeliculaComoDisponible(opcion1);
                    break;
                case 8:
                    System.out.println("Está saliendo de la renta de películas");
                    break;
                default:
                    System.err.println("Error, opción no disponible, seleccione una opción válida");
            }
        } while (opcion != 8);
    }
}
