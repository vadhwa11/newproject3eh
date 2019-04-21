package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_exit_interview_answers
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_exit_interview_answers"
 */

public abstract class BaseHrExitInterviewAnswers implements Serializable {

	public static String REF = "HrExitInterviewAnswers";
	public static String PROP_ANSWER = "Answer";
	public static String PROP_QUESTION = "Question";
	public static String PROP_INTERVIEW = "Interview";
	public static String PROP_ID = "Id";

	// constructors
	public BaseHrExitInterviewAnswers() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrExitInterviewAnswers(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String answer;

	// many to one
	private jkt.hms.masters.business.HrEmployeeExitInterview interview;
	private jkt.hms.masters.business.HrExitInterviewQuestionsMasters question;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="answer_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: answer
	 */
	public java.lang.String getAnswer() {
		return answer;
	}

	/**
	 * Set the value related to the column: answer
	 * 
	 * @param answer
	 *            the answer value
	 */
	public void setAnswer(java.lang.String answer) {
		this.answer = answer;
	}

	/**
	 * Return the value associated with the column: interview_id
	 */
	public jkt.hms.masters.business.HrEmployeeExitInterview getInterview() {
		return interview;
	}

	/**
	 * Set the value related to the column: interview_id
	 * 
	 * @param interview
	 *            the interview_id value
	 */
	public void setInterview(
			jkt.hms.masters.business.HrEmployeeExitInterview interview) {
		this.interview = interview;
	}

	/**
	 * Return the value associated with the column: question_id
	 */
	public jkt.hms.masters.business.HrExitInterviewQuestionsMasters getQuestion() {
		return question;
	}

	/**
	 * Set the value related to the column: question_id
	 * 
	 * @param question
	 *            the question_id value
	 */
	public void setQuestion(
			jkt.hms.masters.business.HrExitInterviewQuestionsMasters question) {
		this.question = question;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HrExitInterviewAnswers)) {
			return false;
		} else {
			jkt.hms.masters.business.HrExitInterviewAnswers hrExitInterviewAnswers = (jkt.hms.masters.business.HrExitInterviewAnswers) obj;
			if (null == this.getId() || null == hrExitInterviewAnswers.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrExitInterviewAnswers.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}