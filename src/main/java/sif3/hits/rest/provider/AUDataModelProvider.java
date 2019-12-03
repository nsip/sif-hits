package sif3.hits.rest.provider;

import sif.dd.au30.conversion.DataModelMarshalFactory;
import sif.dd.au30.conversion.DataModelUnmarshalFactory;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.UnmarshalFactory;
import sif3.common.exception.DataTooLargeException;
import sif3.common.exception.PersistenceException;
import sif3.common.exception.UnsupportedQueryException;
import sif3.common.header.HeaderProperties;
import sif3.common.model.PagingInfo;
import sif3.common.model.RequestMetadata;
import sif3.common.model.SIFContext;
import sif3.common.model.SIFZone;
import sif3.infra.rest.provider.BaseProvider;

public abstract class AUDataModelProvider extends BaseProvider {
  private static DataModelUnmarshalFactory unmarshaller = new DataModelUnmarshalFactory();
  private static DataModelMarshalFactory marshaller = new DataModelMarshalFactory();

  public AUDataModelProvider() {
    super();
  }

  @Override
  public MarshalFactory getMarshaller() {
    return marshaller;
  }

  @Override
  public UnmarshalFactory getUnmarshaller() {
    return unmarshaller;
  }

  @Override
  public void shutdown() {
  }

  protected String getZoneId(SIFZone zone) {
    // TODO: Handle null zone to retrieve default from environment?
    String result = null;
    if (zone != null) {
      result = zone.getId();
    }
    return result;
  }

  protected String getContextId(SIFContext context) {
    String result = null;
    if (context != null) {
      result = context.getId();
    }
    return result;
  }

  @Override
  public HeaderProperties getCustomServiceInfo(SIFZone zone, SIFContext context, PagingInfo pagingInfo, RequestMetadata metadata)
      throws PersistenceException, UnsupportedQueryException, DataTooLargeException {
    // TODO: Does this need to be implemented?
    HeaderProperties headers = new HeaderProperties();
    return headers;
  }
}
