package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestletContentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.NAPTestlet;

@Component
public class NAPTestletContentConverter extends HitsConverter<NAPTestletContentType, NAPTestlet> {

  public NAPTestletContentConverter() {
    super(NAPTestletContentType.class, NAPTestlet.class);
  }

  @Override
  public void toSifModel(NAPTestlet source, NAPTestletContentType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setNAPTestletLocalId(source.getLocalId());
      target.setTestletName(objectFactory.createNAPTestletContentTypeTestletName(source.getTestletName()));
      target.setTestletMaximumScore(getBigDecimalValue(source.getTestletMaximumScore()));
      target.setNode(objectFactory.createNAPTestletContentTypeNode(source.getNode()));
      target.setLocationInStage(objectFactory.createNAPTestletContentTypeLocationInStage(getBigIntegerValue(source.getLocationInStage())));
    }
  }

  @Override
  public void toHitsModel(NAPTestletContentType source, NAPTestlet target) {
    if (source != null && target != null) {
      target.setLocalId(source.getNAPTestletLocalId());
      target.setTestletName(getJAXBValue(source.getTestletName()));
      target.setTestletMaximumScore(getBigDecimalValue(source.getTestletMaximumScore()));
      target.setNode(getJAXBValue(source.getNode()));
      target.setLocationInStage(getBigIntegerValue(getJAXBValue(source.getLocationInStage())));

    }
  }

}
