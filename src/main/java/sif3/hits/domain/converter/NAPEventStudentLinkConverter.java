package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsNAPJurisdictionType;
import sif.dd.au30.model.AUCodeSetsNAPParticipationCodeType;
import sif.dd.au30.model.AUCodeSetsSchoolLocationType;
import sif.dd.au30.model.AUCodeSetsSchoolSectorCodeType;
import sif.dd.au30.model.AUCodeSetsSchoolSystemType;
import sif.dd.au30.model.AdjustmentContainerType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.TestDisruptionListType;
import sif.dd.au30.model.TestDisruptionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestDAO;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.model.NAPEventStudentLink;
import sif3.hits.domain.model.NAPTest;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TestDisruption;
import sif3.hits.service.PersonalStudentIdService;

@Component
public class NAPEventStudentLinkConverter extends HitsConverter<NAPEventStudentLinkType, NAPEventStudentLink> {

  @Autowired
  private TestDisruptionConverter testDisruptionConverter;

  @Autowired
  private AdjustmentConverter adjustmentConverter;

  @Autowired
  private StudentPersonalConverter studentPersonalConverter;

  @Autowired
  private NAPTestDAO napTestDao;

  @Autowired
  private SchoolInfoDAO schoolInfoDao;

  @Autowired
  private StudentPersonalDAO studentPersonalDao;

  public NAPEventStudentLinkConverter() {
    super(NAPEventStudentLinkType.class, NAPEventStudentLink.class);
  }

  @Override
  public void toSifModel(NAPEventStudentLink source, NAPEventStudentLinkType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());

      target.setDate(getDateValue(source.getEventDate()));
      target.setDevice(objectFactory.createNAPEventStudentLinkTypeDevice(source.getDevice()));
      target.setDOBRange(objectFactory.createNAPEventStudentLinkTypeDOBRange(getBooleanValue(source.getDobRange())));
      target.setLapsedTimeTest(getDurationValue(source.getLapsedTimeTest()));
      target.setNAPJurisdiction(objectFactory.createNAPEventStudentLinkTypeNAPJurisdiction(getEnumValue(source.getNapJurisdiction(), AUCodeSetsNAPJurisdictionType.class)));
      target.setPersonalDetailsChanged(objectFactory.createNAPEventStudentLinkTypePersonalDetailsChanged(getBooleanValue(source.getPersonalDetailsChanged())));
      target.setPossibleDuplicate(objectFactory.createNAPEventStudentLinkTypePossibleDuplicate(getBooleanValue(source.getPossibleDuplicate())));
      target.setPSIOtherIdMatch(objectFactory.createNAPEventStudentLinkTypePSIOtherIdMatch(getBooleanValue(source.getPsiOtherIdMatch())));
      target.setStartTime(getTimeValue(source.getStartTime()));
      target.setSystem(objectFactory.createNAPEventStudentLinkTypeSystem(getEnumValue(source.getSystem(), AUCodeSetsSchoolSystemType.class)));

      target.setExemptionReason(objectFactory.createNAPEventStudentLinkTypeExemptionReason(source.getExemptionReason()));
      target.setParticipationCode(getEnumValue(source.getParticipationCode(), AUCodeSetsNAPParticipationCodeType.class));
      target.setParticipationText(source.getParticipationText());

      NAPTest napTest = source.getNapTest();
      if (napTest != null) {
        target.setNAPTestLocalId(napTest.getLocalId());
        target.setNAPTestRefId(objectFactory.createNAPEventStudentLinkTypeNAPTestRefId(napTest.getRefId()));
      }

      SchoolInfo schoolInfo = source.getSchoolInfo();
      if (schoolInfo != null) {
        target.setSchoolInfoRefId(objectFactory.createNAPEventStudentLinkTypeSchoolInfoRefId(schoolInfo.getRefId()));
        target.setSchoolACARAId(schoolInfo.getAcaraId());
        target.setSchoolGeolocation(objectFactory.createNAPEventStudentLinkTypeSchoolGeolocation(getEnumValue(schoolInfo.getAddressGeographicLocation(), AUCodeSetsSchoolLocationType.class)));
        target.setSchoolSector(getEnumValue(schoolInfo.getSchoolSector(), AUCodeSetsSchoolSectorCodeType.class));
        target.setReportingSchoolName(objectFactory.createNAPEventStudentLinkTypeReportingSchoolName(schoolInfo.getSchoolName()));
      }

      StudentPersonal studentPersonal = source.getStudentPersonal();
      StudentPersonalType studentPersonalType = studentPersonalConverter.toSifModel(studentPersonal);
      if (studentPersonal != null) {
        target.setStudentPersonalRefId(objectFactory.createNAPEventStudentLinkTypeStudentPersonalRefId(studentPersonal.getRefId()));
        target.setPlatformStudentIdentifier(PersonalStudentIdService.getIdentifier(studentPersonalType));
      }

      AdjustmentContainerType adjustmentContainerType = adjustmentConverter.toSifModel(source.getAdjustment());
      target.setAdjustment(objectFactory.createNAPEventStudentLinkTypeAdjustment(adjustmentContainerType));

      List<TestDisruptionType> testDisruptions = testDisruptionConverter.toSifModelList(source.getTestDisruptions());
      TestDisruptionListType testDisruptionListType = null;
      if (testDisruptions != null && !testDisruptions.isEmpty()) {
        testDisruptionListType = objectFactory.createTestDisruptionListType();
        testDisruptionListType.getTestDisruption().addAll(testDisruptions);
      }
      target.setTestDisruptionList(objectFactory.createNAPEventStudentLinkTypeTestDisruptionList(testDisruptionListType));
    }
  }

  @Override
  public void toHitsModel(NAPEventStudentLinkType source, NAPEventStudentLink target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());

      target.setEventDate(getDateValue(source.getDate()));
      target.setDevice(getJAXBValue(source.getDevice()));
      target.setDobRange(getBooleanValue(getJAXBValue(source.getDOBRange())));
      target.setLapsedTimeTest(getDurationValue(source.getLapsedTimeTest()));
      target.setNapJurisdiction(getJAXBEnumValue(source.getNAPJurisdiction()));
      target.setPersonalDetailsChanged(getBooleanValue(getJAXBValue(source.getPersonalDetailsChanged())));
      target.setPossibleDuplicate(getBooleanValue(getJAXBValue(source.getPossibleDuplicate())));
      target.setPsiOtherIdMatch(getBooleanValue(getJAXBValue(source.getPSIOtherIdMatch())));
      target.setStartTime(getTimeValue(source.getStartTime()));
      target.setSystem(getJAXBEnumValue(source.getSystem()));

      target.setExemptionReason(getJAXBValue(source.getExemptionReason()));
      target.setParticipationCode(getEnumValue(source.getParticipationCode()));
      target.setParticipationText(source.getParticipationText());

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

      String studentPersonalRefId = getJAXBValue(source.getStudentPersonalRefId());
      String studentPersonalIdentifier = source.getPlatformStudentIdentifier();
      StudentPersonal studentPersonal = studentPersonalDao.findOne(studentPersonalRefId);
      if (studentPersonal == null) {
        List<StudentPersonal> studentPersonals = studentPersonalDao.findWithOtherId(PersonalStudentIdService.PERSONAL_STUDENT_IDENTIFIER_TYPE, studentPersonalIdentifier);
        if (!studentPersonals.isEmpty()) {
          studentPersonal = studentPersonals.get(0);
        }
      }
      target.setStudentPersonal(studentPersonal);

      target.setAdjustment(adjustmentConverter.toHitsModel(getJAXBValue(source.getAdjustment())));
      if (target.getAdjustment() != null) {
        target.getAdjustment().setNapEventStudentLink(target);
      }

      if (target.getTestDisruptions() == null) {
        target.setTestDisruptions(new ArrayList<TestDisruption>());
      }
      target.getTestDisruptions().clear();
      TestDisruptionListType testDisruptionListType = getJAXBValue(source.getTestDisruptionList());
      if (testDisruptionListType != null) {
        target.getTestDisruptions().addAll(testDisruptionConverter.toHitsModelList(testDisruptionListType.getTestDisruption()));
        for (TestDisruption testDisruption : target.getTestDisruptions()) {
          testDisruption.setNapEventStudentLink(target);
        }
      }
    }
  }

}
