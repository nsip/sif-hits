package sif3.hits.test.consumer;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.test.consumer.data.SchoolInfoTestDataFactory;

public class SchoolInfoConsumerTest extends HitsConsumerTest<SchoolInfoType, SchoolInfoCollectionType>{

  private static final String NAME = "SchoolInfo";
  
  public SchoolInfoConsumerTest() {
    super(SchoolInfoType.class, SchoolInfoCollectionType.class, NAME, new SchoolInfoTestDataFactory(NAME));
  }

}
