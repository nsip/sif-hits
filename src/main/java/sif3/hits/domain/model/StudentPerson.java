package sif3.hits.domain.model;


public interface StudentPerson extends Person {
  public String getBirthDate();

  public void setBirthDate(String birthDate);

  public String getIndigenousStatus();

  public void setIndigenousStatus(String indigenousStatus);

  public String getCountryOfBirth();

  public void setCountryOfBirth(String countryOfBirth);

}
