package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_notice_board_data
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_notice_board_data"
 */

public abstract class BaseHrNoticeBoardData implements Serializable {

	public static String REF = "HrNoticeBoardData";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_NOTICE_DATA = "NoticeData";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISPLAY_ON_INDEX = "DisplayOnIndex";

	// constructors
	public BaseHrNoticeBoardData() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrNoticeBoardData(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String noticeData;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.util.Date entryDate;
	private java.lang.String lastChgTime;
	private java.lang.String displayOnIndex;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="increment" column="id"
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
	 * Return the value associated with the column: notice_data
	 */
	public java.lang.String getNoticeData() {
		return noticeData;
	}

	/**
	 * Set the value related to the column: notice_data
	 * 
	 * @param noticeData
	 *            the notice_data value
	 */
	public void setNoticeData(java.lang.String noticeData) {
		this.noticeData = noticeData;
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
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
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
	 * Return the value associated with the column: display_on_index
	 */
	public java.lang.String getDisplayOnIndex() {
		return displayOnIndex;
	}

	/**
	 * Set the value related to the column: display_on_index
	 * 
	 * @param displayOnIndex
	 *            the display_on_index value
	 */
	public void setDisplayOnIndex(java.lang.String displayOnIndex) {
		this.displayOnIndex = displayOnIndex;
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
		if (!(obj instanceof jkt.hrms.masters.business.HrNoticeBoardData)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrNoticeBoardData hrNoticeBoardData = (jkt.hrms.masters.business.HrNoticeBoardData) obj;
			if (null == this.getId() || null == hrNoticeBoardData.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrNoticeBoardData.getId()));
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