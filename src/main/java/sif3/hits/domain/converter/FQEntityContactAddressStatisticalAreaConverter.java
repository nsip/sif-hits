package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif3.hits.domain.model.FQEntityContactAddressStatisticalArea;

@Component
public class FQEntityContactAddressStatisticalAreaConverter extends FQBaseEntityContactAddressStatisticalAreaConverter<FQEntityContactAddressStatisticalArea> {

    public FQEntityContactAddressStatisticalAreaConverter() {
        super(FQEntityContactAddressStatisticalArea.class);
    }

}
