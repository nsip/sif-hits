package sif3.hits.rest.provider;

import sif.dd.au30.conversion.DataModelMarshalFactory;
import sif.dd.au30.conversion.DataModelUnmarshalFactory;
import sif3.common.conversion.MarshalFactory;
import sif3.common.conversion.UnmarshalFactory;
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
}
