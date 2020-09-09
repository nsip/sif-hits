package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.StudentAttendanceCollectionCollectionType;
import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class StudentAttendanceCollectionTestData extends TestData<StudentAttendanceCollectionType,StudentAttendanceCollectionCollectionType> {

    public static final String REF_ID_1 = "7bb07851-dcb8-4d59-845c-daeb0779147a";
    public static final String REF_ID_2 = "ea246c6a-2c68-43da-a7e7-f8990abc3da9";
    public static final String REF_ID_3 = "45baa993-f6da-44d7-837b-ab792dccc854";
    public static final String REF_ID_4 = "1f756698-39b0-4fab-b2ac-3355f12b4ca9";
    public static final String REF_ID_5 = "460b4709-eab4-45ae-b2ec-5908fa1fbb7e";

    public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "d7ac3be9-1f5d-4e75-9965-aca18822fae1";
    public static final String XML_REF_ID_2 = "69430a65-22fb-4a38-a9f1-a23600790e38";

    public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    
    public StudentAttendanceCollectionType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        StudentAttendanceCollectionType studentAttendanceCollection = new StudentAttendanceCollectionType();
        
        return studentAttendanceCollection;
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

    public StudentAttendanceCollectionCollectionType getTestCollection(String... refIds) {
        StudentAttendanceCollectionCollectionType result = new StudentAttendanceCollectionCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getStudentAttendanceCollection().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "StudentAttendanceCollection.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "StudentAttendanceCollections.xml";
    }

}

