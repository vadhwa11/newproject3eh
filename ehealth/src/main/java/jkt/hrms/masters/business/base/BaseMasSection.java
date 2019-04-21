package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_section table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_section"
 */

public abstract class BaseMasSection implements Serializable {

	public static String REF = "MasSection";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SECTION_CODE = "SectionCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SECTION_NAME = "SectionName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasSection() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSection(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sectionCode;
	private java.lang.String sectionName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="section_id"
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
	 * Return the value associated with the column: section_code
	 */
	public java.lang.String getSectionCode() {
		return sectionCode;
	}

	/**
	 * Set the value related to the column: section_code
	 * 
	 * @param sectionCode
	 *            the section_code value
	 */
	public void setSectionCode(java.lang.String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * Return the value associated with the column: section_name
	 */
	public java.lang.String getSectionName() {
		return sectionName;
	}

	/**
	 * Set the value related to the column: section_name
	 * 
	 * @param sectionName
	 *            the section_name value
	 */
	public void setSectionName(java.lang.String sectionName) {
		this.sectionName = sectionName;
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

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasSection)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasSection masSection = (jkt.hrms.masters.business.MasSection) obj;
			if (null == this.getId() || null == masSection.getId()) {
				return false;
			} else {
				return (this.getId().equals(masSection.getId()));
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