package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGReportingObjectResponseListType;
import sif.dd.au30.model.AGReportingObjectResponseType;
import sif.dd.au30.model.CollectionStatusType;
import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.LocalCodeType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGReportingObjectResponse;
import sif3.hits.domain.model.CollectionStatus;
import sif3.hits.domain.model.CollectionStatusLocalCode;
import sif3.hits.utils.UsesConstants;

@Component
public class CollectionStatusConverter extends HitsConverter<CollectionStatusType, CollectionStatus>
		implements UsesConstants {

	@Autowired
	private CollectionStatusLocalCodeConverter collectionStatusLocalCodeConverter;

	@Autowired
	private HitsConverter<AGReportingObjectResponseType, AGReportingObjectResponse> agReportingObjectResponseConverter;

	public CollectionStatusConverter() {
		super(CollectionStatusType.class, CollectionStatus.class);
	}

	@Override
	public void toSifModel(CollectionStatus source, CollectionStatusType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setReportingAuthority(source.getReportingAuthority());
			target.setReportingAuthoritySystem(objectFactory
					.createCollectionStatusTypeReportingAuthoritySystem(source.getReportingAuthoritySystem()));
			target.setReportingAuthorityCommonwealthId(
					objectFactory.createCollectionStatusTypeReportingAuthorityCommonwealthId(
							source.getReportingAuthorityCommonwealthId()));
			target.setSubmittedBy(objectFactory.createCollectionStatusTypeSubmittedBy(source.getSubmittedBy()));
			target.setSubmissionTimestamp(objectFactory
					.createCollectionStatusTypeSubmissionTimestamp(getCalendarValue(source.getSubmissionTimestamp())));
			target.setAGCollection(objectFactory.createCollectionStatusTypeAGCollection(source.getAgCollection()));
			target.setCollectionYear(getYearValue(source.getCollectionYear()));
			target.setRoundCode(source.getRoundCode());

			List<LocalCodeType> collectionStatusLocalCodeTypes = collectionStatusLocalCodeConverter
					.toSifModelList(source.getLocalCodeList());
			if (!collectionStatusLocalCodeTypes.isEmpty()) {
				LocalCodeListType collectionStatusLocalCodeListType = objectFactory.createLocalCodeListType();
				collectionStatusLocalCodeListType.getLocalCode().addAll(collectionStatusLocalCodeTypes);
				target.setLocalCodeList(
						objectFactory.createCollectionStatusTypeLocalCodeList(collectionStatusLocalCodeListType));
			} else {
				target.setLocalCodeList(null);
			}

			List<AGReportingObjectResponseType> agReportingObjectResponseTypes = agReportingObjectResponseConverter
					.toSifModelList(source.getAgReportingObjectResponseList());
			if (!agReportingObjectResponseTypes.isEmpty()) {
				AGReportingObjectResponseListType agReportingObjectResponseListType = objectFactory
						.createAGReportingObjectResponseListType();
				agReportingObjectResponseListType.getAGReportingObjectResponse().addAll(agReportingObjectResponseTypes);
				target.setAGReportingObjectResponseList(objectFactory
						.createCollectionStatusTypeAGReportingObjectResponseList(agReportingObjectResponseListType));
			} else {
				target.setAGReportingObjectResponseList(null);
			}
		}
	}

	@Override
	public void toHitsModel(CollectionStatusType source, CollectionStatus target) {
		if (source != null && target != null) {
			target.setReportingAuthority(source.getReportingAuthority());
			target.setReportingAuthority(source.getReportingAuthority());
			target.setReportingAuthoritySystem(getJAXBValue(source.getReportingAuthoritySystem()));
			target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));
			target.setSubmittedBy(getJAXBValue(source.getSubmittedBy()));
			target.setSubmissionTimestamp(getCalendarValue(getJAXBValue(source.getSubmissionTimestamp())));
			target.setAgCollection(getJAXBValue(source.getAGCollection()));
			target.setCollectionYear(getYearValue(source.getCollectionYear()));
			target.setRoundCode(source.getRoundCode());

			if (target.getLocalCodeList() == null) {
				target.setLocalCodeList(new ArrayList<>());
			}
			target.getLocalCodeList().clear();
			LocalCodeListType localCodeListType = getJAXBValue(source.getLocalCodeList());
			if (localCodeListType != null) {
				List<CollectionStatusLocalCode> localCodes = collectionStatusLocalCodeConverter
						.toHitsModelList(localCodeListType.getLocalCode());
				for (CollectionStatusLocalCode localCode : localCodes) {
					target.getLocalCodeList().add(localCode);
					localCode.setCollectionStatus(target);
				}
			}

			if (target.getAgReportingObjectResponseList() == null)
				target.setAgReportingObjectResponseList(new ArrayList<>());
		}
		target.getAgReportingObjectResponseList().clear();
		AGReportingObjectResponseListType agReportingObjectResponseListType = getJAXBValue(
				source.getAGReportingObjectResponseList());
		if (agReportingObjectResponseListType != null) {
			List<AGReportingObjectResponse> agReportingObjectResponses = agReportingObjectResponseConverter
					.toHitsModelList(agReportingObjectResponseListType.getAGReportingObjectResponse());
			for (AGReportingObjectResponse agReportingObjectResponse : agReportingObjectResponses) {
				target.getAgReportingObjectResponseList().add(agReportingObjectResponse);
				agReportingObjectResponse.setCollectionStatus(target);
			}
		}

	}
}