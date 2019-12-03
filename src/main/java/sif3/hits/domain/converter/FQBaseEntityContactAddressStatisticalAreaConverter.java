package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.StatisticalAreaType;
import sif3.hits.domain.model.FQBaseEntityContactAddressStatisticalArea;

public abstract class FQBaseEntityContactAddressStatisticalAreaConverter<E extends FQBaseEntityContactAddressStatisticalArea> extends HitsConverter<StatisticalAreaType, E> {

    public FQBaseEntityContactAddressStatisticalAreaConverter(Class<E> modelClass) {
        super(StatisticalAreaType.class, modelClass);
    }

    @Override
    public StatisticalAreaType toSifModel(E source) {
        StatisticalAreaType result = null;
        if (isPopulated(source)) {
            result = super.toSifModel(source);
        }
        return result;
    }

    @Override
    public void toSifModel(E source, StatisticalAreaType target) {
        if (source != null && target != null) {
            target.setSpatialUnitType(source.getSpatialUnitType());
            target.setValue(source.getStatisticalArea());
        }
    }

    @Override
    public void toHitsModel(StatisticalAreaType source, E target) {
        if (source != null && target != null) {
            target.setSpatialUnitType(source.getSpatialUnitType());
            target.setStatisticalArea(source.getValue());
        }
    }

    public static boolean isPopulated(FQBaseEntityContactAddressStatisticalArea source) {
        return source != null && (StringUtils.isNotBlank(source.getSpatialUnitType()) || StringUtils.isNotBlank(source.getStatisticalArea()));
    }

}
