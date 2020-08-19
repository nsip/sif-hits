package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.CollectionRoundLocalCode;

@Component
public class CollectionRoundLocalCodeConverter extends BaseLocalCodeConverter<CollectionRoundLocalCode> {

	public CollectionRoundLocalCodeConverter() {
		super(CollectionRoundLocalCode.class);
	}

}
