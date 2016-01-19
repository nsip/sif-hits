package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.PersonPictureFilterDAO;
import sif3.hits.domain.model.PersonPicture;

@Repository
public class PersonPictureFilterDAOImpl extends BaseFilterableRepository<PersonPicture>implements PersonPictureFilterDAO {
  public PersonPictureFilterDAOImpl() {
    super(PersonPicture.class);
  }
}
