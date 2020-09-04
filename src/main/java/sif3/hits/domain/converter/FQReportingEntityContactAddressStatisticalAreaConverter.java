package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.FQReportingEntityContactAddressStatisticalArea;

@Component
public class FQReportingEntityContactAddressStatisticalAreaConverter
		extends BaseAddressStatisticalAreaConverter<FQReportingEntityContactAddressStatisticalArea> {

	public FQReportingEntityContactAddressStatisticalAreaConverter() {
		super(FQReportingEntityContactAddressStatisticalArea.class);
	}

}
