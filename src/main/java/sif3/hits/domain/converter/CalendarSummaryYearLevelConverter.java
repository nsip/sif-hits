package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.YearLevelType;

@Component
public class CalendarSummaryYearLevelConverter extends HitsConverter<YearLevelType, String> {

  public CalendarSummaryYearLevelConverter() {
    super(YearLevelType.class, String.class);
  }

  @Override
  public void toSifModel(String source, YearLevelType target) {
    if (source != null && target != null) {
      target.setCode(getEnumValue(source, AUCodeSetsYearLevelCodeType.class));
    }
  }

  @Override
  public void toHitsModel(YearLevelType source, String target) {

  }

  @Override
  public <X> List<String> toHitsModelList(Collection<X> source) {
    List<String> result = new ArrayList<String>();
    if (source != null) {
      for (X item : source) {
        YearLevelType value = getSifValue(item);
        if (value != null) {
          String code = getEnumValue(value.getCode());
          if (code != null) {
            result.add(code);
          }
        }
      }
    }
    return result;
  }
}
