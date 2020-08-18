package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.AUCodeSetsNameUsageTypeType;
import sif.dd.au30.model.NameType;
import sif3.hits.domain.model.BaseNameType;

public abstract class BaseNameTypeConverter<H extends BaseNameType> extends BaseNameConverter<NameType, H> {

	protected BaseNameTypeConverter(Class<H> hitsClass) {
		super(NameType.class, hitsClass);
	}

	@Override
	public NameType toSifModel(H source) {
		NameType result = null;
		if (source != null && isPopulated(source)) {
			result = super.toSifModel(source);
		}
		return result;
	}

	@Override
	public void toSifModel(H source, NameType target) {
		super.toSifModel(source, target);
		target.setType(getEnumValue(source.getNameType(), AUCodeSetsNameUsageTypeType.class));
	}

	@Override
	public void toHitsModel(NameType source, H target) {
		super.toHitsModel(source, target);
		target.setNameType(getEnumValue(source.getType()));
	}
	
	public static boolean isPopulated(BaseNameType source) {
		return source != null && (BaseNameConverter.isPopulated(source) || StringUtils.isNotEmpty(source.getNameType()));
	}

}
