package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

@Component
public class AGAddressCollectionReportingConverter {
//	
//}
//		extends HitsConverter<AddressCollectionReportingType, AGAddressCollectionReporting> implements UsesConstants {
//
//	@Autowired
//	AGAddressCollectionReportingEntityContactConverter entityContactConverter;
//
//	@Autowired
//	AGAddressCollectionStudentConverter addressCollectionStudentConverter;
//
//	public AGAddressCollectionReportingConverter() {
//		super(AddressCollectionReportingType.class, AGAddressCollectionReporting.class);
//	}
//
//	@Override
//	public void toSifModel(AGAddressCollectionReporting source, AddressCollectionReportingType target) {
//		if (source != null && target != null) {
//			IObjectFactory objectFactory = getObjectFactory();
//
//			target.setAddressCollectionRefId(objectFactory
//					.createAddressCollectionReportingTypeAddressCollectionRefId(source.getAddressCollectionRefId()));
//			target.setEntityLevel(source.getEntityLevel());
//			target.setSchoolInfoRefId(
//					objectFactory.createAddressCollectionReportingTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
//			target.setLocalId(objectFactory.createAddressCollectionReportingTypeLocalId(source.getLocalId()));
//			target.setStateProvinceId(
//					objectFactory.createAddressCollectionReportingTypeStateProvinceId(source.getStateProvinceId()));
//			target.setCommonwealthId(source.getCommonwealthId());
//			target.setACARAId(objectFactory.createAddressCollectionReportingTypeACARAId(source.getAcaraId()));
//			target.setEntityName(objectFactory.createAddressCollectionReportingTypeEntityName(source.getEntityName()));
//
//			target.setEntityContact(entityContactConverter.toSifModel(source.getEntityContact()));
//
//			List<AddressCollectionStudentType> addressCollectionStudentList = addressCollectionStudentConverter
//					.toSifModelList(source.getAddressCollectionStudentList());
//			if (addressCollectionStudentList != null && !addressCollectionStudentList.isEmpty()) {
//				AddressCollectionStudentListType addressCollectionStudentListType = objectFactory
//						.createAddressCollectionStudentListType();
//				addressCollectionStudentListType.getAddressCollectionStudent().addAll(addressCollectionStudentList);
//				target.setAddressCollectionStudentList(
//						objectFactory.createAddressCollectionReportingTypeAddressCollectionStudentList(
//								addressCollectionStudentListType));
//			}
//		}
//	}
//
//	@Override
//	public void toHitsModel(AddressCollectionReportingType source, AGAddressCollectionReporting target) {
//		if (source != null && target != null) {
//			target.setAddressCollectionRefId(getJAXBValue(source.getAddressCollectionRefId()));
//			target.setEntityLevel(source.getEntityLevel());
//			target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
//			target.setLocalId(getJAXBValue(source.getLocalId()));
//			target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
//			target.setCommonwealthId(source.getCommonwealthId());
//			target.setAcaraId(getJAXBValue(source.getACARAId()));
//			target.setEntityName(getJAXBValue(source.getEntityName()));
//
//			AGAddressCollectionReportingEntityContact addressCollectionReportingEntityContact = entityContactConverter
//					.toHitsModel(source.getEntityContact());
//			if (addressCollectionReportingEntityContact != null) {
//				addressCollectionReportingEntityContact.setAgAddressCollectionReporting(target);
//				target.setEntityContact(addressCollectionReportingEntityContact);
//			} else {
//				target.setEntityContact(null);
//			}
//
//			if (target.getAddressCollectionStudentList() == null) {
//				target.setAddressCollectionStudentList(new ArrayList<AGAddressCollectionReportingStudent>());
//			}
//			target.getAddressCollectionStudentList().clear();
//			AddressCollectionStudentListType addressCollectionStudentListType = getJAXBValue(
//					source.getAddressCollectionStudentList());
//			if (addressCollectionStudentListType != null) {
//				List<AGAddressCollectionReportingStudent> addressCollectionReportingStudentList = addressCollectionStudentConverter
//						.toHitsModelList(addressCollectionStudentListType.getAddressCollectionStudent());
//				if (addressCollectionReportingStudentList != null) {
//					for (AGAddressCollectionReportingStudent addressCollectionReportingStudent : addressCollectionReportingStudentList) {
//						addressCollectionReportingStudent.setAgAddressCollectionReporting(target);
//						target.getAddressCollectionStudentList().add(addressCollectionReportingStudent);
//					}
//				}
//			}
//		}
//	}
}
