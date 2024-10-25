package ejercicio;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Misedtru {
	public static Document doc;
	
	public Misedtru(String label) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = null;
		try {
			constructor = factory.newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DOMImplementation implement = constructor.getDOMImplementation();
		doc = implement.createDocument(null, label, null);
		doc.setXmlVersion("1.0");
	}
	
	public Element addMainElement(String name) {
		Element elemento = doc.createElement(name);
		doc.getDocumentElement().appendChild(elemento);
		return elemento;
	}
	
	public void addElementTo(String name, String value, Element parent) {
		Element elemento = doc.createElement(name);
		Text elementText = doc.createTextNode(value);
		elemento.appendChild(elementText);
		parent.appendChild(elemento);
	}
	
	public void addAtribute(String name, String value, Element parent) {
		parent.setAttribute(name, value);
	}
	
	public void writeToXml(String file) {
		Source sorce = new DOMSource(doc);
		Result result = new StreamResult(new File(file));
		try {
			Transformer prime = TransformerFactory.newInstance().newTransformer();
			prime.transform(sorce,result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
