package sif3.hits.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CollectionRound extends HitsEntity {
	private String refId;
	private String agCollection;
	private String collectionYear;
	private List<AGRound> agRoundList;
	private List<CollectionRoundLocalCode> localCodeList;

	@Id
	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getAgCollection() {
		return agCollection;
	}

	public void setAgCollection(String agCollection) {
		this.agCollection = agCollection;
	}

	public String getCollectionYear() {
		return collectionYear;
	}

	public void setCollectionYear(String collectionYear) {
		this.collectionYear = collectionYear;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "collectionRound")
	public List<AGRound> getAgRoundList() {
		return agRoundList;
	}

	public void setAgRoundList(List<AGRound> agRoundList) {
		this.agRoundList = agRoundList;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "collectionRound")
	public List<CollectionRoundLocalCode> getLocalCodeList() {
		return localCodeList;
	}

	public void setLocalCodeList(List<CollectionRoundLocalCode> localCodeList) {
		this.localCodeList = localCodeList;
	}

}
