package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_mas_investigation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_mas_investigation"
 */

public abstract class BaseDgMasInvestigation  implements Serializable {

	public static String REF = "DgMasInvestigation";
	public static String PROP_CONFIDENTIAL = "Confidential";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_APPEAR_IN_DISCHARGE_SUMMARY = "AppearInDischargeSummary";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_MIN_NORMAL_VALUE = "MinNormalValue";
	public static String PROP_TEST_ORDER_NO = "TestOrderNo";
	public static String PROP_SUBMITTED_BY_DOCTOR = "SubmittedByDoctor";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_VARIATION_REQUIRED = "VariationRequired";
	public static String PROP_APPOINTMENT_REQUIRED = "AppointmentRequired";
	public static String PROP_BLOOD_BANK_SCREEN_TEST = "BloodBankScreenTest";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COLLECTION = "Collection";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_INVESTIGATION_SHORT_CODE = "InvestigationShortCode";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_MAX_NORMAL_VALUE = "MaxNormalValue";
	public static String PROP_MACHINE_NAME = "MachineName";
	public static String PROP_INVESTIGATION_TYPE = "InvestigationType";
	public static String PROP_UOM = "Uom";
	public static String PROP_STATUS = "Status";
	public static String PROP_INVESTIGATION_NAME = "InvestigationName";
	public static String PROP_PH_LAB = "PhLab";
	public static String PROP_MULTIPLE_RESULTS = "MultipleResults";
	public static String PROP_RARE_COMMON = "RareCommon";
	public static String PROP_ID = "Id";
	public static String PROP_LOINC_NUM = "LoincNum";
	public static String PROP_BLOOD_REACTION_TEST = "BloodReactionTest";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseDgMasInvestigation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgMasInvestigation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String investigationName;
	private java.lang.String status;
	private java.lang.String confidential;
	private java.lang.String appearInDischargeSummary;
	private java.lang.String investigationType;
	private java.lang.String multipleResults;
	private java.lang.String quantity;
	private java.lang.String normalValue;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String appointmentRequired;
	private java.lang.String minNormalValue;
	private java.lang.String maxNormalValue;
	private java.lang.String rareCommon;
	private java.lang.Integer testOrderNo;
	private java.lang.String variationRequired;
	private java.lang.String bloodBankScreenTest;
	private java.lang.String bloodReactionTest;
	private java.lang.String remark;
	private java.lang.String machineName;
	private java.lang.String submittedByDoctor;
	private java.lang.String phLab;
	private java.lang.String investigationShortCode;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.DgMasCollection collection;
	private jkt.hms.masters.business.DgUom uom;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.MasLionc loincNum;
	private jkt.hms.masters.business.AppEquipmentMaster equipment;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;
	private java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> dgResultEntryDetailSens;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="investigation_id"
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
	 * Return the value associated with the column: investigation_name
	 */
	public java.lang.String getInvestigationName () {
		return investigationName;
	}

	/**
	 * Set the value related to the column: investigation_name
	 * @param investigationName the investigation_name value
	 */
	public void setInvestigationName (java.lang.String investigationName) {
		this.investigationName = investigationName;
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
	 * Return the value associated with the column: confidential
	 */
	public java.lang.String getConfidential () {
		return confidential;
	}

	/**
	 * Set the value related to the column: confidential
	 * @param confidential the confidential value
	 */
	public void setConfidential (java.lang.String confidential) {
		this.confidential = confidential;
	}



	/**
	 * Return the value associated with the column: appear_in_discharge_summary
	 */
	public java.lang.String getAppearInDischargeSummary () {
		return appearInDischargeSummary;
	}

	/**
	 * Set the value related to the column: appear_in_discharge_summary
	 * @param appearInDischargeSummary the appear_in_discharge_summary value
	 */
	public void setAppearInDischargeSummary (java.lang.String appearInDischargeSummary) {
		this.appearInDischargeSummary = appearInDischargeSummary;
	}



	/**
	 * Return the value associated with the column: investigation_type
	 */
	public java.lang.String getInvestigationType () {
		return investigationType;
	}

	/**
	 * Set the value related to the column: investigation_type
	 * @param investigationType the investigation_type value
	 */
	public void setInvestigationType (java.lang.String investigationType) {
		this.investigationType = investigationType;
	}



	/**
	 * Return the value associated with the column: multiple_results
	 */
	public java.lang.String getMultipleResults () {
		return multipleResults;
	}

	/**
	 * Set the value related to the column: multiple_results
	 * @param multipleResults the multiple_results value
	 */
	public void setMultipleResults (java.lang.String multipleResults) {
		this.multipleResults = multipleResults;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.String getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.String quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: normal_value
	 */
	public java.lang.String getNormalValue () {
		return normalValue;
	}

	/**
	 * Set the value related to the column: normal_value
	 * @param normalValue the normal_value value
	 */
	public void setNormalValue (java.lang.String normalValue) {
		this.normalValue = normalValue;
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
	 * Return the value associated with the column: appointment_required
	 */
	public java.lang.String getAppointmentRequired () {
		return appointmentRequired;
	}

	/**
	 * Set the value related to the column: appointment_required
	 * @param appointmentRequired the appointment_required value
	 */
	public void setAppointmentRequired (java.lang.String appointmentRequired) {
		this.appointmentRequired = appointmentRequired;
	}



	/**
	 * Return the value associated with the column: min_normal_value
	 */
	public java.lang.String getMinNormalValue () {
		return minNormalValue;
	}

	/**
	 * Set the value related to the column: min_normal_value
	 * @param minNormalValue the min_normal_value value
	 */
	public void setMinNormalValue (java.lang.String minNormalValue) {
		this.minNormalValue = minNormalValue;
	}



	/**
	 * Return the value associated with the column: max_normal_value
	 */
	public java.lang.String getMaxNormalValue () {
		return maxNormalValue;
	}

	/**
	 * Set the value related to the column: max_normal_value
	 * @param maxNormalValue the max_normal_value value
	 */
	public void setMaxNormalValue (java.lang.String maxNormalValue) {
		this.maxNormalValue = maxNormalValue;
	}



	/**
	 * Return the value associated with the column: rare_common
	 */
	public java.lang.String getRareCommon () {
		return rareCommon;
	}

	/**
	 * Set the value related to the column: rare_common
	 * @param rareCommon the rare_common value
	 */
	public void setRareCommon (java.lang.String rareCommon) {
		this.rareCommon = rareCommon;
	}



	/**
	 * Return the value associated with the column: test_order_no
	 */
	public java.lang.Integer getTestOrderNo () {
		return testOrderNo;
	}

	/**
	 * Set the value related to the column: test_order_no
	 * @param testOrderNo the test_order_no value
	 */
	public void setTestOrderNo (java.lang.Integer testOrderNo) {
		this.testOrderNo = testOrderNo;
	}



	/**
	 * Return the value associated with the column: variation_required
	 */
	public java.lang.String getVariationRequired () {
		return variationRequired;
	}

	/**
	 * Set the value related to the column: variation_required
	 * @param variationRequired the variation_required value
	 */
	public void setVariationRequired (java.lang.String variationRequired) {
		this.variationRequired = variationRequired;
	}



	/**
	 * Return the value associated with the column: blood_bank_screen_test
	 */
	public java.lang.String getBloodBankScreenTest () {
		return bloodBankScreenTest;
	}

	/**
	 * Set the value related to the column: blood_bank_screen_test
	 * @param bloodBankScreenTest the blood_bank_screen_test value
	 */
	public void setBloodBankScreenTest (java.lang.String bloodBankScreenTest) {
		this.bloodBankScreenTest = bloodBankScreenTest;
	}



	/**
	 * Return the value associated with the column: blood_reaction_test
	 */
	public java.lang.String getBloodReactionTest () {
		return bloodReactionTest;
	}

	/**
	 * Set the value related to the column: blood_reaction_test
	 * @param bloodReactionTest the blood_reaction_test value
	 */
	public void setBloodReactionTest (java.lang.String bloodReactionTest) {
		this.bloodReactionTest = bloodReactionTest;
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
	 * Return the value associated with the column: machine_name
	 */
	public java.lang.String getMachineName () {
		return machineName;
	}

	/**
	 * Set the value related to the column: machine_name
	 * @param machineName the machine_name value
	 */
	public void setMachineName (java.lang.String machineName) {
		this.machineName = machineName;
	}



	/**
	 * Return the value associated with the column: submitted_by_doctor
	 */
	public java.lang.String getSubmittedByDoctor () {
		return submittedByDoctor;
	}

	/**
	 * Set the value related to the column: submitted_by_doctor
	 * @param submittedByDoctor the submitted_by_doctor value
	 */
	public void setSubmittedByDoctor (java.lang.String submittedByDoctor) {
		this.submittedByDoctor = submittedByDoctor;
	}



	/**
	 * Return the value associated with the column: ph_lab
	 */
	public java.lang.String getPhLab () {
		return phLab;
	}

	/**
	 * Set the value related to the column: ph_lab
	 * @param phLab the ph_lab value
	 */
	public void setPhLab (java.lang.String phLab) {
		this.phLab = phLab;
	}



	/**
	 * Return the value associated with the column: investigation_short_code
	 */
	public java.lang.String getInvestigationShortCode () {
		return investigationShortCode;
	}

	/**
	 * Set the value related to the column: investigation_short_code
	 * @param investigationShortCode the investigation_short_code value
	 */
	public void setInvestigationShortCode (java.lang.String investigationShortCode) {
		this.investigationShortCode = investigationShortCode;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargecode () {
		return mainChargecode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * @param mainChargecode the main_chargecode_id value
	 */
	public void setMainChargecode (jkt.hms.masters.business.MasMainChargecode mainChargecode) {
		this.mainChargecode = mainChargecode;
	}



	/**
	 * Return the value associated with the column: collection_id
	 */
	public jkt.hms.masters.business.DgMasCollection getCollection () {
		return collection;
	}

	/**
	 * Set the value related to the column: collection_id
	 * @param collection the collection_id value
	 */
	public void setCollection (jkt.hms.masters.business.DgMasCollection collection) {
		this.collection = collection;
	}



	/**
	 * Return the value associated with the column: uom_id
	 */
	public jkt.hms.masters.business.DgUom getUom () {
		return uom;
	}

	/**
	 * Set the value related to the column: uom_id
	 * @param uom the uom_id value
	 */
	public void setUom (jkt.hms.masters.business.DgUom uom) {
		this.uom = uom;
	}



	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargecode () {
		return subChargecode;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * @param subChargecode the sub_chargecode_id value
	 */
	public void setSubChargecode (jkt.hms.masters.business.MasSubChargecode subChargecode) {
		this.subChargecode = subChargecode;
	}



	/**
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample () {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * @param sample the sample_id value
	 */
	public void setSample (jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
	}



	/**
	 * Return the value associated with the column: loinc_num
	 */
	public jkt.hms.masters.business.MasLionc getLoincNum () {
		return loincNum;
	}

	/**
	 * Set the value related to the column: loinc_num
	 * @param loincNum the loinc_num value
	 */
	public void setLoincNum (jkt.hms.masters.business.MasLionc loincNum) {
		this.loincNum = loincNum;
	}



	/**
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.AppEquipmentMaster getEquipment () {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipment the equipment_id value
	 */
	public void setEquipment (jkt.hms.masters.business.AppEquipmentMaster equipment) {
		this.equipment = equipment;
	}



	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails () {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * @param dgResultEntryDetails the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails (java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails (jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails()) setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}



	/**
	 * Return the value associated with the column: DgSubMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> getDgSubMasInvestigations () {
		return dgSubMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgSubMasInvestigations
	 * @param dgSubMasInvestigations the DgSubMasInvestigations value
	 */
	public void setDgSubMasInvestigations (java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations) {
		this.dgSubMasInvestigations = dgSubMasInvestigations;
	}

	public void addToDgSubMasInvestigations (jkt.hms.masters.business.DgSubMasInvestigation dgSubMasInvestigation) {
		if (null == getDgSubMasInvestigations()) setDgSubMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgSubMasInvestigation>());
		getDgSubMasInvestigations().add(dgSubMasInvestigation);
	}



	/**
	 * Return the value associated with the column: DgTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.DgTemplate> getDgTemplates () {
		return dgTemplates;
	}

	/**
	 * Set the value related to the column: DgTemplates
	 * @param dgTemplates the DgTemplates value
	 */
	public void setDgTemplates (java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates) {
		this.dgTemplates = dgTemplates;
	}

	public void addToDgTemplates (jkt.hms.masters.business.DgTemplate dgTemplate) {
		if (null == getDgTemplates()) setDgTemplates(new java.util.TreeSet<jkt.hms.masters.business.DgTemplate>());
		getDgTemplates().add(dgTemplate);
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails () {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * @param dgSampleCollectionDetails the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails (java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails (jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails()) setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}



	/**
	 * Return the value associated with the column: DgResultEntryDetailSens
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> getDgResultEntryDetailSens () {
		return dgResultEntryDetailSens;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetailSens
	 * @param dgResultEntryDetailSens the DgResultEntryDetailSens value
	 */
	public void setDgResultEntryDetailSens (java.util.Set<jkt.hms.masters.business.DgResultEntryDetailSen> dgResultEntryDetailSens) {
		this.dgResultEntryDetailSens = dgResultEntryDetailSens;
	}

	public void addToDgResultEntryDetailSens (jkt.hms.masters.business.DgResultEntryDetailSen dgResultEntryDetailSen) {
		if (null == getDgResultEntryDetailSens()) setDgResultEntryDetailSens(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetailSen>());
		getDgResultEntryDetailSens().add(dgResultEntryDetailSen);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgMasInvestigation)) return false;
		else {
			jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation = (jkt.hms.masters.business.DgMasInvestigation) obj;
			if (null == this.getId() || null == dgMasInvestigation.getId()) return false;
			else return (this.getId().equals(dgMasInvestigation.getId()));
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