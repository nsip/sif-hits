package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class WellbeingCharacteristicTestData extends TestData<WellbeingCharacteristicType, WellbeingCharacteristicCollectionType> {

    public static final String REF_ID_1 = "3f5509c6-df0c-461f-9cf9-fad9a7d104f5";
    public static final String REF_ID_2 = "45612864-15c5-405e-891e-e02d86b61f63";
    public static final String REF_ID_3 = "dafaf1f0-2677-4bec-b37e-e584b830ed40";
    public static final String REF_ID_4 = "98c438d0-34ef-4769-b3d2-98d907762cbd";
    public static final String REF_ID_5 = "b9c03b32-b907-4627-ba1b-88e3946416bb";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "e729ac6f-d9e1-4b53-aca4-9e871d1e16cb";
    public static final String XML_REF_ID_2 = "5f26e066-b5c1-45f0-af85-6d848180a6e5";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public WellbeingCharacteristicType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        WellbeingCharacteristicType wellbeingCharacteristicType = objectFactory.createWellbeingCharacteristicType();
        wellbeingCharacteristicType.setRefId(refId);
        wellbeingCharacteristicType.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        wellbeingCharacteristicType.setSchoolInfoRefId(objectFactory.createWellbeingCharacteristicTypeSchoolInfoRefId(SchoolInfoTestData.REF_ID_1));
        wellbeingCharacteristicType.setWellbeingCharacteristicClassification(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicClassification(AUCodeSetsWellbeingCharacteristicClassificationType.D));
        wellbeingCharacteristicType.setWellbeingCharacteristicStartDate(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicStartDate(getDate("2018-03-23")));
        wellbeingCharacteristicType.setWellbeingCharacteristicEndDate(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicEndDate(getDate("2018-04-01")));
        wellbeingCharacteristicType.setWellbeingCharacteristicReviewDate(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicReviewDate(getDate("2018-03-29")));
        wellbeingCharacteristicType.setWellbeingCharacteristicNotes(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicNotes("Notes go Here"));
        wellbeingCharacteristicType.setWellbeingCharacteristicCategory(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicCategory("Cat"));
        wellbeingCharacteristicType.setWellbeingCharacteristicSubCategory(objectFactory.createWellbeingCharacteristicTypeWellbeingCharacteristicSubCategory("SubCat"));
        wellbeingCharacteristicType.setLocalCharacteristicCode(objectFactory.createWellbeingCharacteristicTypeLocalCharacteristicCode("LocalCode"));
        wellbeingCharacteristicType.setCharacteristicSeverity(objectFactory.createWellbeingCharacteristicTypeCharacteristicSeverity("Severe"));
        wellbeingCharacteristicType.setDailyManagement(objectFactory.createWellbeingCharacteristicTypeDailyManagement("Y"));
        wellbeingCharacteristicType.setEmergencyManagement(objectFactory.createWellbeingCharacteristicTypeEmergencyManagement("N"));
        wellbeingCharacteristicType.setEmergencyResponsePlan(objectFactory.createWellbeingCharacteristicTypeEmergencyResponsePlan("ERP"));
        wellbeingCharacteristicType.setTrigger(objectFactory.createWellbeingCharacteristicTypeTrigger("Trigger"));
        wellbeingCharacteristicType.setConfidentialFlag(objectFactory.createWellbeingCharacteristicTypeConfidentialFlag(AUCodeSetsYesOrNoCategoryType.N));
        wellbeingCharacteristicType.setAlert(objectFactory.createWellbeingCharacteristicTypeAlert(AUCodeSetsYesOrNoCategoryType.N));

        WellbeingDocumentListType wellbeingDocumentListType = objectFactory.createWellbeingDocumentListType();
        wellbeingCharacteristicType.setDocumentList(objectFactory.createWellbeingCharacteristicTypeDocumentList(wellbeingDocumentListType));
        MedicationListType medicationListType = objectFactory.createMedicationListType();
        wellbeingCharacteristicType.setMedicationList(objectFactory.createWellbeingCharacteristicTypeMedicationList(medicationListType));
        for (int i = 1; i < 3; i++) {
            wellbeingDocumentListType.getDocument().add(getWellbeingDocument(i));

            MedicationType medicationType = objectFactory.createMedicationType();
            medicationType.setMedicationName(objectFactory.createMedicationTypeMedicationName("Medication " + i));
            medicationType.setDosage(objectFactory.createMedicationTypeDosage(i + "0mg"));
            medicationType.setFrequency(objectFactory.createMedicationTypeFrequency("Daily"));
            medicationType.setAdministrationInformation(objectFactory.createMedicationTypeAdministrationInformation("Take once daily."));
            medicationType.setMethod(objectFactory.createMedicationTypeMethod("Oral"));
            medicationListType.getMedication().add(medicationType);
        }
        return wellbeingCharacteristicType;

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

    public WellbeingCharacteristicCollectionType getTestCollection(String... refIds) {
        WellbeingCharacteristicCollectionType result = new WellbeingCharacteristicCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getWellbeingCharacteristic().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "WellbeingCharacteristic.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "WellbeingCharacteristics.xml";
    }

}

