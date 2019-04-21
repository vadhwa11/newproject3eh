package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_general_proforma_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_general_proforma_header"
 */

public abstract class BaseOpdGeneralProformaHeader  implements Serializable {

	public static String REF = "OpdGeneralProformaHeader";
	public static String PROP_PRSENTING_COMPLAINTS = "PrsentingComplaints";
	public static String PROP_PRESENTING_COMPLAINTS_OTHERS_VALUE = "PresentingComplaintsOthersValue";
	public static String PROP_MUCOUS_MEMBRANE = "MucousMembrane";
	public static String PROP_DRUG_HISTORY_VALUE = "DrugHistoryValue";
	public static String PROP_SYSTEM_ILLNESS_OTHERS_VALUE = "SystemIllnessOthersValue";
	public static String PROP_SECONDARY_LESION_OTHER = "SecondaryLesionOther";
	public static String PROP_PRIMARY_LESION_OTHER = "PrimaryLesionOther";
	public static String PROP_PAST_HISTORY = "PastHistory";
	public static String PROP_HAIR_VALUE = "HairValue";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_DISTRIBUTION = "Distribution";
	public static String PROP_SYSTEM_ILLNESS = "SystemIllness";
	public static String PROP_PAST_HISTORY_VALUE = "PastHistoryValue";
	public static String PROP_FAMILY_HISTORY_VALUE = "FamilyHistoryValue";
	public static String PROP_DURATION_OF_ILLNESS = "DurationOfIllness";
	public static String PROP_AGGRAVATING_FACTORS = "AggravatingFactors";
	public static String PROP_DISTRIBUTION_PARAMETER_VALUE = "DistributionParameterValue";
	public static String PROP_SIGNS_OTHERS_VALUE = "SignsOthersValue";
	public static String PROP_PRESENTING_COMPLAINT_VALUE = "PresentingComplaintValue";
	public static String PROP_AGGRAVATING_FACTORS_OTHERS_VALUE = "AggravatingFactorsOthersValue";
	public static String PROP_TEMPLATE_NAME = "TemplateName";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_SYSTEM_ILLNESS_VALUE = "SystemIllnessValue";
	public static String PROP_MUCOUS_MENBRANE_VALUE = "MucousMenbraneValue";
	public static String PROP_HAIR = "Hair";
	public static String PROP_NAILS_OTHERS_VALUE = "NailsOthersValue";
	public static String PROP_MUCOUS_MENBRANE_OTHERS_VALUE = "MucousMenbraneOthersValue";
	public static String PROP_SIGNS_VALUE = "SignsValue";
	public static String PROP_DRUG_HISTORY = "DrugHistory";
	public static String PROP_PAST_HISTORY_OTHERS_VALUE = "PastHistoryOthersValue";
	public static String PROP_NAILS_VALUE = "NailsValue";
	public static String PROP_ID = "Id";
	public static String PROP_NAILS = "Nails";
	public static String PROP_HAIR_OTHERS_VALUE = "HairOthersValue";
	public static String PROP_HIN = "Hin";
	public static String PROP_SIGNS = "Signs";
	public static String PROP_AGGRAVATING_FACTORS_VALUE = "AggravatingFactorsValue";


	// constructors
	public BaseOpdGeneralProformaHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGeneralProformaHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String durationOfIllness;
	private java.lang.String presentingComplaintValue;
	private java.lang.String pastHistoryValue;
	private java.lang.String familyHistory;
	private java.lang.String familyHistoryValue;
	private java.lang.String drugHistory;
	private java.lang.String mucousMenbraneValue;
	private java.lang.String hair;
	private java.lang.String nails;
	private java.lang.String systemIllness;
	private java.lang.String templateName;
	private java.lang.String primaryLesionOther;
	private java.lang.String secondaryLesionOther;
	private java.lang.String aggravatingFactors;
	private java.lang.String prsentingComplaints;
	private java.lang.String pastHistory;
	private java.lang.String distribution;
	private java.lang.String distributionParameterValue;
	private java.lang.String mucousMembrane;
	private java.lang.String hairValue;
	private java.lang.String nailsValue;
	private java.lang.String systemIllnessValue;
	private java.lang.String signs;
	private java.lang.String signsValue;
	private java.lang.String aggravatingFactorsValue;
	private java.lang.String presentingComplaintsOthersValue;
	private java.lang.String aggravatingFactorsOthersValue;
	private java.lang.String pastHistoryOthersValue;
	private java.lang.String mucousMenbraneOthersValue;
	private java.lang.String hairOthersValue;
	private java.lang.String nailsOthersValue;
	private java.lang.String systemIllnessOthersValue;
	private java.lang.String signsOthersValue;
	private java.lang.String drugHistoryValue;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdGeneralProformaDetail> opdGeneralProformaDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="general_proforma_id"
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
	 * Return the value associated with the column: duration_of_illness
	 */
	public java.lang.String getDurationOfIllness () {
		return durationOfIllness;
	}

	/**
	 * Set the value related to the column: duration_of_illness
	 * @param durationOfIllness the duration_of_illness value
	 */
	public void setDurationOfIllness (java.lang.String durationOfIllness) {
		this.durationOfIllness = durationOfIllness;
	}



	/**
	 * Return the value associated with the column: presenting_complaint_value
	 */
	public java.lang.String getPresentingComplaintValue () {
		return presentingComplaintValue;
	}

	/**
	 * Set the value related to the column: presenting_complaint_value
	 * @param presentingComplaintValue the presenting_complaint_value value
	 */
	public void setPresentingComplaintValue (java.lang.String presentingComplaintValue) {
		this.presentingComplaintValue = presentingComplaintValue;
	}



	/**
	 * Return the value associated with the column: past_history_value
	 */
	public java.lang.String getPastHistoryValue () {
		return pastHistoryValue;
	}

	/**
	 * Set the value related to the column: past_history_value
	 * @param pastHistoryValue the past_history_value value
	 */
	public void setPastHistoryValue (java.lang.String pastHistoryValue) {
		this.pastHistoryValue = pastHistoryValue;
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
	 * Return the value associated with the column: family_history_value
	 */
	public java.lang.String getFamilyHistoryValue () {
		return familyHistoryValue;
	}

	/**
	 * Set the value related to the column: family_history_value
	 * @param familyHistoryValue the family_history_value value
	 */
	public void setFamilyHistoryValue (java.lang.String familyHistoryValue) {
		this.familyHistoryValue = familyHistoryValue;
	}



	/**
	 * Return the value associated with the column: drug_history
	 */
	public java.lang.String getDrugHistory () {
		return drugHistory;
	}

	/**
	 * Set the value related to the column: drug_history
	 * @param drugHistory the drug_history value
	 */
	public void setDrugHistory (java.lang.String drugHistory) {
		this.drugHistory = drugHistory;
	}



	/**
	 * Return the value associated with the column: mucous_menbrane_value
	 */
	public java.lang.String getMucousMenbraneValue () {
		return mucousMenbraneValue;
	}

	/**
	 * Set the value related to the column: mucous_menbrane_value
	 * @param mucousMenbraneValue the mucous_menbrane_value value
	 */
	public void setMucousMenbraneValue (java.lang.String mucousMenbraneValue) {
		this.mucousMenbraneValue = mucousMenbraneValue;
	}



	/**
	 * Return the value associated with the column: hair
	 */
	public java.lang.String getHair () {
		return hair;
	}

	/**
	 * Set the value related to the column: hair
	 * @param hair the hair value
	 */
	public void setHair (java.lang.String hair) {
		this.hair = hair;
	}



	/**
	 * Return the value associated with the column: nails
	 */
	public java.lang.String getNails () {
		return nails;
	}

	/**
	 * Set the value related to the column: nails
	 * @param nails the nails value
	 */
	public void setNails (java.lang.String nails) {
		this.nails = nails;
	}



	/**
	 * Return the value associated with the column: system_illness
	 */
	public java.lang.String getSystemIllness () {
		return systemIllness;
	}

	/**
	 * Set the value related to the column: system_illness
	 * @param systemIllness the system_illness value
	 */
	public void setSystemIllness (java.lang.String systemIllness) {
		this.systemIllness = systemIllness;
	}



	/**
	 * Return the value associated with the column: template_name
	 */
	public java.lang.String getTemplateName () {
		return templateName;
	}

	/**
	 * Set the value related to the column: template_name
	 * @param templateName the template_name value
	 */
	public void setTemplateName (java.lang.String templateName) {
		this.templateName = templateName;
	}



	/**
	 * Return the value associated with the column: primary_lesion_other
	 */
	public java.lang.String getPrimaryLesionOther () {
		return primaryLesionOther;
	}

	/**
	 * Set the value related to the column: primary_lesion_other
	 * @param primaryLesionOther the primary_lesion_other value
	 */
	public void setPrimaryLesionOther (java.lang.String primaryLesionOther) {
		this.primaryLesionOther = primaryLesionOther;
	}



	/**
	 * Return the value associated with the column: secondary_lesion_other
	 */
	public java.lang.String getSecondaryLesionOther () {
		return secondaryLesionOther;
	}

	/**
	 * Set the value related to the column: secondary_lesion_other
	 * @param secondaryLesionOther the secondary_lesion_other value
	 */
	public void setSecondaryLesionOther (java.lang.String secondaryLesionOther) {
		this.secondaryLesionOther = secondaryLesionOther;
	}



	/**
	 * Return the value associated with the column: aggravating_factors
	 */
	public java.lang.String getAggravatingFactors () {
		return aggravatingFactors;
	}

	/**
	 * Set the value related to the column: aggravating_factors
	 * @param aggravatingFactors the aggravating_factors value
	 */
	public void setAggravatingFactors (java.lang.String aggravatingFactors) {
		this.aggravatingFactors = aggravatingFactors;
	}



	/**
	 * Return the value associated with the column: prsenting_complaints
	 */
	public java.lang.String getPrsentingComplaints () {
		return prsentingComplaints;
	}

	/**
	 * Set the value related to the column: prsenting_complaints
	 * @param prsentingComplaints the prsenting_complaints value
	 */
	public void setPrsentingComplaints (java.lang.String prsentingComplaints) {
		this.prsentingComplaints = prsentingComplaints;
	}



	/**
	 * Return the value associated with the column: past_history
	 */
	public java.lang.String getPastHistory () {
		return pastHistory;
	}

	/**
	 * Set the value related to the column: past_history
	 * @param pastHistory the past_history value
	 */
	public void setPastHistory (java.lang.String pastHistory) {
		this.pastHistory = pastHistory;
	}



	/**
	 * Return the value associated with the column: distribution
	 */
	public java.lang.String getDistribution () {
		return distribution;
	}

	/**
	 * Set the value related to the column: distribution
	 * @param distribution the distribution value
	 */
	public void setDistribution (java.lang.String distribution) {
		this.distribution = distribution;
	}



	/**
	 * Return the value associated with the column: distribution_parameter_value
	 */
	public java.lang.String getDistributionParameterValue () {
		return distributionParameterValue;
	}

	/**
	 * Set the value related to the column: distribution_parameter_value
	 * @param distributionParameterValue the distribution_parameter_value value
	 */
	public void setDistributionParameterValue (java.lang.String distributionParameterValue) {
		this.distributionParameterValue = distributionParameterValue;
	}



	/**
	 * Return the value associated with the column: mucous_membrane
	 */
	public java.lang.String getMucousMembrane () {
		return mucousMembrane;
	}

	/**
	 * Set the value related to the column: mucous_membrane
	 * @param mucousMembrane the mucous_membrane value
	 */
	public void setMucousMembrane (java.lang.String mucousMembrane) {
		this.mucousMembrane = mucousMembrane;
	}



	/**
	 * Return the value associated with the column: hair_value
	 */
	public java.lang.String getHairValue () {
		return hairValue;
	}

	/**
	 * Set the value related to the column: hair_value
	 * @param hairValue the hair_value value
	 */
	public void setHairValue (java.lang.String hairValue) {
		this.hairValue = hairValue;
	}



	/**
	 * Return the value associated with the column: nails_value
	 */
	public java.lang.String getNailsValue () {
		return nailsValue;
	}

	/**
	 * Set the value related to the column: nails_value
	 * @param nailsValue the nails_value value
	 */
	public void setNailsValue (java.lang.String nailsValue) {
		this.nailsValue = nailsValue;
	}



	/**
	 * Return the value associated with the column: system_illness_value
	 */
	public java.lang.String getSystemIllnessValue () {
		return systemIllnessValue;
	}

	/**
	 * Set the value related to the column: system_illness_value
	 * @param systemIllnessValue the system_illness_value value
	 */
	public void setSystemIllnessValue (java.lang.String systemIllnessValue) {
		this.systemIllnessValue = systemIllnessValue;
	}



	/**
	 * Return the value associated with the column: signs
	 */
	public java.lang.String getSigns () {
		return signs;
	}

	/**
	 * Set the value related to the column: signs
	 * @param signs the signs value
	 */
	public void setSigns (java.lang.String signs) {
		this.signs = signs;
	}



	/**
	 * Return the value associated with the column: signs_value
	 */
	public java.lang.String getSignsValue () {
		return signsValue;
	}

	/**
	 * Set the value related to the column: signs_value
	 * @param signsValue the signs_value value
	 */
	public void setSignsValue (java.lang.String signsValue) {
		this.signsValue = signsValue;
	}



	/**
	 * Return the value associated with the column: aggravating_factors_value
	 */
	public java.lang.String getAggravatingFactorsValue () {
		return aggravatingFactorsValue;
	}

	/**
	 * Set the value related to the column: aggravating_factors_value
	 * @param aggravatingFactorsValue the aggravating_factors_value value
	 */
	public void setAggravatingFactorsValue (java.lang.String aggravatingFactorsValue) {
		this.aggravatingFactorsValue = aggravatingFactorsValue;
	}



	/**
	 * Return the value associated with the column: presenting_complaints_others_value
	 */
	public java.lang.String getPresentingComplaintsOthersValue () {
		return presentingComplaintsOthersValue;
	}

	/**
	 * Set the value related to the column: presenting_complaints_others_value
	 * @param presentingComplaintsOthersValue the presenting_complaints_others_value value
	 */
	public void setPresentingComplaintsOthersValue (java.lang.String presentingComplaintsOthersValue) {
		this.presentingComplaintsOthersValue = presentingComplaintsOthersValue;
	}



	/**
	 * Return the value associated with the column: aggravating_factors_others_value
	 */
	public java.lang.String getAggravatingFactorsOthersValue () {
		return aggravatingFactorsOthersValue;
	}

	/**
	 * Set the value related to the column: aggravating_factors_others_value
	 * @param aggravatingFactorsOthersValue the aggravating_factors_others_value value
	 */
	public void setAggravatingFactorsOthersValue (java.lang.String aggravatingFactorsOthersValue) {
		this.aggravatingFactorsOthersValue = aggravatingFactorsOthersValue;
	}



	/**
	 * Return the value associated with the column: past_history_others_value
	 */
	public java.lang.String getPastHistoryOthersValue () {
		return pastHistoryOthersValue;
	}

	/**
	 * Set the value related to the column: past_history_others_value
	 * @param pastHistoryOthersValue the past_history_others_value value
	 */
	public void setPastHistoryOthersValue (java.lang.String pastHistoryOthersValue) {
		this.pastHistoryOthersValue = pastHistoryOthersValue;
	}



	/**
	 * Return the value associated with the column: mucous_menbrane_others_value
	 */
	public java.lang.String getMucousMenbraneOthersValue () {
		return mucousMenbraneOthersValue;
	}

	/**
	 * Set the value related to the column: mucous_menbrane_others_value
	 * @param mucousMenbraneOthersValue the mucous_menbrane_others_value value
	 */
	public void setMucousMenbraneOthersValue (java.lang.String mucousMenbraneOthersValue) {
		this.mucousMenbraneOthersValue = mucousMenbraneOthersValue;
	}



	/**
	 * Return the value associated with the column: hair_others_value
	 */
	public java.lang.String getHairOthersValue () {
		return hairOthersValue;
	}

	/**
	 * Set the value related to the column: hair_others_value
	 * @param hairOthersValue the hair_others_value value
	 */
	public void setHairOthersValue (java.lang.String hairOthersValue) {
		this.hairOthersValue = hairOthersValue;
	}



	/**
	 * Return the value associated with the column: nails_others_value
	 */
	public java.lang.String getNailsOthersValue () {
		return nailsOthersValue;
	}

	/**
	 * Set the value related to the column: nails_others_value
	 * @param nailsOthersValue the nails_others_value value
	 */
	public void setNailsOthersValue (java.lang.String nailsOthersValue) {
		this.nailsOthersValue = nailsOthersValue;
	}



	/**
	 * Return the value associated with the column: system_illness_others_value
	 */
	public java.lang.String getSystemIllnessOthersValue () {
		return systemIllnessOthersValue;
	}

	/**
	 * Set the value related to the column: system_illness_others_value
	 * @param systemIllnessOthersValue the system_illness_others_value value
	 */
	public void setSystemIllnessOthersValue (java.lang.String systemIllnessOthersValue) {
		this.systemIllnessOthersValue = systemIllnessOthersValue;
	}



	/**
	 * Return the value associated with the column: signs_others_value
	 */
	public java.lang.String getSignsOthersValue () {
		return signsOthersValue;
	}

	/**
	 * Set the value related to the column: signs_others_value
	 * @param signsOthersValue the signs_others_value value
	 */
	public void setSignsOthersValue (java.lang.String signsOthersValue) {
		this.signsOthersValue = signsOthersValue;
	}



	/**
	 * Return the value associated with the column: drug_history_value
	 */
	public java.lang.String getDrugHistoryValue () {
		return drugHistoryValue;
	}

	/**
	 * Set the value related to the column: drug_history_value
	 * @param drugHistoryValue the drug_history_value value
	 */
	public void setDrugHistoryValue (java.lang.String drugHistoryValue) {
		this.drugHistoryValue = drugHistoryValue;
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



	/**
	 * Return the value associated with the column: OpdGeneralProformaDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdGeneralProformaDetail> getOpdGeneralProformaDetails () {
		return opdGeneralProformaDetails;
	}

	/**
	 * Set the value related to the column: OpdGeneralProformaDetails
	 * @param opdGeneralProformaDetails the OpdGeneralProformaDetails value
	 */
	public void setOpdGeneralProformaDetails (java.util.Set<jkt.hms.masters.business.OpdGeneralProformaDetail> opdGeneralProformaDetails) {
		this.opdGeneralProformaDetails = opdGeneralProformaDetails;
	}

	public void addToOpdGeneralProformaDetails (jkt.hms.masters.business.OpdGeneralProformaDetail opdGeneralProformaDetail) {
		if (null == getOpdGeneralProformaDetails()) setOpdGeneralProformaDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdGeneralProformaDetail>());
		getOpdGeneralProformaDetails().add(opdGeneralProformaDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdGeneralProformaHeader)) return false;
		else {
			jkt.hms.masters.business.OpdGeneralProformaHeader opdGeneralProformaHeader = (jkt.hms.masters.business.OpdGeneralProformaHeader) obj;
			if (null == this.getId() || null == opdGeneralProformaHeader.getId()) return false;
			else return (this.getId().equals(opdGeneralProformaHeader.getId()));
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