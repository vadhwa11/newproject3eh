package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_vacancy_reason
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_vacancy_reason"
 */

public abstract class BaseMasVacancyReason implements Serializable {

	public static String REF = "MasVacancyReason";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VACANCY_REASON = "VacancyReason";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_VACANY_CODE = "VacanyCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasVacancyReason() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasVacancyReason(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vacancyReason;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String vacanyCode;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	// collections
	private java.util.Set<jkt.hrms.recruitment.masters.business.ResourceRequisition> resourceRequisitions;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="vacancy_reason_id"
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
	 * Return the value associated with the column: vacancy_reason
	 */
	public java.lang.String getVacancyReason() {
		return vacancyReason;
	}

	/**
	 * Set the value related to the column: vacancy_reason
	 * 
	 * @param vacancyReason
	 *            the vacancy_reason value
	 */
	public void setVacancyReason(java.lang.String vacancyReason) {
		this.vacancyReason = vacancyReason;
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
	 * Return the value associated with the column: vacany_code
	 */
	public java.lang.String getVacanyCode() {
		return vacanyCode;
	}

	/**
	 * Set the value related to the column: vacany_code
	 * 
	 * @param vacanyCode
	 *            the vacany_code value
	 */
	public void setVacanyCode(java.lang.String vacanyCode) {
		this.vacanyCode = vacanyCode;
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

	/**
	 * Return the value associated with the column: ResourceRequisitions
	 */
	public java.util.Set<jkt.hrms.recruitment.masters.business.ResourceRequisition> getResourceRequisitions() {
		return resourceRequisitions;
	}

	/**
	 * Set the value related to the column: ResourceRequisitions
	 * 
	 * @param resourceRequisitions
	 *            the ResourceRequisitions value
	 */
	public void setResourceRequisitions(
			java.util.Set<jkt.hrms.recruitment.masters.business.ResourceRequisition> resourceRequisitions) {
		this.resourceRequisitions = resourceRequisitions;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasVacancyReason)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasVacancyReason masVacancyReason = (jkt.hrms.masters.business.MasVacancyReason) obj;
			if (null == this.getId() || null == masVacancyReason.getId()) {
				return false;
			} else {
				return (this.getId().equals(masVacancyReason.getId()));
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