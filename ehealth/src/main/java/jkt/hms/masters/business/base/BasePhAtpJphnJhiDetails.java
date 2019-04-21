package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_atp_jphn_jhi_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_atp_jphn_jhi_details"
 */

public abstract class BasePhAtpJphnJhiDetails  implements Serializable {

	public static String REF = "PhAtpJphnJhiDetails";
	public static String PROP_DATE_ATP = "DateAtp";
	public static String PROP_WORK_STATUS = "WorkStatus";
	public static String PROP_OTHER_ACTIVITY = "OtherActivity";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_AFTER_NOON_ACTIVITY = "AfterNoonActivity";
	public static String PROP_TYPE_NAME = "TypeName";
	public static String PROP_OBSERVATION_STATUS = "ObservationStatus";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PENDING_DAY_BLOCK = "PendingDayBlock";
	public static String PROP_ROUTINE_ACTIVITY = "RoutineActivity";
	public static String PROP_ATP_HEADER = "AtpHeader";
	public static String PROP_ID = "Id";
	public static String PROP_SUPERVISION = "Supervision";
	public static String PROP_DAY_BLOCK = "DayBlock";


	// constructors
	public BasePhAtpJphnJhiDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAtpJphnJhiDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateAtp;
	private java.lang.String typeName;
	private java.lang.String remarks;
	private java.lang.String routineActivity;
	private java.lang.String otherActivity;
	private java.lang.String afterNoonActivity;
	private java.lang.String supervision;
	private java.lang.String workStatus;
	private java.lang.String observationStatus;

	// many to one
	private jkt.hms.masters.business.PhAtpJphnJhiHeader atpHeader;
	private jkt.hms.masters.business.PhDayBlock pendingDayBlock;
	private jkt.hms.masters.business.PhDayBlock dayBlock;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="atp_details_id"
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
	 * Return the value associated with the column: date_atp
	 */
	public java.util.Date getDateAtp () {
		return dateAtp;
	}

	/**
	 * Set the value related to the column: date_atp
	 * @param dateAtp the date_atp value
	 */
	public void setDateAtp (java.util.Date dateAtp) {
		this.dateAtp = dateAtp;
	}



	/**
	 * Return the value associated with the column: type_name
	 */
	public java.lang.String getTypeName () {
		return typeName;
	}

	/**
	 * Set the value related to the column: type_name
	 * @param typeName the type_name value
	 */
	public void setTypeName (java.lang.String typeName) {
		this.typeName = typeName;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: routine_activity
	 */
	public java.lang.String getRoutineActivity () {
		return routineActivity;
	}

	/**
	 * Set the value related to the column: routine_activity
	 * @param routineActivity the routine_activity value
	 */
	public void setRoutineActivity (java.lang.String routineActivity) {
		this.routineActivity = routineActivity;
	}



	/**
	 * Return the value associated with the column: other_activity
	 */
	public java.lang.String getOtherActivity () {
		return otherActivity;
	}

	/**
	 * Set the value related to the column: other_activity
	 * @param otherActivity the other_activity value
	 */
	public void setOtherActivity (java.lang.String otherActivity) {
		this.otherActivity = otherActivity;
	}



	/**
	 * Return the value associated with the column: after_noon_activity
	 */
	public java.lang.String getAfterNoonActivity () {
		return afterNoonActivity;
	}

	/**
	 * Set the value related to the column: after_noon_activity
	 * @param afterNoonActivity the after_noon_activity value
	 */
	public void setAfterNoonActivity (java.lang.String afterNoonActivity) {
		this.afterNoonActivity = afterNoonActivity;
	}



	/**
	 * Return the value associated with the column: supervision
	 */
	public java.lang.String getSupervision () {
		return supervision;
	}

	/**
	 * Set the value related to the column: supervision
	 * @param supervision the supervision value
	 */
	public void setSupervision (java.lang.String supervision) {
		this.supervision = supervision;
	}



	/**
	 * Return the value associated with the column: work_status
	 */
	public java.lang.String getWorkStatus () {
		return workStatus;
	}

	/**
	 * Set the value related to the column: work_status
	 * @param workStatus the work_status value
	 */
	public void setWorkStatus (java.lang.String workStatus) {
		this.workStatus = workStatus;
	}



	/**
	 * Return the value associated with the column: observation_status
	 */
	public java.lang.String getObservationStatus () {
		return observationStatus;
	}

	/**
	 * Set the value related to the column: observation_status
	 * @param observationStatus the observation_status value
	 */
	public void setObservationStatus (java.lang.String observationStatus) {
		this.observationStatus = observationStatus;
	}



	/**
	 * Return the value associated with the column: atp_header_id
	 */
	public jkt.hms.masters.business.PhAtpJphnJhiHeader getAtpHeader () {
		return atpHeader;
	}

	/**
	 * Set the value related to the column: atp_header_id
	 * @param atpHeader the atp_header_id value
	 */
	public void setAtpHeader (jkt.hms.masters.business.PhAtpJphnJhiHeader atpHeader) {
		this.atpHeader = atpHeader;
	}



	/**
	 * Return the value associated with the column: pending_day_block_id
	 */
	public jkt.hms.masters.business.PhDayBlock getPendingDayBlock () {
		return pendingDayBlock;
	}

	/**
	 * Set the value related to the column: pending_day_block_id
	 * @param pendingDayBlock the pending_day_block_id value
	 */
	public void setPendingDayBlock (jkt.hms.masters.business.PhDayBlock pendingDayBlock) {
		this.pendingDayBlock = pendingDayBlock;
	}



	/**
	 * Return the value associated with the column: day_block_id
	 */
	public jkt.hms.masters.business.PhDayBlock getDayBlock () {
		return dayBlock;
	}

	/**
	 * Set the value related to the column: day_block_id
	 * @param dayBlock the day_block_id value
	 */
	public void setDayBlock (jkt.hms.masters.business.PhDayBlock dayBlock) {
		this.dayBlock = dayBlock;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAtpJphnJhiDetails)) return false;
		else {
			jkt.hms.masters.business.PhAtpJphnJhiDetails phAtpJphnJhiDetails = (jkt.hms.masters.business.PhAtpJphnJhiDetails) obj;
			if (null == this.getId() || null == phAtpJphnJhiDetails.getId()) return false;
			else return (this.getId().equals(phAtpJphnJhiDetails.getId()));
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