package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.LibraryPatronStatusCollectionType;
import sif.dd.au30.model.LibraryPatronStatusType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class LibraryPatronStatusTestData extends TestData<LibraryPatronStatusType,LibraryPatronStatusCollectionType> {

    public static final String REF_ID_1 = "c6491c2f-07c1-4e90-b786-0ea770153eed";
    public static final String REF_ID_2 = "0377edcb-962e-49a6-bd76-8e160d3884f4";
    public static final String REF_ID_3 = "a28225e4-b022-45c8-982e-32543bd42286";
    public static final String REF_ID_4 = "f113ad7b-b6f2-4fe0-9259-eaa91d08f07e";
    public static final String REF_ID_5 = "6fb23c5e-a314-4009-83d9-36f51d19e8ea";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "40b1fe54-2587-4556-9222-91579eca1584";
    public static final String XML_REF_ID_2 = "09fa1978-0cb8-48a5-afc1-1151eda2df21";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    
    public LibraryPatronStatusType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        LibraryPatronStatusType libraryPatronStatus = new LibraryPatronStatusType();
        libraryPatronStatus.setRefId(refId);
        
        return libraryPatronStatus;
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

    public LibraryPatronStatusCollectionType getTestCollection(String... refIds) {
        LibraryPatronStatusCollectionType result = new LibraryPatronStatusCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getLibraryPatronStatus().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "LibraryPatronStatus.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "LibraryPatronStatuss.xml";
    }

}

