package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.CensusReportingEntityContactAddressStatisticalArea;

@Component
public class CensusReportingEntityContactAddressStatisticalAreaConverter
		extends BaseAddressStatisticalAreaConverter<CensusReportingEntityContactAddressStatisticalArea> {

	public CensusReportingEntityContactAddressStatisticalAreaConverter() {
		super(CensusReportingEntityContactAddressStatisticalArea.class);
	}

}
