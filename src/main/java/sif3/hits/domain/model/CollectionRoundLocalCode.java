package sif3.hits.domain.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CollectionRoundLocalCode extends BaseLocalCode {
	private static final long serialVersionUID = -6621366196190539130L;

	private CollectionRound collectionRound;

	@ManyToOne
	@JoinColumn(name = "CollectionRound_RefId")
	public CollectionRound getCollectionRound() {
		return collectionRound;
	}

	public void setCollectionRound(CollectionRound collectionRound) {
		this.collectionRound = collectionRound;
	}

}
