import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.persistence.criteria.CriteriaBuilder;

public class SAXHandler extends DefaultHandler {
    private List<HeartBeatRecord> heartBeatRecordList = null;
    private HeartBeatRecord heartBeatRecord = null;
    private String elementValue;

    @Override
    public void startDocument() throws SAXException {
        heartBeatRecordList = new ArrayList<HeartBeatRecord>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException    {
        if(qName.equalsIgnoreCase("Record")) {
            if(attributes.getValue("type").equalsIgnoreCase("HKQuantityTypeIdentifierHeartRate")) {
                heartBeatRecord = new HeartBeatRecord();

                if (attributes.getLength() > 0) {
                    String startDateString = attributes.getValue("startDate");
//                dateToEdit = stringDateParcer(dateToEdit);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDate startDate = LocalDate.parse(startDateString, formatter);
                    heartBeatRecord.setStartDate(startDate);

                    Integer beatsPerMinute = Integer.parseInt(attributes.getValue("value"));
                    heartBeatRecord.setBeatsPerMinute(beatsPerMinute);
                }
            }

        }
    }





//    public String stringDateParcer(String dateToEdit) {
//        String regex = " -0500";
//        String input = dateToEdit;
//        String replace = "";
//
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(input);
//        input = m.replaceAll(replace);
//        return input;
//    }

}
