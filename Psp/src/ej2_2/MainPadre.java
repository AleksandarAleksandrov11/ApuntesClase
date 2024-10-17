package ej2_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainPadre {
	
    // Método para leer el resultado desde el archivo generado por cada proceso hijo
    public static int leerResultado(File archivo) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Extraer el número del mensaje
                String[] partes = line.split(" ");
                count += Integer.parseInt(partes[4]); // El número está en la posición 4 ("La vocal '" + chosencharacter + "' aparece " + count + " veces.")
                //La vocal 'a' aparece 10 veces.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        // Lista de vocales que vamos a procesar
        String[] vocales = {"a", "e", "i", "o", "u"};
        List<Process> procesos = new ArrayList<>();
        List<File> archivosResultados = new ArrayList<>();

        // Crear y lanzar los procesos hijos
        for (String vocal : vocales) {
            try {
                // Crear un archivo temporal para cada vocal
                File archivoResultado = new File(vocal + "_resultado.txt");
                archivosResultados.add(archivoResultado);

                // Crear el proceso hijo con vocal y archivo de salida
                ProcessBuilder pb = new ProcessBuilder("java", "ej2_2.MainHijo1erproceso", vocal, archivoResultado.getAbsolutePath());
                Process proceso = pb.start();
                
                // Añadir el proceso a la lista
                procesos.add(proceso);
                System.out.println("Lanzado proceso para vocal: " + vocal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Esperar a que todos los procesos hijos terminen
        for (Process proceso : procesos) {
            try {
                proceso.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Leer los archivos temporales para sumar los resultados
        int totalVocales = 0;
        for (File archivo : archivosResultados) {
            totalVocales += leerResultado(archivo);
        }

        // Mostrar el total de vocales encontradas
        System.out.println("Total de vocales encontradas: " + totalVocales);
    }


}
