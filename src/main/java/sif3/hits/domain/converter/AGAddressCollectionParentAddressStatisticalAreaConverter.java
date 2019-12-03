package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.AGAddressCollectionReportingParentAddressStatisticalArea;

@Component
public class AGAddressCollectionParentAddressStatisticalAreaConverter extends
		FQBaseEntityContactAddressStatisticalAreaConverter<AGAddressCollectionReportingParentAddressStatisticalArea> {

	public AGAddressCollectionParentAddressStatisticalAreaConverter() {
		super(AGAddressCollectionReportingParentAddressStatisticalArea.class);
	}

}
