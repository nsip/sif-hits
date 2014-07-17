package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.ScheduledActivityType;
import sif3.hits.domain.model.ScheduledActivity;

@Component
public class ScheduledActivityConverter extends HitsConverter<ScheduledActivityType, ScheduledActivity> {

  public ScheduledActivityConverter() {
    super(ScheduledActivityType.class, ScheduledActivity.class);
  }

  @Override
  public void toSifModel(ScheduledActivity source, ScheduledActivityType target) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void toHitsModel(ScheduledActivityType source, ScheduledActivity target) {
    // TODO Auto-generated method stub
    
  }
  
  

}
