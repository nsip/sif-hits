package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AGAddressCollectionReportingEntityContactName;

@Component
public class AGAddressCollectionReportingEntityContactNameConverter extends FQBaseEntityContactNameConverter<AGAddressCollectionReportingEntityContactName> {

    public AGAddressCollectionReportingEntityContactNameConverter() {
        super(AGAddressCollectionReportingEntityContactName.class);
    }

}
