package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.InvoiceFilterDAO;
import sif3.hits.domain.model.Invoice;

@Repository
public class InvoiceFilterDAOImpl extends BaseFilterableRepository<Invoice>implements InvoiceFilterDAO {
  public InvoiceFilterDAOImpl() {
    super(Invoice.class);
  }
}
