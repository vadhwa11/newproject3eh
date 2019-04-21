package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lr_dilatation_descent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lr_dilatation_descent"
 */

public abstract class BaseLrDilatationDescent  implements Serializable {

	public static String REF = "LrDilatationDescent";
	public static String PROP_LABOR_ROOM_TYPE = "LaborRoomType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DILATATION_DESCENT_DATE = "DilatationDescentDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_DILATATION = "Dilatation";
	public static String PROP_DESCENT = "Descent";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DILATATION_DESCENT_TIME = "DilatationDescentTime";


	// constructors
	public BaseLrDilatationDescent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLrDilatationDescent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dilatationDescentDate;
	private java.lang.String dilatationDescentTime;
	private java.lang.Float dilatation;
	private java.lang.Float descent;
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
     *  column="lr_dilatation_descent_id"
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
	 * Return the value associated with the column: dilatation_descent_date
	 */
	public java.util.Date getDilatationDescentDate () {
		return dilatationDescentDate;
	}

	/**
	 * Set the value related to the column: dilatation_descent_date
	 * @param dilatationDescentDate the dilatation_descent_date value
	 */
	public void setDilatationDescentDate (java.util.Date dilatationDescentDate) {
		this.dilatationDescentDate = dilatationDescentDate;
	}



	/**
	 * Return the value associated with the column: dilatation_descent_time
	 */
	public java.lang.String getDilatationDescentTime () {
		return dilatationDescentTime;
	}

	/**
	 * Set the value related to the column: dilatation_descent_time
	 * @param dilatationDescentTime the dilatation_descent_time value
	 */
	public void setDilatationDescentTime (java.lang.String dilatationDescentTime) {
		this.dilatationDescentTime = dilatationDescentTime;
	}



	/**
	 * Return the value associated with the column: dilatation
	 */
	public java.lang.Float getDilatation () {
		return dilatation;
	}

	/**
	 * Set the value related to the column: dilatation
	 * @param dilatation the dilatation value
	 */
	public void setDilatation (java.lang.Float dilatation) {
		this.dilatation = dilatation;
	}



	/**
	 * Return the value associated with the column: descent
	 */
	public java.lang.Float getDescent () {
		return descent;
	}

	/**
	 * Set the value related to the column: descent
	 * @param descent the descent value
	 */
	public void setDescent (java.lang.Float descent) {
		this.descent = descent;
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
		if (!(obj instanceof jkt.hms.masters.business.LrDilatationDescent)) return false;
		else {
			jkt.hms.masters.business.LrDilatationDescent lrDilatationDescent = (jkt.hms.masters.business.LrDilatationDescent) obj;
			if (null == this.getId() || null == lrDilatationDescent.getId()) return false;
			else return (this.getId().equals(lrDilatationDescent.getId()));
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