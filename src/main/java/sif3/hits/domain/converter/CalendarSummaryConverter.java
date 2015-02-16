package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CalendarSummaryType;
import sif.dd.au30.model.YearLevelType;
import sif.dd.au30.model.YearLevelsType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.CalendarSummary;
import sif3.hits.domain.model.CalendarSummaryYearLevel;

@Component
public class CalendarSummaryConverter extends HitsConverter<CalendarSummaryType, CalendarSummary> {

  @Autowired
  private CalendarSummaryYearLevelConverter calendarSummaryYearLevelConverter;

  public CalendarSummaryConverter() {
    super(CalendarSummaryType.class, CalendarSummary.class);
  }

  @Override
  public void toSifModel(CalendarSummary source, CalendarSummaryType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setLocalId(source.getLocalId());
      target.setDaysInSession(getLongValue(source.getDaysInSession()));
      target.setStartDate(objectFactory.createCalendarSummaryTypeStartDate(getDateValue(source.getStartDate())));
      target.setStartDate(objectFactory.createCalendarSummaryTypeEndDate(getDateValue(source.getEndDate())));
      target.setFirstInstructionDate(objectFactory.createCalendarSummaryTypeFirstInstructionDate(getDateValue(source
          .getFirstInstructionDate())));
      target.setLastInstructionDate(objectFactory.createCalendarSummaryTypeLastInstructionDate(getDateValue(source
          .getLastInstructionDate())));
      target.setInstructionalMinutes(objectFactory.createCalendarSummaryTypeInstructionalMinutes(getLongValue(source
          .getInstructionalMinutes())));
      target.setMinutesPerDay(objectFactory.createCalendarSummaryTypeMinutesPerDay(getLongValue(source
          .getMinutesPerDay())));

      YearLevelsType yearLevelsType = objectFactory.createYearLevelsType();
      List<YearLevelType> yearLevels = calendarSummaryYearLevelConverter.toSifModelList(source
          .getCalendarSummaryYearLevels());
      if (yearLevels != null && !yearLevels.isEmpty()) {
        yearLevelsType.getYearLevel().addAll(yearLevels);
        target.setYearLevels(objectFactory.createCalendarSummaryTypeYearLevels(yearLevelsType));
      }

      // Fields not implemented
      // target.setDescription(value);
      // target.setGraduationDate(value);
    }
  }

  @Override
  public void toHitsModel(CalendarSummaryType source, CalendarSummary target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(source.getSchoolInfoRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setLocalId(source.getLocalId());
      target.setDaysInSession(getLongValue(source.getDaysInSession()));
      target.setStartDate(getDateValue(getJAXBValue(source.getStartDate())));
      target.setStartDate(getDateValue(getJAXBValue(source.getEndDate())));
      target.setFirstInstructionDate(getDateValue(getJAXBValue(source.getFirstInstructionDate())));
      target.setLastInstructionDate(getDateValue(getJAXBValue(source.getLastInstructionDate())));
      target.setInstructionalMinutes(getLongValue(getJAXBValue(source.getInstructionalMinutes())));
      target.setMinutesPerDay(getLongValue(getJAXBValue(source.getMinutesPerDay())));

      YearLevelsType yearLevelsType = getJAXBValue(source.getYearLevels());
      if (yearLevelsType != null) {
        List<CalendarSummaryYearLevel> yearLevels = calendarSummaryYearLevelConverter.toHitsModelList(yearLevelsType
            .getYearLevel());
        target.setCalendarSummaryYearLevels(new HashSet<CalendarSummaryYearLevel>(yearLevels));
      }
    }
  }
}
