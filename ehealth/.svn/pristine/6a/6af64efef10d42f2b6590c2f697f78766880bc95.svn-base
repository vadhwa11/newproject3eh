package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_parameter table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_parameter"
 */

public abstract class BaseHrParameter implements Serializable {

	public static String REF = "HrParameter";
	public static String PROP_HALFDAY = "Halfday";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_OVERTIME = "Overtime";
	public static String PROP_FULLDAY = "Fullday";
	public static String PROP_ID = "Id";

	// constructors
	public BaseHrParameter() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrParameter(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Float fullday;
	private java.lang.Float halfday;
	private java.lang.Float overtime;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

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
	 * Return the value associated with the column: fullday
	 */
	public java.lang.Float getFullday() {
		return fullday;
	}

	/**
	 * Set the value related to the column: fullday
	 * 
	 * @param fullday
	 *            the fullday value
	 */
	public void setFullday(java.lang.Float fullday) {
		this.fullday = fullday;
	}

	/**
	 * Return the value associated with the column: halfday
	 */
	public java.lang.Float getHalfday() {
		return halfday;
	}

	/**
	 * Set the value related to the column: halfday
	 * 
	 * @param halfday
	 *            the halfday value
	 */
	public void setHalfday(java.lang.Float halfday) {
		this.halfday = halfday;
	}

	/**
	 * Return the value associated with the column: overtime
	 */
	public java.lang.Float getOvertime() {
		return overtime;
	}

	/**
	 * Set the value related to the column: overtime
	 * 
	 * @param overtime
	 *            the overtime value
	 */
	public void setOvertime(java.lang.Float overtime) {
		this.overtime = overtime;
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

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.HrParameter)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrParameter hrParameter = (jkt.hrms.masters.business.HrParameter) obj;
			if (null == this.getId() || null == hrParameter.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrParameter.getId()));
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