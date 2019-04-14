package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentSchoolEnrollmentPublishingPermission;
import sif3.hits.domain.model.StudentGroup;
import sif3.hits.domain.model.StudentSchoolEnrollment;
import sif3.hits.domain.model.StudentSubjectChoice;

import java.util.ArrayList;

@Component
public class StudentSchoolEnrollmentConverter
        extends HitsConverter<StudentSchoolEnrollmentType, StudentSchoolEnrollment> {

    @Autowired
    StudentGroupConverter studentGroupConverter;

    @Autowired
    StudentSubjectChoiceConverter studentSubjectChoiceConverter;

    @Autowired
    StudentSchoolEnrollmentPublishingPermissionConverter publishingPermissionConverter;

    public StudentSchoolEnrollmentConverter() {
        super(StudentSchoolEnrollmentType.class, StudentSchoolEnrollment.class);
    }

    @Override
    public void toSifModel(StudentSchoolEnrollment source, StudentSchoolEnrollmentType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setMembershipType(getEnumValue(source.getMembershipType(), AUCodeSetsSchoolEnrollmentTypeType.class));
            target.setLocalId(objectFactory.createStudentSchoolEnrollmentTypeLocalId(source.getLocalId()));
            target.setTimeFrame(getEnumValue(source.getTimeFrame(), AUCodeSetsEnrollmentTimeFrameType.class));
            target.setSchoolYear(getDateValue(source.getSchoolYear()));
            target.setEntryDate(getDateValue(source.getEntryDate()));
            target.setHomegroup(objectFactory.createStudentSchoolEnrollmentTypeHomegroup(source.getHomegroup()));
            target.setACARASchoolId(objectFactory.createStudentSchoolEnrollmentTypeACARASchoolId(source.getAcaraSchoolId()));
            target.setClassCode(objectFactory.createStudentSchoolEnrollmentTypeClassCode(source.getClassCode()));
            target.setReportingSchool(objectFactory.createStudentSchoolEnrollmentTypeReportingSchool(getEnumValue(source.getReportingSchool(), AUCodeSetsYesOrNoCategoryType.class)));
            target.setHouse(objectFactory.createStudentSchoolEnrollmentTypeHouse(source.getHouse()));
            target.setIndividualLearningPlan(objectFactory.createStudentSchoolEnrollmentTypeIndividualLearningPlan(getEnumValue(source.getIndividualLearningPlan(), AUCodeSetsYesOrNoCategoryType.class)));
            target.setExitDate(objectFactory.createStudentSchoolEnrollmentTypeExitDate(getDateValue(source.getExitDate())));
            target.setFTE(objectFactory.createStudentSchoolEnrollmentTypeFTE(getBigDecimalValue(source.getFte())));
            target.setFTPTStatus(objectFactory.createStudentSchoolEnrollmentTypeFTPTStatus(getEnumValue(source.getFtptStatus(), AUCodeSetsFTPTStatusCodeType.class)));
            target.setFFPOS(objectFactory.createStudentSchoolEnrollmentTypeFFPOS(getEnumValue(source.getFfpos(), AUCodeSetsFFPOSStatusCodeType.class)));
            target.setRecordClosureReason(objectFactory.createStudentSchoolEnrollmentTypeRecordClosureReason(source.getRecordClosureReason()));
            target.setPreviousSchool(objectFactory.createStudentSchoolEnrollmentTypePreviousSchool(source.getPreviousSchool()));
            target.setPreviousSchoolName(objectFactory.createStudentSchoolEnrollmentTypePreviousSchoolName(source.getPreviousSchoolName()));
            target.setDestinationSchool(objectFactory.createStudentSchoolEnrollmentTypeDestinationSchool(source.getDestinationSchool()));
            target.setDestinationSchoolName(objectFactory.createStudentSchoolEnrollmentTypeDestinationSchoolName(source.getDestinationSchoolName()));
            target.setStartedAtSchoolDate(objectFactory.createStudentSchoolEnrollmentTypeStartedAtSchoolDate(getDateValue(source.getStartedAtSchoolDate())));

            AUCodeSetsEntryTypeType entryType = getEnumValue(source.getEntryType(), AUCodeSetsEntryTypeType.class);
            if (entryType != null) {
                StudentEntryContainerType entryTypeContainer = objectFactory.createStudentEntryContainerType();
                entryTypeContainer.setCode(entryType);
                target.setEntryType(objectFactory.createStudentSchoolEnrollmentTypeEntryType(entryTypeContainer));
            }

            AUCodeSetsYearLevelCodeType yearLevel = getEnumValue(source.getYearLevel(), AUCodeSetsYearLevelCodeType.class);
            if (yearLevel != null) {
                YearLevelType yearLevelType = objectFactory.createYearLevelType();
                yearLevelType.setCode(yearLevel);
                target.setYearLevel(objectFactory.createStudentSchoolEnrollmentTypeYearLevel(yearLevelType));
            }

            if (StringUtils.isNotBlank(source.getHomeroomRefId())) {
                StudentSchoolEnrollmentType.Homeroom homeroom = objectFactory.createStudentSchoolEnrollmentTypeHomeroom();
                homeroom.setSIFRefObject("RoomInfo");
                homeroom.setValue(source.getHomeroomRefId());
                target.setHomeroom(objectFactory.createStudentSchoolEnrollmentTypeHomeroom(homeroom));
            }

            if (StringUtils.isNotBlank(source.getAdvisorRefId())) {
                StudentSchoolEnrollmentType.Advisor advisor = objectFactory.createStudentSchoolEnrollmentTypeAdvisor();
                advisor.setSIFRefObject("StaffPersonal");
                advisor.setValue(source.getAdvisorRefId());
                target.setAdvisor(objectFactory.createStudentSchoolEnrollmentTypeAdvisor(advisor));
            }

            if (StringUtils.isNotBlank(source.getCounselorRefId())) {
                StudentSchoolEnrollmentType.Counselor counselor = objectFactory.createStudentSchoolEnrollmentTypeCounselor();
                counselor.setSIFRefObject("StaffPersonal");
                counselor.setValue(source.getCounselorRefId());
                target.setCounselor(objectFactory.createStudentSchoolEnrollmentTypeCounselor(counselor));
            }

            AUCodeSetsYearLevelCodeType testLevel = getEnumValue(source.getTestLevel(), AUCodeSetsYearLevelCodeType.class);
            if (testLevel != null) {
                YearLevelType testLevelType = objectFactory.createYearLevelType();
                testLevelType.setCode(testLevel);
                target.setTestLevel(objectFactory.createStudentSchoolEnrollmentTypeTestLevel(testLevelType));
            }

            if (StringUtils.isNotBlank(source.getCalendarRefId())) {
                StudentSchoolEnrollmentType.Calendar calendar = objectFactory.createStudentSchoolEnrollmentTypeCalendar();
                calendar.setSIFRefObject("CalendarSummary");
                calendar.setValue(source.getCalendarRefId());
                target.setCalendar(objectFactory.createStudentSchoolEnrollmentTypeCalendar(calendar));
            }

            AUCodeSetsExitWithdrawalStatusType exitStatus = getEnumValue(source.getExitStatus(), AUCodeSetsExitWithdrawalStatusType.class);
            if (exitStatus != null) {
                StudentExitStatusContainerType exitStatusContainer = objectFactory.createStudentExitStatusContainerType();
                exitStatusContainer.setCode(exitStatus);
                target.setExitStatus(objectFactory.createStudentSchoolEnrollmentTypeExitStatus(exitStatusContainer));
            }

            AUCodeSetsExitWithdrawalTypeType exitType = getEnumValue(source.getExitType(), AUCodeSetsExitWithdrawalTypeType.class);
            if (exitType != null) {
                StudentExitContainerType exitTypeContainer = objectFactory.createStudentExitContainerType();
                exitTypeContainer.setCode(exitType);
                target.setExitType(objectFactory.createStudentSchoolEnrollmentTypeExitType(exitTypeContainer));
            }

            AUCodeSetsPublicSchoolCatchmentStatusType catchmentStatus = getEnumValue(source.getCatchmentStatus(), AUCodeSetsPublicSchoolCatchmentStatusType.class);
            if (catchmentStatus != null) {
                CatchmentStatusContainerType catchmentStatusContainer = objectFactory.createCatchmentStatusContainerType();
                catchmentStatusContainer.setCode(catchmentStatus);
                target.setCatchmentStatus(objectFactory.createStudentSchoolEnrollmentTypeCatchmentStatus(catchmentStatusContainer));
            }

            if (StringUtils.isNotBlank(source.getPromotionStatus())) {
                PromotionInfoType promotionInfo = objectFactory.createPromotionInfoType();
                promotionInfo.setPromotionStatus(objectFactory.createPromotionInfoTypePromotionStatus(source.getPromotionStatus()));
                target.setPromotionInfo(objectFactory.createStudentSchoolEnrollmentTypePromotionInfo(promotionInfo));
            }

            if (source.getStudentSubjectChoices() != null && !source.getStudentSubjectChoices().isEmpty()) {
                StudentSubjectChoiceListType studentSubjectChoiceListType = objectFactory.createStudentSubjectChoiceListType();
                for (StudentSubjectChoice studentSubjectChoice : source.getStudentSubjectChoices()) {
                    studentSubjectChoiceListType.getStudentSubjectChoice().add(studentSubjectChoiceConverter.toSifModel(studentSubjectChoice));
                }
                target.setStudentSubjectChoiceList(objectFactory.createStudentSchoolEnrollmentTypeStudentSubjectChoiceList(studentSubjectChoiceListType));
            }

            if (source.getStudentGroups() != null && !source.getStudentGroups().isEmpty()) {
                StudentGroupListType studentGroupListType = objectFactory.createStudentGroupListType();
                for (StudentGroup studentGroup : source.getStudentGroups()) {
                    studentGroupListType.getStudentGroup().add(studentGroupConverter.toSifModel(studentGroup));
                }
                target.setStudentGroupList(objectFactory.createStudentSchoolEnrollmentTypeStudentGroupList(studentGroupListType));
            }

            if (source.getPublishingPermissions() != null && !source.getPublishingPermissions().isEmpty()) {
                PublishingPermissionListType publishingPermissionListType = objectFactory.createPublishingPermissionListType();
                for (StudentSchoolEnrollmentPublishingPermission publishingPermission : source.getPublishingPermissions()) {
                    publishingPermissionListType.getPublishingPermission().add(publishingPermissionConverter.toSifModel(publishingPermission));
                }
                target.setPublishingPermissionList(objectFactory.createStudentSchoolEnrollmentTypePublishingPermissionList(publishingPermissionListType));
            }
        }
    }

    @Override
    public void toHitsModel(StudentSchoolEnrollmentType source, StudentSchoolEnrollment target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setMembershipType(getEnumValue(source.getMembershipType()));
            target.setLocalId(getJAXBValue(source.getLocalId()));
            target.setTimeFrame(getEnumValue(source.getTimeFrame()));
            target.setSchoolYear(getDateValue(source.getSchoolYear()));
            target.setEntryDate(getDateValue(source.getEntryDate()));
            target.setHomegroup(getJAXBValue(source.getHomegroup()));
            target.setAcaraSchoolId(getJAXBValue(source.getACARASchoolId()));
            target.setClassCode(getJAXBValue(source.getClassCode()));
            target.setReportingSchool(getJAXBEnumValue(source.getReportingSchool()));
            target.setHouse(getJAXBValue(source.getHouse()));
            target.setIndividualLearningPlan(getJAXBEnumValue(source.getIndividualLearningPlan()));
            target.setExitDate(getDateValue(getJAXBValue(source.getExitDate())));
            target.setFte(getBigDecimalValue(getJAXBValue(source.getFTE())));
            target.setFtptStatus(getJAXBEnumValue(source.getFTPTStatus()));
            target.setFfpos(getJAXBEnumValue(source.getFFPOS()));
            target.setRecordClosureReason(getJAXBValue(source.getRecordClosureReason()));
            target.setPreviousSchool(getJAXBValue(source.getPreviousSchool()));
            target.setPreviousSchoolName(getJAXBValue(source.getPreviousSchoolName()));
            target.setDestinationSchool(getJAXBValue(source.getDestinationSchool()));
            target.setDestinationSchoolName(getJAXBValue(source.getDestinationSchoolName()));
            target.setStartedAtSchoolDate(getDateValue(getJAXBValue(source.getStartedAtSchoolDate())));

            StudentEntryContainerType entryTypeContainer = getJAXBValue(source.getEntryType());
            if (entryTypeContainer != null) {
                target.setEntryType(getEnumValue(entryTypeContainer.getCode()));
            } else {
                target.setEntryType(null);
            }

            YearLevelType yearLevel = getJAXBValue(source.getYearLevel());
            if (yearLevel != null) {
                target.setYearLevel(getEnumValue(yearLevel.getCode()));
            } else {
                target.setYearLevel(null);
            }

            StudentSchoolEnrollmentType.Homeroom homeroom = getJAXBValue(source.getHomeroom());
            if (homeroom != null) {
                target.setHomeroomRefId(homeroom.getValue());
            } else {
                target.setHomeroomRefId(null);
            }

            StudentSchoolEnrollmentType.Advisor advisor = getJAXBValue(source.getAdvisor());
            if (advisor != null) {
                target.setAdvisorRefId(advisor.getValue());
            } else {
                target.setAdvisorRefId(null);
            }

            StudentSchoolEnrollmentType.Counselor counselor = getJAXBValue(source.getCounselor());
            if (counselor != null) {
                target.setCounselorRefId(counselor.getValue());
            } else {
                target.setCounselorRefId(null);
            }

            YearLevelType testLevel = getJAXBValue(source.getTestLevel());
            if (testLevel != null) {
                target.setTestLevel(getEnumValue(testLevel.getCode()));
            } else {
                target.setTestLevel(null);
            }

            StudentSchoolEnrollmentType.Calendar calendar = getJAXBValue(source.getCalendar());
            if (calendar != null) {
                target.setCalendarRefId(calendar.getValue());
            } else {
                target.setCalendarRefId(null);
            }

            StudentExitStatusContainerType studentExitStatusContainer = getJAXBValue(source.getExitStatus());
            if (studentExitStatusContainer != null) {
                target.setExitStatus(getEnumValue(studentExitStatusContainer.getCode()));
            } else {
                target.setExitStatus(null);
            }

            StudentExitContainerType studentExitContainer = getJAXBValue(source.getExitType());
            if (studentExitContainer != null) {
                target.setExitType(getEnumValue(studentExitContainer.getCode()));
            } else {
                target.setExitType(null);
            }

            CatchmentStatusContainerType catchmentStatusContainer = getJAXBValue(source.getCatchmentStatus());
            if (catchmentStatusContainer != null) {
                target.setCatchmentStatus(getEnumValue(catchmentStatusContainer.getCode()));
            } else {
                target.setCatchmentStatus(null);
            }

            PromotionInfoType promotionInfo = getJAXBValue(source.getPromotionInfo());
            if (promotionInfo != null) {
                target.setPromotionStatus(getJAXBValue(promotionInfo.getPromotionStatus()));
            } else {
                target.setPromotionStatus(null);
            }

            if (target.getStudentSubjectChoices() == null) target.setStudentSubjectChoices(new ArrayList<>());
            target.getStudentSubjectChoices().clear();

            StudentSubjectChoiceListType studentSubjectChoiceList = getJAXBValue(source.getStudentSubjectChoiceList());
            if (studentSubjectChoiceList != null) {
                for (StudentSubjectChoiceType studentSubjectChoiceType : studentSubjectChoiceList.getStudentSubjectChoice()) {
                    StudentSubjectChoice subjectChoice = studentSubjectChoiceConverter.toHitsModel(studentSubjectChoiceType);
                    subjectChoice.setStudentSchoolEnrollment(target);
                    target.getStudentSubjectChoices().add(subjectChoice);
                }
            }

            if (target.getStudentGroups() == null) target.setStudentGroups(new ArrayList<>());
            target.getStudentGroups().clear();

            StudentGroupListType studentGroupList = getJAXBValue(source.getStudentGroupList());
            if (studentGroupList != null) {
                for (StudentGroupType studentGroupType : studentGroupList.getStudentGroup()) {
                    StudentGroup studentGroup = studentGroupConverter.toHitsModel(studentGroupType);
                    studentGroup.setStudentSchoolEnrollment(target);
                    target.getStudentGroups().add(studentGroup);
                }
            }

            if (target.getPublishingPermissions() == null) target.setPublishingPermissions(new ArrayList<>());
            target.getPublishingPermissions().clear();

            PublishingPermissionListType publishingPermissionList = getJAXBValue(source.getPublishingPermissionList());
            if (publishingPermissionList != null) {
                for (PublishingPermissionType publishingPermissionType : publishingPermissionList.getPublishingPermission()) {
                    StudentSchoolEnrollmentPublishingPermission publishingPermission = publishingPermissionConverter.toHitsModel(publishingPermissionType);
                    publishingPermission.setStudentSchoolEnrollment(target);
                    target.getPublishingPermissions().add(publishingPermission);
                }
            }
        }
    }
}
