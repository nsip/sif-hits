package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntityContact extends HitsEntity {
    private static final long serialVersionUID = -3136757794908905396L;

    private Long id;
    private String positionTitle;
    private String role;
    private String registrationDetails;
    private String qualifications;
    private String emailType;
    private String email;
    private String phoneNumber;
    private String phoneNumberType;
    private String phoneNumberExtension;
    private String phoneNumberListedStatus;
    private String phoneNumberPreference;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(String registrationDetails) {
        this.registrationDetails = registrationDetails;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Column(name = "Email_Type")
    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @Column(name = "Email_Value")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PhoneNumber_Number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "PhoneNumber_Type")
    public String getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(String phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    @Column(name = "PhoneNumber_Extension")
    public String getPhoneNumberExtension() {
        return phoneNumberExtension;
    }

    public void setPhoneNumberExtension(String phoneNumberExtension) {
        this.phoneNumberExtension = phoneNumberExtension;
    }

    @Column(name = "PhoneNumber_ListedStatus")
    public String getPhoneNumberListedStatus() {
        return phoneNumberListedStatus;
    }

    public void setPhoneNumberListedStatus(String phoneNumberListedStatus) {
        this.phoneNumberListedStatus = phoneNumberListedStatus;
    }

    @Column(name = "PhoneNumber_Preference")
    public String getPhoneNumberPreference() {
        return phoneNumberPreference;
    }

    public void setPhoneNumberPreference(String phoneNumberPreference) {
        this.phoneNumberPreference = phoneNumberPreference;
    }

    @Transient
    public abstract BaseNameType getName();

    @Transient
    public abstract BaseAddress getAddress();
}
