package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYearLevelCodeType;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.TimeTableSubjectType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.domain.model.TimeTableSubjectOtherCode;

@Component
public class TimeTableSubjectConverter extends HitsConverter<TimeTableSubjectType, TimeTableSubject> {

  @Autowired
  private TimeTableSubjectSchoolInfoConverter timeTableSubjectSchoolInfoConverter;

  public TimeTableSubjectConverter() {
    super(TimeTableSubjectType.class, TimeTableSubject.class);
  }

  @Override
  public void toSifModel(TimeTableSubject source, TimeTableSubjectType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSubjectLocalId(source.getSubjectLocalId());
      timeTableSubjectSchoolInfoConverter.toSifModel(source.getSchoolInfo(), target);

      YearLevelType yearLevel = new YearLevelType();
      yearLevel.setCode(getEnumValue(source.getAcademicYear(), AUCodeSetsYearLevelCodeType.class));
      target.setAcademicYear(objectFactory.createTimeTableSubjectTypeAcademicYear(yearLevel));

      target.setFaculty(objectFactory.createTimeTableSubjectTypeFaculty(source.getFaculty()));
      target.setSubjectShortName(objectFactory.createTimeTableSubjectTypeSubjectShortName(source.getSubjectShortName()));
      target.setSubjectLongName(source.getSubjectLongName());
      target.setSubjectType(objectFactory.createTimeTableSubjectTypeSubjectType(source.getSubjectType()));

      ArrayList<OtherCode> otherCodes = new ArrayList<OtherCode>();
      if (source.getOtherCodes() != null) {
        for (TimeTableSubjectOtherCode timeTableSubjectOtherCode : source.getOtherCodes()) {
          OtherCode otherCode = new OtherCode();
          otherCode.setValue(timeTableSubjectOtherCode.getOtherCode());
          otherCode.setCodeset(timeTableSubjectOtherCode.getCodeSet());
          otherCodes.add(otherCode);
        }
      }
      OtherCodeListType otherCodeList = new OtherCodeListType();
      otherCodeList.getOtherCode().addAll(otherCodes);
      if (!otherCodes.isEmpty()) {
        target.setOtherCodeList(objectFactory.createTimeTableSubjectTypeOtherCodeList(otherCodeList));
      }

      target.setProposedMinClassSize(objectFactory.createTimeTableSubjectTypeProposedMinClassSize(getBigDecimalValue(source.getProposedMinClassSize())));
      target.setProposedMaxClassSize(objectFactory.createTimeTableSubjectTypeProposedMaxClassSize(getBigDecimalValue(source.getProposedMaxClassSize())));
      target.setSemester(objectFactory.createTimeTableSubjectTypeSemester(getLongValue(source.getSemester())));
      target.setSchoolYear(objectFactory.createTimeTableSubjectTypeSchoolYear(getYearValue(source.getSchoolYear())));

      if (source.getSchoolInfo() != null) {
        target.setSchoolInfoRefId(objectFactory.createTimeTableCellTypeSchoolInfoRefId(source.getSchoolInfo().getRefId()));
        target.setSchoolLocalId(objectFactory.createTimeTableCellTypeSchoolLocalId(source.getSchoolInfo().getLocalId()));
      }
    }
  }

  @Override
  public void toHitsModel(TimeTableSubjectType source, TimeTableSubject target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setSubjectLocalId(source.getSubjectLocalId());
      target.setSchoolInfo(timeTableSubjectSchoolInfoConverter.toHitsModel(source));
      YearLevelType academicYear = getJAXBValue(source.getAcademicYear());
      if (academicYear != null) {
        target.setAcademicYear(getEnumValue(academicYear.getCode()));
      }
      target.setFaculty(getJAXBValue(source.getFaculty()));
      target.setSubjectShortName(getJAXBValue(source.getSubjectShortName()));
      target.setSubjectLongName(source.getSubjectLongName());
      target.setSubjectType(getJAXBValue(source.getSubjectType()));

      OtherCodeListType otherCodeList = getJAXBValue(source.getOtherCodeList());
      if (target.getOtherCodes() == null) {
        target.setOtherCodes(new HashSet<TimeTableSubjectOtherCode>());
      } else {
        target.getOtherCodes().clear();
      }

      if (otherCodeList != null && otherCodeList.getOtherCode() != null) {
        for (OtherCode otherCode : otherCodeList.getOtherCode()) {
          TimeTableSubjectOtherCode timeTableSubjectOtherCode = new TimeTableSubjectOtherCode();
          timeTableSubjectOtherCode.setTimeTableSubject(target);
          timeTableSubjectOtherCode.setOtherCode(otherCode.getValue());
          timeTableSubjectOtherCode.setCodeSet(otherCode.getCodeset());
          target.getOtherCodes().add(timeTableSubjectOtherCode);
        }
      }
      target.setProposedMinClassSize(getBigDecimalValue(getJAXBValue(source.getProposedMinClassSize())));
      target.setProposedMaxClassSize(getBigDecimalValue(getJAXBValue(source.getProposedMaxClassSize())));
      target.setSemester(getLongValue(getJAXBValue(source.getSemester())));
      target.setSchoolYear(getYearValue(getJAXBValue(source.getSchoolYear())));
    }
  }
}
