package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_disorder table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_disorder"
 */

public abstract class BaseOpdPatientDisorder  implements Serializable {

	public static String REF = "OpdPatientDisorder";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPD_PTT_DETAILS = "OpdPttDetails";
	public static String PROP_DISORDER_NAME = "DisorderName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISORDER_CODE = "DisorderCode";


	// constructors
	public BaseOpdPatientDisorder () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientDisorder (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Long disorderCode;
	private java.lang.String disorderName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.OpdPatientDetails opdPttDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="disorder_id"
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
	 * Return the value associated with the column: disorder_code
	 */
	public java.lang.Long getDisorderCode () {
		return disorderCode;
	}

	/**
	 * Set the value related to the column: disorder_code
	 * @param disorderCode the disorder_code value
	 */
	public void setDisorderCode (java.lang.Long disorderCode) {
		this.disorderCode = disorderCode;
	}



	/**
	 * Return the value associated with the column: disorder_name
	 */
	public java.lang.String getDisorderName () {
		return disorderName;
	}

	/**
	 * Set the value related to the column: disorder_name
	 * @param disorderName the disorder_name value
	 */
	public void setDisorderName (java.lang.String disorderName) {
		this.disorderName = disorderName;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientDisorder)) return false;
		else {
			jkt.hms.masters.business.OpdPatientDisorder opdPatientDisorder = (jkt.hms.masters.business.OpdPatientDisorder) obj;
			if (null == this.getId() || null == opdPatientDisorder.getId()) return false;
			else return (this.getId().equals(opdPatientDisorder.getId()));
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