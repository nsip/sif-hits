package sif3.hits.domain.model;


public interface StudentPerson extends Person {

  public String getIndigenousStatus();

  public void setIndigenousStatus(String indigenousStatus);

  public String getCountryOfBirth();

  public void setCountryOfBirth(String countryOfBirth);
  
  public String getFullName();
  
  public void setFullName(String fullName);

  public String getReligion();
  
  public void setReligion(String religion);

}
