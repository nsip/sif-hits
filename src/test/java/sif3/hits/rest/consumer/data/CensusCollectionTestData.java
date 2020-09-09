package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.CensusCollectionCollectionType;
import sif.dd.au30.model.CensusCollectionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class CensusCollectionTestData extends TestData<CensusCollectionType,CensusCollectionCollectionType> {

    public static final String REF_ID_1 = "10cb49e5-7b4b-4c18-957d-cce314581abd";
    public static final String REF_ID_2 = "4d8b4aa6-5510-444e-9149-ea46d287aaa4";
    public static final String REF_ID_3 = "0283cf47-9f69-4452-b0ff-99ea9d979d06";
    public static final String REF_ID_4 = "8415f139-df4d-4710-bb09-467e90281911";
    public static final String REF_ID_5 = "f28249a0-2075-483e-a861-fe12d054b6b9";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "c1d64890-c1b2-4d84-863a-db72a7eda67e";
    public static final String XML_REF_ID_2 = "129d9b09-683a-431f-9012-25506cb96c7e";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    
    public CensusCollectionType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        CensusCollectionType censusCollection = new CensusCollectionType();

        return censusCollection;
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

    public CensusCollectionCollectionType getTestCollection(String... refIds) {
        CensusCollectionCollectionType result = new CensusCollectionCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getCensusCollection().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "CensusCollection.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "CensusCollections.xml";
    }

}

