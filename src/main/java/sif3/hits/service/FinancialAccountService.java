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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.FinancialAccountFilterDAO;
import sif3.hits.domain.model.FinancialAccount;

@Service
public class FinancialAccountService extends BaseService<FinancialAccountType, FinancialAccountCollectionType, FinancialAccount> {

  @Autowired
  private FinancialAccountConverter financialAccountConverter;

  @Autowired
  private FinancialAccountDAO financialAccountDAO;

  @Autowired
  private FinancialAccountFilterDAO financialAccountFilterDAO;

  @Override
  protected FinancialAccountCollectionType getCollection(List<FinancialAccountType> items) {
    FinancialAccountCollectionType result = new FinancialAccountCollectionType();
    if (items != null) {
      result.getFinancialAccount().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<FinancialAccountType, FinancialAccount> getConverter() {
    return financialAccountConverter;
  }

  @Override
  protected JpaRepository<FinancialAccount, String> getDAO() {
    return financialAccountDAO;
  }

  @Override
  protected FilterableRepository<FinancialAccount,FinancialAccountType> getFilterableDAO() {
    return financialAccountFilterDAO;
  }

}
