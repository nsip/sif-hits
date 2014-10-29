package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CalendarSummaryType;
import sif.dd.au30.model.ObjectFactory;
import sif3.hits.domain.model.CalendarSummary;

@Component
public class CalendarSummaryConverter extends HitsConverter<CalendarSummaryType, CalendarSummary> {

  public CalendarSummaryConverter() {
    super(CalendarSummaryType.class, CalendarSummary.class);
  }

  @Autowired
  private PersonInfoConverter personInfoConverter;

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
     
      // Fields not implemented
      // target.setDescription(value);
      // target.setFirstInstructionDate(value);
      // target.setLastInstructionDate(value);
      // target.setGraduationDate(value);
      // target.setInstructionalMinutes(value);
      // target.setMinutesPerDay(value);
      // target.setYearLevels(value);
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
    }
  }
}
