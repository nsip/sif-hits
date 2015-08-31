package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.RelationshipType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif.dd.au30.model.StudentContactRelationshipType.ContactFlags;
import sif3.hits.domain.converter.factory.ObjectFactory;
import sif3.hits.domain.model.StudentContactRelationship;

@Component
public class StudentContactRelationshipConverter
    extends HitsConverter<StudentContactRelationshipType, StudentContactRelationship> {

  public StudentContactRelationshipConverter() {
    super(StudentContactRelationshipType.class, StudentContactRelationship.class);
  }

  @Override
  public void toSifModel(StudentContactRelationship source, StudentContactRelationshipType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();

      target.setStudentContactRelationshipRefId(
          objectFactory.createStudentContactRelationshipTypeStudentContactRelationshipRefId(source.getRefId()));
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setStudentContactPersonalRefId(source.getStudentContactPersonalRefId());

      if (source.hasRelationship()) {
        RelationshipType relationship = new RelationshipType();
        relationship.setCode(source.getRelationship());
        target.setRelationship(relationship);
      }

      if (source.hasContactFlags()) {
        ContactFlags contactFlags = new ContactFlags();
        contactFlags
            .setParentLegalGuardian(objectFactory.createStudentContactRelationshipTypeContactFlagsParentLegalGuardian(
                getEnumValue(source.getParentLegalGuardian(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setPickupRights(objectFactory.createStudentContactRelationshipTypeContactFlagsPickupRights(
            getEnumValue(source.getPickupRights(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setLivesWith(objectFactory.createStudentContactRelationshipTypeContactFlagsLivesWith(
            getEnumValue(source.getLivesWith(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setAccessToRecords(objectFactory.createStudentContactRelationshipTypeContactFlagsAccessToRecords(
            getEnumValue(source.getAccessToRecords(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setEmergencyContact(objectFactory.createStudentContactRelationshipTypeContactFlagsEmergencyContact(
            getEnumValue(source.getEmergencyContact(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setHasCustody(objectFactory.createStudentContactRelationshipTypeContactFlagsHasCustody(
            getEnumValue(source.getHasCustody(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags
            .setDisciplinaryContact(objectFactory.createStudentContactRelationshipTypeContactFlagsDisciplinaryContact(
                getEnumValue(source.getDisciplinaryContact(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags
            .setPrimaryCareProvider(objectFactory.createStudentContactRelationshipTypeContactFlagsPrimaryCareProvider(
                getEnumValue(source.getPrimaryCareProvider(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setFeesBilling(objectFactory.createStudentContactRelationshipTypeContactFlagsFeesBilling(
            getEnumValue(source.getFeesBilling(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setFamilyMail(objectFactory.createStudentContactRelationshipTypeContactFlagsFamilyMail(
            getEnumValue(source.getFamilyMail(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags
            .setInterventionOrder(objectFactory.createStudentContactRelationshipTypeContactFlagsInterventionOrder(
                getEnumValue(source.getInterventionOrder(), AUCodeSetsYesOrNoCategoryType.class)));
        target.setContactFlags(objectFactory.createStudentContactRelationshipTypeContactFlags(contactFlags));
      }
    }
  }

  @Override
  public void toHitsModel(StudentContactRelationshipType source, StudentContactRelationship target) {
    if (source != null && target != null) {
      target.setRefId(getJAXBValue(source.getStudentContactRelationshipRefId()));
      target.setStudentContactPersonalRefId(source.getStudentContactPersonalRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());

      if (source.getRelationship() != null) {
        target.setRelationship(source.getRelationship().getCode());
      }
      ContactFlags contactFlags = getJAXBValue(source.getContactFlags());
      if (contactFlags != null) {
        target.setParentLegalGuardian(getJAXBEnumValue(contactFlags.getParentLegalGuardian()));
        target.setPickupRights(getJAXBEnumValue(contactFlags.getPickupRights()));
        target.setLivesWith(getJAXBEnumValue(contactFlags.getLivesWith()));
        target.setAccessToRecords(getJAXBEnumValue(contactFlags.getAccessToRecords()));
        target.setEmergencyContact(getJAXBEnumValue(contactFlags.getEmergencyContact()));
        target.setHasCustody(getJAXBEnumValue(contactFlags.getHasCustody()));
        target.setDisciplinaryContact(getJAXBEnumValue(contactFlags.getDisciplinaryContact()));
        target.setPrimaryCareProvider(getJAXBEnumValue(contactFlags.getPrimaryCareProvider()));
        target.setFeesBilling(getJAXBEnumValue(contactFlags.getFeesBilling()));
        target.setFamilyMail(getJAXBEnumValue(contactFlags.getFamilyMail()));
        target.setInterventionOrder(getJAXBEnumValue(contactFlags.getInterventionOrder()));
      }
    }
  }
}
