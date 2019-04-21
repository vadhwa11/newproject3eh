package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_village_survey_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_village_survey_details"
 */

public abstract class BasePhVillageSurveyDetails  implements Serializable {

	public static String REF = "PhVillageSurveyDetails";
	public static String PROP_SURVEY = "Survey";
	public static String PROP_DOCTORS_COUNT = "DoctorsCount";
	public static String PROP_TRANS_COUNT = "TransCount";
	public static String PROP_OTHER_STAFF_COUNT = "OtherStaffCount";
	public static String PROP_TOTAL_COUNT = "TotalCount";
	public static String PROP_SCHOOL_CLASS = "SchoolClass";
	public static String PROP_OTHER_STAFF_NAME = "OtherStaffName";
	public static String PROP_BENEFICIARY_NAME = "BeneficiaryName";
	public static String PROP_MALE_COUNT = "MaleCount";
	public static String PROP_BENEFICIARY_COUNT = "BeneficiaryCount";
	public static String PROP_ID = "Id";
	public static String PROP_FEMALE_COUNT = "FemaleCount";
	public static String PROP_BED_COUNT = "BedCount";


	// constructors
	public BasePhVillageSurveyDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhVillageSurveyDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String schoolClass;
	private java.lang.Long maleCount;
	private java.lang.Long femaleCount;
	private java.lang.Long transCount;
	private java.lang.Long totalCount;
	private java.lang.String beneficiaryName;
	private java.lang.Long beneficiaryCount;
	private java.lang.Long doctorsCount;
	private java.lang.Long bedCount;
	private java.lang.String otherStaffName;
	private java.lang.Long otherStaffCount;

	// many to one
	private jkt.hms.masters.business.PhVillageSurvey survey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="survey_details"
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
	 * Return the value associated with the column: school_class
	 */
	public java.lang.String getSchoolClass () {
		return schoolClass;
	}

	/**
	 * Set the value related to the column: school_class
	 * @param schoolClass the school_class value
	 */
	public void setSchoolClass (java.lang.String schoolClass) {
		this.schoolClass = schoolClass;
	}



	/**
	 * Return the value associated with the column: male_count
	 */
	public java.lang.Long getMaleCount () {
		return maleCount;
	}

	/**
	 * Set the value related to the column: male_count
	 * @param maleCount the male_count value
	 */
	public void setMaleCount (java.lang.Long maleCount) {
		this.maleCount = maleCount;
	}



	/**
	 * Return the value associated with the column: female_count
	 */
	public java.lang.Long getFemaleCount () {
		return femaleCount;
	}

	/**
	 * Set the value related to the column: female_count
	 * @param femaleCount the female_count value
	 */
	public void setFemaleCount (java.lang.Long femaleCount) {
		this.femaleCount = femaleCount;
	}



	/**
	 * Return the value associated with the column: trans_count
	 */
	public java.lang.Long getTransCount () {
		return transCount;
	}

	/**
	 * Set the value related to the column: trans_count
	 * @param transCount the trans_count value
	 */
	public void setTransCount (java.lang.Long transCount) {
		this.transCount = transCount;
	}



	/**
	 * Return the value associated with the column: total_count
	 */
	public java.lang.Long getTotalCount () {
		return totalCount;
	}

	/**
	 * Set the value related to the column: total_count
	 * @param totalCount the total_count value
	 */
	public void setTotalCount (java.lang.Long totalCount) {
		this.totalCount = totalCount;
	}



	/**
	 * Return the value associated with the column: beneficiary_name
	 */
	public java.lang.String getBeneficiaryName () {
		return beneficiaryName;
	}

	/**
	 * Set the value related to the column: beneficiary_name
	 * @param beneficiaryName the beneficiary_name value
	 */
	public void setBeneficiaryName (java.lang.String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}



	/**
	 * Return the value associated with the column: beneficiary_count
	 */
	public java.lang.Long getBeneficiaryCount () {
		return beneficiaryCount;
	}

	/**
	 * Set the value related to the column: beneficiary_count
	 * @param beneficiaryCount the beneficiary_count value
	 */
	public void setBeneficiaryCount (java.lang.Long beneficiaryCount) {
		this.beneficiaryCount = beneficiaryCount;
	}



	/**
	 * Return the value associated with the column: doctors_count
	 */
	public java.lang.Long getDoctorsCount () {
		return doctorsCount;
	}

	/**
	 * Set the value related to the column: doctors_count
	 * @param doctorsCount the doctors_count value
	 */
	public void setDoctorsCount (java.lang.Long doctorsCount) {
		this.doctorsCount = doctorsCount;
	}



	/**
	 * Return the value associated with the column: bed_count
	 */
	public java.lang.Long getBedCount () {
		return bedCount;
	}

	/**
	 * Set the value related to the column: bed_count
	 * @param bedCount the bed_count value
	 */
	public void setBedCount (java.lang.Long bedCount) {
		this.bedCount = bedCount;
	}



	/**
	 * Return the value associated with the column: other_staff_name
	 */
	public java.lang.String getOtherStaffName () {
		return otherStaffName;
	}

	/**
	 * Set the value related to the column: other_staff_name
	 * @param otherStaffName the other_staff_name value
	 */
	public void setOtherStaffName (java.lang.String otherStaffName) {
		this.otherStaffName = otherStaffName;
	}



	/**
	 * Return the value associated with the column: other_staff_count
	 */
	public java.lang.Long getOtherStaffCount () {
		return otherStaffCount;
	}

	/**
	 * Set the value related to the column: other_staff_count
	 * @param otherStaffCount the other_staff_count value
	 */
	public void setOtherStaffCount (java.lang.Long otherStaffCount) {
		this.otherStaffCount = otherStaffCount;
	}



	/**
	 * Return the value associated with the column: survey_id
	 */
	public jkt.hms.masters.business.PhVillageSurvey getSurvey () {
		return survey;
	}

	/**
	 * Set the value related to the column: survey_id
	 * @param survey the survey_id value
	 */
	public void setSurvey (jkt.hms.masters.business.PhVillageSurvey survey) {
		this.survey = survey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhVillageSurveyDetails)) return false;
		else {
			jkt.hms.masters.business.PhVillageSurveyDetails phVillageSurveyDetails = (jkt.hms.masters.business.PhVillageSurveyDetails) obj;
			if (null == this.getId() || null == phVillageSurveyDetails.getId()) return false;
			else return (this.getId().equals(phVillageSurveyDetails.getId()));
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