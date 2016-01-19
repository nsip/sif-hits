package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.StudentContactPersonalFilterDAO;
import sif3.hits.domain.model.StudentContactPersonal;

@Repository
public class StudentContactPersonalFilterDAOImpl extends BaseFilterableRepository<StudentContactPersonal>implements StudentContactPersonalFilterDAO {
  public StudentContactPersonalFilterDAOImpl() {
    super(StudentContactPersonal.class);
  }
}
