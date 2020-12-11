package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionReportingEntityContactAddressStatisticalArea;

@Component
public class AddressCollectionReportingEntityContactAddressStatisticalAreaConverter extends
		BaseAddressStatisticalAreaConverter<AddressCollectionReportingEntityContactAddressStatisticalArea> {

	public AddressCollectionReportingEntityContactAddressStatisticalAreaConverter() {
		super(AddressCollectionReportingEntityContactAddressStatisticalArea.class);
	}

}
