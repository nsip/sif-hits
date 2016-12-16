package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CodeFrameTestItemType;
import sif3.hits.domain.model.NAPTestletTestItem;

@Component
public class CodeFrameTestItemConverter extends HitsConverter<CodeFrameTestItemType, NAPTestletTestItem> {

  @Autowired
  private NAPTestItemContentConverter napTestItemContentConverter;

  public CodeFrameTestItemConverter() {
    super(CodeFrameTestItemType.class, NAPTestletTestItem.class);
  }

  @Override
  public void toSifModel(NAPTestletTestItem source, CodeFrameTestItemType target) {
    if (source != null && target != null) {
      target.setSequenceNumber(getBigIntegerValue(source.getTestletTestItemSequence()));
      if (source.getNapTestItem() != null) {
        target.setTestItemRefId(source.getNapTestItem().getRefId());
        target.setTestItemContent(napTestItemContentConverter.toSifModel(source.getNapTestItem()));
      }

    }
  }

  @Override
  public void toHitsModel(CodeFrameTestItemType source, NAPTestletTestItem target) {
    // should never be going in this direction.
  }

}
