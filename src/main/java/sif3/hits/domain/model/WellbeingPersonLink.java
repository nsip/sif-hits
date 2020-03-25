package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WellbeingPersonLink extends HitsEntity {
	private static final long serialVersionUID = 5693245628526263891L;

	private String refId;
	private String localId;
	private String wellbeingEventRefId;
	private String wellbeingResponseRefId;
	private String groupId;
	private String personRefId;
	private String personRefIdRefObject;
	private String shortName;
	private String howInvolved;
	private String otherPersonId;
	private String otherPersonContactDetails;
	private String personRole;

	private List<WellbeingPersonLinkFollowUpAction> followUpActions;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	@Column(name = "WellbeingEvent_RefId")
	public String getWellbeingEventRefId() {
		return wellbeingEventRefId;
	}

	public void setWellbeingEventRefId(String wellbeingEventRefId) {
		this.wellbeingEventRefId = wellbeingEventRefId;
	}

	@Column(name = "WellbeingResponse_RefId")
	public String getWellbeingResponseRefId() {
		return wellbeingResponseRefId;
	}

	public void setWellbeingResponseRefId(String wellbeingResponseRefId) {
		this.wellbeingResponseRefId = wellbeingResponseRefId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "Person_RefId")
	public String getPersonRefId() {
		return personRefId;
	}

	public void setPersonRefId(String personRefId) {
		this.personRefId = personRefId;
	}

	@Column(name = "Person_RefId_SIF_RefObject")
	public String getPersonRefIdRefObject() {
		return personRefIdRefObject;
	}

	public void setPersonRefIdRefObject(String personRefIdRefObject) {
		this.personRefIdRefObject = personRefIdRefObject;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getHowInvolved() {
		return howInvolved;
	}

	public void setHowInvolved(String howInvolved) {
		this.howInvolved = howInvolved;
	}

	public String getOtherPersonId() {
		return otherPersonId;
	}

	public void setOtherPersonId(String otherPersonId) {
		this.otherPersonId = otherPersonId;
	}

	public String getOtherPersonContactDetails() {
		return otherPersonContactDetails;
	}

	public void setOtherPersonContactDetails(String otherPersonContactDetails) {
		this.otherPersonContactDetails = otherPersonContactDetails;
	}

	public String getPersonRole() {
		return personRole;
	}

	public void setPersonRole(String personRole) {
		this.personRole = personRole;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "wellbeingPersonLink")
	public List<WellbeingPersonLinkFollowUpAction> getFollowUpActions() {
		return followUpActions;
	}

	public void setFollowUpActions(List<WellbeingPersonLinkFollowUpAction> followUpActions) {
		this.followUpActions = followUpActions;
	}
}
