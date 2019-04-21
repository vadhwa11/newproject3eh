package jkt.hms.masters.business.base;

import java.io.Serializable;

import jkt.hms.masters.business.OtPreAnesthesiaDetails;


/**
 * This is an object that contains data related to the aac_acceptance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="aac_acceptance"
 */

public abstract class BaseAacAcceptance  implements Serializable {

	public static String REF = "AacAcceptance";
	public static String PROP_MEDICINE_AT6AM = "MedicineAt6am";
	public static String PROP_GRADING_ASAPS = "GradingAsaps";
	public static String PROP_OTHERS = "Others";
	public static String PROP_GRADING_DETSKY = "GradingDetsky";
	public static String PROP_FURTHER_INVESTIGATIONS_NEEDED = "FurtherInvestigationsNeeded";
	public static String PROP_SURGERY_DAY_INVESTIGATIONS = "SurgeryDayInvestigations";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_GRADING_PUGH = "GradingPugh";
	public static String PROP_NIL_PER_ORAL = "NilPerOral";
	public static String PROP_REMOVE_ARTIFICIAL = "RemoveArtificial";
	public static String PROP_NIGHT_SEDATION = "NightSedation";
	public static String PROP_INFECTIVE_ENDOCARDITIS = "InfectiveEndocarditis";
	public static String PROP_GRADING_CHILD = "GradingChild";
	public static String PROP_GRADING_GOLDMAN = "GradingGoldman";
	public static String PROP_ADVICE_BEFORE_SURGERY = "AdviceBeforeSurgery";
	public static String PROP_PREVIOUS_DAY_MEDICINE = "PreviousDayMedicine";
	public static String PROP_PRE_MEDICATIONS = "PreMedications";
	public static String PROP_INFORMED_CONSENT = "InformedConsent";
	public static String PROP_ID = "Id";
	public static String PROP_CONSULTATIONS = "Consultations";
	public static String PROP_ACCEPTANCE_STATUS = "AcceptanceStatus";
	public static String PROP_CARDIAC_DRUGS = "CardiacDrugs";
	public static String PROP_OT_PRE_ANESTHESIA_DETAILS = "OtPreAnesthesiaDetails";


	// constructors
	public BaseAacAcceptance () {
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAacAcceptance (
		java.lang.Integer id) {

		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	// fields
	private java.lang.Integer id;
	private java.lang.String gradingAsaps;
	private java.lang.String gradingGoldman;
	private java.lang.String gradingPugh;
	private java.lang.String gradingChild;
	private java.lang.String gradingDetsky;
	private java.lang.String nilPerOral;
	private java.lang.String informedConsent;
	private java.lang.String previousDayMedicine;
	private java.lang.String nightSedation;
	private java.lang.String medicineAt6am;
	private java.lang.String cardiacDrugs;
	private java.lang.String adviceBeforeSurgery;
	private java.lang.String surgeryDayInvestigations;
	private java.lang.String removeArtificial;
	private java.lang.String preMedications;
	private java.lang.String others;
	private java.lang.String acceptanceStatus;
	private java.lang.String remarks;
	private java.lang.String consultations;
	private java.lang.String furtherInvestigationsNeeded;
	private java.lang.String infectiveEndocarditis;



   private OtPreAnesthesiaDetails otPreAnesthesiaDetails;


	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: grading_asaps
	 */
	public java.lang.String getGradingAsaps () {
		return gradingAsaps;
	}

	/**
	 * Set the value related to the column: grading_asaps
	 * @param gradingAsaps the grading_asaps value
	 */
	public void setGradingAsaps (java.lang.String gradingAsaps) {
		this.gradingAsaps = gradingAsaps;
	}



	/**
	 * Return the value associated with the column: grading_goldman
	 */
	public java.lang.String getGradingGoldman () {
		return gradingGoldman;
	}

	/**
	 * Set the value related to the column: grading_goldman
	 * @param gradingGoldman the grading_goldman value
	 */
	public void setGradingGoldman (java.lang.String gradingGoldman) {
		this.gradingGoldman = gradingGoldman;
	}



	/**
	 * Return the value associated with the column: grading_pugh
	 */
	public java.lang.String getGradingPugh () {
		return gradingPugh;
	}

	/**
	 * Set the value related to the column: grading_pugh
	 * @param gradingPugh the grading_pugh value
	 */
	public void setGradingPugh (java.lang.String gradingPugh) {
		this.gradingPugh = gradingPugh;
	}



	/**
	 * Return the value associated with the column: grading_child
	 */
	public java.lang.String getGradingChild () {
		return gradingChild;
	}

	/**
	 * Set the value related to the column: grading_child
	 * @param gradingChild the grading_child value
	 */
	public void setGradingChild (java.lang.String gradingChild) {
		this.gradingChild = gradingChild;
	}



	/**
	 * Return the value associated with the column: grading_detsky
	 */
	public java.lang.String getGradingDetsky () {
		return gradingDetsky;
	}

	/**
	 * Set the value related to the column: grading_detsky
	 * @param gradingDetsky the grading_detsky value
	 */
	public void setGradingDetsky (java.lang.String gradingDetsky) {
		this.gradingDetsky = gradingDetsky;
	}



	/**
	 * Return the value associated with the column: nil_per_oral
	 */
	public java.lang.String getNilPerOral () {
		return nilPerOral;
	}

	/**
	 * Set the value related to the column: nil_per_oral
	 * @param nilPerOral the nil_per_oral value
	 */
	public void setNilPerOral (java.lang.String nilPerOral) {
		this.nilPerOral = nilPerOral;
	}



	/**
	 * Return the value associated with the column: informed_consent
	 */
	public java.lang.String getInformedConsent () {
		return informedConsent;
	}

	/**
	 * Set the value related to the column: informed_consent
	 * @param informedConsent the informed_consent value
	 */
	public void setInformedConsent (java.lang.String informedConsent) {
		this.informedConsent = informedConsent;
	}



	/**
	 * Return the value associated with the column: previous_day_medicine
	 */
	public java.lang.String getPreviousDayMedicine () {
		return previousDayMedicine;
	}

	/**
	 * Set the value related to the column: previous_day_medicine
	 * @param previousDayMedicine the previous_day_medicine value
	 */
	public void setPreviousDayMedicine (java.lang.String previousDayMedicine) {
		this.previousDayMedicine = previousDayMedicine;
	}



	/**
	 * Return the value associated with the column: night_sedation
	 */
	public java.lang.String getNightSedation () {
		return nightSedation;
	}

	/**
	 * Set the value related to the column: night_sedation
	 * @param nightSedation the night_sedation value
	 */
	public void setNightSedation (java.lang.String nightSedation) {
		this.nightSedation = nightSedation;
	}



	/**
	 * Return the value associated with the column: medicine_at_6am
	 */
	public java.lang.String getMedicineAt6am () {
		return medicineAt6am;
	}

	/**
	 * Set the value related to the column: medicine_at_6am
	 * @param medicineAt6am the medicine_at_6am value
	 */
	public void setMedicineAt6am (java.lang.String medicineAt6am) {
		this.medicineAt6am = medicineAt6am;
	}



	/**
	 * Return the value associated with the column: cardiac_drugs
	 */
	public java.lang.String getCardiacDrugs () {
		return cardiacDrugs;
	}

	/**
	 * Set the value related to the column: cardiac_drugs
	 * @param cardiacDrugs the cardiac_drugs value
	 */
	public void setCardiacDrugs (java.lang.String cardiacDrugs) {
		this.cardiacDrugs = cardiacDrugs;
	}



	/**
	 * Return the value associated with the column: advice_before_surgery
	 */
	public java.lang.String getAdviceBeforeSurgery () {
		return adviceBeforeSurgery;
	}

	/**
	 * Set the value related to the column: advice_before_surgery
	 * @param adviceBeforeSurgery the advice_before_surgery value
	 */
	public void setAdviceBeforeSurgery (java.lang.String adviceBeforeSurgery) {
		this.adviceBeforeSurgery = adviceBeforeSurgery;
	}



	/**
	 * Return the value associated with the column: surgery_day_investigations
	 */
	public java.lang.String getSurgeryDayInvestigations () {
		return surgeryDayInvestigations;
	}

	/**
	 * Set the value related to the column: surgery_day_investigations
	 * @param surgeryDayInvestigations the surgery_day_investigations value
	 */
	public void setSurgeryDayInvestigations (java.lang.String surgeryDayInvestigations) {
		this.surgeryDayInvestigations = surgeryDayInvestigations;
	}



	/**
	 * Return the value associated with the column: remove_artificial
	 */
	public java.lang.String getRemoveArtificial () {
		return removeArtificial;
	}

	/**
	 * Set the value related to the column: remove_artificial
	 * @param removeArtificial the remove_artificial value
	 */
	public void setRemoveArtificial (java.lang.String removeArtificial) {
		this.removeArtificial = removeArtificial;
	}



	/**
	 * Return the value associated with the column: pre_medications
	 */
	public java.lang.String getPreMedications () {
		return preMedications;
	}

	/**
	 * Set the value related to the column: pre_medications
	 * @param preMedications the pre_medications value
	 */
	public void setPreMedications (java.lang.String preMedications) {
		this.preMedications = preMedications;
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
	 * Return the value associated with the column: acceptance_status
	 */
	public java.lang.String getAcceptanceStatus () {
		return acceptanceStatus;
	}

	/**
	 * Set the value related to the column: acceptance_status
	 * @param acceptanceStatus the acceptance_status value
	 */
	public void setAcceptanceStatus (java.lang.String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: consultations
	 */
	public java.lang.String getConsultations () {
		return consultations;
	}

	/**
	 * Set the value related to the column: consultations
	 * @param consultations the consultations value
	 */
	public void setConsultations (java.lang.String consultations) {
		this.consultations = consultations;
	}



	/**
	 * Return the value associated with the column: further_investigations_needed
	 */
	public java.lang.String getFurtherInvestigationsNeeded () {
		return furtherInvestigationsNeeded;
	}

	/**
	 * Set the value related to the column: further_investigations_needed
	 * @param furtherInvestigationsNeeded the further_investigations_needed value
	 */
	public void setFurtherInvestigationsNeeded (java.lang.String furtherInvestigationsNeeded) {
		this.furtherInvestigationsNeeded = furtherInvestigationsNeeded;
	}



	/**
	 * Return the value associated with the column: infective_endocarditis
	 */
	public java.lang.String getInfectiveEndocarditis () {
		return infectiveEndocarditis;
	}

	/**
	 * Set the value related to the column: infective_endocarditis
	 * @param infectiveEndocarditis the infective_endocarditis value
	 */
	public void setInfectiveEndocarditis (java.lang.String infectiveEndocarditis) {
		this.infectiveEndocarditis = infectiveEndocarditis;
	}







	public OtPreAnesthesiaDetails getOtPreAnesthesiaDetails() {
		return otPreAnesthesiaDetails;
	}

	public void setOtPreAnesthesiaDetails(
			OtPreAnesthesiaDetails otPreAnesthesiaDetails) {
		this.otPreAnesthesiaDetails = otPreAnesthesiaDetails;
	}

	public String toString () {
		return super.toString();
	}


}