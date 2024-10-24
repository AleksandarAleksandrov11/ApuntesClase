package proyecto_PspApuntes;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
    	//le paso por argumentos la ruta del .java y la ruta de donde queremos que vaya el .class
        if (args.length < 2) {
            System.out.println("Uso: java Compilador <ruta_del_archivo_java> <ruta_destino>");
            return;
        }
        //le asigno los valores que le paso por argumentos
        String javaFilePath = args[0];
        String destinationPath = args[1];
        /*
        El javaCompiler es una clase que simula la compialcion que se haria por cosnola/cmd,
        transforma .javas en .class
        -----------------------------------------------------------------------------------
        ToolProvider es una clase que proporciona acceso a herramientas del sistema, como el compilador.
        -----------------------------------------------------------------------------------
       	getSystemJavaCompiler() es un método estático de ToolProvider que devuelve una instancia del compilador de Java del sistema.
        Te devuelve un objeto para compilar codigo java, si no hay JDK devuelve null 
        -----------------------------------------------------------------------------------
        La variable se inicializa con el resultado de ToolProvider.getSystemJavaCompiler(), 
        lo que significa que compiler ahora contiene una referencia al compilador de Java.
        //////////////////////////////////////////////////////////////////////////////////
        									RESUMEN
        //////////////////////////////////////////////////////////////////////////////////
        La línea completa crea una variable llamada compiler que contiene una instancia del compilador de Java chupando
        a través de ToolProvider. 
        Y el objeto compiler se puede utilizar más adelante para compilar archivos .java.
        */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /*
        La variable compilationResult guarda el resultado de la compilación mediante un 0 si la compilación ha ido bien,
        y si no se guarda otro valor.
        ----------------------------------------------------------------------------------------------------------------
        (Ale卍KS Maricon)
       	==========================================AVISO DE YAPING==========================================
        La función run es un metodo del objeto compiler que lo que hace es poner en ejecución la compilación,
        tiene cuatro parámetros, todos opcionales:
		Primer (null): es un objeto Writer que se utiliza para redirigir la salida estándar del compilador. 
		Al pasar null, la salida del compilador se pasa por consola.
		Si quieres pillar la salida en un archivo o un buffer, le pasas la variable correspondiente ej: File("caca.txt").
		--------------------------------------------------------------------------------------------------------------- 
		Segundo (null):	Igual que el primero,es un objeto Writer para los errores de compilación.
		al pasar null, los mensajes de error se pasan por consola. Si quieres pillar la salida de los errores en otro lugar (como un archivo), le pasas un Writer específico.
		---------------------------------------------------------------------------------------------------------------
		Tercer (null): Este parámetro es para opciones adicionales de compilación. 
		para especificar opciones como la versión del JDK a utilizar, rutas de clase, etc. Al usar null, se utilizarán las opciones predeterminadas.
		---------------------------------------------------------------------------------------------------------------
		(javaFilePath): es el String que contiene la ruta del archivo .java que se va a compilar. 
		Es el único parámetro que no es null y es obliohatorio para el proceso de compilación.
        */
        int compilationResult = compiler.run(null, null, null, javaFilePath);

        if (compilationResult == 0) {
            System.out.println("Todo bien mi rey.");

            // Obtener el nombre del archivo .class
            String classFilePath = javaFilePath.replace(".java", ".class");
            File classFile = new File(classFilePath);

            // Copiar el archivo .class a la ubicación destino
            try {
                Path destination = Path.of(destinationPath, classFile.getName());
                Files.copy(classFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Archivo .class copiado a: " + destination);
            } catch (IOException e) {
                System.out.println("Error al copiar el archivo .class: " + e.getMessage());
            }
        } else {
            System.out.println("Error en la compilación.");
        }
    }
}
