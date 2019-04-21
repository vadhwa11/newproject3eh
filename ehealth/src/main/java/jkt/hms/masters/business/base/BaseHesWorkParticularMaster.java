package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_work_particular_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_work_particular_master"
 */

public abstract class BaseHesWorkParticularMaster  implements Serializable {

	public static String REF = "HesWorkParticularMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WORK_PARTICULAR_NAME = "WorkParticularName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WORK_PARTICULAR_CODE = "WorkParticularCode";


	// constructors
	public BaseHesWorkParticularMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesWorkParticularMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String workParticularCode;
	private java.lang.String workParticularName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="workid"
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
	 * Return the value associated with the column: work_particular_code
	 */
	public java.lang.String getWorkParticularCode () {
		return workParticularCode;
	}

	/**
	 * Set the value related to the column: work_particular_code
	 * @param workParticularCode the work_particular_code value
	 */
	public void setWorkParticularCode (java.lang.String workParticularCode) {
		this.workParticularCode = workParticularCode;
	}



	/**
	 * Return the value associated with the column: work_particular_name
	 */
	public java.lang.String getWorkParticularName () {
		return workParticularName;
	}

	/**
	 * Set the value related to the column: work_particular_name
	 * @param workParticularName the work_particular_name value
	 */
	public void setWorkParticularName (java.lang.String workParticularName) {
		this.workParticularName = workParticularName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesWorkParticularMaster)) return false;
		else {
			jkt.hms.masters.business.HesWorkParticularMaster hesWorkParticularMaster = (jkt.hms.masters.business.HesWorkParticularMaster) obj;
			if (null == this.getId() || null == hesWorkParticularMaster.getId()) return false;
			else return (this.getId().equals(hesWorkParticularMaster.getId()));
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