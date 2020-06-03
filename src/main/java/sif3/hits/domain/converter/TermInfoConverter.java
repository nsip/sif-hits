package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsSessionTypeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.TermInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TermInfo;

@Component
public class TermInfoConverter extends HitsConverter<TermInfoType, TermInfo> {

	public TermInfoConverter() {
		super(TermInfoType.class, TermInfo.class);
	}

	@Override
	public void toSifModel(TermInfo source, TermInfoType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setStartDate(getDateValue(source.getStartDate()));
			target.setEndDate(getDateValue(source.getEndDate()));
			target.setDescription(objectFactory.createTermInfoTypeDescription(source.getDescription()));
			target.setRelativeDuration(
					objectFactory.createTermInfoTypeRelativeDuration(getBigDecimalValue(source.getRelativeDuration())));
			target.setTermCode(objectFactory.createTermInfoTypeTermCode(source.getTermCode()));
			target.setTrack(objectFactory.createTermInfoTypeTrack(source.getTrack()));
			target.setTermSpan(objectFactory
					.createTermInfoTypeTermSpan(getEnumValue(source.getTermSpan(), AUCodeSetsSessionTypeType.class)));
			target.setMarkingTerm(objectFactory.createTermInfoTypeMarkingTerm(
					getEnumValue(source.getMarkingTerm(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setSchedulingTerm(objectFactory.createTermInfoTypeSchedulingTerm(
					getEnumValue(source.getSchedulingTerm(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setAttendanceTerm(objectFactory.createTermInfoTypeAttendanceTerm(
					getEnumValue(source.getAttendanceTerm(), AUCodeSetsYesOrNoCategoryType.class)));
		}
	}

	@Override
	public void toHitsModel(TermInfoType source, TermInfo target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setSchoolYear(getYearValue(source.getSchoolYear()));
			target.setStartDate(getDateValue(source.getStartDate()));
			target.setEndDate(getDateValue(source.getEndDate()));
			target.setDescription(getJAXBValue(source.getDescription()));
			target.setRelativeDuration(getBigDecimalValue(getJAXBValue(source.getRelativeDuration())));
			target.setTermCode(getJAXBValue(source.getTermCode()));
			target.setTrack(getJAXBValue(source.getTrack()));
			target.setTermSpan(getJAXBEnumValue(source.getTermSpan()));
			target.setMarkingTerm(getJAXBEnumValue(source.getMarkingTerm()));
			target.setSchedulingTerm(getJAXBEnumValue(source.getSchedulingTerm()));
			target.setAttendanceTerm(getJAXBEnumValue(source.getAttendanceTerm()));
		}
	}
}
