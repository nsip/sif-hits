package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.DebtorCollectionType;
import sif.dd.au30.model.DebtorType;
import sif3.hits.domain.converter.DebtorConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.DebtorDAO;
import sif3.hits.domain.dao.filter.DebtorFilterDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.Debtor;

@Service
public class DebtorService extends BaseService<DebtorType, DebtorCollectionType, Debtor> {

  @Autowired
  private DebtorConverter debtorConverter;
  
  @Autowired
  private DebtorDAO debtorDAO;

  @Autowired
  private DebtorFilterDAO debtorFilterDAO;

  @Override
  protected DebtorCollectionType getCollection(List<DebtorType> items) {
    DebtorCollectionType result = new DebtorCollectionType();
    if (items != null) {
      result.getDebtor().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<DebtorType, Debtor> getConverter() {
    return debtorConverter;
  }

  @Override
  protected JpaRepository<Debtor, String> getDAO() {
    return debtorDAO;
  }

  @Override
  protected FilterableRepository<Debtor> getFilterableDAO() {
    return debtorFilterDAO;
  }
}
