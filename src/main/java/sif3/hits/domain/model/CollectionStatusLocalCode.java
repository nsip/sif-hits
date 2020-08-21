package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CollectionStatus_LocalCode")
public class CollectionStatusLocalCode extends BaseLocalCode {
	private static final long serialVersionUID = -6621366196190539130L;

	private CollectionStatus collectionStatus;

	@ManyToOne
	@JoinColumn(name = "CollectionStatus_RefId")
	public CollectionStatus getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(CollectionStatus collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

}
