package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_mas_special_qualification table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_special_qualification"
 */

public abstract class BaseHrMasSpecialQualification implements Serializable {

	public static String REF = "HrMasSpecialQualification";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPECIAL_QUALIFICATION_NAME = "SpecialQualificationName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";
	public static String PROP_SPECIAL_QUALIFICATION_CODE = "SpecialQualificationCode";

	// constructors
	public BaseHrMasSpecialQualification() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasSpecialQualification(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String specialQualificationCode;
	private java.lang.String specialQualificationName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="special_qualification_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: special_qualification_code
	 */
	public java.lang.String getSpecialQualificationCode() {
		return specialQualificationCode;
	}

	/**
	 * Set the value related to the column: special_qualification_code
	 * 
	 * @param specialQualificationCode
	 *            the special_qualification_code value
	 */
	public void setSpecialQualificationCode(
			java.lang.String specialQualificationCode) {
		this.specialQualificationCode = specialQualificationCode;
	}

	/**
	 * Return the value associated with the column: special_qualification_name
	 */
	public java.lang.String getSpecialQualificationName() {
		return specialQualificationName;
	}

	/**
	 * Set the value related to the column: special_qualification_name
	 * 
	 * @param specialQualificationName
	 *            the special_qualification_name value
	 */
	public void setSpecialQualificationName(
			java.lang.String specialQualificationName) {
		this.specialQualificationName = specialQualificationName;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany() {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * 
	 * @param company
	 *            the company_id value
	 */
	public void setCompany(jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.HrMasSpecialQualification)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrMasSpecialQualification hrMasSpecialQualification = (jkt.hrms.masters.business.HrMasSpecialQualification) obj;
			if (null == this.getId()
					|| null == hrMasSpecialQualification.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrMasSpecialQualification.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}