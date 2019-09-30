package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif3.hits.domain.model.AGAddressCollectionSubmissionEntityContactAddressStatisticalArea;

@Component
public class AGAddressCollectionSubmissionEntityContactAddressStatisticalAreaConverter extends FQBaseEntityContactAddressStatisticalAreaConverter<AGAddressCollectionSubmissionEntityContactAddressStatisticalArea> {

    public AGAddressCollectionSubmissionEntityContactAddressStatisticalAreaConverter() {
        super(AGAddressCollectionSubmissionEntityContactAddressStatisticalArea.class);
    }

}
