package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPTestletCollectionType;
import sif.dd.au30.model.NAPTestletType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPTestletConverter;
import sif3.hits.domain.dao.NAPTestletDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPTestletFilterDAO;
import sif3.hits.domain.model.NAPTestlet;

@Service
public class NAPTestletService extends BaseService<NAPTestletType, NAPTestletCollectionType, NAPTestlet> {
  @Autowired
  private NAPTestletConverter napTestletConverter;

  @Autowired
  private NAPTestletDAO napTestletDAO;

  @Autowired
  private NAPTestletFilterDAO napTestletFilterDAO;

  @Override
  protected NAPTestletCollectionType getCollection(List<NAPTestletType> items) {
    NAPTestletCollectionType result = new NAPTestletCollectionType();
    if (items != null) {
      result.getNAPTestlet().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<NAPTestletType, NAPTestlet> getConverter() {
    return napTestletConverter;
  }

  @Override
  protected JpaRepository<NAPTestlet, String> getDAO() {
    return napTestletDAO;
  }

  @Override
  protected FilterableRepository<NAPTestlet> getFilterableDAO() {
    return napTestletFilterDAO;
  }
}
