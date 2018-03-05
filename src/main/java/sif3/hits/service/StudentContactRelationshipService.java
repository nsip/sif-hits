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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentContactRelationshipFilterDAO;
import sif3.hits.domain.model.StudentContactRelationship;

@Service
public class StudentContactRelationshipService extends BaseService<StudentContactRelationshipType, StudentContactRelationshipCollectionType, StudentContactRelationship> {

  @Autowired
  private StudentContactRelationshipConverter studentContactRelationshipConverter;

  @Autowired
  private StudentContactRelationshipDAO studentContactRelationshipDAO;

  @Autowired
  private StudentContactRelationshipFilterDAO studentContactRelationshipFilterDAO;

  @Override
  protected StudentContactRelationshipCollectionType getCollection(List<StudentContactRelationshipType> items) {
    StudentContactRelationshipCollectionType result = new StudentContactRelationshipCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getStudentContactRelationship().addAll(items);
    }
    return result;
  }

  @Override
  public HitsConverter<StudentContactRelationshipType, StudentContactRelationship> getConverter() {
    return studentContactRelationshipConverter;
  }

  @Override
  public JpaRepository<StudentContactRelationship, String> getDAO() {
    return studentContactRelationshipDAO;
  }

  @Override
  protected FilterableRepository<StudentContactRelationship,StudentContactRelationshipType> getFilterableDAO() {
    return studentContactRelationshipFilterDAO;
  }
}
