package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_finding table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_finding"
 */

public abstract class BaseOpdPatientFinding  implements Serializable {

	public static String REF = "OpdPatientFinding";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PTT_DETAILS = "OpdPttDetails";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_FINDING_NAME = "FindingName";
	public static String PROP_FINDING_CODE = "FindingCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseOpdPatientFinding () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientFinding (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long findingCode;
	private java.lang.String findingName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.OpdPatientDetails opdPttDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="finding_id"
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
	 * Return the value associated with the column: finding_code
	 */
	public java.lang.Long getFindingCode () {
		return findingCode;
	}

	/**
	 * Set the value related to the column: finding_code
	 * @param findingCode the finding_code value
	 */
	public void setFindingCode (java.lang.Long findingCode) {
		this.findingCode = findingCode;
	}



	/**
	 * Return the value associated with the column: finding_name
	 */
	public java.lang.String getFindingName () {
		return findingName;
	}

	/**
	 * Set the value related to the column: finding_name
	 * @param findingName the finding_name value
	 */
	public void setFindingName (java.lang.String findingName) {
		this.findingName = findingName;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: opd_ptt_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPttDetails () {
		return opdPttDetails;
	}

	/**
	 * Set the value related to the column: opd_ptt_details_id
	 * @param opdPttDetails the opd_ptt_details_id value
	 */
	public void setOpdPttDetails (jkt.hms.masters.business.OpdPatientDetails opdPttDetails) {
		this.opdPttDetails = opdPttDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientFinding)) return false;
		else {
			jkt.hms.masters.business.OpdPatientFinding opdPatientFinding = (jkt.hms.masters.business.OpdPatientFinding) obj;
			if (null == this.getId() || null == opdPatientFinding.getId()) return false;
			else return (this.getId().equals(opdPatientFinding.getId()));
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