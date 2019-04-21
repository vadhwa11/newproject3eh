package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lr_pulse_bp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lr_pulse_bp"
 */

public abstract class BaseLrPulseBp  implements Serializable {

	public static String REF = "LrPulseBp";
	public static String PROP_BP_DIASTOLIC = "BpDiastolic";
	public static String PROP_LABOR_ROOM_TYPE = "LaborRoomType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PULSE_BEAT = "PulseBeat";
	public static String PROP_PULSE_BP_DATE = "PulseBpDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PULSE_BP_TIME = "PulseBpTime";
	public static String PROP_PULSE_MIN = "PulseMin";
	public static String PROP_BP_SYSTOLIC = "BpSystolic";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseLrPulseBp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLrPulseBp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date pulseBpDate;
	private java.lang.String pulseBpTime;
	private java.lang.String pulseBeat;
	private java.lang.Integer pulseMin;
	private java.lang.Integer bpSystolic;
	private java.lang.Integer bpDiastolic;
	private java.lang.Integer laborRoomType;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="lr_pulse_bp_id"
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
	 * Return the value associated with the column: pulse_bp_date
	 */
	public java.util.Date getPulseBpDate () {
		return pulseBpDate;
	}

	/**
	 * Set the value related to the column: pulse_bp_date
	 * @param pulseBpDate the pulse_bp_date value
	 */
	public void setPulseBpDate (java.util.Date pulseBpDate) {
		this.pulseBpDate = pulseBpDate;
	}



	/**
	 * Return the value associated with the column: pulse_bp_time
	 */
	public java.lang.String getPulseBpTime () {
		return pulseBpTime;
	}

	/**
	 * Set the value related to the column: pulse_bp_time
	 * @param pulseBpTime the pulse_bp_time value
	 */
	public void setPulseBpTime (java.lang.String pulseBpTime) {
		this.pulseBpTime = pulseBpTime;
	}



	/**
	 * Return the value associated with the column: pulse_beat
	 */
	public java.lang.String getPulseBeat () {
		return pulseBeat;
	}

	/**
	 * Set the value related to the column: pulse_beat
	 * @param pulseBeat the pulse_beat value
	 */
	public void setPulseBeat (java.lang.String pulseBeat) {
		this.pulseBeat = pulseBeat;
	}



	/**
	 * Return the value associated with the column: pulse_min
	 */
	public java.lang.Integer getPulseMin () {
		return pulseMin;
	}

	/**
	 * Set the value related to the column: pulse_min
	 * @param pulseMin the pulse_min value
	 */
	public void setPulseMin (java.lang.Integer pulseMin) {
		this.pulseMin = pulseMin;
	}



	/**
	 * Return the value associated with the column: bp_systolic
	 */
	public java.lang.Integer getBpSystolic () {
		return bpSystolic;
	}

	/**
	 * Set the value related to the column: bp_systolic
	 * @param bpSystolic the bp_systolic value
	 */
	public void setBpSystolic (java.lang.Integer bpSystolic) {
		this.bpSystolic = bpSystolic;
	}



	/**
	 * Return the value associated with the column: bp_diastolic
	 */
	public java.lang.Integer getBpDiastolic () {
		return bpDiastolic;
	}

	/**
	 * Set the value related to the column: bp_diastolic
	 * @param bpDiastolic the bp_diastolic value
	 */
	public void setBpDiastolic (java.lang.Integer bpDiastolic) {
		this.bpDiastolic = bpDiastolic;
	}



	/**
	 * Return the value associated with the column: labor_room_type
	 */
	public java.lang.Integer getLaborRoomType () {
		return laborRoomType;
	}

	/**
	 * Set the value related to the column: labor_room_type
	 * @param laborRoomType the labor_room_type value
	 */
	public void setLaborRoomType (java.lang.Integer laborRoomType) {
		this.laborRoomType = laborRoomType;
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
		if (!(obj instanceof jkt.hms.masters.business.LrPulseBp)) return false;
		else {
			jkt.hms.masters.business.LrPulseBp lrPulseBp = (jkt.hms.masters.business.LrPulseBp) obj;
			if (null == this.getId() || null == lrPulseBp.getId()) return false;
			else return (this.getId().equals(lrPulseBp.getId()));
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