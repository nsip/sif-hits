package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQEntityContact;
import sif3.hits.domain.model.FQEntityContactAddress;
import sif3.hits.domain.model.FQEntityContactName;

@Component
public class FQEntityContactConverter extends FQBaseEntityContactConverter<FQEntityContact> {

    @Autowired
    FQEntityContactNameConverter fqEntityContactNameConverter;

    @Autowired
    FQEntityContactAddressConverter fqEntityContactAddressConverter;

    public FQEntityContactConverter() {
        super(FQEntityContact.class);
    }

    @Override
    public void toSifModel(FQEntityContact source, EntityContactInfoType target) {
        if (source != null && target != null) {
            super.toSifModel(source, target);
            IObjectFactory objectFactory = getObjectFactory();
            target.setName(fqEntityContactNameConverter.toSifModel(source.getName()));
            target.setAddress(objectFactory.createContactInfoTypeAddress(fqEntityContactAddressConverter.toSifModel(source.getAddress())));
        }
    }

    @Override
    public void toHitsModel(EntityContactInfoType source, FQEntityContact target) {
        if (source != null && target != null) {
            super.toHitsModel(source, target);
            FQEntityContactName name = fqEntityContactNameConverter.toHitsModel(source.getName());
            if (name != null) {
                name.setEntityContact(target);
            }
            target.setName(name);
            FQEntityContactAddress address = fqEntityContactAddressConverter.toHitsModel(getJAXBValue(source.getAddress()));
            if (address != null) {
                address.setEntityContact(target);
            }
            target.setAddress(address);
        }
    }
}