package sif3.hits.domain.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.ObjectFactory;

public abstract class HitsConverter<S, H> {

  private Logger logger = LoggerFactory.getLogger(HitsConverter.class);
  private Class<S> sifClass;
  private Class<H> hitsClass;

  protected HitsConverter(Class<S> sifClass, Class<H> hitsClass) {
    this.sifClass = sifClass;
    this.hitsClass = hitsClass;
  }

  protected S newSifModel() {
    S result = null;
    try {
      if (sifClass != null) {
        result = sifClass.newInstance();
      }
    } catch (Exception ex) {
      logger.error("Unable to create new instance of sif model.", ex);
    }
    return result;
  }

  public abstract void toSifModel(H source, S target);

  protected H newHitsModel() {
    H result = null;
    try {
      if (hitsClass != null) {
        result = hitsClass.newInstance();
      }
    } catch (Exception ex) {
      logger.error("Unable to create new instance of hits model.", ex);
    }
    return result;
  }

  public abstract void toHitsModel(S source, H target);

  public S toSifModel(H source) {
    S result = null;
    if (source != null) {
      result = newSifModel();
      toSifModel(source, result);
    }
    return result;
  }

  public List<S> toSifModelList(Collection<H> source) {
    List<S> result = new ArrayList<S>();
    if (source != null) {
      for (H item : source) {
        result.add(toSifModel(item));
      }
    }
    return result;
  }

  public H toHitsModel(S source) {
    H result = null;
    if (source != null) {
      result = newHitsModel();
      toHitsModel(source, result);
    }
    return result;
  }

  public List<H> toHitsModelList(Collection<S> source) {
    List<H> result = new ArrayList<H>();
    if (source != null) {
      for (S item : source) {
        result.add(toHitsModel(item));
      }
    }
    return result;
  }
  
  /***************************/
  /* Getter + Setter Helpers */
  /***************************/
  protected ObjectFactory getObjectFactory() {
    return new HitsObjectFactory();
  }
  
  protected <V> V getJAXBValue(JAXBElement<V> element) {
    V result = null;
    if (element != null && element.getValue() != null) {
      result = element.getValue();
    }
    return result;
  }
  
  protected <E extends Enum<E>> String getJAXBEnumValue(JAXBElement<E> element) {
    String result = null;
    if (element != null && element.getValue() != null) {
      E value = element.getValue();
      result = getEnumValue(value);
    }
    return result;
  }

  protected XMLGregorianCalendar getDateValue(String value) {
    XMLGregorianCalendar result = null;
    try {
      if (value != null) {
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar(value);
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to xml calendar.", ex);
    }
    return result;
  }
  
  protected String getDateValue(XMLGregorianCalendar value) {
    String result = null;
    try {
      if (value != null) {
        result = value.toString();
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to xml calendar.", ex);
    }
    return result;
  }
  
  protected XMLGregorianCalendar getTimeValue(String value) {
    XMLGregorianCalendar result = null;
    try {
      if (value != null) {
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar(value);
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to xml calendar.", ex);
    }
    return result;
  }
  
  protected String getTimeValue(XMLGregorianCalendar value) {
    String result = null;
    try {
      if (value != null) {
        result = value.toString();
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to xml calendar.", ex);
    }
    return result;
  }  
  
  protected XMLGregorianCalendar getYearValue(String value) {
    XMLGregorianCalendar result = null;
    if (value != null) {
      try {
        int year = Integer.parseInt(value, 10);
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar();
        result.setYear(year);
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to xml calendar year.", ex);
      } 
    }
    return result;
  }
  
  protected String getYearValue(XMLGregorianCalendar value) {
    String result = null;
    if (value != null) {
      int year = value.getYear();
      result = Integer.toString(year, 10);
    }
    return result;
  }

  protected BigDecimal getBigDecimalValue(String value) {
    BigDecimal result = null;
    if (value != null) {
      try {
        result = new BigDecimal(value);
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to bigdecimal.", ex);
      }
    }
    return result;
  }
  
  protected String getBigDecimalValue(BigDecimal value) {
    String result = null;
    if (value != null) {
      try {
        result = value.toString();
      } catch (Exception ex) {
        logger.error("Unable to convert bigdecimal value [" + value + "] to string.", ex);
      }
    }
    return result;
  }
  
  protected Long getLongValue(String value) {
    Long result = null;
    if (value != null) {
      try {
        result = Long.parseLong(value, 10);
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to long.", ex);
      }
    }
    return result;
  }
  
  protected String getLongValue(Long value) {
    String result = null;
    if (value != null) {
      try {
        result = Long.toString(value, 10);
      } catch (Exception ex) {
        logger.error("Unable to convert long value [" + value + "] to string.", ex);
      }
    }
    return result;
  }
  
  protected <E extends Enum<E>> E getEnumValue(String value, Class<E> clazz) {
    E result = null;
    try {
      if (value != null) {
        result = E.valueOf(clazz, value);
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to enum [" + (clazz == null ? "unknown" : clazz.getSimpleName()) + "].", ex);
    }
    return result;
  }
  
  protected <E extends Enum<E>> String getEnumValue(E enumValue) {
    String result = null;
    if (enumValue != null) {
      result = enumValue.name();
    }
    return result;
  }

}

