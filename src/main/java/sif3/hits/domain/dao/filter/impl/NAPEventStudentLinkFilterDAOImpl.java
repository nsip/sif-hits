package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPEventStudentLinkFilterDAO;
import sif3.hits.domain.model.NAPEventStudentLink;

@Repository
public class NAPEventStudentLinkFilterDAOImpl extends BaseFilterableRepository<NAPEventStudentLink> implements NAPEventStudentLinkFilterDAO {
  public NAPEventStudentLinkFilterDAOImpl() {
    super(NAPEventStudentLink.class);
  }
}
