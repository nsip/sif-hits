package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.ContactFlagsType;
import sif.dd.au30.model.RelationshipType;
import sif.dd.au30.model.StudentContactRelationshipType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentContactRelationship;

@Component
public class StudentContactRelationshipConverter extends HitsConverter<StudentContactRelationshipType, StudentContactRelationship> {

  public StudentContactRelationshipConverter() {
    super(StudentContactRelationshipType.class, StudentContactRelationship.class);
  }

  public void setRefId(StudentContactRelationshipType target, String refId) {
    target.setStudentContactRelationshipRefId(refId);
  }

  @Override
  public void toSifModel(StudentContactRelationship source, StudentContactRelationshipType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setStudentContactRelationshipRefId(source.getRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());
      target.setStudentContactPersonalRefId(source.getStudentContactPersonalRefId());

      if (source.hasRelationship()) {
        RelationshipType relationship = objectFactory.createRelationshipType();
        relationship.setCode(source.getRelationship());
        target.setRelationship(relationship);
      }

      if (source.hasContactFlags()) {
        ContactFlagsType contactFlags = objectFactory.createContactFlagsType();
        contactFlags.setParentLegalGuardian(objectFactory.createContactFlagsTypeParentLegalGuardian(getEnumValue(source.getParentLegalGuardian(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setPickupRights(objectFactory.createContactFlagsTypePickupRights(getEnumValue(source.getPickupRights(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setLivesWith(objectFactory.createContactFlagsTypeLivesWith(getEnumValue(source.getLivesWith(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setAccessToRecords(objectFactory.createContactFlagsTypeAccessToRecords(getEnumValue(source.getAccessToRecords(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setEmergencyContact(objectFactory.createContactFlagsTypeEmergencyContact(getEnumValue(source.getEmergencyContact(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setHasCustody(objectFactory.createContactFlagsTypeHasCustody(getEnumValue(source.getHasCustody(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setDisciplinaryContact(objectFactory.createContactFlagsTypeDisciplinaryContact(getEnumValue(source.getDisciplinaryContact(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setPrimaryCareProvider(objectFactory.createContactFlagsTypePrimaryCareProvider(getEnumValue(source.getPrimaryCareProvider(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setFeesBilling(objectFactory.createContactFlagsTypeFeesBilling(getEnumValue(source.getFeesBilling(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setFamilyMail(objectFactory.createContactFlagsTypeFamilyMail(getEnumValue(source.getFamilyMail(), AUCodeSetsYesOrNoCategoryType.class)));
        contactFlags.setInterventionOrder(objectFactory.createContactFlagsTypeInterventionOrder(getEnumValue(source.getInterventionOrder(), AUCodeSetsYesOrNoCategoryType.class)));
        target.setContactFlags(objectFactory.createStudentContactRelationshipTypeContactFlags(contactFlags));
      }
    }
  }

  @Override
  public void toHitsModel(StudentContactRelationshipType source, StudentContactRelationship target) {
    if (source != null && target != null) {
      target.setRefId(source.getStudentContactRelationshipRefId());
      target.setStudentContactPersonalRefId(source.getStudentContactPersonalRefId());
      target.setStudentPersonalRefId(source.getStudentPersonalRefId());

      if (source.getRelationship() != null) {
        target.setRelationship(source.getRelationship().getCode());
      }
      ContactFlagsType contactFlags = getJAXBValue(source.getContactFlags());
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
