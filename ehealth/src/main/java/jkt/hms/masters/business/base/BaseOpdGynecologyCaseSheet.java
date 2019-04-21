package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_gynecology_case_sheet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_gynecology_case_sheet"
 */

public abstract class BaseOpdGynecologyCaseSheet  implements Serializable {

	public static String REF = "OpdGynecologyCaseSheet";
	public static String PROP_OTHERS = "Others";
	public static String PROP_MENSTRUAL_CYCLE = "MenstrualCycle";
	public static String PROP_OTHER_SPECIFY = "OtherSpecify";
	public static String PROP_ALLERGIES = "Allergies";
	public static String PROP_PV = "Pv";
	public static String PROP_GENERAL_EXAM = "GeneralExam";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_SERVICES = "Services";
	public static String PROP_PR = "Pr";
	public static String PROP_PS = "Ps";
	public static String PROP_MENARCHE = "Menarche";
	public static String PROP_BORONCHIAL_ASTHMA = "BoronchialAsthma";
	public static String PROP_DRUGS = "Drugs";
	public static String PROP_LMP_TWO = "LmpTwo";
	public static String PROP_PA = "Pa";
	public static String PROP_HISTORY_OF_PRESENT_ILLNESS = "HistoryOfPresentIllness";
	public static String PROP_ANGINA = "Angina";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_HTN = "Htn";
	public static String PROP_DYSMENORRHOEA = "Dysmenorrhoea";
	public static String PROP_DIABETES = "Diabetes";
	public static String PROP_LMP_ONE = "LmpOne";
	public static String PROP_PRESENT_COMPLAINTS = "PresentComplaints";
	public static String PROP_RENAL_DISEASE = "RenalDisease";
	public static String PROP_SURGICAL_HISTORY = "SurgicalHistory";
	public static String PROP_FOLLOW_UP = "FollowUp";
	public static String PROP_TB = "Tb";
	public static String PROP_SIGNED_BY = "SignedBy";
	public static String PROP_MI = "Mi";
	public static String PROP_MARITAL_OBSTETRICS_HISTORY = "MaritalObstetricsHistory";
	public static String PROP_LOCAL_EXAMINATION = "LocalExamination";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_MENOPAUSE = "Menopause";
	public static String PROP_ON_VALUE = "OnValue";


	// constructors
	public BaseOpdGynecologyCaseSheet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGynecologyCaseSheet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String presentComplaints;
	private java.lang.String historyOfPresentIllness;
	private java.lang.String menarche;
	private java.lang.String menstrualCycle;
	private java.lang.String dysmenorrhoea;
	private java.util.Date lmpOne;
	private java.util.Date lmpTwo;
	private java.lang.String menopause;
	private java.lang.String maritalObstetricsHistory;
	private java.lang.String htn;
	private java.lang.String diabetes;
	private java.lang.String renalDisease;
	private java.lang.String tb;
	private java.lang.String boronchialAsthma;
	private java.lang.String angina;
	private java.lang.String mi;
	private java.lang.String allergies;
	private java.lang.String drugs;
	private java.lang.String others;
	private java.lang.String otherSpecify;
	private java.lang.String surgicalHistory;
	private java.lang.String familyHistory;
	private java.lang.String generalExam;
	private java.lang.String localExamination;
	private java.lang.String pa;
	private java.lang.String ps;
	private java.lang.String pv;
	private java.lang.String pr;
	private java.lang.String services;
	private java.lang.String followUp;
	private java.lang.String onValue;
	private java.lang.String signedBy;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="gynecology_case_sheet_id"
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
	 * Return the value associated with the column: present_complaints
	 */
	public java.lang.String getPresentComplaints () {
		return presentComplaints;
	}

	/**
	 * Set the value related to the column: present_complaints
	 * @param presentComplaints the present_complaints value
	 */
	public void setPresentComplaints (java.lang.String presentComplaints) {
		this.presentComplaints = presentComplaints;
	}



	/**
	 * Return the value associated with the column: history_of_present_illness
	 */
	public java.lang.String getHistoryOfPresentIllness () {
		return historyOfPresentIllness;
	}

	/**
	 * Set the value related to the column: history_of_present_illness
	 * @param historyOfPresentIllness the history_of_present_illness value
	 */
	public void setHistoryOfPresentIllness (java.lang.String historyOfPresentIllness) {
		this.historyOfPresentIllness = historyOfPresentIllness;
	}



	/**
	 * Return the value associated with the column: menarche
	 */
	public java.lang.String getMenarche () {
		return menarche;
	}

	/**
	 * Set the value related to the column: menarche
	 * @param menarche the menarche value
	 */
	public void setMenarche (java.lang.String menarche) {
		this.menarche = menarche;
	}



	/**
	 * Return the value associated with the column: menstrual_cycle
	 */
	public java.lang.String getMenstrualCycle () {
		return menstrualCycle;
	}

	/**
	 * Set the value related to the column: menstrual_cycle
	 * @param menstrualCycle the menstrual_cycle value
	 */
	public void setMenstrualCycle (java.lang.String menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}



	/**
	 * Return the value associated with the column: dysmenorrhoea
	 */
	public java.lang.String getDysmenorrhoea () {
		return dysmenorrhoea;
	}

	/**
	 * Set the value related to the column: dysmenorrhoea
	 * @param dysmenorrhoea the dysmenorrhoea value
	 */
	public void setDysmenorrhoea (java.lang.String dysmenorrhoea) {
		this.dysmenorrhoea = dysmenorrhoea;
	}



	/**
	 * Return the value associated with the column: lmp_one
	 */
	public java.util.Date getLmpOne () {
		return lmpOne;
	}

	/**
	 * Set the value related to the column: lmp_one
	 * @param lmpOne the lmp_one value
	 */
	public void setLmpOne (java.util.Date lmpOne) {
		this.lmpOne = lmpOne;
	}



	/**
	 * Return the value associated with the column: lmp_two
	 */
	public java.util.Date getLmpTwo () {
		return lmpTwo;
	}

	/**
	 * Set the value related to the column: lmp_two
	 * @param lmpTwo the lmp_two value
	 */
	public void setLmpTwo (java.util.Date lmpTwo) {
		this.lmpTwo = lmpTwo;
	}



	/**
	 * Return the value associated with the column: menopause
	 */
	public java.lang.String getMenopause () {
		return menopause;
	}

	/**
	 * Set the value related to the column: menopause
	 * @param menopause the menopause value
	 */
	public void setMenopause (java.lang.String menopause) {
		this.menopause = menopause;
	}



	/**
	 * Return the value associated with the column: marital_obstetrics_history
	 */
	public java.lang.String getMaritalObstetricsHistory () {
		return maritalObstetricsHistory;
	}

	/**
	 * Set the value related to the column: marital_obstetrics_history
	 * @param maritalObstetricsHistory the marital_obstetrics_history value
	 */
	public void setMaritalObstetricsHistory (java.lang.String maritalObstetricsHistory) {
		this.maritalObstetricsHistory = maritalObstetricsHistory;
	}



	/**
	 * Return the value associated with the column: htn
	 */
	public java.lang.String getHtn () {
		return htn;
	}

	/**
	 * Set the value related to the column: htn
	 * @param htn the htn value
	 */
	public void setHtn (java.lang.String htn) {
		this.htn = htn;
	}



	/**
	 * Return the value associated with the column: diabetes
	 */
	public java.lang.String getDiabetes () {
		return diabetes;
	}

	/**
	 * Set the value related to the column: diabetes
	 * @param diabetes the diabetes value
	 */
	public void setDiabetes (java.lang.String diabetes) {
		this.diabetes = diabetes;
	}



	/**
	 * Return the value associated with the column: renal_disease
	 */
	public java.lang.String getRenalDisease () {
		return renalDisease;
	}

	/**
	 * Set the value related to the column: renal_disease
	 * @param renalDisease the renal_disease value
	 */
	public void setRenalDisease (java.lang.String renalDisease) {
		this.renalDisease = renalDisease;
	}



	/**
	 * Return the value associated with the column: tb
	 */
	public java.lang.String getTb () {
		return tb;
	}

	/**
	 * Set the value related to the column: tb
	 * @param tb the tb value
	 */
	public void setTb (java.lang.String tb) {
		this.tb = tb;
	}



	/**
	 * Return the value associated with the column: boronchial_asthma
	 */
	public java.lang.String getBoronchialAsthma () {
		return boronchialAsthma;
	}

	/**
	 * Set the value related to the column: boronchial_asthma
	 * @param boronchialAsthma the boronchial_asthma value
	 */
	public void setBoronchialAsthma (java.lang.String boronchialAsthma) {
		this.boronchialAsthma = boronchialAsthma;
	}



	/**
	 * Return the value associated with the column: angina
	 */
	public java.lang.String getAngina () {
		return angina;
	}

	/**
	 * Set the value related to the column: angina
	 * @param angina the angina value
	 */
	public void setAngina (java.lang.String angina) {
		this.angina = angina;
	}



	/**
	 * Return the value associated with the column: mi
	 */
	public java.lang.String getMi () {
		return mi;
	}

	/**
	 * Set the value related to the column: mi
	 * @param mi the mi value
	 */
	public void setMi (java.lang.String mi) {
		this.mi = mi;
	}



	/**
	 * Return the value associated with the column: allergies
	 */
	public java.lang.String getAllergies () {
		return allergies;
	}

	/**
	 * Set the value related to the column: allergies
	 * @param allergies the allergies value
	 */
	public void setAllergies (java.lang.String allergies) {
		this.allergies = allergies;
	}



	/**
	 * Return the value associated with the column: drugs
	 */
	public java.lang.String getDrugs () {
		return drugs;
	}

	/**
	 * Set the value related to the column: drugs
	 * @param drugs the drugs value
	 */
	public void setDrugs (java.lang.String drugs) {
		this.drugs = drugs;
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
	 * Return the value associated with the column: other_specify
	 */
	public java.lang.String getOtherSpecify () {
		return otherSpecify;
	}

	/**
	 * Set the value related to the column: other_specify
	 * @param otherSpecify the other_specify value
	 */
	public void setOtherSpecify (java.lang.String otherSpecify) {
		this.otherSpecify = otherSpecify;
	}



	/**
	 * Return the value associated with the column: surgical_history
	 */
	public java.lang.String getSurgicalHistory () {
		return surgicalHistory;
	}

	/**
	 * Set the value related to the column: surgical_history
	 * @param surgicalHistory the surgical_history value
	 */
	public void setSurgicalHistory (java.lang.String surgicalHistory) {
		this.surgicalHistory = surgicalHistory;
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
	 * Return the value associated with the column: general_exam
	 */
	public java.lang.String getGeneralExam () {
		return generalExam;
	}

	/**
	 * Set the value related to the column: general_exam
	 * @param generalExam the general_exam value
	 */
	public void setGeneralExam (java.lang.String generalExam) {
		this.generalExam = generalExam;
	}



	/**
	 * Return the value associated with the column: local_examination
	 */
	public java.lang.String getLocalExamination () {
		return localExamination;
	}

	/**
	 * Set the value related to the column: local_examination
	 * @param localExamination the local_examination value
	 */
	public void setLocalExamination (java.lang.String localExamination) {
		this.localExamination = localExamination;
	}



	/**
	 * Return the value associated with the column: pa
	 */
	public java.lang.String getPa () {
		return pa;
	}

	/**
	 * Set the value related to the column: pa
	 * @param pa the pa value
	 */
	public void setPa (java.lang.String pa) {
		this.pa = pa;
	}



	/**
	 * Return the value associated with the column: ps
	 */
	public java.lang.String getPs () {
		return ps;
	}

	/**
	 * Set the value related to the column: ps
	 * @param ps the ps value
	 */
	public void setPs (java.lang.String ps) {
		this.ps = ps;
	}



	/**
	 * Return the value associated with the column: pv
	 */
	public java.lang.String getPv () {
		return pv;
	}

	/**
	 * Set the value related to the column: pv
	 * @param pv the pv value
	 */
	public void setPv (java.lang.String pv) {
		this.pv = pv;
	}



	/**
	 * Return the value associated with the column: pr
	 */
	public java.lang.String getPr () {
		return pr;
	}

	/**
	 * Set the value related to the column: pr
	 * @param pr the pr value
	 */
	public void setPr (java.lang.String pr) {
		this.pr = pr;
	}



	/**
	 * Return the value associated with the column: services
	 */
	public java.lang.String getServices () {
		return services;
	}

	/**
	 * Set the value related to the column: services
	 * @param services the services value
	 */
	public void setServices (java.lang.String services) {
		this.services = services;
	}



	/**
	 * Return the value associated with the column: follow_up
	 */
	public java.lang.String getFollowUp () {
		return followUp;
	}

	/**
	 * Set the value related to the column: follow_up
	 * @param followUp the follow_up value
	 */
	public void setFollowUp (java.lang.String followUp) {
		this.followUp = followUp;
	}



	/**
	 * Return the value associated with the column: on_value
	 */
	public java.lang.String getOnValue () {
		return onValue;
	}

	/**
	 * Set the value related to the column: on_value
	 * @param onValue the on_value value
	 */
	public void setOnValue (java.lang.String onValue) {
		this.onValue = onValue;
	}



	/**
	 * Return the value associated with the column: signed_by
	 */
	public java.lang.String getSignedBy () {
		return signedBy;
	}

	/**
	 * Set the value related to the column: signed_by
	 * @param signedBy the signed_by value
	 */
	public void setSignedBy (java.lang.String signedBy) {
		this.signedBy = signedBy;
	}



	/**
	 * Return the value associated with the column: opd_patient_details
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details
	 * @param opdPatientDetails the opd_patient_details value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdGynecologyCaseSheet)) return false;
		else {
			jkt.hms.masters.business.OpdGynecologyCaseSheet opdGynecologyCaseSheet = (jkt.hms.masters.business.OpdGynecologyCaseSheet) obj;
			if (null == this.getId() || null == opdGynecologyCaseSheet.getId()) return false;
			else return (this.getId().equals(opdGynecologyCaseSheet.getId()));
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