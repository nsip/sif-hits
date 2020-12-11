package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.AddressCollectionCollectionType;
import sif.dd.au30.model.AddressCollectionType;
import sif3.hits.domain.converter.AddressCollectionConverter;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.dao.AddressCollectionDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.model.AddressCollection;
import sif3.hits.domain.dao.filter.AddressCollectionFilterDAO;

@Service
public class AddressCollectionService extends BaseService<AddressCollectionType, AddressCollectionCollectionType, AddressCollection> {

  @Autowired
  private AddressCollectionConverter addressCollectionConverter;

  @Autowired
  private AddressCollectionDAO addressCollectionDAO;

  @Autowired
  private AddressCollectionFilterDAO addressCollectionFilterDAO;

  @Override
  protected AddressCollectionCollectionType getCollection(List<AddressCollectionType> items) {
    AddressCollectionCollectionType result = new AddressCollectionCollectionType();
    if (items != null) {
      result.getAddressCollection().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<AddressCollectionType, AddressCollection> getConverter() {
    return addressCollectionConverter;
  }

  @Override
  protected JpaRepository<AddressCollection, String> getDAO() {
    return addressCollectionDAO;
  }

  @Override
  protected FilterableRepository<AddressCollection,AddressCollectionType> getFilterableDAO() {
    return addressCollectionFilterDAO;
  }
}
