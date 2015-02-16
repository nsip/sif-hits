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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.SessionInfo;

@Service
public class SessionInfoService extends BaseService<SessionInfoType, SessionInfoCollectionType, SessionInfo> {

  @Autowired
  private SessionInfoDAO sessionInfoDAO;

  @Override
  public JpaRepository<SessionInfo, String> getDAO() {
    return sessionInfoDAO;
  }

  @Override
  public ZoneFilterableRepository<SessionInfo> getZoneFilterableDAO() {
    return sessionInfoDAO;
  }

  @Autowired
  private SessionInfoConverter studentPersonalConverter;

  @Override
  public HitsConverter<SessionInfoType, SessionInfo> getConverter() {
    return studentPersonalConverter;
  }

  @Override
  protected SessionInfoCollectionType getCollection(List<SessionInfoType> items) {
    SessionInfoCollectionType result = new SessionInfoCollectionType();
    if (items != null) {
      result.getSessionInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected SessionInfo getFiltered(String refId, java.util.List<String> schoolRefIds) {
    SessionInfo result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = sessionInfoDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
