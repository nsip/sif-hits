package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentContactCollectionType;
import sif.dd.au30.model.StudentContactPersonalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentContactPersonalConverter;
import sif3.hits.domain.dao.StudentContactPersonalDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentContactPersonal;

@Service
public class StudentContactPersonalService extends BaseService<StudentContactPersonalType, StudentContactCollectionType, StudentContactPersonal> {

  @Autowired
  private StudentContactPersonalDAO studentContactPersonalDAO;
  
  @Autowired
  private StudentContactPersonalConverter studentContactPersonalConverter;

  @Override
  public JpaRepository<StudentContactPersonal, String> getDAO() {
    return studentContactPersonalDAO;
  }

  @Override
  public ZoneFilterableRepository<StudentContactPersonal> getZoneFilterableDAO() {
    return studentContactPersonalDAO;
  }

  @Override
  public HitsConverter<StudentContactPersonalType, StudentContactPersonal> getConverter() {
    return studentContactPersonalConverter;
  }

  @Override
  protected StudentContactCollectionType getCollection(List<StudentContactPersonalType> items) {
    StudentContactCollectionType result = new StudentContactCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStudentContactPersonal().addAll(items);
    }
    return result;
  }

  @Override
  protected StudentContactPersonal getFiltered(String refId, List<String> schoolRefIds) {
    StudentContactPersonal result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = studentContactPersonalDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
