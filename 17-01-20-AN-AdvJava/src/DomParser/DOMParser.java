package DomParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(new File("data.xml"));
		document.getDocumentElement().normalize();

		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		 
		//Get all employees
		NodeList nList = document.getElementsByTagName("student");
		System.out.println("============================");
		 
		System.out.println(nList.getLength());
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 System.out.println(""); 
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    Element eElement = (Element) node;
		    System.out.println("USN: "    + eElement.getElementsByTagName("usn").item(0).getTextContent());
		    System.out.println("Name: "  + eElement.getElementsByTagName("name").item(0).getTextContent());
		    System.out.println("College: "  + eElement.getElementsByTagName("college").item(0).getTextContent());
		    System.out.println("Branch: "    + eElement.getElementsByTagName("branch").item(0).getTextContent());
		    System.out.println("Year: "    + eElement.getElementsByTagName("year").item(0).getTextContent());
		    System.out.println("Join: "    + eElement.getElementsByTagName("join").item(0).getTextContent());
		 }		 
		}
	}
}
