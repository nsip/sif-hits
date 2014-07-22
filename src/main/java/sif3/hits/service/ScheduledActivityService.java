package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.ScheduledActivityConverter;
import sif3.hits.domain.dao.ScheduledActivityDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.ScheduledActivity;

@Service
public class ScheduledActivityService extends BaseService<ScheduledActivityType, ScheduledActivityCollectionType, ScheduledActivity> {

  @Autowired
  private ScheduledActivityDAO scheduledActivityDAO;

  @Autowired
  private ScheduledActivityConverter scheduledActivityConverter;

  @Override
  public JpaRepository<ScheduledActivity, String> getDAO() {
    return scheduledActivityDAO;
  }

  @Override
  public ZoneFilterableRepository<ScheduledActivity> getZoneFilterableDAO() {
    return scheduledActivityDAO;
  }

  @Override
  public HitsConverter<ScheduledActivityType, ScheduledActivity> getConverter() {
    return scheduledActivityConverter;
  }

  @Override
  protected ScheduledActivityCollectionType getCollection(List<ScheduledActivityType> items) {
    ScheduledActivityCollectionType result = new ScheduledActivityCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getScheduledActivity().addAll(items);
    }
    return result;
  }

  @Override
  protected ScheduledActivity getFiltered(String refId, List<String> schoolRefIds) {
    ScheduledActivity result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = scheduledActivityDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
