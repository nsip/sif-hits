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
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.Invoice;
import sif3.hits.rest.dto.RequestDTO;

@Service
public class InvoiceService extends BaseService<InvoiceType, InvoiceCollectionType, Invoice> {

  @Autowired
  private InvoiceDAO invoiceDAO;

  @Autowired
  private InvoiceConverter invoiceConverter;

  @Override
  public JpaRepository<Invoice, String> getDAO() {
    return invoiceDAO;
  }

  @Override
  public ZoneFilterableRepository<Invoice> getZoneFilterableDAO() {
    return invoiceDAO;
  }

  @Override
  public HitsConverter<InvoiceType, Invoice> getConverter() {
    return invoiceConverter;
  }

  @Override
  protected InvoiceCollectionType getCollection(List<InvoiceType> items) {
    InvoiceCollectionType result = new InvoiceCollectionType();
    if (items != null && !items.isEmpty()) {
      result.getInvoice().addAll(items);
    }
    return result;
  }

  @Override
  protected Invoice getFiltered(String refId, List<String> schoolRefIds) {
    Invoice result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = invoiceDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }

  @Override
  protected void delete(Invoice hitsObject, RequestDTO<InvoiceType> dto) {
    super.delete(hitsObject, dto);
  }
}
