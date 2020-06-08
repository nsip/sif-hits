package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.SubjectAreaType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.SubjectArea;
import sif3.hits.domain.model.SubjectAreaOtherCode;

@Component
public class SubjectAreaConverter extends HitsConverter<SubjectAreaType, SubjectArea> {

	@Autowired
	SubjectAreaCodeConverter subjectAreaCodeConverter;

	public SubjectAreaConverter() {
		super(SubjectAreaType.class, SubjectArea.class);
	}

	@Override
	public void toSifModel(SubjectArea source, SubjectAreaType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setCode(source.getCode());

			List<OtherCode> otherCodes = subjectAreaCodeConverter.toSifModelList(source.getOtherCodes());
			if (!otherCodes.isEmpty()) {
				OtherCodeListType otherCodeList = objectFactory.createOtherCodeListType();
				otherCodeList.getOtherCode().addAll(otherCodes);
				objectFactory.createSubjectAreaTypeOtherCodeList(otherCodeList);
				target.setOtherCodeList(objectFactory.createSubjectAreaTypeOtherCodeList(otherCodeList));
			}
		}
	}

	@Override
	public void toHitsModel(SubjectAreaType source, SubjectArea target) {
		if (source != null && target != null) {
			target.setCode(source.getCode());

			if (target.getOtherCodes() == null) {
				target.setOtherCodes(new ArrayList<>());
			}
			target.getOtherCodes().clear();

			OtherCodeListType otherCodeList = getJAXBValue(source.getOtherCodeList());
			if (otherCodeList != null) {
				List<SubjectAreaOtherCode> otherCodes = subjectAreaCodeConverter
						.toHitsModelList(otherCodeList.getOtherCode());
				for (SubjectAreaOtherCode otherCode : otherCodes) {
					otherCode.setSubjectArea(target);
				}
				target.getOtherCodes().addAll(otherCodes);
			}
		}
	}
}
