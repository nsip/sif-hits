package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.SchoolCourseInfoType;
import sif.dd.au30.model.SubjectAreaListType;
import sif.dd.au30.model.SubjectAreaType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.SchoolCourseInfo;
import sif3.hits.domain.model.SubjectArea;

@Component
public class SchoolCourseInfoConverter extends HitsConverter<SchoolCourseInfoType, SchoolCourseInfo> {

	@Autowired
	SubjectAreaConverter subjectAreaConverter;

	public SchoolCourseInfoConverter() {
		super(SchoolCourseInfoType.class, SchoolCourseInfo.class);
	}

	@Override
	public void toSifModel(SchoolCourseInfo source, SchoolCourseInfoType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setSchoolLocalId(objectFactory.createSchoolCourseInfoTypeSchoolLocalId(source.getSchoolLocalId()));
			target.setSchoolYear(
					objectFactory.createSchoolCourseInfoTypeSchoolYear(getYearValue(source.getSchoolYear())));
			target.setTermInfoRefId(objectFactory.createSchoolCourseInfoTypeTermInfoRefId(source.getTermInfoRefId()));
			target.setCourseCode(source.getCourseCode());
			target.setStateCourseCode(
					objectFactory.createSchoolCourseInfoTypeStateCourseCode(source.getStateCourseCode()));
			target.setDistrictCourseCode(
					objectFactory.createSchoolCourseInfoTypeDistrictCourseCode(source.getDistrictCourseCode()));
			target.setCourseTitle(source.getCourseTitle());
			target.setDescription(objectFactory.createSchoolCourseInfoTypeDescription(source.getDescription()));
			target.setInstructionalLevel(
					objectFactory.createSchoolCourseInfoTypeInstructionalLevel(source.getInstructionalLevel()));
			target.setCourseCredits(objectFactory.createSchoolCourseInfoTypeCourseCredits(source.getCourseCredits()));
			target.setCoreAcademicCourse(objectFactory.createSchoolCourseInfoTypeCoreAcademicCourse(
					getEnumValue(source.getCoreAcademicCourse(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setGraduationRequirement(objectFactory.createSchoolCourseInfoTypeGraduationRequirement(
					getEnumValue(source.getGraduationRequirement(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setDepartment(objectFactory.createSchoolCourseInfoTypeDepartment(source.getDepartment()));
			target.setCourseContent(objectFactory.createSchoolCourseInfoTypeCourseContent(source.getCourseContent()));

			List<SubjectAreaType> subjectAreas = subjectAreaConverter.toSifModelList(source.getSubjectAreas());
			if (!subjectAreas.isEmpty()) {
				SubjectAreaListType subjectAreaList = objectFactory.createSubjectAreaListType();
				subjectAreaList.getSubjectArea().addAll(subjectAreas);
				target.setSubjectAreaList(objectFactory.createSchoolCourseInfoTypeSubjectAreaList(subjectAreaList));
			}
			
		}
	}

	@Override
	public void toHitsModel(SchoolCourseInfoType source, SchoolCourseInfo target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setSchoolLocalId(getJAXBValue(source.getSchoolLocalId()));
			target.setSchoolYear(getYearValue(getJAXBValue(source.getSchoolYear())));
			target.setTermInfoRefId(getJAXBValue(source.getTermInfoRefId()));
			target.setCourseCode(source.getCourseCode());
			target.setStateCourseCode(getJAXBValue(source.getStateCourseCode()));
			target.setDistrictCourseCode(getJAXBValue(source.getDistrictCourseCode()));
			target.setCourseTitle(source.getCourseTitle());
			target.setDescription(getJAXBValue(source.getDescription()));
			target.setInstructionalLevel(getJAXBValue(source.getInstructionalLevel()));
			target.setCourseCredits(getJAXBValue(source.getCourseCredits()));
			target.setCoreAcademicCourse(getJAXBEnumValue(source.getCoreAcademicCourse()));
			target.setGraduationRequirement(getJAXBEnumValue(source.getGraduationRequirement()));
			target.setDepartment(getJAXBValue(source.getDepartment()));
			target.setCourseContent(getJAXBValue(source.getCourseContent()));

			if (target.getSubjectAreas() == null) {
				target.setSubjectAreas(new ArrayList<>());
			}
			target.getSubjectAreas().clear();
			SubjectAreaListType subjectAreaList = getJAXBValue(source.getSubjectAreaList());
			if (subjectAreaList != null) {
				List<SubjectArea> subjectAreas = subjectAreaConverter.toHitsModelList(subjectAreaList.getSubjectArea());
				for (SubjectArea subjectArea : subjectAreas) {
					subjectArea.setSchoolCourseInfo(target);
				}
				target.getSubjectAreas().addAll(subjectAreas);
			}
		}
	}
}
