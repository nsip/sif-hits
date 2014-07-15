package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableSubjectConverter;
import sif3.hits.domain.dao.TimeTableSubjectDAO;
import sif3.hits.domain.dao.TimeTableSubjectOtherCodeDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.domain.model.TimeTableSubjectOtherCode;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableSubjectService extends
    BaseService<TimeTableSubjectType, TimeTableSubjectCollectionType, TimeTableSubject> {

  @Autowired
  private TimeTableSubjectDAO timeTableSubjectDAO;
  
  @Autowired
  private TimeTableSubjectOtherCodeDAO timeTableSubjectOtherCodeDAO;

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
  
  @Override
  protected void delete(TimeTableSubject hitsObject, RequestDTO<TimeTableSubjectType> dto) {
    deleteOtherCodes(hitsObject);
    super.delete(hitsObject, dto);
  }
  
  private void deleteOtherCodes(TimeTableSubject hitsObject) {
    timeTableSubjectOtherCodeDAO.deleteAllWithTimeTableSubject(hitsObject);
  }
  
  @Override
  protected TimeTableSubject save(TimeTableSubject hitsObject, RequestDTO<TimeTableSubjectType> dto, String zoneId)
      throws PersistenceException {
    TimeTableSubject result = null;
    if (hitsObject.getOtherCodes() != null && hitsObject.getOtherCodes().size() > 0) {
      deleteOtherCodes(hitsObject);
      Set<TimeTableSubjectOtherCode> otherCodes = new HashSet<TimeTableSubjectOtherCode>();
      otherCodes.addAll(hitsObject.getOtherCodes());
      hitsObject.getOtherCodes().clear();
      result = super.save(hitsObject, dto, zoneId);
      for (TimeTableSubjectOtherCode otherCode : otherCodes) {
        timeTableSubjectOtherCodeDAO.save(otherCode);
      }
      result.setOtherCodes(otherCodes);
    } else {
      result = super.save(hitsObject, dto, zoneId); 
    }
    return result;
  }
}
