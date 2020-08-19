package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.CensusStudentType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.CensusReportingStudent;

@Component
public class CensusReportingStudentConverter extends HitsConverter<CensusStudentType, CensusReportingStudent> {

	public CensusReportingStudentConverter() {
		super(CensusStudentType.class, CensusReportingStudent.class);
	}

	@Override
	public void toSifModel(CensusReportingStudent source, CensusStudentType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setStudentCohortId(source.getStudentCohortId());
			YearLevelType yearLevel = null;
			if (StringUtils.isNotEmpty(source.getYearLevel())) {
				yearLevel = objectFactory.createYearLevelType();
				yearLevel.setCode(getEnumValue(source.getYearLevel(), AUCodeSetsYearLevelCodeType.class));
			}
			target.setYearLevel(yearLevel);
			target.setCensusAge(getBigIntegerValue(source.getCensusAge()));
			target.setCohortGender(source.getCohortGender());
			target.setCohortIndigenousType(source.getCohortIndigenousType());
			target.setEducationMode(source.getEducationMode());
			target.setStudentOnVisa(source.getStudentOnVisa());
			target.setOverseasStudent(source.getOverseasStudent());
			target.setDisabilityLevelOfAdjustment(source.getDisabilityLevelOfAdjustment());
			target.setDisabilityCategory(source.getDisabilityCategory());
			target.setFTE(getBigDecimalValue(source.getFte()));
			target.setHeadcount(getBigIntegerValue(source.getHeadcount()));
		}
	}

	@Override
	public void toHitsModel(CensusStudentType source, CensusReportingStudent target) {
		if (source != null && target != null) {
			target.setStudentCohortId(source.getStudentCohortId());
			String yearLevel = null;
			if (source.getYearLevel() != null) {
				yearLevel = getEnumValue(source.getYearLevel().getCode());
			}
			target.setYearLevel(yearLevel);
			target.setCensusAge(getBigIntegerValue(source.getCensusAge()));
			target.setCohortGender(source.getCohortGender());
			target.setCohortIndigenousType(source.getCohortIndigenousType());
			target.setEducationMode(source.getEducationMode());
			target.setStudentOnVisa(source.getStudentOnVisa());
			target.setOverseasStudent(source.getOverseasStudent());
			target.setDisabilityLevelOfAdjustment(source.getDisabilityLevelOfAdjustment());
			target.setDisabilityCategory(source.getDisabilityCategory());
			target.setFte(getBigDecimalValue(source.getFTE()));
			target.setHeadcount(getBigIntegerValue(source.getHeadcount()));
		}
	}
}