package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsNAPResponseCorrectnessType;
import sif.dd.au30.model.NAPSubscoreListType;
import sif.dd.au30.model.NAPSubscoreType;
import sif.dd.au30.model.NAPTestletResponseItemType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestItemDAO;
import sif3.hits.domain.model.NAPSubscore;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.domain.model.TestItemResponse;

@Component
public class NAPStudentResponseTestItemConverter extends HitsConverter<NAPTestletResponseItemType, TestItemResponse> {

  @Autowired
  private NAPSubscoreConverter napSubscoreConverter;

  @Autowired
  private NAPTestItemDAO napTestItemDAO;

  public NAPStudentResponseTestItemConverter() {
    super(NAPTestletResponseItemType.class, TestItemResponse.class);
  }

  @Override
  public void toSifModel(TestItemResponse source, NAPTestletResponseItemType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setItemWeight(getBigDecimalValue(source.getItemWeight()));
      target.setResponse(source.getResponse());
      target.setResponseCorrectness(objectFactory.createNAPTestletResponseItemTypeResponseCorrectness(getEnumValue(source.getResponseCorrectness(), AUCodeSetsNAPResponseCorrectnessType.class)));
      target.setScore(objectFactory.createNAPTestletResponseItemTypeScore(getBigDecimalValue(source.getScore())));
      target.setSequenceNumber(getBigIntegerValue(source.getSequenceNumber()));
      target.setLapsedTimeItem(getDurationValue(source.getLapsedTimeItem()));

      // TestItem
      NAPTestItem napTestItem = source.getTestItem();
      if (napTestItem != null) {
        target.setNAPTestItemLocalId(objectFactory.createNAPTestletResponseItemTypeNAPTestItemLocalId(napTestItem.getLocalId()));
        target.setNAPTestItemRefId(napTestItem.getRefId());
      }

      // Subscore List
      List<NAPSubscoreType> subscoreList = napSubscoreConverter.toSifModelList(source.getSubscoreList());
      if (subscoreList != null && !subscoreList.isEmpty()) {
        NAPSubscoreListType napSubscoreListType = objectFactory.createNAPSubscoreListType();
        napSubscoreListType.getSubscore().addAll(subscoreList);
        target.setSubscoreList(objectFactory.createNAPTestletResponseItemTypeSubscoreList(napSubscoreListType));
      }
    }
  }

  @Override
  public void toHitsModel(NAPTestletResponseItemType source, TestItemResponse target) {
    if (source != null && target != null) {
      target.setItemWeight(getBigDecimalValue(source.getItemWeight()));
      target.setResponse(source.getResponse());
      target.setResponseCorrectness(getEnumValue(getJAXBValue(source.getResponseCorrectness())));
      target.setScore(getBigDecimalValue(getJAXBValue(source.getScore())));
      target.setSequenceNumber(getIntegerValue(source.getSequenceNumber()));
      target.setLapsedTimeItem(getDurationValue(source.getLapsedTimeItem()));

      // TestItem
      String testItemRefId = source.getNAPTestItemRefId();
      String testItemLocalId = getJAXBValue(source.getNAPTestItemLocalId());
      NAPTestItem napTestItem = napTestItemDAO.findOne(testItemRefId);
      if (napTestItem == null) {
        List<NAPTestItem> napTestItems = napTestItemDAO.findWithLocalId(testItemLocalId);
        if (!napTestItems.isEmpty()) {
          napTestItem = napTestItems.get(0);
        }
      }
      target.setTestItem(napTestItem);

      // Subscore List
      if (target.getSubscoreList() == null) {
        target.setSubscoreList(new HashSet<NAPSubscore>());
      }
      target.getSubscoreList().clear();
      NAPSubscoreListType subscoreList = getJAXBValue(source.getSubscoreList());
      if (subscoreList != null) {
        target.getSubscoreList().addAll(napSubscoreConverter.toHitsModelList(subscoreList.getSubscore()));
        for (NAPSubscore subscore : target.getSubscoreList()) {
          subscore.setTestItemResponse(target);
        }
      }
    }
  }

}
