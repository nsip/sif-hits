package sif3.hits.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LearningStandard extends HitsEntity {
	private static final long serialVersionUID = 597162877693332092L;

	private Long id;
	private StudentScoreJudgementAgainstStandard studentScoreJudgementAgainstStandard;
	private String learningStandardItemRefId;
	private String learningStandardURL;
	private String learningStandardLocalId;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "StudentScoreJudgementAgainstStandard_RefId")
	public StudentScoreJudgementAgainstStandard getStudentScoreJudgementAgainstStandard() {
		return studentScoreJudgementAgainstStandard;
	}

	public void setStudentScoreJudgementAgainstStandard(
			StudentScoreJudgementAgainstStandard studentScoreJudgementAgainstStandard) {
		this.studentScoreJudgementAgainstStandard = studentScoreJudgementAgainstStandard;
	}

	@Column(name = "learningStandardItem_RefId")
	public String getLearningStandardItemRefId() {
		return learningStandardItemRefId;
	}

	public void setLearningStandardItemRefId(String learningStandardItemRefId) {
		this.learningStandardItemRefId = learningStandardItemRefId;
	}

	public String getLearningStandardURL() {
		return learningStandardURL;
	}

	public void setLearningStandardURL(String learningStandardURL) {
		this.learningStandardURL = learningStandardURL;
	}

	public String getLearningStandardLocalId() {
		return learningStandardLocalId;
	}

	public void setLearningStandardLocalId(String learningStandardLocalId) {
		this.learningStandardLocalId = learningStandardLocalId;
	}

}
