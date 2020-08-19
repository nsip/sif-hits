package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

			if (hasSoftwareVendorInfo(source)) {
				SoftwareVendorInfoContainerType softwareVendorInfoContainerType = objectFactory
						.createSoftwareVendorInfoContainerType();
				softwareVendorInfoContainerType.setSoftwareProduct(source.getSoftwareProduct());
				softwareVendorInfoContainerType.setSoftwareVersion(source.getSoftwareVersion());
				target.setSoftwareVendorInfo(
						objectFactory.createCensusCollectionTypeSoftwareVendorInfo(softwareVendorInfoContainerType));
			} else {
				target.setSoftwareVendorInfo(null);
			}

			List<CensusReportingType> censusReportingTypes = censusReportingConverter
					.toSifModelList(source.getCensusReportingList());
			if (!censusReportingTypes.isEmpty()) {
				CensusReportingListType censusReportingListType = objectFactory.createCensusReportingListType();
				censusReportingListType.getCensusReporting().addAll(censusReportingTypes);
				target.setCensusReportingList(
						objectFactory.createCensusCollectionTypeCensusReportingList(censusReportingListType));
			} else {
				target.setCensusReportingList(null);
			}
		}
	}

	@Override
	public void toHitsModel(CensusCollectionType source, CensusCollection target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setCensusYear(getYearValue(source.getCensusYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getJAXBValue(
					source.getSoftwareVendorInfo());
			if (softwareVendorInfoContainerType != null) {
				target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
				target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());
			} else {
				target.setSoftwareProduct(null);
				target.setSoftwareVersion(null);
			}

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

	private boolean hasSoftwareVendorInfo(CensusCollection source) {
		return StringUtils.isNotBlank(source.getSoftwareProduct())
				|| StringUtils.isNotBlank(source.getSoftwareVersion());
	}
}