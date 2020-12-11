package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionReportingParentName;

@Component
public class AddressCollectionReportingParentNameConverter
		extends BaseNameOfRecordConverter<AddressCollectionReportingParentName> {

	public AddressCollectionReportingParentNameConverter() {
		super(AddressCollectionReportingParentName.class);
	}
}
