import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class ReadXMLWithSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse("/Users/michael/Documents/HeartRateData/docs/export.xml", saxHandler);

            List<HeartBeatRecord> heartBeatRecordList = saxHandler.getHeartBeatRecords();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}


