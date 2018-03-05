package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.SchoolInfoCollectionType;
import sif.dd.au30.model.SchoolInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.SchoolInfoConverter;
import sif3.hits.domain.dao.SchoolInfoDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SchoolInfoFilterDAO;
import sif3.hits.domain.model.SchoolInfo;

@Service
public class SchoolInfoService extends BaseService<SchoolInfoType, SchoolInfoCollectionType, SchoolInfo> {

  @Autowired
  private SchoolInfoConverter schoolInfoConverter;

  @Autowired
  private SchoolInfoDAO schoolInfoDAO;

  @Autowired
  private SchoolInfoFilterDAO schoolInfoFilterDAO;

  @Override
  protected SchoolInfoCollectionType getCollection(List<SchoolInfoType> items) {
    SchoolInfoCollectionType result = new SchoolInfoCollectionType();
    if (items != null) {
      result.getSchoolInfo().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<SchoolInfoType, SchoolInfo> getConverter() {
    return schoolInfoConverter;
  }

  @Override
  protected JpaRepository<SchoolInfo, String> getDAO() {
    return schoolInfoDAO;
  }

  @Override
  protected FilterableRepository<SchoolInfo,SchoolInfoType> getFilterableDAO() {
    return schoolInfoFilterDAO;
  }
}
