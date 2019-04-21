package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_vital_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_vital_setup"
 */

public abstract class BaseIpdVitalSetup  implements Serializable {

	public static String REF = "IpdVitalSetup";
	public static String PROP_VITAL_NAME = "VitalName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STOP_VITAL = "StopVital";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseIpdVitalSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdVitalSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vitalName;
	private java.lang.String remarks;
	private java.lang.String stopVital;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasFrequency frequency;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdVitalcareHeader> ipdVitalcareHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="vital_setup_id"
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
	 * Return the value associated with the column: vital_name
	 */
	public java.lang.String getVitalName () {
		return vitalName;
	}

	/**
	 * Set the value related to the column: vital_name
	 * @param vitalName the vital_name value
	 */
	public void setVitalName (java.lang.String vitalName) {
		this.vitalName = vitalName;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: stop_vital
	 */
	public java.lang.String getStopVital () {
		return stopVital;
	}

	/**
	 * Set the value related to the column: stop_vital
	 * @param stopVital the stop_vital value
	 */
	public void setStopVital (java.lang.String stopVital) {
		this.stopVital = stopVital;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: IpdVitalcareHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.IpdVitalcareHeader> getIpdVitalcareHeaders () {
		return ipdVitalcareHeaders;
	}

	/**
	 * Set the value related to the column: IpdVitalcareHeaders
	 * @param ipdVitalcareHeaders the IpdVitalcareHeaders value
	 */
	public void setIpdVitalcareHeaders (java.util.Set<jkt.hms.masters.business.IpdVitalcareHeader> ipdVitalcareHeaders) {
		this.ipdVitalcareHeaders = ipdVitalcareHeaders;
	}

	public void addToIpdVitalcareHeaders (jkt.hms.masters.business.IpdVitalcareHeader ipdVitalcareHeader) {
		if (null == getIpdVitalcareHeaders()) setIpdVitalcareHeaders(new java.util.TreeSet<jkt.hms.masters.business.IpdVitalcareHeader>());
		getIpdVitalcareHeaders().add(ipdVitalcareHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdVitalSetup)) return false;
		else {
			jkt.hms.masters.business.IpdVitalSetup ipdVitalSetup = (jkt.hms.masters.business.IpdVitalSetup) obj;
			if (null == this.getId() || null == ipdVitalSetup.getId()) return false;
			else return (this.getId().equals(ipdVitalSetup.getId()));
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