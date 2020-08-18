package sif3.hits.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseNameOfRecord extends HitsEntity {
	private static final long serialVersionUID = -5321474114536389949L;

	private Long id;
	private String title;
	private String familyName;
	private String givenName;
	private String middleName;
	private String familyNameFirst;
	private String preferredFamilyName;
	private String preferredFamilyNameFirst;
	private String preferredGivenName;
	private String suffix;
	private String fullName;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFamilyNameFirst() {
		return familyNameFirst;
	}

	public void setFamilyNameFirst(String familyNameFirst) {
		this.familyNameFirst = familyNameFirst;
	}

	public String getPreferredFamilyName() {
		return preferredFamilyName;
	}

	public void setPreferredFamilyName(String preferredFamilyName) {
		this.preferredFamilyName = preferredFamilyName;
	}

	public String getPreferredFamilyNameFirst() {
		return preferredFamilyNameFirst;
	}

	public void setPreferredFamilyNameFirst(String preferredFamilyNameFirst) {
		this.preferredFamilyNameFirst = preferredFamilyNameFirst;
	}

	public String getPreferredGivenName() {
		return preferredGivenName;
	}

	public void setPreferredGivenName(String preferredGivenName) {
		this.preferredGivenName = preferredGivenName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
