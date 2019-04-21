package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_severity_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_severity_code"
 */

public abstract class BaseMasSeverityCode  implements Serializable {

	public static String REF = "MasSeverityCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_SEVERITY_CODE = "SeverityCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SEVERITY_NAME = "SeverityName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasSeverityCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSeverityCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String severityCode;
	private java.lang.String severityName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> opdPatientAllergyTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="severity_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: severity_code
	 */
	public java.lang.String getSeverityCode () {
		return severityCode;
	}

	/**
	 * Set the value related to the column: severity_code
	 * @param severityCode the severity_code value
	 */
	public void setSeverityCode (java.lang.String severityCode) {
		this.severityCode = severityCode;
	}



	/**
	 * Return the value associated with the column: severity_name
	 */
	public java.lang.String getSeverityName () {
		return severityName;
	}

	/**
	 * Set the value related to the column: severity_name
	 * @param severityName the severity_name value
	 */
	public void setSeverityName (java.lang.String severityName) {
		this.severityName = severityName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: OpdPatientAllergyTs
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> getOpdPatientAllergyTs () {
		return opdPatientAllergyTs;
	}

	/**
	 * Set the value related to the column: OpdPatientAllergyTs
	 * @param opdPatientAllergyTs the OpdPatientAllergyTs value
	 */
	public void setOpdPatientAllergyTs (java.util.Set<jkt.hms.masters.business.OpdPatientAllergyT> opdPatientAllergyTs) {
		this.opdPatientAllergyTs = opdPatientAllergyTs;
	}

	public void addToOpdPatientAllergyTs (jkt.hms.masters.business.OpdPatientAllergyT opdPatientAllergyT) {
		if (null == getOpdPatientAllergyTs()) setOpdPatientAllergyTs(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientAllergyT>());
		getOpdPatientAllergyTs().add(opdPatientAllergyT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSeverityCode)) return false;
		else {
			jkt.hms.masters.business.MasSeverityCode masSeverityCode = (jkt.hms.masters.business.MasSeverityCode) obj;
			if (null == this.getId() || null == masSeverityCode.getId()) return false;
			else return (this.getId().equals(masSeverityCode.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}