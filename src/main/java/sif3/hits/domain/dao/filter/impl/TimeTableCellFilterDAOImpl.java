package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.TimeTableCellFilterDAO;
import sif3.hits.domain.model.RoomInfo;
import sif3.hits.domain.model.SchoolInfo;
import sif3.hits.domain.model.StaffPersonal;
import sif3.hits.domain.model.TeachingGroup;
import sif3.hits.domain.model.TimeTable;
import sif3.hits.domain.model.TimeTableCell;
import sif3.hits.domain.model.TimeTableSubject;

@Repository
public class TimeTableCellFilterDAOImpl extends BaseFilterableRepository<TimeTableCell>implements TimeTableCellFilterDAO {
  public TimeTableCellFilterDAOImpl() {
    super(TimeTableCell.class);
  }
  
  @Override
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    if ("SchoolInfos".equals(key)) {
      criteria.createAlias("timeTable.schoolInfo", "school");
      criteria.add(Restrictions.eq("school.refId", value));
    } else {
      super.addServicePathCriteria(criteria, key, value);
    }
  }

  @Override
  protected void addExampleCriteria(Criteria criteria, TimeTableCell example) {
    if (example != null) {
      if (StringUtils.isNotBlank(example.getDayId())) {
        criteria.add(Restrictions.eq("dayId", example.getDayId()));
      }
      if (StringUtils.isNotBlank(example.getPeriodId())) {
        criteria.add(Restrictions.eq("periodId", example.getPeriodId()));
      }
      if (StringUtils.isNotBlank(example.getCellType())) {
        criteria.add(Restrictions.eq("cellType", example.getCellType()));
      }
      if (needsFilter(example.getRoomInfo())) {
        criteria.createAlias("roomInfo", "room");
        if (StringUtils.isNotBlank(example.getRoomInfo().getRefId())) {
          criteria.add(Restrictions.eq("room.refId", example.getRoomInfo().getRefId()));
        }
        if (StringUtils.isNotBlank(example.getRoomInfo().getRoomNumber())) {
          criteria.add(Restrictions.eq("room.roomNumber", example.getRoomInfo().getRoomNumber()));
        }
      }
      if (needsFilter(example.getStaffPersonal())) {
        criteria.createAlias("staffPersonal", "staff");
        if (StringUtils.isNotBlank(example.getStaffPersonal().getRefId())) {
          criteria.add(Restrictions.eq("staff.refId", example.getStaffPersonal().getRefId()));
        }
        if (StringUtils.isNotBlank(example.getStaffPersonal().getLocalId())) {
          criteria.add(Restrictions.eq("staff.localId", example.getStaffPersonal().getLocalId()));
        }        
      }
      if (needsFilter(example.getTeachingGroup())) {
        criteria.createAlias("teachingGroup", "teachingGroup");
        if (StringUtils.isNotBlank(example.getTeachingGroup().getRefId())) {
          criteria.add(Restrictions.eq("teachingGroup.refId", example.getTeachingGroup().getRefId()));
        }
        if (StringUtils.isNotBlank(example.getTeachingGroup().getLocalId())) {
          criteria.add(Restrictions.eq("teachingGroup.localId", example.getTeachingGroup().getLocalId()));
        }        
      }
      if (needsFilter(example.getTimeTable())) {
        criteria.createAlias("timeTable", "timeTable");
        if (StringUtils.isNotBlank(example.getTimeTable().getRefId())) {
          criteria.add(Restrictions.eq("timeTable.refId", example.getTimeTable().getRefId()));
        }
        if (StringUtils.isNotBlank(example.getTimeTable().getLocalId())) {
          criteria.add(Restrictions.eq("timeTable.localId", example.getTimeTable().getLocalId()));
        }
        if (needsFilter(example.getTimeTable().getSchoolInfo())) {
          criteria.createAlias("timeTable.schoolInfo", "school");
          if (StringUtils.isNotBlank(example.getTimeTable().getSchoolInfo().getRefId())) {
            criteria.add(Restrictions.eq("school.refId", example.getTimeTable().getSchoolInfo().getRefId()));
          }
          if (StringUtils.isNotBlank(example.getTimeTable().getSchoolInfo().getLocalId())) {
            criteria.add(Restrictions.eq("school.localId", example.getTimeTable().getSchoolInfo().getLocalId()));
          }
        }
      }
      if (needsFilter(example.getTimeTableSubject())) {
        criteria.createAlias("timeTableSubject", "subject");
        if (StringUtils.isNotBlank(example.getTimeTableSubject().getRefId())) {
          criteria.add(Restrictions.eq("subject.refId", example.getTimeTableSubject().getRefId()));
        }
        if (StringUtils.isNotBlank(example.getTimeTableSubject().getSubjectLocalId())) {
          criteria.add(Restrictions.eq("subject.subjectLocalId", example.getTimeTableSubject().getSubjectLocalId()));
        }        
      }
    } else {
      super.addExampleCriteria(criteria, example);
    }
  }
  
  private boolean needsFilter(RoomInfo roomInfo) {
    return roomInfo != null && (StringUtils.isNotBlank(roomInfo.getRefId()) || StringUtils.isNotBlank(roomInfo.getRoomNumber()));
  }
  
  private boolean needsFilter(StaffPersonal staffPersonal) {
    return staffPersonal != null && (StringUtils.isNotBlank(staffPersonal.getRefId()) || StringUtils.isNotBlank(staffPersonal.getLocalId()));
  }

  private boolean needsFilter(TeachingGroup teachingGroup) {
    return teachingGroup != null && (StringUtils.isNotBlank(teachingGroup.getRefId()) || StringUtils.isNotBlank(teachingGroup.getLocalId()));
  }

  private boolean needsFilter(TimeTable timeTable) {
    return timeTable != null && (StringUtils.isNotBlank(timeTable.getRefId()) || StringUtils.isNotBlank(timeTable.getLocalId()) || needsFilter(timeTable.getSchoolInfo()));
  }

  private boolean needsFilter(SchoolInfo schoolInfo) {
    return schoolInfo != null && (StringUtils.isNotBlank(schoolInfo.getRefId()) || StringUtils.isNotBlank(schoolInfo.getLocalId()));
  }
  
  private boolean needsFilter(TimeTableSubject timeTableSubject) {
    return timeTableSubject != null && (StringUtils.isNotBlank(timeTableSubject.getRefId()) || StringUtils.isNotBlank(timeTableSubject.getSubjectLocalId()));
  }  
}
