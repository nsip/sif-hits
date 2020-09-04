package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.FQReportingAGRule;

@Component
public class FQReportingAGRuleConverter extends BaseAGRuleConverter<FQReportingAGRule> {

	public FQReportingAGRuleConverter() {
		super(FQReportingAGRule.class);
	}

}
