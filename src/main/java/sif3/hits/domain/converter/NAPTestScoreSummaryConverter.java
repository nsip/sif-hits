package sif3.hits.domain.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestScoreSummaryType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestDAO;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.model.NAPTest;
import sif3.hits.domain.model.NAPTestScoreSummary;
import sif3.hits.domain.model.SchoolInfo;

@Component
public class NAPTestScoreSummaryConverter extends HitsConverter<NAPTestScoreSummaryType, NAPTestScoreSummary> {

  @Autowired
  private NAPTestDAO napTestDao;
  
  @Autowired
  private SchoolInfoDAO schoolInfoDao;
  
  public NAPTestScoreSummaryConverter() {
    super(NAPTestScoreSummaryType.class, NAPTestScoreSummary.class);
  }

  @Override
  public void toSifModel(NAPTestScoreSummary source, NAPTestScoreSummaryType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      
      target.setDomainBottomNational60Percent(objectFactory.createNAPTestScoreSummaryTypeDomainBottomNational60Percent(getBigDecimalValue(source.getDomainBottomNational60Percent())));
      target.setDomainJurisdictionAverage(objectFactory.createNAPTestScoreSummaryTypeDomainJurisdictionAverage(getBigDecimalValue(source.getDomainJurisdictionAverage())));
      target.setDomainNationalAverage(objectFactory.createNAPTestScoreSummaryTypeDomainNationalAverage(getBigDecimalValue(source.getDomainNationalAverage())));
      target.setDomainSchoolAverage(objectFactory.createNAPTestScoreSummaryTypeDomainSchoolAverage(getBigDecimalValue(source.getDomainSchoolAverage())));
      target.setDomainTopNational60Percent(objectFactory.createNAPTestScoreSummaryTypeDomainTopNational60Percent(getBigDecimalValue(source.getDomainTopNational60Percent())));

      NAPTest napTest = source.getNapTest();
      if (napTest != null) {
        target.setNAPTestLocalId(napTest.getLocalId());
        target.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(napTest.getRefId()));
      }
      
      SchoolInfo schoolInfo = source.getSchoolInfo();
      if (schoolInfo != null) {
        target.setSchoolACARAId(schoolInfo.getAcaraId());
        target.setSchoolInfoRefId(objectFactory.createNAPTestScoreSummaryTypeSchoolInfoRefId(schoolInfo.getRefId()));
      }
    }
  }

  @Override
  public void toHitsModel(NAPTestScoreSummaryType source, NAPTestScoreSummary target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      
      target.setDomainBottomNational60Percent(getBigDecimalValue(getJAXBValue(source.getDomainBottomNational60Percent())));
      target.setDomainJurisdictionAverage(getBigDecimalValue(getJAXBValue(source.getDomainJurisdictionAverage())));
      target.setDomainNationalAverage(getBigDecimalValue(getJAXBValue(source.getDomainNationalAverage())));
      target.setDomainSchoolAverage(getBigDecimalValue(getJAXBValue(source.getDomainSchoolAverage())));
      target.setDomainTopNational60Percent(getBigDecimalValue(getJAXBValue(source.getDomainTopNational60Percent())));
      
      String napTestRefId = getJAXBValue(source.getNAPTestRefId());
      String napTestLocalId = source.getNAPTestLocalId();
      NAPTest napTest = napTestDao.findOne(napTestRefId);
      if (napTest == null) {
        List<NAPTest> napTests = napTestDao.findWithLocalId(napTestLocalId);
        if (!napTests.isEmpty()) {
          napTest = napTests.get(0);
        }
      }
      target.setNapTest(napTest);
      
      String schoolInfoRefId = getJAXBValue(source.getSchoolInfoRefId());
      String schoolInfoAcaraId = source.getSchoolACARAId();
      SchoolInfo schoolInfo = schoolInfoDao.findOne(schoolInfoRefId);
      if (schoolInfo == null) {
        List<SchoolInfo> schoolInfos = schoolInfoDao.findWithAcaraId(schoolInfoAcaraId);
        if (!schoolInfos.isEmpty()) {
          schoolInfo = schoolInfos.get(0);
        }
      }
      target.setSchoolInfo(schoolInfo);
    }
  }

}
