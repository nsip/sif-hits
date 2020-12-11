package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CensusCollectionType;
import sif.dd.au30.model.CensusReportingListType;
import sif.dd.au30.model.CensusReportingType;
import sif.dd.au30.model.SoftwareVendorInfoContainerType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.CensusCollection;
import sif3.hits.domain.model.CensusReporting;
import sif3.hits.utils.UsesConstants;

@Component
public class CensusCollectionConverter extends HitsConverter<CensusCollectionType, CensusCollection>
		implements UsesConstants {

	@Autowired
	HitsConverter<CensusReportingType, CensusReporting> censusReportingConverter;

	public CensusCollectionConverter() {
		super(CensusCollectionType.class, CensusCollection.class);
	}

	@Override
	public void toSifModel(CensusCollection source, CensusCollectionType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setCensusYear(getYearValue(source.getCensusYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(
					objectFactory.createAddressCollectionTypeReportingAuthorityCommonwealthId(
							source.getReportingAuthorityCommonwealthId()));

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareProduct(), source.getSoftwareVersion());
			target.setSoftwareVendorInfo(
					objectFactory.createCensusCollectionTypeSoftwareVendorInfo(softwareVendorInfoContainerType));

			List<CensusReportingType> censusReportingTypes = censusReportingConverter
					.toSifModelList(source.getCensusReportingList());
			CensusReportingListType censusReportingListType = null;
			if (!censusReportingTypes.isEmpty()) {
				censusReportingListType = objectFactory.createCensusReportingListType();
				censusReportingListType.getCensusReporting().addAll(censusReportingTypes);
			}
			target.setCensusReportingList(
					objectFactory.createCensusCollectionTypeCensusReportingList(censusReportingListType));
		}
	}

	@Override
	public void toHitsModel(CensusCollectionType source, CensusCollection target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setCensusYear(getYearValue(source.getCensusYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareVendorInfo());
			target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
			target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());

			if (target.getCensusReportingList() == null) {
				target.setCensusReportingList(new ArrayList<>());
			}
			target.getCensusReportingList().clear();
			CensusReportingListType censusReportingListType = getJAXBValue(source.getCensusReportingList());
			if (censusReportingListType != null) {
				List<CensusReporting> censusReportingList = censusReportingConverter
						.toHitsModelList(censusReportingListType.getCensusReporting());
				for (CensusReporting censusReporting : censusReportingList) {
					target.getCensusReportingList().add(censusReporting);
					censusReporting.setCensusCollection(target);
				}
			}
		}
	}
}