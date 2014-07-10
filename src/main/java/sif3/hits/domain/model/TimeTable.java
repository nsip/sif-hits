package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimeTable {

  private String refId;
  private SchoolInfo schoolInfo;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @ManyToOne
  @JoinColumn(name = "SchoolInfo_RefId", referencedColumnName = "RefId")
  public SchoolInfo getSchoolInfo() {
    return schoolInfo;
  }

  public void setSchoolInfo(SchoolInfo schoolInfo) {
    this.schoolInfo = schoolInfo;
  }

}
