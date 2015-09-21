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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.Debtor;

@Service
public class DebtorService extends BaseService<DebtorType, DebtorCollectionType, Debtor> {

  @Autowired
  private DebtorDAO debtorDAO;

  @Override
  public JpaRepository<Debtor, String> getDAO() {
    return debtorDAO;
  }

  @Override
  public ZoneFilterableRepository<Debtor> getZoneFilterableDAO() {
    return debtorDAO;
  }

  @Autowired
  private DebtorConverter locationInfoConverter;

  @Override
  public HitsConverter<DebtorType, Debtor> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected DebtorCollectionType getCollection(List<DebtorType> items) {
    DebtorCollectionType result = new DebtorCollectionType();
    if (items != null) {
      result.getDebtor().addAll(items);
    }
    return result;
  }

  @Override
  protected Debtor getFiltered(String refId, java.util.List<String> schoolRefIds) {
    Debtor result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = debtorDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
