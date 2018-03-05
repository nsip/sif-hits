package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.NAPStudentResponseSetCollectionType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.NAPStudentResponseSetConverter;
import sif3.hits.domain.dao.NAPStudentResponseSetDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.NAPStudentResponseSetFilterDAO;
import sif3.hits.domain.model.NAPStudentResponseSet;

@Service
public class NAPStudentResponseSetService extends BaseService<NAPStudentResponseSetType, NAPStudentResponseSetCollectionType, NAPStudentResponseSet> {
  @Autowired
  private NAPStudentResponseSetConverter napStudentResponseSetConverter;

  @Autowired
  private NAPStudentResponseSetDAO napStudentResponseSetDAO;

  @Autowired
  private NAPStudentResponseSetFilterDAO napStudentResponseSetFilterDAO;

  @Override
  protected NAPStudentResponseSetCollectionType getCollection(List<NAPStudentResponseSetType> items) {
    NAPStudentResponseSetCollectionType result = new NAPStudentResponseSetCollectionType();
    if (items != null) {
      result.getNAPStudentResponseSet().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<NAPStudentResponseSetType, NAPStudentResponseSet> getConverter() {
    return napStudentResponseSetConverter;
  }

  @Override
  protected JpaRepository<NAPStudentResponseSet, String> getDAO() {
    return napStudentResponseSetDAO;
  }

  @Override
  protected FilterableRepository<NAPStudentResponseSet,NAPStudentResponseSetType> getFilterableDAO() {
    return napStudentResponseSetFilterDAO;
  }
}
