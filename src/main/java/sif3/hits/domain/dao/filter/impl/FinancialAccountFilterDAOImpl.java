package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.FinancialAccountFilterDAO;
import sif3.hits.domain.model.FinancialAccount;

@Repository
public class FinancialAccountFilterDAOImpl extends BaseFilterableRepository<FinancialAccount>implements FinancialAccountFilterDAO {
  public FinancialAccountFilterDAOImpl() {
    super(FinancialAccount.class);
  }
}
