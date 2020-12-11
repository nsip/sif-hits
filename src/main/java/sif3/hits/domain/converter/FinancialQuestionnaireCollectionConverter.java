package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.FQReportingListType;
import sif.dd.au30.model.FQReportingType;
import sif.dd.au30.model.FinancialQuestionnaireCollectionType;
import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.LocalCodeType;
import sif.dd.au30.model.SoftwareVendorInfoContainerType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQCollectionLocalCode;
import sif3.hits.domain.model.FQReporting;
import sif3.hits.domain.model.FinancialQuestionnaireCollection;

@Component
public class FinancialQuestionnaireCollectionConverter
		extends HitsConverter<FinancialQuestionnaireCollectionType, FinancialQuestionnaireCollection> {

	@Autowired
	HitsConverter<LocalCodeType, FQCollectionLocalCode> fqCollectionLocalCodeConverter;

	@Autowired
	HitsConverter<FQReportingType, FQReporting> fqReportingConverter;

	public FinancialQuestionnaireCollectionConverter() {
		super(FinancialQuestionnaireCollectionType.class, FinancialQuestionnaireCollection.class);
	}

	@Override
	public void toSifModel(FinancialQuestionnaireCollection source, FinancialQuestionnaireCollectionType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setFQYear(getYearValue(source.getFqYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId());

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareProduct(), source.getSoftwareVersion());
			target.setSoftwareVendorInfo(softwareVendorInfoContainerType);

			List<LocalCodeType> localCodeTypes = fqCollectionLocalCodeConverter
					.toSifModelList(source.getLocalCodeList());
			LocalCodeListType addressCollectionLocalCodeListType = null;
			if (!localCodeTypes.isEmpty()) {
				addressCollectionLocalCodeListType = objectFactory.createLocalCodeListType();
				addressCollectionLocalCodeListType.getLocalCode().addAll(localCodeTypes);
			}
			target.setLocalCodeList(
					objectFactory.createAddressCollectionTypeLocalCodeList(addressCollectionLocalCodeListType));

			List<FQReportingType> fqReportingTypes = fqReportingConverter.toSifModelList(source.getFqReportingList());
			FQReportingListType fqReportingListType = null;
			if (!fqReportingTypes.isEmpty()) {
				fqReportingListType = objectFactory.createFQReportingListType();
				fqReportingListType.getFQReporting().addAll(fqReportingTypes);
			}
			target.setFQReportingList(
					objectFactory.createFinancialQuestionnaireCollectionTypeFQReportingList(fqReportingListType));
		}
	}

	@Override
	public void toHitsModel(FinancialQuestionnaireCollectionType source, FinancialQuestionnaireCollection target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setFqYear(getYearValue(source.getFQYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId());

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareVendorInfo());
			target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
			target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());

			if (target.getLocalCodeList() == null) {
				target.setLocalCodeList(new ArrayList<>());
			}
			target.getLocalCodeList().clear();
			LocalCodeListType localCodeListType = getJAXBValue(source.getLocalCodeList());
			if (localCodeListType != null) {
				List<FQCollectionLocalCode> localCodes = fqCollectionLocalCodeConverter
						.toHitsModelList(localCodeListType.getLocalCode());
				for (FQCollectionLocalCode localCode : localCodes) {
					localCode.setFqCollection(target);
					target.getLocalCodeList().add(localCode);
				}
			}

			if (target.getFqReportingList() == null) {
				target.setFqReportingList(new ArrayList<>());
			}
			target.getFqReportingList().clear();
			FQReportingListType fqReportingListType = getJAXBValue(source.getFQReportingList());
			if (fqReportingListType != null) {
				List<FQReporting> fqReportings = fqReportingConverter
						.toHitsModelList(fqReportingListType.getFQReporting());
				for (FQReporting fqReporting : fqReportings) {
					fqReporting.setFqCollection(target);
					target.getFqReportingList().add(fqReporting);
				}
			}
		}
	}

}
