package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPEventStudentLinkCollectionType;
import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPEventStudentLinkConverter;
import sif3.hits.domain.dao.NAPEventStudentLinkDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPEventStudentLinkFilterDAO;
import sif3.hits.domain.model.NAPEventStudentLink;

@Service
public class NAPEventStudentLinkService extends BaseService<NAPEventStudentLinkType, NAPEventStudentLinkCollectionType, NAPEventStudentLink> {
  @Autowired
  private NAPEventStudentLinkConverter napEventStudentLinkConverter;

  @Autowired
  private NAPEventStudentLinkDAO napEventStudentLinkDAO;

  @Autowired
  private NAPEventStudentLinkFilterDAO napEventStudentLinkFilterDAO;

  @Override
  protected NAPEventStudentLinkCollectionType getCollection(List<NAPEventStudentLinkType> items) {
    NAPEventStudentLinkCollectionType result = new NAPEventStudentLinkCollectionType();
    if (items != null) {
      result.getNAPEventStudentLink().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<NAPEventStudentLinkType, NAPEventStudentLink> getConverter() {
    return napEventStudentLinkConverter;
  }

  @Override
  protected JpaRepository<NAPEventStudentLink, String> getDAO() {
    return napEventStudentLinkDAO;
  }

  @Override
  protected FilterableRepository<NAPEventStudentLink,NAPEventStudentLinkType> getFilterableDAO() {
    return napEventStudentLinkFilterDAO;
  }
}
