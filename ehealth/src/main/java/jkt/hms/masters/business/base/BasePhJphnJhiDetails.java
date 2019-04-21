package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_jphn_jhi_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_jphn_jhi_details"
 */

public abstract class BasePhJphnJhiDetails  implements Serializable {

	public static String REF = "PhJphnJhiDetails";
	public static String PROP_QUESTION = "Question";
	public static String PROP_ID = "Id";
	public static String PROP_JPHN_JHI_HEADER = "JphnJhiHeader";
	public static String PROP_QUESTION_ANSWERS = "QuestionAnswers";


	// constructors
	public BasePhJphnJhiDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhJphnJhiDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.PhJphnJhiHeader jphnJhiHeader;
	private jkt.hms.masters.business.MasQuestionAnswers questionAnswers;
	private jkt.hms.masters.business.MasQuestions question;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="jphn_jhi_details_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: jphn_jhi_header_id
	 */
	public jkt.hms.masters.business.PhJphnJhiHeader getJphnJhiHeader () {
		return jphnJhiHeader;
	}

	/**
	 * Set the value related to the column: jphn_jhi_header_id
	 * @param jphnJhiHeader the jphn_jhi_header_id value
	 */
	public void setJphnJhiHeader (jkt.hms.masters.business.PhJphnJhiHeader jphnJhiHeader) {
		this.jphnJhiHeader = jphnJhiHeader;
	}



	/**
	 * Return the value associated with the column: question_answers_id
	 */
	public jkt.hms.masters.business.MasQuestionAnswers getQuestionAnswers () {
		return questionAnswers;
	}

	/**
	 * Set the value related to the column: question_answers_id
	 * @param questionAnswers the question_answers_id value
	 */
	public void setQuestionAnswers (jkt.hms.masters.business.MasQuestionAnswers questionAnswers) {
		this.questionAnswers = questionAnswers;
	}



	/**
	 * Return the value associated with the column: question_id
	 */
	public jkt.hms.masters.business.MasQuestions getQuestion () {
		return question;
	}

	/**
	 * Set the value related to the column: question_id
	 * @param question the question_id value
	 */
	public void setQuestion (jkt.hms.masters.business.MasQuestions question) {
		this.question = question;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhJphnJhiDetails)) return false;
		else {
			jkt.hms.masters.business.PhJphnJhiDetails phJphnJhiDetails = (jkt.hms.masters.business.PhJphnJhiDetails) obj;
			if (null == this.getId() || null == phJphnJhiDetails.getId()) return false;
			else return (this.getId().equals(phJphnJhiDetails.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}