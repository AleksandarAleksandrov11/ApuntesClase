package ej2_2;

import java.io.File;

public class MainHijo1erproceso {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Debe proporcionar una vocal como argumento.");
            return;
        }

        String vocal = args[0];
        File file = new File("fichero.txt");
        ManejarFicheros mf = new ManejarFicheros(vocal, file);
        mf.readfile();
    }
}
