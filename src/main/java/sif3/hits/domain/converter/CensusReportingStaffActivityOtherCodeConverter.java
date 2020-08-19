package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.CensusReportingStaffActivityOtherCode;

@Component
public class CensusReportingStaffActivityOtherCodeConverter
		extends BaseOtherCodeConverter<CensusReportingStaffActivityOtherCode> {

	public CensusReportingStaffActivityOtherCodeConverter() {
		super(CensusReportingStaffActivityOtherCode.class);
	}
}
