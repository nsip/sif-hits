package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.PersonPictureType;
import sif3.hits.domain.dao.filter.PersonPictureFilterDAO;
import sif3.hits.domain.model.PersonPicture;

@Repository
public class PersonPictureFilterDAOImpl extends BaseFilterableRepository<PersonPicture, PersonPictureType> implements PersonPictureFilterDAO {
    public PersonPictureFilterDAOImpl() {
        super(PersonPicture.class, PersonPictureType.class);
    }
}
