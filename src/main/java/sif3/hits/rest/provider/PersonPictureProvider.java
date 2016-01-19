package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.PersonPictureCollectionType;
import sif.dd.au30.model.PersonPictureType;
import sif3.hits.domain.model.PersonPicture;
import sif3.hits.service.PersonPictureService;

public class PersonPictureProvider extends HitsBaseProvider<PersonPictureType, PersonPictureCollectionType, PersonPicture, PersonPictureService> {

  protected static final Logger L = LoggerFactory.getLogger(PersonPictureProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public PersonPictureProvider() {
    super(PersonPictureType.class, "PersonPicture", PersonPictureCollectionType.class, "PersonPictures", PersonPictureService.class);
  }
}
