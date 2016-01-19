package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.model.SchoolInfo;

@Repository
public class SchoolInfoFilterDAOImpl extends BaseFilterableRepository<SchoolInfo>implements SchoolInfoFilterDAO {
  public SchoolInfoFilterDAOImpl() {
    super(SchoolInfo.class);
  }
}
