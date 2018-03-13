package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceTimeList_PeriodAttendance_TeacherCover")
public class PeriodAttendanceTeacher extends HitsEntity {
    private static final long serialVersionUID = -7441749574654079140L;

    private Long id;
    private PeriodAttendanceTime periodAttendanceTime;
    private String staffPersonalRefId;
    private String staffLocalId;
    private String startTime;
    private String finishTime;
    private String credit;
    private String supervision;
    private String weighting;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "PeriodAttendance_Id")
    public PeriodAttendanceTime getPeriodAttendanceTime() {
        return periodAttendanceTime;
    }

    public void setPeriodAttendanceTime(PeriodAttendanceTime periodAttendanceTime) {
        this.periodAttendanceTime = periodAttendanceTime;
    }

    @Column(name = "StaffPersonal_RefId")
    public String getStaffPersonalRefId() {
        return staffPersonalRefId;
    }

    public void setStaffPersonalRefId(String staffPersonalRefId) {
        this.staffPersonalRefId = staffPersonalRefId;
    }

    public String getStaffLocalId() {
        return staffLocalId;
    }

    public void setStaffLocalId(String staffLocalId) {
        this.staffLocalId = staffLocalId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getSupervision() {
        return supervision;
    }

    public void setSupervision(String supervision) {
        this.supervision = supervision;
    }

    public String getWeighting() {
        return weighting;
    }

    public void setWeighting(String weighting) {
        this.weighting = weighting;
    }
}
