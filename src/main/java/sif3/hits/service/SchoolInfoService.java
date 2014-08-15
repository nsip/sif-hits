package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.SchoolCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.SchoolInfoConverter;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.SchoolInfo;

@Service
public class SchoolInfoService extends BaseService<SchoolInfoType, SchoolCollectionType, SchoolInfo> {

  @Autowired
  private SchoolInfoDAO schoolInfoDAO;

  @Override
  public JpaRepository<SchoolInfo, String> getDAO() {
    return schoolInfoDAO;
  }

  @Override
  public ZoneFilterableRepository<SchoolInfo> getZoneFilterableDAO() {
    return schoolInfoDAO;
  }

  @Autowired
  private SchoolInfoConverter schoolInfoConverter;

  @Override
  public HitsConverter<SchoolInfoType, SchoolInfo> getConverter() {
    return schoolInfoConverter;
  }

  @Override
  protected SchoolCollectionType getCollection(List<SchoolInfoType> items) {
    SchoolCollectionType result = new SchoolCollectionType();
    if (items != null) {
      result.getSchoolInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected SchoolInfo getFiltered(String refId, List<String> refIds) {
    SchoolInfo result = null;
    if (refIds.contains(refId)) {
      result = schoolInfoDAO.findOne(refId);
    }
    return result;
  }
}
