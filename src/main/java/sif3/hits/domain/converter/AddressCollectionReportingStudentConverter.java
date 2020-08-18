package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsBoardingType;
import sif.dd.au30.model.AUCodeSetsEducationLevelType;
import sif.dd.au30.model.AddressCollectionStudentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AddressCollectionReportingStudent;
import sif3.hits.utils.UsesConstants;

@Component
public class AddressCollectionReportingStudentConverter extends
		HitsConverter<AddressCollectionStudentType, AddressCollectionReportingStudent> implements UsesConstants {

	@Autowired
	AddressCollectionReportingStudentAddressConverter addressConverter;

	@Autowired
	AddressCollectionReportingParentConverter parentConverter;

	public AddressCollectionReportingStudentConverter() {
		super(AddressCollectionStudentType.class, AddressCollectionReportingStudent.class);
	}

	@Override
	public void toSifModel(AddressCollectionReportingStudent source, AddressCollectionStudentType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setLocalId(source.getLocalId());
			target.setEducationLevel(getEnumValue(source.getEducationLevel(), AUCodeSetsEducationLevelType.class));
			target.setBoardingStatus(objectFactory.createAddressCollectionStudentTypeBoardingStatus(getEnumValue(source.getBoardingStatus(), AUCodeSetsBoardingType.class)));
			target.setReportingParent2(source.getReportingParent2());
			
			target.setStudentAddress(addressConverter.toSifModel(source.getStudentAddress()));
			target.setParent1(parentConverter.toSifModel(source.getParent1()));
			target.setParent2(objectFactory.createAddressCollectionStudentTypeParent2(parentConverter.toSifModel(source.getParent2())));
		}
	}

	@Override
	public void toHitsModel(AddressCollectionStudentType source, AddressCollectionReportingStudent target) {
		if (source != null && target != null) {
			target.setLocalId(source.getLocalId());
			target.setEducationLevel(getEnumValue(source.getEducationLevel()));
			target.setBoardingStatus(getJAXBEnumValue(source.getBoardingStatus()));
			target.setReportingParent2(source.getReportingParent2());
			
			target.setStudentAddress(addressConverter.toHitsModel(source.getStudentAddress()));
			
			if (target.getParents() == null) {
				target.setParents(new ArrayList<>());
			}
			target.getParents().clear();
			
			target.setParent1(parentConverter.toHitsModel(source.getParent1()));
			target.setParent2(parentConverter.toHitsModel(getJAXBValue(source.getParent2())));
			
			if (target.getStudentAddress() != null) {
				target.getStudentAddress().setStudent(target);
			}
			if (target.getParent1() != null) {
				target.getParent1().setStudent(target);
			}
			if (target.getParent2() != null) {
				target.getParent2().setStudent(target);
			}
		}
	}
}