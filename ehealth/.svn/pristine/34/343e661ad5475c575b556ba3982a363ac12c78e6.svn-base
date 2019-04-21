package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_detention_register table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_detention_register"
 */

public abstract class BasePatientDetentionRegister  implements Serializable {

	public static String REF = "PatientDetentionRegister";
	public static String PROP_TOTIME = "Totime";
	public static String PROP_DETAINED_TO = "DetainedTo";
	public static String PROP_DETENTION_REGISTER_DATE = "DetentionRegisterDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FROMTIME = "Fromtime";
	public static String PROP_REQUISITIONDATE = "Requisitiondate";
	public static String PROP_VISIT = "Visit";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_STATUS = "Status";
	public static String PROP_REVIEWAT = "Reviewat";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DETAINED_FROM = "DetainedFrom";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BasePatientDetentionRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientDetentionRegister (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.util.Date detentionRegisterDate;
	private java.lang.String remark;
	private java.util.Date detainedFrom;
	private java.util.Date detainedTo;
	private java.util.Date lastChgDate;
	private java.lang.String treatment;
	private java.lang.String fromtime;
	private java.lang.String totime;
	private java.util.Date requisitiondate;
	private java.lang.String reviewat;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="patient_detention_register_id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: detention_register_date
	 */
	public java.util.Date getDetentionRegisterDate () {
		return detentionRegisterDate;
	}

	/**
	 * Set the value related to the column: detention_register_date
	 * @param detentionRegisterDate the detention_register_date value
	 */
	public void setDetentionRegisterDate (java.util.Date detentionRegisterDate) {
		this.detentionRegisterDate = detentionRegisterDate;
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
	 * Return the value associated with the column: detained_from
	 */
	public java.util.Date getDetainedFrom () {
		return detainedFrom;
	}

	/**
	 * Set the value related to the column: detained_from
	 * @param detainedFrom the detained_from value
	 */
	public void setDetainedFrom (java.util.Date detainedFrom) {
		this.detainedFrom = detainedFrom;
	}



	/**
	 * Return the value associated with the column: detained_to
	 */
	public java.util.Date getDetainedTo () {
		return detainedTo;
	}

	/**
	 * Set the value related to the column: detained_to
	 * @param detainedTo the detained_to value
	 */
	public void setDetainedTo (java.util.Date detainedTo) {
		this.detainedTo = detainedTo;
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
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * @param treatment the treatment value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: fromtime
	 */
	public java.lang.String getFromtime () {
		return fromtime;
	}

	/**
	 * Set the value related to the column: fromtime
	 * @param fromtime the fromtime value
	 */
	public void setFromtime (java.lang.String fromtime) {
		this.fromtime = fromtime;
	}



	/**
	 * Return the value associated with the column: totime
	 */
	public java.lang.String getTotime () {
		return totime;
	}

	/**
	 * Set the value related to the column: totime
	 * @param totime the totime value
	 */
	public void setTotime (java.lang.String totime) {
		this.totime = totime;
	}



	/**
	 * Return the value associated with the column: requisitiondate
	 */
	public java.util.Date getRequisitiondate () {
		return requisitiondate;
	}

	/**
	 * Set the value related to the column: requisitiondate
	 * @param requisitiondate the requisitiondate value
	 */
	public void setRequisitiondate (java.util.Date requisitiondate) {
		this.requisitiondate = requisitiondate;
	}



	/**
	 * Return the value associated with the column: reviewat
	 */
	public java.lang.String getReviewat () {
		return reviewat;
	}

	/**
	 * Set the value related to the column: reviewat
	 * @param reviewat the reviewat value
	 */
	public void setReviewat (java.lang.String reviewat) {
		this.reviewat = reviewat;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientDetentionRegister)) return false;
		else {
			jkt.hms.masters.business.PatientDetentionRegister patientDetentionRegister = (jkt.hms.masters.business.PatientDetentionRegister) obj;
			if (null == this.getId() || null == patientDetentionRegister.getId()) return false;
			else return (this.getId().equals(patientDetentionRegister.getId()));
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