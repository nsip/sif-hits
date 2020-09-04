package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsStaffActivityType;
import sif.dd.au30.model.CensusStaffType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.StaffActivityExtensionType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.CensusReportingStaff;
import sif3.hits.domain.model.CensusReportingStaffActivityOtherCode;

@Component
public class CensusReportingStaffConverter extends HitsConverter<CensusStaffType, CensusReportingStaff> {

	@Autowired
	HitsConverter<OtherCode, CensusReportingStaffActivityOtherCode> otherCodeConverter;

	public CensusReportingStaffConverter() {
		super(CensusStaffType.class, CensusReportingStaff.class);
	}

	@Override
	public void toSifModel(CensusReportingStaff source, CensusStaffType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setStaffCohortId(source.getStaffCohortId());
			target.setCohortGender(source.getCohortGender());
			target.setCohortIndigenousType(source.getCohortIndigenousType());
			target.setPrimaryFTE(
					objectFactory.createCensusStaffTypePrimaryFTE(getBigDecimalValue(source.getPrimaryFTE())));
			target.setSecondaryFTE(
					objectFactory.createCensusStaffTypeSecondaryFTE(getBigDecimalValue(source.getSecondaryFTE())));
			target.setJobFTE(objectFactory.createCensusStaffTypeJobFTE(getBigDecimalValue(source.getJobFTE())));
			target.setHeadcount(getBigIntegerValue(source.getHeadCount()));

			List<OtherCode> otherCodeList = otherCodeConverter
					.toSifModelList(source.getCensusReportingStaffActivityOtherCodeList());
			StaffActivityExtensionType staffActivity = null;
			if (StringUtils.isNotEmpty(source.getStaffActivity()) || !otherCodeList.isEmpty()) {
				staffActivity = objectFactory.createStaffActivityExtensionType();
				staffActivity.setCode(getEnumValue(source.getStaffActivity(), AUCodeSetsStaffActivityType.class));
				if (!otherCodeList.isEmpty()) {
					OtherCodeListType otherCodeListType = objectFactory.createOtherCodeListType();
					otherCodeListType.getOtherCode().addAll(otherCodeList);
					staffActivity.setOtherCodeList(
							objectFactory.createStaffActivityExtensionTypeOtherCodeList(otherCodeListType));
				}
			}
			target.setStaffActivity(staffActivity);
		}
	}

	@Override
	public void toHitsModel(CensusStaffType source, CensusReportingStaff target) {
		if (source != null && target != null) {
			target.setStaffCohortId(source.getStaffCohortId());
			target.setCohortGender(source.getCohortGender());
			target.setCohortIndigenousType(source.getCohortIndigenousType());
			target.setPrimaryFTE(getBigDecimalValue(getJAXBValue(source.getPrimaryFTE())));
			target.setSecondaryFTE(getBigDecimalValue(getJAXBValue(source.getSecondaryFTE())));
			target.setJobFTE(getBigDecimalValue(getJAXBValue(source.getJobFTE())));
			target.setHeadCount(getBigIntegerValue(source.getHeadcount()));

			if (target.getCensusReportingStaffActivityOtherCodeList() == null) {
				target.setCensusReportingStaffActivityOtherCodeList(new ArrayList<>());
			}
			target.getCensusReportingStaffActivityOtherCodeList().clear();

			StaffActivityExtensionType staffActivity = source.getStaffActivity();
			if (staffActivity != null) {
				target.setStaffActivity(getEnumValue(staffActivity.getCode()));

				OtherCodeListType otherCodeListType = getJAXBValue(staffActivity.getOtherCodeList());
				if (otherCodeListType != null) {
					List<CensusReportingStaffActivityOtherCode> activityCodes = otherCodeConverter
							.toHitsModelList(otherCodeListType.getOtherCode());
					for (CensusReportingStaffActivityOtherCode activityCode : activityCodes) {
						target.getCensusReportingStaffActivityOtherCodeList().add(activityCode);
						activityCode.setCensusReportingStaff(target);
					}
				}
			} else {
				target.setStaffActivity(null);
			}
		}
	}
}