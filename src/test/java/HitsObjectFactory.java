
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sif.dd.au30.model.ObjectFactory;

public class HitsObjectFactory /* extends ObjectFactory */{

  public static void main(String[] args) {
    HashMap<String, String> methodMap = getMethodMap();

    Class<ObjectFactory> clazz = ObjectFactory.class;
    Method[] methods = clazz.getMethods();
    for (int i = 0; i < methods.length; i++) {
      if (methods[i].getName().startsWith("create") && methods[i].getParameterTypes() != null
          && methods[i].getParameterTypes().length > 0) {
        printMethod(methods[i], methodMap);
      }
    }
  }

  public static void printMethod(Method method, HashMap<String, String> methodMap) {
    if (method.getParameterTypes().length == 1) {
      System.out.println("@Override");
      System.out.print("public ");
      System.out.print(methodMap.get(method.getName()));
      System.out.print(" " + method.getName() + "(" + method.getParameterTypes()[0].getCanonicalName() + " value");
      System.out.println(") {");
      System.out.println(" if (value != null) {");
      System.out.print("return super." + method.getName() + "(value);");
      System.out.println(" } else { return null; }");
      System.out.println("}\n");
    }
  }

  private static HashMap<String, String> getMethodMap() {
    HashMap<String, String> methodMap = new HashMap<String, String>();
    methodMap.put("createLanguageList", "JAXBElement<LanguageListType>");
    methodMap.put("createSif3AssessmentAsset", "JAXBElement<Sif3AssessmentAssetType>");
    methodMap.put("createDemographics", "JAXBElement<DemographicsType>");
    methodMap.put("createSif3AssessmentItemAssociations", "JAXBElement<Sif3AssessmentItemAssociationCollectionType>");
    methodMap.put("createSchoolInfo", "JAXBElement<SchoolInfoType>");
    methodMap.put("createSIFQuery", "JAXBElement<SIFQueryType>");
    methodMap.put("createProjectedGraduationYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentScoreSets", "JAXBElement<StudentScoreSetCollectionType>");
    methodMap.put("createLearningResourcePackage", "JAXBElement<LearningResourcePackageType>");
    methodMap.put("createReportAuthorityInfos", "JAXBElement<ReportAuthorityInfoCollectionType>");
    methodMap.put("createSectionInfo", "JAXBElement<SectionInfoType>");
    methodMap.put("createSif3AssessmentItemAssociation", "JAXBElement<Sif3AssessmentItemAssociationType>");
    methodMap.put("createSIFContext", "JAXBElement<String>");
    methodMap.put("createTeachingGroup", "JAXBElement<TeachingGroupType>");
    methodMap.put("createCalendarSummary", "JAXBElement<CalendarSummaryType>");
    methodMap.put("createStudentSnapshots", "JAXBElement<StudentSnapshotCollectionType>");
    methodMap.put("createScheduledActivity", "JAXBElement<ScheduledActivityType>");
    methodMap.put("createStudentPersonals", "JAXBElement<StudentCollectionType>");
    methodMap.put("createTermInfos", "JAXBElement<TermInfoCollectionType>");
    methodMap.put("createSif3AssessmentSubTests", "JAXBElement<Sif3AssessmentSubTestCollectionType>");
    methodMap.put("createSubjectArea", "JAXBElement<SubjectAreaType>");
    methodMap.put("createEmailList", "JAXBElement<EmailListType>");
    methodMap.put("createStaffAssignment", "JAXBElement<StaffAssignmentType>");
    methodMap.put("createSif3AssessmentSessions", "JAXBElement<Sif3AssessmentSessionCollectionType>");
    methodMap.put("createPhoneNumber", "JAXBElement<PhoneNumberType>");
    methodMap.put("createTeachingGroups", "JAXBElement<TeachingGroupCollectionType>");
    methodMap.put("createStateProvinceId", "JAXBElement<String>");
    methodMap.put("createCountry", "JAXBElement<String>");
    methodMap.put("createSubjectAreaList", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSchoolCourseInfos", "JAXBElement<SchoolCourseInfoCollectionType>");
    methodMap.put("createStudentSchoolEnrollment", "JAXBElement<StudentSchoolEnrollmentType>");
    methodMap.put("createAssessmentRegistration", "JAXBElement<AssessmentRegistrationType>");
    methodMap.put("createSif3AssessmentScoreTable", "JAXBElement<Sif3AssessmentScoreTableType>");
    methodMap.put("createAssessmentForms", "JAXBElement<AssessmentFormCollectionType>");
    methodMap.put("createAssessmentRegistrations", "JAXBElement<AssessmentRegistrationCollectionType>");
    methodMap.put("createStudentActivityInfos", "JAXBElement<StudentActivityInfoCollectionType>");
    methodMap.put("createTimeTableSubjects", "JAXBElement<TimeTableSubjectCollectionType>");
    methodMap.put("createHomeroomNumber", "JAXBElement<String>");
    methodMap.put("createOtherNames", "JAXBElement<OtherNamesType>");
    methodMap.put("createActivity", "JAXBElement<ActivityType>");
    methodMap.put("createEmail", "JAXBElement<EmailType>");
    methodMap.put("createStaffPersonals", "JAXBElement<StaffCollectionType>");
    methodMap.put("createSif3AssessmentRubrics", "JAXBElement<Sif3AssessmentRubricCollectionType>");
    methodMap.put("createOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createAssessmentAdministrations", "JAXBElement<AssessmentAdministrationCollectionType>");
    methodMap.put("createStudentDailyAttendances", "JAXBElement<StudentDailyAttendanceCollectionType>");
    methodMap.put("createSIFReportObject", "JAXBElement<SIFReportObjectType>");
    methodMap.put("createPersonPicture", "JAXBElement<PersonPictureType>");
    methodMap.put("createReportManifest", "JAXBElement<ReportManifestType>");
    methodMap.put("createStudentParticipations", "JAXBElement<StudentParticipationCollectionType>");
    methodMap.put("createStateProvince", "JAXBElement<String>");
    methodMap.put("createAssessmentForm", "JAXBElement<AssessmentFormType>");
    methodMap.put("createStudentAttendanceSummary", "JAXBElement<StudentAttendanceSummaryType>");
    methodMap.put("createAggregateStatisticFacts", "JAXBElement<AggregateStatisticFactCollectionType>");
    methodMap.put("createSif3AssessmentAdministration", "JAXBElement<Sif3AssessmentAdministrationType>");
    methodMap.put("createSchoolPrograms", "JAXBElement<SchoolProgramsType>");
    methodMap.put("createLifeCycle", "JAXBElement<LifeCycleType>");
    methodMap.put("createStudentPeriodAttendance", "JAXBElement<StudentPeriodAttendanceType>");
    methodMap.put("createReportManifests", "JAXBElement<ReportManifestCollectionType>");
    methodMap.put("createSummaryEnrollmentInfo", "JAXBElement<SummaryEnrollmentInfoType>");
    methodMap.put("createSummaryEnrollmentInfos", "JAXBElement<SummaryEnrollmentInfoCollectionType>");
    methodMap.put("createStudentContactRelationships", "JAXBElement<StudentContactRelationshipCollectionType>");
    methodMap.put("createSif3AssessmentRegistration", "JAXBElement<Sif3AssessmentRegistrationType>");
    methodMap.put("createPhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createStaffAssignments", "JAXBElement<StaffAssignmentCollectionType>");
    methodMap.put("createSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createCalendarSummarys", "JAXBElement<CalendarSummaryCollectionType>");
    methodMap.put("createStudentContactRelationship", "JAXBElement<StudentContactRelationshipType>");
    methodMap.put("createSIFAuthenticationLevel", "JAXBElement<Long>");
    methodMap.put("createAggregateCharacteristicInfo", "JAXBElement<AggregateCharacteristicInfoType>");
    methodMap.put("createPublishInDirectory", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createResourceUsage", "JAXBElement<ResourceUsageType>");
    methodMap.put("createIdentitys", "JAXBElement<IdentityCollectionType>");
    methodMap.put("createAggregateStatisticFact", "JAXBElement<AggregateStatisticFactType>");
    methodMap.put("createAggregateCharacteristicInfos", "JAXBElement<AggregateCharacteristicInfoCollectionType>");
    methodMap.put("createAddressList", "JAXBElement<AddressListType>");
    methodMap.put("createSif3AssessmentItem", "JAXBElement<Sif3AssessmentItemType>");
    methodMap.put("createAggregateStatisticInfo", "JAXBElement<AggregateStatisticInfoType>");
    methodMap.put("createLearningStandardDocument", "JAXBElement<LearningStandardDocumentType>");
    methodMap.put("createLearningResourcePackages", "JAXBElement<LearningResourcePackageCollectionType>");
    methodMap.put("createLearningResource", "JAXBElement<LearningResourceType>");
    methodMap.put("createAttendanceCode", "JAXBElement<AttendanceCodeType>");
    methodMap.put("createSIFEncryptionLevel", "JAXBElement<Long>");
    methodMap.put("createACStrandSubjectArea", "JAXBElement<ACStrandSubjectAreaType>");
    methodMap.put("createResourceUsages", "JAXBElement<ResourceUsageCollectionType>");
    methodMap.put("createEducationalLevel", "JAXBElement<String>");
    methodMap.put("createEducationFilter", "JAXBElement<EducationFilterType>");
    methodMap.put("createSif3AssessmentScoreTables", "JAXBElement<Sif3AssessmentScoreTableCollectionType>");
    methodMap.put("createAggregateStatisticInfos", "JAXBElement<AggregateStatisticInfoCollectionType>");
    methodMap.put("createElectronicIdList", "JAXBElement<ElectronicIdListType>");
    methodMap.put("createSif3AssessmentRubric", "JAXBElement<Sif3AssessmentRubricType>");
    methodMap.put("createElectronicId", "JAXBElement<ElectronicIdType>");
    methodMap.put("createAddress", "JAXBElement<AddressType>");
    methodMap.put("createTimeTable", "JAXBElement<TimeTableType>");
    methodMap.put("createAssessmentItem", "JAXBElement<AssessmentItemType>");
    methodMap.put("createYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createSif3AssessmentForm", "JAXBElement<Sif3AssessmentFormType>");
    methodMap.put("createSessionInfo", "JAXBElement<SessionInfoType>");
    methodMap.put("createAssessmentItems", "JAXBElement<AssessmentItemCollectionType>");
    methodMap.put("createRoomInfos", "JAXBElement<RoomInfoCollectionType>");
    methodMap.put("createAssessment", "JAXBElement<AssessmentType>");
    methodMap.put("createTimeElement", "JAXBElement<TimeElementType>");
    methodMap.put("createTimeTableCells", "JAXBElement<TimeTableCellCollectionType>");
    methodMap.put("createSif3Assessments", "JAXBElement<Sif3AssessmentCollectionType>");
    methodMap.put("createSystemRole", "JAXBElement<SystemRoleType>");
    methodMap.put("createStudentActivityParticipations", "JAXBElement<StudentActivityParticipationCollectionType>");
    methodMap.put("createTimeTableCell", "JAXBElement<TimeTableCellType>");
    methodMap.put("createStudentSDTN", "JAXBElement<StudentSDTNType>");
    methodMap.put("createLearningStandardDocuments", "JAXBElement<LearningStandardDocumentCollectionType>");
    methodMap.put("createAssessmentSubTest", "JAXBElement<AssessmentSubTestType>");
    methodMap.put("createLearningStandardItem", "JAXBElement<LearningStandardItemType>");
    methodMap.put("createLearningStandardItems", "JAXBElement<LearningStandardItemCollectionType>");
    methodMap.put("createStudentSectionEnrollments", "JAXBElement<StudentSectionEnrollmentCollectionType>");
    methodMap.put("createBirthDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSif3AssessmentAssets", "JAXBElement<Sif3AssessmentAssetCollectionType>");
    methodMap.put("createSif3StudentResponseSets", "JAXBElement<Sif3StudentResponseSetCollectionType>");
    methodMap.put("createTimeTableSubject", "JAXBElement<TimeTableSubjectType>");
    methodMap.put("createSif3StudentResponseSet", "JAXBElement<Sif3StudentResponseSetType>");
    methodMap.put("createSchoolProgramss", "JAXBElement<SchoolProgramsCollectionType>");
    methodMap.put("createContactInfo", "JAXBElement<ContactInfoType>");
    methodMap.put("createRelationship", "JAXBElement<RelationshipType>");
    methodMap.put("createSif3AssessmentItems", "JAXBElement<Sif3AssessmentItemCollectionType>");
    methodMap.put("createAssessmentSubTests", "JAXBElement<AssessmentSubTestCollectionType>");
    methodMap.put("createCalendarDates", "JAXBElement<CalendarDateCollectionType>");
    methodMap.put("createStudentSnapshot", "JAXBElement<StudentSnapshotType>");
    methodMap.put("createLocalId", "JAXBElement<String>");
    methodMap.put("createStudentPeriodAttendances", "JAXBElement<StudentPeriodAttendanceCollectionType>");
    methodMap.put("createStudentActivityParticipation", "JAXBElement<StudentActivityParticipationType>");
    methodMap.put("createTermInfo", "JAXBElement<TermInfoType>");
    methodMap.put("createRoomInfo", "JAXBElement<RoomInfoType>");
    methodMap.put("createAssessmentPackages", "JAXBElement<AssessmentPackageCollectionType>");
    methodMap.put("createStudentActivityInfo", "JAXBElement<StudentActivityInfoType>");
    methodMap.put("createStudentContactPersonal", "JAXBElement<StudentContactPersonalType>");
    methodMap.put("createSchoolContactList", "JAXBElement<SchoolContactListType>");
    methodMap.put("createStudentPersonal", "JAXBElement<StudentPersonalType>");
    methodMap.put("createSIFContexts", "JAXBElement<SIFContextsType>");
    methodMap.put("createSif3AssessmentForms", "JAXBElement<Sif3AssessmentFormCollectionType>");
    methodMap.put("createYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSchoolURL", "JAXBElement<String>");
    methodMap.put("createPersonPictures", "JAXBElement<PersonPictureCollectionType>");
    methodMap.put("createPrincipalInfo", "JAXBElement<PrincipalInfoType>");
    methodMap.put("createStudentContactPersonals", "JAXBElement<StudentContactCollectionType>");
    methodMap.put("createAssessmentPackage", "JAXBElement<AssessmentPackageType>");
    methodMap.put("createReportAuthorityInfo", "JAXBElement<ReportAuthorityInfoType>");
    methodMap.put("createStudentAttendanceSummarys", "JAXBElement<StudentAttendanceSummaryCollectionType>");
    methodMap.put("createStaffPersonal", "JAXBElement<StaffPersonalType>");
    methodMap.put("createSif3AssessmentAdministrations", "JAXBElement<Sif3AssessmentAdministrationCollectionType>");
    methodMap.put("createCalendarDate", "JAXBElement<CalendarDate>");
    methodMap.put("createAssessmentAdministration", "JAXBElement<AssessmentAdministrationType>");
    methodMap.put("createSectionInfos", "JAXBElement<SectionInfoCollectionType>");
    methodMap.put("createStudentParticipation", "JAXBElement<StudentParticipationType>");
    methodMap.put("createGridLocation", "JAXBElement<GridLocationType>");
    methodMap.put("createSif3AssessmentSession", "JAXBElement<Sif3AssessmentSessionType>");
    methodMap.put("createSystemRoles", "JAXBElement<SystemRoleCollectionType>");
    methodMap.put("createEnglishProficiency", "JAXBElement<EnglishProficiencyType>");
    methodMap.put("createSif3AssessmentSection", "JAXBElement<Sif3AssessmentSectionType>");
    methodMap.put("createLEAInfos", "JAXBElement<LEAInfoCollectionType>");
    methodMap.put("createLearningResources", "JAXBElement<LearningResourceCollectionType>");
    methodMap.put("createSif3Assessment", "JAXBElement<Sif3AssessmentType>");
    methodMap.put("createAssessments", "JAXBElement<AssessmentCollectionType>");
    methodMap.put("createSif3AssessmentSubTest", "JAXBElement<Sif3AssessmentSubTestType>");
    methodMap.put("createSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSchoolEnrollments", "JAXBElement<StudentSchoolEnrollmentCollectionType>");
    methodMap.put("createOnTimeGraduationYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTimeTables", "JAXBElement<TimeTableCollectionType>");
    methodMap.put("createLocation", "JAXBElement<LocationType>");
    methodMap.put("createSif3AssessmentSections", "JAXBElement<Sif3AssessmentSectionCollectionType>");
    methodMap.put("createSchoolInfos", "JAXBElement<SchoolCollectionType>");
    methodMap.put("createSif3AssessmentRegistrations", "JAXBElement<Sif3AssessmentRegistrationCollectionType>");
    methodMap.put("createOperationalStatus", "JAXBElement<AUCodeSetsOperationalStatusType>");
    methodMap.put("createStudentSDTNs", "JAXBElement<StudentSDTNCollectionType>");
    methodMap.put("createStudentDailyAttendance", "JAXBElement<StudentDailyAttendanceType>");
    methodMap.put("createSchoolCourseInfo", "JAXBElement<SchoolCourseInfoType>");
    methodMap.put("createStudentSectionEnrollment", "JAXBElement<StudentSectionEnrollmentType>");
    methodMap.put("createLEAInfo", "JAXBElement<LEAInfoType>");
    methodMap.put("createStudentScoreSet", "JAXBElement<StudentScoreSetType>");
    methodMap.put("createActivitys", "JAXBElement<ActivityCollectionType>");
    methodMap.put("createSIFReportObjects", "JAXBElement<SIFReportObjectCollectionType>");
    methodMap.put("createPersonInfo", "JAXBElement<PersonInfoType>");
    methodMap.put("createGraduationDate", "JAXBElement<String>");
    methodMap.put("createName", "JAXBElement<NameType>");
    methodMap.put("createProgramStatus", "JAXBElement<ProgramStatusType>");
    methodMap.put("createSessionInfos", "JAXBElement<SessionInfoCollectionType>");
    methodMap.put("createIdentity", "JAXBElement<IdentityType>");
    methodMap.put("createScheduledActivitys", "JAXBElement<ScheduledActivityCollectionType>");
    methodMap.put("createACStrandSubjectAreaTypeSubjectArea", "JAXBElement<SubjectAreaType>");
    methodMap.put("createAssessmentSubTestTypeScoreRange", "JAXBElement<AssessmentSubTestType.ScoreRange>");
    methodMap.put("createAssessmentSubTestTypePerformanceLevels",
        "JAXBElement<AssessmentSubTestType.PerformanceLevels>");
    methodMap.put("createAssessmentSubTestTypeSubTestTier", "JAXBElement<Long>");
    methodMap.put("createAssessmentSubTestTypeDescription", "JAXBElement<String>");
    methodMap.put("createAssessmentSubTestTypeContainerOnly", "JAXBElement<Boolean>");
    methodMap.put("createAssessmentSubTestTypeAssessmentSubTestRefIds",
        "JAXBElement<AssessmentSubTestType.AssessmentSubTestRefIds>");
    methodMap.put("createAssessmentSubTestTypeAbbreviation", "JAXBElement<String>");
    methodMap.put("createAssessmentSubTestTypeNumberOfItems", "JAXBElement<Long>");
    methodMap.put("createAssessmentSubTestTypeLearningStandardItemRefIds",
        "JAXBElement<AssessmentSubTestType.LearningStandardItemRefIds>");
    methodMap.put("createAssessmentSubTestTypeSubjectArea", "JAXBElement<String>");
    methodMap.put("createAssessmentSubTestTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentSubTestTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createAssessmentSubTestTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotOnTimeGraduationYear",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap
        .put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotStateProvinceId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotNeglectedDelinquent",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotEconomicDisadvantage",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAge", "JAXBElement<Long>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotProjectedGraduationYear",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationOnTime",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationDate", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotSex", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotName", "JAXBElement<NameType>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGiftedTalented",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap
        .put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationAward", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAddress", "JAXBElement<AddressType>");
    methodMap
        .put("createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreCode", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreValue",
        "JAXBElement<String>");
    methodMap
        .put("createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreType", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeFurtherInformationPhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createStudentSDTNTypeFurtherInformationEmailList", "JAXBElement<EmailListType>");
    methodMap.put("createStudentSDTNTypeFurtherInformationContactName", "JAXBElement<NameOfRecordType>");
    methodMap.put("createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresUpperCut",
        "JAXBElement<String>");
    methodMap.put("createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresLowerCut",
        "JAXBElement<String>");
    methodMap.put("createAssessmentTypeAssessmentId", "JAXBElement<String>");
    methodMap.put("createAssessmentTypeAssessmentPackageRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentTypeAssessmentDescriptors", "JAXBElement<AssessmentType.AssessmentDescriptors>");
    methodMap.put("createAssessmentTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber",
        "JAXBElement<Long>");
    methodMap.put("createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId",
        "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription",
        "JAXBElement<SubjectAreaType>");
    methodMap.put("createPersonInfoTypeDemographics", "JAXBElement<DemographicsType>");
    methodMap.put("createPersonInfoTypeOtherNames", "JAXBElement<OtherNamesType>");
    methodMap.put("createPersonInfoTypeAddressList", "JAXBElement<AddressListType>");
    methodMap.put("createPersonInfoTypePhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createPersonInfoTypeEmailList", "JAXBElement<EmailListType>");
    methodMap.put("createResourceUsageTypeResourceUsageContentTypeLocalDescription", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeOtherLearningAreasListOtherLearningAreaResult",
        "JAXBElement<AUCodeSetsProgressLevelType>");
    methodMap.put("createAddressTypeStateProvince", "JAXBElement<String>");
    methodMap.put("createAddressTypeAddressGlobalUID", "JAXBElement<String>");
    methodMap.put("createAddressTypeLocalId", "JAXBElement<String>");
    methodMap.put("createAddressTypeRadioContact", "JAXBElement<String>");
    methodMap.put("createAddressTypeMapReference", "JAXBElement<AddressType.MapReference>");
    methodMap.put("createAddressTypeCountry", "JAXBElement<String>");
    methodMap.put("createAddressTypeCommunity", "JAXBElement<String>");
    methodMap.put("createAddressTypeGridLocation", "JAXBElement<GridLocationType>");
    methodMap.put("createAddressTypeStatisticalAreas", "JAXBElement<AddressType.StatisticalAreas>");
    methodMap.put("createActivityTypeActivityTimeFinishDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createActivityTypeActivityTimeStartDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createActivityTypeActivityTimeDueDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createActivityTypeActivityTimeDuration", "JAXBElement<ActivityType.ActivityTime.Duration>");
    methodMap.put("createAttendanceCodeTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createLEAInfoTypeStateProvinceId", "JAXBElement<String>");
    methodMap.put("createLEAInfoTypeSLA", "JAXBElement<String>");
    methodMap.put("createLEAInfoTypeEducationAgencyType", "JAXBElement<LEAInfoType.EducationAgencyType>");
    methodMap.put("createLEAInfoTypeOperationalStatus", "JAXBElement<AUCodeSetsOperationalStatusType>");
    methodMap.put("createLEAInfoTypeCommonwealthId", "JAXBElement<String>");
    methodMap.put("createLEAInfoTypeAddressList", "JAXBElement<AddressListType>");
    methodMap.put("createLEAInfoTypeLEAContactList", "JAXBElement<LEAInfoType.LEAContactList>");
    methodMap.put("createLEAInfoTypePhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createLEAInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createLEAInfoTypeLEAURL", "JAXBElement<String>");
    methodMap.put("createLEAInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createLEAInfoTypeJurisdictionLowerHouse", "JAXBElement<String>");
    methodMap.put("createActivityTypeLearningObjectives", "JAXBElement<ActivityType.LearningObjectives>");
    methodMap.put("createActivityTypeStudents", "JAXBElement<ActivityType.Students>");
    methodMap.put("createActivityTypePoints", "JAXBElement<Long>");
    methodMap.put("createActivityTypeTitle", "JAXBElement<String>");
    methodMap.put("createActivityTypeEssentialMaterials", "JAXBElement<ActivityType.EssentialMaterials>");
    methodMap.put("createActivityTypeAssessmentRefId", "JAXBElement<String>");
    methodMap.put("createActivityTypeActivityWeight", "JAXBElement<BigDecimal>");
    methodMap.put("createActivityTypeTechnicalRequirements", "JAXBElement<ActivityType.TechnicalRequirements>");
    methodMap.put("createActivityTypePrerequisites", "JAXBElement<ActivityType.Prerequisites>");
    methodMap.put("createActivityTypeSoftwareRequirementList", "JAXBElement<ActivityType.SoftwareRequirementList>");
    methodMap.put("createActivityTypeLearningResources", "JAXBElement<ActivityType.LearningResources>");
    methodMap.put("createActivityTypeMaxAttemptsAllowed", "JAXBElement<Long>");
    methodMap.put("createActivityTypeEvaluation", "JAXBElement<ActivityType.Evaluation>");
    methodMap.put("createActivityTypePreamble", "JAXBElement<String>");
    methodMap.put("createActivityTypeSourceObjects", "JAXBElement<ActivityType.SourceObjects>");
    methodMap.put("createActivityTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createActivityTypeSubjectArea", "JAXBElement<SubjectAreaType>");
    methodMap.put("createActivityTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createActivityTypeLearningStandards", "JAXBElement<ActivityType.LearningStandards>");
    methodMap.put("createTimeTableCellTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeStaffLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeSubjectLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeTimeTableLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeStaffPersonalRefId", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeRoomNumber", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableCellTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createTimeTableCellTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createTimeTableCellTypeTeachingGroupLocalId", "JAXBElement<String>");
    methodMap.put("createSIFQueryDataModelTypeSIFConditionGroup",
        "JAXBElement<SIFQueryDataModelType.SIFConditionGroup>");
    methodMap.put("createSIFQueryDataModelTypeSIFExample", "JAXBElement<ObjectType>");
    methodMap.put("createIdentityTypeIdentityAssertions", "JAXBElement<IdentityType.IdentityAssertions>");
    methodMap.put("createIdentityTypePasswordList", "JAXBElement<IdentityType.PasswordList>");
    methodMap.put("createIdentityTypeAuthenticationSourceGlobalUID", "JAXBElement<String>");
    methodMap.put("createIdentityTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createIdentityTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAggregateStatisticInfoTypeEffectiveDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createAggregateStatisticInfoTypeLocation", "JAXBElement<LocationType>");
    methodMap.put("createAggregateStatisticInfoTypeMeasure", "JAXBElement<String>");
    methodMap.put("createAggregateStatisticInfoTypeDiscontinueDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createAggregateStatisticInfoTypeCalculationRule",
        "JAXBElement<AggregateStatisticInfoType.CalculationRule>");
    methodMap.put("createAggregateStatisticInfoTypeApprovalDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createAggregateStatisticInfoTypeExpirationDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createAggregateStatisticInfoTypeSource", "JAXBElement<String>");
    methodMap.put("createAggregateStatisticInfoTypeExclusionRules",
        "JAXBElement<AggregateStatisticInfoType.ExclusionRules>");
    methodMap.put("createAggregateStatisticInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAggregateStatisticInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createLearningResourceTypeLearningResourcePackageRefId", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeAuthor", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeLocation", "JAXBElement<LearningResourceType.Location>");
    methodMap.put("createLearningResourceTypeSubjectAreas", "JAXBElement<LearningResourceType.SubjectAreas>");
    methodMap.put("createLearningResourceTypeApprovals", "JAXBElement<LearningResourceType.Approvals>");
    methodMap.put("createLearningResourceTypeDescription", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeUseAgreement", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeContacts", "JAXBElement<LearningResourceType.Contacts>");
    methodMap.put("createLearningResourceTypeMediaTypes", "JAXBElement<LearningResourceType.MediaTypes>");
    methodMap.put("createLearningResourceTypeAgreementDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningResourceTypeStatus", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeEvaluations", "JAXBElement<LearningResourceType.Evaluations>");
    methodMap.put("createLearningResourceTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createLearningResourceTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createLearningResourceTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createLearningResourceTypeLearningStandards", "JAXBElement<LearningResourceType.LearningStandards>");
    methodMap.put("createSchoolInfoTypeCampusCampusType", "JAXBElement<AUCodeSetsSchoolLevelType>");
    methodMap.put("createSchoolInfoTypeCampusParentSchoolId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId",
        "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStartTime",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId",
        "JAXBElement<String>");
    methodMap.put("createStudentParticipationTypeReferralDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeProgramAvailability",
        "JAXBElement<StudentParticipationType.ProgramAvailability>");
    methodMap.put("createStudentParticipationTypePlacementParentalConsentDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeGiftedEligibilityCriteria",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentParticipationTypeEvaluationExtensionDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeParticipationContact", "JAXBElement<String>");
    methodMap.put("createStudentParticipationTypeProgramPlacementDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentParticipationTypeReferralSource",
        "JAXBElement<StudentParticipationType.ReferralSource>");
    methodMap.put("createStudentParticipationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentParticipationTypeEntryPerson", "JAXBElement<String>");
    methodMap.put("createStudentParticipationTypeEvaluationDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeReevaluationDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeExtendedSchoolYear", "JAXBElement<Boolean>");
    methodMap.put("createStudentParticipationTypeNOREPDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeExtendedDay", "JAXBElement<Boolean>");
    methodMap.put("createStudentParticipationTypeProgramEligibilityDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeEvaluationParentalConsentDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeProgramFundingSources",
        "JAXBElement<StudentParticipationType.ProgramFundingSources>");
    methodMap.put("createStudentParticipationTypeProgramPlanDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentParticipationTypeProgramStatus", "JAXBElement<ProgramStatusType>");
    methodMap.put("createStudentParticipationTypeExtensionComments", "JAXBElement<String>");
    methodMap.put("createStudentParticipationTypeProgramType", "JAXBElement<String>");
    methodMap.put("createStudentParticipationTypeStudentSpecialEducationFTE", "JAXBElement<BigDecimal>");
    methodMap.put("createStudentParticipationTypeProgramPlanEffectiveDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningStandardItemTypeStandardSettingBodyStateProvince", "JAXBElement<String>");
    methodMap.put("createLearningStandardItemTypeStandardSettingBodySettingBodyName", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAssetTypeAssetIdentifiers",
        "JAXBElement<Sif3AssessmentAssetType.AssetIdentifiers>");
    methodMap.put("createSif3AssessmentAssetTypeAssetLanguage", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAssetTypeAssetName", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAssetTypeAssetVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAssetTypeAssetLearningStandards",
        "JAXBElement<Sif3AssessmentAssetType.AssetLearningStandards>");
    methodMap.put("createSif3AssessmentAssetTypeAssetOwner", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAssetTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentAssetTypeAssetSubjects", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSif3AssessmentAssetTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentAssetTypeAssetGradeLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentAssetTypeAssetPublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideCourseCredits", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideDistrictCourseCode", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideStateCourseCode", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideCourseTitle", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideInstructionalLevel", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideSubjectArea", "JAXBElement<SubjectAreaType>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverrideCourseCode", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList",
        "JAXBElement<Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreValuesScoreValuePassFailIndicator", "JAXBElement<String>");
    methodMap.put("createCalendarSummaryTypeFirstInstructionDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createCalendarSummaryTypeLastInstructionDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createCalendarSummaryTypeGraduationDate", "JAXBElement<String>");
    methodMap.put("createCalendarSummaryTypeInstructionalMinutes", "JAXBElement<Long>");
    methodMap.put("createCalendarSummaryTypeDescription", "JAXBElement<String>");
    methodMap.put("createCalendarSummaryTypeMinutesPerDay", "JAXBElement<Long>");
    methodMap.put("createCalendarSummaryTypeEndDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createCalendarSummaryTypeStartDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createCalendarSummaryTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createCalendarSummaryTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createCalendarSummaryTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSummaryEnrollmentInfoTypeStateProvinceId", "JAXBElement<String>");
    methodMap.put("createSummaryEnrollmentInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSummaryEnrollmentInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createEnglishProficiencyTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createSystemRoleTypeSystemContextListSystemContextRoleList",
        "JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList>");
    methodMap.put("createStudentPersonalTypeMostRecentParent2Language", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createStudentPersonalTypeMostRecentParent1Language", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentParent2EmploymentType", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentParent1NonSchoolEducation", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentParent1SchoolEducationLevel", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentParent1EmploymentType", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentHomeroomLocalId", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentParent2SchoolEducationLevel", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeMostRecentParent2NonSchoolEducation", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeReligiousAffiliation", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeSchoolURL", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypePrincipalInfo", "JAXBElement<PrincipalInfoType>");
    methodMap.put("createSchoolInfoTypeOtherIdList", "JAXBElement<SchoolInfoType.OtherIdList>");
    methodMap.put("createSchoolInfoTypeFederalElectorate", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeCampus", "JAXBElement<SchoolInfoType.Campus>");
    methodMap.put("createSchoolInfoTypeSLA", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeEntityOpen", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSchoolInfoTypeLocalGovernmentArea", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeSchoolDistrict", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeNonGovSystemicStatus", "JAXBElement<AUCodeSetsSystemicStatusType>");
    methodMap.put("createSchoolInfoTypeSystem", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeCommonwealthId", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeSchoolGroupList", "JAXBElement<SchoolInfoType.SchoolGroupList>");
    methodMap.put("createSchoolInfoTypeEntityClose", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSchoolInfoTypeSchoolFocusList", "JAXBElement<SchoolInfoType.SchoolFocusList>");
    methodMap.put("createSchoolInfoTypePhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createSchoolInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSchoolInfoTypeSchoolGeographicLocation", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSchoolInfoTypeSessionType", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeBoardingSchoolStatus", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSchoolInfoTypeOtherLEA", "JAXBElement<SchoolInfoType.OtherLEA>");
    methodMap.put("createSchoolInfoTypeStateProvinceId", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeSchoolDistrictLocalId", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeOperationalStatus", "JAXBElement<AUCodeSetsOperationalStatusType>");
    methodMap.put("createSchoolInfoTypeAddressList", "JAXBElement<AddressListType>");
    methodMap.put("createSchoolInfoTypeSchoolCoEdStatus", "JAXBElement<AUCodeSetsSchoolCoEdStatusType>");
    methodMap.put("createSchoolInfoTypeJurisdictionLowerHouse", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeLEAInfoRefId", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeLocalId", "JAXBElement<String>");
    methodMap.put("createSchoolInfoTypeARIA", "JAXBElement<BigDecimal>");
    methodMap.put("createSchoolInfoTypeSchoolContactList", "JAXBElement<SchoolContactListType>");
    methodMap.put("createSchoolInfoTypeSchoolType", "JAXBElement<AUCodeSetsSchoolLevelType>");
    methodMap.put("createSchoolInfoTypeIndependentSchool", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSchoolInfoTypeSchoolEmailList", "JAXBElement<EmailListType>");
    methodMap.put("createSchoolInfoTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createDemographicsTypeVisaStatisticalCode", "JAXBElement<String>");
    methodMap.put("createDemographicsTypePlaceOfBirth", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeLanguageList", "JAXBElement<LanguageListType>");
    methodMap.put("createDemographicsTypeVisaExpiryDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createDemographicsTypeBirthDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createDemographicsTypeCulturalBackground", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeAustralianCitizenshipStatus", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeImmunisationCertificateStatus",
        "JAXBElement<AUCodeSetsImmunisationCertificateStatusType>");
    methodMap.put("createDemographicsTypeBirthDateVerification", "JAXBElement<String>");
    methodMap.put("createDemographicsTypePermanentResident", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeReligiousEventList", "JAXBElement<DemographicsType.ReligiousEventList>");
    methodMap.put("createDemographicsTypeReligion", "JAXBElement<DemographicsType.Religion>");
    methodMap.put("createDemographicsTypeCountryOfBirth", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeEnglishProficiency", "JAXBElement<EnglishProficiencyType>");
    methodMap.put("createDemographicsTypeIndigenousStatus", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeCountryArrivalDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createDemographicsTypeMaritalStatus", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeCountriesOfResidency", "JAXBElement<DemographicsType.CountriesOfResidency>");
    methodMap.put("createDemographicsTypeSex", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeDwellingArrangement", "JAXBElement<DemographicsType.DwellingArrangement>");
    methodMap.put("createDemographicsTypeReligiousRegion", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeCountriesOfCitizenship",
        "JAXBElement<DemographicsType.CountriesOfCitizenship>");
    methodMap.put("createDemographicsTypeVisaSubClass", "JAXBElement<String>");
    methodMap.put("createDemographicsTypeStateOfBirth", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeResponseChoicesChoiceResponseFeedback", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeResponseChoicesChoiceCreditValue", "JAXBElement<Float>");
    methodMap.put("createSif3AssessmentItemTypeResponseChoicesChoiceChoiceLabel", "JAXBElement<String>");
    methodMap.put("createAssessmentPackageTypeXMLData", "JAXBElement<AssessmentPackageType.XMLData>");
    methodMap.put("createAssessmentPackageTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentPackageTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createTeachingGroupTypeLongName", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeachingGroupPeriodList",
        "JAXBElement<TeachingGroupType.TeachingGroupPeriodList>");
    methodMap.put("createTeachingGroupTypeCurriculumLevel", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeSchoolCourseLocalId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeSemester", "JAXBElement<Long>");
    methodMap.put("createTeachingGroupTypeMaxClassSize", "JAXBElement<BigInteger>");
    methodMap.put("createTeachingGroupTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeacherList", "JAXBElement<TeachingGroupType.TeacherList>");
    methodMap.put("createTeachingGroupTypeSet", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeSchoolCourseInfoRefId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTimeTableSubjectRefId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeBlock", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTimeTableSubjectLocalId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeMinClassSize", "JAXBElement<BigInteger>");
    methodMap.put("createTeachingGroupTypeStudentList", "JAXBElement<TeachingGroupType.StudentList>");
    methodMap.put("createTeachingGroupTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createTeachingGroupTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSchoolEnrollmentTypePromotionInfoPromotionStatus", "JAXBElement<String>");
    methodMap
        .put("createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId",
            "JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId>");
    methodMap.put("createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeName",
        "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypePromotionInfo",
        "JAXBElement<StudentSchoolEnrollmentType.PromotionInfo>");
    methodMap.put("createStudentSchoolEnrollmentTypeHomeroom", "JAXBElement<StudentSchoolEnrollmentType.Homeroom>");
    methodMap.put("createStudentSchoolEnrollmentTypeYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createStudentSchoolEnrollmentTypeCalendar", "JAXBElement<StudentSchoolEnrollmentType.Calendar>");
    methodMap.put("createStudentSchoolEnrollmentTypeCounselor", "JAXBElement<StudentSchoolEnrollmentType.Counselor>");
    methodMap.put("createStudentSchoolEnrollmentTypeExitDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSchoolEnrollmentTypeFTPTStatus", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeEntryType", "JAXBElement<StudentSchoolEnrollmentType.EntryType>");
    methodMap.put("createStudentSchoolEnrollmentTypeExitStatus", "JAXBElement<StudentSchoolEnrollmentType.ExitStatus>");
    methodMap.put("createStudentSchoolEnrollmentTypeStudentSubjectChoiceList",
        "JAXBElement<StudentSchoolEnrollmentType.StudentSubjectChoiceList>");
    methodMap.put("createStudentSchoolEnrollmentTypeFFPOS", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypePreviousSchool", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeCatchmentStatus",
        "JAXBElement<StudentSchoolEnrollmentType.CatchmentStatus>");
    methodMap.put("createStudentSchoolEnrollmentTypeAdvisor", "JAXBElement<StudentSchoolEnrollmentType.Advisor>");
    methodMap.put("createStudentSchoolEnrollmentTypeHouse", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeExitType", "JAXBElement<StudentSchoolEnrollmentType.ExitType>");
    methodMap.put("createStudentSchoolEnrollmentTypeHomegroup", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeRecordClosureReason", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeDestinationSchool", "JAXBElement<String>");
    methodMap.put("createStudentSchoolEnrollmentTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentSchoolEnrollmentTypeFTE", "JAXBElement<BigDecimal>");
    methodMap.put("createStudentSchoolEnrollmentTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSchoolEnrollmentTypeIndividualLearningPlan",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresUpperCut", "JAXBElement<String>");
    methodMap.put("createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresLowerCut", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName",
        "JAXBElement<String>");
    methodMap.put("createLEAInfoTypeLEAContactListLEAContactPublishInDirectory",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createTimeTableSubjectTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createTimeTableSubjectTypeAcademicYear", "JAXBElement<YearLevelType>");
    methodMap.put("createTimeTableSubjectTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTimeTableSubjectTypeAcademicYearRange", "JAXBElement<TimeTableSubjectType.AcademicYearRange>");
    methodMap.put("createTimeTableSubjectTypeFaculty", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeSemester", "JAXBElement<Long>");
    methodMap.put("createTimeTableSubjectTypeSubjectType", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeProposedMinClassSize", "JAXBElement<BigDecimal>");
    methodMap.put("createTimeTableSubjectTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeCourseLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeProposedMaxClassSize", "JAXBElement<BigDecimal>");
    methodMap.put("createTimeTableSubjectTypeSchoolCourseInfoRefId", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeSubjectShortName", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableSubjectTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createTimeTableSubjectTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createAssessmentRegistrationTypeAssessmentStudentSnapshotSex", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemCommentsCommentCommentDescription", "JAXBElement<String>");
    methodMap.put("createStudentContactRelationshipTypeMainlySpeaksEnglishAtHome",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactSequenceSource",
        "JAXBElement<AUCodeSetsSourceCodeTypeType>");
    methodMap.put("createStudentContactRelationshipTypeStudentContactRelationshipRefId", "JAXBElement<String>");
    methodMap.put("createStudentContactRelationshipTypeContactFlags",
        "JAXBElement<StudentContactRelationshipType.ContactFlags>");
    methodMap.put("createStudentContactRelationshipTypeHouseholdList",
        "JAXBElement<StudentContactRelationshipType.HouseholdList>");
    methodMap.put("createStudentContactRelationshipTypeContactSequence", "JAXBElement<Long>");
    methodMap.put("createStudentContactRelationshipTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentContactRelationshipTypeParentRelationshipStatus", "JAXBElement<String>");
    methodMap.put("createStudentContactRelationshipTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put(
        "createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodInstructionalMinutes",
        "JAXBElement<Long>");
    methodMap.put("createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod",
        "JAXBElement<String>");
    methodMap.put(
        "createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodUseInAttendanceCalculations",
        "JAXBElement<String>");
    methodMap.put(
        "createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodRegularSchoolPeriod",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRubricTypeScoresScoreScoreCodeDefinition",
        "JAXBElement<AbstractContentElementType>");
    methodMap.put("createSif3AssessmentRubricTypeScoresScoreScoreCode", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRubricTypeScoresScoreScoreComments",
        "JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreComments>");
    methodMap.put("createSif3AssessmentRubricTypeScoresScoreScoreDescriptions",
        "JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions>");
    methodMap.put("createResourceUsageTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createResourceUsageTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolInfoRefId",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentFullYearEnrollment",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolName",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom",
        "JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStateProvinceId",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentLocalId",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroomNumber",
        "JAXBElement<String>");
    methodMap.put(
        "createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStudentSchoolEnrollmentRefId",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSectionSealed", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeItemSelectionAlgorithm", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSectionAssets",
        "JAXBElement<Sif3AssessmentSectionType.SectionAssets>");
    methodMap.put("createSif3AssessmentSectionTypeSectionItems", "JAXBElement<Sif3AssessmentSectionType.SectionItems>");
    methodMap.put("createSif3AssessmentSectionTypeSectionTimeLimit", "JAXBElement<javax.xml.datatype.Duration>");
    methodMap.put("createSif3AssessmentSectionTypeSectionName", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSectionVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSectionIdentifiers",
        "JAXBElement<Sif3AssessmentSectionType.SectionIdentifiers>");
    methodMap.put("createSif3AssessmentSectionTypeItemSelectionAlgorithmName", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSectionReentry", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentSectionTypeSectionPublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentSectionTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentActivityInfoTypeLocation", "JAXBElement<LocationType>");
    methodMap.put("createStudentActivityInfoTypeCurricularStatus", "JAXBElement<String>");
    methodMap.put("createStudentActivityInfoTypeDescription", "JAXBElement<String>");
    methodMap.put("createStudentActivityInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentActivityInfoTypeStudentActivityLevel", "JAXBElement<String>");
    methodMap.put("createStudentActivityInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentActivityInfoTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentRegistrationTypeEndDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentRegistrationTypeDaysOfInstruction", "JAXBElement<Integer>");
    methodMap.put("createSif3AssessmentRegistrationTypeTestingStatuses",
        "JAXBElement<Sif3AssessmentRegistrationType.TestingStatuses>");
    methodMap.put("createSif3AssessmentRegistrationTypeScorePublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentRegistrationTypeRetestIndicator", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeTestAttemptIdentifier", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeStudentSpecialEvents",
        "JAXBElement<Sif3AssessmentRegistrationType.StudentSpecialEvents>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentAdministrationRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentPlatform", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeStudentGradeLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createSif3AssessmentRegistrationTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeLEAInfoRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeSectionInfoRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentFormRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeStaffPersonalRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot",
        "JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentSessionRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRegistrationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentRegistrationTypeAssessmentGradeLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createSif3AssessmentRegistrationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentParticipationTypeReferralSourceOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackDescription",
        "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackSource",
        "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackCode",
        "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemDiagnosticStatement",
        "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypePreviousSchoolsListPreviousSchoolReasonLeft", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSubTestTypeSubTestIdentifiers",
        "JAXBElement<Sif3AssessmentSubTestType.SubTestIdentifiers>");
    methodMap.put("createSif3AssessmentSubTestTypeAssessmentItems",
        "JAXBElement<Sif3AssessmentSubTestType.AssessmentItems>");
    methodMap.put("createSif3AssessmentSubTestTypeSubTestPublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentSubTestTypeSubTestSubjectAreas", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSif3AssessmentSubTestTypeSubTestTier", "JAXBElement<Long>");
    methodMap.put("createSif3AssessmentSubTestTypeDescription", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSubTestTypeContainerOnly", "JAXBElement<Boolean>");
    methodMap.put("createSif3AssessmentSubTestTypeAssessmentSubTestRefIds",
        "JAXBElement<Sif3AssessmentSubTestType.AssessmentSubTestRefIds>");
    methodMap.put("createSif3AssessmentSubTestTypeScoreReporting",
        "JAXBElement<Sif3AssessmentSubTestType.ScoreReporting>");
    methodMap.put("createSif3AssessmentSubTestTypeAbbreviation", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSubTestTypeSubTestGradeLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentSubTestTypeNumberOfItems", "JAXBElement<Long>");
    methodMap.put("createSif3AssessmentSubTestTypeSubTestVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSubTestTypeLearningStandardItemRefIds",
        "JAXBElement<Sif3AssessmentSubTestType.LearningStandardItemRefIds>");
    methodMap.put("createSif3AssessmentSubTestTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentSubTestTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentItemAssociationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentItemAssociationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId",
        "JAXBElement<ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId>");
    methodMap.put("createResourceUsageTypeResourceReportLineListResourceReportLineEndDate",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentActivityInfoTypeStudentActivityTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createLEAInfoTypeEducationAgencyTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createReportManifestTypeReportFormatList", "JAXBElement<ReportManifestType.ReportFormatList>");
    methodMap.put("createReportManifestTypeReceivingAuthority", "JAXBElement<ReportManifestType.ReceivingAuthority>");
    methodMap.put("createReportManifestTypeReportingPeriod", "JAXBElement<ReportManifestType.ReportingPeriod>");
    methodMap.put("createReportManifestTypeSIFExtendedQuery", "JAXBElement<SIFExtendedQueryDataModelType>");
    methodMap.put("createReportManifestTypeDescription", "JAXBElement<String>");
    methodMap.put("createReportManifestTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createReportManifestTypeSIFQueryGroup", "JAXBElement<ReportManifestType.SIFQueryGroup>");
    methodMap.put("createReportManifestTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createTermInfoTypeAttendanceTerm", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createTermInfoTypeTermSpan", "JAXBElement<String>");
    methodMap.put("createTermInfoTypeTrack", "JAXBElement<String>");
    methodMap.put("createTermInfoTypeMarkingTerm", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createTermInfoTypeTermCode", "JAXBElement<String>");
    methodMap.put("createTermInfoTypeDescription", "JAXBElement<String>");
    methodMap.put("createTermInfoTypeSchedulingTerm", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createTermInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createTermInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createTermInfoTypeRelativeDuration", "JAXBElement<BigDecimal>");
    methodMap.put("createAssessmentSubTestTypeScoreRangeMinimum", "JAXBElement<String>");
    methodMap.put("createAssessmentSubTestTypeScoreRangeMaximum", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolCourseInfoOverride",
        "JAXBElement<SectionInfoType.SchoolCourseInfoOverride>");
    methodMap.put("createSectionInfoTypeMediumOfInstruction", "JAXBElement<SectionInfoType.MediumOfInstruction>");
    methodMap.put("createSectionInfoTypeTermInfoRefId", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSectionInfoTypeLocationOfInstruction", "JAXBElement<SectionInfoType.LocationOfInstruction>");
    methodMap.put("createSectionInfoTypeSectionCode", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeDescription", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeLanguageOfInstruction", "JAXBElement<SectionInfoType.LanguageOfInstruction>");
    methodMap.put("createSectionInfoTypeCourseSectionCode", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSummerSchool", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeCountForAttendance", "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSectionInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createLearningStandardItemTypeRelatedLearningStandardItems",
        "JAXBElement<LearningStandardItemType.RelatedLearningStandardItems>");
    methodMap.put("createLearningStandardItemTypeStandardIdentifier",
        "JAXBElement<LearningStandardItemType.StandardIdentifier>");
    methodMap.put("createLearningStandardItemTypeStatementCodes",
        "JAXBElement<LearningStandardItemType.StatementCodes>");
    methodMap.put("createLearningStandardItemTypeACStrandSubjectArea", "JAXBElement<ACStrandSubjectAreaType>");
    methodMap.put("createLearningStandardItemTypeStandardSettingBody",
        "JAXBElement<LearningStandardItemType.StandardSettingBody>");
    methodMap.put("createLearningStandardItemTypeResources", "JAXBElement<LearningStandardItemType.Resources>");
    methodMap.put("createLearningStandardItemTypeLevel5", "JAXBElement<String>");
    methodMap.put("createLearningStandardItemTypeLevel4", "JAXBElement<String>");
    methodMap.put("createLearningStandardItemTypeStatements", "JAXBElement<LearningStandardItemType.Statements>");
    methodMap.put("createLearningStandardItemTypePredecessorItems",
        "JAXBElement<LearningStandardItemType.PredecessorItems>");
    methodMap.put("createLearningStandardItemTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createLearningStandardItemTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentRegistrationTypeTestingStatusesTestingStatusTestingStatusDescription",
        "JAXBElement<String>");
    methodMap.put("createTimeElementTypeSpanGapsSpanGapEndDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createTimeElementTypeSpanGapsSpanGapStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createLanguageListTypeLanguageOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createLanguageListTypeLanguageDialect", "JAXBElement<String>");
    methodMap.put("createLanguageListTypeLanguageLanguageType", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAdministrationTypeOrganizationsOrganizationSchoolInfoRefId",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAdministrationTypeOrganizationsOrganizationLEAInfoRefId", "JAXBElement<String>");
    methodMap.put("createTimeTableTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createTimeTableTypeSchoolName", "JAXBElement<String>");
    methodMap.put("createTimeTableTypeLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableTypeTimeTableCreationDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTimeTableTypeTeachingPeriodsPerDay", "JAXBElement<Long>");
    methodMap.put("createTimeTableTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createTimeTableTypeEndDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTimeTableTypeStartDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createTimeTableTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createTimeTableTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSchoolEnrollmentTypeCatchmentStatusOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createRoomInfoTypeStaffList", "JAXBElement<RoomInfoType.StaffList>");
    methodMap.put("createRoomInfoTypePhoneNumber", "JAXBElement<PhoneNumberType>");
    methodMap.put("createRoomInfoTypeCapacity", "JAXBElement<Long>");
    methodMap.put("createRoomInfoTypeHomeroomNumber", "JAXBElement<String>");
    methodMap.put("createRoomInfoTypeSize", "JAXBElement<BigDecimal>");
    methodMap.put("createRoomInfoTypeDescription", "JAXBElement<String>");
    methodMap.put("createRoomInfoTypeRoomType", "JAXBElement<String>");
    methodMap.put("createRoomInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createRoomInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createRoomInfoTypeBuilding", "JAXBElement<String>");
    methodMap.put("createSIFErrorDataModelTypeSIFExtendedDesc", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemTimeOnItem", "JAXBElement<javax.xml.datatype.Duration>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemTraitScores",
        "JAXBElement<Sif3StudentResponseSetType.Items.Item.TraitScores>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemAttemptStatus", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemItemScore", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemResponseLocation", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemComments",
        "JAXBElement<Sif3StudentResponseSetType.Items.Item.Comments>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemAssessmentRubricRefId", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemFeedbackItems",
        "JAXBElement<Sif3StudentResponseSetType.Items.Item.FeedbackItems>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemViewStatus", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemItemNumber", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemResponseCorrectness", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemNumberOfAttempts", "JAXBElement<Long>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemItemAids",
        "JAXBElement<Sif3StudentResponseSetType.Items.Item.ItemAids>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemItemScoreCode", "JAXBElement<String>");
    methodMap.put("createSif3StudentResponseSetTypeItemsItemItemName", "JAXBElement<String>");
    methodMap.put("createSchoolProgramsTypeSchoolProgramListProgramOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createSchoolProgramsTypeSchoolProgramListProgramCategory", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeContactsContactPhoneNumber", "JAXBElement<PhoneNumberType>");
    methodMap.put("createLearningResourceTypeContactsContactName", "JAXBElement<NameType>");
    methodMap.put("createLearningResourceTypeContactsContactEmail", "JAXBElement<EmailType>");
    methodMap.put("createLearningResourceTypeContactsContactAddress", "JAXBElement<AddressType>");
    methodMap.put("createStudentSDTNTypeStudentPersonalRefId", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeAreasOfInterestList", "JAXBElement<StudentSDTNType.AreasOfInterestList>");
    methodMap.put("createStudentSDTNTypeYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createStudentSDTNTypePrincipalInfo", "JAXBElement<PrincipalInfoType>");
    methodMap.put("createStudentSDTNTypeYoungCarersRole", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypePastoralCare", "JAXBElement<StudentSDTNType.PastoralCare>");
    methodMap.put("createStudentSDTNTypeReasonForLeaving", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeFurtherInformation", "JAXBElement<StudentSDTNType.FurtherInformation>");
    methodMap.put("createStudentSDTNTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeLiteracy", "JAXBElement<AUCodeSetsProgressLevelType>");
    methodMap.put("createStudentSDTNTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeAttendanceConcerns", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentSDTNTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSDTNTypeHealthNeeds", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypePreviousSchoolsList", "JAXBElement<StudentSDTNType.PreviousSchoolsList>");
    methodMap.put("createStudentSDTNTypeEnrollmentDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSDTNTypeCareerGuidanceFileHeld", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypeDepartureDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSDTNTypeAdjustedEducationProgram", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypeAddressList", "JAXBElement<AddressListType>");
    methodMap.put("createStudentSDTNTypeNumeracy", "JAXBElement<AUCodeSetsProgressLevelType>");
    methodMap.put("createStudentSDTNTypeAcceleratedProgram", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypeOtherLearningAreasList", "JAXBElement<StudentSDTNType.OtherLearningAreasList>");
    methodMap.put("createStudentSDTNTypeNegotiatedCurriculumPlan", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypeLatestStudentReportAvailable", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSDTNTypeOtherLearningSupport", "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypeSchoolCounsellorFileHeld", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSIFExtendedQueryDataModelTypeSIFWhere", "JAXBElement<SIFExtendedQueryDataModelType.SIFWhere>");
    methodMap.put("createSIFExtendedQueryDataModelTypeSIFOrderBy",
        "JAXBElement<SIFExtendedQueryDataModelType.SIFOrderBy>");
    methodMap.put("createSIFExtendedQueryDataModelTypeSIFDestinationProvider", "JAXBElement<String>");
    methodMap.put("createTimeElementTypeEndDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createTimeElementTypeSpanGaps", "JAXBElement<TimeElementType.SpanGaps>");
    methodMap.put("createTimeElementTypeStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentFormTypeFormAccommodations",
        "JAXBElement<Sif3AssessmentFormType.FormAccommodations>");
    methodMap.put("createSif3AssessmentFormTypeFormIdentifiers", "JAXBElement<Sif3AssessmentFormType.FormIdentifiers>");
    methodMap.put("createSif3AssessmentFormTypeFormVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentFormTypePeriod", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentFormTypeGradeLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentFormLanguages", "JAXBElement<LanguageListType>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentType", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentFormSubjects", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSif3AssessmentFormTypeLevel", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentSubTestRefIds",
        "JAXBElement<Sif3AssessmentFormType.AssessmentSubTestRefIds>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentSections",
        "JAXBElement<Sif3AssessmentFormType.AssessmentSections>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentAssetRefIds",
        "JAXBElement<Sif3AssessmentFormType.AssessmentAssetRefIds>");
    methodMap.put("createSif3AssessmentFormTypeAssessmentPlatforms",
        "JAXBElement<Sif3AssessmentFormType.AssessmentPlatforms>");
    methodMap.put("createSif3AssessmentFormTypeFormPublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentFormTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentFormTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAggregateStatisticFactTypeExcluded", "JAXBElement<String>");
    methodMap.put("createAggregateStatisticFactTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAggregateStatisticFactTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createCalendarDateCalendarDateTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes",
        "JAXBElement<LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes>");
    methodMap.put("createLearningStandardItemTypeStandardIdentifierYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createLearningStandardItemTypeStandardIdentifierIndicatorNumber", "JAXBElement<String>");
    methodMap.put("createLearningStandardItemTypeStandardIdentifierBenchmark", "JAXBElement<String>");
    methodMap.put("createAggregateCharacteristicInfoTypeElementName", "JAXBElement<String>");
    methodMap.put("createAggregateCharacteristicInfoTypeDescription", "JAXBElement<String>");
    methodMap.put("createAggregateCharacteristicInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAggregateCharacteristicInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSIFMetadataTypeLifeCycle", "JAXBElement<LifeCycleType>");
    methodMap.put("createSIFMetadataTypeEducationFilter", "JAXBElement<EducationFilterType>");
    methodMap.put("createSIFMetadataTypeTimeElements", "JAXBElement<SIFMetadataType.TimeElements>");
    methodMap.put("createStudentSchoolEnrollmentTypeEntryTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createPhoneNumberTypeListedStatus", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createPhoneNumberTypeExtension", "JAXBElement<String>");
    methodMap.put("createPersonPictureTypeOKToPublish", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createPersonPictureTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createPersonPictureTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAddressTypeStatisticalAreasStatisticalArea",
        "JAXBElement<AddressType.StatisticalAreas.StatisticalArea>");
    methodMap.put("createStudentScoreSetTypeScoresScoreNumberOfResponses", "JAXBElement<Long>");
    methodMap.put("createStudentScoreSetTypeScoresScoreDescription", "JAXBElement<String>");
    methodMap.put("createStudentScoreSetTypeScoresScoreDiagnosticStatement", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSectionTypeSectionItemsSectionItemItemSequence", "JAXBElement<String>");
    methodMap.put("createLifeCycleTypeCreated", "JAXBElement<LifeCycleType.Created>");
    methodMap.put("createLifeCycleTypeTimeElements", "JAXBElement<LifeCycleType.TimeElements>");
    methodMap.put("createLifeCycleTypeModificationHistory", "JAXBElement<LifeCycleType.ModificationHistory>");
    methodMap.put("createLearningResourceTypeComponentsComponentStrategies",
        "JAXBElement<LearningResourceType.Components.Component.Strategies>");
    methodMap.put("createLearningResourceTypeComponentsComponentAssociatedObjects",
        "JAXBElement<LearningResourceType.Components.Component.AssociatedObjects>");
    methodMap.put("createLearningResourceTypeComponentsComponentDescription", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeEvaluationsEvaluationName", "JAXBElement<NameType>");
    methodMap.put("createLearningResourceTypeEvaluationsEvaluationDescription", "JAXBElement<String>");
    methodMap.put("createLearningResourceTypeEvaluationsEvaluationDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDescription",
        "JAXBElement<String>");
    methodMap.put("createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDelimiter",
        "JAXBElement<String>");
    methodMap.put("createSIFHeaderDataModelTypeSIFSecurity", "JAXBElement<SIFHeaderDataModelType.SIFSecurity>");
    methodMap.put("createSIFHeaderDataModelTypeSIFContexts", "JAXBElement<SIFContextsType>");
    methodMap.put("createSIFHeaderDataModelTypeSIFDestinationId", "JAXBElement<String>");
    methodMap.put("createStudentContactPersonalTypeNonSchoolEducation", "JAXBElement<String>");
    methodMap.put("createStudentContactPersonalTypeLocalId", "JAXBElement<String>");
    methodMap.put("createStudentContactPersonalTypeOtherIdList", "JAXBElement<StudentContactPersonalType.OtherIdList>");
    methodMap.put("createStudentContactPersonalTypeEmploymentType", "JAXBElement<String>");
    methodMap.put("createStudentContactPersonalTypeSchoolEducationalLevel", "JAXBElement<String>");
    methodMap.put("createStudentContactPersonalTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentContactPersonalTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentItemTypeResponseChoicesChoiceCreditValue", "JAXBElement<Float>");
    methodMap.put("createAssessmentItemTypeResponseChoicesChoiceChoiceLabel", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeDayId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeLocation", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeActivityType", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypePeriodId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeCellType", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeAddressList", "JAXBElement<AddressListType>");
    methodMap.put("createScheduledActivityTypeTimeTableCellRefId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeTimeTableRefId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeTeacherList", "JAXBElement<ScheduledActivityType.TeacherList>");
    methodMap.put("createScheduledActivityTypeActivityComment", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeTeachingGroupList",
        "JAXBElement<ScheduledActivityType.TeachingGroupList>");
    methodMap.put("createScheduledActivityTypeRoomList", "JAXBElement<ScheduledActivityType.RoomList>");
    methodMap.put("createScheduledActivityTypeTimeTableSubjectRefId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeActivityName", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeStudentList", "JAXBElement<ScheduledActivityType.StudentList>");
    methodMap.put("createScheduledActivityTypeOverride", "JAXBElement<ScheduledActivityType.Override>");
    methodMap.put("createScheduledActivityTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createScheduledActivityTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createScheduledActivityTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackSource",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackDescription",
        "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAdministrationTypeAdministrationAssessments",
        "JAXBElement<Sif3AssessmentAdministrationType.AdministrationAssessments>");
    methodMap.put("createSif3AssessmentAdministrationTypeAdministrationCode", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAdministrationTypeFinishDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentAdministrationTypeStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentAdministrationTypeAdministrationName", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentAdministrationTypeOrganizations",
        "JAXBElement<Sif3AssessmentAdministrationType.Organizations>");
    methodMap.put("createSif3AssessmentAdministrationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentAdministrationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createDemographicsTypeReligionOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createStudentParticipationTypeProgramFundingSourcesProgramFundingSourceOtherCodeList",
        "JAXBElement<OtherCodeListType>");
    methodMap.put("createSystemRoleTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSystemRoleTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put(
        "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSubjectLocalId",
        "JAXBElement<String>");
    methodMap.put(
        "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentCourseLocalId",
        "JAXBElement<String>");
    methodMap
        .put(
            "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTimeTableSubjectRefId",
            "JAXBElement<String>");
    methodMap
        .put(
            "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolCourseInfoRefId",
            "JAXBElement<String>");
    methodMap
        .put(
            "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTeachingGroupRefId",
            "JAXBElement<String>");
    methodMap.put(
        "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolYear",
        "JAXBElement<XMLGregorianCalendar>");
    methodMap.put(
        "createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentShortName",
        "JAXBElement<String>");
    methodMap.put("createSectionInfoTypeLocationOfInstructionOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createSif3StudentResponseSetTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3StudentResponseSetTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentRegistrationTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentRegistrationTypeLEAInfoRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentRegistrationTypeStudentYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createAssessmentRegistrationTypeStudentSpecialConditions",
        "JAXBElement<AssessmentRegistrationType.StudentSpecialConditions>");
    methodMap.put("createAssessmentRegistrationTypeStaffPersonalRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentRegistrationTypeAssessmentStudentSnapshot",
        "JAXBElement<AssessmentRegistrationType.AssessmentStudentSnapshot>");
    methodMap.put("createAssessmentRegistrationTypeAssessmentYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createAssessmentRegistrationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentRegistrationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createRelationshipTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber",
        "JAXBElement<Long>");
    methodMap.put("createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId",
        "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription",
        "JAXBElement<SubjectAreaType>");
    methodMap.put("createSectionInfoTypeMediumOfInstructionOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createReportManifestTypeReportingPeriodEndSubmitDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createReportManifestTypeReportingPeriodEndReportDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createReportManifestTypeReportingPeriodDueDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createReportManifestTypeReportingPeriodBeginSubmitDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createReportManifestTypeReportingPeriodBeginReportDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentSchoolName", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentHomeroom",
        "JAXBElement<StudentSnapshotType.HomeEnrollment.Homeroom>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentYearLevel", "JAXBElement<YearLevelType>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentLocalId", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentHomeroomNumber", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentStudentSchoolEnrollmentRefId", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeHomeEnrollmentSchoolNo", "JAXBElement<String>");
    methodMap.put("createActivityTypeTechnicalRequirementsTechnicalRequirement", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreTableIdentifiers",
        "JAXBElement<Sif3AssessmentScoreTableType.ScoreTableIdentifiers>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreTablePublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreTableVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentScoreTableTypeScoreValues",
        "JAXBElement<Sif3AssessmentScoreTableType.ScoreValues>");
    methodMap.put("createSif3AssessmentScoreTableTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentScoreTableTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSnapshotTypeOnTimeGraduationYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSnapshotTypeStateProvinceId", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeStudentSnapshotRefId", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeBirthDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSnapshotTypeSex", "JAXBElement<String>");
    methodMap.put("createStudentSnapshotTypeAge", "JAXBElement<Long>");
    methodMap.put("createStudentSnapshotTypeStudentSubjectChoiceList",
        "JAXBElement<StudentSnapshotType.StudentSubjectChoiceList>");
    methodMap.put("createStudentSnapshotTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentSnapshotTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSnapshotTypeProjectedGraduationYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createActivityTypeSoftwareRequirementListSoftwareRequirementOS", "JAXBElement<String>");
    methodMap.put("createActivityTypeSoftwareRequirementListSoftwareRequirementVersion", "JAXBElement<String>");
    methodMap.put("createActivityTypeSoftwareRequirementListSoftwareRequirementVendor", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeDistrictCourseCode", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeCourseCredits", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeCourseContent", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeSubjectAreaList", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSchoolCourseInfoTypeTermInfoRefId", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSchoolCourseInfoTypeCoreAcademicCourse", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSchoolCourseInfoTypeDescription", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeGraduationRequirement", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSchoolCourseInfoTypeStateCourseCode", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeDepartment", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeInstructionalLevel", "JAXBElement<String>");
    methodMap.put("createSchoolCourseInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSchoolCourseInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentFormTypeAssessmentSubTestRefIds",
        "JAXBElement<AssessmentFormType.AssessmentSubTestRefIds>");
    methodMap.put("createAssessmentFormTypeLevel", "JAXBElement<String>");
    methodMap.put("createAssessmentFormTypePeriod", "JAXBElement<String>");
    methodMap.put("createAssessmentFormTypeFormNumbers", "JAXBElement<AssessmentFormType.FormNumbers>");
    methodMap.put("createAssessmentFormTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentFormTypeAssessmentType", "JAXBElement<String>");
    methodMap.put("createAssessmentFormTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentFormTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSIFReportObjectTypeReportInfoDescription", "JAXBElement<String>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfo",
        "JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo>");
    methodMap.put("createStudentPersonalTypeAlertMessages", "JAXBElement<StudentPersonalType.AlertMessages>");
    methodMap.put("createStudentPersonalTypeOnTimeGraduationYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentPersonalTypeDisability", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeStateProvinceId", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeYoungCarersRole", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeOtherIdList", "JAXBElement<StudentPersonalType.OtherIdList>");
    methodMap.put("createStudentPersonalTypePrePrimaryEducation", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeEconomicDisadvantage", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeMedicalAlertMessages",
        "JAXBElement<StudentPersonalType.MedicalAlertMessages>");
    methodMap.put("createStudentPersonalTypeESL", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeAcceptableUsePolicy", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeProjectedGraduationYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentPersonalTypeGraduationDate", "JAXBElement<String>");
    methodMap.put("createStudentPersonalTypeFirstAUSchoolEnrollment", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentPersonalTypeElectronicIdList", "JAXBElement<ElectronicIdListType>");
    methodMap.put("createStudentPersonalTypeIntegrationAide", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeMostRecent", "JAXBElement<StudentPersonalType.MostRecent>");
    methodMap.put("createStudentPersonalTypeGiftedTalented", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentPersonalTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentPersonalTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentSessionTypeScheduledStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentSessionTypeStaffPersonalRefIds",
        "JAXBElement<Sif3AssessmentSessionType.StaffPersonalRefIds>");
    methodMap.put("createSif3AssessmentSessionTypeScheduledEndDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentSessionTypeActualEndDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentSessionTypeActualStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentSessionTypeAssessmentAdministrationRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSessionTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSessionTypeLEAInfoRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSessionTypeAssessmentFormRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSessionTypeUnusualEvents",
        "JAXBElement<Sif3AssessmentSessionType.UnusualEvents>");
    methodMap.put("createSif3AssessmentSessionTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentSessionTypeAddress", "JAXBElement<AddressType>");
    methodMap.put("createSif3AssessmentSessionTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createPrincipalInfoTypeContactTitle", "JAXBElement<String>");
    methodMap.put("createPrincipalInfoTypePhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createPrincipalInfoTypeEmailList", "JAXBElement<EmailListType>");
    methodMap.put("createStudentScoreSetTypeAssessmentRegistrationRefId", "JAXBElement<String>");
    methodMap.put("createStudentScoreSetTypeFinishDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createStudentScoreSetTypeStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createStudentScoreSetTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentScoreSetTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentSubTestTypeScoreReportingMinimum", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSubTestTypeScoreReportingScoreTableRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentSubTestTypeScoreReportingMaximum", "JAXBElement<String>");
    methodMap.put("createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId", "JAXBElement<String>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfoContactInfo", "JAXBElement<ContactInfoType>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfoPhoneNumber", "JAXBElement<PhoneNumberType>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId",
        "JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterDepartment", "JAXBElement<String>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterNotes", "JAXBElement<String>");
    methodMap.put("createSIFReportObjectTypeReportInfoReportSubmitterInfoAddress", "JAXBElement<AddressType>");
    methodMap.put("createStudentDailyAttendanceTypeTimeIn", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentDailyAttendanceTypeTimeOut", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentDailyAttendanceTypeAbsenceValue", "JAXBElement<BigDecimal>");
    methodMap.put("createStudentDailyAttendanceTypeDayValue", "JAXBElement<AUCodeSetsDayValueCodeType>");
    methodMap.put("createStudentDailyAttendanceTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentDailyAttendanceTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentDailyAttendanceTypeAttendanceNote", "JAXBElement<String>");
    methodMap.put("createLearningStandardDocumentTypeEndOfLifeDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningStandardDocumentTypeLocalArchiveDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningStandardDocumentTypeAuthors", "JAXBElement<LearningStandardDocumentType.Authors>");
    methodMap.put("createLearningStandardDocumentTypeDocumentDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningStandardDocumentTypeDescription", "JAXBElement<String>");
    methodMap.put("createLearningStandardDocumentTypeLocalAdoptionDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningStandardDocumentTypeRichDescription", "JAXBElement<AbstractContentElementType>");
    methodMap.put("createLearningStandardDocumentTypeCopyright", "JAXBElement<LearningStandardDocumentType.Copyright>");
    methodMap.put("createLearningStandardDocumentTypeRelatedLearningStandards",
        "JAXBElement<LearningStandardDocumentType.RelatedLearningStandards>");
    methodMap.put("createLearningStandardDocumentTypeRepositoryDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createLearningStandardDocumentTypeOrganizationContactPoint", "JAXBElement<String>");
    methodMap.put("createLearningStandardDocumentTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createLearningStandardDocumentTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createLearningStandardDocumentTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudentStudentLocalId",
        "JAXBElement<String>");
    methodMap.put("createLocationTypeLocationRefId", "JAXBElement<LocationType.LocationRefId>");
    methodMap.put("createLocationTypeLocationName", "JAXBElement<String>");
    methodMap.put("createLearningStandardDocumentTypeCopyrightHolder", "JAXBElement<String>");
    methodMap.put("createLearningStandardDocumentTypeCopyrightDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStaffAssignmentTypeStaffSubjectListStaffSubjectSubjectLocalId", "JAXBElement<String>");
    methodMap.put("createStaffAssignmentTypeStaffSubjectListStaffSubjectTimeTableSubjectRefId", "JAXBElement<String>");
    methodMap.put("createStudentPeriodAttendanceTypeTimeIn", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentPeriodAttendanceTypeSessionInfoRefId", "JAXBElement<String>");
    methodMap.put("createStudentPeriodAttendanceTypeTimeOut", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentPeriodAttendanceTypeTimetablePeriod", "JAXBElement<String>");
    methodMap.put("createStudentPeriodAttendanceTypeAuditInfo", "JAXBElement<StudentPeriodAttendanceType.AuditInfo>");
    methodMap.put("createStudentPeriodAttendanceTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentPeriodAttendanceTypeAttendanceComment", "JAXBElement<String>");
    methodMap.put("createStudentPeriodAttendanceTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentPeriodAttendanceTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolInfoRefId",
        "JAXBElement<String>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent",
        "JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolLocalId",
        "JAXBElement<String>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff",
        "JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList",
        "JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolStateProvinceId",
        "JAXBElement<String>");
    methodMap.put("createStudentParticipationTypeProgramAvailabilityOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createCalendarDateTeacherAttendance", "JAXBElement<CalendarDate.TeacherAttendance>");
    methodMap.put("createCalendarDateStudentAttendance", "JAXBElement<CalendarDate.StudentAttendance>");
    methodMap.put("createCalendarDateAdministratorAttendance", "JAXBElement<CalendarDate.AdministratorAttendance>");
    methodMap.put("createCalendarDateCalendarDateNumber", "JAXBElement<Long>");
    methodMap.put("createCalendarDateCalendarDateRefId", "JAXBElement<String>");
    methodMap.put("createCalendarDateSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createCalendarDateSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentActivityParticipationTypeRole", "JAXBElement<String>");
    methodMap.put("createStudentActivityParticipationTypeRecognitionList",
        "JAXBElement<StudentActivityParticipationType.RecognitionList>");
    methodMap.put("createStudentActivityParticipationTypeParticipationComment", "JAXBElement<String>");
    methodMap.put("createStudentActivityParticipationTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentActivityParticipationTypeEndDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentActivityParticipationTypeStartDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentActivityParticipationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentActivityParticipationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores",
        "JAXBElement<AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores>");
    methodMap.put("createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName",
        "JAXBElement<String>");
    methodMap.put("createStudentSDTNTypePastoralCareIndividualBehaviourPlan",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap
        .put("createStudentSDTNTypePastoralCareDisciplinaryAbsences", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createAssessmentItemTypeLearningStandardItems",
        "JAXBElement<AssessmentItemType.LearningStandardItems>");
    methodMap.put("createAssessmentItemTypeItemScoreMinimum", "JAXBElement<String>");
    methodMap.put("createAssessmentItemTypePerformanceLevels", "JAXBElement<AssessmentItemType.PerformanceLevels>");
    methodMap.put("createAssessmentItemTypeItemScoreMaximum", "JAXBElement<String>");
    methodMap.put("createAssessmentItemTypeStem", "JAXBElement<AbstractContentElementType>");
    methodMap.put("createAssessmentItemTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentItemTypeResponseChoices", "JAXBElement<AssessmentItemType.ResponseChoices>");
    methodMap.put("createAssessmentItemTypeStimulus", "JAXBElement<AbstractContentElementType>");
    methodMap.put("createAssessmentItemTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentItemTypeItemName", "JAXBElement<String>");
    methodMap.put("createSchoolContactListTypeSchoolContactPublishInDirectory",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList",
        "JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList>");
    methodMap.put("createSubjectAreaTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createEducationFilterTypeLearningStandardItems",
        "JAXBElement<EducationFilterType.LearningStandardItems>");
    methodMap.put("createSif3AssessmentRubricTypeScores", "JAXBElement<Sif3AssessmentRubricType.Scores>");
    methodMap.put("createSif3AssessmentRubricTypeScoringGuideReference", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRubricTypeRubricVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentRubricTypeRubricPublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentRubricTypeRubricIdentifiers",
        "JAXBElement<Sif3AssessmentRubricType.RubricIdentifiers>");
    methodMap.put("createSif3AssessmentRubricTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentRubricTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentSchoolEnrollmentTypeExitStatusOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaffStaffLocalId",
        "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetStreetType", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetStreetSuffix", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetApartmentNumber", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetStreetNumber", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetComplex", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetStreetPrefix", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetLine3", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetLine2", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetApartmentNumberSuffix", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetApartmentType", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetStreetName", "JAXBElement<String>");
    methodMap.put("createAddressTypeStreetApartmentNumberPrefix", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeTeacherListTeacherCoverSupervision", "JAXBElement<String>");
    methodMap.put("createScheduledActivityTypeTeacherListTeacherCoverStartTime", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createScheduledActivityTypeTeacherListTeacherCoverWeighting", "JAXBElement<BigDecimal>");
    methodMap.put("createScheduledActivityTypeTeacherListTeacherCoverFinishTime", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createScheduledActivityTypeTeacherListTeacherCoverCredit", "JAXBElement<String>");
    methodMap.put("createContactInfoTypeRole", "JAXBElement<String>");
    methodMap.put("createContactInfoTypePhoneNumberList", "JAXBElement<PhoneNumberListType>");
    methodMap.put("createContactInfoTypePositionTitle", "JAXBElement<String>");
    methodMap.put("createContactInfoTypeEmailList", "JAXBElement<EmailListType>");
    methodMap.put("createContactInfoTypeAddress", "JAXBElement<AddressType>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentItemPlatforms",
        "JAXBElement<Sif3AssessmentItemType.AssessmentItemPlatforms>");
    methodMap.put("createSif3AssessmentItemTypeLearningStandardItems",
        "JAXBElement<Sif3AssessmentItemType.LearningStandardItems>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentItemBanks",
        "JAXBElement<Sif3AssessmentItemType.AssessmentItemBanks>");
    methodMap.put("createSif3AssessmentItemTypeItemScoreMaximum", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeItemRubricIds", "JAXBElement<Sif3AssessmentItemType.ItemRubricIds>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentLanguages", "JAXBElement<LanguageListType>");
    methodMap.put("createSif3AssessmentItemTypeStem", "JAXBElement<AbstractContentElementType>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentGradeLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentSubjects", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSif3AssessmentItemTypeItemScoreMinimum", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentIdentifiers",
        "JAXBElement<Sif3AssessmentItemType.AssessmentIdentifiers>");
    methodMap.put("createSif3AssessmentItemTypeItemFeedbackCorrect", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeItemFeedbackIncorrect", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeAssessmentItemAssetRefIds",
        "JAXBElement<Sif3AssessmentItemType.AssessmentItemAssetRefIds>");
    methodMap.put("createSif3AssessmentItemTypeItemFeedbackHint", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeItemPublishDate", "JAXBElement<java.util.Calendar>");
    methodMap.put("createSif3AssessmentItemTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentItemTypeResponseChoices", "JAXBElement<Sif3AssessmentItemType.ResponseChoices>");
    methodMap.put("createSif3AssessmentItemTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentItemTypeItemVersion", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentItemTypeItemName", "JAXBElement<String>");
    methodMap.put("createBaseNameTypePreferredFamilyNameFirst", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createBaseNameTypePreferredFamilyName", "JAXBElement<String>");
    methodMap.put("createBaseNameTypeFamilyName", "JAXBElement<String>");
    methodMap.put("createBaseNameTypeTitle", "JAXBElement<String>");
    methodMap.put("createBaseNameTypePreferredGivenName", "JAXBElement<String>");
    methodMap.put("createBaseNameTypeFamilyNameFirst", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createBaseNameTypeMiddleName", "JAXBElement<String>");
    methodMap.put("createBaseNameTypeFullName", "JAXBElement<String>");
    methodMap.put("createBaseNameTypeSuffix", "JAXBElement<String>");
    methodMap.put("createBaseNameTypeGivenName", "JAXBElement<String>");
    methodMap.put("createStudentSectionEnrollmentTypeEntryDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSectionEnrollmentTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSectionEnrollmentTypeExitDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStudentSectionEnrollmentTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentSectionEnrollmentTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createDemographicsTypeDwellingArrangementOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createSessionInfoTypeStartTime", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSessionInfoTypeRollMarked", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createSessionInfoTypeRoomNumber", "JAXBElement<String>");
    methodMap.put("createSessionInfoTypeSchoolLocalId", "JAXBElement<String>");
    methodMap.put("createSessionInfoTypeFinishTime", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSessionInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSessionInfoTypeStaffPersonalLocalId", "JAXBElement<String>");
    methodMap.put("createSessionInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap
        .put("createStudentSDTNTypeAreasOfInterestListActivityInfoStudentActivityInfoRefId", "JAXBElement<String>");
    methodMap.put("createSchoolProgramsTypeSchoolProgramList", "JAXBElement<SchoolProgramsType.SchoolProgramList>");
    methodMap.put("createSchoolProgramsTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createSchoolProgramsTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSchoolProgramsTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores",
        "JAXBElement<AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores>");
    methodMap.put("createStaffAssignmentTypeStaffActivity", "JAXBElement<StaffAssignmentType.StaffActivity>");
    methodMap.put("createStaffAssignmentTypeSchoolYear", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStaffAssignmentTypeJobStartDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStaffAssignmentTypeDescription", "JAXBElement<String>");
    methodMap.put("createStaffAssignmentTypeJobEndDate", "JAXBElement<XMLGregorianCalendar>");
    methodMap.put("createStaffAssignmentTypeCasualReliefTeacher", "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStaffAssignmentTypeHouse", "JAXBElement<String>");
    methodMap.put("createStaffAssignmentTypeJobFTE", "JAXBElement<BigDecimal>");
    methodMap.put("createStaffAssignmentTypeHomegroup", "JAXBElement<String>");
    methodMap.put("createStaffAssignmentTypeJobFunction", "JAXBElement<String>");
    methodMap.put("createStaffAssignmentTypeStaffSubjectList", "JAXBElement<StaffAssignmentType.StaffSubjectList>");
    methodMap.put("createStaffAssignmentTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStaffAssignmentTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStaffAssignmentTypeYearLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createActivityTypeEvaluationDescription", "JAXBElement<String>");
    methodMap.put("createSIFReportObjectTypeReportInfo", "JAXBElement<SIFReportObjectType.ReportInfo>");
    methodMap.put("createSIFReportObjectTypeSIFExtendedQueryResults",
        "JAXBElement<SIFExtendedQueryResultsDataModelType>");
    methodMap.put("createSIFReportObjectTypeReportData", "JAXBElement<ReportDataObjectType>");
    methodMap.put("createSIFReportObjectTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSIFReportObjectTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createSif3AssessmentTypeAssessmentSubjects", "JAXBElement<SubjectAreaListType>");
    methodMap.put("createSif3AssessmentTypeAssessmentProvider", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentTypeAssessmentIdentifiers",
        "JAXBElement<Sif3AssessmentType.AssessmentIdentifiers>");
    methodMap.put("createSif3AssessmentTypeAssessmentItemBanks", "JAXBElement<Sif3AssessmentType.AssessmentItemBanks>");
    methodMap.put("createSif3AssessmentTypeAssessmentPackageRefId", "JAXBElement<String>");
    methodMap.put("createSif3AssessmentTypeLearningStandardItemRefIds",
        "JAXBElement<Sif3AssessmentType.LearningStandardItemRefIds>");
    methodMap.put("createSif3AssessmentTypeAssessmentLanguages", "JAXBElement<LanguageListType>");
    methodMap.put("createSif3AssessmentTypeAssessmentDescriptors",
        "JAXBElement<Sif3AssessmentType.AssessmentDescriptors>");
    methodMap.put("createSif3AssessmentTypeAssessmentGradeLevels", "JAXBElement<YearLevelsType>");
    methodMap.put("createSif3AssessmentTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createSif3AssessmentTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createLifeCycleTypeModificationHistoryModifiedDescription", "JAXBElement<String>");
    methodMap.put("createStaffAssignmentTypeStaffActivityOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createAssessmentAdministrationTypeSchoolInfoRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentAdministrationTypeLEAInfoRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentAdministrationTypeSpecialConditions",
        "JAXBElement<AssessmentAdministrationType.SpecialConditions>");
    methodMap.put("createAssessmentAdministrationTypeStaffPersonalRefId", "JAXBElement<String>");
    methodMap.put("createAssessmentAdministrationTypeFinishDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createAssessmentAdministrationTypeStartDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createAssessmentAdministrationTypeAdministrationName", "JAXBElement<String>");
    methodMap.put("createAssessmentAdministrationTypeDueDateTime", "JAXBElement<java.util.Calendar>");
    methodMap.put("createAssessmentAdministrationTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createAssessmentAdministrationTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createAssessmentAdministrationTypeAddress", "JAXBElement<AddressType>");
    methodMap.put("createSectionInfoTypeLanguageOfInstructionOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createStudentAttendanceSummaryTypeDaysTardy", "JAXBElement<BigDecimal>");
    methodMap.put("createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId", "JAXBElement<String>");
    methodMap.put("createStudentAttendanceSummaryTypeStartDay", "JAXBElement<Long>");
    methodMap.put("createStudentAttendanceSummaryTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStudentAttendanceSummaryTypeFTE", "JAXBElement<BigDecimal>");
    methodMap.put("createStudentAttendanceSummaryTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentAttendanceSummaryTypeEndDay", "JAXBElement<Long>");
    methodMap.put("createProgramStatusTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createStaffPersonalTypeEmploymentStatus", "JAXBElement<AUCodeSetsStaffStatusType>");
    methodMap.put("createStaffPersonalTypeStateProvinceId", "JAXBElement<String>");
    methodMap.put("createStaffPersonalTypeOtherIdList", "JAXBElement<StaffPersonalType.OtherIdList>");
    methodMap.put("createStaffPersonalTypeTitle", "JAXBElement<String>");
    methodMap.put("createStaffPersonalTypeElectronicIdList", "JAXBElement<ElectronicIdListType>");
    methodMap.put("createStaffPersonalTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createStaffPersonalTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsHasCustody",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsFeesBilling",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsReceivesAssessmentReport",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsEmergencyContact",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsPickupRights",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsAttendanceContact",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsAccessToRecords",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsFamilyMail",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsInterventionOrder",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsParentLegalGuardian",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsDisciplinaryContact",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentContactRelationshipTypeContactFlagsLivesWith",
        "JAXBElement<AUCodeSetsYesOrNoCategoryType>");
    methodMap.put("createStudentSchoolEnrollmentTypeExitTypeOtherCodeList", "JAXBElement<OtherCodeListType>");
    methodMap.put("createReportAuthorityInfoTypeContactInfo", "JAXBElement<ContactInfoType>");
    methodMap.put("createReportAuthorityInfoTypePhoneNumber", "JAXBElement<PhoneNumberType>");
    methodMap.put("createReportAuthorityInfoTypeAuthorityDepartment", "JAXBElement<String>");
    methodMap.put("createReportAuthorityInfoTypeSIFMetadata", "JAXBElement<SIFMetadataType>");
    methodMap.put("createReportAuthorityInfoTypeSIFExtendedElements", "JAXBElement<SIFExtendedElementsType>");
    methodMap.put("createReportAuthorityInfoTypeAddress", "JAXBElement<AddressType>");
    methodMap.put("createLifeCycleTypeCreatedCreators", "JAXBElement<LifeCycleType.Created.Creators>");
    return methodMap;
  }

}
