package sif3.hits.domain.converter;

import sif.dd.au30.model.LocalCodeType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.BaseLocalCode;

public abstract class BaseLocalCodeConverter<E extends BaseLocalCode> extends HitsConverter<LocalCodeType, E> {

	public BaseLocalCodeConverter(Class<E> modelClass) {
		super(LocalCodeType.class, modelClass);
	}

	@Override
	public void toSifModel(E source, LocalCodeType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setLocalisedCode(source.getLocalisedCode());
			target.setDescription(objectFactory.createLocalCodeTypeDescription(source.getDescription()));
			target.setElement(objectFactory.createLocalCodeTypeElement(source.getElement()));
			target.setListIndex(objectFactory.createLocalCodeTypeListIndex(getBigIntegerValue(source.getListIndex())));
		}
	}

	@Override
	public void toHitsModel(LocalCodeType source, E target) {
		if (source != null && target != null) {
			target.setLocalisedCode(source.getLocalisedCode());
			target.setDescription(getJAXBValue(source.getDescription()));
			target.setElement(getJAXBValue(source.getElement()));
			target.setListIndex(getIntegerValue(getJAXBValue(source.getListIndex())));
		}
	}
}