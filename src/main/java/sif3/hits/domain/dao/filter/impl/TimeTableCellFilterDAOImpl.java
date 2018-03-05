package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.TimeTableCellType;
import sif3.hits.domain.dao.filter.TimeTableCellFilterDAO;
import sif3.hits.domain.model.TimeTableCell;

@Repository
public class TimeTableCellFilterDAOImpl extends BaseFilterableRepository<TimeTableCell, TimeTableCellType> implements TimeTableCellFilterDAO {
    public TimeTableCellFilterDAOImpl() {
        super(TimeTableCell.class, TimeTableCellType.class);
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
    protected void addExtraExampleCriteria(Criteria criteria, TimeTableCell example, TimeTableCellType input) {
        if (input != null) {
            if (needsFilter(input.getRoomInfoRefId(), input.getRoomNumber())) {
                criteria.createAlias("roomInfo", "room");
                if (needsFilter(input.getRoomInfoRefId())) {
                    criteria.add(Restrictions.eq("room.refId", input.getRoomInfoRefId().getValue()));
                }
                if (needsFilter(input.getRoomNumber())) {
                    criteria.add(Restrictions.eq("room.roomNumber", input.getRoomNumber().getValue()));
                }
            }
            if (needsFilter(input.getStaffPersonalRefId(), input.getStaffLocalId())) {
                criteria.createAlias("staffPersonal", "staff");
                if (needsFilter(input.getStaffPersonalRefId())) {
                    criteria.add(Restrictions.eq("staff.refId", input.getStaffPersonalRefId().getValue()));
                }
                if (needsFilter(input.getStaffLocalId())) {
                    criteria.add(Restrictions.eq("staff.localId", input.getStaffLocalId().getValue()));
                }
            }
            if (needsFilter(input.getTeachingGroupLocalId()) || StringUtils.isNotBlank(input.getTeachingGroupRefId())) {
                criteria.createAlias("teachingGroup", "teachingGroup");
                if (StringUtils.isNotBlank(input.getTeachingGroupRefId())) {
                    criteria.add(Restrictions.eq("teachingGroup.refId", input.getTeachingGroupRefId()));
                }
                if (needsFilter(input.getTeachingGroupLocalId())) {
                    criteria.add(Restrictions.eq("teachingGroup.localId", input.getTeachingGroupLocalId()));
                }
            }
            if (needsFilter(input.getTimeTableLocalId()) || StringUtils.isNotBlank(input.getTimeTableRefId())) {
                criteria.createAlias("timeTable", "timeTable");
                if (StringUtils.isNotBlank(input.getTimeTableRefId())) {
                    criteria.add(Restrictions.eq("timeTable.refId", input.getTimeTableRefId()));
                }
                if (needsFilter(input.getTimeTableLocalId())) {
                    criteria.add(Restrictions.eq("timeTable.localId", input.getTimeTableLocalId().getValue()));
                }
            }
            if (needsFilter(input.getSubjectLocalId(), input.getTimeTableSubjectRefId())) {
                criteria.createAlias("timeTableSubject", "subject");
                if (needsFilter(input.getTimeTableSubjectRefId())) {
                    criteria.add(Restrictions.eq("subject.refId", input.getTimeTableSubjectRefId().getValue()));
                }
                if (needsFilter(input.getSubjectLocalId())) {
                    criteria.add(Restrictions.eq("subject.subjectLocalId", input.getSubjectLocalId().getValue()));
                }
            }
        }
    }
}