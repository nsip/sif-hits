package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsStaffActivityType;
import sif.dd.au30.model.AUCodeSetsStaffStatusType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.CalendarSummaryListType;
import sif.dd.au30.model.StaffActivityExtensionType;
import sif.dd.au30.model.StaffAssignmentType;
import sif.dd.au30.model.StaffSubjectListType;
import sif.dd.au30.model.StaffSubjectType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffAssignment;
import sif3.hits.domain.model.StaffSubject;

@Component
public class StaffAssignmentConverter extends HitsConverter<StaffAssignmentType, StaffAssignment> {

    @Autowired
    StaffSubjectConverter staffSubjectConverter;

    public StaffAssignmentConverter() {
        super(StaffAssignmentType.class, StaffAssignment.class);
    }

    @Override
    public void toSifModel(StaffAssignment source, StaffAssignmentType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setRefId(source.getRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setStaffPersonalRefId(source.getStaffPersonalRefId());
            target.setSchoolYear(objectFactory.createStaffAssignmentTypeSchoolYear(getYearValue(source.getSchoolYear())));
            target.setDescription(objectFactory.createStaffAssignmentTypeDescription(source.getDescription()));
            target.setPrimaryAssignment(getEnumValue(source.getPrimaryAssignment(), AUCodeSetsYesOrNoCategoryType.class));

            target.setJobStartDate(objectFactory.createStaffAssignmentTypeJobStartDate(getDateValue(source.getJobStartDate())));
            target.setJobEndDate(objectFactory.createStaffAssignmentTypeJobEndDate(getDateValue(source.getJobEndDate())));
            target.setJobFTE(objectFactory.createStaffAssignmentTypeJobFTE(getBigDecimalValue(source.getJobFTE())));
            target.setJobFunction(objectFactory.createStaffAssignmentTypeJobFunction(source.getJobFunction()));

            target.setEmploymentStatus(objectFactory.createStaffAssignmentTypeEmploymentStatus(getEnumValue(source.getEmploymentStatus(), AUCodeSetsStaffStatusType.class)));
            target.setCasualReliefTeacher(objectFactory.createStaffAssignmentTypeCasualReliefTeacher(getEnumValue(source.getCasualReliefTeacher(), AUCodeSetsYesOrNoCategoryType.class)));
            target.setHomegroup(objectFactory.createStaffAssignmentTypeHomegroup(source.getHomegroup()));
            target.setHouse(objectFactory.createStaffAssignmentTypeHouse(source.getHouse()));
            target.setPreviousSchoolName(objectFactory.createStaffAssignmentTypePreviousSchoolName(source.getPreviousSchoolName()));
            target.setAvailableForTimetable(objectFactory.createStaffAssignmentTypeAvailableForTimetable(getEnumValue(source.getAvailableForTimetable(), AUCodeSetsYesOrNoCategoryType.class)));

            if (StringUtils.isNotBlank(source.getStaffActivityCode())) {
                StaffActivityExtensionType staffActivity = objectFactory.createStaffActivityExtensionType();
                staffActivity.setCode(getEnumValue(source.getStaffActivityCode(), AUCodeSetsStaffActivityType.class));
                target.setStaffActivity(objectFactory.createStaffAssignmentTypeStaffActivity(staffActivity));
            }

            if (source.getYearLevels() != null && !source.getYearLevels().isEmpty()) {
                YearLevelsType yearLevels = objectFactory.createYearLevelsType();
                for (String yearLevel : source.getYearLevels()) {
                    YearLevelType yearLevelType = objectFactory.createYearLevelType();
                    AUCodeSetsYearLevelCodeType yearLevelCode = getEnumValue(yearLevel, AUCodeSetsYearLevelCodeType.class);
                    if (yearLevelCode != null) {
                        yearLevelType.setCode(yearLevelCode);
                        yearLevels.getYearLevel().add(yearLevelType);
                    }
                }
                if (!yearLevels.getYearLevel().isEmpty()) {
                    target.setYearLevels(objectFactory.createStaffAssignmentTypeYearLevels(yearLevels));
                }
            }


            if (source.getCalendarSummaries() != null && !source.getCalendarSummaries().isEmpty()) {
                CalendarSummaryListType calendarSummaries = objectFactory.createCalendarSummaryListType();
                calendarSummaries.getCalendarSummaryRefId().addAll(source.getCalendarSummaries());
                target.setCalendarSummaryList(objectFactory.createStaffAssignmentTypeCalendarSummaryList(calendarSummaries));
            }

            StaffSubjectListType staffSubjectList = objectFactory.createStaffSubjectListType();
            staffSubjectList.getStaffSubject().addAll(staffSubjectConverter.toSifModelList(source.getSubjects()));
            if (!staffSubjectList.getStaffSubject().isEmpty()) {
                target.setStaffSubjectList(objectFactory.createStaffAssignmentTypeStaffSubjectList(staffSubjectList));
            }
        }
    }

    @Override
    public void toHitsModel(StaffAssignmentType source, StaffAssignment target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setStaffPersonalRefId(source.getStaffPersonalRefId());
            target.setDescription(getJAXBValue(source.getDescription()));
            target.setSchoolYear(getYearValue(getJAXBValue(source.getSchoolYear())));
            target.setPrimaryAssignment(getEnumValue(source.getPrimaryAssignment()));

            target.setJobStartDate(getDateValue(getJAXBValue(source.getJobStartDate())));
            target.setJobEndDate(getDateValue(getJAXBValue(source.getJobEndDate())));
            target.setJobFTE(getBigDecimalValue(getJAXBValue(source.getJobFTE())));
            target.setJobFunction(getJAXBValue(source.getJobFunction()));

            target.setEmploymentStatus(getJAXBEnumValue(source.getEmploymentStatus()));
            target.setCasualReliefTeacher(getJAXBEnumValue(source.getCasualReliefTeacher()));
            target.setHomegroup(getJAXBValue(source.getHomegroup()));
            target.setHouse(getJAXBValue(source.getHouse()));
            target.setPreviousSchoolName(getJAXBValue(source.getPreviousSchoolName()));
            target.setAvailableForTimetable(getJAXBEnumValue(source.getAvailableForTimetable()));
            
            StaffActivityExtensionType staffActivity = getJAXBValue(source.getStaffActivity());
            if (staffActivity != null) {
                target.setStaffActivityCode(getEnumValue(staffActivity.getCode()));
            } else {
                target.setStaffActivityCode(null);
            }

            if (target.getYearLevels() == null) {
                target.setYearLevels(new ArrayList<>());
            }
            target.getYearLevels().clear();

            YearLevelsType yearLevels = getJAXBValue(source.getYearLevels());
            if (yearLevels != null) {
                for (YearLevelType yearLevel : yearLevels.getYearLevel()) {
                    String value = getEnumValue(yearLevel.getCode());
                    if (StringUtils.isNotBlank(value)) {
                        target.getYearLevels().add(value);
                    }
                }
            }

            if (target.getCalendarSummaries() == null) {
                target.setCalendarSummaries(new ArrayList<>());
            }
            target.getCalendarSummaries().clear();
            CalendarSummaryListType calendarSummaryList = getJAXBValue(source.getCalendarSummaryList());
            if (calendarSummaryList != null) {
                target.getCalendarSummaries().addAll(calendarSummaryList.getCalendarSummaryRefId());
            }

            if (target.getSubjects() == null) {
                target.setSubjects(new ArrayList<>());
            }
            target.getSubjects().clear();
            StaffSubjectListType subjectList = getJAXBValue(source.getStaffSubjectList());
            if (subjectList != null) {
                for (StaffSubjectType staffSubjectType : subjectList.getStaffSubject()) {
                    StaffSubject staffSubject = staffSubjectConverter.toHitsModel(staffSubjectType);
                    if (staffSubject != null) {
                        staffSubject.setStaffAssignment(target);
                        target.getSubjects().add(staffSubject);
                    }
                }
            }
        }
    }
}
