package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the nursingcare_setup_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="nursingcare_setup_history"
 */

public abstract class BaseNursingcareSetupHistory  implements Serializable {

	public static String REF = "NursingcareSetupHistory";
	public static String PROP_NURSINGCARE_SETUP = "NursingcareSetup";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_ID = "Id";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_START_TIME = "StartTime";


	// constructors
	public BaseNursingcareSetupHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNursingcareSetupHistory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date endDate;
	private java.lang.String endTime;
	private java.util.Date startDate;
	private java.lang.String startTime;

	// many to one
	private jkt.hms.masters.business.NursingcareSetup nursingcareSetup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="history_id"
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
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
	}



	/**
	 * Return the value associated with the column: end_time
	 */
	public java.lang.String getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: end_time
	 * @param endTime the end_time value
	 */
	public void setEndTime (java.lang.String endTime) {
		this.endTime = endTime;
	}



	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: start_time
	 */
	public java.lang.String getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: start_time
	 * @param startTime the start_time value
	 */
	public void setStartTime (java.lang.String startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: nursingcare_setup_id
	 */
	public jkt.hms.masters.business.NursingcareSetup getNursingcareSetup () {
		return nursingcareSetup;
	}

	/**
	 * Set the value related to the column: nursingcare_setup_id
	 * @param nursingcareSetup the nursingcare_setup_id value
	 */
	public void setNursingcareSetup (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		this.nursingcareSetup = nursingcareSetup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.NursingcareSetupHistory)) return false;
		else {
			jkt.hms.masters.business.NursingcareSetupHistory nursingcareSetupHistory = (jkt.hms.masters.business.NursingcareSetupHistory) obj;
			if (null == this.getId() || null == nursingcareSetupHistory.getId()) return false;
			else return (this.getId().equals(nursingcareSetupHistory.getId()));
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