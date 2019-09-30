package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AGAddressCollectionReportingStudentAddressStatisticalArea;

@Component
public class AGAddressCollectionStudentAddressStatisticalAreaConverter extends
		FQBaseEntityContactAddressStatisticalAreaConverter<AGAddressCollectionReportingStudentAddressStatisticalArea> {

	public AGAddressCollectionStudentAddressStatisticalAreaConverter() {
		super(AGAddressCollectionReportingStudentAddressStatisticalArea.class);
	}

}
