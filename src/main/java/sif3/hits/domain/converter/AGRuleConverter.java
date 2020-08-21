package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGRuleType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGRule;

@Component
public class AGRuleConverter extends HitsConverter<AGRuleType, AGRule> {

	AGRuleConverter() {
		super(AGRuleType.class, AGRule.class);
	}

	@Override
	public void toSifModel(AGRule source, AGRuleType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setAGRuleCode(objectFactory.createAGRuleTypeAGRuleCode(source.getAgRuleCode()));
			target.setAGRuleComment(objectFactory.createAGRuleTypeAGRuleComment(source.getAgRuleComment()));
			target.setAGRuleResponse(objectFactory.createAGRuleTypeAGRuleResponse(source.getAgRuleResponse()));
			target.setAGRuleStatus(objectFactory.createAGRuleTypeAGRuleStatus(source.getAgRuleStatus()));
		}
	}

	@Override
	public void toHitsModel(AGRuleType source, AGRule target) {
		if (source != null && target != null) {
			target.setAgRuleCode(getJAXBValue(source.getAGRuleCode()));
			target.setAgRuleComment(getJAXBValue(source.getAGRuleComment()));
			target.setAgRuleResponse(getJAXBValue(source.getAGRuleResponse()));
			target.setAgRuleStatus(getJAXBValue(source.getAGRuleStatus()));
		}
	}
}
