package pruebas;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class MeterEnUnArchivo {
	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		/*
		<peluqueria>
		  	<trabajador id = 1>
				<nombre>Marcos</nombre>
			</trabajador>
			<trabajador id = 2>
				<nombre>Van</nombre>
			</trabajador>
		</peluqueria>
		 */
		
		//DECLARO el docuemnto, y le digo que se riga por DOM
		DocumentBuilderFactory fnaf = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = fnaf.newDocumentBuilder();
		DOMImplementation implement = constructor.getDOMImplementation();
		//le decimos que sea de tipo xml
		/*
		el primer null es namespace(mierda de xml que no nos sirve)
		el segundo atributo es el nombre de la raiz,
		el ultimo null es el tipo de doctype, el null es para que se ponga automaticamente la version adecuada.
		*/
		Document doc = implement.createDocument(null,"peluqueria",null);
		doc.setXmlVersion("1.0");
		//CREO los elementos que luego les voy a decir quienes son sus padres
		Element trabajador = doc.createElement("trabajador");
		// Establecer atributo id, lo crea y lo une
		trabajador.setAttribute("id", "1"); 
		Element nombre = doc.createElement("nombre");
		//Creo un nodo text, que va a rellenar los elementos que he creado
		Text textoNombre = doc.createTextNode("Marcos");
		//Le decimos la jerarquia que va a tener el archivo xml(basicamente le decimos quien va a ser el padre de cada elemento)
		//siempre va a seguir la metodologia de declarar el hijo mediante el padre
		trabajador.appendChild(nombre);
		//los nodos text, al igaul que los atributos tambien s ehacen igual
		nombre.appendChild(textoNombre);
		/*
		Como antes hemos declarado peluqueria como elemento padre, no hace falta crearlo como elemento sino lo que hacemos es pillar 
		directamente la raiz mediante el metodo getDocumentElement()
		*/
		doc.getDocumentElement().appendChild(trabajador);
		//haces un  metodo que literalmente hace todo lo que he puesto sin comentarios de mierda(Alex maricon)
		agregarTrabajador(doc, "2", "Van");
		//CREAMOS el documento y le decimos como crear el documento porque a java le gusta el perico
		Source sauce = new DOMSource(doc);
		Result result = new StreamResult(new File("caca.xml"));
		Transformer optimus = TransformerFactory.newInstance().newTransformer();
		optimus.transform(sauce,result);
		
	}
	//metodo para crear infinitos trabajadores
	 private static void agregarTrabajador(Document doc, String id, String nombreTrabajador) {
	        Element trabajador = doc.createElement("trabajador");
	        trabajador.setAttribute("id", id);
	        Element nombre = doc.createElement("nombre");
	        Text textoNombre = doc.createTextNode(nombreTrabajador);
	        trabajador.appendChild(nombre);
	        nombre.appendChild(textoNombre);
	        doc.getDocumentElement().appendChild(trabajador);
	    }

}