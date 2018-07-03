package sif3.hits.domain.converter;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.DebtorType;
import sif.dd.au30.model.DebtorType.BilledEntity;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Address;
import sif3.hits.domain.model.Debtor;

@Component
public class DebtorConverter extends HitsConverter<DebtorType, Debtor> {

    @Autowired
    private AddressConverter addressConverter;

    public DebtorConverter() {
        super(DebtorType.class, Debtor.class);
    }

    @Override
    public void toSifModel(Debtor source, DebtorType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());
            if (StringUtils.isNotBlank(source.getBilledEntity()) || StringUtils.isNotBlank(source.getBilledEntitySIFRefObject())) {
                BilledEntity billedEntity = objectFactory.createDebtorTypeBilledEntity();
                billedEntity.setValue(source.getBilledEntity());
                billedEntity.setSIFRefObject(source.getBilledEntitySIFRefObject());
                target.setBilledEntity(billedEntity);
            }
            target.setBillingName(objectFactory.createDebtorTypeBillingName(source.getBillingName()));
            target.setBillingNote(objectFactory.createDebtorTypeBillingNote(source.getBillingNote()));
            target.setDiscount(objectFactory.createDebtorTypeDiscount(source.getDiscount()));

            if (source.getAddresses() != null && !source.getAddresses().isEmpty()) {
                AddressListType addressList = objectFactory.createAddressListType();
                addressList.getAddress().addAll(addressConverter.toSifModelList(source.getAddresses(), AddressType.class));
                target.setAddressList(objectFactory.createDebtorTypeAddressList(addressList));
            }
        }
    }

    @Override
    public void toHitsModel(DebtorType source, Debtor target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            if (source.getBilledEntity() != null) {
                if (StringUtils.isNotBlank(source.getBilledEntity().getValue()) && StringUtils.isNotBlank(source.getBilledEntity().getSIFRefObject())) {
                    target.setBilledEntity(source.getBilledEntity().getValue());
                    target.setBilledEntitySIFRefObject(source.getBilledEntity().getSIFRefObject());
                }
            }
            target.setBillingName(getJAXBValue(source.getBillingName()));
            target.setBillingNote(getJAXBValue(source.getBillingNote()));
            target.setDiscount(getJAXBValue(source.getDiscount()));
            if (target.getAddresses() == null) {
                target.setAddresses(new HashSet<Address>());
            } else {
                target.getAddresses().clear();
            }
            AddressListType addressList = getJAXBValue(source.getAddressList());
            if (addressList != null && addressList.getAddress() != null && !addressList.getAddress().isEmpty()) {
                target.getAddresses().addAll(addressConverter.toHitsModelList(addressList.getAddress()));
                for (Address address : target.getAddresses()) {
                    address.setPersonRefId(target.getRefId());
                }
            }
        }
    }

}
