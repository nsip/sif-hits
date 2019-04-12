package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.FQReportingType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQReporting;

@Component
public class FQReportingConverter extends HitsConverter<FQReportingType, FQReporting> {

    @Autowired
    FQEntityContactConverter entityContactConverter;

    public FQReportingConverter() {
        super(FQReportingType.class, FQReporting.class);
    }

    @Override
    public void toSifModel(FQReporting source, FQReportingType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setFQRefId(objectFactory.createFQReportingTypeFQRefId(null));
        }
    }

    @Override
    public void toHitsModel(FQReportingType source, FQReporting target) {
        if (source != null && target != null) {

        }
    }
}
