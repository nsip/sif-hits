package sif3.hits.rest.consumer.data;

import java.util.Arrays;
import java.util.List;

import sif.dd.au30.model.AddressListType;
import sif.dd.au30.model.DebtorCollectionType;
import sif.dd.au30.model.DebtorType;
import sif.dd.au30.model.DebtorType.BilledEntity;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.utils.RefIdGenerator;

public class DebtorTestData extends TestData<DebtorType, DebtorCollectionType> {

	public static final String REF_ID_1 = "6aef3adf-18e3-4ee0-823f-a39aa60bd19b";
	public static final String REF_ID_2 = "0d7871ea-8f69-4255-8d5c-735e173eb902";
	public static final String REF_ID_3 = "729d1d69-89fa-4460-b55b-2ff9405ebde1";
	public static final String REF_ID_4 = "b80ee35f-b421-4b9b-b85e-59903a3aa7f7";
	public static final String REF_ID_5 = "cda3361e-d7be-4502-bbe5-7c8ea8b566b6";

	public static final String[] REF_ID_RA = { REF_ID_1, REF_ID_2, REF_ID_3, REF_ID_4, REF_ID_5 };
	public static final List<String> REF_ID_LIST = Arrays.asList(REF_ID_RA);

	public static final String XML_REF_ID_1 = "512bf740-42e5-4f32-97ac-dfb61c745ef3";
	public static final String XML_REF_ID_2 = "84267dc1-223c-491d-90c4-b6954f079631";

	public static final String[] XML_REF_ID_RA = { XML_REF_ID_1, XML_REF_ID_2 };
	public static final List<String> XML_REF_ID_LIST = Arrays.asList(XML_REF_ID_RA);

	public static final String BILLED_ENTITY = "VendorInfo";
	public static final String BILLING_NAME = "Billing Name";
	public static final String BILLING_NOTE = "Billing Note";
	public static final String DISCOUNT = "0.05";
	public static final String ADDRESS = "1 Billings Street";

	public DebtorType getTestObject(String refId) {
		IObjectFactory objectFactory = getObjectFactory();
		DebtorType debtorType = new DebtorType();
		debtorType.setRefId(refId);
		debtorType.setLocalId(objectFactory.createDebtorTypeLocalId("local-id"));

		BilledEntity billedEntity = objectFactory.createDebtorTypeBilledEntity();
		billedEntity.setValue(VendorInfoTestData.REF_ID_1);
		billedEntity.setSIFRefObject(BILLED_ENTITY);
		debtorType.setBilledEntity(billedEntity);

		debtorType.setBillingName(objectFactory.createDebtorTypeBillingName(BILLING_NAME));
		debtorType.setBillingNote(objectFactory.createDebtorTypeBillingNote(BILLING_NOTE));
		debtorType.setDiscount(objectFactory.createDebtorTypeDiscount(DISCOUNT));

		AddressListType addressList = objectFactory.createAddressListType();
		addressList.getAddress().add(getAddress(ADDRESS, null));
		debtorType.setAddressList(objectFactory.createDebtorTypeAddressList(addressList));
		return debtorType;
	}

	@Override
	public List<DebtorType> getExamplesForQuery() {
		IObjectFactory objectFactory = getObjectFactory();
		DebtorType debtorType = new DebtorType();
		BilledEntity billedEntity = objectFactory.createDebtorTypeBilledEntity();
		billedEntity.setValue(VendorInfoTestData.REF_ID_1);
		billedEntity.setSIFRefObject(BILLED_ENTITY);
		debtorType.setBilledEntity(billedEntity);
		return Arrays.asList(debtorType);
	}

	@Override
	public boolean isExampleObject(DebtorType object, int index) {
		return object != null && object.getBilledEntity() != null
				&& BILLED_ENTITY.equals(object.getBilledEntity().getSIFRefObject())
				&& VendorInfoTestData.REF_ID_1.equals(object.getBilledEntity().getValue());
	}

	public String getRefId(int index) {
		String result = null;
		if (index >= 0 && index < REF_ID_RA.length) {
			result = REF_ID_RA[index];
		} else {
			result = RefIdGenerator.getRefId();
		}
		return result;
	}

	public DebtorCollectionType getTestCollection(String... refIds) {
		DebtorCollectionType result = new DebtorCollectionType();
		for (int i = 0; refIds != null && i < refIds.length; i++) {
			result.getDebtor().add(getTestObject(refIds[i]));
		}
		return result;
	}

	public String getSingleObjectXMLFilename() {
		return "Debtor.xml";
	}

	public String getMultiObjectXMLFilename() {
		return "Debtors.xml";
	}

}
