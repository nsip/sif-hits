package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGContextualQuestionType;
import sif.dd.au30.model.AUCodeSetsAGContextQuestionType;
import sif3.hits.domain.model.AddressAGContextualQuestion;

@Component
public class AddressCollectionReportingAGContextualQuestionConverter
		extends HitsConverter<AGContextualQuestionType, AddressAGContextualQuestion> {

	public AddressCollectionReportingAGContextualQuestionConverter() {
		super(AGContextualQuestionType.class, AddressAGContextualQuestion.class);
	}
	
	@Override
	public void toSifModel(AddressAGContextualQuestion source, AGContextualQuestionType target) {
		if (source != null && target != null) {
			target.setAGContextCode(getEnumValue(source.getContext(), AUCodeSetsAGContextQuestionType.class));
			target.setAGAnswer(source.getAnswer());			
		}
	}
	
	@Override
	public void toHitsModel(AGContextualQuestionType source, AddressAGContextualQuestion target) {
		if (source != null && target != null) {
			target.setContext(getEnumValue(source.getAGContextCode()));
			target.setAnswer(source.getAGAnswer());
		}
	}
}
