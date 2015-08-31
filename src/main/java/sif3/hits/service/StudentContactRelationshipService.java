package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentContactRelationshipCollectionType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentContactRelationshipConverter;
import sif3.hits.domain.dao.StudentContactRelationshipDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.StudentContactRelationship;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class StudentContactRelationshipService extends BaseService<StudentContactRelationshipType, StudentContactRelationshipCollectionType, StudentContactRelationship> {

  @Autowired
  private StudentContactRelationshipDAO studentContactRelationshipDAO;
  
  @Autowired
  private StudentContactRelationshipConverter studentContactRelationshipConverter;

  @Override
  public JpaRepository<StudentContactRelationship, String> getDAO() {
    return studentContactRelationshipDAO;
  }

  @Override
  public ZoneFilterableRepository<StudentContactRelationship> getZoneFilterableDAO() {
    return studentContactRelationshipDAO;
  }

  @Override
  public HitsConverter<StudentContactRelationshipType, StudentContactRelationship> getConverter() {
    return studentContactRelationshipConverter;
  }

  @Override
  protected StudentContactRelationshipCollectionType getCollection(List<StudentContactRelationshipType> items) {
    StudentContactRelationshipCollectionType result = new StudentContactRelationshipCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStudentContactRelationship().addAll(items);
    }
    return result;
  }

  @Override
  protected StudentContactRelationship getFiltered(String refId, List<String> schoolRefIds) {
    StudentContactRelationship result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = studentContactRelationshipDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(StudentContactRelationship hitsObject, RequestDTO<StudentContactRelationshipType> dto) {
    deleteOtherIds(hitsObject);
    super.delete(hitsObject, dto);
  }

  private void deleteOtherIds(StudentContactRelationship hitsObject) {
    
  }
}
