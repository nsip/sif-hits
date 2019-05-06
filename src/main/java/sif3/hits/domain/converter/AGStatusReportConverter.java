package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.AGReportingObjectResponseListType;
import sif.dd.au30.model.AGReportingObjectResponseType;
import sif.dd.au30.model.AGStatusReportType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGReportingObjectResponse;
import sif3.hits.domain.model.AGStatusReport;
import sif3.hits.utils.UsesConstants;

import java.util.ArrayList;
import java.util.List;

@Component
public class AGStatusReportConverter extends HitsConverter<AGStatusReportType, AGStatusReport> implements UsesConstants {

    @Autowired
    AGReportingObjectResponseConverter agReportingObjectResponseConverter;


    public AGStatusReportConverter() {
        super(AGStatusReportType.class, AGStatusReport.class);
    }

    @Override
    public void toSifModel(AGStatusReport source, AGStatusReportType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setRefId(source.getRefId());
            target.setReportingAuthority(source.getReportingAuthority());
            target.setReportingAuthoritySystem(objectFactory.createAGStatusReportTypeReportingAuthoritySystem(source.getReportingAuthoritySystem()));
            target.setReportingAuthorityCommonwealthId(objectFactory.createAGStatusReportTypeReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId()));
            target.setSubmittedBy(objectFactory.createAGStatusReportTypeSubmittedBy(source.getSubmittedBy()));
            target.setSubmissionTimestamp(objectFactory.createAGStatusReportTypeSubmissionTimestamp(getCalendarValue(source.getSubmissionTimestamp())));
            target.setAGCollection(objectFactory.createAGStatusReportTypeAGCollection(source.getAgCollection()));
            target.setCollectionYear(getYearValue(source.getCollectionYear()));

            List<AGReportingObjectResponseType> agReportingObjectResponseTypes = agReportingObjectResponseConverter.toSifModelList(source.getAgReportingObjectResponseList());
            if (agReportingObjectResponseTypes != null && !agReportingObjectResponseTypes.isEmpty()) {
                AGReportingObjectResponseListType agReportingObjectResponseListType = objectFactory.createAGReportingObjectResponseListType();
                agReportingObjectResponseListType.getAGReportingObjectResponse().addAll(agReportingObjectResponseTypes);
                target.setAGReportingObjectResponseList(objectFactory.createAGStatusReportTypeAGReportingObjectResponseList(agReportingObjectResponseListType));
            }
        }
    }

    @Override
    public void toHitsModel(AGStatusReportType source, AGStatusReport target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setReportingAuthority(source.getReportingAuthority());
            target.setReportingAuthoritySystem(getJAXBValue(source.getReportingAuthoritySystem()));
            target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));
            target.setSubmittedBy(getJAXBValue(source.getSubmittedBy()));
            target.setSubmissionTimestamp(getCalendarValue(getJAXBValue(source.getSubmissionTimestamp())));
            target.setAgCollection(getJAXBValue(source.getAGCollection()));
            target.setCollectionYear(getYearValue(source.getCollectionYear()));

            if (target.getAgReportingObjectResponseList() == null) {
                target.setAgReportingObjectResponseList(new ArrayList<>());
            }
            target.getAgReportingObjectResponseList().clear();
            AGReportingObjectResponseListType agReportingObjectResponseListType = getJAXBValue(source.getAGReportingObjectResponseList());
            if (agReportingObjectResponseListType != null) {
                for (AGReportingObjectResponseType agReportingObjectResponseType : agReportingObjectResponseListType.getAGReportingObjectResponse()) {
                    AGReportingObjectResponse agReportingObjectResponse = agReportingObjectResponseConverter.toHitsModel(agReportingObjectResponseType);
                    if (agReportingObjectResponse != null) {
                        agReportingObjectResponse.setAgStatusReport(target);
                        target.getAgReportingObjectResponseList().add(agReportingObjectResponse);
                    }
                }
            }
        }
    }

}