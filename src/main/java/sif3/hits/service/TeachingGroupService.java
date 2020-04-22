package sif3.hits.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentListType;
import sif.dd.au30.model.TeacherListType;
import sif.dd.au30.model.TeachingGroupCollectionType;
import sif.dd.au30.model.TeachingGroupStudentType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif.dd.au30.model.TeachingGroupType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TeachingGroupConverter;
import sif3.hits.domain.converter.TeachingGroupStudentConverter;
import sif3.hits.domain.converter.TeachingGroupTeacherConverter;
import sif3.hits.domain.dao.TeachingGroupDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.dao.filter.StaffPersonalFilterDAO;
import sif3.hits.domain.dao.filter.StudentPersonalFilterDAO;
import sif3.hits.domain.dao.filter.TeachingGroupFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableCellFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableSubjectFilterDAO;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TeachingGroupTeacher;
import sif3.hits.domain.model.TimeTableCell;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TeachingGroupService extends BaseService<TeachingGroupType, TeachingGroupCollectionType, TeachingGroup> {

	@Autowired
	private TeachingGroupConverter teachingGroupConverter;

	@Autowired
	private TeachingGroupStudentConverter teachingGroupStudentConverter;

	@Autowired
	private TeachingGroupTeacherConverter teachingGroupTeacherConverter;
	
	@Autowired
	private TeachingGroupDAO teachingGroupDAO;

	@Autowired
	private TeachingGroupFilterDAO teachingGroupFilterDAO;

	@Autowired
	private StudentPersonalFilterDAO studentPersonalFilterDAO;

	@Autowired
	private SchoolInfoFilterDAO schoolInfoFilterDAO;

	@Autowired
	private TimeTableSubjectFilterDAO timeTableSubjectFilterDAO;

	@Autowired
	private TimeTableCellFilterDAO timeTableCellFilterDAO;

	@Autowired
	private StaffPersonalFilterDAO staffPersonalFilterDAO;

	@Override
	protected TeachingGroupCollectionType getCollection(List<TeachingGroupType> items) {
		TeachingGroupCollectionType result = new TeachingGroupCollectionType();
		if (items != null) {
			result.getTeachingGroup().addAll(items);
		}
		return result;
	}

	@Override
	protected HitsConverter<TeachingGroupType, TeachingGroup> getConverter() {
		return teachingGroupConverter;
	}

	@Override
	protected JpaRepository<TeachingGroup, String> getDAO() {
		return teachingGroupDAO;
	}

	@Override
	protected FilterableRepository<TeachingGroup, TeachingGroupType> getFilterableDAO() {
		return teachingGroupFilterDAO;
	}

	@Override
	protected TeachingGroup preSave(TeachingGroup hitsObject, RequestDTO<TeachingGroupType> dto, String zoneId,
			boolean create) {
		// Save and/or find TimeTableCells
		List<TimeTableCell> finalPeriods = new ArrayList<>();
		List<String> timeTableCells = new ArrayList<>();
		for (TimeTableCell timeTablePeriod : hitsObject.getTimeTablePeriods()) {
			if (timeTablePeriod.isTemporary()) {
				timeTableCells.add(timeTablePeriod.getRefId());
			} else {
				finalPeriods.add(timeTablePeriod);
			}
		}
		hitsObject.getTimeTablePeriods().clear();
		for (String refId : timeTableCells) {
			TimeTableCell period = getTimeTableCell(refId, zoneId);
			if (period != null) {
				finalPeriods.add(period);
			}
		}

		// Populate list of Students
		List<String> validStudents = new ArrayList<>();
		for (String refId : hitsObject.getStudentPersonalRefIds()) {
			StudentPersonal studentPersonal = studentPersonalFilterDAO.findOneWithZone(refId, zoneId);
			if (studentPersonal != null) {
				validStudents.add(refId);
			}
		}
		hitsObject.getStudentPersonalRefIds().clear();
		hitsObject.getStudentPersonalRefIds().addAll(validStudents);

		// Populate list of Teachers
		List<TeachingGroupTeacher> validTeachers = new ArrayList<>();
		for (TeachingGroupTeacher teacher : hitsObject.getTeachingGroupTeachers()) {
			if (teacher != null && StringUtils.isNotBlank(teacher.getStaffPersonalRefId())) {
				StaffPersonal staffPersonal = staffPersonalFilterDAO.findOneWithZone(teacher.getStaffPersonalRefId(),
						zoneId);
				if (staffPersonal != null) {
					validTeachers.add(teacher);
				} else {
					teacher.setTeachingGroup(null);
				}
			} else if (teacher != null) {
				teacher.setTeachingGroup(null);
			}
		}
		hitsObject.getTeachingGroupTeachers().clear();
		hitsObject.getTeachingGroupTeachers().addAll(validTeachers);

		// Populate Subject
		hitsObject.setTimeTableSubject(getTimeTableSubject(hitsObject.getTimeTableSubject(), zoneId));

		// Populate School
		hitsObject.setSchoolInfo(getSchoolInfo(hitsObject.getSchoolInfo(), zoneId));

		getDAO().save(hitsObject);
		for (TimeTableCell cell : finalPeriods) {
			cell.setTeachingGroup(hitsObject);
			hitsObject.getTimeTablePeriods().add(cell);
		}

		return hitsObject;
	}

	private SchoolInfo getSchoolInfo(SchoolInfo schoolInfo, String zoneId) {
		SchoolInfo result = null;
		if (schoolInfo != null) {
			result = schoolInfoFilterDAO.findOneWithZone(schoolInfo.getRefId(), zoneId);
		}
		return result;
	}

	private TimeTableSubject getTimeTableSubject(TimeTableSubject subject, String zoneId) {
		TimeTableSubject result = null;
		if (subject != null) {
			result = timeTableSubjectFilterDAO.findOneWithZone(subject.getRefId(), zoneId);
		}
		return result;
	}

	private TimeTableCell getTimeTableCell(String refId, String zoneId) {
		TimeTableCell result = null;
		if (refId != null) {
			result = timeTableCellFilterDAO.findOneWithZone(refId, zoneId);
		}
		return result;
	}

	@Override
	protected void postConversion(TeachingGroupType resultObject, String zoneId) {
		populateStudents(resultObject.getStudentList(), zoneId);
		populateTeachers(resultObject.getTeacherList(), zoneId);
	}

	private void populateTeachers(JAXBElement<TeacherListType> teacherList, String zoneId) {
		if (teacherList != null && teacherList.getValue() != null) {
			List<TeachingGroupTeacherType> teachingGroupTeachers = new ArrayList<>();
			for (TeachingGroupTeacherType teachingGroupTeacher : teacherList.getValue().getTeachingGroupTeacher()) {
				if (teachingGroupTeacher != null && teachingGroupTeacher.getStaffPersonalRefId() != null
						&& StringUtils.isNotBlank(teachingGroupTeacher.getStaffPersonalRefId().getValue())) {
					String staffPersonalRefId = teachingGroupTeacher.getStaffPersonalRefId().getValue();
					StaffPersonal staff = staffPersonalFilterDAO.findOneWithZone(staffPersonalRefId, zoneId);
					if (staff != null) {
						teachingGroupTeacherConverter.toSifModel(staff, teachingGroupTeacher);
						teachingGroupTeachers.add(teachingGroupTeacher);
					}
				}
			}
			teacherList.getValue().getTeachingGroupTeacher().clear();
			teacherList.getValue().getTeachingGroupTeacher().addAll(teachingGroupTeachers);
		}		
	}

	private void populateStudents(JAXBElement<StudentListType> studentList, String zoneId) {
		if (studentList != null && studentList.getValue() != null) {
			List<TeachingGroupStudentType> teachingGroupStudents = new ArrayList<>();
			for (TeachingGroupStudentType teachingGroupStudent : studentList.getValue().getTeachingGroupStudent()) {
				if (teachingGroupStudent != null && teachingGroupStudent.getStudentPersonalRefId() != null
						&& StringUtils.isNotBlank(teachingGroupStudent.getStudentPersonalRefId().getValue())) {
					String studentPersonalRefId = teachingGroupStudent.getStudentPersonalRefId().getValue();
					StudentPersonal student = studentPersonalFilterDAO.findOneWithZone(studentPersonalRefId, zoneId);
					if (student != null) {
						teachingGroupStudentConverter.toSifModel(student, teachingGroupStudent);
						teachingGroupStudents.add(teachingGroupStudent);
					}
				}
			}
			studentList.getValue().getTeachingGroupStudent().clear();
			studentList.getValue().getTeachingGroupStudent().addAll(teachingGroupStudents);
		}
	}
}
