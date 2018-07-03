package sif3.hits.rest.consumer;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.NAPTestConsumerTest.NAPTestRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPCodeFrameConsumerTest extends BaseTest {
    private ConsumerTest<NAPCodeFrameType, NAPCodeFrameCollectionType> codeFrameTester = null;

    public static class NAPCodeFrameRefIds {
        public static String REF_ID_1 = "d8192e3e-3fc2-4c91-adde-2beca7a09fba";
        public static String REF_ID_2 = "75eb2fc1-1add-4622-829c-64824074d86b";
        public static String REF_ID_3 = "d6dfd045-1553-4490-a0f0-2576efa92f52";
        public static String REF_ID_4 = "d6490818-2af4-4ee0-be31-7ffb4bc0ddfe";
        public static String REF_ID_5 = "8687591e-72f1-4433-9a0d-7ae5113d53b9";
    }

    private final String REF_ID_1 = "81fc94d7-c2d1-4a32-af5f-a0ab7c36ee99";
    private final String REF_ID_2 = "d9a48489-bb2f-4171-a334-cb3226607d0d";
    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        NAPCodeFrameType codeFrame = new NAPCodeFrameType();
        codeFrame.setRefId(NAPCodeFrameRefIds.REF_ID_1);
        codeFrame.setNAPTestRefId(NAPTestRefIds.REF_ID_1);
        codeFrameTester.doCreateOne(codeFrame);

        codeFrame.setRefId(NAPCodeFrameRefIds.REF_ID_2);
        codeFrame.setNAPTestRefId(NAPTestRefIds.REF_ID_2);
        codeFrameTester.doCreateOne(codeFrame);

        codeFrame.setRefId(NAPCodeFrameRefIds.REF_ID_3);
        codeFrame.setNAPTestRefId(NAPTestRefIds.REF_ID_3);
        codeFrameTester.doCreateOne(codeFrame);

        codeFrame.setRefId(NAPCodeFrameRefIds.REF_ID_4);
        codeFrame.setNAPTestRefId(NAPTestRefIds.REF_ID_4);
        codeFrameTester.doCreateOne(codeFrame);

        codeFrame.setRefId(NAPCodeFrameRefIds.REF_ID_5);
        codeFrame.setNAPTestRefId(NAPTestRefIds.REF_ID_5);
        codeFrameTester.doCreateOne(codeFrame);

        NAPCodeFrameType getResult = codeFrameTester.doGetOne(NAPCodeFrameRefIds.REF_ID_1);
        Assert.assertNotNull(getResult);
        Assert.assertNotNull(getResult.getTestContent());
        Assert.assertNotNull(getResult.getTestContent().getNAPTestLocalId());
        Assert.assertNotNull(getResult.getTestletList());
        Assert.assertNotNull(getResult.getTestletList().getTestlet());
        Assert.assertEquals(5, getResult.getTestletList().getTestlet().size());
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        codeFrameTester = new ConsumerTest<NAPCodeFrameType, NAPCodeFrameCollectionType>(NAPCodeFrameType.class, "NAPCodeFrame", NAPCodeFrameCollectionType.class, "NAPCodeFrames");
        codeFrameTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        NAPCodeFrameType codeFrame = new NAPCodeFrameType();
        codeFrame.setNAPTestRefId(NAPTestRefIds.REF_ID_1);
        List<Response> responses = codeFrameTester.testQBE(codeFrame, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());

        Response response = responses.get(0);
        NAPCodeFrameCollectionType codeFrames = (NAPCodeFrameCollectionType) response.getDataObject();
        Assert.assertNotNull(codeFrames.getNAPCodeFrame());
        Assert.assertFalse(codeFrames.getNAPCodeFrame().isEmpty());
        boolean found = false;
        for (NAPCodeFrameType codeFrameType : codeFrames.getNAPCodeFrame()) {
            found = found || NAPCodeFrameRefIds.REF_ID_1.equals(codeFrameType.getRefId());
            Assert.assertEquals(NAPTestRefIds.REF_ID_1, codeFrameType.getNAPTestRefId());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = codeFrameTester.testGetSingle(NAPCodeFrameRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPCodeFrameType napCodeFrameType = (NAPCodeFrameType) response.getDataObject();
        Assert.assertEquals(NAPCodeFrameRefIds.REF_ID_1, napCodeFrameType.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = codeFrameTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        NAPCodeFrameCollectionType napCodeFrameCollectionType = (NAPCodeFrameCollectionType) response.getDataObject();
        Assert.assertNotNull(napCodeFrameCollectionType.getNAPCodeFrame());
        Assert.assertEquals(5, napCodeFrameCollectionType.getNAPCodeFrame().size());
    }
}