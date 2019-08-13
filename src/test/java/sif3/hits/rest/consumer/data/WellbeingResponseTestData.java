package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.rest.consumer.WellbeingResponseConsumerTest;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class WellbeingResponseTestData extends TestData<WellbeingResponseType, WellbeingResponseCollectionType> {

    public static final String REF_ID_1 = "9e7682f7-db56-44da-a7d2-1405784a2fcd";
    public static final String REF_ID_2 = "0b803bdd-a61c-4551-bfa8-cf2dad823d44";
    public static final String REF_ID_3 = "d3a9fe68-a7fb-4364-95fd-08d40168d4a9";
    public static final String REF_ID_4 = "10722577-ff71-4795-8f33-2a3af7f3d271";
    public static final String REF_ID_5 = "ee1efffd-bde2-40f8-9fa9-b2509ba1803c";
    public static final String REF_ID_6 = "a76aaca8-e6e5-4b31-9574-93779478494a";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5, REF_ID_6};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "362c7bf6-1be9-413b-9912-819e293d47cb";
    public static final String XML_REF_ID_2 = "533e442b-7c0b-43ac-b253-0a6dc649ec96";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public WellbeingResponseType getTestObject(String refId) {
        ObjectFactory objectFactory = new ObjectFactory();

        WellbeingResponseType wellbeingResponseType = objectFactory.createWellbeingResponseType();
        wellbeingResponseType.setRefId(refId);
        wellbeingResponseType.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        wellbeingResponseType.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        wellbeingResponseType.setDate(getDate("2018-03-06"));
        wellbeingResponseType.setWellbeingResponseStartDate(getDate("2018-03-01"));
        wellbeingResponseType.setWellbeingResponseEndDate(objectFactory.createWellbeingResponseTypeWellbeingResponseEndDate(getDate("2018-05-09")));
        wellbeingResponseType.setWellbeingResponseNotes(objectFactory.createWellbeingResponseTypeWellbeingResponseNotes("Wellbeing Response Notes"));

        WellbeingDocumentListType wellbeingDocumentListType = objectFactory.createWellbeingDocumentListType();
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(1));
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(2));
        wellbeingResponseType.setDocumentList(objectFactory.createWellbeingResponseTypeDocumentList(wellbeingDocumentListType));

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
        wellbeingResponseType.setPersonInvolvementList(objectFactory.createWellbeingResponseTypePersonInvolvementList(personInvolvementListType));

        if (REF_ID_2.equals(refId)) {
            wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.S));
            SuspensionContainerType suspensionType = objectFactory.createSuspensionContainerType();
            suspensionType.setSuspensionCategory(AUCodeSetsSuspensionCategoryType.S);
            suspensionType.setDuration(objectFactory.createSuspensionContainerTypeDuration(BigDecimal.ONE));
            suspensionType.setAdvisementDate(objectFactory.createSuspensionContainerTypeAdvisementDate(getDate("2018-03-06")));
            suspensionType.setResolutionMeetingTime(objectFactory.createSuspensionContainerTypeResolutionMeetingTime(getCalendar("2018-03-10T09:00:00Z")));
            suspensionType.setResolutionNotes(objectFactory.createSuspensionContainerTypeResolutionNotes("Suspended"));
            suspensionType.setEarlyReturnDate(objectFactory.createSuspensionContainerTypeEarlyReturnDate(getDate("2018-03-11")));
            suspensionType.setStatus(objectFactory.createSuspensionContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));

            WithdrawalType withdrawalType1 = objectFactory.createWithdrawalType();
            withdrawalType1.setScheduledActivityRefId(objectFactory.createWithdrawalTypeScheduledActivityRefId(ScheduledActivityTestData.REF_ID_1));
            withdrawalType1.setTimeTableCellRefId(objectFactory.createWithdrawalTypeTimeTableCellRefId(TimeTableCellTestData.REF_ID_1));
            withdrawalType1.setTimeTableSubjectRefId(objectFactory.createWithdrawalTypeTimeTableSubjectRefId(TimeTableSubjectTestData.REF_ID_1));
            withdrawalType1.setWithdrawalDate(getDate("2018-03-09"));
            withdrawalType1.setWithdrawalStartTime(objectFactory.createWithdrawalTypeWithdrawalStartTime(getDate("09:00:00")));
            withdrawalType1.setWithdrawalEndTime(objectFactory.createWithdrawalTypeWithdrawalEndTime(getDate("15:30:00")));
            WithdrawalTimeListType withdrawalList = objectFactory.createWithdrawalTimeListType();
            withdrawalList.getWithdrawal().add(withdrawalType1);
            suspensionType.setWithdrawalTimeList(objectFactory.createSuspensionContainerTypeWithdrawalTimeList(withdrawalList));
            wellbeingResponseType.setSuspension(objectFactory.createWellbeingResponseTypeSuspension(suspensionType));
        } else if (REF_ID_3.equals(refId)) {
            wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.D));
            DetentionContainerType detentionType = objectFactory.createDetentionContainerType();
            detentionType.setDetentionCategory(AUCodeSetsDetentionCategoryType.A);
            detentionType.setDetentionDate(objectFactory.createDetentionContainerTypeDetentionDate(getDate("2018-03-01")));
            detentionType.setDetentionLocation(objectFactory.createDetentionContainerTypeDetentionLocation("The Naughty Corner"));
            detentionType.setDetentionNotes(objectFactory.createDetentionContainerTypeDetentionNotes("Some Detention Notes"));
            detentionType.setStatus(objectFactory.createDetentionContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
            wellbeingResponseType.setDetention(objectFactory.createWellbeingResponseTypeDetention(detentionType));
        } else if (REF_ID_4.equals(refId)) {
            wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.P));
            PlanRequiredContainerType planRequiredType = objectFactory.createPlanRequiredContainerType();
            WellbeingPlanType wellbeingPlanType1 = objectFactory.createWellbeingPlanType();
            wellbeingPlanType1.setPersonalisedPlanRefId(objectFactory.createWellbeingPlanTypePersonalisedPlanRefId(PersonalisedPlanTestData.REF_ID_1));
            wellbeingPlanType1.setPlanNotes(objectFactory.createWellbeingPlanTypePlanNotes("Personalised Plan Notes"));

            WellbeingPlanType wellbeingPlanType2 = objectFactory.createWellbeingPlanType();
            wellbeingPlanType1.setPersonalisedPlanRefId(objectFactory.createWellbeingPlanTypePersonalisedPlanRefId(PersonalisedPlanTestData.REF_ID_2));
            wellbeingPlanType1.setPlanNotes(objectFactory.createWellbeingPlanTypePlanNotes("Personalised Plan Notes"));

            planRequiredType.setStatus(objectFactory.createPlanRequiredContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
            PlanRequiredListType planRequiredList = objectFactory.createPlanRequiredListType();
            planRequiredList.getPlan().add(wellbeingPlanType1);
            planRequiredList.getPlan().add(wellbeingPlanType2);
            wellbeingResponseType.setPlanRequired(objectFactory.createWellbeingResponseTypePlanRequired(planRequiredType));
        } else if (REF_ID_5.equals(refId)) {
            wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.A));
            AwardContainerType awardType = objectFactory.createAwardContainerType();
            awardType.setAwardDate(objectFactory.createAwardContainerTypeAwardDate(getDate("2018-04-02")));
            awardType.setAwardType(objectFactory.createAwardContainerTypeAwardType("Book Prize"));
            awardType.setAwardDescription(objectFactory.createAwardContainerTypeAwardDescription("Super duper best student in the world award"));
            awardType.setAwardNotes(objectFactory.createAwardContainerTypeAwardNotes("Student is definitely the best student"));
            awardType.setStatus(objectFactory.createAwardContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
            wellbeingResponseType.setAward(objectFactory.createWellbeingResponseTypeAward(awardType));
        } else if (REF_ID_6.equals(refId)) {
            wellbeingResponseType.setWellbeingResponseCategory(objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(AUCodeSetsWellbeingResponseCategoryType.O));
            OtherWellbeingResponseContainerType otherType = objectFactory.createOtherWellbeingResponseContainerType();
            otherType.setOtherResponseDate(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseDate(getDate("2018-03-11")));
            otherType.setOtherResponseType(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseType("Other Response"));
            otherType.setOtherResponseDescription(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseDescription("Response Description"));
            otherType.setOtherResponseNotes(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseNotes("Response Notes"));
            otherType.setStatus(objectFactory.createOtherWellbeingResponseContainerTypeStatus(AUCodeSetsWellbeingStatusType.O));
            wellbeingResponseType.setOtherResponse(objectFactory.createWellbeingResponseTypeOtherResponse(otherType));
        }
        return wellbeingResponseType;
    }

    @Override
    public boolean verifyAllInitialObjects() {
        return true;
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

    public WellbeingResponseCollectionType getTestCollection(String... refIds) {
        WellbeingResponseCollectionType result = new WellbeingResponseCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getWellbeingResponse().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "WellbeingResponse.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "WellbeingResponses.xml";
    }

}

