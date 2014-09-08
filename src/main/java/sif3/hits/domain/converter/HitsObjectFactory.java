package sif3.hits.domain.converter;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import sif.dd.au30.model.*;

public class HitsObjectFactory extends ObjectFactory {

  @Override
  public JAXBElement<LanguageListType> createLanguageList(sif.dd.au30.model.LanguageListType value) {
    if (value != null) {
      return super.createLanguageList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAssetType> createSif3AssessmentAsset(sif.dd.au30.model.Sif3AssessmentAssetType value) {
    if (value != null) {
      return super.createSif3AssessmentAsset(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType> createDemographics(sif.dd.au30.model.DemographicsType value) {
    if (value != null) {
      return super.createDemographics(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemAssociationCollectionType> createSif3AssessmentItemAssociations(
      sif.dd.au30.model.Sif3AssessmentItemAssociationCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentItemAssociations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolInfoType> createSchoolInfo(sif.dd.au30.model.SchoolInfoType value) {
    if (value != null) {
      return super.createSchoolInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFQueryType> createSIFQuery(sif.dd.au30.model.SIFQueryType value) {
    if (value != null) {
      return super.createSIFQuery(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createProjectedGraduationYear(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createProjectedGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentScoreSetCollectionType> createStudentScoreSets(
      sif.dd.au30.model.StudentScoreSetCollectionType value) {
    if (value != null) {
      return super.createStudentScoreSets(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourcePackageType> createLearningResourcePackage(
      sif.dd.au30.model.LearningResourcePackageType value) {
    if (value != null) {
      return super.createLearningResourcePackage(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportAuthorityInfoCollectionType> createReportAuthorityInfos(
      sif.dd.au30.model.ReportAuthorityInfoCollectionType value) {
    if (value != null) {
      return super.createReportAuthorityInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SectionInfoType> createSectionInfo(sif.dd.au30.model.SectionInfoType value) {
    if (value != null) {
      return super.createSectionInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemAssociationType> createSif3AssessmentItemAssociation(
      sif.dd.au30.model.Sif3AssessmentItemAssociationType value) {
    if (value != null) {
      return super.createSif3AssessmentItemAssociation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFContext(java.lang.String value) {
    if (value != null) {
      return super.createSIFContext(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TeachingGroupType> createTeachingGroup(sif.dd.au30.model.TeachingGroupType value) {
    if (value != null) {
      return super.createTeachingGroup(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarSummaryType> createCalendarSummary(sif.dd.au30.model.CalendarSummaryType value) {
    if (value != null) {
      return super.createCalendarSummary(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSnapshotCollectionType> createStudentSnapshots(
      sif.dd.au30.model.StudentSnapshotCollectionType value) {
    if (value != null) {
      return super.createStudentSnapshots(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityType> createScheduledActivity(sif.dd.au30.model.ScheduledActivityType value) {
    if (value != null) {
      return super.createScheduledActivity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentCollectionType> createStudentPersonals(sif.dd.au30.model.StudentCollectionType value) {
    if (value != null) {
      return super.createStudentPersonals(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TermInfoCollectionType> createTermInfos(sif.dd.au30.model.TermInfoCollectionType value) {
    if (value != null) {
      return super.createTermInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestCollectionType> createSif3AssessmentSubTests(
      sif.dd.au30.model.Sif3AssessmentSubTestCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentSubTests(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaType> createSubjectArea(sif.dd.au30.model.SubjectAreaType value) {
    if (value != null) {
      return super.createSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailListType> createEmailList(sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createEmailList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffAssignmentType> createStaffAssignment(sif.dd.au30.model.StaffAssignmentType value) {
    if (value != null) {
      return super.createStaffAssignment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSessionCollectionType> createSif3AssessmentSessions(
      sif.dd.au30.model.Sif3AssessmentSessionCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentSessions(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberType> createPhoneNumber(sif.dd.au30.model.PhoneNumberType value) {
    if (value != null) {
      return super.createPhoneNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TeachingGroupCollectionType> createTeachingGroups(
      sif.dd.au30.model.TeachingGroupCollectionType value) {
    if (value != null) {
      return super.createTeachingGroups(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createCountry(java.lang.String value) {
    if (value != null) {
      return super.createCountry(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSubjectAreaList(sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSubjectAreaList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSchoolYear(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolCourseInfoCollectionType> createSchoolCourseInfos(
      sif.dd.au30.model.SchoolCourseInfoCollectionType value) {
    if (value != null) {
      return super.createSchoolCourseInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType> createStudentSchoolEnrollment(
      sif.dd.au30.model.StudentSchoolEnrollmentType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentRegistrationType> createAssessmentRegistration(
      sif.dd.au30.model.AssessmentRegistrationType value) {
    if (value != null) {
      return super.createAssessmentRegistration(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentScoreTableType> createSif3AssessmentScoreTable(
      sif.dd.au30.model.Sif3AssessmentScoreTableType value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTable(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentFormCollectionType> createAssessmentForms(
      sif.dd.au30.model.AssessmentFormCollectionType value) {
    if (value != null) {
      return super.createAssessmentForms(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentRegistrationCollectionType> createAssessmentRegistrations(
      sif.dd.au30.model.AssessmentRegistrationCollectionType value) {
    if (value != null) {
      return super.createAssessmentRegistrations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentActivityInfoCollectionType> createStudentActivityInfos(
      sif.dd.au30.model.StudentActivityInfoCollectionType value) {
    if (value != null) {
      return super.createStudentActivityInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableSubjectCollectionType> createTimeTableSubjects(
      sif.dd.au30.model.TimeTableSubjectCollectionType value) {
    if (value != null) {
      return super.createTimeTableSubjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createHomeroomNumber(java.lang.String value) {
    if (value != null) {
      return super.createHomeroomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherNamesType> createOtherNames(sif.dd.au30.model.OtherNamesType value) {
    if (value != null) {
      return super.createOtherNames(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType> createActivity(sif.dd.au30.model.ActivityType value) {
    if (value != null) {
      return super.createActivity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailType> createEmail(sif.dd.au30.model.EmailType value) {
    if (value != null) {
      return super.createEmail(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffCollectionType> createStaffPersonals(sif.dd.au30.model.StaffCollectionType value) {
    if (value != null) {
      return super.createStaffPersonals(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRubricCollectionType> createSif3AssessmentRubrics(
      sif.dd.au30.model.Sif3AssessmentRubricCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentRubrics(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createOtherCodeList(sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentAdministrationCollectionType> createAssessmentAdministrations(
      sif.dd.au30.model.AssessmentAdministrationCollectionType value) {
    if (value != null) {
      return super.createAssessmentAdministrations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentDailyAttendanceCollectionType> createStudentDailyAttendances(
      sif.dd.au30.model.StudentDailyAttendanceCollectionType value) {
    if (value != null) {
      return super.createStudentDailyAttendances(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFReportObjectType> createSIFReportObject(sif.dd.au30.model.SIFReportObjectType value) {
    if (value != null) {
      return super.createSIFReportObject(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PersonPictureType> createPersonPicture(sif.dd.au30.model.PersonPictureType value) {
    if (value != null) {
      return super.createPersonPicture(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportManifestType> createReportManifest(sif.dd.au30.model.ReportManifestType value) {
    if (value != null) {
      return super.createReportManifest(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentParticipationCollectionType> createStudentParticipations(
      sif.dd.au30.model.StudentParticipationCollectionType value) {
    if (value != null) {
      return super.createStudentParticipations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStateProvince(java.lang.String value) {
    if (value != null) {
      return super.createStateProvince(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentFormType> createAssessmentForm(sif.dd.au30.model.AssessmentFormType value) {
    if (value != null) {
      return super.createAssessmentForm(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentAttendanceSummaryType> createStudentAttendanceSummary(
      sif.dd.au30.model.StudentAttendanceSummaryType value) {
    if (value != null) {
      return super.createStudentAttendanceSummary(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateStatisticFactCollectionType> createAggregateStatisticFacts(
      sif.dd.au30.model.AggregateStatisticFactCollectionType value) {
    if (value != null) {
      return super.createAggregateStatisticFacts(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAdministrationType> createSif3AssessmentAdministration(
      sif.dd.au30.model.Sif3AssessmentAdministrationType value) {
    if (value != null) {
      return super.createSif3AssessmentAdministration(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolProgramsType> createSchoolPrograms(sif.dd.au30.model.SchoolProgramsType value) {
    if (value != null) {
      return super.createSchoolPrograms(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LifeCycleType> createLifeCycle(sif.dd.au30.model.LifeCycleType value) {
    if (value != null) {
      return super.createLifeCycle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPeriodAttendanceType> createStudentPeriodAttendance(
      sif.dd.au30.model.StudentPeriodAttendanceType value) {
    if (value != null) {
      return super.createStudentPeriodAttendance(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportManifestCollectionType> createReportManifests(
      sif.dd.au30.model.ReportManifestCollectionType value) {
    if (value != null) {
      return super.createReportManifests(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SummaryEnrollmentInfoType> createSummaryEnrollmentInfo(
      sif.dd.au30.model.SummaryEnrollmentInfoType value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SummaryEnrollmentInfoCollectionType> createSummaryEnrollmentInfos(
      sif.dd.au30.model.SummaryEnrollmentInfoCollectionType value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactRelationshipCollectionType> createStudentContactRelationships(
      sif.dd.au30.model.StudentContactRelationshipCollectionType value) {
    if (value != null) {
      return super.createStudentContactRelationships(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRegistrationType> createSif3AssessmentRegistration(
      sif.dd.au30.model.Sif3AssessmentRegistrationType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistration(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createPhoneNumberList(sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createPhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffAssignmentCollectionType> createStaffAssignments(
      sif.dd.au30.model.StaffAssignmentCollectionType value) {
    if (value != null) {
      return super.createStaffAssignments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarSummaryCollectionType> createCalendarSummarys(
      sif.dd.au30.model.CalendarSummaryCollectionType value) {
    if (value != null) {
      return super.createCalendarSummarys(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactRelationshipType> createStudentContactRelationship(
      sif.dd.au30.model.StudentContactRelationshipType value) {
    if (value != null) {
      return super.createStudentContactRelationship(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createSIFAuthenticationLevel(java.lang.Long value) {
    if (value != null) {
      return super.createSIFAuthenticationLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateCharacteristicInfoType> createAggregateCharacteristicInfo(
      sif.dd.au30.model.AggregateCharacteristicInfoType value) {
    if (value != null) {
      return super.createAggregateCharacteristicInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createPublishInDirectory(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createPublishInDirectory(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ResourceUsageType> createResourceUsage(sif.dd.au30.model.ResourceUsageType value) {
    if (value != null) {
      return super.createResourceUsage(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<IdentityCollectionType> createIdentitys(sif.dd.au30.model.IdentityCollectionType value) {
    if (value != null) {
      return super.createIdentitys(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateStatisticFactType> createAggregateStatisticFact(
      sif.dd.au30.model.AggregateStatisticFactType value) {
    if (value != null) {
      return super.createAggregateStatisticFact(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateCharacteristicInfoCollectionType> createAggregateCharacteristicInfos(
      sif.dd.au30.model.AggregateCharacteristicInfoCollectionType value) {
    if (value != null) {
      return super.createAggregateCharacteristicInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressListType> createAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createAddressList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType> createSif3AssessmentItem(sif.dd.au30.model.Sif3AssessmentItemType value) {
    if (value != null) {
      return super.createSif3AssessmentItem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateStatisticInfoType> createAggregateStatisticInfo(
      sif.dd.au30.model.AggregateStatisticInfoType value) {
    if (value != null) {
      return super.createAggregateStatisticInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardDocumentType> createLearningStandardDocument(
      sif.dd.au30.model.LearningStandardDocumentType value) {
    if (value != null) {
      return super.createLearningStandardDocument(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourcePackageCollectionType> createLearningResourcePackages(
      sif.dd.au30.model.LearningResourcePackageCollectionType value) {
    if (value != null) {
      return super.createLearningResourcePackages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType> createLearningResource(sif.dd.au30.model.LearningResourceType value) {
    if (value != null) {
      return super.createLearningResource(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AttendanceCodeType> createAttendanceCode(sif.dd.au30.model.AttendanceCodeType value) {
    if (value != null) {
      return super.createAttendanceCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createSIFEncryptionLevel(java.lang.Long value) {
    if (value != null) {
      return super.createSIFEncryptionLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ACStrandSubjectAreaType> createACStrandSubjectArea(sif.dd.au30.model.ACStrandSubjectAreaType value) {
    if (value != null) {
      return super.createACStrandSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ResourceUsageCollectionType> createResourceUsages(
      sif.dd.au30.model.ResourceUsageCollectionType value) {
    if (value != null) {
      return super.createResourceUsages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createEducationalLevel(java.lang.String value) {
    if (value != null) {
      return super.createEducationalLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EducationFilterType> createEducationFilter(sif.dd.au30.model.EducationFilterType value) {
    if (value != null) {
      return super.createEducationFilter(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentScoreTableCollectionType> createSif3AssessmentScoreTables(
      sif.dd.au30.model.Sif3AssessmentScoreTableCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTables(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateStatisticInfoCollectionType> createAggregateStatisticInfos(
      sif.dd.au30.model.AggregateStatisticInfoCollectionType value) {
    if (value != null) {
      return super.createAggregateStatisticInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ElectronicIdListType> createElectronicIdList(sif.dd.au30.model.ElectronicIdListType value) {
    if (value != null) {
      return super.createElectronicIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRubricType> createSif3AssessmentRubric(
      sif.dd.au30.model.Sif3AssessmentRubricType value) {
    if (value != null) {
      return super.createSif3AssessmentRubric(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ElectronicIdType> createElectronicId(sif.dd.au30.model.ElectronicIdType value) {
    if (value != null) {
      return super.createElectronicId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createAddress(sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableType> createTimeTable(sif.dd.au30.model.TimeTableType value) {
    if (value != null) {
      return super.createTimeTable(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentItemType> createAssessmentItem(sif.dd.au30.model.AssessmentItemType value) {
    if (value != null) {
      return super.createAssessmentItem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createYearLevel(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType> createSif3AssessmentForm(sif.dd.au30.model.Sif3AssessmentFormType value) {
    if (value != null) {
      return super.createSif3AssessmentForm(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SessionInfoType> createSessionInfo(sif.dd.au30.model.SessionInfoType value) {
    if (value != null) {
      return super.createSessionInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentItemCollectionType> createAssessmentItems(
      sif.dd.au30.model.AssessmentItemCollectionType value) {
    if (value != null) {
      return super.createAssessmentItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<RoomInfoCollectionType> createRoomInfos(sif.dd.au30.model.RoomInfoCollectionType value) {
    if (value != null) {
      return super.createRoomInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentType> createAssessment(sif.dd.au30.model.AssessmentType value) {
    if (value != null) {
      return super.createAssessment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeElementType> createTimeElement(sif.dd.au30.model.TimeElementType value) {
    if (value != null) {
      return super.createTimeElement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableCellCollectionType> createTimeTableCells(
      sif.dd.au30.model.TimeTableCellCollectionType value) {
    if (value != null) {
      return super.createTimeTableCells(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentCollectionType> createSif3Assessments(
      sif.dd.au30.model.Sif3AssessmentCollectionType value) {
    if (value != null) {
      return super.createSif3Assessments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SystemRoleType> createSystemRole(sif.dd.au30.model.SystemRoleType value) {
    if (value != null) {
      return super.createSystemRole(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentActivityParticipationCollectionType> createStudentActivityParticipations(
      sif.dd.au30.model.StudentActivityParticipationCollectionType value) {
    if (value != null) {
      return super.createStudentActivityParticipations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableCellType> createTimeTableCell(sif.dd.au30.model.TimeTableCellType value) {
    if (value != null) {
      return super.createTimeTableCell(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNType> createStudentSDTN(sif.dd.au30.model.StudentSDTNType value) {
    if (value != null) {
      return super.createStudentSDTN(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardDocumentCollectionType> createLearningStandardDocuments(
      sif.dd.au30.model.LearningStandardDocumentCollectionType value) {
    if (value != null) {
      return super.createLearningStandardDocuments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestType> createAssessmentSubTest(sif.dd.au30.model.AssessmentSubTestType value) {
    if (value != null) {
      return super.createAssessmentSubTest(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType> createLearningStandardItem(
      sif.dd.au30.model.LearningStandardItemType value) {
    if (value != null) {
      return super.createLearningStandardItem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemCollectionType> createLearningStandardItems(
      sif.dd.au30.model.LearningStandardItemCollectionType value) {
    if (value != null) {
      return super.createLearningStandardItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSectionEnrollmentCollectionType> createStudentSectionEnrollments(
      sif.dd.au30.model.StudentSectionEnrollmentCollectionType value) {
    if (value != null) {
      return super.createStudentSectionEnrollments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createBirthDate(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createBirthDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAssetCollectionType> createSif3AssessmentAssets(
      sif.dd.au30.model.Sif3AssessmentAssetCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentAssets(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3StudentResponseSetCollectionType> createSif3StudentResponseSets(
      sif.dd.au30.model.Sif3StudentResponseSetCollectionType value) {
    if (value != null) {
      return super.createSif3StudentResponseSets(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableSubjectType> createTimeTableSubject(sif.dd.au30.model.TimeTableSubjectType value) {
    if (value != null) {
      return super.createTimeTableSubject(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3StudentResponseSetType> createSif3StudentResponseSet(
      sif.dd.au30.model.Sif3StudentResponseSetType value) {
    if (value != null) {
      return super.createSif3StudentResponseSet(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolProgramsCollectionType> createSchoolProgramss(
      sif.dd.au30.model.SchoolProgramsCollectionType value) {
    if (value != null) {
      return super.createSchoolProgramss(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ContactInfoType> createContactInfo(sif.dd.au30.model.ContactInfoType value) {
    if (value != null) {
      return super.createContactInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<RelationshipType> createRelationship(sif.dd.au30.model.RelationshipType value) {
    if (value != null) {
      return super.createRelationship(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemCollectionType> createSif3AssessmentItems(
      sif.dd.au30.model.Sif3AssessmentItemCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestCollectionType> createAssessmentSubTests(
      sif.dd.au30.model.AssessmentSubTestCollectionType value) {
    if (value != null) {
      return super.createAssessmentSubTests(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarDateCollectionType> createCalendarDates(sif.dd.au30.model.CalendarDateCollectionType value) {
    if (value != null) {
      return super.createCalendarDates(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSnapshotType> createStudentSnapshot(sif.dd.au30.model.StudentSnapshotType value) {
    if (value != null) {
      return super.createStudentSnapshot(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLocalId(java.lang.String value) {
    if (value != null) {
      return super.createLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPeriodAttendanceCollectionType> createStudentPeriodAttendances(
      sif.dd.au30.model.StudentPeriodAttendanceCollectionType value) {
    if (value != null) {
      return super.createStudentPeriodAttendances(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentActivityParticipationType> createStudentActivityParticipation(
      sif.dd.au30.model.StudentActivityParticipationType value) {
    if (value != null) {
      return super.createStudentActivityParticipation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TermInfoType> createTermInfo(sif.dd.au30.model.TermInfoType value) {
    if (value != null) {
      return super.createTermInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<RoomInfoType> createRoomInfo(sif.dd.au30.model.RoomInfoType value) {
    if (value != null) {
      return super.createRoomInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentPackageCollectionType> createAssessmentPackages(
      sif.dd.au30.model.AssessmentPackageCollectionType value) {
    if (value != null) {
      return super.createAssessmentPackages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentActivityInfoType> createStudentActivityInfo(sif.dd.au30.model.StudentActivityInfoType value) {
    if (value != null) {
      return super.createStudentActivityInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactPersonalType> createStudentContactPersonal(
      sif.dd.au30.model.StudentContactPersonalType value) {
    if (value != null) {
      return super.createStudentContactPersonal(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolContactListType> createSchoolContactList(sif.dd.au30.model.SchoolContactListType value) {
    if (value != null) {
      return super.createSchoolContactList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPersonalType> createStudentPersonal(sif.dd.au30.model.StudentPersonalType value) {
    if (value != null) {
      return super.createStudentPersonal(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFContextsType> createSIFContexts(sif.dd.au30.model.SIFContextsType value) {
    if (value != null) {
      return super.createSIFContexts(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormCollectionType> createSif3AssessmentForms(
      sif.dd.au30.model.Sif3AssessmentFormCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentForms(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolURL(java.lang.String value) {
    if (value != null) {
      return super.createSchoolURL(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PersonPictureCollectionType> createPersonPictures(
      sif.dd.au30.model.PersonPictureCollectionType value) {
    if (value != null) {
      return super.createPersonPictures(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PrincipalInfoType> createPrincipalInfo(sif.dd.au30.model.PrincipalInfoType value) {
    if (value != null) {
      return super.createPrincipalInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactCollectionType> createStudentContactPersonals(
      sif.dd.au30.model.StudentContactCollectionType value) {
    if (value != null) {
      return super.createStudentContactPersonals(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentPackageType> createAssessmentPackage(sif.dd.au30.model.AssessmentPackageType value) {
    if (value != null) {
      return super.createAssessmentPackage(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportAuthorityInfoType> createReportAuthorityInfo(sif.dd.au30.model.ReportAuthorityInfoType value) {
    if (value != null) {
      return super.createReportAuthorityInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentAttendanceSummaryCollectionType> createStudentAttendanceSummarys(
      sif.dd.au30.model.StudentAttendanceSummaryCollectionType value) {
    if (value != null) {
      return super.createStudentAttendanceSummarys(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffPersonalType> createStaffPersonal(sif.dd.au30.model.StaffPersonalType value) {
    if (value != null) {
      return super.createStaffPersonal(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAdministrationCollectionType> createSif3AssessmentAdministrations(
      sif.dd.au30.model.Sif3AssessmentAdministrationCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarDate> createCalendarDate(sif.dd.au30.model.CalendarDate value) {
    if (value != null) {
      return super.createCalendarDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentAdministrationType> createAssessmentAdministration(
      sif.dd.au30.model.AssessmentAdministrationType value) {
    if (value != null) {
      return super.createAssessmentAdministration(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SectionInfoCollectionType> createSectionInfos(sif.dd.au30.model.SectionInfoCollectionType value) {
    if (value != null) {
      return super.createSectionInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentParticipationType> createStudentParticipation(
      sif.dd.au30.model.StudentParticipationType value) {
    if (value != null) {
      return super.createStudentParticipation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<GridLocationType> createGridLocation(sif.dd.au30.model.GridLocationType value) {
    if (value != null) {
      return super.createGridLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSessionType> createSif3AssessmentSession(
      sif.dd.au30.model.Sif3AssessmentSessionType value) {
    if (value != null) {
      return super.createSif3AssessmentSession(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SystemRoleCollectionType> createSystemRoles(sif.dd.au30.model.SystemRoleCollectionType value) {
    if (value != null) {
      return super.createSystemRoles(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EnglishProficiencyType> createEnglishProficiency(sif.dd.au30.model.EnglishProficiencyType value) {
    if (value != null) {
      return super.createEnglishProficiency(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSectionType> createSif3AssessmentSection(
      sif.dd.au30.model.Sif3AssessmentSectionType value) {
    if (value != null) {
      return super.createSif3AssessmentSection(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LEAInfoCollectionType> createLEAInfos(sif.dd.au30.model.LEAInfoCollectionType value) {
    if (value != null) {
      return super.createLEAInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceCollectionType> createLearningResources(
      sif.dd.au30.model.LearningResourceCollectionType value) {
    if (value != null) {
      return super.createLearningResources(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentType> createSif3Assessment(sif.dd.au30.model.Sif3AssessmentType value) {
    if (value != null) {
      return super.createSif3Assessment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentCollectionType> createAssessments(sif.dd.au30.model.AssessmentCollectionType value) {
    if (value != null) {
      return super.createAssessments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestType> createSif3AssessmentSubTest(
      sif.dd.au30.model.Sif3AssessmentSubTestType value) {
    if (value != null) {
      return super.createSif3AssessmentSubTest(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSIFExtendedElements(sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentCollectionType> createStudentSchoolEnrollments(
      sif.dd.au30.model.StudentSchoolEnrollmentCollectionType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createOnTimeGraduationYear(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createOnTimeGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableCollectionType> createTimeTables(sif.dd.au30.model.TimeTableCollectionType value) {
    if (value != null) {
      return super.createTimeTables(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LocationType> createLocation(sif.dd.au30.model.LocationType value) {
    if (value != null) {
      return super.createLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSectionCollectionType> createSif3AssessmentSections(
      sif.dd.au30.model.Sif3AssessmentSectionCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentSections(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolCollectionType> createSchoolInfos(sif.dd.au30.model.SchoolCollectionType value) {
    if (value != null) {
      return super.createSchoolInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRegistrationCollectionType> createSif3AssessmentRegistrations(
      sif.dd.au30.model.Sif3AssessmentRegistrationCollectionType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsOperationalStatusType> createOperationalStatus(
      sif.dd.au30.model.AUCodeSetsOperationalStatusType value) {
    if (value != null) {
      return super.createOperationalStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNCollectionType> createStudentSDTNs(sif.dd.au30.model.StudentSDTNCollectionType value) {
    if (value != null) {
      return super.createStudentSDTNs(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentDailyAttendanceType> createStudentDailyAttendance(
      sif.dd.au30.model.StudentDailyAttendanceType value) {
    if (value != null) {
      return super.createStudentDailyAttendance(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolCourseInfoType> createSchoolCourseInfo(sif.dd.au30.model.SchoolCourseInfoType value) {
    if (value != null) {
      return super.createSchoolCourseInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSectionEnrollmentType> createStudentSectionEnrollment(
      sif.dd.au30.model.StudentSectionEnrollmentType value) {
    if (value != null) {
      return super.createStudentSectionEnrollment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LEAInfoType> createLEAInfo(sif.dd.au30.model.LEAInfoType value) {
    if (value != null) {
      return super.createLEAInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentScoreSetType> createStudentScoreSet(sif.dd.au30.model.StudentScoreSetType value) {
    if (value != null) {
      return super.createStudentScoreSet(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityCollectionType> createActivitys(sif.dd.au30.model.ActivityCollectionType value) {
    if (value != null) {
      return super.createActivitys(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFReportObjectCollectionType> createSIFReportObjects(
      sif.dd.au30.model.SIFReportObjectCollectionType value) {
    if (value != null) {
      return super.createSIFReportObjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PersonInfoType> createPersonInfo(sif.dd.au30.model.PersonInfoType value) {
    if (value != null) {
      return super.createPersonInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createGraduationDate(java.lang.String value) {
    if (value != null) {
      return super.createGraduationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<NameType> createName(sif.dd.au30.model.NameType value) {
    if (value != null) {
      return super.createName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ProgramStatusType> createProgramStatus(sif.dd.au30.model.ProgramStatusType value) {
    if (value != null) {
      return super.createProgramStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SessionInfoCollectionType> createSessionInfos(sif.dd.au30.model.SessionInfoCollectionType value) {
    if (value != null) {
      return super.createSessionInfos(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<IdentityType> createIdentity(sif.dd.au30.model.IdentityType value) {
    if (value != null) {
      return super.createIdentity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityCollectionType> createScheduledActivitys(
      sif.dd.au30.model.ScheduledActivityCollectionType value) {
    if (value != null) {
      return super.createScheduledActivitys(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaType> createACStrandSubjectAreaTypeSubjectArea(sif.dd.au30.model.SubjectAreaType value) {
    if (value != null) {
      return super.createACStrandSubjectAreaTypeSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestType.ScoreRange> createAssessmentSubTestTypeScoreRange(
      sif.dd.au30.model.AssessmentSubTestType.ScoreRange value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeScoreRange(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestType.PerformanceLevels> createAssessmentSubTestTypePerformanceLevels(
      sif.dd.au30.model.AssessmentSubTestType.PerformanceLevels value) {
    if (value != null) {
      return super.createAssessmentSubTestTypePerformanceLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createAssessmentSubTestTypeSubTestTier(java.lang.Long value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeSubTestTier(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Boolean> createAssessmentSubTestTypeContainerOnly(java.lang.Boolean value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeContainerOnly(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestType.AssessmentSubTestRefIds> createAssessmentSubTestTypeAssessmentSubTestRefIds(
      sif.dd.au30.model.AssessmentSubTestType.AssessmentSubTestRefIds value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeAssessmentSubTestRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypeAbbreviation(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeAbbreviation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createAssessmentSubTestTypeNumberOfItems(java.lang.Long value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeNumberOfItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestType.LearningStandardItemRefIds> createAssessmentSubTestTypeLearningStandardItemRefIds(
      sif.dd.au30.model.AssessmentSubTestType.LearningStandardItemRefIds value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeLearningStandardItemRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypeSubjectArea(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentSubTestTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createAssessmentSubTestTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentSubTestTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotOnTimeGraduationYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotOnTimeGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotStateProvinceId(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotNeglectedDelinquent(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotNeglectedDelinquent(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotEconomicDisadvantage(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotEconomicDisadvantage(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAge(java.lang.Long value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAge(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotProjectedGraduationYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotProjectedGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationOnTime(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationOnTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationDate(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotSex(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotSex(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<NameType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotName(
      sif.dd.au30.model.NameType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGiftedTalented(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGiftedTalented(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationAward(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationAward(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAddress(
      sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreCode(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreValue(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreValue(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreType(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createStudentSDTNTypeFurtherInformationPhoneNumberList(
      sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createStudentSDTNTypeFurtherInformationPhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailListType> createStudentSDTNTypeFurtherInformationEmailList(
      sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createStudentSDTNTypeFurtherInformationEmailList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<NameOfRecordType> createStudentSDTNTypeFurtherInformationContactName(
      sif.dd.au30.model.NameOfRecordType value) {
    if (value != null) {
      return super.createStudentSDTNTypeFurtherInformationContactName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(
      java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(
      java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentTypeAssessmentId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentTypeAssessmentId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentTypeAssessmentPackageRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentTypeAssessmentPackageRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentType.AssessmentDescriptors> createAssessmentTypeAssessmentDescriptors(
      sif.dd.au30.model.AssessmentType.AssessmentDescriptors value) {
    if (value != null) {
      return super.createAssessmentTypeAssessmentDescriptors(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(
      java.lang.Long value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaType> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(
      sif.dd.au30.model.SubjectAreaType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType> createPersonInfoTypeDemographics(sif.dd.au30.model.DemographicsType value) {
    if (value != null) {
      return super.createPersonInfoTypeDemographics(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherNamesType> createPersonInfoTypeOtherNames(sif.dd.au30.model.OtherNamesType value) {
    if (value != null) {
      return super.createPersonInfoTypeOtherNames(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressListType> createPersonInfoTypeAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createPersonInfoTypeAddressList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createPersonInfoTypePhoneNumberList(
      sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createPersonInfoTypePhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailListType> createPersonInfoTypeEmailList(sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createPersonInfoTypeEmailList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createResourceUsageTypeResourceUsageContentTypeLocalDescription(java.lang.String value) {
    if (value != null) {
      return super.createResourceUsageTypeResourceUsageContentTypeLocalDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeOtherLearningAreasListOtherLearningAreaResult(
      sif.dd.au30.model.AUCodeSetsProgressLevelType value) {
    if (value != null) {
      return super.createStudentSDTNTypeOtherLearningAreasListOtherLearningAreaResult(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStateProvince(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStateProvince(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeAddressGlobalUID(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeAddressGlobalUID(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeLocalId(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeRadioContact(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeRadioContact(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType.MapReference> createAddressTypeMapReference(
      sif.dd.au30.model.AddressType.MapReference value) {
    if (value != null) {
      return super.createAddressTypeMapReference(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeCountry(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeCountry(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeCommunity(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeCommunity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<GridLocationType> createAddressTypeGridLocation(sif.dd.au30.model.GridLocationType value) {
    if (value != null) {
      return super.createAddressTypeGridLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType.StatisticalAreas> createAddressTypeStatisticalAreas(
      sif.dd.au30.model.AddressType.StatisticalAreas value) {
    if (value != null) {
      return super.createAddressTypeStatisticalAreas(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeFinishDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createActivityTypeActivityTimeFinishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeStartDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createActivityTypeActivityTimeStartDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeDueDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createActivityTypeActivityTimeDueDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.ActivityTime.Duration> createActivityTypeActivityTimeDuration(
      sif.dd.au30.model.ActivityType.ActivityTime.Duration value) {
    if (value != null) {
      return super.createActivityTypeActivityTimeDuration(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createAttendanceCodeTypeOtherCodeList(sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createAttendanceCodeTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLEAInfoTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createLEAInfoTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLEAInfoTypeSLA(java.lang.String value) {
    if (value != null) {
      return super.createLEAInfoTypeSLA(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LEAInfoType.EducationAgencyType> createLEAInfoTypeEducationAgencyType(
      sif.dd.au30.model.LEAInfoType.EducationAgencyType value) {
    if (value != null) {
      return super.createLEAInfoTypeEducationAgencyType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsOperationalStatusType> createLEAInfoTypeOperationalStatus(
      sif.dd.au30.model.AUCodeSetsOperationalStatusType value) {
    if (value != null) {
      return super.createLEAInfoTypeOperationalStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLEAInfoTypeCommonwealthId(java.lang.String value) {
    if (value != null) {
      return super.createLEAInfoTypeCommonwealthId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressListType> createLEAInfoTypeAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createLEAInfoTypeAddressList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LEAInfoType.LEAContactList> createLEAInfoTypeLEAContactList(
      sif.dd.au30.model.LEAInfoType.LEAContactList value) {
    if (value != null) {
      return super.createLEAInfoTypeLEAContactList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createLEAInfoTypePhoneNumberList(sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createLEAInfoTypePhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createLEAInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createLEAInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLEAInfoTypeLEAURL(java.lang.String value) {
    if (value != null) {
      return super.createLEAInfoTypeLEAURL(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createLEAInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createLEAInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLEAInfoTypeJurisdictionLowerHouse(java.lang.String value) {
    if (value != null) {
      return super.createLEAInfoTypeJurisdictionLowerHouse(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.LearningObjectives> createActivityTypeLearningObjectives(
      sif.dd.au30.model.ActivityType.LearningObjectives value) {
    if (value != null) {
      return super.createActivityTypeLearningObjectives(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.Students> createActivityTypeStudents(sif.dd.au30.model.ActivityType.Students value) {
    if (value != null) {
      return super.createActivityTypeStudents(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createActivityTypePoints(java.lang.Long value) {
    if (value != null) {
      return super.createActivityTypePoints(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeTitle(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeTitle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.EssentialMaterials> createActivityTypeEssentialMaterials(
      sif.dd.au30.model.ActivityType.EssentialMaterials value) {
    if (value != null) {
      return super.createActivityTypeEssentialMaterials(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeAssessmentRefId(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeAssessmentRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createActivityTypeActivityWeight(java.math.BigDecimal value) {
    if (value != null) {
      return super.createActivityTypeActivityWeight(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.TechnicalRequirements> createActivityTypeTechnicalRequirements(
      sif.dd.au30.model.ActivityType.TechnicalRequirements value) {
    if (value != null) {
      return super.createActivityTypeTechnicalRequirements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.Prerequisites> createActivityTypePrerequisites(
      sif.dd.au30.model.ActivityType.Prerequisites value) {
    if (value != null) {
      return super.createActivityTypePrerequisites(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.SoftwareRequirementList> createActivityTypeSoftwareRequirementList(
      sif.dd.au30.model.ActivityType.SoftwareRequirementList value) {
    if (value != null) {
      return super.createActivityTypeSoftwareRequirementList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.LearningResources> createActivityTypeLearningResources(
      sif.dd.au30.model.ActivityType.LearningResources value) {
    if (value != null) {
      return super.createActivityTypeLearningResources(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createActivityTypeMaxAttemptsAllowed(java.lang.Long value) {
    if (value != null) {
      return super.createActivityTypeMaxAttemptsAllowed(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.Evaluation> createActivityTypeEvaluation(
      sif.dd.au30.model.ActivityType.Evaluation value) {
    if (value != null) {
      return super.createActivityTypeEvaluation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypePreamble(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypePreamble(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.SourceObjects> createActivityTypeSourceObjects(
      sif.dd.au30.model.ActivityType.SourceObjects value) {
    if (value != null) {
      return super.createActivityTypeSourceObjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createActivityTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createActivityTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaType> createActivityTypeSubjectArea(sif.dd.au30.model.SubjectAreaType value) {
    if (value != null) {
      return super.createActivityTypeSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createActivityTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createActivityTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ActivityType.LearningStandards> createActivityTypeLearningStandards(
      sif.dd.au30.model.ActivityType.LearningStandards value) {
    if (value != null) {
      return super.createActivityTypeLearningStandards(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeStaffLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeStaffLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeSubjectLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeSubjectLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeTimeTableLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeTimeTableLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeStaffPersonalRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeRoomNumber(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeRoomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createTimeTableCellTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createTimeTableCellTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createTimeTableCellTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createTimeTableCellTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableCellTypeTeachingGroupLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableCellTypeTeachingGroupLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFQueryDataModelType.SIFConditionGroup> createSIFQueryDataModelTypeSIFConditionGroup(
      sif.dd.au30.model.SIFQueryDataModelType.SIFConditionGroup value) {
    if (value != null) {
      return super.createSIFQueryDataModelTypeSIFConditionGroup(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ObjectType> createSIFQueryDataModelTypeSIFExample(sif.dd.au30.model.ObjectType value) {
    if (value != null) {
      return super.createSIFQueryDataModelTypeSIFExample(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<IdentityType.IdentityAssertions> createIdentityTypeIdentityAssertions(
      sif.dd.au30.model.IdentityType.IdentityAssertions value) {
    if (value != null) {
      return super.createIdentityTypeIdentityAssertions(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<IdentityType.PasswordList> createIdentityTypePasswordList(
      sif.dd.au30.model.IdentityType.PasswordList value) {
    if (value != null) {
      return super.createIdentityTypePasswordList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createIdentityTypeAuthenticationSourceGlobalUID(java.lang.String value) {
    if (value != null) {
      return super.createIdentityTypeAuthenticationSourceGlobalUID(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createIdentityTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createIdentityTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createIdentityTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createIdentityTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeEffectiveDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeEffectiveDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LocationType> createAggregateStatisticInfoTypeLocation(sif.dd.au30.model.LocationType value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAggregateStatisticInfoTypeMeasure(java.lang.String value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeMeasure(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeDiscontinueDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeDiscontinueDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateStatisticInfoType.CalculationRule> createAggregateStatisticInfoTypeCalculationRule(
      sif.dd.au30.model.AggregateStatisticInfoType.CalculationRule value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeCalculationRule(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeApprovalDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeApprovalDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeExpirationDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeExpirationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAggregateStatisticInfoTypeSource(java.lang.String value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeSource(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AggregateStatisticInfoType.ExclusionRules> createAggregateStatisticInfoTypeExclusionRules(
      sif.dd.au30.model.AggregateStatisticInfoType.ExclusionRules value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeExclusionRules(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAggregateStatisticInfoTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAggregateStatisticInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAggregateStatisticInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeLearningResourcePackageRefId(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeLearningResourcePackageRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeAuthor(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeAuthor(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.Location> createLearningResourceTypeLocation(
      sif.dd.au30.model.LearningResourceType.Location value) {
    if (value != null) {
      return super.createLearningResourceTypeLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.SubjectAreas> createLearningResourceTypeSubjectAreas(
      sif.dd.au30.model.LearningResourceType.SubjectAreas value) {
    if (value != null) {
      return super.createLearningResourceTypeSubjectAreas(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.Approvals> createLearningResourceTypeApprovals(
      sif.dd.au30.model.LearningResourceType.Approvals value) {
    if (value != null) {
      return super.createLearningResourceTypeApprovals(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeUseAgreement(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeUseAgreement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.Contacts> createLearningResourceTypeContacts(
      sif.dd.au30.model.LearningResourceType.Contacts value) {
    if (value != null) {
      return super.createLearningResourceTypeContacts(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.MediaTypes> createLearningResourceTypeMediaTypes(
      sif.dd.au30.model.LearningResourceType.MediaTypes value) {
    if (value != null) {
      return super.createLearningResourceTypeMediaTypes(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningResourceTypeAgreementDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningResourceTypeAgreementDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeStatus(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.Evaluations> createLearningResourceTypeEvaluations(
      sif.dd.au30.model.LearningResourceType.Evaluations value) {
    if (value != null) {
      return super.createLearningResourceTypeEvaluations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createLearningResourceTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createLearningResourceTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createLearningResourceTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createLearningResourceTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createLearningResourceTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createLearningResourceTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.LearningStandards> createLearningResourceTypeLearningStandards(
      sif.dd.au30.model.LearningResourceType.LearningStandards value) {
    if (value != null) {
      return super.createLearningResourceTypeLearningStandards(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeCampusCampusType(
      sif.dd.au30.model.AUCodeSetsSchoolLevelType value) {
    if (value != null) {
      return super.createSchoolInfoTypeCampusCampusType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeCampusParentSchoolId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeCampusParentSchoolId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStartTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStartTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeReferralDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeReferralDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentParticipationType.ProgramAvailability> createStudentParticipationTypeProgramAvailability(
      sif.dd.au30.model.StudentParticipationType.ProgramAvailability value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramAvailability(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypePlacementParentalConsentDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypePlacementParentalConsentDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentParticipationTypeGiftedEligibilityCriteria(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentParticipationTypeGiftedEligibilityCriteria(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationExtensionDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeEvaluationExtensionDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentParticipationTypeParticipationContact(java.lang.String value) {
    if (value != null) {
      return super.createStudentParticipationTypeParticipationContact(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlacementDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramPlacementDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentParticipationTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentParticipationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentParticipationType.ReferralSource> createStudentParticipationTypeReferralSource(
      sif.dd.au30.model.StudentParticipationType.ReferralSource value) {
    if (value != null) {
      return super.createStudentParticipationTypeReferralSource(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentParticipationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentParticipationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentParticipationTypeEntryPerson(java.lang.String value) {
    if (value != null) {
      return super.createStudentParticipationTypeEntryPerson(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeEvaluationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeReevaluationDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeReevaluationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Boolean> createStudentParticipationTypeExtendedSchoolYear(java.lang.Boolean value) {
    if (value != null) {
      return super.createStudentParticipationTypeExtendedSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeNOREPDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeNOREPDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Boolean> createStudentParticipationTypeExtendedDay(java.lang.Boolean value) {
    if (value != null) {
      return super.createStudentParticipationTypeExtendedDay(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramEligibilityDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramEligibilityDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationParentalConsentDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeEvaluationParentalConsentDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentParticipationType.ProgramFundingSources> createStudentParticipationTypeProgramFundingSources(
      sif.dd.au30.model.StudentParticipationType.ProgramFundingSources value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramFundingSources(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlanDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramPlanDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ProgramStatusType> createStudentParticipationTypeProgramStatus(
      sif.dd.au30.model.ProgramStatusType value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentParticipationTypeExtensionComments(java.lang.String value) {
    if (value != null) {
      return super.createStudentParticipationTypeExtensionComments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentParticipationTypeProgramType(java.lang.String value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createStudentParticipationTypeStudentSpecialEducationFTE(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStudentParticipationTypeStudentSpecialEducationFTE(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlanEffectiveDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramPlanEffectiveDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardItemTypeStandardSettingBodyStateProvince(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardSettingBodyStateProvince(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardItemTypeStandardSettingBodySettingBodyName(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardSettingBodySettingBodyName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAssetType.AssetIdentifiers> createSif3AssessmentAssetTypeAssetIdentifiers(
      sif.dd.au30.model.Sif3AssessmentAssetType.AssetIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAssetTypeAssetLanguage(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetLanguage(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAssetTypeAssetName(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAssetTypeAssetVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAssetType.AssetLearningStandards> createSif3AssessmentAssetTypeAssetLearningStandards(
      sif.dd.au30.model.Sif3AssessmentAssetType.AssetLearningStandards value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetLearningStandards(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAssetTypeAssetOwner(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetOwner(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentAssetTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSif3AssessmentAssetTypeAssetSubjects(
      sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetSubjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentAssetTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createSif3AssessmentAssetTypeAssetGradeLevels(
      sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetGradeLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentAssetTypeAssetPublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentAssetTypeAssetPublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseCredits(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideCourseCredits(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideDistrictCourseCode(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideDistrictCourseCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideStateCourseCode(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideStateCourseCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseTitle(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideCourseTitle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideInstructionalLevel(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideInstructionalLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaType> createSectionInfoTypeSchoolCourseInfoOverrideSubjectArea(
      sif.dd.au30.model.SubjectAreaType value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseCode(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverrideCourseCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList(
      sif.dd.au30.model.Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValuePassFailIndicator(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreValuesScoreValuePassFailIndicator(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeFirstInstructionDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createCalendarSummaryTypeFirstInstructionDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeLastInstructionDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createCalendarSummaryTypeLastInstructionDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createCalendarSummaryTypeGraduationDate(java.lang.String value) {
    if (value != null) {
      return super.createCalendarSummaryTypeGraduationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createCalendarSummaryTypeInstructionalMinutes(java.lang.Long value) {
    if (value != null) {
      return super.createCalendarSummaryTypeInstructionalMinutes(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createCalendarSummaryTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createCalendarSummaryTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createCalendarSummaryTypeMinutesPerDay(java.lang.Long value) {
    if (value != null) {
      return super.createCalendarSummaryTypeMinutesPerDay(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeEndDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createCalendarSummaryTypeEndDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeStartDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createCalendarSummaryTypeStartDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createCalendarSummaryTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createCalendarSummaryTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createCalendarSummaryTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createCalendarSummaryTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createCalendarSummaryTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createCalendarSummaryTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSummaryEnrollmentInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSummaryEnrollmentInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createEnglishProficiencyTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createEnglishProficiencyTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList> createSystemRoleTypeSystemContextListSystemContextRoleList(
      sif.dd.au30.model.SystemRoleType.SystemContextList.SystemContext.RoleList value) {
    if (value != null) {
      return super.createSystemRoleTypeSystemContextListSystemContextRoleList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2Language(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2Language(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createStudentPersonalTypeMostRecentYearLevel(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1Language(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1Language(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2EmploymentType(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2EmploymentType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1NonSchoolEducation(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1NonSchoolEducation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent1EmploymentType(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent1EmploymentType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentHomeroomLocalId(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentHomeroomLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeMostRecentParent2NonSchoolEducation(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecentParent2NonSchoolEducation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeReligiousAffiliation(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeReligiousAffiliation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSchoolURL(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolURL(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PrincipalInfoType> createSchoolInfoTypePrincipalInfo(sif.dd.au30.model.PrincipalInfoType value) {
    if (value != null) {
      return super.createSchoolInfoTypePrincipalInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolInfoType.OtherIdList> createSchoolInfoTypeOtherIdList(
      sif.dd.au30.model.SchoolInfoType.OtherIdList value) {
    if (value != null) {
      return super.createSchoolInfoTypeOtherIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeFederalElectorate(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeFederalElectorate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolInfoType.Campus> createSchoolInfoTypeCampus(sif.dd.au30.model.SchoolInfoType.Campus value) {
    if (value != null) {
      return super.createSchoolInfoTypeCampus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSLA(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSLA(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityOpen(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolInfoTypeEntityOpen(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeLocalGovernmentArea(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeLocalGovernmentArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSchoolDistrict(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolDistrict(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsSystemicStatusType> createSchoolInfoTypeNonGovSystemicStatus(
      sif.dd.au30.model.AUCodeSetsSystemicStatusType value) {
    if (value != null) {
      return super.createSchoolInfoTypeNonGovSystemicStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSystem(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSystem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeCommonwealthId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeCommonwealthId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolInfoType.SchoolGroupList> createSchoolInfoTypeSchoolGroupList(
      sif.dd.au30.model.SchoolInfoType.SchoolGroupList value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolGroupList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityClose(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolInfoTypeEntityClose(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolInfoType.SchoolFocusList> createSchoolInfoTypeSchoolFocusList(
      sif.dd.au30.model.SchoolInfoType.SchoolFocusList value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolFocusList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createSchoolInfoTypePhoneNumberList(
      sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createSchoolInfoTypePhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSchoolInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSchoolGeographicLocation(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolGeographicLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSchoolInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSessionType(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSessionType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeBoardingSchoolStatus(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSchoolInfoTypeBoardingSchoolStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolInfoType.OtherLEA> createSchoolInfoTypeOtherLEA(
      sif.dd.au30.model.SchoolInfoType.OtherLEA value) {
    if (value != null) {
      return super.createSchoolInfoTypeOtherLEA(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeSchoolDistrictLocalId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolDistrictLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsOperationalStatusType> createSchoolInfoTypeOperationalStatus(
      sif.dd.au30.model.AUCodeSetsOperationalStatusType value) {
    if (value != null) {
      return super.createSchoolInfoTypeOperationalStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressListType> createSchoolInfoTypeAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createSchoolInfoTypeAddressList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsSchoolCoEdStatusType> createSchoolInfoTypeSchoolCoEdStatus(
      sif.dd.au30.model.AUCodeSetsSchoolCoEdStatusType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolCoEdStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeJurisdictionLowerHouse(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeJurisdictionLowerHouse(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeLEAInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeLEAInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolInfoTypeLocalId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolInfoTypeLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createSchoolInfoTypeARIA(java.math.BigDecimal value) {
    if (value != null) {
      return super.createSchoolInfoTypeARIA(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolContactListType> createSchoolInfoTypeSchoolContactList(
      sif.dd.au30.model.SchoolContactListType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolContactList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeSchoolType(
      sif.dd.au30.model.AUCodeSetsSchoolLevelType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeIndependentSchool(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSchoolInfoTypeIndependentSchool(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailListType> createSchoolInfoTypeSchoolEmailList(sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createSchoolInfoTypeSchoolEmailList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createSchoolInfoTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createSchoolInfoTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeVisaStatisticalCode(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeVisaStatisticalCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypePlaceOfBirth(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypePlaceOfBirth(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LanguageListType> createDemographicsTypeLanguageList(sif.dd.au30.model.LanguageListType value) {
    if (value != null) {
      return super.createDemographicsTypeLanguageList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createDemographicsTypeVisaExpiryDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createDemographicsTypeVisaExpiryDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createDemographicsTypeBirthDate(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createDemographicsTypeBirthDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeCulturalBackground(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeCulturalBackground(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeAustralianCitizenshipStatus(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeAustralianCitizenshipStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsImmunisationCertificateStatusType> createDemographicsTypeImmunisationCertificateStatus(
      sif.dd.au30.model.AUCodeSetsImmunisationCertificateStatusType value) {
    if (value != null) {
      return super.createDemographicsTypeImmunisationCertificateStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeBirthDateVerification(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeBirthDateVerification(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypePermanentResident(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypePermanentResident(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType.ReligiousEventList> createDemographicsTypeReligiousEventList(
      sif.dd.au30.model.DemographicsType.ReligiousEventList value) {
    if (value != null) {
      return super.createDemographicsTypeReligiousEventList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType.Religion> createDemographicsTypeReligion(
      sif.dd.au30.model.DemographicsType.Religion value) {
    if (value != null) {
      return super.createDemographicsTypeReligion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeCountryOfBirth(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeCountryOfBirth(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EnglishProficiencyType> createDemographicsTypeEnglishProficiency(
      sif.dd.au30.model.EnglishProficiencyType value) {
    if (value != null) {
      return super.createDemographicsTypeEnglishProficiency(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeIndigenousStatus(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeIndigenousStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createDemographicsTypeCountryArrivalDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createDemographicsTypeCountryArrivalDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeMaritalStatus(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeMaritalStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType.CountriesOfResidency> createDemographicsTypeCountriesOfResidency(
      sif.dd.au30.model.DemographicsType.CountriesOfResidency value) {
    if (value != null) {
      return super.createDemographicsTypeCountriesOfResidency(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeSex(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeSex(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType.DwellingArrangement> createDemographicsTypeDwellingArrangement(
      sif.dd.au30.model.DemographicsType.DwellingArrangement value) {
    if (value != null) {
      return super.createDemographicsTypeDwellingArrangement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeReligiousRegion(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeReligiousRegion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<DemographicsType.CountriesOfCitizenship> createDemographicsTypeCountriesOfCitizenship(
      sif.dd.au30.model.DemographicsType.CountriesOfCitizenship value) {
    if (value != null) {
      return super.createDemographicsTypeCountriesOfCitizenship(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeVisaSubClass(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeVisaSubClass(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createDemographicsTypeStateOfBirth(java.lang.String value) {
    if (value != null) {
      return super.createDemographicsTypeStateOfBirth(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeResponseChoicesChoiceResponseFeedback(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeResponseChoicesChoiceResponseFeedback(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Float> createSif3AssessmentItemTypeResponseChoicesChoiceCreditValue(java.lang.Float value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeResponseChoicesChoiceCreditValue(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeResponseChoicesChoiceChoiceLabel(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeResponseChoicesChoiceChoiceLabel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentPackageType.XMLData> createAssessmentPackageTypeXMLData(
      sif.dd.au30.model.AssessmentPackageType.XMLData value) {
    if (value != null) {
      return super.createAssessmentPackageTypeXMLData(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentPackageTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentPackageTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentPackageTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentPackageTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeLongName(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeLongName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TeachingGroupType.TeachingGroupPeriodList> createTeachingGroupTypeTeachingGroupPeriodList(
      sif.dd.au30.model.TeachingGroupType.TeachingGroupPeriodList value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeachingGroupPeriodList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeCurriculumLevel(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeCurriculumLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeSchoolCourseLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSchoolCourseLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createTeachingGroupTypeSemester(java.lang.Long value) {
    if (value != null) {
      return super.createTeachingGroupTypeSemester(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigInteger> createTeachingGroupTypeMaxClassSize(java.math.BigInteger value) {
    if (value != null) {
      return super.createTeachingGroupTypeMaxClassSize(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TeachingGroupType.TeacherList> createTeachingGroupTypeTeacherList(
      sif.dd.au30.model.TeachingGroupType.TeacherList value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeacherList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeSet(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSet(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeSchoolCourseInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSchoolCourseInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTimeTableSubjectRefId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTimeTableSubjectRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeBlock(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeBlock(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTimeTableSubjectLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTimeTableSubjectLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigInteger> createTeachingGroupTypeMinClassSize(java.math.BigInteger value) {
    if (value != null) {
      return super.createTeachingGroupTypeMinClassSize(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TeachingGroupType.StudentList> createTeachingGroupTypeStudentList(
      sif.dd.au30.model.TeachingGroupType.StudentList value) {
    if (value != null) {
      return super.createTeachingGroupTypeStudentList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createTeachingGroupTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createTeachingGroupTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createTeachingGroupTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createTeachingGroupTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypePromotionInfoPromotionStatus(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypePromotionInfoPromotionStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId(
      sif.dd.au30.model.SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId value) {
    if (value != null) {
      return super
          .createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeName(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.PromotionInfo> createStudentSchoolEnrollmentTypePromotionInfo(
      sif.dd.au30.model.StudentSchoolEnrollmentType.PromotionInfo value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypePromotionInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.Homeroom> createStudentSchoolEnrollmentTypeHomeroom(
      sif.dd.au30.model.StudentSchoolEnrollmentType.Homeroom value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeHomeroom(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createStudentSchoolEnrollmentTypeYearLevel(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.Calendar> createStudentSchoolEnrollmentTypeCalendar(
      sif.dd.au30.model.StudentSchoolEnrollmentType.Calendar value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeCalendar(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.Counselor> createStudentSchoolEnrollmentTypeCounselor(
      sif.dd.au30.model.StudentSchoolEnrollmentType.Counselor value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeCounselor(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSchoolEnrollmentTypeExitDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeExitDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeFTPTStatus(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeFTPTStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.EntryType> createStudentSchoolEnrollmentTypeEntryType(
      sif.dd.au30.model.StudentSchoolEnrollmentType.EntryType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeEntryType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.ExitStatus> createStudentSchoolEnrollmentTypeExitStatus(
      sif.dd.au30.model.StudentSchoolEnrollmentType.ExitStatus value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeExitStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.StudentSubjectChoiceList> createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(
      sif.dd.au30.model.StudentSchoolEnrollmentType.StudentSubjectChoiceList value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeFFPOS(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeFFPOS(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypePreviousSchool(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypePreviousSchool(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.CatchmentStatus> createStudentSchoolEnrollmentTypeCatchmentStatus(
      sif.dd.au30.model.StudentSchoolEnrollmentType.CatchmentStatus value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeCatchmentStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.Advisor> createStudentSchoolEnrollmentTypeAdvisor(
      sif.dd.au30.model.StudentSchoolEnrollmentType.Advisor value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeAdvisor(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeHouse(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeHouse(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSchoolEnrollmentType.ExitType> createStudentSchoolEnrollmentTypeExitType(
      sif.dd.au30.model.StudentSchoolEnrollmentType.ExitType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeExitType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeHomegroup(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeHomegroup(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeRecordClosureReason(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeRecordClosureReason(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSchoolEnrollmentTypeDestinationSchool(java.lang.String value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeDestinationSchool(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentSchoolEnrollmentTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createStudentSchoolEnrollmentTypeFTE(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeFTE(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentSchoolEnrollmentTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSchoolEnrollmentTypeIndividualLearningPlan(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeIndividualLearningPlan(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(
      java.lang.String value) {
    if (value != null) {
      return super.createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(
      java.lang.String value) {
    if (value != null) {
      return super.createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createLEAInfoTypeLEAContactListLEAContactPublishInDirectory(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createLEAInfoTypeLEAContactListLEAContactPublishInDirectory(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createTimeTableSubjectTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createTimeTableSubjectTypeAcademicYear(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeAcademicYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTimeTableSubjectTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeTableSubjectType.AcademicYearRange> createTimeTableSubjectTypeAcademicYearRange(
      sif.dd.au30.model.TimeTableSubjectType.AcademicYearRange value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeAcademicYearRange(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeFaculty(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeFaculty(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createTimeTableSubjectTypeSemester(java.lang.Long value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSemester(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeSubjectType(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSubjectType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMinClassSize(java.math.BigDecimal value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeProposedMinClassSize(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeCourseLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeCourseLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMaxClassSize(java.math.BigDecimal value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeProposedMaxClassSize(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeSchoolCourseInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSchoolCourseInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeSubjectShortName(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSubjectShortName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableSubjectTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createTimeTableSubjectTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createTimeTableSubjectTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createTimeTableSubjectTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createAssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentRegistrationTypeAssessmentStudentSnapshotSex(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeAssessmentStudentSnapshotSex(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemCommentsCommentCommentDescription(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemCommentsCommentCommentDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeMainlySpeaksEnglishAtHome(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeMainlySpeaksEnglishAtHome(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsSourceCodeTypeType> createStudentContactRelationshipTypeContactSequenceSource(
      sif.dd.au30.model.AUCodeSetsSourceCodeTypeType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactSequenceSource(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentContactRelationshipTypeStudentContactRelationshipRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeStudentContactRelationshipRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactRelationshipType.ContactFlags> createStudentContactRelationshipTypeContactFlags(
      sif.dd.au30.model.StudentContactRelationshipType.ContactFlags value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlags(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactRelationshipType.HouseholdList> createStudentContactRelationshipTypeHouseholdList(
      sif.dd.au30.model.StudentContactRelationshipType.HouseholdList value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeHouseholdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentContactRelationshipTypeContactSequence(java.lang.Long value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactSequence(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentContactRelationshipTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentContactRelationshipTypeParentRelationshipStatus(java.lang.String value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeParentRelationshipStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentContactRelationshipTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodInstructionalMinutes(
      java.lang.Long value) {
    if (value != null) {
      return super
          .createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodInstructionalMinutes(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(
      java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodUseInAttendanceCalculations(
      java.lang.String value) {
    if (value != null) {
      return super
          .createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodUseInAttendanceCalculations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodRegularSchoolPeriod(
      java.lang.String value) {
    if (value != null) {
      return super
          .createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodRegularSchoolPeriod(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AbstractContentElementType> createSif3AssessmentRubricTypeScoresScoreScoreCodeDefinition(
      sif.dd.au30.model.AbstractContentElementType value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeScoresScoreScoreCodeDefinition(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRubricTypeScoresScoreScoreCode(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeScoresScoreScoreCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreComments> createSif3AssessmentRubricTypeScoresScoreScoreComments(
      sif.dd.au30.model.Sif3AssessmentRubricType.Scores.Score.ScoreComments value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeScoresScoreScoreComments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions> createSif3AssessmentRubricTypeScoresScoreScoreDescriptions(
      sif.dd.au30.model.Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeScoresScoreScoreDescriptions(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createResourceUsageTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createResourceUsageTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createResourceUsageTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createResourceUsageTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolInfoRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentFullYearEnrollment(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentFullYearEnrollment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolName(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom(
      sif.dd.au30.model.Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStateProvinceId(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroomNumber(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStudentSchoolEnrollmentRefId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStudentSchoolEnrollmentRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeSectionSealed(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionSealed(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeItemSelectionAlgorithm(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeItemSelectionAlgorithm(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSectionType.SectionAssets> createSif3AssessmentSectionTypeSectionAssets(
      sif.dd.au30.model.Sif3AssessmentSectionType.SectionAssets value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionAssets(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSectionType.SectionItems> createSif3AssessmentSectionTypeSectionItems(
      sif.dd.au30.model.Sif3AssessmentSectionType.SectionItems value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<javax.xml.datatype.Duration> createSif3AssessmentSectionTypeSectionTimeLimit(
      javax.xml.datatype.Duration value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionTimeLimit(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeSectionName(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeSectionVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSectionType.SectionIdentifiers> createSif3AssessmentSectionTypeSectionIdentifiers(
      sif.dd.au30.model.Sif3AssessmentSectionType.SectionIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeItemSelectionAlgorithmName(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeItemSelectionAlgorithmName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeSectionReentry(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionReentry(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentSectionTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentSectionTypeSectionPublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionPublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentSectionTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LocationType> createStudentActivityInfoTypeLocation(sif.dd.au30.model.LocationType value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentActivityInfoTypeCurricularStatus(java.lang.String value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeCurricularStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentActivityInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentActivityInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentActivityInfoTypeStudentActivityLevel(java.lang.String value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeStudentActivityLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentActivityInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createStudentActivityInfoTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeEndDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeEndDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Integer> createSif3AssessmentRegistrationTypeDaysOfInstruction(java.lang.Integer value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeDaysOfInstruction(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRegistrationType.TestingStatuses> createSif3AssessmentRegistrationTypeTestingStatuses(
      sif.dd.au30.model.Sif3AssessmentRegistrationType.TestingStatuses value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeTestingStatuses(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeScorePublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeScorePublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeRetestIndicator(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeRetestIndicator(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeTestAttemptIdentifier(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeTestAttemptIdentifier(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRegistrationType.StudentSpecialEvents> createSif3AssessmentRegistrationTypeStudentSpecialEvents(
      sif.dd.au30.model.Sif3AssessmentRegistrationType.StudentSpecialEvents value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeStudentSpecialEvents(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentAdministrationRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentAdministrationRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentPlatform(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentPlatform(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createSif3AssessmentRegistrationTypeStudentGradeLevel(
      sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeStudentGradeLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeLEAInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeLEAInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeSectionInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeSectionInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentFormRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentFormRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeStaffPersonalRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot(
      sif.dd.au30.model.Sif3AssessmentRegistrationType.AssessmentStudentSnapshot value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentSessionRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentSessionRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentRegistrationTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createSif3AssessmentRegistrationTypeAssessmentGradeLevel(
      sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeAssessmentGradeLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentRegistrationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentParticipationTypeReferralSourceOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentParticipationTypeReferralSourceOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackDescription(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackSource(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackSource(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackCode(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemDiagnosticStatement(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemDiagnosticStatement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypePreviousSchoolsListPreviousSchoolReasonLeft(java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypePreviousSchoolsListPreviousSchoolReasonLeft(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestType.SubTestIdentifiers> createSif3AssessmentSubTestTypeSubTestIdentifiers(
      sif.dd.au30.model.Sif3AssessmentSubTestType.SubTestIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSubTestIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestType.AssessmentItems> createSif3AssessmentSubTestTypeAssessmentItems(
      sif.dd.au30.model.Sif3AssessmentSubTestType.AssessmentItems value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeAssessmentItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentSubTestTypeSubTestPublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSubTestPublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSif3AssessmentSubTestTypeSubTestSubjectAreas(
      sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSubTestSubjectAreas(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createSif3AssessmentSubTestTypeSubTestTier(java.lang.Long value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSubTestTier(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSubTestTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Boolean> createSif3AssessmentSubTestTypeContainerOnly(java.lang.Boolean value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeContainerOnly(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestType.AssessmentSubTestRefIds> createSif3AssessmentSubTestTypeAssessmentSubTestRefIds(
      sif.dd.au30.model.Sif3AssessmentSubTestType.AssessmentSubTestRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeAssessmentSubTestRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestType.ScoreReporting> createSif3AssessmentSubTestTypeScoreReporting(
      sif.dd.au30.model.Sif3AssessmentSubTestType.ScoreReporting value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeScoreReporting(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSubTestTypeAbbreviation(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeAbbreviation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createSif3AssessmentSubTestTypeSubTestGradeLevels(
      sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSubTestGradeLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createSif3AssessmentSubTestTypeNumberOfItems(java.lang.Long value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeNumberOfItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSubTestTypeSubTestVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSubTestVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSubTestType.LearningStandardItemRefIds> createSif3AssessmentSubTestTypeLearningStandardItemRefIds(
      sif.dd.au30.model.Sif3AssessmentSubTestType.LearningStandardItemRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeLearningStandardItemRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentSubTestTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentSubTestTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentItemAssociationTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentItemAssociationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentItemAssociationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentItemAssociationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId> createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId(
      sif.dd.au30.model.ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId value) {
    if (value != null) {
      return super.createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createResourceUsageTypeResourceReportLineListResourceReportLineEndDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createResourceUsageTypeResourceReportLineListResourceReportLineEndDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentActivityInfoTypeStudentActivityTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentActivityInfoTypeStudentActivityTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createLEAInfoTypeEducationAgencyTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createLEAInfoTypeEducationAgencyTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportManifestType.ReportFormatList> createReportManifestTypeReportFormatList(
      sif.dd.au30.model.ReportManifestType.ReportFormatList value) {
    if (value != null) {
      return super.createReportManifestTypeReportFormatList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportManifestType.ReceivingAuthority> createReportManifestTypeReceivingAuthority(
      sif.dd.au30.model.ReportManifestType.ReceivingAuthority value) {
    if (value != null) {
      return super.createReportManifestTypeReceivingAuthority(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportManifestType.ReportingPeriod> createReportManifestTypeReportingPeriod(
      sif.dd.au30.model.ReportManifestType.ReportingPeriod value) {
    if (value != null) {
      return super.createReportManifestTypeReportingPeriod(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedQueryDataModelType> createReportManifestTypeSIFExtendedQuery(
      sif.dd.au30.model.SIFExtendedQueryDataModelType value) {
    if (value != null) {
      return super.createReportManifestTypeSIFExtendedQuery(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createReportManifestTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createReportManifestTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createReportManifestTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createReportManifestTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportManifestType.SIFQueryGroup> createReportManifestTypeSIFQueryGroup(
      sif.dd.au30.model.ReportManifestType.SIFQueryGroup value) {
    if (value != null) {
      return super.createReportManifestTypeSIFQueryGroup(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createReportManifestTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createReportManifestTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeAttendanceTerm(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createTermInfoTypeAttendanceTerm(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTermInfoTypeTermSpan(java.lang.String value) {
    if (value != null) {
      return super.createTermInfoTypeTermSpan(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTermInfoTypeTrack(java.lang.String value) {
    if (value != null) {
      return super.createTermInfoTypeTrack(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeMarkingTerm(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createTermInfoTypeMarkingTerm(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTermInfoTypeTermCode(java.lang.String value) {
    if (value != null) {
      return super.createTermInfoTypeTermCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTermInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createTermInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeSchedulingTerm(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createTermInfoTypeSchedulingTerm(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createTermInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createTermInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createTermInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createTermInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createTermInfoTypeRelativeDuration(java.math.BigDecimal value) {
    if (value != null) {
      return super.createTermInfoTypeRelativeDuration(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypeScoreRangeMinimum(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeScoreRangeMinimum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentSubTestTypeScoreRangeMaximum(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentSubTestTypeScoreRangeMaximum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SectionInfoType.SchoolCourseInfoOverride> createSectionInfoTypeSchoolCourseInfoOverride(
      sif.dd.au30.model.SectionInfoType.SchoolCourseInfoOverride value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolCourseInfoOverride(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SectionInfoType.MediumOfInstruction> createSectionInfoTypeMediumOfInstruction(
      sif.dd.au30.model.SectionInfoType.MediumOfInstruction value) {
    if (value != null) {
      return super.createSectionInfoTypeMediumOfInstruction(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeTermInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeTermInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSectionInfoTypeSchoolYear(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSectionInfoTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SectionInfoType.LocationOfInstruction> createSectionInfoTypeLocationOfInstruction(
      sif.dd.au30.model.SectionInfoType.LocationOfInstruction value) {
    if (value != null) {
      return super.createSectionInfoTypeLocationOfInstruction(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSectionCode(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSectionCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SectionInfoType.LanguageOfInstruction> createSectionInfoTypeLanguageOfInstruction(
      sif.dd.au30.model.SectionInfoType.LanguageOfInstruction value) {
    if (value != null) {
      return super.createSectionInfoTypeLanguageOfInstruction(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeCourseSectionCode(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeCourseSectionCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeSummerSchool(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeSummerSchool(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSectionInfoTypeCountForAttendance(java.lang.String value) {
    if (value != null) {
      return super.createSectionInfoTypeCountForAttendance(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSectionInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSectionInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSectionInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSectionInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.RelatedLearningStandardItems> createLearningStandardItemTypeRelatedLearningStandardItems(
      sif.dd.au30.model.LearningStandardItemType.RelatedLearningStandardItems value) {
    if (value != null) {
      return super.createLearningStandardItemTypeRelatedLearningStandardItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.StandardIdentifier> createLearningStandardItemTypeStandardIdentifier(
      sif.dd.au30.model.LearningStandardItemType.StandardIdentifier value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardIdentifier(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.StatementCodes> createLearningStandardItemTypeStatementCodes(
      sif.dd.au30.model.LearningStandardItemType.StatementCodes value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStatementCodes(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ACStrandSubjectAreaType> createLearningStandardItemTypeACStrandSubjectArea(
      sif.dd.au30.model.ACStrandSubjectAreaType value) {
    if (value != null) {
      return super.createLearningStandardItemTypeACStrandSubjectArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.StandardSettingBody> createLearningStandardItemTypeStandardSettingBody(
      sif.dd.au30.model.LearningStandardItemType.StandardSettingBody value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardSettingBody(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.Resources> createLearningStandardItemTypeResources(
      sif.dd.au30.model.LearningStandardItemType.Resources value) {
    if (value != null) {
      return super.createLearningStandardItemTypeResources(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardItemTypeLevel5(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardItemTypeLevel5(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardItemTypeLevel4(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardItemTypeLevel4(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.Statements> createLearningStandardItemTypeStatements(
      sif.dd.au30.model.LearningStandardItemType.Statements value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStatements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.PredecessorItems> createLearningStandardItemTypePredecessorItems(
      sif.dd.au30.model.LearningStandardItemType.PredecessorItems value) {
    if (value != null) {
      return super.createLearningStandardItemTypePredecessorItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createLearningStandardItemTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createLearningStandardItemTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createLearningStandardItemTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createLearningStandardItemTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRegistrationTypeTestingStatusesTestingStatusTestingStatusDescription(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRegistrationTypeTestingStatusesTestingStatusTestingStatusDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createTimeElementTypeSpanGapsSpanGapEndDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createTimeElementTypeSpanGapsSpanGapEndDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createTimeElementTypeSpanGapsSpanGapStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createTimeElementTypeSpanGapsSpanGapStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createLanguageListTypeLanguageOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createLanguageListTypeLanguageOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLanguageListTypeLanguageDialect(java.lang.String value) {
    if (value != null) {
      return super.createLanguageListTypeLanguageDialect(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLanguageListTypeLanguageLanguageType(java.lang.String value) {
    if (value != null) {
      return super.createLanguageListTypeLanguageLanguageType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAdministrationTypeOrganizationsOrganizationSchoolInfoRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeOrganizationsOrganizationSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAdministrationTypeOrganizationsOrganizationLEAInfoRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeOrganizationsOrganizationLEAInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeSchoolName(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeSchoolName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableCreationDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeTimeTableCreationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createTimeTableTypeTeachingPeriodsPerDay(java.lang.Long value) {
    if (value != null) {
      return super.createTimeTableTypeTeachingPeriodsPerDay(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTimeTableTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createTimeTableTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeEndDate(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeEndDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createTimeTableTypeStartDate(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createTimeTableTypeStartDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createTimeTableTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createTimeTableTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createTimeTableTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createTimeTableTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeCatchmentStatusOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeCatchmentStatusOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<RoomInfoType.StaffList> createRoomInfoTypeStaffList(sif.dd.au30.model.RoomInfoType.StaffList value) {
    if (value != null) {
      return super.createRoomInfoTypeStaffList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberType> createRoomInfoTypePhoneNumber(sif.dd.au30.model.PhoneNumberType value) {
    if (value != null) {
      return super.createRoomInfoTypePhoneNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createRoomInfoTypeCapacity(java.lang.Long value) {
    if (value != null) {
      return super.createRoomInfoTypeCapacity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createRoomInfoTypeHomeroomNumber(java.lang.String value) {
    if (value != null) {
      return super.createRoomInfoTypeHomeroomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createRoomInfoTypeSize(java.math.BigDecimal value) {
    if (value != null) {
      return super.createRoomInfoTypeSize(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createRoomInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createRoomInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createRoomInfoTypeRoomType(java.lang.String value) {
    if (value != null) {
      return super.createRoomInfoTypeRoomType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createRoomInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createRoomInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createRoomInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createRoomInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createRoomInfoTypeBuilding(java.lang.String value) {
    if (value != null) {
      return super.createRoomInfoTypeBuilding(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFErrorDataModelTypeSIFExtendedDesc(java.lang.String value) {
    if (value != null) {
      return super.createSIFErrorDataModelTypeSIFExtendedDesc(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<javax.xml.datatype.Duration> createSif3StudentResponseSetTypeItemsItemTimeOnItem(
      javax.xml.datatype.Duration value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemTimeOnItem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3StudentResponseSetType.Items.Item.TraitScores> createSif3StudentResponseSetTypeItemsItemTraitScores(
      sif.dd.au30.model.Sif3StudentResponseSetType.Items.Item.TraitScores value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemTraitScores(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemAttemptStatus(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemAttemptStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemScore(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemItemScore(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemResponseLocation(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemResponseLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3StudentResponseSetType.Items.Item.Comments> createSif3StudentResponseSetTypeItemsItemComments(
      sif.dd.au30.model.Sif3StudentResponseSetType.Items.Item.Comments value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemComments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemAssessmentRubricRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemAssessmentRubricRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3StudentResponseSetType.Items.Item.FeedbackItems> createSif3StudentResponseSetTypeItemsItemFeedbackItems(
      sif.dd.au30.model.Sif3StudentResponseSetType.Items.Item.FeedbackItems value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemFeedbackItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemViewStatus(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemViewStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemNumber(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemItemNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemResponseCorrectness(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemResponseCorrectness(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createSif3StudentResponseSetTypeItemsItemNumberOfAttempts(java.lang.Long value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemNumberOfAttempts(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3StudentResponseSetType.Items.Item.ItemAids> createSif3StudentResponseSetTypeItemsItemItemAids(
      sif.dd.au30.model.Sif3StudentResponseSetType.Items.Item.ItemAids value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemItemAids(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemScoreCode(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemItemScoreCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemName(java.lang.String value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeItemsItemItemName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createSchoolProgramsTypeSchoolProgramListProgramOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createSchoolProgramsTypeSchoolProgramListProgramOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolProgramsTypeSchoolProgramListProgramCategory(java.lang.String value) {
    if (value != null) {
      return super.createSchoolProgramsTypeSchoolProgramListProgramCategory(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberType> createLearningResourceTypeContactsContactPhoneNumber(
      sif.dd.au30.model.PhoneNumberType value) {
    if (value != null) {
      return super.createLearningResourceTypeContactsContactPhoneNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<NameType> createLearningResourceTypeContactsContactName(sif.dd.au30.model.NameType value) {
    if (value != null) {
      return super.createLearningResourceTypeContactsContactName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailType> createLearningResourceTypeContactsContactEmail(sif.dd.au30.model.EmailType value) {
    if (value != null) {
      return super.createLearningResourceTypeContactsContactEmail(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createLearningResourceTypeContactsContactAddress(sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createLearningResourceTypeContactsContactAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypeStudentPersonalRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypeStudentPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNType.AreasOfInterestList> createStudentSDTNTypeAreasOfInterestList(
      sif.dd.au30.model.StudentSDTNType.AreasOfInterestList value) {
    if (value != null) {
      return super.createStudentSDTNTypeAreasOfInterestList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createStudentSDTNTypeYearLevel(sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createStudentSDTNTypeYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PrincipalInfoType> createStudentSDTNTypePrincipalInfo(sif.dd.au30.model.PrincipalInfoType value) {
    if (value != null) {
      return super.createStudentSDTNTypePrincipalInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeYoungCarersRole(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeYoungCarersRole(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNType.PastoralCare> createStudentSDTNTypePastoralCare(
      sif.dd.au30.model.StudentSDTNType.PastoralCare value) {
    if (value != null) {
      return super.createStudentSDTNTypePastoralCare(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypeReasonForLeaving(java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypeReasonForLeaving(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNType.FurtherInformation> createStudentSDTNTypeFurtherInformation(
      sif.dd.au30.model.StudentSDTNType.FurtherInformation value) {
    if (value != null) {
      return super.createStudentSDTNTypeFurtherInformation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeLiteracy(
      sif.dd.au30.model.AUCodeSetsProgressLevelType value) {
    if (value != null) {
      return super.createStudentSDTNTypeLiteracy(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAttendanceConcerns(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeAttendanceConcerns(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentSDTNTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentSDTNTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentSDTNTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentSDTNTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeHealthNeeds(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeHealthNeeds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNType.PreviousSchoolsList> createStudentSDTNTypePreviousSchoolsList(
      sif.dd.au30.model.StudentSDTNType.PreviousSchoolsList value) {
    if (value != null) {
      return super.createStudentSDTNTypePreviousSchoolsList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSDTNTypeEnrollmentDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSDTNTypeEnrollmentDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeCareerGuidanceFileHeld(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeCareerGuidanceFileHeld(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSDTNTypeDepartureDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSDTNTypeDepartureDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAdjustedEducationProgram(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeAdjustedEducationProgram(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressListType> createStudentSDTNTypeAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createStudentSDTNTypeAddressList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeNumeracy(
      sif.dd.au30.model.AUCodeSetsProgressLevelType value) {
    if (value != null) {
      return super.createStudentSDTNTypeNumeracy(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAcceleratedProgram(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeAcceleratedProgram(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSDTNType.OtherLearningAreasList> createStudentSDTNTypeOtherLearningAreasList(
      sif.dd.au30.model.StudentSDTNType.OtherLearningAreasList value) {
    if (value != null) {
      return super.createStudentSDTNTypeOtherLearningAreasList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeNegotiatedCurriculumPlan(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeNegotiatedCurriculumPlan(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeLatestStudentReportAvailable(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeLatestStudentReportAvailable(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypeOtherLearningSupport(java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypeOtherLearningSupport(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeSchoolCounsellorFileHeld(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypeSchoolCounsellorFileHeld(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedQueryDataModelType.SIFWhere> createSIFExtendedQueryDataModelTypeSIFWhere(
      sif.dd.au30.model.SIFExtendedQueryDataModelType.SIFWhere value) {
    if (value != null) {
      return super.createSIFExtendedQueryDataModelTypeSIFWhere(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedQueryDataModelType.SIFOrderBy> createSIFExtendedQueryDataModelTypeSIFOrderBy(
      sif.dd.au30.model.SIFExtendedQueryDataModelType.SIFOrderBy value) {
    if (value != null) {
      return super.createSIFExtendedQueryDataModelTypeSIFOrderBy(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFExtendedQueryDataModelTypeSIFDestinationProvider(java.lang.String value) {
    if (value != null) {
      return super.createSIFExtendedQueryDataModelTypeSIFDestinationProvider(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createTimeElementTypeEndDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createTimeElementTypeEndDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<TimeElementType.SpanGaps> createTimeElementTypeSpanGaps(
      sif.dd.au30.model.TimeElementType.SpanGaps value) {
    if (value != null) {
      return super.createTimeElementTypeSpanGaps(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createTimeElementTypeStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createTimeElementTypeStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType.FormAccommodations> createSif3AssessmentFormTypeFormAccommodations(
      sif.dd.au30.model.Sif3AssessmentFormType.FormAccommodations value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeFormAccommodations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType.FormIdentifiers> createSif3AssessmentFormTypeFormIdentifiers(
      sif.dd.au30.model.Sif3AssessmentFormType.FormIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeFormIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentFormTypeFormVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeFormVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentFormTypePeriod(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypePeriod(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createSif3AssessmentFormTypeGradeLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeGradeLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LanguageListType> createSif3AssessmentFormTypeAssessmentFormLanguages(
      sif.dd.au30.model.LanguageListType value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentFormLanguages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentFormTypeAssessmentType(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSif3AssessmentFormTypeAssessmentFormSubjects(
      sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentFormSubjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentFormTypeLevel(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType.AssessmentSubTestRefIds> createSif3AssessmentFormTypeAssessmentSubTestRefIds(
      sif.dd.au30.model.Sif3AssessmentFormType.AssessmentSubTestRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentSubTestRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType.AssessmentSections> createSif3AssessmentFormTypeAssessmentSections(
      sif.dd.au30.model.Sif3AssessmentFormType.AssessmentSections value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentSections(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType.AssessmentAssetRefIds> createSif3AssessmentFormTypeAssessmentAssetRefIds(
      sif.dd.au30.model.Sif3AssessmentFormType.AssessmentAssetRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentAssetRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentFormType.AssessmentPlatforms> createSif3AssessmentFormTypeAssessmentPlatforms(
      sif.dd.au30.model.Sif3AssessmentFormType.AssessmentPlatforms value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeAssessmentPlatforms(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentFormTypeFormPublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeFormPublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentFormTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentFormTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentFormTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAggregateStatisticFactTypeExcluded(java.lang.String value) {
    if (value != null) {
      return super.createAggregateStatisticFactTypeExcluded(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAggregateStatisticFactTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAggregateStatisticFactTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAggregateStatisticFactTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAggregateStatisticFactTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createCalendarDateCalendarDateTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createCalendarDateCalendarDateTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes> createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes(
      sif.dd.au30.model.LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createLearningStandardItemTypeStandardIdentifierYearLevel(
      sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardIdentifierYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardItemTypeStandardIdentifierIndicatorNumber(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardIdentifierIndicatorNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardItemTypeStandardIdentifierBenchmark(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardItemTypeStandardIdentifierBenchmark(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAggregateCharacteristicInfoTypeElementName(java.lang.String value) {
    if (value != null) {
      return super.createAggregateCharacteristicInfoTypeElementName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAggregateCharacteristicInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createAggregateCharacteristicInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAggregateCharacteristicInfoTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAggregateCharacteristicInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAggregateCharacteristicInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAggregateCharacteristicInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LifeCycleType> createSIFMetadataTypeLifeCycle(sif.dd.au30.model.LifeCycleType value) {
    if (value != null) {
      return super.createSIFMetadataTypeLifeCycle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EducationFilterType> createSIFMetadataTypeEducationFilter(
      sif.dd.au30.model.EducationFilterType value) {
    if (value != null) {
      return super.createSIFMetadataTypeEducationFilter(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType.TimeElements> createSIFMetadataTypeTimeElements(
      sif.dd.au30.model.SIFMetadataType.TimeElements value) {
    if (value != null) {
      return super.createSIFMetadataTypeTimeElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeEntryTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeEntryTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createPhoneNumberTypeListedStatus(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createPhoneNumberTypeListedStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createPhoneNumberTypeExtension(java.lang.String value) {
    if (value != null) {
      return super.createPhoneNumberTypeExtension(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createPersonPictureTypeOKToPublish(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createPersonPictureTypeOKToPublish(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createPersonPictureTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createPersonPictureTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createPersonPictureTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createPersonPictureTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType.StatisticalAreas.StatisticalArea> createAddressTypeStatisticalAreasStatisticalArea(
      sif.dd.au30.model.AddressType.StatisticalAreas.StatisticalArea value) {
    if (value != null) {
      return super.createAddressTypeStatisticalAreasStatisticalArea(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentScoreSetTypeScoresScoreNumberOfResponses(java.lang.Long value) {
    if (value != null) {
      return super.createStudentScoreSetTypeScoresScoreNumberOfResponses(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentScoreSetTypeScoresScoreDescription(java.lang.String value) {
    if (value != null) {
      return super.createStudentScoreSetTypeScoresScoreDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentScoreSetTypeScoresScoreDiagnosticStatement(java.lang.String value) {
    if (value != null) {
      return super.createStudentScoreSetTypeScoresScoreDiagnosticStatement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSectionTypeSectionItemsSectionItemItemSequence(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSectionTypeSectionItemsSectionItemItemSequence(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LifeCycleType.Created> createLifeCycleTypeCreated(sif.dd.au30.model.LifeCycleType.Created value) {
    if (value != null) {
      return super.createLifeCycleTypeCreated(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LifeCycleType.TimeElements> createLifeCycleTypeTimeElements(
      sif.dd.au30.model.LifeCycleType.TimeElements value) {
    if (value != null) {
      return super.createLifeCycleTypeTimeElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LifeCycleType.ModificationHistory> createLifeCycleTypeModificationHistory(
      sif.dd.au30.model.LifeCycleType.ModificationHistory value) {
    if (value != null) {
      return super.createLifeCycleTypeModificationHistory(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.Components.Component.Strategies> createLearningResourceTypeComponentsComponentStrategies(
      sif.dd.au30.model.LearningResourceType.Components.Component.Strategies value) {
    if (value != null) {
      return super.createLearningResourceTypeComponentsComponentStrategies(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningResourceType.Components.Component.AssociatedObjects> createLearningResourceTypeComponentsComponentAssociatedObjects(
      sif.dd.au30.model.LearningResourceType.Components.Component.AssociatedObjects value) {
    if (value != null) {
      return super.createLearningResourceTypeComponentsComponentAssociatedObjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeComponentsComponentDescription(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeComponentsComponentDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<NameType> createLearningResourceTypeEvaluationsEvaluationName(sif.dd.au30.model.NameType value) {
    if (value != null) {
      return super.createLearningResourceTypeEvaluationsEvaluationName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningResourceTypeEvaluationsEvaluationDescription(java.lang.String value) {
    if (value != null) {
      return super.createLearningResourceTypeEvaluationsEvaluationDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningResourceTypeEvaluationsEvaluationDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningResourceTypeEvaluationsEvaluationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDescription(
      java.lang.String value) {
    if (value != null) {
      return super.createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDelimiter(
      java.lang.String value) {
    if (value != null) {
      return super.createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDelimiter(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFHeaderDataModelType.SIFSecurity> createSIFHeaderDataModelTypeSIFSecurity(
      sif.dd.au30.model.SIFHeaderDataModelType.SIFSecurity value) {
    if (value != null) {
      return super.createSIFHeaderDataModelTypeSIFSecurity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFContextsType> createSIFHeaderDataModelTypeSIFContexts(sif.dd.au30.model.SIFContextsType value) {
    if (value != null) {
      return super.createSIFHeaderDataModelTypeSIFContexts(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFHeaderDataModelTypeSIFDestinationId(java.lang.String value) {
    if (value != null) {
      return super.createSIFHeaderDataModelTypeSIFDestinationId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentContactPersonalTypeNonSchoolEducation(java.lang.String value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeNonSchoolEducation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentContactPersonalTypeLocalId(java.lang.String value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentContactPersonalType.OtherIdList> createStudentContactPersonalTypeOtherIdList(
      sif.dd.au30.model.StudentContactPersonalType.OtherIdList value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeOtherIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentContactPersonalTypeEmploymentType(java.lang.String value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeEmploymentType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentContactPersonalTypeSchoolEducationalLevel(java.lang.String value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeSchoolEducationalLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentContactPersonalTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentContactPersonalTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentContactPersonalTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Float> createAssessmentItemTypeResponseChoicesChoiceCreditValue(java.lang.Float value) {
    if (value != null) {
      return super.createAssessmentItemTypeResponseChoicesChoiceCreditValue(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentItemTypeResponseChoicesChoiceChoiceLabel(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentItemTypeResponseChoicesChoiceChoiceLabel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeDayId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeDayId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeLocation(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeLocation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeActivityType(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeActivityType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypePeriodId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypePeriodId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeCellType(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeCellType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressListType> createScheduledActivityTypeAddressList(sif.dd.au30.model.AddressListType value) {
    if (value != null) {
      return super.createScheduledActivityTypeAddressList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeTimeTableCellRefId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTimeTableCellRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeTimeTableRefId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTimeTableRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityType.TeacherList> createScheduledActivityTypeTeacherList(
      sif.dd.au30.model.ScheduledActivityType.TeacherList value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeActivityComment(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeActivityComment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityType.TeachingGroupList> createScheduledActivityTypeTeachingGroupList(
      sif.dd.au30.model.ScheduledActivityType.TeachingGroupList value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeachingGroupList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityType.RoomList> createScheduledActivityTypeRoomList(
      sif.dd.au30.model.ScheduledActivityType.RoomList value) {
    if (value != null) {
      return super.createScheduledActivityTypeRoomList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeTimeTableSubjectRefId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTimeTableSubjectRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeActivityName(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeActivityName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityType.StudentList> createScheduledActivityTypeStudentList(
      sif.dd.au30.model.ScheduledActivityType.StudentList value) {
    if (value != null) {
      return super.createScheduledActivityTypeStudentList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ScheduledActivityType.Override> createScheduledActivityTypeOverride(
      sif.dd.au30.model.ScheduledActivityType.Override value) {
    if (value != null) {
      return super.createScheduledActivityTypeOverride(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createScheduledActivityTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createScheduledActivityTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createScheduledActivityTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createScheduledActivityTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createScheduledActivityTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createScheduledActivityTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackSource(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackSource(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackDescription(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAdministrationType.AdministrationAssessments> createSif3AssessmentAdministrationTypeAdministrationAssessments(
      sif.dd.au30.model.Sif3AssessmentAdministrationType.AdministrationAssessments value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeAdministrationAssessments(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAdministrationTypeAdministrationCode(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeAdministrationCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentAdministrationTypeFinishDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeFinishDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentAdministrationTypeStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentAdministrationTypeAdministrationName(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeAdministrationName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentAdministrationType.Organizations> createSif3AssessmentAdministrationTypeOrganizations(
      sif.dd.au30.model.Sif3AssessmentAdministrationType.Organizations value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeOrganizations(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentAdministrationTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentAdministrationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentAdministrationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createDemographicsTypeReligionOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createDemographicsTypeReligionOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentParticipationTypeProgramFundingSourcesProgramFundingSourceOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramFundingSourcesProgramFundingSourceOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSystemRoleTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSystemRoleTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSystemRoleTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSystemRoleTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSubjectLocalId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSubjectLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentCourseLocalId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentCourseLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTimeTableSubjectRefId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTimeTableSubjectRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolCourseInfoRefId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolCourseInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTeachingGroupRefId(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTeachingGroupRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentShortName(
      java.lang.String value) {
    if (value != null) {
      return super
          .createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentShortName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createSectionInfoTypeLocationOfInstructionOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createSectionInfoTypeLocationOfInstructionOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3StudentResponseSetTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3StudentResponseSetTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3StudentResponseSetTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentRegistrationTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentRegistrationTypeLEAInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeLEAInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createAssessmentRegistrationTypeStudentYearLevel(
      sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeStudentYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentRegistrationType.StudentSpecialConditions> createAssessmentRegistrationTypeStudentSpecialConditions(
      sif.dd.au30.model.AssessmentRegistrationType.StudentSpecialConditions value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeStudentSpecialConditions(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentRegistrationTypeStaffPersonalRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentRegistrationType.AssessmentStudentSnapshot> createAssessmentRegistrationTypeAssessmentStudentSnapshot(
      sif.dd.au30.model.AssessmentRegistrationType.AssessmentStudentSnapshot value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeAssessmentStudentSnapshot(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createAssessmentRegistrationTypeAssessmentYearLevel(
      sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeAssessmentYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentRegistrationTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentRegistrationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentRegistrationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createRelationshipTypeOtherCodeList(sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createRelationshipTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(
      java.lang.Long value) {
    if (value != null) {
      return super.createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaType> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(
      sif.dd.au30.model.SubjectAreaType value) {
    if (value != null) {
      return super.createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createSectionInfoTypeMediumOfInstructionOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createSectionInfoTypeMediumOfInstructionOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodEndSubmitDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createReportManifestTypeReportingPeriodEndSubmitDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodEndReportDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createReportManifestTypeReportingPeriodEndReportDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodDueDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createReportManifestTypeReportingPeriodDueDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodBeginSubmitDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createReportManifestTypeReportingPeriodBeginSubmitDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodBeginReportDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createReportManifestTypeReportingPeriodBeginReportDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolName(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentSchoolName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSnapshotType.HomeEnrollment.Homeroom> createStudentSnapshotTypeHomeEnrollmentHomeroom(
      sif.dd.au30.model.StudentSnapshotType.HomeEnrollment.Homeroom value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentHomeroom(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelType> createStudentSnapshotTypeHomeEnrollmentYearLevel(
      sif.dd.au30.model.YearLevelType value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentYearLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentLocalId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentHomeroomNumber(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentHomeroomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentStudentSchoolEnrollmentRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentStudentSchoolEnrollmentRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolNo(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeHomeEnrollmentSchoolNo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeTechnicalRequirementsTechnicalRequirement(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeTechnicalRequirementsTechnicalRequirement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentScoreTableType.ScoreTableIdentifiers> createSif3AssessmentScoreTableTypeScoreTableIdentifiers(
      sif.dd.au30.model.Sif3AssessmentScoreTableType.ScoreTableIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreTableIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentScoreTableTypeScoreTablePublishDate(
      java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreTablePublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentScoreTableTypeScoreTableVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreTableVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentScoreTableType.ScoreValues> createSif3AssessmentScoreTableTypeScoreValues(
      sif.dd.au30.model.Sif3AssessmentScoreTableType.ScoreValues value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeScoreValues(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentScoreTableTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentScoreTableTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentScoreTableTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeOnTimeGraduationYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSnapshotTypeOnTimeGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeStudentSnapshotRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeStudentSnapshotRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeBirthDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSnapshotTypeBirthDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSnapshotTypeSex(java.lang.String value) {
    if (value != null) {
      return super.createStudentSnapshotTypeSex(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentSnapshotTypeAge(java.lang.Long value) {
    if (value != null) {
      return super.createStudentSnapshotTypeAge(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentSnapshotType.StudentSubjectChoiceList> createStudentSnapshotTypeStudentSubjectChoiceList(
      sif.dd.au30.model.StudentSnapshotType.StudentSubjectChoiceList value) {
    if (value != null) {
      return super.createStudentSnapshotTypeStudentSubjectChoiceList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentSnapshotTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentSnapshotTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentSnapshotTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentSnapshotTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeProjectedGraduationYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSnapshotTypeProjectedGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementOS(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeSoftwareRequirementListSoftwareRequirementOS(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementVersion(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeSoftwareRequirementListSoftwareRequirementVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementVendor(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeSoftwareRequirementListSoftwareRequirementVendor(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeDistrictCourseCode(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeDistrictCourseCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeCourseCredits(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeCourseCredits(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeCourseContent(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeCourseContent(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSchoolCourseInfoTypeSubjectAreaList(
      sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeSubjectAreaList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeTermInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeTermInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSchoolCourseInfoTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolCourseInfoTypeCoreAcademicCourse(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeCoreAcademicCourse(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolCourseInfoTypeGraduationRequirement(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeGraduationRequirement(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeStateCourseCode(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeStateCourseCode(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeDepartment(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeDepartment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSchoolCourseInfoTypeInstructionalLevel(java.lang.String value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeInstructionalLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSchoolCourseInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSchoolCourseInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSchoolCourseInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentFormType.AssessmentSubTestRefIds> createAssessmentFormTypeAssessmentSubTestRefIds(
      sif.dd.au30.model.AssessmentFormType.AssessmentSubTestRefIds value) {
    if (value != null) {
      return super.createAssessmentFormTypeAssessmentSubTestRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentFormTypeLevel(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentFormTypeLevel(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentFormTypePeriod(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentFormTypePeriod(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentFormType.FormNumbers> createAssessmentFormTypeFormNumbers(
      sif.dd.au30.model.AssessmentFormType.FormNumbers value) {
    if (value != null) {
      return super.createAssessmentFormTypeFormNumbers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentFormTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentFormTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentFormTypeAssessmentType(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentFormTypeAssessmentType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentFormTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentFormTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createAssessmentFormTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createAssessmentFormTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFReportObjectTypeReportInfoDescription(java.lang.String value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo> createSIFReportObjectTypeReportInfoReportSubmitterInfo(
      sif.dd.au30.model.SIFReportObjectType.ReportInfo.ReportSubmitterInfo value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPersonalType.AlertMessages> createStudentPersonalTypeAlertMessages(
      sif.dd.au30.model.StudentPersonalType.AlertMessages value) {
    if (value != null) {
      return super.createStudentPersonalTypeAlertMessages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeOnTimeGraduationYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentPersonalTypeOnTimeGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeDisability(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeDisability(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeYoungCarersRole(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeYoungCarersRole(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPersonalType.OtherIdList> createStudentPersonalTypeOtherIdList(
      sif.dd.au30.model.StudentPersonalType.OtherIdList value) {
    if (value != null) {
      return super.createStudentPersonalTypeOtherIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypePrePrimaryEducation(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypePrePrimaryEducation(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeEconomicDisadvantage(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeEconomicDisadvantage(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPersonalType.MedicalAlertMessages> createStudentPersonalTypeMedicalAlertMessages(
      sif.dd.au30.model.StudentPersonalType.MedicalAlertMessages value) {
    if (value != null) {
      return super.createStudentPersonalTypeMedicalAlertMessages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeESL(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeESL(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeAcceptableUsePolicy(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeAcceptableUsePolicy(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeProjectedGraduationYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentPersonalTypeProjectedGraduationYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPersonalTypeGraduationDate(java.lang.String value) {
    if (value != null) {
      return super.createStudentPersonalTypeGraduationDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeFirstAUSchoolEnrollment(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentPersonalTypeFirstAUSchoolEnrollment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ElectronicIdListType> createStudentPersonalTypeElectronicIdList(
      sif.dd.au30.model.ElectronicIdListType value) {
    if (value != null) {
      return super.createStudentPersonalTypeElectronicIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeIntegrationAide(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeIntegrationAide(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPersonalType.MostRecent> createStudentPersonalTypeMostRecent(
      sif.dd.au30.model.StudentPersonalType.MostRecent value) {
    if (value != null) {
      return super.createStudentPersonalTypeMostRecent(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeGiftedTalented(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentPersonalTypeGiftedTalented(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentPersonalTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentPersonalTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentPersonalTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentPersonalTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeScheduledStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeScheduledStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSessionType.StaffPersonalRefIds> createSif3AssessmentSessionTypeStaffPersonalRefIds(
      sif.dd.au30.model.Sif3AssessmentSessionType.StaffPersonalRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeStaffPersonalRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeScheduledEndDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeScheduledEndDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeActualEndDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeActualEndDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeActualStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeActualStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSessionTypeAssessmentAdministrationRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeAssessmentAdministrationRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSessionTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSessionTypeLEAInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeLEAInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSessionTypeAssessmentFormRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeAssessmentFormRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentSessionType.UnusualEvents> createSif3AssessmentSessionTypeUnusualEvents(
      sif.dd.au30.model.Sif3AssessmentSessionType.UnusualEvents value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeUnusualEvents(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentSessionTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createSif3AssessmentSessionTypeAddress(sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentSessionTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentSessionTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createPrincipalInfoTypeContactTitle(java.lang.String value) {
    if (value != null) {
      return super.createPrincipalInfoTypeContactTitle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createPrincipalInfoTypePhoneNumberList(
      sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createPrincipalInfoTypePhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailListType> createPrincipalInfoTypeEmailList(sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createPrincipalInfoTypeEmailList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentScoreSetTypeAssessmentRegistrationRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentScoreSetTypeAssessmentRegistrationRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createStudentScoreSetTypeFinishDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createStudentScoreSetTypeFinishDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createStudentScoreSetTypeStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createStudentScoreSetTypeStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentScoreSetTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentScoreSetTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentScoreSetTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentScoreSetTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingMinimum(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeScoreReportingMinimum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingScoreTableRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeScoreReportingScoreTableRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingMaximum(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentSubTestTypeScoreReportingMaximum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ContactInfoType> createSIFReportObjectTypeReportInfoReportSubmitterInfoContactInfo(
      sif.dd.au30.model.ContactInfoType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfoContactInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberType> createSIFReportObjectTypeReportInfoReportSubmitterInfoPhoneNumber(
      sif.dd.au30.model.PhoneNumberType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfoPhoneNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId> createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId(
      sif.dd.au30.model.SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterDepartment(
      java.lang.String value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterDepartment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterNotes(java.lang.String value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterNotes(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createSIFReportObjectTypeReportInfoReportSubmitterInfoAddress(
      sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfoReportSubmitterInfoAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentDailyAttendanceTypeTimeIn(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeTimeIn(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentDailyAttendanceTypeTimeOut(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeTimeOut(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createStudentDailyAttendanceTypeAbsenceValue(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeAbsenceValue(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsDayValueCodeType> createStudentDailyAttendanceTypeDayValue(
      sif.dd.au30.model.AUCodeSetsDayValueCodeType value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeDayValue(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentDailyAttendanceTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentDailyAttendanceTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentDailyAttendanceTypeAttendanceNote(java.lang.String value) {
    if (value != null) {
      return super.createStudentDailyAttendanceTypeAttendanceNote(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeEndOfLifeDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeEndOfLifeDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeLocalArchiveDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeLocalArchiveDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardDocumentType.Authors> createLearningStandardDocumentTypeAuthors(
      sif.dd.au30.model.LearningStandardDocumentType.Authors value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeAuthors(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeDocumentDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeDocumentDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardDocumentTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeLocalAdoptionDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeLocalAdoptionDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AbstractContentElementType> createLearningStandardDocumentTypeRichDescription(
      sif.dd.au30.model.AbstractContentElementType value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeRichDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardDocumentType.Copyright> createLearningStandardDocumentTypeCopyright(
      sif.dd.au30.model.LearningStandardDocumentType.Copyright value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeCopyright(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LearningStandardDocumentType.RelatedLearningStandards> createLearningStandardDocumentTypeRelatedLearningStandards(
      sif.dd.au30.model.LearningStandardDocumentType.RelatedLearningStandards value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeRelatedLearningStandards(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeRepositoryDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeRepositoryDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardDocumentTypeOrganizationContactPoint(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeOrganizationContactPoint(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createLearningStandardDocumentTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createLearningStandardDocumentTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createLearningStandardDocumentTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudentStudentLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudentStudentLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LocationType.LocationRefId> createLocationTypeLocationRefId(
      sif.dd.au30.model.LocationType.LocationRefId value) {
    if (value != null) {
      return super.createLocationTypeLocationRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLocationTypeLocationName(java.lang.String value) {
    if (value != null) {
      return super.createLocationTypeLocationName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLearningStandardDocumentTypeCopyrightHolder(java.lang.String value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeCopyrightHolder(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeCopyrightDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createLearningStandardDocumentTypeCopyrightDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffAssignmentTypeStaffSubjectListStaffSubjectSubjectLocalId(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeStaffSubjectListStaffSubjectSubjectLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffAssignmentTypeStaffSubjectListStaffSubjectTimeTableSubjectRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeStaffSubjectListStaffSubjectTimeTableSubjectRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeTimeIn(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeTimeIn(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPeriodAttendanceTypeSessionInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeSessionInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeTimeOut(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeTimeOut(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPeriodAttendanceTypeTimetablePeriod(java.lang.String value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeTimetablePeriod(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentPeriodAttendanceType.AuditInfo> createStudentPeriodAttendanceTypeAuditInfo(
      sif.dd.au30.model.StudentPeriodAttendanceType.AuditInfo value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeAuditInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentPeriodAttendanceTypeAttendanceComment(java.lang.String value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeAttendanceComment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentPeriodAttendanceTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentPeriodAttendanceTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentPeriodAttendanceTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolInfoRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent(
      sif.dd.au30.model.SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff(
      sif.dd.au30.model.SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList(
      sif.dd.au30.model.SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolStateProvinceId(
      java.lang.String value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentParticipationTypeProgramAvailabilityOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentParticipationTypeProgramAvailabilityOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarDate.TeacherAttendance> createCalendarDateTeacherAttendance(
      sif.dd.au30.model.CalendarDate.TeacherAttendance value) {
    if (value != null) {
      return super.createCalendarDateTeacherAttendance(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarDate.StudentAttendance> createCalendarDateStudentAttendance(
      sif.dd.au30.model.CalendarDate.StudentAttendance value) {
    if (value != null) {
      return super.createCalendarDateStudentAttendance(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<CalendarDate.AdministratorAttendance> createCalendarDateAdministratorAttendance(
      sif.dd.au30.model.CalendarDate.AdministratorAttendance value) {
    if (value != null) {
      return super.createCalendarDateAdministratorAttendance(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createCalendarDateCalendarDateNumber(java.lang.Long value) {
    if (value != null) {
      return super.createCalendarDateCalendarDateNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createCalendarDateCalendarDateRefId(java.lang.String value) {
    if (value != null) {
      return super.createCalendarDateCalendarDateRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createCalendarDateSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createCalendarDateSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createCalendarDateSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createCalendarDateSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentActivityParticipationTypeRole(java.lang.String value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeRole(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StudentActivityParticipationType.RecognitionList> createStudentActivityParticipationTypeRecognitionList(
      sif.dd.au30.model.StudentActivityParticipationType.RecognitionList value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeRecognitionList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentActivityParticipationTypeParticipationComment(java.lang.String value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeParticipationComment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeEndDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeEndDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeStartDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeStartDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentActivityParticipationTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentActivityParticipationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentActivityParticipationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores(
      sif.dd.au30.model.AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores value) {
    if (value != null) {
      return super.createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(
      java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypePastoralCareIndividualBehaviourPlan(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypePastoralCareIndividualBehaviourPlan(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypePastoralCareDisciplinaryAbsences(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentSDTNTypePastoralCareDisciplinaryAbsences(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentItemType.LearningStandardItems> createAssessmentItemTypeLearningStandardItems(
      sif.dd.au30.model.AssessmentItemType.LearningStandardItems value) {
    if (value != null) {
      return super.createAssessmentItemTypeLearningStandardItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentItemTypeItemScoreMinimum(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentItemTypeItemScoreMinimum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentItemType.PerformanceLevels> createAssessmentItemTypePerformanceLevels(
      sif.dd.au30.model.AssessmentItemType.PerformanceLevels value) {
    if (value != null) {
      return super.createAssessmentItemTypePerformanceLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentItemTypeItemScoreMaximum(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentItemTypeItemScoreMaximum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AbstractContentElementType> createAssessmentItemTypeStem(
      sif.dd.au30.model.AbstractContentElementType value) {
    if (value != null) {
      return super.createAssessmentItemTypeStem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentItemTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentItemTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentItemType.ResponseChoices> createAssessmentItemTypeResponseChoices(
      sif.dd.au30.model.AssessmentItemType.ResponseChoices value) {
    if (value != null) {
      return super.createAssessmentItemTypeResponseChoices(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AbstractContentElementType> createAssessmentItemTypeStimulus(
      sif.dd.au30.model.AbstractContentElementType value) {
    if (value != null) {
      return super.createAssessmentItemTypeStimulus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentItemTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentItemTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentItemTypeItemName(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentItemTypeItemName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolContactListTypeSchoolContactPublishInDirectory(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSchoolContactListTypeSchoolContactPublishInDirectory(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList(
      sif.dd.au30.model.SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList value) {
    if (value != null) {
      return super.createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createSubjectAreaTypeOtherCodeList(sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createSubjectAreaTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EducationFilterType.LearningStandardItems> createEducationFilterTypeLearningStandardItems(
      sif.dd.au30.model.EducationFilterType.LearningStandardItems value) {
    if (value != null) {
      return super.createEducationFilterTypeLearningStandardItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRubricType.Scores> createSif3AssessmentRubricTypeScores(
      sif.dd.au30.model.Sif3AssessmentRubricType.Scores value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeScores(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRubricTypeScoringGuideReference(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeScoringGuideReference(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentRubricTypeRubricVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeRubricVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentRubricTypeRubricPublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeRubricPublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentRubricType.RubricIdentifiers> createSif3AssessmentRubricTypeRubricIdentifiers(
      sif.dd.au30.model.Sif3AssessmentRubricType.RubricIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeRubricIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentRubricTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentRubricTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentRubricTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeExitStatusOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeExitStatusOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaffStaffLocalId(
      java.lang.String value) {
    if (value != null) {
      return super.createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaffStaffLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetStreetType(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetStreetSuffix(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetSuffix(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetApartmentNumber(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetApartmentNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetStreetNumber(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetComplex(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetComplex(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetStreetPrefix(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetPrefix(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetLine3(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetLine3(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetLine2(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetLine2(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetApartmentNumberSuffix(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetApartmentNumberSuffix(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetApartmentType(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetApartmentType(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetStreetName(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetStreetName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAddressTypeStreetApartmentNumberPrefix(java.lang.String value) {
    if (value != null) {
      return super.createAddressTypeStreetApartmentNumberPrefix(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverSupervision(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverSupervision(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverStartTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverStartTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createScheduledActivityTypeTeacherListTeacherCoverWeighting(java.math.BigDecimal value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverWeighting(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverFinishTime(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverFinishTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverCredit(java.lang.String value) {
    if (value != null) {
      return super.createScheduledActivityTypeTeacherListTeacherCoverCredit(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createContactInfoTypeRole(java.lang.String value) {
    if (value != null) {
      return super.createContactInfoTypeRole(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberListType> createContactInfoTypePhoneNumberList(
      sif.dd.au30.model.PhoneNumberListType value) {
    if (value != null) {
      return super.createContactInfoTypePhoneNumberList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createContactInfoTypePositionTitle(java.lang.String value) {
    if (value != null) {
      return super.createContactInfoTypePositionTitle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<EmailListType> createContactInfoTypeEmailList(sif.dd.au30.model.EmailListType value) {
    if (value != null) {
      return super.createContactInfoTypeEmailList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createContactInfoTypeAddress(sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createContactInfoTypeAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.AssessmentItemPlatforms> createSif3AssessmentItemTypeAssessmentItemPlatforms(
      sif.dd.au30.model.Sif3AssessmentItemType.AssessmentItemPlatforms value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentItemPlatforms(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.LearningStandardItems> createSif3AssessmentItemTypeLearningStandardItems(
      sif.dd.au30.model.Sif3AssessmentItemType.LearningStandardItems value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeLearningStandardItems(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.AssessmentItemBanks> createSif3AssessmentItemTypeAssessmentItemBanks(
      sif.dd.au30.model.Sif3AssessmentItemType.AssessmentItemBanks value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentItemBanks(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemScoreMaximum(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemScoreMaximum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.ItemRubricIds> createSif3AssessmentItemTypeItemRubricIds(
      sif.dd.au30.model.Sif3AssessmentItemType.ItemRubricIds value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemRubricIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LanguageListType> createSif3AssessmentItemTypeAssessmentLanguages(
      sif.dd.au30.model.LanguageListType value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentLanguages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AbstractContentElementType> createSif3AssessmentItemTypeStem(
      sif.dd.au30.model.AbstractContentElementType value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeStem(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createSif3AssessmentItemTypeAssessmentGradeLevels(
      sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentGradeLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSif3AssessmentItemTypeAssessmentSubjects(
      sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentSubjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemScoreMinimum(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemScoreMinimum(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.AssessmentIdentifiers> createSif3AssessmentItemTypeAssessmentIdentifiers(
      sif.dd.au30.model.Sif3AssessmentItemType.AssessmentIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackCorrect(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemFeedbackCorrect(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackIncorrect(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemFeedbackIncorrect(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.AssessmentItemAssetRefIds> createSif3AssessmentItemTypeAssessmentItemAssetRefIds(
      sif.dd.au30.model.Sif3AssessmentItemType.AssessmentItemAssetRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeAssessmentItemAssetRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackHint(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemFeedbackHint(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createSif3AssessmentItemTypeItemPublishDate(java.util.Calendar value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemPublishDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentItemTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentItemType.ResponseChoices> createSif3AssessmentItemTypeResponseChoices(
      sif.dd.au30.model.Sif3AssessmentItemType.ResponseChoices value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeResponseChoices(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentItemTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemVersion(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemVersion(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentItemTypeItemName(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentItemTypeItemName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createBaseNameTypePreferredFamilyNameFirst(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createBaseNameTypePreferredFamilyNameFirst(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypePreferredFamilyName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypePreferredFamilyName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypeFamilyName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeFamilyName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypeTitle(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeTitle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypePreferredGivenName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypePreferredGivenName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createBaseNameTypeFamilyNameFirst(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createBaseNameTypeFamilyNameFirst(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypeMiddleName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeMiddleName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypeFullName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeFullName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypeSuffix(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeSuffix(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createBaseNameTypeGivenName(java.lang.String value) {
    if (value != null) {
      return super.createBaseNameTypeGivenName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeEntryDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSectionEnrollmentTypeEntryDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSectionEnrollmentTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeExitDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStudentSectionEnrollmentTypeExitDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentSectionEnrollmentTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentSectionEnrollmentTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentSectionEnrollmentTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentSectionEnrollmentTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createDemographicsTypeDwellingArrangementOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createDemographicsTypeDwellingArrangementOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSessionInfoTypeStartTime(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSessionInfoTypeStartTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createSessionInfoTypeRollMarked(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createSessionInfoTypeRollMarked(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSessionInfoTypeRoomNumber(java.lang.String value) {
    if (value != null) {
      return super.createSessionInfoTypeRoomNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSessionInfoTypeSchoolLocalId(java.lang.String value) {
    if (value != null) {
      return super.createSessionInfoTypeSchoolLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSessionInfoTypeFinishTime(javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSessionInfoTypeFinishTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSessionInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSessionInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSessionInfoTypeStaffPersonalLocalId(java.lang.String value) {
    if (value != null) {
      return super.createSessionInfoTypeStaffPersonalLocalId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSessionInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSessionInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentSDTNTypeAreasOfInterestListActivityInfoStudentActivityInfoRefId(
      java.lang.String value) {
    if (value != null) {
      return super.createStudentSDTNTypeAreasOfInterestListActivityInfoStudentActivityInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SchoolProgramsType.SchoolProgramList> createSchoolProgramsTypeSchoolProgramList(
      sif.dd.au30.model.SchoolProgramsType.SchoolProgramList value) {
    if (value != null) {
      return super.createSchoolProgramsTypeSchoolProgramList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createSchoolProgramsTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createSchoolProgramsTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSchoolProgramsTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSchoolProgramsTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSchoolProgramsTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSchoolProgramsTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores(
      sif.dd.au30.model.AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores value) {
    if (value != null) {
      return super.createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffAssignmentType.StaffActivity> createStaffAssignmentTypeStaffActivity(
      sif.dd.au30.model.StaffAssignmentType.StaffActivity value) {
    if (value != null) {
      return super.createStaffAssignmentTypeStaffActivity(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeSchoolYear(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStaffAssignmentTypeSchoolYear(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobStartDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobStartDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffAssignmentTypeDescription(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobEndDate(
      javax.xml.datatype.XMLGregorianCalendar value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobEndDate(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStaffAssignmentTypeCasualReliefTeacher(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStaffAssignmentTypeCasualReliefTeacher(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffAssignmentTypeHouse(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeHouse(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createStaffAssignmentTypeJobFTE(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobFTE(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffAssignmentTypeHomegroup(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeHomegroup(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffAssignmentTypeJobFunction(java.lang.String value) {
    if (value != null) {
      return super.createStaffAssignmentTypeJobFunction(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffAssignmentType.StaffSubjectList> createStaffAssignmentTypeStaffSubjectList(
      sif.dd.au30.model.StaffAssignmentType.StaffSubjectList value) {
    if (value != null) {
      return super.createStaffAssignmentTypeStaffSubjectList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStaffAssignmentTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStaffAssignmentTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStaffAssignmentTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStaffAssignmentTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createStaffAssignmentTypeYearLevels(sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createStaffAssignmentTypeYearLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createActivityTypeEvaluationDescription(java.lang.String value) {
    if (value != null) {
      return super.createActivityTypeEvaluationDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFReportObjectType.ReportInfo> createSIFReportObjectTypeReportInfo(
      sif.dd.au30.model.SIFReportObjectType.ReportInfo value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedQueryResultsDataModelType> createSIFReportObjectTypeSIFExtendedQueryResults(
      sif.dd.au30.model.SIFExtendedQueryResultsDataModelType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeSIFExtendedQueryResults(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ReportDataObjectType> createSIFReportObjectTypeReportData(
      sif.dd.au30.model.ReportDataObjectType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeReportData(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSIFReportObjectTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSIFReportObjectTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSIFReportObjectTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SubjectAreaListType> createSif3AssessmentTypeAssessmentSubjects(
      sif.dd.au30.model.SubjectAreaListType value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentSubjects(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentTypeAssessmentProvider(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentProvider(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentType.AssessmentIdentifiers> createSif3AssessmentTypeAssessmentIdentifiers(
      sif.dd.au30.model.Sif3AssessmentType.AssessmentIdentifiers value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentIdentifiers(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentType.AssessmentItemBanks> createSif3AssessmentTypeAssessmentItemBanks(
      sif.dd.au30.model.Sif3AssessmentType.AssessmentItemBanks value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentItemBanks(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createSif3AssessmentTypeAssessmentPackageRefId(java.lang.String value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentPackageRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentType.LearningStandardItemRefIds> createSif3AssessmentTypeLearningStandardItemRefIds(
      sif.dd.au30.model.Sif3AssessmentType.LearningStandardItemRefIds value) {
    if (value != null) {
      return super.createSif3AssessmentTypeLearningStandardItemRefIds(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LanguageListType> createSif3AssessmentTypeAssessmentLanguages(
      sif.dd.au30.model.LanguageListType value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentLanguages(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Sif3AssessmentType.AssessmentDescriptors> createSif3AssessmentTypeAssessmentDescriptors(
      sif.dd.au30.model.Sif3AssessmentType.AssessmentDescriptors value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentDescriptors(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<YearLevelsType> createSif3AssessmentTypeAssessmentGradeLevels(
      sif.dd.au30.model.YearLevelsType value) {
    if (value != null) {
      return super.createSif3AssessmentTypeAssessmentGradeLevels(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createSif3AssessmentTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createSif3AssessmentTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createSif3AssessmentTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createSif3AssessmentTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createLifeCycleTypeModificationHistoryModifiedDescription(java.lang.String value) {
    if (value != null) {
      return super.createLifeCycleTypeModificationHistoryModifiedDescription(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStaffAssignmentTypeStaffActivityOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStaffAssignmentTypeStaffActivityOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentAdministrationTypeSchoolInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeSchoolInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentAdministrationTypeLEAInfoRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeLEAInfoRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AssessmentAdministrationType.SpecialConditions> createAssessmentAdministrationTypeSpecialConditions(
      sif.dd.au30.model.AssessmentAdministrationType.SpecialConditions value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeSpecialConditions(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentAdministrationTypeStaffPersonalRefId(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeStaffPersonalRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeFinishDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeFinishDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeStartDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeStartDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createAssessmentAdministrationTypeAdministrationName(java.lang.String value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeAdministrationName(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeDueDateTime(java.util.Calendar value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeDueDateTime(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createAssessmentAdministrationTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createAssessmentAdministrationTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createAssessmentAdministrationTypeAddress(sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createAssessmentAdministrationTypeAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createSectionInfoTypeLanguageOfInstructionOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createSectionInfoTypeLanguageOfInstructionOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createStudentAttendanceSummaryTypeDaysTardy(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeDaysTardy(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId(java.lang.String value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentAttendanceSummaryTypeStartDay(java.lang.Long value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeStartDay(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStudentAttendanceSummaryTypeSIFMetadata(
      sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<BigDecimal> createStudentAttendanceSummaryTypeFTE(java.math.BigDecimal value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeFTE(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStudentAttendanceSummaryTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<Long> createStudentAttendanceSummaryTypeEndDay(java.lang.Long value) {
    if (value != null) {
      return super.createStudentAttendanceSummaryTypeEndDay(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createProgramStatusTypeOtherCodeList(sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createProgramStatusTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsStaffStatusType> createStaffPersonalTypeEmploymentStatus(
      sif.dd.au30.model.AUCodeSetsStaffStatusType value) {
    if (value != null) {
      return super.createStaffPersonalTypeEmploymentStatus(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffPersonalTypeStateProvinceId(java.lang.String value) {
    if (value != null) {
      return super.createStaffPersonalTypeStateProvinceId(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<StaffPersonalType.OtherIdList> createStaffPersonalTypeOtherIdList(
      sif.dd.au30.model.StaffPersonalType.OtherIdList value) {
    if (value != null) {
      return super.createStaffPersonalTypeOtherIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createStaffPersonalTypeTitle(java.lang.String value) {
    if (value != null) {
      return super.createStaffPersonalTypeTitle(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ElectronicIdListType> createStaffPersonalTypeElectronicIdList(
      sif.dd.au30.model.ElectronicIdListType value) {
    if (value != null) {
      return super.createStaffPersonalTypeElectronicIdList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createStaffPersonalTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createStaffPersonalTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createStaffPersonalTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createStaffPersonalTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsHasCustody(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsHasCustody(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsFeesBilling(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsFeesBilling(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsReceivesAssessmentReport(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsReceivesAssessmentReport(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsEmergencyContact(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsEmergencyContact(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsPickupRights(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsPickupRights(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsAttendanceContact(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsAttendanceContact(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsAccessToRecords(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsAccessToRecords(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsFamilyMail(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsFamilyMail(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsInterventionOrder(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsInterventionOrder(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsParentLegalGuardian(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsParentLegalGuardian(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsDisciplinaryContact(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsDisciplinaryContact(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsLivesWith(
      sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType value) {
    if (value != null) {
      return super.createStudentContactRelationshipTypeContactFlagsLivesWith(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeExitTypeOtherCodeList(
      sif.dd.au30.model.OtherCodeListType value) {
    if (value != null) {
      return super.createStudentSchoolEnrollmentTypeExitTypeOtherCodeList(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<ContactInfoType> createReportAuthorityInfoTypeContactInfo(sif.dd.au30.model.ContactInfoType value) {
    if (value != null) {
      return super.createReportAuthorityInfoTypeContactInfo(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<PhoneNumberType> createReportAuthorityInfoTypePhoneNumber(sif.dd.au30.model.PhoneNumberType value) {
    if (value != null) {
      return super.createReportAuthorityInfoTypePhoneNumber(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<String> createReportAuthorityInfoTypeAuthorityDepartment(java.lang.String value) {
    if (value != null) {
      return super.createReportAuthorityInfoTypeAuthorityDepartment(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFMetadataType> createReportAuthorityInfoTypeSIFMetadata(sif.dd.au30.model.SIFMetadataType value) {
    if (value != null) {
      return super.createReportAuthorityInfoTypeSIFMetadata(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<SIFExtendedElementsType> createReportAuthorityInfoTypeSIFExtendedElements(
      sif.dd.au30.model.SIFExtendedElementsType value) {
    if (value != null) {
      return super.createReportAuthorityInfoTypeSIFExtendedElements(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<AddressType> createReportAuthorityInfoTypeAddress(sif.dd.au30.model.AddressType value) {
    if (value != null) {
      return super.createReportAuthorityInfoTypeAddress(value);
    } else {
      return null;
    }
  }

  @Override
  public JAXBElement<LifeCycleType.Created.Creators> createLifeCycleTypeCreatedCreators(
      sif.dd.au30.model.LifeCycleType.Created.Creators value) {
    if (value != null) {
      return super.createLifeCycleTypeCreatedCreators(value);
    } else {
      return null;
    }
  }

}
