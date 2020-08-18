package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGParentType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif3.hits.domain.model.AddressCollectionReportingParent;

@Component
public class AddressCollectionReportingParentConverter
		extends HitsConverter<AGParentType, AddressCollectionReportingParent> {

	@Autowired
	AddressCollectionReportingParentNameConverter nameConverter;

	@Autowired
	AddressCollectionReportingParentAddressConverter addressConverter;

	public AddressCollectionReportingParentConverter() {
		super(AGParentType.class, AddressCollectionReportingParent.class);
	}

	@Override
	public void toSifModel(AddressCollectionReportingParent source, AGParentType target) {
		if (source != null && target != null) {
			target.setParentName(nameConverter.toSifModel(source.getParentName()));
			target.setParentAddress(addressConverter.toSifModel(source.getParentAddress()));
			target.setAddressSameAsStudent(
					getEnumValue(source.getAddressSameAsStudent(), AUCodeSetsYesOrNoCategoryType.class));
		}
	}

	@Override
	public void toHitsModel(AGParentType source, AddressCollectionReportingParent target) {
		if (source != null && target != null) {
			target.setParentName(nameConverter.toHitsModel(source.getParentName()));
			target.setParentAddress(addressConverter.toHitsModel(source.getParentAddress()));
			target.setAddressSameAsStudent(getEnumValue(source.getAddressSameAsStudent()));

			if (target.getParentName() != null) {
				target.getParentName().setParent(target);
			}
			if (target.getParentAddress() != null) {
				target.getParentAddress().setParent(target);
			}
		}
	}
}