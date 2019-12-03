package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import sif.dd.au30.model.WellbeingDocumentType;
import sif.dd.au30.model.WellbeingEventCategoryListType;
import sif.dd.au30.model.WellbeingEventCategoryType;
import sif.dd.au30.model.WellbeingEventLocationDetailsType;
import sif.dd.au30.model.WellbeingEventType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingEvent;
import sif3.hits.domain.model.WellbeingEventCategory;
import sif3.hits.domain.model.WellbeingEventDocument;
import sif3.hits.domain.model.WellbeingEventFollowUpAction;
import sif3.hits.domain.model.WellbeingEventPersonInvolvement;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingEventConverter extends HitsConverter<WellbeingEventType, WellbeingEvent> implements UsesConstants {

    @Autowired
    WellbeingEventDocumentConverter documentConverter;

    @Autowired
    WellbeingEventPersonInvolvementConverter personInvolvementConverter;

    @Autowired
    WellbeingEventCategoryConverter categoryConverter;

    @Autowired
    WellbeingEventFollowUpActionConverter followUpActionConverter;

    public WellbeingEventConverter() {
        super(WellbeingEventType.class, WellbeingEvent.class);
    }

    @Override
    public void toSifModel(WellbeingEvent source, WellbeingEventType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(objectFactory.createWellbeingEventTypeStudentPersonalRefId(source.getStudentPersonalRefId()));
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setEventId(objectFactory.createWellbeingEventTypeEventId(source.getEventId()));
            target.setWellbeingEventNotes(objectFactory.createWellbeingEventTypeWellbeingEventNotes(source.getWellbeingEventNotes()));
            target.setWellbeingEventCategoryClass(getEnumValue(source.getWellbeingEventCategoryClass(), AUCodeSetsWellbeingEventCategoryClassType.class));
            target.setReportingStaffRefId(objectFactory.createWellbeingEventTypeReportingStaffRefId(source.getReportingStaffRefId()));
            target.setWellbeingEventCreationTimeStamp(
                    objectFactory.createWellbeingEventTypeWellbeingEventCreationTimeStamp(getCalendarValue(source.getWellbeingEventCreationTimeStamp())));
            target.setWellbeingEventDate(getDateValue(source.getWellbeingEventDate()));
            target.setWellbeingEventTime(objectFactory.createWellbeingEventTypeWellbeingEventTime(getTimeValue(source.getWellbeingEventTime())));
            target.setWellbeingEventDescription(objectFactory.createWellbeingEventTypeWellbeingEventDescription(source.getWellbeingEventDescription()));
            target.setWellbeingEventTimePeriod(getEnumValue(source.getWellbeingEventTimePeriod(), AUCodeSetsWellbeingEventTimePeriodType.class));
            target.setGroupIndicator(objectFactory.createWellbeingEventTypeGroupIndicator(getBooleanValue(source.getGroupIndicator())));

            if (hasLocationDetails(source)) {
                WellbeingEventLocationDetailsType locationDetailsType = objectFactory.createWellbeingEventLocationDetailsType();
                locationDetailsType.setEventLocation(getEnumValue(source.getWellbeingEventLocationDetailsEventLocation(), AUCodeSetsWellbeingEventLocationType.class));
                locationDetailsType.setClazz(objectFactory.createWellbeingEventLocationDetailsTypeClass(source.getWellbeingEventLocationDetailsClass()));
                locationDetailsType.setFurtherLocationNotes(
                        objectFactory.createWellbeingEventLocationDetailsTypeFurtherLocationNotes(source.getWellbeingEventLocationDetailsFurtherLocationNotes()));
                target.setWellbeingEventLocationDetails(objectFactory.createWellbeingEventTypeWellbeingEventLocationDetails(locationDetailsType));
            }
            target.setConfidentialFlag(objectFactory.createWellbeingEventTypeConfidentialFlag(getEnumValue(source.getConfidentialFlag(), AUCodeSetsYesOrNoCategoryType.class)));
            target.setStatus(objectFactory.createWellbeingEventTypeStatus(getEnumValue(source.getStatus(), AUCodeSetsWellbeingStatusType.class)));

            if (source.getPersonInvolvements() != null && !source.getPersonInvolvements().isEmpty()) {
                List<PersonInvolvementType> personInvolvements = personInvolvementConverter.toSifModelList(source.getPersonInvolvements());
                if (personInvolvements != null && !personInvolvements.isEmpty()) {
                    PersonInvolvementListType personInvolvementList = objectFactory.createPersonInvolvementListType();
                    personInvolvementList.getPersonInvolvement().addAll(personInvolvements);
                    target.setPersonInvolvementList(objectFactory.createWellbeingEventTypePersonInvolvementList(personInvolvementList));
                }
            }
            if (source.getDocuments() != null && !source.getDocuments().isEmpty()) {
                List<WellbeingDocumentType> documents = documentConverter.toSifModelList(source.getDocuments());
                if (documents != null && !documents.isEmpty()) {
                    WellbeingDocumentListType documentList = objectFactory.createWellbeingDocumentListType();
                    documentList.getDocument().addAll(documents);
                    target.setDocumentList(objectFactory.createWellbeingEventTypeDocumentList(documentList));
                }
            }
            if (source.getCategories() != null && !source.getCategories().isEmpty()) {
                List<WellbeingEventCategoryType> categories = categoryConverter.toSifModelList(source.getCategories());
                if (categories != null && !categories.isEmpty()) {
                    WellbeingEventCategoryListType categoryList = objectFactory.createWellbeingEventCategoryListType();
                    categoryList.getWellbeingEventCategory().addAll(categories);
                    target.setWellbeingEventCategoryList(objectFactory.createWellbeingEventTypeWellbeingEventCategoryList(categoryList));
                }
            }
            if (source.getFollowUpActions() != null && !source.getFollowUpActions().isEmpty()) {
                List<FollowUpActionType> followUpActions = followUpActionConverter.toSifModelList(source.getFollowUpActions());
                if (followUpActions != null && !followUpActions.isEmpty()) {
                    FollowUpActionListType followUpActionList = objectFactory.createFollowUpActionListType();
                    followUpActionList.getFollowUpAction().addAll(followUpActions);
                    target.setFollowUpActionList(objectFactory.createWellbeingEventTypeFollowUpActionList(followUpActionList));
                }
            }
        }
    }

    @Override
    public void toHitsModel(WellbeingEventType source, WellbeingEvent target) {
        if (source != null && target != null) {
            resetModel(target);
            target.setRefId(source.getRefId());
            target.setStudentPersonalRefId(getJAXBValue(source.getStudentPersonalRefId()));
            target.setSchoolInfoRefId(source.getSchoolInfoRefId());
            target.setEventId(getJAXBValue(source.getEventId()));
            target.setWellbeingEventNotes(getJAXBValue(source.getWellbeingEventNotes()));
            target.setWellbeingEventCategoryClass(getEnumValue(source.getWellbeingEventCategoryClass()));
            target.setReportingStaffRefId(getJAXBValue(source.getReportingStaffRefId()));
            target.setWellbeingEventCreationTimeStamp(getCalendarValue(getJAXBValue(source.getWellbeingEventCreationTimeStamp())));
            target.setWellbeingEventDate(getDateValue(source.getWellbeingEventDate()));
            target.setWellbeingEventTime(getTimeValue(getJAXBValue(source.getWellbeingEventTime())));
            target.setWellbeingEventDescription(getJAXBValue(source.getWellbeingEventDescription()));
            target.setWellbeingEventTimePeriod(getEnumValue(source.getWellbeingEventTimePeriod()));
            target.setConfidentialFlag(getJAXBEnumValue(source.getConfidentialFlag()));
            target.setStatus(getJAXBEnumValue(source.getStatus()));
            target.setGroupIndicator(getBooleanValue(getJAXBValue(source.getGroupIndicator())));
            
            WellbeingEventLocationDetailsType wellbeingEventLocationDetailsType = getJAXBValue(source.getWellbeingEventLocationDetails());
            if (wellbeingEventLocationDetailsType != null) {
                target.setWellbeingEventLocationDetailsEventLocation(getEnumValue(wellbeingEventLocationDetailsType.getEventLocation()));
                target.setWellbeingEventLocationDetailsClass(getJAXBValue(wellbeingEventLocationDetailsType.getClazz()));
                target.setWellbeingEventLocationDetailsFurtherLocationNotes(getJAXBValue(wellbeingEventLocationDetailsType.getFurtherLocationNotes()));
            }

            PersonInvolvementListType personInvolvementList = getJAXBValue(source.getPersonInvolvementList());
            if (personInvolvementList != null && !personInvolvementList.getPersonInvolvement().isEmpty()) {
                List<WellbeingEventPersonInvolvement> personInvolvements = personInvolvementConverter.toHitsModelList(personInvolvementList.getPersonInvolvement());
                if (personInvolvements != null && !personInvolvements.isEmpty()) {
                    for (WellbeingEventPersonInvolvement personInvolvement : personInvolvements) {
                        personInvolvement.setWellbeingEvent(target);
                    }
                    target.getPersonInvolvements().addAll(personInvolvements);
                }
            }

            WellbeingDocumentListType documentList = getJAXBValue(source.getDocumentList());
            if (documentList != null && !documentList.getDocument().isEmpty()) {
                List<WellbeingEventDocument> documents = documentConverter.toHitsModelList(documentList.getDocument());
                if (documents != null && !documents.isEmpty()) {
                    for (WellbeingEventDocument document : documents) {
                        document.setWellbeingEvent(target);
                    }
                    target.getDocuments().addAll(documents);
                }
            }

            WellbeingEventCategoryListType categoryList = getJAXBValue(source.getWellbeingEventCategoryList());
            if (categoryList != null && !categoryList.getWellbeingEventCategory().isEmpty()) {
                List<WellbeingEventCategory> categories = categoryConverter.toHitsModelList(categoryList.getWellbeingEventCategory());
                if (categories != null && !categories.isEmpty()) {
                    for (WellbeingEventCategory category : categories) {
                        category.updateWellbeingEvent(target);
                    }
                    target.getCategories().addAll(categories);
                }
            }

            FollowUpActionListType followUpActionList = getJAXBValue(source.getFollowUpActionList());
            if (followUpActionList != null && !followUpActionList.getFollowUpAction().isEmpty()) {
                List<WellbeingEventFollowUpAction> followUpActions = followUpActionConverter.toHitsModelList(followUpActionList.getFollowUpAction());
                if (followUpActions != null && !followUpActions.isEmpty()) {
                    for (WellbeingEventFollowUpAction followUpAction : followUpActions) {
                        followUpAction.setWellbeingEvent(target);
                    }
                    target.getFollowUpActions().addAll(followUpActions);
                }
            }
        }
    }

    private boolean hasLocationDetails(WellbeingEvent source) {
        return source != null && (StringUtils.isNotBlank(source.getWellbeingEventLocationDetailsEventLocation())
                || StringUtils.isNotBlank(source.getWellbeingEventLocationDetailsClass()) || StringUtils.isNotBlank(source.getWellbeingEventLocationDetailsFurtherLocationNotes()));
    }

    private void resetModel(WellbeingEvent target) {
        target.setWellbeingEventLocationDetailsEventLocation(null);
        target.setWellbeingEventLocationDetailsClass(null);
        target.setWellbeingEventLocationDetailsFurtherLocationNotes(null);
        if (target.getCategories() == null) {
            target.setCategories(new ArrayList<WellbeingEventCategory>());
        }
        target.getCategories().clear();
        if (target.getFollowUpActions() == null) {
            target.setFollowUpActions(new ArrayList<WellbeingEventFollowUpAction>());
        }
        target.getFollowUpActions().clear();
        if (target.getPersonInvolvements() == null) {
            target.setPersonInvolvements(new ArrayList<WellbeingEventPersonInvolvement>());
        }
        target.getPersonInvolvements().clear();
        if (target.getDocuments() == null) {
            target.setDocuments(new ArrayList<WellbeingEventDocument>());
        }
        target.getDocuments().clear();
    }

}
