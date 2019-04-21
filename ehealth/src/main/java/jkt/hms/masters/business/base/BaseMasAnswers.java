package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_answers table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_answers"
 */

public abstract class BaseMasAnswers  implements Serializable {

	public static String REF = "MasAnswers";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ANSWERS_NAME = "AnswersName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasAnswers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAnswers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String answersName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasQuestionAnswers> masQuestionAnswers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="answers_id"
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
	 * Return the value associated with the column: answers_name
	 */
	public java.lang.String getAnswersName () {
		return answersName;
	}

	/**
	 * Set the value related to the column: answers_name
	 * @param answersName the answers_name value
	 */
	public void setAnswersName (java.lang.String answersName) {
		this.answersName = answersName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: MasQuestionAnswers
	 */
	public java.util.Set<jkt.hms.masters.business.MasQuestionAnswers> getMasQuestionAnswers () {
		return masQuestionAnswers;
	}

	/**
	 * Set the value related to the column: MasQuestionAnswers
	 * @param masQuestionAnswers the MasQuestionAnswers value
	 */
	public void setMasQuestionAnswers (java.util.Set<jkt.hms.masters.business.MasQuestionAnswers> masQuestionAnswers) {
		this.masQuestionAnswers = masQuestionAnswers;
	}

	public void addToMasQuestionAnswers (jkt.hms.masters.business.MasQuestionAnswers masQuestionAnswers) {
		if (null == getMasQuestionAnswers()) setMasQuestionAnswers(new java.util.TreeSet<jkt.hms.masters.business.MasQuestionAnswers>());
		getMasQuestionAnswers().add(masQuestionAnswers);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAnswers)) return false;
		else {
			jkt.hms.masters.business.MasAnswers masAnswers = (jkt.hms.masters.business.MasAnswers) obj;
			if (null == this.getId() || null == masAnswers.getId()) return false;
			else return (this.getId().equals(masAnswers.getId()));
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