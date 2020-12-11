package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AGRound extends HitsEntity {
	private static final long serialVersionUID = 6753137014127728328L;

	private Long id;
	private CollectionRound collectionRound;
	private String roundCode;
	private String roundName;
	private String startDate;
	private String dueDate;
	private String endDate;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "CollectionRound_RefId")
	public CollectionRound getCollectionRound() {
		return collectionRound;
	}

	public void setCollectionRound(CollectionRound collectionRound) {
		this.collectionRound = collectionRound;
	}

	public String getRoundCode() {
		return roundCode;
	}

	public void setRoundCode(String roundCode) {
		this.roundCode = roundCode;
	}

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
