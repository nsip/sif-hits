package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.ObjectFactory;
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
      target.setFamilyName(objectFactory.createBaseNameTypeFamilyName(source.getFamilyName()));
      target.setGivenName(objectFactory.createBaseNameTypeGivenName(source.getGivenName()));
      target.setMiddleName(objectFactory.createBaseNameTypeMiddleName(source.getMiddleName()));
      target.setPreferredGivenName(objectFactory.createBaseNameTypePreferredGivenName(source.getPreferredGivenName()));
      if (source instanceof StaffPerson) {
        StaffPerson staffSource = (StaffPerson) source;
        target.setTitle(objectFactory.createBaseNameTypeTitle(staffSource.getSalutation()));
      }
    }
  }

  @Override
  public void toHitsModel(NameOfRecordType source, Person target) {
    if (source != null && target != null) {
      target.setFamilyName(getJAXBValue(source.getFamilyName()));
      target.setGivenName(getJAXBValue(source.getGivenName()));
      target.setMiddleName(getJAXBValue(source.getMiddleName()));
      target.setPreferredGivenName(getJAXBValue(source.getPreferredGivenName()));
      if (target instanceof StaffPerson) {
        StaffPerson staffTarget = (StaffPerson) target;
        staffTarget.setSalutation(getJAXBValue(source.getTitle()));
      }
    }
  }

}
