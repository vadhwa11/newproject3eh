package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_language table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_language"
 */

public abstract class BaseMasLanguage implements Serializable {

	public static String REF = "MasLanguage";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LANGUAGE_CODE = "LanguageCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LANGUAGE_DESCRIPTION = "LanguageDescription";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseMasLanguage() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasLanguage(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String languageCode;
	private java.lang.String languageDescription;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> masSetupParameterMaintainces;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="language_id"
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
	 * Return the value associated with the column: language_code
	 */
	public java.lang.String getLanguageCode() {
		return languageCode;
	}

	/**
	 * Set the value related to the column: language_code
	 * 
	 * @param languageCode
	 *            the language_code value
	 */
	public void setLanguageCode(java.lang.String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * Return the value associated with the column: language_description
	 */
	public java.lang.String getLanguageDescription() {
		return languageDescription;
	}

	/**
	 * Set the value related to the column: language_description
	 * 
	 * @param languageDescription
	 *            the language_description value
	 */
	public void setLanguageDescription(java.lang.String languageDescription) {
		this.languageDescription = languageDescription;
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
	 * Return the value associated with the column: MasSetupParameterMaintainces
	 */
	public java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> getMasSetupParameterMaintainces() {
		return masSetupParameterMaintainces;
	}

	/**
	 * Set the value related to the column: MasSetupParameterMaintainces
	 * 
	 * @param masSetupParameterMaintainces
	 *            the MasSetupParameterMaintainces value
	 */
	public void setMasSetupParameterMaintainces(
			java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> masSetupParameterMaintainces) {
		this.masSetupParameterMaintainces = masSetupParameterMaintainces;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.MasLanguage)) {
			return false;
		} else {
			jkt.hms.masters.business.MasLanguage masLanguage = (jkt.hms.masters.business.MasLanguage) obj;
			if (null == this.getId() || null == masLanguage.getId()) {
				return false;
			} else {
				return (this.getId().equals(masLanguage.getId()));
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