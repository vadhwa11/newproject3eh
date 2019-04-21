package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_pediatric_respiratory_speciality_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_pediatric_respiratory_speciality_detail"
 */

public abstract class BaseOpdPediatricRespiratorySpecialityDetail  implements Serializable {

	public static String REF = "OpdPediatricRespiratorySpecialityDetail";
	public static String PROP_FLAG = "Flag";
	public static String PROP_CURRENT_TREATMENT = "CurrentTreatment";
	public static String PROP_RESPONSE = "Response";
	public static String PROP_ASTHMA = "Asthma";
	public static String PROP_RESPIRATORY_SPECIALITY = "RespiratorySpeciality";
	public static String PROP_ECZEMA = "Eczema";
	public static String PROP_NASAL_ALLERGY = "NasalAllergy";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_FOOD_ALLERGY = "FoodAllergy";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseOpdPediatricRespiratorySpecialityDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPediatricRespiratorySpecialityDetail (java.lang.Integer id) {
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

	// many to one
	private jkt.hms.masters.business.OpdPediatricRespiratorySpecialityHeader respiratorySpeciality;



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
	 * Return the value associated with the column: respiratory_speciality_id
	 */
	public jkt.hms.masters.business.OpdPediatricRespiratorySpecialityHeader getRespiratorySpeciality () {
		return respiratorySpeciality;
	}

	/**
	 * Set the value related to the column: respiratory_speciality_id
	 * @param respiratorySpeciality the respiratory_speciality_id value
	 */
	public void setRespiratorySpeciality (jkt.hms.masters.business.OpdPediatricRespiratorySpecialityHeader respiratorySpeciality) {
		this.respiratorySpeciality = respiratorySpeciality;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPediatricRespiratorySpecialityDetail)) return false;
		else {
			jkt.hms.masters.business.OpdPediatricRespiratorySpecialityDetail opdPediatricRespiratorySpecialityDetail = (jkt.hms.masters.business.OpdPediatricRespiratorySpecialityDetail) obj;
			if (null == this.getId() || null == opdPediatricRespiratorySpecialityDetail.getId()) return false;
			else return (this.getId().equals(opdPediatricRespiratorySpecialityDetail.getId()));
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