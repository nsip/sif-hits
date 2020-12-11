package sif3.hits.domain.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FQCollection_LocalCode")
public class FQCollectionLocalCode extends BaseLocalCode {
	private static final long serialVersionUID = 43720444926775041L;

	private FinancialQuestionnaireCollection fqCollection;

	@ManyToOne
	@JoinColumn(name = "FQCollection_RefId")
	public FinancialQuestionnaireCollection getFqCollection() {
		return fqCollection;
	}

	public void setFqCollection(FinancialQuestionnaireCollection fqCollection) {
		this.fqCollection = fqCollection;
	}
}
