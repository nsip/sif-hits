package sif3.hits.test.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsSchoolLevelType;
import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;

public class SchoolInfoTestDataFactory extends HitsTestDataFactory<SchoolInfoType, SchoolInfoCollectionType> {

  public SchoolInfoTestDataFactory(String name) {
    super(SchoolInfoType.class, SchoolInfoCollectionType.class, name);
  }

  // @formatter:off
  private final String[] REF_IDS = 
      { "952e36f1-b85f-4b98-9164-e23e82c03297", 
        "b7a2f9cb-694f-456e-85d3-4360b4b2ea3a", 
        "1ad8379c-08d5-41d7-846e-a69abb0afc0f", 
        "ad92a074-ef68-460c-9240-9d659043aab8", 
        "ec235000-da4e-446c-87f0-be798ec6075f", 
        "eefaffdf-8a7f-405a-9d15-8fbbf7c73b0d", 
        "6058812a-a10e-40e9-992c-b11f967bdaec" }; 
  // @formatter:on
  private final List<String> METHODS_TO_HANDLE = Arrays.asList("setLocalId", "setRefId", "setStateProvinceId", "setCommonwealthId", "setACARAId", "setSchoolName", "setSchoolType");
  private final List<String> METHODS_TO_REJECT = Arrays.asList("getLocalId", "getRefId", "getStateProvinceId", "getCommonwealthId", "getACARAId", "getOtherIdList", "setOtherIdList", "getSchoolName",
      "getLEAInfoRefId", "setLEAInfoRefId", "getOtherLEA", "setOtherLEA", "getSchoolDistrict", "setSchoolDistrict", "getSchoolDistrictLocalId", "setSchoolDistrictLocalId", "getSchoolType",
      "getSchoolFocusList", "setSchoolFocusList", "getSchoolURL", "setSchoolURL", "getSchoolEmailList", "setSchoolEmailList", "getARIA", "getAddressList", "getBoardingSchoolStatus", "getCampus",
      "getEntityClose", "getEntityOpen", "getFederalElectorate", "getIndependentSchool", "getJurisdictionLowerHouse", "getLocalGovernmentArea", "getNonGovSystemicStatus", "getOperationalStatus",
      "getPhoneNumberList", "getPrincipalInfo", "getReligiousAffiliation", "getSLA", "getSchoolCoEdStatus", "getSchoolContactList", "getSchoolGeographicLocation", "getSchoolGroupList",
      "getSchoolSector", "getSessionType", "getSystem", "getTotalEnrollments", "getYearLevelEnrollmentList", "getYearLevels");

  public String[] getRefIds() {
    return REF_IDS;
  }

  @Override
  protected Boolean handleMethod(String name) {
    Boolean result = super.handleMethod(name);
    if (result == null) result = handleMethod(name, METHODS_TO_HANDLE, METHODS_TO_REJECT);
    return result;
  }

  public void setLocalId(SchoolInfoType object, int index) {
    if (index >= 0) object.setLocalId(getObjectFactory().createSchoolInfoTypeLocalId("400" + index));
    else object.setLocalId(getObjectFactory().createSchoolInfoTypeLocalId("" + (3000 + getRandom().nextInt(1000))));
  }

  public void setRefId(SchoolInfoType object, int index) {
    object.setRefId(getRefId(index));
  }

  public void setStateProvinceId(SchoolInfoType object, int index) {
    if (index >= 0) object.setStateProvinceId(getObjectFactory().createSchoolInfoTypeStateProvinceId("WA"));
    else object.setStateProvinceId(getObjectFactory().createSchoolInfoTypeStateProvinceId("VIC"));
  }

  public void setCommonwealthId(SchoolInfoType object, int index) {
    if (index >= 0) object.setCommonwealthId(getObjectFactory().createSchoolInfoTypeCommonwealthId("600" + index));
    else object.setStateProvinceId(getObjectFactory().createSchoolInfoTypeStateProvinceId("" + (5000 + getRandom().nextInt(1000))));
  }

  public void setACARAId(SchoolInfoType object, int index) {
    if (index >= 0) object.setCommonwealthId(getObjectFactory().createSchoolInfoTypeCommonwealthId("6" + index + "4" + index + "28" + index));
    else object.setStateProvinceId(getObjectFactory().createSchoolInfoTypeStateProvinceId("" + (10000000 + getRandom().nextInt(1000000))));
  }

  public void setSchoolName(SchoolInfoType object, int index) {
    if (index >= 0) object.setSchoolName("Test School " + index);
    else object.setSchoolName("Test School " + (10000 + getRandom().nextInt(10000)));
  }

  public void setSchoolType(SchoolInfoType object, int index) {
    if (index >= 0) object.setSchoolType(getObjectFactory().createSchoolInfoTypeSchoolType(AUCodeSetsSchoolLevelType.SEC));
    else object.setSchoolType(getObjectFactory().createSchoolInfoTypeSchoolType(randomEnum(AUCodeSetsSchoolLevelType.class)));
  }

}
