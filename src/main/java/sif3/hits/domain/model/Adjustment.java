package sif3.hits.domain.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NAPEventStudentLink_Adjustment")
public class Adjustment {

  private Integer id;
  private NAPEventStudentLink napEventStudentLink;
  private String bookletType;
  private Set<String> pnpCodeList;

  @Id
  @GeneratedValue
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(optional = false)
  @JoinColumn(name = "NAPEventStudentLink_RefId")
  public NAPEventStudentLink getNapEventStudentLink() {
    return napEventStudentLink;
  }

  public void setNapEventStudentLink(NAPEventStudentLink napEventStudentLink) {
    this.napEventStudentLink = napEventStudentLink;
  }

  public String getBookletType() {
    return bookletType;
  }

  public void setBookletType(String bookletType) {
    this.bookletType = bookletType;
  }

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "NAPEventStudentLink_Adjustment_PNPCode", joinColumns = @JoinColumn(name = "Adjustment_Id"))
  @Column(name="Code")
  public Set<String> getPnpCodeList() {
    return pnpCodeList;
  }

  public void setPnpCodeList(Set<String> pnpCodeList) {
    this.pnpCodeList = pnpCodeList;
  }
}
