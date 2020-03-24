package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsWellbeingCharacteristicClassificationType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.MedicationListType;
import sif.dd.au30.model.MedicationType;
import sif.dd.au30.model.SymptomListType;
import sif.dd.au30.model.WellbeingCharacteristicType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingCharacteristic;
import sif3.hits.domain.model.WellbeingCharacteristicDocument;
import sif3.hits.domain.model.WellbeingCharacteristicMedication;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingCharacteristicConverter
		extends HitsConverter<WellbeingCharacteristicType, WellbeingCharacteristic> implements UsesConstants {

	@Autowired
	WellbeingCharacteristicDocumentConverter documentConverter;

	@Autowired
	WellbeingCharacteristicMedicationConverter medicationConverter;

	public WellbeingCharacteristicConverter() {
		super(WellbeingCharacteristicType.class, WellbeingCharacteristic.class);
	}

	@Override
	public void toSifModel(WellbeingCharacteristic source, WellbeingCharacteristicType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setLocalId(objectFactory.createWellbeingCharacteristicTypeLocalId(source.getLocalId()));
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(
					objectFactory.createWellbeingCharacteristicTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
			target.setWellbeingCharacteristicClassification(
					objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicClassification(getEnumValue(
							source.getClassification(), AUCodeSetsWellbeingCharacteristicClassificationType.class)));
			target.setWellbeingCharacteristicStartDate(
					objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicStartDate(
							getDateValue(source.getStartDate())));
			target.setWellbeingCharacteristicEndDate(
					objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicEndDate(
							getDateValue(source.getEndDate())));
			target.setWellbeingCharacteristicReviewDate(
					objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicReviewDate(
							getDateValue(source.getReviewDate())));
			target.setWellbeingCharacteristicNotes(
					objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicNotes(source.getNotes()));
			target.setWellbeingCharacteristicCategory(objectFactory
					.createWellbeingCharacteristicTypeWellbeingCharacteristicCategory(source.getCategory()));
			target.setWellbeingCharacteristicSubCategory(objectFactory
					.createWellbeingCharacteristicTypeWellbeingCharacteristicSubCategory(source.getSubcategory()));
			target.setLocalCharacteristicCode(objectFactory
					.createWellbeingCharacteristicTypeLocalCharacteristicCode(source.getLocalCharacteristicCode()));
			target.setCharacteristicSeverity(objectFactory
					.createWellbeingCharacteristicTypeCharacteristicSeverity(source.getCharacteristicSeverity()));
			target.setDailyManagement(
					objectFactory.createWellbeingCharacteristicTypeDailyManagement(source.getDailyManagement()));
			target.setEmergencyManagement(objectFactory
					.createWellbeingCharacteristicTypeEmergencyManagement(source.getEmergencyManagement()));
			target.setEmergencyResponsePlan(objectFactory
					.createWellbeingCharacteristicTypeEmergencyResponsePlan(source.getEmergencyResponsePlan()));
			target.setTrigger(objectFactory.createWellbeingCharacteristicTypeTrigger(source.getTrigger()));
			target.setConfidentialFlag(objectFactory.createWellbeingCharacteristicTypeConfidentialFlag(
					getEnumValue(source.getConfidentialFlag(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setAlert(objectFactory.createWellbeingCharacteristicTypeAlert(
					getEnumValue(source.getAlert(), AUCodeSetsYesOrNoCategoryType.class)));

			if (source.getDocuments() != null && !source.getDocuments().isEmpty()) {
				List<WellbeingDocumentType> documents = documentConverter.toSifModelList(source.getDocuments());
				if (documents != null && !documents.isEmpty()) {
					WellbeingDocumentListType documentList = objectFactory.createWellbeingDocumentListType();
					documentList.getDocument().addAll(documents);
					target.setDocumentList(objectFactory.createWellbeingCharacteristicTypeDocumentList(documentList));
				}
			}
			if (source.getMedication() != null && !source.getMedication().isEmpty()) {
				List<MedicationType> medications = medicationConverter.toSifModelList(source.getMedication());
				if (medications != null && !medications.isEmpty()) {
					MedicationListType medicationList = objectFactory.createMedicationListType();
					medicationList.getMedication().addAll(medications);
					target.setMedicationList(
							objectFactory.createWellbeingCharacteristicTypeMedicationList(medicationList));
				}
			}
			if (source.getSymptoms() != null && !source.getSymptoms().isEmpty()) {
				SymptomListType symptomList = objectFactory.createSymptomListType();
				symptomList.getSymptom().addAll(source.getSymptoms());
				target.setSymptomList(objectFactory.createWellbeingCharacteristicTypeSymptomList(symptomList));
			}
		}

	}

	@Override
	public void toHitsModel(WellbeingCharacteristicType source, WellbeingCharacteristic target) {
		if (source != null && target != null) {
			resetModel(target);

			target.setRefId(source.getRefId());
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
			target.setClassification(getJAXBEnumValue(source.getWellbeingCharacteristicClassification()));
			target.setStartDate(getDateValue(getJAXBValue(source.getWellbeingCharacteristicStartDate())));
			target.setEndDate(getDateValue(getJAXBValue(source.getWellbeingCharacteristicEndDate())));
			target.setReviewDate(getDateValue(getJAXBValue(source.getWellbeingCharacteristicReviewDate())));
			target.setNotes(getJAXBValue(source.getWellbeingCharacteristicNotes()));
			target.setCategory(getJAXBValue(source.getWellbeingCharacteristicCategory()));
			target.setSubcategory(getJAXBValue(source.getWellbeingCharacteristicSubCategory()));
			target.setLocalCharacteristicCode(getJAXBValue(source.getLocalCharacteristicCode()));
			target.setCharacteristicSeverity(getJAXBValue(source.getCharacteristicSeverity()));
			target.setDailyManagement(getJAXBValue(source.getDailyManagement()));
			target.setEmergencyManagement(getJAXBValue(source.getEmergencyManagement()));
			target.setEmergencyResponsePlan(getJAXBValue(source.getEmergencyResponsePlan()));
			target.setTrigger(getJAXBValue(source.getTrigger()));
			target.setConfidentialFlag(getJAXBEnumValue(source.getConfidentialFlag()));
			target.setAlert(getJAXBEnumValue(source.getAlert()));

			WellbeingDocumentListType documentList = getJAXBValue(source.getDocumentList());
			if (documentList != null && !documentList.getDocument().isEmpty()) {
				List<WellbeingCharacteristicDocument> documents = documentConverter
						.toHitsModelList(documentList.getDocument());
				if (documents != null && !documents.isEmpty()) {
					for (WellbeingCharacteristicDocument document : documents) {
						document.setWellbeingCharacteristic(target);
					}
					target.getDocuments().addAll(documents);
				}
			}
			MedicationListType medicationList = getJAXBValue(source.getMedicationList());
			if (medicationList != null && !medicationList.getMedication().isEmpty()) {
				List<WellbeingCharacteristicMedication> medications = medicationConverter
						.toHitsModelList(medicationList.getMedication());
				if (medications != null && !medications.isEmpty()) {
					for (WellbeingCharacteristicMedication medication : medications) {
						medication.setWellbeingCharacteristic(target);
					}
					target.getMedication().addAll(medications);
				}
			}

			if (target.getSymptoms() == null)
				target.setSymptoms(new ArrayList<>());
			target.getSymptoms().clear();
			SymptomListType symptomList = getJAXBValue(source.getSymptomList());
			if (symptomList != null) {
				target.getSymptoms().addAll(symptomList.getSymptom());
			}
		}
	}

	private void resetModel(WellbeingCharacteristic target) {
		if (target.getMedication() == null) {
			target.setMedication(new ArrayList<WellbeingCharacteristicMedication>());
		}
		target.getMedication().clear();

		if (target.getDocuments() == null) {
			target.setDocuments(new ArrayList<WellbeingCharacteristicDocument>());
		}
		target.getDocuments().clear();
	}

}
