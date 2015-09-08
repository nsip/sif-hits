package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinancialClass extends HitsEntity {
  private static final long serialVersionUID = 656030009231065210L;

  private String refId;
  private String name;
  private String description;
  private String classType;

  @Id
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getClassType() {
    return classType;
  }

  public void setClassType(String classType) {
    this.classType = classType;
  }
}
