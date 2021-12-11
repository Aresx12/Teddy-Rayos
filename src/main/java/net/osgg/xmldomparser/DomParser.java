package net.osgg.xmldomparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {

  private String fileName;
	
  public DomParser(String fileName) {
		this.fileName = fileName;
  }
	
  public void parse() throws Exception {
	  
	int poblacion =0;  

	File inputDataFile = new File(fileName);
	DocumentBuilderFactory dbldrFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = dbldrFactory.newDocumentBuilder();
	Document docmt = docBuilder.parse(inputDataFile);
	docmt.getDocumentElement().normalize();
	System.out.println("Name of the Root element:" + docmt.getDocumentElement().getNodeName());

	NodeList ndList = docmt.getElementsByTagName("pais");

	   for (int tempval = 0; tempval < ndList.getLength(); tempval++) {
	       Node nd = ndList.item(tempval);
	       System.out.println("\nNombre elemento actual :" + nd.getNodeName());
	       if (nd.getNodeType() == Node.ELEMENT_NODE) {
	           Element elemnt = (Element) nd;
	           System.out.println("Nombre : " + elemnt.getAttribute("nombre"));
	           System.out.println("Hombres: " + elemnt
	                  .getElementsByTagName("hombres").item(0).getTextContent());
	           
	           poblacion += Integer.parseInt(elemnt.getElementsByTagName("hombres").item(0).getTextContent());
	           poblacion += Integer.parseInt(elemnt.getElementsByTagName("mujeres").item(0).getTextContent());
	           
	           System.out.println("Mujeres: " + elemnt
		              .getElementsByTagName("mujeres").item(0).getTextContent());
	           System.out.println("Poblacion Total:" + poblacion );
	           
	           poblacion =0;
	        }
       }
   }
}

