package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_nursing_patient_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_nursing_patient_details"
 */

public abstract class BaseOpdNursingPatientDetails  implements Serializable {

	public static String REF = "OpdNursingPatientDetails";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PAST_ILLNESS_HISTORY = "PastIllnessHistory";
	public static String PROP_PRESENT_COMPLAINT_HISTORY = "PresentComplaintHistory";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_VISIT = "Visit";
	public static String PROP_PRESENT_HISTORY = "PresentHistory";
	public static String PROP_BMI = "Bmi";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_BP = "Bp";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_MADICATION_HISTORY = "MadicationHistory";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseOpdNursingPatientDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdNursingPatientDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String presentComplaintHistory;
	private java.lang.String pastIllnessHistory;
	private java.lang.String presentHistory;
	private java.lang.String familyHistory;
	private java.lang.String madicationHistory;
	private java.lang.String status;
	private java.lang.Integer pulse;
	private java.lang.Float temperature;
	private java.lang.String bp;
	private java.lang.Double height;
	private java.lang.Double weight;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Float bmi;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_nursing_patient_details_id"
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
	 * Return the value associated with the column: present_complaint_history
	 */
	public java.lang.String getPresentComplaintHistory () {
		return presentComplaintHistory;
	}

	/**
	 * Set the value related to the column: present_complaint_history
	 * @param presentComplaintHistory the present_complaint_history value
	 */
	public void setPresentComplaintHistory (java.lang.String presentComplaintHistory) {
		this.presentComplaintHistory = presentComplaintHistory;
	}



	/**
	 * Return the value associated with the column: past_illness_history
	 */
	public java.lang.String getPastIllnessHistory () {
		return pastIllnessHistory;
	}

	/**
	 * Set the value related to the column: past_illness_history
	 * @param pastIllnessHistory the past_illness_history value
	 */
	public void setPastIllnessHistory (java.lang.String pastIllnessHistory) {
		this.pastIllnessHistory = pastIllnessHistory;
	}



	/**
	 * Return the value associated with the column: present_history
	 */
	public java.lang.String getPresentHistory () {
		return presentHistory;
	}

	/**
	 * Set the value related to the column: present_history
	 * @param presentHistory the present_history value
	 */
	public void setPresentHistory (java.lang.String presentHistory) {
		this.presentHistory = presentHistory;
	}



	/**
	 * Return the value associated with the column: family_history
	 */
	public java.lang.String getFamilyHistory () {
		return familyHistory;
	}

	/**
	 * Set the value related to the column: family_history
	 * @param familyHistory the family_history value
	 */
	public void setFamilyHistory (java.lang.String familyHistory) {
		this.familyHistory = familyHistory;
	}



	/**
	 * Return the value associated with the column: madication_history
	 */
	public java.lang.String getMadicationHistory () {
		return madicationHistory;
	}

	/**
	 * Set the value related to the column: madication_history
	 * @param madicationHistory the madication_history value
	 */
	public void setMadicationHistory (java.lang.String madicationHistory) {
		this.madicationHistory = madicationHistory;
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
	 * Return the value associated with the column: temperature
	 */
	public java.lang.Float getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.lang.Float temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Double getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.Double height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Double getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.Double weight) {
		this.weight = weight;
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
	 * Return the value associated with the column: bmi
	 */
	public java.lang.Float getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * @param bmi the bmi value
	 */
	public void setBmi (java.lang.Float bmi) {
		this.bmi = bmi;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdNursingPatientDetails)) return false;
		else {
			jkt.hms.masters.business.OpdNursingPatientDetails opdNursingPatientDetails = (jkt.hms.masters.business.OpdNursingPatientDetails) obj;
			if (null == this.getId() || null == opdNursingPatientDetails.getId()) return false;
			else return (this.getId().equals(opdNursingPatientDetails.getId()));
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