package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryPatronStatus_Message")
public class LibraryPatronMessage {

	private Long id;
	private LibraryPatronStatus libraryPatronStatus;
	private String sent;
	private String text;
	private String priority;
	private String priorityCodeset;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "LibraryPatronStatus_RefId")
	public LibraryPatronStatus getLibraryPatronStatus() {
		return libraryPatronStatus;
	}

	public void setLibraryPatronStatus(LibraryPatronStatus libraryPatronStatus) {
		this.libraryPatronStatus = libraryPatronStatus;
	}

	public String getSent() {
		return sent;
	}

	public void setSent(String sent) {
		this.sent = sent;
	}

	@Column(name = "MessageText")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPriorityCodeset() {
		return priorityCodeset;
	}

	public void setPriorityCodeset(String priorityCodeset) {
		this.priorityCodeset = priorityCodeset;
	}

}
