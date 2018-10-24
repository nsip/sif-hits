package sif3.hits.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FQReporting_EntityContact")
public class FQEntityContact extends HitsEntity {
    private static final long serialVersionUID = -3136757794908905396L;

    private Long id;
    private FQReporting fqReporting;
    private List<FQEntityContactName> names;
    private String positionTitle;
    private String role;
    private String registrationDetails;
    private String qualifications;
    private List<FQEntityContactAddress> addresses;
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

    @ManyToOne
    @JoinColumn(name = "FQReporting_RefId", referencedColumnName = "RefId")
    public FQReporting getFqReporting() {
        return fqReporting;
    }

    public void setFqReporting(FQReporting fqReporting) {
        this.fqReporting = fqReporting;
    }

    // Actually One to One but easier to manage with hibernate this way
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
    public List<FQEntityContactName> getNames() {
        return names;
    }

    public void setNames(List<FQEntityContactName> names) {
        this.names = names;
    }
    
    @Transient
    public FQEntityContactName getName() {
        FQEntityContactName result = null;
        if (names != null && !names.isEmpty()) {
            result = names.get(0);
        }
        return result;
    }
    
    @Transient
    public void setName(FQEntityContactName name) {
        if (names == null) {
            names = new ArrayList<FQEntityContactName>();
        }
        names.clear();
        if (name != null) {
            names.add(name);
        }
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

    // Actually One to One but easier to manage with hibernate this way
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "entityContact")
    public List<FQEntityContactAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<FQEntityContactAddress> addresses) {
        this.addresses = addresses;
    }
    
    @Transient
    public FQEntityContactAddress getAddress() {
        FQEntityContactAddress result = null;
        if (addresses != null && !addresses.isEmpty()) {
            result = addresses.get(0);
        }
        return result;
    }
    
    @Transient
    public void setAddress(FQEntityContactAddress address) {
        if (addresses == null) {
            addresses = new ArrayList<FQEntityContactAddress>();
        }
        addresses.clear();
        if (address != null) {
            addresses.add(address);
        }
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
}
