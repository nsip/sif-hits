package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestItem2Type;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.domain.model.NAPTestletTestItem;

@Component
public class NAPTestletTestItemConverter extends HitsConverter<NAPTestItem2Type, NAPTestletTestItem> {

  public NAPTestletTestItemConverter() {
    super(NAPTestItem2Type.class, NAPTestletTestItem.class);
  }

  @Override
  public void toSifModel(NAPTestletTestItem source, NAPTestItem2Type target) {
    if (source != null && target != null) {

      NAPTestItem testItem = source.getNapTestItem();
      if (testItem != null) {
        target.setTestItemRefId(testItem.getRefId());
        target.setTestItemLocalId(testItem.getLocalId());
      }
      target.setSequenceNumber(getBigIntegerValue(source.getTestletTestItemSequence()));
    }
  }

  @Override
  public void toHitsModel(NAPTestItem2Type source, NAPTestletTestItem target) {
    if (source != null && target != null) {
      // never going this way
    }
  }

}
