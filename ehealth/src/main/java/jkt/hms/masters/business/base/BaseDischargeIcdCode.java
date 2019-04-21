package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the discharge_icd_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="discharge_icd_code"
 */

public abstract class BaseDischargeIcdCode  implements Serializable {

	public static String REF = "DischargeIcdCode";
	public static String PROP_ICD = "Icd";
	public static String PROP_COMORBIDITY_STATUS = "ComorbidityStatus";
	public static String PROP_Z09 = "Z09";
	public static String PROP_COMORBIDITY_REMARK = "ComorbidityRemark";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SINCE_YEAR = "SinceYear";
	public static String PROP_SINCE_MONTH = "SinceMonth";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_DIAGNOSIS_STATUS = "DiagnosisStatus";
	public static String PROP_ID = "Id";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_Z03 = "Z03";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseDischargeIcdCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDischargeIcdCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String status;
	private java.lang.String z03;
	private java.lang.String z09;
	private java.lang.String diagnosisStatus;
	private java.lang.String comorbidityStatus;
	private java.lang.String sinceMonth;
	private java.lang.String sinceYear;
	private java.lang.String comorbidityRemark;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasIcd icd;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="discharge_icd_code_id"
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
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
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
	 * Return the value associated with the column: z03
	 */
	public java.lang.String getZ03 () {
		return z03;
	}

	/**
	 * Set the value related to the column: z03
	 * @param z03 the z03 value
	 */
	public void setZ03 (java.lang.String z03) {
		this.z03 = z03;
	}



	/**
	 * Return the value associated with the column: z09
	 */
	public java.lang.String getZ09 () {
		return z09;
	}

	/**
	 * Set the value related to the column: z09
	 * @param z09 the z09 value
	 */
	public void setZ09 (java.lang.String z09) {
		this.z09 = z09;
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
	 * Return the value associated with the column: comorbidity_status
	 */
	public java.lang.String getComorbidityStatus () {
		return comorbidityStatus;
	}

	/**
	 * Set the value related to the column: comorbidity_status
	 * @param comorbidityStatus the comorbidity_status value
	 */
	public void setComorbidityStatus (java.lang.String comorbidityStatus) {
		this.comorbidityStatus = comorbidityStatus;
	}



	/**
	 * Return the value associated with the column: since_month
	 */
	public java.lang.String getSinceMonth () {
		return sinceMonth;
	}

	/**
	 * Set the value related to the column: since_month
	 * @param sinceMonth the since_month value
	 */
	public void setSinceMonth (java.lang.String sinceMonth) {
		this.sinceMonth = sinceMonth;
	}



	/**
	 * Return the value associated with the column: since_year
	 */
	public java.lang.String getSinceYear () {
		return sinceYear;
	}

	/**
	 * Set the value related to the column: since_year
	 * @param sinceYear the since_year value
	 */
	public void setSinceYear (java.lang.String sinceYear) {
		this.sinceYear = sinceYear;
	}



	/**
	 * Return the value associated with the column: comorbidity_remark
	 */
	public java.lang.String getComorbidityRemark () {
		return comorbidityRemark;
	}

	/**
	 * Set the value related to the column: comorbidity_remark
	 * @param comorbidityRemark the comorbidity_remark value
	 */
	public void setComorbidityRemark (java.lang.String comorbidityRemark) {
		this.comorbidityRemark = comorbidityRemark;
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}



	/**
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icd the icd_id value
	 */
	public void setIcd (jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DischargeIcdCode)) return false;
		else {
			jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode = (jkt.hms.masters.business.DischargeIcdCode) obj;
			if (null == this.getId() || null == dischargeIcdCode.getId()) return false;
			else return (this.getId().equals(dischargeIcdCode.getId()));
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