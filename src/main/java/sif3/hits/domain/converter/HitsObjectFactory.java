package sif3.hits.domain.converter;

import java.math.BigDecimal;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import sif.dd.au30.model.AUCodeSetsOperationalStatusType;
import sif.dd.au30.model.AUCodeSetsSchoolLevelType;
import sif.dd.au30.model.AUCodeSetsStaffStatusType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.DemographicsType;
import sif.dd.au30.model.EmailListType;
import sif.dd.au30.model.GridLocationType;
import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.PhoneNumberListType;
import sif.dd.au30.model.ScheduledActivityType;
import sif.dd.au30.model.SchoolInfoType;
import sif.dd.au30.model.StaffAssignmentType;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.TeachingGroupType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;

/**
 * Proxy for the Object Factory to treat nulls as null instead of nil.
 * 
 * @see sif.dd.au30.model.ObjectFactory
 * @author Ben Carter
 */
public class HitsObjectFactory extends ObjectFactory {
  public JAXBElement<GridLocationType> createAddressTypeGridLocation(sif.dd.au30.model.GridLocationType value) {
    if (value != null) {
      return super.createAddressTypeGridLocation(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createAddressTypeStateProvince(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStateProvince(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createAddressTypeStreetStreetName(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createAddressTypeStreetStreetNumber(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetNumber(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createBaseNameTypeFamilyName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeFamilyName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createBaseNameTypeGivenName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeGivenName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createBaseNameTypeMiddleName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeMiddleName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createBaseNameTypePreferredGivenName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypePreferredGivenName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createBaseNameTypeTitle(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeTitle(value);
    } else {
      return null;
    }
  }

  public JAXBElement<DemographicsType> createDemographics(sif.dd.au30.model.DemographicsType value) {
    if (value != null) {
      return super.createDemographics(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createDemographicsTypeBirthDate(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createDemographicsTypeBirthDate(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createDemographicsTypeCountryOfBirth(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeCountryOfBirth(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createDemographicsTypeIndigenousStatus(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeIndigenousStatus(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createDemographicsTypeSex(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeSex(value);
    } else {
      return null;
    }
  }

  public JAXBElement<EmailListType> createEmailList(sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createEmailList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<PhoneNumberListType> createPhoneNumberList(sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createPhoneNumberList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<Long> createRoomInfoTypeCapacity(java.lang.Long value) {
    if (value != null) {
      return super.createRoomInfoTypeCapacity(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createRoomInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createRoomInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createRoomInfoTypeRoomType(java.lang.String value) {
    if (value != null) {
      return super.createRoomInfoTypeRoomType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<BigDecimal> createRoomInfoTypeSize(java.math.BigDecimal value) {
    if (value != null) {
      return super.createRoomInfoTypeSize(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeActivityComment(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeActivityComment(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeActivityName(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeActivityName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeActivityType(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeActivityType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeCellType(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeCellType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeDayId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeDayId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeLocation(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeLocation(value);
    } else {
      return null;
    }
  }

  public JAXBElement<ScheduledActivityType.Override> createScheduledActivityTypeOverride(
      sif.dd.au30.model.ScheduledActivityType.Override value) {
    if (value != null) {
      return super.createScheduledActivityTypeOverride(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypePeriodId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypePeriodId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<ScheduledActivityType.RoomList> createScheduledActivityTypeRoomList(
      sif.dd.au30.model.ScheduledActivityType.RoomList value) {
    if (value != null) {
      return super.createScheduledActivityTypeRoomList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<ScheduledActivityType.StudentList> createScheduledActivityTypeStudentList(
      sif.dd.au30.model.ScheduledActivityType.StudentList value) {
    if (value != null) {
      return super.createScheduledActivityTypeStudentList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<ScheduledActivityType.TeacherList> createScheduledActivityTypeTeacherList(
      sif.dd.au30.model.ScheduledActivityType.TeacherList value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverCredit(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverCredit(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverFinishTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverFinishTime(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverStartTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverStartTime(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverSupervision(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverSupervision(value);
    } else {
      return null;
    }
  }

  public JAXBElement<BigDecimal> createScheduledActivityTypeTeacherListTeacherCoverWeighting(java.math.BigDecimal value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverWeighting(value);
    } else {
      return null;
    }
  }

  public JAXBElement<ScheduledActivityType.TeachingGroupList> createScheduledActivityTypeTeachingGroupList(
      sif.dd.au30.model.ScheduledActivityType.TeachingGroupList value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeachingGroupList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeTimeTableCellRefId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTimeTableCellRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeTimeTableRefId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTimeTableRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createScheduledActivityTypeTimeTableSubjectRefId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTimeTableSubjectRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<YearLevelsType> createScheduledActivityTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createScheduledActivityTypeYearLevels(value);
    } else {
      return null;
    }
  }

  public JAXBElement<AddressListType> createSchoolInfoTypeAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createSchoolInfoTypeAddressList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<BigDecimal> createSchoolInfoTypeARIA(java.math.BigDecimal value) {
    if (value != null) {
      return super.createSchoolInfoTypeARIA(value);
    } else {
      return null;
    }
  }

  public JAXBElement<SchoolInfoType.Campus> createSchoolInfoTypeCampus(sif.dd.au30.model.SchoolInfoType.Campus value) {
    if (value != null) {
      return super.createSchoolInfoTypeCampus(value);
    } else {
      return null;
    }
  }

  public JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeCampusCampusType(
      sif.dd.au30.model.AUCodeSetsSchoolLevelType value) {
    if (value != null) {
      return super.createSchoolInfoTypeCampusCampusType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createSchoolInfoTypeCommonwealthId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeCommonwealthId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityClose(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolInfoTypeEntityClose(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityOpen(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolInfoTypeEntityOpen(value);
    } else {
      return null;
    }
  }

  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeIndependentSchool(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSchoolInfoTypeIndependentSchool(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createSchoolInfoTypeLocalId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<AUCodeSetsOperationalStatusType> createSchoolInfoTypeOperationalStatus(
      sif.dd.au30.model.AUCodeSetsOperationalStatusType value) {
    if (value != null) {
      return super.createSchoolInfoTypeOperationalStatus(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createSchoolInfoTypeSchoolGeographicLocation(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolGeographicLocation(value);
    } else {
      return null;
    }
  }

  public JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeSchoolType(
      sif.dd.au30.model.AUCodeSetsSchoolLevelType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createSchoolInfoTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStaffAssignmentTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeDescription(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobEndDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobEndDate(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStaffAssignmentTypeJobFunction(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobFunction(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobStartDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobStartDate(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStaffAssignmentTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  public JAXBElement<StaffAssignmentType.StaffActivity> createStaffAssignmentTypeStaffActivity(
      sif.dd.au30.model.StaffAssignmentType.StaffActivity value) {
    if (value != null) {
      return super.createStaffAssignmentTypeStaffActivity(value);
    } else {
      return null;
    }
  }

  public JAXBElement<AUCodeSetsStaffStatusType> createStaffPersonalTypeEmploymentStatus(
      sif.dd.au30.model.AUCodeSetsStaffStatusType value) {
    if (value != null) {
      return super.createStaffPersonalTypeEmploymentStatus(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStaffPersonalTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createStaffPersonalTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<StudentPersonalType.MostRecent> createStudentPersonalTypeMostRecent(
      sif.dd.au30.model.StudentPersonalType.MostRecent value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecent(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1EmploymentType(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1EmploymentType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1Language(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1Language(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1NonSchoolEducation(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1NonSchoolEducation(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2EmploymentType(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2EmploymentType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2Language(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2Language(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2NonSchoolEducation(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2NonSchoolEducation(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(value);
    } else {
      return null;
    }
  }

  public JAXBElement<YearLevelType> createStudentPersonalTypeMostRecentYearLevel(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentYearLevel(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createStudentPersonalTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<BigDecimal> createStudentSchoolEnrollmentTypeFTE(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeFTE(value);
    } else {
      return null;
    }
  }

  public JAXBElement<YearLevelType> createStudentSchoolEnrollmentTypeYearLevel(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeYearLevel(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeLongName(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeLongName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<TeachingGroupType.StudentList> createTeachingGroupTypeStudentList(
      sif.dd.au30.model.TeachingGroupType.StudentList value) {
    if (value != null) {
      return super.createTeachingGroupTypeStudentList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<TeachingGroupType.TeacherList> createTeachingGroupTypeTeacherList(
      sif.dd.au30.model.TeachingGroupType.TeacherList value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeacherList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<TeachingGroupType.TeachingGroupPeriodList> createTeachingGroupTypeTeachingGroupPeriodList(
      sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeRoomNumber(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeRoomNumber(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeStaffLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeStaffLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeStaffPersonalRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeSubjectLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeSubjectLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeTeachingGroupLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeTeachingGroupLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableCellTypeTimeTableLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeTimeTableLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<YearLevelType> createTimeTableSubjectTypeAcademicYear(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeAcademicYear(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableSubjectTypeFaculty(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeFaculty(value);
    } else {
      return null;
    }
  }

  public JAXBElement<OtherCodeListType> createTimeTableSubjectTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  public JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMinClassSize(java.math.BigDecimal value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeProposedMinClassSize(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableSubjectTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createTimeTableSubjectTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  public JAXBElement<Long> createTimeTableSubjectTypeSemester(java.lang.Long value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSemester(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableSubjectTypeSubjectShortName(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSubjectShortName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableSubjectTypeSubjectType(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSubjectType(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableTypeLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableTypeSchoolName(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeSchoolName(value);
    } else {
      return null;
    }
  }

  public JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(
      java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(value);
    } else {
      return null;
    }
  }

  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(value);
    } else {
      return null;
    }
  }
  
  public JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeStartDate(XMLGregorianCalendar value) {
    if (value != null) {
      return super.createCalendarSummaryTypeStartDate(value);
    } else {
      return null;
    }
  }
  
  public JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeEndDate(XMLGregorianCalendar value) {
    if (value != null) {
      return super.createCalendarSummaryTypeEndDate(value);
    } else {
      return null;
    }
  }
}
