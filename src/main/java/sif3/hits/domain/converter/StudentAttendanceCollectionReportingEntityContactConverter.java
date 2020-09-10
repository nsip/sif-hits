package sif3.hits.domain.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentAttendanceCollectionReportingEntityContact;
import sif3.hits.domain.model.StudentAttendanceCollectionReportingEntityContactAddress;
import sif3.hits.domain.model.StudentAttendanceCollectionReportingEntityContactName;

@Component
public class StudentAttendanceCollectionReportingEntityContactConverter
		extends BaseEntityContactConverter<StudentAttendanceCollectionReportingEntityContact> {

	@Autowired
	StudentAttendanceCollectionReportingEntityContactNameConverter nameConverter;

	@Autowired
	StudentAttendanceCollectionReportingEntityContactAddressConverter addressConverter;

	public StudentAttendanceCollectionReportingEntityContactConverter() {
		super(StudentAttendanceCollectionReportingEntityContact.class);
	}

	@Override
	public void toSifModel(StudentAttendanceCollectionReportingEntityContact source, EntityContactInfoType target) {
		if (source != null && target != null) {
			super.toSifModel(source, target);
			IObjectFactory objectFactory = getObjectFactory();
			target.setName(nameConverter.toSifModel(source.getName()));
			target.setAddress(
					objectFactory.createEntityContactInfoTypeAddress(addressConverter.toSifModel(source.getAddress())));
		}
	}

	@Override
	public void toHitsModel(EntityContactInfoType source, StudentAttendanceCollectionReportingEntityContact target) {
		if (source != null && target != null) {
			super.toHitsModel(source, target);
			StudentAttendanceCollectionReportingEntityContactName name = nameConverter.toHitsModel(source.getName());
			target.setName(name);

			StudentAttendanceCollectionReportingEntityContactAddress address = addressConverter
					.toHitsModel(getJAXBValue(source.getAddress()));
			target.setAddress(address);
		}
	}
}