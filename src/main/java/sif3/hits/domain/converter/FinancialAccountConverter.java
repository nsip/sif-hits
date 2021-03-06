package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FinancialAccountType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FinancialAccount;

@Component
public class FinancialAccountConverter extends HitsConverter<FinancialAccountType, FinancialAccount> {

  public FinancialAccountConverter() {
    super(FinancialAccountType.class, FinancialAccount.class);
  }

  @Override
  public void toSifModel(FinancialAccount source, FinancialAccountType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setLocalId(objectFactory.createFinancialAccountTypeLocalId(source.getLocalId()));
      target.setAccountNumber(source.getAccountNumber());
      target.setChargedLocationInfoRefId(objectFactory.createFinancialAccountTypeChargedLocationInfoRefId(source.getLocationInfoRefId()));
      target.setCreationDate(getDateValue(source.getCreationDate()));
      target.setCreationTime(getTimeValue(source.getCreationTime()));
      target.setDescription(objectFactory.createFinancialAccountTypeDescription(source.getDescription()));
      target.setName(source.getName());
      target.setClassType(source.getClassType());
      target.setParentAccountRefId(objectFactory.createFinancialAccountTypeParentAccountRefId(source.getSubAccountRefId()));
      target.setAccountCode(objectFactory.createFinancialAccountTypeAccountCode(source.getAccountCode()));
    }
  }

  @Override
  public void toHitsModel(FinancialAccountType source, FinancialAccount target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setLocalId(getJAXBValue(source.getLocalId()));
      target.setAccountNumber(source.getAccountNumber());
      target.setLocationInfoRefId(getJAXBValue(source.getChargedLocationInfoRefId()));
      target.setCreationDate(getDateValue(source.getCreationDate()));
      target.setCreationTime(getTimeValue(source.getCreationTime()));
      target.setDescription(getJAXBValue(source.getDescription()));
      target.setName(source.getName());
      target.setClassType(source.getClassType());
      target.setSubAccountRefId(getJAXBValue(source.getParentAccountRefId()));
      target.setAccountCode(getJAXBValue(source.getAccountCode()));
    }
  }

}
