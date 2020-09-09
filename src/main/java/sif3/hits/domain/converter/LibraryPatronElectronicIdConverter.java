package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsElectronicIdTypeType;
import sif.dd.au30.model.ElectronicIdType;
import sif3.hits.domain.model.LibraryPatronElectronicId;

@Component
public class LibraryPatronElectronicIdConverter extends HitsConverter<ElectronicIdType, LibraryPatronElectronicId> {

	public LibraryPatronElectronicIdConverter() {
		super(ElectronicIdType.class, LibraryPatronElectronicId.class);
	}

	@Override
	public void toSifModel(LibraryPatronElectronicId source, ElectronicIdType target) {
		if (source != null && target != null) {
			target.setValue(source.getElectronicId());
			target.setType(getEnumValue(source.getType(), AUCodeSetsElectronicIdTypeType.class));
		}
	}

	@Override
	public void toHitsModel(ElectronicIdType source, LibraryPatronElectronicId target) {
		if (source != null && target != null) {
			target.setElectronicId(source.getValue());
			target.setType(getEnumValue(source.getType()));
		}
	}

}
