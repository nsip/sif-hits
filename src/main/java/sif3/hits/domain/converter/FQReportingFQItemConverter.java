package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.FQItemType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQItem;

@Component
public class FQReportingFQItemConverter extends HitsConverter<FQItemType, FQItem> {

	public FQReportingFQItemConverter() {
		super(FQItemType.class, FQItem.class);
	}

	@Override
	public void toSifModel(FQItem source, FQItemType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setFQItemCode(source.getFqItemCode());
			target.setTuitionAmount(
					objectFactory.createFQItemTypeTuitionAmount(getBigDecimalValue(source.getTuitionAmount())));
			target.setBoardingAmount(
					objectFactory.createFQItemTypeBoardingAmount(getBigDecimalValue(source.getBoardingAmount())));
			target.setSystemAmount(
					objectFactory.createFQItemTypeSystemAmount(getBigDecimalValue(source.getSystemAmount())));
			target.setDioceseAmount(
					objectFactory.createFQItemTypeDioceseAmount(getBigDecimalValue(source.getDioceseAmount())));
			target.setFQComments(objectFactory.createFQItemTypeFQComments(source.getFqComments()));
		}
	}

	@Override
	public void toHitsModel(FQItemType source, FQItem target) {
		if (source != null && target != null) {
			target.setFqItemCode(source.getFQItemCode());
			target.setTuitionAmount(getBigDecimalValue(getJAXBValue(source.getTuitionAmount())));
			target.setBoardingAmount(getBigDecimalValue(getJAXBValue(source.getBoardingAmount())));
			target.setSystemAmount(getBigDecimalValue(getJAXBValue(source.getSystemAmount())));
			target.setDioceseAmount(getBigDecimalValue(getJAXBValue(source.getDioceseAmount())));
			target.setFqComments(getJAXBValue(source.getFQComments()));
		}
	}
}
