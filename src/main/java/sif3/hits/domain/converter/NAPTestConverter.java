package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestType;
import sif3.hits.domain.model.NAPTest;

@Component
public class NAPTestConverter extends HitsConverter<NAPTestType, NAPTest> {

  @Autowired
  private NAPTestContentConverter napTestContentConverter;

  public NAPTestConverter() {
    super(NAPTestType.class, NAPTest.class);
  }

  @Override
  public void toSifModel(NAPTest source, NAPTestType target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setTestContent(napTestContentConverter.toSifModel(source));
    }
  }

  @Override
  public void toHitsModel(NAPTestType source, NAPTest target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      napTestContentConverter.toHitsModel(source.getTestContent(), target);
    }
  }
}
