package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.CensusReportingEntityContactName;

@Component
public class CensusReportingEntityContactNameConverter extends BaseNameTypeConverter<CensusReportingEntityContactName> {

	public CensusReportingEntityContactNameConverter() {
		super(CensusReportingEntityContactName.class);
	}

}
