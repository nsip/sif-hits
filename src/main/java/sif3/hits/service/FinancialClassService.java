package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.FinancialClassificationCollectionType;
import sif.dd.au30.model.FinancialClassificationType;
import sif3.hits.domain.converter.FinancialClassConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.FinancialClassDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.FinancialClass;

@Service
public class FinancialClassService
    extends BaseService<FinancialClassificationType, FinancialClassificationCollectionType, FinancialClass> {

  @Autowired
  private FinancialClassDAO financialClassDAO;

  @Override
  public JpaRepository<FinancialClass, String> getDAO() {
    return financialClassDAO;
  }

  @Override
  public ZoneFilterableRepository<FinancialClass> getZoneFilterableDAO() {
    return financialClassDAO;
  }

  @Autowired
  private FinancialClassConverter locationInfoConverter;

  @Override
  public HitsConverter<FinancialClassificationType, FinancialClass> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected FinancialClassificationCollectionType getCollection(List<FinancialClassificationType> items) {
    FinancialClassificationCollectionType result = new FinancialClassificationCollectionType();
    if (items != null) {
      result.getFinancialClassification().addAll(items);
    }
    return result;
  }

  @Override
  protected FinancialClass getFiltered(String refId, java.util.List<String> schoolRefIds) {
    FinancialClass result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = financialClassDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
