package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;
import sif3.hits.domain.model.FQEntityContactName;

@Component
public class FQEntityContactNameConverter extends FQBaseEntityContactNameConverter<FQEntityContactName> {

    public FQEntityContactNameConverter() {
        super(FQEntityContactName.class);
    }

}
