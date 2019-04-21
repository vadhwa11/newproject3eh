package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_pre_operative_check_list table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_pre_operative_check_list"
 */

public abstract class BaseOtPreOperativeCheckList  implements Serializable {

	public static String REF = "OtPreOperativeCheckList";
	public static String PROP_INTRA_OPERATIVE_SURGERY_STATUS = "IntraOperativeSurgeryStatus";
	public static String PROP_BLOOD_CROSS_MATCH = "BloodCrossMatch";
	public static String PROP_KNOWN_ALLERGY = "KnownAllergy";
	public static String PROP_LAST_FOOD_INTAKE = "LastFoodIntake";
	public static String PROP_PRE_OP_SHOWER = "PreOpShower";
	public static String PROP_EXISTING_IMPLANT = "ExistingImplant";
	public static String PROP_PROC_CONSENT_FORM_STATUS = "ProcConsentFormStatus";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_PASSED_URINE = "PassedUrine";
	public static String PROP_SURGICAL_ATTIRE = "SurgicalAttire";
	public static String PROP_HEARING_AID = "HearingAid";
	public static String PROP_REMOVAL = "Removal";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_CAPS_CROWN_LOOSE_TEETH_DAMAGE_DOCUMNETED = "CapsCrownLooseTeethDamageDocumneted";
	public static String PROP_NIDDM = "Niddm";
	public static String PROP_MEDICATION_WITHHELD = "MedicationWithheld";
	public static String PROP_IDDM = "Iddm";
	public static String PROP_INR = "Inr";
	public static String PROP_OPERATION_SITE_PREPARED = "OperationSitePrepared";
	public static String PROP_LAST_FLUID_INTAKE = "LastFluidIntake";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RESPIRATORY_RATE = "RespiratoryRate";
	public static String PROP_ASPIRATION_RISK = "AspirationRisk";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_OTHER_MEDICATION_TAKEN = "OtherMedicationTaken";
	public static String PROP_PREGNANT = "Pregnant";
	public static String PROP_ALLERGY_STATUS = "AllergyStatus";
	public static String PROP_DIABETIC_STATUS = "DiabeticStatus";
	public static String PROP_GLASSES = "Glasses";
	public static String PROP_BLOOD_PRODUCT_REFUSAL = "BloodProductRefusal";
	public static String PROP_RISK = "Risk";
	public static String PROP_DIFF_AIRWAY_ASPIRATIN_AVL = "DiffAirwayAspiratinAvl";
	public static String PROP_INFECTION_ALERTS = "InfectionAlerts";
	public static String PROP_ANAESTHESIA_MACHINE_CHECKED = "AnaesthesiaMachineChecked";
	public static String PROP_BP = "Bp";
	public static String PROP_ID = "Id";
	public static String PROP_XRAY_IMAGING_PACS = "XrayImagingPacs";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_OXIMETER_WORKING = "OximeterWorking";
	public static String PROP_ISS_MARKED_BY_SURGEON = "IssMarkedBySurgeon";
	public static String PROP_CYTO_MEDI_ADMIN_SEVEN_DAYS = "CytoMediAdminSevenDays";
	public static String PROP_OTHER_CHRONICAL_ILLNESS = "OtherChronicalIllness";
	public static String PROP_HIN = "Hin";
	public static String PROP_BLOOOD_GROUP = "BlooodGroup";
	public static String PROP_TEMP = "Temp";


	// constructors
	public BaseOtPreOperativeCheckList () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreOperativeCheckList (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String temp;
	private java.lang.String pulse;
	private java.lang.String respiratoryRate;
	private java.lang.String bp;
	private java.lang.String weight;
	private java.lang.String height;
	private java.lang.String procConsentFormStatus;
	private java.lang.String issMarkedBySurgeon;
	private java.lang.String xrayImagingPacs;
	private java.lang.String allergyStatus;
	private java.lang.String cytoMediAdminSevenDays;
	private java.lang.String pregnant;
	private java.lang.String diabeticStatus;
	private java.lang.String otherChronicalIllness;
	private java.lang.String lastFoodIntake;
	private java.lang.String lastFluidIntake;
	private java.lang.String otherMedicationTaken;
	private java.lang.String medicationWithheld;
	private java.lang.String blooodGroup;
	private java.lang.String inr;
	private java.lang.String bloodCrossMatch;
	private java.lang.String bloodProductRefusal;
	private java.lang.String existingImplant;
	private java.lang.String capsCrownLooseTeethDamageDocumneted;
	private java.lang.String preOpShower;
	private java.lang.String surgicalAttire;
	private java.lang.String removal;
	private java.lang.String operationSitePrepared;
	private java.lang.String glasses;
	private java.lang.String hearingAid;
	private java.lang.String diffAirwayAspiratinAvl;
	private java.lang.String risk;
	private java.lang.String passedUrine;
	private java.lang.String infectionAlerts;
	private java.lang.String niddm;
	private java.lang.String iddm;
	private java.lang.String intraOperativeSurgeryStatus;
	private java.lang.String anaesthesiaMachineChecked;
	private java.lang.String oximeterWorking;
	private java.lang.String knownAllergy;
	private java.lang.String aspirationRisk;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OtBooking otBooking;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="pre_operative_id"
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
	 * Return the value associated with the column: temp
	 */
	public java.lang.String getTemp () {
		return temp;
	}

	/**
	 * Set the value related to the column: temp
	 * @param temp the temp value
	 */
	public void setTemp (java.lang.String temp) {
		this.temp = temp;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.String getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.String pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: respiratory_rate
	 */
	public java.lang.String getRespiratoryRate () {
		return respiratoryRate;
	}

	/**
	 * Set the value related to the column: respiratory_rate
	 * @param respiratoryRate the respiratory_rate value
	 */
	public void setRespiratoryRate (java.lang.String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
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
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.String weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: proc_consent_form_status
	 */
	public java.lang.String getProcConsentFormStatus () {
		return procConsentFormStatus;
	}

	/**
	 * Set the value related to the column: proc_consent_form_status
	 * @param procConsentFormStatus the proc_consent_form_status value
	 */
	public void setProcConsentFormStatus (java.lang.String procConsentFormStatus) {
		this.procConsentFormStatus = procConsentFormStatus;
	}



	/**
	 * Return the value associated with the column: iss_marked_by_surgeon
	 */
	public java.lang.String getIssMarkedBySurgeon () {
		return issMarkedBySurgeon;
	}

	/**
	 * Set the value related to the column: iss_marked_by_surgeon
	 * @param issMarkedBySurgeon the iss_marked_by_surgeon value
	 */
	public void setIssMarkedBySurgeon (java.lang.String issMarkedBySurgeon) {
		this.issMarkedBySurgeon = issMarkedBySurgeon;
	}



	/**
	 * Return the value associated with the column: xray_imaging_pacs
	 */
	public java.lang.String getXrayImagingPacs () {
		return xrayImagingPacs;
	}

	/**
	 * Set the value related to the column: xray_imaging_pacs
	 * @param xrayImagingPacs the xray_imaging_pacs value
	 */
	public void setXrayImagingPacs (java.lang.String xrayImagingPacs) {
		this.xrayImagingPacs = xrayImagingPacs;
	}



	/**
	 * Return the value associated with the column: allergy_status
	 */
	public java.lang.String getAllergyStatus () {
		return allergyStatus;
	}

	/**
	 * Set the value related to the column: allergy_status
	 * @param allergyStatus the allergy_status value
	 */
	public void setAllergyStatus (java.lang.String allergyStatus) {
		this.allergyStatus = allergyStatus;
	}



	/**
	 * Return the value associated with the column: cyto_medi_admin_seven_days
	 */
	public java.lang.String getCytoMediAdminSevenDays () {
		return cytoMediAdminSevenDays;
	}

	/**
	 * Set the value related to the column: cyto_medi_admin_seven_days
	 * @param cytoMediAdminSevenDays the cyto_medi_admin_seven_days value
	 */
	public void setCytoMediAdminSevenDays (java.lang.String cytoMediAdminSevenDays) {
		this.cytoMediAdminSevenDays = cytoMediAdminSevenDays;
	}



	/**
	 * Return the value associated with the column: pregnant
	 */
	public java.lang.String getPregnant () {
		return pregnant;
	}

	/**
	 * Set the value related to the column: pregnant
	 * @param pregnant the pregnant value
	 */
	public void setPregnant (java.lang.String pregnant) {
		this.pregnant = pregnant;
	}



	/**
	 * Return the value associated with the column: diabetic_status
	 */
	public java.lang.String getDiabeticStatus () {
		return diabeticStatus;
	}

	/**
	 * Set the value related to the column: diabetic_status
	 * @param diabeticStatus the diabetic_status value
	 */
	public void setDiabeticStatus (java.lang.String diabeticStatus) {
		this.diabeticStatus = diabeticStatus;
	}



	/**
	 * Return the value associated with the column: other_chronical_illness
	 */
	public java.lang.String getOtherChronicalIllness () {
		return otherChronicalIllness;
	}

	/**
	 * Set the value related to the column: other_chronical_illness
	 * @param otherChronicalIllness the other_chronical_illness value
	 */
	public void setOtherChronicalIllness (java.lang.String otherChronicalIllness) {
		this.otherChronicalIllness = otherChronicalIllness;
	}



	/**
	 * Return the value associated with the column: last_food_intake
	 */
	public java.lang.String getLastFoodIntake () {
		return lastFoodIntake;
	}

	/**
	 * Set the value related to the column: last_food_intake
	 * @param lastFoodIntake the last_food_intake value
	 */
	public void setLastFoodIntake (java.lang.String lastFoodIntake) {
		this.lastFoodIntake = lastFoodIntake;
	}



	/**
	 * Return the value associated with the column: last_fluid_intake
	 */
	public java.lang.String getLastFluidIntake () {
		return lastFluidIntake;
	}

	/**
	 * Set the value related to the column: last_fluid_intake
	 * @param lastFluidIntake the last_fluid_intake value
	 */
	public void setLastFluidIntake (java.lang.String lastFluidIntake) {
		this.lastFluidIntake = lastFluidIntake;
	}



	/**
	 * Return the value associated with the column: other_medication_taken
	 */
	public java.lang.String getOtherMedicationTaken () {
		return otherMedicationTaken;
	}

	/**
	 * Set the value related to the column: other_medication_taken
	 * @param otherMedicationTaken the other_medication_taken value
	 */
	public void setOtherMedicationTaken (java.lang.String otherMedicationTaken) {
		this.otherMedicationTaken = otherMedicationTaken;
	}



	/**
	 * Return the value associated with the column: medication_withheld
	 */
	public java.lang.String getMedicationWithheld () {
		return medicationWithheld;
	}

	/**
	 * Set the value related to the column: medication_withheld
	 * @param medicationWithheld the medication_withheld value
	 */
	public void setMedicationWithheld (java.lang.String medicationWithheld) {
		this.medicationWithheld = medicationWithheld;
	}



	/**
	 * Return the value associated with the column: bloood_group
	 */
	public java.lang.String getBlooodGroup () {
		return blooodGroup;
	}

	/**
	 * Set the value related to the column: bloood_group
	 * @param blooodGroup the bloood_group value
	 */
	public void setBlooodGroup (java.lang.String blooodGroup) {
		this.blooodGroup = blooodGroup;
	}



	/**
	 * Return the value associated with the column: inr
	 */
	public java.lang.String getInr () {
		return inr;
	}

	/**
	 * Set the value related to the column: inr
	 * @param inr the inr value
	 */
	public void setInr (java.lang.String inr) {
		this.inr = inr;
	}



	/**
	 * Return the value associated with the column: blood_cross_match
	 */
	public java.lang.String getBloodCrossMatch () {
		return bloodCrossMatch;
	}

	/**
	 * Set the value related to the column: blood_cross_match
	 * @param bloodCrossMatch the blood_cross_match value
	 */
	public void setBloodCrossMatch (java.lang.String bloodCrossMatch) {
		this.bloodCrossMatch = bloodCrossMatch;
	}



	/**
	 * Return the value associated with the column: blood_product_refusal
	 */
	public java.lang.String getBloodProductRefusal () {
		return bloodProductRefusal;
	}

	/**
	 * Set the value related to the column: blood_product_refusal
	 * @param bloodProductRefusal the blood_product_refusal value
	 */
	public void setBloodProductRefusal (java.lang.String bloodProductRefusal) {
		this.bloodProductRefusal = bloodProductRefusal;
	}



	/**
	 * Return the value associated with the column: existing_implant
	 */
	public java.lang.String getExistingImplant () {
		return existingImplant;
	}

	/**
	 * Set the value related to the column: existing_implant
	 * @param existingImplant the existing_implant value
	 */
	public void setExistingImplant (java.lang.String existingImplant) {
		this.existingImplant = existingImplant;
	}



	/**
	 * Return the value associated with the column: caps_crown_loose_teeth_damage_documneted
	 */
	public java.lang.String getCapsCrownLooseTeethDamageDocumneted () {
		return capsCrownLooseTeethDamageDocumneted;
	}

	/**
	 * Set the value related to the column: caps_crown_loose_teeth_damage_documneted
	 * @param capsCrownLooseTeethDamageDocumneted the caps_crown_loose_teeth_damage_documneted value
	 */
	public void setCapsCrownLooseTeethDamageDocumneted (java.lang.String capsCrownLooseTeethDamageDocumneted) {
		this.capsCrownLooseTeethDamageDocumneted = capsCrownLooseTeethDamageDocumneted;
	}



	/**
	 * Return the value associated with the column: pre_op_shower
	 */
	public java.lang.String getPreOpShower () {
		return preOpShower;
	}

	/**
	 * Set the value related to the column: pre_op_shower
	 * @param preOpShower the pre_op_shower value
	 */
	public void setPreOpShower (java.lang.String preOpShower) {
		this.preOpShower = preOpShower;
	}



	/**
	 * Return the value associated with the column: surgical_attire
	 */
	public java.lang.String getSurgicalAttire () {
		return surgicalAttire;
	}

	/**
	 * Set the value related to the column: surgical_attire
	 * @param surgicalAttire the surgical_attire value
	 */
	public void setSurgicalAttire (java.lang.String surgicalAttire) {
		this.surgicalAttire = surgicalAttire;
	}



	/**
	 * Return the value associated with the column: removal
	 */
	public java.lang.String getRemoval () {
		return removal;
	}

	/**
	 * Set the value related to the column: removal
	 * @param removal the removal value
	 */
	public void setRemoval (java.lang.String removal) {
		this.removal = removal;
	}



	/**
	 * Return the value associated with the column: operation_site_prepared
	 */
	public java.lang.String getOperationSitePrepared () {
		return operationSitePrepared;
	}

	/**
	 * Set the value related to the column: operation_site_prepared
	 * @param operationSitePrepared the operation_site_prepared value
	 */
	public void setOperationSitePrepared (java.lang.String operationSitePrepared) {
		this.operationSitePrepared = operationSitePrepared;
	}



	/**
	 * Return the value associated with the column: glasses
	 */
	public java.lang.String getGlasses () {
		return glasses;
	}

	/**
	 * Set the value related to the column: glasses
	 * @param glasses the glasses value
	 */
	public void setGlasses (java.lang.String glasses) {
		this.glasses = glasses;
	}



	/**
	 * Return the value associated with the column: hearing_aid
	 */
	public java.lang.String getHearingAid () {
		return hearingAid;
	}

	/**
	 * Set the value related to the column: hearing_aid
	 * @param hearingAid the hearing_aid value
	 */
	public void setHearingAid (java.lang.String hearingAid) {
		this.hearingAid = hearingAid;
	}



	/**
	 * Return the value associated with the column: diff_airway_aspiratin_avl
	 */
	public java.lang.String getDiffAirwayAspiratinAvl () {
		return diffAirwayAspiratinAvl;
	}

	/**
	 * Set the value related to the column: diff_airway_aspiratin_avl
	 * @param diffAirwayAspiratinAvl the diff_airway_aspiratin_avl value
	 */
	public void setDiffAirwayAspiratinAvl (java.lang.String diffAirwayAspiratinAvl) {
		this.diffAirwayAspiratinAvl = diffAirwayAspiratinAvl;
	}



	/**
	 * Return the value associated with the column: risk
	 */
	public java.lang.String getRisk () {
		return risk;
	}

	/**
	 * Set the value related to the column: risk
	 * @param risk the risk value
	 */
	public void setRisk (java.lang.String risk) {
		this.risk = risk;
	}



	/**
	 * Return the value associated with the column: passed_urine
	 */
	public java.lang.String getPassedUrine () {
		return passedUrine;
	}

	/**
	 * Set the value related to the column: passed_urine
	 * @param passedUrine the passed_urine value
	 */
	public void setPassedUrine (java.lang.String passedUrine) {
		this.passedUrine = passedUrine;
	}



	/**
	 * Return the value associated with the column: infection_alerts
	 */
	public java.lang.String getInfectionAlerts () {
		return infectionAlerts;
	}

	/**
	 * Set the value related to the column: infection_alerts
	 * @param infectionAlerts the infection_alerts value
	 */
	public void setInfectionAlerts (java.lang.String infectionAlerts) {
		this.infectionAlerts = infectionAlerts;
	}



	/**
	 * Return the value associated with the column: niddm
	 */
	public java.lang.String getNiddm () {
		return niddm;
	}

	/**
	 * Set the value related to the column: niddm
	 * @param niddm the niddm value
	 */
	public void setNiddm (java.lang.String niddm) {
		this.niddm = niddm;
	}



	/**
	 * Return the value associated with the column: iddm
	 */
	public java.lang.String getIddm () {
		return iddm;
	}

	/**
	 * Set the value related to the column: iddm
	 * @param iddm the iddm value
	 */
	public void setIddm (java.lang.String iddm) {
		this.iddm = iddm;
	}



	/**
	 * Return the value associated with the column: intra_operative_surgery_status
	 */
	public java.lang.String getIntraOperativeSurgeryStatus () {
		return intraOperativeSurgeryStatus;
	}

	/**
	 * Set the value related to the column: intra_operative_surgery_status
	 * @param intraOperativeSurgeryStatus the intra_operative_surgery_status value
	 */
	public void setIntraOperativeSurgeryStatus (java.lang.String intraOperativeSurgeryStatus) {
		this.intraOperativeSurgeryStatus = intraOperativeSurgeryStatus;
	}



	/**
	 * Return the value associated with the column: anaesthesia_machine_checked
	 */
	public java.lang.String getAnaesthesiaMachineChecked () {
		return anaesthesiaMachineChecked;
	}

	/**
	 * Set the value related to the column: anaesthesia_machine_checked
	 * @param anaesthesiaMachineChecked the anaesthesia_machine_checked value
	 */
	public void setAnaesthesiaMachineChecked (java.lang.String anaesthesiaMachineChecked) {
		this.anaesthesiaMachineChecked = anaesthesiaMachineChecked;
	}



	/**
	 * Return the value associated with the column: oximeter_working
	 */
	public java.lang.String getOximeterWorking () {
		return oximeterWorking;
	}

	/**
	 * Set the value related to the column: oximeter_working
	 * @param oximeterWorking the oximeter_working value
	 */
	public void setOximeterWorking (java.lang.String oximeterWorking) {
		this.oximeterWorking = oximeterWorking;
	}



	/**
	 * Return the value associated with the column: known_allergy
	 */
	public java.lang.String getKnownAllergy () {
		return knownAllergy;
	}

	/**
	 * Set the value related to the column: known_allergy
	 * @param knownAllergy the known_allergy value
	 */
	public void setKnownAllergy (java.lang.String knownAllergy) {
		this.knownAllergy = knownAllergy;
	}



	/**
	 * Return the value associated with the column: aspiration_risk
	 */
	public java.lang.String getAspirationRisk () {
		return aspirationRisk;
	}

	/**
	 * Set the value related to the column: aspiration_risk
	 * @param aspirationRisk the aspiration_risk value
	 */
	public void setAspirationRisk (java.lang.String aspirationRisk) {
		this.aspirationRisk = aspirationRisk;
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
	 * Return the value associated with the column: ot_booking_id
	 */
	public jkt.hms.masters.business.OtBooking getOtBooking () {
		return otBooking;
	}

	/**
	 * Set the value related to the column: ot_booking_id
	 * @param otBooking the ot_booking_id value
	 */
	public void setOtBooking (jkt.hms.masters.business.OtBooking otBooking) {
		this.otBooking = otBooking;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreOperativeCheckList)) return false;
		else {
			jkt.hms.masters.business.OtPreOperativeCheckList otPreOperativeCheckList = (jkt.hms.masters.business.OtPreOperativeCheckList) obj;
			if (null == this.getId() || null == otPreOperativeCheckList.getId()) return false;
			else return (this.getId().equals(otPreOperativeCheckList.getId()));
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