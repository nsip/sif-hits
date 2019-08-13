package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.hits.utils.RefIdGenerator;

import java.util.Arrays;
import java.util.List;

public class NAPCodeFrameTestData extends TestData<NAPCodeFrameType, NAPCodeFrameCollectionType> {

    public static final String REF_ID_1 = "d1cd2c84-0dca-4312-b6c5-2435a52bf7ab";
    public static final String REF_ID_2 = "401db1ad-603c-417c-bc10-c9ee9535d1eb";
    public static final String REF_ID_3 = "da9ef8b4-0e47-4c7e-b7d3-39a07fdb19f8";
    public static final String REF_ID_4 = "8ba62859-ae81-4840-8462-426d272d9a11";
    public static final String REF_ID_5 = "0b56b9d9-0108-4ed7-a4a9-27b2a9311ea7";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "c455c1bb-37d7-4668-b4db-4000e121fdcc";
    public static final String XML_REF_ID_2 = "5d1900cc-d733-4fc3-95ce-f2e4fbe87af3";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public NAPCodeFrameType getTestObject(String refId) {
        return null;
    }

    @Override
    public List<NAPCodeFrameType> getExamplesForQuery() {
        NAPCodeFrameType napCodeFrame = new NAPCodeFrameType();
        napCodeFrame.setNAPTestRefId(NAPTestTestData.REF_ID_1);
        return Arrays.asList(napCodeFrame);
    }

    @Override
    public boolean isExampleObject(NAPCodeFrameType object, int index) {
        return object != null && NAPTestTestData.REF_ID_1.equals(object.getNAPTestRefId());
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

    public NAPCodeFrameCollectionType getTestCollection(String... refIds) {
        NAPCodeFrameCollectionType result = new NAPCodeFrameCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPCodeFrame().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPCodeFrame.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPCodeFrames.xml";
    }

}

