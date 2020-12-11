package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.StatsCohortListType;
import sif.dd.au30.model.StatsCohortType;
import sif.dd.au30.model.StatsCohortYearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StatsCohort;
import sif3.hits.domain.model.StatsCohortYearLevel;
import sif3.hits.utils.UsesConstants;

@Component
public class StatsCohortYearLevelConverter extends HitsConverter<StatsCohortYearLevelType, StatsCohortYearLevel>
		implements UsesConstants {

	@Autowired
	HitsConverter<StatsCohortType, StatsCohort> statsCohortConverter;

	public StatsCohortYearLevelConverter() {
		super(StatsCohortYearLevelType.class, StatsCohortYearLevel.class);
	}

	@Override
	public void toSifModel(StatsCohortYearLevel source, StatsCohortYearLevelType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setCohortYearLevel(getYearLevelType(source.getYearLevel()));

			StatsCohortListType statsCohortListType = null;
			List<StatsCohortType> statsCohortTypes = statsCohortConverter.toSifModelList(source.getStatsCohortList());
			if (!statsCohortTypes.isEmpty()) {
				statsCohortListType = objectFactory.createStatsCohortListType();
				statsCohortListType.getStatsCohort().addAll(statsCohortTypes);
			}
			target.setStatsCohortList(statsCohortListType);
		}
	}

	@Override
	public void toHitsModel(StatsCohortYearLevelType source, StatsCohortYearLevel target) {
		if (source != null && target != null) {
			target.setYearLevel(getYearLevelType(source.getCohortYearLevel()));

			if (target.getStatsCohortList() == null) {
				target.setStatsCohortList(new ArrayList<>());
			}
			target.getStatsCohortList().clear();
			StatsCohortListType statsCohortListType = source.getStatsCohortList();
			if (statsCohortListType != null) {
				List<StatsCohort> statsCohorts = statsCohortConverter
						.toHitsModelList(statsCohortListType.getStatsCohort());
				for (StatsCohort statsCohort : statsCohorts) {
					target.getStatsCohortList().add(statsCohort);
					statsCohort.setStatsCohortYearLevel(target);
				}
			}
		}
	}
}
