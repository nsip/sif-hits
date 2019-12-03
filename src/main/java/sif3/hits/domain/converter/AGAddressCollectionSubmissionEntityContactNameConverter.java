package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AGAddressCollectionSubmissionEntityContactName;

@Component
public class AGAddressCollectionSubmissionEntityContactNameConverter extends FQBaseEntityContactNameConverter<AGAddressCollectionSubmissionEntityContactName> {

    public AGAddressCollectionSubmissionEntityContactNameConverter() {
        super(AGAddressCollectionSubmissionEntityContactName.class);
    }

}
