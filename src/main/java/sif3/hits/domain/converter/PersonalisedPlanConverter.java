package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsPersonalisedPlanType;
import sif.dd.au30.model.PersonalisedPlanType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PersonalisedPlan;
import sif3.hits.domain.model.PersonalisedPlanDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class PersonalisedPlanConverter extends HitsConverter<PersonalisedPlanType, PersonalisedPlan>
		implements UsesConstants {

	@Autowired
	PersonalisedPlanDocumentConverter documentConverter;

	public PersonalisedPlanConverter() {
		super(PersonalisedPlanType.class, PersonalisedPlan.class);
	}

	@Override
	public void toSifModel(PersonalisedPlan source, PersonalisedPlanType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setLocalId(objectFactory.createPersonalisedPlanTypeLocalId(source.getLocalId()));
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setPersonalisedPlanCategory(
					getEnumValue(source.getPersonalisedPlanCategory(), AUCodeSetsPersonalisedPlanType.class));
			target.setPersonalisedPlanStartDate(getDateValue(source.getPersonalisedPlanStartDate()));
			target.setPersonalisedPlanEndDate(objectFactory.createPersonalisedPlanTypePersonalisedPlanEndDate(
					getDateValue(source.getPersonalisedPlanEndDate())));
			target.setPersonalisedPlanReviewDate(objectFactory.createPersonalisedPlanTypePersonalisedPlanReviewDate(
					getDateValue(source.getPersonalisedPlanReviewDate())));
			target.setPersonalisedPlanNotes(
					objectFactory.createPersonalisedPlanTypePersonalisedPlanNotes(source.getPersonalisedPlanNotes()));
			target.setAssociatedAttachment(
					objectFactory.createPersonalisedPlanTypeAssociatedAttachment(source.getAssociatedAttachment()));
			List<WellbeingDocumentType> wellbeingDocuments = documentConverter.toSifModelList(source.getDocuments());
			if (wellbeingDocuments != null && !wellbeingDocuments.isEmpty()) {
				WellbeingDocumentListType wellbeingDocumentList = objectFactory.createWellbeingDocumentListType();
				wellbeingDocumentList.getDocument().addAll(wellbeingDocuments);
				target.setDocumentList(objectFactory.createPersonalisedPlanTypeDocumentList(wellbeingDocumentList));
			}
		}
	}

	@Override
	public void toHitsModel(PersonalisedPlanType source, PersonalisedPlan target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setPersonalisedPlanCategory(getEnumValue(source.getPersonalisedPlanCategory()));
			target.setPersonalisedPlanStartDate(getDateValue(source.getPersonalisedPlanStartDate()));
			target.setPersonalisedPlanEndDate(getDateValue(getJAXBValue(source.getPersonalisedPlanEndDate())));
			target.setPersonalisedPlanReviewDate(getDateValue(getJAXBValue(source.getPersonalisedPlanReviewDate())));
			target.setPersonalisedPlanNotes(getJAXBValue(source.getPersonalisedPlanNotes()));
			target.setAssociatedAttachment(getJAXBValue(source.getAssociatedAttachment()));
			if (target.getDocuments() == null) {
				target.setDocuments(new ArrayList<PersonalisedPlanDocument>());
			}
			target.getDocuments().clear();
			WellbeingDocumentListType documentList = getJAXBValue(source.getDocumentList());
			if (documentList != null && !documentList.getDocument().isEmpty()) {
				List<PersonalisedPlanDocument> wellbeingDocuments = documentConverter
						.toHitsModelList(documentList.getDocument());
				if (wellbeingDocuments != null && !wellbeingDocuments.isEmpty()) {
					for (PersonalisedPlanDocument document : wellbeingDocuments) {
						document.setPersonalisedPlan(target);
					}
				}
				target.getDocuments().addAll(wellbeingDocuments);
			}
		}
	}
}
