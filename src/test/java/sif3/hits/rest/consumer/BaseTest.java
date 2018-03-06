package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public abstract class BaseTest {

    private Pattern TAG_PATTERN = Pattern.compile("^[^\\<]*(<[^\\>]*>).*$");

    public abstract void initialiseData() throws Exception;

    protected XMLGregorianCalendar getDate(String date) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
    }

    protected boolean semiEquals(String xmlFrom, String xmlTo) {
        String[] fromStrings = xmlFrom.split("\n");
        List<String> fromElements = Arrays.asList(fromStrings);
        String[] toStrings = xmlTo.split("\n");
        List<String> toElements = Arrays.asList(toStrings);
        boolean allSame = fromElements.size() == toElements.size();
        for (int i = 0; i < fromElements.size(); i++) {
            String element = fromElements.get(i);
            boolean same = true;
            if (element.contains("<CreationDateTime>")) {
                same = simpleFrequency(fromElements, element) == simpleFrequency(toElements, element);
            } else {
                same = Collections.frequency(fromElements, element) == Collections.frequency(toElements, element);
            }
            if (!same) {
                System.out.println("Error:" + element);
            }
            allSame &= same;
        }
        for (int i = 0; i < toElements.size(); i++) {
            String element = toElements.get(i);
            boolean same = true;
            if (element.contains("<CreationDateTime>")) {
                same = simpleFrequency(fromElements, element) == simpleFrequency(toElements, element);
            } else {
                same = Collections.frequency(fromElements, element) == Collections.frequency(toElements, element);
            }
            if (!same) {
                System.out.println("Error:" + element);
            }
            allSame &= same;
        }
        return allSame;
    }

    private int simpleFrequency(List<String> elements, String search) {
        int result = 0;
        String tag = getTag(search);
        for (String s : elements) {
            if (tag.equals(getTag(s))) {
                result++;
            }
        }
        return result;
    }

    private String getTag(String element) {
        Matcher m = TAG_PATTERN.matcher(element);
        if (m.matches()) {
            return m.group(1);
        }
        return element;
    }

}
