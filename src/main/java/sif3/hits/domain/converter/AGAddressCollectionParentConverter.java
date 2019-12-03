package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGParentType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif3.hits.domain.model.AGAddressCollectionReportingParent;
import sif3.hits.domain.model.AGAddressCollectionReportingParentAddress;
import sif3.hits.domain.model.AGAddressCollectionReportingParentName;

@Component
public class AGAddressCollectionParentConverter
		extends HitsConverter<AGParentType, AGAddressCollectionReportingParent> {

	@Autowired
	AGAddressCollectionParentNameConverter nameConverter;

	@Autowired
	AGAddressCollectionParentAddressConverter addressConverter;

	public AGAddressCollectionParentConverter() {
		super(AGParentType.class, AGAddressCollectionReportingParent.class);
	}

	@Override
	public void toSifModel(AGAddressCollectionReportingParent source, AGParentType target) {
		if (source != null && target != null) {
			target.setAddressSameAsStudent(
					getEnumValue(source.getAddressSameAsStudent(), AUCodeSetsYesOrNoCategoryType.class));
			target.setParentName(nameConverter.toSifModel(source.getName()));
			target.setParentAddress(addressConverter.toSifModel(source.getAddress()));
		}
	}

	@Override
	public void toHitsModel(AGParentType source, AGAddressCollectionReportingParent target) {
		if (source != null && target != null) {
			target.setAddressSameAsStudent(getEnumValue(source.getAddressSameAsStudent()));

			AGAddressCollectionReportingParentName name = nameConverter.toHitsModel(source.getParentName());
			if (name != null) {
				name.setParent(target);
				target.setName(name);
			}

			AGAddressCollectionReportingParentAddress address = addressConverter.toHitsModel(source.getParentAddress());
			if (address != null) {
				address.setParent(target);
				target.setAddress(address);
			}
		}
	}
}