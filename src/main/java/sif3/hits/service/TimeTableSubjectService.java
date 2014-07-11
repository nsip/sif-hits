package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableSubjectConverter;
import sif3.hits.domain.dao.TimeTableSubjectDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.TimeTableSubject;

@Service
public class TimeTableSubjectService extends
    BaseService<TimeTableSubjectType, TimeTableSubjectCollectionType, TimeTableSubject> {

  @Autowired
  private TimeTableSubjectDAO timeTableSubjectDAO;

  @Override
  public JpaRepository<TimeTableSubject, String> getDAO() {
    return timeTableSubjectDAO;
  }

  @Override
  public ZoneFilterableRepository<TimeTableSubject> getZoneFilterableDAO() {
    return timeTableSubjectDAO;
  }

  @Autowired
  private TimeTableSubjectConverter timeTableSubjectConverter;

  @Override
  public HitsConverter<TimeTableSubjectType, TimeTableSubject> getConverter() {
    return timeTableSubjectConverter;
  }

  @Override
  protected TimeTableSubjectCollectionType getCollection(List<TimeTableSubjectType> items) {
    TimeTableSubjectCollectionType result = new TimeTableSubjectCollectionType();
    if (items != null) {
      result.getTimeTableSubject().addAll(items);
    }
    return result;
  }

  @Override
  protected TimeTableSubject getFiltered(String refId, java.util.List<String> schoolRefIds) {
    TimeTableSubject result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = getDAO().findOne(refId);
      if (result != null) {
        if (!schoolRefIds.contains(result.getSchoolInfoRefId())) {
          result = null;
        }
      }
    }
    return result;
  }
}
