package sif3.hits.domain.converter.factory;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import sif.dd.au30.model.*;

public interface IObjectFactory {

  /**
   * Create an instance of {@link SIFQueryDataModelType }
   * 
   */
  SIFQueryDataModelType createSIFQueryDataModelType();

  /**
   * Create an instance of {@link SIFQueryDataModelType.SIFConditionGroup }
   * 
   */
  SIFQueryDataModelType.SIFConditionGroup createSIFQueryDataModelTypeSIFConditionGroup();

  /**
   * Create an instance of
   * {@link SIFQueryDataModelType.SIFConditionGroup.SIFConditions }
   * 
   */
  SIFQueryDataModelType.SIFConditionGroup.SIFConditions createSIFQueryDataModelTypeSIFConditionGroupSIFConditions();

  /**
   * Create an instance of {@link SIFHeaderDataModelType }
   * 
   */
  SIFHeaderDataModelType createSIFHeaderDataModelType();

  /**
   * Create an instance of {@link SIFHeaderDataModelType.SIFSecurity }
   * 
   */
  SIFHeaderDataModelType.SIFSecurity createSIFHeaderDataModelTypeSIFSecurity();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType }
   * 
   */
  SIFExtendedQueryResultsDataModelType createSIFExtendedQueryResultsDataModelType();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType.SIFRows }
   * 
   */
  SIFExtendedQueryResultsDataModelType.SIFRows createSIFExtendedQueryResultsDataModelTypeSIFRows();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryResultsDataModelType.SIFColumnHeaders }
   * 
   */
  SIFExtendedQueryResultsDataModelType.SIFColumnHeaders createSIFExtendedQueryResultsDataModelTypeSIFColumnHeaders();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType }
   * 
   */
  SIFExtendedQueryDataModelType createSIFExtendedQueryDataModelType();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFOrderBy }
   * 
   */
  SIFExtendedQueryDataModelType.SIFOrderBy createSIFExtendedQueryDataModelTypeSIFOrderBy();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFWhere }
   * 
   */
  SIFExtendedQueryDataModelType.SIFWhere createSIFExtendedQueryDataModelTypeSIFWhere();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup }
   * 
   */
  SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroup();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions
   * }
   * 
   */
  SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroupSIFConditions();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition
   * }
   * 
   */
  SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom }
   * 
   */
  SIFExtendedQueryDataModelType.SIFFrom createSIFExtendedQueryDataModelTypeSIFFrom();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin
   * }
   * 
   */
  SIFExtendedQueryDataModelType.SIFFrom.SIFJoin createSIFExtendedQueryDataModelTypeSIFFromSIFJoin();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn }
   * 
   */
  SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn createSIFExtendedQueryDataModelTypeSIFFromSIFJoinSIFJoinOn();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFSelect }
   * 
   */
  SIFExtendedQueryDataModelType.SIFSelect createSIFExtendedQueryDataModelTypeSIFSelect();

  /**
   * Create an instance of {@link AbstractContentPackageType }
   * 
   */
  AbstractContentPackageType createAbstractContentPackageType();

  /**
   * Create an instance of {@link AbstractContentElementType }
   * 
   */
  AbstractContentElementType createAbstractContentElementType();

  /**
   * Create an instance of {@link IdentityType }
   * 
   */
  IdentityType createIdentityType();

  /**
   * Create an instance of {@link IdentityType.PasswordList }
   * 
   */
  IdentityType.PasswordList createIdentityTypePasswordList();

  /**
   * Create an instance of {@link IdentityType.IdentityAssertions }
   * 
   */
  IdentityType.IdentityAssertions createIdentityTypeIdentityAssertions();

  /**
   * Create an instance of {@link LocationType }
   * 
   */
  LocationType createLocationType();

  /**
   * Create an instance of {@link LEAInfoType }
   * 
   */
  LEAInfoType createLEAInfoType();

  /**
   * Create an instance of {@link LEAInfoType.LEAContactList }
   * 
   */
  LEAInfoType.LEAContactList createLEAInfoTypeLEAContactList();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType }
   * 
   */
  Sif3AssessmentSectionType createSif3AssessmentSectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionItems }
   * 
   */
  Sif3AssessmentSectionType.SectionItems createSif3AssessmentSectionTypeSectionItems();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionIdentifiers }
   * 
   */
  Sif3AssessmentSectionType.SectionIdentifiers createSif3AssessmentSectionTypeSectionIdentifiers();

  /**
   * Create an instance of {@link SIFExtendedElementsType }
   * 
   */
  SIFExtendedElementsType createSIFExtendedElementsType();

  /**
   * Create an instance of {@link StaffPersonalType }
   * 
   */
  StaffPersonalType createStaffPersonalType();

  /**
   * Create an instance of {@link StaffPersonalType.MostRecent }
   * 
   */
  StaffPersonalType.MostRecent createStaffPersonalTypeMostRecent();

  /**
   * Create an instance of {@link StaffPersonalType.OtherIdList }
   * 
   */
  StaffPersonalType.OtherIdList createStaffPersonalTypeOtherIdList();

  /**
   * Create an instance of {@link EquipmentInfoType }
   * 
   */
  EquipmentInfoType createEquipmentInfoType();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType }
   * 
   */
  Sif3AssessmentSessionType createSif3AssessmentSessionType();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType.UnusualEvents }
   * 
   */
  Sif3AssessmentSessionType.UnusualEvents createSif3AssessmentSessionTypeUnusualEvents();

  /**
   * Create an instance of {@link AssessmentAdministrationType }
   * 
   */
  AssessmentAdministrationType createAssessmentAdministrationType();

  /**
   * Create an instance of {@link AssessmentAdministrationType.SpecialConditions
   * }
   * 
   */
  AssessmentAdministrationType.SpecialConditions createAssessmentAdministrationTypeSpecialConditions();

  /**
   * Create an instance of {@link CalendarDate }
   * 
   */
  CalendarDate createCalendarDate();

  /**
   * Create an instance of {@link RoomInfoType }
   * 
   */
  RoomInfoType createRoomInfoType();

  /**
   * Create an instance of {@link StudentActivityParticipationType }
   * 
   */
  StudentActivityParticipationType createStudentActivityParticipationType();

  /**
   * Create an instance of {@link StudentPersonalType }
   * 
   */
  StudentPersonalType createStudentPersonalType();

  /**
   * Create an instance of {@link StudentPersonalType.OtherIdList }
   * 
   */
  StudentPersonalType.OtherIdList createStudentPersonalTypeOtherIdList();

  /**
   * Create an instance of {@link StudentPersonalType.MedicalAlertMessages }
   * 
   */
  StudentPersonalType.MedicalAlertMessages createStudentPersonalTypeMedicalAlertMessages();

  /**
   * Create an instance of {@link StudentPersonalType.AlertMessages }
   * 
   */
  StudentPersonalType.AlertMessages createStudentPersonalTypeAlertMessages();

  /**
   * Create an instance of {@link StudentActivityInfoType }
   * 
   */
  StudentActivityInfoType createStudentActivityInfoType();

  /**
   * Create an instance of {@link StudentContactPersonalType }
   * 
   */
  StudentContactPersonalType createStudentContactPersonalType();

  /**
   * Create an instance of {@link StudentContactPersonalType.OtherIdList }
   * 
   */
  StudentContactPersonalType.OtherIdList createStudentContactPersonalTypeOtherIdList();

  /**
   * Create an instance of {@link InvoiceType }
   * 
   */
  InvoiceType createInvoiceType();

  /**
   * Create an instance of {@link InvoiceType.PurchasingItems }
   * 
   */
  InvoiceType.PurchasingItems createInvoiceTypePurchasingItems();

  /**
   * Create an instance of {@link PaymentReceiptType }
   * 
   */
  PaymentReceiptType createPaymentReceiptType();

  /**
   * Create an instance of {@link AssessmentSubTestType }
   * 
   */
  AssessmentSubTestType createAssessmentSubTestType();

  /**
   * Create an instance of {@link AssessmentSubTestType.PerformanceLevels }
   * 
   */
  AssessmentSubTestType.PerformanceLevels createAssessmentSubTestTypePerformanceLevels();

  /**
   * Create an instance of
   * {@link AssessmentSubTestType.PerformanceLevels.PerformanceLevel }
   * 
   */
  AssessmentSubTestType.PerformanceLevels.PerformanceLevel createAssessmentSubTestTypePerformanceLevelsPerformanceLevel();

  /**
   * Create an instance of {@link JournalType }
   * 
   */
  JournalType createJournalType();

  /**
   * Create an instance of {@link StudentSDTNType }
   * 
   */
  StudentSDTNType createStudentSDTNType();

  /**
   * Create an instance of {@link StudentSDTNType.OtherLearningAreasList }
   * 
   */
  StudentSDTNType.OtherLearningAreasList createStudentSDTNTypeOtherLearningAreasList();

  /**
   * Create an instance of {@link StudentSDTNType.AreasOfInterestList }
   * 
   */
  StudentSDTNType.AreasOfInterestList createStudentSDTNTypeAreasOfInterestList();

  /**
   * Create an instance of {@link StudentSDTNType.PreviousSchoolsList }
   * 
   */
  StudentSDTNType.PreviousSchoolsList createStudentSDTNTypePreviousSchoolsList();

  /**
   * Create an instance of {@link Sif3AssessmentFormType }
   * 
   */
  Sif3AssessmentFormType createSif3AssessmentFormType();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentSections }
   * 
   */
  Sif3AssessmentFormType.AssessmentSections createSif3AssessmentFormTypeAssessmentSections();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.FormIdentifiers }
   * 
   */
  Sif3AssessmentFormType.FormIdentifiers createSif3AssessmentFormTypeFormIdentifiers();

  /**
   * Create an instance of {@link AssessmentItemType }
   * 
   */
  AssessmentItemType createAssessmentItemType();

  /**
   * Create an instance of {@link AssessmentItemType.PerformanceLevels }
   * 
   */
  AssessmentItemType.PerformanceLevels createAssessmentItemTypePerformanceLevels();

  /**
   * Create an instance of
   * {@link AssessmentItemType.PerformanceLevels.PerformanceLevel }
   * 
   */
  AssessmentItemType.PerformanceLevels.PerformanceLevel createAssessmentItemTypePerformanceLevelsPerformanceLevel();

  /**
   * Create an instance of {@link AssessmentItemType.ResponseChoices }
   * 
   */
  AssessmentItemType.ResponseChoices createAssessmentItemTypeResponseChoices();

  /**
   * Create an instance of {@link TimeTableType }
   * 
   */
  TimeTableType createTimeTableType();

  /**
   * Create an instance of {@link TimeTableType.TimeTableDayList }
   * 
   */
  TimeTableType.TimeTableDayList createTimeTableTypeTimeTableDayList();

  /**
   * Create an instance of {@link TimeTableType.TimeTableDayList.TimeTableDay }
   * 
   */
  TimeTableType.TimeTableDayList.TimeTableDay createTimeTableTypeTimeTableDayListTimeTableDay();

  /**
   * Create an instance of
   * {@link TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList }
   * 
   */
  TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodList();

  /**
   * Create an instance of {@link TimeElementType }
   * 
   */
  TimeElementType createTimeElementType();

  /**
   * Create an instance of {@link TimeElementType.SpanGaps }
   * 
   */
  TimeElementType.SpanGaps createTimeElementTypeSpanGaps();

  /**
   * Create an instance of {@link AssessmentType }
   * 
   */
  AssessmentType createAssessmentType();

  /**
   * Create an instance of {@link AddressType }
   * 
   */
  AddressType createAddressType();

  /**
   * Create an instance of {@link AddressType.StatisticalAreas }
   * 
   */
  AddressType.StatisticalAreas createAddressTypeStatisticalAreas();

  /**
   * Create an instance of {@link AggregateStatisticFactType }
   * 
   */
  AggregateStatisticFactType createAggregateStatisticFactType();

  /**
   * Create an instance of {@link LearningResourceType }
   * 
   */
  LearningResourceType createLearningResourceType();

  /**
   * Create an instance of {@link LearningResourceType.Components }
   * 
   */
  LearningResourceType.Components createLearningResourceTypeComponents();

  /**
   * Create an instance of {@link LearningResourceType.Components.Component }
   * 
   */
  LearningResourceType.Components.Component createLearningResourceTypeComponentsComponent();

  /**
   * Create an instance of
   * {@link LearningResourceType.Components.Component.AssociatedObjects }
   * 
   */
  LearningResourceType.Components.Component.AssociatedObjects createLearningResourceTypeComponentsComponentAssociatedObjects();

  /**
   * Create an instance of {@link LearningResourceType.Evaluations }
   * 
   */
  LearningResourceType.Evaluations createLearningResourceTypeEvaluations();

  /**
   * Create an instance of {@link LearningResourceType.Approvals }
   * 
   */
  LearningResourceType.Approvals createLearningResourceTypeApprovals();

  /**
   * Create an instance of {@link LearningResourceType.Contacts }
   * 
   */
  LearningResourceType.Contacts createLearningResourceTypeContacts();

  /**
   * Create an instance of {@link AggregateStatisticInfoType }
   * 
   */
  AggregateStatisticInfoType createAggregateStatisticInfoType();

  /**
   * Create an instance of {@link AggregateStatisticInfoType.ExclusionRules }
   * 
   */
  AggregateStatisticInfoType.ExclusionRules createAggregateStatisticInfoTypeExclusionRules();

  /**
   * Create an instance of {@link Sif3AssessmentItemType }
   * 
   */
  Sif3AssessmentItemType createSif3AssessmentItemType();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentItemBanks }
   * 
   */
  Sif3AssessmentItemType.AssessmentItemBanks createSif3AssessmentItemTypeAssessmentItemBanks();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.ResponseChoices }
   * 
   */
  Sif3AssessmentItemType.ResponseChoices createSif3AssessmentItemTypeResponseChoices();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentIdentifiers }
   * 
   */
  Sif3AssessmentItemType.AssessmentIdentifiers createSif3AssessmentItemTypeAssessmentIdentifiers();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationType }
   * 
   */
  Sif3AssessmentAdministrationType createSif3AssessmentAdministrationType();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationType.Organizations
   * }
   * 
   */
  Sif3AssessmentAdministrationType.Organizations createSif3AssessmentAdministrationTypeOrganizations();

  /**
   * Create an instance of {@link LifeCycleType }
   * 
   */
  LifeCycleType createLifeCycleType();

  /**
   * Create an instance of {@link LifeCycleType.ModificationHistory }
   * 
   */
  LifeCycleType.ModificationHistory createLifeCycleTypeModificationHistory();

  /**
   * Create an instance of {@link LifeCycleType.Created }
   * 
   */
  LifeCycleType.Created createLifeCycleTypeCreated();

  /**
   * Create an instance of {@link LifeCycleType.Created.Creators }
   * 
   */
  LifeCycleType.Created.Creators createLifeCycleTypeCreatedCreators();

  /**
   * Create an instance of {@link SIFMetadataType }
   * 
   */
  SIFMetadataType createSIFMetadataType();

  /**
   * Create an instance of {@link DebtorType }
   * 
   */
  DebtorType createDebtorType();

  /**
   * Create an instance of {@link PersonPictureType }
   * 
   */
  PersonPictureType createPersonPictureType();

  /**
   * Create an instance of {@link ReportManifestType }
   * 
   */
  ReportManifestType createReportManifestType();

  /**
   * Create an instance of {@link ReportManifestType.ReportFormatList }
   * 
   */
  ReportManifestType.ReportFormatList createReportManifestTypeReportFormatList();

  /**
   * Create an instance of {@link ActivityType }
   * 
   */
  ActivityType createActivityType();

  /**
   * Create an instance of {@link ActivityType.ActivityTime }
   * 
   */
  ActivityType.ActivityTime createActivityTypeActivityTime();

  /**
   * Create an instance of {@link ActivityType.SourceObjects }
   * 
   */
  ActivityType.SourceObjects createActivityTypeSourceObjects();

  /**
   * Create an instance of {@link ActivityType.SoftwareRequirementList }
   * 
   */
  ActivityType.SoftwareRequirementList createActivityTypeSoftwareRequirementList();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType }
   * 
   */
  StudentSchoolEnrollmentType createStudentSchoolEnrollmentType();

  /**
   * Create an instance of
   * {@link StudentSchoolEnrollmentType.StudentSubjectChoiceList }
   * 
   */
  StudentSchoolEnrollmentType.StudentSubjectChoiceList createStudentSchoolEnrollmentTypeStudentSubjectChoiceList();

  /**
   * Create an instance of {@link StaffAssignmentType }
   * 
   */
  StaffAssignmentType createStaffAssignmentType();

  /**
   * Create an instance of {@link StaffAssignmentType.StaffSubjectList }
   * 
   */
  StaffAssignmentType.StaffSubjectList createStaffAssignmentTypeStaffSubjectList();

  /**
   * Create an instance of {@link ScheduledActivityType }
   * 
   */
  ScheduledActivityType createScheduledActivityType();

  /**
   * Create an instance of {@link ScheduledActivityType.TeacherList }
   * 
   */
  ScheduledActivityType.TeacherList createScheduledActivityTypeTeacherList();

  /**
   * Create an instance of {@link SIFExtendedQueryType }
   * 
   */
  SIFExtendedQueryType createSIFExtendedQueryType();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFOrderBy }
   * 
   */
  SIFExtendedQueryType.SIFOrderBy createSIFExtendedQueryTypeSIFOrderBy();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFWhere }
   * 
   */
  SIFExtendedQueryType.SIFWhere createSIFExtendedQueryTypeSIFWhere();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup }
   * 
   */
  SIFExtendedQueryType.SIFWhere.SIFConditionGroup createSIFExtendedQueryTypeSIFWhereSIFConditionGroup();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions }
   * 
   */
  SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions createSIFExtendedQueryTypeSIFWhereSIFConditionGroupSIFConditions();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition
   * }
   * 
   */
  SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition createSIFExtendedQueryTypeSIFWhereSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFFrom }
   * 
   */
  SIFExtendedQueryType.SIFFrom createSIFExtendedQueryTypeSIFFrom();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFFrom.SIFJoin }
   * 
   */
  SIFExtendedQueryType.SIFFrom.SIFJoin createSIFExtendedQueryTypeSIFFromSIFJoin();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn
   * }
   * 
   */
  SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn createSIFExtendedQueryTypeSIFFromSIFJoinSIFJoinOn();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFSelect }
   * 
   */
  SIFExtendedQueryType.SIFSelect createSIFExtendedQueryTypeSIFSelect();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType }
   * 
   */
  Sif3AssessmentAssetType createSif3AssessmentAssetType();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType.AssetIdentifiers }
   * 
   */
  Sif3AssessmentAssetType.AssetIdentifiers createSif3AssessmentAssetTypeAssetIdentifiers();

  /**
   * Create an instance of {@link SIFQueryType }
   * 
   */
  SIFQueryType createSIFQueryType();

  /**
   * Create an instance of {@link SIFQueryType.SIFConditionGroup }
   * 
   */
  SIFQueryType.SIFConditionGroup createSIFQueryTypeSIFConditionGroup();

  /**
   * Create an instance of {@link SIFQueryType.SIFConditionGroup.SIFConditions }
   * 
   */
  SIFQueryType.SIFConditionGroup.SIFConditions createSIFQueryTypeSIFConditionGroupSIFConditions();

  /**
   * Create an instance of {@link StudentScoreSetType }
   * 
   */
  StudentScoreSetType createStudentScoreSetType();

  /**
   * Create an instance of {@link StudentScoreSetType.Scores }
   * 
   */
  StudentScoreSetType.Scores createStudentScoreSetTypeScores();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType }
   * 
   */
  Sif3AssessmentSubTestType createSif3AssessmentSubTestType();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.AssessmentItems }
   * 
   */
  Sif3AssessmentSubTestType.AssessmentItems createSif3AssessmentSubTestTypeAssessmentItems();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.SubTestIdentifiers }
   * 
   */
  Sif3AssessmentSubTestType.SubTestIdentifiers createSif3AssessmentSubTestTypeSubTestIdentifiers();

  /**
   * Create an instance of {@link Sif3AssessmentType }
   * 
   */
  Sif3AssessmentType createSif3AssessmentType();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentItemBanks }
   * 
   */
  Sif3AssessmentType.AssessmentItemBanks createSif3AssessmentTypeAssessmentItemBanks();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentIdentifiers }
   * 
   */
  Sif3AssessmentType.AssessmentIdentifiers createSif3AssessmentTypeAssessmentIdentifiers();

  /**
   * Create an instance of {@link AssessmentPackageType }
   * 
   */
  AssessmentPackageType createAssessmentPackageType();

  /**
   * Create an instance of {@link StudentParticipationType }
   * 
   */
  StudentParticipationType createStudentParticipationType();

  /**
   * Create an instance of {@link StudentParticipationType.ProgramFundingSources
   * }
   * 
   */
  StudentParticipationType.ProgramFundingSources createStudentParticipationTypeProgramFundingSources();

  /**
   * Create an instance of {@link StudentSnapshotType }
   * 
   */
  StudentSnapshotType createStudentSnapshotType();

  /**
   * Create an instance of {@link StudentSnapshotType.HomeEnrollment }
   * 
   */
  StudentSnapshotType.HomeEnrollment createStudentSnapshotTypeHomeEnrollment();

  /**
   * Create an instance of {@link StudentSnapshotType.StudentSubjectChoiceList }
   * 
   */
  StudentSnapshotType.StudentSubjectChoiceList createStudentSnapshotTypeStudentSubjectChoiceList();

  /**
   * Create an instance of {@link SchoolContactListType }
   * 
   */
  SchoolContactListType createSchoolContactListType();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType }
   * 
   */
  Sif3StudentResponseSetType createSif3StudentResponseSetType();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items }
   * 
   */
  Sif3StudentResponseSetType.Items createSif3StudentResponseSetTypeItems();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item }
   * 
   */
  Sif3StudentResponseSetType.Items.Item createSif3StudentResponseSetTypeItemsItem();

  /**
   * Create an instance of
   * {@link Sif3StudentResponseSetType.Items.Item.FeedbackItems }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.FeedbackItems createSif3StudentResponseSetTypeItemsItemFeedbackItems();

  /**
   * Create an instance of
   * {@link Sif3StudentResponseSetType.Items.Item.TraitScores }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.TraitScores createSif3StudentResponseSetTypeItemsItemTraitScores();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.Comments
   * }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.Comments createSif3StudentResponseSetTypeItemsItemComments();

  /**
   * Create an instance of {@link TimeTableSubjectType }
   * 
   */
  TimeTableSubjectType createTimeTableSubjectType();

  /**
   * Create an instance of {@link LearningStandardItemType }
   * 
   */
  LearningStandardItemType createLearningStandardItemType();

  /**
   * Create an instance of
   * {@link LearningStandardItemType.RelatedLearningStandardItems }
   * 
   */
  LearningStandardItemType.RelatedLearningStandardItems createLearningStandardItemTypeRelatedLearningStandardItems();

  /**
   * Create an instance of {@link LearningStandardItemType.StandardIdentifier }
   * 
   */
  LearningStandardItemType.StandardIdentifier createLearningStandardItemTypeStandardIdentifier();

  /**
   * Create an instance of {@link LearningStandardItemType.Resources }
   * 
   */
  LearningStandardItemType.Resources createLearningStandardItemTypeResources();

  /**
   * Create an instance of {@link SystemRoleType }
   * 
   */
  SystemRoleType createSystemRoleType();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList }
   * 
   */
  SystemRoleType.SystemContextList createSystemRoleTypeSystemContextList();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext
   * }
   * 
   */
  SystemRoleType.SystemContextList.SystemContext createSystemRoleTypeSystemContextListSystemContext();

  /**
   * Create an instance of
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList }
   * 
   */
  SystemRoleType.SystemContextList.SystemContext.RoleList createSystemRoleTypeSystemContextListSystemContextRoleList();

  /**
   * Create an instance of
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role }
   * 
   */
  SystemRoleType.SystemContextList.SystemContext.RoleList.Role createSystemRoleTypeSystemContextListSystemContextRoleListRole();

  /**
   * Create an instance of
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList
   * }
   * 
   */
  SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList();

  /**
   * Create an instance of
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope
   * }
   * 
   */
  SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScope();

  /**
   * Create an instance of {@link EducationFilterType }
   * 
   */
  EducationFilterType createEducationFilterType();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType }
   * 
   */
  Sif3AssessmentRubricType createSif3AssessmentRubricType();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores }
   * 
   */
  Sif3AssessmentRubricType.Scores createSif3AssessmentRubricTypeScores();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores.Score }
   * 
   */
  Sif3AssessmentRubricType.Scores.Score createSif3AssessmentRubricTypeScoresScore();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRubricType.Scores.Score.ScoreComments }
   * 
   */
  Sif3AssessmentRubricType.Scores.Score.ScoreComments createSif3AssessmentRubricTypeScoresScoreScoreComments();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.RubricIdentifiers }
   * 
   */
  Sif3AssessmentRubricType.RubricIdentifiers createSif3AssessmentRubricTypeRubricIdentifiers();

  /**
   * Create an instance of {@link ResourceUsageType }
   * 
   */
  ResourceUsageType createResourceUsageType();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportLineList }
   * 
   */
  ResourceUsageType.ResourceReportLineList createResourceUsageTypeResourceReportLineList();

  /**
   * Create an instance of
   * {@link ResourceUsageType.ResourceReportLineList.ResourceReportLine }
   * 
   */
  ResourceUsageType.ResourceReportLineList.ResourceReportLine createResourceUsageTypeResourceReportLineListResourceReportLine();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportColumnList }
   * 
   */
  ResourceUsageType.ResourceReportColumnList createResourceUsageTypeResourceReportColumnList();

  /**
   * Create an instance of {@link StudentContactRelationshipType }
   * 
   */
  StudentContactRelationshipType createStudentContactRelationshipType();

  /**
   * Create an instance of {@link LearningStandardDocumentType }
   * 
   */
  LearningStandardDocumentType createLearningStandardDocumentType();

  /**
   * Create an instance of {@link SchoolProgramsType }
   * 
   */
  SchoolProgramsType createSchoolProgramsType();

  /**
   * Create an instance of {@link SchoolProgramsType.SchoolProgramList }
   * 
   */
  SchoolProgramsType.SchoolProgramList createSchoolProgramsTypeSchoolProgramList();

  /**
   * Create an instance of {@link StudentPeriodAttendanceType }
   * 
   */
  StudentPeriodAttendanceType createStudentPeriodAttendanceType();

  /**
   * Create an instance of {@link StudentPeriodAttendanceType.AuditInfo }
   * 
   */
  StudentPeriodAttendanceType.AuditInfo createStudentPeriodAttendanceTypeAuditInfo();

  /**
   * Create an instance of {@link AssessmentFormType }
   * 
   */
  AssessmentFormType createAssessmentFormType();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType }
   * 
   */
  Sif3AssessmentRegistrationType createSif3AssessmentRegistrationType();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot }
   * 
   */
  Sif3AssessmentRegistrationType.AssessmentStudentSnapshot createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment
   * }
   * 
   */
  Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollment();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.TestingStatuses
   * }
   * 
   */
  Sif3AssessmentRegistrationType.TestingStatuses createSif3AssessmentRegistrationTypeTestingStatuses();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRegistrationType.StudentSpecialEvents }
   * 
   */
  Sif3AssessmentRegistrationType.StudentSpecialEvents createSif3AssessmentRegistrationTypeStudentSpecialEvents();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType }
   * 
   */
  SummaryEnrollmentInfoType createSummaryEnrollmentInfoType();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList
   * }
   * 
   */
  SummaryEnrollmentInfoType.SchoolEnrollmentList createSummaryEnrollmentInfoTypeSchoolEnrollmentList();

  /**
   * Create an instance of
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment }
   * 
   */
  SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollment();

  /**
   * Create an instance of
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList
   * }
   * 
   */
  SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList();

  /**
   * Create an instance of {@link SIFReportObjectType }
   * 
   */
  SIFReportObjectType createSIFReportObjectType();

  /**
   * Create an instance of {@link SIFReportObjectType.ReportInfo }
   * 
   */
  SIFReportObjectType.ReportInfo createSIFReportObjectTypeReportInfo();

  /**
   * Create an instance of
   * {@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo }
   * 
   */
  SIFReportObjectType.ReportInfo.ReportSubmitterInfo createSIFReportObjectTypeReportInfoReportSubmitterInfo();

  /**
   * Create an instance of {@link OtherCodeListType }
   * 
   */
  OtherCodeListType createOtherCodeListType();

  /**
   * Create an instance of {@link StudentAttendanceTimeListType }
   * 
   */
  StudentAttendanceTimeListType createStudentAttendanceTimeListType();

  /**
   * Create an instance of {@link StudentAttendanceTimeListType.AttendanceTimes
   * }
   * 
   */
  StudentAttendanceTimeListType.AttendanceTimes createStudentAttendanceTimeListTypeAttendanceTimes();

  /**
   * Create an instance of {@link PurchaseOrderType }
   * 
   */
  PurchaseOrderType createPurchaseOrderType();

  /**
   * Create an instance of {@link PurchaseOrderType.PurchasingItems }
   * 
   */
  PurchaseOrderType.PurchasingItems createPurchaseOrderTypePurchasingItems();

  /**
   * Create an instance of
   * {@link PurchaseOrderType.PurchasingItems.PurchasingItem }
   * 
   */
  PurchaseOrderType.PurchasingItems.PurchasingItem createPurchaseOrderTypePurchasingItemsPurchasingItem();

  /**
   * Create an instance of
   * {@link PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts }
   * 
   */
  PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccounts();

  /**
   * Create an instance of {@link ResourceBookingType }
   * 
   */
  ResourceBookingType createResourceBookingType();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType }
   * 
   */
  Sif3AssessmentScoreTableType createSif3AssessmentScoreTableType();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreValues }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreValues createSif3AssessmentScoreTableTypeScoreValues();

  /**
   * Create an instance of
   * {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreValues.ScoreValue createSif3AssessmentScoreTableTypeScoreValuesScoreValue();

  /**
   * Create an instance of
   * {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList();

  /**
   * Create an instance of
   * {@link Sif3AssessmentScoreTableType.ScoreTableIdentifiers }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreTableIdentifiers createSif3AssessmentScoreTableTypeScoreTableIdentifiers();

  /**
   * Create an instance of {@link AssessmentRegistrationType }
   * 
   */
  AssessmentRegistrationType createAssessmentRegistrationType();

  /**
   * Create an instance of
   * {@link AssessmentRegistrationType.StudentSpecialConditions }
   * 
   */
  AssessmentRegistrationType.StudentSpecialConditions createAssessmentRegistrationTypeStudentSpecialConditions();

  /**
   * Create an instance of {@link SectionInfoType }
   * 
   */
  SectionInfoType createSectionInfoType();

  /**
   * Create an instance of {@link TeachingGroupType }
   * 
   */
  TeachingGroupType createTeachingGroupType();

  /**
   * Create an instance of {@link TeachingGroupType.TeachingGroupPeriodList }
   * 
   */
  TeachingGroupType.TeachingGroupPeriodList createTeachingGroupTypeTeachingGroupPeriodList();

  /**
   * Create an instance of {@link TeachingGroupType.TeacherList }
   * 
   */
  TeachingGroupType.TeacherList createTeachingGroupTypeTeacherList();

  /**
   * Create an instance of {@link TeachingGroupType.StudentList }
   * 
   */
  TeachingGroupType.StudentList createTeachingGroupTypeStudentList();

  /**
   * Create an instance of {@link DemographicsType }
   * 
   */
  DemographicsType createDemographicsType();

  /**
   * Create an instance of {@link DemographicsType.ReligiousEventList }
   * 
   */
  DemographicsType.ReligiousEventList createDemographicsTypeReligiousEventList();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsType }
   * 
   */
  SIFExtendedQueryResultsType createSIFExtendedQueryResultsType();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsType.SIFRows }
   * 
   */
  SIFExtendedQueryResultsType.SIFRows createSIFExtendedQueryResultsTypeSIFRows();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsType.SIFColumnHeaders }
   * 
   */
  SIFExtendedQueryResultsType.SIFColumnHeaders createSIFExtendedQueryResultsTypeSIFColumnHeaders();

  /**
   * Create an instance of {@link LanguageListType }
   * 
   */
  LanguageListType createLanguageListType();

  /**
   * Create an instance of {@link SchoolInfoType }
   * 
   */
  SchoolInfoType createSchoolInfoType();

  /**
   * Create an instance of {@link SchoolInfoType.YearLevelEnrollmentList }
   * 
   */
  SchoolInfoType.YearLevelEnrollmentList createSchoolInfoTypeYearLevelEnrollmentList();

  /**
   * Create an instance of {@link SchoolInfoType.OtherIdList }
   * 
   */
  SchoolInfoType.OtherIdList createSchoolInfoTypeOtherIdList();

  /**
   * Create an instance of {@link CalendarSummaryType }
   * 
   */
  CalendarSummaryType createCalendarSummaryType();

  /**
   * Create an instance of {@link StudentSnapshotCollectionType }
   * 
   */
  StudentSnapshotCollectionType createStudentSnapshotCollectionType();

  /**
   * Create an instance of {@link TermInfoCollectionType }
   * 
   */
  TermInfoCollectionType createTermInfoCollectionType();

  /**
   * Create an instance of {@link PaymentReceiptCollectionType }
   * 
   */
  PaymentReceiptCollectionType createPaymentReceiptCollectionType();

  /**
   * Create an instance of {@link SchoolCourseInfoCollectionType }
   * 
   */
  SchoolCourseInfoCollectionType createSchoolCourseInfoCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSessionCollectionType }
   * 
   */
  Sif3AssessmentSessionCollectionType createSif3AssessmentSessionCollectionType();

  /**
   * Create an instance of {@link PhoneNumberType }
   * 
   */
  PhoneNumberType createPhoneNumberType();

  /**
   * Create an instance of {@link EmailType }
   * 
   */
  EmailType createEmailType();

  /**
   * Create an instance of {@link OtherNamesType }
   * 
   */
  OtherNamesType createOtherNamesType();

  /**
   * Create an instance of {@link AssessmentAdministrationCollectionType }
   * 
   */
  AssessmentAdministrationCollectionType createAssessmentAdministrationCollectionType();

  /**
   * Create an instance of {@link PhoneNumberListType }
   * 
   */
  PhoneNumberListType createPhoneNumberListType();

  /**
   * Create an instance of {@link StaffAssignmentCollectionType }
   * 
   */
  StaffAssignmentCollectionType createStaffAssignmentCollectionType();

  /**
   * Create an instance of {@link StudentAttendanceSummaryType }
   * 
   */
  StudentAttendanceSummaryType createStudentAttendanceSummaryType();

  /**
   * Create an instance of {@link AggregateStatisticFactCollectionType }
   * 
   */
  AggregateStatisticFactCollectionType createAggregateStatisticFactCollectionType();

  /**
   * Create an instance of {@link AggregateCharacteristicInfoCollectionType }
   * 
   */
  AggregateCharacteristicInfoCollectionType createAggregateCharacteristicInfoCollectionType();

  /**
   * Create an instance of {@link AddressListType }
   * 
   */
  AddressListType createAddressListType();

  /**
   * Create an instance of {@link ElectronicIdListType }
   * 
   */
  ElectronicIdListType createElectronicIdListType();

  /**
   * Create an instance of {@link ElectronicIdType }
   * 
   */
  ElectronicIdType createElectronicIdType();

  /**
   * Create an instance of {@link AttendanceCodeType }
   * 
   */
  AttendanceCodeType createAttendanceCodeType();

  /**
   * Create an instance of {@link ResourceUsageCollectionType }
   * 
   */
  ResourceUsageCollectionType createResourceUsageCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableCollectionType }
   * 
   */
  Sif3AssessmentScoreTableCollectionType createSif3AssessmentScoreTableCollectionType();

  /**
   * Create an instance of {@link ChargedLocationInfoCollectionType }
   * 
   */
  ChargedLocationInfoCollectionType createChargedLocationInfoCollectionType();

  /**
   * Create an instance of {@link TimeTableCellCollectionType }
   * 
   */
  TimeTableCellCollectionType createTimeTableCellCollectionType();

  /**
   * Create an instance of {@link ResourceBookingCollectionType }
   * 
   */
  ResourceBookingCollectionType createResourceBookingCollectionType();

  /**
   * Create an instance of {@link AssessmentItemCollectionType }
   * 
   */
  AssessmentItemCollectionType createAssessmentItemCollectionType();

  /**
   * Create an instance of {@link RoomInfoCollectionType }
   * 
   */
  RoomInfoCollectionType createRoomInfoCollectionType();

  /**
   * Create an instance of {@link LearningStandardDocumentCollectionType }
   * 
   */
  LearningStandardDocumentCollectionType createLearningStandardDocumentCollectionType();

  /**
   * Create an instance of {@link StudentActivityParticipationCollectionType }
   * 
   */
  StudentActivityParticipationCollectionType createStudentActivityParticipationCollectionType();

  /**
   * Create an instance of {@link StudentAttendanceTimeListCollectionType }
   * 
   */
  StudentAttendanceTimeListCollectionType createStudentAttendanceTimeListCollectionType();

  /**
   * Create an instance of {@link TimeTableCellType }
   * 
   */
  TimeTableCellType createTimeTableCellType();

  /**
   * Create an instance of {@link StudentSectionEnrollmentCollectionType }
   * 
   */
  StudentSectionEnrollmentCollectionType createStudentSectionEnrollmentCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentAssetCollectionType }
   * 
   */
  Sif3AssessmentAssetCollectionType createSif3AssessmentAssetCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentFormCollectionType }
   * 
   */
  Sif3AssessmentFormCollectionType createSif3AssessmentFormCollectionType();

  /**
   * Create an instance of {@link ContactInfoType }
   * 
   */
  ContactInfoType createContactInfoType();

  /**
   * Create an instance of {@link CalendarDateCollectionType }
   * 
   */
  CalendarDateCollectionType createCalendarDateCollectionType();

  /**
   * Create an instance of {@link StudentPeriodAttendanceCollectionType }
   * 
   */
  StudentPeriodAttendanceCollectionType createStudentPeriodAttendanceCollectionType();

  /**
   * Create an instance of {@link TermInfoType }
   * 
   */
  TermInfoType createTermInfoType();

  /**
   * Create an instance of {@link SectionInfoCollectionType }
   * 
   */
  SectionInfoCollectionType createSectionInfoCollectionType();

  /**
   * Create an instance of {@link GridLocationType }
   * 
   */
  GridLocationType createGridLocationType();

  /**
   * Create an instance of {@link SystemRoleCollectionType }
   * 
   */
  SystemRoleCollectionType createSystemRoleCollectionType();

  /**
   * Create an instance of {@link PersonPictureCollectionType }
   * 
   */
  PersonPictureCollectionType createPersonPictureCollectionType();

  /**
   * Create an instance of {@link StudentContactCollectionType }
   * 
   */
  StudentContactCollectionType createStudentContactCollectionType();

  /**
   * Create an instance of {@link ReportAuthorityInfoType }
   * 
   */
  ReportAuthorityInfoType createReportAuthorityInfoType();

  /**
   * Create an instance of {@link StudentAttendanceSummaryCollectionType }
   * 
   */
  StudentAttendanceSummaryCollectionType createStudentAttendanceSummaryCollectionType();

  /**
   * Create an instance of {@link AssessmentCollectionType }
   * 
   */
  AssessmentCollectionType createAssessmentCollectionType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentCollectionType }
   * 
   */
  StudentSchoolEnrollmentCollectionType createStudentSchoolEnrollmentCollectionType();

  /**
   * Create an instance of {@link ScheduledActivityCollectionType }
   * 
   */
  ScheduledActivityCollectionType createScheduledActivityCollectionType();

  /**
   * Create an instance of {@link LEAInfoCollectionType }
   * 
   */
  LEAInfoCollectionType createLEAInfoCollectionType();

  /**
   * Create an instance of {@link LearningResourceCollectionType }
   * 
   */
  LearningResourceCollectionType createLearningResourceCollectionType();

  /**
   * Create an instance of {@link StudentSDTNCollectionType }
   * 
   */
  StudentSDTNCollectionType createStudentSDTNCollectionType();

  /**
   * Create an instance of {@link StudentDailyAttendanceType }
   * 
   */
  StudentDailyAttendanceType createStudentDailyAttendanceType();

  /**
   * Create an instance of {@link GradingAssignmentScoreCollectionType }
   * 
   */
  GradingAssignmentScoreCollectionType createGradingAssignmentScoreCollectionType();

  /**
   * Create an instance of {@link SchoolCourseInfoType }
   * 
   */
  SchoolCourseInfoType createSchoolCourseInfoType();

  /**
   * Create an instance of {@link StudentSectionEnrollmentType }
   * 
   */
  StudentSectionEnrollmentType createStudentSectionEnrollmentType();

  /**
   * Create an instance of {@link TimeTableCollectionType }
   * 
   */
  TimeTableCollectionType createTimeTableCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationCollectionType }
   * 
   */
  Sif3AssessmentRegistrationCollectionType createSif3AssessmentRegistrationCollectionType();

  /**
   * Create an instance of {@link ProgramStatusType }
   * 
   */
  ProgramStatusType createProgramStatusType();

  /**
   * Create an instance of {@link FinancialAccountCollectionType }
   * 
   */
  FinancialAccountCollectionType createFinancialAccountCollectionType();

  /**
   * Create an instance of {@link InvoiceCollectionType }
   * 
   */
  InvoiceCollectionType createInvoiceCollectionType();

  /**
   * Create an instance of {@link PersonInfoType }
   * 
   */
  PersonInfoType createPersonInfoType();

  /**
   * Create an instance of {@link Sif3AssessmentItemAssociationCollectionType }
   * 
   */
  Sif3AssessmentItemAssociationCollectionType createSif3AssessmentItemAssociationCollectionType();

  /**
   * Create an instance of {@link StudentPersonalCollectionType }
   * 
   */
  StudentPersonalCollectionType createStudentPersonalCollectionType();

  /**
   * Create an instance of {@link SubjectAreaType }
   * 
   */
  SubjectAreaType createSubjectAreaType();

  /**
   * Create an instance of {@link EmailListType }
   * 
   */
  EmailListType createEmailListType();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestCollectionType }
   * 
   */
  Sif3AssessmentSubTestCollectionType createSif3AssessmentSubTestCollectionType();

  /**
   * Create an instance of {@link StudentScoreSetCollectionType }
   * 
   */
  StudentScoreSetCollectionType createStudentScoreSetCollectionType();

  /**
   * Create an instance of {@link LearningResourcePackageType }
   * 
   */
  LearningResourcePackageType createLearningResourcePackageType();

  /**
   * Create an instance of {@link ReportAuthorityInfoCollectionType }
   * 
   */
  ReportAuthorityInfoCollectionType createReportAuthorityInfoCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentItemAssociationType }
   * 
   */
  Sif3AssessmentItemAssociationType createSif3AssessmentItemAssociationType();

  /**
   * Create an instance of {@link EquipmentInfoCollectionType }
   * 
   */
  EquipmentInfoCollectionType createEquipmentInfoCollectionType();

  /**
   * Create an instance of {@link TeachingGroupCollectionType }
   * 
   */
  TeachingGroupCollectionType createTeachingGroupCollectionType();

  /**
   * Create an instance of {@link SubjectAreaListType }
   * 
   */
  SubjectAreaListType createSubjectAreaListType();

  /**
   * Create an instance of {@link ChargedLocationInfoType }
   * 
   */
  ChargedLocationInfoType createChargedLocationInfoType();

  /**
   * Create an instance of {@link AssessmentFormCollectionType }
   * 
   */
  AssessmentFormCollectionType createAssessmentFormCollectionType();

  /**
   * Create an instance of {@link AssessmentRegistrationCollectionType }
   * 
   */
  AssessmentRegistrationCollectionType createAssessmentRegistrationCollectionType();

  /**
   * Create an instance of {@link StudentActivityInfoCollectionType }
   * 
   */
  StudentActivityInfoCollectionType createStudentActivityInfoCollectionType();

  /**
   * Create an instance of {@link TimeTableSubjectCollectionType }
   * 
   */
  TimeTableSubjectCollectionType createTimeTableSubjectCollectionType();

  /**
   * Create an instance of {@link StudentParticipationCollectionType }
   * 
   */
  StudentParticipationCollectionType createStudentParticipationCollectionType();

  /**
   * Create an instance of {@link StaffCollectionType }
   * 
   */
  StaffCollectionType createStaffCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentRubricCollectionType }
   * 
   */
  Sif3AssessmentRubricCollectionType createSif3AssessmentRubricCollectionType();

  /**
   * Create an instance of {@link StudentDailyAttendanceCollectionType }
   * 
   */
  StudentDailyAttendanceCollectionType createStudentDailyAttendanceCollectionType();

  /**
   * Create an instance of {@link StudentContactRelationshipCollectionType }
   * 
   */
  StudentContactRelationshipCollectionType createStudentContactRelationshipCollectionType();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoCollectionType }
   * 
   */
  SummaryEnrollmentInfoCollectionType createSummaryEnrollmentInfoCollectionType();

  /**
   * Create an instance of {@link CalendarSummaryCollectionType }
   * 
   */
  CalendarSummaryCollectionType createCalendarSummaryCollectionType();

  /**
   * Create an instance of {@link JournalCollectionType }
   * 
   */
  JournalCollectionType createJournalCollectionType();

  /**
   * Create an instance of {@link ReportManifestCollectionType }
   * 
   */
  ReportManifestCollectionType createReportManifestCollectionType();

  /**
   * Create an instance of {@link FinancialAccountType }
   * 
   */
  FinancialAccountType createFinancialAccountType();

  /**
   * Create an instance of {@link LearningResourcePackageCollectionType }
   * 
   */
  LearningResourcePackageCollectionType createLearningResourcePackageCollectionType();

  /**
   * Create an instance of {@link AggregateCharacteristicInfoType }
   * 
   */
  AggregateCharacteristicInfoType createAggregateCharacteristicInfoType();

  /**
   * Create an instance of {@link IdentityCollectionType }
   * 
   */
  IdentityCollectionType createIdentityCollectionType();

  /**
   * Create an instance of {@link AggregateStatisticInfoCollectionType }
   * 
   */
  AggregateStatisticInfoCollectionType createAggregateStatisticInfoCollectionType();

  /**
   * Create an instance of {@link ACStrandSubjectAreaType }
   * 
   */
  ACStrandSubjectAreaType createACStrandSubjectAreaType();

  /**
   * Create an instance of {@link Sif3AssessmentCollectionType }
   * 
   */
  Sif3AssessmentCollectionType createSif3AssessmentCollectionType();

  /**
   * Create an instance of {@link YearLevelType }
   * 
   */
  YearLevelType createYearLevelType();

  /**
   * Create an instance of {@link SessionInfoType }
   * 
   */
  SessionInfoType createSessionInfoType();

  /**
   * Create an instance of {@link GradingAssignmentType }
   * 
   */
  GradingAssignmentType createGradingAssignmentType();

  /**
   * Create an instance of {@link VendorInfoCollectionType }
   * 
   */
  VendorInfoCollectionType createVendorInfoCollectionType();

  /**
   * Create an instance of {@link GradingAssignmentScoreType }
   * 
   */
  GradingAssignmentScoreType createGradingAssignmentScoreType();

  /**
   * Create an instance of {@link SchoolProgramsCollectionType }
   * 
   */
  SchoolProgramsCollectionType createSchoolProgramsCollectionType();

  /**
   * Create an instance of {@link LearningStandardItemCollectionType }
   * 
   */
  LearningStandardItemCollectionType createLearningStandardItemCollectionType();

  /**
   * Create an instance of {@link Sif3StudentResponseSetCollectionType }
   * 
   */
  Sif3StudentResponseSetCollectionType createSif3StudentResponseSetCollectionType();

  /**
   * Create an instance of {@link SIFContextsType }
   * 
   */
  SIFContextsType createSIFContextsType();

  /**
   * Create an instance of {@link YearLevelsType }
   * 
   */
  YearLevelsType createYearLevelsType();

  /**
   * Create an instance of {@link RelationshipType }
   * 
   */
  RelationshipType createRelationshipType();

  /**
   * Create an instance of {@link Sif3AssessmentItemCollectionType }
   * 
   */
  Sif3AssessmentItemCollectionType createSif3AssessmentItemCollectionType();

  /**
   * Create an instance of {@link AssessmentSubTestCollectionType }
   * 
   */
  AssessmentSubTestCollectionType createAssessmentSubTestCollectionType();

  /**
   * Create an instance of {@link AssessmentPackageCollectionType }
   * 
   */
  AssessmentPackageCollectionType createAssessmentPackageCollectionType();

  /**
   * Create an instance of {@link PrincipalInfoType }
   * 
   */
  PrincipalInfoType createPrincipalInfoType();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationCollectionType }
   * 
   */
  Sif3AssessmentAdministrationCollectionType createSif3AssessmentAdministrationCollectionType();

  /**
   * Create an instance of {@link VendorInfoType }
   * 
   */
  VendorInfoType createVendorInfoType();

  /**
   * Create an instance of {@link EnglishProficiencyType }
   * 
   */
  EnglishProficiencyType createEnglishProficiencyType();

  /**
   * Create an instance of {@link GradingAssignmentCollectionType }
   * 
   */
  GradingAssignmentCollectionType createGradingAssignmentCollectionType();

  /**
   * Create an instance of {@link DebtorCollectionType }
   * 
   */
  DebtorCollectionType createDebtorCollectionType();

  /**
   * Create an instance of {@link PurchaseOrderCollectionType }
   * 
   */
  PurchaseOrderCollectionType createPurchaseOrderCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSectionCollectionType }
   * 
   */
  Sif3AssessmentSectionCollectionType createSif3AssessmentSectionCollectionType();

  /**
   * Create an instance of {@link SchoolInfoCollectionType }
   * 
   */
  SchoolInfoCollectionType createSchoolInfoCollectionType();

  /**
   * Create an instance of {@link NameType }
   * 
   */
  NameType createNameType();

  /**
   * Create an instance of {@link SessionInfoCollectionType }
   * 
   */
  SessionInfoCollectionType createSessionInfoCollectionType();

  /**
   * Create an instance of {@link ActivityCollectionType }
   * 
   */
  ActivityCollectionType createActivityCollectionType();

  /**
   * Create an instance of {@link SIFReportObjectCollectionType }
   * 
   */
  SIFReportObjectCollectionType createSIFReportObjectCollectionType();

  /**
   * Create an instance of {@link SelectedContentType }
   * 
   */
  SelectedContentType createSelectedContentType();

  /**
   * Create an instance of {@link MonetaryAmountType }
   * 
   */
  MonetaryAmountType createMonetaryAmountType();

  /**
   * Create an instance of {@link SIFErrorDataModelType }
   * 
   */
  SIFErrorDataModelType createSIFErrorDataModelType();

  /**
   * Create an instance of {@link ReportPackageType }
   * 
   */
  ReportPackageType createReportPackageType();

  /**
   * Create an instance of {@link ExtendedContentType }
   * 
   */
  ExtendedContentType createExtendedContentType();

  /**
   * Create an instance of {@link BaseNameType }
   * 
   */
  BaseNameType createBaseNameType();

  /**
   * Create an instance of {@link NameOfRecordType }
   * 
   */
  NameOfRecordType createNameOfRecordType();

  /**
   * Create an instance of {@link ReportDataObjectType }
   * 
   */
  ReportDataObjectType createReportDataObjectType();

  /**
   * Create an instance of {@link OtherNameType }
   * 
   */
  OtherNameType createOtherNameType();

  /**
   * Create an instance of {@link ObjectType }
   * 
   */
  ObjectType createObjectType();

  /**
   * Create an instance of {@link SIFQueryDataModelType.SIFQueryObject }
   * 
   */
  SIFQueryDataModelType.SIFQueryObject createSIFQueryDataModelTypeSIFQueryObject();

  /**
   * Create an instance of
   * {@link SIFQueryDataModelType.SIFConditionGroup.SIFConditions.SIFCondition }
   * 
   */
  SIFQueryDataModelType.SIFConditionGroup.SIFConditions.SIFCondition createSIFQueryDataModelTypeSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of
   * {@link SIFHeaderDataModelType.SIFSecurity.SIFSecureChannel }
   * 
   */
  SIFHeaderDataModelType.SIFSecurity.SIFSecureChannel createSIFHeaderDataModelTypeSIFSecuritySIFSecureChannel();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType.SIFRows.R
   * }
   * 
   */
  SIFExtendedQueryResultsDataModelType.SIFRows.R createSIFExtendedQueryResultsDataModelTypeSIFRowsR();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryResultsDataModelType.SIFColumnHeaders.SIFElement }
   * 
   */
  SIFExtendedQueryResultsDataModelType.SIFColumnHeaders.SIFElement createSIFExtendedQueryResultsDataModelTypeSIFColumnHeadersSIFElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFOrderBy.SIFElement }
   * 
   */
  SIFExtendedQueryDataModelType.SIFOrderBy.SIFElement createSIFExtendedQueryDataModelTypeSIFOrderBySIFElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement
   * }
   * 
   */
  SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroupSIFConditionsSIFConditionSIFElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement
   * }
   * 
   */
  SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement createSIFExtendedQueryDataModelTypeSIFFromSIFJoinSIFJoinOnSIFLeftElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement
   * }
   * 
   */
  SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement createSIFExtendedQueryDataModelTypeSIFFromSIFJoinSIFJoinOnSIFRightElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryDataModelType.SIFSelect.SIFElement }
   * 
   */
  SIFExtendedQueryDataModelType.SIFSelect.SIFElement createSIFExtendedQueryDataModelTypeSIFSelectSIFElement();

  /**
   * Create an instance of {@link AbstractContentPackageType.XMLData }
   * 
   */
  AbstractContentPackageType.XMLData createAbstractContentPackageTypeXMLData();

  /**
   * Create an instance of {@link AbstractContentPackageType.TextData }
   * 
   */
  AbstractContentPackageType.TextData createAbstractContentPackageTypeTextData();

  /**
   * Create an instance of {@link AbstractContentPackageType.BinaryData }
   * 
   */
  AbstractContentPackageType.BinaryData createAbstractContentPackageTypeBinaryData();

  /**
   * Create an instance of {@link AbstractContentPackageType.Reference }
   * 
   */
  AbstractContentPackageType.Reference createAbstractContentPackageTypeReference();

  /**
   * Create an instance of {@link AbstractContentElementType.XMLData }
   * 
   */
  AbstractContentElementType.XMLData createAbstractContentElementTypeXMLData();

  /**
   * Create an instance of {@link AbstractContentElementType.TextData }
   * 
   */
  AbstractContentElementType.TextData createAbstractContentElementTypeTextData();

  /**
   * Create an instance of {@link AbstractContentElementType.BinaryData }
   * 
   */
  AbstractContentElementType.BinaryData createAbstractContentElementTypeBinaryData();

  /**
   * Create an instance of {@link AbstractContentElementType.Reference }
   * 
   */
  AbstractContentElementType.Reference createAbstractContentElementTypeReference();

  /**
   * Create an instance of {@link IdentityType.SIFRefId }
   * 
   */
  IdentityType.SIFRefId createIdentityTypeSIFRefId();

  /**
   * Create an instance of {@link IdentityType.PasswordList.Password }
   * 
   */
  IdentityType.PasswordList.Password createIdentityTypePasswordListPassword();

  /**
   * Create an instance of
   * {@link IdentityType.IdentityAssertions.IdentityAssertion }
   * 
   */
  IdentityType.IdentityAssertions.IdentityAssertion createIdentityTypeIdentityAssertionsIdentityAssertion();

  /**
   * Create an instance of {@link LocationType.LocationRefId }
   * 
   */
  LocationType.LocationRefId createLocationTypeLocationRefId();

  /**
   * Create an instance of {@link LEAInfoType.EducationAgencyType }
   * 
   */
  LEAInfoType.EducationAgencyType createLEAInfoTypeEducationAgencyType();

  /**
   * Create an instance of {@link LEAInfoType.LEAContactList.LEAContact }
   * 
   */
  LEAInfoType.LEAContactList.LEAContact createLEAInfoTypeLEAContactListLEAContact();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionAssets }
   * 
   */
  Sif3AssessmentSectionType.SectionAssets createSif3AssessmentSectionTypeSectionAssets();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSectionType.SectionItems.SectionItem }
   * 
   */
  Sif3AssessmentSectionType.SectionItems.SectionItem createSif3AssessmentSectionTypeSectionItemsSectionItem();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSectionType.SectionIdentifiers.SectionIdentifier }
   * 
   */
  Sif3AssessmentSectionType.SectionIdentifiers.SectionIdentifier createSif3AssessmentSectionTypeSectionIdentifiersSectionIdentifier();

  /**
   * Create an instance of {@link SIFExtendedElementsType.SIFExtendedElement }
   * 
   */
  SIFExtendedElementsType.SIFExtendedElement createSIFExtendedElementsTypeSIFExtendedElement();

  /**
   * Create an instance of {@link StaffPersonalType.MostRecent.NAPLANClassList }
   * 
   */
  StaffPersonalType.MostRecent.NAPLANClassList createStaffPersonalTypeMostRecentNAPLANClassList();

  /**
   * Create an instance of {@link StaffPersonalType.OtherIdList.OtherId }
   * 
   */
  StaffPersonalType.OtherIdList.OtherId createStaffPersonalTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link EquipmentInfoType.SIFRefId }
   * 
   */
  EquipmentInfoType.SIFRefId createEquipmentInfoTypeSIFRefId();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType.StaffPersonalRefIds
   * }
   * 
   */
  Sif3AssessmentSessionType.StaffPersonalRefIds createSif3AssessmentSessionTypeStaffPersonalRefIds();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSessionType.UnusualEvents.UnusualEvent }
   * 
   */
  Sif3AssessmentSessionType.UnusualEvents.UnusualEvent createSif3AssessmentSessionTypeUnusualEventsUnusualEvent();

  /**
   * Create an instance of
   * {@link AssessmentAdministrationType.SpecialConditions.SpecialCondition }
   * 
   */
  AssessmentAdministrationType.SpecialConditions.SpecialCondition createAssessmentAdministrationTypeSpecialConditionsSpecialCondition();

  /**
   * Create an instance of {@link CalendarDate.CalendarDateType }
   * 
   */
  CalendarDate.CalendarDateType createCalendarDateCalendarDateType();

  /**
   * Create an instance of {@link CalendarDate.StudentAttendance }
   * 
   */
  CalendarDate.StudentAttendance createCalendarDateStudentAttendance();

  /**
   * Create an instance of {@link CalendarDate.TeacherAttendance }
   * 
   */
  CalendarDate.TeacherAttendance createCalendarDateTeacherAttendance();

  /**
   * Create an instance of {@link CalendarDate.AdministratorAttendance }
   * 
   */
  CalendarDate.AdministratorAttendance createCalendarDateAdministratorAttendance();

  /**
   * Create an instance of {@link RoomInfoType.StaffList }
   * 
   */
  RoomInfoType.StaffList createRoomInfoTypeStaffList();

  /**
   * Create an instance of
   * {@link StudentActivityParticipationType.RecognitionList }
   * 
   */
  StudentActivityParticipationType.RecognitionList createStudentActivityParticipationTypeRecognitionList();

  /**
   * Create an instance of {@link StudentPersonalType.MostRecent }
   * 
   */
  StudentPersonalType.MostRecent createStudentPersonalTypeMostRecent();

  /**
   * Create an instance of {@link StudentPersonalType.OtherIdList.OtherId }
   * 
   */
  StudentPersonalType.OtherIdList.OtherId createStudentPersonalTypeOtherIdListOtherId();

  /**
   * Create an instance of
   * {@link StudentPersonalType.MedicalAlertMessages.MedicalAlertMessage }
   * 
   */
  StudentPersonalType.MedicalAlertMessages.MedicalAlertMessage createStudentPersonalTypeMedicalAlertMessagesMedicalAlertMessage();

  /**
   * Create an instance of {@link StudentPersonalType.AlertMessages.AlertMessage
   * }
   * 
   */
  StudentPersonalType.AlertMessages.AlertMessage createStudentPersonalTypeAlertMessagesAlertMessage();

  /**
   * Create an instance of {@link StudentActivityInfoType.StudentActivityType }
   * 
   */
  StudentActivityInfoType.StudentActivityType createStudentActivityInfoTypeStudentActivityType();

  /**
   * Create an instance of {@link StudentContactPersonalType.OtherIdList.OtherId
   * }
   * 
   */
  StudentContactPersonalType.OtherIdList.OtherId createStudentContactPersonalTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link InvoiceType.InvoicedEntity }
   * 
   */
  InvoiceType.InvoicedEntity createInvoiceTypeInvoicedEntity();

  /**
   * Create an instance of {@link InvoiceType.BilledAmount }
   * 
   */
  InvoiceType.BilledAmount createInvoiceTypeBilledAmount();

  /**
   * Create an instance of {@link InvoiceType.FinancialAccountRefIdList }
   * 
   */
  InvoiceType.FinancialAccountRefIdList createInvoiceTypeFinancialAccountRefIdList();

  /**
   * Create an instance of {@link InvoiceType.PurchasingItems.PurchasingItem }
   * 
   */
  InvoiceType.PurchasingItems.PurchasingItem createInvoiceTypePurchasingItemsPurchasingItem();

  /**
   * Create an instance of {@link PaymentReceiptType.TransactionAmount }
   * 
   */
  PaymentReceiptType.TransactionAmount createPaymentReceiptTypeTransactionAmount();

  /**
   * Create an instance of {@link PaymentReceiptType.FinancialAccountRefIdList }
   * 
   */
  PaymentReceiptType.FinancialAccountRefIdList createPaymentReceiptTypeFinancialAccountRefIdList();

  /**
   * Create an instance of {@link AssessmentSubTestType.ScoreRange }
   * 
   */
  AssessmentSubTestType.ScoreRange createAssessmentSubTestTypeScoreRange();

  /**
   * Create an instance of {@link AssessmentSubTestType.AssessmentSubTestRefIds
   * }
   * 
   */
  AssessmentSubTestType.AssessmentSubTestRefIds createAssessmentSubTestTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of
   * {@link AssessmentSubTestType.LearningStandardItemRefIds }
   * 
   */
  AssessmentSubTestType.LearningStandardItemRefIds createAssessmentSubTestTypeLearningStandardItemRefIds();

  /**
   * Create an instance of
   * {@link AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores }
   * 
   */
  AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores();

  /**
   * Create an instance of {@link JournalType.OriginatingTransactionRefId }
   * 
   */
  JournalType.OriginatingTransactionRefId createJournalTypeOriginatingTransactionRefId();

  /**
   * Create an instance of {@link StudentSDTNType.FurtherInformation }
   * 
   */
  StudentSDTNType.FurtherInformation createStudentSDTNTypeFurtherInformation();

  /**
   * Create an instance of {@link StudentSDTNType.PastoralCare }
   * 
   */
  StudentSDTNType.PastoralCare createStudentSDTNTypePastoralCare();

  /**
   * Create an instance of
   * {@link StudentSDTNType.OtherLearningAreasList.OtherLearningArea }
   * 
   */
  StudentSDTNType.OtherLearningAreasList.OtherLearningArea createStudentSDTNTypeOtherLearningAreasListOtherLearningArea();

  /**
   * Create an instance of
   * {@link StudentSDTNType.AreasOfInterestList.ActivityInfo }
   * 
   */
  StudentSDTNType.AreasOfInterestList.ActivityInfo createStudentSDTNTypeAreasOfInterestListActivityInfo();

  /**
   * Create an instance of
   * {@link StudentSDTNType.PreviousSchoolsList.PreviousSchool }
   * 
   */
  StudentSDTNType.PreviousSchoolsList.PreviousSchool createStudentSDTNTypePreviousSchoolsListPreviousSchool();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.FormAccommodations }
   * 
   */
  Sif3AssessmentFormType.FormAccommodations createSif3AssessmentFormTypeFormAccommodations();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentSubTestRefIds
   * }
   * 
   */
  Sif3AssessmentFormType.AssessmentSubTestRefIds createSif3AssessmentFormTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentPlatforms }
   * 
   */
  Sif3AssessmentFormType.AssessmentPlatforms createSif3AssessmentFormTypeAssessmentPlatforms();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentAssetRefIds }
   * 
   */
  Sif3AssessmentFormType.AssessmentAssetRefIds createSif3AssessmentFormTypeAssessmentAssetRefIds();

  /**
   * Create an instance of
   * {@link Sif3AssessmentFormType.AssessmentSections.AssessmentSection }
   * 
   */
  Sif3AssessmentFormType.AssessmentSections.AssessmentSection createSif3AssessmentFormTypeAssessmentSectionsAssessmentSection();

  /**
   * Create an instance of
   * {@link Sif3AssessmentFormType.FormIdentifiers.FormIdentifier }
   * 
   */
  Sif3AssessmentFormType.FormIdentifiers.FormIdentifier createSif3AssessmentFormTypeFormIdentifiersFormIdentifier();

  /**
   * Create an instance of {@link AssessmentItemType.LearningStandardItems }
   * 
   */
  AssessmentItemType.LearningStandardItems createAssessmentItemTypeLearningStandardItems();

  /**
   * Create an instance of
   * {@link AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores }
   * 
   */
  AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores();

  /**
   * Create an instance of {@link AssessmentItemType.ResponseChoices.Choice }
   * 
   */
  AssessmentItemType.ResponseChoices.Choice createAssessmentItemTypeResponseChoicesChoice();

  /**
   * Create an instance of
   * {@link TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod
   * }
   * 
   */
  TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriod();

  /**
   * Create an instance of {@link TimeElementType.SpanGaps.SpanGap }
   * 
   */
  TimeElementType.SpanGaps.SpanGap createTimeElementTypeSpanGapsSpanGap();

  /**
   * Create an instance of {@link AssessmentType.AssessmentDescriptors }
   * 
   */
  AssessmentType.AssessmentDescriptors createAssessmentTypeAssessmentDescriptors();

  /**
   * Create an instance of {@link AddressType.Street }
   * 
   */
  AddressType.Street createAddressTypeStreet();

  /**
   * Create an instance of {@link AddressType.MapReference }
   * 
   */
  AddressType.MapReference createAddressTypeMapReference();

  /**
   * Create an instance of {@link AddressType.StatisticalAreas.StatisticalArea }
   * 
   */
  AddressType.StatisticalAreas.StatisticalArea createAddressTypeStatisticalAreasStatisticalArea();

  /**
   * Create an instance of {@link AggregateStatisticFactType.Characteristics }
   * 
   */
  AggregateStatisticFactType.Characteristics createAggregateStatisticFactTypeCharacteristics();

  /**
   * Create an instance of {@link LearningResourceType.Location }
   * 
   */
  LearningResourceType.Location createLearningResourceTypeLocation();

  /**
   * Create an instance of {@link LearningResourceType.SubjectAreas }
   * 
   */
  LearningResourceType.SubjectAreas createLearningResourceTypeSubjectAreas();

  /**
   * Create an instance of {@link LearningResourceType.MediaTypes }
   * 
   */
  LearningResourceType.MediaTypes createLearningResourceTypeMediaTypes();

  /**
   * Create an instance of {@link LearningResourceType.LearningStandards }
   * 
   */
  LearningResourceType.LearningStandards createLearningResourceTypeLearningStandards();

  /**
   * Create an instance of
   * {@link LearningResourceType.Components.Component.Strategies }
   * 
   */
  LearningResourceType.Components.Component.Strategies createLearningResourceTypeComponentsComponentStrategies();

  /**
   * Create an instance of
   * {@link LearningResourceType.Components.Component.AssociatedObjects.AssociatedObject
   * }
   * 
   */
  LearningResourceType.Components.Component.AssociatedObjects.AssociatedObject createLearningResourceTypeComponentsComponentAssociatedObjectsAssociatedObject();

  /**
   * Create an instance of {@link LearningResourceType.Evaluations.Evaluation }
   * 
   */
  LearningResourceType.Evaluations.Evaluation createLearningResourceTypeEvaluationsEvaluation();

  /**
   * Create an instance of {@link LearningResourceType.Approvals.Approval }
   * 
   */
  LearningResourceType.Approvals.Approval createLearningResourceTypeApprovalsApproval();

  /**
   * Create an instance of {@link LearningResourceType.Contacts.Contact }
   * 
   */
  LearningResourceType.Contacts.Contact createLearningResourceTypeContactsContact();

  /**
   * Create an instance of {@link AggregateStatisticInfoType.CalculationRule }
   * 
   */
  AggregateStatisticInfoType.CalculationRule createAggregateStatisticInfoTypeCalculationRule();

  /**
   * Create an instance of
   * {@link AggregateStatisticInfoType.ExclusionRules.ExclusionRule }
   * 
   */
  AggregateStatisticInfoType.ExclusionRules.ExclusionRule createAggregateStatisticInfoTypeExclusionRulesExclusionRule();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.LearningStandardItems }
   * 
   */
  Sif3AssessmentItemType.LearningStandardItems createSif3AssessmentItemTypeLearningStandardItems();

  /**
   * Create an instance of
   * {@link Sif3AssessmentItemType.AssessmentItemAssetRefIds }
   * 
   */
  Sif3AssessmentItemType.AssessmentItemAssetRefIds createSif3AssessmentItemTypeAssessmentItemAssetRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.ItemRubricIds }
   * 
   */
  Sif3AssessmentItemType.ItemRubricIds createSif3AssessmentItemTypeItemRubricIds();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentItemPlatforms
   * }
   * 
   */
  Sif3AssessmentItemType.AssessmentItemPlatforms createSif3AssessmentItemTypeAssessmentItemPlatforms();

  /**
   * Create an instance of
   * {@link Sif3AssessmentItemType.AssessmentItemBanks.AssessmentItemBank }
   * 
   */
  Sif3AssessmentItemType.AssessmentItemBanks.AssessmentItemBank createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBank();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.ResponseChoices.Choice
   * }
   * 
   */
  Sif3AssessmentItemType.ResponseChoices.Choice createSif3AssessmentItemTypeResponseChoicesChoice();

  /**
   * Create an instance of
   * {@link Sif3AssessmentItemType.AssessmentIdentifiers.AssessmentIdentifier }
   * 
   */
  Sif3AssessmentItemType.AssessmentIdentifiers.AssessmentIdentifier createSif3AssessmentItemTypeAssessmentIdentifiersAssessmentIdentifier();

  /**
   * Create an instance of
   * {@link Sif3AssessmentAdministrationType.AdministrationAssessments }
   * 
   */
  Sif3AssessmentAdministrationType.AdministrationAssessments createSif3AssessmentAdministrationTypeAdministrationAssessments();

  /**
   * Create an instance of
   * {@link Sif3AssessmentAdministrationType.Organizations.Organization }
   * 
   */
  Sif3AssessmentAdministrationType.Organizations.Organization createSif3AssessmentAdministrationTypeOrganizationsOrganization();

  /**
   * Create an instance of {@link LifeCycleType.TimeElements }
   * 
   */
  LifeCycleType.TimeElements createLifeCycleTypeTimeElements();

  /**
   * Create an instance of {@link LifeCycleType.ModificationHistory.Modified }
   * 
   */
  LifeCycleType.ModificationHistory.Modified createLifeCycleTypeModificationHistoryModified();

  /**
   * Create an instance of {@link LifeCycleType.Created.Creators.Creator }
   * 
   */
  LifeCycleType.Created.Creators.Creator createLifeCycleTypeCreatedCreatorsCreator();

  /**
   * Create an instance of {@link SIFMetadataType.TimeElements }
   * 
   */
  SIFMetadataType.TimeElements createSIFMetadataTypeTimeElements();

  /**
   * Create an instance of {@link DebtorType.BilledEntity }
   * 
   */
  DebtorType.BilledEntity createDebtorTypeBilledEntity();

  /**
   * Create an instance of {@link PersonPictureType.ParentObjectRefId }
   * 
   */
  PersonPictureType.ParentObjectRefId createPersonPictureTypeParentObjectRefId();

  /**
   * Create an instance of {@link PersonPictureType.PictureSource }
   * 
   */
  PersonPictureType.PictureSource createPersonPictureTypePictureSource();

  /**
   * Create an instance of {@link ReportManifestType.ReceivingAuthority }
   * 
   */
  ReportManifestType.ReceivingAuthority createReportManifestTypeReceivingAuthority();

  /**
   * Create an instance of {@link ReportManifestType.ReportingPeriod }
   * 
   */
  ReportManifestType.ReportingPeriod createReportManifestTypeReportingPeriod();

  /**
   * Create an instance of {@link ReportManifestType.ReportDefinitionSource }
   * 
   */
  ReportManifestType.ReportDefinitionSource createReportManifestTypeReportDefinitionSource();

  /**
   * Create an instance of {@link ReportManifestType.SIFQueryGroup }
   * 
   */
  ReportManifestType.SIFQueryGroup createReportManifestTypeSIFQueryGroup();

  /**
   * Create an instance of
   * {@link ReportManifestType.ReportFormatList.ReportFormat }
   * 
   */
  ReportManifestType.ReportFormatList.ReportFormat createReportManifestTypeReportFormatListReportFormat();

  /**
   * Create an instance of {@link ActivityType.TechnicalRequirements }
   * 
   */
  ActivityType.TechnicalRequirements createActivityTypeTechnicalRequirements();

  /**
   * Create an instance of {@link ActivityType.EssentialMaterials }
   * 
   */
  ActivityType.EssentialMaterials createActivityTypeEssentialMaterials();

  /**
   * Create an instance of {@link ActivityType.LearningObjectives }
   * 
   */
  ActivityType.LearningObjectives createActivityTypeLearningObjectives();

  /**
   * Create an instance of {@link ActivityType.LearningStandards }
   * 
   */
  ActivityType.LearningStandards createActivityTypeLearningStandards();

  /**
   * Create an instance of {@link ActivityType.Prerequisites }
   * 
   */
  ActivityType.Prerequisites createActivityTypePrerequisites();

  /**
   * Create an instance of {@link ActivityType.Students }
   * 
   */
  ActivityType.Students createActivityTypeStudents();

  /**
   * Create an instance of {@link ActivityType.Evaluation }
   * 
   */
  ActivityType.Evaluation createActivityTypeEvaluation();

  /**
   * Create an instance of {@link ActivityType.LearningResources }
   * 
   */
  ActivityType.LearningResources createActivityTypeLearningResources();

  /**
   * Create an instance of {@link ActivityType.ActivityTime.Duration }
   * 
   */
  ActivityType.ActivityTime.Duration createActivityTypeActivityTimeDuration();

  /**
   * Create an instance of {@link ActivityType.SourceObjects.SourceObject }
   * 
   */
  ActivityType.SourceObjects.SourceObject createActivityTypeSourceObjectsSourceObject();

  /**
   * Create an instance of
   * {@link ActivityType.SoftwareRequirementList.SoftwareRequirement }
   * 
   */
  ActivityType.SoftwareRequirementList.SoftwareRequirement createActivityTypeSoftwareRequirementListSoftwareRequirement();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.EntryType }
   * 
   */
  StudentSchoolEnrollmentType.EntryType createStudentSchoolEnrollmentTypeEntryType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Homeroom }
   * 
   */
  StudentSchoolEnrollmentType.Homeroom createStudentSchoolEnrollmentTypeHomeroom();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Advisor }
   * 
   */
  StudentSchoolEnrollmentType.Advisor createStudentSchoolEnrollmentTypeAdvisor();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Counselor }
   * 
   */
  StudentSchoolEnrollmentType.Counselor createStudentSchoolEnrollmentTypeCounselor();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Calendar }
   * 
   */
  StudentSchoolEnrollmentType.Calendar createStudentSchoolEnrollmentTypeCalendar();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.ExitStatus }
   * 
   */
  StudentSchoolEnrollmentType.ExitStatus createStudentSchoolEnrollmentTypeExitStatus();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.ExitType }
   * 
   */
  StudentSchoolEnrollmentType.ExitType createStudentSchoolEnrollmentTypeExitType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.CatchmentStatus }
   * 
   */
  StudentSchoolEnrollmentType.CatchmentStatus createStudentSchoolEnrollmentTypeCatchmentStatus();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.PromotionInfo }
   * 
   */
  StudentSchoolEnrollmentType.PromotionInfo createStudentSchoolEnrollmentTypePromotionInfo();

  /**
   * Create an instance of
   * {@link StudentSchoolEnrollmentType.StudentSubjectChoiceList.StudentSubjectChoice
   * }
   * 
   */
  StudentSchoolEnrollmentType.StudentSubjectChoiceList.StudentSubjectChoice createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoice();

  /**
   * Create an instance of {@link StaffAssignmentType.StaffActivity }
   * 
   */
  StaffAssignmentType.StaffActivity createStaffAssignmentTypeStaffActivity();

  /**
   * Create an instance of
   * {@link StaffAssignmentType.StaffSubjectList.StaffSubject }
   * 
   */
  StaffAssignmentType.StaffSubjectList.StaffSubject createStaffAssignmentTypeStaffSubjectListStaffSubject();

  /**
   * Create an instance of {@link ScheduledActivityType.RoomList }
   * 
   */
  ScheduledActivityType.RoomList createScheduledActivityTypeRoomList();

  /**
   * Create an instance of {@link ScheduledActivityType.StudentList }
   * 
   */
  ScheduledActivityType.StudentList createScheduledActivityTypeStudentList();

  /**
   * Create an instance of {@link ScheduledActivityType.TeachingGroupList }
   * 
   */
  ScheduledActivityType.TeachingGroupList createScheduledActivityTypeTeachingGroupList();

  /**
   * Create an instance of {@link ScheduledActivityType.Override }
   * 
   */
  ScheduledActivityType.Override createScheduledActivityTypeOverride();

  /**
   * Create an instance of {@link ScheduledActivityType.TeacherList.TeacherCover
   * }
   * 
   */
  ScheduledActivityType.TeacherList.TeacherCover createScheduledActivityTypeTeacherListTeacherCover();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFOrderBy.SIFElement }
   * 
   */
  SIFExtendedQueryType.SIFOrderBy.SIFElement createSIFExtendedQueryTypeSIFOrderBySIFElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement
   * }
   * 
   */
  SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement createSIFExtendedQueryTypeSIFWhereSIFConditionGroupSIFConditionsSIFConditionSIFElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement }
   * 
   */
  SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement createSIFExtendedQueryTypeSIFFromSIFJoinSIFJoinOnSIFLeftElement();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement }
   * 
   */
  SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement createSIFExtendedQueryTypeSIFFromSIFJoinSIFJoinOnSIFRightElement();

  /**
   * Create an instance of {@link SIFExtendedQueryType.SIFSelect.SIFElement }
   * 
   */
  SIFExtendedQueryType.SIFSelect.SIFElement createSIFExtendedQueryTypeSIFSelectSIFElement();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType.AssetLearningStandards
   * }
   * 
   */
  Sif3AssessmentAssetType.AssetLearningStandards createSif3AssessmentAssetTypeAssetLearningStandards();

  /**
   * Create an instance of
   * {@link Sif3AssessmentAssetType.AssetIdentifiers.AssetIdentifier }
   * 
   */
  Sif3AssessmentAssetType.AssetIdentifiers.AssetIdentifier createSif3AssessmentAssetTypeAssetIdentifiersAssetIdentifier();

  /**
   * Create an instance of {@link SIFQueryType.SIFQueryObject }
   * 
   */
  SIFQueryType.SIFQueryObject createSIFQueryTypeSIFQueryObject();

  /**
   * Create an instance of
   * {@link SIFQueryType.SIFConditionGroup.SIFConditions.SIFCondition }
   * 
   */
  SIFQueryType.SIFConditionGroup.SIFConditions.SIFCondition createSIFQueryTypeSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of {@link StudentScoreSetType.Scores.Score }
   * 
   */
  StudentScoreSetType.Scores.Score createStudentScoreSetTypeScoresScore();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.ScoreReporting }
   * 
   */
  Sif3AssessmentSubTestType.ScoreReporting createSif3AssessmentSubTestTypeScoreReporting();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSubTestType.AssessmentSubTestRefIds }
   * 
   */
  Sif3AssessmentSubTestType.AssessmentSubTestRefIds createSif3AssessmentSubTestTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSubTestType.LearningStandardItemRefIds }
   * 
   */
  Sif3AssessmentSubTestType.LearningStandardItemRefIds createSif3AssessmentSubTestTypeLearningStandardItemRefIds();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSubTestType.AssessmentItems.AssessmentItem }
   * 
   */
  Sif3AssessmentSubTestType.AssessmentItems.AssessmentItem createSif3AssessmentSubTestTypeAssessmentItemsAssessmentItem();

  /**
   * Create an instance of
   * {@link Sif3AssessmentSubTestType.SubTestIdentifiers.SubTestIdentifier }
   * 
   */
  Sif3AssessmentSubTestType.SubTestIdentifiers.SubTestIdentifier createSif3AssessmentSubTestTypeSubTestIdentifiersSubTestIdentifier();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentDescriptors }
   * 
   */
  Sif3AssessmentType.AssessmentDescriptors createSif3AssessmentTypeAssessmentDescriptors();

  /**
   * Create an instance of {@link Sif3AssessmentType.LearningStandardItemRefIds
   * }
   * 
   */
  Sif3AssessmentType.LearningStandardItemRefIds createSif3AssessmentTypeLearningStandardItemRefIds();

  /**
   * Create an instance of
   * {@link Sif3AssessmentType.AssessmentItemBanks.AssessmentItemBank }
   * 
   */
  Sif3AssessmentType.AssessmentItemBanks.AssessmentItemBank createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBank();

  /**
   * Create an instance of
   * {@link Sif3AssessmentType.AssessmentIdentifiers.AssessmentIdentifier }
   * 
   */
  Sif3AssessmentType.AssessmentIdentifiers.AssessmentIdentifier createSif3AssessmentTypeAssessmentIdentifiersAssessmentIdentifier();

  /**
   * Create an instance of {@link AssessmentPackageType.XMLData }
   * 
   */
  AssessmentPackageType.XMLData createAssessmentPackageTypeXMLData();

  /**
   * Create an instance of {@link StudentParticipationType.ManagingSchool }
   * 
   */
  StudentParticipationType.ManagingSchool createStudentParticipationTypeManagingSchool();

  /**
   * Create an instance of {@link StudentParticipationType.ReferralSource }
   * 
   */
  StudentParticipationType.ReferralSource createStudentParticipationTypeReferralSource();

  /**
   * Create an instance of {@link StudentParticipationType.ProgramAvailability }
   * 
   */
  StudentParticipationType.ProgramAvailability createStudentParticipationTypeProgramAvailability();

  /**
   * Create an instance of
   * {@link StudentParticipationType.ProgramFundingSources.ProgramFundingSource
   * }
   * 
   */
  StudentParticipationType.ProgramFundingSources.ProgramFundingSource createStudentParticipationTypeProgramFundingSourcesProgramFundingSource();

  /**
   * Create an instance of {@link StudentSnapshotType.HomeEnrollment.Homeroom }
   * 
   */
  StudentSnapshotType.HomeEnrollment.Homeroom createStudentSnapshotTypeHomeEnrollmentHomeroom();

  /**
   * Create an instance of
   * {@link StudentSnapshotType.StudentSubjectChoiceList.StudentSubjectChoice }
   * 
   */
  StudentSnapshotType.StudentSubjectChoiceList.StudentSubjectChoice createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoice();

  /**
   * Create an instance of {@link SchoolContactListType.SchoolContact }
   * 
   */
  SchoolContactListType.SchoolContact createSchoolContactListTypeSchoolContact();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.ItemAids
   * }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.ItemAids createSif3StudentResponseSetTypeItemsItemItemAids();

  /**
   * Create an instance of
   * {@link Sif3StudentResponseSetType.Items.Item.FeedbackItems.FeedbackItem }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.FeedbackItems.FeedbackItem createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItem();

  /**
   * Create an instance of
   * {@link Sif3StudentResponseSetType.Items.Item.TraitScores.TraitScore }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.TraitScores.TraitScore createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScore();

  /**
   * Create an instance of
   * {@link Sif3StudentResponseSetType.Items.Item.Comments.Comment }
   * 
   */
  Sif3StudentResponseSetType.Items.Item.Comments.Comment createSif3StudentResponseSetTypeItemsItemCommentsComment();

  /**
   * Create an instance of {@link TimeTableSubjectType.AcademicYearRange }
   * 
   */
  TimeTableSubjectType.AcademicYearRange createTimeTableSubjectTypeAcademicYearRange();

  /**
   * Create an instance of {@link LearningStandardItemType.StandardSettingBody }
   * 
   */
  LearningStandardItemType.StandardSettingBody createLearningStandardItemTypeStandardSettingBody();

  /**
   * Create an instance of
   * {@link LearningStandardItemType.StandardHierarchyLevel }
   * 
   */
  LearningStandardItemType.StandardHierarchyLevel createLearningStandardItemTypeStandardHierarchyLevel();

  /**
   * Create an instance of {@link LearningStandardItemType.PredecessorItems }
   * 
   */
  LearningStandardItemType.PredecessorItems createLearningStandardItemTypePredecessorItems();

  /**
   * Create an instance of {@link LearningStandardItemType.StatementCodes }
   * 
   */
  LearningStandardItemType.StatementCodes createLearningStandardItemTypeStatementCodes();

  /**
   * Create an instance of {@link LearningStandardItemType.Statements }
   * 
   */
  LearningStandardItemType.Statements createLearningStandardItemTypeStatements();

  /**
   * Create an instance of
   * {@link LearningStandardItemType.RelatedLearningStandardItems.LearningStandardItemRefId
   * }
   * 
   */
  LearningStandardItemType.RelatedLearningStandardItems.LearningStandardItemRefId createLearningStandardItemTypeRelatedLearningStandardItemsLearningStandardItemRefId();

  /**
   * Create an instance of
   * {@link LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes
   * }
   * 
   */
  LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes();

  /**
   * Create an instance of
   * {@link LearningStandardItemType.Resources.LearningResourceRefId }
   * 
   */
  LearningStandardItemType.Resources.LearningResourceRefId createLearningStandardItemTypeResourcesLearningResourceRefId();

  /**
   * Create an instance of {@link SystemRoleType.SIFRefId }
   * 
   */
  SystemRoleType.SIFRefId createSystemRoleTypeSIFRefId();

  /**
   * Create an instance of
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId
   * }
   * 
   */
  SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId();

  /**
   * Create an instance of {@link EducationFilterType.LearningStandardItems }
   * 
   */
  EducationFilterType.LearningStandardItems createEducationFilterTypeLearningStandardItems();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions }
   * 
   */
  Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions createSif3AssessmentRubricTypeScoresScoreScoreDescriptions();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRubricType.Scores.Score.ScoreComments.ScoreComment }
   * 
   */
  Sif3AssessmentRubricType.Scores.Score.ScoreComments.ScoreComment createSif3AssessmentRubricTypeScoresScoreScoreCommentsScoreComment();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRubricType.RubricIdentifiers.RubricIdentifier }
   * 
   */
  Sif3AssessmentRubricType.RubricIdentifiers.RubricIdentifier createSif3AssessmentRubricTypeRubricIdentifiersRubricIdentifier();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceUsageContentType }
   * 
   */
  ResourceUsageType.ResourceUsageContentType createResourceUsageTypeResourceUsageContentType();

  /**
   * Create an instance of
   * {@link ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId
   * }
   * 
   */
  ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId();

  /**
   * Create an instance of
   * {@link ResourceUsageType.ResourceReportColumnList.ResourceReportColumn }
   * 
   */
  ResourceUsageType.ResourceReportColumnList.ResourceReportColumn createResourceUsageTypeResourceReportColumnListResourceReportColumn();

  /**
   * Create an instance of {@link StudentContactRelationshipType.HouseholdList }
   * 
   */
  StudentContactRelationshipType.HouseholdList createStudentContactRelationshipTypeHouseholdList();

  /**
   * Create an instance of {@link StudentContactRelationshipType.ContactFlags }
   * 
   */
  StudentContactRelationshipType.ContactFlags createStudentContactRelationshipTypeContactFlags();

  /**
   * Create an instance of {@link LearningStandardDocumentType.Organizations }
   * 
   */
  LearningStandardDocumentType.Organizations createLearningStandardDocumentTypeOrganizations();

  /**
   * Create an instance of {@link LearningStandardDocumentType.Authors }
   * 
   */
  LearningStandardDocumentType.Authors createLearningStandardDocumentTypeAuthors();

  /**
   * Create an instance of {@link LearningStandardDocumentType.SubjectAreas }
   * 
   */
  LearningStandardDocumentType.SubjectAreas createLearningStandardDocumentTypeSubjectAreas();

  /**
   * Create an instance of {@link LearningStandardDocumentType.Copyright }
   * 
   */
  LearningStandardDocumentType.Copyright createLearningStandardDocumentTypeCopyright();

  /**
   * Create an instance of
   * {@link LearningStandardDocumentType.RelatedLearningStandards }
   * 
   */
  LearningStandardDocumentType.RelatedLearningStandards createLearningStandardDocumentTypeRelatedLearningStandards();

  /**
   * Create an instance of {@link SchoolProgramsType.SchoolProgramList.Program }
   * 
   */
  SchoolProgramsType.SchoolProgramList.Program createSchoolProgramsTypeSchoolProgramListProgram();

  /**
   * Create an instance of
   * {@link StudentPeriodAttendanceType.AuditInfo.CreationUser }
   * 
   */
  StudentPeriodAttendanceType.AuditInfo.CreationUser createStudentPeriodAttendanceTypeAuditInfoCreationUser();

  /**
   * Create an instance of {@link AssessmentFormType.FormNumbers }
   * 
   */
  AssessmentFormType.FormNumbers createAssessmentFormTypeFormNumbers();

  /**
   * Create an instance of {@link AssessmentFormType.AssessmentSubTestRefIds }
   * 
   */
  AssessmentFormType.AssessmentSubTestRefIds createAssessmentFormTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom
   * }
   * 
   */
  Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRegistrationType.TestingStatuses.TestingStatus }
   * 
   */
  Sif3AssessmentRegistrationType.TestingStatuses.TestingStatus createSif3AssessmentRegistrationTypeTestingStatusesTestingStatus();

  /**
   * Create an instance of
   * {@link Sif3AssessmentRegistrationType.StudentSpecialEvents.StudentSpecialEvent
   * }
   * 
   */
  Sif3AssessmentRegistrationType.StudentSpecialEvents.StudentSpecialEvent createSif3AssessmentRegistrationTypeStudentSpecialEventsStudentSpecialEvent();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.ParentObjectRefId }
   * 
   */
  SummaryEnrollmentInfoType.ParentObjectRefId createSummaryEnrollmentInfoTypeParentObjectRefId();

  /**
   * Create an instance of
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student
   * }
   * 
   */
  SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent();

  /**
   * Create an instance of
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff
   * }
   * 
   */
  SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff();

  /**
   * Create an instance of
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList.Enrollment
   * }
   * 
   */
  SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList.Enrollment createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollment();

  /**
   * Create an instance of
   * {@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId }
   * 
   */
  SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId();

  /**
   * Create an instance of {@link OtherCodeListType.OtherCode }
   * 
   */
  OtherCodeListType.OtherCode createOtherCodeListTypeOtherCode();

  /**
   * Create an instance of
   * {@link StudentAttendanceTimeListType.AttendanceTimes.AttendanceTime }
   * 
   */
  StudentAttendanceTimeListType.AttendanceTimes.AttendanceTime createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTime();

  /**
   * Create an instance of
   * {@link PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount
   * }
   * 
   */
  PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccount();

  /**
   * Create an instance of {@link ResourceBookingType.ResourceRefId }
   * 
   */
  ResourceBookingType.ResourceRefId createResourceBookingTypeResourceRefId();

  /**
   * Create an instance of
   * {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.DerivedValue }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.DerivedValue createSif3AssessmentScoreTableTypeScoreValuesScoreValueDerivedValue();

  /**
   * Create an instance of
   * {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList.Feedback
   * }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList.Feedback createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedback();

  /**
   * Create an instance of
   * {@link Sif3AssessmentScoreTableType.ScoreTableIdentifiers.ScoreTableIdentifier
   * }
   * 
   */
  Sif3AssessmentScoreTableType.ScoreTableIdentifiers.ScoreTableIdentifier createSif3AssessmentScoreTableTypeScoreTableIdentifiersScoreTableIdentifier();

  /**
   * Create an instance of
   * {@link AssessmentRegistrationType.AssessmentStudentSnapshot }
   * 
   */
  AssessmentRegistrationType.AssessmentStudentSnapshot createAssessmentRegistrationTypeAssessmentStudentSnapshot();

  /**
   * Create an instance of
   * {@link AssessmentRegistrationType.StudentSpecialConditions.StudentSpecialCondition
   * }
   * 
   */
  AssessmentRegistrationType.StudentSpecialConditions.StudentSpecialCondition createAssessmentRegistrationTypeStudentSpecialConditionsStudentSpecialCondition();

  /**
   * Create an instance of {@link SectionInfoType.MediumOfInstruction }
   * 
   */
  SectionInfoType.MediumOfInstruction createSectionInfoTypeMediumOfInstruction();

  /**
   * Create an instance of {@link SectionInfoType.LanguageOfInstruction }
   * 
   */
  SectionInfoType.LanguageOfInstruction createSectionInfoTypeLanguageOfInstruction();

  /**
   * Create an instance of {@link SectionInfoType.LocationOfInstruction }
   * 
   */
  SectionInfoType.LocationOfInstruction createSectionInfoTypeLocationOfInstruction();

  /**
   * Create an instance of {@link SectionInfoType.SchoolCourseInfoOverride }
   * 
   */
  SectionInfoType.SchoolCourseInfoOverride createSectionInfoTypeSchoolCourseInfoOverride();

  /**
   * Create an instance of
   * {@link TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod }
   * 
   */
  TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriod();

  /**
   * Create an instance of
   * {@link TeachingGroupType.TeacherList.TeachingGroupTeacher }
   * 
   */
  TeachingGroupType.TeacherList.TeachingGroupTeacher createTeachingGroupTypeTeacherListTeachingGroupTeacher();

  /**
   * Create an instance of
   * {@link TeachingGroupType.StudentList.TeachingGroupStudent }
   * 
   */
  TeachingGroupType.StudentList.TeachingGroupStudent createTeachingGroupTypeStudentListTeachingGroupStudent();

  /**
   * Create an instance of {@link DemographicsType.CountriesOfCitizenship }
   * 
   */
  DemographicsType.CountriesOfCitizenship createDemographicsTypeCountriesOfCitizenship();

  /**
   * Create an instance of {@link DemographicsType.CountriesOfResidency }
   * 
   */
  DemographicsType.CountriesOfResidency createDemographicsTypeCountriesOfResidency();

  /**
   * Create an instance of {@link DemographicsType.DwellingArrangement }
   * 
   */
  DemographicsType.DwellingArrangement createDemographicsTypeDwellingArrangement();

  /**
   * Create an instance of {@link DemographicsType.Religion }
   * 
   */
  DemographicsType.Religion createDemographicsTypeReligion();

  /**
   * Create an instance of
   * {@link DemographicsType.ReligiousEventList.ReligiousEvent }
   * 
   */
  DemographicsType.ReligiousEventList.ReligiousEvent createDemographicsTypeReligiousEventListReligiousEvent();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsType.SIFRows.R }
   * 
   */
  SIFExtendedQueryResultsType.SIFRows.R createSIFExtendedQueryResultsTypeSIFRowsR();

  /**
   * Create an instance of
   * {@link SIFExtendedQueryResultsType.SIFColumnHeaders.SIFElement }
   * 
   */
  SIFExtendedQueryResultsType.SIFColumnHeaders.SIFElement createSIFExtendedQueryResultsTypeSIFColumnHeadersSIFElement();

  /**
   * Create an instance of {@link LanguageListType.Language }
   * 
   */
  LanguageListType.Language createLanguageListTypeLanguage();

  /**
   * Create an instance of {@link SchoolInfoType.OtherLEA }
   * 
   */
  SchoolInfoType.OtherLEA createSchoolInfoTypeOtherLEA();

  /**
   * Create an instance of {@link SchoolInfoType.SchoolFocusList }
   * 
   */
  SchoolInfoType.SchoolFocusList createSchoolInfoTypeSchoolFocusList();

  /**
   * Create an instance of {@link SchoolInfoType.Campus }
   * 
   */
  SchoolInfoType.Campus createSchoolInfoTypeCampus();

  /**
   * Create an instance of {@link SchoolInfoType.TotalEnrollments }
   * 
   */
  SchoolInfoType.TotalEnrollments createSchoolInfoTypeTotalEnrollments();

  /**
   * Create an instance of {@link SchoolInfoType.SchoolGroupList }
   * 
   */
  SchoolInfoType.SchoolGroupList createSchoolInfoTypeSchoolGroupList();

  /**
   * Create an instance of
   * {@link SchoolInfoType.YearLevelEnrollmentList.YearLevelEnrollment }
   * 
   */
  SchoolInfoType.YearLevelEnrollmentList.YearLevelEnrollment createSchoolInfoTypeYearLevelEnrollmentListYearLevelEnrollment();

  /**
   * Create an instance of {@link SchoolInfoType.OtherIdList.OtherId }
   * 
   */
  SchoolInfoType.OtherIdList.OtherId createSchoolInfoTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }
   * {@code >}}
   * 
   */
  JAXBElement<SubjectAreaType> createSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailListType> createEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestCollectionType> createSif3AssessmentSubTests(Sif3AssessmentSubTestCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffAssignmentType }{@code >}}
   * 
   */
  JAXBElement<StaffAssignmentType> createStaffAssignment(StaffAssignmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityType }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityType> createScheduledActivity(ScheduledActivityType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPersonalCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentPersonalCollectionType> createStudentPersonals(StudentPersonalCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFContext(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemAssociationType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemAssociationType> createSif3AssessmentItemAssociation(Sif3AssessmentItemAssociationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportAuthorityInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<ReportAuthorityInfoCollectionType> createReportAuthorityInfos(ReportAuthorityInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentScoreSetCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentScoreSetCollectionType> createStudentScoreSets(StudentScoreSetCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourcePackageType }{@code >}}
   * 
   */
  JAXBElement<LearningResourcePackageType> createLearningResourcePackage(LearningResourcePackageType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFQueryType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFQueryType> createSIFQuery(SIFQueryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemAssociationCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemAssociationCollectionType> createSif3AssessmentItemAssociations(Sif3AssessmentItemAssociationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedQueryType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedQueryType> createSIFExtendedQuery(SIFExtendedQueryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAssetType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAssetType> createSif3AssessmentAsset(Sif3AssessmentAssetType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ChargedLocationInfoType }{@code >}}
   * 
   */
  JAXBElement<ChargedLocationInfoType> createChargedLocationInfo(ChargedLocationInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType }
   * {@code >}}
   * 
   */
  JAXBElement<ActivityType> createActivity(ActivityType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TimeTableSubjectCollectionType }{@code >}}
   * 
   */
  JAXBElement<TimeTableSubjectCollectionType> createTimeTableSubjects(TimeTableSubjectCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentFormCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentFormCollectionType> createAssessmentForms(AssessmentFormCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentRegistrationCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentRegistrationCollectionType> createAssessmentRegistrations(AssessmentRegistrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentActivityInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentActivityInfoCollectionType> createStudentActivityInfos(StudentActivityInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType> createStudentSchoolEnrollment(StudentSchoolEnrollmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSubjectAreaList(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TeachingGroupCollectionType }{@code >}}
   * 
   */
  JAXBElement<TeachingGroupCollectionType> createTeachingGroups(TeachingGroupCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EquipmentInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<EquipmentInfoCollectionType> createEquipmentInfos(EquipmentInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link CalendarSummaryCollectionType }{@code >}}
   * 
   */
  JAXBElement<CalendarSummaryCollectionType> createCalendarSummarys(CalendarSummaryCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DebtorType }
   * {@code >}}
   * 
   */
  JAXBElement<DebtorType> createDebtor(DebtorType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactRelationshipCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentContactRelationshipCollectionType> createStudentContactRelationships(StudentContactRelationshipCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SummaryEnrollmentInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<SummaryEnrollmentInfoCollectionType> createSummaryEnrollmentInfos(SummaryEnrollmentInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportManifestCollectionType }{@code >}}
   * 
   */
  JAXBElement<ReportManifestCollectionType> createReportManifests(ReportManifestCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType }
   * {@code >}}
   * 
   */
  JAXBElement<LifeCycleType> createLifeCycle(LifeCycleType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAdministrationType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAdministrationType> createSif3AssessmentAdministration(Sif3AssessmentAdministrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link JournalCollectionType }{@code >}}
   * 
   */
  JAXBElement<JournalCollectionType> createJournals(JournalCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStateProvince(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentParticipationCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentParticipationCollectionType> createStudentParticipations(StudentParticipationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportManifestType }{@code >}}
   * 
   */
  JAXBElement<ReportManifestType> createReportManifest(ReportManifestType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersonPictureType
   * }{@code >}}
   * 
   */
  JAXBElement<PersonPictureType> createPersonPicture(PersonPictureType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentDailyAttendanceCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentDailyAttendanceCollectionType> createStudentDailyAttendances(StudentDailyAttendanceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffCollectionType }{@code >}}
   * 
   */
  JAXBElement<StaffCollectionType> createStaffPersonals(StaffCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRubricCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRubricCollectionType> createSif3AssessmentRubrics(Sif3AssessmentRubricCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateStatisticInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<AggregateStatisticInfoCollectionType> createAggregateStatisticInfos(AggregateStatisticInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createEducationalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ACStrandSubjectAreaType }{@code >}}
   * 
   */
  JAXBElement<ACStrandSubjectAreaType> createACStrandSubjectArea(ACStrandSubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createSIFEncryptionLevel(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourcePackageCollectionType }{@code >}}
   * 
   */
  JAXBElement<LearningResourcePackageCollectionType> createLearningResourcePackages(LearningResourcePackageCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType> createLearningResource(LearningResourceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType> createSif3AssessmentItem(Sif3AssessmentItemType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateStatisticInfoType }{@code >}}
   * 
   */
  JAXBElement<AggregateStatisticInfoType> createAggregateStatisticInfo(AggregateStatisticInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link FinancialAccountType }{@code >}}
   * 
   */
  JAXBElement<FinancialAccountType> createFinancialAccount(FinancialAccountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateStatisticFactType }{@code >}}
   * 
   */
  JAXBElement<AggregateStatisticFactType> createAggregateStatisticFact(AggregateStatisticFactType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link IdentityCollectionType }{@code >}}
   * 
   */
  JAXBElement<IdentityCollectionType> createIdentitys(IdentityCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateCharacteristicInfoType }{@code >}}
   * 
   */
  JAXBElement<AggregateCharacteristicInfoType> createAggregateCharacteristicInfo(AggregateCharacteristicInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createPublishInDirectory(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestType }{@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestType> createAssessmentSubTest(AssessmentSubTestType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link JournalType }
   * {@code >}}
   * 
   */
  JAXBElement<JournalType> createJournal(JournalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType }
   * {@code >}}
   * 
   */
  JAXBElement<StudentSDTNType> createStudentSDTN(StudentSDTNType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link GradingAssignmentType }{@code >}}
   * 
   */
  JAXBElement<GradingAssignmentType> createGradingAssignment(GradingAssignmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link VendorInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<VendorInfoCollectionType> createVendorInfos(VendorInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PaymentReceiptType }{@code >}}
   * 
   */
  JAXBElement<PaymentReceiptType> createPaymentReceipt(PaymentReceiptType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentCollectionType> createSif3Assessments(Sif3AssessmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeElementType }
   * {@code >}}
   * 
   */
  JAXBElement<TimeElementType> createTimeElement(TimeElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentType }
   * {@code >}}
   * 
   */
  JAXBElement<AssessmentType> createAssessment(AssessmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SessionInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<SessionInfoType> createSessionInfo(SessionInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType> createSif3AssessmentForm(Sif3AssessmentFormType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentItemType }{@code >}}
   * 
   */
  JAXBElement<AssessmentItemType> createAssessmentItem(AssessmentItemType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableType }
   * {@code >}}
   * 
   */
  JAXBElement<TimeTableType> createTimeTable(TimeTableType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFContextsType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFContextsType> createSIFContexts(SIFContextsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPersonalType }{@code >}}
   * 
   */
  JAXBElement<StudentPersonalType> createStudentPersonal(StudentPersonalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactPersonalType }{@code >}}
   * 
   */
  JAXBElement<StudentContactPersonalType> createStudentContactPersonal(StudentContactPersonalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentActivityInfoType }{@code >}}
   * 
   */
  JAXBElement<StudentActivityInfoType> createStudentActivityInfo(StudentActivityInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RoomInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<RoomInfoType> createRoomInfo(RoomInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentPackageCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentPackageCollectionType> createAssessmentPackages(AssessmentPackageCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentActivityParticipationType }{@code >}}
   * 
   */
  JAXBElement<StudentActivityParticipationType> createStudentActivityParticipation(StudentActivityParticipationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestCollectionType> createAssessmentSubTests(AssessmentSubTestCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RelationshipType
   * }{@code >}}
   * 
   */
  JAXBElement<RelationshipType> createRelationship(RelationshipType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemCollectionType> createSif3AssessmentItems(Sif3AssessmentItemCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolProgramsCollectionType }{@code >}}
   * 
   */
  JAXBElement<SchoolProgramsCollectionType> createSchoolProgramss(SchoolProgramsCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link GradingAssignmentScoreType }{@code >}}
   * 
   */
  JAXBElement<GradingAssignmentScoreType> createGradingAssignmentScore(GradingAssignmentScoreType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3StudentResponseSetCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3StudentResponseSetCollectionType> createSif3StudentResponseSets(Sif3StudentResponseSetCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link InvoiceType }
   * {@code >}}
   * 
   */
  JAXBElement<InvoiceType> createInvoice(InvoiceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemCollectionType }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemCollectionType> createLearningStandardItems(LearningStandardItemCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link VendorInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<VendorInfoType> createVendorInfo(VendorInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSectionType> createSif3AssessmentSection(Sif3AssessmentSectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link GradingAssignmentCollectionType }{@code >}}
   * 
   */
  JAXBElement<GradingAssignmentCollectionType> createGradingAssignments(GradingAssignmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link DebtorCollectionType }{@code >}}
   * 
   */
  JAXBElement<DebtorCollectionType> createDebtors(DebtorCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EnglishProficiencyType }{@code >}}
   * 
   */
  JAXBElement<EnglishProficiencyType> createEnglishProficiency(EnglishProficiencyType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSessionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSessionType> createSif3AssessmentSession(Sif3AssessmentSessionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentAdministrationType }{@code >}}
   * 
   */
  JAXBElement<AssessmentAdministrationType> createAssessmentAdministration(AssessmentAdministrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarDate }
   * {@code >}}
   * 
   */
  JAXBElement<CalendarDate> createCalendarDate(CalendarDate value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAdministrationCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAdministrationCollectionType> createSif3AssessmentAdministrations(Sif3AssessmentAdministrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffPersonalType
   * }{@code >}}
   * 
   */
  JAXBElement<StaffPersonalType> createStaffPersonal(StaffPersonalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PrincipalInfoType
   * }{@code >}}
   * 
   */
  JAXBElement<PrincipalInfoType> createPrincipalInfo(PrincipalInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EquipmentInfoType
   * }{@code >}}
   * 
   */
  JAXBElement<EquipmentInfoType> createEquipmentInfo(EquipmentInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link IdentityType }
   * {@code >}}
   * 
   */
  JAXBElement<IdentityType> createIdentity(IdentityType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SessionInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<SessionInfoCollectionType> createSessionInfos(SessionInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }
   * {@code >}}
   * 
   */
  JAXBElement<NameType> createName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFReportObjectCollectionType }{@code >}}
   * 
   */
  JAXBElement<SIFReportObjectCollectionType> createSIFReportObjects(SIFReportObjectCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityCollectionType }{@code >}}
   * 
   */
  JAXBElement<ActivityCollectionType> createActivitys(ActivityCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LEAInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<LEAInfoType> createLEAInfo(LEAInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsOperationalStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsOperationalStatusType> createOperationalStatus(AUCodeSetsOperationalStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PurchaseOrderCollectionType }{@code >}}
   * 
   */
  JAXBElement<PurchaseOrderCollectionType> createPurchaseOrders(PurchaseOrderCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoCollectionType> createSchoolInfos(SchoolInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSectionCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSectionCollectionType> createSif3AssessmentSections(Sif3AssessmentSectionCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createOnTimeGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }
   * {@code >}}
   * 
   */
  JAXBElement<LocationType> createLocation(LocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TermInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<TermInfoCollectionType> createTermInfos(TermInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TeachingGroupType
   * }{@code >}}
   * 
   */
  JAXBElement<TeachingGroupType> createTeachingGroup(TeachingGroupType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link CalendarSummaryType }{@code >}}
   * 
   */
  JAXBElement<CalendarSummaryType> createCalendarSummary(CalendarSummaryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSnapshotCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentSnapshotCollectionType> createStudentSnapshots(StudentSnapshotCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<SectionInfoType> createSectionInfo(SectionInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PaymentReceiptCollectionType }{@code >}}
   * 
   */
  JAXBElement<PaymentReceiptCollectionType> createPaymentReceipts(PaymentReceiptCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createProjectedGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<SchoolInfoType> createSchoolInfo(SchoolInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType
   * }{@code >}}
   * 
   */
  JAXBElement<DemographicsType> createDemographics(DemographicsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedQueryResultsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedQueryResultsType> createSIFExtendedQueryResults(SIFExtendedQueryResultsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType
   * }{@code >}}
   * 
   */
  JAXBElement<LanguageListType> createLanguageList(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailType> createEmail(EmailType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentAttendanceTimeListType }{@code >}}
   * 
   */
  JAXBElement<StudentAttendanceTimeListType> createStudentAttendanceTimeList(StudentAttendanceTimeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherNamesType }
   * {@code >}}
   * 
   */
  JAXBElement<OtherNamesType> createOtherNames(OtherNamesType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentScoreTableType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentScoreTableType> createSif3AssessmentScoreTable(Sif3AssessmentScoreTableType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentRegistrationType }{@code >}}
   * 
   */
  JAXBElement<AssessmentRegistrationType> createAssessmentRegistration(AssessmentRegistrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolCourseInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<SchoolCourseInfoCollectionType> createSchoolCourseInfos(SchoolCourseInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseOrderType
   * }{@code >}}
   * 
   */
  JAXBElement<PurchaseOrderType> createPurchaseOrder(PurchaseOrderType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ResourceBookingType }{@code >}}
   * 
   */
  JAXBElement<ResourceBookingType> createResourceBooking(ResourceBookingType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createCountry(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }
   * {@code >}}
   * 
   */
  JAXBElement<PhoneNumberType> createPhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSessionCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSessionCollectionType> createSif3AssessmentSessions(Sif3AssessmentSessionCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffAssignmentCollectionType }{@code >}}
   * 
   */
  JAXBElement<StaffAssignmentCollectionType> createStaffAssignments(StaffAssignmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createPhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRegistrationType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRegistrationType> createSif3AssessmentRegistration(Sif3AssessmentRegistrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SummaryEnrollmentInfoType }{@code >}}
   * 
   */
  JAXBElement<SummaryEnrollmentInfoType> createSummaryEnrollmentInfo(SummaryEnrollmentInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPeriodAttendanceType }{@code >}}
   * 
   */
  JAXBElement<StudentPeriodAttendanceType> createStudentPeriodAttendance(StudentPeriodAttendanceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolProgramsType }{@code >}}
   * 
   */
  JAXBElement<SchoolProgramsType> createSchoolPrograms(SchoolProgramsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateStatisticFactCollectionType }{@code >}}
   * 
   */
  JAXBElement<AggregateStatisticFactCollectionType> createAggregateStatisticFacts(AggregateStatisticFactCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentAttendanceSummaryType }{@code >}}
   * 
   */
  JAXBElement<StudentAttendanceSummaryType> createStudentAttendanceSummary(StudentAttendanceSummaryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentFormType }{@code >}}
   * 
   */
  JAXBElement<AssessmentFormType> createAssessmentForm(AssessmentFormType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFReportObjectType }{@code >}}
   * 
   */
  JAXBElement<SIFReportObjectType> createSIFReportObject(SIFReportObjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentAdministrationCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentAdministrationCollectionType> createAssessmentAdministrations(AssessmentAdministrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicIdType
   * }{@code >}}
   * 
   */
  JAXBElement<ElectronicIdType> createElectronicId(ElectronicIdType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRubricType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRubricType> createSif3AssessmentRubric(Sif3AssessmentRubricType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ElectronicIdListType }{@code >}}
   * 
   */
  JAXBElement<ElectronicIdListType> createElectronicIdList(ElectronicIdListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EducationFilterType }{@code >}}
   * 
   */
  JAXBElement<EducationFilterType> createEducationFilter(EducationFilterType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ResourceUsageCollectionType }{@code >}}
   * 
   */
  JAXBElement<ResourceUsageCollectionType> createResourceUsages(ResourceUsageCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentScoreTableCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentScoreTableCollectionType> createSif3AssessmentScoreTables(Sif3AssessmentScoreTableCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AttendanceCodeType }{@code >}}
   * 
   */
  JAXBElement<AttendanceCodeType> createAttendanceCode(AttendanceCodeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardDocumentType }{@code >}}
   * 
   */
  JAXBElement<LearningStandardDocumentType> createLearningStandardDocument(LearningStandardDocumentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateCharacteristicInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<AggregateCharacteristicInfoCollectionType> createAggregateCharacteristicInfos(AggregateCharacteristicInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createSIFAuthenticationLevel(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ResourceUsageType
   * }{@code >}}
   * 
   */
  JAXBElement<ResourceUsageType> createResourceUsage(ResourceUsageType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactRelationshipType }{@code >}}
   * 
   */
  JAXBElement<StudentContactRelationshipType> createStudentContactRelationship(StudentContactRelationshipType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType> createLearningStandardItem(LearningStandardItemType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardDocumentCollectionType }{@code >}}
   * 
   */
  JAXBElement<LearningStandardDocumentCollectionType> createLearningStandardDocuments(LearningStandardDocumentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableCellType
   * }{@code >}}
   * 
   */
  JAXBElement<TimeTableCellType> createTimeTableCell(TimeTableCellType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentAttendanceTimeListCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentAttendanceTimeListCollectionType> createStudentAttendanceTimeLists(StudentAttendanceTimeListCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentActivityParticipationCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentActivityParticipationCollectionType> createStudentActivityParticipations(StudentActivityParticipationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SystemRoleType }
   * {@code >}}
   * 
   */
  JAXBElement<SystemRoleType> createSystemRole(SystemRoleType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TimeTableCellCollectionType }{@code >}}
   * 
   */
  JAXBElement<TimeTableCellCollectionType> createTimeTableCells(TimeTableCellCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ChargedLocationInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<ChargedLocationInfoCollectionType> createChargedLocationInfos(ChargedLocationInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link RoomInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<RoomInfoCollectionType> createRoomInfos(RoomInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentItemCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentItemCollectionType> createAssessmentItems(AssessmentItemCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ResourceBookingCollectionType }{@code >}}
   * 
   */
  JAXBElement<ResourceBookingCollectionType> createResourceBookings(ResourceBookingCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormCollectionType> createSif3AssessmentForms(Sif3AssessmentFormCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolContactListType }{@code >}}
   * 
   */
  JAXBElement<SchoolContactListType> createSchoolContactList(SchoolContactListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TermInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<TermInfoType> createTermInfo(TermInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link CalendarDateCollectionType }{@code >}}
   * 
   */
  JAXBElement<CalendarDateCollectionType> createCalendarDates(CalendarDateCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPeriodAttendanceCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentPeriodAttendanceCollectionType> createStudentPeriodAttendances(StudentPeriodAttendanceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSnapshotType }{@code >}}
   * 
   */
  JAXBElement<StudentSnapshotType> createStudentSnapshot(StudentSnapshotType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<ContactInfoType> createContactInfo(ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3StudentResponseSetType }{@code >}}
   * 
   */
  JAXBElement<Sif3StudentResponseSetType> createSif3StudentResponseSet(Sif3StudentResponseSetType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TimeTableSubjectType }{@code >}}
   * 
   */
  JAXBElement<TimeTableSubjectType> createTimeTableSubject(TimeTableSubjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAssetCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAssetCollectionType> createSif3AssessmentAssets(Sif3AssessmentAssetCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSectionEnrollmentCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentSectionEnrollmentCollectionType> createStudentSectionEnrollments(StudentSectionEnrollmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestType> createSif3AssessmentSubTest(Sif3AssessmentSubTestType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentCollectionType> createStudentSchoolEnrollments(StudentSchoolEnrollmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentCollectionType }{@code >}}
   * 
   */
  JAXBElement<AssessmentCollectionType> createAssessments(AssessmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentType> createSif3Assessment(Sif3AssessmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceCollectionType }{@code >}}
   * 
   */
  JAXBElement<LearningResourceCollectionType> createLearningResources(LearningResourceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LEAInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<LEAInfoCollectionType> createLEAInfos(LEAInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityCollectionType }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityCollectionType> createScheduledActivitys(ScheduledActivityCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GridLocationType
   * }{@code >}}
   * 
   */
  JAXBElement<GridLocationType> createGridLocation(GridLocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SystemRoleCollectionType }{@code >}}
   * 
   */
  JAXBElement<SystemRoleCollectionType> createSystemRoles(SystemRoleCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SectionInfoCollectionType }{@code >}}
   * 
   */
  JAXBElement<SectionInfoCollectionType> createSectionInfos(SectionInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentParticipationType }{@code >}}
   * 
   */
  JAXBElement<StudentParticipationType> createStudentParticipation(StudentParticipationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentAttendanceSummaryCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentAttendanceSummaryCollectionType> createStudentAttendanceSummarys(StudentAttendanceSummaryCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportAuthorityInfoType }{@code >}}
   * 
   */
  JAXBElement<ReportAuthorityInfoType> createReportAuthorityInfo(ReportAuthorityInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentPackageType }{@code >}}
   * 
   */
  JAXBElement<AssessmentPackageType> createAssessmentPackage(AssessmentPackageType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PersonPictureCollectionType }{@code >}}
   * 
   */
  JAXBElement<PersonPictureCollectionType> createPersonPictures(PersonPictureCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentContactCollectionType> createStudentContactPersonals(StudentContactCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link InvoiceCollectionType }{@code >}}
   * 
   */
  JAXBElement<InvoiceCollectionType> createInvoices(InvoiceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link FinancialAccountCollectionType }{@code >}}
   * 
   */
  JAXBElement<FinancialAccountCollectionType> createFinancialAccounts(FinancialAccountCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ProgramStatusType
   * }{@code >}}
   * 
   */
  JAXBElement<ProgramStatusType> createProgramStatus(ProgramStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersonInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<PersonInfoType> createPersonInfo(PersonInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentScoreSetType }{@code >}}
   * 
   */
  JAXBElement<StudentScoreSetType> createStudentScoreSet(StudentScoreSetType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSectionEnrollmentType }{@code >}}
   * 
   */
  JAXBElement<StudentSectionEnrollmentType> createStudentSectionEnrollment(StudentSectionEnrollmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolCourseInfoType }{@code >}}
   * 
   */
  JAXBElement<SchoolCourseInfoType> createSchoolCourseInfo(SchoolCourseInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link GradingAssignmentScoreCollectionType }{@code >}}
   * 
   */
  JAXBElement<GradingAssignmentScoreCollectionType> createGradingAssignmentScores(GradingAssignmentScoreCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentDailyAttendanceType }{@code >}}
   * 
   */
  JAXBElement<StudentDailyAttendanceType> createStudentDailyAttendance(StudentDailyAttendanceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSDTNCollectionType }{@code >}}
   * 
   */
  JAXBElement<StudentSDTNCollectionType> createStudentSDTNs(StudentSDTNCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRegistrationCollectionType }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRegistrationCollectionType> createSif3AssessmentRegistrations(Sif3AssessmentRegistrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TimeTableCollectionType }{@code >}}
   * 
   */
  JAXBElement<TimeTableCollectionType> createTimeTables(TimeTableCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }
   * {@code >}}
   * 
   */
  JAXBElement<SubjectAreaType> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsSchoolLevelType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeCampusCampusType(AUCodeSetsSchoolLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeCampusParentSchoolId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeTechnicalRequirementsTechnicalRequirement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }
   * {@code >}}
   * 
   */
  JAXBElement<SubjectAreaType> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createRelationshipTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackSource(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardItemTypeStandardIdentifierBenchmark(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardItemTypeStandardIdentifierIndicatorNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createLearningStandardItemTypeStandardIdentifierYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes
   * }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes> createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes(
      LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentScoreTableTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentScoreTableTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentScoreTableType.ScoreValues }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentScoreTableType.ScoreValues> createSif3AssessmentScoreTableTypeScoreValues(Sif3AssessmentScoreTableType.ScoreValues value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentScoreTableTypeScoreTableVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentScoreTableTypeScoreTablePublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentScoreTableType.ScoreTableIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentScoreTableType.ScoreTableIdentifiers> createSif3AssessmentScoreTableTypeScoreTableIdentifiers(Sif3AssessmentScoreTableType.ScoreTableIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentSubTestTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentSubTestTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestType.LearningStandardItemRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestType.LearningStandardItemRefIds> createSif3AssessmentSubTestTypeLearningStandardItemRefIds(Sif3AssessmentSubTestType.LearningStandardItemRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSubTestTypeSubTestVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createSif3AssessmentSubTestTypeNumberOfItems(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSubTestTypeAbbreviation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createSif3AssessmentSubTestTypeSubTestGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestType.AssessmentSubTestRefIds> createSif3AssessmentSubTestTypeAssessmentSubTestRefIds(Sif3AssessmentSubTestType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestType.ScoreReporting }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestType.ScoreReporting> createSif3AssessmentSubTestTypeScoreReporting(Sif3AssessmentSubTestType.ScoreReporting value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }
   * {@code >}}
   * 
   */
  JAXBElement<Boolean> createSif3AssessmentSubTestTypeContainerOnly(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSif3AssessmentSubTestTypeSubTestSubjectAreas(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createSif3AssessmentSubTestTypeSubTestTier(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSubTestTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentSubTestTypeSubTestPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestType.SubTestIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestType.SubTestIdentifiers> createSif3AssessmentSubTestTypeSubTestIdentifiers(Sif3AssessmentSubTestType.SubTestIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSubTestType.AssessmentItems }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSubTestType.AssessmentItems> createSif3AssessmentSubTestTypeAssessmentItems(Sif3AssessmentSubTestType.AssessmentItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createPurchaseOrderTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createPurchaseOrderTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypeChargedLocationInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypeOriginalPurchaseOrderRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypeEmployeePersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createPurchaseOrderTypeTotalAmount(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createPurchaseOrderTypeTaxRate(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createPurchaseOrderTypeCreationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createPurchaseOrderTypeUpdateDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createPurchaseOrderTypeTaxAmount(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createPurchaseOrderTypeFullyDelivered(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createIdentityTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createIdentityTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createIdentityTypeAuthenticationSourceGlobalUID(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link IdentityType.PasswordList }{@code >}}
   * 
   */
  JAXBElement<IdentityType.PasswordList> createIdentityTypePasswordList(IdentityType.PasswordList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link IdentityType.IdentityAssertions }{@code >}}
   * 
   */
  JAXBElement<IdentityType.IdentityAssertions> createIdentityTypeIdentityAssertions(IdentityType.IdentityAssertions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createTimeTableCellTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createTimeTableCellTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeTeachingGroupLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeRoomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeTimeTableLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeStaffLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableCellTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailListType> createContactInfoTypeEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createContactInfoTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createContactInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createContactInfoTypePositionTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createContactInfoTypeRole(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypePurchasingItemsPurchasingItemQuantity(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createInvoiceTypePurchasingItemsPurchasingItemUnitCost(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypePurchasingItemsPurchasingItemItemNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeExitTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTimeAttendanceNote(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentAttendanceTimeListTypeAttendanceTimesAttendanceTimeDurationValue(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAggregateStatisticFactTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAggregateStatisticFactTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAggregateStatisticFactTypeExcluded(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createRoomInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createRoomInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createRoomInfoTypeBuilding(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createRoomInfoTypeRoomType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createRoomInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createRoomInfoTypeSize(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createRoomInfoTypeHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }
   * {@code >}}
   * 
   */
  JAXBElement<PhoneNumberType> createRoomInfoTypePhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createRoomInfoTypeCapacity(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createRoomInfoTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link RoomInfoType.StaffList }{@code >}}
   * 
   */
  JAXBElement<RoomInfoType.StaffList> createRoomInfoTypeStaffList(RoomInfoType.StaffList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccountAccountingPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccountFinancialAccountRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeResponseChoicesChoiceChoiceLabel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
   * 
   */
  JAXBElement<Float> createSif3AssessmentItemTypeResponseChoicesChoiceCreditValue(Float value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeResponseChoicesChoiceResponseFeedback(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardDocumentTypeCopyrightHolder(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeCopyrightDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createEnglishProficiencyTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffAssignmentTypeStaffSubjectListStaffSubjectTimeTableSubjectRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffAssignmentTypeStaffSubjectListStaffSubjectSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createTimeTableTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createTimeTableTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTimeTableTypeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTimeTableTypeEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createTimeTableTypeTeachingPeriodsPerDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableCreationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeSchoolName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolContactListTypeSchoolContactPublishInDirectory(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFMetadataType.TimeElements }{@code >}}
   * 
   */
  JAXBElement<SIFMetadataType.TimeElements> createSIFMetadataTypeTimeElements(SIFMetadataType.TimeElements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EducationFilterType }{@code >}}
   * 
   */
  JAXBElement<EducationFilterType> createSIFMetadataTypeEducationFilter(EducationFilterType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType }
   * {@code >}}
   * 
   */
  JAXBElement<LifeCycleType> createSIFMetadataTypeLifeCycle(LifeCycleType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentFormTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentFormTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentFormTypeFormPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType.AssessmentSections }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType.AssessmentSections> createSif3AssessmentFormTypeAssessmentSections(Sif3AssessmentFormType.AssessmentSections value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType.AssessmentAssetRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType.AssessmentAssetRefIds> createSif3AssessmentFormTypeAssessmentAssetRefIds(Sif3AssessmentFormType.AssessmentAssetRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType.AssessmentPlatforms }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType.AssessmentPlatforms> createSif3AssessmentFormTypeAssessmentPlatforms(Sif3AssessmentFormType.AssessmentPlatforms value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentFormTypeLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType.AssessmentSubTestRefIds> createSif3AssessmentFormTypeAssessmentSubTestRefIds(Sif3AssessmentFormType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentFormTypeAssessmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSif3AssessmentFormTypeAssessmentFormSubjects(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType
   * }{@code >}}
   * 
   */
  JAXBElement<LanguageListType> createSif3AssessmentFormTypeAssessmentFormLanguages(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentFormTypePeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createSif3AssessmentFormTypeGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentFormTypeFormVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType.FormIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType.FormIdentifiers> createSif3AssessmentFormTypeFormIdentifiers(Sif3AssessmentFormType.FormIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentFormType.FormAccommodations }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentFormType.FormAccommodations> createSif3AssessmentFormTypeFormAccommodations(Sif3AssessmentFormType.FormAccommodations value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createTimeElementTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TimeElementType.SpanGaps }{@code >}}
   * 
   */
  JAXBElement<TimeElementType.SpanGaps> createTimeElementTypeSpanGaps(TimeElementType.SpanGaps value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createTimeElementTypeEndDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createTimeTableSubjectTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createTimeTableSubjectTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeSubjectShortName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMaxClassSize(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeSchoolCourseInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeCourseLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeSubjectType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMinClassSize(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableSubjectTypeFaculty(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createTimeTableSubjectTypeSemester(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TimeTableSubjectType.AcademicYearRange }{@code >}}
   * 
   */
  JAXBElement<TimeTableSubjectType.AcademicYearRange> createTimeTableSubjectTypeAcademicYearRange(TimeTableSubjectType.AcademicYearRange value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createTimeTableSubjectTypeAcademicYear(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTimeTableSubjectTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createTimeTableSubjectTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypePurchasingItemsPurchasingItemQuantity(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createPurchaseOrderTypePurchasingItemsPurchasingItemUnitCost(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createPurchaseOrderTypePurchasingItemsPurchasingItemTaxRate(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypePurchasingItemsPurchasingItemQuantityDelivered(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPurchaseOrderTypePurchasingItemsPurchasingItemItemNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts }
   * {@code >}}
   * 
   */
  JAXBElement<PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts> createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccounts(PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createPurchaseOrderTypePurchasingItemsPurchasingItemCancelledOrder(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createPurchaseOrderTypePurchasingItemsPurchasingItemTotalCost(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypePreviousSchoolsListPreviousSchoolReasonLeft(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentItemTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.ResponseChoices }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.ResponseChoices> createSif3AssessmentItemTypeResponseChoices(Sif3AssessmentItemType.ResponseChoices value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentItemTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentItemTypeItemPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.AssessmentItemAssetRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.AssessmentItemAssetRefIds> createSif3AssessmentItemTypeAssessmentItemAssetRefIds(Sif3AssessmentItemType.AssessmentItemAssetRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackHint(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackIncorrect(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.AssessmentIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.AssessmentIdentifiers> createSif3AssessmentItemTypeAssessmentIdentifiers(Sif3AssessmentItemType.AssessmentIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackCorrect(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemScoreMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSif3AssessmentItemTypeAssessmentSubjects(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType
   * }{@code >}}
   * 
   */
  JAXBElement<LanguageListType> createSif3AssessmentItemTypeAssessmentLanguages(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AbstractContentElementType }{@code >}}
   * 
   */
  JAXBElement<AbstractContentElementType> createSif3AssessmentItemTypeStem(AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createSif3AssessmentItemTypeAssessmentGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.ItemRubricIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.ItemRubricIds> createSif3AssessmentItemTypeItemRubricIds(Sif3AssessmentItemType.ItemRubricIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentItemTypeItemScoreMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.AssessmentItemBanks }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.AssessmentItemBanks> createSif3AssessmentItemTypeAssessmentItemBanks(Sif3AssessmentItemType.AssessmentItemBanks value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.AssessmentItemPlatforms }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.AssessmentItemPlatforms> createSif3AssessmentItemTypeAssessmentItemPlatforms(Sif3AssessmentItemType.AssessmentItemPlatforms value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentItemType.LearningStandardItems }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentItemType.LearningStandardItems> createSif3AssessmentItemTypeLearningStandardItems(Sif3AssessmentItemType.LearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeSectionItemsSectionItemItemSequence(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount
   * }{@code >}}
   * 
   */
  JAXBElement<PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount> createPurchaseOrderTypePurchasingItemsPurchasingItemExpenseAccountsExpenseAccount(
      PurchaseOrderType.PurchasingItems.PurchasingItem.ExpenseAccounts.ExpenseAccount value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStaffAssignmentTypeStaffActivityOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createReportAuthorityInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createReportAuthorityInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createReportAuthorityInfoTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createReportAuthorityInfoTypeAuthorityDepartment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }
   * {@code >}}
   * 
   */
  JAXBElement<PhoneNumberType> createReportAuthorityInfoTypePhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<ContactInfoType> createReportAuthorityInfoTypeContactInfo(ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodUseInAttendanceCalculations(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodRegularSchoolPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodInstructionalMinutes(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createLearningStandardDocumentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createLearningStandardDocumentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createLearningStandardDocumentTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardDocumentTypeOrganizationContactPoint(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeRepositoryDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AbstractContentElementType }{@code >}}
   * 
   */
  JAXBElement<AbstractContentElementType> createLearningStandardDocumentTypeRichDescription(AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardDocumentType.Copyright }{@code >}}
   * 
   */
  JAXBElement<LearningStandardDocumentType.Copyright> createLearningStandardDocumentTypeCopyright(LearningStandardDocumentType.Copyright value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardDocumentType.RelatedLearningStandards }{@code >}}
   * 
   */
  JAXBElement<LearningStandardDocumentType.RelatedLearningStandards> createLearningStandardDocumentTypeRelatedLearningStandards(LearningStandardDocumentType.RelatedLearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardDocumentTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeLocalAdoptionDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeDocumentDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardDocumentType.Authors }{@code >}}
   * 
   */
  JAXBElement<LearningStandardDocumentType.Authors> createLearningStandardDocumentTypeAuthors(LearningStandardDocumentType.Authors value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeEndOfLifeDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeLocalArchiveDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentParticipationTypeReferralSourceOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailListType> createPrincipalInfoTypeEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createPrincipalInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPrincipalInfoTypeContactTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSystemRoleTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSystemRoleTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentItemTypeResponseChoicesChoiceChoiceLabel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
   * 
   */
  JAXBElement<Float> createAssessmentItemTypeResponseChoicesChoiceCreditValue(Float value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createTeachingGroupTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createTeachingGroupTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTimeTableSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }
   * {@code >}}
   * 
   */
  JAXBElement<BigInteger> createTeachingGroupTypeMinClassSize(BigInteger value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TeachingGroupType.StudentList }{@code >}}
   * 
   */
  JAXBElement<TeachingGroupType.StudentList> createTeachingGroupTypeStudentList(TeachingGroupType.StudentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeBlock(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeSchoolCourseInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTimeTableSubjectRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeSet(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TeachingGroupType.TeacherList }{@code >}}
   * 
   */
  JAXBElement<TeachingGroupType.TeacherList> createTeachingGroupTypeTeacherList(TeachingGroupType.TeacherList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }
   * {@code >}}
   * 
   */
  JAXBElement<BigInteger> createTeachingGroupTypeMaxClassSize(BigInteger value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createTeachingGroupTypeSemester(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeSchoolCourseLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeCurriculumLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeLongName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link TeachingGroupType.TeachingGroupPeriodList }{@code >}}
   * 
   */
  JAXBElement<TeachingGroupType.TeachingGroupPeriodList> createTeachingGroupTypeTeachingGroupPeriodList(TeachingGroupType.TeachingGroupPeriodList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentPackageTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentPackageTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentPackageType.XMLData }{@code >}}
   * 
   */
  JAXBElement<AssessmentPackageType.XMLData> createAssessmentPackageTypeXMLData(AssessmentPackageType.XMLData value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createSIFReportObjectTypeReportInfoReportSubmitterInfoAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterNotes(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterDepartment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }
   * {@code >}}
   * 
   */
  JAXBElement<PhoneNumberType> createSIFReportObjectTypeReportInfoReportSubmitterInfoPhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId }
   * {@code >}}
   * 
   */
  JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId> createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId(SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<ContactInfoType> createSIFReportObjectTypeReportInfoReportSubmitterInfoContactInfo(ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentSchoolEnrollmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentSchoolEnrollmentTypeFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentSchoolEnrollmentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeRecordClosureReason(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSchoolEnrollmentTypeReportingSchool(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeHomegroup(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.CatchmentStatus }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.CatchmentStatus> createStudentSchoolEnrollmentTypeCatchmentStatus(StudentSchoolEnrollmentType.CatchmentStatus value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeFFPOS(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.ExitStatus }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.ExitStatus> createStudentSchoolEnrollmentTypeExitStatus(StudentSchoolEnrollmentType.ExitStatus value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.StudentSubjectChoiceList }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.StudentSubjectChoiceList> createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(StudentSchoolEnrollmentType.StudentSubjectChoiceList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeACARASchoolId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSchoolEnrollmentTypeExitDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.EntryType }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.EntryType> createStudentSchoolEnrollmentTypeEntryType(StudentSchoolEnrollmentType.EntryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeFTPTStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createStudentSchoolEnrollmentTypeYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.PromotionInfo }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.PromotionInfo> createStudentSchoolEnrollmentTypePromotionInfo(StudentSchoolEnrollmentType.PromotionInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSchoolEnrollmentTypeIndividualLearningPlan(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeClassCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypeDestinationSchool(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.Advisor }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.Advisor> createStudentSchoolEnrollmentTypeAdvisor(StudentSchoolEnrollmentType.Advisor value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.ExitType }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.ExitType> createStudentSchoolEnrollmentTypeExitType(StudentSchoolEnrollmentType.ExitType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createStudentSchoolEnrollmentTypeTestLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypePreviousSchool(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.Counselor }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.Counselor> createStudentSchoolEnrollmentTypeCounselor(StudentSchoolEnrollmentType.Counselor value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.Homeroom }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.Homeroom> createStudentSchoolEnrollmentTypeHomeroom(StudentSchoolEnrollmentType.Homeroom value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSchoolEnrollmentType.Calendar }{@code >}}
   * 
   */
  JAXBElement<StudentSchoolEnrollmentType.Calendar> createStudentSchoolEnrollmentTypeCalendar(StudentSchoolEnrollmentType.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createResourceUsageTypeResourceReportLineListResourceReportLineEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId
   * }{@code >}}
   * 
   */
  JAXBElement<ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId> createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId(ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStudentSchoolEnrollmentRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom
   * }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom(
      Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentFullYearEnrollment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLocationTypeLocationName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LocationType.LocationRefId }{@code >}}
   * 
   */
  JAXBElement<LocationType.LocationRefId> createLocationTypeLocationRefId(LocationType.LocationRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSIFReportObjectTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSIFReportObjectTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedQueryResultsDataModelType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedQueryResultsDataModelType> createSIFReportObjectTypeSIFExtendedQueryResults(SIFExtendedQueryResultsDataModelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportDataObjectType }{@code >}}
   * 
   */
  JAXBElement<ReportDataObjectType> createSIFReportObjectTypeReportData(ReportDataObjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFReportObjectType.ReportInfo }{@code >}}
   * 
   */
  JAXBElement<SIFReportObjectType.ReportInfo> createSIFReportObjectTypeReportInfo(SIFReportObjectType.ReportInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentAttendanceSummaryTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentAttendanceSummaryTypeFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentAttendanceSummaryTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentAttendanceSummaryTypeEndDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentAttendanceSummaryTypeStartDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentAttendanceSummaryTypeDaysTardy(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentActivityInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentActivityInfoTypeStudentActivityLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentActivityInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createStudentActivityInfoTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentActivityInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentActivityInfoTypeCurricularStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }
   * {@code >}}
   * 
   */
  JAXBElement<LocationType> createStudentActivityInfoTypeLocation(LocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreValue(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentAdministrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentAdministrationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createAssessmentAdministrationTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeDueDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentAdministrationTypeAdministrationName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeFinishDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentAdministrationTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentAdministrationTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentAdministrationType.SpecialConditions }{@code >}}
   * 
   */
  JAXBElement<AssessmentAdministrationType.SpecialConditions> createAssessmentAdministrationTypeSpecialConditions(AssessmentAdministrationType.SpecialConditions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentAdministrationTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAdministrationTypeOrganizationsOrganizationLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAdministrationTypeOrganizationsOrganizationSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList
   * }{@code >}}
   * 
   */
  JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList(
      SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeComponentsComponentDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.Components.Component.Strategies }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.Components.Component.Strategies> createLearningResourceTypeComponentsComponentStrategies(LearningResourceType.Components.Component.Strategies value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.Components.Component.AssociatedObjects }
   * {@code >}}
   * 
   */
  JAXBElement<LearningResourceType.Components.Component.AssociatedObjects> createLearningResourceTypeComponentsComponentAssociatedObjects(LearningResourceType.Components.Component.AssociatedObjects value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createLEAInfoTypeEducationAgencyTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemDiagnosticStatement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackSource(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createDemographicsTypeReligionOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeTotalEnrollmentsGirls(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeTotalEnrollmentsBoys(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeTotalEnrollmentsTotalStudents(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createActivityTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }
   * {@code >}}
   * 
   */
  JAXBElement<SubjectAreaType> createActivityTypeSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createActivityTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.LearningStandards }{@code >}}
   * 
   */
  JAXBElement<ActivityType.LearningStandards> createActivityTypeLearningStandards(ActivityType.LearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.Evaluation }{@code >}}
   * 
   */
  JAXBElement<ActivityType.Evaluation> createActivityTypeEvaluation(ActivityType.Evaluation value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypePreamble(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.SourceObjects }{@code >}}
   * 
   */
  JAXBElement<ActivityType.SourceObjects> createActivityTypeSourceObjects(ActivityType.SourceObjects value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.LearningResources }{@code >}}
   * 
   */
  JAXBElement<ActivityType.LearningResources> createActivityTypeLearningResources(ActivityType.LearningResources value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createActivityTypeMaxAttemptsAllowed(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.Prerequisites }{@code >}}
   * 
   */
  JAXBElement<ActivityType.Prerequisites> createActivityTypePrerequisites(ActivityType.Prerequisites value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.SoftwareRequirementList }{@code >}}
   * 
   */
  JAXBElement<ActivityType.SoftwareRequirementList> createActivityTypeSoftwareRequirementList(ActivityType.SoftwareRequirementList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.TechnicalRequirements }{@code >}}
   * 
   */
  JAXBElement<ActivityType.TechnicalRequirements> createActivityTypeTechnicalRequirements(ActivityType.TechnicalRequirements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createActivityTypeActivityWeight(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeAssessmentRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.EssentialMaterials }{@code >}}
   * 
   */
  JAXBElement<ActivityType.EssentialMaterials> createActivityTypeEssentialMaterials(ActivityType.EssentialMaterials value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.Students }{@code >}}
   * 
   */
  JAXBElement<ActivityType.Students> createActivityTypeStudents(ActivityType.Students value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createActivityTypePoints(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.LearningObjectives }{@code >}}
   * 
   */
  JAXBElement<ActivityType.LearningObjectives> createActivityTypeLearningObjectives(ActivityType.LearningObjectives value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypeAreasOfInterestListActivityInfoStudentActivityInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsTeacherCoverCreditType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsTeacherCoverCreditType> createScheduledActivityTypeTeacherListTeacherCoverCredit(AUCodeSetsTeacherCoverCreditType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createScheduledActivityTypeTeacherListTeacherCoverWeighting(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverFinishTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsTeacherCoverSupervisionType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsTeacherCoverSupervisionType> createScheduledActivityTypeTeacherListTeacherCoverSupervision(AUCodeSetsTeacherCoverSupervisionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverStartTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentType.AssessmentDescriptors }{@code >}}
   * 
   */
  JAXBElement<AssessmentType.AssessmentDescriptors> createAssessmentTypeAssessmentDescriptors(AssessmentType.AssessmentDescriptors value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentTypeAssessmentPackageRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentTypeAssessmentId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentItemTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentItemType.ResponseChoices }{@code >}}
   * 
   */
  JAXBElement<AssessmentItemType.ResponseChoices> createAssessmentItemTypeResponseChoices(AssessmentItemType.ResponseChoices value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AbstractContentElementType }{@code >}}
   * 
   */
  JAXBElement<AbstractContentElementType> createAssessmentItemTypeStimulus(AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentItemTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentItemTypeItemName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AbstractContentElementType }{@code >}}
   * 
   */
  JAXBElement<AbstractContentElementType> createAssessmentItemTypeStem(AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentItemTypeItemScoreMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentItemTypeItemScoreMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentItemType.PerformanceLevels }{@code >}}
   * 
   */
  JAXBElement<AssessmentItemType.PerformanceLevels> createAssessmentItemTypePerformanceLevels(AssessmentItemType.PerformanceLevels value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentItemType.LearningStandardItems }{@code >}}
   * 
   */
  JAXBElement<AssessmentItemType.LearningStandardItems> createAssessmentItemTypeLearningStandardItems(AssessmentItemType.LearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3StudentResponseSetTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3StudentResponseSetTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentAssetTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSif3AssessmentAssetTypeAssetSubjects(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentAssetTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createSif3AssessmentAssetTypeAssetGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentAssetTypeAssetPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAssetTypeAssetVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAssetType.AssetLearningStandards }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAssetType.AssetLearningStandards> createSif3AssessmentAssetTypeAssetLearningStandards(Sif3AssessmentAssetType.AssetLearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAssetTypeAssetOwner(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAssetTypeAssetName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAssetTypeAssetLanguage(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAssetType.AssetIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAssetType.AssetIdentifiers> createSif3AssessmentAssetTypeAssetIdentifiers(Sif3AssessmentAssetType.AssetIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createPaymentReceiptTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createPaymentReceiptTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PaymentReceiptType.FinancialAccountRefIdList }{@code >}}
   * 
   */
  JAXBElement<PaymentReceiptType.FinancialAccountRefIdList> createPaymentReceiptTypeFinancialAccountRefIdList(PaymentReceiptType.FinancialAccountRefIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeTransactionMethod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeInvoiceRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeAccountingPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeTransactionDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeVendorInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeChargedLocationInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeTransactionNote(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeDebtorRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createPaymentReceiptTypeTaxRate(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createPaymentReceiptTypeTaxAmount(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPaymentReceiptTypeChequeNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores }
   * {@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores(AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createScheduledActivityTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createScheduledActivityTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createScheduledActivityTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityType.Override }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityType.Override> createScheduledActivityTypeOverride(ScheduledActivityType.Override value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityType.StudentList }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityType.StudentList> createScheduledActivityTypeStudentList(ScheduledActivityType.StudentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityType.TeachingGroupList }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityType.TeachingGroupList> createScheduledActivityTypeTeachingGroupList(ScheduledActivityType.TeachingGroupList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityType.RoomList }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityType.RoomList> createScheduledActivityTypeRoomList(ScheduledActivityType.RoomList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeTimeTableSubjectRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeActivityName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeActivityComment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeTimeTableRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ScheduledActivityType.TeacherList }{@code >}}
   * 
   */
  JAXBElement<ScheduledActivityType.TeacherList> createScheduledActivityTypeTeacherList(ScheduledActivityType.TeacherList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeCellType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createScheduledActivityTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeTimeTableCellRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypePeriodId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeDayId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createScheduledActivityTypeLocation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsScheduledActivityTypeType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsScheduledActivityTypeType> createScheduledActivityTypeActivityType(AUCodeSetsScheduledActivityTypeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createLearningResourceTypeContactsContactAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailType> createLearningResourceTypeContactsContactEmail(EmailType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }
   * {@code >}}
   * 
   */
  JAXBElement<NameType> createLearningResourceTypeContactsContactName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }
   * {@code >}}
   * 
   */
  JAXBElement<PhoneNumberType> createLearningResourceTypeContactsContactPhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSchoolProgramsTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSchoolProgramsTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolProgramsType.SchoolProgramList }{@code >}}
   * 
   */
  JAXBElement<SchoolProgramsType.SchoolProgramList> createSchoolProgramsTypeSchoolProgramList(SchoolProgramsType.SchoolProgramList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSchoolProgramsTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createVendorInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypeAccountNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createVendorInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createVendorInfoTypeRegisteredForGST(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypeBSB(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypeCustomerId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypePaymentTerms(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypeABN(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypeBPay(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }
   * {@code >}}
   * 
   */
  JAXBElement<ContactInfoType> createVendorInfoTypeContactInfo(ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createVendorInfoTypeAccountName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentRegistrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createSif3AssessmentRegistrationTypeAssessmentGradeLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentRegistrationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentSessionRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot(Sif3AssessmentRegistrationType.AssessmentStudentSnapshot value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeSectionInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentFormRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRegistrationType.StudentSpecialEvents }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRegistrationType.StudentSpecialEvents> createSif3AssessmentRegistrationTypeStudentSpecialEvents(Sif3AssessmentRegistrationType.StudentSpecialEvents value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentAdministrationRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentPlatform(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createSif3AssessmentRegistrationTypeStudentGradeLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeRetestIndicator(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeTestAttemptIdentifier(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRegistrationType.TestingStatuses }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRegistrationType.TestingStatuses> createSif3AssessmentRegistrationTypeTestingStatuses(Sif3AssessmentRegistrationType.TestingStatuses value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeScorePublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Integer }
   * {@code >}}
   * 
   */
  JAXBElement<Integer> createSif3AssessmentRegistrationTypeDaysOfInstruction(Integer value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeEndDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationAward(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGiftedTalented(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }
   * {@code >}}
   * 
   */
  JAXBElement<NameType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationOnTime(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotProjectedGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAge(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotNeglectedDelinquent(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotEconomicDisadvantage(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotOnTimeGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypePastoralCareDisciplinaryAbsences(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypePastoralCareIndividualBehaviourPlan(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentShortName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTeachingGroupRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTimeTableSubjectRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolCourseInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentCourseLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId
   * }{@code >}}
   * 
   */
  JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId(
      SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentContactRelationshipTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentContactRelationshipTypeParentRelationshipStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentContactRelationshipTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentContactRelationshipTypeContactSequence(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactRelationshipType.ContactFlags }{@code >}}
   * 
   */
  JAXBElement<StudentContactRelationshipType.ContactFlags> createStudentContactRelationshipTypeContactFlags(StudentContactRelationshipType.ContactFlags value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactRelationshipType.HouseholdList }{@code >}}
   * 
   */
  JAXBElement<StudentContactRelationshipType.HouseholdList> createStudentContactRelationshipTypeHouseholdList(StudentContactRelationshipType.HouseholdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsSourceCodeTypeType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsSourceCodeTypeType> createStudentContactRelationshipTypeContactSequenceSource(AUCodeSetsSourceCodeTypeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeMainlySpeaksEnglishAtHome(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypeScoreRangeMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypeScoreRangeMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLanguageListTypeLanguageLanguageType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLanguageListTypeLanguageDialect(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createLanguageListTypeLanguageOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentSectionEnrollmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentSectionEnrollmentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeExitDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeEntryDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createSectionInfoTypeLanguageOfInstructionOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolNo(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentStudentSchoolEnrollmentRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSnapshotType.HomeEnrollment.Homeroom }{@code >}}
   * 
   */
  JAXBElement<StudentSnapshotType.HomeEnrollment.Homeroom> createStudentSnapshotTypeHomeEnrollmentHomeroom(StudentSnapshotType.HomeEnrollment.Homeroom value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createStudentSnapshotTypeHomeEnrollmentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentParticipationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentParticipationType.ReferralSource }{@code >}}
   * 
   */
  JAXBElement<StudentParticipationType.ReferralSource> createStudentParticipationTypeReferralSource(StudentParticipationType.ReferralSource value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentParticipationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlacementDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentParticipationTypeParticipationContact(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationExtensionDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentParticipationTypeGiftedEligibilityCriteria(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypePlacementParentalConsentDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentParticipationType.ProgramAvailability }{@code >}}
   * 
   */
  JAXBElement<StudentParticipationType.ProgramAvailability> createStudentParticipationTypeProgramAvailability(StudentParticipationType.ProgramAvailability value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeReferralDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlanEffectiveDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentParticipationTypeStudentSpecialEducationFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentParticipationTypeProgramType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ProgramStatusType
   * }{@code >}}
   * 
   */
  JAXBElement<ProgramStatusType> createStudentParticipationTypeProgramStatus(ProgramStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentParticipationTypeExtensionComments(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlanDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationParentalConsentDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentParticipationType.ProgramFundingSources }{@code >}}
   * 
   */
  JAXBElement<StudentParticipationType.ProgramFundingSources> createStudentParticipationTypeProgramFundingSources(StudentParticipationType.ProgramFundingSources value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramEligibilityDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }
   * {@code >}}
   * 
   */
  JAXBElement<Boolean> createStudentParticipationTypeExtendedSchoolYear(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeNOREPDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }
   * {@code >}}
   * 
   */
  JAXBElement<Boolean> createStudentParticipationTypeExtendedDay(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeReevaluationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentParticipationTypeEntryPerson(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentRubricTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentRubricTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRubricType.RubricIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRubricType.RubricIdentifiers> createSif3AssessmentRubricTypeRubricIdentifiers(Sif3AssessmentRubricType.RubricIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentRubricTypeRubricPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRubricTypeRubricVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRubricType.Scores }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRubricType.Scores> createSif3AssessmentRubricTypeScores(Sif3AssessmentRubricType.Scores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRubricTypeScoringGuideReference(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeExitStatusOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypeFullName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypeSuffix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypeGivenName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypeMiddleName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypePreferredGivenName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createBaseNameTypeFamilyNameFirst(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypeTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypeFamilyName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createBaseNameTypePreferredFamilyNameFirst(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createBaseNameTypePreferredFamilyName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createResourceUsageTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createResourceUsageTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createEquipmentInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createEquipmentInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createEquipmentInfoTypeEquipmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createEquipmentInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createEquipmentInfoTypePurchaseOrderRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EquipmentInfoType.SIFRefId }{@code >}}
   * 
   */
  JAXBElement<EquipmentInfoType.SIFRefId> createEquipmentInfoTypeSIFRefId(EquipmentInfoType.SIFRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createEquipmentInfoTypeAssetNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createEquipmentInfoTypeInvoiceRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentScoreSetTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentScoreSetTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createStudentScoreSetTypeFinishDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createStudentScoreSetTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentScoreSetTypeAssessmentRegistrationRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeItemSelectionAlgorithmName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeSectionReentry(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentSectionTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentSectionTypeSectionPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentSectionTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSectionType.SectionIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSectionType.SectionIdentifiers> createSif3AssessmentSectionTypeSectionIdentifiers(Sif3AssessmentSectionType.SectionIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeSectionVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link javax.xml.datatype.Duration }{@code >}}
   * 
   */
  JAXBElement<javax.xml.datatype.Duration> createSif3AssessmentSectionTypeSectionTimeLimit(javax.xml.datatype.Duration value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeSectionName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSectionType.SectionItems }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSectionType.SectionItems> createSif3AssessmentSectionTypeSectionItems(Sif3AssessmentSectionType.SectionItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSectionType.SectionAssets }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSectionType.SectionAssets> createSif3AssessmentSectionTypeSectionAssets(Sif3AssessmentSectionType.SectionAssets value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeItemSelectionAlgorithm(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSectionTypeSectionSealed(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentActivityInfoTypeStudentActivityTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStartTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createCalendarDateSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createCalendarDateSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createCalendarDateCalendarDateNumber(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link CalendarDate.AdministratorAttendance }{@code >}}
   * 
   */
  JAXBElement<CalendarDate.AdministratorAttendance> createCalendarDateAdministratorAttendance(CalendarDate.AdministratorAttendance value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link CalendarDate.StudentAttendance }{@code >}}
   * 
   */
  JAXBElement<CalendarDate.StudentAttendance> createCalendarDateStudentAttendance(CalendarDate.StudentAttendance value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link CalendarDate.TeacherAttendance }{@code >}}
   * 
   */
  JAXBElement<CalendarDate.TeacherAttendance> createCalendarDateTeacherAttendance(CalendarDate.TeacherAttendance value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceUsageTypeResourceUsageContentTypeLocalDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaffStaffLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentFormTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentFormTypeAssessmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentFormTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createAssessmentFormTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentFormType.FormNumbers }{@code >}}
   * 
   */
  JAXBElement<AssessmentFormType.FormNumbers> createAssessmentFormTypeFormNumbers(AssessmentFormType.FormNumbers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentFormTypePeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentFormType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  JAXBElement<AssessmentFormType.AssessmentSubTestRefIds> createAssessmentFormTypeAssessmentSubTestRefIds(AssessmentFormType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentFormTypeLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementVendor(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementOS(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentOtherEnrollmentSchoolACARAId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentReportingSchoolId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentPersonalTypeMostRecentFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent2NonSchoolEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentClassCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent1NonSchoolEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentHomeroomLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentHomegroup(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentSchoolACARAId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createStudentPersonalTypeMostRecentTestLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentFFPOS(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent1EmploymentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentLocalCampusId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent2EmploymentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent1Language(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createStudentPersonalTypeMostRecentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeMostRecentParent2Language(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardItemTypeStandardSettingBodySettingBodyName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardItemTypeStandardSettingBodyStateProvince(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LifeCycleType.TimeElements }{@code >}}
   * 
   */
  JAXBElement<LifeCycleType.TimeElements> createLifeCycleTypeTimeElements(LifeCycleType.TimeElements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LifeCycleType.ModificationHistory }{@code >}}
   * 
   */
  JAXBElement<LifeCycleType.ModificationHistory> createLifeCycleTypeModificationHistory(LifeCycleType.ModificationHistory value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LifeCycleType.Created }{@code >}}
   * 
   */
  JAXBElement<LifeCycleType.Created> createLifeCycleTypeCreated(LifeCycleType.Created value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createLearningStandardItemTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createLearningStandardItemTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.PredecessorItems }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.PredecessorItems> createLearningStandardItemTypePredecessorItems(LearningStandardItemType.PredecessorItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardItemTypeLevel5(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningStandardItemTypeLevel4(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.Statements }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.Statements> createLearningStandardItemTypeStatements(LearningStandardItemType.Statements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.StandardSettingBody }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.StandardSettingBody> createLearningStandardItemTypeStandardSettingBody(LearningStandardItemType.StandardSettingBody value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.Resources }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.Resources> createLearningStandardItemTypeResources(LearningStandardItemType.Resources value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ACStrandSubjectAreaType }{@code >}}
   * 
   */
  JAXBElement<ACStrandSubjectAreaType> createLearningStandardItemTypeACStrandSubjectArea(ACStrandSubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.RelatedLearningStandardItems }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.RelatedLearningStandardItems> createLearningStandardItemTypeRelatedLearningStandardItems(LearningStandardItemType.RelatedLearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.StandardIdentifier }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.StandardIdentifier> createLearningStandardItemTypeStandardIdentifier(LearningStandardItemType.StandardIdentifier value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningStandardItemType.StatementCodes }{@code >}}
   * 
   */
  JAXBElement<LearningStandardItemType.StatementCodes> createLearningStandardItemTypeStatementCodes(LearningStandardItemType.StatementCodes value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemScoreCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3StudentResponseSetType.Items.Item.ItemAids }{@code >}}
   * 
   */
  JAXBElement<Sif3StudentResponseSetType.Items.Item.ItemAids> createSif3StudentResponseSetTypeItemsItemItemAids(Sif3StudentResponseSetType.Items.Item.ItemAids value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createSif3StudentResponseSetTypeItemsItemNumberOfAttempts(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemResponseCorrectness(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemViewStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemAssessmentRubricRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3StudentResponseSetType.Items.Item.FeedbackItems }{@code >}}
   * 
   */
  JAXBElement<Sif3StudentResponseSetType.Items.Item.FeedbackItems> createSif3StudentResponseSetTypeItemsItemFeedbackItems(Sif3StudentResponseSetType.Items.Item.FeedbackItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemResponseLocation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3StudentResponseSetType.Items.Item.Comments }{@code >}}
   * 
   */
  JAXBElement<Sif3StudentResponseSetType.Items.Item.Comments> createSif3StudentResponseSetTypeItemsItemComments(Sif3StudentResponseSetType.Items.Item.Comments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemScore(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemAttemptStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3StudentResponseSetType.Items.Item.TraitScores }{@code >}}
   * 
   */
  JAXBElement<Sif3StudentResponseSetType.Items.Item.TraitScores> createSif3StudentResponseSetTypeItemsItemTraitScores(Sif3StudentResponseSetType.Items.Item.TraitScores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link javax.xml.datatype.Duration }{@code >}}
   * 
   */
  JAXBElement<javax.xml.datatype.Duration> createSif3StudentResponseSetTypeItemsItemTimeOnItem(javax.xml.datatype.Duration value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SystemRoleType.SystemContextList.SystemContext.RoleList }{@code >}}
   * 
   */
  JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList> createSystemRoleTypeSystemContextListSystemContextRoleList(SystemRoleType.SystemContextList.SystemContext.RoleList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStaffPersonalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStaffPersonalTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffPersonalType.MostRecent }{@code >}}
   * 
   */
  JAXBElement<StaffPersonalType.MostRecent> createStaffPersonalTypeMostRecent(StaffPersonalType.MostRecent value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ElectronicIdListType }{@code >}}
   * 
   */
  JAXBElement<ElectronicIdListType> createStaffPersonalTypeElectronicIdList(ElectronicIdListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffPersonalTypeTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffPersonalType.OtherIdList }{@code >}}
   * 
   */
  JAXBElement<StaffPersonalType.OtherIdList> createStaffPersonalTypeOtherIdList(StaffPersonalType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffPersonalTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsStaffStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsStaffStatusType> createStaffPersonalTypeEmploymentStatus(AUCodeSetsStaffStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createChargedLocationInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createChargedLocationInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createChargedLocationInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createChargedLocationInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createChargedLocationInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createChargedLocationInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createChargedLocationInfoTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createChargedLocationInfoTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createChargedLocationInfoTypeParentChargedLocationInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createProgramStatusTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSessionInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSessionInfoTypeStaffPersonalLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSessionInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSessionInfoTypeFinishTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSessionInfoTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSessionInfoTypeRoomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSessionInfoTypeRollMarked(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSessionInfoTypeStartTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetApartmentNumberPrefix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetStreetName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetApartmentNumberSuffix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetApartmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetStreetPrefix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetLine3(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetLine2(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetComplex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetStreetSuffix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetApartmentNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetStreetNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStreetStreetType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }
   * {@code >}}
   * 
   */
  JAXBElement<SubjectAreaType> createSectionInfoTypeSchoolCourseInfoOverrideSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideInstructionalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideStateCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseCredits(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideDistrictCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentAttendanceTimeListTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentAttendanceTimeListTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createAttendanceCodeTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentContactPersonalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentContactPersonalTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentContactPersonalTypeSchoolEducationalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentContactPersonalType.OtherIdList }{@code >}}
   * 
   */
  JAXBElement<StudentContactPersonalType.OtherIdList> createStudentContactPersonalTypeOtherIdList(StudentContactPersonalType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentContactPersonalTypeEmploymentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentContactPersonalTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentContactPersonalTypeNonSchoolEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createGradingAssignmentScoreTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createGradingAssignmentScoreTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createGradingAssignmentScoreTypeScorePercent(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentScoreTypeScoreLetter(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createGradingAssignmentScoreTypeScorePoints(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentScoreTypeTeachingGroupRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentScoreTypeScoreDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentScoreTypeStudentPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentScoreTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSummaryEnrollmentInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSummaryEnrollmentInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ObjectType }
   * {@code >}}
   * 
   */
  JAXBElement<ObjectType> createSIFQueryDataModelTypeSIFExample(ObjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFQueryDataModelType.SIFConditionGroup }{@code >}}
   * 
   */
  JAXBElement<SIFQueryDataModelType.SIFConditionGroup> createSIFQueryDataModelTypeSIFConditionGroup(SIFQueryDataModelType.SIFConditionGroup value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentAdministrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentAdministrationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAdministrationType.Organizations }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAdministrationType.Organizations> createSif3AssessmentAdministrationTypeOrganizations(Sif3AssessmentAdministrationType.Organizations value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAdministrationTypeAdministrationName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentAdministrationTypeFinishDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentAdministrationTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentAdministrationTypeAdministrationCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentAdministrationType.AdministrationAssessments }
   * {@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentAdministrationType.AdministrationAssessments> createSif3AssessmentAdministrationTypeAdministrationAssessments(Sif3AssessmentAdministrationType.AdministrationAssessments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRegistrationTypeTestingStatusesTestingStatusTestingStatusDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createCalendarSummaryTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createCalendarSummaryTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createCalendarSummaryTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createCalendarSummaryTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createCalendarSummaryTypeMinutesPerDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createCalendarSummaryTypeInstructionalMinutes(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createCalendarSummaryTypeGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeLastInstructionDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeFirstInstructionDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AddressType.StatisticalAreas.StatisticalArea }{@code >}}
   * 
   */
  JAXBElement<AddressType.StatisticalAreas.StatisticalArea> createAddressTypeStatisticalAreasStatisticalArea(AddressType.StatisticalAreas.StatisticalArea value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link DemographicsType.DwellingArrangement }{@code >}}
   * 
   */
  JAXBElement<DemographicsType.DwellingArrangement> createDemographicsTypeDwellingArrangement(DemographicsType.DwellingArrangement value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeReligiousRegion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link DemographicsType.CountriesOfResidency }{@code >}}
   * 
   */
  JAXBElement<DemographicsType.CountriesOfResidency> createDemographicsTypeCountriesOfResidency(DemographicsType.CountriesOfResidency value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeMaritalStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EnglishProficiencyType }{@code >}}
   * 
   */
  JAXBElement<EnglishProficiencyType> createDemographicsTypeEnglishProficiency(EnglishProficiencyType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeCountryOfBirth(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link DemographicsType.ReligiousEventList }{@code >}}
   * 
   */
  JAXBElement<DemographicsType.ReligiousEventList> createDemographicsTypeReligiousEventList(DemographicsType.ReligiousEventList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeCulturalBackground(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createDemographicsTypeVisaExpiryDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType
   * }{@code >}}
   * 
   */
  JAXBElement<LanguageListType> createDemographicsTypeLanguageList(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeVisaStatisticalCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeStateOfBirth(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeVisaSubClass(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link DemographicsType.CountriesOfCitizenship }{@code >}}
   * 
   */
  JAXBElement<DemographicsType.CountriesOfCitizenship> createDemographicsTypeCountriesOfCitizenship(DemographicsType.CountriesOfCitizenship value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createDemographicsTypeCountryArrivalDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeIndigenousStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link DemographicsType.Religion }{@code >}}
   * 
   */
  JAXBElement<DemographicsType.Religion> createDemographicsTypeReligion(DemographicsType.Religion value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypePermanentResident(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsImmunisationCertificateStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsImmunisationCertificateStatusType> createDemographicsTypeImmunisationCertificateStatus(AUCodeSetsImmunisationCertificateStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeBirthDateVerification(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypeAustralianCitizenshipStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createDemographicsTypeBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createDemographicsTypeLBOTE(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDemographicsTypePlaceOfBirth(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolProgramsTypeSchoolProgramListProgramCategory(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createSchoolProgramsTypeSchoolProgramListProgramOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodDueDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodBeginSubmitDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodBeginReportDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodEndReportDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodEndSubmitDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeDueDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ActivityType.ActivityTime.Duration }{@code >}}
   * 
   */
  JAXBElement<ActivityType.ActivityTime.Duration> createActivityTypeActivityTimeDuration(ActivityType.ActivityTime.Duration value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeFinishDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createCalendarDateCalendarDateTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypeSubjectArea(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentSubTestTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createAssessmentSubTestTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentSubTestTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestType.LearningStandardItemRefIds }{@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestType.LearningStandardItemRefIds> createAssessmentSubTestTypeLearningStandardItemRefIds(AssessmentSubTestType.LearningStandardItemRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createAssessmentSubTestTypeNumberOfItems(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypeAbbreviation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestType.AssessmentSubTestRefIds> createAssessmentSubTestTypeAssessmentSubTestRefIds(AssessmentSubTestType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }
   * {@code >}}
   * 
   */
  JAXBElement<Boolean> createAssessmentSubTestTypeContainerOnly(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createAssessmentSubTestTypeSubTestTier(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentSubTestTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestType.PerformanceLevels }{@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestType.PerformanceLevels> createAssessmentSubTestTypePerformanceLevels(AssessmentSubTestType.PerformanceLevels value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentSubTestType.ScoreRange }{@code >}}
   * 
   */
  JAXBElement<AssessmentSubTestType.ScoreRange> createAssessmentSubTestTypeScoreRange(AssessmentSubTestType.ScoreRange value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createInvoiceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link InvoiceType.PurchasingItems }{@code >}}
   * 
   */
  JAXBElement<InvoiceType.PurchasingItems> createInvoiceTypePurchasingItems(InvoiceType.PurchasingItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createInvoiceTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeTaxType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link InvoiceType.FinancialAccountRefIdList }{@code >}}
   * 
   */
  JAXBElement<InvoiceType.FinancialAccountRefIdList> createInvoiceTypeFinancialAccountRefIdList(InvoiceType.FinancialAccountRefIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeItemDetail(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeCreatedBy(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createInvoiceTypeDueDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeAccountingPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createInvoiceTypeNetAmount(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeChargedLocationInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeRelatedPurchaseOrderRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeFormNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createInvoiceTypeTaxRate(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createInvoiceTypeApprovedBy(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link MonetaryAmountType }{@code >}}
   * 
   */
  JAXBElement<MonetaryAmountType> createInvoiceTypeTaxAmount(MonetaryAmountType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createInvoiceTypeVoluntary(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores }
   * {@code >}}
   * 
   */
  JAXBElement<AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores(AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createPhoneNumberTypeExtension(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createPhoneNumberTypeListedStatus(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createLEAInfoTypeLEAContactListLEAContactPublishInDirectory(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList }
   * {@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList(Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValuePassFailIndicator(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createReportManifestTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportManifestType.SIFQueryGroup }{@code >}}
   * 
   */
  JAXBElement<ReportManifestType.SIFQueryGroup> createReportManifestTypeSIFQueryGroup(ReportManifestType.SIFQueryGroup value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createReportManifestTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createReportManifestTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportManifestType.ReportingPeriod }{@code >}}
   * 
   */
  JAXBElement<ReportManifestType.ReportingPeriod> createReportManifestTypeReportingPeriod(ReportManifestType.ReportingPeriod value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedQueryDataModelType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedQueryDataModelType> createReportManifestTypeSIFExtendedQuery(SIFExtendedQueryDataModelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportManifestType.ReportFormatList }{@code >}}
   * 
   */
  JAXBElement<ReportManifestType.ReportFormatList> createReportManifestTypeReportFormatList(ReportManifestType.ReportFormatList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ReportManifestType.ReceivingAuthority }{@code >}}
   * 
   */
  JAXBElement<ReportManifestType.ReceivingAuthority> createReportManifestTypeReceivingAuthority(ReportManifestType.ReceivingAuthority value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions> createSif3AssessmentRubricTypeScoresScoreScoreDescriptions(Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentRubricType.Scores.Score.ScoreComments }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreComments> createSif3AssessmentRubricTypeScoresScoreScoreComments(Sif3AssessmentRubricType.Scores.Score.ScoreComments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentRubricTypeScoresScoreScoreCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AbstractContentElementType }{@code >}}
   * 
   */
  JAXBElement<AbstractContentElementType> createSif3AssessmentRubricTypeScoresScoreScoreCodeDefinition(AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSectionInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSectionInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeCountForAttendance(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSummerSchool(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeCourseSectionCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SectionInfoType.LanguageOfInstruction }{@code >}}
   * 
   */
  JAXBElement<SectionInfoType.LanguageOfInstruction> createSectionInfoTypeLanguageOfInstruction(SectionInfoType.LanguageOfInstruction value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SectionInfoType.LocationOfInstruction }{@code >}}
   * 
   */
  JAXBElement<SectionInfoType.LocationOfInstruction> createSectionInfoTypeLocationOfInstruction(SectionInfoType.LocationOfInstruction value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeSectionCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSectionInfoTypeTermInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSectionInfoTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SectionInfoType.MediumOfInstruction }{@code >}}
   * 
   */
  JAXBElement<SectionInfoType.MediumOfInstruction> createSectionInfoTypeMediumOfInstruction(SectionInfoType.MediumOfInstruction value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SectionInfoType.SchoolCourseInfoOverride }{@code >}}
   * 
   */
  JAXBElement<SectionInfoType.SchoolCourseInfoOverride> createSectionInfoTypeSchoolCourseInfoOverride(SectionInfoType.SchoolCourseInfoOverride value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailListType> createStudentSDTNTypeFurtherInformationEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameOfRecordType
   * }{@code >}}
   * 
   */
  JAXBElement<NameOfRecordType> createStudentSDTNTypeFurtherInformationContactName(NameOfRecordType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createStudentSDTNTypeFurtherInformationPhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentPersonalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentPersonalTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeIntegrationAide(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPersonalType.MostRecent }{@code >}}
   * 
   */
  JAXBElement<StudentPersonalType.MostRecent> createStudentPersonalTypeMostRecent(StudentPersonalType.MostRecent value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeGiftedTalented(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeFirstAUSchoolEnrollment(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ElectronicIdListType }{@code >}}
   * 
   */
  JAXBElement<ElectronicIdListType> createStudentPersonalTypeElectronicIdList(ElectronicIdListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeEducationSupport(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeHomeSchooledStudent(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeProjectedGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeSensitive(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeOfflineDelivery(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPersonalType.MedicalAlertMessages }{@code >}}
   * 
   */
  JAXBElement<StudentPersonalType.MedicalAlertMessages> createStudentPersonalTypeMedicalAlertMessages(StudentPersonalType.MedicalAlertMessages value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeESL(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeAcceptableUsePolicy(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeYoungCarersRole(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPersonalType.OtherIdList }{@code >}}
   * 
   */
  JAXBElement<StudentPersonalType.OtherIdList> createStudentPersonalTypeOtherIdList(StudentPersonalType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypePrePrimaryEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeEconomicDisadvantage(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeDisability(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPersonalTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPersonalType.AlertMessages }{@code >}}
   * 
   */
  JAXBElement<StudentPersonalType.AlertMessages> createStudentPersonalTypeAlertMessages(StudentPersonalType.AlertMessages value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeOnTimeGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createSubjectAreaTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createDebtorTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createDebtorTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createDebtorTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDebtorTypeBillingNote(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDebtorTypeDiscount(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createDebtorTypeBillingName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createTimeElementTypeSpanGapsSpanGapStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createTimeElementTypeSpanGapsSpanGapEndDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailListType> createPersonInfoTypeEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createPersonInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createPersonInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType
   * }{@code >}}
   * 
   */
  JAXBElement<DemographicsType> createPersonInfoTypeDemographics(DemographicsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherNamesType }
   * {@code >}}
   * 
   */
  JAXBElement<OtherNamesType> createPersonInfoTypeOtherNames(OtherNamesType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createLEAInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLEAInfoTypeLEAURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createLEAInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLEAInfoTypeJurisdictionLowerHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createLEAInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createLEAInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LEAInfoType.LEAContactList }{@code >}}
   * 
   */
  JAXBElement<LEAInfoType.LEAContactList> createLEAInfoTypeLEAContactList(LEAInfoType.LEAContactList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsOperationalStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsOperationalStatusType> createLEAInfoTypeOperationalStatus(AUCodeSetsOperationalStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLEAInfoTypeCommonwealthId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLEAInfoTypeSLA(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LEAInfoType.EducationAgencyType }{@code >}}
   * 
   */
  JAXBElement<LEAInfoType.EducationAgencyType> createLEAInfoTypeEducationAgencyType(LEAInfoType.EducationAgencyType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLEAInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingScoreTableRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffPersonalTypeMostRecentSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffPersonalTypeMostRecentHomeGroup(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffPersonalType.MostRecent.NAPLANClassList }{@code >}}
   * 
   */
  JAXBElement<StaffPersonalType.MostRecent.NAPLANClassList> createStaffPersonalTypeMostRecentNAPLANClassList(StaffPersonalType.MostRecent.NAPLANClassList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffPersonalTypeMostRecentLocalCampusId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffPersonalTypeMostRecentSchoolACARAId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentScoreSetTypeScoresScoreDiagnosticStatement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentScoreSetTypeScoresScoreDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentScoreSetTypeScoresScoreNumberOfResponses(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningResourceTypeEvaluationsEvaluationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeEvaluationsEvaluationDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }
   * {@code >}}
   * 
   */
  JAXBElement<NameType> createLearningResourceTypeEvaluationsEvaluationName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentPeriodAttendanceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentPeriodAttendanceTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPeriodAttendanceTypeAttendanceComment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentPeriodAttendanceType.AuditInfo }{@code >}}
   * 
   */
  JAXBElement<StudentPeriodAttendanceType.AuditInfo> createStudentPeriodAttendanceTypeAuditInfo(StudentPeriodAttendanceType.AuditInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeTimeOut(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPeriodAttendanceTypeTimetablePeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentPeriodAttendanceTypeSessionInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeTimeIn(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentParticipationTypeProgramAvailabilityOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createResourceBookingTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createResourceBookingTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceBookingTypeToPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceBookingTypeFromPeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ResourceBookingType.ResourceRefId }{@code >}}
   * 
   */
  JAXBElement<ResourceBookingType.ResourceRefId> createResourceBookingTypeResourceRefId(ResourceBookingType.ResourceRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceBookingTypeReason(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceBookingTypeScheduledActivityRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }
   * {@code >}}
   * 
   */
  JAXBElement<Boolean> createResourceBookingTypeKeepOld(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createGradingAssignmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
   * 
   */
  JAXBElement<byte[]> createGradingAssignmentTypeDetailedDescriptionBinary(byte[] value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createGradingAssignmentTypeDueDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createGradingAssignmentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createGradingAssignmentTypeWeight(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentTypeDetailedDescriptionURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentTypeTeachingGroupRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }
   * {@code >}}
   * 
   */
  JAXBElement<BigInteger> createGradingAssignmentTypeMaxAttemptsAllowed(BigInteger value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createGradingAssignmentTypeCreateDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentTypeGradingCategory(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createGradingAssignmentTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createDemographicsTypeDwellingArrangementOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link EducationFilterType.LearningStandardItems }{@code >}}
   * 
   */
  JAXBElement<EducationFilterType.LearningStandardItems> createEducationFilterTypeLearningStandardItems(EducationFilterType.LearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentActivityParticipationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentActivityParticipationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentActivityParticipationTypeParticipationComment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentActivityParticipationType.RecognitionList }{@code >}}
   * 
   */
  JAXBElement<StudentActivityParticipationType.RecognitionList> createStudentActivityParticipationTypeRecognitionList(StudentActivityParticipationType.RecognitionList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentActivityParticipationTypeRole(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentParticipationTypeProgramFundingSourcesProgramFundingSourceOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFReportObjectTypeReportInfoDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo }{@code >}}
   * 
   */
  JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo> createSIFReportObjectTypeReportInfoReportSubmitterInfo(SIFReportObjectType.ReportInfo.ReportSubmitterInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDelimiter(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createPersonPictureTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createPersonPictureTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createPersonPictureTypeOKToPublish(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }
   * {@code >}}
   * 
   */
  JAXBElement<SubjectAreaType> createACStrandSubjectAreaTypeSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsProgressLevelType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeOtherLearningAreasListOtherLearningAreaResult(AUCodeSetsProgressLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSchoolEnrollmentTypePromotionInfoPromotionStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFExtendedQueryDataModelTypeSIFDestinationProvider(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedQueryDataModelType.SIFOrderBy }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedQueryDataModelType.SIFOrderBy> createSIFExtendedQueryDataModelTypeSIFOrderBy(SIFExtendedQueryDataModelType.SIFOrderBy value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedQueryDataModelType.SIFWhere }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedQueryDataModelType.SIFWhere> createSIFExtendedQueryDataModelTypeSIFWhere(SIFExtendedQueryDataModelType.SIFWhere value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createJournalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createJournalTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createJournalTypeGSTCodeReplacement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link JournalType.OriginatingTransactionRefId }{@code >}}
   * 
   */
  JAXBElement<JournalType.OriginatingTransactionRefId> createJournalTypeOriginatingTransactionRefId(JournalType.OriginatingTransactionRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createJournalTypeGSTCodeOriginal(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createJournalTypeApprovedBy(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createJournalTypeNote(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createJournalTypeCreatedBy(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createJournalTypeCreatedDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createJournalTypeApprovedDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AddressType.StatisticalAreas }{@code >}}
   * 
   */
  JAXBElement<AddressType.StatisticalAreas> createAddressTypeStatisticalAreas(AddressType.StatisticalAreas value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GridLocationType
   * }{@code >}}
   * 
   */
  JAXBElement<GridLocationType> createAddressTypeGridLocation(GridLocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeCommunity(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeCountry(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeAddressGlobalUID(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeRadioContact(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AddressType.MapReference }{@code >}}
   * 
   */
  JAXBElement<AddressType.MapReference> createAddressTypeMapReference(AddressType.MapReference value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAddressTypeStateProvince(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createSectionInfoTypeLocationOfInstructionOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeCatchmentStatusOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLifeCycleTypeModificationHistoryModifiedDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFContextsType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFContextsType> createSIFHeaderDataModelTypeSIFContexts(SIFContextsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFHeaderDataModelTypeSIFDestinationId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFHeaderDataModelType.SIFSecurity }{@code >}}
   * 
   */
  JAXBElement<SIFHeaderDataModelType.SIFSecurity> createSIFHeaderDataModelTypeSIFSecurity(SIFHeaderDataModelType.SIFSecurity value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentSessionTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressType> createSif3AssessmentSessionTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentSessionTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSessionType.UnusualEvents }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSessionType.UnusualEvents> createSif3AssessmentSessionTypeUnusualEvents(Sif3AssessmentSessionType.UnusualEvents value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSessionTypeAssessmentFormRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSessionTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSessionTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeActualStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentSessionTypeAssessmentAdministrationRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeActualEndDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeScheduledEndDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link java.util.Calendar }{@code >}}
   * 
   */
  JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeScheduledStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentSessionType.StaffPersonalRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentSessionType.StaffPersonalRefIds> createSif3AssessmentSessionTypeStaffPersonalRefIds(Sif3AssessmentSessionType.StaffPersonalRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentDailyAttendanceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentDailyAttendanceTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentDailyAttendanceTypeAttendanceNote(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsDayValueCodeType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsDayValueCodeType> createStudentDailyAttendanceTypeDayValue(AUCodeSetsDayValueCodeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStudentDailyAttendanceTypeAbsenceValue(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentDailyAttendanceTypeTimeOut(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentDailyAttendanceTypeTimeIn(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createActivityTypeEvaluationDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAggregateStatisticInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAggregateStatisticInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAggregateStatisticInfoTypeSource(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateStatisticInfoType.ExclusionRules }{@code >}}
   * 
   */
  JAXBElement<AggregateStatisticInfoType.ExclusionRules> createAggregateStatisticInfoTypeExclusionRules(AggregateStatisticInfoType.ExclusionRules value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeApprovalDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeExpirationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAggregateStatisticInfoTypeMeasure(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeDiscontinueDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AggregateStatisticInfoType.CalculationRule }{@code >}}
   * 
   */
  JAXBElement<AggregateStatisticInfoType.CalculationRule> createAggregateStatisticInfoTypeCalculationRule(AggregateStatisticInfoType.CalculationRule value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeEffectiveDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }
   * {@code >}}
   * 
   */
  JAXBElement<LocationType> createAggregateStatisticInfoTypeLocation(LocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentType.LearningStandardItemRefIds }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentType.LearningStandardItemRefIds> createSif3AssessmentTypeLearningStandardItemRefIds(Sif3AssessmentType.LearningStandardItemRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType
   * }{@code >}}
   * 
   */
  JAXBElement<LanguageListType> createSif3AssessmentTypeAssessmentLanguages(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentType.AssessmentDescriptors }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentType.AssessmentDescriptors> createSif3AssessmentTypeAssessmentDescriptors(Sif3AssessmentType.AssessmentDescriptors value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createSif3AssessmentTypeAssessmentGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentTypeAssessmentPackageRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentType.AssessmentIdentifiers }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentType.AssessmentIdentifiers> createSif3AssessmentTypeAssessmentIdentifiers(Sif3AssessmentType.AssessmentIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link Sif3AssessmentType.AssessmentItemBanks }{@code >}}
   * 
   */
  JAXBElement<Sif3AssessmentType.AssessmentItemBanks> createSif3AssessmentTypeAssessmentItemBanks(Sif3AssessmentType.AssessmentItemBanks value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSif3AssessmentTypeAssessmentSubjects(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3AssessmentTypeAssessmentProvider(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentSDTNTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentSDTNTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeHealthNeeds(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSDTNType.PreviousSchoolsList }{@code >}}
   * 
   */
  JAXBElement<StudentSDTNType.PreviousSchoolsList> createStudentSDTNTypePreviousSchoolsList(StudentSDTNType.PreviousSchoolsList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSDTNTypeEnrollmentDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAttendanceConcerns(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsProgressLevelType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeLiteracy(AUCodeSetsProgressLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSDTNType.PastoralCare }{@code >}}
   * 
   */
  JAXBElement<StudentSDTNType.PastoralCare> createStudentSDTNTypePastoralCare(StudentSDTNType.PastoralCare value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypeReasonForLeaving(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSDTNType.FurtherInformation }{@code >}}
   * 
   */
  JAXBElement<StudentSDTNType.FurtherInformation> createStudentSDTNTypeFurtherInformation(StudentSDTNType.FurtherInformation value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeYoungCarersRole(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypeStudentPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSDTNType.AreasOfInterestList }{@code >}}
   * 
   */
  JAXBElement<StudentSDTNType.AreasOfInterestList> createStudentSDTNTypeAreasOfInterestList(StudentSDTNType.AreasOfInterestList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createStudentSDTNTypeYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PrincipalInfoType
   * }{@code >}}
   * 
   */
  JAXBElement<PrincipalInfoType> createStudentSDTNTypePrincipalInfo(PrincipalInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeSchoolCounsellorFileHeld(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSDTNTypeOtherLearningSupport(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeLatestStudentReportAvailable(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeNegotiatedCurriculumPlan(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSDTNType.OtherLearningAreasList }{@code >}}
   * 
   */
  JAXBElement<StudentSDTNType.OtherLearningAreasList> createStudentSDTNTypeOtherLearningAreasList(StudentSDTNType.OtherLearningAreasList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAcceleratedProgram(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsProgressLevelType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeNumeracy(AUCodeSetsProgressLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createStudentSDTNTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAdjustedEducationProgram(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeCareerGuidanceFileHeld(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSDTNTypeDepartureDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSchoolCourseInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSchoolCourseInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeInstructionalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeDepartment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeStateCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolCourseInfoTypeGraduationRequirement(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolCourseInfoTypeCoreAcademicCourse(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeTermInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSchoolCourseInfoTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SubjectAreaListType }{@code >}}
   * 
   */
  JAXBElement<SubjectAreaListType> createSchoolCourseInfoTypeSubjectAreaList(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeCourseContent(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeDistrictCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolCourseInfoTypeCourseCredits(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSchoolInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSchoolGeographicLocation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSchoolInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityClose(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.SchoolFocusList }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.SchoolFocusList> createSchoolInfoTypeSchoolFocusList(SchoolInfoType.SchoolFocusList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link PhoneNumberListType }{@code >}}
   * 
   */
  JAXBElement<PhoneNumberListType> createSchoolInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeCommonwealthId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.SchoolGroupList }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.SchoolGroupList> createSchoolInfoTypeSchoolGroupList(SchoolInfoType.SchoolGroupList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSchoolDistrict(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSystem(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsSystemicStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsSystemicStatusType> createSchoolInfoTypeNonGovSystemicStatus(AUCodeSetsSystemicStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.YearLevelEnrollmentList }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.YearLevelEnrollmentList> createSchoolInfoTypeYearLevelEnrollmentList(SchoolInfoType.YearLevelEnrollmentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeLocalGovernmentArea(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityOpen(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSLA(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.OtherIdList }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.OtherIdList> createSchoolInfoTypeOtherIdList(SchoolInfoType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeFederalElectorate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.Campus }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.Campus> createSchoolInfoTypeCampus(SchoolInfoType.Campus value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PrincipalInfoType
   * }{@code >}}
   * 
   */
  JAXBElement<PrincipalInfoType> createSchoolInfoTypePrincipalInfo(PrincipalInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeReligiousAffiliation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSchoolURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createSchoolInfoTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }
   * {@code >}}
   * 
   */
  JAXBElement<EmailListType> createSchoolInfoTypeSchoolEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsSchoolLevelType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeSchoolType(AUCodeSetsSchoolLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeIndependentSchool(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolContactListType }{@code >}}
   * 
   */
  JAXBElement<SchoolContactListType> createSchoolInfoTypeSchoolContactList(SchoolContactListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.TotalEnrollments }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.TotalEnrollments> createSchoolInfoTypeTotalEnrollments(SchoolInfoType.TotalEnrollments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createSchoolInfoTypeARIA(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsSchoolCoEdStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsSchoolCoEdStatusType> createSchoolInfoTypeSchoolCoEdStatus(AUCodeSetsSchoolCoEdStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeJurisdictionLowerHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }
   * {@code >}}
   * 
   */
  JAXBElement<AddressListType> createSchoolInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsOperationalStatusType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsOperationalStatusType> createSchoolInfoTypeOperationalStatus(AUCodeSetsOperationalStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeACARAId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSchoolDistrictLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SchoolInfoType.OtherLEA }{@code >}}
   * 
   */
  JAXBElement<SchoolInfoType.OtherLEA> createSchoolInfoTypeOtherLEA(SchoolInfoType.OtherLEA value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSchoolInfoTypeSessionType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeBoardingSchoolStatus(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAssessmentRegistrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAssessmentRegistrationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createAssessmentRegistrationTypeAssessmentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentRegistrationType.AssessmentStudentSnapshot }{@code >}}
   * 
   */
  JAXBElement<AssessmentRegistrationType.AssessmentStudentSnapshot> createAssessmentRegistrationTypeAssessmentStudentSnapshot(AssessmentRegistrationType.AssessmentStudentSnapshot value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentRegistrationTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelType> createAssessmentRegistrationTypeStudentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AssessmentRegistrationType.StudentSpecialConditions }{@code >}}
   * 
   */
  JAXBElement<AssessmentRegistrationType.StudentSpecialConditions> createAssessmentRegistrationTypeStudentSpecialConditions(AssessmentRegistrationType.StudentSpecialConditions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentRegistrationTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentRegistrationTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStaffAssignmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStaffAssignmentTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createStaffAssignmentTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffAssignmentType.StaffSubjectList }{@code >}}
   * 
   */
  JAXBElement<StaffAssignmentType.StaffSubjectList> createStaffAssignmentTypeStaffSubjectList(StaffAssignmentType.StaffSubjectList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffAssignmentTypeJobFunction(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffAssignmentTypeHomegroup(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createStaffAssignmentTypeJobFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffAssignmentTypeHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStaffAssignmentTypeCasualReliefTeacher(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStaffAssignmentTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StaffAssignmentType.StaffActivity }{@code >}}
   * 
   */
  JAXBElement<StaffAssignmentType.StaffActivity> createStaffAssignmentTypeStaffActivity(StaffAssignmentType.StaffActivity value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createLearningResourceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createLearningResourceTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }
   * {@code >}}
   * 
   */
  JAXBElement<YearLevelsType> createLearningResourceTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.LearningStandards }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.LearningStandards> createLearningResourceTypeLearningStandards(LearningResourceType.LearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.Evaluations }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.Evaluations> createLearningResourceTypeEvaluations(LearningResourceType.Evaluations value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createLearningResourceTypeAgreementDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.MediaTypes }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.MediaTypes> createLearningResourceTypeMediaTypes(LearningResourceType.MediaTypes value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.Contacts }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.Contacts> createLearningResourceTypeContacts(LearningResourceType.Contacts value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeUseAgreement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.Approvals }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.Approvals> createLearningResourceTypeApprovals(LearningResourceType.Approvals value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.SubjectAreas }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.SubjectAreas> createLearningResourceTypeSubjectAreas(LearningResourceType.SubjectAreas value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeLearningResourcePackageRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createLearningResourceTypeAuthor(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LearningResourceType.Location }{@code >}}
   * 
   */
  JAXBElement<LearningResourceType.Location> createLearningResourceTypeLocation(LearningResourceType.Location value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSIFErrorDataModelTypeSIFExtendedDesc(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudentStudentLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createStudentSnapshotTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createStudentSnapshotTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeProjectedGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link StudentSnapshotType.StudentSubjectChoiceList }{@code >}}
   * 
   */
  JAXBElement<StudentSnapshotType.StudentSubjectChoiceList> createStudentSnapshotTypeStudentSubjectChoiceList(StudentSnapshotType.StudentSubjectChoiceList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  JAXBElement<Long> createStudentSnapshotTypeAge(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeStudentSnapshotRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createStudentSnapshotTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeOnTimeGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList
   * }{@code >}}
   * 
   */
  JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList(
      SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff
   * }{@code >}}
   * 
   */
  JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff(SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student
   * }{@code >}}
   * 
   */
  JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent(
      SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createSectionInfoTypeMediumOfInstructionOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link LifeCycleType.Created.Creators }{@code >}}
   * 
   */
  JAXBElement<LifeCycleType.Created.Creators> createLifeCycleTypeCreatedCreators(LifeCycleType.Created.Creators value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createSif3StudentResponseSetTypeItemsItemCommentsCommentCommentDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createAggregateCharacteristicInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createAggregateCharacteristicInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAggregateCharacteristicInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAggregateCharacteristicInfoTypeElementName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsLivesWith(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsDisciplinaryContact(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsParentLegalGuardian(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsFamilyMail(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsInterventionOrder(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsAccessToRecords(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsEmergencyContact(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsPickupRights(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsAttendanceContact(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsFeesBilling(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsReceivesAssessmentReport(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsHasCustody(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createAssessmentRegistrationTypeAssessmentStudentSnapshotSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link XMLGregorianCalendar }{@code >}}
   * 
   */
  JAXBElement<XMLGregorianCalendar> createAssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createTermInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createTermInfoTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
   * {@code >}}
   * 
   */
  JAXBElement<BigDecimal> createTermInfoTypeRelativeDuration(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeSchedulingTerm(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTermInfoTypeTermCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTermInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeMarkingTerm(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTermInfoTypeTrack(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeAttendanceTerm(AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createTermInfoTypeTermSpan(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType
   * }{@code >}}
   * 
   */
  JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeEntryTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createSif3AssessmentItemAssociationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createSif3AssessmentItemAssociationTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }
   * {@code >}}
   * 
   */
  JAXBElement<SIFMetadataType> createFinancialAccountTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link SIFExtendedElementsType }{@code >}}
   * 
   */
  JAXBElement<SIFExtendedElementsType> createFinancialAccountTypeSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createFinancialAccountTypeChargedLocationInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createFinancialAccountTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * }
   * 
   */
  JAXBElement<String> createFinancialAccountTypeSubAccountRefId(String value);

}