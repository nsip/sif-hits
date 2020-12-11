package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AddressCollectionReportingStudentAddressStatisticalArea;

@Component
public class AddressCollectionReportingStudentAddressStatisticalAreaConverter extends
		BaseAddressStatisticalAreaConverter<AddressCollectionReportingStudentAddressStatisticalArea> {

	public AddressCollectionReportingStudentAddressStatisticalAreaConverter() {
		super(AddressCollectionReportingStudentAddressStatisticalArea.class);
	}

}
