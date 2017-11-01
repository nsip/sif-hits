package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsPictureSourceType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.PersonPictureType;
import sif.dd.au30.model.PersonPictureType.ParentObjectRefId;
import sif.dd.au30.model.PersonPictureType.PictureSource;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.PersonPicture;
import sif3.hits.utils.UsesConstants;

@Component
public class PersonPictureConverter extends HitsConverter<PersonPictureType, PersonPicture> implements UsesConstants {

  public PersonPictureConverter() {
    super(PersonPictureType.class, PersonPicture.class);
  }

  @Override
  public void toSifModel(PersonPicture source, PersonPictureType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setRefId(source.getRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setOKToPublish(objectFactory.createPersonPictureTypeOKToPublish(getEnumValue(source.getOkToPublish(), AUCodeSetsYesOrNoCategoryType.class)));

      if (source.getParentObjectRefId() != null && source.getParentObjectRefObject() != null) {
        ParentObjectRefId parentObjectRefId = new ParentObjectRefId();
        parentObjectRefId.setValue(source.getParentObjectRefId());
        parentObjectRefId.setSIFRefObject(source.getParentObjectRefObject());
        target.setParentObjectRefId(parentObjectRefId);
      }

      if (source.getPictureSource() != null || source.getPictureSourceType() != null) {
        PictureSource pictureSource = objectFactory.createPersonPictureTypePictureSource();
        pictureSource.setValue(source.getPictureSource());
        pictureSource.setType(getEnumValue(source.getPictureSourceType(), AUCodeSetsPictureSourceType.class));
        target.setPictureSource(pictureSource);
      }
    }
  }

  @Override
  public void toHitsModel(PersonPictureType source, PersonPicture target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setSchoolYear(getYearValue(source.getSchoolYear()));
      target.setOkToPublish(getJAXBEnumValue(source.getOKToPublish()));

      ParentObjectRefId parentObject = source.getParentObjectRefId();
      if (parentObject != null) {
        target.setParentObjectRefId(parentObject.getValue());
        target.setParentObjectRefObject(parentObject.getSIFRefObject());
      }

      PictureSource pictureSource = source.getPictureSource();
      if (pictureSource != null) {
        if (pictureSource.getValue() != null && !pictureSource.getValue().isEmpty()) {
          target.setPictureSource(pictureSource.getValue());
        }
        target.setPictureSourceType(getEnumValue(pictureSource.getType()));
      }
    }
  }

}
