package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestItemType;
import sif3.hits.domain.model.NAPTestItem;

@Component
public class NAPTestItemConverter extends HitsConverter<NAPTestItemType, NAPTestItem> {

  @Autowired
  private NAPTestItemContentConverter napTestItemContentConverter;

  public NAPTestItemConverter() {
    super(NAPTestItemType.class, NAPTestItem.class);
  }

  @Override
  public void toSifModel(NAPTestItem source, NAPTestItemType target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setTestItemContent(napTestItemContentConverter.toSifModel(source));
    }
  }

  @Override
  public void toHitsModel(NAPTestItemType source, NAPTestItem target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      napTestItemContentConverter.toHitsModel(source.getTestItemContent(), target);
    }
  }
}
