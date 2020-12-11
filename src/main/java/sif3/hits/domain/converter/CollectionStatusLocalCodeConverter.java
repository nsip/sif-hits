package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.CollectionStatusLocalCode;

@Component
public class CollectionStatusLocalCodeConverter extends BaseLocalCodeConverter<CollectionStatusLocalCode> {

	public CollectionStatusLocalCodeConverter() {
		super(CollectionStatusLocalCode.class);
	}

}
