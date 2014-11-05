package sif3.hits.domain.converter.factory;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import sif.dd.au30.model.*;

public interface ObjectFactory {

  /**
   * Create an instance of {@link SIFQueryDataModelType }
   * 
   */
  public abstract SIFQueryDataModelType createSIFQueryDataModelType();

  /**
   * Create an instance of {@link SIFQueryDataModelType.SIFConditionGroup }
   * 
   */
  public abstract SIFQueryDataModelType.SIFConditionGroup createSIFQueryDataModelTypeSIFConditionGroup();

  /**
   * Create an instance of {@link SIFQueryDataModelType.SIFConditionGroup.SIFConditions }
   * 
   */
  public abstract SIFQueryDataModelType.SIFConditionGroup.SIFConditions createSIFQueryDataModelTypeSIFConditionGroupSIFConditions();

  /**
   * Create an instance of {@link SIFHeaderDataModelType }
   * 
   */
  public abstract SIFHeaderDataModelType createSIFHeaderDataModelType();

  /**
   * Create an instance of {@link SIFHeaderDataModelType.SIFSecurity }
   * 
   */
  public abstract SIFHeaderDataModelType.SIFSecurity createSIFHeaderDataModelTypeSIFSecurity();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType }
   * 
   */
  public abstract SIFExtendedQueryResultsDataModelType createSIFExtendedQueryResultsDataModelType();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType.SIFRows }
   * 
   */
  public abstract SIFExtendedQueryResultsDataModelType.SIFRows createSIFExtendedQueryResultsDataModelTypeSIFRows();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType.SIFColumnHeaders }
   * 
   */
  public abstract SIFExtendedQueryResultsDataModelType.SIFColumnHeaders createSIFExtendedQueryResultsDataModelTypeSIFColumnHeaders();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType }
   * 
   */
  public abstract SIFExtendedQueryDataModelType createSIFExtendedQueryDataModelType();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFOrderBy }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFOrderBy createSIFExtendedQueryDataModelTypeSIFOrderBy();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFWhere }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFWhere createSIFExtendedQueryDataModelTypeSIFWhere();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroup();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroupSIFConditions();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFFrom createSIFExtendedQueryDataModelTypeSIFFrom();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFFrom.SIFJoin createSIFExtendedQueryDataModelTypeSIFFromSIFJoin();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn createSIFExtendedQueryDataModelTypeSIFFromSIFJoinSIFJoinOn();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFSelect }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFSelect createSIFExtendedQueryDataModelTypeSIFSelect();

  /**
   * Create an instance of {@link AbstractContentPackageType }
   * 
   */
  public abstract AbstractContentPackageType createAbstractContentPackageType();

  /**
   * Create an instance of {@link AbstractContentElementType }
   * 
   */
  public abstract AbstractContentElementType createAbstractContentElementType();

  /**
   * Create an instance of {@link IdentityType }
   * 
   */
  public abstract IdentityType createIdentityType();

  /**
   * Create an instance of {@link IdentityType.PasswordList }
   * 
   */
  public abstract IdentityType.PasswordList createIdentityTypePasswordList();

  /**
   * Create an instance of {@link IdentityType.IdentityAssertions }
   * 
   */
  public abstract IdentityType.IdentityAssertions createIdentityTypeIdentityAssertions();

  /**
   * Create an instance of {@link LocationType }
   * 
   */
  public abstract LocationType createLocationType();

  /**
   * Create an instance of {@link LEAInfoType }
   * 
   */
  public abstract LEAInfoType createLEAInfoType();

  /**
   * Create an instance of {@link LEAInfoType.LEAContactList }
   * 
   */
  public abstract LEAInfoType.LEAContactList createLEAInfoTypeLEAContactList();

  /**
   * Create an instance of {@link StudentScoreSetType }
   * 
   */
  public abstract StudentScoreSetType createStudentScoreSetType();

  /**
   * Create an instance of {@link StudentScoreSetType.Scores }
   * 
   */
  public abstract StudentScoreSetType.Scores createStudentScoreSetTypeScores();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType }
   * 
   */
  public abstract Sif3AssessmentSectionType createSif3AssessmentSectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionItems }
   * 
   */
  public abstract Sif3AssessmentSectionType.SectionItems createSif3AssessmentSectionTypeSectionItems();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionIdentifiers }
   * 
   */
  public abstract Sif3AssessmentSectionType.SectionIdentifiers createSif3AssessmentSectionTypeSectionIdentifiers();

  /**
   * Create an instance of {@link SIFExtendedElementsType }
   * 
   */
  public abstract SIFExtendedElementsType createSIFExtendedElementsType();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType }
   * 
   */
  public abstract Sif3AssessmentSubTestType createSif3AssessmentSubTestType();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.AssessmentItems }
   * 
   */
  public abstract Sif3AssessmentSubTestType.AssessmentItems createSif3AssessmentSubTestTypeAssessmentItems();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.SubTestIdentifiers }
   * 
   */
  public abstract Sif3AssessmentSubTestType.SubTestIdentifiers createSif3AssessmentSubTestTypeSubTestIdentifiers();

  /**
   * Create an instance of {@link Sif3AssessmentType }
   * 
   */
  public abstract Sif3AssessmentType createSif3AssessmentType();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentItemBanks }
   * 
   */
  public abstract Sif3AssessmentType.AssessmentItemBanks createSif3AssessmentTypeAssessmentItemBanks();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentIdentifiers }
   * 
   */
  public abstract Sif3AssessmentType.AssessmentIdentifiers createSif3AssessmentTypeAssessmentIdentifiers();

  /**
   * Create an instance of {@link StaffPersonalType }
   * 
   */
  public abstract StaffPersonalType createStaffPersonalType();

  /**
   * Create an instance of {@link StaffPersonalType.OtherIdList }
   * 
   */
  public abstract StaffPersonalType.OtherIdList createStaffPersonalTypeOtherIdList();

  /**
   * Create an instance of {@link AssessmentPackageType }
   * 
   */
  public abstract AssessmentPackageType createAssessmentPackageType();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType }
   * 
   */
  public abstract Sif3AssessmentSessionType createSif3AssessmentSessionType();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType.UnusualEvents }
   * 
   */
  public abstract Sif3AssessmentSessionType.UnusualEvents createSif3AssessmentSessionTypeUnusualEvents();

  /**
   * Create an instance of {@link StudentParticipationType }
   * 
   */
  public abstract StudentParticipationType createStudentParticipationType();

  /**
   * Create an instance of {@link StudentParticipationType.ProgramFundingSources }
   * 
   */
  public abstract StudentParticipationType.ProgramFundingSources createStudentParticipationTypeProgramFundingSources();

  /**
   * Create an instance of {@link AssessmentAdministrationType }
   * 
   */
  public abstract AssessmentAdministrationType createAssessmentAdministrationType();

  /**
   * Create an instance of {@link AssessmentAdministrationType.SpecialConditions }
   * 
   */
  public abstract AssessmentAdministrationType.SpecialConditions createAssessmentAdministrationTypeSpecialConditions();

  /**
   * Create an instance of {@link CalendarDate }
   * 
   */
  public abstract CalendarDate createCalendarDate();

  /**
   * Create an instance of {@link RoomInfoType }
   * 
   */
  public abstract RoomInfoType createRoomInfoType();

  /**
   * Create an instance of {@link StudentActivityParticipationType }
   * 
   */
  public abstract StudentActivityParticipationType createStudentActivityParticipationType();

  /**
   * Create an instance of {@link StudentSnapshotType }
   * 
   */
  public abstract StudentSnapshotType createStudentSnapshotType();

  /**
   * Create an instance of {@link StudentSnapshotType.HomeEnrollment }
   * 
   */
  public abstract StudentSnapshotType.HomeEnrollment createStudentSnapshotTypeHomeEnrollment();

  /**
   * Create an instance of {@link StudentSnapshotType.StudentSubjectChoiceList }
   * 
   */
  public abstract StudentSnapshotType.StudentSubjectChoiceList createStudentSnapshotTypeStudentSubjectChoiceList();

  /**
   * Create an instance of {@link StudentPersonalType }
   * 
   */
  public abstract StudentPersonalType createStudentPersonalType();

  /**
   * Create an instance of {@link StudentPersonalType.OtherIdList }
   * 
   */
  public abstract StudentPersonalType.OtherIdList createStudentPersonalTypeOtherIdList();

  /**
   * Create an instance of {@link StudentPersonalType.MedicalAlertMessages }
   * 
   */
  public abstract StudentPersonalType.MedicalAlertMessages createStudentPersonalTypeMedicalAlertMessages();

  /**
   * Create an instance of {@link StudentPersonalType.AlertMessages }
   * 
   */
  public abstract StudentPersonalType.AlertMessages createStudentPersonalTypeAlertMessages();

  /**
   * Create an instance of {@link StudentActivityInfoType }
   * 
   */
  public abstract StudentActivityInfoType createStudentActivityInfoType();

  /**
   * Create an instance of {@link StudentContactPersonalType }
   * 
   */
  public abstract StudentContactPersonalType createStudentContactPersonalType();

  /**
   * Create an instance of {@link StudentContactPersonalType.OtherIdList }
   * 
   */
  public abstract StudentContactPersonalType.OtherIdList createStudentContactPersonalTypeOtherIdList();

  /**
   * Create an instance of {@link SchoolContactListType }
   * 
   */
  public abstract SchoolContactListType createSchoolContactListType();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType }
   * 
   */
  public abstract Sif3StudentResponseSetType createSif3StudentResponseSetType();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items createSif3StudentResponseSetTypeItems();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item createSif3StudentResponseSetTypeItemsItem();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.FeedbackItems }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.FeedbackItems createSif3StudentResponseSetTypeItemsItemFeedbackItems();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.TraitScores }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.TraitScores createSif3StudentResponseSetTypeItemsItemTraitScores();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.Comments }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.Comments createSif3StudentResponseSetTypeItemsItemComments();

  /**
   * Create an instance of {@link TimeTableSubjectType }
   * 
   */
  public abstract TimeTableSubjectType createTimeTableSubjectType();

  /**
   * Create an instance of {@link AssessmentSubTestType }
   * 
   */
  public abstract AssessmentSubTestType createAssessmentSubTestType();

  /**
   * Create an instance of {@link AssessmentSubTestType.PerformanceLevels }
   * 
   */
  public abstract AssessmentSubTestType.PerformanceLevels createAssessmentSubTestTypePerformanceLevels();

  /**
   * Create an instance of {@link AssessmentSubTestType.PerformanceLevels.PerformanceLevel }
   * 
   */
  public abstract AssessmentSubTestType.PerformanceLevels.PerformanceLevel createAssessmentSubTestTypePerformanceLevelsPerformanceLevel();

  /**
   * Create an instance of {@link LearningStandardItemType }
   * 
   */
  public abstract LearningStandardItemType createLearningStandardItemType();

  /**
   * Create an instance of {@link LearningStandardItemType.RelatedLearningStandardItems }
   * 
   */
  public abstract LearningStandardItemType.RelatedLearningStandardItems createLearningStandardItemTypeRelatedLearningStandardItems();

  /**
   * Create an instance of {@link LearningStandardItemType.StandardIdentifier }
   * 
   */
  public abstract LearningStandardItemType.StandardIdentifier createLearningStandardItemTypeStandardIdentifier();

  /**
   * Create an instance of {@link LearningStandardItemType.Resources }
   * 
   */
  public abstract LearningStandardItemType.Resources createLearningStandardItemTypeResources();

  /**
   * Create an instance of {@link StudentSDTNType }
   * 
   */
  public abstract StudentSDTNType createStudentSDTNType();

  /**
   * Create an instance of {@link StudentSDTNType.OtherLearningAreasList }
   * 
   */
  public abstract StudentSDTNType.OtherLearningAreasList createStudentSDTNTypeOtherLearningAreasList();

  /**
   * Create an instance of {@link StudentSDTNType.AreasOfInterestList }
   * 
   */
  public abstract StudentSDTNType.AreasOfInterestList createStudentSDTNTypeAreasOfInterestList();

  /**
   * Create an instance of {@link StudentSDTNType.PreviousSchoolsList }
   * 
   */
  public abstract StudentSDTNType.PreviousSchoolsList createStudentSDTNTypePreviousSchoolsList();

  /**
   * Create an instance of {@link Sif3AssessmentFormType }
   * 
   */
  public abstract Sif3AssessmentFormType createSif3AssessmentFormType();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentSections }
   * 
   */
  public abstract Sif3AssessmentFormType.AssessmentSections createSif3AssessmentFormTypeAssessmentSections();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.FormIdentifiers }
   * 
   */
  public abstract Sif3AssessmentFormType.FormIdentifiers createSif3AssessmentFormTypeFormIdentifiers();

  /**
   * Create an instance of {@link AssessmentItemType }
   * 
   */
  public abstract AssessmentItemType createAssessmentItemType();

  /**
   * Create an instance of {@link AssessmentItemType.PerformanceLevels }
   * 
   */
  public abstract AssessmentItemType.PerformanceLevels createAssessmentItemTypePerformanceLevels();

  /**
   * Create an instance of {@link AssessmentItemType.PerformanceLevels.PerformanceLevel }
   * 
   */
  public abstract AssessmentItemType.PerformanceLevels.PerformanceLevel createAssessmentItemTypePerformanceLevelsPerformanceLevel();

  /**
   * Create an instance of {@link AssessmentItemType.ResponseChoices }
   * 
   */
  public abstract AssessmentItemType.ResponseChoices createAssessmentItemTypeResponseChoices();

  /**
   * Create an instance of {@link TimeTableType }
   * 
   */
  public abstract TimeTableType createTimeTableType();

  /**
   * Create an instance of {@link TimeTableType.TimeTableDayList }
   * 
   */
  public abstract TimeTableType.TimeTableDayList createTimeTableTypeTimeTableDayList();

  /**
   * Create an instance of {@link TimeTableType.TimeTableDayList.TimeTableDay }
   * 
   */
  public abstract TimeTableType.TimeTableDayList.TimeTableDay createTimeTableTypeTimeTableDayListTimeTableDay();

  /**
   * Create an instance of {@link TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList }
   * 
   */
  public abstract TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodList();

  /**
   * Create an instance of {@link SystemRoleType }
   * 
   */
  public abstract SystemRoleType createSystemRoleType();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList }
   * 
   */
  public abstract SystemRoleType.SystemContextList createSystemRoleTypeSystemContextList();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext }
   * 
   */
  public abstract SystemRoleType.SystemContextList.SystemContext createSystemRoleTypeSystemContextListSystemContext();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext.RoleList }
   * 
   */
  public abstract SystemRoleType.SystemContextList.SystemContext.RoleList createSystemRoleTypeSystemContextListSystemContextRoleList();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role }
   * 
   */
  public abstract SystemRoleType.SystemContextList.SystemContext.RoleList.Role createSystemRoleTypeSystemContextListSystemContextRoleListRole();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList }
   * 
   */
  public abstract SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope }
   * 
   */
  public abstract SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScope();

  /**
   * Create an instance of {@link TimeElementType }
   * 
   */
  public abstract TimeElementType createTimeElementType();

  /**
   * Create an instance of {@link TimeElementType.SpanGaps }
   * 
   */
  public abstract TimeElementType.SpanGaps createTimeElementTypeSpanGaps();

  /**
   * Create an instance of {@link AssessmentType }
   * 
   */
  public abstract AssessmentType createAssessmentType();

  /**
   * Create an instance of {@link EducationFilterType }
   * 
   */
  public abstract EducationFilterType createEducationFilterType();

  /**
   * Create an instance of {@link AddressType }
   * 
   */
  public abstract AddressType createAddressType();

  /**
   * Create an instance of {@link AddressType.StatisticalAreas }
   * 
   */
  public abstract AddressType.StatisticalAreas createAddressTypeStatisticalAreas();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType }
   * 
   */
  public abstract Sif3AssessmentRubricType createSif3AssessmentRubricType();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores }
   * 
   */
  public abstract Sif3AssessmentRubricType.Scores createSif3AssessmentRubricTypeScores();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores.Score }
   * 
   */
  public abstract Sif3AssessmentRubricType.Scores.Score createSif3AssessmentRubricTypeScoresScore();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores.Score.ScoreComments }
   * 
   */
  public abstract Sif3AssessmentRubricType.Scores.Score.ScoreComments createSif3AssessmentRubricTypeScoresScoreScoreComments();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.RubricIdentifiers }
   * 
   */
  public abstract Sif3AssessmentRubricType.RubricIdentifiers createSif3AssessmentRubricTypeRubricIdentifiers();

  /**
   * Create an instance of {@link AggregateStatisticFactType }
   * 
   */
  public abstract AggregateStatisticFactType createAggregateStatisticFactType();

  /**
   * Create an instance of {@link ResourceUsageType }
   * 
   */
  public abstract ResourceUsageType createResourceUsageType();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportLineList }
   * 
   */
  public abstract ResourceUsageType.ResourceReportLineList createResourceUsageTypeResourceReportLineList();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportLineList.ResourceReportLine }
   * 
   */
  public abstract ResourceUsageType.ResourceReportLineList.ResourceReportLine createResourceUsageTypeResourceReportLineListResourceReportLine();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportColumnList }
   * 
   */
  public abstract ResourceUsageType.ResourceReportColumnList createResourceUsageTypeResourceReportColumnList();

  /**
   * Create an instance of {@link StudentContactRelationshipType }
   * 
   */
  public abstract StudentContactRelationshipType createStudentContactRelationshipType();

  /**
   * Create an instance of {@link LearningResourceType }
   * 
   */
  public abstract LearningResourceType createLearningResourceType();

  /**
   * Create an instance of {@link LearningResourceType.Components }
   * 
   */
  public abstract LearningResourceType.Components createLearningResourceTypeComponents();

  /**
   * Create an instance of {@link LearningResourceType.Components.Component }
   * 
   */
  public abstract LearningResourceType.Components.Component createLearningResourceTypeComponentsComponent();

  /**
   * Create an instance of {@link LearningResourceType.Components.Component.AssociatedObjects }
   * 
   */
  public abstract LearningResourceType.Components.Component.AssociatedObjects createLearningResourceTypeComponentsComponentAssociatedObjects();

  /**
   * Create an instance of {@link LearningResourceType.Evaluations }
   * 
   */
  public abstract LearningResourceType.Evaluations createLearningResourceTypeEvaluations();

  /**
   * Create an instance of {@link LearningResourceType.Approvals }
   * 
   */
  public abstract LearningResourceType.Approvals createLearningResourceTypeApprovals();

  /**
   * Create an instance of {@link LearningResourceType.Contacts }
   * 
   */
  public abstract LearningResourceType.Contacts createLearningResourceTypeContacts();

  /**
   * Create an instance of {@link LearningStandardDocumentType }
   * 
   */
  public abstract LearningStandardDocumentType createLearningStandardDocumentType();

  /**
   * Create an instance of {@link AggregateStatisticInfoType }
   * 
   */
  public abstract AggregateStatisticInfoType createAggregateStatisticInfoType();

  /**
   * Create an instance of {@link AggregateStatisticInfoType.ExclusionRules }
   * 
   */
  public abstract AggregateStatisticInfoType.ExclusionRules createAggregateStatisticInfoTypeExclusionRules();

  /**
   * Create an instance of {@link Sif3AssessmentItemType }
   * 
   */
  public abstract Sif3AssessmentItemType createSif3AssessmentItemType();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentItemBanks }
   * 
   */
  public abstract Sif3AssessmentItemType.AssessmentItemBanks createSif3AssessmentItemTypeAssessmentItemBanks();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.ResponseChoices }
   * 
   */
  public abstract Sif3AssessmentItemType.ResponseChoices createSif3AssessmentItemTypeResponseChoices();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentIdentifiers }
   * 
   */
  public abstract Sif3AssessmentItemType.AssessmentIdentifiers createSif3AssessmentItemTypeAssessmentIdentifiers();

  /**
   * Create an instance of {@link AddressListType }
   * 
   */
  public abstract AddressListType createAddressListType();

  /**
   * Create an instance of {@link StudentPeriodAttendanceType }
   * 
   */
  public abstract StudentPeriodAttendanceType createStudentPeriodAttendanceType();

  /**
   * Create an instance of {@link StudentPeriodAttendanceType.AuditInfo }
   * 
   */
  public abstract StudentPeriodAttendanceType.AuditInfo createStudentPeriodAttendanceTypeAuditInfo();

  /**
   * Create an instance of {@link LifeCycleType }
   * 
   */
  public abstract LifeCycleType createLifeCycleType();

  /**
   * Create an instance of {@link LifeCycleType.ModificationHistory }
   * 
   */
  public abstract LifeCycleType.ModificationHistory createLifeCycleTypeModificationHistory();

  /**
   * Create an instance of {@link LifeCycleType.Created }
   * 
   */
  public abstract LifeCycleType.Created createLifeCycleTypeCreated();

  /**
   * Create an instance of {@link LifeCycleType.Created.Creators }
   * 
   */
  public abstract LifeCycleType.Created.Creators createLifeCycleTypeCreatedCreators();

  /**
   * Create an instance of {@link SchoolProgramsType }
   * 
   */
  public abstract SchoolProgramsType createSchoolProgramsType();

  /**
   * Create an instance of {@link SchoolProgramsType.SchoolProgramList }
   * 
   */
  public abstract SchoolProgramsType.SchoolProgramList createSchoolProgramsTypeSchoolProgramList();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationType }
   * 
   */
  public abstract Sif3AssessmentAdministrationType createSif3AssessmentAdministrationType();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationType.Organizations }
   * 
   */
  public abstract Sif3AssessmentAdministrationType.Organizations createSif3AssessmentAdministrationTypeOrganizations();

  /**
   * Create an instance of {@link AssessmentFormType }
   * 
   */
  public abstract AssessmentFormType createAssessmentFormType();

  /**
   * Create an instance of {@link SIFMetadataType }
   * 
   */
  public abstract SIFMetadataType createSIFMetadataType();

  /**
   * Create an instance of {@link PhoneNumberListType }
   * 
   */
  public abstract PhoneNumberListType createPhoneNumberListType();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType }
   * 
   */
  public abstract Sif3AssessmentRegistrationType createSif3AssessmentRegistrationType();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.AssessmentStudentSnapshot createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollment();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.TestingStatuses }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.TestingStatuses createSif3AssessmentRegistrationTypeTestingStatuses();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.StudentSpecialEvents }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.StudentSpecialEvents createSif3AssessmentRegistrationTypeStudentSpecialEvents();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType }
   * 
   */
  public abstract SummaryEnrollmentInfoType createSummaryEnrollmentInfoType();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList }
   * 
   */
  public abstract SummaryEnrollmentInfoType.SchoolEnrollmentList createSummaryEnrollmentInfoTypeSchoolEnrollmentList();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment }
   * 
   */
  public abstract SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollment();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList }
   * 
   */
  public abstract SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList();

  /**
   * Create an instance of {@link PersonPictureType }
   * 
   */
  public abstract PersonPictureType createPersonPictureType();

  /**
   * Create an instance of {@link SIFReportObjectType }
   * 
   */
  public abstract SIFReportObjectType createSIFReportObjectType();

  /**
   * Create an instance of {@link SIFReportObjectType.ReportInfo }
   * 
   */
  public abstract SIFReportObjectType.ReportInfo createSIFReportObjectTypeReportInfo();

  /**
   * Create an instance of {@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo }
   * 
   */
  public abstract SIFReportObjectType.ReportInfo.ReportSubmitterInfo createSIFReportObjectTypeReportInfoReportSubmitterInfo();

  /**
   * Create an instance of {@link OtherCodeListType }
   * 
   */
  public abstract OtherCodeListType createOtherCodeListType();

  /**
   * Create an instance of {@link ReportManifestType }
   * 
   */
  public abstract ReportManifestType createReportManifestType();

  /**
   * Create an instance of {@link ReportManifestType.ReportFormatList }
   * 
   */
  public abstract ReportManifestType.ReportFormatList createReportManifestTypeReportFormatList();

  /**
   * Create an instance of {@link OtherNamesType }
   * 
   */
  public abstract OtherNamesType createOtherNamesType();

  /**
   * Create an instance of {@link ActivityType }
   * 
   */
  public abstract ActivityType createActivityType();

  /**
   * Create an instance of {@link ActivityType.ActivityTime }
   * 
   */
  public abstract ActivityType.ActivityTime createActivityTypeActivityTime();

  /**
   * Create an instance of {@link ActivityType.SourceObjects }
   * 
   */
  public abstract ActivityType.SourceObjects createActivityTypeSourceObjects();

  /**
   * Create an instance of {@link ActivityType.SoftwareRequirementList }
   * 
   */
  public abstract ActivityType.SoftwareRequirementList createActivityTypeSoftwareRequirementList();

  /**
   * Create an instance of {@link AssessmentRegistrationType }
   * 
   */
  public abstract AssessmentRegistrationType createAssessmentRegistrationType();

  /**
   * Create an instance of {@link AssessmentRegistrationType.StudentSpecialConditions }
   * 
   */
  public abstract AssessmentRegistrationType.StudentSpecialConditions createAssessmentRegistrationTypeStudentSpecialConditions();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType }
   * 
   */
  public abstract Sif3AssessmentScoreTableType createSif3AssessmentScoreTableType();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreValues }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreValues createSif3AssessmentScoreTableTypeScoreValues();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreValues.ScoreValue createSif3AssessmentScoreTableTypeScoreValuesScoreValue();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreTableIdentifiers }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreTableIdentifiers createSif3AssessmentScoreTableTypeScoreTableIdentifiers();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType }
   * 
   */
  public abstract StudentSchoolEnrollmentType createStudentSchoolEnrollmentType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.StudentSubjectChoiceList }
   * 
   */
  public abstract StudentSchoolEnrollmentType.StudentSubjectChoiceList createStudentSchoolEnrollmentTypeStudentSubjectChoiceList();

  /**
   * Create an instance of {@link SectionInfoType }
   * 
   */
  public abstract SectionInfoType createSectionInfoType();

  /**
   * Create an instance of {@link StaffAssignmentType }
   * 
   */
  public abstract StaffAssignmentType createStaffAssignmentType();

  /**
   * Create an instance of {@link StaffAssignmentType.StaffSubjectList }
   * 
   */
  public abstract StaffAssignmentType.StaffSubjectList createStaffAssignmentTypeStaffSubjectList();

  /**
   * Create an instance of {@link EmailListType }
   * 
   */
  public abstract EmailListType createEmailListType();

  /**
   * Create an instance of {@link ScheduledActivityType }
   * 
   */
  public abstract ScheduledActivityType createScheduledActivityType();

  /**
   * Create an instance of {@link ScheduledActivityType.TeacherList }
   * 
   */
  public abstract ScheduledActivityType.TeacherList createScheduledActivityTypeTeacherList();

  /**
   * Create an instance of {@link TeachingGroupType }
   * 
   */
  public abstract TeachingGroupType createTeachingGroupType();

  /**
   * Create an instance of {@link TeachingGroupType.TeachingGroupPeriodList }
   * 
   */
  public abstract TeachingGroupType.TeachingGroupPeriodList createTeachingGroupTypeTeachingGroupPeriodList();

  /**
   * Create an instance of {@link TeachingGroupType.TeacherList }
   * 
   */
  public abstract TeachingGroupType.TeacherList createTeachingGroupTypeTeacherList();

  /**
   * Create an instance of {@link TeachingGroupType.StudentList }
   * 
   */
  public abstract TeachingGroupType.StudentList createTeachingGroupTypeStudentList();

  /**
   * Create an instance of {@link DemographicsType }
   * 
   */
  public abstract DemographicsType createDemographicsType();

  /**
   * Create an instance of {@link DemographicsType.ReligiousEventList }
   * 
   */
  public abstract DemographicsType.ReligiousEventList createDemographicsTypeReligiousEventList();

  /**
   * Create an instance of {@link LanguageListType }
   * 
   */
  public abstract LanguageListType createLanguageListType();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType }
   * 
   */
  public abstract Sif3AssessmentAssetType createSif3AssessmentAssetType();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType.AssetIdentifiers }
   * 
   */
  public abstract Sif3AssessmentAssetType.AssetIdentifiers createSif3AssessmentAssetTypeAssetIdentifiers();

  /**
   * Create an instance of {@link SIFQueryType }
   * 
   */
  public abstract SIFQueryType createSIFQueryType();

  /**
   * Create an instance of {@link SIFQueryType.SIFConditionGroup }
   * 
   */
  public abstract SIFQueryType.SIFConditionGroup createSIFQueryTypeSIFConditionGroup();

  /**
   * Create an instance of {@link SIFQueryType.SIFConditionGroup.SIFConditions }
   * 
   */
  public abstract SIFQueryType.SIFConditionGroup.SIFConditions createSIFQueryTypeSIFConditionGroupSIFConditions();

  /**
   * Create an instance of {@link SchoolInfoType }
   * 
   */
  public abstract SchoolInfoType createSchoolInfoType();

  /**
   * Create an instance of {@link SchoolInfoType.OtherIdList }
   * 
   */
  public abstract SchoolInfoType.OtherIdList createSchoolInfoTypeOtherIdList();

  /**
   * Create an instance of {@link Sif3AssessmentItemAssociationCollectionType }
   * 
   */
  public abstract Sif3AssessmentItemAssociationCollectionType createSif3AssessmentItemAssociationCollectionType();

  /**
   * Create an instance of {@link StudentSnapshotCollectionType }
   * 
   */
  public abstract StudentSnapshotCollectionType createStudentSnapshotCollectionType();

  /**
   * Create an instance of {@link CalendarSummaryType }
   * 
   */
  public abstract CalendarSummaryType createCalendarSummaryType();

  /**
   * Create an instance of {@link TermInfoCollectionType }
   * 
   */
  public abstract TermInfoCollectionType createTermInfoCollectionType();

  /**
   * Create an instance of {@link StudentCollectionType }
   * 
   */
  public abstract StudentCollectionType createStudentCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestCollectionType }
   * 
   */
  public abstract Sif3AssessmentSubTestCollectionType createSif3AssessmentSubTestCollectionType();

  /**
   * Create an instance of {@link SubjectAreaType }
   * 
   */
  public abstract SubjectAreaType createSubjectAreaType();

  /**
   * Create an instance of {@link StudentScoreSetCollectionType }
   * 
   */
  public abstract StudentScoreSetCollectionType createStudentScoreSetCollectionType();

  /**
   * Create an instance of {@link LearningResourcePackageType }
   * 
   */
  public abstract LearningResourcePackageType createLearningResourcePackageType();

  /**
   * Create an instance of {@link ReportAuthorityInfoCollectionType }
   * 
   */
  public abstract ReportAuthorityInfoCollectionType createReportAuthorityInfoCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentItemAssociationType }
   * 
   */
  public abstract Sif3AssessmentItemAssociationType createSif3AssessmentItemAssociationType();

  /**
   * Create an instance of {@link SchoolCourseInfoCollectionType }
   * 
   */
  public abstract SchoolCourseInfoCollectionType createSchoolCourseInfoCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSessionCollectionType }
   * 
   */
  public abstract Sif3AssessmentSessionCollectionType createSif3AssessmentSessionCollectionType();

  /**
   * Create an instance of {@link TeachingGroupCollectionType }
   * 
   */
  public abstract TeachingGroupCollectionType createTeachingGroupCollectionType();

  /**
   * Create an instance of {@link PhoneNumberType }
   * 
   */
  public abstract PhoneNumberType createPhoneNumberType();

  /**
   * Create an instance of {@link SubjectAreaListType }
   * 
   */
  public abstract SubjectAreaListType createSubjectAreaListType();

  /**
   * Create an instance of {@link EmailType }
   * 
   */
  public abstract EmailType createEmailType();

  /**
   * Create an instance of {@link StudentActivityInfoCollectionType }
   * 
   */
  public abstract StudentActivityInfoCollectionType createStudentActivityInfoCollectionType();

  /**
   * Create an instance of {@link AssessmentRegistrationCollectionType }
   * 
   */
  public abstract AssessmentRegistrationCollectionType createAssessmentRegistrationCollectionType();

  /**
   * Create an instance of {@link AssessmentFormCollectionType }
   * 
   */
  public abstract AssessmentFormCollectionType createAssessmentFormCollectionType();

  /**
   * Create an instance of {@link TimeTableSubjectCollectionType }
   * 
   */
  public abstract TimeTableSubjectCollectionType createTimeTableSubjectCollectionType();

  /**
   * Create an instance of {@link StudentParticipationCollectionType }
   * 
   */
  public abstract StudentParticipationCollectionType createStudentParticipationCollectionType();

  /**
   * Create an instance of {@link StaffCollectionType }
   * 
   */
  public abstract StaffCollectionType createStaffCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentRubricCollectionType }
   * 
   */
  public abstract Sif3AssessmentRubricCollectionType createSif3AssessmentRubricCollectionType();

  /**
   * Create an instance of {@link AssessmentAdministrationCollectionType }
   * 
   */
  public abstract AssessmentAdministrationCollectionType createAssessmentAdministrationCollectionType();

  /**
   * Create an instance of {@link StudentDailyAttendanceCollectionType }
   * 
   */
  public abstract StudentDailyAttendanceCollectionType createStudentDailyAttendanceCollectionType();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoCollectionType }
   * 
   */
  public abstract SummaryEnrollmentInfoCollectionType createSummaryEnrollmentInfoCollectionType();

  /**
   * Create an instance of {@link StudentContactRelationshipCollectionType }
   * 
   */
  public abstract StudentContactRelationshipCollectionType createStudentContactRelationshipCollectionType();

  /**
   * Create an instance of {@link StaffAssignmentCollectionType }
   * 
   */
  public abstract StaffAssignmentCollectionType createStaffAssignmentCollectionType();

  /**
   * Create an instance of {@link CalendarSummaryCollectionType }
   * 
   */
  public abstract CalendarSummaryCollectionType createCalendarSummaryCollectionType();

  /**
   * Create an instance of {@link StudentAttendanceSummaryType }
   * 
   */
  public abstract StudentAttendanceSummaryType createStudentAttendanceSummaryType();

  /**
   * Create an instance of {@link AggregateStatisticFactCollectionType }
   * 
   */
  public abstract AggregateStatisticFactCollectionType createAggregateStatisticFactCollectionType();

  /**
   * Create an instance of {@link ReportManifestCollectionType }
   * 
   */
  public abstract ReportManifestCollectionType createReportManifestCollectionType();

  /**
   * Create an instance of {@link AggregateCharacteristicInfoCollectionType }
   * 
   */
  public abstract AggregateCharacteristicInfoCollectionType createAggregateCharacteristicInfoCollectionType();

  /**
   * Create an instance of {@link LearningResourcePackageCollectionType }
   * 
   */
  public abstract LearningResourcePackageCollectionType createLearningResourcePackageCollectionType();

  /**
   * Create an instance of {@link AggregateCharacteristicInfoType }
   * 
   */
  public abstract AggregateCharacteristicInfoType createAggregateCharacteristicInfoType();

  /**
   * Create an instance of {@link IdentityCollectionType }
   * 
   */
  public abstract IdentityCollectionType createIdentityCollectionType();

  /**
   * Create an instance of {@link AggregateStatisticInfoCollectionType }
   * 
   */
  public abstract AggregateStatisticInfoCollectionType createAggregateStatisticInfoCollectionType();

  /**
   * Create an instance of {@link ElectronicIdListType }
   * 
   */
  public abstract ElectronicIdListType createElectronicIdListType();

  /**
   * Create an instance of {@link ElectronicIdType }
   * 
   */
  public abstract ElectronicIdType createElectronicIdType();

  /**
   * Create an instance of {@link AttendanceCodeType }
   * 
   */
  public abstract AttendanceCodeType createAttendanceCodeType();

  /**
   * Create an instance of {@link ACStrandSubjectAreaType }
   * 
   */
  public abstract ACStrandSubjectAreaType createACStrandSubjectAreaType();

  /**
   * Create an instance of {@link ResourceUsageCollectionType }
   * 
   */
  public abstract ResourceUsageCollectionType createResourceUsageCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableCollectionType }
   * 
   */
  public abstract Sif3AssessmentScoreTableCollectionType createSif3AssessmentScoreTableCollectionType();

  /**
   * Create an instance of {@link TimeTableCellCollectionType }
   * 
   */
  public abstract TimeTableCellCollectionType createTimeTableCellCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentCollectionType }
   * 
   */
  public abstract Sif3AssessmentCollectionType createSif3AssessmentCollectionType();

  /**
   * Create an instance of {@link YearLevelType }
   * 
   */
  public abstract YearLevelType createYearLevelType();

  /**
   * Create an instance of {@link SessionInfoType }
   * 
   */
  public abstract SessionInfoType createSessionInfoType();

  /**
   * Create an instance of {@link RoomInfoCollectionType }
   * 
   */
  public abstract RoomInfoCollectionType createRoomInfoCollectionType();

  /**
   * Create an instance of {@link AssessmentItemCollectionType }
   * 
   */
  public abstract AssessmentItemCollectionType createAssessmentItemCollectionType();

  /**
   * Create an instance of {@link LearningStandardDocumentCollectionType }
   * 
   */
  public abstract LearningStandardDocumentCollectionType createLearningStandardDocumentCollectionType();

  /**
   * Create an instance of {@link StudentActivityParticipationCollectionType }
   * 
   */
  public abstract StudentActivityParticipationCollectionType createStudentActivityParticipationCollectionType();

  /**
   * Create an instance of {@link TimeTableCellType }
   * 
   */
  public abstract TimeTableCellType createTimeTableCellType();

  /**
   * Create an instance of {@link SchoolProgramsCollectionType }
   * 
   */
  public abstract SchoolProgramsCollectionType createSchoolProgramsCollectionType();

  /**
   * Create an instance of {@link LearningStandardItemCollectionType }
   * 
   */
  public abstract LearningStandardItemCollectionType createLearningStandardItemCollectionType();

  /**
   * Create an instance of {@link StudentSectionEnrollmentCollectionType }
   * 
   */
  public abstract StudentSectionEnrollmentCollectionType createStudentSectionEnrollmentCollectionType();

  /**
   * Create an instance of {@link Sif3StudentResponseSetCollectionType }
   * 
   */
  public abstract Sif3StudentResponseSetCollectionType createSif3StudentResponseSetCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentAssetCollectionType }
   * 
   */
  public abstract Sif3AssessmentAssetCollectionType createSif3AssessmentAssetCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentFormCollectionType }
   * 
   */
  public abstract Sif3AssessmentFormCollectionType createSif3AssessmentFormCollectionType();

  /**
   * Create an instance of {@link SIFContextsType }
   * 
   */
  public abstract SIFContextsType createSIFContextsType();

  /**
   * Create an instance of {@link YearLevelsType }
   * 
   */
  public abstract YearLevelsType createYearLevelsType();

  /**
   * Create an instance of {@link Sif3AssessmentItemCollectionType }
   * 
   */
  public abstract Sif3AssessmentItemCollectionType createSif3AssessmentItemCollectionType();

  /**
   * Create an instance of {@link RelationshipType }
   * 
   */
  public abstract RelationshipType createRelationshipType();

  /**
   * Create an instance of {@link ContactInfoType }
   * 
   */
  public abstract ContactInfoType createContactInfoType();

  /**
   * Create an instance of {@link CalendarDateCollectionType }
   * 
   */
  public abstract CalendarDateCollectionType createCalendarDateCollectionType();

  /**
   * Create an instance of {@link AssessmentSubTestCollectionType }
   * 
   */
  public abstract AssessmentSubTestCollectionType createAssessmentSubTestCollectionType();

  /**
   * Create an instance of {@link StudentPeriodAttendanceCollectionType }
   * 
   */
  public abstract StudentPeriodAttendanceCollectionType createStudentPeriodAttendanceCollectionType();

  /**
   * Create an instance of {@link TermInfoType }
   * 
   */
  public abstract TermInfoType createTermInfoType();

  /**
   * Create an instance of {@link AssessmentPackageCollectionType }
   * 
   */
  public abstract AssessmentPackageCollectionType createAssessmentPackageCollectionType();

  /**
   * Create an instance of {@link SectionInfoCollectionType }
   * 
   */
  public abstract SectionInfoCollectionType createSectionInfoCollectionType();

  /**
   * Create an instance of {@link GridLocationType }
   * 
   */
  public abstract GridLocationType createGridLocationType();

  /**
   * Create an instance of {@link SystemRoleCollectionType }
   * 
   */
  public abstract SystemRoleCollectionType createSystemRoleCollectionType();

  /**
   * Create an instance of {@link PersonPictureCollectionType }
   * 
   */
  public abstract PersonPictureCollectionType createPersonPictureCollectionType();

  /**
   * Create an instance of {@link StudentContactCollectionType }
   * 
   */
  public abstract StudentContactCollectionType createStudentContactCollectionType();

  /**
   * Create an instance of {@link PrincipalInfoType }
   * 
   */
  public abstract PrincipalInfoType createPrincipalInfoType();

  /**
   * Create an instance of {@link StudentAttendanceSummaryCollectionType }
   * 
   */
  public abstract StudentAttendanceSummaryCollectionType createStudentAttendanceSummaryCollectionType();

  /**
   * Create an instance of {@link ReportAuthorityInfoType }
   * 
   */
  public abstract ReportAuthorityInfoType createReportAuthorityInfoType();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationCollectionType }
   * 
   */
  public abstract Sif3AssessmentAdministrationCollectionType createSif3AssessmentAdministrationCollectionType();

  /**
   * Create an instance of {@link AssessmentCollectionType }
   * 
   */
  public abstract AssessmentCollectionType createAssessmentCollectionType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentCollectionType }
   * 
   */
  public abstract StudentSchoolEnrollmentCollectionType createStudentSchoolEnrollmentCollectionType();

  /**
   * Create an instance of {@link EnglishProficiencyType }
   * 
   */
  public abstract EnglishProficiencyType createEnglishProficiencyType();

  /**
   * Create an instance of {@link LEAInfoCollectionType }
   * 
   */
  public abstract LEAInfoCollectionType createLEAInfoCollectionType();

  /**
   * Create an instance of {@link LearningResourceCollectionType }
   * 
   */
  public abstract LearningResourceCollectionType createLearningResourceCollectionType();

  /**
   * Create an instance of {@link StudentSDTNCollectionType }
   * 
   */
  public abstract StudentSDTNCollectionType createStudentSDTNCollectionType();

  /**
   * Create an instance of {@link StudentDailyAttendanceType }
   * 
   */
  public abstract StudentDailyAttendanceType createStudentDailyAttendanceType();

  /**
   * Create an instance of {@link StudentSectionEnrollmentType }
   * 
   */
  public abstract StudentSectionEnrollmentType createStudentSectionEnrollmentType();

  /**
   * Create an instance of {@link SchoolCourseInfoType }
   * 
   */
  public abstract SchoolCourseInfoType createSchoolCourseInfoType();

  /**
   * Create an instance of {@link TimeTableCollectionType }
   * 
   */
  public abstract TimeTableCollectionType createTimeTableCollectionType();

  /**
   * Create an instance of {@link SchoolCollectionType }
   * 
   */
  public abstract SchoolCollectionType createSchoolCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentSectionCollectionType }
   * 
   */
  public abstract Sif3AssessmentSectionCollectionType createSif3AssessmentSectionCollectionType();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationCollectionType }
   * 
   */
  public abstract Sif3AssessmentRegistrationCollectionType createSif3AssessmentRegistrationCollectionType();

  /**
   * Create an instance of {@link SessionInfoCollectionType }
   * 
   */
  public abstract SessionInfoCollectionType createSessionInfoCollectionType();

  /**
   * Create an instance of {@link ProgramStatusType }
   * 
   */
  public abstract ProgramStatusType createProgramStatusType();

  /**
   * Create an instance of {@link NameType }
   * 
   */
  public abstract NameType createNameType();

  /**
   * Create an instance of {@link ScheduledActivityCollectionType }
   * 
   */
  public abstract ScheduledActivityCollectionType createScheduledActivityCollectionType();

  /**
   * Create an instance of {@link ActivityCollectionType }
   * 
   */
  public abstract ActivityCollectionType createActivityCollectionType();

  /**
   * Create an instance of {@link SIFReportObjectCollectionType }
   * 
   */
  public abstract SIFReportObjectCollectionType createSIFReportObjectCollectionType();

  /**
   * Create an instance of {@link PersonInfoType }
   * 
   */
  public abstract PersonInfoType createPersonInfoType();

  /**
   * Create an instance of {@link SelectedContentType }
   * 
   */
  public abstract SelectedContentType createSelectedContentType();

  /**
   * Create an instance of {@link MonetaryAmountType }
   * 
   */
  public abstract MonetaryAmountType createMonetaryAmountType();

  /**
   * Create an instance of {@link SIFErrorDataModelType }
   * 
   */
  public abstract SIFErrorDataModelType createSIFErrorDataModelType();

  /**
   * Create an instance of {@link ReportPackageType }
   * 
   */
  public abstract ReportPackageType createReportPackageType();

  /**
   * Create an instance of {@link ExtendedContentType }
   * 
   */
  public abstract ExtendedContentType createExtendedContentType();

  /**
   * Create an instance of {@link BaseNameType }
   * 
   */
  public abstract BaseNameType createBaseNameType();

  /**
   * Create an instance of {@link NameOfRecordType }
   * 
   */
  public abstract NameOfRecordType createNameOfRecordType();

  /**
   * Create an instance of {@link ReportDataObjectType }
   * 
   */
  public abstract ReportDataObjectType createReportDataObjectType();

  /**
   * Create an instance of {@link OtherNameType }
   * 
   */
  public abstract OtherNameType createOtherNameType();

  /**
   * Create an instance of {@link ObjectType }
   * 
   */
  public abstract ObjectType createObjectType();

  /**
   * Create an instance of {@link SIFQueryDataModelType.SIFQueryObject }
   * 
   */
  public abstract SIFQueryDataModelType.SIFQueryObject createSIFQueryDataModelTypeSIFQueryObject();

  /**
   * Create an instance of {@link SIFQueryDataModelType.SIFConditionGroup.SIFConditions.SIFCondition }
   * 
   */
  public abstract SIFQueryDataModelType.SIFConditionGroup.SIFConditions.SIFCondition createSIFQueryDataModelTypeSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of {@link SIFHeaderDataModelType.SIFSecurity.SIFSecureChannel }
   * 
   */
  public abstract SIFHeaderDataModelType.SIFSecurity.SIFSecureChannel createSIFHeaderDataModelTypeSIFSecuritySIFSecureChannel();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType.SIFRows.R }
   * 
   */
  public abstract SIFExtendedQueryResultsDataModelType.SIFRows.R createSIFExtendedQueryResultsDataModelTypeSIFRowsR();

  /**
   * Create an instance of {@link SIFExtendedQueryResultsDataModelType.SIFColumnHeaders.SIFElement }
   * 
   */
  public abstract SIFExtendedQueryResultsDataModelType.SIFColumnHeaders.SIFElement createSIFExtendedQueryResultsDataModelTypeSIFColumnHeadersSIFElement();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFOrderBy.SIFElement }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFOrderBy.SIFElement createSIFExtendedQueryDataModelTypeSIFOrderBySIFElement();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement createSIFExtendedQueryDataModelTypeSIFWhereSIFConditionGroupSIFConditionsSIFConditionSIFElement();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement createSIFExtendedQueryDataModelTypeSIFFromSIFJoinSIFJoinOnSIFLeftElement();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement createSIFExtendedQueryDataModelTypeSIFFromSIFJoinSIFJoinOnSIFRightElement();

  /**
   * Create an instance of {@link SIFExtendedQueryDataModelType.SIFSelect.SIFElement }
   * 
   */
  public abstract SIFExtendedQueryDataModelType.SIFSelect.SIFElement createSIFExtendedQueryDataModelTypeSIFSelectSIFElement();

  /**
   * Create an instance of {@link AbstractContentPackageType.XMLData }
   * 
   */
  public abstract AbstractContentPackageType.XMLData createAbstractContentPackageTypeXMLData();

  /**
   * Create an instance of {@link AbstractContentPackageType.TextData }
   * 
   */
  public abstract AbstractContentPackageType.TextData createAbstractContentPackageTypeTextData();

  /**
   * Create an instance of {@link AbstractContentPackageType.BinaryData }
   * 
   */
  public abstract AbstractContentPackageType.BinaryData createAbstractContentPackageTypeBinaryData();

  /**
   * Create an instance of {@link AbstractContentPackageType.Reference }
   * 
   */
  public abstract AbstractContentPackageType.Reference createAbstractContentPackageTypeReference();

  /**
   * Create an instance of {@link AbstractContentElementType.XMLData }
   * 
   */
  public abstract AbstractContentElementType.XMLData createAbstractContentElementTypeXMLData();

  /**
   * Create an instance of {@link AbstractContentElementType.TextData }
   * 
   */
  public abstract AbstractContentElementType.TextData createAbstractContentElementTypeTextData();

  /**
   * Create an instance of {@link AbstractContentElementType.BinaryData }
   * 
   */
  public abstract AbstractContentElementType.BinaryData createAbstractContentElementTypeBinaryData();

  /**
   * Create an instance of {@link AbstractContentElementType.Reference }
   * 
   */
  public abstract AbstractContentElementType.Reference createAbstractContentElementTypeReference();

  /**
   * Create an instance of {@link IdentityType.SIFRefId }
   * 
   */
  public abstract IdentityType.SIFRefId createIdentityTypeSIFRefId();

  /**
   * Create an instance of {@link IdentityType.PasswordList.Password }
   * 
   */
  public abstract IdentityType.PasswordList.Password createIdentityTypePasswordListPassword();

  /**
   * Create an instance of {@link IdentityType.IdentityAssertions.IdentityAssertion }
   * 
   */
  public abstract IdentityType.IdentityAssertions.IdentityAssertion createIdentityTypeIdentityAssertionsIdentityAssertion();

  /**
   * Create an instance of {@link LocationType.LocationRefId }
   * 
   */
  public abstract LocationType.LocationRefId createLocationTypeLocationRefId();

  /**
   * Create an instance of {@link LEAInfoType.EducationAgencyType }
   * 
   */
  public abstract LEAInfoType.EducationAgencyType createLEAInfoTypeEducationAgencyType();

  /**
   * Create an instance of {@link LEAInfoType.LEAContactList.LEAContact }
   * 
   */
  public abstract LEAInfoType.LEAContactList.LEAContact createLEAInfoTypeLEAContactListLEAContact();

  /**
   * Create an instance of {@link StudentScoreSetType.Scores.Score }
   * 
   */
  public abstract StudentScoreSetType.Scores.Score createStudentScoreSetTypeScoresScore();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionAssets }
   * 
   */
  public abstract Sif3AssessmentSectionType.SectionAssets createSif3AssessmentSectionTypeSectionAssets();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionItems.SectionItem }
   * 
   */
  public abstract Sif3AssessmentSectionType.SectionItems.SectionItem createSif3AssessmentSectionTypeSectionItemsSectionItem();

  /**
   * Create an instance of {@link Sif3AssessmentSectionType.SectionIdentifiers.SectionIdentifier }
   * 
   */
  public abstract Sif3AssessmentSectionType.SectionIdentifiers.SectionIdentifier createSif3AssessmentSectionTypeSectionIdentifiersSectionIdentifier();

  /**
   * Create an instance of {@link SIFExtendedElementsType.SIFExtendedElement }
   * 
   */
  public abstract SIFExtendedElementsType.SIFExtendedElement createSIFExtendedElementsTypeSIFExtendedElement();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.ScoreReporting }
   * 
   */
  public abstract Sif3AssessmentSubTestType.ScoreReporting createSif3AssessmentSubTestTypeScoreReporting();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.AssessmentSubTestRefIds }
   * 
   */
  public abstract Sif3AssessmentSubTestType.AssessmentSubTestRefIds createSif3AssessmentSubTestTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.LearningStandardItemRefIds }
   * 
   */
  public abstract Sif3AssessmentSubTestType.LearningStandardItemRefIds createSif3AssessmentSubTestTypeLearningStandardItemRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.AssessmentItems.AssessmentItem }
   * 
   */
  public abstract Sif3AssessmentSubTestType.AssessmentItems.AssessmentItem createSif3AssessmentSubTestTypeAssessmentItemsAssessmentItem();

  /**
   * Create an instance of {@link Sif3AssessmentSubTestType.SubTestIdentifiers.SubTestIdentifier }
   * 
   */
  public abstract Sif3AssessmentSubTestType.SubTestIdentifiers.SubTestIdentifier createSif3AssessmentSubTestTypeSubTestIdentifiersSubTestIdentifier();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentDescriptors }
   * 
   */
  public abstract Sif3AssessmentType.AssessmentDescriptors createSif3AssessmentTypeAssessmentDescriptors();

  /**
   * Create an instance of {@link Sif3AssessmentType.LearningStandardItemRefIds }
   * 
   */
  public abstract Sif3AssessmentType.LearningStandardItemRefIds createSif3AssessmentTypeLearningStandardItemRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentItemBanks.AssessmentItemBank }
   * 
   */
  public abstract Sif3AssessmentType.AssessmentItemBanks.AssessmentItemBank createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBank();

  /**
   * Create an instance of {@link Sif3AssessmentType.AssessmentIdentifiers.AssessmentIdentifier }
   * 
   */
  public abstract Sif3AssessmentType.AssessmentIdentifiers.AssessmentIdentifier createSif3AssessmentTypeAssessmentIdentifiersAssessmentIdentifier();

  /**
   * Create an instance of {@link StaffPersonalType.OtherIdList.OtherId }
   * 
   */
  public abstract StaffPersonalType.OtherIdList.OtherId createStaffPersonalTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link AssessmentPackageType.XMLData }
   * 
   */
  public abstract AssessmentPackageType.XMLData createAssessmentPackageTypeXMLData();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType.StaffPersonalRefIds }
   * 
   */
  public abstract Sif3AssessmentSessionType.StaffPersonalRefIds createSif3AssessmentSessionTypeStaffPersonalRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentSessionType.UnusualEvents.UnusualEvent }
   * 
   */
  public abstract Sif3AssessmentSessionType.UnusualEvents.UnusualEvent createSif3AssessmentSessionTypeUnusualEventsUnusualEvent();

  /**
   * Create an instance of {@link StudentParticipationType.ManagingSchool }
   * 
   */
  public abstract StudentParticipationType.ManagingSchool createStudentParticipationTypeManagingSchool();

  /**
   * Create an instance of {@link StudentParticipationType.ReferralSource }
   * 
   */
  public abstract StudentParticipationType.ReferralSource createStudentParticipationTypeReferralSource();

  /**
   * Create an instance of {@link StudentParticipationType.ProgramAvailability }
   * 
   */
  public abstract StudentParticipationType.ProgramAvailability createStudentParticipationTypeProgramAvailability();

  /**
   * Create an instance of {@link StudentParticipationType.ProgramFundingSources.ProgramFundingSource }
   * 
   */
  public abstract StudentParticipationType.ProgramFundingSources.ProgramFundingSource createStudentParticipationTypeProgramFundingSourcesProgramFundingSource();

  /**
   * Create an instance of {@link AssessmentAdministrationType.SpecialConditions.SpecialCondition }
   * 
   */
  public abstract AssessmentAdministrationType.SpecialConditions.SpecialCondition createAssessmentAdministrationTypeSpecialConditionsSpecialCondition();

  /**
   * Create an instance of {@link CalendarDate.CalendarDateType }
   * 
   */
  public abstract CalendarDate.CalendarDateType createCalendarDateCalendarDateType();

  /**
   * Create an instance of {@link CalendarDate.StudentAttendance }
   * 
   */
  public abstract CalendarDate.StudentAttendance createCalendarDateStudentAttendance();

  /**
   * Create an instance of {@link CalendarDate.TeacherAttendance }
   * 
   */
  public abstract CalendarDate.TeacherAttendance createCalendarDateTeacherAttendance();

  /**
   * Create an instance of {@link CalendarDate.AdministratorAttendance }
   * 
   */
  public abstract CalendarDate.AdministratorAttendance createCalendarDateAdministratorAttendance();

  /**
   * Create an instance of {@link RoomInfoType.StaffList }
   * 
   */
  public abstract RoomInfoType.StaffList createRoomInfoTypeStaffList();

  /**
   * Create an instance of {@link StudentActivityParticipationType.RecognitionList }
   * 
   */
  public abstract StudentActivityParticipationType.RecognitionList createStudentActivityParticipationTypeRecognitionList();

  /**
   * Create an instance of {@link StudentSnapshotType.HomeEnrollment.Homeroom }
   * 
   */
  public abstract StudentSnapshotType.HomeEnrollment.Homeroom createStudentSnapshotTypeHomeEnrollmentHomeroom();

  /**
   * Create an instance of {@link StudentSnapshotType.StudentSubjectChoiceList.StudentSubjectChoice }
   * 
   */
  public abstract StudentSnapshotType.StudentSubjectChoiceList.StudentSubjectChoice createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoice();

  /**
   * Create an instance of {@link StudentPersonalType.MostRecent }
   * 
   */
  public abstract StudentPersonalType.MostRecent createStudentPersonalTypeMostRecent();

  /**
   * Create an instance of {@link StudentPersonalType.OtherIdList.OtherId }
   * 
   */
  public abstract StudentPersonalType.OtherIdList.OtherId createStudentPersonalTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link StudentPersonalType.MedicalAlertMessages.MedicalAlertMessage }
   * 
   */
  public abstract StudentPersonalType.MedicalAlertMessages.MedicalAlertMessage createStudentPersonalTypeMedicalAlertMessagesMedicalAlertMessage();

  /**
   * Create an instance of {@link StudentPersonalType.AlertMessages.AlertMessage }
   * 
   */
  public abstract StudentPersonalType.AlertMessages.AlertMessage createStudentPersonalTypeAlertMessagesAlertMessage();

  /**
   * Create an instance of {@link StudentActivityInfoType.StudentActivityType }
   * 
   */
  public abstract StudentActivityInfoType.StudentActivityType createStudentActivityInfoTypeStudentActivityType();

  /**
   * Create an instance of {@link StudentContactPersonalType.OtherIdList.OtherId }
   * 
   */
  public abstract StudentContactPersonalType.OtherIdList.OtherId createStudentContactPersonalTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link SchoolContactListType.SchoolContact }
   * 
   */
  public abstract SchoolContactListType.SchoolContact createSchoolContactListTypeSchoolContact();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.ItemAids }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.ItemAids createSif3StudentResponseSetTypeItemsItemItemAids();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.FeedbackItems.FeedbackItem }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.FeedbackItems.FeedbackItem createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItem();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.TraitScores.TraitScore }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.TraitScores.TraitScore createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScore();

  /**
   * Create an instance of {@link Sif3StudentResponseSetType.Items.Item.Comments.Comment }
   * 
   */
  public abstract Sif3StudentResponseSetType.Items.Item.Comments.Comment createSif3StudentResponseSetTypeItemsItemCommentsComment();

  /**
   * Create an instance of {@link TimeTableSubjectType.AcademicYearRange }
   * 
   */
  public abstract TimeTableSubjectType.AcademicYearRange createTimeTableSubjectTypeAcademicYearRange();

  /**
   * Create an instance of {@link AssessmentSubTestType.ScoreRange }
   * 
   */
  public abstract AssessmentSubTestType.ScoreRange createAssessmentSubTestTypeScoreRange();

  /**
   * Create an instance of {@link AssessmentSubTestType.AssessmentSubTestRefIds }
   * 
   */
  public abstract AssessmentSubTestType.AssessmentSubTestRefIds createAssessmentSubTestTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of {@link AssessmentSubTestType.LearningStandardItemRefIds }
   * 
   */
  public abstract AssessmentSubTestType.LearningStandardItemRefIds createAssessmentSubTestTypeLearningStandardItemRefIds();

  /**
   * Create an instance of {@link AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores }
   * 
   */
  public abstract AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores();

  /**
   * Create an instance of {@link LearningStandardItemType.StandardSettingBody }
   * 
   */
  public abstract LearningStandardItemType.StandardSettingBody createLearningStandardItemTypeStandardSettingBody();

  /**
   * Create an instance of {@link LearningStandardItemType.StandardHierarchyLevel }
   * 
   */
  public abstract LearningStandardItemType.StandardHierarchyLevel createLearningStandardItemTypeStandardHierarchyLevel();

  /**
   * Create an instance of {@link LearningStandardItemType.PredecessorItems }
   * 
   */
  public abstract LearningStandardItemType.PredecessorItems createLearningStandardItemTypePredecessorItems();

  /**
   * Create an instance of {@link LearningStandardItemType.StatementCodes }
   * 
   */
  public abstract LearningStandardItemType.StatementCodes createLearningStandardItemTypeStatementCodes();

  /**
   * Create an instance of {@link LearningStandardItemType.Statements }
   * 
   */
  public abstract LearningStandardItemType.Statements createLearningStandardItemTypeStatements();

  /**
   * Create an instance of {@link LearningStandardItemType.RelatedLearningStandardItems.LearningStandardItemRefId }
   * 
   */
  public abstract LearningStandardItemType.RelatedLearningStandardItems.LearningStandardItemRefId createLearningStandardItemTypeRelatedLearningStandardItemsLearningStandardItemRefId();

  /**
   * Create an instance of {@link LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes }
   * 
   */
  public abstract LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes();

  /**
   * Create an instance of {@link LearningStandardItemType.Resources.LearningResourceRefId }
   * 
   */
  public abstract LearningStandardItemType.Resources.LearningResourceRefId createLearningStandardItemTypeResourcesLearningResourceRefId();

  /**
   * Create an instance of {@link StudentSDTNType.FurtherInformation }
   * 
   */
  public abstract StudentSDTNType.FurtherInformation createStudentSDTNTypeFurtherInformation();

  /**
   * Create an instance of {@link StudentSDTNType.PastoralCare }
   * 
   */
  public abstract StudentSDTNType.PastoralCare createStudentSDTNTypePastoralCare();

  /**
   * Create an instance of {@link StudentSDTNType.OtherLearningAreasList.OtherLearningArea }
   * 
   */
  public abstract StudentSDTNType.OtherLearningAreasList.OtherLearningArea createStudentSDTNTypeOtherLearningAreasListOtherLearningArea();

  /**
   * Create an instance of {@link StudentSDTNType.AreasOfInterestList.ActivityInfo }
   * 
   */
  public abstract StudentSDTNType.AreasOfInterestList.ActivityInfo createStudentSDTNTypeAreasOfInterestListActivityInfo();

  /**
   * Create an instance of {@link StudentSDTNType.PreviousSchoolsList.PreviousSchool }
   * 
   */
  public abstract StudentSDTNType.PreviousSchoolsList.PreviousSchool createStudentSDTNTypePreviousSchoolsListPreviousSchool();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.FormAccommodations }
   * 
   */
  public abstract Sif3AssessmentFormType.FormAccommodations createSif3AssessmentFormTypeFormAccommodations();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentSubTestRefIds }
   * 
   */
  public abstract Sif3AssessmentFormType.AssessmentSubTestRefIds createSif3AssessmentFormTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentPlatforms }
   * 
   */
  public abstract Sif3AssessmentFormType.AssessmentPlatforms createSif3AssessmentFormTypeAssessmentPlatforms();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentAssetRefIds }
   * 
   */
  public abstract Sif3AssessmentFormType.AssessmentAssetRefIds createSif3AssessmentFormTypeAssessmentAssetRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.AssessmentSections.AssessmentSection }
   * 
   */
  public abstract Sif3AssessmentFormType.AssessmentSections.AssessmentSection createSif3AssessmentFormTypeAssessmentSectionsAssessmentSection();

  /**
   * Create an instance of {@link Sif3AssessmentFormType.FormIdentifiers.FormIdentifier }
   * 
   */
  public abstract Sif3AssessmentFormType.FormIdentifiers.FormIdentifier createSif3AssessmentFormTypeFormIdentifiersFormIdentifier();

  /**
   * Create an instance of {@link AssessmentItemType.LearningStandardItems }
   * 
   */
  public abstract AssessmentItemType.LearningStandardItems createAssessmentItemTypeLearningStandardItems();

  /**
   * Create an instance of {@link AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores }
   * 
   */
  public abstract AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores();

  /**
   * Create an instance of {@link AssessmentItemType.ResponseChoices.Choice }
   * 
   */
  public abstract AssessmentItemType.ResponseChoices.Choice createAssessmentItemTypeResponseChoicesChoice();

  /**
   * Create an instance of {@link TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod }
   * 
   */
  public abstract TimeTableType.TimeTableDayList.TimeTableDay.TimeTablePeriodList.TimeTablePeriod createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriod();

  /**
   * Create an instance of {@link SystemRoleType.SIFRefId }
   * 
   */
  public abstract SystemRoleType.SIFRefId createSystemRoleTypeSIFRefId();

  /**
   * Create an instance of {@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId }
   * 
   */
  public abstract SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId();

  /**
   * Create an instance of {@link TimeElementType.SpanGaps.SpanGap }
   * 
   */
  public abstract TimeElementType.SpanGaps.SpanGap createTimeElementTypeSpanGapsSpanGap();

  /**
   * Create an instance of {@link AssessmentType.AssessmentDescriptors }
   * 
   */
  public abstract AssessmentType.AssessmentDescriptors createAssessmentTypeAssessmentDescriptors();

  /**
   * Create an instance of {@link EducationFilterType.LearningStandardItems }
   * 
   */
  public abstract EducationFilterType.LearningStandardItems createEducationFilterTypeLearningStandardItems();

  /**
   * Create an instance of {@link AddressType.Street }
   * 
   */
  public abstract AddressType.Street createAddressTypeStreet();

  /**
   * Create an instance of {@link AddressType.MapReference }
   * 
   */
  public abstract AddressType.MapReference createAddressTypeMapReference();

  /**
   * Create an instance of {@link AddressType.StatisticalAreas.StatisticalArea }
   * 
   */
  public abstract AddressType.StatisticalAreas.StatisticalArea createAddressTypeStatisticalAreasStatisticalArea();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions }
   * 
   */
  public abstract Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions createSif3AssessmentRubricTypeScoresScoreScoreDescriptions();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.Scores.Score.ScoreComments.ScoreComment }
   * 
   */
  public abstract Sif3AssessmentRubricType.Scores.Score.ScoreComments.ScoreComment createSif3AssessmentRubricTypeScoresScoreScoreCommentsScoreComment();

  /**
   * Create an instance of {@link Sif3AssessmentRubricType.RubricIdentifiers.RubricIdentifier }
   * 
   */
  public abstract Sif3AssessmentRubricType.RubricIdentifiers.RubricIdentifier createSif3AssessmentRubricTypeRubricIdentifiersRubricIdentifier();

  /**
   * Create an instance of {@link AggregateStatisticFactType.Characteristics }
   * 
   */
  public abstract AggregateStatisticFactType.Characteristics createAggregateStatisticFactTypeCharacteristics();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceUsageContentType }
   * 
   */
  public abstract ResourceUsageType.ResourceUsageContentType createResourceUsageTypeResourceUsageContentType();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId }
   * 
   */
  public abstract ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId();

  /**
   * Create an instance of {@link ResourceUsageType.ResourceReportColumnList.ResourceReportColumn }
   * 
   */
  public abstract ResourceUsageType.ResourceReportColumnList.ResourceReportColumn createResourceUsageTypeResourceReportColumnListResourceReportColumn();

  /**
   * Create an instance of {@link StudentContactRelationshipType.HouseholdList }
   * 
   */
  public abstract StudentContactRelationshipType.HouseholdList createStudentContactRelationshipTypeHouseholdList();

  /**
   * Create an instance of {@link StudentContactRelationshipType.ContactFlags }
   * 
   */
  public abstract StudentContactRelationshipType.ContactFlags createStudentContactRelationshipTypeContactFlags();

  /**
   * Create an instance of {@link LearningResourceType.Location }
   * 
   */
  public abstract LearningResourceType.Location createLearningResourceTypeLocation();

  /**
   * Create an instance of {@link LearningResourceType.SubjectAreas }
   * 
   */
  public abstract LearningResourceType.SubjectAreas createLearningResourceTypeSubjectAreas();

  /**
   * Create an instance of {@link LearningResourceType.MediaTypes }
   * 
   */
  public abstract LearningResourceType.MediaTypes createLearningResourceTypeMediaTypes();

  /**
   * Create an instance of {@link LearningResourceType.LearningStandards }
   * 
   */
  public abstract LearningResourceType.LearningStandards createLearningResourceTypeLearningStandards();

  /**
   * Create an instance of {@link LearningResourceType.Components.Component.Strategies }
   * 
   */
  public abstract LearningResourceType.Components.Component.Strategies createLearningResourceTypeComponentsComponentStrategies();

  /**
   * Create an instance of {@link LearningResourceType.Components.Component.AssociatedObjects.AssociatedObject }
   * 
   */
  public abstract LearningResourceType.Components.Component.AssociatedObjects.AssociatedObject createLearningResourceTypeComponentsComponentAssociatedObjectsAssociatedObject();

  /**
   * Create an instance of {@link LearningResourceType.Evaluations.Evaluation }
   * 
   */
  public abstract LearningResourceType.Evaluations.Evaluation createLearningResourceTypeEvaluationsEvaluation();

  /**
   * Create an instance of {@link LearningResourceType.Approvals.Approval }
   * 
   */
  public abstract LearningResourceType.Approvals.Approval createLearningResourceTypeApprovalsApproval();

  /**
   * Create an instance of {@link LearningResourceType.Contacts.Contact }
   * 
   */
  public abstract LearningResourceType.Contacts.Contact createLearningResourceTypeContactsContact();

  /**
   * Create an instance of {@link LearningStandardDocumentType.Organizations }
   * 
   */
  public abstract LearningStandardDocumentType.Organizations createLearningStandardDocumentTypeOrganizations();

  /**
   * Create an instance of {@link LearningStandardDocumentType.Authors }
   * 
   */
  public abstract LearningStandardDocumentType.Authors createLearningStandardDocumentTypeAuthors();

  /**
   * Create an instance of {@link LearningStandardDocumentType.SubjectAreas }
   * 
   */
  public abstract LearningStandardDocumentType.SubjectAreas createLearningStandardDocumentTypeSubjectAreas();

  /**
   * Create an instance of {@link LearningStandardDocumentType.Copyright }
   * 
   */
  public abstract LearningStandardDocumentType.Copyright createLearningStandardDocumentTypeCopyright();

  /**
   * Create an instance of {@link LearningStandardDocumentType.RelatedLearningStandards }
   * 
   */
  public abstract LearningStandardDocumentType.RelatedLearningStandards createLearningStandardDocumentTypeRelatedLearningStandards();

  /**
   * Create an instance of {@link AggregateStatisticInfoType.CalculationRule }
   * 
   */
  public abstract AggregateStatisticInfoType.CalculationRule createAggregateStatisticInfoTypeCalculationRule();

  /**
   * Create an instance of {@link AggregateStatisticInfoType.ExclusionRules.ExclusionRule }
   * 
   */
  public abstract AggregateStatisticInfoType.ExclusionRules.ExclusionRule createAggregateStatisticInfoTypeExclusionRulesExclusionRule();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.LearningStandardItems }
   * 
   */
  public abstract Sif3AssessmentItemType.LearningStandardItems createSif3AssessmentItemTypeLearningStandardItems();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentItemAssetRefIds }
   * 
   */
  public abstract Sif3AssessmentItemType.AssessmentItemAssetRefIds createSif3AssessmentItemTypeAssessmentItemAssetRefIds();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.ItemRubricIds }
   * 
   */
  public abstract Sif3AssessmentItemType.ItemRubricIds createSif3AssessmentItemTypeItemRubricIds();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentItemPlatforms }
   * 
   */
  public abstract Sif3AssessmentItemType.AssessmentItemPlatforms createSif3AssessmentItemTypeAssessmentItemPlatforms();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentItemBanks.AssessmentItemBank }
   * 
   */
  public abstract Sif3AssessmentItemType.AssessmentItemBanks.AssessmentItemBank createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBank();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.ResponseChoices.Choice }
   * 
   */
  public abstract Sif3AssessmentItemType.ResponseChoices.Choice createSif3AssessmentItemTypeResponseChoicesChoice();

  /**
   * Create an instance of {@link Sif3AssessmentItemType.AssessmentIdentifiers.AssessmentIdentifier }
   * 
   */
  public abstract Sif3AssessmentItemType.AssessmentIdentifiers.AssessmentIdentifier createSif3AssessmentItemTypeAssessmentIdentifiersAssessmentIdentifier();

  /**
   * Create an instance of {@link AddressListType.Address }
   * 
   */
  public abstract AddressListType.Address createAddressListTypeAddress();

  /**
   * Create an instance of {@link StudentPeriodAttendanceType.AuditInfo.CreationUser }
   * 
   */
  public abstract StudentPeriodAttendanceType.AuditInfo.CreationUser createStudentPeriodAttendanceTypeAuditInfoCreationUser();

  /**
   * Create an instance of {@link LifeCycleType.TimeElements }
   * 
   */
  public abstract LifeCycleType.TimeElements createLifeCycleTypeTimeElements();

  /**
   * Create an instance of {@link LifeCycleType.ModificationHistory.Modified }
   * 
   */
  public abstract LifeCycleType.ModificationHistory.Modified createLifeCycleTypeModificationHistoryModified();

  /**
   * Create an instance of {@link LifeCycleType.Created.Creators.Creator }
   * 
   */
  public abstract LifeCycleType.Created.Creators.Creator createLifeCycleTypeCreatedCreatorsCreator();

  /**
   * Create an instance of {@link SchoolProgramsType.SchoolProgramList.Program }
   * 
   */
  public abstract SchoolProgramsType.SchoolProgramList.Program createSchoolProgramsTypeSchoolProgramListProgram();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationType.AdministrationAssessments }
   * 
   */
  public abstract Sif3AssessmentAdministrationType.AdministrationAssessments createSif3AssessmentAdministrationTypeAdministrationAssessments();

  /**
   * Create an instance of {@link Sif3AssessmentAdministrationType.Organizations.Organization }
   * 
   */
  public abstract Sif3AssessmentAdministrationType.Organizations.Organization createSif3AssessmentAdministrationTypeOrganizationsOrganization();

  /**
   * Create an instance of {@link AssessmentFormType.FormNumbers }
   * 
   */
  public abstract AssessmentFormType.FormNumbers createAssessmentFormTypeFormNumbers();

  /**
   * Create an instance of {@link AssessmentFormType.AssessmentSubTestRefIds }
   * 
   */
  public abstract AssessmentFormType.AssessmentSubTestRefIds createAssessmentFormTypeAssessmentSubTestRefIds();

  /**
   * Create an instance of {@link SIFMetadataType.TimeElements }
   * 
   */
  public abstract SIFMetadataType.TimeElements createSIFMetadataTypeTimeElements();

  /**
   * Create an instance of {@link PhoneNumberListType.PhoneNumber }
   * 
   */
  public abstract PhoneNumberListType.PhoneNumber createPhoneNumberListTypePhoneNumber();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.TestingStatuses.TestingStatus }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.TestingStatuses.TestingStatus createSif3AssessmentRegistrationTypeTestingStatusesTestingStatus();

  /**
   * Create an instance of {@link Sif3AssessmentRegistrationType.StudentSpecialEvents.StudentSpecialEvent }
   * 
   */
  public abstract Sif3AssessmentRegistrationType.StudentSpecialEvents.StudentSpecialEvent createSif3AssessmentRegistrationTypeStudentSpecialEventsStudentSpecialEvent();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.ParentObjectRefId }
   * 
   */
  public abstract SummaryEnrollmentInfoType.ParentObjectRefId createSummaryEnrollmentInfoTypeParentObjectRefId();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student }
   * 
   */
  public abstract SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff }
   * 
   */
  public abstract SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff();

  /**
   * Create an instance of {@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList.Enrollment }
   * 
   */
  public abstract SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList.Enrollment createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollment();

  /**
   * Create an instance of {@link PersonPictureType.ParentObjectRefId }
   * 
   */
  public abstract PersonPictureType.ParentObjectRefId createPersonPictureTypeParentObjectRefId();

  /**
   * Create an instance of {@link PersonPictureType.PictureSource }
   * 
   */
  public abstract PersonPictureType.PictureSource createPersonPictureTypePictureSource();

  /**
   * Create an instance of {@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId }
   * 
   */
  public abstract SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId();

  /**
   * Create an instance of {@link OtherCodeListType.OtherCode }
   * 
   */
  public abstract OtherCodeListType.OtherCode createOtherCodeListTypeOtherCode();

  /**
   * Create an instance of {@link ReportManifestType.ReceivingAuthority }
   * 
   */
  public abstract ReportManifestType.ReceivingAuthority createReportManifestTypeReceivingAuthority();

  /**
   * Create an instance of {@link ReportManifestType.ReportingPeriod }
   * 
   */
  public abstract ReportManifestType.ReportingPeriod createReportManifestTypeReportingPeriod();

  /**
   * Create an instance of {@link ReportManifestType.ReportDefinitionSource }
   * 
   */
  public abstract ReportManifestType.ReportDefinitionSource createReportManifestTypeReportDefinitionSource();

  /**
   * Create an instance of {@link ReportManifestType.SIFQueryGroup }
   * 
   */
  public abstract ReportManifestType.SIFQueryGroup createReportManifestTypeSIFQueryGroup();

  /**
   * Create an instance of {@link ReportManifestType.ReportFormatList.ReportFormat }
   * 
   */
  public abstract ReportManifestType.ReportFormatList.ReportFormat createReportManifestTypeReportFormatListReportFormat();

  /**
   * Create an instance of {@link OtherNamesType.Name }
   * 
   */
  public abstract OtherNamesType.Name createOtherNamesTypeName();

  /**
   * Create an instance of {@link ActivityType.TechnicalRequirements }
   * 
   */
  public abstract ActivityType.TechnicalRequirements createActivityTypeTechnicalRequirements();

  /**
   * Create an instance of {@link ActivityType.EssentialMaterials }
   * 
   */
  public abstract ActivityType.EssentialMaterials createActivityTypeEssentialMaterials();

  /**
   * Create an instance of {@link ActivityType.LearningObjectives }
   * 
   */
  public abstract ActivityType.LearningObjectives createActivityTypeLearningObjectives();

  /**
   * Create an instance of {@link ActivityType.LearningStandards }
   * 
   */
  public abstract ActivityType.LearningStandards createActivityTypeLearningStandards();

  /**
   * Create an instance of {@link ActivityType.Prerequisites }
   * 
   */
  public abstract ActivityType.Prerequisites createActivityTypePrerequisites();

  /**
   * Create an instance of {@link ActivityType.Students }
   * 
   */
  public abstract ActivityType.Students createActivityTypeStudents();

  /**
   * Create an instance of {@link ActivityType.Evaluation }
   * 
   */
  public abstract ActivityType.Evaluation createActivityTypeEvaluation();

  /**
   * Create an instance of {@link ActivityType.LearningResources }
   * 
   */
  public abstract ActivityType.LearningResources createActivityTypeLearningResources();

  /**
   * Create an instance of {@link ActivityType.ActivityTime.Duration }
   * 
   */
  public abstract ActivityType.ActivityTime.Duration createActivityTypeActivityTimeDuration();

  /**
   * Create an instance of {@link ActivityType.SourceObjects.SourceObject }
   * 
   */
  public abstract ActivityType.SourceObjects.SourceObject createActivityTypeSourceObjectsSourceObject();

  /**
   * Create an instance of {@link ActivityType.SoftwareRequirementList.SoftwareRequirement }
   * 
   */
  public abstract ActivityType.SoftwareRequirementList.SoftwareRequirement createActivityTypeSoftwareRequirementListSoftwareRequirement();

  /**
   * Create an instance of {@link AssessmentRegistrationType.AssessmentStudentSnapshot }
   * 
   */
  public abstract AssessmentRegistrationType.AssessmentStudentSnapshot createAssessmentRegistrationTypeAssessmentStudentSnapshot();

  /**
   * Create an instance of {@link AssessmentRegistrationType.StudentSpecialConditions.StudentSpecialCondition }
   * 
   */
  public abstract AssessmentRegistrationType.StudentSpecialConditions.StudentSpecialCondition createAssessmentRegistrationTypeStudentSpecialConditionsStudentSpecialCondition();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.DerivedValue }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.DerivedValue createSif3AssessmentScoreTableTypeScoreValuesScoreValueDerivedValue();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList.Feedback }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList.Feedback createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedback();

  /**
   * Create an instance of {@link Sif3AssessmentScoreTableType.ScoreTableIdentifiers.ScoreTableIdentifier }
   * 
   */
  public abstract Sif3AssessmentScoreTableType.ScoreTableIdentifiers.ScoreTableIdentifier createSif3AssessmentScoreTableTypeScoreTableIdentifiersScoreTableIdentifier();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.EntryType }
   * 
   */
  public abstract StudentSchoolEnrollmentType.EntryType createStudentSchoolEnrollmentTypeEntryType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Homeroom }
   * 
   */
  public abstract StudentSchoolEnrollmentType.Homeroom createStudentSchoolEnrollmentTypeHomeroom();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Advisor }
   * 
   */
  public abstract StudentSchoolEnrollmentType.Advisor createStudentSchoolEnrollmentTypeAdvisor();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Counselor }
   * 
   */
  public abstract StudentSchoolEnrollmentType.Counselor createStudentSchoolEnrollmentTypeCounselor();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.Calendar }
   * 
   */
  public abstract StudentSchoolEnrollmentType.Calendar createStudentSchoolEnrollmentTypeCalendar();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.ExitStatus }
   * 
   */
  public abstract StudentSchoolEnrollmentType.ExitStatus createStudentSchoolEnrollmentTypeExitStatus();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.ExitType }
   * 
   */
  public abstract StudentSchoolEnrollmentType.ExitType createStudentSchoolEnrollmentTypeExitType();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.CatchmentStatus }
   * 
   */
  public abstract StudentSchoolEnrollmentType.CatchmentStatus createStudentSchoolEnrollmentTypeCatchmentStatus();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.PromotionInfo }
   * 
   */
  public abstract StudentSchoolEnrollmentType.PromotionInfo createStudentSchoolEnrollmentTypePromotionInfo();

  /**
   * Create an instance of {@link StudentSchoolEnrollmentType.StudentSubjectChoiceList.StudentSubjectChoice }
   * 
   */
  public abstract StudentSchoolEnrollmentType.StudentSubjectChoiceList.StudentSubjectChoice createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoice();

  /**
   * Create an instance of {@link SectionInfoType.MediumOfInstruction }
   * 
   */
  public abstract SectionInfoType.MediumOfInstruction createSectionInfoTypeMediumOfInstruction();

  /**
   * Create an instance of {@link SectionInfoType.LanguageOfInstruction }
   * 
   */
  public abstract SectionInfoType.LanguageOfInstruction createSectionInfoTypeLanguageOfInstruction();

  /**
   * Create an instance of {@link SectionInfoType.LocationOfInstruction }
   * 
   */
  public abstract SectionInfoType.LocationOfInstruction createSectionInfoTypeLocationOfInstruction();

  /**
   * Create an instance of {@link SectionInfoType.SchoolCourseInfoOverride }
   * 
   */
  public abstract SectionInfoType.SchoolCourseInfoOverride createSectionInfoTypeSchoolCourseInfoOverride();

  /**
   * Create an instance of {@link StaffAssignmentType.StaffActivity }
   * 
   */
  public abstract StaffAssignmentType.StaffActivity createStaffAssignmentTypeStaffActivity();

  /**
   * Create an instance of {@link StaffAssignmentType.StaffSubjectList.StaffSubject }
   * 
   */
  public abstract StaffAssignmentType.StaffSubjectList.StaffSubject createStaffAssignmentTypeStaffSubjectListStaffSubject();

  /**
   * Create an instance of {@link EmailListType.Email }
   * 
   */
  public abstract EmailListType.Email createEmailListTypeEmail();

  /**
   * Create an instance of {@link ScheduledActivityType.RoomList }
   * 
   */
  public abstract ScheduledActivityType.RoomList createScheduledActivityTypeRoomList();

  /**
   * Create an instance of {@link ScheduledActivityType.StudentList }
   * 
   */
  public abstract ScheduledActivityType.StudentList createScheduledActivityTypeStudentList();

  /**
   * Create an instance of {@link ScheduledActivityType.TeachingGroupList }
   * 
   */
  public abstract ScheduledActivityType.TeachingGroupList createScheduledActivityTypeTeachingGroupList();

  /**
   * Create an instance of {@link ScheduledActivityType.Override }
   * 
   */
  public abstract ScheduledActivityType.Override createScheduledActivityTypeOverride();

  /**
   * Create an instance of {@link ScheduledActivityType.TeacherList.TeacherCover }
   * 
   */
  public abstract ScheduledActivityType.TeacherList.TeacherCover createScheduledActivityTypeTeacherListTeacherCover();

  /**
   * Create an instance of {@link TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod }
   * 
   */
  public abstract TeachingGroupType.TeachingGroupPeriodList.TeachingGroupPeriod createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriod();

  /**
   * Create an instance of {@link TeachingGroupType.TeacherList.TeachingGroupTeacher }
   * 
   */
  public abstract TeachingGroupType.TeacherList.TeachingGroupTeacher createTeachingGroupTypeTeacherListTeachingGroupTeacher();

  /**
   * Create an instance of {@link TeachingGroupType.StudentList.TeachingGroupStudent }
   * 
   */
  public abstract TeachingGroupType.StudentList.TeachingGroupStudent createTeachingGroupTypeStudentListTeachingGroupStudent();

  /**
   * Create an instance of {@link DemographicsType.CountriesOfCitizenship }
   * 
   */
  public abstract DemographicsType.CountriesOfCitizenship createDemographicsTypeCountriesOfCitizenship();

  /**
   * Create an instance of {@link DemographicsType.CountriesOfResidency }
   * 
   */
  public abstract DemographicsType.CountriesOfResidency createDemographicsTypeCountriesOfResidency();

  /**
   * Create an instance of {@link DemographicsType.DwellingArrangement }
   * 
   */
  public abstract DemographicsType.DwellingArrangement createDemographicsTypeDwellingArrangement();

  /**
   * Create an instance of {@link DemographicsType.Religion }
   * 
   */
  public abstract DemographicsType.Religion createDemographicsTypeReligion();

  /**
   * Create an instance of {@link DemographicsType.ReligiousEventList.ReligiousEvent }
   * 
   */
  public abstract DemographicsType.ReligiousEventList.ReligiousEvent createDemographicsTypeReligiousEventListReligiousEvent();

  /**
   * Create an instance of {@link LanguageListType.Language }
   * 
   */
  public abstract LanguageListType.Language createLanguageListTypeLanguage();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType.AssetLearningStandards }
   * 
   */
  public abstract Sif3AssessmentAssetType.AssetLearningStandards createSif3AssessmentAssetTypeAssetLearningStandards();

  /**
   * Create an instance of {@link Sif3AssessmentAssetType.AssetIdentifiers.AssetIdentifier }
   * 
   */
  public abstract Sif3AssessmentAssetType.AssetIdentifiers.AssetIdentifier createSif3AssessmentAssetTypeAssetIdentifiersAssetIdentifier();

  /**
   * Create an instance of {@link SIFQueryType.SIFQueryObject }
   * 
   */
  public abstract SIFQueryType.SIFQueryObject createSIFQueryTypeSIFQueryObject();

  /**
   * Create an instance of {@link SIFQueryType.SIFConditionGroup.SIFConditions.SIFCondition }
   * 
   */
  public abstract SIFQueryType.SIFConditionGroup.SIFConditions.SIFCondition createSIFQueryTypeSIFConditionGroupSIFConditionsSIFCondition();

  /**
   * Create an instance of {@link SchoolInfoType.OtherLEA }
   * 
   */
  public abstract SchoolInfoType.OtherLEA createSchoolInfoTypeOtherLEA();

  /**
   * Create an instance of {@link SchoolInfoType.SchoolFocusList }
   * 
   */
  public abstract SchoolInfoType.SchoolFocusList createSchoolInfoTypeSchoolFocusList();

  /**
   * Create an instance of {@link SchoolInfoType.Campus }
   * 
   */
  public abstract SchoolInfoType.Campus createSchoolInfoTypeCampus();

  /**
   * Create an instance of {@link SchoolInfoType.SchoolGroupList }
   * 
   */
  public abstract SchoolInfoType.SchoolGroupList createSchoolInfoTypeSchoolGroupList();

  /**
   * Create an instance of {@link SchoolInfoType.OtherIdList.OtherId }
   * 
   */
  public abstract SchoolInfoType.OtherIdList.OtherId createSchoolInfoTypeOtherIdListOtherId();

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType }{@code >}}
   * 
   */
  public abstract JAXBElement<LanguageListType> createLanguageList(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAssetType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAssetType> createSif3AssessmentAsset(Sif3AssessmentAssetType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType> createDemographics(DemographicsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemAssociationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemAssociationCollectionType> createSif3AssessmentItemAssociations(
      Sif3AssessmentItemAssociationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolInfoType> createSchoolInfo(SchoolInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFQueryType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFQueryType> createSIFQuery(SIFQueryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createProjectedGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentScoreSetCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentScoreSetCollectionType> createStudentScoreSets(StudentScoreSetCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourcePackageType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourcePackageType> createLearningResourcePackage(
      LearningResourcePackageType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportAuthorityInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportAuthorityInfoCollectionType> createReportAuthorityInfos(
      ReportAuthorityInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<SectionInfoType> createSectionInfo(SectionInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemAssociationType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemAssociationType> createSif3AssessmentItemAssociation(
      Sif3AssessmentItemAssociationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFContext(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TeachingGroupType }{@code >}}
   * 
   */
  public abstract JAXBElement<TeachingGroupType> createTeachingGroup(TeachingGroupType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarSummaryType }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarSummaryType> createCalendarSummary(CalendarSummaryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSnapshotCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSnapshotCollectionType> createStudentSnapshots(StudentSnapshotCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityType }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityType> createScheduledActivity(ScheduledActivityType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentCollectionType> createStudentPersonals(StudentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TermInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<TermInfoCollectionType> createTermInfos(TermInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestCollectionType> createSif3AssessmentSubTests(
      Sif3AssessmentSubTestCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaType> createSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailListType> createEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffAssignmentType }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffAssignmentType> createStaffAssignment(StaffAssignmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSessionCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSessionCollectionType> createSif3AssessmentSessions(
      Sif3AssessmentSessionCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberType> createPhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TeachingGroupCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<TeachingGroupCollectionType> createTeachingGroups(TeachingGroupCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createCountry(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSubjectAreaList(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolCourseInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolCourseInfoCollectionType> createSchoolCourseInfos(
      SchoolCourseInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType> createStudentSchoolEnrollment(
      StudentSchoolEnrollmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentRegistrationType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentRegistrationType> createAssessmentRegistration(AssessmentRegistrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentScoreTableType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentScoreTableType> createSif3AssessmentScoreTable(
      Sif3AssessmentScoreTableType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentFormCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentFormCollectionType> createAssessmentForms(AssessmentFormCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentRegistrationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentRegistrationCollectionType> createAssessmentRegistrations(
      AssessmentRegistrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentActivityInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentActivityInfoCollectionType> createStudentActivityInfos(
      StudentActivityInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableSubjectCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableSubjectCollectionType> createTimeTableSubjects(
      TimeTableSubjectCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherNamesType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherNamesType> createOtherNames(OtherNamesType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType> createActivity(ActivityType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailType> createEmail(EmailType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffCollectionType> createStaffPersonals(StaffCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRubricCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRubricCollectionType> createSif3AssessmentRubrics(
      Sif3AssessmentRubricCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentAdministrationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentAdministrationCollectionType> createAssessmentAdministrations(
      AssessmentAdministrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentDailyAttendanceCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentDailyAttendanceCollectionType> createStudentDailyAttendances(
      StudentDailyAttendanceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFReportObjectType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFReportObjectType> createSIFReportObject(SIFReportObjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersonPictureType }{@code >}}
   * 
   */
  public abstract JAXBElement<PersonPictureType> createPersonPicture(PersonPictureType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportManifestType }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportManifestType> createReportManifest(ReportManifestType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentParticipationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentParticipationCollectionType> createStudentParticipations(
      StudentParticipationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStateProvince(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentFormType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentFormType> createAssessmentForm(AssessmentFormType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentAttendanceSummaryType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentAttendanceSummaryType> createStudentAttendanceSummary(
      StudentAttendanceSummaryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateStatisticFactCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateStatisticFactCollectionType> createAggregateStatisticFacts(
      AggregateStatisticFactCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAdministrationType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAdministrationType> createSif3AssessmentAdministration(
      Sif3AssessmentAdministrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolProgramsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolProgramsType> createSchoolPrograms(SchoolProgramsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType }{@code >}}
   * 
   */
  public abstract JAXBElement<LifeCycleType> createLifeCycle(LifeCycleType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPeriodAttendanceType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPeriodAttendanceType> createStudentPeriodAttendance(
      StudentPeriodAttendanceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportManifestCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportManifestCollectionType> createReportManifests(ReportManifestCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SummaryEnrollmentInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<SummaryEnrollmentInfoType> createSummaryEnrollmentInfo(SummaryEnrollmentInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SummaryEnrollmentInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SummaryEnrollmentInfoCollectionType> createSummaryEnrollmentInfos(
      SummaryEnrollmentInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactRelationshipCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactRelationshipCollectionType> createStudentContactRelationships(
      StudentContactRelationshipCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRegistrationType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRegistrationType> createSif3AssessmentRegistration(
      Sif3AssessmentRegistrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createPhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffAssignmentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffAssignmentCollectionType> createStaffAssignments(StaffAssignmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarSummaryCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarSummaryCollectionType> createCalendarSummarys(CalendarSummaryCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactRelationshipType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactRelationshipType> createStudentContactRelationship(
      StudentContactRelationshipType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createSIFAuthenticationLevel(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateCharacteristicInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateCharacteristicInfoType> createAggregateCharacteristicInfo(
      AggregateCharacteristicInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createPublishInDirectory(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ResourceUsageType }{@code >}}
   * 
   */
  public abstract JAXBElement<ResourceUsageType> createResourceUsage(ResourceUsageType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link IdentityCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<IdentityCollectionType> createIdentitys(IdentityCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateStatisticFactType }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateStatisticFactType> createAggregateStatisticFact(AggregateStatisticFactType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateCharacteristicInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateCharacteristicInfoCollectionType> createAggregateCharacteristicInfos(
      AggregateCharacteristicInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressListType> createAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType> createSif3AssessmentItem(Sif3AssessmentItemType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateStatisticInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateStatisticInfoType> createAggregateStatisticInfo(AggregateStatisticInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardDocumentType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardDocumentType> createLearningStandardDocument(
      LearningStandardDocumentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourcePackageCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourcePackageCollectionType> createLearningResourcePackages(
      LearningResourcePackageCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType> createLearningResource(LearningResourceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AttendanceCodeType }{@code >}}
   * 
   */
  public abstract JAXBElement<AttendanceCodeType> createAttendanceCode(AttendanceCodeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createSIFEncryptionLevel(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ACStrandSubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<ACStrandSubjectAreaType> createACStrandSubjectArea(ACStrandSubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ResourceUsageCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<ResourceUsageCollectionType> createResourceUsages(ResourceUsageCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createEducationalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EducationFilterType }{@code >}}
   * 
   */
  public abstract JAXBElement<EducationFilterType> createEducationFilter(EducationFilterType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentScoreTableCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentScoreTableCollectionType> createSif3AssessmentScoreTables(
      Sif3AssessmentScoreTableCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateStatisticInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateStatisticInfoCollectionType> createAggregateStatisticInfos(
      AggregateStatisticInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicIdListType }{@code >}}
   * 
   */
  public abstract JAXBElement<ElectronicIdListType> createElectronicIdList(ElectronicIdListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRubricType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRubricType> createSif3AssessmentRubric(Sif3AssessmentRubricType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicIdType }{@code >}}
   * 
   */
  public abstract JAXBElement<ElectronicIdType> createElectronicId(ElectronicIdType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableType> createTimeTable(TimeTableType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentItemType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentItemType> createAssessmentItem(AssessmentItemType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType> createSif3AssessmentForm(Sif3AssessmentFormType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SessionInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<SessionInfoType> createSessionInfo(SessionInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentItemCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentItemCollectionType> createAssessmentItems(AssessmentItemCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RoomInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<RoomInfoCollectionType> createRoomInfos(RoomInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentType> createAssessment(AssessmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeElementType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeElementType> createTimeElement(TimeElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableCellCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableCellCollectionType> createTimeTableCells(TimeTableCellCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentCollectionType> createSif3Assessments(Sif3AssessmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SystemRoleType }{@code >}}
   * 
   */
  public abstract JAXBElement<SystemRoleType> createSystemRole(SystemRoleType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentActivityParticipationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentActivityParticipationCollectionType> createStudentActivityParticipations(
      StudentActivityParticipationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableCellType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableCellType> createTimeTableCell(TimeTableCellType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNType> createStudentSDTN(StudentSDTNType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardDocumentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardDocumentCollectionType> createLearningStandardDocuments(
      LearningStandardDocumentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestType> createAssessmentSubTest(AssessmentSubTestType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType> createLearningStandardItem(LearningStandardItemType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemCollectionType> createLearningStandardItems(
      LearningStandardItemCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSectionEnrollmentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSectionEnrollmentCollectionType> createStudentSectionEnrollments(
      StudentSectionEnrollmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAssetCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAssetCollectionType> createSif3AssessmentAssets(
      Sif3AssessmentAssetCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3StudentResponseSetCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3StudentResponseSetCollectionType> createSif3StudentResponseSets(
      Sif3StudentResponseSetCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableSubjectType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableSubjectType> createTimeTableSubject(TimeTableSubjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3StudentResponseSetType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3StudentResponseSetType> createSif3StudentResponseSet(Sif3StudentResponseSetType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolProgramsCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolProgramsCollectionType> createSchoolProgramss(SchoolProgramsCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<ContactInfoType> createContactInfo(ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RelationshipType }{@code >}}
   * 
   */
  public abstract JAXBElement<RelationshipType> createRelationship(RelationshipType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemCollectionType> createSif3AssessmentItems(
      Sif3AssessmentItemCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestCollectionType> createAssessmentSubTests(
      AssessmentSubTestCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarDateCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarDateCollectionType> createCalendarDates(CalendarDateCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSnapshotType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSnapshotType> createStudentSnapshot(StudentSnapshotType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPeriodAttendanceCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPeriodAttendanceCollectionType> createStudentPeriodAttendances(
      StudentPeriodAttendanceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentActivityParticipationType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentActivityParticipationType> createStudentActivityParticipation(
      StudentActivityParticipationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TermInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<TermInfoType> createTermInfo(TermInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RoomInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<RoomInfoType> createRoomInfo(RoomInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentPackageCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentPackageCollectionType> createAssessmentPackages(
      AssessmentPackageCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentActivityInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentActivityInfoType> createStudentActivityInfo(StudentActivityInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactPersonalType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactPersonalType> createStudentContactPersonal(StudentContactPersonalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolContactListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolContactListType> createSchoolContactList(SchoolContactListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPersonalType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPersonalType> createStudentPersonal(StudentPersonalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFContextsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFContextsType> createSIFContexts(SIFContextsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormCollectionType> createSif3AssessmentForms(
      Sif3AssessmentFormCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersonPictureCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<PersonPictureCollectionType> createPersonPictures(PersonPictureCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PrincipalInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<PrincipalInfoType> createPrincipalInfo(PrincipalInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactCollectionType> createStudentContactPersonals(
      StudentContactCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentPackageType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentPackageType> createAssessmentPackage(AssessmentPackageType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportAuthorityInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportAuthorityInfoType> createReportAuthorityInfo(ReportAuthorityInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentAttendanceSummaryCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentAttendanceSummaryCollectionType> createStudentAttendanceSummarys(
      StudentAttendanceSummaryCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffPersonalType }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffPersonalType> createStaffPersonal(StaffPersonalType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAdministrationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAdministrationCollectionType> createSif3AssessmentAdministrations(
      Sif3AssessmentAdministrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarDate }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarDate> createCalendarDate(CalendarDate value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentAdministrationType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentAdministrationType> createAssessmentAdministration(
      AssessmentAdministrationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SectionInfoCollectionType> createSectionInfos(SectionInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentParticipationType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentParticipationType> createStudentParticipation(StudentParticipationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GridLocationType }{@code >}}
   * 
   */
  public abstract JAXBElement<GridLocationType> createGridLocation(GridLocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSessionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSessionType> createSif3AssessmentSession(Sif3AssessmentSessionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SystemRoleCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SystemRoleCollectionType> createSystemRoles(SystemRoleCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EnglishProficiencyType }{@code >}}
   * 
   */
  public abstract JAXBElement<EnglishProficiencyType> createEnglishProficiency(EnglishProficiencyType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSectionType> createSif3AssessmentSection(Sif3AssessmentSectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LEAInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<LEAInfoCollectionType> createLEAInfos(LEAInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceCollectionType> createLearningResources(
      LearningResourceCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentType> createSif3Assessment(Sif3AssessmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentCollectionType> createAssessments(AssessmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestType> createSif3AssessmentSubTest(Sif3AssessmentSubTestType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSIFExtendedElements(SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentCollectionType> createStudentSchoolEnrollments(
      StudentSchoolEnrollmentCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createOnTimeGraduationYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableCollectionType> createTimeTables(TimeTableCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
   * 
   */
  public abstract JAXBElement<LocationType> createLocation(LocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSectionCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSectionCollectionType> createSif3AssessmentSections(
      Sif3AssessmentSectionCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolCollectionType> createSchoolInfos(SchoolCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRegistrationCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRegistrationCollectionType> createSif3AssessmentRegistrations(
      Sif3AssessmentRegistrationCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsOperationalStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsOperationalStatusType> createOperationalStatus(
      AUCodeSetsOperationalStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNCollectionType> createStudentSDTNs(StudentSDTNCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentDailyAttendanceType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentDailyAttendanceType> createStudentDailyAttendance(StudentDailyAttendanceType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolCourseInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolCourseInfoType> createSchoolCourseInfo(SchoolCourseInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSectionEnrollmentType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSectionEnrollmentType> createStudentSectionEnrollment(
      StudentSectionEnrollmentType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LEAInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<LEAInfoType> createLEAInfo(LEAInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentScoreSetType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentScoreSetType> createStudentScoreSet(StudentScoreSetType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityCollectionType> createActivitys(ActivityCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFReportObjectCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFReportObjectCollectionType> createSIFReportObjects(SIFReportObjectCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PersonInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<PersonInfoType> createPersonInfo(PersonInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
   * 
   */
  public abstract JAXBElement<NameType> createName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ProgramStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<ProgramStatusType> createProgramStatus(ProgramStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SessionInfoCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<SessionInfoCollectionType> createSessionInfos(SessionInfoCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link IdentityType }{@code >}}
   * 
   */
  public abstract JAXBElement<IdentityType> createIdentity(IdentityType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityCollectionType }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityCollectionType> createScheduledActivitys(
      ScheduledActivityCollectionType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaType> createACStrandSubjectAreaTypeSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestType.ScoreRange }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestType.ScoreRange> createAssessmentSubTestTypeScoreRange(
      AssessmentSubTestType.ScoreRange value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestType.PerformanceLevels }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestType.PerformanceLevels> createAssessmentSubTestTypePerformanceLevels(
      AssessmentSubTestType.PerformanceLevels value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createAssessmentSubTestTypeSubTestTier(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
   * 
   */
  public abstract JAXBElement<Boolean> createAssessmentSubTestTypeContainerOnly(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestType.AssessmentSubTestRefIds> createAssessmentSubTestTypeAssessmentSubTestRefIds(
      AssessmentSubTestType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypeAbbreviation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createAssessmentSubTestTypeNumberOfItems(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestType.LearningStandardItemRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestType.LearningStandardItemRefIds> createAssessmentSubTestTypeLearningStandardItemRefIds(
      AssessmentSubTestType.LearningStandardItemRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypeSubjectArea(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentSubTestTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createAssessmentSubTestTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentSubTestTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotOnTimeGraduationYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotStateProvinceId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotNeglectedDelinquent(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotEconomicDisadvantage(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAge(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotProjectedGraduationYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationOnTime(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationDate(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
   * 
   */
  public abstract JAXBElement<NameType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGiftedTalented(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotGraduationAward(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotAddress(
      AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreCode(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreValue(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemTraitScoresTraitScoreTraitScoreType(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createStudentSDTNTypeFurtherInformationPhoneNumberList(
      PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailListType> createStudentSDTNTypeFurtherInformationEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameOfRecordType }{@code >}}
   * 
   */
  public abstract JAXBElement<NameOfRecordType> createStudentSDTNTypeFurtherInformationContactName(
      NameOfRecordType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentTypeAssessmentId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentTypeAssessmentPackageRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentType.AssessmentDescriptors }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentType.AssessmentDescriptors> createAssessmentTypeAssessmentDescriptors(
      AssessmentType.AssessmentDescriptors value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(
      Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaType> createStudentSchoolEnrollmentTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(
      SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType> createPersonInfoTypeDemographics(DemographicsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherNamesType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherNamesType> createPersonInfoTypeOtherNames(OtherNamesType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressListType> createPersonInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createPersonInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailListType> createPersonInfoTypeEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createResourceUsageTypeResourceUsageContentTypeLocalDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsProgressLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeOtherLearningAreasListOtherLearningAreaResult(
      AUCodeSetsProgressLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStateProvince(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeAddressGlobalUID(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeRadioContact(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType.MapReference }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType.MapReference> createAddressTypeMapReference(AddressType.MapReference value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeCountry(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeCommunity(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link GridLocationType }{@code >}}
   * 
   */
  public abstract JAXBElement<GridLocationType> createAddressTypeGridLocation(GridLocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType.StatisticalAreas }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType.StatisticalAreas> createAddressTypeStatisticalAreas(
      AddressType.StatisticalAreas value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeFinishDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createActivityTypeActivityTimeDueDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.ActivityTime.Duration }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.ActivityTime.Duration> createActivityTypeActivityTimeDuration(
      ActivityType.ActivityTime.Duration value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createAttendanceCodeTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLEAInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLEAInfoTypeSLA(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LEAInfoType.EducationAgencyType }{@code >}}
   * 
   */
  public abstract JAXBElement<LEAInfoType.EducationAgencyType> createLEAInfoTypeEducationAgencyType(
      LEAInfoType.EducationAgencyType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsOperationalStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsOperationalStatusType> createLEAInfoTypeOperationalStatus(
      AUCodeSetsOperationalStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLEAInfoTypeCommonwealthId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressListType> createLEAInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LEAInfoType.LEAContactList }{@code >}}
   * 
   */
  public abstract JAXBElement<LEAInfoType.LEAContactList> createLEAInfoTypeLEAContactList(
      LEAInfoType.LEAContactList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createLEAInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createLEAInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLEAInfoTypeLEAURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createLEAInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLEAInfoTypeJurisdictionLowerHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.LearningObjectives }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.LearningObjectives> createActivityTypeLearningObjectives(
      ActivityType.LearningObjectives value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.Students }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.Students> createActivityTypeStudents(ActivityType.Students value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createActivityTypePoints(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.EssentialMaterials }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.EssentialMaterials> createActivityTypeEssentialMaterials(
      ActivityType.EssentialMaterials value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeAssessmentRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createActivityTypeActivityWeight(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.TechnicalRequirements }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.TechnicalRequirements> createActivityTypeTechnicalRequirements(
      ActivityType.TechnicalRequirements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.Prerequisites }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.Prerequisites> createActivityTypePrerequisites(
      ActivityType.Prerequisites value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.SoftwareRequirementList }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.SoftwareRequirementList> createActivityTypeSoftwareRequirementList(
      ActivityType.SoftwareRequirementList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.LearningResources }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.LearningResources> createActivityTypeLearningResources(
      ActivityType.LearningResources value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createActivityTypeMaxAttemptsAllowed(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.Evaluation }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.Evaluation> createActivityTypeEvaluation(ActivityType.Evaluation value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypePreamble(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.SourceObjects }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.SourceObjects> createActivityTypeSourceObjects(
      ActivityType.SourceObjects value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createActivityTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaType> createActivityTypeSubjectArea(SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createActivityTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType.LearningStandards }{@code >}}
   * 
   */
  public abstract JAXBElement<ActivityType.LearningStandards> createActivityTypeLearningStandards(
      ActivityType.LearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeStaffLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeTimeTableLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeRoomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createTimeTableCellTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createTimeTableCellTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableCellTypeTeachingGroupLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFQueryDataModelType.SIFConditionGroup }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFQueryDataModelType.SIFConditionGroup> createSIFQueryDataModelTypeSIFConditionGroup(
      SIFQueryDataModelType.SIFConditionGroup value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ObjectType }{@code >}}
   * 
   */
  public abstract JAXBElement<ObjectType> createSIFQueryDataModelTypeSIFExample(ObjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link IdentityType.IdentityAssertions }{@code >}}
   * 
   */
  public abstract JAXBElement<IdentityType.IdentityAssertions> createIdentityTypeIdentityAssertions(
      IdentityType.IdentityAssertions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link IdentityType.PasswordList }{@code >}}
   * 
   */
  public abstract JAXBElement<IdentityType.PasswordList> createIdentityTypePasswordList(IdentityType.PasswordList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createIdentityTypeAuthenticationSourceGlobalUID(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createIdentityTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createIdentityTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeEffectiveDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
   * 
   */
  public abstract JAXBElement<LocationType> createAggregateStatisticInfoTypeLocation(LocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAggregateStatisticInfoTypeMeasure(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeDiscontinueDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateStatisticInfoType.CalculationRule }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateStatisticInfoType.CalculationRule> createAggregateStatisticInfoTypeCalculationRule(
      AggregateStatisticInfoType.CalculationRule value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeApprovalDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createAggregateStatisticInfoTypeExpirationDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAggregateStatisticInfoTypeSource(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AggregateStatisticInfoType.ExclusionRules }{@code >}}
   * 
   */
  public abstract JAXBElement<AggregateStatisticInfoType.ExclusionRules> createAggregateStatisticInfoTypeExclusionRules(
      AggregateStatisticInfoType.ExclusionRules value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAggregateStatisticInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAggregateStatisticInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeLearningResourcePackageRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeAuthor(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.Location }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.Location> createLearningResourceTypeLocation(
      LearningResourceType.Location value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.SubjectAreas }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.SubjectAreas> createLearningResourceTypeSubjectAreas(
      LearningResourceType.SubjectAreas value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.Approvals }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.Approvals> createLearningResourceTypeApprovals(
      LearningResourceType.Approvals value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeUseAgreement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.Contacts }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.Contacts> createLearningResourceTypeContacts(
      LearningResourceType.Contacts value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.MediaTypes }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.MediaTypes> createLearningResourceTypeMediaTypes(
      LearningResourceType.MediaTypes value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningResourceTypeAgreementDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.Evaluations }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.Evaluations> createLearningResourceTypeEvaluations(
      LearningResourceType.Evaluations value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createLearningResourceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createLearningResourceTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createLearningResourceTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.LearningStandards }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.LearningStandards> createLearningResourceTypeLearningStandards(
      LearningResourceType.LearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsSchoolLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeCampusCampusType(
      AUCodeSetsSchoolLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeCampusParentSchoolId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStaffLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodStartTime(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodPeriodId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodRoomNumber(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodCellType(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTeachingGroupPeriodListTeachingGroupPeriodTimeTableCellRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeReferralDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentParticipationType.ProgramAvailability }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentParticipationType.ProgramAvailability> createStudentParticipationTypeProgramAvailability(
      StudentParticipationType.ProgramAvailability value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypePlacementParentalConsentDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentParticipationTypeGiftedEligibilityCriteria(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationExtensionDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentParticipationTypeParticipationContact(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlacementDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentParticipationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentParticipationType.ReferralSource }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentParticipationType.ReferralSource> createStudentParticipationTypeReferralSource(
      StudentParticipationType.ReferralSource value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentParticipationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentParticipationTypeEntryPerson(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeReevaluationDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
   * 
   */
  public abstract JAXBElement<Boolean> createStudentParticipationTypeExtendedSchoolYear(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeNOREPDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
   * 
   */
  public abstract JAXBElement<Boolean> createStudentParticipationTypeExtendedDay(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramEligibilityDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeEvaluationParentalConsentDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentParticipationType.ProgramFundingSources }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentParticipationType.ProgramFundingSources> createStudentParticipationTypeProgramFundingSources(
      StudentParticipationType.ProgramFundingSources value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlanDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ProgramStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<ProgramStatusType> createStudentParticipationTypeProgramStatus(ProgramStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentParticipationTypeExtensionComments(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentParticipationTypeProgramType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createStudentParticipationTypeStudentSpecialEducationFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentParticipationTypeProgramPlanEffectiveDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardItemTypeStandardSettingBodyStateProvince(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardItemTypeStandardSettingBodySettingBodyName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAssetType.AssetIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAssetType.AssetIdentifiers> createSif3AssessmentAssetTypeAssetIdentifiers(
      Sif3AssessmentAssetType.AssetIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAssetTypeAssetLanguage(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAssetTypeAssetName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAssetTypeAssetVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAssetType.AssetLearningStandards }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAssetType.AssetLearningStandards> createSif3AssessmentAssetTypeAssetLearningStandards(
      Sif3AssessmentAssetType.AssetLearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAssetTypeAssetOwner(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentAssetTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSif3AssessmentAssetTypeAssetSubjects(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentAssetTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createSif3AssessmentAssetTypeAssetGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentAssetTypeAssetPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseCredits(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideDistrictCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideStateCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideInstructionalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaType> createSectionInfoTypeSchoolCourseInfoOverrideSubjectArea(
      SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSchoolCourseInfoOverrideCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackList(
      Sif3AssessmentScoreTableType.ScoreValues.ScoreValue.FeedbackList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValuePassFailIndicator(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeFirstInstructionDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeLastInstructionDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createCalendarSummaryTypeGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createCalendarSummaryTypeInstructionalMinutes(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createCalendarSummaryTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createCalendarSummaryTypeMinutesPerDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createCalendarSummaryTypeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createCalendarSummaryTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createCalendarSummaryTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createCalendarSummaryTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSummaryEnrollmentInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSummaryEnrollmentInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createEnglishProficiencyTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SystemRoleType.SystemContextList.SystemContext.RoleList }{@code >}}
   * 
   */
  public abstract JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList> createSystemRoleTypeSystemContextListSystemContextRoleList(
      SystemRoleType.SystemContextList.SystemContext.RoleList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent2Language(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createStudentPersonalTypeMostRecentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent1Language(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent2EmploymentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent1NonSchoolEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent1SchoolEducationLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent1EmploymentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentHomeroomLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent2SchoolEducationLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeMostRecentParent2NonSchoolEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeReligiousAffiliation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSchoolURL(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PrincipalInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<PrincipalInfoType> createSchoolInfoTypePrincipalInfo(PrincipalInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType.OtherIdList }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolInfoType.OtherIdList> createSchoolInfoTypeOtherIdList(
      SchoolInfoType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeFederalElectorate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType.Campus }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolInfoType.Campus> createSchoolInfoTypeCampus(SchoolInfoType.Campus value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSLA(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityOpen(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeLocalGovernmentArea(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSchoolDistrict(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsSystemicStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsSystemicStatusType> createSchoolInfoTypeNonGovSystemicStatus(
      AUCodeSetsSystemicStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSystem(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeCommonwealthId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType.SchoolGroupList }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolInfoType.SchoolGroupList> createSchoolInfoTypeSchoolGroupList(
      SchoolInfoType.SchoolGroupList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSchoolInfoTypeEntityClose(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType.SchoolFocusList }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolInfoType.SchoolFocusList> createSchoolInfoTypeSchoolFocusList(
      SchoolInfoType.SchoolFocusList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createSchoolInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSchoolInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSchoolGeographicLocation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSchoolInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSessionType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeBoardingSchoolStatus(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolInfoType.OtherLEA }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolInfoType.OtherLEA> createSchoolInfoTypeOtherLEA(SchoolInfoType.OtherLEA value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeSchoolDistrictLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsOperationalStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsOperationalStatusType> createSchoolInfoTypeOperationalStatus(
      AUCodeSetsOperationalStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressListType> createSchoolInfoTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsSchoolCoEdStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsSchoolCoEdStatusType> createSchoolInfoTypeSchoolCoEdStatus(
      AUCodeSetsSchoolCoEdStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeJurisdictionLowerHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolInfoTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createSchoolInfoTypeARIA(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolContactListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolContactListType> createSchoolInfoTypeSchoolContactList(SchoolContactListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsSchoolLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsSchoolLevelType> createSchoolInfoTypeSchoolType(AUCodeSetsSchoolLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolInfoTypeIndependentSchool(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailListType> createSchoolInfoTypeSchoolEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createSchoolInfoTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeVisaStatisticalCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypePlaceOfBirth(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType }{@code >}}
   * 
   */
  public abstract JAXBElement<LanguageListType> createDemographicsTypeLanguageList(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createDemographicsTypeVisaExpiryDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createDemographicsTypeBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeCulturalBackground(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeAustralianCitizenshipStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsImmunisationCertificateStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsImmunisationCertificateStatusType> createDemographicsTypeImmunisationCertificateStatus(
      AUCodeSetsImmunisationCertificateStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeBirthDateVerification(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypePermanentResident(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType.ReligiousEventList }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType.ReligiousEventList> createDemographicsTypeReligiousEventList(
      DemographicsType.ReligiousEventList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType.Religion }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType.Religion> createDemographicsTypeReligion(DemographicsType.Religion value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeCountryOfBirth(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EnglishProficiencyType }{@code >}}
   * 
   */
  public abstract JAXBElement<EnglishProficiencyType> createDemographicsTypeEnglishProficiency(
      EnglishProficiencyType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeIndigenousStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createDemographicsTypeCountryArrivalDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeMaritalStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType.CountriesOfResidency }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType.CountriesOfResidency> createDemographicsTypeCountriesOfResidency(
      DemographicsType.CountriesOfResidency value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType.DwellingArrangement }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType.DwellingArrangement> createDemographicsTypeDwellingArrangement(
      DemographicsType.DwellingArrangement value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeReligiousRegion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link DemographicsType.CountriesOfCitizenship }{@code >}}
   * 
   */
  public abstract JAXBElement<DemographicsType.CountriesOfCitizenship> createDemographicsTypeCountriesOfCitizenship(
      DemographicsType.CountriesOfCitizenship value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeVisaSubClass(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createDemographicsTypeStateOfBirth(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeResponseChoicesChoiceResponseFeedback(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
   * 
   */
  public abstract JAXBElement<Float> createSif3AssessmentItemTypeResponseChoicesChoiceCreditValue(Float value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeResponseChoicesChoiceChoiceLabel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentPackageType.XMLData }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentPackageType.XMLData> createAssessmentPackageTypeXMLData(
      AssessmentPackageType.XMLData value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentPackageTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentPackageTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeLongName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TeachingGroupType.TeachingGroupPeriodList }{@code >}}
   * 
   */
  public abstract JAXBElement<TeachingGroupType.TeachingGroupPeriodList> createTeachingGroupTypeTeachingGroupPeriodList(
      TeachingGroupType.TeachingGroupPeriodList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeCurriculumLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeSchoolCourseLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createTeachingGroupTypeSemester(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
   * 
   */
  public abstract JAXBElement<BigInteger> createTeachingGroupTypeMaxClassSize(BigInteger value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TeachingGroupType.TeacherList }{@code >}}
   * 
   */
  public abstract JAXBElement<TeachingGroupType.TeacherList> createTeachingGroupTypeTeacherList(
      TeachingGroupType.TeacherList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeSet(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeSchoolCourseInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTimeTableSubjectRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeBlock(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTimeTableSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
   * 
   */
  public abstract JAXBElement<BigInteger> createTeachingGroupTypeMinClassSize(BigInteger value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TeachingGroupType.StudentList }{@code >}}
   * 
   */
  public abstract JAXBElement<TeachingGroupType.StudentList> createTeachingGroupTypeStudentList(
      TeachingGroupType.StudentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createTeachingGroupTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createTeachingGroupTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypePromotionInfoPromotionStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId }{@code >}}
   * 
   */
  public abstract JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeRefId(
      SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList.RoleScope.RoleScopeRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeListRoleScopeRoleScopeName(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.PromotionInfo }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.PromotionInfo> createStudentSchoolEnrollmentTypePromotionInfo(
      StudentSchoolEnrollmentType.PromotionInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.Homeroom }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.Homeroom> createStudentSchoolEnrollmentTypeHomeroom(
      StudentSchoolEnrollmentType.Homeroom value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createStudentSchoolEnrollmentTypeYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.Calendar> createStudentSchoolEnrollmentTypeCalendar(
      StudentSchoolEnrollmentType.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.Counselor }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.Counselor> createStudentSchoolEnrollmentTypeCounselor(
      StudentSchoolEnrollmentType.Counselor value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSchoolEnrollmentTypeExitDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeFTPTStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.EntryType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.EntryType> createStudentSchoolEnrollmentTypeEntryType(
      StudentSchoolEnrollmentType.EntryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.ExitStatus }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.ExitStatus> createStudentSchoolEnrollmentTypeExitStatus(
      StudentSchoolEnrollmentType.ExitStatus value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.StudentSubjectChoiceList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.StudentSubjectChoiceList> createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(
      StudentSchoolEnrollmentType.StudentSubjectChoiceList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeFFPOS(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypePreviousSchool(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.CatchmentStatus }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.CatchmentStatus> createStudentSchoolEnrollmentTypeCatchmentStatus(
      StudentSchoolEnrollmentType.CatchmentStatus value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.Advisor }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.Advisor> createStudentSchoolEnrollmentTypeAdvisor(
      StudentSchoolEnrollmentType.Advisor value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSchoolEnrollmentType.ExitType }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSchoolEnrollmentType.ExitType> createStudentSchoolEnrollmentTypeExitType(
      StudentSchoolEnrollmentType.ExitType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeHomegroup(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeRecordClosureReason(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSchoolEnrollmentTypeDestinationSchool(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentSchoolEnrollmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createStudentSchoolEnrollmentTypeFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentSchoolEnrollmentTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSchoolEnrollmentTypeIndividualLearningPlan(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresUpperCut(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScoresLowerCut(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createLEAInfoTypeLEAContactListLEAContactPublishInDirectory(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createTimeTableSubjectTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createTimeTableSubjectTypeAcademicYear(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTimeTableSubjectTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeTableSubjectType.AcademicYearRange }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeTableSubjectType.AcademicYearRange> createTimeTableSubjectTypeAcademicYearRange(
      TimeTableSubjectType.AcademicYearRange value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeFaculty(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createTimeTableSubjectTypeSemester(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeSubjectType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMinClassSize(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeCourseLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createTimeTableSubjectTypeProposedMaxClassSize(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeSchoolCourseInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeSubjectShortName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableSubjectTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createTimeTableSubjectTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createTimeTableSubjectTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createAssessmentRegistrationTypeAssessmentStudentSnapshotBirthDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentRegistrationTypeAssessmentStudentSnapshotSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemCommentsCommentCommentDescription(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeMainlySpeaksEnglishAtHome(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsSourceCodeTypeType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsSourceCodeTypeType> createStudentContactRelationshipTypeContactSequenceSource(
      AUCodeSetsSourceCodeTypeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentContactRelationshipTypeStudentContactRelationshipRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactRelationshipType.ContactFlags }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactRelationshipType.ContactFlags> createStudentContactRelationshipTypeContactFlags(
      StudentContactRelationshipType.ContactFlags value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactRelationshipType.HouseholdList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactRelationshipType.HouseholdList> createStudentContactRelationshipTypeHouseholdList(
      StudentContactRelationshipType.HouseholdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentContactRelationshipTypeContactSequence(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentContactRelationshipTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentContactRelationshipTypeParentRelationshipStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentContactRelationshipTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodEndTime(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodStartTime(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodInstructionalMinutes(
      Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodBellPeriod(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodUseInAttendanceCalculations(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeTimeTableDayListTimeTableDayTimeTablePeriodListTimeTablePeriodRegularSchoolPeriod(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContentElementType }{@code >}}
   * 
   */
  public abstract JAXBElement<AbstractContentElementType> createSif3AssessmentRubricTypeScoresScoreScoreCodeDefinition(
      AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRubricTypeScoresScoreScoreCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRubricType.Scores.Score.ScoreComments }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreComments> createSif3AssessmentRubricTypeScoresScoreScoreComments(
      Sif3AssessmentRubricType.Scores.Score.ScoreComments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions> createSif3AssessmentRubricTypeScoresScoreScoreDescriptions(
      Sif3AssessmentRubricType.Scores.Score.ScoreDescriptions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createResourceUsageTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createResourceUsageTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolInfoRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentFullYearEnrollment(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentSchoolName(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroom(
      Sif3AssessmentRegistrationType.AssessmentStudentSnapshot.HomeEnrollment.Homeroom value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStateProvinceId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentHomeroomNumber(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshotHomeEnrollmentStudentSchoolEnrollmentRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeSectionSealed(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeItemSelectionAlgorithm(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSectionType.SectionAssets }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSectionType.SectionAssets> createSif3AssessmentSectionTypeSectionAssets(
      Sif3AssessmentSectionType.SectionAssets value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSectionType.SectionItems }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSectionType.SectionItems> createSif3AssessmentSectionTypeSectionItems(
      Sif3AssessmentSectionType.SectionItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link javax.xml.datatype.Duration }{@code >}}
   * 
   */
  public abstract JAXBElement<javax.xml.datatype.Duration> createSif3AssessmentSectionTypeSectionTimeLimit(
      javax.xml.datatype.Duration value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeSectionName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeSectionVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSectionType.SectionIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSectionType.SectionIdentifiers> createSif3AssessmentSectionTypeSectionIdentifiers(
      Sif3AssessmentSectionType.SectionIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeItemSelectionAlgorithmName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeSectionReentry(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentSectionTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentSectionTypeSectionPublishDate(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentSectionTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
   * 
   */
  public abstract JAXBElement<LocationType> createStudentActivityInfoTypeLocation(LocationType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentActivityInfoTypeCurricularStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentActivityInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentActivityInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentActivityInfoTypeStudentActivityLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentActivityInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createStudentActivityInfoTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeEndDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
   * 
   */
  public abstract JAXBElement<Integer> createSif3AssessmentRegistrationTypeDaysOfInstruction(Integer value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRegistrationType.TestingStatuses }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRegistrationType.TestingStatuses> createSif3AssessmentRegistrationTypeTestingStatuses(
      Sif3AssessmentRegistrationType.TestingStatuses value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeScorePublishDate(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeRetestIndicator(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeTestAttemptIdentifier(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRegistrationType.StudentSpecialEvents }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRegistrationType.StudentSpecialEvents> createSif3AssessmentRegistrationTypeStudentSpecialEvents(
      Sif3AssessmentRegistrationType.StudentSpecialEvents value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentAdministrationRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentPlatform(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createSif3AssessmentRegistrationTypeStudentGradeLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeSectionInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentFormRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentRegistrationTypeStartDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRegistrationType.AssessmentStudentSnapshot }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRegistrationType.AssessmentStudentSnapshot> createSif3AssessmentRegistrationTypeAssessmentStudentSnapshot(
      Sif3AssessmentRegistrationType.AssessmentStudentSnapshot value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeAssessmentSessionRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentRegistrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createSif3AssessmentRegistrationTypeAssessmentGradeLevel(
      YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentRegistrationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentParticipationTypeReferralSourceOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackDescription(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackSource(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemFeedbackCode(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemFeedbackItemsFeedbackItemDiagnosticStatement(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypePreviousSchoolsListPreviousSchoolReasonLeft(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestType.SubTestIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestType.SubTestIdentifiers> createSif3AssessmentSubTestTypeSubTestIdentifiers(
      Sif3AssessmentSubTestType.SubTestIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestType.AssessmentItems }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestType.AssessmentItems> createSif3AssessmentSubTestTypeAssessmentItems(
      Sif3AssessmentSubTestType.AssessmentItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentSubTestTypeSubTestPublishDate(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSif3AssessmentSubTestTypeSubTestSubjectAreas(
      SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createSif3AssessmentSubTestTypeSubTestTier(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSubTestTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
   * 
   */
  public abstract JAXBElement<Boolean> createSif3AssessmentSubTestTypeContainerOnly(Boolean value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestType.AssessmentSubTestRefIds> createSif3AssessmentSubTestTypeAssessmentSubTestRefIds(
      Sif3AssessmentSubTestType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestType.ScoreReporting }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestType.ScoreReporting> createSif3AssessmentSubTestTypeScoreReporting(
      Sif3AssessmentSubTestType.ScoreReporting value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSubTestTypeAbbreviation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createSif3AssessmentSubTestTypeSubTestGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createSif3AssessmentSubTestTypeNumberOfItems(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSubTestTypeSubTestVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSubTestType.LearningStandardItemRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSubTestType.LearningStandardItemRefIds> createSif3AssessmentSubTestTypeLearningStandardItemRefIds(
      Sif3AssessmentSubTestType.LearningStandardItemRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentSubTestTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentSubTestTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentItemAssociationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentItemAssociationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId }{@code >}}
   * 
   */
  public abstract JAXBElement<ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId> createResourceUsageTypeResourceReportLineListResourceReportLineSIFRefId(
      ResourceUsageType.ResourceReportLineList.ResourceReportLine.SIFRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createResourceUsageTypeResourceReportLineListResourceReportLineEndDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentActivityInfoTypeStudentActivityTypeOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createLEAInfoTypeEducationAgencyTypeOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportManifestType.ReportFormatList }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportManifestType.ReportFormatList> createReportManifestTypeReportFormatList(
      ReportManifestType.ReportFormatList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportManifestType.ReceivingAuthority }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportManifestType.ReceivingAuthority> createReportManifestTypeReceivingAuthority(
      ReportManifestType.ReceivingAuthority value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportManifestType.ReportingPeriod }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportManifestType.ReportingPeriod> createReportManifestTypeReportingPeriod(
      ReportManifestType.ReportingPeriod value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedQueryDataModelType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedQueryDataModelType> createReportManifestTypeSIFExtendedQuery(
      SIFExtendedQueryDataModelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createReportManifestTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createReportManifestTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportManifestType.SIFQueryGroup }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportManifestType.SIFQueryGroup> createReportManifestTypeSIFQueryGroup(
      ReportManifestType.SIFQueryGroup value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createReportManifestTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeAttendanceTerm(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTermInfoTypeTermSpan(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTermInfoTypeTrack(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeMarkingTerm(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTermInfoTypeTermCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTermInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createTermInfoTypeSchedulingTerm(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createTermInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createTermInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createTermInfoTypeRelativeDuration(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypeScoreRangeMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentSubTestTypeScoreRangeMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoType.SchoolCourseInfoOverride }{@code >}}
   * 
   */
  public abstract JAXBElement<SectionInfoType.SchoolCourseInfoOverride> createSectionInfoTypeSchoolCourseInfoOverride(
      SectionInfoType.SchoolCourseInfoOverride value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoType.MediumOfInstruction }{@code >}}
   * 
   */
  public abstract JAXBElement<SectionInfoType.MediumOfInstruction> createSectionInfoTypeMediumOfInstruction(
      SectionInfoType.MediumOfInstruction value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeTermInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSectionInfoTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoType.LocationOfInstruction }{@code >}}
   * 
   */
  public abstract JAXBElement<SectionInfoType.LocationOfInstruction> createSectionInfoTypeLocationOfInstruction(
      SectionInfoType.LocationOfInstruction value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSectionCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SectionInfoType.LanguageOfInstruction }{@code >}}
   * 
   */
  public abstract JAXBElement<SectionInfoType.LanguageOfInstruction> createSectionInfoTypeLanguageOfInstruction(
      SectionInfoType.LanguageOfInstruction value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeCourseSectionCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeSummerSchool(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSectionInfoTypeCountForAttendance(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSectionInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSectionInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.RelatedLearningStandardItems }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.RelatedLearningStandardItems> createLearningStandardItemTypeRelatedLearningStandardItems(
      LearningStandardItemType.RelatedLearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.StandardIdentifier }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.StandardIdentifier> createLearningStandardItemTypeStandardIdentifier(
      LearningStandardItemType.StandardIdentifier value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.StatementCodes }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.StatementCodes> createLearningStandardItemTypeStatementCodes(
      LearningStandardItemType.StatementCodes value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ACStrandSubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<ACStrandSubjectAreaType> createLearningStandardItemTypeACStrandSubjectArea(
      ACStrandSubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.StandardSettingBody }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.StandardSettingBody> createLearningStandardItemTypeStandardSettingBody(
      LearningStandardItemType.StandardSettingBody value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.Resources }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.Resources> createLearningStandardItemTypeResources(
      LearningStandardItemType.Resources value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardItemTypeLevel5(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardItemTypeLevel4(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.Statements }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.Statements> createLearningStandardItemTypeStatements(
      LearningStandardItemType.Statements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.PredecessorItems }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.PredecessorItems> createLearningStandardItemTypePredecessorItems(
      LearningStandardItemType.PredecessorItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createLearningStandardItemTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createLearningStandardItemTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRegistrationTypeTestingStatusesTestingStatusTestingStatusDescription(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createTimeElementTypeSpanGapsSpanGapEndDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createTimeElementTypeSpanGapsSpanGapStartDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createLanguageListTypeLanguageOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLanguageListTypeLanguageDialect(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLanguageListTypeLanguageLanguageType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAdministrationTypeOrganizationsOrganizationSchoolInfoRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAdministrationTypeOrganizationsOrganizationLEAInfoRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeSchoolName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTimeTableTypeTimeTableCreationDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createTimeTableTypeTeachingPeriodsPerDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTimeTableTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTimeTableTypeEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createTimeTableTypeStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createTimeTableTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createTimeTableTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeCatchmentStatusOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RoomInfoType.StaffList }{@code >}}
   * 
   */
  public abstract JAXBElement<RoomInfoType.StaffList> createRoomInfoTypeStaffList(RoomInfoType.StaffList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberType> createRoomInfoTypePhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createRoomInfoTypeCapacity(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createRoomInfoTypeHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createRoomInfoTypeSize(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createRoomInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createRoomInfoTypeRoomType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createRoomInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createRoomInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createRoomInfoTypeBuilding(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFErrorDataModelTypeSIFExtendedDesc(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link javax.xml.datatype.Duration }{@code >}}
   * 
   */
  public abstract JAXBElement<javax.xml.datatype.Duration> createSif3StudentResponseSetTypeItemsItemTimeOnItem(
      javax.xml.datatype.Duration value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3StudentResponseSetType.Items.Item.TraitScores }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3StudentResponseSetType.Items.Item.TraitScores> createSif3StudentResponseSetTypeItemsItemTraitScores(
      Sif3StudentResponseSetType.Items.Item.TraitScores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemAttemptStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemScore(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemResponseLocation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3StudentResponseSetType.Items.Item.Comments }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3StudentResponseSetType.Items.Item.Comments> createSif3StudentResponseSetTypeItemsItemComments(
      Sif3StudentResponseSetType.Items.Item.Comments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemAssessmentRubricRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3StudentResponseSetType.Items.Item.FeedbackItems }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3StudentResponseSetType.Items.Item.FeedbackItems> createSif3StudentResponseSetTypeItemsItemFeedbackItems(
      Sif3StudentResponseSetType.Items.Item.FeedbackItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemViewStatus(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemResponseCorrectness(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createSif3StudentResponseSetTypeItemsItemNumberOfAttempts(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3StudentResponseSetType.Items.Item.ItemAids }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3StudentResponseSetType.Items.Item.ItemAids> createSif3StudentResponseSetTypeItemsItemItemAids(
      Sif3StudentResponseSetType.Items.Item.ItemAids value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemScoreCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3StudentResponseSetTypeItemsItemItemName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createSchoolProgramsTypeSchoolProgramListProgramOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolProgramsTypeSchoolProgramListProgramCategory(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberType> createLearningResourceTypeContactsContactPhoneNumber(
      PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
   * 
   */
  public abstract JAXBElement<NameType> createLearningResourceTypeContactsContactName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailType> createLearningResourceTypeContactsContactEmail(EmailType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createLearningResourceTypeContactsContactAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypeStudentPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType.AreasOfInterestList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNType.AreasOfInterestList> createStudentSDTNTypeAreasOfInterestList(
      StudentSDTNType.AreasOfInterestList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createStudentSDTNTypeYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PrincipalInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<PrincipalInfoType> createStudentSDTNTypePrincipalInfo(PrincipalInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeYoungCarersRole(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType.PastoralCare }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNType.PastoralCare> createStudentSDTNTypePastoralCare(
      StudentSDTNType.PastoralCare value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypeReasonForLeaving(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType.FurtherInformation }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNType.FurtherInformation> createStudentSDTNTypeFurtherInformation(
      StudentSDTNType.FurtherInformation value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsProgressLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeLiteracy(
      AUCodeSetsProgressLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAttendanceConcerns(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentSDTNTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentSDTNTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeHealthNeeds(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType.PreviousSchoolsList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNType.PreviousSchoolsList> createStudentSDTNTypePreviousSchoolsList(
      StudentSDTNType.PreviousSchoolsList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSDTNTypeEnrollmentDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeCareerGuidanceFileHeld(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSDTNTypeDepartureDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAdjustedEducationProgram(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressListType> createStudentSDTNTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsProgressLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsProgressLevelType> createStudentSDTNTypeNumeracy(
      AUCodeSetsProgressLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeAcceleratedProgram(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSDTNType.OtherLearningAreasList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSDTNType.OtherLearningAreasList> createStudentSDTNTypeOtherLearningAreasList(
      StudentSDTNType.OtherLearningAreasList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeNegotiatedCurriculumPlan(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeLatestStudentReportAvailable(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypeOtherLearningSupport(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypeSchoolCounsellorFileHeld(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedQueryDataModelType.SIFWhere }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedQueryDataModelType.SIFWhere> createSIFExtendedQueryDataModelTypeSIFWhere(
      SIFExtendedQueryDataModelType.SIFWhere value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedQueryDataModelType.SIFOrderBy }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedQueryDataModelType.SIFOrderBy> createSIFExtendedQueryDataModelTypeSIFOrderBy(
      SIFExtendedQueryDataModelType.SIFOrderBy value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFExtendedQueryDataModelTypeSIFDestinationProvider(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createTimeElementTypeEndDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TimeElementType.SpanGaps }{@code >}}
   * 
   */
  public abstract JAXBElement<TimeElementType.SpanGaps> createTimeElementTypeSpanGaps(TimeElementType.SpanGaps value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createTimeElementTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType.FormAccommodations }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType.FormAccommodations> createSif3AssessmentFormTypeFormAccommodations(
      Sif3AssessmentFormType.FormAccommodations value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType.FormIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType.FormIdentifiers> createSif3AssessmentFormTypeFormIdentifiers(
      Sif3AssessmentFormType.FormIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentFormTypeFormVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentFormTypePeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createSif3AssessmentFormTypeGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType }{@code >}}
   * 
   */
  public abstract JAXBElement<LanguageListType> createSif3AssessmentFormTypeAssessmentFormLanguages(
      LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentFormTypeAssessmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSif3AssessmentFormTypeAssessmentFormSubjects(
      SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentFormTypeLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType.AssessmentSubTestRefIds> createSif3AssessmentFormTypeAssessmentSubTestRefIds(
      Sif3AssessmentFormType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType.AssessmentSections }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType.AssessmentSections> createSif3AssessmentFormTypeAssessmentSections(
      Sif3AssessmentFormType.AssessmentSections value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType.AssessmentAssetRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType.AssessmentAssetRefIds> createSif3AssessmentFormTypeAssessmentAssetRefIds(
      Sif3AssessmentFormType.AssessmentAssetRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentFormType.AssessmentPlatforms }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentFormType.AssessmentPlatforms> createSif3AssessmentFormTypeAssessmentPlatforms(
      Sif3AssessmentFormType.AssessmentPlatforms value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentFormTypeFormPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentFormTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentFormTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAggregateStatisticFactTypeExcluded(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAggregateStatisticFactTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAggregateStatisticFactTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createCalendarDateCalendarDateTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes> createLearningStandardItemTypeStandardIdentifierAlternateIdentificationCodes(
      LearningStandardItemType.StandardIdentifier.AlternateIdentificationCodes value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createLearningStandardItemTypeStandardIdentifierYearLevel(
      YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardItemTypeStandardIdentifierIndicatorNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardItemTypeStandardIdentifierBenchmark(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAggregateCharacteristicInfoTypeElementName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAggregateCharacteristicInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAggregateCharacteristicInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAggregateCharacteristicInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType }{@code >}}
   * 
   */
  public abstract JAXBElement<LifeCycleType> createSIFMetadataTypeLifeCycle(LifeCycleType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EducationFilterType }{@code >}}
   * 
   */
  public abstract JAXBElement<EducationFilterType> createSIFMetadataTypeEducationFilter(EducationFilterType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType.TimeElements }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType.TimeElements> createSIFMetadataTypeTimeElements(
      SIFMetadataType.TimeElements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeEntryTypeOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createPhoneNumberTypeListedStatus(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createPhoneNumberTypeExtension(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createPersonPictureTypeOKToPublish(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createPersonPictureTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createPersonPictureTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType.StatisticalAreas.StatisticalArea }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType.StatisticalAreas.StatisticalArea> createAddressTypeStatisticalAreasStatisticalArea(
      AddressType.StatisticalAreas.StatisticalArea value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentScoreSetTypeScoresScoreNumberOfResponses(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentScoreSetTypeScoresScoreDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentScoreSetTypeScoresScoreDiagnosticStatement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSectionTypeSectionItemsSectionItemItemSequence(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType.Created }{@code >}}
   * 
   */
  public abstract JAXBElement<LifeCycleType.Created> createLifeCycleTypeCreated(LifeCycleType.Created value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType.TimeElements }{@code >}}
   * 
   */
  public abstract JAXBElement<LifeCycleType.TimeElements> createLifeCycleTypeTimeElements(
      LifeCycleType.TimeElements value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType.ModificationHistory }{@code >}}
   * 
   */
  public abstract JAXBElement<LifeCycleType.ModificationHistory> createLifeCycleTypeModificationHistory(
      LifeCycleType.ModificationHistory value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.Components.Component.Strategies }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.Components.Component.Strategies> createLearningResourceTypeComponentsComponentStrategies(
      LearningResourceType.Components.Component.Strategies value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningResourceType.Components.Component.AssociatedObjects }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningResourceType.Components.Component.AssociatedObjects> createLearningResourceTypeComponentsComponentAssociatedObjects(
      LearningResourceType.Components.Component.AssociatedObjects value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeComponentsComponentDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
   * 
   */
  public abstract JAXBElement<NameType> createLearningResourceTypeEvaluationsEvaluationName(NameType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningResourceTypeEvaluationsEvaluationDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningResourceTypeEvaluationsEvaluationDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDescription(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createResourceUsageTypeResourceReportColumnListResourceReportColumnColumnDelimiter(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFHeaderDataModelType.SIFSecurity }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFHeaderDataModelType.SIFSecurity> createSIFHeaderDataModelTypeSIFSecurity(
      SIFHeaderDataModelType.SIFSecurity value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFContextsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFContextsType> createSIFHeaderDataModelTypeSIFContexts(SIFContextsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFHeaderDataModelTypeSIFDestinationId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentContactPersonalTypeNonSchoolEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentContactPersonalTypeLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentContactPersonalType.OtherIdList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentContactPersonalType.OtherIdList> createStudentContactPersonalTypeOtherIdList(
      StudentContactPersonalType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentContactPersonalTypeEmploymentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentContactPersonalTypeSchoolEducationalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentContactPersonalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentContactPersonalTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
   * 
   */
  public abstract JAXBElement<Float> createAssessmentItemTypeResponseChoicesChoiceCreditValue(Float value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentItemTypeResponseChoicesChoiceChoiceLabel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeStudentListTeachingGroupStudentStudentPersonalRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeDayId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeLocation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeActivityType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypePeriodId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeCellType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressListType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressListType> createScheduledActivityTypeAddressList(AddressListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeTimeTableCellRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeTimeTableRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityType.TeacherList }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityType.TeacherList> createScheduledActivityTypeTeacherList(
      ScheduledActivityType.TeacherList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeActivityComment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityType.TeachingGroupList }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityType.TeachingGroupList> createScheduledActivityTypeTeachingGroupList(
      ScheduledActivityType.TeachingGroupList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityType.RoomList }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityType.RoomList> createScheduledActivityTypeRoomList(
      ScheduledActivityType.RoomList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeTimeTableSubjectRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeActivityName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityType.StudentList }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityType.StudentList> createScheduledActivityTypeStudentList(
      ScheduledActivityType.StudentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ScheduledActivityType.Override }{@code >}}
   * 
   */
  public abstract JAXBElement<ScheduledActivityType.Override> createScheduledActivityTypeOverride(
      ScheduledActivityType.Override value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createScheduledActivityTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createScheduledActivityTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createScheduledActivityTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackSource(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentScoreTableTypeScoreValuesScoreValueFeedbackListFeedbackDescription(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAdministrationType.AdministrationAssessments }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAdministrationType.AdministrationAssessments> createSif3AssessmentAdministrationTypeAdministrationAssessments(
      Sif3AssessmentAdministrationType.AdministrationAssessments value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAdministrationTypeAdministrationCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentAdministrationTypeFinishDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentAdministrationTypeStartDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentAdministrationTypeAdministrationName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentAdministrationType.Organizations }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentAdministrationType.Organizations> createSif3AssessmentAdministrationTypeOrganizations(
      Sif3AssessmentAdministrationType.Organizations value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentAdministrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentAdministrationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createDemographicsTypeReligionOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentParticipationTypeProgramFundingSourcesProgramFundingSourceOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSystemRoleTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSystemRoleTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSubjectLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentCourseLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTimeTableSubjectRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolCourseInfoRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentTeachingGroupRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentSchoolYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentListEnrollmentShortName(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createSectionInfoTypeLocationOfInstructionOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3StudentResponseSetTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3StudentResponseSetTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentRegistrationTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentRegistrationTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createAssessmentRegistrationTypeStudentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentRegistrationType.StudentSpecialConditions }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentRegistrationType.StudentSpecialConditions> createAssessmentRegistrationTypeStudentSpecialConditions(
      AssessmentRegistrationType.StudentSpecialConditions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentRegistrationTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentRegistrationType.AssessmentStudentSnapshot }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentRegistrationType.AssessmentStudentSnapshot> createAssessmentRegistrationTypeAssessmentStudentSnapshot(
      AssessmentRegistrationType.AssessmentStudentSnapshot value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createAssessmentRegistrationTypeAssessmentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentRegistrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentRegistrationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createRelationshipTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoicePreferenceNumber(
      Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceOtherSchoolLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaType> createStudentSnapshotTypeStudentSubjectChoiceListStudentSubjectChoiceStudyDescription(
      SubjectAreaType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createSectionInfoTypeMediumOfInstructionOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodEndSubmitDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodEndReportDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodDueDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodBeginSubmitDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createReportManifestTypeReportingPeriodBeginReportDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSnapshotType.HomeEnrollment.Homeroom }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSnapshotType.HomeEnrollment.Homeroom> createStudentSnapshotTypeHomeEnrollmentHomeroom(
      StudentSnapshotType.HomeEnrollment.Homeroom value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelType> createStudentSnapshotTypeHomeEnrollmentYearLevel(YearLevelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentHomeroomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentStudentSchoolEnrollmentRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeHomeEnrollmentSchoolNo(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeTechnicalRequirementsTechnicalRequirement(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentScoreTableType.ScoreTableIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentScoreTableType.ScoreTableIdentifiers> createSif3AssessmentScoreTableTypeScoreTableIdentifiers(
      Sif3AssessmentScoreTableType.ScoreTableIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentScoreTableTypeScoreTablePublishDate(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentScoreTableTypeScoreTableVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentScoreTableType.ScoreValues }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentScoreTableType.ScoreValues> createSif3AssessmentScoreTableTypeScoreValues(
      Sif3AssessmentScoreTableType.ScoreValues value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentScoreTableTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentScoreTableTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeOnTimeGraduationYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeStudentSnapshotRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeBirthDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSnapshotTypeSex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentSnapshotTypeAge(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentSnapshotType.StudentSubjectChoiceList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentSnapshotType.StudentSubjectChoiceList> createStudentSnapshotTypeStudentSubjectChoiceList(
      StudentSnapshotType.StudentSubjectChoiceList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentSnapshotTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentSnapshotTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSnapshotTypeProjectedGraduationYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementOS(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeSoftwareRequirementListSoftwareRequirementVendor(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeDistrictCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeCourseCredits(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeCourseContent(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSchoolCourseInfoTypeSubjectAreaList(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeTermInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSchoolCourseInfoTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolCourseInfoTypeCoreAcademicCourse(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolCourseInfoTypeGraduationRequirement(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeStateCourseCode(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeDepartment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSchoolCourseInfoTypeInstructionalLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSchoolCourseInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSchoolCourseInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentFormType.AssessmentSubTestRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentFormType.AssessmentSubTestRefIds> createAssessmentFormTypeAssessmentSubTestRefIds(
      AssessmentFormType.AssessmentSubTestRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentFormTypeLevel(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentFormTypePeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentFormType.FormNumbers }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentFormType.FormNumbers> createAssessmentFormTypeFormNumbers(
      AssessmentFormType.FormNumbers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentFormTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentFormTypeAssessmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentFormTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createAssessmentFormTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFReportObjectTypeReportInfoDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo> createSIFReportObjectTypeReportInfoReportSubmitterInfo(
      SIFReportObjectType.ReportInfo.ReportSubmitterInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPersonalType.AlertMessages }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPersonalType.AlertMessages> createStudentPersonalTypeAlertMessages(
      StudentPersonalType.AlertMessages value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeOnTimeGraduationYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeDisability(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeYoungCarersRole(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPersonalType.OtherIdList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPersonalType.OtherIdList> createStudentPersonalTypeOtherIdList(
      StudentPersonalType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypePrePrimaryEducation(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeEconomicDisadvantage(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPersonalType.MedicalAlertMessages }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPersonalType.MedicalAlertMessages> createStudentPersonalTypeMedicalAlertMessages(
      StudentPersonalType.MedicalAlertMessages value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeESL(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeAcceptableUsePolicy(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeProjectedGraduationYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPersonalTypeGraduationDate(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentPersonalTypeFirstAUSchoolEnrollment(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicIdListType }{@code >}}
   * 
   */
  public abstract JAXBElement<ElectronicIdListType> createStudentPersonalTypeElectronicIdList(ElectronicIdListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeIntegrationAide(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPersonalType.MostRecent }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPersonalType.MostRecent> createStudentPersonalTypeMostRecent(
      StudentPersonalType.MostRecent value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentPersonalTypeGiftedTalented(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentPersonalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentPersonalTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeScheduledStartDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSessionType.StaffPersonalRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSessionType.StaffPersonalRefIds> createSif3AssessmentSessionTypeStaffPersonalRefIds(
      Sif3AssessmentSessionType.StaffPersonalRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeScheduledEndDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeActualEndDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentSessionTypeActualStartDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSessionTypeAssessmentAdministrationRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSessionTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSessionTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSessionTypeAssessmentFormRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentSessionType.UnusualEvents }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentSessionType.UnusualEvents> createSif3AssessmentSessionTypeUnusualEvents(
      Sif3AssessmentSessionType.UnusualEvents value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentSessionTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createSif3AssessmentSessionTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentSessionTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createPrincipalInfoTypeContactTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createPrincipalInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailListType> createPrincipalInfoTypeEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentScoreSetTypeAssessmentRegistrationRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createStudentScoreSetTypeFinishDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createStudentScoreSetTypeStartDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentScoreSetTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentScoreSetTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingScoreTableRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentSubTestTypeScoreReportingMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createTeachingGroupTypeTeacherListTeachingGroupTeacherStaffPersonalRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<ContactInfoType> createSIFReportObjectTypeReportInfoReportSubmitterInfoContactInfo(
      ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberType> createSIFReportObjectTypeReportInfoReportSubmitterInfoPhoneNumber(
      PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId> createSIFReportObjectTypeReportInfoReportSubmitterInfoSIFRefId(
      SIFReportObjectType.ReportInfo.ReportSubmitterInfo.SIFRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterDepartment(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSIFReportObjectTypeReportInfoReportSubmitterInfoSubmitterNotes(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createSIFReportObjectTypeReportInfoReportSubmitterInfoAddress(
      AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentDailyAttendanceTypeTimeIn(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentDailyAttendanceTypeTimeOut(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createStudentDailyAttendanceTypeAbsenceValue(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsDayValueCodeType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsDayValueCodeType> createStudentDailyAttendanceTypeDayValue(
      AUCodeSetsDayValueCodeType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentDailyAttendanceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentDailyAttendanceTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentDailyAttendanceTypeAttendanceNote(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeEndOfLifeDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeLocalArchiveDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardDocumentType.Authors }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardDocumentType.Authors> createLearningStandardDocumentTypeAuthors(
      LearningStandardDocumentType.Authors value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeDocumentDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardDocumentTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeLocalAdoptionDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContentElementType }{@code >}}
   * 
   */
  public abstract JAXBElement<AbstractContentElementType> createLearningStandardDocumentTypeRichDescription(
      AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardDocumentType.Copyright }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardDocumentType.Copyright> createLearningStandardDocumentTypeCopyright(
      LearningStandardDocumentType.Copyright value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LearningStandardDocumentType.RelatedLearningStandards }{@code >}}
   * 
   */
  public abstract JAXBElement<LearningStandardDocumentType.RelatedLearningStandards> createLearningStandardDocumentTypeRelatedLearningStandards(
      LearningStandardDocumentType.RelatedLearningStandards value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeRepositoryDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardDocumentTypeOrganizationContactPoint(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createLearningStandardDocumentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createLearningStandardDocumentTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createLearningStandardDocumentTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudentStudentLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LocationType.LocationRefId }{@code >}}
   * 
   */
  public abstract JAXBElement<LocationType.LocationRefId> createLocationTypeLocationRefId(
      LocationType.LocationRefId value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLocationTypeLocationName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLearningStandardDocumentTypeCopyrightHolder(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createLearningStandardDocumentTypeCopyrightDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffAssignmentTypeStaffSubjectListStaffSubjectSubjectLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffAssignmentTypeStaffSubjectListStaffSubjectTimeTableSubjectRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeTimeIn(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPeriodAttendanceTypeSessionInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeTimeOut(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPeriodAttendanceTypeTimetablePeriod(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentPeriodAttendanceType.AuditInfo }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentPeriodAttendanceType.AuditInfo> createStudentPeriodAttendanceTypeAuditInfo(
      StudentPeriodAttendanceType.AuditInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentPeriodAttendanceTypeSchoolYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentPeriodAttendanceTypeAttendanceComment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentPeriodAttendanceTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentPeriodAttendanceTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolInfoRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student }{@code >}}
   * 
   */
  public abstract JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStudent(
      SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Student value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff }{@code >}}
   * 
   */
  public abstract JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaff(
      SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.Staff value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList }{@code >}}
   * 
   */
  public abstract JAXBElement<SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentEnrollmentList(
      SummaryEnrollmentInfoType.SchoolEnrollmentList.SchoolEnrollment.EnrollmentList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentSchoolStateProvinceId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentParticipationTypeProgramAvailabilityOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarDate.TeacherAttendance }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarDate.TeacherAttendance> createCalendarDateTeacherAttendance(
      CalendarDate.TeacherAttendance value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarDate.StudentAttendance }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarDate.StudentAttendance> createCalendarDateStudentAttendance(
      CalendarDate.StudentAttendance value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CalendarDate.AdministratorAttendance }{@code >}}
   * 
   */
  public abstract JAXBElement<CalendarDate.AdministratorAttendance> createCalendarDateAdministratorAttendance(
      CalendarDate.AdministratorAttendance value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createCalendarDateCalendarDateNumber(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createCalendarDateCalendarDateRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createCalendarDateSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createCalendarDateSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentActivityParticipationTypeRole(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StudentActivityParticipationType.RecognitionList }{@code >}}
   * 
   */
  public abstract JAXBElement<StudentActivityParticipationType.RecognitionList> createStudentActivityParticipationTypeRecognitionList(
      StudentActivityParticipationType.RecognitionList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentActivityParticipationTypeParticipationComment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeSchoolYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeEndDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentActivityParticipationTypeStartDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentActivityParticipationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentActivityParticipationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores> createAssessmentSubTestTypePerformanceLevelsPerformanceLevelCutScores(
      AssessmentSubTestType.PerformanceLevels.PerformanceLevel.CutScores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentTypeAssessmentItemBanksAssessmentItemBankAssessmentItemBankName(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypePastoralCareIndividualBehaviourPlan(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentSDTNTypePastoralCareDisciplinaryAbsences(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentItemType.LearningStandardItems }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentItemType.LearningStandardItems> createAssessmentItemTypeLearningStandardItems(
      AssessmentItemType.LearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentItemTypeItemScoreMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentItemType.PerformanceLevels }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentItemType.PerformanceLevels> createAssessmentItemTypePerformanceLevels(
      AssessmentItemType.PerformanceLevels value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentItemTypeItemScoreMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContentElementType }{@code >}}
   * 
   */
  public abstract JAXBElement<AbstractContentElementType> createAssessmentItemTypeStem(AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentItemTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentItemType.ResponseChoices }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentItemType.ResponseChoices> createAssessmentItemTypeResponseChoices(
      AssessmentItemType.ResponseChoices value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContentElementType }{@code >}}
   * 
   */
  public abstract JAXBElement<AbstractContentElementType> createAssessmentItemTypeStimulus(
      AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentItemTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentItemTypeItemName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSchoolContactListTypeSchoolContactPublishInDirectory(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList }{@code >}}
   * 
   */
  public abstract JAXBElement<SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList> createSystemRoleTypeSystemContextListSystemContextRoleListRoleRoleScopeList(
      SystemRoleType.SystemContextList.SystemContext.RoleList.Role.RoleScopeList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createSubjectAreaTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EducationFilterType.LearningStandardItems }{@code >}}
   * 
   */
  public abstract JAXBElement<EducationFilterType.LearningStandardItems> createEducationFilterTypeLearningStandardItems(
      EducationFilterType.LearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRubricType.Scores }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRubricType.Scores> createSif3AssessmentRubricTypeScores(
      Sif3AssessmentRubricType.Scores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRubricTypeScoringGuideReference(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentRubricTypeRubricVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentRubricTypeRubricPublishDate(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentRubricType.RubricIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentRubricType.RubricIdentifiers> createSif3AssessmentRubricTypeRubricIdentifiers(
      Sif3AssessmentRubricType.RubricIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentRubricTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentRubricTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeExitStatusOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSummaryEnrollmentInfoTypeSchoolEnrollmentListSchoolEnrollmentStaffStaffLocalId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetStreetType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetStreetSuffix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetApartmentNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetStreetNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetComplex(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetStreetPrefix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetLine3(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetLine2(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetApartmentNumberSuffix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetApartmentType(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetStreetName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAddressTypeStreetApartmentNumberPrefix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverStaffLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverSupervision(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverStartTime(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createScheduledActivityTypeTeacherListTeacherCoverWeighting(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createScheduledActivityTypeTeacherListTeacherCoverFinishTime(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createScheduledActivityTypeTeacherListTeacherCoverCredit(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createContactInfoTypeRole(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberListType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberListType> createContactInfoTypePhoneNumberList(PhoneNumberListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createContactInfoTypePositionTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link EmailListType }{@code >}}
   * 
   */
  public abstract JAXBElement<EmailListType> createContactInfoTypeEmailList(EmailListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createContactInfoTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.AssessmentItemPlatforms }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.AssessmentItemPlatforms> createSif3AssessmentItemTypeAssessmentItemPlatforms(
      Sif3AssessmentItemType.AssessmentItemPlatforms value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.LearningStandardItems }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.LearningStandardItems> createSif3AssessmentItemTypeLearningStandardItems(
      Sif3AssessmentItemType.LearningStandardItems value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.AssessmentItemBanks }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.AssessmentItemBanks> createSif3AssessmentItemTypeAssessmentItemBanks(
      Sif3AssessmentItemType.AssessmentItemBanks value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemScoreMaximum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.ItemRubricIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.ItemRubricIds> createSif3AssessmentItemTypeItemRubricIds(
      Sif3AssessmentItemType.ItemRubricIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType }{@code >}}
   * 
   */
  public abstract JAXBElement<LanguageListType> createSif3AssessmentItemTypeAssessmentLanguages(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContentElementType }{@code >}}
   * 
   */
  public abstract JAXBElement<AbstractContentElementType> createSif3AssessmentItemTypeStem(
      AbstractContentElementType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createSif3AssessmentItemTypeAssessmentGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSif3AssessmentItemTypeAssessmentSubjects(
      SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemScoreMinimum(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.AssessmentIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.AssessmentIdentifiers> createSif3AssessmentItemTypeAssessmentIdentifiers(
      Sif3AssessmentItemType.AssessmentIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackCorrect(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackIncorrect(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.AssessmentItemAssetRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.AssessmentItemAssetRefIds> createSif3AssessmentItemTypeAssessmentItemAssetRefIds(
      Sif3AssessmentItemType.AssessmentItemAssetRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemFeedbackHint(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createSif3AssessmentItemTypeItemPublishDate(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentItemTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentItemType.ResponseChoices }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentItemType.ResponseChoices> createSif3AssessmentItemTypeResponseChoices(
      Sif3AssessmentItemType.ResponseChoices value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentItemTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemVersion(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentItemTypeItemName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createBaseNameTypePreferredFamilyNameFirst(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypePreferredFamilyName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypeFamilyName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypeTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypePreferredGivenName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createBaseNameTypeFamilyNameFirst(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypeMiddleName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypeFullName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypeSuffix(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createBaseNameTypeGivenName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeEntryDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeSchoolYear(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStudentSectionEnrollmentTypeExitDate(
      XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentSectionEnrollmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentSectionEnrollmentTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createDemographicsTypeDwellingArrangementOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSessionInfoTypeStartTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createSessionInfoTypeRollMarked(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSessionInfoTypeRoomNumber(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSessionInfoTypeSchoolLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSessionInfoTypeFinishTime(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSessionInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSessionInfoTypeStaffPersonalLocalId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSessionInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentSDTNTypeAreasOfInterestListActivityInfoStudentActivityInfoRefId(
      String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SchoolProgramsType.SchoolProgramList }{@code >}}
   * 
   */
  public abstract JAXBElement<SchoolProgramsType.SchoolProgramList> createSchoolProgramsTypeSchoolProgramList(
      SchoolProgramsType.SchoolProgramList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createSchoolProgramsTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSchoolProgramsTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSchoolProgramsTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores> createAssessmentItemTypePerformanceLevelsPerformanceLevelCutScores(
      AssessmentItemType.PerformanceLevels.PerformanceLevel.CutScores value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffAssignmentType.StaffActivity }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffAssignmentType.StaffActivity> createStaffAssignmentTypeStaffActivity(
      StaffAssignmentType.StaffActivity value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeSchoolYear(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobStartDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffAssignmentTypeDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
   * 
   */
  public abstract JAXBElement<XMLGregorianCalendar> createStaffAssignmentTypeJobEndDate(XMLGregorianCalendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStaffAssignmentTypeCasualReliefTeacher(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffAssignmentTypeHouse(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createStaffAssignmentTypeJobFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffAssignmentTypeHomegroup(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffAssignmentTypeJobFunction(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffAssignmentType.StaffSubjectList }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffAssignmentType.StaffSubjectList> createStaffAssignmentTypeStaffSubjectList(
      StaffAssignmentType.StaffSubjectList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStaffAssignmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStaffAssignmentTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createStaffAssignmentTypeYearLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createActivityTypeEvaluationDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFReportObjectType.ReportInfo }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFReportObjectType.ReportInfo> createSIFReportObjectTypeReportInfo(
      SIFReportObjectType.ReportInfo value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedQueryResultsDataModelType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedQueryResultsDataModelType> createSIFReportObjectTypeSIFExtendedQueryResults(
      SIFExtendedQueryResultsDataModelType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReportDataObjectType }{@code >}}
   * 
   */
  public abstract JAXBElement<ReportDataObjectType> createSIFReportObjectTypeReportData(ReportDataObjectType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSIFReportObjectTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSIFReportObjectTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAreaListType }{@code >}}
   * 
   */
  public abstract JAXBElement<SubjectAreaListType> createSif3AssessmentTypeAssessmentSubjects(SubjectAreaListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentTypeAssessmentProvider(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentType.AssessmentIdentifiers }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentType.AssessmentIdentifiers> createSif3AssessmentTypeAssessmentIdentifiers(
      Sif3AssessmentType.AssessmentIdentifiers value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentType.AssessmentItemBanks }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentType.AssessmentItemBanks> createSif3AssessmentTypeAssessmentItemBanks(
      Sif3AssessmentType.AssessmentItemBanks value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createSif3AssessmentTypeAssessmentPackageRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentType.LearningStandardItemRefIds }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentType.LearningStandardItemRefIds> createSif3AssessmentTypeLearningStandardItemRefIds(
      Sif3AssessmentType.LearningStandardItemRefIds value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LanguageListType }{@code >}}
   * 
   */
  public abstract JAXBElement<LanguageListType> createSif3AssessmentTypeAssessmentLanguages(LanguageListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Sif3AssessmentType.AssessmentDescriptors }{@code >}}
   * 
   */
  public abstract JAXBElement<Sif3AssessmentType.AssessmentDescriptors> createSif3AssessmentTypeAssessmentDescriptors(
      Sif3AssessmentType.AssessmentDescriptors value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link YearLevelsType }{@code >}}
   * 
   */
  public abstract JAXBElement<YearLevelsType> createSif3AssessmentTypeAssessmentGradeLevels(YearLevelsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createSif3AssessmentTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createSif3AssessmentTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createLifeCycleTypeModificationHistoryModifiedDescription(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStaffAssignmentTypeStaffActivityOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentAdministrationTypeSchoolInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentAdministrationTypeLEAInfoRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AssessmentAdministrationType.SpecialConditions }{@code >}}
   * 
   */
  public abstract JAXBElement<AssessmentAdministrationType.SpecialConditions> createAssessmentAdministrationTypeSpecialConditions(
      AssessmentAdministrationType.SpecialConditions value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentAdministrationTypeStaffPersonalRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeFinishDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeStartDateTime(
      java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createAssessmentAdministrationTypeAdministrationName(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link java.util.Calendar }{@code >}}
   * 
   */
  public abstract JAXBElement<java.util.Calendar> createAssessmentAdministrationTypeDueDateTime(java.util.Calendar value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createAssessmentAdministrationTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createAssessmentAdministrationTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createAssessmentAdministrationTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createSectionInfoTypeLanguageOfInstructionOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createStudentAttendanceSummaryTypeDaysTardy(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStudentAttendanceSummaryTypeStudentAttendanceSummaryRefId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentAttendanceSummaryTypeStartDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStudentAttendanceSummaryTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
   * 
   */
  public abstract JAXBElement<BigDecimal> createStudentAttendanceSummaryTypeFTE(BigDecimal value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStudentAttendanceSummaryTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
   * 
   */
  public abstract JAXBElement<Long> createStudentAttendanceSummaryTypeEndDay(Long value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createProgramStatusTypeOtherCodeList(OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsStaffStatusType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsStaffStatusType> createStaffPersonalTypeEmploymentStatus(
      AUCodeSetsStaffStatusType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffPersonalTypeStateProvinceId(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link StaffPersonalType.OtherIdList }{@code >}}
   * 
   */
  public abstract JAXBElement<StaffPersonalType.OtherIdList> createStaffPersonalTypeOtherIdList(
      StaffPersonalType.OtherIdList value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createStaffPersonalTypeTitle(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicIdListType }{@code >}}
   * 
   */
  public abstract JAXBElement<ElectronicIdListType> createStaffPersonalTypeElectronicIdList(ElectronicIdListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createStaffPersonalTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createStaffPersonalTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsHasCustody(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsFeesBilling(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsReceivesAssessmentReport(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsEmergencyContact(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsPickupRights(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsAttendanceContact(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsAccessToRecords(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsFamilyMail(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsInterventionOrder(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsParentLegalGuardian(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsDisciplinaryContact(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AUCodeSetsYesOrNoCategoryType }{@code >}}
   * 
   */
  public abstract JAXBElement<AUCodeSetsYesOrNoCategoryType> createStudentContactRelationshipTypeContactFlagsLivesWith(
      AUCodeSetsYesOrNoCategoryType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OtherCodeListType }{@code >}}
   * 
   */
  public abstract JAXBElement<OtherCodeListType> createStudentSchoolEnrollmentTypeExitTypeOtherCodeList(
      OtherCodeListType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfoType }{@code >}}
   * 
   */
  public abstract JAXBElement<ContactInfoType> createReportAuthorityInfoTypeContactInfo(ContactInfoType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PhoneNumberType }{@code >}}
   * 
   */
  public abstract JAXBElement<PhoneNumberType> createReportAuthorityInfoTypePhoneNumber(PhoneNumberType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
   * 
   */
  public abstract JAXBElement<String> createReportAuthorityInfoTypeAuthorityDepartment(String value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFMetadataType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFMetadataType> createReportAuthorityInfoTypeSIFMetadata(SIFMetadataType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SIFExtendedElementsType }{@code >}}
   * 
   */
  public abstract JAXBElement<SIFExtendedElementsType> createReportAuthorityInfoTypeSIFExtendedElements(
      SIFExtendedElementsType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
   * 
   */
  public abstract JAXBElement<AddressType> createReportAuthorityInfoTypeAddress(AddressType value);

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link LifeCycleType.Created.Creators }{@code >}}
   * 
   */
  public abstract JAXBElement<LifeCycleType.Created.Creators> createLifeCycleTypeCreatedCreators(
      LifeCycleType.Created.Creators value);

}