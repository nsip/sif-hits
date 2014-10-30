package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.hits.domain.model.CalendarDateTypeOtherCode;

@Component
public class CalendarDateTypeOtherCodeConverter extends HitsConverter<OtherCode, CalendarDateTypeOtherCode> {

  public CalendarDateTypeOtherCodeConverter() {
    super(OtherCode.class, CalendarDateTypeOtherCode.class);
  }

  @Override
  public void toSifModel(CalendarDateTypeOtherCode source, OtherCode target) {
    if (source != null && target != null) {
      target.setCodeset(source.getCodeSet());
      target.setValue(source.getOtherCode());
    }
  }

  @Override
  public void toHitsModel(OtherCode source, CalendarDateTypeOtherCode target) {
    if (source != null && target != null) {
      target.setCodeSet(source.getCodeset());
      target.setOtherCode(source.getValue());
    }
  }
}
