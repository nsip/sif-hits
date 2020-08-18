package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGContextualQuestionType;
import sif.dd.au30.model.AUCodeSetsAGContextQuestionType;
import sif3.hits.domain.model.AGContextualQuestion;
import sif3.hits.utils.UsesConstants;

@Component
public class AddressCollectionReportingAGContextualQuestionConverter
		extends HitsConverter<AGContextualQuestionType, AGContextualQuestion> implements UsesConstants {

	public AddressCollectionReportingAGContextualQuestionConverter() {
		super(AGContextualQuestionType.class, AGContextualQuestion.class);
	}

	@Override
	public void toSifModel(AGContextualQuestion source, AGContextualQuestionType target) {
		if (source != null && target != null) {
			target.setAGContextCode(getEnumValue(source.getAgContextCode(), AUCodeSetsAGContextQuestionType.class));
			target.setAGAnswer(source.getAgAnswer());
		}
	}

	@Override
	public void toHitsModel(AGContextualQuestionType source, AGContextualQuestion target) {
		if (source != null && target != null) {
			target.setAgContextCode(getEnumValue(source.getAGContextCode()));
			target.setAgAnswer(source.getAGAnswer());
		}
	}
}