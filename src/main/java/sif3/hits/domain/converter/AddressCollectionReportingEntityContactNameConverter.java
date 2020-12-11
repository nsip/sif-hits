package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionReportingEntityContactName;

@Component
public class AddressCollectionReportingEntityContactNameConverter
		extends BaseNameTypeConverter<AddressCollectionReportingEntityContactName> {

	public AddressCollectionReportingEntityContactNameConverter() {
		super(AddressCollectionReportingEntityContactName.class);
	}

}
