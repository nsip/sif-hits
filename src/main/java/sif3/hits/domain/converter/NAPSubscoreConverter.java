package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsNAPWritingRubricTypeType;
import sif.dd.au30.model.NAPSubscoreType;
import sif3.hits.domain.model.NAPSubscore;

@Component
public class NAPSubscoreConverter extends HitsConverter<NAPSubscoreType, NAPSubscore>{
  
  public NAPSubscoreConverter() {
    super(NAPSubscoreType.class, NAPSubscore.class);
  }

  @Override
  public void toSifModel(NAPSubscore source, NAPSubscoreType target) {
    if (source != null && target != null) {
      target.setSubscoreType(getEnumValue(source.getSubscoreType(), AUCodeSetsNAPWritingRubricTypeType.class));
      target.setSubscoreValue(getBigDecimalValue(source.getSubscoreValue()));
    }
  }

  @Override
  public void toHitsModel(NAPSubscoreType source, NAPSubscore target) {
    if (source != null && target != null) {
      target.setSubscoreType(getEnumValue(source.getSubscoreType()));
      target.setSubscoreValue(getBigDecimalValue(source.getSubscoreValue()));
    }
  }

}
