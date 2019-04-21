package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_duty_schedule_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_duty_schedule_m"
 */

public abstract class BaseHrDutyScheduleM  implements Serializable {

	public static String REF = "HrDutyScheduleM";
	public static String PROP_VALIDATE_TIME = "ValidateTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MONTH = "Month";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EMPLOYEE_CATE = "EmployeeCate";
	public static String PROP_STATUS = "Status";
	public static String PROP_YEAR = "Year";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VALIDATE_BY = "ValidateBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VALIDATE_DATE = "ValidateDate";


	// constructors
	public BaseHrDutyScheduleM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrDutyScheduleM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date validateDate;
	private java.lang.String validateTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String month;
	private int year;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.Users validateBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasEmpCategory employeeCate;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrDutyScheduleT> hrDutyScheduleTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="schedule_m_id"
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
	 * Return the value associated with the column: validate_date
	 */
	public java.util.Date getValidateDate () {
		return validateDate;
	}

	/**
	 * Set the value related to the column: validate_date
	 * @param validateDate the validate_date value
	 */
	public void setValidateDate (java.util.Date validateDate) {
		this.validateDate = validateDate;
	}



	/**
	 * Return the value associated with the column: validate_time
	 */
	public java.lang.String getValidateTime () {
		return validateTime;
	}

	/**
	 * Set the value related to the column: validate_time
	 * @param validateTime the validate_time value
	 */
	public void setValidateTime (java.lang.String validateTime) {
		this.validateTime = validateTime;
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
	 * Return the value associated with the column: month
	 */
	public java.lang.String getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.String month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: schedule_year
	 */
	public int getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: schedule_year
	 * @param year the schedule_year value
	 */
	public void setYear (int year) {
		this.year = year;
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
	 * Return the value associated with the column: validate_by
	 */
	public jkt.hms.masters.business.Users getValidateBy () {
		return validateBy;
	}

	/**
	 * Set the value related to the column: validate_by
	 * @param validateBy the validate_by value
	 */
	public void setValidateBy (jkt.hms.masters.business.Users validateBy) {
		this.validateBy = validateBy;
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



	/**
	 * Return the value associated with the column: emp_category_id
	 */
	public jkt.hms.masters.business.MasEmpCategory getEmployeeCate () {
		return employeeCate;
	}

	/**
	 * Set the value related to the column: emp_category_id
	 * @param employeeCate the emp_category_id value
	 */
	public void setEmployeeCate (jkt.hms.masters.business.MasEmpCategory employeeCate) {
		this.employeeCate = employeeCate;
	}



	/**
	 * Return the value associated with the column: HrDutyScheduleTs
	 */
	public java.util.Set<jkt.hms.masters.business.HrDutyScheduleT> getHrDutyScheduleTs () {
		return hrDutyScheduleTs;
	}

	/**
	 * Set the value related to the column: HrDutyScheduleTs
	 * @param hrDutyScheduleTs the HrDutyScheduleTs value
	 */
	public void setHrDutyScheduleTs (java.util.Set<jkt.hms.masters.business.HrDutyScheduleT> hrDutyScheduleTs) {
		this.hrDutyScheduleTs = hrDutyScheduleTs;
	}

	public void addToHrDutyScheduleTs (jkt.hms.masters.business.HrDutyScheduleT hrDutyScheduleT) {
		if (null == getHrDutyScheduleTs()) setHrDutyScheduleTs(new java.util.TreeSet<jkt.hms.masters.business.HrDutyScheduleT>());
		getHrDutyScheduleTs().add(hrDutyScheduleT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrDutyScheduleM)) return false;
		else {
			jkt.hms.masters.business.HrDutyScheduleM hrDutyScheduleM = (jkt.hms.masters.business.HrDutyScheduleM) obj;
			if (null == this.getId() || null == hrDutyScheduleM.getId()) return false;
			else return (this.getId().equals(hrDutyScheduleM.getId()));
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