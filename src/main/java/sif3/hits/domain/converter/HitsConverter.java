package sif3.hits.domain.converter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif3.hits.domain.converter.factory.HitsObjectFactory;
import sif3.hits.domain.converter.factory.IObjectFactory;

public abstract class HitsConverter<S, H> {

  private static final Logger logger = LoggerFactory.getLogger(HitsConverter.class);

  private Class<S> sifClass;
  private Class<H> hitsClass;
  private static final Map<Class<?>, Method> enumValueMethods = new HashMap<Class<?>, Method>();
  private static final Map<Class<?>, Method> enumLookupMethods = new HashMap<Class<?>, Method>();
  private static final IObjectFactory objectFactory = new HitsObjectFactory();
  private static final InvocationHandler nullValueInvocationHandler = new InvocationHandler() {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      // if this method has one parameter and the parameter value is null return
      // null otherwise
      // invoke the method on the objectFactory
      if (args != null && args.length == 1 && args[0] == null) {
        return null;
      } else {
        return method.invoke(objectFactory, args);
      }
    }
  };

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

  public <X> List<S> toSifModelList(Collection<X> source) {
    List<S> result = new ArrayList<S>();
    if (source != null) {
      for (X item : source) {
        H value = getHitsValue(item);
        if (value != null) {
          result.add(toSifModel(value));
        }
      }
    }
    return result;
  }

  public <X extends S> List<X> toSifModelList(Collection<H> source, Class<X> clazz) {
    List<X> result = new ArrayList<X>();
    if (source != null) {
      for (H item : source) {
        H value = getHitsValue(item);
        if (value != null) {
          X target = null;
          try {
            target = clazz.newInstance();
          } catch (Exception ex) {
            logger.error("Unable to create new instance of sif model.", ex);
          }
          toSifModel(value, target);
          result.add(target);
        }
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

  public <X> List<H> toHitsModelList(Collection<X> source) {
    List<H> result = new ArrayList<H>();
    if (source != null) {
      for (X item : source) {
        S value = getSifValue(item);
        if (value != null) {
          result.add(toHitsModel(value));
        }
      }
    }
    return result;
  }

  protected <X> S getSifValue(X value) {
    S result = null;
    if (value != null && sifClass != null && sifClass.isAssignableFrom(value.getClass())) {
      result = sifClass.cast(value);
    }
    return result;
  }

  private <X> H getHitsValue(X value) {
    H result = null;
    if (value != null && hitsClass != null && hitsClass.isAssignableFrom(value.getClass())) {
      result = hitsClass.cast(value);
    }
    return result;
  }

  /***************************/
  /* Getter + Setter Helpers */
  /***************************/
  protected IObjectFactory getObjectFactory() {
    return (IObjectFactory) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] { IObjectFactory.class }, nullValueInvocationHandler);
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
  
  protected Duration getDurationValue(String value) {
    Duration result = null;
    try {
      if (value != null) {
        result = DatatypeFactory.newInstance().newDuration(value);
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to duration.", ex);
    }
    return result;
  }

  protected String getDurationValue(Duration value) {
    String result = null;
    try {
      if (value != null) {
        result = value.toString();
      }
    } catch (Exception ex) {
      logger.error("Unable to convert duration value [" + value + "] to string.", ex);
    }
    return result;
  }

  private static final FastDateFormat calendarFormat = FastDateFormat.getInstance("yyyyMMddHHmmssSSSZZ");

  protected Calendar getCalendarValue(String value) {
    Calendar result = null;
    try {
      if (value != null) {
        Calendar temp = Calendar.getInstance();
        temp.setTime(calendarFormat.parse(value));
        result = temp;
      }
    } catch (Exception ex) {
      logger.error("Unable to convert value [" + value + "] to xml calendar.", ex);
    }
    return result;
  }

  protected String getCalendarValue(Calendar value) {
    String result = null;
    try {
      if (value != null) {
        result = calendarFormat.format(value);
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
  
  protected Integer getIntegerValue(BigInteger value) {
    Integer result = null;
    if (value != null) {
      try {
        result = value.intValue();
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to BigInteger.", ex);
      }
    }
    return result;
  }
  
  protected String getIntegerValue(Integer value) {
    String result = null;
    if (value != null) {
      try {
        result = Integer.toString(value, 10);
      } catch (Exception ex) {
        logger.error("Unable to convert integer value [" + value + "] to string.", ex);
      }
    }
    return result;
  }

  
  protected Integer getIntegerValue(String value) {
    Integer result = null;
    if (value != null) {
      try {
        result = Integer.parseInt(value, 10);
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to integer.", ex);
      }
    }
    return result;
  }

  protected BigInteger getBigIntegerValue(Integer value) {
    BigInteger result = null;
    if (value != null) {
      try {
        result = new BigInteger(value.toString());
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to BigInteger.", ex);
      }
    }
    return result;
  }
  
  protected BigInteger getBigIntegerValue(String value) {
    BigInteger result = null;
    if (value != null) {
      try {
        result = new BigInteger(value);
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to BigInteger.", ex);
      }
    }
    return result;
  }

  protected String getBigIntegerValue(BigInteger value) {
    String result = null;
    if (value != null) {
      try {
        result = value.toString();
      } catch (Exception ex) {
        logger.error("Unable to convert BigInteger value [" + value + "] to string.", ex);
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
  
  protected Boolean getBooleanValue(String value) {
    Boolean result = null;
    if (value != null) {
      try {
        result = Boolean.parseBoolean(value);
      } catch (Exception ex) {
        logger.error("Unable to convert value [" + value + "] to boolean.", ex);
      }
    }
    return result;
  }
  
  protected boolean getBoolValue(String value) {
    return "true".equals(value);
  }

  protected String getBooleanValue(Boolean value) {
    String result = null;
    if (value != null) {
      try {
        result = value.toString();
      } catch (Exception ex) {
        logger.error("Unable to convert boolean value [" + value + "] to string.", ex);
      }
    }
    return result;
  }
  
  protected byte[] getByteArrayValue(String value) {
    byte[] result = null;
    if (value != null) {
      try {
        result = Base64.decodeBase64(value);
      } catch (Exception ex) {
        logger.error("Unable to convert boolean value [" + value + "] to string.", ex);
      }
    }
    return result;
  }
  
  protected String getByteArrayValue(byte[] value) {
    String result = null;
    if (value != null) {
      try {
        result = Base64.encodeBase64String(value);
      } catch (Exception ex) {
        logger.error("Unable to convert boolean value [" + value + "] to string.", ex);
      }
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  protected <E extends Enum<E>> E getEnumValue(String value, Class<E> clazz) {
    E result = null;
    if (value != null) {
      try {
        result = E.valueOf(clazz, value);
      } catch (Exception ex) {
        Exception finalException = ex;
        try {
          Method method = getFromValueMethod(clazz);
          if (method != null) {
            result = (E) method.invoke(null, value);
          }
        } catch (Exception innerException) {
          finalException = innerException;
        } finally {
          if (result == null) {
            logger.error("Unable to convert value [" + value + "] to enum [" + (clazz == null ? "unknown" : clazz.getSimpleName()) + "].", finalException);
          }
        }
      }
    }
    return result;
  }

  protected <E extends Enum<E>> String getEnumValue(E enumValue) {
    String result = null;
    if (enumValue != null) {
      Method valueMethod = getValueMethod(enumValue.getClass());
      if (valueMethod != null) {
        try {
          result = (String) valueMethod.invoke(enumValue);
        } catch (Exception ex) {
          logger.warn("Unable to convert value [" + enumValue + "] to value - using name.");
        }
      }
      if (result == null) {
        result = enumValue.name();
      }
    }
    return result;
  }

  private Method getValueMethod(Class<?> clazz) {
    Method result = enumValueMethods.get(clazz);
    if (result == null && !enumValueMethods.containsKey(clazz)) {
      try {
        result = clazz.getMethod("value");
      } catch (Exception ignore) {
      } finally {
        enumValueMethods.put(clazz, result);
      }
    }
    return result;
  }

  private static Method getFromValueMethod(Class<?> clazz) {
    Method result = enumLookupMethods.get(clazz);
    if (result == null && !enumLookupMethods.containsKey(clazz)) {
      try {
        result = clazz.getMethod("fromValue", String.class);
      } catch (NoSuchMethodException ex) {
        logger.warn("Unable to find fromValue for enum [" + (clazz == null ? "unknown" : clazz.getSimpleName()) + "].", ex);
      } finally {
        // will store null if we had an exception so we don't look again.
        enumLookupMethods.put(clazz, result);
      }
    }
    return result;
  }

}
