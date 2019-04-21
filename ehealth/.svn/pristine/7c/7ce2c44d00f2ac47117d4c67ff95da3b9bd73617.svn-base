package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the external_admission_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="external_admission_details"
 */

public abstract class BaseExternalAdmissionDetails  implements Serializable {

	public static String REF = "ExternalAdmissionDetails";
	public static String PROP_MANAGEMENT = "Management";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_DATE_OF_ADMISSION = "DateOfAdmission";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_DISCHARGE = "DateOfDischarge";
	public static String PROP_ADVICE = "Advice";
	public static String PROP_VISIT = "Visit";
	public static String PROP_HIN = "Hin";
	public static String PROP_IP_NO = "IpNo";


	// constructors
	public BaseExternalAdmissionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExternalAdmissionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dateOfAdmission;
	private java.lang.String ipNo;
	private java.lang.String diagnosis;
	private java.lang.String management;
	private java.lang.String advice;
	private java.lang.String dateOfDischarge;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="record_id"
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
	 * Return the value associated with the column: date_of_admission
	 */
	public java.lang.String getDateOfAdmission () {
		return dateOfAdmission;
	}

	/**
	 * Set the value related to the column: date_of_admission
	 * @param dateOfAdmission the date_of_admission value
	 */
	public void setDateOfAdmission (java.lang.String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}



	/**
	 * Return the value associated with the column: ip_no
	 */
	public java.lang.String getIpNo () {
		return ipNo;
	}

	/**
	 * Set the value related to the column: ip_no
	 * @param ipNo the ip_no value
	 */
	public void setIpNo (java.lang.String ipNo) {
		this.ipNo = ipNo;
	}



	/**
	 * Return the value associated with the column: diagnosis
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis
	 * @param diagnosis the diagnosis value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: management
	 */
	public java.lang.String getManagement () {
		return management;
	}

	/**
	 * Set the value related to the column: management
	 * @param management the management value
	 */
	public void setManagement (java.lang.String management) {
		this.management = management;
	}



	/**
	 * Return the value associated with the column: advice
	 */
	public java.lang.String getAdvice () {
		return advice;
	}

	/**
	 * Set the value related to the column: advice
	 * @param advice the advice value
	 */
	public void setAdvice (java.lang.String advice) {
		this.advice = advice;
	}



	/**
	 * Return the value associated with the column: date_of_discharge
	 */
	public java.lang.String getDateOfDischarge () {
		return dateOfDischarge;
	}

	/**
	 * Set the value related to the column: date_of_discharge
	 * @param dateOfDischarge the date_of_discharge value
	 */
	public void setDateOfDischarge (java.lang.String dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
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
		if (!(obj instanceof jkt.hms.masters.business.ExternalAdmissionDetails)) return false;
		else {
			jkt.hms.masters.business.ExternalAdmissionDetails externalAdmissionDetails = (jkt.hms.masters.business.ExternalAdmissionDetails) obj;
			if (null == this.getId() || null == externalAdmissionDetails.getId()) return false;
			else return (this.getId().equals(externalAdmissionDetails.getId()));
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