package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.NameOfRecordType;
import sif.dd.au30.model.TeachingGroupTeacherType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.TeachingGroupTeacher;

@Component
public class TeachingGroupTeacherConverter extends HitsConverter<TeachingGroupTeacherType, TeachingGroupTeacher> {

	public TeachingGroupTeacherConverter() {
		super(TeachingGroupTeacherType.class, TeachingGroupTeacher.class);
	}

	@Autowired
	private NameOfRecordConverter nameOfRecordConverter;

	@Override
	public void toSifModel(TeachingGroupTeacher source, TeachingGroupTeacherType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setStaffPersonalRefId(
					objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(source.getStaffPersonalRefId()));
			target.setAssociation(source.getTeacherAssociation());
		}
	}

	@Override
	public void toHitsModel(TeachingGroupTeacherType source, TeachingGroupTeacher target) {
		if (source != null && target != null) {
			target.setStaffPersonalRefId(getJAXBValue(source.getStaffPersonalRefId()));
			target.setTeacherAssociation(source.getAssociation());
		}
	}

	public void toSifModel(StaffPersonal source, TeachingGroupTeacherType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setStaffPersonalRefId(
					objectFactory.createTeachingGroupTeacherTypeStaffPersonalRefId(source.getRefId()));
			target.setStaffLocalId(objectFactory.createTeachingGroupTeacherTypeStaffLocalId(source.getLocalId()));
			NameOfRecordType name = getJAXBValue(target.getName());
			if (name == null) {
				name = objectFactory.createNameOfRecordType();
			}
			nameOfRecordConverter.toSifModel(source, name);
			target.setName(objectFactory.createTeachingGroupTeacherTypeName(name));
		}
	}

}
