package gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class ChuparDeUnArchivo {		
	/*
	  {
  		"nombre": "Inludify",
  		"fundado": 2021,
  		"equipo": [
    		{
      		  "nombre": "Juan",
      		  "edad": 30,
      		  "rol": "Desarrollador",
      		  "activo": true
    		},
    		{
      		  "nombre": "Marta",
      		  "edad": 27,
      		  "rol": "Diseñadora",
     		  "activo": false
    		}
  		  ],
  	"is_startup": true,
  	"presupuesto": null,
  	"datos": {
    	"numeros": [1, 2.5, 3, 4.7	5],
    	"cadenas": ["uno", "dos", "tres"],
    	"mixto": [1, "dos", true, null],
    	"anidado": {
      		"nivel1": {
        		"nivel2": {
          			"clave": "valor"
        		}
      		}
    	}
  	}
}
	 
	*/
	public static void main(String[] args) {
		Gson gson = new Gson();
		/*
		Creamos un reader para poder leer el archivo json, en este caso no hace falta declarar el File,
		lo meto directamente en el try para que se maneje la excepcion en funcion  de la lectura, pero se puede
		perfectamnte poner como la primera linea.
		*/
		try (FileReader reader = new FileReader("ejemplo.json")) {
			 /*
			 JsonObject es una clase en la biblioteca Gson que representa un objeto JSON en Java, lo que nos sirve para poder manejar
			 los objetos como calve valor.
			 
			 JsonParser es una clase de Gson que permite parsear
			 texto en formato JSON a objetos de Gson (como JsonObject, JsonArray, etc.).
			  
			 parseReader(): Este método lee un flujo de entrada (como el de un archivo o una cadena de caracteres) 
			 y lo convierte en un elemento JSON de Gson.
			 LO QUE ES NUY IMPORTANTE SOBRE EL PARSEREADER(), es que te devuelve un elemento json generico.
			 
			 getAsJsonObject(): Convierte el resultado de parseReader(reader), que inicialmente es un JsonElement, en un JsonObject,
			 como he dicho antes, el parseReader() te devuelve un  tipo geneerico, este metodo lo que hace es declararlo como objeto de Json.
			 
			 de tal modo que haciendo esta linea conseguimos poder interpretar cada elemento de un json como un jasonobject que luego vamos
			 a poder manipular.
			 */					
			JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

			/*
			---------------------------------------------------------------------------------- 
			  
			 									IMPORTANTE
			 
			----------------------------------------------------------------------------------
			La estructura con la que se trabaja en gson es con el JsonObject.
			Y este se puede manipular de varias maneras, Las principales son:
			
			EL jsonObject.get, que basicamnete chupa el elemento que coincida con el valor que le pases,
			en este caso "nombre".
			Siempre que se hace un jsonObject.get(), luego se le tiene que aclarar como se va a querer guardar,
			en este caso lo queremos guardar como String, por ende utilizamos el metodo:
			###################
			# getAss ( ͡° ͜ʖ ͡°) #
			###################
			el metodo getAss aclara de que manera vamos a quere interpretar ese tipo de dato, y esto se hace
			con todos los tipos de variables primitivas y con Objetos en este caso si lo queremos como String
			se pone getAsString() como aqui:
			*/
			String nombre = jsonObject.get("nombre").getAsString();
			System.out.println("Nombre: " + nombre);
			
			//luego en este caso se utiliza pero con el Int
			int fundado = jsonObject.get("fundado").getAsInt();
			System.out.println("Fundado: " + fundado);

			//Hace falta que lo vuelva a repetir....
			boolean isStartup = jsonObject.get("is_startup").getAsBoolean();
			System.out.println("¿Es startup?: " + isStartup);

			/*
			Que pasa si un valor es nulo, pues muy sencillo simplemente nos aseguramos de que no sea nulo con el
			isJsonNull() , que nos pondra true si es nulo o false si no es nulo, la cosa esta en que el metodo isJsonNull()
			es un metodo de JsonElement, lo que significa que vamos a tener que declararlo antes, EXACTEMENTE igual que en XML,
			simplemente le decimos que nos lo guarde como elelemnto(JsonElement) y hacemos lo mismo de siempre con el jsonObject.
			*/
			JsonElement presupuestoElement = jsonObject.get("presupuesto");
			if (presupuestoElement.isJsonNull()) {
				System.out.println("Presupuesto: null");
				int presupuesto = 0;
			}

			/*
			Para leer en un array de objetos, lo primero que tenemos que hacer es declararnos el array que vamos a utilizar,
			y eso se consigue con el getAsJsonArray() y guardandolo en un array de objetos json en este caso JsonArray,
			asi conseguimos poder tener un array de objetos json que si podemos manejar 
			*/
			JsonArray equipo = jsonObject.getAsJsonArray("equipo");
			
			/*
			Lo mas importante de un array de json, es que cada elemento del array no es un JsonObject(que es con lo que hemos
			estado trabajando hasta ahora), sino que es un JsonElement, que como explique antes es un objectom json generico,s	  
			*/
			for (JsonElement miembro : equipo) {
				
				/*
				Lo que tenemos que hacer para poder controlar cada tipo de objeto dentro del array, es crearnos un JsonObject, para 
				asi poder manejarlo como siempre lo hemos estado haciendo, y es tan facil como ejecutar esta sentencia que se basa en darle 
				formato al elemento generico que hemos creado antes diciendole que sea un JsonObject (Ez as pie):	 
				*/
				JsonObject miembroObj = miembro.getAsJsonObject();
				
				//Y todo lo demas de aqui como siempre
				
				String nombreMiembro = miembroObj.get("nombre").getAsString();
				
				int edad = miembroObj.get("edad").getAsInt();
				
				String rol = miembroObj.get("rol").getAsString();
				
				boolean activo = miembroObj.get("activo").getAsBoolean();
				
				//Esto es un prtintf, que lo he puesto aqui para probar y experimentar, es lo mismo que el print normal, 
				// pero con formato, este siendo %s para string , %d para int y %b para boolean
				System.out.printf("Miembro: %s, Edad: %d, Rol: %s, Activo: %b %n", nombreMiembro, edad, rol, activo);
			}

			// Acceder a arrays de diferentes tipos
			JsonObject datos = jsonObject.getAsJsonObject("datos");

			// Array de números
			JsonArray numeros = datos.getAsJsonArray("numeros");
			System.out.print("Números: ");
			for (JsonElement numero : numeros) {
				System.out.print(numero.getAsNumber() + " ");
			}
			System.out.println();

			// Array de cadenas
			JsonArray cadenas = datos.getAsJsonArray("cadenas");
			System.out.print("Cadenas: ");
			for (JsonElement cadena : cadenas) {
				System.out.print(cadena.getAsString() + " ");
			}
			System.out.println();

			// Array mixto
			JsonArray mixto = datos.getAsJsonArray("mixto");
			System.out.print("Mixto: ");
			for (JsonElement elemento : mixto) {
				if (elemento.isJsonPrimitive()) {
					if (elemento.getAsJsonPrimitive().isBoolean()) {
						System.out.print(elemento.getAsBoolean() + " ");
					} else if (elemento.getAsJsonPrimitive().isNumber()) {
						System.out.print(elemento.getAsNumber() + " ");
					} else if (elemento.getAsJsonPrimitive().isString()) {
						System.out.print(elemento.getAsString() + " ");
					}
				} else if (elemento.isJsonNull()) {
					System.out.print("null ");
				}
			}
			System.out.println();

			// Acceso a objeto anidado
			JsonObject anidado = datos.getAsJsonObject("anidado").getAsJsonObject("nivel1").getAsJsonObject("nivel2");
			String claveValor = anidado.get("clave").getAsString();
			System.out.println("Valor anidado: " + claveValor);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
