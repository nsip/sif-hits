package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AddressCollectionReportingListType;
import sif.dd.au30.model.AddressCollectionReportingType;
import sif.dd.au30.model.AddressCollectionType;
import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.LocalCodeType;
import sif.dd.au30.model.SoftwareVendorInfoContainerType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AddressCollection;
import sif3.hits.domain.model.AddressCollectionLocalCode;
import sif3.hits.domain.model.AddressCollectionReporting;
import sif3.hits.utils.UsesConstants;

@Component
public class AddressCollectionConverter extends HitsConverter<AddressCollectionType, AddressCollection>
		implements UsesConstants {

	@Autowired
	AddressCollectionReportingConverter addressCollectionReportingConverter;

	@Autowired
	AddressCollectionLocalCodeConverter addressCollectionLocalCodeConverter;

	public AddressCollectionConverter() {
		super(AddressCollectionType.class, AddressCollection.class);
	}

	@Override
	public void toSifModel(AddressCollection source, AddressCollectionType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setAddressCollectionYear(getYearValue(source.getAddressCollectionYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(
					objectFactory.createAddressCollectionTypeReportingAuthorityCommonwealthId(
							source.getReportingAuthorityCommonwealthId()));

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareProduct(), source.getSoftwareVersion());
			target.setSoftwareVendorInfo(
					objectFactory.createAddressCollectionTypeSoftwareVendorInfo(softwareVendorInfoContainerType));

			List<AddressCollectionReportingType> addressCollectionReportingTypes = addressCollectionReportingConverter
					.toSifModelList(source.getAddressCollectionReportingList());
			AddressCollectionReportingListType addressCollectionReportingListType = null;
			if (!addressCollectionReportingTypes.isEmpty()) {
				addressCollectionReportingListType = objectFactory.createAddressCollectionReportingListType();
				addressCollectionReportingListType.getAddressCollectionReporting()
						.addAll(addressCollectionReportingTypes);
			}
			target.setAddressCollectionReportingList(objectFactory
					.createAddressCollectionTypeAddressCollectionReportingList(addressCollectionReportingListType));

			List<LocalCodeType> addressCollectionLocalCodeTypes = addressCollectionLocalCodeConverter
					.toSifModelList(source.getAddressCollectionLocalCodeList());
			LocalCodeListType addressCollectionLocalCodeListType = null;
			if (!addressCollectionLocalCodeTypes.isEmpty()) {
				addressCollectionLocalCodeListType = objectFactory.createLocalCodeListType();
				addressCollectionLocalCodeListType.getLocalCode().addAll(addressCollectionLocalCodeTypes);
			}
			target.setLocalCodeList(
					objectFactory.createAddressCollectionTypeLocalCodeList(addressCollectionLocalCodeListType));
		}
	}

	@Override
	public void toHitsModel(AddressCollectionType source, AddressCollection target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setAddressCollectionYear(getYearValue(source.getAddressCollectionYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));
			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareVendorInfo());
			target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
			target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());

			if (target.getAddressCollectionReportingList() == null) {
				target.setAddressCollectionReportingList(new ArrayList<>());
			}
			target.getAddressCollectionReportingList().clear();
			AddressCollectionReportingListType addressCollectionReportingListType = getJAXBValue(
					source.getAddressCollectionReportingList());
			if (addressCollectionReportingListType != null) {
				List<AddressCollectionReporting> addressCollectionReportingList = addressCollectionReportingConverter
						.toHitsModelList(addressCollectionReportingListType.getAddressCollectionReporting());
				for (AddressCollectionReporting addressCollectionReporting : addressCollectionReportingList) {
					target.getAddressCollectionReportingList().add(addressCollectionReporting);
					addressCollectionReporting.setAddressCollection(target);
				}
			}

			if (target.getAddressCollectionLocalCodeList() == null) {
				target.setAddressCollectionLocalCodeList(new ArrayList<>());
			}
			target.getAddressCollectionLocalCodeList().clear();
			LocalCodeListType addressCollectionLocalCodeListType = getJAXBValue(source.getLocalCodeList());
			if (addressCollectionLocalCodeListType != null) {
				List<AddressCollectionLocalCode> addressCollectionLocalCodeList = addressCollectionLocalCodeConverter
						.toHitsModelList(addressCollectionLocalCodeListType.getLocalCode());
				for (AddressCollectionLocalCode addressCollectionLocalCode : addressCollectionLocalCodeList) {
					target.getAddressCollectionLocalCodeList().add(addressCollectionLocalCode);
					addressCollectionLocalCode.setAddressCollection(target);
				}
			}
		}
	}
}