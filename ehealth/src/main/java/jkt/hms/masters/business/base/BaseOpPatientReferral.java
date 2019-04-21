package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the op_patient_referral table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="op_patient_referral"
 */

public abstract class BaseOpPatientReferral  implements Serializable {

	public static String REF = "OpPatientReferral";
	public static String PROP_REFERRED_DATE = "ReferredDate";
	public static String PROP_CARDIAC = "Cardiac";
	public static String PROP_OTHERS = "Others";
	public static String PROP_FACILITY_TELEPHONE = "FacilityTelephone";
	public static String PROP_RENAL = "Renal";
	public static String PROP_GENERAL = "General";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_PERSON_SPOKEN_TO = "PersonSpokenTo";
	public static String PROP_DRUG_ADMINISTERED = "DrugAdministered";
	public static String PROP_REFERRED_TO = "ReferredTo";
	public static String PROP_RESP = "Resp";
	public static String PROP_SUMMARY_OF_PROCEDURE = "SummaryOfProcedure";
	public static String PROP_CNS = "Cns";
	public static String PROP_ADMITTED_TIME = "AdmittedTime";
	public static String PROP_REFERRED_TIME = "ReferredTime";
	public static String PROP_FATHER_NAME = "FatherName";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_FACILITY_CENTRE = "FacilityCentre";
	public static String PROP_FACILITY_ADDRESS = "FacilityAddress";
	public static String PROP_INFORMATION = "Information";
	public static String PROP_ADMITTED_DATE = "admitted_date";
	public static String PROP_INVESTIGATION_DONE = "InvestigationDone";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_REFER_NO = "ReferNo";


	// constructors
	public BaseOpPatientReferral () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpPatientReferral (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fatherName;
	private java.lang.String contactNo;
	private java.util.Date referredDate;
	private java.lang.String referredTime;
	private java.lang.String referredTo;
	private java.lang.String facilityCentre;
	private java.lang.String diagnosis;
	private java.util.Date admitted_date;
	private java.lang.String admittedTime;
	private java.lang.String summaryOfProcedure;
	private java.lang.String drugAdministered;
	private java.lang.String investigationDone;
	private java.lang.String general;
	private java.lang.String cns;
	private java.lang.String resp;
	private java.lang.String cardiac;
	private java.lang.String information;
	private java.lang.String others;
	private java.lang.String personSpokenTo;
	private java.lang.String referNo;
	private java.lang.String facilityAddress;
	private java.lang.String facilityTelephone;
	private java.lang.String renal;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="patient_refer_id"
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
	 * Return the value associated with the column: father_name
	 */
	public java.lang.String getFatherName () {
		return fatherName;
	}

	/**
	 * Set the value related to the column: father_name
	 * @param fatherName the father_name value
	 */
	public void setFatherName (java.lang.String fatherName) {
		this.fatherName = fatherName;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: referred_date
	 */
	public java.util.Date getReferredDate () {
		return referredDate;
	}

	/**
	 * Set the value related to the column: referred_date
	 * @param referredDate the referred_date value
	 */
	public void setReferredDate (java.util.Date referredDate) {
		this.referredDate = referredDate;
	}



	/**
	 * Return the value associated with the column: referred_time
	 */
	public java.lang.String getReferredTime () {
		return referredTime;
	}

	/**
	 * Set the value related to the column: referred_time
	 * @param referredTime the referred_time value
	 */
	public void setReferredTime (java.lang.String referredTime) {
		this.referredTime = referredTime;
	}



	/**
	 * Return the value associated with the column: referred_to
	 */
	public java.lang.String getReferredTo () {
		return referredTo;
	}

	/**
	 * Set the value related to the column: referred_to
	 * @param referredTo the referred_to value
	 */
	public void setReferredTo (java.lang.String referredTo) {
		this.referredTo = referredTo;
	}



	/**
	 * Return the value associated with the column: facility_centre
	 */
	public java.lang.String getFacilityCentre () {
		return facilityCentre;
	}

	/**
	 * Set the value related to the column: facility_centre
	 * @param facilityCentre the facility_centre value
	 */
	public void setFacilityCentre (java.lang.String facilityCentre) {
		this.facilityCentre = facilityCentre;
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
	 * Return the value associated with the column: admitted_date
	 */
	public java.util.Date getAdmitted_date () {
		return admitted_date;
	}

	/**
	 * Set the value related to the column: admitted_date
	 * @param admitted_date the admitted_date value
	 */
	public void setAdmitted_date (java.util.Date admitted_date) {
		this.admitted_date = admitted_date;
	}



	/**
	 * Return the value associated with the column: admitted_time
	 */
	public java.lang.String getAdmittedTime () {
		return admittedTime;
	}

	/**
	 * Set the value related to the column: admitted_time
	 * @param admittedTime the admitted_time value
	 */
	public void setAdmittedTime (java.lang.String admittedTime) {
		this.admittedTime = admittedTime;
	}



	/**
	 * Return the value associated with the column: summary_of_procedure
	 */
	public java.lang.String getSummaryOfProcedure () {
		return summaryOfProcedure;
	}

	/**
	 * Set the value related to the column: summary_of_procedure
	 * @param summaryOfProcedure the summary_of_procedure value
	 */
	public void setSummaryOfProcedure (java.lang.String summaryOfProcedure) {
		this.summaryOfProcedure = summaryOfProcedure;
	}



	/**
	 * Return the value associated with the column: drug_administered
	 */
	public java.lang.String getDrugAdministered () {
		return drugAdministered;
	}

	/**
	 * Set the value related to the column: drug_administered
	 * @param drugAdministered the drug_administered value
	 */
	public void setDrugAdministered (java.lang.String drugAdministered) {
		this.drugAdministered = drugAdministered;
	}



	/**
	 * Return the value associated with the column: investigation_done
	 */
	public java.lang.String getInvestigationDone () {
		return investigationDone;
	}

	/**
	 * Set the value related to the column: investigation_done
	 * @param investigationDone the investigation_done value
	 */
	public void setInvestigationDone (java.lang.String investigationDone) {
		this.investigationDone = investigationDone;
	}



	/**
	 * Return the value associated with the column: general
	 */
	public java.lang.String getGeneral () {
		return general;
	}

	/**
	 * Set the value related to the column: general
	 * @param general the general value
	 */
	public void setGeneral (java.lang.String general) {
		this.general = general;
	}



	/**
	 * Return the value associated with the column: cns
	 */
	public java.lang.String getCns () {
		return cns;
	}

	/**
	 * Set the value related to the column: cns
	 * @param cns the cns value
	 */
	public void setCns (java.lang.String cns) {
		this.cns = cns;
	}



	/**
	 * Return the value associated with the column: resp
	 */
	public java.lang.String getResp () {
		return resp;
	}

	/**
	 * Set the value related to the column: resp
	 * @param resp the resp value
	 */
	public void setResp (java.lang.String resp) {
		this.resp = resp;
	}



	/**
	 * Return the value associated with the column: cardiac
	 */
	public java.lang.String getCardiac () {
		return cardiac;
	}

	/**
	 * Set the value related to the column: cardiac
	 * @param cardiac the cardiac value
	 */
	public void setCardiac (java.lang.String cardiac) {
		this.cardiac = cardiac;
	}



	/**
	 * Return the value associated with the column: information
	 */
	public java.lang.String getInformation () {
		return information;
	}

	/**
	 * Set the value related to the column: information
	 * @param information the information value
	 */
	public void setInformation (java.lang.String information) {
		this.information = information;
	}



	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers () {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * @param others the others value
	 */
	public void setOthers (java.lang.String others) {
		this.others = others;
	}



	/**
	 * Return the value associated with the column: person_spoken_to
	 */
	public java.lang.String getPersonSpokenTo () {
		return personSpokenTo;
	}

	/**
	 * Set the value related to the column: person_spoken_to
	 * @param personSpokenTo the person_spoken_to value
	 */
	public void setPersonSpokenTo (java.lang.String personSpokenTo) {
		this.personSpokenTo = personSpokenTo;
	}



	/**
	 * Return the value associated with the column: refer_no
	 */
	public java.lang.String getReferNo () {
		return referNo;
	}

	/**
	 * Set the value related to the column: refer_no
	 * @param referNo the refer_no value
	 */
	public void setReferNo (java.lang.String referNo) {
		this.referNo = referNo;
	}



	/**
	 * Return the value associated with the column: facility_address
	 */
	public java.lang.String getFacilityAddress () {
		return facilityAddress;
	}

	/**
	 * Set the value related to the column: facility_address
	 * @param facilityAddress the facility_address value
	 */
	public void setFacilityAddress (java.lang.String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}



	/**
	 * Return the value associated with the column: facility_tele
	 */
	public java.lang.String getFacilityTelephone () {
		return facilityTelephone;
	}

	/**
	 * Set the value related to the column: facility_tele
	 * @param facilityTelephone the facility_tele value
	 */
	public void setFacilityTelephone (java.lang.String facilityTelephone) {
		this.facilityTelephone = facilityTelephone;
	}



	/**
	 * Return the value associated with the column: renal
	 */
	public java.lang.String getRenal () {
		return renal;
	}

	/**
	 * Set the value related to the column: renal
	 * @param renal the renal value
	 */
	public void setRenal (java.lang.String renal) {
		this.renal = renal;
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
		if (!(obj instanceof jkt.hms.masters.business.OpPatientReferral)) return false;
		else {
			jkt.hms.masters.business.OpPatientReferral opPatientReferral = (jkt.hms.masters.business.OpPatientReferral) obj;
			if (null == this.getId() || null == opPatientReferral.getId()) return false;
			else return (this.getId().equals(opPatientReferral.getId()));
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