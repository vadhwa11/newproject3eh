package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_experience table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_experience"
 */

public abstract class BaseMasExperience implements Serializable {

	public static String REF = "MasExperience";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EXPERIENCE_YEARS = "ExperienceYears";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_EXP_CODE = "ExpCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasExperience() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasExperience(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String experienceYears;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer expCode;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: experience_years
	 */
	public java.lang.String getExperienceYears() {
		return experienceYears;
	}

	/**
	 * Set the value related to the column: experience_years
	 * 
	 * @param experienceYears
	 *            the experience_years value
	 */
	public void setExperienceYears(java.lang.String experienceYears) {
		this.experienceYears = experienceYears;
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
	 * Return the value associated with the column: exp_code
	 */
	public java.lang.Integer getExpCode() {
		return expCode;
	}

	/**
	 * Set the value related to the column: exp_code
	 * 
	 * @param expCode
	 *            the exp_code value
	 */
	public void setExpCode(java.lang.Integer expCode) {
		this.expCode = expCode;
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
		if (!(obj instanceof jkt.hrms.masters.business.MasExperience)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasExperience masExperience = (jkt.hrms.masters.business.MasExperience) obj;
			if (null == this.getId() || null == masExperience.getId()) {
				return false;
			} else {
				return (this.getId().equals(masExperience.getId()));
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