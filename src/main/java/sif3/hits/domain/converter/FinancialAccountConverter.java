package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FinancialAccountType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.FinancialAccount;

@Component
public class FinancialAccountConverter extends HitsConverter<FinancialAccountType, FinancialAccount>{
  
  public FinancialAccountConverter() {
    super(FinancialAccountType.class, FinancialAccount.class);
  }

  @Override
  public void toSifModel(FinancialAccount source, FinancialAccountType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      
      target.setRefId(source.getRefId());
      target.setAccountNumber(source.getAccountNumber());
      target.setChargedLocationInfoRefId(objectFactory.createFinancialAccountTypeChargedLocationInfoRefId(source.getLocationInfoRefId()));
      target.setCreationDate(getDateValue(source.getCreationDate()));
      target.setCreationTime(getTimeValue(source.getCreationTime()));
      target.setDescription(objectFactory.createFinancialAccountTypeDescription(source.getDescription()));
      target.setFinancialClassificationRefId(source.getFinancialClassRefId());
      target.setName(source.getName());
      target.setSubAccountRefId(objectFactory.createFinancialAccountTypeSubAccountRefId(source.getSubAccountRefId()));
    }
  }

  @Override
  public void toHitsModel(FinancialAccountType source, FinancialAccount target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setAccountNumber(source.getAccountNumber());
      target.setLocationInfoRefId(getJAXBValue(source.getChargedLocationInfoRefId()));
      target.setCreationDate(getDateValue(source.getCreationDate()));
      target.setCreationTime(getTimeValue(source.getCreationTime()));
      target.setDescription(getJAXBValue(source.getDescription()));
      target.setFinancialClassRefId(source.getFinancialClassificationRefId());
      target.setName(source.getName());
      target.setSubAccountRefId(getJAXBValue(source.getSubAccountRefId()));
    }
  }

}
