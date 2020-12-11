package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionLocalCode;

@Component
public class AddressCollectionLocalCodeConverter extends BaseLocalCodeConverter<AddressCollectionLocalCode> {

	public AddressCollectionLocalCodeConverter() {
		super(AddressCollectionLocalCode.class);
	}

}
