package sif3.hits.test.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import sif3.common.header.HeaderValues.QueryIntention;
import sif3.common.header.HeaderValues.RequestType;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ZoneContextInfo;
import sif3.common.ws.BaseResponse;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;

public class HitsTestConsumer<S, M> {

  private static Logger L = LoggerFactory.getLogger(HitsTestConsumer.class);

  private final static RequestType REQUEST_TYPE = RequestType.IMMEDIATE;

  private final Class<S> SINGLE_CLASS;
  private final Class<M> MULTI_CLASS;
  private final String SINGLE_NAME;
  private final String MULTI_NAME;

  private TestConsumer<S, M> testConsumer;

  public HitsTestConsumer(Class<S> singleClass, Class<M> multiClass, String name) {
    this.SINGLE_NAME = name;
    this.MULTI_NAME = name + "s";
    this.SINGLE_CLASS = singleClass;
    this.MULTI_CLASS = multiClass;
    this.testConsumer = new TestConsumer<S, M>(SINGLE_CLASS, SINGLE_NAME, MULTI_CLASS, MULTI_NAME);
  }

  public List<Response> getSingle(String refId) {
    List<Response> result = null;
    L.info("getSingle(" + refId + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.retrievByPrimaryKey(refId, getZoneContextList());
      printResponses(result);
    } catch (Exception ex) {
      L.error("getSingle(" + refId + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<Response> getMany(int recordsPerPage, int page) {
    List<Response> result = null;
    L.info("getMany(" + recordsPerPage + "," + page + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.retrieve(new PagingInfo(recordsPerPage, page), getZoneContextList(), REQUEST_TYPE);
      printResponses(result);
    } catch (Exception ex) {
      L.error("getMany(" + recordsPerPage + "," + page + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<Response> getByExample(S example, int recordsPerPage, int page) {
    List<Response> result = null;
    L.info("getByExample(" + example + "," + recordsPerPage + "," + page + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.retrieveByQBE(example, new PagingInfo(recordsPerPage, page), getZoneContextList(), REQUEST_TYPE, QueryIntention.ONE_OFF, null);
      printResponses(result);
    } catch (Exception ex) {
      L.error("getByExample(" + example + "," + recordsPerPage + "," + page + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<Response> getByServicePath(QueryCriteria queryCriteria, int recordsPerPage, int page) {
    List<Response> result = null;
    L.info("getByServicePath(" + queryCriteria + "," + recordsPerPage + "," + page + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.retrieveByServicePath(queryCriteria, new PagingInfo(recordsPerPage, page), getZoneContextList(), REQUEST_TYPE);
      printResponses(result);
    } catch (Exception ex) {
      L.error("getByServicePath(" + queryCriteria + "," + recordsPerPage + "," + page + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<Response> createOne(S object) {
    List<Response> result = null;
    L.info("createOne(" + object + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.createSingle(object, null);
      printResponses(result);
    } catch (Exception ex) {
      L.error("createOne(" + object + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<BulkOperationResponse<CreateOperationStatus>> createMany(M object) {
    List<BulkOperationResponse<CreateOperationStatus>> result = null;
    L.info("createMany(" + object + ") : " + MULTI_NAME);
    try {
      result = testConsumer.createMany(object, getZoneContextList(), REQUEST_TYPE);
      printResponses(result);
    } catch (Exception ex) {
      L.error("createMany(" + object + ") : " + MULTI_NAME, ex);
    }
    return result;
  }

  public List<Response> updateOne(S object, String refId) {
    List<Response> result = null;
    L.info("updateOne(" + object + "," + refId + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.updateSingle(object, refId, null);
      printResponses(result);
    } catch (Exception ex) {
      L.error("updateOne(" + object + "," + refId + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<BulkOperationResponse<OperationStatus>> updateMany(M object) {
    List<BulkOperationResponse<OperationStatus>> result = null;
    L.info("updateMany(" + object + ") : " + MULTI_NAME);
    try {
      if (object != null) {
        result = testConsumer.updateMany(object, getZoneContextList(), REQUEST_TYPE);
        printResponses(result);
      }
    } catch (Exception ex) {
      L.error("updateMany(" + object + ") : " + MULTI_NAME, ex);
    }
    return result;
  }

  public List<Response> deleteOne(String refId) {
    List<Response> result = null;
    L.info("deleteOne(" + refId + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.deleteSingle(refId, getZoneContextList());
      printResponses(result);
    } catch (Exception ex) {
      L.error("deleteOne(" + refId + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public List<BulkOperationResponse<OperationStatus>> deleteMany(String... refIds) {
    List<BulkOperationResponse<OperationStatus>> result = null;
    L.info("deleteMany(" + refIds + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.deleteMany(Arrays.asList(refIds), getZoneContextList(), REQUEST_TYPE);
      printResponses(result);
    } catch (Exception ex) {
      L.error("deleteMany(" + refIds + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  private List<ZoneContextInfo> getZoneContextList() {
    List<ZoneContextInfo> result = new ArrayList<ZoneContextInfo>();
    result.add(new ZoneContextInfo((SIFZone) null, (SIFContext) null));
    return result;
  }

  private void printResponses(List<? extends BaseResponse> responses) {
    try {
      if (responses != null) {
        int i = 1;
        for (BaseResponse response : responses) {
          L.debug("Response " + i + ":\n" + response);
          if (response.hasError()) {
            L.debug("Error for Response " + i + ": " + response.getError());
          } else {
            if (response.getHasEntity()) {
              if (response instanceof Response) {
                L.debug("Data Object Response " + i + ": " + testConsumer.getMarshaller().marshalToXML(((Response) response).getDataObject()));
              } else if (BulkOperationResponse.class.isAssignableFrom(response.getClass())) {
                L.debug("Bulk Operation Response " + i + ":");
                BulkOperationResponse<?> bor = BulkOperationResponse.class.cast(response);
                List<?> statuss = bor.getOperationStatuses();
                for (Object status : statuss) {
                  if (OperationStatus.class.isAssignableFrom(status.getClass())) {
                    OperationStatus operationStatus = OperationStatus.class.cast(status);
                    L.debug(operationStatus.getResourceID() + " : " + operationStatus.getStatus());
                  }
                }
              } else {
                L.debug("Response " + i + ": " + response.toString());
              }
            } else {
              L.debug("Data Object Response " + i + ": No Data Returned. Respnse Status = " + response.getStatus() + " (" + response.getStatusMessage() + ")");
            }
          }
          i++;
        }
      } else {
        L.debug("Responses from attempt to create Student: null");
      }
    } catch (Exception ex) {
      L.error("Error printing responses", ex);
    }
  }

  public String getXMLFromObject(Object object) {
    String result = null;
    L.info("getXMLFromObject(" + object + ") : " + SINGLE_NAME);
    try {
      result = testConsumer.getMarshaller().marshalToXML(object);
    } catch (Exception ex) {
      L.error("getXMLFromObject(" + object + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  public S getObjectFromFile(String filename) {
    return getObjectFromXML(getFileContents(filename));
  }

  public S getObjectFromXML(String xml) {
    S result = null;
    L.info("getObjectFromXML(" + (xml == null ? "null" : "...") + ") : " + SINGLE_NAME);
    try {
      result = SINGLE_CLASS.cast(testConsumer.getUnmarshaller().unmarshalFromXML(xml, SINGLE_CLASS));
    } catch (Exception ex) {
      L.error("getObjectFromXML(" + (xml == null ? "null" : "...") + ") : " + SINGLE_NAME, ex);
    }
    return result;
  }

  private String getFileContents(String filename) {
    String result = "";
    try {
      Resource resource = new ClassPathResource(filename);
      BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()), 1024);
      StringBuilder stringBuilder = new StringBuilder();
      String line;
      while ((line = br.readLine()) != null) {
        stringBuilder.append(line);
      }
      br.close();
      result = stringBuilder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }
}
