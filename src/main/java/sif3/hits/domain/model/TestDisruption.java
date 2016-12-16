package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NAPEventStudentLink_TestDisruption")
public class TestDisruption extends HitsEntity {
  private static final long serialVersionUID = -3435692680313700274L;

  private Integer id;
  private NAPEventStudentLink napEventStudentLink;
  private String code;
  private String event;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "NAPEventStudentLink_RefId")
  public NAPEventStudentLink getNapEventStudentLink() {
    return napEventStudentLink;
  }

  public void setNapEventStudentLink(NAPEventStudentLink napEventStudentLink) {
    this.napEventStudentLink = napEventStudentLink;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }
}
