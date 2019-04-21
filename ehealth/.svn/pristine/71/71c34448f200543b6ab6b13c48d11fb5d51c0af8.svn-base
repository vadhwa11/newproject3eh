package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ip_progress_note table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ip_progress_note"
 */

public abstract class BaseIpProgressNote  implements Serializable {

	public static String REF = "IpProgressNote";
	public static String PROP_PROGRESS_NOTE = "ProgressNote";
	public static String PROP_ID = "Id";
	public static String PROP_PROGRESS_TIME = "ProgressTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_PROGRESS_DATE = "ProgressDate";


	// constructors
	public BaseIpProgressNote () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpProgressNote (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIpProgressNote (
		java.lang.Integer id,
		jkt.hms.masters.business.Inpatient inpatient) {

		this.setId(id);
		this.setInpatient(inpatient);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date progressDate;
	private java.lang.String progressNote;
	private java.lang.String progressTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="progress_id"
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
	 * Return the value associated with the column: progress_date
	 */
	public java.util.Date getProgressDate () {
		return progressDate;
	}

	/**
	 * Set the value related to the column: progress_date
	 * @param progressDate the progress_date value
	 */
	public void setProgressDate (java.util.Date progressDate) {
		this.progressDate = progressDate;
	}



	/**
	 * Return the value associated with the column: progress_note
	 */
	public java.lang.String getProgressNote () {
		return progressNote;
	}

	/**
	 * Set the value related to the column: progress_note
	 * @param progressNote the progress_note value
	 */
	public void setProgressNote (java.lang.String progressNote) {
		this.progressNote = progressNote;
	}



	/**
	 * Return the value associated with the column: progress_time
	 */
	public java.lang.String getProgressTime () {
		return progressTime;
	}

	/**
	 * Set the value related to the column: progress_time
	 * @param progressTime the progress_time value
	 */
	public void setProgressTime (java.lang.String progressTime) {
		this.progressTime = progressTime;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpProgressNote)) return false;
		else {
			jkt.hms.masters.business.IpProgressNote ipProgressNote = (jkt.hms.masters.business.IpProgressNote) obj;
			if (null == this.getId() || null == ipProgressNote.getId()) return false;
			else return (this.getId().equals(ipProgressNote.getId()));
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