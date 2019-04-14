package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentSchoolEnrollment extends HitsEntity {

    private static final long serialVersionUID = 8616854135795820792L;

    private String refId;
    private String studentPersonalRefId;
    private String schoolInfoRefId;
    private String membershipType;
    private String localId;
    private String timeFrame;
    private String schoolYear;
    private String entryDate;
    private String entryType;
    private String yearLevel;
    private String homeroomRefId;
    private String advisorRefId;
    private String counselorRefId;
    private String homegroup;
    private String acaraSchoolId;
    private String classCode;
    private String testLevel;
    private String reportingSchool;
    private String house;
    private String individualLearningPlan;
    private String calendarRefId;
    private String exitDate;
    private String exitStatus;
    private String exitType;
    private String fte;
    private String ftptStatus;
    private String ffpos;
    private String catchmentStatus;
    private String recordClosureReason;
    private String promotionStatus;
    private String previousSchool;
    private String previousSchoolName;
    private String destinationSchool;
    private String destinationSchoolName;
    private List<StudentSubjectChoice> studentSubjectChoices;
    private String startedAtSchoolDate;
    private List<StudentGroup> studentGroups;
    private List<StudentSchoolEnrollmentPublishingPermission> publishingPermissions;

    @Id
    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    @Column(name = "StudentPersonal_RefId")
    public String getStudentPersonalRefId() {
        return studentPersonalRefId;
    }

    public void setStudentPersonalRefId(String studentPersonalRefId) {
        this.studentPersonalRefId = studentPersonalRefId;
    }

    @Column(name = "SchoolInfo_RefId")
    public String getSchoolInfoRefId() {
        return schoolInfoRefId;
    }

    public void setSchoolInfoRefId(String schoolInfoRefId) {
        this.schoolInfoRefId = schoolInfoRefId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    @Column(name = "Homeroom_RefId")
    public String getHomeroomRefId() {
        return homeroomRefId;
    }

    public void setHomeroomRefId(String homeroomRefId) {
        this.homeroomRefId = homeroomRefId;
    }

    @Column(name = "Advisor_RefId")
    public String getAdvisorRefId() {
        return advisorRefId;
    }

    public void setAdvisorRefId(String advisorRefId) {
        this.advisorRefId = advisorRefId;
    }

    @Column(name = "Counselor_RefId")
    public String getCounselorRefId() {
        return counselorRefId;
    }

    public void setCounselorRefId(String counselorRefId) {
        this.counselorRefId = counselorRefId;
    }

    public String getHomegroup() {
        return homegroup;
    }

    public void setHomegroup(String homegroup) {
        this.homegroup = homegroup;
    }

    public String getAcaraSchoolId() {
        return acaraSchoolId;
    }

    public void setAcaraSchoolId(String acaraSchoolId) {
        this.acaraSchoolId = acaraSchoolId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTestLevel() {
        return testLevel;
    }

    public void setTestLevel(String testLevel) {
        this.testLevel = testLevel;
    }

    public String getReportingSchool() {
        return reportingSchool;
    }

    public void setReportingSchool(String reportingSchool) {
        this.reportingSchool = reportingSchool;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getIndividualLearningPlan() {
        return individualLearningPlan;
    }

    public void setIndividualLearningPlan(String individualLearningPlan) {
        this.individualLearningPlan = individualLearningPlan;
    }

    @Column(name = "Calendar_RefId")
    public String getCalendarRefId() {
        return calendarRefId;
    }

    public void setCalendarRefId(String calendarRefId) {
        this.calendarRefId = calendarRefId;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public String getExitStatus() {
        return exitStatus;
    }

    public void setExitStatus(String exitStatus) {
        this.exitStatus = exitStatus;
    }

    public String getExitType() {
        return exitType;
    }

    public void setExitType(String exitType) {
        this.exitType = exitType;
    }

    public String getFte() {
        return fte;
    }

    public void setFte(String fte) {
        this.fte = fte;
    }

    public String getFtptStatus() {
        return ftptStatus;
    }

    public void setFtptStatus(String ftptStatus) {
        this.ftptStatus = ftptStatus;
    }

    public String getFfpos() {
        return ffpos;
    }

    public void setFfpos(String ffpos) {
        this.ffpos = ffpos;
    }

    public String getCatchmentStatus() {
        return catchmentStatus;
    }

    public void setCatchmentStatus(String catchmentStatus) {
        this.catchmentStatus = catchmentStatus;
    }

    public String getRecordClosureReason() {
        return recordClosureReason;
    }

    public void setRecordClosureReason(String recordClosureReason) {
        this.recordClosureReason = recordClosureReason;
    }

    public String getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(String promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public String getPreviousSchoolName() {
        return previousSchoolName;
    }

    public void setPreviousSchoolName(String previousSchoolName) {
        this.previousSchoolName = previousSchoolName;
    }

    public String getDestinationSchool() {
        return destinationSchool;
    }

    public void setDestinationSchool(String destinationSchool) {
        this.destinationSchool = destinationSchool;
    }

    public String getDestinationSchoolName() {
        return destinationSchoolName;
    }

    public void setDestinationSchoolName(String destinationSchoolName) {
        this.destinationSchoolName = destinationSchoolName;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentSchoolEnrollment")
    public List<StudentSubjectChoice> getStudentSubjectChoices() {
        return studentSubjectChoices;
    }

    public void setStudentSubjectChoices(List<StudentSubjectChoice> studentSubjectChoices) {
        this.studentSubjectChoices = studentSubjectChoices;
    }

    public String getStartedAtSchoolDate() {
        return startedAtSchoolDate;
    }

    public void setStartedAtSchoolDate(String startedAtSchoolDate) {
        this.startedAtSchoolDate = startedAtSchoolDate;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentSchoolEnrollment")
    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "studentSchoolEnrollment")
    public List<StudentSchoolEnrollmentPublishingPermission> getPublishingPermissions() {
        return publishingPermissions;
    }

    public void setPublishingPermissions(List<StudentSchoolEnrollmentPublishingPermission> publishingPermissions) {
        this.publishingPermissions = publishingPermissions;
    }
}
