package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.EntityContactInfoType;
import sif.dd.au30.model.NameType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQReportingEntityContact;
import sif3.hits.domain.model.FQReportingEntityContactAddress;
import sif3.hits.domain.model.FQReportingEntityContactName;

@Component
public class FQReportingEntityContactConverter extends BaseEntityContactConverter<FQReportingEntityContact> {

	@Autowired
	HitsConverter<NameType, FQReportingEntityContactName> nameConverter;

	@Autowired
	HitsConverter<AddressType, FQReportingEntityContactAddress> addressConverter;

	public FQReportingEntityContactConverter() {
		super(FQReportingEntityContact.class);
	}

	@Override
	public void toSifModel(FQReportingEntityContact source, EntityContactInfoType target) {
		if (source != null && target != null) {
			super.toSifModel(source, target);
			IObjectFactory objectFactory = getObjectFactory();
			target.setName(nameConverter.toSifModel(source.getName()));
			target.setAddress(
					objectFactory.createContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
		}
	}

	@Override
	public void toHitsModel(EntityContactInfoType source, FQReportingEntityContact target) {
		if (source != null && target != null) {
			super.toHitsModel(source, target);
			target.setName(nameConverter.toHitsModel(source.getName()));
			target.setAddress(addressConverter.toHitsModel(getJAXBValue(source.getAddress())));
		}
	}
}