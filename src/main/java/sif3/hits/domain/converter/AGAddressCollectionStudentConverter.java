package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGParentType;
import sif.dd.au30.model.AUCodeSetsBoardingType;
import sif.dd.au30.model.AUCodeSetsEducationLevelType;
import sif.dd.au30.model.AddressCollectionStudentType;
import sif.dd.au30.model.AddressType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGAddressCollectionReportingParent;
import sif3.hits.domain.model.AGAddressCollectionReportingStudent;
import sif3.hits.domain.model.AGAddressCollectionReportingStudentAddress;
import sif3.hits.utils.UsesConstants;

@Component
public class AGAddressCollectionStudentConverter extends
		HitsConverter<AddressCollectionStudentType, AGAddressCollectionReportingStudent> implements UsesConstants {

	@Autowired
	AGAddressCollectionStudentAddressConverter addressConverter;

	@Autowired
	AGAddressCollectionParentConverter parentConverter;

	public AGAddressCollectionStudentConverter() {
		super(AddressCollectionStudentType.class, AGAddressCollectionReportingStudent.class);
	}

	@Override
	public void toSifModel(AGAddressCollectionReportingStudent source, AddressCollectionStudentType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setLocalId(source.getLocalId());
			target.setEducationLevel(getEnumValue(source.getEducationLevel(), AUCodeSetsEducationLevelType.class));
			target.setBoardingStatus(objectFactory.createAddressCollectionStudentTypeBoardingStatus(
					getEnumValue(source.getBoardingStatus(), AUCodeSetsBoardingType.class)));

			AddressType addressType = addressConverter.toSifModel(source.getAddress());
			if (addressType != null) {
				target.setStudentAddress(addressType);
			}

			AGParentType parent1 = parentConverter.toSifModel(source.getParent1());
			if (parent1 != null) {
				target.setParent1(parent1);
			}

			AGParentType parent2 = parentConverter.toSifModel(source.getParent2());
			if (parent2 != null) {
				target.setParent2(objectFactory.createAddressCollectionStudentTypeParent2(parent2));
			}
		}
	}

	@Override
	public void toHitsModel(AddressCollectionStudentType source, AGAddressCollectionReportingStudent target) {
		if (source != null && target != null) {
			target.setLocalId(source.getLocalId());
			target.setEducationLevel(getEnumValue(source.getEducationLevel()));
			target.setBoardingStatus(getJAXBEnumValue(source.getBoardingStatus()));
			AGAddressCollectionReportingStudentAddress address = addressConverter
					.toHitsModel(source.getStudentAddress());
			if (address != null) {
				address.setStudent(target);
				target.setAddress(address);
			} else {
				target.setAddress(null);
			}
			AGAddressCollectionReportingParent parent1 = parentConverter.toHitsModel(source.getParent1());
			if (parent1 != null) {
				parent1.setStudent(target);
				target.setParent1(parent1);
			} else {
				target.setParent1(null);
			}
			AGAddressCollectionReportingParent parent2 = parentConverter.toHitsModel(getJAXBValue(source.getParent2()));
			if (parent2 != null) {
				parent2.setStudent(target);
				target.setParent2(parent2);
			} else {
				target.setParent2(null);
			}
		}
	}

}