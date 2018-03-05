package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.SessionInfoType;
import sif3.hits.domain.dao.filter.SessionInfoFilterDAO;
import sif3.hits.domain.model.SessionInfo;

@Repository
public class SessionInfoFilterDAOImpl extends BaseFilterableRepository<SessionInfo, SessionInfoType> implements SessionInfoFilterDAO {
    public SessionInfoFilterDAOImpl() {
        super(SessionInfo.class, SessionInfoType.class);
    }
}
