package sif3.hits.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseLocalCode extends HitsEntity {
	private static final long serialVersionUID = 5641809070246331346L;

	private Long id;
	private String localisedCode;
	private String description;
	private String element;
	private Integer listIndex;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalisedCode() {
		return localisedCode;
	}

	public void setLocalisedCode(String localisedCode) {
		this.localisedCode = localisedCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Integer getListIndex() {
		return listIndex;
	}

	public void setListIndex(Integer listIndex) {
		this.listIndex = listIndex;
	}
}
