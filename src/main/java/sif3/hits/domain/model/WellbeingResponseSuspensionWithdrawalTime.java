package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingResponse_SuspensionContainer_WithdrawalTime")
public class WellbeingResponseSuspensionWithdrawalTime extends HitsEntity {
    private static final long serialVersionUID = -3803542778368590981L;

    private Long id;
    private WellbeingResponse wellbeingResponse;
    private String withdrawalDate;
    private String withdrawalStartTime;
    private String withdrawalEndTime;
    private String timeTableSubjectRefId;
    private String scheduledActivityRefId;
    private String timeTableCellRefId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "WellbeingResponse_RefId")
    public WellbeingResponse getWellbeingResponse() {
        return wellbeingResponse;
    }

    public void setWellbeingResponse(WellbeingResponse wellbeingResponse) {
        this.wellbeingResponse = wellbeingResponse;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getWithdrawalStartTime() {
        return withdrawalStartTime;
    }

    public void setWithdrawalStartTime(String withdrawalStartTime) {
        this.withdrawalStartTime = withdrawalStartTime;
    }

    public String getWithdrawalEndTime() {
        return withdrawalEndTime;
    }

    public void setWithdrawalEndTime(String withdrawalEndTime) {
        this.withdrawalEndTime = withdrawalEndTime;
    }

    @Column(name = "TimeTableSubject_RefId")
    public String getTimeTableSubjectRefId() {
        return timeTableSubjectRefId;
    }

    public void setTimeTableSubjectRefId(String timeTableSubjectRefId) {
        this.timeTableSubjectRefId = timeTableSubjectRefId;
    }

    @Column(name = "ScheduledActivity_RefId")
    public String getScheduledActivityRefId() {
        return scheduledActivityRefId;
    }

    public void setScheduledActivityRefId(String scheduledActivityRefId) {
        this.scheduledActivityRefId = scheduledActivityRefId;
    }

    @Column(name = "TimeTableCell_RefId")
    public String getTimeTableCellRefId() {
        return timeTableCellRefId;
    }

    public void setTimeTableCellRefId(String timeTableCellRefId) {
        this.timeTableCellRefId = timeTableCellRefId;
    }

}
