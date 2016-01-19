package sif3.hits.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TimeTableSubjectCollectionType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableSubjectConverter;
import sif3.hits.domain.dao.TimeTableSubjectDAO;
import sif3.hits.domain.dao.TimeTableSubjectOtherCodeDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableSubjectFilterDAO;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.domain.model.TimeTableSubjectOtherCode;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableSubjectService extends BaseService<TimeTableSubjectType, TimeTableSubjectCollectionType, TimeTableSubject> {

  @Autowired
  private TimeTableSubjectConverter timeTableSubjectConverter;

  @Autowired
  private TimeTableSubjectDAO timeTableSubjectDAO;

  @Autowired
  private TimeTableSubjectFilterDAO timeTableSubjectFilterDAO;

  @Autowired
  private TimeTableSubjectOtherCodeDAO timeTableSubjectOtherCodeDAO;
  
  @Autowired
  private SchoolInfoFilterDAO schoolInfoFilterDAO;

  @Override
  protected TimeTableSubjectCollectionType getCollection(List<TimeTableSubjectType> items) {
    TimeTableSubjectCollectionType result = new TimeTableSubjectCollectionType();
    if (items != null) {
      result.getTimeTableSubject().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<TimeTableSubjectType, TimeTableSubject> getConverter() {
    return timeTableSubjectConverter;
  }

  @Override
  protected JpaRepository<TimeTableSubject, String> getDAO() {
    return timeTableSubjectDAO;
  }
  
  @Override
  protected FilterableRepository<TimeTableSubject> getFilterableDAO() {
    return timeTableSubjectFilterDAO;
  }
  
  @Override
  protected void deleteChildObjects(TimeTableSubject hitsObject) {
    timeTableSubjectOtherCodeDAO.deleteAllWithTimeTableSubject(hitsObject);
  }

  @Override
  protected boolean hasChildObjects(TimeTableSubject hitsObject) {
    return true;
  }
  
  @Override
  protected TimeTableSubject saveWithChildObjects(TimeTableSubject hitsObject, RequestDTO<TimeTableSubjectType> dto, String zoneId, boolean create) {
    TimeTableSubject result = null;
    hitsObject.setSchoolInfo(getSchoolInfo(hitsObject.getSchoolInfo(), zoneId));
    if (hitsObject.getOtherCodes() != null && hitsObject.getOtherCodes().size() > 0) {
      Set<TimeTableSubjectOtherCode> otherCodes = new HashSet<TimeTableSubjectOtherCode>();
      otherCodes.addAll(hitsObject.getOtherCodes());
      hitsObject.getOtherCodes().clear();
      result = super.saveWithChildObjects(hitsObject, dto, zoneId, create);
      for (TimeTableSubjectOtherCode otherCode : otherCodes) {
        otherCode.setTimeTableSubject(hitsObject);
        timeTableSubjectOtherCodeDAO.save(otherCode);
      }
      result.setOtherCodes(otherCodes);
    } else {
      result = super.saveWithChildObjects(hitsObject, dto, zoneId, create);
    }
    return result;
  }
  
  private SchoolInfo getSchoolInfo(SchoolInfo schoolInfo, String zoneId) {
    SchoolInfo result = null;
    if (schoolInfo != null) {
      result = schoolInfoFilterDAO.findOneWithZone(schoolInfo.getRefId(), zoneId);
    }
    return result;
  }
}
