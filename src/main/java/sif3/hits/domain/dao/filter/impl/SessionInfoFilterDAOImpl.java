package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.SessionInfoFilterDAO;
import sif3.hits.domain.model.SessionInfo;

@Repository
public class SessionInfoFilterDAOImpl extends BaseFilterableRepository<SessionInfo>implements SessionInfoFilterDAO {
  public SessionInfoFilterDAOImpl() {
    super(SessionInfo.class);
  }
}
