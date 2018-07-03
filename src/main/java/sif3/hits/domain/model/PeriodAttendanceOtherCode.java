package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendanceTimeList_PeriodAttendance_OtherCode")
public class PeriodAttendanceOtherCode {

    private Long id;
    private PeriodAttendanceTime periodAttendanceTime;
    private String otherCode;
    private String codeset;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "StudentAttendanceTimeList_PeriodAttendance_Id")
    public PeriodAttendanceTime getPeriodAttendanceTime() {
        return periodAttendanceTime;
    }

    public void setPeriodAttendanceTime(PeriodAttendanceTime periodAttendanceTime) {
        this.periodAttendanceTime = periodAttendanceTime;
    }

    public String getOtherCode() {
        return otherCode;
    }

    public void setOtherCode(String otherCode) {
        this.otherCode = otherCode;
    }

    public String getCodeset() {
        return codeset;
    }

    public void setCodeset(String codeset) {
        this.codeset = codeset;
    }

}
