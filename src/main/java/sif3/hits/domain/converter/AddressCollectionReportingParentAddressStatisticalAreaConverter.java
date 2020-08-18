package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionReportingParentAddressStatisticalArea;

@Component
public class AddressCollectionReportingParentAddressStatisticalAreaConverter
		extends BaseAddressStatisticalAreaConverter<AddressCollectionReportingParentAddressStatisticalArea> {

	public AddressCollectionReportingParentAddressStatisticalAreaConverter() {
		super(AddressCollectionReportingParentAddressStatisticalArea.class);
	}

}
