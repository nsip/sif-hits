package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.FQReportingEntityContactName;

@Component
public class FQReportingEntityContactNameConverter extends BaseNameTypeConverter<FQReportingEntityContactName> {

	public FQReportingEntityContactNameConverter() {
		super(FQReportingEntityContactName.class);
	}

}
