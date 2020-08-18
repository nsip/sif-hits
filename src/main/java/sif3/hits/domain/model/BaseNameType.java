package sif3.hits.domain.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseNameType extends BaseNameOfRecord {
	private static final long serialVersionUID = -5321474114536389949L;

	private String nameType;

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

}
