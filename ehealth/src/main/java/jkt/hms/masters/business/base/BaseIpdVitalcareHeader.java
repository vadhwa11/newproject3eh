package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_vitalcare_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_vitalcare_header"
 */

public abstract class BaseIpdVitalcareHeader  implements Serializable {

	public static String REF = "IpdVitalcareHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VITAL_SETUP = "VitalSetup";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_CARE = "DateOfCare";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BILLED_CARE_COUNT = "BilledCareCount";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseIpdVitalcareHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdVitalcareHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfCare;
	private java.lang.Integer billedCareCount;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.IpdVitalSetup vitalSetup;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdVitalcareDetails> ipdVitalcareDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="vital_header_id"
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
	 * Return the value associated with the column: date_of_care
	 */
	public java.util.Date getDateOfCare () {
		return dateOfCare;
	}

	/**
	 * Set the value related to the column: date_of_care
	 * @param dateOfCare the date_of_care value
	 */
	public void setDateOfCare (java.util.Date dateOfCare) {
		this.dateOfCare = dateOfCare;
	}



	/**
	 * Return the value associated with the column: billed_care_count
	 */
	public java.lang.Integer getBilledCareCount () {
		return billedCareCount;
	}

	/**
	 * Set the value related to the column: billed_care_count
	 * @param billedCareCount the billed_care_count value
	 */
	public void setBilledCareCount (java.lang.Integer billedCareCount) {
		this.billedCareCount = billedCareCount;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: vital_setup_id
	 */
	public jkt.hms.masters.business.IpdVitalSetup getVitalSetup () {
		return vitalSetup;
	}

	/**
	 * Set the value related to the column: vital_setup_id
	 * @param vitalSetup the vital_setup_id value
	 */
	public void setVitalSetup (jkt.hms.masters.business.IpdVitalSetup vitalSetup) {
		this.vitalSetup = vitalSetup;
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
	 * Return the value associated with the column: IpdVitalcareDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdVitalcareDetails> getIpdVitalcareDetails () {
		return ipdVitalcareDetails;
	}

	/**
	 * Set the value related to the column: IpdVitalcareDetails
	 * @param ipdVitalcareDetails the IpdVitalcareDetails value
	 */
	public void setIpdVitalcareDetails (java.util.Set<jkt.hms.masters.business.IpdVitalcareDetails> ipdVitalcareDetails) {
		this.ipdVitalcareDetails = ipdVitalcareDetails;
	}

	public void addToIpdVitalcareDetails (jkt.hms.masters.business.IpdVitalcareDetails ipdVitalcareDetails) {
		if (null == getIpdVitalcareDetails()) setIpdVitalcareDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdVitalcareDetails>());
		getIpdVitalcareDetails().add(ipdVitalcareDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdVitalcareHeader)) return false;
		else {
			jkt.hms.masters.business.IpdVitalcareHeader ipdVitalcareHeader = (jkt.hms.masters.business.IpdVitalcareHeader) obj;
			if (null == this.getId() || null == ipdVitalcareHeader.getId()) return false;
			else return (this.getId().equals(ipdVitalcareHeader.getId()));
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