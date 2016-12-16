package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestItem2Type;
import sif.dd.au30.model.NAPTestItemListType;
import sif.dd.au30.model.NAPTestletType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestDAO;
import sif3.hits.domain.dao.NAPTestItemDAO;
import sif3.hits.domain.dao.NAPTestletTestItemDAO;
import sif3.hits.domain.model.NAPTest;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.domain.model.NAPTestlet;
import sif3.hits.domain.model.NAPTestletTestItem;

@Component
public class NAPTestletConverter extends HitsConverter<NAPTestletType, NAPTestlet> {

  @Autowired
  private NAPTestletTestItemConverter napTestletTestItemConverter;

  @Autowired
  private NAPTestletContentConverter napTestletContentConverter;

  @Autowired
  private NAPTestDAO napTestDao;

  @Autowired
  private NAPTestletTestItemDAO napTestletTestItemDao;

  @Autowired
  private NAPTestItemDAO napTestItemDao;

  public NAPTestletConverter() {
    super(NAPTestletType.class, NAPTestlet.class);
  }

  @Override
  public void toSifModel(NAPTestlet source, NAPTestletType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setTestletContent(napTestletContentConverter.toSifModel(source));

      NAPTest napTest = source.getNapTest();
      if (napTest != null) {
        target.setNAPTestLocalId(napTest.getLocalId());
        target.setNAPTestRefId(objectFactory.createNAPTestScoreSummaryTypeNAPTestRefId(napTest.getRefId()));
      }

      List<NAPTestletTestItem> testItems = new ArrayList<NAPTestletTestItem>(source.getTestItems());
      if (testItems != null && !testItems.isEmpty()) {
        Collections.sort(testItems, new Comparator<NAPTestletTestItem>() {
          public int compare(NAPTestletTestItem left, NAPTestletTestItem right) {
            return new CompareToBuilder().append(left.getTestletTestItemSequence(), right.getTestletTestItemSequence()).append(left.getId(), right.getId()).toComparison();
          }
        });
        NAPTestItemListType napTestItemListType = new NAPTestItemListType();
        napTestItemListType.getTestItem().addAll(napTestletTestItemConverter.toSifModelList(testItems));
        target.setTestItemList(napTestItemListType);
      }
    }
  }

  @Override
  public void toHitsModel(NAPTestletType source, NAPTestlet target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());

      napTestletContentConverter.toHitsModel(source.getTestletContent(), target);

      String napTestRefId = getJAXBValue(source.getNAPTestRefId());
      String napTestLocalId = source.getNAPTestLocalId();
      NAPTest napTest = napTestDao.findOne(napTestRefId);
      if (napTest == null) {
        List<NAPTest> napTests = napTestDao.findWithLocalId(napTestLocalId);
        if (!napTests.isEmpty()) {
          napTest = napTests.get(0);
        }
      }
      target.setNapTest(napTest);

      if (target.getTestItems() == null) {
        target.setTestItems(new HashSet<NAPTestletTestItem>());
      }
      HashMap<String, NAPTestletTestItem> targetTestItems = new HashMap<String, NAPTestletTestItem>();
      NAPTestItemListType napTestItemList = source.getTestItemList();
      if (napTestItemList != null) {
        for (NAPTestItem2Type napTestItem : napTestItemList.getTestItem()) {
          if (napTestItem != null && napTestItem.getTestItemRefId() != null) {
            addTestItem(napTestItem, target, targetTestItems);
          }
        }
      }
      target.getTestItems().clear();
      target.getTestItems().addAll(targetTestItems.values());
    }
  }

  private void addTestItem(NAPTestItem2Type napTestItem, NAPTestlet target, HashMap<String, NAPTestletTestItem> targetTestItems) {
    NAPTestItem testItem = napTestItemDao.findOne(napTestItem.getTestItemRefId());
    if (testItem == null) {
      List<NAPTestItem> testItems = napTestItemDao.findWithLocalId(napTestItem.getTestItemLocalId());
      if (!testItems.isEmpty()) {
        testItem = testItems.get(0);
      }
    }
    if (testItem != null) {
      List<NAPTestletTestItem> testletTestItems = napTestletTestItemDao.findWithRefIds(target.getRefId(), testItem.getRefId());
      NAPTestletTestItem testletTestItem = null;
      if (testletTestItems.isEmpty()) {
        testletTestItem = new NAPTestletTestItem();
        testletTestItem.setNapTestItem(testItem);
        testletTestItem.setNapTestlet(target);
      } else {
        testletTestItem = testletTestItems.get(0);
      }
      testletTestItem.setTestletTestItemSequence(getIntegerValue(napTestItem.getSequenceNumber()));
      targetTestItems.put(testItem.getRefId(), testletTestItem);
    }
  }
}
