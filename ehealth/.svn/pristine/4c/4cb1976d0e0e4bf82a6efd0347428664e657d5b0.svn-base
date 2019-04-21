package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the survey_detail_mails table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="survey_detail_mails"
 */

public abstract class BaseSurveyDetailMails  implements Serializable {

	public static String REF = "SurveyDetailMails";
	public static String PROP_EMAILS = "Emails";
	public static String PROP_ID = "Id";


	// constructors
	public BaseSurveyDetailMails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSurveyDetailMails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String emails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: emails
	 */
	public java.lang.String getEmails () {
		return emails;
	}

	/**
	 * Set the value related to the column: emails
	 * @param emails the emails value
	 */
	public void setEmails (java.lang.String emails) {
		this.emails = emails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SurveyDetailMails)) return false;
		else {
			jkt.hms.masters.business.SurveyDetailMails surveyDetailMails = (jkt.hms.masters.business.SurveyDetailMails) obj;
			if (null == this.getId() || null == surveyDetailMails.getId()) return false;
			else return (this.getId().equals(surveyDetailMails.getId()));
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