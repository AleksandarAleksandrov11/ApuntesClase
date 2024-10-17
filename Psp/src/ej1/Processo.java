package ej1;

import java.io.IOException;

public class Processo {
    public static void main(String[] args) throws IOException {
          int numero = Integer.parseInt(args[0]);
          int contadorDivisores = 0;

          for (int i = 1; i <= numero; i++) {
              if (numero % i == 0) {
                  contadorDivisores++;
              }
          }
          // Devolver el resultado
          System.out.println(contadorDivisores);
      }
  }


