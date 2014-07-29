package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.ScheduledActivityCollectionType;
import sif.dd.au30.model.ScheduledActivityType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.ScheduledActivityConverter;
import sif3.hits.domain.dao.ScheduledActivityDAO;
import sif3.hits.domain.dao.ScheduledActivityTeacherDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.ScheduledActivity;
import sif3.hits.domain.model.ScheduledActivityTeacher;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class ScheduledActivityService extends BaseService<ScheduledActivityType, ScheduledActivityCollectionType, ScheduledActivity> {

  @Autowired
  private ScheduledActivityDAO scheduledActivityDAO;
  
  @Autowired
  private ScheduledActivityTeacherDAO scheduledActivityTeacherDAO;

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
  protected ScheduledActivity save(ScheduledActivity hitsObject, RequestDTO<ScheduledActivityType> dto, String zoneId,
      boolean create) throws PersistenceException {

    ScheduledActivity result = null;
    if (!create) {
      deleteTeachers(hitsObject);
    }
    if (hitsObject.getTeachers() != null && hitsObject.getTeachers().size() > 0) {
      Set<ScheduledActivityTeacher> temporaryTeachers = new HashSet<ScheduledActivityTeacher>();
      Set<ScheduledActivityTeacher> teachers = new HashSet<ScheduledActivityTeacher>();
      temporaryTeachers.addAll(hitsObject.getTeachers());
      hitsObject.getTeachers().clear();
      result = super.save(hitsObject, dto, zoneId, create);
      for (ScheduledActivityTeacher teacher : temporaryTeachers) {
        teacher.setScheduledActivity(result);
        teachers.add(scheduledActivityTeacherDAO.save(teacher));
      }
      result.setTeachers(teachers);
    } else {
      result = super.save(hitsObject, dto, zoneId, create);
    }
    return result;
  }

  private void deleteTeachers(ScheduledActivity scheduledActivity) {
    scheduledActivityTeacherDAO.deleteAllWithScheduledActivity(scheduledActivity);
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
