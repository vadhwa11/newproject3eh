package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_leave table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_leave"
 */

public abstract class BaseHrMasLeave implements Serializable {

	public static String REF = "HrMasLeave";
	public static String PROP_STATUS = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseHrMasLeave() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLeave(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	// collections
	private java.util.Set<jkt.hrms.masters.business.HrLeaveDetails> leaveDetails;
	private java.util.Set<jkt.hrms.masters.business.HrLeaveDetailsHistory> leaveDetailsHistories;

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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * 
	 * @param description
	 *            the description value
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: LeaveDetails
	 */
	public java.util.Set<jkt.hrms.masters.business.HrLeaveDetails> getLeaveDetails() {
		return leaveDetails;
	}

	/**
	 * Set the value related to the column: LeaveDetails
	 * 
	 * @param leaveDetails
	 *            the LeaveDetails value
	 */
	public void setLeaveDetails(
			java.util.Set<jkt.hrms.masters.business.HrLeaveDetails> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

	public void addToLeaveDetails(
			jkt.hrms.masters.business.HrLeaveDetails hrLeaveDetails) {
		if (null == getLeaveDetails()) {
			setLeaveDetails(new java.util.TreeSet<jkt.hrms.masters.business.HrLeaveDetails>());
		}
		getLeaveDetails().add(hrLeaveDetails);
	}

	/**
	 * Return the value associated with the column: LeaveDetailsHistories
	 */
	public java.util.Set<jkt.hrms.masters.business.HrLeaveDetailsHistory> getLeaveDetailsHistories() {
		return leaveDetailsHistories;
	}

	/**
	 * Set the value related to the column: LeaveDetailsHistories
	 * 
	 * @param leaveDetailsHistories
	 *            the LeaveDetailsHistories value
	 */
	public void setLeaveDetailsHistories(
			java.util.Set<jkt.hrms.masters.business.HrLeaveDetailsHistory> leaveDetailsHistories) {
		this.leaveDetailsHistories = leaveDetailsHistories;
	}

	public void addToLeaveDetailsHistories(
			jkt.hrms.masters.business.HrLeaveDetailsHistory hrLeaveDetailsHistory) {
		if (null == getLeaveDetailsHistories()) {
			setLeaveDetailsHistories(new java.util.TreeSet<jkt.hrms.masters.business.HrLeaveDetailsHistory>());
		}
		getLeaveDetailsHistories().add(hrLeaveDetailsHistory);
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.HrMasLeave)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrMasLeave hrMasLeave = (jkt.hrms.masters.business.HrMasLeave) obj;
			if (null == this.getId() || null == hrMasLeave.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrMasLeave.getId()));
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