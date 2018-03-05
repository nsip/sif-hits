package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPTestItemCollectionType;
import sif.dd.au30.model.NAPTestItemType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPTestItemConverter;
import sif3.hits.domain.dao.NAPTestItemDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPTestItemFilterDAO;
import sif3.hits.domain.model.NAPTestItem;

@Service
public class NAPTestItemService extends BaseService<NAPTestItemType, NAPTestItemCollectionType, NAPTestItem> {
  @Autowired
  private NAPTestItemConverter napTestItemConverter;

  @Autowired
  private NAPTestItemDAO napTestItemDAO;

  @Autowired
  private NAPTestItemFilterDAO napTestItemFilterDAO;

  @Override
  protected NAPTestItemCollectionType getCollection(List<NAPTestItemType> items) {
    NAPTestItemCollectionType result = new NAPTestItemCollectionType();
    if (items != null) {
      result.getNAPTestItem().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<NAPTestItemType, NAPTestItem> getConverter() {
    return napTestItemConverter;
  }

  @Override
  protected JpaRepository<NAPTestItem, String> getDAO() {
    return napTestItemDAO;
  }

  @Override
  protected FilterableRepository<NAPTestItem,NAPTestItemType> getFilterableDAO() {
    return napTestItemFilterDAO;
  }
}
