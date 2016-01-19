package sif3.hits.domain.model;

public interface Person {

  public String getRefId();

  public String getFamilyName();

  public void setFamilyName(String familyName);

  public String getGivenName();

  public void setGivenName(String givenName);

  public String getMiddleName();

  public void setMiddleName(String middleName);

  public String getPreferredFamilyName();

  public void setPreferredFamilyName(String preferredFamilyName);

  public String getPreferredGivenName();

  public void setPreferredGivenName(String preferredGivenName);

  public String getFullName();

  public void setFullName(String fullName);

  public String getSex();

  public void setSex(String sex);

  public String getEmail();

  public void setEmail(String email);

  public String getPhoneNumber();

  public void setPhoneNumber(String phoneNumber);

  public String getBirthDate();

  public void setBirthDate(String birthDate);

  public String getTitle();

  public void setTitle(String title);

}
