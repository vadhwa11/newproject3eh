package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_alert table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_alert"
 */

public abstract class BasePhAlert  implements Serializable {

	public static String REF = "PhAlert";
	public static String PROP_MEMBER = "Member";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_VISIT_DATE = "VisitDate";
	public static String PROP_TT2 = "Tt2";
	public static String PROP_TT1 = "Tt1";
	public static String PROP_BMI = "Bmi";
	public static String PROP_SUB_SECTION_ID = "SubSectionId";
	public static String PROP_STATUS = "Status";
	public static String PROP_ALERT_TYPE = "AlertType";
	public static String PROP_PRESCRIBE_MEDICIN = "PrescribeMedicin";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_ALERT_MESSAGE = "AlertMessage";
	public static String PROP_BP = "Bp";
	public static String PROP_DIAGNOSIS_STATUS = "DiagnosisStatus";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_HIN = "Hin";
	public static String PROP_BASIC_SECTION_ID = "BasicSectionId";


	// constructors
	public BasePhAlert () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAlert (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String alertType;
	private java.lang.String prescribeMedicin;
	private java.util.Date tt2;
	private java.util.Date tt1;
	private java.lang.String alertMessage;
	private java.util.Date visitDate;
	private java.lang.Integer pulse;
	private java.lang.String bp;
	private java.lang.Float temperature;
	private java.lang.Float bmi;
	private java.lang.Double weight;
	private java.lang.Double height;
	private java.lang.String diagnosisStatus;
	private java.lang.String status;
	private java.lang.Integer basicSectionId;
	private java.lang.Integer subSectionId;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.PhMemberSurvey member;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="alert_id"
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
	 * Return the value associated with the column: alert_type
	 */
	public java.lang.String getAlertType () {
		return alertType;
	}

	/**
	 * Set the value related to the column: alert_type
	 * @param alertType the alert_type value
	 */
	public void setAlertType (java.lang.String alertType) {
		this.alertType = alertType;
	}



	/**
	 * Return the value associated with the column: prescribe_medicin
	 */
	public java.lang.String getPrescribeMedicin () {
		return prescribeMedicin;
	}

	/**
	 * Set the value related to the column: prescribe_medicin
	 * @param prescribeMedicin the prescribe_medicin value
	 */
	public void setPrescribeMedicin (java.lang.String prescribeMedicin) {
		this.prescribeMedicin = prescribeMedicin;
	}



	/**
	 * Return the value associated with the column: tt2
	 */
	public java.util.Date getTt2 () {
		return tt2;
	}

	/**
	 * Set the value related to the column: tt2
	 * @param tt2 the tt2 value
	 */
	public void setTt2 (java.util.Date tt2) {
		this.tt2 = tt2;
	}



	/**
	 * Return the value associated with the column: tt1
	 */
	public java.util.Date getTt1 () {
		return tt1;
	}

	/**
	 * Set the value related to the column: tt1
	 * @param tt1 the tt1 value
	 */
	public void setTt1 (java.util.Date tt1) {
		this.tt1 = tt1;
	}



	/**
	 * Return the value associated with the column: alert_message
	 */
	public java.lang.String getAlertMessage () {
		return alertMessage;
	}

	/**
	 * Set the value related to the column: alert_message
	 * @param alertMessage the alert_message value
	 */
	public void setAlertMessage (java.lang.String alertMessage) {
		this.alertMessage = alertMessage;
	}



	/**
	 * Return the value associated with the column: visit_date
	 */
	public java.util.Date getVisitDate () {
		return visitDate;
	}

	/**
	 * Set the value related to the column: visit_date
	 * @param visitDate the visit_date value
	 */
	public void setVisitDate (java.util.Date visitDate) {
		this.visitDate = visitDate;
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
	 * Return the value associated with the column: diagnosis_status
	 */
	public java.lang.String getDiagnosisStatus () {
		return diagnosisStatus;
	}

	/**
	 * Set the value related to the column: diagnosis_status
	 * @param diagnosisStatus the diagnosis_status value
	 */
	public void setDiagnosisStatus (java.lang.String diagnosisStatus) {
		this.diagnosisStatus = diagnosisStatus;
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
	 * Return the value associated with the column: basic_section_id
	 */
	public java.lang.Integer getBasicSectionId () {
		return basicSectionId;
	}

	/**
	 * Set the value related to the column: basic_section_id
	 * @param basicSectionId the basic_section_id value
	 */
	public void setBasicSectionId (java.lang.Integer basicSectionId) {
		this.basicSectionId = basicSectionId;
	}



	/**
	 * Return the value associated with the column: sub_section_id
	 */
	public java.lang.Integer getSubSectionId () {
		return subSectionId;
	}

	/**
	 * Set the value related to the column: sub_section_id
	 * @param subSectionId the sub_section_id value
	 */
	public void setSubSectionId (java.lang.Integer subSectionId) {
		this.subSectionId = subSectionId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAlert)) return false;
		else {
			jkt.hms.masters.business.PhAlert phAlert = (jkt.hms.masters.business.PhAlert) obj;
			if (null == this.getId() || null == phAlert.getId()) return false;
			else return (this.getId().equals(phAlert.getId()));
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