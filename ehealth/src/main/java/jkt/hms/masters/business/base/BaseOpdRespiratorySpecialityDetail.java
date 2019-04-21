package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_respiratory_speciality_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_respiratory_speciality_detail"
 */

public abstract class BaseOpdRespiratorySpecialityDetail  implements Serializable {

	public static String REF = "OpdRespiratorySpecialityDetail";
	public static String PROP_CONTROLLED = "Controlled";
	public static String PROP_FLAG = "Flag";
	public static String PROP_CURRENT_TREATMENT = "CurrentTreatment";
	public static String PROP_RESPONSE = "Response";
	public static String PROP_EVER_USED = "EverUsed";
	public static String PROP_ASTHMA = "Asthma";
	public static String PROP_PARTLY_CONTROLLED = "PartlyControlled";
	public static String PROP_RESPIRATORY_SPECIALITY = "RespiratorySpeciality";
	public static String PROP_ECZEMA = "Eczema";
	public static String PROP_NASAL_ALLERGY = "NasalAllergy";
	public static String PROP_UNCONTROLLED = "Uncontrolled";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_REVIEW_CONTROL_FLAG = "ReviewControlFlag";
	public static String PROP_FOOD_ALLERGY = "FoodAllergy";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_REMARK = "Remark";
	public static String PROP_SYMPTOMS_OTHERS = "SymptomsOthers";


	// constructors
	public BaseOpdRespiratorySpecialityDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdRespiratorySpecialityDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String parameterName;
	private java.lang.String status;
	private java.lang.String flag;
	private java.lang.String duration;
	private java.lang.String frequency;
	private java.lang.String remark;
	private java.lang.String name;
	private java.lang.String response;
	private java.lang.String currentTreatment;
	private java.lang.String asthma;
	private java.lang.String nasalAllergy;
	private java.lang.String eczema;
	private java.lang.String foodAllergy;
	private java.lang.String everUsed;
	private java.lang.String reviewControlFlag;
	private java.lang.String controlled;
	private java.lang.String partlyControlled;
	private java.lang.String uncontrolled;
	private java.lang.String symptomsOthers;

	// many to one
	private jkt.hms.masters.business.OpdRespiratorySpecialityHeader respiratorySpeciality;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="respiratory_detail_id"
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
	 * Return the value associated with the column: parameter_name
	 */
	public java.lang.String getParameterName () {
		return parameterName;
	}

	/**
	 * Set the value related to the column: parameter_name
	 * @param parameterName the parameter_name value
	 */
	public void setParameterName (java.lang.String parameterName) {
		this.parameterName = parameterName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: frequency
	 */
	public java.lang.String getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param frequency the frequency value
	 */
	public void setFrequency (java.lang.String frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: response
	 */
	public java.lang.String getResponse () {
		return response;
	}

	/**
	 * Set the value related to the column: response
	 * @param response the response value
	 */
	public void setResponse (java.lang.String response) {
		this.response = response;
	}



	/**
	 * Return the value associated with the column: current_treatment
	 */
	public java.lang.String getCurrentTreatment () {
		return currentTreatment;
	}

	/**
	 * Set the value related to the column: current_treatment
	 * @param currentTreatment the current_treatment value
	 */
	public void setCurrentTreatment (java.lang.String currentTreatment) {
		this.currentTreatment = currentTreatment;
	}



	/**
	 * Return the value associated with the column: asthma
	 */
	public java.lang.String getAsthma () {
		return asthma;
	}

	/**
	 * Set the value related to the column: asthma
	 * @param asthma the asthma value
	 */
	public void setAsthma (java.lang.String asthma) {
		this.asthma = asthma;
	}



	/**
	 * Return the value associated with the column: nasal_allergy
	 */
	public java.lang.String getNasalAllergy () {
		return nasalAllergy;
	}

	/**
	 * Set the value related to the column: nasal_allergy
	 * @param nasalAllergy the nasal_allergy value
	 */
	public void setNasalAllergy (java.lang.String nasalAllergy) {
		this.nasalAllergy = nasalAllergy;
	}



	/**
	 * Return the value associated with the column: eczema
	 */
	public java.lang.String getEczema () {
		return eczema;
	}

	/**
	 * Set the value related to the column: eczema
	 * @param eczema the eczema value
	 */
	public void setEczema (java.lang.String eczema) {
		this.eczema = eczema;
	}



	/**
	 * Return the value associated with the column: food_allergy
	 */
	public java.lang.String getFoodAllergy () {
		return foodAllergy;
	}

	/**
	 * Set the value related to the column: food_allergy
	 * @param foodAllergy the food_allergy value
	 */
	public void setFoodAllergy (java.lang.String foodAllergy) {
		this.foodAllergy = foodAllergy;
	}



	/**
	 * Return the value associated with the column: ever_used
	 */
	public java.lang.String getEverUsed () {
		return everUsed;
	}

	/**
	 * Set the value related to the column: ever_used
	 * @param everUsed the ever_used value
	 */
	public void setEverUsed (java.lang.String everUsed) {
		this.everUsed = everUsed;
	}



	/**
	 * Return the value associated with the column: review_control_flag
	 */
	public java.lang.String getReviewControlFlag () {
		return reviewControlFlag;
	}

	/**
	 * Set the value related to the column: review_control_flag
	 * @param reviewControlFlag the review_control_flag value
	 */
	public void setReviewControlFlag (java.lang.String reviewControlFlag) {
		this.reviewControlFlag = reviewControlFlag;
	}



	/**
	 * Return the value associated with the column: controlled
	 */
	public java.lang.String getControlled () {
		return controlled;
	}

	/**
	 * Set the value related to the column: controlled
	 * @param controlled the controlled value
	 */
	public void setControlled (java.lang.String controlled) {
		this.controlled = controlled;
	}



	/**
	 * Return the value associated with the column: partly_controlled
	 */
	public java.lang.String getPartlyControlled () {
		return partlyControlled;
	}

	/**
	 * Set the value related to the column: partly_controlled
	 * @param partlyControlled the partly_controlled value
	 */
	public void setPartlyControlled (java.lang.String partlyControlled) {
		this.partlyControlled = partlyControlled;
	}



	/**
	 * Return the value associated with the column: uncontrolled
	 */
	public java.lang.String getUncontrolled () {
		return uncontrolled;
	}

	/**
	 * Set the value related to the column: uncontrolled
	 * @param uncontrolled the uncontrolled value
	 */
	public void setUncontrolled (java.lang.String uncontrolled) {
		this.uncontrolled = uncontrolled;
	}



	/**
	 * Return the value associated with the column: symptoms_others
	 */
	public java.lang.String getSymptomsOthers () {
		return symptomsOthers;
	}

	/**
	 * Set the value related to the column: symptoms_others
	 * @param symptomsOthers the symptoms_others value
	 */
	public void setSymptomsOthers (java.lang.String symptomsOthers) {
		this.symptomsOthers = symptomsOthers;
	}



	/**
	 * Return the value associated with the column: respiratory_speciality_id
	 */
	public jkt.hms.masters.business.OpdRespiratorySpecialityHeader getRespiratorySpeciality () {
		return respiratorySpeciality;
	}

	/**
	 * Set the value related to the column: respiratory_speciality_id
	 * @param respiratorySpeciality the respiratory_speciality_id value
	 */
	public void setRespiratorySpeciality (jkt.hms.masters.business.OpdRespiratorySpecialityHeader respiratorySpeciality) {
		this.respiratorySpeciality = respiratorySpeciality;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdRespiratorySpecialityDetail)) return false;
		else {
			jkt.hms.masters.business.OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail = (jkt.hms.masters.business.OpdRespiratorySpecialityDetail) obj;
			if (null == this.getId() || null == opdRespiratorySpecialityDetail.getId()) return false;
			else return (this.getId().equals(opdRespiratorySpecialityDetail.getId()));
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