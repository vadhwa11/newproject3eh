package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the blood_result_entry_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="blood_result_entry_header"
 */

public abstract class BaseBloodResultEntryHeader  implements Serializable {

	public static String REF = "BloodResultEntryHeader";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CG_BLOOD_GROUP = "CgBloodGroup";
	public static String PROP_RESULT_ENTRY_VALIDATION = "ResultEntryValidation";
	public static String PROP_DISCREPANCY = "Discrepancy";
	public static String PROP_CG_REMARK = "CgRemark";
	public static String PROP_RH_FACTOR = "RhFactor";
	public static String PROP_SG_REMARK = "SgRemark";
	public static String PROP_CG_RH_FACTOR = "CgRhFactor";
	public static String PROP_SAMPLE_COLLECTION = "SampleCollection";
	public static String PROP_SG_STATUS = "SgStatus";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DONOR = "Donor";
	public static String PROP_CG_STATUS = "CgStatus";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SG_BLOOD_GROUP = "SgBloodGroup";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SCREENING_TEST = "ScreeningTest";


	// constructors
	public BaseBloodResultEntryHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodResultEntryHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cgRemark;
	private java.lang.String cgStatus;
	private java.lang.String rhFactor;
	private java.lang.String sgRemark;
	private java.lang.String sgStatus;
	private java.lang.String resultEntryValidation;
	private java.lang.String remarks;
	private java.lang.String discrepancy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String cgRhFactor;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasBloodGroup sgBloodGroup;
	private jkt.hms.masters.business.BloodDonationEntryHeader donor;
	private jkt.hms.masters.business.BloodSampleCollection sampleCollection;
	private jkt.hms.masters.business.MasBloodGroup cgBloodGroup;
	private jkt.hms.masters.business.BloodSampleScreeningHeader screeningTest;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodResultEntryDetails> bloodResultEntryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="header_id"
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
	 * Return the value associated with the column: cg_remark
	 */
	public java.lang.String getCgRemark () {
		return cgRemark;
	}

	/**
	 * Set the value related to the column: cg_remark
	 * @param cgRemark the cg_remark value
	 */
	public void setCgRemark (java.lang.String cgRemark) {
		this.cgRemark = cgRemark;
	}



	/**
	 * Return the value associated with the column: cg_status
	 */
	public java.lang.String getCgStatus () {
		return cgStatus;
	}

	/**
	 * Set the value related to the column: cg_status
	 * @param cgStatus the cg_status value
	 */
	public void setCgStatus (java.lang.String cgStatus) {
		this.cgStatus = cgStatus;
	}



	/**
	 * Return the value associated with the column: rh_factor
	 */
	public java.lang.String getRhFactor () {
		return rhFactor;
	}

	/**
	 * Set the value related to the column: rh_factor
	 * @param rhFactor the rh_factor value
	 */
	public void setRhFactor (java.lang.String rhFactor) {
		this.rhFactor = rhFactor;
	}



	/**
	 * Return the value associated with the column: sg_remark
	 */
	public java.lang.String getSgRemark () {
		return sgRemark;
	}

	/**
	 * Set the value related to the column: sg_remark
	 * @param sgRemark the sg_remark value
	 */
	public void setSgRemark (java.lang.String sgRemark) {
		this.sgRemark = sgRemark;
	}



	/**
	 * Return the value associated with the column: sg_status
	 */
	public java.lang.String getSgStatus () {
		return sgStatus;
	}

	/**
	 * Set the value related to the column: sg_status
	 * @param sgStatus the sg_status value
	 */
	public void setSgStatus (java.lang.String sgStatus) {
		this.sgStatus = sgStatus;
	}



	/**
	 * Return the value associated with the column: result_entry_validation
	 */
	public java.lang.String getResultEntryValidation () {
		return resultEntryValidation;
	}

	/**
	 * Set the value related to the column: result_entry_validation
	 * @param resultEntryValidation the result_entry_validation value
	 */
	public void setResultEntryValidation (java.lang.String resultEntryValidation) {
		this.resultEntryValidation = resultEntryValidation;
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
	 * Return the value associated with the column: discrepancy
	 */
	public java.lang.String getDiscrepancy () {
		return discrepancy;
	}

	/**
	 * Set the value related to the column: discrepancy
	 * @param discrepancy the discrepancy value
	 */
	public void setDiscrepancy (java.lang.String discrepancy) {
		this.discrepancy = discrepancy;
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
	 * Return the value associated with the column: cg_rh_factor
	 */
	public java.lang.String getCgRhFactor () {
		return cgRhFactor;
	}

	/**
	 * Set the value related to the column: cg_rh_factor
	 * @param cgRhFactor the cg_rh_factor value
	 */
	public void setCgRhFactor (java.lang.String cgRhFactor) {
		this.cgRhFactor = cgRhFactor;
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
	 * Return the value associated with the column: sg_blood_group
	 */
	public jkt.hms.masters.business.MasBloodGroup getSgBloodGroup () {
		return sgBloodGroup;
	}

	/**
	 * Set the value related to the column: sg_blood_group
	 * @param sgBloodGroup the sg_blood_group value
	 */
	public void setSgBloodGroup (jkt.hms.masters.business.MasBloodGroup sgBloodGroup) {
		this.sgBloodGroup = sgBloodGroup;
	}



	/**
	 * Return the value associated with the column: donor_id
	 */
	public jkt.hms.masters.business.BloodDonationEntryHeader getDonor () {
		return donor;
	}

	/**
	 * Set the value related to the column: donor_id
	 * @param donor the donor_id value
	 */
	public void setDonor (jkt.hms.masters.business.BloodDonationEntryHeader donor) {
		this.donor = donor;
	}



	/**
	 * Return the value associated with the column: sample_collection_id
	 */
	public jkt.hms.masters.business.BloodSampleCollection getSampleCollection () {
		return sampleCollection;
	}

	/**
	 * Set the value related to the column: sample_collection_id
	 * @param sampleCollection the sample_collection_id value
	 */
	public void setSampleCollection (jkt.hms.masters.business.BloodSampleCollection sampleCollection) {
		this.sampleCollection = sampleCollection;
	}



	/**
	 * Return the value associated with the column: cg_blood_group
	 */
	public jkt.hms.masters.business.MasBloodGroup getCgBloodGroup () {
		return cgBloodGroup;
	}

	/**
	 * Set the value related to the column: cg_blood_group
	 * @param cgBloodGroup the cg_blood_group value
	 */
	public void setCgBloodGroup (jkt.hms.masters.business.MasBloodGroup cgBloodGroup) {
		this.cgBloodGroup = cgBloodGroup;
	}



	/**
	 * Return the value associated with the column: screening_test_id
	 */
	public jkt.hms.masters.business.BloodSampleScreeningHeader getScreeningTest () {
		return screeningTest;
	}

	/**
	 * Set the value related to the column: screening_test_id
	 * @param screeningTest the screening_test_id value
	 */
	public void setScreeningTest (jkt.hms.masters.business.BloodSampleScreeningHeader screeningTest) {
		this.screeningTest = screeningTest;
	}



	/**
	 * Return the value associated with the column: BloodResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodResultEntryDetails> getBloodResultEntryDetails () {
		return bloodResultEntryDetails;
	}

	/**
	 * Set the value related to the column: BloodResultEntryDetails
	 * @param bloodResultEntryDetails the BloodResultEntryDetails value
	 */
	public void setBloodResultEntryDetails (java.util.Set<jkt.hms.masters.business.BloodResultEntryDetails> bloodResultEntryDetails) {
		this.bloodResultEntryDetails = bloodResultEntryDetails;
	}

	public void addToBloodResultEntryDetails (jkt.hms.masters.business.BloodResultEntryDetails bloodResultEntryDetails) {
		if (null == getBloodResultEntryDetails()) setBloodResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodResultEntryDetails>());
		getBloodResultEntryDetails().add(bloodResultEntryDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodResultEntryHeader)) return false;
		else {
			jkt.hms.masters.business.BloodResultEntryHeader bloodResultEntryHeader = (jkt.hms.masters.business.BloodResultEntryHeader) obj;
			if (null == this.getId() || null == bloodResultEntryHeader.getId()) return false;
			else return (this.getId().equals(bloodResultEntryHeader.getId()));
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