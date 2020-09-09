package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.CollectionStatusCollectionType;
import sif.dd.au30.model.CollectionStatusType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class CollectionStatusTestData extends TestData<CollectionStatusType,CollectionStatusCollectionType> {

    public static final String REF_ID_1 = "fab9478f-52ed-46bd-94c2-7a1d72af88e3";
    public static final String REF_ID_2 = "a3590c35-58b2-4809-9910-e8446b2bc708";
    public static final String REF_ID_3 = "b2de9c1d-337a-43eb-b6ad-b0918f5d24b5";
    public static final String REF_ID_4 = "6369892b-0a7b-4ea6-a17a-5c051c7b8bde";
    public static final String REF_ID_5 = "c21b7d75-3646-4e5f-a459-51d5fd582b95";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "ad8550d9-cada-43ff-813d-d2dd2946789f";
    public static final String XML_REF_ID_2 = "344362a8-91b2-4687-a570-9607ce637bf1";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    
    public CollectionStatusType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        CollectionStatusType collectionStatus = new CollectionStatusType();
        collectionStatus.setRefId(refId);
        
        return collectionStatus;
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

    public CollectionStatusCollectionType getTestCollection(String... refIds) {
        CollectionStatusCollectionType result = new CollectionStatusCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getCollectionStatus().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "CollectionStatus.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "CollectionStatuss.xml";
    }

}

