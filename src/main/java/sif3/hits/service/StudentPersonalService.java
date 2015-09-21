package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.common.exception.UnsupportedQueryException;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentPersonalConverter;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.rest.dto.KeyValuePair;

@Service
public class StudentPersonalService extends BaseService<StudentPersonalType, StudentCollectionType, StudentPersonal> {

  @Autowired
  private StudentPersonalDAO studentPersonalDAO;

  @Override
  public JpaRepository<StudentPersonal, String> getDAO() {
    return studentPersonalDAO;
  }

  @Override
  public ZoneFilterableRepository<StudentPersonal> getZoneFilterableDAO() {
    return studentPersonalDAO;
  }

  @Autowired
  private StudentPersonalConverter studentPersonalConverter;

  @Override
  public HitsConverter<StudentPersonalType, StudentPersonal> getConverter() {
    return studentPersonalConverter;
  }

  @Override
  protected StudentCollectionType getCollection(List<StudentPersonalType> items) {
    StudentCollectionType result = new StudentCollectionType();
    if (items != null) {
      result.getStudentPersonal().addAll(items);
    }
    return result;
  }

  @Override
  protected StudentPersonal getFiltered(String refId, java.util.List<String> schoolRefIds) {
    StudentPersonal result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = studentPersonalDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected Page<StudentPersonal> findByServicePath(List<KeyValuePair> filters, List<String> schoolRefIds,
      PageRequest pageRequest) throws UnsupportedQueryException {

    String teachingGroupRefId = null;

    if (filters != null) {
      for (KeyValuePair filter : filters) {
        if (filter != null && "TeachingGroups".equals(filter.getKey()) && teachingGroupRefId == null) {
          teachingGroupRefId = filter.getValue();
        } else if (filter != null && ("TeachingGroups".equals(filter.getKey()))) {
          throw new UnsupportedQueryException("Invalid service path query - each key can appear only once.");
        }
      }
    }

    if (teachingGroupRefId != null) {
      return studentPersonalDAO.findAllWithTeachingGroupAndFilter(teachingGroupRefId, schoolRefIds, pageRequest);
    } else {
      return super.findByServicePath(filters, schoolRefIds, pageRequest);
    }
  }
}
