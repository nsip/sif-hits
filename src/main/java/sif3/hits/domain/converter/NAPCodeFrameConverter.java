package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPCodeFrameTestletListType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestDAO;
import sif3.hits.domain.model.NAPCodeFrame;
import sif3.hits.domain.model.NAPTest;

@Component
public class NAPCodeFrameConverter extends HitsConverter<NAPCodeFrameType, NAPCodeFrame> {

  @Autowired
  private NAPTestContentConverter napTestContentConverter;

  @Autowired
  private NAPCodeFrameTestletConverter napCodeFramTestletConverter;

  @Autowired
  private NAPTestDAO napTestDAO;

  public NAPCodeFrameConverter() {
    super(NAPCodeFrameType.class, NAPCodeFrame.class);
  }

  @Override
  public void toSifModel(NAPCodeFrame source, NAPCodeFrameType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      if (source.getNapTest() != null) {
        target.setNAPTestRefId(objectFactory.createNAPCodeFrameTypeNAPTestRefId(source.getNapTest().getRefId()));
        target.setTestContent(objectFactory.createNAPCodeFrameTypeTestContent(napTestContentConverter.toSifModel(source.getNapTest())));
        if (source.getNapTest().getNapTestlets() != null && !source.getNapTest().getNapTestlets().isEmpty()) {
          NAPCodeFrameTestletListType napCodeFrameTestletListType = objectFactory.createNAPCodeFrameTestletListType();
          napCodeFrameTestletListType.getTestlet().addAll(napCodeFramTestletConverter.toSifModelList(source.getNapTest().getNapTestlets()));
          target.setTestletList(napCodeFrameTestletListType);
        }
      }
    }
  }

  @Override
  public void toHitsModel(NAPCodeFrameType source, NAPCodeFrame target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());

      String testRefId = getJAXBValue(source.getNAPTestRefId());

      if (testRefId != null) {
        NAPTest napTest = napTestDAO.findOne(testRefId);
        target.setNapTest(napTest);
      }
    }
  }

}
