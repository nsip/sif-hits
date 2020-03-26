package sif3.hits.domain.converter;

import sif.dd.au30.model.LearningStandardType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LearningStandard;

public class LearningStandardConverter extends HitsConverter<LearningStandardType, LearningStandard> {

	public LearningStandardConverter() {
		super(LearningStandardType.class, LearningStandard.class);
	}

	@Override
	public void toSifModel(LearningStandard source, LearningStandardType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setLearningStandardItemRefId(objectFactory
					.createLearningStandardTypeLearningStandardItemRefId(source.getLearningStandardItemRefId()));
			target.setLearningStandardURL(
					objectFactory.createLearningStandardTypeLearningStandardURL(source.getLearningStandardURL()));
			target.setLearningStandardLocalId(objectFactory
					.createLearningStandardTypeLearningStandardLocalId(source.getLearningStandardLocalId()));
		}
	}

	@Override
	public void toHitsModel(LearningStandardType source, LearningStandard target) {
		if (source != null && target != null) {
			target.setLearningStandardItemRefId(getJAXBValue(source.getLearningStandardItemRefId()));
			target.setLearningStandardURL(getJAXBValue(source.getLearningStandardURL()));
			target.setLearningStandardLocalId(getJAXBValue(source.getLearningStandardLocalId()));
		}
	}

}
