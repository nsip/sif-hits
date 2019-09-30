package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.StatisticalAreaType;
import sif.dd.au30.model.StatisticalAreasType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGAddressCollectionReportingEntityContactAddress;
import sif3.hits.domain.model.AGAddressCollectionReportingEntityContactAddressStatisticalArea;

import java.util.ArrayList;

@Component
public class AGAddressCollectionReportingEntityContactAddressConverter extends FQBaseEntityContactAddressConverter<AGAddressCollectionReportingEntityContactAddress> {

    @Autowired
    AGAddressCollectionReportingEntityContactAddressStatisticalAreaConverter statisticalAreaConverter;

    public AGAddressCollectionReportingEntityContactAddressConverter() {
        super(AGAddressCollectionReportingEntityContactAddress.class);
    }

    @Override
    public void toSifModel(AGAddressCollectionReportingEntityContactAddress source, AddressType target) {
        if (source != null && target != null) {
            super.toSifModel(source, target);
            IObjectFactory objectFactory = getObjectFactory();
            if (source.getStatisticalAreas() != null) {
                StatisticalAreasType statisticalAreasType = objectFactory.createStatisticalAreasType();
                for (AGAddressCollectionReportingEntityContactAddressStatisticalArea statisticalArea : source.getStatisticalAreas()) {
                    StatisticalAreaType statisticalAreaType = statisticalAreaConverter.toSifModel(statisticalArea);
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
    public void toHitsModel(AddressType source, AGAddressCollectionReportingEntityContactAddress target) {
        if (source != null && target != null) {
            super.toHitsModel(source, target);
            if (target.getStatisticalAreas() == null) {
                target.setStatisticalAreas(new ArrayList<>());
            }
            target.getStatisticalAreas().clear();
            StatisticalAreasType statisticalAreasType = getJAXBValue(source.getStatisticalAreas());
            if (statisticalAreasType != null) {
                for (StatisticalAreaType statisticalAreaType : statisticalAreasType.getStatisticalArea()) {
                    AGAddressCollectionReportingEntityContactAddressStatisticalArea statisticalArea = statisticalAreaConverter.toHitsModel(statisticalAreaType);
                    if (statisticalArea != null) {
                        statisticalArea.setAddress(target);
                        target.getStatisticalAreas().add(statisticalArea);
                    }
                }
            }
        }
    }

}
