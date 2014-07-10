package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentPersonalConverter;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentPersonal;

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
      result = studentPersonalDAO.findOne(refId);
      if (result != null) {
        if (!schoolRefIds.contains(result.getSchoolInfoRefId())) {
          result = null;
        }
      }
    }
    return result;
  }
}
