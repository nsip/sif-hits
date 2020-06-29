package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif3.hits.domain.model.SubjectAreaOtherCode;

@Component
public class SubjectAreaCodeConverter extends HitsConverter<OtherCode, SubjectAreaOtherCode> {

	public SubjectAreaCodeConverter() {
		super(OtherCode.class, SubjectAreaOtherCode.class);
	}

	@Override
	public void toSifModel(SubjectAreaOtherCode source, OtherCode target) {
		if (source != null && target != null) {
			target.setValue(source.getValue());
			target.setCodeset(source.getCodeset());
		}
	}

	@Override
	public void toHitsModel(OtherCode source, SubjectAreaOtherCode target) {
		if (source != null && target != null) {
			target.setValue(source.getValue());
			target.setCodeset(source.getCodeset());
		}
	}
}
