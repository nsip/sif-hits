package sif3.hits.rest.provider;

import sif.dd.au30.model.FQReportingCollectionType;
import sif.dd.au30.model.FQReportingType;
import sif3.hits.domain.model.FQReporting;
import sif3.hits.service.FQReportingService;

public class FQReportingProvider extends HitsBaseProvider<FQReportingType, FQReportingCollectionType, FQReporting, FQReportingService> {
    public FQReportingProvider() {
        super(FQReportingType.class, "FQReporting", FQReportingCollectionType.class, "FQReportings", FQReportingService.class);
    }
}
