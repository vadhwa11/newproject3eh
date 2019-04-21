package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_resume_pay_elements
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_resume_pay_elements"
 */

public abstract class BaseHrResumePayElements implements Serializable {

	public static String REF = "HrResumePayElements";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAY_ELEMENT = "PayElement";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_RESUME = "Resume";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PAY_AMOUNT = "PayAmount";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseHrResumePayElements() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrResumePayElements(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrResumePayElements(java.lang.Integer id,
			jkt.hrms.masters.business.HrMasPayElement payElement,
			jkt.hrms.recruitment.masters.business.Resumepersonaldetails resume,
			java.lang.String lastChgBy) {

		this.setId(id);
		this.setPayElement(payElement);
		this.setResume(resume);
		this.setLastChgBy(lastChgBy);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal payAmount;
	private java.util.Date startDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.HrMasPayElement payElement;
	private jkt.hrms.recruitment.masters.business.Resumepersonaldetails resume;

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
	 * Return the value associated with the column: pay_amount
	 */
	public java.math.BigDecimal getPayAmount() {
		return payAmount;
	}

	/**
	 * Set the value related to the column: pay_amount
	 * 
	 * @param payAmount
	 *            the pay_amount value
	 */
	public void setPayAmount(java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * 
	 * @param startDate
	 *            the start_date value
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
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
	 * Return the value associated with the column: pay_element_id
	 */
	public jkt.hrms.masters.business.HrMasPayElement getPayElement() {
		return payElement;
	}

	/**
	 * Set the value related to the column: pay_element_id
	 * 
	 * @param payElement
	 *            the pay_element_id value
	 */
	public void setPayElement(
			jkt.hrms.masters.business.HrMasPayElement payElement) {
		this.payElement = payElement;
	}

	/**
	 * Return the value associated with the column: resume_id
	 */
	public jkt.hrms.recruitment.masters.business.Resumepersonaldetails getResume() {
		return resume;
	}

	/**
	 * Set the value related to the column: resume_id
	 * 
	 * @param resume
	 *            the resume_id value
	 */
	public void setResume(
			jkt.hrms.recruitment.masters.business.Resumepersonaldetails resume) {
		this.resume = resume;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.HrResumePayElements)) {
			return false;
		} else {
			jkt.hrms.recruitment.masters.business.HrResumePayElements hrResumePayElements = (jkt.hrms.recruitment.masters.business.HrResumePayElements) obj;
			if (null == this.getId() || null == hrResumePayElements.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrResumePayElements.getId()));
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