package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGAddressCollectionReportingEntityContact;
import sif3.hits.domain.model.AGAddressCollectionReportingEntityContactAddress;
import sif3.hits.domain.model.AGAddressCollectionReportingEntityContactName;

@Component
public class AGAddressCollectionReportingEntityContactConverter extends FQBaseEntityContactConverter<AGAddressCollectionReportingEntityContact> {

    @Autowired
    AGAddressCollectionReportingEntityContactNameConverter nameConverter;

    @Autowired
    AGAddressCollectionReportingEntityContactAddressConverter addressConverter;

    public AGAddressCollectionReportingEntityContactConverter() {
        super(AGAddressCollectionReportingEntityContact.class);
    }

    @Override
    public void toSifModel(AGAddressCollectionReportingEntityContact source, EntityContactInfoType target) {
        if (source != null && target != null) {
            super.toSifModel(source, target);
            IObjectFactory objectFactory = getObjectFactory();
            target.setName(nameConverter.toSifModel(source.getName()));
            target.setAddress(objectFactory.createContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
        }
    }

    @Override
    public void toHitsModel(EntityContactInfoType source, AGAddressCollectionReportingEntityContact target) {
        if (source != null && target != null) {
            super.toHitsModel(source, target);
            AGAddressCollectionReportingEntityContactName name = nameConverter.toHitsModel(source.getName());
            if (name != null) {
                name.setEntityContact(target);
            }
            target.setName(name);
            AGAddressCollectionReportingEntityContactAddress address = addressConverter.toHitsModel(getJAXBValue(source.getAddress()));
            if (address != null) {
                address.setEntityContact(target);
            }
            target.setAddress(address);
        }
    }
}