package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.ObjectFactory;
import sif.dd.au30.model.OtherCodeListType.OtherCode;
import sif.dd.au30.model.OtherCodeListType;
import sif.dd.au30.model.TimeTableSubjectType;
import sif.dd.au30.model.YearLevelType;
import sif3.hits.domain.model.TimeTableSubject;
import sif3.hits.domain.model.TimeTableSubjectOtherCode;

@Component
public class TimeTableSubjectConverter extends HitsConverter<TimeTableSubjectType, TimeTableSubject> {

  public TimeTableSubjectConverter() {
    super(TimeTableSubjectType.class, TimeTableSubject.class);
  }

  @Override
  public void toSifModel(TimeTableSubject source, TimeTableSubjectType target) {
    if (source != null && target != null) {
      ObjectFactory objectFactory = getObjectFactory();
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(objectFactory.createTimeTableSubjectTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
      target.setSubjectLocalId(source.getSubjectLocalId());
      
      YearLevelType yearLevel = new YearLevelType();
      yearLevel.setCode(source.getAcademicYear());
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
      target.setOtherCodeList(objectFactory.createTimeTableSubjectTypeOtherCodeList(otherCodeList));
      
      target.setProposedMinClassSize(objectFactory.createTimeTableSubjectTypeProposedMinClassSize(getBigDecimalValue(source.getProposedMinClassSize())));
      target.setSemester(objectFactory.createTimeTableSubjectTypeSemester(getLongValue(source.getSemester())));
      target.setSchoolYear(objectFactory.createTimeTableSubjectTypeSchoolYear(getYearValue(source.getSchoolYear())));
    }
  }

  @Override
  public void toHitsModel(TimeTableSubjectType source, TimeTableSubject target) {
    if (source != null && target != null) {
      target.setRefId(source.getRefId());
      target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
      target.setSubjectLocalId(source.getSubjectLocalId());
      
      YearLevelType academicYear = getJAXBValue(source.getAcademicYear());
      if (academicYear != null) {
        target.setAcademicYear(academicYear.getCode());
      }
      target.setFaculty(getJAXBValue(source.getFaculty()));
      target.setSubjectShortName(getJAXBValue(source.getSubjectShortName()));
      target.setSubjectLongName(source.getSubjectLongName());
      target.setSubjectType(getJAXBValue(source.getSubjectType()));
      
      Set<TimeTableSubjectOtherCode> otherCodes = new HashSet<TimeTableSubjectOtherCode>();
      OtherCodeListType otherCodeList = getJAXBValue(source.getOtherCodeList());
      if (otherCodeList != null && otherCodeList.getOtherCode() != null) {
        for (OtherCode otherCode : otherCodeList.getOtherCode()) {
          TimeTableSubjectOtherCode timeTableSubjectOtherCode = new TimeTableSubjectOtherCode();
          timeTableSubjectOtherCode.setTimeTableSubject(target);
          timeTableSubjectOtherCode.setOtherCode(otherCode.getValue());
          timeTableSubjectOtherCode.setCodeSet(otherCode.getCodeset());
          otherCodes.add(timeTableSubjectOtherCode);
        }
      }
      target.setOtherCodes(otherCodes);
      
      target.setProposedMinClassSize(getBigDecimalValue(getJAXBValue(source.getProposedMinClassSize())));
      target.setSemester(getLongValue(getJAXBValue(source.getSemester())));
      target.setSchoolYear(getYearValue(getJAXBValue(source.getSchoolYear())));
    }
  }
}
