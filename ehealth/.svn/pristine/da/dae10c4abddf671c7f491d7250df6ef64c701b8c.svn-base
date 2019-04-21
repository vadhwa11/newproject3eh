package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_care_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_care_header"
 */

public abstract class BaseIpdCareHeader  implements Serializable {

	public static String REF = "IpdCareHeader";
	public static String PROP_NURSINGCARE_SETUP = "NursingcareSetup";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_CARE = "DateOfCare";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BILLED_CARE_COUNT = "BilledCareCount";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseIpdCareHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdCareHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
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
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.NursingcareSetup nursingcareSetup;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdCareDetails> ipdCareDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="care_header_id"
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
	 * Return the value associated with the column: nursingcare_setup_id
	 */
	public jkt.hms.masters.business.NursingcareSetup getNursingcareSetup () {
		return nursingcareSetup;
	}

	/**
	 * Set the value related to the column: nursingcare_setup_id
	 * @param nursingcareSetup the nursingcare_setup_id value
	 */
	public void setNursingcareSetup (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		this.nursingcareSetup = nursingcareSetup;
	}



	/**
	 * Return the value associated with the column: IpdCareDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdCareDetails> getIpdCareDetails () {
		return ipdCareDetails;
	}

	/**
	 * Set the value related to the column: IpdCareDetails
	 * @param ipdCareDetails the IpdCareDetails value
	 */
	public void setIpdCareDetails (java.util.Set<jkt.hms.masters.business.IpdCareDetails> ipdCareDetails) {
		this.ipdCareDetails = ipdCareDetails;
	}

	public void addToIpdCareDetails (jkt.hms.masters.business.IpdCareDetails ipdCareDetails) {
		if (null == getIpdCareDetails()) setIpdCareDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdCareDetails>());
		getIpdCareDetails().add(ipdCareDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdCareHeader)) return false;
		else {
			jkt.hms.masters.business.IpdCareHeader ipdCareHeader = (jkt.hms.masters.business.IpdCareHeader) obj;
			if (null == this.getId() || null == ipdCareHeader.getId()) return false;
			else return (this.getId().equals(ipdCareHeader.getId()));
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