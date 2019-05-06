package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.AGReportingObjectResponseType;
import sif.dd.au30.model.AGRuleListType;
import sif.dd.au30.model.AGRuleType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGReportingObjectResponse;
import sif3.hits.domain.model.AGRule;

import java.util.ArrayList;
import java.util.List;

@Component
public class AGReportingObjectResponseConverter extends HitsConverter<AGReportingObjectResponseType, AGReportingObjectResponse> {

    @Autowired
    AGRuleConverter agRuleConverter;

    AGReportingObjectResponseConverter() {
        super(AGReportingObjectResponseType.class, AGReportingObjectResponse.class);
    }

    @Override
    public void toSifModel(AGReportingObjectResponse source, AGReportingObjectResponseType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setCommonwealthId(source.getCommonwealthId());
            target.setEntityName(objectFactory.createAGReportingObjectResponseTypeEntityName(source.getEntityName()));
            target.setAGSubmissionStatusCode(objectFactory.createAGReportingObjectResponseTypeAGSubmissionStatusCode(source.getAgSubmissionStatusCode()));
            target.setErrorText(objectFactory.createAGReportingObjectResponseTypeErrorText(source.getErrorText()));
            target.setHTTPStatusCode(objectFactory.createAGReportingObjectResponseTypeHTTPStatusCode(source.getHttpStatusCode()));
            target.setSIFRefId(objectFactory.createAGReportingObjectResponseTypeSIFRefId(source.getSifRefId()));
            target.setSubmittedRefId(objectFactory.createAGReportingObjectResponseTypeSubmittedRefId(source.getSubmittedRefId()));

            List<AGRuleType> agRuleTypes = agRuleConverter.toSifModelList(source.getAgRuleList());
            if (agRuleTypes != null && !agRuleTypes.isEmpty()) {
                AGRuleListType agRuleListType = objectFactory.createAGRuleListType();
                agRuleListType.getAGRule().addAll(agRuleTypes);
                target.setAGRuleList(objectFactory.createAGReportingObjectResponseTypeAGRuleList(agRuleListType));
            }
        }
    }

    @Override
    public void toHitsModel(AGReportingObjectResponseType source, AGReportingObjectResponse target) {
        if (source != null && target != null) {
            target.setCommonwealthId(source.getCommonwealthId());
            target.setEntityName(getJAXBValue(source.getEntityName()));
            target.setAgSubmissionStatusCode(getJAXBValue(source.getAGSubmissionStatusCode()));
            target.setErrorText(getJAXBValue(source.getErrorText()));
            target.setHttpStatusCode(getJAXBValue(source.getHTTPStatusCode()));
            target.setSifRefId(getJAXBValue(source.getSIFRefId()));
            target.setSubmittedRefId(getJAXBValue(source.getSubmittedRefId()));

            if (target.getAgRuleList() == null) {
                target.setAgRuleList(new ArrayList<>());
            }
            target.getAgRuleList().clear();
            AGRuleListType agRuleListType = getJAXBValue(source.getAGRuleList());
            if (agRuleListType != null) {
                for (AGRuleType agRuleType : agRuleListType.getAGRule()) {
                    AGRule agRule = agRuleConverter.toHitsModel(agRuleType);
                    if (agRule != null) {
                        agRule.setAgReportingObjectResponse(target);
                        target.getAgRuleList().add(agRule);
                    }
                }
            }
        }
    }
}
