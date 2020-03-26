package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBElement;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsACStrandType;
import sif.dd.au30.model.StudentListType;
import sif.dd.au30.model.TeacherListType;
import sif.dd.au30.model.TeachingGroupPeriodListType;
import sif.dd.au30.model.TeachingGroupPeriodType;
import sif.dd.au30.model.TeachingGroupStudentType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;
import sif3.hits.domain.model.TimeTableCell;

@Component
public class TeachingGroupConverter extends HitsConverter<TeachingGroupType, TeachingGroup> {

	public TeachingGroupConverter() {
		super(TeachingGroupType.class, TeachingGroup.class);
	}

	@Autowired
	private TeachingGroupTeacherConverter teachingGroupTeacherConverter;

	@Autowired
	private TeachingGroupSchoolInfoConverter teachingGroupSchoolInfoConverter;

	@Autowired
	private TeachingGroupTimeTableSubjectConveter teachingGroupTimeTableSubjectConveter;

	@Autowired
	private TeachingGroupPeriodTimeTableCellConverter teachingGroupPeriodTimeTableCellConverter;

	@Override
	public void toSifModel(TeachingGroup source, TeachingGroupType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setLocalId(source.getLocalId());
			target.setShortName(source.getShortName());
			target.setLongName(objectFactory.createTeachingGroupTypeLongName(source.getLongName()));

			teachingGroupTimeTableSubjectConveter.toSifModel(source.getTimeTableSubject(), target);

			if (source.getStudentPersonalRefIds() != null && !source.getStudentPersonalRefIds().isEmpty()) {
				StudentListType studentListType = objectFactory.createStudentListType();
				for (String studentPersonalRefId : source.getStudentPersonalRefIds()) {
					TeachingGroupStudentType student = objectFactory.createTeachingGroupStudentType();
					student.setStudentPersonalRefId(
							objectFactory.createTeachingGroupStudentTypeStudentPersonalRefId(studentPersonalRefId));
					studentListType.getTeachingGroupStudent().add(student);
				}
				target.setStudentList(objectFactory.createTeachingGroupScheduleTypeStudentList(studentListType));
			}

			List<TeachingGroupTeacherType> teachers = teachingGroupTeacherConverter
					.toSifModelList(source.getTeachingGroupTeachers());
			if (teachers != null && !teachers.isEmpty()) {
				TeacherListType teacherList = objectFactory.createTeacherListType();

				teacherList.getTeachingGroupTeacher().addAll(teachers);
				target.setTeacherList(objectFactory.createTeachingGroupTypeTeacherList(teacherList));
			}

			List<TeachingGroupPeriodType> teachingGroupPeriods = teachingGroupPeriodTimeTableCellConverter
					.toSifModelList(source.getTimeTablePeriods());
			if (teachingGroupPeriods != null && !teachingGroupPeriods.isEmpty()) {
				TeachingGroupPeriodListType teachingGroupPeriodList = objectFactory.createTeachingGroupPeriodListType();
				teachingGroupPeriodList.getTeachingGroupPeriod().addAll(teachingGroupPeriods);
				target.setTeachingGroupPeriodList(
						objectFactory.createTeachingGroupTypeTeachingGroupPeriodList(teachingGroupPeriodList));
			}

			teachingGroupSchoolInfoConverter.toSifModel(source.getSchoolInfo(), target);

			target.setKeyLearningArea(objectFactory.createTeachingGroupTypeKeyLearningArea(
					getEnumValue(source.getKeyLearningArea(), AUCodeSetsACStrandType.class)));

			target.setSchoolYear(getYearValue(source.getSchoolYear()));
		}
	}

	@Override
	public void toHitsModel(TeachingGroupType source, TeachingGroup target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setLocalId(source.getLocalId());
			target.setShortName(source.getShortName());
			target.setLongName(getJAXBValue(source.getLongName()));
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setSchoolInfo(teachingGroupSchoolInfoConverter.toHitsModel(source));
			target.setTimeTableSubject(teachingGroupTimeTableSubjectConveter.toHitsModel(source));
			target.setKeyLearningArea(getJAXBEnumValue(source.getKeyLearningArea()));

			handleTeachers(target, source);
			handleStudents(target, source);
			handlePeriods(target, source);
		}
	}

	private void handleTeachers(TeachingGroup target, TeachingGroupType source) {
		if (target.getTeachingGroupTeachers() == null) {
			target.setTeachingGroupTeachers(new ArrayList<>());
		}
		Map<String, TeachingGroupTeacher> currentTeachers = target.getTeachingGroupTeachers().stream()
				.collect(Collectors.toMap(TeachingGroupTeacher::getStaffPersonalRefId, t -> t));
		target.getTeachingGroupTeachers().clear();
		TeacherListType teacherListType = getJAXBValue(source.getTeacherList());

		if (teacherListType != null && !teacherListType.getTeachingGroupTeacher().isEmpty()) {
			for (TeachingGroupTeacherType teachingGroupTeacherType : teacherListType.getTeachingGroupTeacher()) {
				TeachingGroupTeacher teacher = null;
				if (teachingGroupTeacherType != null && teachingGroupTeacherType.getStaffPersonalRefId() != null
						&& StringUtils.isNotBlank(teachingGroupTeacherType.getStaffPersonalRefId().getValue())) {
					teacher = currentTeachers.get(teachingGroupTeacherType.getStaffPersonalRefId().getValue());
				}
				if (teacher == null) {
					teacher = new TeachingGroupTeacher();
				}
				teachingGroupTeacherConverter.toHitsModel(teachingGroupTeacherType, teacher);
				teacher.setTeachingGroup(target);
				target.getTeachingGroupTeachers().add(teacher);
			}
		}
	}

	private void handleStudents(TeachingGroup target, TeachingGroupType source) {
		if (target.getStudentPersonalRefIds() == null) {
			target.setStudentPersonalRefIds(new ArrayList<>());
		}
		target.getStudentPersonalRefIds().clear();
		StudentListType studentListType = getJAXBValue(source.getStudentList());
		if (studentListType != null && !studentListType.getTeachingGroupStudent().isEmpty()) {
			for (TeachingGroupStudentType teachingGroupStudentType : studentListType.getTeachingGroupStudent()) {
				String refId = getJAXBValue(teachingGroupStudentType.getStudentPersonalRefId());
				if (refId != null) {
					target.getStudentPersonalRefIds().add(refId);
				}
			}
		}
	}

	private void handlePeriods(TeachingGroup target, TeachingGroupType source) {
		Set<String> newPeriods = new HashSet<>();
		Map<String, TimeTableCell> existingPeriods = new HashMap<>();

		TeachingGroupPeriodListType teachingGroupPeriodListType = getJAXBValue(source.getTeachingGroupPeriodList());
		if (teachingGroupPeriodListType != null && !teachingGroupPeriodListType.getTeachingGroupPeriod().isEmpty()) {
			for (TeachingGroupPeriodType teachingGroupPeriodType : teachingGroupPeriodListType
					.getTeachingGroupPeriod()) {
				String refId = getJAXBValue(teachingGroupPeriodType.getTimeTableCellRefId());
				if (refId != null) {
					newPeriods.add(refId);
				}
			}
		}
		if (target.getTimeTablePeriods() == null) {
			target.setTimeTablePeriods(new HashSet<TimeTableCell>());
		}
		for (TimeTableCell timeTablePeriod : target.getTimeTablePeriods()) {
			existingPeriods.put(timeTablePeriod.getRefId(), timeTablePeriod);
		}
		target.getTimeTablePeriods().clear();
		for (Entry<String, TimeTableCell> entry : existingPeriods.entrySet()) {
			if (newPeriods.contains(entry.getKey())) {
				target.getTimeTablePeriods().add(entry.getValue());
			} else {
				entry.getValue().setTeachingGroup(null);
			}
		}
		for (String refId : newPeriods) {
			if (!existingPeriods.containsKey(refId)) {
				TimeTableCell period = new TimeTableCell();
				period.setTemporary(true);
				period.setRefId(refId);
				target.getTimeTablePeriods().add(period);
			}
		}
	}
}
