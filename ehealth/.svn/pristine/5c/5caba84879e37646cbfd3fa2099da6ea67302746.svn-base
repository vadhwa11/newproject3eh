package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_student_health_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_student_health_details"
 */

public abstract class BasePhStudentHealthDetails  implements Serializable {

	public static String REF = "PhStudentHealthDetails";
	public static String PROP_AGE = "Age";
	public static String PROP_OPV_O_DUE_DATE = "OpvODueDate";
	public static String PROP_ALLERGY = "Allergy";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_TYPE = "HospitalType";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_SBP = "Sbp";
	public static String PROP_DBP = "Dbp";
	public static String PROP_ALLERGY_YES_TEXT = "AllergyYesText";
	public static String PROP_STUDENT = "Student";
	public static String PROP_BMI = "Bmi";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SCHOOL_CLASS = "SchoolClass";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_DISTRICT = "District";
	public static String PROP_HEPATITIES_BO_DUE_DATE = "HepatitiesBoDueDate";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_BCG_DUE_DATE = "BcgDueDate";
	public static String PROP_OPV_O_IMM_DATE = "OpvOImmDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BCG_IMM_DATE = "BcgImmDate";
	public static String PROP_HEPATITIES_BO_IMM_DATE = "HepatitiesBoImmDate";


	// constructors
	public BasePhStudentHealthDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhStudentHealthDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer height;
	private java.lang.Integer weight;
	private java.lang.Integer pulse;
	private java.lang.Integer sbp;
	private java.lang.Integer dbp;
	private java.math.BigDecimal bmi;
	private java.lang.Integer age;
	private java.util.Date bcgDueDate;
	private java.util.Date bcgImmDate;
	private java.util.Date opvODueDate;
	private java.util.Date opvOImmDate;
	private java.util.Date hepatitiesBoDueDate;
	private java.util.Date hepatitiesBoImmDate;
	private java.lang.String allergy;
	private java.lang.String allergyYesText;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String schoolClass;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.PhStudentRegistration student;
	private jkt.hms.masters.business.MasHospitalType hospitalType;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ph_student_health_details_id"
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
	 * Return the value associated with the column: height
	 */
	public java.lang.Integer getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.Integer height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.Integer weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Integer getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.Integer pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: sbp
	 */
	public java.lang.Integer getSbp () {
		return sbp;
	}

	/**
	 * Set the value related to the column: sbp
	 * @param sbp the sbp value
	 */
	public void setSbp (java.lang.Integer sbp) {
		this.sbp = sbp;
	}



	/**
	 * Return the value associated with the column: dbp
	 */
	public java.lang.Integer getDbp () {
		return dbp;
	}

	/**
	 * Set the value related to the column: dbp
	 * @param dbp the dbp value
	 */
	public void setDbp (java.lang.Integer dbp) {
		this.dbp = dbp;
	}



	/**
	 * Return the value associated with the column: bmi
	 */
	public java.math.BigDecimal getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * @param bmi the bmi value
	 */
	public void setBmi (java.math.BigDecimal bmi) {
		this.bmi = bmi;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Integer getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.Integer age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: bcg_due_date
	 */
	public java.util.Date getBcgDueDate () {
		return bcgDueDate;
	}

	/**
	 * Set the value related to the column: bcg_due_date
	 * @param bcgDueDate the bcg_due_date value
	 */
	public void setBcgDueDate (java.util.Date bcgDueDate) {
		this.bcgDueDate = bcgDueDate;
	}



	/**
	 * Return the value associated with the column: bcg_imm_date
	 */
	public java.util.Date getBcgImmDate () {
		return bcgImmDate;
	}

	/**
	 * Set the value related to the column: bcg_imm_date
	 * @param bcgImmDate the bcg_imm_date value
	 */
	public void setBcgImmDate (java.util.Date bcgImmDate) {
		this.bcgImmDate = bcgImmDate;
	}



	/**
	 * Return the value associated with the column: opv_o_due_date
	 */
	public java.util.Date getOpvODueDate () {
		return opvODueDate;
	}

	/**
	 * Set the value related to the column: opv_o_due_date
	 * @param opvODueDate the opv_o_due_date value
	 */
	public void setOpvODueDate (java.util.Date opvODueDate) {
		this.opvODueDate = opvODueDate;
	}



	/**
	 * Return the value associated with the column: opv_o_imm_date
	 */
	public java.util.Date getOpvOImmDate () {
		return opvOImmDate;
	}

	/**
	 * Set the value related to the column: opv_o_imm_date
	 * @param opvOImmDate the opv_o_imm_date value
	 */
	public void setOpvOImmDate (java.util.Date opvOImmDate) {
		this.opvOImmDate = opvOImmDate;
	}



	/**
	 * Return the value associated with the column: hepatities_bo_due_date
	 */
	public java.util.Date getHepatitiesBoDueDate () {
		return hepatitiesBoDueDate;
	}

	/**
	 * Set the value related to the column: hepatities_bo_due_date
	 * @param hepatitiesBoDueDate the hepatities_bo_due_date value
	 */
	public void setHepatitiesBoDueDate (java.util.Date hepatitiesBoDueDate) {
		this.hepatitiesBoDueDate = hepatitiesBoDueDate;
	}



	/**
	 * Return the value associated with the column: hepatities_bo_imm_date
	 */
	public java.util.Date getHepatitiesBoImmDate () {
		return hepatitiesBoImmDate;
	}

	/**
	 * Set the value related to the column: hepatities_bo_imm_date
	 * @param hepatitiesBoImmDate the hepatities_bo_imm_date value
	 */
	public void setHepatitiesBoImmDate (java.util.Date hepatitiesBoImmDate) {
		this.hepatitiesBoImmDate = hepatitiesBoImmDate;
	}



	/**
	 * Return the value associated with the column: allergy
	 */
	public java.lang.String getAllergy () {
		return allergy;
	}

	/**
	 * Set the value related to the column: allergy
	 * @param allergy the allergy value
	 */
	public void setAllergy (java.lang.String allergy) {
		this.allergy = allergy;
	}



	/**
	 * Return the value associated with the column: allergy_yes_text
	 */
	public java.lang.String getAllergyYesText () {
		return allergyYesText;
	}

	/**
	 * Set the value related to the column: allergy_yes_text
	 * @param allergyYesText the allergy_yes_text value
	 */
	public void setAllergyYesText (java.lang.String allergyYesText) {
		this.allergyYesText = allergyYesText;
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
	 * Return the value associated with the column: student_id
	 */
	public jkt.hms.masters.business.PhStudentRegistration getStudent () {
		return student;
	}

	/**
	 * Set the value related to the column: student_id
	 * @param student the student_id value
	 */
	public void setStudent (jkt.hms.masters.business.PhStudentRegistration student) {
		this.student = student;
	}



	/**
	 * Return the value associated with the column: hospital_type_id
	 */
	public jkt.hms.masters.business.MasHospitalType getHospitalType () {
		return hospitalType;
	}

	/**
	 * Set the value related to the column: hospital_type_id
	 * @param hospitalType the hospital_type_id value
	 */
	public void setHospitalType (jkt.hms.masters.business.MasHospitalType hospitalType) {
		this.hospitalType = hospitalType;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhStudentHealthDetails)) return false;
		else {
			jkt.hms.masters.business.PhStudentHealthDetails phStudentHealthDetails = (jkt.hms.masters.business.PhStudentHealthDetails) obj;
			if (null == this.getId() || null == phStudentHealthDetails.getId()) return false;
			else return (this.getId().equals(phStudentHealthDetails.getId()));
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