package sif3.hits.domain.converter;

import org.apache.commons.lang3.StringUtils;

import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.hits.domain.model.BaseOtherCode;

public abstract class BaseOtherCodeConverter<H extends BaseOtherCode> extends HitsConverter<OtherCode, H> {

	protected BaseOtherCodeConverter(Class<H> hitsClass) {
		super(OtherCode.class, hitsClass);
	}

	@Override
	public OtherCode toSifModel(H source) {
		OtherCode result = null;
		if (source != null && isPopulated(source)) {
			result = super.toSifModel(source);
		}
		return result;
	}

	@Override
	public void toSifModel(H source, OtherCode target) {
		if (source != null && target != null) {
			target.setValue(source.getOtherCode());
			target.setCodeset(source.getCodeset());
		}
	}

	@Override
	public void toHitsModel(OtherCode source, H target) {
		if (source != null && target != null) {
			target.setOtherCode(source.getValue());
			target.setCodeset(source.getCodeset());
		}
	}

	public static boolean isPopulated(BaseOtherCode source) {
		return source != null
				&& (StringUtils.isNotEmpty(source.getOtherCode()) || StringUtils.isNotEmpty(source.getCodeset()));
	}
}
