package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionReportingEntityContactAddressStatisticalArea;

@Component
public class CensusReportingEntityContactAddressStatisticalAreaConverter
		extends BaseAddressStatisticalAreaConverter<AddressCollectionReportingEntityContactAddressStatisticalArea> {

	public CensusReportingEntityContactAddressStatisticalAreaConverter() {
		super(AddressCollectionReportingEntityContactAddressStatisticalArea.class);
	}

}
