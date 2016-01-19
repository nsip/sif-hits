package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.DebtorFilterDAO;
import sif3.hits.domain.model.Debtor;

@Repository
public class DebtorFilterDAOImpl extends BaseFilterableRepository<Debtor>implements DebtorFilterDAO {
  public DebtorFilterDAOImpl() {
    super(Debtor.class);
  }
}
