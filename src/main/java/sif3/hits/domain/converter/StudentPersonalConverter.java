package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType;
import sif.dd.au30.model.AUCodeSetsBoardingType;
import sif.dd.au30.model.AUCodeSetsEmploymentTypeType;
import sif.dd.au30.model.AUCodeSetsFFPOSStatusCodeType;
import sif.dd.au30.model.AUCodeSetsNonSchoolEducationType;
import sif.dd.au30.model.AUCodeSetsPrePrimaryHoursType;
import sif.dd.au30.model.AUCodeSetsSchoolEducationLevelTypeType;
import sif.dd.au30.model.AUCodeSetsSchoolEnrollmentTypeType;
import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.OtherIdListType;
import sif.dd.au30.model.OtherIdType;
import sif.dd.au30.model.StudentMostRecentContainerType;
import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.StudentPersonalOtherId;

@Component
public class StudentPersonalConverter extends HitsConverter<StudentPersonalType, StudentPersonal> {

	public StudentPersonalConverter() {
		super(StudentPersonalType.class, StudentPersonal.class);
	}

	@Autowired
	private PersonInfoConverter personInfoConverter;

	@Override
	public void toSifModel(StudentPersonal source, StudentPersonalType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			target.setRefId(source.getRefId());
			target.setLocalId(source.getLocalId());
			target.setPersonInfo(personInfoConverter.toSifModel(source));
			target.setStateProvinceId(
					objectFactory.createStudentPersonalTypeStateProvinceId(source.getStateProvinceId()));
			target.setESLSupport(objectFactory.createStudentPersonalTypeESLSupport(
					getEnumValue(source.getESLSupport(), AUCodeSetsYesOrNoCategoryType.class)));

			StudentMostRecentContainerType mostRecent = objectFactory.createStudentMostRecentContainerType();

			if (StringUtils.isNotBlank(source.getMostRecentYearLevel())) {
				YearLevelType yearLevel = objectFactory.createYearLevelType();
				yearLevel.setCode(getEnumValue(source.getMostRecentYearLevel(), AUCodeSetsYearLevelCodeType.class));
				mostRecent.setYearLevel(objectFactory.createStudentMostRecentContainerTypeYearLevel(yearLevel));
			}

			mostRecent.setParent1Language(objectFactory.createStudentMostRecentContainerTypeParent1Language(
					getEnumValue(source.getMostRecentParent1Language(),
							AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType.class)));
			mostRecent.setParent2Language(objectFactory.createStudentMostRecentContainerTypeParent2Language(
					getEnumValue(source.getMostRecentParent2Language(),
							AUCodeSetsAustralianStandardClassificationOfLanguagesASCLType.class)));
			mostRecent.setParent1SchoolEducationLevel(
					objectFactory.createStudentMostRecentContainerTypeParent1SchoolEducationLevel(
							getEnumValue(source.getMostRecentParent1SchoolEducation(),
									AUCodeSetsSchoolEducationLevelTypeType.class)));
			mostRecent.setParent2SchoolEducationLevel(
					objectFactory.createStudentMostRecentContainerTypeParent2SchoolEducationLevel(
							getEnumValue(source.getMostRecentParent2SchoolEducation(),
									AUCodeSetsSchoolEducationLevelTypeType.class)));
			mostRecent.setParent1NonSchoolEducation(
					objectFactory.createStudentMostRecentContainerTypeParent1NonSchoolEducation(getEnumValue(
							source.getMostRecentParent1NonSchoolEducation(), AUCodeSetsNonSchoolEducationType.class)));
			mostRecent.setParent2NonSchoolEducation(
					objectFactory.createStudentMostRecentContainerTypeParent2NonSchoolEducation(getEnumValue(
							source.getMostRecentParent2NonSchoolEducation(), AUCodeSetsNonSchoolEducationType.class)));
			mostRecent.setParent1EmploymentType(objectFactory.createStudentMostRecentContainerTypeParent1EmploymentType(
					getEnumValue(source.getMostRecentParent1EmploymentType(), AUCodeSetsEmploymentTypeType.class)));
			mostRecent.setParent2EmploymentType(objectFactory.createStudentMostRecentContainerTypeParent2EmploymentType(
					getEnumValue(source.getMostRecentParent2EmploymentType(), AUCodeSetsEmploymentTypeType.class)));

			// naplan
			mostRecent.setSchoolLocalId(objectFactory
					.createStudentMostRecentContainerTypeSchoolLocalId(source.getMostRecentSchoolLocalId()));
			mostRecent.setSchoolACARAId(objectFactory
					.createStudentMostRecentContainerTypeSchoolACARAId(source.getMostRecentSchoolAcaraId()));
			mostRecent.setLocalCampusId(objectFactory
					.createStudentMostRecentContainerTypeLocalCampusId(source.getMostRecentSchoolCampusId()));
			mostRecent.setHomeroomLocalId(objectFactory
					.createStudentMostRecentContainerTypeHomeroomLocalId(source.getMostRecentHomeroomLocalId()));
			mostRecent.setFTE(objectFactory
					.createStudentMostRecentContainerTypeFTE(getBigDecimalValue(source.getMostRecentFTE())));
			mostRecent.setHomegroup(
					objectFactory.createStudentMostRecentContainerTypeHomegroup(source.getMostRecentHomegroup()));
			mostRecent.setClassCode(
					objectFactory.createStudentMostRecentContainerTypeClassCode(source.getMostRecentClassCode()));
			mostRecent.setMembershipType(objectFactory.createStudentMostRecentContainerTypeMembershipType(
					getEnumValue(source.getMostRecentMembershipType(), AUCodeSetsSchoolEnrollmentTypeType.class)));
			mostRecent.setOtherEnrollmentSchoolACARAId(
					objectFactory.createStudentMostRecentContainerTypeOtherEnrollmentSchoolACARAId(
							source.getMostRecentOtherEnrollmentSchoolAcaraId()));
			mostRecent.setFFPOS(objectFactory.createStudentMostRecentContainerTypeFFPOS(
					getEnumValue(source.getMostRecentFFPOS(), AUCodeSetsFFPOSStatusCodeType.class)));
			mostRecent.setReportingSchoolId(objectFactory
					.createStudentMostRecentContainerTypeReportingSchoolId(source.getMostRecentReportingSchool()));

			if (StringUtils.isNotBlank(source.getMostRecentTestLevel())) {
				YearLevelType testLevel = objectFactory.createYearLevelType();
				testLevel.setCode(getEnumValue(source.getMostRecentTestLevel(), AUCodeSetsYearLevelCodeType.class));
				mostRecent.setTestLevel(objectFactory.createStudentMostRecentContainerTypeTestLevel(testLevel));
			}
			
			mostRecent.setOtherSchoolName(objectFactory.createStudentMostRecentContainerTypeOtherSchoolName(source.getMostRecentOtherSchoolName()));
			mostRecent.setDisabilityLevelOfAdjustment(objectFactory.createStudentMostRecentContainerTypeDisabilityLevelOfAdjustment(source.getMostRecentDisabilityLevelOfAdjustment()));
			mostRecent.setDisabilityCategory(objectFactory.createStudentMostRecentContainerTypeDisabilityCategory(source.getMostRecentDisabilityCategory()));
			mostRecent.setCensusAge(objectFactory.createStudentMostRecentContainerTypeCensusAge(getBigIntegerValue(source.getMostRecentCensusAge())));
			mostRecent.setDistanceEducationStudent(objectFactory.createStudentMostRecentContainerTypeDistanceEducationStudent(getEnumValue(source.getMostRecentDistanceEducationStudent(), AUCodeSetsYesOrNoCategoryType.class)));
			mostRecent.setBoardingStatus(objectFactory.createStudentMostRecentContainerTypeBoardingStatus(getEnumValue(source.getMostRecentBoardingStatus(), AUCodeSetsBoardingType.class)));
			
			target.setMostRecent(objectFactory.createStudentPersonalTypeMostRecent(mostRecent));

			target.setOfflineDelivery(objectFactory.createStudentPersonalTypeOfflineDelivery(
					getEnumValue(source.getOfflineDelivery(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setEducationSupport(objectFactory.createStudentPersonalTypeEducationSupport(
					getEnumValue(source.getEducationSupport(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setHomeSchooledStudent(objectFactory.createStudentPersonalTypeHomeSchooledStudent(
					getEnumValue(source.getHomeSchooledStudent(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setESL(objectFactory
					.createStudentPersonalTypeESL(getEnumValue(source.getEsl(), AUCodeSetsYesOrNoCategoryType.class)));
			target.setSensitive(objectFactory.createStudentPersonalTypeSensitive(
					getEnumValue(source.getSensitive(), AUCodeSetsYesOrNoCategoryType.class)));

			target.setPrePrimaryEducation(
					objectFactory.createStudentPersonalTypePrePrimaryEducation(source.getPrePrimaryEducation()));
			target.setPrePrimaryEducationHours(objectFactory.createStudentPersonalTypePrePrimaryEducationHours(
					getEnumValue(source.getPrePrimaryEducationHours(), AUCodeSetsPrePrimaryHoursType.class)));

			ArrayList<OtherIdType> otherIds = new ArrayList<OtherIdType>();
			if (source.getOtherIds() != null) {
				for (StudentPersonalOtherId studentPersonalOtherId : source.getOtherIds()) {
					OtherIdType otherId = objectFactory.createOtherIdType();
					otherId.setType(studentPersonalOtherId.getOtherIdType());
					otherId.setValue(studentPersonalOtherId.getOtherId());
					otherIds.add(otherId);
				}
			}
			OtherIdListType otherIdList = objectFactory.createOtherIdListType();
			otherIdList.getOtherId().addAll(otherIds);
			target.setOtherIdList(objectFactory.createStudentPersonalTypeOtherIdList(otherIdList));
		}
	}

	@Override
	public void toHitsModel(StudentPersonalType source, StudentPersonal target) {
		if (source != null && target != null) {
			target.setRefId(source.getRefId());
			target.setLocalId(source.getLocalId());
			target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
			target.setESLSupport(getJAXBEnumValue(source.getESLSupport()));
			personInfoConverter.toHitsModel(source.getPersonInfo(), target);

			StudentMostRecentContainerType mostRecent = getJAXBValue(source.getMostRecent());
			if (mostRecent != null) {
				YearLevelType yearLevel = getJAXBValue(mostRecent.getYearLevel());
				if (yearLevel != null) {
					target.setYearLevel(getEnumValue(yearLevel.getCode()));
					target.setMostRecentYearLevel(getEnumValue(yearLevel.getCode()));
				}
				target.setMostRecentParent1Language(getJAXBEnumValue(mostRecent.getParent1Language()));
				target.setMostRecentParent2Language(getJAXBEnumValue(mostRecent.getParent2Language()));
				target.setMostRecentParent1SchoolEducation(
						getJAXBEnumValue(mostRecent.getParent1SchoolEducationLevel()));
				target.setMostRecentParent2SchoolEducation(
						getJAXBEnumValue(mostRecent.getParent2SchoolEducationLevel()));
				target.setMostRecentParent1NonSchoolEducation(
						getJAXBEnumValue(mostRecent.getParent1NonSchoolEducation()));
				target.setMostRecentParent2NonSchoolEducation(
						getJAXBEnumValue(mostRecent.getParent2NonSchoolEducation()));
				target.setMostRecentParent1EmploymentType(getJAXBEnumValue(mostRecent.getParent1EmploymentType()));
				target.setMostRecentParent2EmploymentType(getJAXBEnumValue(mostRecent.getParent2EmploymentType()));

				// naplan
				target.setMostRecentSchoolLocalId(getJAXBValue(mostRecent.getSchoolLocalId()));
				target.setMostRecentSchoolAcaraId(getJAXBValue(mostRecent.getSchoolACARAId()));
				target.setMostRecentSchoolCampusId(getJAXBValue(mostRecent.getLocalCampusId()));
				target.setMostRecentHomeroomLocalId(getJAXBValue(mostRecent.getHomeroomLocalId()));
				target.setMostRecentFTE(getBigDecimalValue(getJAXBValue(mostRecent.getFTE())));
				target.setMostRecentHomegroup(getJAXBValue(mostRecent.getHomegroup()));
				target.setMostRecentClassCode(getJAXBValue(mostRecent.getClassCode()));
				target.setMostRecentMembershipType(getJAXBEnumValue(mostRecent.getMembershipType()));
				target.setMostRecentOtherEnrollmentSchoolAcaraId(
						getJAXBValue(mostRecent.getOtherEnrollmentSchoolACARAId()));
				target.setMostRecentFFPOS(getJAXBEnumValue(mostRecent.getFFPOS()));
				target.setMostRecentReportingSchool(getJAXBValue(mostRecent.getReportingSchoolId()));
				
				target.setMostRecentOtherSchoolName(getJAXBValue(mostRecent.getOtherSchoolName()));
				target.setMostRecentDisabilityLevelOfAdjustment(getJAXBValue(mostRecent.getDisabilityLevelOfAdjustment()));
				target.setMostRecentDisabilityCategory(getJAXBValue(mostRecent.getDisabilityCategory()));
				target.setMostRecentCensusAge(getBigIntegerValue(getJAXBValue(mostRecent.getCensusAge())));
				target.setMostRecentDistanceEducationStudent(getJAXBEnumValue(mostRecent.getDistanceEducationStudent()));
				target.setMostRecentBoardingStatus(getJAXBEnumValue(mostRecent.getBoardingStatus()));
				
				YearLevelType testLevel = getJAXBValue(mostRecent.getTestLevel());
				if (testLevel != null) {
					target.setMostRecentTestLevel(getEnumValue(testLevel.getCode()));
				}

				target.setOfflineDelivery(getJAXBEnumValue(source.getOfflineDelivery()));
				target.setEducationSupport(getJAXBEnumValue(source.getEducationSupport()));
				target.setHomeSchooledStudent(getJAXBEnumValue(source.getHomeSchooledStudent()));
				target.setEsl(getJAXBEnumValue(source.getESL()));
				target.setSensitive(getJAXBEnumValue(source.getSensitive()));
			}

			if (target.getOtherIds() == null) {
				target.setOtherIds(new HashSet<StudentPersonalOtherId>());
			} else {
				target.getOtherIds().clear();
			}
			OtherIdListType otherIdList = getJAXBValue(source.getOtherIdList());
			if (otherIdList != null && otherIdList.getOtherId() != null) {
				for (OtherIdType otherId : otherIdList.getOtherId()) {
					StudentPersonalOtherId studentPersonalOtherId = new StudentPersonalOtherId();
					studentPersonalOtherId.setOtherId(otherId.getValue());
					studentPersonalOtherId.setOtherIdType(otherId.getType());
					studentPersonalOtherId.setStudentPersonal(target);
					target.getOtherIds().add(studentPersonalOtherId);
				}
			}
			target.setPrePrimaryEducation(getJAXBValue(source.getPrePrimaryEducation()));
			target.setPrePrimaryEducationHours(getJAXBEnumValue(source.getPrePrimaryEducationHours()));
		}
	}
}
