package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableType;
import sif3.common.exception.PersistenceException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableConverter;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.TimeTableDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableService extends BaseService<TimeTableType, TimeTableCollectionType, TimeTable> {

  @Autowired
  private TimeTableDAO timeTableDAO;

  @Autowired
  private SchoolInfoDAO schoolInfoDAO;

  @Override
  public JpaRepository<TimeTable, String> getDAO() {
    return timeTableDAO;
  }

  @Override
  public ZoneFilterableRepository<TimeTable> getZoneFilterableDAO() {
    return timeTableDAO;
  }

  @Autowired
  private TimeTableConverter timeTableConverter;

  @Override
  public HitsConverter<TimeTableType, TimeTable> getConverter() {
    return timeTableConverter;
  }

  @Override
  protected TimeTableCollectionType getCollection(List<TimeTableType> items) {
    TimeTableCollectionType result = new TimeTableCollectionType();
    if (items != null) {
      result.getTimeTable().addAll(items);
    }
    return result;
  }

  @Override
  protected TimeTable save(TimeTable hitsObject, RequestDTO<TimeTableType> dto, String zoneId, boolean create) {
    SchoolInfo schoolInfo = schoolInfoDAO.findOne(hitsObject.getSchoolInfoRefId());
    if (schoolInfo == null) {
      throw new RuntimeException();
    }
    hitsObject.setSchoolInfo(schoolInfo);
    return super.save(hitsObject, dto, zoneId, create);
  }

  @Override
  protected TimeTable getFiltered(String refId, List<String> schoolRefIds) {
    return timeTableDAO.findOneWithFilter(refId, schoolRefIds);
  }
}
