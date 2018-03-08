package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsDetentionCategoryType;
import sif.dd.au30.model.AUCodeSetsSuspensionCategoryType;
import sif.dd.au30.model.AUCodeSetsWellbeingResponseCategoryType;
import sif.dd.au30.model.AUCodeSetsWellbeingStatusType;
import sif.dd.au30.model.AwardContainerType;
import sif.dd.au30.model.DetentionContainerType;
import sif.dd.au30.model.OtherWellbeingResponseContainerType;
import sif.dd.au30.model.PersonInvolvementListType;
import sif.dd.au30.model.PersonInvolvementType;
import sif.dd.au30.model.PlanRequiredContainerType;
import sif.dd.au30.model.PlanRequiredListType;
import sif.dd.au30.model.SuspensionContainerType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif.dd.au30.model.WellbeingPlanType;
import sif.dd.au30.model.WellbeingResponseType;
import sif.dd.au30.model.WithdrawalTimeListType;
import sif.dd.au30.model.WithdrawalType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingResponse;
import sif3.hits.domain.model.WellbeingResponseDocument;
import sif3.hits.domain.model.WellbeingResponsePersonInvolvement;
import sif3.hits.domain.model.WellbeingResponsePlanRequired;
import sif3.hits.domain.model.WellbeingResponseSuspensionWithdrawalTime;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingResponseConverter extends HitsConverter<WellbeingResponseType, WellbeingResponse> implements UsesConstants {

    @Autowired
    WellbeingResponseSuspensionWithdrawalTimeConverter suspensionWithdrawalTimeConverter;

    @Autowired
    WellbeingResponseWellbeingPlanConverter wellbeingPlanConverter;

    @Autowired
    WellbeingResponseDocumentConverter wellbeingDocumentConverter;

    @Autowired
    WellbeingResponsePersonInvolvementConverter personInvolvementConverter;

    public WellbeingResponseConverter() {
        super(WellbeingResponseType.class, WellbeingResponse.class);
    }

    @Override
    public void toSifModel(WellbeingResponse source, WellbeingResponseType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();
            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setDate(getDateValue(source.getDate()));
            target.setWellbeingResponseStartDate(getDateValue(source.getStartDate()));
            target.setWellbeingResponseEndDate(objectFactory.createWellbeingResponseTypeWellbeingResponseEndDate(getDateValue(source.getEndDate())));
            target.setWellbeingResponseCategory(
                    objectFactory.createWellbeingResponseTypeWellbeingResponseCategory(getEnumValue(source.getCategory(), AUCodeSetsWellbeingResponseCategoryType.class)));
            target.setWellbeingResponseNotes(objectFactory.createWellbeingResponseTypeWellbeingResponseNotes(source.getNotes()));
            if (isSuspension(source)) {
                SuspensionContainerType suspensionType = objectFactory.createSuspensionContainerType();
                suspensionType.setSuspensionCategory(getEnumValue(source.getSuspensionCategory(), AUCodeSetsSuspensionCategoryType.class));
                suspensionType.setDuration(objectFactory.createSuspensionContainerTypeDuration(getBigDecimalValue(source.getSuspensionDuration())));
                suspensionType.setAdvisementDate(objectFactory.createSuspensionContainerTypeAdvisementDate(getDateValue(source.getSuspensionAdvisementDate())));
                suspensionType
                        .setResolutionMeetingTime(objectFactory.createSuspensionContainerTypeResolutionMeetingTime(getCalendarValue(source.getSuspensionResolutionMeetingTime())));
                suspensionType.setResolutionNotes(objectFactory.createSuspensionContainerTypeResolutionNotes(source.getSuspensionResolutionNotes()));
                suspensionType.setEarlyReturnDate(objectFactory.createSuspensionContainerTypeEarlyReturnDate(getDateValue(source.getSuspensionEarlyReturnDate())));
                suspensionType.setStatus(objectFactory.createSuspensionContainerTypeStatus(getEnumValue(source.getSuspensionStatus(), AUCodeSetsWellbeingStatusType.class)));

                if (source.getSuspensionWithdawalTimes() != null && !source.getSuspensionWithdawalTimes().isEmpty()) {
                    List<WithdrawalType> withdrawalTimes = suspensionWithdrawalTimeConverter.toSifModelList(source.getSuspensionWithdawalTimes());
                    if (withdrawalTimes != null && !withdrawalTimes.isEmpty()) {
                        WithdrawalTimeListType withdrawalTimeList = objectFactory.createWithdrawalTimeListType();
                        withdrawalTimeList.getWithdrawal().addAll(withdrawalTimes);
                        suspensionType.setWithdrawalTimeList(objectFactory.createSuspensionContainerTypeWithdrawalTimeList(withdrawalTimeList));
                    }
                }
                target.setSuspension(objectFactory.createWellbeingResponseTypeSuspension(suspensionType));
            }
            if (isDetention(source)) {
                DetentionContainerType detentionType = objectFactory.createDetentionContainerType();
                detentionType.setDetentionCategory(getEnumValue(source.getDetentionCategory(), AUCodeSetsDetentionCategoryType.class));
                detentionType.setDetentionDate(objectFactory.createDetentionContainerTypeDetentionDate(getDateValue(source.getDetentionDate())));
                detentionType.setDetentionLocation(objectFactory.createDetentionContainerTypeDetentionLocation(source.getDetentionLocation()));
                detentionType.setDetentionNotes(objectFactory.createDetentionContainerTypeDetentionNotes(source.getDetentionNotes()));
                detentionType.setStatus(objectFactory.createDetentionContainerTypeStatus(getEnumValue(source.getDetentionStatus(), AUCodeSetsWellbeingStatusType.class)));
                target.setDetention(objectFactory.createWellbeingResponseTypeDetention(detentionType));
            }
            if (isPlanRequired(source)) {
                PlanRequiredContainerType planRequiredType = objectFactory.createPlanRequiredContainerType();
                planRequiredType.setStatus(objectFactory.createPlanRequiredContainerTypeStatus(getEnumValue(source.getPlanRequiredStatus(), AUCodeSetsWellbeingStatusType.class)));
                if (source.getPlansRequired() != null && !source.getPlansRequired().isEmpty()) {
                    List<WellbeingPlanType> wellbeingPlans = wellbeingPlanConverter.toSifModelList(source.getPlansRequired());
                    if (wellbeingPlans != null && !wellbeingPlans.isEmpty()) {
                        PlanRequiredListType planRequiredList = objectFactory.createPlanRequiredListType();
                        planRequiredList.getPlan().addAll(wellbeingPlans);
                        planRequiredType.setPlanRequiredList(objectFactory.createPlanRequiredContainerTypePlanRequiredList(planRequiredList));
                    }
                }
                target.setPlanRequired(objectFactory.createWellbeingResponseTypePlanRequired(planRequiredType));
            }
            if (isAward(source)) {
                AwardContainerType awardType = objectFactory.createAwardContainerType();
                awardType.setAwardDate(objectFactory.createAwardContainerTypeAwardDate(getDateValue(source.getAwardDate())));
                awardType.setAwardType(objectFactory.createAwardContainerTypeAwardType(source.getAwardType()));
                awardType.setAwardDescription(objectFactory.createAwardContainerTypeAwardDescription(source.getAwardDescription()));
                awardType.setAwardNotes(objectFactory.createAwardContainerTypeAwardNotes(source.getAwardNotes()));
                awardType.setStatus(objectFactory.createAwardContainerTypeStatus(getEnumValue(source.getAwardStatus(), AUCodeSetsWellbeingStatusType.class)));
                target.setAward(objectFactory.createWellbeingResponseTypeAward(awardType));
            }
            if (isOther(source)) {
                OtherWellbeingResponseContainerType otherType = objectFactory.createOtherWellbeingResponseContainerType();
                otherType.setOtherResponseDate(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseDate(getDateValue(source.getOtherResponseDate())));
                otherType.setOtherResponseType(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseType(source.getOtherResponseType()));
                otherType.setOtherResponseDescription(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseDescription(source.getOtherResponseDescription()));
                otherType.setOtherResponseNotes(objectFactory.createOtherWellbeingResponseContainerTypeOtherResponseNotes(source.getOtherResponseNotes()));
                otherType.setStatus(objectFactory.createOtherWellbeingResponseContainerTypeStatus(getEnumValue(source.getOtherStatus(), AUCodeSetsWellbeingStatusType.class)));
                target.setOtherResponse(objectFactory.createWellbeingResponseTypeOtherResponse(otherType));
            }
            if (source.getPersonInvolvements() != null && !source.getPersonInvolvements().isEmpty()) {
                List<PersonInvolvementType> personInvolvements = personInvolvementConverter.toSifModelList(source.getPersonInvolvements());
                if (personInvolvements != null && !personInvolvements.isEmpty()) {
                    PersonInvolvementListType personInvolvementList = objectFactory.createPersonInvolvementListType();
                    personInvolvementList.getPersonInvolvement().addAll(personInvolvements);
                    target.setPersonInvolvementList(objectFactory.createWellbeingEventTypePersonInvolvementList(personInvolvementList));
                }
            }
            if (source.getDocuments() != null && !source.getDocuments().isEmpty()) {
                List<WellbeingDocumentType> documents = wellbeingDocumentConverter.toSifModelList(source.getDocuments());
                if (documents != null && !documents.isEmpty()) {
                    WellbeingDocumentListType documentList = objectFactory.createWellbeingDocumentListType();
                    documentList.getDocument().addAll(documents);
                    target.setDocumentList(objectFactory.createWellbeingResponseTypeDocumentList(documentList));
                }
            }
        }
    }

    @Override
    public void toHitsModel(WellbeingResponseType source, WellbeingResponse target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(source.getStudentPersonalRefId());
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setDate(getDateValue(source.getDate()));
            target.setStartDate(getDateValue(source.getWellbeingResponseStartDate()));
            target.setEndDate(getDateValue(getJAXBValue(source.getWellbeingResponseEndDate())));
            target.setCategory(getJAXBEnumValue(source.getWellbeingResponseCategory()));
            target.setNotes(getJAXBValue(source.getWellbeingResponseNotes()));

            resetModel(target);

            SuspensionContainerType suspensionType = getJAXBValue(source.getSuspension());
            if (suspensionType != null) {
                target.setSuspensionCategory(getEnumValue(suspensionType.getSuspensionCategory()));
                target.setSuspensionDuration(getBigDecimalValue(getJAXBValue(suspensionType.getDuration())));
                target.setSuspensionAdvisementDate(getDateValue(getJAXBValue(suspensionType.getAdvisementDate())));
                target.setSuspensionResolutionMeetingTime(getCalendarValue(getJAXBValue(suspensionType.getResolutionMeetingTime())));
                target.setSuspensionResolutionNotes(getJAXBValue(suspensionType.getResolutionNotes()));
                target.setSuspensionEarlyReturnDate(getDateValue(getJAXBValue(suspensionType.getEarlyReturnDate())));
                target.setSuspensionStatus(getJAXBEnumValue(suspensionType.getStatus()));

                WithdrawalTimeListType withdrawalTimeList = getJAXBValue(suspensionType.getWithdrawalTimeList());
                if (withdrawalTimeList != null && !withdrawalTimeList.getWithdrawal().isEmpty()) {
                    List<WellbeingResponseSuspensionWithdrawalTime> withdrawalTimes = suspensionWithdrawalTimeConverter.toHitsModelList(withdrawalTimeList.getWithdrawal());
                    if (withdrawalTimes != null && !withdrawalTimes.isEmpty()) {
                        for (WellbeingResponseSuspensionWithdrawalTime withdrawalTime : withdrawalTimes) {
                            withdrawalTime.setWellbeingResponse(target);
                        }
                        target.getSuspensionWithdawalTimes().addAll(withdrawalTimes);
                    }
                }
            }

            DetentionContainerType detentionType = getJAXBValue(source.getDetention());
            if (detentionType != null) {
                target.setDetentionCategory(getEnumValue(detentionType.getDetentionCategory()));
                target.setDetentionDate(getDateValue(getJAXBValue(detentionType.getDetentionDate())));
                target.setDetentionLocation(getJAXBValue(detentionType.getDetentionLocation()));
                target.setDetentionNotes(getJAXBValue(detentionType.getDetentionNotes()));
                target.setDetentionStatus(getJAXBEnumValue(detentionType.getStatus()));
            }

            PlanRequiredContainerType planRequiredType = getJAXBValue(source.getPlanRequired());
            if (planRequiredType != null) {
                target.setPlanRequiredStatus(getJAXBEnumValue(planRequiredType.getStatus()));

                PlanRequiredListType planRequiredList = getJAXBValue(planRequiredType.getPlanRequiredList());
                if (planRequiredList != null && !planRequiredList.getPlan().isEmpty()) {
                    List<WellbeingResponsePlanRequired> wellbeingPlans = wellbeingPlanConverter.toHitsModelList(planRequiredList.getPlan());
                    if (wellbeingPlans != null && !wellbeingPlans.isEmpty()) {
                        for (WellbeingResponsePlanRequired wellbeingPlan : wellbeingPlans) {
                            wellbeingPlan.setWellbeingResponse(target);
                        }
                        target.getPlansRequired().addAll(wellbeingPlans);
                    }
                }
            }

            AwardContainerType awardType = getJAXBValue(source.getAward());
            if (awardType != null) {
                target.setAwardDate(getDateValue(getJAXBValue(awardType.getAwardDate())));
                target.setAwardType(getJAXBValue(awardType.getAwardType()));
                target.setAwardDescription(getJAXBValue(awardType.getAwardDescription()));
                target.setAwardNotes(getJAXBValue(awardType.getAwardNotes()));
                target.setAwardStatus(getJAXBEnumValue(awardType.getStatus()));
            }

            OtherWellbeingResponseContainerType otherType = getJAXBValue(source.getOtherResponse());
            if (otherType != null) {
                target.setOtherResponseDate(getDateValue(getJAXBValue(otherType.getOtherResponseDate())));
                target.setOtherResponseType(getJAXBValue(otherType.getOtherResponseType()));
                target.setOtherResponseDescription(getJAXBValue(otherType.getOtherResponseDescription()));
                target.setOtherResponseNotes(getJAXBValue(otherType.getOtherResponseNotes()));
                target.setOtherStatus(getJAXBEnumValue(otherType.getStatus()));
            }

            PersonInvolvementListType personInvolvementList = getJAXBValue(source.getPersonInvolvementList());
            if (personInvolvementList != null && !personInvolvementList.getPersonInvolvement().isEmpty()) {
                List<WellbeingResponsePersonInvolvement> personInvolvements = personInvolvementConverter.toHitsModelList(personInvolvementList.getPersonInvolvement());
                if (personInvolvements != null && !personInvolvements.isEmpty()) {
                    for (WellbeingResponsePersonInvolvement personInvolvement : personInvolvements) {
                        personInvolvement.setWellbeingResponse(target);
                    }
                    target.getPersonInvolvements().addAll(personInvolvements);
                }
            }

            WellbeingDocumentListType documentList = getJAXBValue(source.getDocumentList());
            if (documentList != null && !documentList.getDocument().isEmpty()) {
                List<WellbeingResponseDocument> documents = wellbeingDocumentConverter.toHitsModelList(documentList.getDocument());
                if (documents != null && !documents.isEmpty()) {
                    for (WellbeingResponseDocument document : documents) {
                        document.setWellbeingResponse(target);
                    }
                    target.getDocuments().addAll(documents);
                }
            }
        }
    }

    private void resetModel(WellbeingResponse target) {
        target.setSuspensionCategory(null);
        target.setSuspensionDuration(null);
        target.setSuspensionAdvisementDate(null);
        target.setSuspensionResolutionMeetingTime(null);
        target.setSuspensionResolutionNotes(null);
        target.setSuspensionEarlyReturnDate(null);
        target.setSuspensionStatus(null);
        target.setDetentionCategory(null);
        target.setDetentionDate(null);
        target.setDetentionLocation(null);
        target.setDetentionNotes(null);
        target.setDetentionStatus(null);
        target.setPlanRequiredStatus(null);
        target.setAwardDate(null);
        target.setAwardType(null);
        target.setAwardDescription(null);
        target.setAwardNotes(null);
        target.setAwardStatus(null);
        target.setOtherResponseDate(null);
        target.setOtherResponseType(null);
        target.setOtherResponseDescription(null);
        target.setOtherResponseNotes(null);
        target.setOtherStatus(null);
        if (target.getSuspensionWithdawalTimes() == null) {
            target.setSuspensionWithdawalTimes(new ArrayList<WellbeingResponseSuspensionWithdrawalTime>());
        }
        target.getSuspensionWithdawalTimes().clear();
        if (target.getPlansRequired() == null) {
            target.setPlansRequired(new ArrayList<WellbeingResponsePlanRequired>());
        }
        target.getPlansRequired().clear();
        if (target.getPersonInvolvements() == null) {
            target.setPersonInvolvements(new ArrayList<WellbeingResponsePersonInvolvement>());
        }
        target.getPersonInvolvements().clear();
        if (target.getDocuments() == null) {
            target.setDocuments(new ArrayList<WellbeingResponseDocument>());
        }
        target.getDocuments().clear();
    }

    private boolean isOther(WellbeingResponse source) {
        return source != null && (StringUtils.isNotBlank(source.getOtherResponseDate()) || StringUtils.isNotBlank(source.getOtherResponseType())
                || StringUtils.isNotBlank(source.getOtherResponseDescription()) || StringUtils.isNotBlank(source.getOtherResponseNotes())
                || StringUtils.isNotBlank(source.getOtherStatus()));
    }

    private boolean isAward(WellbeingResponse source) {
        return source != null && (StringUtils.isNotBlank(source.getAwardDate()) || StringUtils.isNotBlank(source.getAwardType())
                || StringUtils.isNotBlank(source.getAwardDescription()) || StringUtils.isNotBlank(source.getAwardNotes()) || StringUtils.isNotBlank(source.getAwardStatus()));
    }

    private boolean isPlanRequired(WellbeingResponse source) {
        return source != null && (StringUtils.isNotBlank(source.getPlanRequiredStatus()) || (source.getPlansRequired() != null && !source.getPlansRequired().isEmpty()));
    }

    private boolean isDetention(WellbeingResponse source) {
        return source != null && (StringUtils.isNotBlank(source.getDetentionCategory()) || StringUtils.isNotBlank(source.getDetentionDate())
                || StringUtils.isNotBlank(source.getDetentionLocation()) || StringUtils.isNotBlank(source.getDetentionNotes()) || StringUtils.isNotBlank(source.getDetentionStatus()));
    }

    private boolean isSuspension(WellbeingResponse source) {
        return source != null && (StringUtils.isNotBlank(source.getSuspensionCategory()) || StringUtils.isNotBlank(source.getSuspensionDuration())
                || StringUtils.isNotBlank(source.getSuspensionAdvisementDate()) || StringUtils.isNotBlank(source.getSuspensionResolutionMeetingTime())
                || StringUtils.isNotBlank(source.getSuspensionResolutionNotes()) || StringUtils.isNotBlank(source.getSuspensionEarlyReturnDate())
                || StringUtils.isNotBlank(source.getSuspensionStatus()) || StringUtils.isNotBlank(source.getSuspensionAdvisementDate())
                || (source.getSuspensionWithdawalTimes() != null && !source.getSuspensionWithdawalTimes().isEmpty()));
    }
}
