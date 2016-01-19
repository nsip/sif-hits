package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.InvoiceCollectionType;
import sif.dd.au30.model.InvoiceType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.InvoiceConverter;
import sif3.hits.domain.dao.InvoiceDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.InvoiceFilterDAO;
import sif3.hits.domain.model.Invoice;

@Service
public class InvoiceService extends BaseService<InvoiceType, InvoiceCollectionType, Invoice> {

  @Autowired
  private InvoiceConverter invoiceConverter;

  @Autowired
  private InvoiceDAO invoiceDAO;

  @Autowired
  private InvoiceFilterDAO invoiceFilterDAO;
  
  @Override
  protected InvoiceCollectionType getCollection(List<InvoiceType> items) {
    InvoiceCollectionType result = new InvoiceCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getInvoice().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<InvoiceType, Invoice> getConverter() {
    return invoiceConverter;
  }

  @Override
  protected JpaRepository<Invoice, String> getDAO() {
    return invoiceDAO;
  }
  
  @Override
  protected FilterableRepository<Invoice> getFilterableDAO() {
    return invoiceFilterDAO;
  }
}
