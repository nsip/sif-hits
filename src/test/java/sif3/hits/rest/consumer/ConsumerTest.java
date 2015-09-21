package sif3.hits.rest.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import sif3.common.exception.MarshalException;
import sif3.common.exception.UnmarshalException;
import sif3.common.exception.UnsupportedMediaTypeExcpetion;
import sif3.common.header.HeaderValues.RequestType;
import sif3.common.model.PagingInfo;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.common.model.ZoneContextInfo;
import sif3.common.ws.BaseResponse;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;

public class ConsumerTest<S, M> {

  private final static RequestType REQUEST_TYPE = RequestType.IMMEDIATE;
  private final static String FILE_PATH = "data";

  private final Class<S> SINGLE_CLASS;
  private final Class<M> MULTI_CLASS;

  private TestConsumer<S, M> testConsumer;

  protected ConsumerTest(Class<S> singleClass, String singleName, Class<M> multiClass, String multiName) {
    this.testConsumer = new TestConsumer<S, M>(singleClass, singleName, multiClass, multiName);
    this.SINGLE_CLASS = singleClass;
    this.MULTI_CLASS = multiClass;
  }

  protected List<Response> testGetSingle(String refId) {
    List<Response> result = null;
    System.out.println("Start 'Get " + getSingleName() + "' in all connected environments...");
    try {
      result = testConsumer.retrievByPrimaryKey(refId, getZoneContextList());
      System.out.println("Responses from attempt to 'Get " + getSingleName() + "':");
      printResponses(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Get " + getSingleName() + "' in all connected environments...");
    return result;
  }

  protected List<Response> testGetMany(int recordsPerPage, int page) {
    List<Response> result = null;
    System.out.println("Start 'Get All " + getMultiName() + "' in all connected environments...");
    try {
      result = testConsumer.retrieve(new PagingInfo(recordsPerPage, page), getZoneContextList(), REQUEST_TYPE);
      System.out.println("Responses from attempt to 'Get All " + getMultiName() + "':");
      printResponses(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Get All " + getMultiName() + "' in all connected environments...");
    return result;
  }

  protected List<Response> testCreateOne(String filename) {
    List<Response> result = null;
    System.out.println("Start 'Create " + getSingleName() + "' in all connected environments...");
    try {
      String contents = getFileContents(filename);
      Object object = testConsumer.getUnmarshaller().unmarshalFromXML(contents, SINGLE_CLASS);
      S input = null;
      if (SINGLE_CLASS.isAssignableFrom(object.getClass())) {
        input = SINGLE_CLASS.cast(object);
      }
      result = testConsumer.createSingle(input, null);
      System.out.println("Responses from attempt to 'Create " + getSingleName() + "':");
      printResponses(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Create " + getSingleName() + "' in all connected environments...");
    return result;
  }

  protected List<Response> doCreateOne(S object) {
    List<Response> result = null;
    System.out.println("Start 'Create " + getSingleName() + "' in all connected environments...");
    try {
      if (object != null) {
        result = testConsumer.createSingle(object, null);
        System.out.println("Responses from attempt to 'Create " + getSingleName() + "':");
        printResponses(result);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Create " + getSingleName() + "' in all connected environments...");
    return result;
  }
  
  protected List<Response> doUpdateOne(S object, String refId) {
    List<Response> result = null;
    System.out.println("Start 'Update " + getSingleName() + "' in all connected environments...");
    try {
      if (object != null) {
        result = testConsumer.updateSingle(object, refId, null);
        System.out.println("Responses from attempt to 'Update " + getSingleName() + "':");
        printResponses(result);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Update " + getSingleName() + "' in all connected environments...");
    return result;
  }
  
  protected String getXML(S object) throws MarshalException, UnsupportedMediaTypeExcpetion {
    String result = null;
    if (object != null) {
      result = testConsumer.getMarshaller().marshalToXML(object);
    }
    return result;
  }
  
  protected S fromXML(String xml) throws UnmarshalException, UnsupportedMediaTypeExcpetion {
    S result = null;
    if (xml != null) {
      Object sifObject = testConsumer.getUnmarshaller().unmarshalFromXML(xml, SINGLE_CLASS);
      if (SINGLE_CLASS.isAssignableFrom(sifObject.getClass())) {
        result = SINGLE_CLASS.cast(sifObject);
      }
    }
    return result;
  }


  protected List<Response> testUpdateOne(String filename, String refId) {
    List<Response> result = null;
    System.out.println("Start 'Update " + getSingleName() + "' in all connected environments...");
    try {
      String contents = getFileContents(filename);
      Object object = testConsumer.getUnmarshaller().unmarshalFromXML(contents, SINGLE_CLASS);
      S input = null;
      if (SINGLE_CLASS.isAssignableFrom(object.getClass())) {
        input = SINGLE_CLASS.cast(object);
      }
      result = testConsumer.updateSingle(input, refId, null);
      System.out.println("Responses from attempt to 'Update " + getSingleName() + "':");
      printResponses(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Update " + getSingleName() + "' in all connected environments...");
    return result;
  }

  protected List<BulkOperationResponse<CreateOperationStatus>> testCreateMany(String filename) {
    List<BulkOperationResponse<CreateOperationStatus>> result = null;
    System.out.println("Start 'Create " + getMultiName() + "' in all connected environments...");
    try {
      String contents = getFileContents(filename);
      Object object = testConsumer.getUnmarshaller().unmarshalFromXML(contents, MULTI_CLASS);
      M input = null;
      if (MULTI_CLASS.isAssignableFrom(object.getClass())) {
        input = MULTI_CLASS.cast(object);
      }
      result = testConsumer.createMany(input, getZoneContextList(), REQUEST_TYPE);
      printResponses(result);
      System.out.println("Responses from attempt to 'Create " + getMultiName() + "':");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Create " + getMultiName() + "' in all connected environments...");
    return result;
  }

  protected List<Response> testDeleteOne(String refId) {
    List<Response> result = null;
    System.out.println("Start 'Remove " + getSingleName() + "' in all connected environments...");
    try {
      result = testConsumer.deleteSingle(refId, getZoneContextList());
      System.out.println("Responses from attempt to 'Remove " + getSingleName() + "':" + result);
      printResponses(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Remove " + getSingleName() + "' in all connected environments...");
    return result;
  }

  protected List<BulkOperationResponse<OperationStatus>> testDeleteMany(String... refIds) {
    List<BulkOperationResponse<OperationStatus>> result = null;
    System.out.println("Start 'Remove " + getMultiName() + "' in all connected environments...");
    try {
      result = testConsumer.deleteMany(Arrays.asList(refIds), getZoneContextList(), REQUEST_TYPE);
      printResponses(result);
      System.out.println("Responses from attempt to 'Remove " + getMultiName() + "':" + result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("Finished 'Remove " + getMultiName() + "' in all connected environments...");
    return result;
  }

  protected String getFileContents(String filename) {
    String result = "";
    try {
      Resource resource = new ClassPathResource(FILE_PATH + "/" + filename);
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

  private String getSingleName() {
    return testConsumer.getSingleObjectClassInfo().getObjectName();
  }

  private String getMultiName() {
    return testConsumer.getMultiObjectClassInfo().getObjectName();
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
          System.out.println("Response " + i + ":\n" + response);
          if (response.hasError()) {
            System.out.println("Error for Response " + i + ": " + response.getError());
          } else // We should have a student personal
          {
            if (response.getHasEntity()) {
              if (response instanceof Response) {
                System.out.println("Data Object Response " + i + ": "
                    + testConsumer.getMarshaller().marshalToXML(((Response) response).getDataObject()));
              } else if (BulkOperationResponse.class.isAssignableFrom(response.getClass())) {
                System.out.println("Bulk Operation Response " + i + ":");
                BulkOperationResponse<?> bor = BulkOperationResponse.class.cast(response);
                List<?> statuss = bor.getOperationStatuses();
                for (Object status : statuss) {
                  if (OperationStatus.class.isAssignableFrom(status.getClass())) {
                    OperationStatus operationStatus = OperationStatus.class.cast(status);
                    System.out.println(operationStatus.getResourceID() + " : " + operationStatus.getStatus());
                  }
                }
              } else {
                System.out.println("Response " + i + ": " + response.toString());
              }
            } else {
              System.out.println("Data Object Response " + i + ": No Data Returned. Respnse Status = "
                  + response.getStatus() + " (" + response.getStatusMessage() + ")");
            }
          }
          i++;
        }
      } else {
        System.out.println("Responses from attempt to create Student: null");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  public S doGetOne(String refId) throws Exception {
    S result = null;
    List<Response> responses = testGetSingle(refId);
    if (responses != null && responses.size() == 1) {
      Response response = responses.get(0);
      result = (S) response.getDataObject();
    } else {
      throw new Exception("Bad result"); 
    }
    return result;
  }
}
