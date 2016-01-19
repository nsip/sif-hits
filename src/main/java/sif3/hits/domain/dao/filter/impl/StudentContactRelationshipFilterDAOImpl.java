package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentContactRelationshipFilterDAO;
import sif3.hits.domain.model.StudentContactRelationship;

@Repository
public class StudentContactRelationshipFilterDAOImpl extends BaseFilterableRepository<StudentContactRelationship>implements StudentContactRelationshipFilterDAO {
  public StudentContactRelationshipFilterDAOImpl() {
    super(StudentContactRelationship.class);
  }
}
