package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_joining_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_joining_details"
 */

public abstract class BaseHrJoiningDetails  implements Serializable {

	public static String REF = "HrJoiningDetails";
	public static String PROP_JOINING_MODE = "JoiningMode";
	public static String PROP_JOINING_INSTITUTE = "JoiningInstitute";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TERMINATION_PROCESS = "TerminationProcess";
	public static String PROP_ACTUAL_JOINING_DATE = "ActualJoiningDate";
	public static String PROP_JOINING_SESSION = "JoiningSession";
	public static String PROP_JOINING_TIME = "JoiningTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_JOINING_DATE = "JoiningDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_JOINING_REMARKS = "JoiningRemarks";
	public static String PROP_TRANS_APPROV = "TransApprov";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseHrJoiningDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrJoiningDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String joiningMode;
	private java.util.Date joiningDate;
	private java.util.Date actualJoiningDate;
	private java.lang.String joiningTime;
	private java.lang.String joiningRemarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital joiningInstitute;
	private jkt.hms.masters.business.MasOpSession joiningSession;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.HrTransferApproved transApprov;
	private jkt.hms.masters.business.HrTerminationProcess terminationProcess;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="joining_id"
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
	 * Return the value associated with the column: joining_mode
	 */
	public java.lang.String getJoiningMode () {
		return joiningMode;
	}

	/**
	 * Set the value related to the column: joining_mode
	 * @param joiningMode the joining_mode value
	 */
	public void setJoiningMode (java.lang.String joiningMode) {
		this.joiningMode = joiningMode;
	}



	/**
	 * Return the value associated with the column: joining_date
	 */
	public java.util.Date getJoiningDate () {
		return joiningDate;
	}

	/**
	 * Set the value related to the column: joining_date
	 * @param joiningDate the joining_date value
	 */
	public void setJoiningDate (java.util.Date joiningDate) {
		this.joiningDate = joiningDate;
	}



	/**
	 * Return the value associated with the column: actual_joining_date
	 */
	public java.util.Date getActualJoiningDate () {
		return actualJoiningDate;
	}

	/**
	 * Set the value related to the column: actual_joining_date
	 * @param actualJoiningDate the actual_joining_date value
	 */
	public void setActualJoiningDate (java.util.Date actualJoiningDate) {
		this.actualJoiningDate = actualJoiningDate;
	}



	/**
	 * Return the value associated with the column: joining_time
	 */
	public java.lang.String getJoiningTime () {
		return joiningTime;
	}

	/**
	 * Set the value related to the column: joining_time
	 * @param joiningTime the joining_time value
	 */
	public void setJoiningTime (java.lang.String joiningTime) {
		this.joiningTime = joiningTime;
	}



	/**
	 * Return the value associated with the column: joining_remarks
	 */
	public java.lang.String getJoiningRemarks () {
		return joiningRemarks;
	}

	/**
	 * Set the value related to the column: joining_remarks
	 * @param joiningRemarks the joining_remarks value
	 */
	public void setJoiningRemarks (java.lang.String joiningRemarks) {
		this.joiningRemarks = joiningRemarks;
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
	 * Return the value associated with the column: joining_institute
	 */
	public jkt.hms.masters.business.MasHospital getJoiningInstitute () {
		return joiningInstitute;
	}

	/**
	 * Set the value related to the column: joining_institute
	 * @param joiningInstitute the joining_institute value
	 */
	public void setJoiningInstitute (jkt.hms.masters.business.MasHospital joiningInstitute) {
		this.joiningInstitute = joiningInstitute;
	}



	/**
	 * Return the value associated with the column: joining_session
	 */
	public jkt.hms.masters.business.MasOpSession getJoiningSession () {
		return joiningSession;
	}

	/**
	 * Set the value related to the column: joining_session
	 * @param joiningSession the joining_session value
	 */
	public void setJoiningSession (jkt.hms.masters.business.MasOpSession joiningSession) {
		this.joiningSession = joiningSession;
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
	 * Return the value associated with the column: trans_approv_id
	 */
	public jkt.hms.masters.business.HrTransferApproved getTransApprov () {
		return transApprov;
	}

	/**
	 * Set the value related to the column: trans_approv_id
	 * @param transApprov the trans_approv_id value
	 */
	public void setTransApprov (jkt.hms.masters.business.HrTransferApproved transApprov) {
		this.transApprov = transApprov;
	}



	/**
	 * Return the value associated with the column: ter_process_id
	 */
	public jkt.hms.masters.business.HrTerminationProcess getTerminationProcess () {
		return terminationProcess;
	}

	/**
	 * Set the value related to the column: ter_process_id
	 * @param terminationProcess the ter_process_id value
	 */
	public void setTerminationProcess (jkt.hms.masters.business.HrTerminationProcess terminationProcess) {
		this.terminationProcess = terminationProcess;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrJoiningDetails)) return false;
		else {
			jkt.hms.masters.business.HrJoiningDetails hrJoiningDetails = (jkt.hms.masters.business.HrJoiningDetails) obj;
			if (null == this.getId() || null == hrJoiningDetails.getId()) return false;
			else return (this.getId().equals(hrJoiningDetails.getId()));
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