package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TestDisruptionType;
import sif3.hits.domain.model.TestDisruption;

@Component
public class TestDisruptionConverter extends HitsConverter<TestDisruptionType, TestDisruption> {

  public TestDisruptionConverter() {
    super(TestDisruptionType.class, TestDisruption.class);
  }

  @Override
  public void toSifModel(TestDisruption source, TestDisruptionType target) {
    if (source != null && target != null) {
      target.setEvent(source.getEvent());
    }
  }

  @Override
  public void toHitsModel(TestDisruptionType source, TestDisruption target) {
    if (source != null && target != null) {
      target.setEvent(source.getEvent());
    }
  }

}
