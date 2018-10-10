package sif3.hits.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TimeTableCell_TeacherCover")
public class TimeTableCellTeacherCover implements Serializable {
    private static final long serialVersionUID = -3453833584106712538L;

    private Long id;
    private TimeTableCell timeTableCell;
    private String staffPersonalRefId;
    private String staffLocalId;
    private String startTime;
    private String finishTime;
    private String credit;
    private String supervision;
    private String weighting;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "TimeTableCell_RefId", referencedColumnName = "RefId")
    public TimeTableCell getTimeTableCell() {
        return timeTableCell;
    }

    public void setTimeTableCell(TimeTableCell timeTableCell) {
        this.timeTableCell = timeTableCell;
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
