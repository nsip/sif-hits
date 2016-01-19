package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonPicture extends HitsEntity {
  private static final long serialVersionUID = 5089206322356148612L;

  private String refId;
  private String parentObjectRefId;
  private String parentObjectRefObject;
  private String schoolYear;
  private String pictureSource;
  private String pictureSourceType;
  private String okToPublish;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  @Column(name = "ParentObject_RefId")
  public String getParentObjectRefId() {
    return parentObjectRefId;
  }

  public void setParentObjectRefId(String parentObjectRefId) {
    this.parentObjectRefId = parentObjectRefId;
  }

  @Column(name = "ParentObjectRefId_SIF_RefObject")
  public String getParentObjectRefObject() {
    return parentObjectRefObject;
  }

  public void setParentObjectRefObject(String parentObjectRefObject) {
    this.parentObjectRefObject = parentObjectRefObject;
  }

  public String getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(String schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getPictureSource() {
    return pictureSource;
  }

  public void setPictureSource(String pictureSource) {
    this.pictureSource = pictureSource;
  }

  public String getPictureSourceType() {
    return pictureSourceType;
  }

  public void setPictureSourceType(String pictureSourceType) {
    this.pictureSourceType = pictureSourceType;
  }

  public String getOkToPublish() {
    return okToPublish;
  }

  public void setOkToPublish(String okToPublish) {
    this.okToPublish = okToPublish;
  }
}
