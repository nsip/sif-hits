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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentContactPersonalFilterDAO;
import sif3.hits.domain.model.StudentContactPersonal;

@Service
public class StudentContactPersonalService extends BaseService<StudentContactPersonalType, StudentContactCollectionType, StudentContactPersonal> {

  @Autowired
  private StudentContactPersonalConverter studentContactPersonalConverter;

  @Autowired
  private StudentContactPersonalDAO studentContactPersonalDAO;

  @Autowired
  private StudentContactPersonalFilterDAO studentContactPersonalFilterDAO;

  @Override
  protected StudentContactCollectionType getCollection(List<StudentContactPersonalType> items) {
    StudentContactCollectionType result = new StudentContactCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStudentContactPersonal().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentContactPersonalType, StudentContactPersonal> getConverter() {
    return studentContactPersonalConverter;
  }

  @Override
  protected JpaRepository<StudentContactPersonal, String> getDAO() {
    return studentContactPersonalDAO;
  }
  
  @Override
  protected FilterableRepository<StudentContactPersonal> getFilterableDAO() {
    return studentContactPersonalFilterDAO;
  }
}
