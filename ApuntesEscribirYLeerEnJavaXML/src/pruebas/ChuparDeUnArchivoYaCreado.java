package pruebas;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ChuparDeUnArchivoYaCreado {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	/*
	<libros>
	    <libro>
	        <titulo id = "1">El Quijote</titulo>
	        <autor>Cervantes</autor>
	    </libro>
	    <libro>
	        <titulo id = "2" >Marcos Calvito</titulo>
	        <autor>Alex</autor>
	    </libro>
	</libros>
	*/
		
	//DECLARO el file diciendo que sea un xml.
	/*
 	El DocumentBuilderFactory es una clase singleton que crea 1 solo objeto, que sirve para poder crear metodos
  	de la misma clase DocumentBuilder que sirven para poder crear Documentos(obviamente).
  	*/
	DocumentBuilderFactory fnaf = DocumentBuilderFactory.newInstance();
	//Y el DocumentBuilder lo que hace es crear Documentos(como he dicho antes).
	DocumentBuilder constructor = fnaf.newDocumentBuilder();
	//decalra el file para encontrar el archivo.
	File file = new File("./src/barrin.xml");
	//carga el objeto doc con un archivo xml.
	Document doc = constructor.parse(file);
	/*
	El método normalize() en un objeto Document se utiliza para combinar nodos de texto adyacentes y eliminar nodos vacíos.
	Esto es especialmente útil cuando se ha manipulado el DOM (Document Object Model) o cuando se ha cargado un documento XML 
	que puede contener espacios en blanco innecesarios o nodos vacíos.
	Basicamente hace legible el codigo para java, nos ayuda mucho , basicamnete ponerlo siempre.
	*/
	doc.getDocumentElement().normalize();
	
	//getElementsByTagName(): Obtiene todos los elementos que tienen la etiqueta especificada.
	NodeList listaDeElemntosRaiz = doc.getElementsByTagName("libro");
	/*
	 Recorremos la lista de los padres en este caso libro, basicamente para poder obtener todos los subelementos y atributos 
	 que tenga nuestro documento xml.
	*/
	for (int i = 0; i < listaDeElemntosRaiz.getLength(); i++) {
	// la de siempre, te creas un Element donde vas a guardar lo que chupes del xml, la razón es porque en el arhcivo xml se guardan Elements,
		//tambien (se me habia olvidad decir) te los va a leer todos ya que lo recorre.
		Element libroPapi = (Element) listaDeElemntosRaiz.item(i);
		/*
		El getElementsByTagName() devuelve un Nodelist(ListaDeNodos)con todos los nodos dentro que tengan la etiqueta titulo.
		El .item(0) accede a el primer nodo de la lista(como absolutamente todas las listas que siempre empiezan en 0), si no hay te da una 
		exception. Y por ultimo el getTextContent() saca el texto del elemento ej:
		  <autor>Alex</autor>, de este elemento sacaria Alex.
		*/
		String autorHijo = libroPapi.getElementsByTagName("autor").item(0).getTextContent();
		/*
		 -------------------------------------------------------------------------------- 
		  				   IMPORTANTE
		 --------------------------------------------------------------------------------
		 Para sacar cualqier dato de un hijo se tiene que tener el padre siempre,por ejemplo el titulo no lo hemos declarado como Element
		 para sacar el texto del titulo porque ya tenemos el padre(libroPapi), comom queremos sacar el id necesitamos tener el padre del id,
		 en este caso el padre es tituloHijo, por ende necesitamos declarar el padre como elemento asi podremos sacar las propiedades del hijo.
		*/
		/*
		Como he dicho antes declaro el titulo como elemento, para ello utiliza el getElementsByTagName() que como explique antes te chupa todos
		los elementos dentro de un elemento(en este caso del padre listaDeElemntosRaiz) y devuelve un Nodelist.
		El item(0) es igual que antes y el casteo a Element es porque tiene que identificar de todos los nodos dentro del Nodelist
		que devuelve el cual es un Element.
		 */
		Element tituloPadreDelId = (Element) libroPapi.getElementsByTagName("titulo").item(0);
		/*
		Ahora que ya tenemos el padre, podemos sacar los atributos del hijo perfectamente, declaramos el id como String y 
		utilizamos el tituloPadreDelId() que basicamente busca todos los atributos con cierto nombre (en este caso "id"),
		esto se hace sobre el padre tituloPadreDelId.
		*/
		String idHijoAtributoDelTitulo= tituloPadreDelId.getAttribute("id");
		/*
		Ahora solo nos faltaria sacar el titulo que esta dentro del elemento titulo, para ello se utiliza el getTextContent() exactamente
		igual que antes solo que ahora no se utiliza el .item(0) porque es directamente solo 1 elemento no un NodeList	 
		*/
		String titulo = tituloPadreDelId.getTextContent();
		System.out.println("El titulo es: "+titulo+" con id:  "+idHijoAtributoDelTitulo+" Y el autor es:  "+autorHijo);
		
	} 
		
	}
	
}
