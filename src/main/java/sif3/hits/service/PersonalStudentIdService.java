package sif3.hits.service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.validator.routines.checkdigit.CheckDigitException;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif.dd.au30.model.StudentPersonalType;
import sif.dd.au30.model.StudentPersonalType.OtherIdList.OtherId;
import sif3.hits.domain.converter.StudentPersonalOtherIdConverter;
import sif3.hits.domain.shared.dao.PersonalStudentSequenceDAO;

@Service
public class PersonalStudentIdService {

  private static final Logger L = LoggerFactory.getLogger(PersonalStudentIdService.class);
  
  @Autowired
  private PersonalStudentSequenceDAO personalStudentSequenceDAO;
  
  @Autowired
  private StudentPersonalOtherIdConverter studentPersonalOtherIdConverter;

  public static final String PERSONAL_STUDENT_IDENTIFIER_TYPE = "NAPPlatformStudentId";
  private static final String TYPE_CODE = "R";
  private static final String STATE_CODE = "1"; // NSW
  private static final MessageFormat PSI_FORMAT = new MessageFormat("{0}{1}{2}{3}");
  private static final MessageFormat CHECK_FORMAT = new MessageFormat("{0,number,00000000}");
  private static final HashMap<String, String> CHECK_DIGIT_MAP = new HashMap<String, String>();

  // Defined in PSI Usage Guidelines
  static {
    CHECK_DIGIT_MAP.put("0", "K");
    CHECK_DIGIT_MAP.put("1", "M");
    CHECK_DIGIT_MAP.put("2", "R");
    CHECK_DIGIT_MAP.put("3", "A");
    CHECK_DIGIT_MAP.put("4", "S");
    CHECK_DIGIT_MAP.put("5", "P");
    CHECK_DIGIT_MAP.put("6", "D");
    CHECK_DIGIT_MAP.put("7", "H");
    CHECK_DIGIT_MAP.put("8", "E");
    CHECK_DIGIT_MAP.put("9", "G");
  }

  @Transactional(value = "sharedTransactionManager")
  public void createId(StudentPersonalType studentPersonalType) {
    if (!hasIdentifier(studentPersonalType)) {
      Integer id = personalStudentSequenceDAO.getNextId();
      String identifier = getIdentifier(getStateCode(studentPersonalType), id);
      OtherId otherId = new OtherId();
      otherId.setType(PERSONAL_STUDENT_IDENTIFIER_TYPE);
      otherId.setValue(identifier);
      if (studentPersonalType.getOtherIdList() != null && studentPersonalType.getOtherIdList().getValue() != null && studentPersonalType.getOtherIdList().getValue().getOtherId() != null) {
        studentPersonalType.getOtherIdList().getValue().getOtherId().add(otherId);
      } else {
        studentPersonalOtherIdConverter.toSifModel(otherId, studentPersonalType);
      }
    }
  }
  
  public static String getIdentifier(String typeCode, String stateCode, Integer sequence) {
    String result = null;
    String identifier = CHECK_FORMAT.format(new Object[]{sequence});
    LuhnCheckDigit lcd = new LuhnCheckDigit();
    try {
      String checkIndex = lcd.calculate(identifier);
      result = PSI_FORMAT.format(new Object[] { typeCode, stateCode, identifier, CHECK_DIGIT_MAP.get(checkIndex) });
    } catch (CheckDigitException ex) {
      L.error("Error calculating check digit", ex);
    }
    return result;
  }
  
  public static String getIdentifier(String stateCode, Integer sequence) {
    return getIdentifier(TYPE_CODE, stateCode, sequence);
  }
  
  public static String getIdentifier(Integer sequence) {
    return getIdentifier(TYPE_CODE, STATE_CODE, sequence);
  }

  public static boolean hasIdentifier(StudentPersonalType studentPersonalType) {
    boolean result = false;
    
    if (studentPersonalType.getOtherIdList() != null && studentPersonalType.getOtherIdList().getValue() != null && studentPersonalType.getOtherIdList().getValue().getOtherId() != null) {
      List<OtherId> otherIds = studentPersonalType.getOtherIdList().getValue().getOtherId();
      for (int i = 0; !result && otherIds != null && i < otherIds.size(); i++) {
        OtherId otherId = otherIds.get(i);
        result = otherId != null && PERSONAL_STUDENT_IDENTIFIER_TYPE.equals(otherId.getType());
      }
    }
    return result;
  }

  private String getStateCode(StudentPersonalType studentPersonalType) {
    // We are not calculating this from the student
    return STATE_CODE;
  }
  
  public static void main(String[] args) {
    System.out.println(getIdentifier(245883245));
  }

}
