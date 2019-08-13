package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif3.hits.domain.model.FQSubmissionEntityContactAddressStatisticalArea;

@Component
public class FQSubmissionEntityContactAddressStatisticalAreaConverter extends FQBaseEntityContactAddressStatisticalAreaConverter<FQSubmissionEntityContactAddressStatisticalArea> {

    public FQSubmissionEntityContactAddressStatisticalAreaConverter() {
        super(FQSubmissionEntityContactAddressStatisticalArea.class);
    }

}
