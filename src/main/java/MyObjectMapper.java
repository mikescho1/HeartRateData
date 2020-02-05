import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class MyObjectMapper {

    public static void main(String[] args) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream((new File("/Users/michael/Documents/HeartRateData/docs/export.xml"))));
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        String expression;
        NodeList nodeList;
        expression = "//*[@type=\"HKQuantityTypeIdentifierHeartRate\"]";
        nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

//        XPathExpression expr = xpath.compile("/Record[@type=\"HKQuantityTypeIdentifierHeartRate\"]");
//        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        System.out.println(nodeList.getLength());


    }

}


