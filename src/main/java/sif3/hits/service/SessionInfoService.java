package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.SessionInfoCollectionType;
import sif.dd.au30.model.SessionInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.SessionInfoConverter;
import sif3.hits.domain.dao.SessionInfoDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SessionInfoFilterDAO;
import sif3.hits.domain.model.SessionInfo;

@Service
public class SessionInfoService extends BaseService<SessionInfoType, SessionInfoCollectionType, SessionInfo> {

  @Autowired
  private SessionInfoConverter sessionInfoConverter;
  
  @Autowired
  private SessionInfoDAO sessionInfoDAO;

  @Autowired
  private SessionInfoFilterDAO sessionInfoFilterDAO;

  @Override
  protected SessionInfoCollectionType getCollection(List<SessionInfoType> items) {
    SessionInfoCollectionType result = new SessionInfoCollectionType();
    if (items != null) {
      result.getSessionInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<SessionInfoType, SessionInfo> getConverter() {
    return sessionInfoConverter;
  }

  @Override
  protected JpaRepository<SessionInfo, String> getDAO() {
    return sessionInfoDAO;
  }

  @Override
  protected FilterableRepository<SessionInfo,SessionInfoType> getFilterableDAO() {
    return sessionInfoFilterDAO;
  }
}
