import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SAXHandler extends DefaultHandler {
    private List<HeartBeatRecord> heartBeatRecordList = null;
    private HeartBeatRecord heartBeatRecord = null;
    private String elementValue;
    Long counter = 0L;

    @Override
    public void startDocument() throws SAXException {
        heartBeatRecordList = new ArrayList<HeartBeatRecord>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Record")) {
            if (attributes.getLength() > 0) {
                if (attributes.getValue("type").equalsIgnoreCase("HKQuantityTypeIdentifierHeartRate")) {
                    heartBeatRecord = new HeartBeatRecord();
                    String startDateString = attributes.getValue("startDate");
                    startDateString = stringDateParcer(startDateString);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDate startDate = LocalDate.parse(startDateString, formatter);
                    heartBeatRecord.setStartDate(startDate);
                    System.out.println(attributes.getValue("value"));
                    counter++;
                    System.out.println(counter);
                    Integer beatsPerMinute = Integer.parseInt(String.valueOf(Math.round(Float.parseFloat(attributes.getValue("value")))));
                    heartBeatRecord.setBeatsPerMinute(beatsPerMinute);
                    heartBeatRecordList.add(heartBeatRecord);
                }
            }

        }
    }

    public List<HeartBeatRecord> getHeartBeatRecords() {
        return heartBeatRecordList;
    }


    public String stringDateParcer(String dateToEdit) {
        String regex = " -0500";
        String input = dateToEdit;
        String replace = "";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        input = m.replaceAll(replace);
        return input;
    }

}
