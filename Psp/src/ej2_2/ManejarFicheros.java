package ej2_2;

import java.io.*;

public class ManejarFicheros {
    private static final File usedfiletoread = new File("fichero.txt");
    private String chosencharacter;
    private File usedfiletowrite;
    private static FileReader conexion;
    private static BufferedReader read;
    private static String line;
    private static FileWriter conexionwrite;
    private static BufferedWriter write;

    public ManejarFicheros(String chosencharacter, File usedfiletowrite) {
        this.chosencharacter = chosencharacter;
        this.usedfiletowrite = usedfiletowrite;
    }

    // Método para contar las vocales y escribir el resultado en un archivo
    public void countAndWriteVowel() {
        int count = 0; // Contador de cuántas veces aparece la vocal
        try {
            conexion = new FileReader(usedfiletoread);
            read = new BufferedReader(conexion);
            
            while ((line = read.readLine()) != null) {
                // Contamos apariciones de la vocal, tanto mayúscula como minúscula
                for (char c : line.toCharArray()) {
                    if (String.valueOf(c).equalsIgnoreCase(chosencharacter)) {
                        count++;
                    }
                }
            }

            // Escribimos el resultado en el archivo correspondiente
            writeToFile(count);

            closereadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escribir en el archivo el conteo de la vocal
    public void writeToFile(int count) {
        try {
            conexionwrite = new FileWriter(usedfiletowrite);
            write = new BufferedWriter(conexionwrite);
            write.write("La vocal '" + chosencharacter + "' aparece " + count + " veces.");
            write.newLine();
            closewriteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cerrar archivo de lectura
    public void closereadFile() {
        try {
            if (read != null) {
                read.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cerrar archivo de escritura
    public void closewriteFile() {
        try {
            if (write != null) {
                write.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
