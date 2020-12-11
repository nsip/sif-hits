package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.StatsCohortType;
import sif3.hits.domain.model.StatsCohort;
import sif3.hits.utils.UsesConstants;

@Component
public class StatsCohortConverter extends HitsConverter<StatsCohortType, StatsCohort> implements UsesConstants {

	public StatsCohortConverter() {
		super(StatsCohortType.class, StatsCohort.class);
	}

	@Override
	public void toSifModel(StatsCohort source, StatsCohortType target) {
		if (source != null && target != null) {
			target.setStatsCohortId(source.getStatsCohortId());
			target.setStatsIndigenousStudentType(source.getStatsIndigenousStudentType());
			target.setCohortGender(source.getCohortGender());
			target.setDaysInReferencePeriod(getBigIntegerValue(source.getDaysInReferencePeriod()));
			target.setPossibleSchoolDays(getBigIntegerValue(source.getPossibleSchoolDays()));
			target.setAttendanceDays(getBigDecimalValue(source.getAttendanceDays()));
			target.setAttendanceLess90Percent(getBigIntegerValue(source.getAttendanceLess90Percent()));
			target.setAttendanceGTE90Percent(getBigIntegerValue(source.getAttendanceGTE90Percent()));
			target.setPossibleSchoolDaysGT90PercentAttendance(
					getBigIntegerValue(source.getPossibleSchoolDaysGT90PercentAttendance()));

		}
	}

	@Override
	public void toHitsModel(StatsCohortType source, StatsCohort target) {
		if (source != null && target != null) {
			target.setStatsCohortId(source.getStatsCohortId());
			target.setStatsIndigenousStudentType(source.getStatsIndigenousStudentType());
			target.setCohortGender(source.getCohortGender());
			target.setDaysInReferencePeriod(getBigIntegerValue(source.getDaysInReferencePeriod()));
			target.setPossibleSchoolDays(getBigIntegerValue(source.getPossibleSchoolDays()));
			target.setAttendanceDays(getBigDecimalValue(source.getAttendanceDays()));
			target.setAttendanceLess90Percent(getBigIntegerValue(source.getAttendanceLess90Percent()));
			target.setAttendanceGTE90Percent(getBigIntegerValue(source.getAttendanceGTE90Percent()));
			target.setPossibleSchoolDaysGT90PercentAttendance(
					getBigIntegerValue(source.getPossibleSchoolDaysGT90PercentAttendance()));
		}
	}
}
