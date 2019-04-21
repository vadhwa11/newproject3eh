package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_charge_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_charge_code"
 */

public abstract class BaseMasChargeCode  implements Serializable {

	public static String REF = "MasChargeCode";
	public static String PROP_STD_DEDUCTION_GEN = "StdDeductionGen";
	public static String PROP_DATE_EFFECTIVE_FROM = "DateEffectiveFrom";
	public static String PROP_CHARGE_CODE_CODE = "ChargeCodeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_DR_ACCOUNTING_REQUIRED = "DrAccountingRequired";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_TELEMEDICINE_STATUS = "TelemedicineStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_PACS_STATUS = "ChargePacsStatus";
	public static String PROP_SNOMED_CONCEPT_ID = "SnomedConceptId";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISCOUNTABLE = "Discountable";
	public static String PROP_CHARGE_TYPE = "ChargeType";
	public static String PROP_OPD_RELATED_SERVICES = "OpdRelatedServices";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_STD_DEDUCTION_SPL = "StdDeductionSpl";
	public static String PROP_BILLING_STATUS = "BillingStatus";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_EDITABLE = "Editable";
	public static String PROP_STATUS = "Status";
	public static String PROP_PROCEDURE_CODE = "ProcedureCode";
	public static String PROP_DATE_EFFECTIVE_TO = "DateEffectiveTo";
	public static String PROP_ID = "Id";
	public static String PROP_CHARGE_CODE_NAME = "ChargeCodeName";
	public static String PROP_DISCOUNT_PERCENTAGE = "DiscountPercentage";
	public static String PROP_SUB_ACCOUNT = "SubAccount";
	public static String PROP_COMMON_CHARGE_CODE_STATUS = "CommonChargeCodeStatus";


	// constructors
	public BaseMasChargeCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasChargeCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String chargeCodeCode;
	private java.lang.String chargeCodeName;
	private java.lang.Float charge;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dateEffectiveFrom;
	private java.util.Date dateEffectiveTo;
	private java.lang.String editable;
	private java.lang.String discountable;
	private java.math.BigDecimal discountPercentage;
	private java.lang.String drAccountingRequired;
	private java.math.BigDecimal stdDeductionGen;
	private java.math.BigDecimal stdDeductionSpl;
	private java.lang.String billingStatus;
	private java.lang.String opdRelatedServices;
	private java.lang.String procedureCode;
	private java.lang.String chargePacsStatus;
	private java.lang.String telemedicineStatus;
	private java.lang.String snomedConceptId;
	private java.lang.String commonChargeCodeStatus;
	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasChargeType chargeType;
	private jkt.hms.masters.business.FaMasSubLed subAccount;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.BlTempOpBillDetails> blTempOpBillDetails;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails;
	private java.util.Set<jkt.hms.masters.business.BlPackageServicesDetails> blPackageServicesDetails;
	private java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> masSetupParameterMaintaincesByRegChargeCode;
	private java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> masSetupParameterMaintaincesByVisitChargeCode;
	private java.util.Set<jkt.hms.masters.business.DgNormalValue> dgNormalValues;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> otSurgeyPaSurgeyDetails;
	private java.util.Set<jkt.hms.masters.business.BlPaymentAdviceDetails> blPaymentAdviceDetails;
	private java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;
	private java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.MasSubTest> masSubTests;
	private java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.OtMasChargeDetails> otMasChargeDetails;
	private java.util.Set<jkt.hms.masters.business.MasChargeCodeRates> masChargeCodeRates;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> patientInvestigationDetails;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> opdSurgeryDetails;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	private java.util.Set<jkt.hms.masters.business.BlOpBillDetails> blOpBillDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="charge_code_id"
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
	 * Return the value associated with the column: charge_code_code
	 */
	public java.lang.String getChargeCodeCode () {
		return chargeCodeCode;
	}

	/**
	 * Set the value related to the column: charge_code_code
	 * @param chargeCodeCode the charge_code_code value
	 */
	public void setChargeCodeCode (java.lang.String chargeCodeCode) {
		this.chargeCodeCode = chargeCodeCode;
	}



	/**
	 * Return the value associated with the column: charge_code_name
	 */
	public java.lang.String getChargeCodeName () {
		return chargeCodeName;
	}

	/**
	 * Set the value related to the column: charge_code_name
	 * @param chargeCodeName the charge_code_name value
	 */
	public void setChargeCodeName (java.lang.String chargeCodeName) {
		this.chargeCodeName = chargeCodeName;
	}



	/**
	 * Return the value associated with the column: charge
	 */
	public java.lang.Float getCharge () {
		return charge;
	}

	/**
	 * Set the value related to the column: charge
	 * @param charge the charge value
	 */
	public void setCharge (java.lang.Float charge) {
		this.charge = charge;
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
	 * Return the value associated with the column: common_charge_code_status
	 */
	public java.lang.String getCommonChargeCodeStatus () {
		return commonChargeCodeStatus;
	}

	/**
	 * Set the value related to the column: common_charge_code_status
	 * @param commonChargeCodeStatus the common_charge_code_status value
	 */
	public void setCommonChargeCodeStatus (java.lang.String commonChargeCodeStatus) {
		this.commonChargeCodeStatus = commonChargeCodeStatus;
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
	 * Return the value associated with the column: date_effective_from
	 */
	public java.util.Date getDateEffectiveFrom () {
		return dateEffectiveFrom;
	}

	/**
	 * Set the value related to the column: date_effective_from
	 * @param dateEffectiveFrom the date_effective_from value
	 */
	public void setDateEffectiveFrom (java.util.Date dateEffectiveFrom) {
		this.dateEffectiveFrom = dateEffectiveFrom;
	}



	/**
	 * Return the value associated with the column: date_effective_to
	 */
	public java.util.Date getDateEffectiveTo () {
		return dateEffectiveTo;
	}

	/**
	 * Set the value related to the column: date_effective_to
	 * @param dateEffectiveTo the date_effective_to value
	 */
	public void setDateEffectiveTo (java.util.Date dateEffectiveTo) {
		this.dateEffectiveTo = dateEffectiveTo;
	}



	/**
	 * Return the value associated with the column: editable
	 */
	public java.lang.String getEditable () {
		return editable;
	}

	/**
	 * Set the value related to the column: editable
	 * @param editable the editable value
	 */
	public void setEditable (java.lang.String editable) {
		this.editable = editable;
	}



	/**
	 * Return the value associated with the column: discountable
	 */
	public java.lang.String getDiscountable () {
		return discountable;
	}

	/**
	 * Set the value related to the column: discountable
	 * @param discountable the discountable value
	 */
	public void setDiscountable (java.lang.String discountable) {
		this.discountable = discountable;
	}



	/**
	 * Return the value associated with the column: discount_percentage
	 */
	public java.math.BigDecimal getDiscountPercentage () {
		return discountPercentage;
	}

	/**
	 * Set the value related to the column: discount_percentage
	 * @param discountPercentage the discount_percentage value
	 */
	public void setDiscountPercentage (java.math.BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}



	/**
	 * Return the value associated with the column: dr_accounting_required
	 */
	public java.lang.String getDrAccountingRequired () {
		return drAccountingRequired;
	}

	/**
	 * Set the value related to the column: dr_accounting_required
	 * @param drAccountingRequired the dr_accounting_required value
	 */
	public void setDrAccountingRequired (java.lang.String drAccountingRequired) {
		this.drAccountingRequired = drAccountingRequired;
	}



	/**
	 * Return the value associated with the column: std_deduction_gen
	 */
	public java.math.BigDecimal getStdDeductionGen () {
		return stdDeductionGen;
	}

	/**
	 * Set the value related to the column: std_deduction_gen
	 * @param stdDeductionGen the std_deduction_gen value
	 */
	public void setStdDeductionGen (java.math.BigDecimal stdDeductionGen) {
		this.stdDeductionGen = stdDeductionGen;
	}



	/**
	 * Return the value associated with the column: std_deduction_spl
	 */
	public java.math.BigDecimal getStdDeductionSpl () {
		return stdDeductionSpl;
	}

	/**
	 * Set the value related to the column: std_deduction_spl
	 * @param stdDeductionSpl the std_deduction_spl value
	 */
	public void setStdDeductionSpl (java.math.BigDecimal stdDeductionSpl) {
		this.stdDeductionSpl = stdDeductionSpl;
	}



	/**
	 * Return the value associated with the column: billing_status
	 */
	public java.lang.String getBillingStatus () {
		return billingStatus;
	}

	/**
	 * Set the value related to the column: billing_status
	 * @param billingStatus the billing_status value
	 */
	public void setBillingStatus (java.lang.String billingStatus) {
		this.billingStatus = billingStatus;
	}



	/**
	 * Return the value associated with the column: opd_related_services
	 */
	public java.lang.String getOpdRelatedServices () {
		return opdRelatedServices;
	}

	/**
	 * Set the value related to the column: opd_related_services
	 * @param opdRelatedServices the opd_related_services value
	 */
	public void setOpdRelatedServices (java.lang.String opdRelatedServices) {
		this.opdRelatedServices = opdRelatedServices;
	}



	/**
	 * Return the value associated with the column: procedure_code
	 */
	public java.lang.String getProcedureCode () {
		return procedureCode;
	}

	/**
	 * Set the value related to the column: procedure_code
	 * @param procedureCode the procedure_code value
	 */
	public void setProcedureCode (java.lang.String procedureCode) {
		this.procedureCode = procedureCode;
	}



	/**
	 * Return the value associated with the column: charge_pacs_status
	 */
	public java.lang.String getChargePacsStatus () {
		return chargePacsStatus;
	}

	/**
	 * Set the value related to the column: charge_pacs_status
	 * @param chargePacsStatus the charge_pacs_status value
	 */
	public void setChargePacsStatus (java.lang.String chargePacsStatus) {
		this.chargePacsStatus = chargePacsStatus;
	}



	/**
	 * Return the value associated with the column: telemedicine_status
	 */
	public java.lang.String getTelemedicineStatus () {
		return telemedicineStatus;
	}

	/**
	 * Set the value related to the column: telemedicine_status
	 * @param telemedicineStatus the telemedicine_status value
	 */
	public void setTelemedicineStatus (java.lang.String telemedicineStatus) {
		this.telemedicineStatus = telemedicineStatus;
	}



	/**
	 * Return the value associated with the column: snomed_concept_id
	 */
	public java.lang.String getSnomedConceptId () {
		return snomedConceptId;
	}

	/**
	 * Set the value related to the column: snomed_concept_id
	 * @param snomedConceptId the snomed_concept_id value
	 */
	public void setSnomedConceptId (java.lang.String snomedConceptId) {
		this.snomedConceptId = snomedConceptId;
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
	 * Return the value associated with the column: account_id
	 */
	public jkt.hms.masters.business.FaMasAccount getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: account_id
	 * @param account the account_id value
	 */
	public void setAccount (jkt.hms.masters.business.FaMasAccount account) {
		this.account = account;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: charge_type_id
	 */
	public jkt.hms.masters.business.MasChargeType getChargeType () {
		return chargeType;
	}

	/**
	 * Set the value related to the column: charge_type_id
	 * @param chargeType the charge_type_id value
	 */
	public void setChargeType (jkt.hms.masters.business.MasChargeType chargeType) {
		this.chargeType = chargeType;
	}



	/**
	 * Return the value associated with the column: sub_account_id
	 */
	public jkt.hms.masters.business.FaMasSubLed getSubAccount () {
		return subAccount;
	}

	/**
	 * Set the value related to the column: sub_account_id
	 * @param subAccount the sub_account_id value
	 */
	public void setSubAccount (jkt.hms.masters.business.FaMasSubLed subAccount) {
		this.subAccount = subAccount;
	}



	/**
	 * Return the value associated with the column: DgMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgMasInvestigation> getDgMasInvestigations () {
		return dgMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgMasInvestigations
	 * @param dgMasInvestigations the DgMasInvestigations value
	 */
	public void setDgMasInvestigations (java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations) {
		this.dgMasInvestigations = dgMasInvestigations;
	}

	public void addToDgMasInvestigations (jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		if (null == getDgMasInvestigations()) setDgMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgMasInvestigation>());
		getDgMasInvestigations().add(dgMasInvestigation);
	}



	/**
	 * Return the value associated with the column: BlTempOpBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlTempOpBillDetails> getBlTempOpBillDetails () {
		return blTempOpBillDetails;
	}

	/**
	 * Set the value related to the column: BlTempOpBillDetails
	 * @param blTempOpBillDetails the BlTempOpBillDetails value
	 */
	public void setBlTempOpBillDetails (java.util.Set<jkt.hms.masters.business.BlTempOpBillDetails> blTempOpBillDetails) {
		this.blTempOpBillDetails = blTempOpBillDetails;
	}

	public void addToBlTempOpBillDetails (jkt.hms.masters.business.BlTempOpBillDetails blTempOpBillDetails) {
		if (null == getBlTempOpBillDetails()) setBlTempOpBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlTempOpBillDetails>());
		getBlTempOpBillDetails().add(blTempOpBillDetails);
	}



	/**
	 * Return the value associated with the column: BlChargeSlipDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> getBlChargeSlipDetails () {
		return blChargeSlipDetails;
	}

	/**
	 * Set the value related to the column: BlChargeSlipDetails
	 * @param blChargeSlipDetails the BlChargeSlipDetails value
	 */
	public void setBlChargeSlipDetails (java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails) {
		this.blChargeSlipDetails = blChargeSlipDetails;
	}

	public void addToBlChargeSlipDetails (jkt.hms.masters.business.BlChargeSlipDetail blChargeSlipDetail) {
		if (null == getBlChargeSlipDetails()) setBlChargeSlipDetails(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipDetail>());
		getBlChargeSlipDetails().add(blChargeSlipDetail);
	}



	/**
	 * Return the value associated with the column: BlPackageServicesDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlPackageServicesDetails> getBlPackageServicesDetails () {
		return blPackageServicesDetails;
	}

	/**
	 * Set the value related to the column: BlPackageServicesDetails
	 * @param blPackageServicesDetails the BlPackageServicesDetails value
	 */
	public void setBlPackageServicesDetails (java.util.Set<jkt.hms.masters.business.BlPackageServicesDetails> blPackageServicesDetails) {
		this.blPackageServicesDetails = blPackageServicesDetails;
	}

	public void addToBlPackageServicesDetails (jkt.hms.masters.business.BlPackageServicesDetails blPackageServicesDetails) {
		if (null == getBlPackageServicesDetails()) setBlPackageServicesDetails(new java.util.TreeSet<jkt.hms.masters.business.BlPackageServicesDetails>());
		getBlPackageServicesDetails().add(blPackageServicesDetails);
	}



	/**
	 * Return the value associated with the column: MasSetupParameterMaintaincesByRegChargeCode
	 */
	public java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> getMasSetupParameterMaintaincesByRegChargeCode () {
		return masSetupParameterMaintaincesByRegChargeCode;
	}

	/**
	 * Set the value related to the column: MasSetupParameterMaintaincesByRegChargeCode
	 * @param masSetupParameterMaintaincesByRegChargeCode the MasSetupParameterMaintaincesByRegChargeCode value
	 */
	public void setMasSetupParameterMaintaincesByRegChargeCode (java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> masSetupParameterMaintaincesByRegChargeCode) {
		this.masSetupParameterMaintaincesByRegChargeCode = masSetupParameterMaintaincesByRegChargeCode;
	}

	public void addToMasSetupParameterMaintaincesByRegChargeCode (jkt.hms.masters.business.MasSetupParameterMaintaince masSetupParameterMaintaince) {
		if (null == getMasSetupParameterMaintaincesByRegChargeCode()) setMasSetupParameterMaintaincesByRegChargeCode(new java.util.TreeSet<jkt.hms.masters.business.MasSetupParameterMaintaince>());
		getMasSetupParameterMaintaincesByRegChargeCode().add(masSetupParameterMaintaince);
	}



	/**
	 * Return the value associated with the column: MasSetupParameterMaintaincesByVisitChargeCode
	 */
	public java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> getMasSetupParameterMaintaincesByVisitChargeCode () {
		return masSetupParameterMaintaincesByVisitChargeCode;
	}

	/**
	 * Set the value related to the column: MasSetupParameterMaintaincesByVisitChargeCode
	 * @param masSetupParameterMaintaincesByVisitChargeCode the MasSetupParameterMaintaincesByVisitChargeCode value
	 */
	public void setMasSetupParameterMaintaincesByVisitChargeCode (java.util.Set<jkt.hms.masters.business.MasSetupParameterMaintaince> masSetupParameterMaintaincesByVisitChargeCode) {
		this.masSetupParameterMaintaincesByVisitChargeCode = masSetupParameterMaintaincesByVisitChargeCode;
	}

	public void addToMasSetupParameterMaintaincesByVisitChargeCode (jkt.hms.masters.business.MasSetupParameterMaintaince masSetupParameterMaintaince) {
		if (null == getMasSetupParameterMaintaincesByVisitChargeCode()) setMasSetupParameterMaintaincesByVisitChargeCode(new java.util.TreeSet<jkt.hms.masters.business.MasSetupParameterMaintaince>());
		getMasSetupParameterMaintaincesByVisitChargeCode().add(masSetupParameterMaintaince);
	}



	/**
	 * Return the value associated with the column: DgNormalValues
	 */
	public java.util.Set<jkt.hms.masters.business.DgNormalValue> getDgNormalValues () {
		return dgNormalValues;
	}

	/**
	 * Set the value related to the column: DgNormalValues
	 * @param dgNormalValues the DgNormalValues value
	 */
	public void setDgNormalValues (java.util.Set<jkt.hms.masters.business.DgNormalValue> dgNormalValues) {
		this.dgNormalValues = dgNormalValues;
	}

	public void addToDgNormalValues (jkt.hms.masters.business.DgNormalValue dgNormalValue) {
		if (null == getDgNormalValues()) setDgNormalValues(new java.util.TreeSet<jkt.hms.masters.business.DgNormalValue>());
		getDgNormalValues().add(dgNormalValue);
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: OtSurgeyPaSurgeyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> getOtSurgeyPaSurgeyDetails () {
		return otSurgeyPaSurgeyDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaSurgeyDetails
	 * @param otSurgeyPaSurgeyDetails the OtSurgeyPaSurgeyDetails value
	 */
	public void setOtSurgeyPaSurgeyDetails (java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> otSurgeyPaSurgeyDetails) {
		this.otSurgeyPaSurgeyDetails = otSurgeyPaSurgeyDetails;
	}

	public void addToOtSurgeyPaSurgeyDetails (jkt.hms.masters.business.OtSurgeyPaSurgeyDetail otSurgeyPaSurgeyDetail) {
		if (null == getOtSurgeyPaSurgeyDetails()) setOtSurgeyPaSurgeyDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail>());
		getOtSurgeyPaSurgeyDetails().add(otSurgeyPaSurgeyDetail);
	}



	/**
	 * Return the value associated with the column: BlPaymentAdviceDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlPaymentAdviceDetails> getBlPaymentAdviceDetails () {
		return blPaymentAdviceDetails;
	}

	/**
	 * Set the value related to the column: BlPaymentAdviceDetails
	 * @param blPaymentAdviceDetails the BlPaymentAdviceDetails value
	 */
	public void setBlPaymentAdviceDetails (java.util.Set<jkt.hms.masters.business.BlPaymentAdviceDetails> blPaymentAdviceDetails) {
		this.blPaymentAdviceDetails = blPaymentAdviceDetails;
	}

	public void addToBlPaymentAdviceDetails (jkt.hms.masters.business.BlPaymentAdviceDetails blPaymentAdviceDetails) {
		if (null == getBlPaymentAdviceDetails()) setBlPaymentAdviceDetails(new java.util.TreeSet<jkt.hms.masters.business.BlPaymentAdviceDetails>());
		getBlPaymentAdviceDetails().add(blPaymentAdviceDetails);
	}



	/**
	 * Return the value associated with the column: DgOrderdts
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderdt> getDgOrderdts () {
		return dgOrderdts;
	}

	/**
	 * Set the value related to the column: DgOrderdts
	 * @param dgOrderdts the DgOrderdts value
	 */
	public void setDgOrderdts (java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts) {
		this.dgOrderdts = dgOrderdts;
	}

	public void addToDgOrderdts (jkt.hms.masters.business.DgOrderdt dgOrderdt) {
		if (null == getDgOrderdts()) setDgOrderdts(new java.util.TreeSet<jkt.hms.masters.business.DgOrderdt>());
		getDgOrderdts().add(dgOrderdt);
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
	 * Return the value associated with the column: OpdTemplateInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> getOpdTemplateInvestigations () {
		return opdTemplateInvestigations;
	}

	/**
	 * Set the value related to the column: OpdTemplateInvestigations
	 * @param opdTemplateInvestigations the OpdTemplateInvestigations value
	 */
	public void setOpdTemplateInvestigations (java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations) {
		this.opdTemplateInvestigations = opdTemplateInvestigations;
	}

	public void addToOpdTemplateInvestigations (jkt.hms.masters.business.OpdTemplateInvestigation opdTemplateInvestigation) {
		if (null == getOpdTemplateInvestigations()) setOpdTemplateInvestigations(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateInvestigation>());
		getOpdTemplateInvestigations().add(opdTemplateInvestigation);
	}



	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts () {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * @param masDiscounts the MasDiscounts value
	 */
	public void setMasDiscounts (java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts (jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts()) setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}



	/**
	 * Return the value associated with the column: MasSubTests
	 */
	public java.util.Set<jkt.hms.masters.business.MasSubTest> getMasSubTests () {
		return masSubTests;
	}

	/**
	 * Set the value related to the column: MasSubTests
	 * @param masSubTests the MasSubTests value
	 */
	public void setMasSubTests (java.util.Set<jkt.hms.masters.business.MasSubTest> masSubTests) {
		this.masSubTests = masSubTests;
	}

	public void addToMasSubTests (jkt.hms.masters.business.MasSubTest masSubTest) {
		if (null == getMasSubTests()) setMasSubTests(new java.util.TreeSet<jkt.hms.masters.business.MasSubTest>());
		getMasSubTests().add(masSubTest);
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
	 * Return the value associated with the column: OtMasChargeDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtMasChargeDetails> getOtMasChargeDetails () {
		return otMasChargeDetails;
	}

	/**
	 * Set the value related to the column: OtMasChargeDetails
	 * @param otMasChargeDetails the OtMasChargeDetails value
	 */
	public void setOtMasChargeDetails (java.util.Set<jkt.hms.masters.business.OtMasChargeDetails> otMasChargeDetails) {
		this.otMasChargeDetails = otMasChargeDetails;
	}

	public void addToOtMasChargeDetails (jkt.hms.masters.business.OtMasChargeDetails otMasChargeDetails) {
		if (null == getOtMasChargeDetails()) setOtMasChargeDetails(new java.util.TreeSet<jkt.hms.masters.business.OtMasChargeDetails>());
		getOtMasChargeDetails().add(otMasChargeDetails);
	}



	/**
	 * Return the value associated with the column: MasChargeCodeRates
	 */
	public java.util.Set<jkt.hms.masters.business.MasChargeCodeRates> getMasChargeCodeRates () {
		return masChargeCodeRates;
	}

	/**
	 * Set the value related to the column: MasChargeCodeRates
	 * @param masChargeCodeRates the MasChargeCodeRates value
	 */
	public void setMasChargeCodeRates (java.util.Set<jkt.hms.masters.business.MasChargeCodeRates> masChargeCodeRates) {
		this.masChargeCodeRates = masChargeCodeRates;
	}

	public void addToMasChargeCodeRates (jkt.hms.masters.business.MasChargeCodeRates masChargeCodeRates) {
		if (null == getMasChargeCodeRates()) setMasChargeCodeRates(new java.util.TreeSet<jkt.hms.masters.business.MasChargeCodeRates>());
		getMasChargeCodeRates().add(masChargeCodeRates);
	}



	/**
	 * Return the value associated with the column: PatientInvestigationDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> getPatientInvestigationDetails () {
		return patientInvestigationDetails;
	}

	/**
	 * Set the value related to the column: PatientInvestigationDetails
	 * @param patientInvestigationDetails the PatientInvestigationDetails value
	 */
	public void setPatientInvestigationDetails (java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> patientInvestigationDetails) {
		this.patientInvestigationDetails = patientInvestigationDetails;
	}

	public void addToPatientInvestigationDetails (jkt.hms.masters.business.PatientInvestigationDetails patientInvestigationDetails) {
		if (null == getPatientInvestigationDetails()) setPatientInvestigationDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientInvestigationDetails>());
		getPatientInvestigationDetails().add(patientInvestigationDetails);
	}



	/**
	 * Return the value associated with the column: OpdSurgeryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> getOpdSurgeryDetails () {
		return opdSurgeryDetails;
	}

	/**
	 * Set the value related to the column: OpdSurgeryDetails
	 * @param opdSurgeryDetails the OpdSurgeryDetails value
	 */
	public void setOpdSurgeryDetails (java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> opdSurgeryDetails) {
		this.opdSurgeryDetails = opdSurgeryDetails;
	}

	public void addToOpdSurgeryDetails (jkt.hms.masters.business.OpdSurgeryDetail opdSurgeryDetail) {
		if (null == getOpdSurgeryDetails()) setOpdSurgeryDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdSurgeryDetail>());
		getOpdSurgeryDetails().add(opdSurgeryDetail);
	}



	/**
	 * Return the value associated with the column: OtBookings
	 */
	public java.util.Set<jkt.hms.masters.business.OtBooking> getOtBookings () {
		return otBookings;
	}

	/**
	 * Set the value related to the column: OtBookings
	 * @param otBookings the OtBookings value
	 */
	public void setOtBookings (java.util.Set<jkt.hms.masters.business.OtBooking> otBookings) {
		this.otBookings = otBookings;
	}

	public void addToOtBookings (jkt.hms.masters.business.OtBooking otBooking) {
		if (null == getOtBookings()) setOtBookings(new java.util.TreeSet<jkt.hms.masters.business.OtBooking>());
		getOtBookings().add(otBooking);
	}



	/**
	 * Return the value associated with the column: BlOpBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillDetails> getBlOpBillDetails () {
		return blOpBillDetails;
	}

	/**
	 * Set the value related to the column: BlOpBillDetails
	 * @param blOpBillDetails the BlOpBillDetails value
	 */
	public void setBlOpBillDetails (java.util.Set<jkt.hms.masters.business.BlOpBillDetails> blOpBillDetails) {
		this.blOpBillDetails = blOpBillDetails;
	}

	public void addToBlOpBillDetails (jkt.hms.masters.business.BlOpBillDetails blOpBillDetails) {
		if (null == getBlOpBillDetails()) setBlOpBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillDetails>());
		getBlOpBillDetails().add(blOpBillDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasChargeCode)) return false;
		else {
			jkt.hms.masters.business.MasChargeCode masChargeCode = (jkt.hms.masters.business.MasChargeCode) obj;
			if (null == this.getId() || null == masChargeCode.getId()) return false;
			else return (this.getId().equals(masChargeCode.getId()));
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