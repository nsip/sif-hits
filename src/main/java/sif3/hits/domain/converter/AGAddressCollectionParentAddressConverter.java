package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AddressType;
import sif.dd.au30.model.StatisticalAreaType;
import sif.dd.au30.model.StatisticalAreasType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGAddressCollectionReportingParentAddress;
import sif3.hits.domain.model.AGAddressCollectionReportingParentAddressStatisticalArea;

@Component
public class AGAddressCollectionParentAddressConverter
		extends FQBaseEntityContactAddressConverter<AGAddressCollectionReportingParentAddress> {

	@Autowired
	AGAddressCollectionParentAddressStatisticalAreaConverter statisticalAreaConverter;

	public AGAddressCollectionParentAddressConverter() {
		super(AGAddressCollectionReportingParentAddress.class);
	}

	@Override
	public void toSifModel(AGAddressCollectionReportingParentAddress source, AddressType target) {
		if (source != null && target != null) {
			super.toSifModel(source, target);
			IObjectFactory objectFactory = getObjectFactory();
			if (source.getStatisticalAreas() != null) {
				StatisticalAreasType statisticalAreasType = objectFactory.createStatisticalAreasType();
				for (AGAddressCollectionReportingParentAddressStatisticalArea statisticalArea : source
						.getStatisticalAreas()) {
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
	public void toHitsModel(AddressType source, AGAddressCollectionReportingParentAddress target) {
		if (source != null && target != null) {
			super.toHitsModel(source, target);
			if (target.getStatisticalAreas() == null) {
				target.setStatisticalAreas(new ArrayList<>());
			}
			target.getStatisticalAreas().clear();
			StatisticalAreasType statisticalAreasType = getJAXBValue(source.getStatisticalAreas());
			if (statisticalAreasType != null) {
				for (StatisticalAreaType statisticalAreaType : statisticalAreasType.getStatisticalArea()) {
					AGAddressCollectionReportingParentAddressStatisticalArea statisticalArea = statisticalAreaConverter
							.toHitsModel(statisticalAreaType);
					if (statisticalArea != null) {
						statisticalArea.setAddress(target);
						target.getStatisticalAreas().add(statisticalArea);
					}
				}
			}
		}
	}

}
