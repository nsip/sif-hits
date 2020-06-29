package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.FQSubmissionEntityContactName;

@Component
public class FQSubmissionEntityContactNameConverter extends FQBaseEntityContactNameConverter<FQSubmissionEntityContactName> {

    public FQSubmissionEntityContactNameConverter() {
        super(FQSubmissionEntityContactName.class);
    }

}