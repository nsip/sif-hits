package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.FQCollectionLocalCode;

@Component
public class FQCollectionLocalCodeConverter extends BaseLocalCodeConverter<FQCollectionLocalCode> {

	public FQCollectionLocalCodeConverter() {
		super(FQCollectionLocalCode.class);
	}

}
