package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AddressCollectionReportingEntityContact;
import sif3.hits.domain.model.AddressCollectionReportingEntityContactAddress;
import sif3.hits.domain.model.AddressCollectionReportingEntityContactName;

@Component
public class AddressCollectionReportingEntityContactConverter
		extends BaseEntityContactConverter<AddressCollectionReportingEntityContact> {

	@Autowired
	AddressCollectionReportingEntityContactNameConverter nameConverter;

	@Autowired
	AddressCollectionReportingEntityContactAddressConverter addressConverter;

	public AddressCollectionReportingEntityContactConverter() {
		super(AddressCollectionReportingEntityContact.class);
	}

	@Override
	public void toSifModel(AddressCollectionReportingEntityContact source, EntityContactInfoType target) {
		if (source != null && target != null) {
			super.toSifModel(source, target);
			IObjectFactory objectFactory = getObjectFactory();
			target.setName(nameConverter.toSifModel(source.getName()));
			target.setAddress(
					objectFactory.createEntityContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
		}
	}

	@Override
	public void toHitsModel(EntityContactInfoType source, AddressCollectionReportingEntityContact target) {
		if (source != null && target != null) {
			super.toHitsModel(source, target);
			AddressCollectionReportingEntityContactName name = nameConverter.toHitsModel(source.getName());
			target.setName(name);

			AddressCollectionReportingEntityContactAddress address = addressConverter
					.toHitsModel(getJAXBValue(source.getAddress()));
			target.setAddress(address);
		}
	}
}