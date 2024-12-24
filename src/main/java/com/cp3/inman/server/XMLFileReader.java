package com.cp3.inman.server;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLFileReader {
    private NodeList nodelist;

    public XMLFileReader() {
        nodelist = null;
    }

    public NodeList readAndInitializeNodeList(String filePathOfXML) throws IOException, SAXException, ParserConfigurationException {
        NodeList nodeList = null;
        File inputFile = new File(filePathOfXML);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);

        document.getDocumentElement().normalize();

        nodeList = document.getElementsByTagName("product");


        return nodeList;
    }

    public NodeList getNodelist() {
        return nodelist;
    }

    public void setNodelist(NodeList nodelist) {
        this.nodelist = nodelist;
    }
}
