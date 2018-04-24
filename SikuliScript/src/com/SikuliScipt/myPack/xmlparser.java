package com.SikuliScipt.myPack;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlparser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		fetchDataFromXML("C:\\Users\\ahmed.javed\\Downloads\\Properties.xml");
	}

	public static void fetchDataFromXML(String file) throws ParserConfigurationException, SAXException, IOException {
		String RemoteSystem;
		String DB_Name;
		String DB_UserName;
		String DB_Password;
		File xmlFile = new File(file);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		// System.out.println("Root element :" +
		// doc.getDocumentElement().getNodeName());

		String prop = doc.getDocumentElement().getNodeName();
		NodeList nList = doc.getElementsByTagName(prop);

		System.out.println(doc.getDocumentElement());

		System.out.println(nList.getLength());
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			System.out.println("current node:--" + nNode.getNodeName());
			Element eElement = (Element) nNode;

			System.out.println("Data is "+eElement.getTagName());
			System.out.println(eElement.getChildNodes().getLength());

			for (int j = 0; j < eElement.getChildNodes().getLength(); j++) {
				Node eElement2 =  eElement.getChildNodes().item(j);

				System.out.println("Data is "+eElement2.getAttributes());
				
	//			System.out.println(eElement.getChildNodes().item(j).);

			}

			/*
			 * if (nNode.getNodeType() == Node.ELEMENT_NODE) { Element eElement
			 * = (Element) nNode; System.out.println("eElement "+ eElement);
			 * System.out.println("Mazak hai Bhai "+eElement.getAttribute("URL")
			 * ); // getting the required data in variables... RemoteSystem =
			 * eElement.getChildNodes().item(19).getTextContent().toString();
			 * DB_Name = eElement.getChildNodes().item(21).getTextContent();
			 * DB_UserName = eElement.getChildNodes().item(23).getTextContent();
			 * DB_Password = eElement.getChildNodes().item(25).getTextContent();
			 * 
			 * // printing the required data on console
			 * System.out.println("IP address is:--" +
			 * eElement.getChildNodes().item(19).getTextContent().toString());
			 * System.out.println("DB  name is:--" +
			 * eElement.getChildNodes().item(21).getTextContent());
			 * System.out.println("Database userName is:--" +
			 * eElement.getChildNodes().item(23).getTextContent());
			 * System.out.println("Database Password is:--" +
			 * eElement.getChildNodes().item(25).getTextContent());
			 * System.out.println("process group:--" +
			 * eElement.getChildNodes().item(13).getTextContent().toString());
			 * 
			 * } }
			 * 
			 */
		}
	}
}
