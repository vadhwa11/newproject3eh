package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the nursingcare_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="nursingcare_setup"
 */

public abstract class BaseNursingcareSetup  implements Serializable {

	public static String REF = "NursingcareSetup";
	public static String PROP_STOP_CARE = "StopCare";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PRESCRIBED_BY_NURSE = "PrescribedByNurse";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NURSING = "Nursing";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseNursingcareSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNursingcareSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String stopCare;
	private java.lang.String prescribedByNurse;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasNursingCare nursing;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="nursingcare_setup_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
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
	 * Return the value associated with the column: stop_care
	 */
	public java.lang.String getStopCare () {
		return stopCare;
	}

	/**
	 * Set the value related to the column: stop_care
	 * @param stopCare the stop_care value
	 */
	public void setStopCare (java.lang.String stopCare) {
		this.stopCare = stopCare;
	}



	/**
	 * Return the value associated with the column: prescribed_by_nurse
	 */
	public java.lang.String getPrescribedByNurse () {
		return prescribedByNurse;
	}

	/**
	 * Set the value related to the column: prescribed_by_nurse
	 * @param prescribedByNurse the prescribed_by_nurse value
	 */
	public void setPrescribedByNurse (java.lang.String prescribedByNurse) {
		this.prescribedByNurse = prescribedByNurse;
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
	 * Return the value associated with the column: nursing_id
	 */
	public jkt.hms.masters.business.MasNursingCare getNursing () {
		return nursing;
	}

	/**
	 * Set the value related to the column: nursing_id
	 * @param nursing the nursing_id value
	 */
	public void setNursing (jkt.hms.masters.business.MasNursingCare nursing) {
		this.nursing = nursing;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.NursingcareSetup)) return false;
		else {
			jkt.hms.masters.business.NursingcareSetup nursingcareSetup = (jkt.hms.masters.business.NursingcareSetup) obj;
			if (null == this.getId() || null == nursingcareSetup.getId()) return false;
			else return (this.getId().equals(nursingcareSetup.getId()));
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