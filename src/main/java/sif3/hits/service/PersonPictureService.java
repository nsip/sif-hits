package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.PersonPictureCollectionType;
import sif.dd.au30.model.PersonPictureType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.PersonPictureConverter;
import sif3.hits.domain.dao.PersonPictureDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.PersonPictureFilterDAO;
import sif3.hits.domain.model.PersonPicture;

@Service
public class PersonPictureService extends BaseService<PersonPictureType, PersonPictureCollectionType, PersonPicture> {

  @Autowired
  private PersonPictureConverter personPictureConverter;

  @Autowired
  private PersonPictureDAO personPictureDAO;

  @Autowired
  private PersonPictureFilterDAO personPictureFilterDAO;

  @Override
  protected PersonPictureCollectionType getCollection(List<PersonPictureType> items) {
    PersonPictureCollectionType result = new PersonPictureCollectionType();
    if (items != null) {
      result.getPersonPicture().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<PersonPictureType, PersonPicture> getConverter() {
    return personPictureConverter;
  }

  @Override
  protected JpaRepository<PersonPicture, String> getDAO() {
    return personPictureDAO;
  }

  @Override
  protected FilterableRepository<PersonPicture> getFilterableDAO() {
    return personPictureFilterDAO;
  }
}
