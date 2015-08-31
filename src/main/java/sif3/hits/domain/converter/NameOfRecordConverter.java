package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.Person;
import sif3.hits.domain.model.StaffPerson;

@Component
public class NameOfRecordConverter extends HitsConverter<NameOfRecordType, Person> {

  public NameOfRecordConverter() {
    super(NameOfRecordType.class, null);
  }

  @Override
  public void toSifModel(Person source, NameOfRecordType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setTitle(objectFactory.createBaseNameTypeTitle(source.getTitle()));
      target.setFamilyName(objectFactory.createBaseNameTypeFamilyName(source.getFamilyName()));
      target.setGivenName(objectFactory.createBaseNameTypeGivenName(source.getGivenName()));
      target.setMiddleName(objectFactory.createBaseNameTypeMiddleName(source.getMiddleName()));
      target
          .setPreferredFamilyName(objectFactory.createBaseNameTypePreferredFamilyName(source.getPreferredFamilyName()));
      target.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName(source.getPreferredGivenName()));
      target.setFullName(objectFactory.createBaseNameTypeFullName(source.getFullName()));
      if (source instanceof StaffPerson) {
        StaffPerson staffSource = (StaffPerson) source;
        target.setTitle(objectFactory.createBaseNameTypeTitle(staffSource.getSalutation()));
      }
    }
  }

  @Override
  public void toHitsModel(NameOfRecordType source, Person target) {
    if (source != null && target != null) {
      target.setTitle(getJAXBValue(source.getTitle()));
      target.setFamilyName(getJAXBValue(source.getFamilyName()));
      target.setGivenName(getJAXBValue(source.getGivenName()));
      target.setMiddleName(getJAXBValue(source.getMiddleName()));
      target.setPreferredGivenName(getJAXBValue(source.getPreferredGivenName()));
      target.setPreferredFamilyName(getJAXBValue(source.getPreferredFamilyName()));
      target.setFullName(getJAXBValue(source.getFullName()));
      if (target instanceof StaffPerson) {
        StaffPerson staffTarget = (StaffPerson) target;
        staffTarget.setSalutation(getJAXBValue(source.getTitle()));
      }
    }
  }

}
