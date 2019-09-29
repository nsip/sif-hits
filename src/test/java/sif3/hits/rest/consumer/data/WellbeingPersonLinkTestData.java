package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.FollowUpActionListType;
import sif.dd.au30.model.FollowUpActionType;
import sif.dd.au30.model.WellbeingPersonLinkCollectionType;
import sif.dd.au30.model.WellbeingPersonLinkType;
import sif.dd.au30.model.WellbeingPersonLinkType.PersonRefId;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class WellbeingPersonLinkTestData extends TestData<WellbeingPersonLinkType, WellbeingPersonLinkCollectionType> {

	public static final String REF_ID_1 = "6c52745a-7d1f-4186-b585-8a06179daea3";
	public static final String REF_ID_2 = "6093125e-ea4e-4e85-bdcf-a2e67af351c4";
	public static final String REF_ID_3 = "2384b1ac-ac04-42df-982b-f954aa21d8fa";
	public static final String REF_ID_4 = "fda114b3-7b78-48b9-bdab-6d4e398ebfc8";
	public static final String REF_ID_5 = "6a30b884-c1f5-4884-bbbb-292b7ec0d1c6";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "87cfdd54-f9f5-42d7-bca6-6c2bf6c120d5";
	public static final String XML_REF_ID_2 = "f09c8316-021f-44a0-86e4-6e70bb7479ff";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public WellbeingPersonLinkType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		WellbeingPersonLinkType wellbeingPersonLinkType = objectFactory.createWellbeingPersonLinkType();
		wellbeingPersonLinkType.setRefId(refId);

		wellbeingPersonLinkType.setWellbeingEventRefId(WellbeingEventTestData.REF_ID_1);
		wellbeingPersonLinkType.setWellbeingResponseRefId(
				objectFactory.createWellbeingPersonLinkTypeWellbeingResponseRefId(WellbeingResponseTestData.REF_ID_1));
		wellbeingPersonLinkType.setGroupId("Group Id");

		PersonRefId personRefId = objectFactory.createWellbeingPersonLinkTypePersonRefId();
		personRefId.setValue(StudentPersonalTestData.REF_ID_1);
		personRefId.setSIFRefObject("StudentPersonal");
		wellbeingPersonLinkType.setPersonRefId(objectFactory.createWellbeingPersonLinkTypePersonRefId(personRefId));

		wellbeingPersonLinkType.setShortName(objectFactory.createWellbeingPersonLinkTypeShortName("Short Name"));
		wellbeingPersonLinkType.setHowInvolved(objectFactory.createWellbeingPersonLinkTypeHowInvolved("How Involved"));
		wellbeingPersonLinkType.setOtherPersonId(objectFactory.createWellbeingPersonLinkTypeOtherPersonId("personId"));
		wellbeingPersonLinkType.setOtherPersonContactDetails(
				objectFactory.createWellbeingPersonLinkTypeOtherPersonContactDetails("person contact"));
		wellbeingPersonLinkType.setPersonRole(objectFactory.createWellbeingPersonLinkTypePersonRole("Parent"));

		FollowUpActionType followUpAction1 = objectFactory.createFollowUpActionType();
		followUpAction1
				.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails("Follow up details - 1"));
		followUpAction1
				.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory("Category 1"));
		followUpAction1.setWellbeingResponseRefId(
				objectFactory.createFollowUpActionTypeWellbeingResponseRefId(WellbeingResponseTestData.REF_ID_1));

		FollowUpActionType followUpAction2 = objectFactory.createFollowUpActionType();
		followUpAction2
				.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails("Follow up details - 2"));
		followUpAction2
				.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory("Category 2"));
		followUpAction2.setWellbeingResponseRefId(
				objectFactory.createFollowUpActionTypeWellbeingResponseRefId(WellbeingResponseTestData.REF_ID_2));

		FollowUpActionListType followUpActionListType = objectFactory.createFollowUpActionListType();
		followUpActionListType.getFollowUpAction().add(followUpAction1);
		followUpActionListType.getFollowUpAction().add(followUpAction2);
		wellbeingPersonLinkType.setFollowUpActionList(
				objectFactory.createWellbeingPersonLinkTypeFollowUpActionList(followUpActionListType));
		return wellbeingPersonLinkType;
	}

	public String getRefId(int index) {
		String result = null;
		if (index >= 0 && index < REF_ID_RA.length) {
			result = REF_ID_RA[index];
		} else {
			result = RefIdGenerator.getRefId();
		}
		return result;
	}

	public WellbeingPersonLinkCollectionType getTestCollection(String... refIds) {
		WellbeingPersonLinkCollectionType result = new WellbeingPersonLinkCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getWellbeingPersonLink().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "WellbeingPersonLink.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "WellbeingPersonLinks.xml";
	}

}
