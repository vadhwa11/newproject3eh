package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hms_notice_board table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hms_notice_board"
 */

public abstract class BaseHmsNoticeBoard implements Serializable {

	public static String REF = "HmsNoticeBoard";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_NOTICE_CODE = "NoticeCode";
	public static String PROP_DESC = "Desc";

	// constructors
	public BaseHmsNoticeBoard() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHmsNoticeBoard(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String noticeCode;
	private java.lang.String desc;
	private java.lang.String status;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;

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
	 * Return the value associated with the column: notice_code
	 */
	public java.lang.String getNoticeCode() {
		return noticeCode;
	}

	/**
	 * Set the value related to the column: notice_code
	 * 
	 * @param noticeCode
	 *            the notice_code value
	 */
	public void setNoticeCode(java.lang.String noticeCode) {
		this.noticeCode = noticeCode;
	}

	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDesc() {
		return desc;
	}

	/**
	 * Set the value related to the column: description
	 * 
	 * @param desc
	 *            the description value
	 */
	public void setDesc(java.lang.String desc) {
		this.desc = desc;
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
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChangedBy
	 *            the last_chg_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChangedDate
	 *            the last_chg_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChangedTime
	 *            the last_chg_time value
	 */
	public void setLastChangedTime(java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.HmsNoticeBoard)) {
			return false;
		} else {
			jkt.hms.masters.business.HmsNoticeBoard hmsNoticeBoard = (jkt.hms.masters.business.HmsNoticeBoard) obj;
			if (null == this.getId() || null == hmsNoticeBoard.getId()) {
				return false;
			} else {
				return (this.getId().equals(hmsNoticeBoard.getId()));
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