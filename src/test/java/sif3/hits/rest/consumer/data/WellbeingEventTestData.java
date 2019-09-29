package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsWellbeingEventCategoryClassType;
import sif.dd.au30.model.AUCodeSetsWellbeingEventLocationType;
import sif.dd.au30.model.AUCodeSetsWellbeingEventTimePeriodType;
import sif.dd.au30.model.AUCodeSetsWellbeingStatusType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.FollowUpActionListType;
import sif.dd.au30.model.FollowUpActionType;
import sif.dd.au30.model.PersonInvolvementListType;
import sif.dd.au30.model.PersonInvolvementType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingEventCategoryListType;
import sif.dd.au30.model.WellbeingEventCategoryType;
import sif.dd.au30.model.WellbeingEventCollectionType;
import sif.dd.au30.model.WellbeingEventLocationDetailsType;
import sif.dd.au30.model.WellbeingEventSubCategoryListType;
import sif.dd.au30.model.WellbeingEventType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class WellbeingEventTestData extends TestData<WellbeingEventType,WellbeingEventCollectionType> {

    public static final String REF_ID_1 = "c19f7155-1dd6-416d-850c-111f46257418";
    public static final String REF_ID_2 = "00de0430-ebff-40b5-9ba8-0ec3ca53539f";
    public static final String REF_ID_3 = "1de80e34-9b7d-45a7-81b7-e362c56c599e";
    public static final String REF_ID_4 = "bec322d5-d8f3-4429-b73e-3c6fad6a0c49";
    public static final String REF_ID_5 = "f003f907-f3c6-4170-a161-2c4f5cfb36cb";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "aa963553-80fa-4228-840e-137beac0bbba";
    public static final String XML_REF_ID_2 = "3b795b5e-9245-4448-8f75-e60daf59677a";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public WellbeingEventType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        WellbeingEventType wellbeingEventType = objectFactory.createWellbeingEventType();
        wellbeingEventType.setRefId(refId);
        wellbeingEventType.setStudentPersonalRefId(objectFactory.createWellbeingEventTypeStudentPersonalRefId(StudentPersonalTestData.REF_ID_1));
        wellbeingEventType.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        wellbeingEventType.setEventId(objectFactory.createWellbeingEventTypeEventId("Event Id"));
        wellbeingEventType.setWellbeingEventNotes(objectFactory.createWellbeingEventTypeWellbeingEventNotes("Notes Notes Notes"));
        wellbeingEventType.setWellbeingEventCategoryClass(AUCodeSetsWellbeingEventCategoryClassType.N);
        wellbeingEventType.setReportingStaffRefId(objectFactory.createWellbeingEventTypeReportingStaffRefId(StaffPersonalTestData.REF_ID_4));
        wellbeingEventType.setWellbeingEventCreationTimeStamp(objectFactory.createWellbeingEventTypeWellbeingEventCreationTimeStamp(getCalendar("2018-03-09T10:00:00Z")));
        wellbeingEventType.setWellbeingEventDate(getDate("2018-02-23"));
        wellbeingEventType.setWellbeingEventTime(objectFactory.createWellbeingEventTypeWellbeingEventTime(getDate("09:00:00")));
        wellbeingEventType.setWellbeingEventDescription(objectFactory.createWellbeingEventTypeWellbeingEventDescription("Event Description"));
        wellbeingEventType.setWellbeingEventTimePeriod(AUCodeSetsWellbeingEventTimePeriodType.B);

        WellbeingEventLocationDetailsType locationDetailsType = objectFactory.createWellbeingEventLocationDetailsType();
        locationDetailsType.setEventLocation(AUCodeSetsWellbeingEventLocationType.C);
        locationDetailsType.setClazz(objectFactory.createWellbeingEventLocationDetailsTypeClass("PPR01"));
        locationDetailsType.setFurtherLocationNotes(objectFactory.createWellbeingEventLocationDetailsTypeFurtherLocationNotes("Notes"));
        wellbeingEventType.setWellbeingEventLocationDetails(objectFactory.createWellbeingEventTypeWellbeingEventLocationDetails(locationDetailsType));
        wellbeingEventType.setConfidentialFlag(objectFactory.createWellbeingEventTypeConfidentialFlag(AUCodeSetsYesOrNoCategoryType.N));
        wellbeingEventType.setStatus(objectFactory.createWellbeingEventTypeStatus(AUCodeSetsWellbeingStatusType.R));
        wellbeingEventType.setGroupIndicator(objectFactory.createWellbeingEventTypeGroupIndicator(Boolean.FALSE));

        WellbeingDocumentListType wellbeingDocumentListType = objectFactory.createWellbeingDocumentListType();
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(1));
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(2));
        wellbeingEventType.setDocumentList(objectFactory.createWellbeingEventTypeDocumentList(wellbeingDocumentListType));

        PersonInvolvementType personInvolvement1 = objectFactory.createPersonInvolvementType();
        personInvolvement1.setHowInvolved(objectFactory.createPersonInvolvementTypeHowInvolved("Instigator"));
        personInvolvement1.setShortName(objectFactory.createPersonInvolvementTypeShortName("John Smith Student"));
        PersonInvolvementType.PersonRefId personRefId1 = new PersonInvolvementType.PersonRefId();
        personRefId1.setValue(StudentPersonalTestData.REF_ID_2);
        personRefId1.setSIFRefObject("StudentPersonal");
        personInvolvement1.setPersonRefId(objectFactory.createPersonInvolvementTypePersonRefId(personRefId1));

        PersonInvolvementType personInvolvement2 = objectFactory.createPersonInvolvementType();
        personInvolvement2.setHowInvolved(objectFactory.createPersonInvolvementTypeHowInvolved("Teacher"));
        personInvolvement2.setShortName(objectFactory.createPersonInvolvementTypeShortName("John Smith Teacher"));
        PersonInvolvementType.PersonRefId personRefId2 = new PersonInvolvementType.PersonRefId();
        personRefId2.setValue(StaffPersonalTestData.REF_ID_2);
        personRefId2.setSIFRefObject("StaffPersonal");
        personInvolvement2.setPersonRefId(objectFactory.createPersonInvolvementTypePersonRefId(personRefId2));

        PersonInvolvementListType personInvolvementListType = objectFactory.createPersonInvolvementListType();
        personInvolvementListType.getPersonInvolvement().add(personInvolvement1);
        personInvolvementListType.getPersonInvolvement().add(personInvolvement2);
        wellbeingEventType.setPersonInvolvementList(objectFactory.createWellbeingEventTypePersonInvolvementList(personInvolvementListType));

        FollowUpActionType followUpAction1 = objectFactory.createFollowUpActionType();
        followUpAction1.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails("Follow up details - 1"));
        followUpAction1.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory("Category 1"));
        followUpAction1.setWellbeingResponseRefId(objectFactory.createFollowUpActionTypeWellbeingResponseRefId(WellbeingResponseTestData.REF_ID_1));

        FollowUpActionType followUpAction2 = objectFactory.createFollowUpActionType();
        followUpAction2.setFollowUpDetails(objectFactory.createFollowUpActionTypeFollowUpDetails("Follow up details - 2"));
        followUpAction2.setFollowUpActionCategory(objectFactory.createFollowUpActionTypeFollowUpActionCategory("Category 2"));
        followUpAction2.setWellbeingResponseRefId(objectFactory.createFollowUpActionTypeWellbeingResponseRefId(WellbeingResponseTestData.REF_ID_2));

        FollowUpActionListType followUpActionListType = objectFactory.createFollowUpActionListType();
        followUpActionListType.getFollowUpAction().add(followUpAction1);
        followUpActionListType.getFollowUpAction().add(followUpAction2);
        wellbeingEventType.setFollowUpActionList(objectFactory.createWellbeingEventTypeFollowUpActionList(followUpActionListType));

        WellbeingEventCategoryType category1 = objectFactory.createWellbeingEventCategoryType();
        category1.setEventCategory("M8");
        WellbeingEventSubCategoryListType subcategory1 = objectFactory.createWellbeingEventSubCategoryListType();
        subcategory1.getWellbeingEventSubCategory().add("M8a");
        category1.setWellbeingEventSubCategoryList(objectFactory.createWellbeingEventCategoryTypeWellbeingEventSubCategoryList(subcategory1));

        WellbeingEventCategoryType category2 = objectFactory.createWellbeingEventCategoryType();
        category2.setEventCategory("M8");

        WellbeingEventCategoryType category3 = objectFactory.createWellbeingEventCategoryType();
        category3.setEventCategory("M7");
        WellbeingEventSubCategoryListType subcategory3 = objectFactory.createWellbeingEventSubCategoryListType();
        subcategory3.getWellbeingEventSubCategory().add("M7a");
        subcategory3.getWellbeingEventSubCategory().add("M7b");
        category3.setWellbeingEventSubCategoryList(objectFactory.createWellbeingEventCategoryTypeWellbeingEventSubCategoryList(subcategory3));

        WellbeingEventCategoryListType wellbeingEventCategoryListType = objectFactory.createWellbeingEventCategoryListType();
        wellbeingEventCategoryListType.getWellbeingEventCategory().add(category1);
        wellbeingEventCategoryListType.getWellbeingEventCategory().add(category2);
        wellbeingEventCategoryListType.getWellbeingEventCategory().add(category3);
        wellbeingEventType.setWellbeingEventCategoryList(objectFactory.createWellbeingEventTypeWellbeingEventCategoryList(wellbeingEventCategoryListType));
        return wellbeingEventType;
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

    public WellbeingEventCollectionType getTestCollection(String... refIds) {
        WellbeingEventCollectionType result = new WellbeingEventCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getWellbeingEvent().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "WellbeingEvent.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "WellbeingEvents.xml";
    }

}

