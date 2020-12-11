package sif3.hits.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseOtherCode extends HitsEntity {
	private static final long serialVersionUID = 8274285797346867741L;

	private Long id;
	private String otherCode;
	private String codeset;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtherCode() {
		return otherCode;
	}

	public void setOtherCode(String otherCode) {
		this.otherCode = otherCode;
	}

	public String getCodeset() {
		return codeset;
	}

	public void setCodeset(String codeset) {
		this.codeset = codeset;
	}

}
