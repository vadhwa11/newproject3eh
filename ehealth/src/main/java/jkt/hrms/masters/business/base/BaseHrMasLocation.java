package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_location table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="hr_mas_location"
 */

public abstract class BaseHrMasLocation implements Serializable {

	public static String REF = "HrMasLocation";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LOCATION_NAME = "LocationName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";
	public static String PROP_LOCATION_CODE = "LocationCode";

	// constructors
	public BaseHrMasLocation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLocation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String locationCode;
	private java.lang.String locationName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="location_id"
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
	 * Return the value associated with the column: location_code
	 */
	public java.lang.String getLocationCode() {
		return locationCode;
	}

	/**
	 * Set the value related to the column: location_code
	 * 
	 * @param locationCode
	 *            the location_code value
	 */
	public void setLocationCode(java.lang.String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * Return the value associated with the column: location_name
	 */
	public java.lang.String getLocationName() {
		return locationName;
	}

	/**
	 * Set the value related to the column: location_name
	 * 
	 * @param locationName
	 *            the location_name value
	 */
	public void setLocationName(java.lang.String locationName) {
		this.locationName = locationName;
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

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.HrMasLocation)) {
			return false;
		} else {
			jkt.hrms.masters.business.HrMasLocation hrMasLocation = (jkt.hrms.masters.business.HrMasLocation) obj;
			if (null == this.getId() || null == hrMasLocation.getId()) {
				return false;
			} else {
				return (this.getId().equals(hrMasLocation.getId()));
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