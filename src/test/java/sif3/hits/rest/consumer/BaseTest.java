package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public abstract class BaseTest {
  
  public abstract void initialiseData() throws Exception;

  protected XMLGregorianCalendar getDate(String date) throws DatatypeConfigurationException {
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
  }

  protected boolean semiEquals(String xmlFrom, String xmlTo) {
    String[] fromStrings = xmlFrom.split("\n");
    List<String> fromElements = Arrays.asList(fromStrings);
    String[] toStrings = xmlTo.split("\n");
    List<String> toElements = Arrays.asList(toStrings);
    boolean same = fromElements.size() == toElements.size();
    for (int i = 0; same && i < fromElements.size(); i++) {
      String element = fromElements.get(i);
      same = Collections.frequency(fromElements, element) == Collections.frequency(toElements, element);
    }
    for (int i = 0; same && i < toElements.size(); i++) {
      String element = toElements.get(i);
      same = Collections.frequency(fromElements, element) == Collections.frequency(toElements, element);
    }
    return same;
  }

}
