package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPCodeFrameCollectionType;
import sif.dd.au30.model.NAPCodeFrameType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPCodeFrameConverter;
import sif3.hits.domain.dao.NAPCodeFrameDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPCodeFrameFilterDAO;
import sif3.hits.domain.model.NAPCodeFrame;

@Service
public class NAPCodeFrameService extends BaseService<NAPCodeFrameType, NAPCodeFrameCollectionType, NAPCodeFrame> {

  @Autowired
  private NAPCodeFrameConverter napCodeFrameConverter;

  @Autowired
  private NAPCodeFrameDAO napCodeFrameDAO;

  @Autowired
  private NAPCodeFrameFilterDAO napCodeFrameFilterDAO;

  @Override
  protected NAPCodeFrameCollectionType getCollection(List<NAPCodeFrameType> items) {
    NAPCodeFrameCollectionType napCodeFrameCollectionType = new NAPCodeFrameCollectionType();
    if (items != null) {
      napCodeFrameCollectionType.getNAPCodeFrame().addAll(items);
    }
    return napCodeFrameCollectionType;
  }

  @Override
  protected HitsConverter<NAPCodeFrameType, NAPCodeFrame> getConverter() {
    return napCodeFrameConverter;
  }

  @Override
  protected JpaRepository<NAPCodeFrame, String> getDAO() {
    return napCodeFrameDAO;
  }

  @Override
  protected FilterableRepository<NAPCodeFrame,NAPCodeFrameType> getFilterableDAO() {
    return napCodeFrameFilterDAO;
  }

}
