package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AUCodeSetsWellbeingAppealStatusType;
import sif.dd.au30.model.WellbeingAppealCollectionType;
import sif.dd.au30.model.WellbeingAppealType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class WellbeingAppealTestData extends TestData<WellbeingAppealType,WellbeingAppealCollectionType> {

    public static final String REF_ID_1 = "9ba1bb94-ceb0-4829-9abb-a71ae1dc232d";
    public static final String REF_ID_2 = "e38e467f-896f-42c3-b773-adfba0b8c6de";
    public static final String REF_ID_3 = "1ad7f483-1524-4a34-a07e-cbbfd4f76aa9";
    public static final String REF_ID_4 = "89f0c96f-d6ec-408e-ada2-7e6e14738fdb";
    public static final String REF_ID_5 = "84241f93-f15c-40d6-9aee-a9da6cb0aabd";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "9cfd16a7-8c4f-4d79-8132-6341fc40663c";
    public static final String XML_REF_ID_2 = "922ff172-70c6-4b0e-8334-bf90da2a4808";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public WellbeingAppealType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        WellbeingAppealType wellbeingAppealType = objectFactory.createWellbeingAppealType();
        wellbeingAppealType.setRefId(refId);
        wellbeingAppealType.setStudentPersonalRefId(StudentPersonalTestData.REF_ID_1);
        wellbeingAppealType.setSchoolInfoRefId(SchoolInfoTestData.REF_ID_1);
        wellbeingAppealType.setWellbeingResponseRefId(WellbeingResponseTestData.REF_ID_1);
        wellbeingAppealType.setLocalAppealId(objectFactory.createWellbeingAppealTypeLocalAppealId("AP-0324411"));
        wellbeingAppealType.setAppealStatusCode(objectFactory.createWellbeingAppealTypeAppealStatusCode(AUCodeSetsWellbeingAppealStatusType.N));
        wellbeingAppealType.setDate(objectFactory.createWellbeingAppealTypeDate(getDate("2018-02-22")));
        wellbeingAppealType.setAppealNotes(objectFactory.createWellbeingAppealTypeAppealNotes("Notes about the appeal."));
        wellbeingAppealType.setAppealOutcome(objectFactory.createWellbeingAppealTypeAppealOutcome("Appeal outcome.s"));

        WellbeingDocumentListType wellbeingDocumentListType = objectFactory.createWellbeingDocumentListType();
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(1));
        wellbeingDocumentListType.getDocument().add(getWellbeingDocument(2));
        wellbeingAppealType.setDocumentList(objectFactory.createWellbeingAppealTypeDocumentList(wellbeingDocumentListType));
        return wellbeingAppealType;
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

    public WellbeingAppealCollectionType getTestCollection(String... refIds) {
        WellbeingAppealCollectionType result = new WellbeingAppealCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getWellbeingAppeal().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "WellbeingAppeal.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "WellbeingAppeals.xml";
    }

}

