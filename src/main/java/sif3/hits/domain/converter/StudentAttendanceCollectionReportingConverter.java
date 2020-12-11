package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.StatsCohortYearLevelListType;
import sif.dd.au30.model.StatsCohortYearLevelType;
import sif.dd.au30.model.StudentAttendanceCollectionReportingType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StatsCohortYearLevel;
import sif3.hits.domain.model.StudentAttendanceCollectionReporting;
import sif3.hits.utils.UsesConstants;

@Component
public class StudentAttendanceCollectionReportingConverter
		extends HitsConverter<StudentAttendanceCollectionReportingType, StudentAttendanceCollectionReporting>
		implements UsesConstants {

	@Autowired
	StudentAttendanceCollectionReportingEntityContactConverter entityContactConverter;

	@Autowired
	HitsConverter<StatsCohortYearLevelType, StatsCohortYearLevel> statsCohortYearLevelConverter;

	public StudentAttendanceCollectionReportingConverter() {
		super(StudentAttendanceCollectionReportingType.class, StudentAttendanceCollectionReporting.class);
	}

	@Override
	public void toSifModel(StudentAttendanceCollectionReporting source,
			StudentAttendanceCollectionReportingType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setEntityLevel(
					objectFactory.createStudentAttendanceCollectionReportingTypeEntityLevel(source.getEntityLevel()));
			target.setSchoolInfoRefId(objectFactory
					.createStudentAttendanceCollectionReportingTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
			target.setLocalId(objectFactory.createStudentAttendanceCollectionReportingTypeLocalId(source.getLocalId()));
			target.setStateProvinceId(objectFactory
					.createStudentAttendanceCollectionReportingTypeStateProvinceId(source.getStateProvinceId()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setACARAId(objectFactory.createStudentAttendanceCollectionReportingTypeACARAId(source.getAcaraId()));
			target.setEntityName(
					objectFactory.createStudentAttendanceCollectionReportingTypeEntityName(source.getEntityName()));

			target.setEntityContact(entityContactConverter.toSifModel(source.getEntityContact()));

			StatsCohortYearLevelListType statsCohortYearLevelListType = null;
			List<StatsCohortYearLevelType> statsCohortYearLevelTypes = statsCohortYearLevelConverter
					.toSifModelList(source.getStatsCohortYearLevelList());
			if (!statsCohortYearLevelTypes.isEmpty()) {
				statsCohortYearLevelListType = objectFactory.createStatsCohortYearLevelListType();
				statsCohortYearLevelListType.getStatsCohortYearLevel().addAll(statsCohortYearLevelTypes);
			}
			target.setStatsCohortYearLevelList(
					objectFactory.createStudentAttendanceCollectionReportingTypeStatsCohortYearLevelList(
							statsCohortYearLevelListType));
		}
	}

	@Override
	public void toHitsModel(StudentAttendanceCollectionReportingType source,
			StudentAttendanceCollectionReporting target) {
		if (source != null && target != null) {
			target.setEntityLevel(getJAXBValue(source.getEntityLevel()));
			target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setAcaraId(getJAXBValue(source.getACARAId()));
			target.setEntityName(getJAXBValue(source.getEntityName()));
			target.setEntityContact(entityContactConverter.toHitsModel(source.getEntityContact()));

			if (target.getStatsCohortYearLevelList() == null) {
				target.setStatsCohortYearLevelList(new ArrayList<>());
			}
			target.getStatsCohortYearLevelList().clear();
			StatsCohortYearLevelListType statsCohortYearLevelListType = getJAXBValue(
					source.getStatsCohortYearLevelList());
			if (statsCohortYearLevelListType != null) {
				List<StatsCohortYearLevel> statsCohortYearLevels = statsCohortYearLevelConverter
						.toHitsModelList(statsCohortYearLevelListType.getStatsCohortYearLevel());
				for (StatsCohortYearLevel statsCohortYearLevel : statsCohortYearLevels) {
					target.getStatsCohortYearLevelList().add(statsCohortYearLevel);
					statsCohortYearLevel.setStudentAttendanceCollectionReporting(target);
				}
			}
		}
	}
}
