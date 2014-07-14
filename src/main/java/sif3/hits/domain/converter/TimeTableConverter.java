package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.TimeTableType;
import sif3.hits.domain.model.TimeTable;

@Component
public class TimeTableConverter extends HitsConverter<TimeTableType, TimeTable> {

  public TimeTableConverter() {
    super(TimeTableType.class, TimeTable.class);
  }

  @Override
  public void toSifModel(TimeTable source, TimeTableType target) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void toHitsModel(TimeTableType source, TimeTable target) {
    // TODO Auto-generated method stub
    
  }

}
