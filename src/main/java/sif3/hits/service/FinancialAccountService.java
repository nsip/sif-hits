package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.FinancialAccountCollectionType;
import sif.dd.au30.model.FinancialAccountType;
import sif3.hits.domain.converter.FinancialAccountConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.FinancialAccountDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.FinancialAccount;

@Service
public class FinancialAccountService
    extends BaseService<FinancialAccountType, FinancialAccountCollectionType, FinancialAccount> {

  @Autowired
  private FinancialAccountDAO financialAccountDAO;

  @Override
  public JpaRepository<FinancialAccount, String> getDAO() {
    return financialAccountDAO;
  }

  @Override
  public ZoneFilterableRepository<FinancialAccount> getZoneFilterableDAO() {
    return financialAccountDAO;
  }

  @Autowired
  private FinancialAccountConverter locationInfoConverter;

  @Override
  public HitsConverter<FinancialAccountType, FinancialAccount> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected FinancialAccountCollectionType getCollection(List<FinancialAccountType> items) {
    FinancialAccountCollectionType result = new FinancialAccountCollectionType();
    if (items != null) {
      result.getFinancialAccount().addAll(items);
    }
    return result;
  }

  @Override
  protected FinancialAccount getFiltered(String refId, java.util.List<String> schoolRefIds) {
    FinancialAccount result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = financialAccountDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
