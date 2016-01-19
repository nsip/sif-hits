package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.PaymentReceiptFilterDAO;
import sif3.hits.domain.model.PaymentReceipt;

@Repository
public class PaymentReceiptFilterDAOImpl extends BaseFilterableRepository<PaymentReceipt>implements PaymentReceiptFilterDAO {
  public PaymentReceiptFilterDAOImpl() {
    super(PaymentReceipt.class);
  }
}
