package sif3.hits.domain.model;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public abstract class FQBaseEntityContactAddress extends HitsEntity {
    private static final long serialVersionUID = -2625854444459437022L;

    private Long id;
    private String addressType;
    private String addressRole;
    private String effectiveFromDate;
    private String effectiveToDate;
    private String streetLine1;
    private String streetLine2;
    private String streetLine3;
    private String streetComplex;
    private String streetStreetNumber;
    private String streetStreetPrefix;
    private String streetStreetName;
    private String streetStreetType;
    private String streetStreetSuffix;
    private String streetApartmentType;
    private String streetApartmentNumberPrefix;
    private String streetApartmentNumber;
    private String streetApartmentNumberSuffix;
    private String city;
    private String stateProvince;
    private String country;
    private String postalCode;
    private String gridLocationLatitude;
    private String gridLocationLongitude;
    private String mapReferenceType;
    private String mapReferenceXCoordinate;
    private String mapReferenceYCoordinate;
    private String mapReferenceMapNumber;
    private String radioContact;
    private String community;
    private String localId;
    private String addressGlobalUID;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressRole() {
        return addressRole;
    }

    public void setAddressRole(String addressRole) {
        this.addressRole = addressRole;
    }

    public String getEffectiveFromDate() {
        return effectiveFromDate;
    }

    public void setEffectiveFromDate(String effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    public String getEffectiveToDate() {
        return effectiveToDate;
    }

    public void setEffectiveToDate(String effectiveToDate) {
        this.effectiveToDate = effectiveToDate;
    }

    @Column(name = "Street_Line1")
    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    @Column(name = "Street_Line2")
    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    @Column(name = "Street_Line3")
    public String getStreetLine3() {
        return streetLine3;
    }

    public void setStreetLine3(String streetLine3) {
        this.streetLine3 = streetLine3;
    }

    @Column(name = "Street_Complex")
    public String getStreetComplex() {
        return streetComplex;
    }

    public void setStreetComplex(String streetComplex) {
        this.streetComplex = streetComplex;
    }

    @Column(name = "Street_StreetNumber")
    public String getStreetStreetNumber() {
        return streetStreetNumber;
    }

    public void setStreetStreetNumber(String streetStreetNumber) {
        this.streetStreetNumber = streetStreetNumber;
    }

    @Column(name = "Street_StreetPrefix")
    public String getStreetStreetPrefix() {
        return streetStreetPrefix;
    }

    public void setStreetStreetPrefix(String streetStreetPrefix) {
        this.streetStreetPrefix = streetStreetPrefix;
    }

    @Column(name = "Street_StreetName")
    public String getStreetStreetName() {
        return streetStreetName;
    }

    public void setStreetStreetName(String streetStreetName) {
        this.streetStreetName = streetStreetName;
    }

    @Column(name = "Street_StreetType")
    public String getStreetStreetType() {
        return streetStreetType;
    }

    public void setStreetStreetType(String streetStreetType) {
        this.streetStreetType = streetStreetType;
    }

    @Column(name = "Street_StreetSuffix")
    public String getStreetStreetSuffix() {
        return streetStreetSuffix;
    }

    public void setStreetStreetSuffix(String streetStreetSuffix) {
        this.streetStreetSuffix = streetStreetSuffix;
    }

    @Column(name = "Street_ApartmentType")
    public String getStreetApartmentType() {
        return streetApartmentType;
    }

    public void setStreetApartmentType(String streetApartmentType) {
        this.streetApartmentType = streetApartmentType;
    }

    @Column(name = "Street_ApartmentNumberPrefix")
    public String getStreetApartmentNumberPrefix() {
        return streetApartmentNumberPrefix;
    }

    public void setStreetApartmentNumberPrefix(String streetApartmentNumberPrefix) {
        this.streetApartmentNumberPrefix = streetApartmentNumberPrefix;
    }

    @Column(name = "Street_ApartmentNumber")
    public String getStreetApartmentNumber() {
        return streetApartmentNumber;
    }

    public void setStreetApartmentNumber(String streetApartmentNumber) {
        this.streetApartmentNumber = streetApartmentNumber;
    }

    @Column(name = "Street_ApartmentNumberSuffix")
    public String getStreetApartmentNumberSuffix() {
        return streetApartmentNumberSuffix;
    }

    public void setStreetApartmentNumberSuffix(String streetApartmentNumberSuffix) {
        this.streetApartmentNumberSuffix = streetApartmentNumberSuffix;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "GridLocation_Latitude")
    public String getGridLocationLatitude() {
        return gridLocationLatitude;
    }

    public void setGridLocationLatitude(String gridLocationLatitude) {
        this.gridLocationLatitude = gridLocationLatitude;
    }

    @Column(name = "GridLocation_Longitude")
    public String getGridLocationLongitude() {
        return gridLocationLongitude;
    }

    public void setGridLocationLongitude(String gridLocationLongitude) {
        this.gridLocationLongitude = gridLocationLongitude;
    }

    @Column(name = "MapReference_Type")
    public String getMapReferenceType() {
        return mapReferenceType;
    }

    public void setMapReferenceType(String mapReferenceType) {
        this.mapReferenceType = mapReferenceType;
    }

    @Column(name = "MapReference_XCoordinate")
    public String getMapReferenceXCoordinate() {
        return mapReferenceXCoordinate;
    }

    public void setMapReferenceXCoordinate(String mapReferenceXCoordinate) {
        this.mapReferenceXCoordinate = mapReferenceXCoordinate;
    }

    @Column(name = "MapReference_YCoordinate")
    public String getMapReferenceYCoordinate() {
        return mapReferenceYCoordinate;
    }

    public void setMapReferenceYCoordinate(String mapReferenceYCoordinate) {
        this.mapReferenceYCoordinate = mapReferenceYCoordinate;
    }
    
    @Column(name = "MapReference_MapNumber")
    public String getMapReferenceMapNumber() {
        return mapReferenceMapNumber;
    }

    public void setMapReferenceMapNumber(String mapReferenceMapNumber) {
        this.mapReferenceMapNumber = mapReferenceMapNumber;
    }
    
    public String getRadioContact() {
        return radioContact;
    }

    public void setRadioContact(String radioContact) {
        this.radioContact = radioContact;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getAddressGlobalUID() {
        return addressGlobalUID;
    }

    public void setAddressGlobalUID(String addressGlobalUID) {
        this.addressGlobalUID = addressGlobalUID;
    }

    @Transient
    public abstract List<? extends FQBaseEntityContactAddressStatisticalArea> getStatisticalAreas();

}
