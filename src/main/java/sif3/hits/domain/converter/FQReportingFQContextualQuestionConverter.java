package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FQContextualQuestionType;
import sif3.hits.domain.model.FQReportingFQContextualQuestion;

@Component
public class FQReportingFQContextualQuestionConverter
		extends HitsConverter<FQContextualQuestionType, FQReportingFQContextualQuestion> {

	public FQReportingFQContextualQuestionConverter() {
		super(FQContextualQuestionType.class, FQReportingFQContextualQuestion.class);
	}

	@Override
	public void toSifModel(FQReportingFQContextualQuestion source, FQContextualQuestionType target) {
		if (source != null && target != null) {
			target.setFQContext(source.getContext());
			target.setFQAnswer(source.getAnswer());
		}
	}

	@Override
	public void toHitsModel(FQContextualQuestionType source, FQReportingFQContextualQuestion target) {
		if (source != null && target != null) {
			target.setContext(source.getFQContext());
			target.setAnswer(source.getFQAnswer());
		}
	}
}
