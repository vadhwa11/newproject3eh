package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_family_survey table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_family_survey"
 */

public abstract class BasePhFamilySurvey  implements Serializable {

	public static String REF = "PhFamilySurvey";
	public static String PROP_FAMILY_INCOME = "FamilyIncome";
	public static String PROP_FAMILY_SURVEY_STATUS = "FamilySurveyStatus";
	public static String PROP_FAMILY_ID = "FamilyId";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BPL_STATUS = "BplStatus";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_PH_SURVEY_ID = "PhSurveyId";
	public static String PROP_SURVEY_DATE = "SurveyDate";
	public static String PROP_RATION_CARD_NO = "RationCardNo";
	public static String PROP_SURVEY_TIME = "SurveyTime";
	public static String PROP_ID = "Id";
	public static String PROP_FAMILY_NAME = "FamilyName";
	public static String PROP_HOUSE_ID = "HouseId";
	public static String PROP_RSBY_NO = "RsbyNo";
	public static String PROP_SURVEY_BY = "SurveyBy";


	// constructors
	public BasePhFamilySurvey () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhFamilySurvey (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String familyName;
	private java.lang.String houseId;
	private java.lang.String familySurveyStatus;
	private java.util.Date surveyDate;
	private java.lang.String surveyTime;
	private java.lang.String rationCardNo;
	private java.lang.String bplStatus;
	private java.lang.String rsbyNo;
	private java.lang.String contactNo;
	private java.math.BigDecimal familyIncome;
	private java.lang.String familyId;
	private java.lang.Long phSurveyId;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users surveyBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.PhContactDetails> phContactDetails;
	private java.util.Set<jkt.hms.masters.business.PhMemberSurvey> phMemberSurveies;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="survey_id"
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
	 * Return the value associated with the column: family_name
	 */
	public java.lang.String getFamilyName () {
		return familyName;
	}

	/**
	 * Set the value related to the column: family_name
	 * @param familyName the family_name value
	 */
	public void setFamilyName (java.lang.String familyName) {
		this.familyName = familyName;
	}



	/**
	 * Return the value associated with the column: house_id
	 */
	public java.lang.String getHouseId () {
		return houseId;
	}

	/**
	 * Set the value related to the column: house_id
	 * @param houseId the house_id value
	 */
	public void setHouseId (java.lang.String houseId) {
		this.houseId = houseId;
	}



	/**
	 * Return the value associated with the column: family_survey_status
	 */
	public java.lang.String getFamilySurveyStatus () {
		return familySurveyStatus;
	}

	/**
	 * Set the value related to the column: family_survey_status
	 * @param familySurveyStatus the family_survey_status value
	 */
	public void setFamilySurveyStatus (java.lang.String familySurveyStatus) {
		this.familySurveyStatus = familySurveyStatus;
	}



	/**
	 * Return the value associated with the column: survey_date
	 */
	public java.util.Date getSurveyDate () {
		return surveyDate;
	}

	/**
	 * Set the value related to the column: survey_date
	 * @param surveyDate the survey_date value
	 */
	public void setSurveyDate (java.util.Date surveyDate) {
		this.surveyDate = surveyDate;
	}



	/**
	 * Return the value associated with the column: survey_time
	 */
	public java.lang.String getSurveyTime () {
		return surveyTime;
	}

	/**
	 * Set the value related to the column: survey_time
	 * @param surveyTime the survey_time value
	 */
	public void setSurveyTime (java.lang.String surveyTime) {
		this.surveyTime = surveyTime;
	}



	/**
	 * Return the value associated with the column: ration_card_no
	 */
	public java.lang.String getRationCardNo () {
		return rationCardNo;
	}

	/**
	 * Set the value related to the column: ration_card_no
	 * @param rationCardNo the ration_card_no value
	 */
	public void setRationCardNo (java.lang.String rationCardNo) {
		this.rationCardNo = rationCardNo;
	}



	/**
	 * Return the value associated with the column: bpl_status
	 */
	public java.lang.String getBplStatus () {
		return bplStatus;
	}

	/**
	 * Set the value related to the column: bpl_status
	 * @param bplStatus the bpl_status value
	 */
	public void setBplStatus (java.lang.String bplStatus) {
		this.bplStatus = bplStatus;
	}



	/**
	 * Return the value associated with the column: rsby_no
	 */
	public java.lang.String getRsbyNo () {
		return rsbyNo;
	}

	/**
	 * Set the value related to the column: rsby_no
	 * @param rsbyNo the rsby_no value
	 */
	public void setRsbyNo (java.lang.String rsbyNo) {
		this.rsbyNo = rsbyNo;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: family_income
	 */
	public java.math.BigDecimal getFamilyIncome () {
		return familyIncome;
	}

	/**
	 * Set the value related to the column: family_income
	 * @param familyIncome the family_income value
	 */
	public void setFamilyIncome (java.math.BigDecimal familyIncome) {
		this.familyIncome = familyIncome;
	}



	/**
	 * Return the value associated with the column: family_id
	 */
	public java.lang.String getFamilyId () {
		return familyId;
	}

	/**
	 * Set the value related to the column: family_id
	 * @param familyId the family_id value
	 */
	public void setFamilyId (java.lang.String familyId) {
		this.familyId = familyId;
	}



	/**
	 * Return the value associated with the column: ph_survey_id
	 */
	public java.lang.Long getPhSurveyId () {
		return phSurveyId;
	}

	/**
	 * Set the value related to the column: ph_survey_id
	 * @param phSurveyId the ph_survey_id value
	 */
	public void setPhSurveyId (java.lang.Long phSurveyId) {
		this.phSurveyId = phSurveyId;
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
	 * Return the value associated with the column: survey_by
	 */
	public jkt.hms.masters.business.Users getSurveyBy () {
		return surveyBy;
	}

	/**
	 * Set the value related to the column: survey_by
	 * @param surveyBy the survey_by value
	 */
	public void setSurveyBy (jkt.hms.masters.business.Users surveyBy) {
		this.surveyBy = surveyBy;
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: PhContactDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhContactDetails> getPhContactDetails () {
		return phContactDetails;
	}

	/**
	 * Set the value related to the column: PhContactDetails
	 * @param phContactDetails the PhContactDetails value
	 */
	public void setPhContactDetails (java.util.Set<jkt.hms.masters.business.PhContactDetails> phContactDetails) {
		this.phContactDetails = phContactDetails;
	}

	public void addToPhContactDetails (jkt.hms.masters.business.PhContactDetails phContactDetails) {
		if (null == getPhContactDetails()) setPhContactDetails(new java.util.TreeSet<jkt.hms.masters.business.PhContactDetails>());
		getPhContactDetails().add(phContactDetails);
	}



	/**
	 * Return the value associated with the column: PhMemberSurveies
	 */
	public java.util.Set<jkt.hms.masters.business.PhMemberSurvey> getPhMemberSurveies () {
		return phMemberSurveies;
	}

	/**
	 * Set the value related to the column: PhMemberSurveies
	 * @param phMemberSurveies the PhMemberSurveies value
	 */
	public void setPhMemberSurveies (java.util.Set<jkt.hms.masters.business.PhMemberSurvey> phMemberSurveies) {
		this.phMemberSurveies = phMemberSurveies;
	}

	public void addToPhMemberSurveies (jkt.hms.masters.business.PhMemberSurvey phMemberSurvey) {
		if (null == getPhMemberSurveies()) setPhMemberSurveies(new java.util.TreeSet<jkt.hms.masters.business.PhMemberSurvey>());
		getPhMemberSurveies().add(phMemberSurvey);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhFamilySurvey)) return false;
		else {
			jkt.hms.masters.business.PhFamilySurvey phFamilySurvey = (jkt.hms.masters.business.PhFamilySurvey) obj;
			if (null == this.getId() || null == phFamilySurvey.getId()) return false;
			else return (this.getId().equals(phFamilySurvey.getId()));
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