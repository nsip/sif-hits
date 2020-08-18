package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressCR_ContextualQuestion")
public class AGContextualQuestion extends HitsEntity {
	private static final long serialVersionUID = 5896772269799409583L;

	private Long id;
	private AddressCollectionReporting addressCollectionReporting;
	private String agContextCode;
	private String agAnswer;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "AddressCollectionReporting_Id")
	public AddressCollectionReporting getAddressCollectionReporting() {
		return addressCollectionReporting;
	}

	public void setAddressCollectionReporting(AddressCollectionReporting addressCollectionReporting) {
		this.addressCollectionReporting = addressCollectionReporting;
	}

	public String getAgContextCode() {
		return agContextCode;
	}

	public void setAgContextCode(String agContextCode) {
		this.agContextCode = agContextCode;
	}

	public String getAgAnswer() {
		return agAnswer;
	}

	public void setAgAnswer(String agAnswer) {
		this.agAnswer = agAnswer;
	}

}
