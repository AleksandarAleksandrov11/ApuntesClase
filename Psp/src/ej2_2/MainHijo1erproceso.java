package ej2_2;

import java.io.File;

public class MainHijo1erproceso {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Debe proporcionar una vocal y un archivo para escribir como argumento.");
            return;
        }

        String vocal = args[0];
        File file = new File(args[1]); // El archivo donde se escribirá el resultado
        ManejarFicheros mf = new ManejarFicheros(vocal, file);
        mf.countAndWriteVowel(); // Contar la vocal y escribir el resultado
    }
}
