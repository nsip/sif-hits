package sif3.hits.rest.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.hits.rest.consumer.data.NAPCodeFrameTestData;
import sif3.hits.rest.consumer.data.NAPTestTestData;
import sif3.infra.rest.consumer.ConsumerLoader;

public class NAPCodeFrameConsumerTest extends BaseTest<NAPCodeFrameType, NAPCodeFrameCollectionType> {
	private ConsumerTest<NAPCodeFrameType, NAPCodeFrameCollectionType> codeFrameTester = null;
	private NAPCodeFrameTestData testData = new NAPCodeFrameTestData();

	@Before
	public void setup() {
		ConsumerLoader.initialise(CONSUMER);
		codeFrameTester = new ConsumerTest<>(NAPCodeFrameType.class, "NAPCodeFrame", NAPCodeFrameCollectionType.class,
				"NAPCodeFrames");
	}

	@Override
	public ConsumerTest<NAPCodeFrameType, NAPCodeFrameCollectionType> getTester() {
		return codeFrameTester;
	}

	@Override
	public NAPCodeFrameTestData getTestData() {
		return testData;
	}

	@Override
	public String getRefId(NAPCodeFrameType object) {
		return object.getRefId();
	}

	@Override
	public void setRefId(NAPCodeFrameType object, String refId) {
		object.setRefId(refId);
	}

	@Override
	public List<NAPCodeFrameType> getCollectionList(NAPCodeFrameCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPCodeFrameCollectionType::getNAPCodeFrame)
				.orElse(new ArrayList<>());
	}

	@Override
	public int getCollectionSize(NAPCodeFrameCollectionType collection) {
		return Optional.ofNullable(collection).map(NAPCodeFrameCollectionType::getNAPCodeFrame).map(List::size)
				.orElse(-1);
	}

	@Test
	@Category({ IntegrationTest.class, InitialiseData.class })
	public void initialiseData() {
		logTestName("initialiseData");
		NAPCodeFrameType codeFrame = new NAPCodeFrameType();
		codeFrame.setRefId(NAPCodeFrameTestData.REF_ID_1);
		codeFrame.setNAPTestRefId(NAPTestTestData.REF_ID_1);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		codeFrame.setRefId(NAPCodeFrameTestData.REF_ID_2);
		codeFrame.setNAPTestRefId(NAPTestTestData.REF_ID_2);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		codeFrame.setRefId(NAPCodeFrameTestData.REF_ID_3);
		codeFrame.setNAPTestRefId(NAPTestTestData.REF_ID_3);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		codeFrame.setRefId(NAPCodeFrameTestData.REF_ID_4);
		codeFrame.setNAPTestRefId(NAPTestTestData.REF_ID_4);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		codeFrame.setRefId(NAPCodeFrameTestData.REF_ID_5);
		codeFrame.setNAPTestRefId(NAPTestTestData.REF_ID_5);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		codeFrame.setRefId(NAPCodeFrameTestData.XML_REF_ID_1);
		codeFrame.setNAPTestRefId(NAPTestTestData.XML_REF_ID_1);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		codeFrame.setRefId(NAPCodeFrameTestData.XML_REF_ID_2);
		codeFrame.setNAPTestRefId(NAPTestTestData.XML_REF_ID_2);
		codeFrameTester.doCreateOne(codeFrame);
		codeFrameTester.doUpdateOne(codeFrame, codeFrame.getRefId());

		NAPCodeFrameType getResult = codeFrameTester.doGetOne(NAPCodeFrameTestData.REF_ID_1);
		Assert.assertNotNull(getResult);
		Assert.assertNotNull(getResult.getTestContent());
		Assert.assertNotNull(getResult.getTestContent().getNAPTestLocalId());
		Assert.assertNotNull(getResult.getTestletList());
		Assert.assertNotNull(getResult.getTestletList().getTestlet());
		Assert.assertEquals(5, getResult.getTestletList().getTestlet().size());
	}

	@Test
	@Category(IntegrationTest.class)
	public void testQBES() {
		super.testQBES();
	}

	@Test
	@Category(IntegrationTest.class)
	public void testGetSingle() {
		super.testGetSingle();
	}

	@Test
	@Category(IntegrationTest.class)
	public void testGetMany() {
		super.testGetMany();
	}
}