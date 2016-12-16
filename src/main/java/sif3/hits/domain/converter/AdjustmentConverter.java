package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsPNPCodeType;
import sif.dd.au30.model.AdjustmentContainerType;
import sif.dd.au30.model.PNPCodeListType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Adjustment;

@Component
public class AdjustmentConverter extends HitsConverter<AdjustmentContainerType, Adjustment> {

  public AdjustmentConverter() {
    super(AdjustmentContainerType.class, Adjustment.class);
  }

  @Override
  public void toSifModel(Adjustment source, AdjustmentContainerType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setBookletType(objectFactory.createAdjustmentContainerTypeBookletType(source.getBookletType()));
      Set<String> pnpCodeList = source.getPnpCodeList();
      if (pnpCodeList != null && !pnpCodeList.isEmpty()) {
        PNPCodeListType pnpCodeListType = objectFactory.createPNPCodeListType();
        for (String pnpCode : pnpCodeList) {
          pnpCodeListType.getPNPCode().add(getEnumValue(pnpCode, AUCodeSetsPNPCodeType.class));
        }
        target.setPNPCodeList(pnpCodeListType);
      }
    }
  }

  @Override
  public void toHitsModel(AdjustmentContainerType source, Adjustment target) {
    if (source != null && target != null) {
      target.setBookletType(getJAXBValue(source.getBookletType()));
      if (target.getPnpCodeList() == null) {
        target.setPnpCodeList(new HashSet<String>());
      }
      target.getPnpCodeList().clear();
      PNPCodeListType pnpCodeListType = source.getPNPCodeList();
      if (pnpCodeListType != null) {
        for (AUCodeSetsPNPCodeType pnpCode : pnpCodeListType.getPNPCode()) {
          target.getPnpCodeList().add(getEnumValue(pnpCode));
        }
      }
    }
  }

}
