package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FinancialClassificationType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.FinancialClass;

@Component
public class FinancialClassConverter extends HitsConverter<FinancialClassificationType, FinancialClass> {

  public FinancialClassConverter() {
    super(FinancialClassificationType.class, FinancialClass.class);
  }

  @Override
  public void toSifModel(FinancialClass source, FinancialClassificationType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setClassificationType(source.getClassType());
      target.setDescription(objectFactory.createFinancialClassificationTypeDescription(source.getDescription()));
      target.setName(source.getName());
    }
  }

  @Override
  public void toHitsModel(FinancialClassificationType source, FinancialClass target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setClassType(source.getClassificationType());
      target.setDescription(getJAXBValue(source.getDescription()));
      target.setName(source.getName());
    }
  }

}
