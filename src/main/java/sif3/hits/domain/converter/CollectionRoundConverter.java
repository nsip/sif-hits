package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGRoundListType;
import sif.dd.au30.model.AGRoundType;
import sif.dd.au30.model.AUCodeSetsAGCollectionType;
import sif.dd.au30.model.CollectionRoundType;
import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.LocalCodeType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AGRound;
import sif3.hits.domain.model.CollectionRound;
import sif3.hits.domain.model.CollectionRoundLocalCode;
import sif3.hits.utils.UsesConstants;

@Component
public class CollectionRoundConverter extends HitsConverter<CollectionRoundType, CollectionRound>
		implements UsesConstants {

	@Autowired
	CollectionRoundLocalCodeConverter collectionRoundLocalCodeConverter;

	@Autowired
	HitsConverter<AGRoundType, AGRound> agRoundConverter;

	public CollectionRoundConverter() {
		super(CollectionRoundType.class, CollectionRound.class);
	}

	@Override
	public void toSifModel(CollectionRound source, CollectionRoundType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setAGCollection(objectFactory.createCollectionRoundTypeAGCollection(
					getEnumValue(source.getAgCollection(), AUCodeSetsAGCollectionType.class)));
			target.setCollectionYear(getYearValue(source.getCollectionYear()));

			AGRoundListType agRoundListType = null;
			List<AGRoundType> agRoundTypes = agRoundConverter.toSifModelList(source.getAgRoundList());
			if (!agRoundTypes.isEmpty()) {
				agRoundListType = objectFactory.createAGRoundListType();
				agRoundListType.getAGRound().addAll(agRoundTypes);
			}
			target.setAGRoundList(agRoundListType);

			List<LocalCodeType> collectionRoundLocalCodeTypes = collectionRoundLocalCodeConverter
					.toSifModelList(source.getLocalCodeList());
			if (!collectionRoundLocalCodeTypes.isEmpty()) {
				LocalCodeListType collectionRoundLocalCodeListType = objectFactory.createLocalCodeListType();
				collectionRoundLocalCodeListType.getLocalCode().addAll(collectionRoundLocalCodeTypes);
				target.setLocalCodeList(
						objectFactory.createCollectionRoundTypeLocalCodeList(collectionRoundLocalCodeListType));
			} else {
				target.setLocalCodeList(null);
			}
		}
	}

	@Override
	public void toHitsModel(CollectionRoundType source, CollectionRound target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setAgCollection(getJAXBEnumValue(source.getAGCollection()));
			target.setCollectionYear(getYearValue(source.getCollectionYear()));

			if (target.getAgRoundList() == null) {
				target.setAgRoundList(new ArrayList<>());
			}
			target.getAgRoundList().clear();
			if (source.getAGRoundList() != null) {
				List<AGRound> agRounds = agRoundConverter.toHitsModelList(source.getAGRoundList().getAGRound());
				for (AGRound agRound : agRounds) {
					target.getAgRoundList().add(agRound);
					agRound.setCollectionRound(target);
				}
			}

			if (target.getLocalCodeList() == null) {
				target.setLocalCodeList(new ArrayList<>());
			}
			target.getLocalCodeList().clear();
			LocalCodeListType localCodeListType = getJAXBValue(source.getLocalCodeList());
			if (localCodeListType != null) {
				List<CollectionRoundLocalCode> localCodes = collectionRoundLocalCodeConverter
						.toHitsModelList(localCodeListType.getLocalCode());
				for (CollectionRoundLocalCode localCode : localCodes) {
					target.getLocalCodeList().add(localCode);
					localCode.setCollectionRound(target);
				}
			}
		}
	}
}