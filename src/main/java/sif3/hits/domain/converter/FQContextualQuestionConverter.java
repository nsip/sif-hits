package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif.dd.au30.model.FQContextualQuestionType;
import sif3.hits.domain.model.FQContextualQuestion;

@Component
public class FQContextualQuestionConverter extends HitsConverter<FQContextualQuestionType, FQContextualQuestion> {
    public FQContextualQuestionConverter() {
        super(FQContextualQuestionType.class, FQContextualQuestion.class);
    }

    @Override
    public void toSifModel(FQContextualQuestion source, FQContextualQuestionType target) {
        if (source != null && target != null) {
            target.setFQContext(source.getContext());
            target.setFQAnswer(source.getAnswer());
        }
    }

    @Override
    public void toHitsModel(FQContextualQuestionType source, FQContextualQuestion target) {
        if (source != null && target != null) {
            target.setContext(source.getFQContext());
            target.setAnswer(source.getFQAnswer());
        }
    }
}
