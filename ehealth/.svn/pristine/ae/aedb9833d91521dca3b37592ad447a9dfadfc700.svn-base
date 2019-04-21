package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_second_opinion table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_second_opinion"
 */

public abstract class BaseOpdPatientSecondOpinion  implements Serializable {

	public static String REF = "OpdPatientSecondOpinion";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_OPINION_HIN = "OpinionHin";
	public static String PROP_OPINION_DATE = "OpinionDate";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_OPINOIN_NOTES = "OpinoinNotes";
	public static String PROP_CASE_SHEET = "CaseSheet";
	public static String PROP_VISIT = "Visit";
	public static String PROP_OPINOIN_STATUS = "OpinoinStatus";
	public static String PROP_OPENION_COMMENTS = "OpenionComments";
	public static String PROP_ID = "Id";
	public static String PROP_UHID_NO = "UhidNo";
	public static String PROP_OPINION_DOCTOR = "OpinionDoctor";
	public static String PROP_EHR = "Ehr";


	// constructors
	public BaseOpdPatientSecondOpinion () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientSecondOpinion (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String openionComments;
	private java.lang.String ehr;
	private java.lang.String opinoinStatus;
	private java.util.Date opinionDate;
	private java.lang.String uhidNo;
	private java.lang.String investigation;
	private java.lang.String caseSheet;
	private java.lang.String prescription;
	private java.lang.String opinoinNotes;
	private java.lang.String patientDetailsStatus;

	// many to one
	private jkt.hms.masters.business.Patient opinionHin;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasEmployee opinionDoctor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opinion_id"
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
	 * Return the value associated with the column: openion_comments
	 */
	public java.lang.String getOpenionComments () {
		return openionComments;
	}

	/**
	 * Set the value related to the column: openion_comments
	 * @param openionComments the openion_comments value
	 */
	public void setOpenionComments (java.lang.String openionComments) {
		this.openionComments = openionComments;
	}



	/**
	 * Return the value associated with the column: ehr
	 */
	public java.lang.String getEhr () {
		return ehr;
	}

	/**
	 * Set the value related to the column: ehr
	 * @param ehr the ehr value
	 */
	public void setEhr (java.lang.String ehr) {
		this.ehr = ehr;
	}



	/**
	 * Return the value associated with the column: opinoin_status
	 */
	public java.lang.String getOpinoinStatus () {
		return opinoinStatus;
	}

	/**
	 * Set the value related to the column: opinoin_status
	 * @param opinoinStatus the opinoin_status value
	 */
	public void setOpinoinStatus (java.lang.String opinoinStatus) {
		this.opinoinStatus = opinoinStatus;
	}



	/**
	 * Return the value associated with the column: opinion_date
	 */
	public java.util.Date getOpinionDate () {
		return opinionDate;
	}

	/**
	 * Set the value related to the column: opinion_date
	 * @param opinionDate the opinion_date value
	 */
	public void setOpinionDate (java.util.Date opinionDate) {
		this.opinionDate = opinionDate;
	}



	/**
	 * Return the value associated with the column: uhid_no
	 */
	public java.lang.String getUhidNo () {
		return uhidNo;
	}

	/**
	 * Set the value related to the column: uhid_no
	 * @param uhidNo the uhid_no value
	 */
	public void setUhidNo (java.lang.String uhidNo) {
		this.uhidNo = uhidNo;
	}



	/**
	 * Return the value associated with the column: investigation
	 */
	public java.lang.String getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation
	 * @param investigation the investigation value
	 */
	public void setInvestigation (java.lang.String investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: case_sheet
	 */
	public java.lang.String getCaseSheet () {
		return caseSheet;
	}

	/**
	 * Set the value related to the column: case_sheet
	 * @param caseSheet the case_sheet value
	 */
	public void setCaseSheet (java.lang.String caseSheet) {
		this.caseSheet = caseSheet;
	}



	/**
	 * Return the value associated with the column: prescription
	 */
	public java.lang.String getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: prescription
	 * @param prescription the prescription value
	 */
	public void setPrescription (java.lang.String prescription) {
		this.prescription = prescription;
	}



	/**
	 * Return the value associated with the column: opinoin_notes
	 */
	public java.lang.String getOpinoinNotes () {
		return opinoinNotes;
	}

	/**
	 * Set the value related to the column: opinoin_notes
	 * @param opinoinNotes the opinoin_notes value
	 */
	public void setOpinoinNotes (java.lang.String opinoinNotes) {
		this.opinoinNotes = opinoinNotes;
	}


	/**
	 * Return the value associated with the column: patient_details_status
	 */
	public java.lang.String getPatientDetailsStatus () {
		return patientDetailsStatus;
	}

	/**
	 * Set the value related to the column: patient_details_status
	 * @param patientDetailsStatus the patient_details_status value
	 */
	public void setPatientDetailsStatus (java.lang.String patientDetailsStatus) {
		this.patientDetailsStatus = patientDetailsStatus;
	}
	

	/**
	 * Return the value associated with the column: opinion_hin_id
	 */
	public jkt.hms.masters.business.Patient getOpinionHin () {
		return opinionHin;
	}

	/**
	 * Set the value related to the column: opinion_hin_id
	 * @param opinionHin the opinion_hin_id value
	 */
	public void setOpinionHin (jkt.hms.masters.business.Patient opinionHin) {
		this.opinionHin = opinionHin;
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
	 * Return the value associated with the column: opinion_doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getOpinionDoctor () {
		return opinionDoctor;
	}

	/**
	 * Set the value related to the column: opinion_doctor_id
	 * @param opinionDoctor the opinion_doctor_id value
	 */
	public void setOpinionDoctor (jkt.hms.masters.business.MasEmployee opinionDoctor) {
		this.opinionDoctor = opinionDoctor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientSecondOpinion)) return false;
		else {
			jkt.hms.masters.business.OpdPatientSecondOpinion opdPatientSecondOpinion = (jkt.hms.masters.business.OpdPatientSecondOpinion) obj;
			if (null == this.getId() || null == opdPatientSecondOpinion.getId()) return false;
			else return (this.getId().equals(opdPatientSecondOpinion.getId()));
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