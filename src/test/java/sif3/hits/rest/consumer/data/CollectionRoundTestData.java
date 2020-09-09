package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.CollectionRoundCollectionType;
import sif.dd.au30.model.CollectionRoundType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class CollectionRoundTestData extends TestData<CollectionRoundType,CollectionRoundCollectionType> {

    public static final String REF_ID_1 = "25cf1701-5df6-48e0-bb11-896646fde307";
    public static final String REF_ID_2 = "4a8311df-ba0e-440a-b659-d285a3795c67";
    public static final String REF_ID_3 = "e4c6a2fd-7b57-4997-bc64-323abed231cf";
    public static final String REF_ID_4 = "0ac6f634-3059-47b4-aa81-39c727fb268a";
    public static final String REF_ID_5 = "731d5fca-b8a6-4d83-852b-5e0ba1f17f23";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "9336bb8c-729f-482a-87f5-b495862e1ef9";
    public static final String XML_REF_ID_2 = "a081f37a-d096-44fa-9a60-37decd372109";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    
    public CollectionRoundType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();

        CollectionRoundType collectionRound = new CollectionRoundType();
        collectionRound.setRefId(refId);
        
        return collectionRound;
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

    public CollectionRoundCollectionType getTestCollection(String... refIds) {
        CollectionRoundCollectionType result = new CollectionRoundCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getCollectionRound().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "CollectionRound.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "CollectionRounds.xml";
    }

}

