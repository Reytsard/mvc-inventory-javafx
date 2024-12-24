package com.cp3.inman.server.controller;

import com.cp3.inman.server.XMLFileReader;
import org.w3c.dom.NodeList;

public class XMLFileWriter {
    private NodeList nodeList;
    private final String filePath = "res/product.xml";

    public XMLFileWriter(NodeList nodeList){
        this.nodeList = nodeList;
    }
}
