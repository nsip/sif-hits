package sif3.hits.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TimeTableCollectionType;
import sif.dd.au30.model.TimeTableType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TimeTableConverter;
import sif3.hits.domain.dao.TimeTableDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.dao.filter.TimeTableFilterDAO;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class TimeTableService extends BaseService<TimeTableType, TimeTableCollectionType, TimeTable> {

  @Autowired
  private TimeTableConverter timeTableConverter;

  @Autowired
  private TimeTableDAO timeTableDAO;

  @Autowired
  private TimeTableFilterDAO timeTableFilterDAO;
  
  @Autowired
  private SchoolInfoFilterDAO schoolInfoFilterDAO;

  @Override
  protected TimeTableCollectionType getCollection(List<TimeTableType> items) {
    TimeTableCollectionType result = new TimeTableCollectionType();
    if (items != null) {
      result.getTimeTable().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<TimeTableType, TimeTable> getConverter() {
    return timeTableConverter;
  }

  @Override
  protected JpaRepository<TimeTable, String> getDAO() {
    return timeTableDAO;
  }
  
  @Override
  protected FilterableRepository<TimeTable,TimeTableType> getFilterableDAO() {
    return timeTableFilterDAO;
  }
  
  @Override
  protected void deleteChildObjects(TimeTable hitsObject) {
  }
  
  @Override
  protected boolean hasChildObjects(TimeTable hitsObject) {
    return true;
  }
  
  @Override
  protected TimeTable saveWithChildObjects(TimeTable hitsObject, RequestDTO<TimeTableType> dto, String zoneId, boolean create) {
    SchoolInfo schoolInfo = schoolInfoFilterDAO.findOneWithZone(hitsObject.getSchoolInfoRefId(), zoneId);
    if (schoolInfo == null && StringUtils.isNotBlank(hitsObject.getSchoolInfoRefId())) {
      throw new RuntimeException("SchoolInfo not found.");
    }
    hitsObject.setSchoolInfo(schoolInfo);
    return super.saveWithChildObjects(hitsObject, dto, zoneId, create);
  }
}
