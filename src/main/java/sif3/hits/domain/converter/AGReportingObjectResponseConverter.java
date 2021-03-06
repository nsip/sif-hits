package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGReportingObjectResponseType;
import sif.dd.au30.model.AGRuleListType;
import sif.dd.au30.model.AGRuleType;
import sif.dd.au30.model.AUCodeSetsAGSubmissionStatusType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGReportingObjectResponse;
import sif3.hits.domain.model.CollectionStatusReponseAGRule;

@Component
public class AGReportingObjectResponseConverter
		extends HitsConverter<AGReportingObjectResponseType, AGReportingObjectResponse> {

	@Autowired
	HitsConverter<AGRuleType, CollectionStatusReponseAGRule> agRuleConverter;

	AGReportingObjectResponseConverter() {
		super(AGReportingObjectResponseType.class, AGReportingObjectResponse.class);
	}

	@Override
	public void toSifModel(AGReportingObjectResponse source, AGReportingObjectResponseType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setSubmittedRefId(
					objectFactory.createAGReportingObjectResponseTypeSubmittedRefId(source.getSubmittedRefId()));
			target.setSIFRefId(objectFactory.createAGReportingObjectResponseTypeSIFRefId(source.getSifRefId()));
			target.setHTTPStatusCode(
					objectFactory.createAGReportingObjectResponseTypeHTTPStatusCode(source.getHttpStatusCode()));
			target.setErrorText(objectFactory.createAGReportingObjectResponseTypeErrorText(source.getErrorText()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setEntityName(objectFactory.createAGReportingObjectResponseTypeEntityName(source.getEntityName()));
			target.setAGSubmissionStatusCode(
					getEnumValue(source.getAgSubmissionStatusCode(), AUCodeSetsAGSubmissionStatusType.class));

			List<AGRuleType> agRuleTypes = agRuleConverter.toSifModelList(source.getAgRuleList());
			AGRuleListType agRuleListType = null;
			if (!agRuleTypes.isEmpty()) {
				agRuleListType = objectFactory.createAGRuleListType();
				agRuleListType.getAGRule().addAll(agRuleTypes);
			}
			target.setAGRuleList(objectFactory.createAGReportingObjectResponseTypeAGRuleList(agRuleListType));
		}
	}

	@Override
	public void toHitsModel(AGReportingObjectResponseType source, AGReportingObjectResponse target) {
		if (source != null && target != null) {
			target.setSubmittedRefId(getJAXBValue(source.getSubmittedRefId()));
			target.setSifRefId(getJAXBValue(source.getSIFRefId()));
			target.setHttpStatusCode(getJAXBValue(source.getHTTPStatusCode()));
			target.setErrorText(getJAXBValue(source.getErrorText()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setEntityName(getJAXBValue(source.getEntityName()));
			target.setAgSubmissionStatusCode(getEnumValue(source.getAGSubmissionStatusCode()));

			if (target.getAgRuleList() == null) {
				target.setAgRuleList(new ArrayList<>());
			}
			target.getAgRuleList().clear();
			AGRuleListType agRuleListType = getJAXBValue(source.getAGRuleList());
			if (agRuleListType != null) {
				for (AGRuleType agRuleType : agRuleListType.getAGRule()) {
					CollectionStatusReponseAGRule agRule = agRuleConverter.toHitsModel(agRuleType);
					if (agRule != null) {
						agRule.setAgReportingObjectResponse(target);
						target.getAgRuleList().add(agRule);
					}
				}
			}
		}
	}
}
