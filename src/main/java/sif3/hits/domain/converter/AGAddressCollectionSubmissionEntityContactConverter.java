package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGAddressCollectionSubmissionEntityContact;
import sif3.hits.domain.model.AGAddressCollectionSubmissionEntityContactAddress;
import sif3.hits.domain.model.AGAddressCollectionSubmissionEntityContactName;

@Component
public class AGAddressCollectionSubmissionEntityContactConverter extends FQBaseEntityContactConverter<AGAddressCollectionSubmissionEntityContact> {

    @Autowired
    AGAddressCollectionSubmissionEntityContactNameConverter nameConverter;

    @Autowired
    AGAddressCollectionSubmissionEntityContactAddressConverter addressConverter;

    public AGAddressCollectionSubmissionEntityContactConverter() {
        super(AGAddressCollectionSubmissionEntityContact.class);
    }

    @Override
    public void toSifModel(AGAddressCollectionSubmissionEntityContact source, EntityContactInfoType target) {
        if (source != null && target != null) {
            super.toSifModel(source, target);
            IObjectFactory objectFactory = getObjectFactory();
            target.setName(nameConverter.toSifModel(source.getName()));
            target.setAddress(objectFactory.createContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
        }
    }

    @Override
    public void toHitsModel(EntityContactInfoType source, AGAddressCollectionSubmissionEntityContact target) {
        if (source != null && target != null) {
            super.toHitsModel(source, target);
            AGAddressCollectionSubmissionEntityContactName name = nameConverter.toHitsModel(source.getName());
            if (name != null) {
                name.setEntityContact(target);
            }
            target.setName(name);
            AGAddressCollectionSubmissionEntityContactAddress address = addressConverter.toHitsModel(getJAXBValue(source.getAddress()));
            if (address != null) {
                address.setEntityContact(target);
            }
            target.setAddress(address);
        }
    }
}