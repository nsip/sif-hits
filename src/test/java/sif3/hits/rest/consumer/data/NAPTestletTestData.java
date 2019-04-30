package sif3.hits.rest.consumer.data;

import sif.dd.au30.model.*;
import sif3.common.model.QueryCriteria;
import sif3.common.model.QueryOperator;
import sif3.common.model.QueryPredicate;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class NAPTestletTestData extends TestData<NAPTestletType, NAPTestletCollectionType> {

    public static final String REF_ID_1 = "e50fcb47-05f9-4834-ab81-f02ac41935d5";
    public static final String REF_ID_2 = "375f3027-13dc-4962-a8fc-3d32464af785";
    public static final String REF_ID_3 = "97c0e4ff-466f-4a43-be55-ce7ffd267557";
    public static final String REF_ID_4 = "9c2eaabb-649b-4d76-afc8-793bafdae945";
    public static final String REF_ID_5 = "d68fd4b2-2a21-4cce-82a5-fc132c3f7865";

    public static final String[] REF_ID_RA = {REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5};
    public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

    public static final String XML_REF_ID_1 = "55289a17-37ad-43f2-ab82-54ec45384a5b";
    public static final String XML_REF_ID_2 = "f5813033-6e34-4044-bf5f-534390d9afb4";

    public static final String[] XML_REF_ID_RA = {XML_REF_ID_1, XML_REF_ID_2};
    public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

    public static final String NAME = "NAPLAN Testlet";
    public static final String NODE = "A";
    public static final String MAXIMUM_SCORE = "32";
    public static final BigInteger LOCATION = BigInteger.ONE;
    public static final String LOCAL_ID = "local-id-ntl";


    public NAPTestletType getTestObject(String refId) {
        IObjectFactory objectFactory = getObjectFactory();
        NAPTestletType napTestletType = new NAPTestletType();
        napTestletType.setRefId(refId);
        napTestletType.setNAPTestRefId(objectFactory.createNAPTestletTypeNAPTestRefId(NAPTestTestData.REF_ID_1));
        napTestletType.setNAPTestLocalId(NAPTestTestData.LOCAL_ID_1);

        NAPTestletContentType napTestletContent = new NAPTestletContentType();
        napTestletContent.setTestletName(objectFactory.createNAPTestletContentTypeTestletName(NAME));
        napTestletContent.setNode(objectFactory.createNAPTestletContentTypeNode(NODE));
        napTestletContent.setTestletMaximumScore(new BigDecimal(MAXIMUM_SCORE));
        napTestletContent.setLocationInStage(objectFactory.createNAPTestletContentTypeLocationInStage(LOCATION));
        napTestletContent.setNAPTestletLocalId(LOCAL_ID);
        napTestletType.setTestletContent(napTestletContent);

        NAPTestItemListType napTestItemListType = new NAPTestItemListType();
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemTestData.REF_ID_1, NAPTestItemTestData.LOCAL_ID_1, 0));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemTestData.REF_ID_2, NAPTestItemTestData.LOCAL_ID_2, 1));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemTestData.REF_ID_3, NAPTestItemTestData.LOCAL_ID_3, 2));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemTestData.REF_ID_4, NAPTestItemTestData.LOCAL_ID_4, 3));
        napTestItemListType.getTestItem().add(getTestItem(NAPTestItemTestData.REF_ID_5, NAPTestItemTestData.LOCAL_ID_5, 4));
        napTestletType.setTestItemList(napTestItemListType);
        return napTestletType;
    }

    private NAPTestItem2Type getTestItem(String refId, String localId, int sequence) {
        NAPTestItem2Type testItem = new NAPTestItem2Type();
        testItem.setSequenceNumber(new BigInteger(Integer.toString(sequence)));
        testItem.setTestItemRefId(refId);
        testItem.setTestItemLocalId(localId);
        return testItem;
    }

    @Override
    public List<QueryCriteria> getServicePathQueries() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.addPredicate(new QueryPredicate("NAPTests", QueryOperator.EQUAL, NAPTestTestData.REF_ID_1));
        return Arrays.asList(queryCriteria);
    }

    @Override
    public boolean isServicePathObject(NAPTestletType object, int index) {
        return object != null && object.getNAPTestRefId() != null && NAPTestTestData.REF_ID_1.equals(object.getNAPTestRefId().getValue());
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

    public NAPTestletCollectionType getTestCollection(String... refIds) {
        NAPTestletCollectionType result = new NAPTestletCollectionType();
        for (int i = 0; refIds != null && i < refIds.length; i++) {
            result.getNAPTestlet().add(getTestObject(refIds[i]));
        }
        return result;
    }

    public String getSingleObjectXMLFilename() {
        return "NAPTestlet.xml";
    }

    public String getMultiObjectXMLFilename() {
        return "NAPTestlets.xml";
    }

}

