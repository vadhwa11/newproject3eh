package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_exit_interview_questions_masters table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="hr_exit_interview_questions_masters"
 */

public abstract class BaseHrExitInterviewQuestionsMasters implements
		Serializable {

	public static String REF = "HrExitInterviewQuestionsMasters";
	public static String PROP_QUESTIONNO = "Questionno";
	public static String PROP_QUESTION = "Question";
	public static String PROP_ID = "Id";

	// constructors
	public BaseHrExitInterviewQuestionsMasters() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrExitInterviewQuestionsMasters(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String questionno;
	private java.lang.String question;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="question_id"
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
	 * Return the value associated with the column: questionno
	 */
	public java.lang.String getQuestionno() {
		return questionno;
	}

	/**
	 * Set the value related to the column: questionno
	 * 
	 * @param questionno
	 *            the questionno value
	 */
	public void setQuestionno(java.lang.String questionno) {
		this.questionno = questionno;
	}

	/**
	 * Return the value associated with the column: question
	 */
	public java.lang.String getQuestion() {
		return question;
	}

	/**
	 * Set the value related to the column: question
	 * 
	 * @param question
	 *            the question value
	 */
	public void setQuestion(java.lang.String question) {
		this.question = question;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HrExitInterviewQuestionsMasters)) {
			return false;
		} else {
			jkt.hms.masters.business.HrExitInterviewQuestionsMasters hrExitInterviewQuestionsMasters = (jkt.hms.masters.business.HrExitInterviewQuestionsMasters) obj;
			if (null == this.getId()
					|| null == hrExitInterviewQuestionsMasters.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrExitInterviewQuestionsMasters
						.getId()));
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