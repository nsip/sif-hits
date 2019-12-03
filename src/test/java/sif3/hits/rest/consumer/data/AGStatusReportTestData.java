package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class AGStatusReportTestData extends TestData<AGStatusReportType, AGStatusReportCollectionType> {

    public static final String REF_ID_1 = "b23dcd42-56c6-4ca3-802b-4d842c13fb61";
    public static final String REF_ID_2 = "ac7949dd-2d86-4172-a294-e91129902731";
    public static final String REF_ID_3 = "795a9c6b-b9c5-48e9-9c5c-dd57afed08f0";
    public static final String REF_ID_4 = "67d5f96e-a0be-4b43-a5a3-c673a5a95528";
    public static final String REF_ID_5 = "ecee092f-165f-4d07-8ceb-b52f4126edb9";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "4d02b543-30e1-4ac5-985c-5a5f4ab22ab8";
    public static final String XML_REF_ID_2 = "6bc19b55-dfa0-489b-83e3-75490d4200d3";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String ASR_ROR_SIF_REFID = "4f37559c-a093-47fe-a1c6-d546e1ca8e0";
    public static final String ASR_ROR_SUB_REFID = "78547278-58f5-4358-95f4-d6a04951a52";

    public AGStatusReportType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        AGStatusReportType agStatusReport = objectFactory.createAGStatusReportType();
        agStatusReport.setRefId(refId);
        agStatusReport.setReportingAuthority("Reporting Authority");
        agStatusReport.setReportingAuthoritySystem(objectFactory.createAGStatusReportTypeReportingAuthoritySystem("Reporting Authority System"));
        agStatusReport.setReportingAuthorityCommonwealthId(objectFactory.createAGStatusReportTypeReportingAuthorityCommonwealthId("RACID - 1"));
        agStatusReport.setSubmittedBy(objectFactory.createAGStatusReportTypeSubmittedBy("Submitted By"));
        agStatusReport.setSubmissionTimestamp(objectFactory.createAGStatusReportTypeSubmissionTimestamp(getCalendar("2019-04-01T18:23:00Z")));
        agStatusReport.setAGCollection(objectFactory.createAGStatusReportTypeAGCollection("Collection"));
        agStatusReport.setCollectionYear(getDate("2019"));

        AGReportingObjectResponseListType agReportingObjectResponseListType = objectFactory.createAGReportingObjectResponseListType();
        agReportingObjectResponseListType.getAGReportingObjectResponse().add(getAGReportingObjectResponse(1));
        agReportingObjectResponseListType.getAGReportingObjectResponse().add(getAGReportingObjectResponse(2));
        agStatusReport.setAGReportingObjectResponseList(objectFactory.createAGStatusReportTypeAGReportingObjectResponseList(agReportingObjectResponseListType));

        return agStatusReport;
    }

    private AGReportingObjectResponseType getAGReportingObjectResponse(int index) {
        IObjectFactory objectFactory = getObjectFactory();
        AGReportingObjectResponseType objectResponseType = objectFactory.createAGReportingObjectResponseType();
        objectResponseType.setCommonwealthId("cid-" + index);
        objectResponseType.setEntityName(objectFactory.createAGReportingObjectResponseTypeEntityName("Entity Name " + index));
        objectResponseType.setAGSubmissionStatusCode(getValue(AUCodeSetsAGSubmissionStatusType.values(), index));
        objectResponseType.setErrorText(objectFactory.createAGReportingObjectResponseTypeErrorText("Error " + index));
        objectResponseType.setHTTPStatusCode(objectFactory.createAGReportingObjectResponseTypeHTTPStatusCode("20" + index));
        objectResponseType.setSIFRefId(objectFactory.createAGReportingObjectResponseTypeSIFRefId(ASR_ROR_SIF_REFID + index));
        objectResponseType.setSubmittedRefId(objectFactory.createAGReportingObjectResponseTypeSubmittedRefId(ASR_ROR_SUB_REFID + index));

        AGRuleListType agRuleListType = objectFactory.createAGRuleListType();
        agRuleListType.getAGRule().add(getAGRuleType(index, 1));
        agRuleListType.getAGRule().add(getAGRuleType(index, 2));
        objectResponseType.setAGRuleList(objectFactory.createAGReportingObjectResponseTypeAGRuleList(agRuleListType));

        return objectResponseType;
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

    public AGStatusReportCollectionType getTestCollection(String... refIds) {
        AGStatusReportCollectionType result = new AGStatusReportCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getAGStatusReport().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "AGStatusReport.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "AGStatusReports.xml";
    }

}

