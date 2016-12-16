package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsPNPCodeType;
import sif.dd.au30.model.PNPCodeListType;
import sif.dd.au30.model.SubstituteItemType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestItemDAO;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.domain.model.SubstituteItem;

@Component
public class NAPItemSubstitutedForConverter extends HitsConverter<SubstituteItemType, SubstituteItem> {

  @Autowired
  private NAPTestItemDAO napTestItemDao;

  public NAPItemSubstitutedForConverter() {
    super(SubstituteItemType.class, SubstituteItem.class);
  }

  @Override
  public void toSifModel(SubstituteItem source, SubstituteItemType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      if (source.getSubstituteItem() != null) {
        target.setSubstituteItemRefId(source.getSubstituteItem().getRefId());
        target.setSubstituteItemLocalId(objectFactory.createSubstituteItemTypeSubstituteItemLocalId(source.getSubstituteItem().getLocalId()));
      }

      if (source.getPNPCodeList() != null && !source.getPNPCodeList().isEmpty()) {
        PNPCodeListType pnpCodeListType = objectFactory.createPNPCodeListType();
        for (String pnpCode : source.getPNPCodeList()) {
          pnpCodeListType.getPNPCode().add(getEnumValue(pnpCode, AUCodeSetsPNPCodeType.class));
        }
      }
    }
  }

  @Override
  public void toHitsModel(SubstituteItemType source, SubstituteItem target) {
    if (source != null && target != null) {
      String refId = source.getSubstituteItemRefId();
      String localId = getJAXBValue(source.getSubstituteItemLocalId());
      NAPTestItem testItem = null;
      if (refId != null) {
        testItem = napTestItemDao.findOne(refId);
      }
      if (testItem == null && localId != null) {
        List<NAPTestItem> testItems = napTestItemDao.findWithLocalId(localId);
        if (!testItems.isEmpty()) {
          testItem = testItems.get(0); 
        }
      }
      target.setSubstituteItem(testItem);
      if (target.getPNPCodeList() == null) {
        target.setPNPCodeList(new HashSet<String>());
      }
      target.getPNPCodeList().clear();
      if (source.getPNPCodeList() != null) {
        for (AUCodeSetsPNPCodeType pnpCodeType : source.getPNPCodeList().getPNPCode()) {
          target.getPNPCodeList().add(getEnumValue(pnpCodeType));
        }
      }
    }
  }
}
