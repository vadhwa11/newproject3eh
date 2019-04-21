package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lr_fetal_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lr_fetal_details"
 */

public abstract class BaseLrFetalDetails  implements Serializable {

	public static String REF = "LrFetalDetails";
	public static String PROP_LABOR_ROOM_TYPE = "LaborRoomType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_AMNIOTIC_FLUID = "AmnioticFluid";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_FETAL_DETAILS_TIME = "FetalDetailsTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_FETAL_DETAILS_DATE = "FetalDetailsDate";
	public static String PROP_FETAL_SKULL_MOULDING = "FetalSkullMoulding";


	// constructors
	public BaseLrFetalDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLrFetalDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fetalDetailsDate;
	private java.lang.String fetalDetailsTime;
	private java.lang.Integer pulse;
	private java.lang.String amnioticFluid;
	private java.lang.String fetalSkullMoulding;
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
     *  column="lr_fetal_details_id"
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
	 * Return the value associated with the column: fetal_details_date
	 */
	public java.util.Date getFetalDetailsDate () {
		return fetalDetailsDate;
	}

	/**
	 * Set the value related to the column: fetal_details_date
	 * @param fetalDetailsDate the fetal_details_date value
	 */
	public void setFetalDetailsDate (java.util.Date fetalDetailsDate) {
		this.fetalDetailsDate = fetalDetailsDate;
	}



	/**
	 * Return the value associated with the column: fetal_details_time
	 */
	public java.lang.String getFetalDetailsTime () {
		return fetalDetailsTime;
	}

	/**
	 * Set the value related to the column: fetal_details_time
	 * @param fetalDetailsTime the fetal_details_time value
	 */
	public void setFetalDetailsTime (java.lang.String fetalDetailsTime) {
		this.fetalDetailsTime = fetalDetailsTime;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Integer getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.Integer pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: amniotic_fluid
	 */
	public java.lang.String getAmnioticFluid () {
		return amnioticFluid;
	}

	/**
	 * Set the value related to the column: amniotic_fluid
	 * @param amnioticFluid the amniotic_fluid value
	 */
	public void setAmnioticFluid (java.lang.String amnioticFluid) {
		this.amnioticFluid = amnioticFluid;
	}



	/**
	 * Return the value associated with the column: fetal_skull_moulding
	 */
	public java.lang.String getFetalSkullMoulding () {
		return fetalSkullMoulding;
	}

	/**
	 * Set the value related to the column: fetal_skull_moulding
	 * @param fetalSkullMoulding the fetal_skull_moulding value
	 */
	public void setFetalSkullMoulding (java.lang.String fetalSkullMoulding) {
		this.fetalSkullMoulding = fetalSkullMoulding;
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
		if (!(obj instanceof jkt.hms.masters.business.LrFetalDetails)) return false;
		else {
			jkt.hms.masters.business.LrFetalDetails lrFetalDetails = (jkt.hms.masters.business.LrFetalDetails) obj;
			if (null == this.getId() || null == lrFetalDetails.getId()) return false;
			else return (this.getId().equals(lrFetalDetails.getId()));
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