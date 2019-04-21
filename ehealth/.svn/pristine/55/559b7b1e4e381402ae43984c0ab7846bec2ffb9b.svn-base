package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_deputation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_deputation"
 */

public abstract class BaseHrEmployeeDeputation  implements Serializable {

	public static String REF = "HrEmployeeDeputation";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DEPU_DEPARTMENT = "DepuDepartment";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_DEPU_HOSPITAL = "DepuHospital";
	public static String PROP_DEPU_PERIOD_UNIT = "DepuPeriodUnit";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_CUR_HOSPITAL = "CurHospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_DEPU_DESIGNATION = "DepuDesignation";
	public static String PROP_DEPU_PERIOD = "DepuPeriod";
	public static String PROP_OTHER_INSTITUTION = "OtherInstitution";
	public static String PROP_ID = "Id";
	public static String PROP_CUR_DESIGNATION = "CurDesignation";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CUR_DEPARTMENT = "CurDepartment";


	// constructors
	public BaseHrEmployeeDeputation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeDeputation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String orderNo;
	private java.util.Date orderDate;
	private java.lang.Integer depuPeriod;
	private java.lang.String depuPeriodUnit;
	private java.lang.String otherInstitution;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital curHospital;
	private jkt.hms.masters.business.MasHospital depuHospital;
	private jkt.hms.masters.business.MasDepartment depuDepartment;
	private jkt.hms.masters.business.MasRank depuDesignation;
	private jkt.hms.masters.business.MasDepartment curDepartment;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasRank curDesignation;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="deputation_id"
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
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
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
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.String orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: order_date
	 */
	public java.util.Date getOrderDate () {
		return orderDate;
	}

	/**
	 * Set the value related to the column: order_date
	 * @param orderDate the order_date value
	 */
	public void setOrderDate (java.util.Date orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * Return the value associated with the column: depu_period
	 */
	public java.lang.Integer getDepuPeriod () {
		return depuPeriod;
	}

	/**
	 * Set the value related to the column: depu_period
	 * @param depuPeriod the depu_period value
	 */
	public void setDepuPeriod (java.lang.Integer depuPeriod) {
		this.depuPeriod = depuPeriod;
	}



	/**
	 * Return the value associated with the column: depu_period_unit
	 */
	public java.lang.String getDepuPeriodUnit () {
		return depuPeriodUnit;
	}

	/**
	 * Set the value related to the column: depu_period_unit
	 * @param depuPeriodUnit the depu_period_unit value
	 */
	public void setDepuPeriodUnit (java.lang.String depuPeriodUnit) {
		this.depuPeriodUnit = depuPeriodUnit;
	}



	/**
	 * Return the value associated with the column: other_institution
	 */
	public java.lang.String getOtherInstitution () {
		return otherInstitution;
	}

	/**
	 * Set the value related to the column: other_institution
	 * @param otherInstitution the other_institution value
	 */
	public void setOtherInstitution (java.lang.String otherInstitution) {
		this.otherInstitution = otherInstitution;
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
	 * Return the value associated with the column: cur_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getCurHospital () {
		return curHospital;
	}

	/**
	 * Set the value related to the column: cur_hospital_id
	 * @param curHospital the cur_hospital_id value
	 */
	public void setCurHospital (jkt.hms.masters.business.MasHospital curHospital) {
		this.curHospital = curHospital;
	}



	/**
	 * Return the value associated with the column: depu_hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getDepuHospital () {
		return depuHospital;
	}

	/**
	 * Set the value related to the column: depu_hospital_id
	 * @param depuHospital the depu_hospital_id value
	 */
	public void setDepuHospital (jkt.hms.masters.business.MasHospital depuHospital) {
		this.depuHospital = depuHospital;
	}



	/**
	 * Return the value associated with the column: depu_department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepuDepartment () {
		return depuDepartment;
	}

	/**
	 * Set the value related to the column: depu_department_id
	 * @param depuDepartment the depu_department_id value
	 */
	public void setDepuDepartment (jkt.hms.masters.business.MasDepartment depuDepartment) {
		this.depuDepartment = depuDepartment;
	}



	/**
	 * Return the value associated with the column: depu_designation_id
	 */
	public jkt.hms.masters.business.MasRank getDepuDesignation () {
		return depuDesignation;
	}

	/**
	 * Set the value related to the column: depu_designation_id
	 * @param depuDesignation the depu_designation_id value
	 */
	public void setDepuDesignation (jkt.hms.masters.business.MasRank depuDesignation) {
		this.depuDesignation = depuDesignation;
	}



	/**
	 * Return the value associated with the column: cur_department_id
	 */
	public jkt.hms.masters.business.MasDepartment getCurDepartment () {
		return curDepartment;
	}

	/**
	 * Set the value related to the column: cur_department_id
	 * @param curDepartment the cur_department_id value
	 */
	public void setCurDepartment (jkt.hms.masters.business.MasDepartment curDepartment) {
		this.curDepartment = curDepartment;
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
	 * Return the value associated with the column: cur_designation_id
	 */
	public jkt.hms.masters.business.MasRank getCurDesignation () {
		return curDesignation;
	}

	/**
	 * Set the value related to the column: cur_designation_id
	 * @param curDesignation the cur_designation_id value
	 */
	public void setCurDesignation (jkt.hms.masters.business.MasRank curDesignation) {
		this.curDesignation = curDesignation;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeDeputation)) return false;
		else {
			jkt.hms.masters.business.HrEmployeeDeputation hrEmployeeDeputation = (jkt.hms.masters.business.HrEmployeeDeputation) obj;
			if (null == this.getId() || null == hrEmployeeDeputation.getId()) return false;
			else return (this.getId().equals(hrEmployeeDeputation.getId()));
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