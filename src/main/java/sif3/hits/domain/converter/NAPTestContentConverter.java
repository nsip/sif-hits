package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsNAPTestDomainType;
import sif.dd.au30.model.AUCodeSetsNAPTestTypeType;
import sif.dd.au30.model.DomainBandsContainerType;
import sif.dd.au30.model.DomainProficiencyContainerType;
import sif.dd.au30.model.NAPTestContentType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.NAPTest;

@Component
public class NAPTestContentConverter extends HitsConverter<NAPTestContentType, NAPTest> {

  public NAPTestContentConverter() {
    super(NAPTestContentType.class, NAPTest.class);
  }

  @Override
  public void toSifModel(NAPTest source, NAPTestContentType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setNAPTestLocalId(source.getLocalId());
      target.setTestName(source.getTestName());

      YearLevelType yearLevelType = objectFactory.createYearLevelType();
      yearLevelType.setCode(source.getTestLevel());
      target.setTestLevel(yearLevelType);
      target.setTestType(getEnumValue(source.getTestType(), AUCodeSetsNAPTestTypeType.class));
      target.setDomain(getEnumValue(source.getDomain(), AUCodeSetsNAPTestDomainType.class));
      target.setTestYear(getYearValue(source.getTestYear()));

      // new
      target.setStagesCount(getIntegerValue(source.getStagesCount()));

      DomainBandsContainerType domainBandsContainerType = objectFactory.createDomainBandsContainerType();
      domainBandsContainerType.setBand1Lower(getBigDecimalValue(source.getBand1Lower()));
      domainBandsContainerType.setBand1Upper(getBigDecimalValue(source.getBand1Upper()));
      domainBandsContainerType.setBand2Lower(getBigDecimalValue(source.getBand2Lower()));
      domainBandsContainerType.setBand2Upper(getBigDecimalValue(source.getBand2Upper()));
      domainBandsContainerType.setBand3Lower(getBigDecimalValue(source.getBand3Lower()));
      domainBandsContainerType.setBand3Upper(getBigDecimalValue(source.getBand3Upper()));
      domainBandsContainerType.setBand4Lower(getBigDecimalValue(source.getBand4Lower()));
      domainBandsContainerType.setBand4Upper(getBigDecimalValue(source.getBand4Upper()));
      domainBandsContainerType.setBand5Lower(getBigDecimalValue(source.getBand5Lower()));
      domainBandsContainerType.setBand5Upper(getBigDecimalValue(source.getBand5Upper()));
      domainBandsContainerType.setBand6Lower(getBigDecimalValue(source.getBand6Lower()));
      domainBandsContainerType.setBand6Upper(getBigDecimalValue(source.getBand6Upper()));
      domainBandsContainerType.setBand7Lower(getBigDecimalValue(source.getBand7Lower()));
      domainBandsContainerType.setBand7Upper(getBigDecimalValue(source.getBand7Upper()));
      domainBandsContainerType.setBand8Lower(getBigDecimalValue(source.getBand8Lower()));
      domainBandsContainerType.setBand8Upper(getBigDecimalValue(source.getBand8Upper()));
      domainBandsContainerType.setBand9Lower(getBigDecimalValue(source.getBand9Lower()));
      domainBandsContainerType.setBand9Upper(getBigDecimalValue(source.getBand9Upper()));
      domainBandsContainerType.setBand10Lower(getBigDecimalValue(source.getBand10Lower()));
      domainBandsContainerType.setBand10Upper(getBigDecimalValue(source.getBand10Upper()));
      if (hasDomainBands(source)) {
        target.setDomainBands(domainBandsContainerType);
      }

      DomainProficiencyContainerType domainProficiencyContainerType = objectFactory.createDomainProficiencyContainerType();
      domainProficiencyContainerType.setLevel1Lower(getBigDecimalValue(source.getLevel1Lower()));
      domainProficiencyContainerType.setLevel1Upper(getBigDecimalValue(source.getLevel1Upper()));
      domainProficiencyContainerType.setLevel2Lower(getBigDecimalValue(source.getLevel2Lower()));
      domainProficiencyContainerType.setLevel2Upper(getBigDecimalValue(source.getLevel2Upper()));
      domainProficiencyContainerType.setLevel3Lower(getBigDecimalValue(source.getLevel3Lower()));
      domainProficiencyContainerType.setLevel3Upper(getBigDecimalValue(source.getLevel3Upper()));
      domainProficiencyContainerType.setLevel4Lower(getBigDecimalValue(source.getLevel4Lower()));
      domainProficiencyContainerType.setLevel4Upper(getBigDecimalValue(source.getLevel4Upper()));
      if (hasDomainProficiency(source)) {
        target.setDomainProficiency(domainProficiencyContainerType);
      }
    }
  }

  private boolean hasDomainProficiency(NAPTest source) {
    return source.getBand1Lower() != null || source.getBand1Upper() != null || source.getBand2Lower() != null || source.getBand2Upper() != null || source.getBand3Lower() != null
        || source.getBand3Upper() != null || source.getBand4Lower() != null || source.getBand4Upper() != null || source.getBand5Lower() != null || source.getBand5Upper() != null
        || source.getBand6Lower() != null || source.getBand6Upper() != null || source.getBand7Lower() != null || source.getBand7Upper() != null || source.getBand8Lower() != null
        || source.getBand8Upper() != null || source.getBand9Lower() != null || source.getBand9Upper() != null || source.getBand10Lower() != null || source.getBand10Upper() != null;
  }

  private boolean hasDomainBands(NAPTest source) {
    return source.getLevel1Lower() != null || source.getLevel1Upper() != null || source.getLevel2Lower() != null || source.getLevel2Upper() != null || source.getLevel3Lower() != null
        || source.getLevel3Upper() != null || source.getLevel4Lower() != null || source.getLevel4Upper() != null;
  }

  @Override
  public void toHitsModel(NAPTestContentType source, NAPTest target) {
    if (source != null && target != null) {
      target.setLocalId(source.getNAPTestLocalId());
      target.setTestName(source.getTestName());
      YearLevelType yearLevelType = source.getTestLevel();
      if (yearLevelType != null) {
        target.setTestLevel(yearLevelType.getCode());
      } else {
        target.setTestLevel(null);
      }
      target.setTestType(getEnumValue(source.getTestType()));
      target.setDomain(getEnumValue(source.getDomain()));
      target.setTestYear(getYearValue(source.getTestYear()));
      target.setStagesCount(getIntegerValue(source.getStagesCount()));

      DomainBandsContainerType domainBandsContainerType = source.getDomainBands();
      if (domainBandsContainerType != null) {
        target.setBand1Lower(getBigDecimalValue(domainBandsContainerType.getBand1Lower()));
        target.setBand1Upper(getBigDecimalValue(domainBandsContainerType.getBand1Upper()));
        target.setBand2Lower(getBigDecimalValue(domainBandsContainerType.getBand2Lower()));
        target.setBand2Upper(getBigDecimalValue(domainBandsContainerType.getBand2Upper()));
        target.setBand3Lower(getBigDecimalValue(domainBandsContainerType.getBand3Lower()));
        target.setBand3Upper(getBigDecimalValue(domainBandsContainerType.getBand3Upper()));
        target.setBand4Lower(getBigDecimalValue(domainBandsContainerType.getBand4Lower()));
        target.setBand4Upper(getBigDecimalValue(domainBandsContainerType.getBand4Upper()));
        target.setBand5Lower(getBigDecimalValue(domainBandsContainerType.getBand5Lower()));
        target.setBand5Upper(getBigDecimalValue(domainBandsContainerType.getBand5Upper()));
        target.setBand6Lower(getBigDecimalValue(domainBandsContainerType.getBand6Lower()));
        target.setBand6Upper(getBigDecimalValue(domainBandsContainerType.getBand6Upper()));
        target.setBand7Lower(getBigDecimalValue(domainBandsContainerType.getBand7Lower()));
        target.setBand7Upper(getBigDecimalValue(domainBandsContainerType.getBand7Upper()));
        target.setBand8Lower(getBigDecimalValue(domainBandsContainerType.getBand8Lower()));
        target.setBand8Upper(getBigDecimalValue(domainBandsContainerType.getBand8Upper()));
        target.setBand9Lower(getBigDecimalValue(domainBandsContainerType.getBand9Lower()));
        target.setBand9Upper(getBigDecimalValue(domainBandsContainerType.getBand9Upper()));
        target.setBand10Lower(getBigDecimalValue(domainBandsContainerType.getBand10Lower()));
        target.setBand10Upper(getBigDecimalValue(domainBandsContainerType.getBand10Upper()));
      }

      DomainProficiencyContainerType domainProficiencyContainerType = source.getDomainProficiency();
      if (domainProficiencyContainerType != null) {
        target.setLevel1Lower(getBigDecimalValue(domainProficiencyContainerType.getLevel1Lower()));
        target.setLevel1Upper(getBigDecimalValue(domainProficiencyContainerType.getLevel1Upper()));
        target.setLevel2Lower(getBigDecimalValue(domainProficiencyContainerType.getLevel2Lower()));
        target.setLevel2Upper(getBigDecimalValue(domainProficiencyContainerType.getLevel2Upper()));
        target.setLevel3Lower(getBigDecimalValue(domainProficiencyContainerType.getLevel3Lower()));
        target.setLevel3Upper(getBigDecimalValue(domainProficiencyContainerType.getLevel3Upper()));
        target.setLevel4Lower(getBigDecimalValue(domainProficiencyContainerType.getLevel4Lower()));
        target.setLevel4Upper(getBigDecimalValue(domainProficiencyContainerType.getLevel4Upper()));
      }
    }
  }
}
