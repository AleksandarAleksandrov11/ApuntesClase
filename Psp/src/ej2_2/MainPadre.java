package ej2_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPadre {

    public static void main(String[] args) {
        // Lista de caracteres (vocales) que vamos a procesar
        String[] vocales = {"a", "e", "i", "o", "u"};
        
        // Lista para almacenar los procesos
        List<Process> procesos = new ArrayList<>();
        
        // Crear y lanzar los procesos hijos
        for (String vocal : vocales) {
            try {
                // Crear un nuevo proceso con ProcessBuilder
                ProcessBuilder pb = new ProcessBuilder("java", "ej2_2.MainHijo1erproceso", vocal);
                Process proceso = pb.start();
                
                // Añadir el proceso a la lista para su gestión
                procesos.add(proceso);
                System.out.println("Lanzado proceso para vocal: " + vocal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Esperar a que todos los procesos terminen
        for (Process proceso : procesos) {
            try {
                proceso.waitFor();  // Espera a que termine el proceso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Todos los procesos han terminado.");
    }
}
