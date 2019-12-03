package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WellbeingPersonLink_FollowupAction")
public class WellbeingPersonLinkFollowUpAction extends HitsEntity {
	private static final long serialVersionUID = 429343961608772672L;

	private Long id;
	private WellbeingPersonLink wellbeingPersonLink;
	private String followUpDetails;
	private String followUpActionCategory;
	private String wellbeingResponseRefId;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "WellbeingPersonLink_RefId")
	public WellbeingPersonLink getWellbeingPersonLink() {
		return wellbeingPersonLink;
	}

	public void setWellbeingPersonLink(WellbeingPersonLink wellbeingPersonLink) {
		this.wellbeingPersonLink = wellbeingPersonLink;
	}

	public String getFollowUpDetails() {
		return followUpDetails;
	}

	public void setFollowUpDetails(String followUpDetails) {
		this.followUpDetails = followUpDetails;
	}

	public String getFollowUpActionCategory() {
		return followUpActionCategory;
	}

	public void setFollowUpActionCategory(String followUpActionCategory) {
		this.followUpActionCategory = followUpActionCategory;
	}

	@Column(name = "WellbeingResponse_RefId")
	public String getWellbeingResponseRefId() {
		return wellbeingResponseRefId;
	}

	public void setWellbeingResponseRefId(String wellbeingResponseRefId) {
		this.wellbeingResponseRefId = wellbeingResponseRefId;
	}

}
