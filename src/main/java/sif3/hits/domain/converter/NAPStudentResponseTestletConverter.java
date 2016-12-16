package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NAPTestletItemResponseListType;
import sif.dd.au30.model.NAPTestletResponseType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestletDAO;
import sif3.hits.domain.model.NAPTestlet;
import sif3.hits.domain.model.TestItemResponse;
import sif3.hits.domain.model.TestletResponse;

@Component
public class NAPStudentResponseTestletConverter extends HitsConverter<NAPTestletResponseType, TestletResponse> {

  @Autowired
  private NAPStudentResponseTestItemConverter napStudentResponseTestItemConverter;

  @Autowired
  private NAPTestletDAO napTestletDAO;

  public NAPStudentResponseTestletConverter() {
    super(NAPTestletResponseType.class, TestletResponse.class);
  }

  @Override
  public void toSifModel(TestletResponse source, NAPTestletResponseType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setTestletSubScore(getBigDecimalValue(source.getTestletScore()));

      // NAP Testlet
      NAPTestlet napTestlet = source.getTestlet();
      if (napTestlet != null) {
        target.setNAPTestletLocalId(napTestlet.getLocalId());
        target.setNAPTestletRefId(objectFactory.createNAPTestletResponseTypeNAPTestletRefId(napTestlet.getRefId()));
      }

      // NAP TestItem List
      List<TestItemResponse> testItemList = new ArrayList<TestItemResponse>(source.getItemList());
      if (testItemList != null && !testItemList.isEmpty()) {
        Collections.sort(testItemList, new Comparator<TestItemResponse>() {
          public int compare(TestItemResponse left, TestItemResponse right) {
            return new CompareToBuilder().append(left.getSequenceNumber(), right.getSequenceNumber()).append(left.getId(), right.getId()).toComparison();
          }
        });
        NAPTestletItemResponseListType napTestletItemListType = objectFactory.createNAPTestletItemResponseListType();
        napTestletItemListType.getItemResponse().addAll(napStudentResponseTestItemConverter.toSifModelList(testItemList));
        target.setItemResponseList(napTestletItemListType);
      }
    }
  }

  @Override
  public void toHitsModel(NAPTestletResponseType source, TestletResponse target) {
    if (source != null && target != null) {
      target.setTestletScore(getBigDecimalValue(source.getTestletSubScore()));

      // NAPTestlet
      String testletRefId = getJAXBValue(source.getNAPTestletRefId());
      String testletLocalId = source.getNAPTestletLocalId();
      NAPTestlet napTestlet = napTestletDAO.findOne(testletRefId);
      if (napTestlet == null) {
        List<NAPTestlet> napTestlets = napTestletDAO.findWithLocalId(testletLocalId);
        if (!napTestlets.isEmpty()) {
          napTestlet = napTestlets.get(0);
        }
      }
      target.setTestlet(napTestlet);

      // NAPTestItem List
      if (target.getItemList() == null) {
        target.setItemList(new HashSet<TestItemResponse>());
      }
      target.getItemList().clear();
      NAPTestletItemResponseListType napTestletItemListType = source.getItemResponseList();
      if (napTestletItemListType != null) {
        target.getItemList().addAll(napStudentResponseTestItemConverter.toHitsModelList(napTestletItemListType.getItemResponse()));
        for (TestItemResponse testItemResponse : target.getItemList()) {
          testItemResponse.setTestletResponse(target);
        }
      }
    }
  }

}
