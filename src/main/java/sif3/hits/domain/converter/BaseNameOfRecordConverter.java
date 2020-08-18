package sif3.hits.domain.converter;

import sif.dd.au30.model.NameOfRecordType;
import sif3.hits.domain.model.BaseNameOfRecord;

public abstract class BaseNameOfRecordConverter<H extends BaseNameOfRecord>
		extends BaseNameConverter<NameOfRecordType, H> {

	protected BaseNameOfRecordConverter(Class<H> hitsClass) {
		super(NameOfRecordType.class, hitsClass);
	}

	@Override
	public NameOfRecordType toSifModel(H source) {
		NameOfRecordType result = null;
		if (source != null && isPopulated(source)) {
			result = super.toSifModel(source);
		}
		return result;
	}
}
