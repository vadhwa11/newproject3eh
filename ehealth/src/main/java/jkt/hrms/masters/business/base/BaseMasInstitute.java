package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_institute table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_institute"
 */

public abstract class BaseMasInstitute implements Serializable {

	public static String REF = "MasInstitute";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_INSTITUTE_NAME = "InstituteName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INSTITUTE_CODE = "InstituteCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasInstitute() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasInstitute(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String instituteName;
	private java.lang.String instituteCode;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="institute_id"
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
	 * Return the value associated with the column: institute_name
	 */
	public java.lang.String getInstituteName() {
		return instituteName;
	}

	/**
	 * Set the value related to the column: institute_name
	 * 
	 * @param instituteName
	 *            the institute_name value
	 */
	public void setInstituteName(java.lang.String instituteName) {
		this.instituteName = instituteName;
	}

	/**
	 * Return the value associated with the column: institute_code
	 */
	public java.lang.String getInstituteCode() {
		return instituteCode;
	}

	/**
	 * Set the value related to the column: institute_code
	 * 
	 * @param instituteCode
	 *            the institute_code value
	 */
	public void setInstituteCode(java.lang.String instituteCode) {
		this.instituteCode = instituteCode;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasInstitute)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasInstitute masInstitute = (jkt.hrms.masters.business.MasInstitute) obj;
			if (null == this.getId() || null == masInstitute.getId()) {
				return false;
			} else {
				return (this.getId().equals(masInstitute.getId()));
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