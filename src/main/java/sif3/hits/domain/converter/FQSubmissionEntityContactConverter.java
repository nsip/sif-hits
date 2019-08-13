package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQSubmissionEntityContact;
import sif3.hits.domain.model.FQSubmissionEntityContactAddress;
import sif3.hits.domain.model.FQSubmissionEntityContactName;

@Component
public class FQSubmissionEntityContactConverter extends FQBaseEntityContactConverter<FQSubmissionEntityContact> {

    @Autowired
    FQSubmissionEntityContactNameConverter fqSubmissionEntityContactNameConverter;

    @Autowired
    FQSubmissionEntityContactAddressConverter fqSubmissionEntityContactAddressConverter;

    public FQSubmissionEntityContactConverter() {
        super(FQSubmissionEntityContact.class);
    }

    @Override
    public void toSifModel(FQSubmissionEntityContact source, EntityContactInfoType target) {
        if (source != null && target != null) {
            super.toSifModel(source, target);
            IObjectFactory objectFactory = getObjectFactory();
            target.setName(fqSubmissionEntityContactNameConverter.toSifModel(source.getName()));
            target.setAddress(objectFactory.createContactInfoTypeAddress(fqSubmissionEntityContactAddressConverter.toSifModel(source.getAddress())));
        }
    }

    @Override
    public void toHitsModel(EntityContactInfoType source, FQSubmissionEntityContact target) {
        if (source != null && target != null) {
            super.toHitsModel(source, target);
            FQSubmissionEntityContactName name = fqSubmissionEntityContactNameConverter.toHitsModel(source.getName());
            if (name != null) {
                name.setEntityContact(target);
            }
            target.setName(name);
            FQSubmissionEntityContactAddress address = fqSubmissionEntityContactAddressConverter.toHitsModel(getJAXBValue(source.getAddress()));
            if (address != null) {
                address.setEntityContact(target);
            }
            target.setAddress(address);
        }
    }
}