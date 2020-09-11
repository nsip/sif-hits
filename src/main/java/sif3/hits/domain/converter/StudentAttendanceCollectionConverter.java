package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.LocalCodeListType;
import sif.dd.au30.model.LocalCodeType;
import sif.dd.au30.model.SoftwareVendorInfoContainerType;
import sif.dd.au30.model.StudentAttendanceCollectionReportingListType;
import sif.dd.au30.model.StudentAttendanceCollectionReportingType;
import sif.dd.au30.model.StudentAttendanceCollectionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentAttendanceCollection;
import sif3.hits.domain.model.StudentAttendanceCollectionLocalCode;
import sif3.hits.domain.model.StudentAttendanceCollectionReporting;

@Component
public class StudentAttendanceCollectionConverter
		extends HitsConverter<StudentAttendanceCollectionType, StudentAttendanceCollection> {

	@Autowired
	HitsConverter<LocalCodeType, StudentAttendanceCollectionLocalCode> localCodeConverter;

	@Autowired
	HitsConverter<StudentAttendanceCollectionReportingType, StudentAttendanceCollectionReporting> studentAttendanceReportingConverter;

	public StudentAttendanceCollectionConverter() {
		super(StudentAttendanceCollectionType.class, StudentAttendanceCollection.class);
	}

	@Override
	public void toSifModel(StudentAttendanceCollection source, StudentAttendanceCollectionType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setStudentAttendanceCollectionYear(getYearValue(source.getStudentAttendanceCollectionYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(
					objectFactory.createStudentAttendanceCollectionTypeReportingAuthorityCommonwealthId(
							source.getReportingAuthorityCommonwealthId()));

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareProduct(), source.getSoftwareVersion());
			target.setSoftwareVendorInfo(objectFactory
					.createStudentAttendanceCollectionTypeSoftwareVendorInfo(softwareVendorInfoContainerType));

			List<LocalCodeType> localCodeTypes = localCodeConverter.toSifModelList(source.getLocalCodeList());
			LocalCodeListType localCodeListType = null;
			if (!localCodeTypes.isEmpty()) {
				localCodeListType = objectFactory.createLocalCodeListType();
				localCodeListType.getLocalCode().addAll(localCodeTypes);
			}
			target.setLocalCodeList(objectFactory.createStudentActivityInfoTypeLocalCodeList(localCodeListType));

			List<StudentAttendanceCollectionReportingType> studentAttendanceCollectionReportingTypes = studentAttendanceReportingConverter
					.toSifModelList(source.getStudentAttendanceCollectionReportingList());
			StudentAttendanceCollectionReportingListType studentAttendanceCollectionReportingListType = null;
			if (!studentAttendanceCollectionReportingTypes.isEmpty()) {
				studentAttendanceCollectionReportingListType = objectFactory
						.createStudentAttendanceCollectionReportingListType();
				studentAttendanceCollectionReportingListType.getStudentAttendanceCollectionReporting()
						.addAll(studentAttendanceCollectionReportingTypes);
			}
			target.setStudentAttendanceCollectionReportingList(
					objectFactory.createStudentAttendanceCollectionTypeStudentAttendanceCollectionReportingList(
							studentAttendanceCollectionReportingListType));
		}
	}

	@Override
	public void toHitsModel(StudentAttendanceCollectionType source, StudentAttendanceCollection target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setStudentAttendanceCollectionYear(getYearValue(source.getStudentAttendanceCollectionYear()));
			target.setRoundCode(source.getRoundCode());
			target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));

			SoftwareVendorInfoContainerType softwareVendorInfoContainerType = getSoftwareVendorInfo(
					source.getSoftwareVendorInfo());
			target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
			target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());

			if (target.getLocalCodeList() == null) {
				target.setLocalCodeList(new ArrayList<>());
			}
			target.getLocalCodeList().clear();
			LocalCodeListType localCodeListType = getJAXBValue(source.getLocalCodeList());
			if (localCodeListType != null) {
				List<StudentAttendanceCollectionLocalCode> localCodes = localCodeConverter
						.toHitsModelList(localCodeListType.getLocalCode());
				for (StudentAttendanceCollectionLocalCode localCode : localCodes) {
					target.getLocalCodeList().add(localCode);
					localCode.setStudentAttendanceCollection(target);
				}
			}

			if (target.getStudentAttendanceCollectionReportingList() == null) {
				target.setStudentAttendanceCollectionReportingList(new ArrayList<>());
			}
			target.getStudentAttendanceCollectionReportingList().clear();
			StudentAttendanceCollectionReportingListType studentAttendanceCollectionReportingListType = getJAXBValue(
					source.getStudentAttendanceCollectionReportingList());
			if (studentAttendanceCollectionReportingListType != null) {
				List<StudentAttendanceCollectionReporting> studentAttendanceCollectionReportings = studentAttendanceReportingConverter
						.toHitsModelList(
								studentAttendanceCollectionReportingListType.getStudentAttendanceCollectionReporting());
				for (StudentAttendanceCollectionReporting studentAttendanceCollectionReporting : studentAttendanceCollectionReportings) {
					target.getStudentAttendanceCollectionReportingList().add(studentAttendanceCollectionReporting);
					studentAttendanceCollectionReporting.setStudentAttendanceCollection(target);
				}
			}
		}
	}
}
