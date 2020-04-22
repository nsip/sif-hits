package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.FollowUpActionListType;
import sif.dd.au30.model.FollowUpActionType;
import sif.dd.au30.model.WellbeingPersonLinkType;
import sif.dd.au30.model.WellbeingPersonLinkType.PersonRefId;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingPersonLink;
import sif3.hits.domain.model.WellbeingPersonLinkFollowUpAction;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingPersonLinkConverter extends HitsConverter<WellbeingPersonLinkType, WellbeingPersonLink>
		implements UsesConstants {

	@Autowired
	WellbeingPersonLinkFollowUpActionConverter followUpActionConverter;

	public WellbeingPersonLinkConverter() {
		super(WellbeingPersonLinkType.class, WellbeingPersonLink.class);
	}

	@Override
	public void toSifModel(WellbeingPersonLink source, WellbeingPersonLinkType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setLocalId(objectFactory.createWellbeingPersonLinkTypeLocalId(source.getLocalId()));

			target.setWellbeingEventRefId(source.getWellbeingEventRefId());
			target.setWellbeingResponseRefId(objectFactory
					.createWellbeingPersonLinkTypeWellbeingResponseRefId(source.getWellbeingResponseRefId()));
			target.setGroupId(source.getGroupId());
			if (StringUtils.isNotBlank(source.getPersonRefId())
					|| StringUtils.isNotBlank(source.getPersonRefIdRefObject())) {
				PersonRefId personRefId = objectFactory.createWellbeingPersonLinkTypePersonRefId();
				personRefId.setValue(source.getPersonRefId());
				personRefId.setSIFRefObject(source.getPersonRefIdRefObject());
				target.setPersonRefId(objectFactory.createWellbeingPersonLinkTypePersonRefId(personRefId));
			}
			target.setShortName(objectFactory.createWellbeingPersonLinkTypeShortName(source.getShortName()));
			target.setHowInvolved(objectFactory.createWellbeingPersonLinkTypeHowInvolved(source.getHowInvolved()));
			target.setOtherPersonId(
					objectFactory.createWellbeingPersonLinkTypeOtherPersonId(source.getOtherPersonId()));
			target.setOtherPersonContactDetails(objectFactory
					.createWellbeingPersonLinkTypeOtherPersonContactDetails(source.getOtherPersonContactDetails()));
			target.setPersonRole(objectFactory.createWellbeingPersonLinkTypePersonRole(source.getPersonRole()));

			if (source.getFollowUpActions() != null && !source.getFollowUpActions().isEmpty()) {
				List<FollowUpActionType> followUpActions = followUpActionConverter
						.toSifModelList(source.getFollowUpActions());
				if (followUpActions != null && !followUpActions.isEmpty()) {
					FollowUpActionListType followUpActionList = objectFactory.createFollowUpActionListType();
					followUpActionList.getFollowUpAction().addAll(followUpActions);
					target.setFollowUpActionList(
							objectFactory.createWellbeingPersonLinkTypeFollowUpActionList(followUpActionList));
				}
			}
		}
	}

	@Override
	public void toHitsModel(WellbeingPersonLinkType source, WellbeingPersonLink target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setWellbeingEventRefId(source.getWellbeingEventRefId());
			target.setWellbeingResponseRefId(getJAXBValue(source.getWellbeingResponseRefId()));
			target.setGroupId(source.getGroupId());
			PersonRefId personRefId = getJAXBValue(source.getPersonRefId());
			if (personRefId != null) {
				target.setPersonRefId(personRefId.getValue());
				target.setPersonRefIdRefObject(personRefId.getSIFRefObject());
			} else {
				target.setPersonRefId(null);
				target.setPersonRefIdRefObject(null);
			}
			target.setShortName(getJAXBValue(source.getShortName()));
			target.setHowInvolved(getJAXBValue(source.getHowInvolved()));
			target.setOtherPersonId(getJAXBValue(source.getOtherPersonId()));
			target.setOtherPersonContactDetails(getJAXBValue(source.getOtherPersonContactDetails()));
			target.setPersonRole(getJAXBValue(source.getPersonRole()));

			if (target.getFollowUpActions() == null) {
				target.setFollowUpActions(new ArrayList<WellbeingPersonLinkFollowUpAction>());
			}
			target.getFollowUpActions().clear();
			FollowUpActionListType followUpActionList = getJAXBValue(source.getFollowUpActionList());
			if (followUpActionList != null && !followUpActionList.getFollowUpAction().isEmpty()) {
				List<WellbeingPersonLinkFollowUpAction> followUpActions = followUpActionConverter
						.toHitsModelList(followUpActionList.getFollowUpAction());
				if (followUpActions != null && !followUpActions.isEmpty()) {
					for (WellbeingPersonLinkFollowUpAction followUpAction : followUpActions) {
						followUpAction.setWellbeingPersonLink(target);
					}
					target.getFollowUpActions().addAll(followUpActions);
				}
			}
		}
	}

}
