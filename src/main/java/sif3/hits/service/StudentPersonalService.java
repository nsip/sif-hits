package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentPersonalCollectionType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentPersonalConverter;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentPersonalFilterDAO;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.rest.dto.RequestDTO;
import sif3.hits.rest.dto.ResponseDTO;

@Service
public class StudentPersonalService extends BaseService<StudentPersonalType, StudentPersonalCollectionType, StudentPersonal> {

  @Autowired
  private StudentPersonalConverter studentPersonalConverter;

  @Autowired
  private StudentPersonalDAO studentPersonalDAO;

  @Autowired
  private StudentPersonalFilterDAO studentPersonalFilterDAO;
  
  @Autowired
  private PersonalStudentIdService personalStudentIdService;
  
  @Override
  public ResponseDTO<StudentPersonalType> createSingle(RequestDTO<StudentPersonalType> dto, String zoneId) {
    personalStudentIdService.createId(dto.getSifObject());
    return super.createSingle(dto, zoneId);
  }

  @Override
  protected StudentPersonalCollectionType getCollection(List<StudentPersonalType> items) {
    StudentPersonalCollectionType result = new StudentPersonalCollectionType();
    if (items != null) {
      result.getStudentPersonal().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentPersonalType, StudentPersonal> getConverter() {
    return studentPersonalConverter;
  }

  @Override
  protected JpaRepository<StudentPersonal, String> getDAO() {
    return studentPersonalDAO;
  }

  @Override
  protected FilterableRepository<StudentPersonal> getFilterableDAO() {
    return studentPersonalFilterDAO;
  }

}
