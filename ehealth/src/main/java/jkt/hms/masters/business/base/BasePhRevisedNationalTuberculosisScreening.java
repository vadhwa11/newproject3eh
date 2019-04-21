package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_revised_national_tuberculosis_screening table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_revised_national_tuberculosis_screening"
 */

public abstract class BasePhRevisedNationalTuberculosisScreening  implements Serializable {

	public static String REF = "PhRevisedNationalTuberculosisScreening";
	public static String PROP_REG_TYPE = "RegType";
	public static String PROP_PAST_HISTORY_TB = "PastHistoryTb";
	public static String PROP_ALCOHOL = "Alcohol";
	public static String PROP_MEMBER = "Member";
	public static String PROP_FAMILY_MEMBER_TB = "FamilyMemberTb";
	public static String PROP_UNIQUE_REG_ID = "UniqueRegId";
	public static String PROP_COUGH_MORETHAN_TWO_WEEKS = "CoughMorethanTwoWeeks";
	public static String PROP_HISTORY_OF_DIABETES_MELLITUS = "HistoryOfDiabetesMellitus";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FEVER = "Fever";
	public static String PROP_LOSS_OF_WEIGHT = "LossOfWeight";
	public static String PROP_BLOOD_STAINED_SPUTUM = "BloodStainedSputum";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_NAME_OF_INSTITUTION = "NameOfInstitution";
	public static String PROP_TYPE_OF_INSTITUTION = "TypeOfInstitution";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_COPD = "Copd";
	public static String PROP_AADHAR_NO = "AadharNo";
	public static String PROP_CHECKED_STATUS ="CheckedStatus";

	// constructors
	public BasePhRevisedNationalTuberculosisScreening () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePhRevisedNationalTuberculosisScreening (
		java.lang.Integer id) {

		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.Long aadharNo;
	private java.lang.String pastHistoryTb;
	private java.lang.String familyMemberTb;
	private java.lang.String coughMorethanTwoWeeks;
	private java.lang.String bloodStainedSputum;
	private java.lang.String fever;
	private java.lang.String lossOfWeight;
	private java.lang.String historyOfDiabetesMellitus;
	private java.lang.String copd;
	private java.lang.String smoking;
	private java.lang.String alcohol;
	private java.lang.String typeOfInstitution;
	private java.lang.String nameOfInstitution;
	private java.lang.String remarks;
	private java.util.Date lastChangeDate;
	private java.lang.String uniqueRegId;
	private java.lang.String regType;
	private java.lang.String checkedStatus;
	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChangeBy;
	private jkt.hms.masters.business.PhMemberSurvey member;






	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: aadhar_no
	 */
	public java.lang.Long getAadharNo () {
		return aadharNo;
	}

	/**
	 * Set the value related to the column: aadhar_no
	 * @param aadharNo the aadhar_no value
	 */
	public void setAadharNo (java.lang.Long aadharNo) {
		this.aadharNo = aadharNo;
	}



	/**
	 * Return the value associated with the column: past_history_tb
	 */
	public java.lang.String getPastHistoryTb () {
		return pastHistoryTb;
	}
	
	

	public java.lang.String getCheckedStatus() {
		return checkedStatus;
	}

	public void setCheckedStatus(java.lang.String checkedStatus) {
		this.checkedStatus = checkedStatus;
	}

	/**
	 * Set the value related to the column: past_history_tb
	 * @param pastHistoryTb the past_history_tb value
	 */
	public void setPastHistoryTb (java.lang.String pastHistoryTb) {
		this.pastHistoryTb = pastHistoryTb;
	}



	/**
	 * Return the value associated with the column: family_member_tb
	 */
	public java.lang.String getFamilyMemberTb () {
		return familyMemberTb;
	}

	/**
	 * Set the value related to the column: family_member_tb
	 * @param familyMemberTb the family_member_tb value
	 */
	public void setFamilyMemberTb (java.lang.String familyMemberTb) {
		this.familyMemberTb = familyMemberTb;
	}



	/**
	 * Return the value associated with the column: cough_morethan_two_weeks
	 */
	public java.lang.String getCoughMorethanTwoWeeks () {
		return coughMorethanTwoWeeks;
	}

	/**
	 * Set the value related to the column: cough_morethan_two_weeks
	 * @param coughMorethanTwoWeeks the cough_morethan_two_weeks value
	 */
	public void setCoughMorethanTwoWeeks (java.lang.String coughMorethanTwoWeeks) {
		this.coughMorethanTwoWeeks = coughMorethanTwoWeeks;
	}



	/**
	 * Return the value associated with the column: blood_stained_sputum
	 */
	public java.lang.String getBloodStainedSputum () {
		return bloodStainedSputum;
	}

	/**
	 * Set the value related to the column: blood_stained_sputum
	 * @param bloodStainedSputum the blood_stained_sputum value
	 */
	public void setBloodStainedSputum (java.lang.String bloodStainedSputum) {
		this.bloodStainedSputum = bloodStainedSputum;
	}



	/**
	 * Return the value associated with the column: fever
	 */
	public java.lang.String getFever () {
		return fever;
	}

	/**
	 * Set the value related to the column: fever
	 * @param fever the fever value
	 */
	public void setFever (java.lang.String fever) {
		this.fever = fever;
	}



	/**
	 * Return the value associated with the column: loss_of_weight
	 */
	public java.lang.String getLossOfWeight () {
		return lossOfWeight;
	}

	/**
	 * Set the value related to the column: loss_of_weight
	 * @param lossOfWeight the loss_of_weight value
	 */
	public void setLossOfWeight (java.lang.String lossOfWeight) {
		this.lossOfWeight = lossOfWeight;
	}



	/**
	 * Return the value associated with the column: history_of_diabetes_mellitus
	 */
	public java.lang.String getHistoryOfDiabetesMellitus () {
		return historyOfDiabetesMellitus;
	}

	/**
	 * Set the value related to the column: history_of_diabetes_mellitus
	 * @param historyOfDiabetesMellitus the history_of_diabetes_mellitus value
	 */
	public void setHistoryOfDiabetesMellitus (java.lang.String historyOfDiabetesMellitus) {
		this.historyOfDiabetesMellitus = historyOfDiabetesMellitus;
	}



	/**
	 * Return the value associated with the column: copd
	 */
	public java.lang.String getCopd () {
		return copd;
	}

	/**
	 * Set the value related to the column: copd
	 * @param copd the copd value
	 */
	public void setCopd (java.lang.String copd) {
		this.copd = copd;
	}



	/**
	 * Return the value associated with the column: smoking
	 */
	public java.lang.String getSmoking () {
		return smoking;
	}

	/**
	 * Set the value related to the column: smoking
	 * @param smoking the smoking value
	 */
	public void setSmoking (java.lang.String smoking) {
		this.smoking = smoking;
	}



	/**
	 * Return the value associated with the column: alcohol
	 */
	public java.lang.String getAlcohol () {
		return alcohol;
	}

	/**
	 * Set the value related to the column: alcohol
	 * @param alcohol the alcohol value
	 */
	public void setAlcohol (java.lang.String alcohol) {
		this.alcohol = alcohol;
	}



	/**
	 * Return the value associated with the column: type_of_institution
	 */
	public java.lang.String getTypeOfInstitution () {
		return typeOfInstitution;
	}

	/**
	 * Set the value related to the column: type_of_institution
	 * @param typeOfInstitution the type_of_institution value
	 */
	public void setTypeOfInstitution (java.lang.String typeOfInstitution) {
		this.typeOfInstitution = typeOfInstitution;
	}



	/**
	 * Return the value associated with the column: name_of_institution
	 */
	public java.lang.String getNameOfInstitution () {
		return nameOfInstitution;
	}

	/**
	 * Set the value related to the column: name_of_institution
	 * @param nameOfInstitution the name_of_institution value
	 */
	public void setNameOfInstitution (java.lang.String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
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
	 * Return the value associated with the column: last_change_date
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: last_change_date
	 * @param lastChangeDate the last_change_date value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: unique_reg_id
	 */
	public java.lang.String getUniqueRegId () {
		return uniqueRegId;
	}

	/**
	 * Set the value related to the column: unique_reg_id
	 * @param uniqueRegId the unique_reg_id value
	 */
	public void setUniqueRegId (java.lang.String uniqueRegId) {
		this.uniqueRegId = uniqueRegId;
	}



	/**
	 * Return the value associated with the column: reg_type
	 */
	public java.lang.String getRegType () {
		return regType;
	}

	/**
	 * Set the value related to the column: reg_type
	 * @param regType the reg_type value
	 */
	public void setRegType (java.lang.String regType) {
		this.regType = regType;
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
	 * Return the value associated with the column: last_change_by
	 */
	public jkt.hms.masters.business.Users getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: last_change_by
	 * @param lastChangeBy the last_change_by value
	 */
	public void setLastChangeBy (jkt.hms.masters.business.Users lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: member_id
	 */
	public jkt.hms.masters.business.PhMemberSurvey getMember () {
		return member;
	}

	/**
	 * Set the value related to the column: member_id
	 * @param member the member_id value
	 */
	public void setMember (jkt.hms.masters.business.PhMemberSurvey member) {
		this.member = member;
	}







	public String toString () {
		return super.toString();
	}


}