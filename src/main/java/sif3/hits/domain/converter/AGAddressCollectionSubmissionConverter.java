package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

@Component
public class AGAddressCollectionSubmissionConverter {
//	extends HitsConverter<AGAddressCollectionSubmissionType, AGAddressCollectionSubmission> implements UsesConstants {
//}
//
//    @Autowired
//    AGAddressCollectionSubmissionEntityContactConverter entityContactConverter;
//    
//    @Autowired
//    AGAddressCollectionReportingConverter addressCollectionReportingConverter; 
//    
//    public AGAddressCollectionSubmissionConverter() {
//        super(AGAddressCollectionSubmissionType.class, AGAddressCollectionSubmission.class);
//    }
//
//    @Override
//    public void toSifModel(AGAddressCollectionSubmission source, AGAddressCollectionSubmissionType target) {
//        if (source != null && target != null) {
//            IObjectFactory objectFactory = getObjectFactory();
//            target.setRefId(source.getRefId());
//            
//            target.setAddressCollectionYear(getYearValue(source.getAddressCollectionYear()));
//            target.setReportingAuthority(objectFactory.createAGAddressCollectionSubmissionTypeReportingAuthority(source.getReportingAuthority()));
//            target.setReportingAuthoritySystem(objectFactory.createAGAddressCollectionSubmissionTypeReportingAuthoritySystem(source.getReportingAuthoritySystem()));
//            target.setReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId());
//            target.setSystemSubmission(objectFactory.createAGAddressCollectionSubmissionTypeSystemSubmission(getEnumValue(source.getSystemSubmission(), AUCodeSetsYesOrNoCategoryType.class)));
//            
//            if (StringUtils.isNotBlank(source.getSoftwareProduct()) || StringUtils.isNotBlank(source.getSoftwareVersion())) {
//            	SoftwareVendorInfoContainerType softwareVendorInfoContainerType = objectFactory.createSoftwareVendorInfoContainerType();
//            	softwareVendorInfoContainerType.setSoftwareProduct(source.getSoftwareProduct());
//            	softwareVendorInfoContainerType.setSoftwareVersion(source.getSoftwareVersion());
//            	target.setSoftwareVendorInfo(softwareVendorInfoContainerType);
//            }
//            target.setSubmissionContact(entityContactConverter.toSifModel(source.getEntityContact()));
//            target.setAddressCollectionComments(objectFactory.createAGAddressCollectionSubmissionTypeAddressCollectionComments(source.getAddressCollectionComments()));
//            
//            List<AddressCollectionReportingType> addressCollectionReportingList = addressCollectionReportingConverter.toSifModelList(source.getAddressCollectionReportingList());
//            if (addressCollectionReportingList != null && !addressCollectionReportingList.isEmpty()) {
//            	AddressCollectionReportingListType addressCollectionReportingListType = objectFactory.createAddressCollectionReportingListType();
//            	addressCollectionReportingListType.getAddressCollectionReporting().addAll(addressCollectionReportingList);
//            	target.setAddressCollectionReportingList(objectFactory.createAGAddressCollectionSubmissionTypeAddressCollectionReportingList(addressCollectionReportingListType));
//            }
//        }
//    }
//
//    @Override
//    public void toHitsModel(AGAddressCollectionSubmissionType source, AGAddressCollectionSubmission target) {
//        if (source != null && target != null) {
//            target.setRefId(source.getRefId());
//            target.setAddressCollectionYear(getYearValue(source.getAddressCollectionYear()));
//            target.setReportingAuthority(getJAXBValue(source.getReportingAuthority()));
//            target.setReportingAuthoritySystem(getJAXBValue(source.getReportingAuthoritySystem()));
//            target.setReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId());
//            target.setSystemSubmission(getJAXBEnumValue(source.getSystemSubmission()));
//            SoftwareVendorInfoContainerType softwareVendorInfoContainerType = source.getSoftwareVendorInfo();
//            if (softwareVendorInfoContainerType != null) {
//            	target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
//            	target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());
//            }
//            target.setAddressCollectionComments(getJAXBValue(source.getAddressCollectionComments()));
//            
//            AGAddressCollectionSubmissionEntityContact addressCollectionSubmissionEntityContact = entityContactConverter.toHitsModel(source.getSubmissionContact());
//            if (addressCollectionSubmissionEntityContact != null) {
//            	addressCollectionSubmissionEntityContact.setAgAddressCollectionSubmission(target);
//            	target.setEntityContact(addressCollectionSubmissionEntityContact);
//            }
//            
//            if (target.getAddressCollectionReportingList() == null) {
//            	target.setAddressCollectionReportingList(new ArrayList<>());
//            }
//            target.getAddressCollectionReportingList().clear();
//            
//            AddressCollectionReportingListType addressCollectionReportingListType = getJAXBValue(source.getAddressCollectionReportingList());
//            if (addressCollectionReportingListType != null) {
//            	for (AddressCollectionReportingType addressCollectionReportingType : addressCollectionReportingListType.getAddressCollectionReporting()) {
//            		AGAddressCollectionReporting addressCollectionReporting = addressCollectionReportingConverter.toHitsModel(addressCollectionReportingType);
//            		if (addressCollectionReporting != null) {
//            			addressCollectionReporting.setAgAddressCollectionSubmission(target);
//            			target.getAddressCollectionReportingList().add(addressCollectionReporting);            			
//            		}
//            	}
//            }
//        }
//    }
}