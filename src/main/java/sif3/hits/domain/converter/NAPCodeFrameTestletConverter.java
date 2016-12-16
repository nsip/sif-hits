package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CodeFrameTestItemListType;
import sif.dd.au30.model.NAPTestletCodeFrameType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.NAPTestlet;

@Component
public class NAPCodeFrameTestletConverter extends HitsConverter<NAPTestletCodeFrameType, NAPTestlet> {

  @Autowired
  private NAPTestletContentConverter napTestletContentConverter;
  
  @Autowired
  private CodeFrameTestItemConverter codeFrameTestItemConverter;

  public NAPCodeFrameTestletConverter() {
    super(NAPTestletCodeFrameType.class, NAPTestlet.class);
  }

  @Override
  public void toSifModel(NAPTestlet source, NAPTestletCodeFrameType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setNAPTestletRefId(objectFactory.createNAPTestletCodeFrameTypeNAPTestletRefId(source.getRefId()));
      target.setTestletContent(napTestletContentConverter.toSifModel(source));

      if (source.getTestItems() != null && !source.getTestItems().isEmpty()) {
        CodeFrameTestItemListType codeFrameTestItemListType = objectFactory.createCodeFrameTestItemListType();
        codeFrameTestItemListType.getTestItem().addAll(codeFrameTestItemConverter.toSifModelList(source.getTestItems()));
        target.setTestItemList(codeFrameTestItemListType);
      }
    }
  }

  @Override
  public void toHitsModel(NAPTestletCodeFrameType source, NAPTestlet target) {
    if (source != null && target != null) {
      // should never be going in this direction
    }
  }

}
