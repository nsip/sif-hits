package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.CollectionStatusReponseAGRule;

@Component
public class CollectionStatusReponseAGRuleConverter extends BaseAGRuleConverter<CollectionStatusReponseAGRule> {

	public CollectionStatusReponseAGRuleConverter() {
		super(CollectionStatusReponseAGRule.class);
	}

}
