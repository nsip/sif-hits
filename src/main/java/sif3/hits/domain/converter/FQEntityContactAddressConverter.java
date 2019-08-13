package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.StatisticalAreaType;
import sif.dd.au30.model.StatisticalAreasType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQEntityContactAddress;
import sif3.hits.domain.model.FQEntityContactAddressStatisticalArea;

import java.util.ArrayList;

@Component
public class FQEntityContactAddressConverter extends FQBaseEntityContactAddressConverter<FQEntityContactAddress> {

    @Autowired
    FQEntityContactAddressStatisticalAreaConverter fqEntityContactAddressStatisticalAreaConverter;

    public FQEntityContactAddressConverter() {
        super(FQEntityContactAddress.class);
    }

    @Override
    public void toSifModel(FQEntityContactAddress source, AddressType target) {
        if (source != null && target != null) {
            super.toSifModel(source, target);
            IObjectFactory objectFactory = getObjectFactory();
            if (source.getStatisticalAreas() != null) {
                StatisticalAreasType statisticalAreasType = objectFactory.createStatisticalAreasType();
                for (FQEntityContactAddressStatisticalArea statisticalArea : source.getStatisticalAreas()) {
                    StatisticalAreaType statisticalAreaType = fqEntityContactAddressStatisticalAreaConverter.toSifModel(statisticalArea);
                    if (statisticalAreaType != null) {
                        statisticalAreasType.getStatisticalArea().add(statisticalAreaType);
                    }
                }
                if (!statisticalAreasType.getStatisticalArea().isEmpty()) {
                    target.setStatisticalAreas(objectFactory.createAddressTypeStatisticalAreas(statisticalAreasType));
                }
            }
        }
    }

    @Override
    public void toHitsModel(AddressType source, FQEntityContactAddress target) {
        if (source != null && target != null) {
            super.toHitsModel(source, target);
            if (target.getStatisticalAreas() == null) {
                target.setStatisticalAreas(new ArrayList<>());
            }

            StatisticalAreasType statisticalAreasType = getJAXBValue(source.getStatisticalAreas());
            target.getStatisticalAreas().clear();
            if (statisticalAreasType != null) {
                for (StatisticalAreaType statisticalAreaType : statisticalAreasType.getStatisticalArea()) {
                    FQEntityContactAddressStatisticalArea statisticalArea = fqEntityContactAddressStatisticalAreaConverter.toHitsModel(statisticalAreaType);
                    if (statisticalArea != null) {
                        statisticalArea.setAddress(target);
                        target.getStatisticalAreas().add(statisticalArea);
                    }
                }
            }
        }
    }

}
