package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.model.CalendarSummaryYearLevel;

@Component
public class CalendarSummaryYearLevelConverter extends HitsConverter<YearLevelType, CalendarSummaryYearLevel> {

  public CalendarSummaryYearLevelConverter() {
    super(YearLevelType.class, CalendarSummaryYearLevel.class);
  }

  @Override
  public void toSifModel(CalendarSummaryYearLevel source, YearLevelType target) {
    if (source != null && target != null) {
      target.setCode(source.getYearLevel());
    }
  }

  @Override
  public void toHitsModel(YearLevelType source, CalendarSummaryYearLevel target) {
    if (source != null && target != null) {
      target.setYearLevel(source.getCode());
    }
  }
}
