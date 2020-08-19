package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGRoundType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGRound;
import sif3.hits.utils.UsesConstants;

@Component
public class AGRoundConverter extends HitsConverter<AGRoundType, AGRound> implements UsesConstants {

	public AGRoundConverter() {
		super(AGRoundType.class, AGRound.class);
	}

	@Override
	public void toSifModel(AGRound source, AGRoundType target) {
		if (source != null && target != null) {
			target.setRoundCode(source.getRoundCode());
			target.setRoundName(source.getRoundName());
			target.setStartDate(getDateValue(source.getStartDate()));
			target.setDueDate(getDateValue(source.getDueDate()));
			target.setEndDate(getDateValue(source.getEndDate()));
		}
	}

	@Override
	public void toHitsModel(AGRoundType source, AGRound target) {
		if (source != null && target != null) {
			target.setRoundCode(source.getRoundCode());
			target.setRoundName(source.getRoundName());
			target.setStartDate(getDateValue(source.getStartDate()));
			target.setDueDate(getDateValue(source.getDueDate()));
			target.setEndDate(getDateValue(source.getEndDate()));
		}
	}
}