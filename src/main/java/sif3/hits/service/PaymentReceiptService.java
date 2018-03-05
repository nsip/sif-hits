package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.PaymentReceiptCollectionType;
import sif.dd.au30.model.PaymentReceiptType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.PaymentReceiptConverter;
import sif3.hits.domain.dao.PaymentReceiptDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.PaymentReceiptFilterDAO;
import sif3.hits.domain.model.PaymentReceipt;

@Service
public class PaymentReceiptService extends BaseService<PaymentReceiptType, PaymentReceiptCollectionType, PaymentReceipt> {

  @Autowired
  private PaymentReceiptConverter locationInfoConverter;

  @Autowired
  private PaymentReceiptDAO paymentReceiptDAO;

  @Autowired
  private PaymentReceiptFilterDAO paymentReceiptFilterDAO;

  @Override
  protected PaymentReceiptCollectionType getCollection(List<PaymentReceiptType> items) {
    PaymentReceiptCollectionType result = new PaymentReceiptCollectionType();
    if (items != null) {
      result.getPaymentReceipt().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<PaymentReceiptType, PaymentReceipt> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected JpaRepository<PaymentReceipt, String> getDAO() {
    return paymentReceiptDAO;
  }

  @Override
  protected FilterableRepository<PaymentReceipt,PaymentReceiptType> getFilterableDAO() {
    return paymentReceiptFilterDAO;
  }
}
