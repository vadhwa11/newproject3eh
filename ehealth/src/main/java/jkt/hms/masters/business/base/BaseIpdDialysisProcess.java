package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_dialysis_process table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_dialysis_process"
 */

public abstract class BaseIpdDialysisProcess  implements Serializable {

	public static String REF = "IpdDialysisProcess";
	public static String PROP_VOMITING = "Vomiting";
	public static String PROP_SHIVERING = "Shivering";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CRAMPS = "Cramps";
	public static String PROP_OTHER_HEALTH_EVENT = "OtherHealthEvent";
	public static String PROP_FEVER = "Fever";
	public static String PROP_STATUS = "Status";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_ID = "Id";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_START_TIME = "StartTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_CHEST_PAIN = "ChestPain";
	public static String PROP_END_EVENT = "EndEvent";


	// constructors
	public BaseIpdDialysisProcess () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdDialysisProcess (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date startDate;
	private java.lang.String startTime;
	private java.lang.String cramps;
	private java.lang.String vomiting;
	private java.lang.String chestPain;
	private java.lang.String shivering;
	private java.lang.String fever;
	private java.lang.String otherHealthEvent;
	private java.lang.String endEvent;
	private java.util.Date endDate;
	private java.lang.String endTime;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="dialysis_process_id"
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
	 * Return the value associated with the column: cramps
	 */
	public java.lang.String getCramps () {
		return cramps;
	}

	/**
	 * Set the value related to the column: cramps
	 * @param cramps the cramps value
	 */
	public void setCramps (java.lang.String cramps) {
		this.cramps = cramps;
	}



	/**
	 * Return the value associated with the column: vomiting
	 */
	public java.lang.String getVomiting () {
		return vomiting;
	}

	/**
	 * Set the value related to the column: vomiting
	 * @param vomiting the vomiting value
	 */
	public void setVomiting (java.lang.String vomiting) {
		this.vomiting = vomiting;
	}



	/**
	 * Return the value associated with the column: chest_pain
	 */
	public java.lang.String getChestPain () {
		return chestPain;
	}

	/**
	 * Set the value related to the column: chest_pain
	 * @param chestPain the chest_pain value
	 */
	public void setChestPain (java.lang.String chestPain) {
		this.chestPain = chestPain;
	}



	/**
	 * Return the value associated with the column: shivering
	 */
	public java.lang.String getShivering () {
		return shivering;
	}

	/**
	 * Set the value related to the column: shivering
	 * @param shivering the shivering value
	 */
	public void setShivering (java.lang.String shivering) {
		this.shivering = shivering;
	}



	/**
	 * Return the value associated with the column: fever
	 */
	public java.lang.String getFever () {
		return fever;
	}

	/**
	 * Set the value related to the column: fever
	 * @param fever the fever value
	 */
	public void setFever (java.lang.String fever) {
		this.fever = fever;
	}



	/**
	 * Return the value associated with the column: other_health_event
	 */
	public java.lang.String getOtherHealthEvent () {
		return otherHealthEvent;
	}

	/**
	 * Set the value related to the column: other_health_event
	 * @param otherHealthEvent the other_health_event value
	 */
	public void setOtherHealthEvent (java.lang.String otherHealthEvent) {
		this.otherHealthEvent = otherHealthEvent;
	}



	/**
	 * Return the value associated with the column: end_event
	 */
	public java.lang.String getEndEvent () {
		return endEvent;
	}

	/**
	 * Set the value related to the column: end_event
	 * @param endEvent the end_event value
	 */
	public void setEndEvent (java.lang.String endEvent) {
		this.endEvent = endEvent;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdDialysisProcess)) return false;
		else {
			jkt.hms.masters.business.IpdDialysisProcess ipdDialysisProcess = (jkt.hms.masters.business.IpdDialysisProcess) obj;
			if (null == this.getId() || null == ipdDialysisProcess.getId()) return false;
			else return (this.getId().equals(ipdDialysisProcess.getId()));
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