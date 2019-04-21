package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hospitalparameters table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hospitalparameters"
 */

public abstract class BaseHospitalParameters  implements Serializable {

	public static String REF = "HospitalParameters";
	public static String PROP_ALLOW_REFUND = "AllowRefund";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_REGISTRATION_NUMBER = "RegistrationNumber";
	public static String PROP_MARQUEE_TEXT = "MarqueeText";
	public static String PROP_OP_ON_ACCT = "OpOnAcct";
	public static String PROP_CST_NUMBER = "CstNumber";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_URL = "Url";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_STD_CODE = "StdCode";
	public static String PROP_POST_OFFICE = "PostOffice";
	public static String PROP_DEPT_ID_STORE_CODE_DHMS = "DeptIdStoreCodeDhms";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_IP_PAY_TYPE = "IpPayType";
	public static String PROP_REG_POLICY_PERIOD = "RegPolicyPeriod";
	public static String PROP_DEPT_ID_STORE_CODE_R_K_S = "DeptIdStoreCodeRKS";
	public static String PROP_REGISTRATION_DATE = "RegistrationDate";
	public static String PROP_LST_NUMBER = "LstNumber";
	public static String PROP_DAILY_CHARGE_CALCULATION = "DailyChargeCalculation";
	public static String PROP_DEPT_ID_STORE_CODE_NURSING_COLLEGE = "DeptIdStoreCodeNursingCollege";
	public static String PROP_DISPENSING_REQUIRED = "DispensingRequired";
	public static String PROP_ID = "Id";
	public static String PROP_INCLUDE_ST = "IncludeSt";
	public static String PROP_ADDRESS_LINE1 = "AddressLine1";
	public static String PROP_ADDRESS_LINE2 = "AddressLine2";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_DIET_SCHEDULING = "DietScheduling";
	public static String PROP_E_MAIL = "EMail";
	public static String PROP_BILL_PRINT_TYPE = "BillPrintType";
	public static String PROP_LAST_PROCESSED_DATE = "LastProcessedDate";
	public static String PROP_ALLOW_DISCHRG_WITHOUT_CLRNC = "AllowDischrgWithoutClrnc";
	public static String PROP_CHARGE_CALCULATION_TYPE = "ChargeCalculationType";
	public static String PROP_FAX_NUMBER = "FaxNumber";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_GRAMOPHONE_NUMBER = "GramophoneNumber";
	public static String PROP_ALLOW_OP_ADVANCE = "AllowOpAdvance";
	public static String PROP_MOBILE_NUMBER = "MobileNumber";
	public static String PROP_BLOCK = "Block";
	public static String PROP_CALCULATION_TIME = "CalculationTime";
	public static String PROP_OP_PAY_TYPE = "OpPayType";
	public static String PROP_REGISTRATION_VALIDITY_POLICY = "RegistrationValidityPolicy";
	public static String PROP_PROV_DIAG_MUST = "ProvDiagMust";
	public static String PROP_NURSING_CARE_CALCULATION = "NursingCareCalculation";
	public static String PROP_DEPT_ID_STORE_CODE_SICKEL = "DeptIdStoreCodeSickel";
	public static String PROP_CUURRENT_UNIT = "CuurrentUnit";
	public static String PROP_CITY = "City";
	public static String PROP_STATUS = "Status";
	public static String PROP_DEPT_ID_STORE_CODE_KHANVEL = "DeptIdStoreCodeKhanvel";
	public static String PROP_STATE = "State";
	public static String PROP_ALLOW_REG_FEE = "AllowRegFee";
	public static String PROP_DEPT_ID_STORE_CODE_V_B_C_H = "DeptIdStoreCodeVBCH";


	// constructors
	public BaseHospitalParameters () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHospitalParameters (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String eMail;
	private java.lang.String url;
	private java.lang.String cuurrentUnit;
	private java.lang.String cstNumber;
	private java.lang.String lstNumber;
	private java.lang.String registrationNumber;
	private java.util.Date registrationDate;
	private java.lang.String addressLine1;
	private java.lang.String pinCode;
	private java.lang.String stdCode;
	private java.lang.String phoneNumber;
	private java.lang.String faxNumber;
	private java.lang.String mobileNumber;
	private java.lang.String gramophoneNumber;
	private java.lang.Integer opOnAcct;
	private java.lang.Integer ipPayType;
	private java.lang.Integer opPayType;
	private java.lang.Integer includeSt;
	private java.lang.Integer provDiagMust;
	private java.lang.Integer billPrintType;
	private java.lang.Integer allowRegFee;
	private java.lang.Integer allowRefund;
	private java.lang.String marqueeText;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.Integer registrationValidityPolicy;
	private java.lang.Integer regPolicyPeriod;
	private java.lang.String status;
	private java.lang.String addressLine2;
	private java.lang.Integer allowDischrgWithoutClrnc;
	private java.lang.Integer allowOpAdvance;
	private java.lang.String dailyChargeCalculation;
	private java.lang.String chargeCalculationType;
	private java.lang.String calculationTime;
	private java.lang.String nursingCareCalculation;
	private java.util.Date lastProcessedDate;
	private java.lang.String block;
	private java.lang.String postOffice;
	private java.lang.String dispensingRequired;
	private java.lang.Integer deptIdStoreCodeRKS;
	private java.lang.Integer deptIdStoreCodeVBCH;
	private java.lang.Integer deptIdStoreCodeNursingCollege;
	private java.lang.Integer deptIdStoreCodeSickel;
	private java.lang.String dietScheduling;
	private java.lang.Integer deptIdStoreCodeKhanvel;
	private java.lang.Integer deptIdStoreCodeDhms;

	// many to one
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasCurrency currency;
	private jkt.hms.masters.business.Users lastChangedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasCountry country;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: e_mail
	 */
	public java.lang.String getEMail () {
		return eMail;
	}

	/**
	 * Set the value related to the column: e_mail
	 * @param eMail the e_mail value
	 */
	public void setEMail (java.lang.String eMail) {
		this.eMail = eMail;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: cuurrent_unit
	 */
	public java.lang.String getCuurrentUnit () {
		return cuurrentUnit;
	}

	/**
	 * Set the value related to the column: cuurrent_unit
	 * @param cuurrentUnit the cuurrent_unit value
	 */
	public void setCuurrentUnit (java.lang.String cuurrentUnit) {
		this.cuurrentUnit = cuurrentUnit;
	}



	/**
	 * Return the value associated with the column: cst_number
	 */
	public java.lang.String getCstNumber () {
		return cstNumber;
	}

	/**
	 * Set the value related to the column: cst_number
	 * @param cstNumber the cst_number value
	 */
	public void setCstNumber (java.lang.String cstNumber) {
		this.cstNumber = cstNumber;
	}



	/**
	 * Return the value associated with the column: lst_number
	 */
	public java.lang.String getLstNumber () {
		return lstNumber;
	}

	/**
	 * Set the value related to the column: lst_number
	 * @param lstNumber the lst_number value
	 */
	public void setLstNumber (java.lang.String lstNumber) {
		this.lstNumber = lstNumber;
	}



	/**
	 * Return the value associated with the column: registration_number
	 */
	public java.lang.String getRegistrationNumber () {
		return registrationNumber;
	}

	/**
	 * Set the value related to the column: registration_number
	 * @param registrationNumber the registration_number value
	 */
	public void setRegistrationNumber (java.lang.String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}



	/**
	 * Return the value associated with the column: registration_date
	 */
	public java.util.Date getRegistrationDate () {
		return registrationDate;
	}

	/**
	 * Set the value related to the column: registration_date
	 * @param registrationDate the registration_date value
	 */
	public void setRegistrationDate (java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}



	/**
	 * Return the value associated with the column: address_line_1
	 */
	public java.lang.String getAddressLine1 () {
		return addressLine1;
	}

	/**
	 * Set the value related to the column: address_line_1
	 * @param addressLine1 the address_line_1 value
	 */
	public void setAddressLine1 (java.lang.String addressLine1) {
		this.addressLine1 = addressLine1;
	}



	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.String getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.String pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: std_code
	 */
	public java.lang.String getStdCode () {
		return stdCode;
	}

	/**
	 * Set the value related to the column: std_code
	 * @param stdCode the std_code value
	 */
	public void setStdCode (java.lang.String stdCode) {
		this.stdCode = stdCode;
	}



	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber () {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * @param phoneNumber the phone_number value
	 */
	public void setPhoneNumber (java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * Return the value associated with the column: fax_number
	 */
	public java.lang.String getFaxNumber () {
		return faxNumber;
	}

	/**
	 * Set the value related to the column: fax_number
	 * @param faxNumber the fax_number value
	 */
	public void setFaxNumber (java.lang.String faxNumber) {
		this.faxNumber = faxNumber;
	}



	/**
	 * Return the value associated with the column: mobile_number
	 */
	public java.lang.String getMobileNumber () {
		return mobileNumber;
	}

	/**
	 * Set the value related to the column: mobile_number
	 * @param mobileNumber the mobile_number value
	 */
	public void setMobileNumber (java.lang.String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	/**
	 * Return the value associated with the column: gramophone_number
	 */
	public java.lang.String getGramophoneNumber () {
		return gramophoneNumber;
	}

	/**
	 * Set the value related to the column: gramophone_number
	 * @param gramophoneNumber the gramophone_number value
	 */
	public void setGramophoneNumber (java.lang.String gramophoneNumber) {
		this.gramophoneNumber = gramophoneNumber;
	}



	/**
	 * Return the value associated with the column: op_on_acct
	 */
	public java.lang.Integer getOpOnAcct () {
		return opOnAcct;
	}

	/**
	 * Set the value related to the column: op_on_acct
	 * @param opOnAcct the op_on_acct value
	 */
	public void setOpOnAcct (java.lang.Integer opOnAcct) {
		this.opOnAcct = opOnAcct;
	}



	/**
	 * Return the value associated with the column: ip_pay_type
	 */
	public java.lang.Integer getIpPayType () {
		return ipPayType;
	}

	/**
	 * Set the value related to the column: ip_pay_type
	 * @param ipPayType the ip_pay_type value
	 */
	public void setIpPayType (java.lang.Integer ipPayType) {
		this.ipPayType = ipPayType;
	}



	/**
	 * Return the value associated with the column: op_pay_type
	 */
	public java.lang.Integer getOpPayType () {
		return opPayType;
	}

	/**
	 * Set the value related to the column: op_pay_type
	 * @param opPayType the op_pay_type value
	 */
	public void setOpPayType (java.lang.Integer opPayType) {
		this.opPayType = opPayType;
	}



	/**
	 * Return the value associated with the column: include_st
	 */
	public java.lang.Integer getIncludeSt () {
		return includeSt;
	}

	/**
	 * Set the value related to the column: include_st
	 * @param includeSt the include_st value
	 */
	public void setIncludeSt (java.lang.Integer includeSt) {
		this.includeSt = includeSt;
	}



	/**
	 * Return the value associated with the column: prov_diag_must
	 */
	public java.lang.Integer getProvDiagMust () {
		return provDiagMust;
	}

	/**
	 * Set the value related to the column: prov_diag_must
	 * @param provDiagMust the prov_diag_must value
	 */
	public void setProvDiagMust (java.lang.Integer provDiagMust) {
		this.provDiagMust = provDiagMust;
	}



	/**
	 * Return the value associated with the column: bill_print_type
	 */
	public java.lang.Integer getBillPrintType () {
		return billPrintType;
	}

	/**
	 * Set the value related to the column: bill_print_type
	 * @param billPrintType the bill_print_type value
	 */
	public void setBillPrintType (java.lang.Integer billPrintType) {
		this.billPrintType = billPrintType;
	}



	/**
	 * Return the value associated with the column: allow_reg_fee
	 */
	public java.lang.Integer getAllowRegFee () {
		return allowRegFee;
	}

	/**
	 * Set the value related to the column: allow_reg_fee
	 * @param allowRegFee the allow_reg_fee value
	 */
	public void setAllowRegFee (java.lang.Integer allowRegFee) {
		this.allowRegFee = allowRegFee;
	}



	/**
	 * Return the value associated with the column: allow_refund
	 */
	public java.lang.Integer getAllowRefund () {
		return allowRefund;
	}

	/**
	 * Set the value related to the column: allow_refund
	 * @param allowRefund the allow_refund value
	 */
	public void setAllowRefund (java.lang.Integer allowRefund) {
		this.allowRefund = allowRefund;
	}



	/**
	 * Return the value associated with the column: marquee_text
	 */
	public java.lang.String getMarqueeText () {
		return marqueeText;
	}

	/**
	 * Set the value related to the column: marquee_text
	 * @param marqueeText the marquee_text value
	 */
	public void setMarqueeText (java.lang.String marqueeText) {
		this.marqueeText = marqueeText;
	}



	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate () {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * @param lastChangedDate the last_changed_date value
	 */
	public void setLastChangedDate (java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}



	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime () {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * @param lastChangedTime the last_changed_time value
	 */
	public void setLastChangedTime (java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}



	/**
	 * Return the value associated with the column: registration_validity_policy
	 */
	public java.lang.Integer getRegistrationValidityPolicy () {
		return registrationValidityPolicy;
	}

	/**
	 * Set the value related to the column: registration_validity_policy
	 * @param registrationValidityPolicy the registration_validity_policy value
	 */
	public void setRegistrationValidityPolicy (java.lang.Integer registrationValidityPolicy) {
		this.registrationValidityPolicy = registrationValidityPolicy;
	}



	/**
	 * Return the value associated with the column: reg_policy_period
	 */
	public java.lang.Integer getRegPolicyPeriod () {
		return regPolicyPeriod;
	}

	/**
	 * Set the value related to the column: reg_policy_period
	 * @param regPolicyPeriod the reg_policy_period value
	 */
	public void setRegPolicyPeriod (java.lang.Integer regPolicyPeriod) {
		this.regPolicyPeriod = regPolicyPeriod;
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
	 * Return the value associated with the column: address_line_2
	 */
	public java.lang.String getAddressLine2 () {
		return addressLine2;
	}

	/**
	 * Set the value related to the column: address_line_2
	 * @param addressLine2 the address_line_2 value
	 */
	public void setAddressLine2 (java.lang.String addressLine2) {
		this.addressLine2 = addressLine2;
	}



	/**
	 * Return the value associated with the column: allow_dischrg_without_clrnc
	 */
	public java.lang.Integer getAllowDischrgWithoutClrnc () {
		return allowDischrgWithoutClrnc;
	}

	/**
	 * Set the value related to the column: allow_dischrg_without_clrnc
	 * @param allowDischrgWithoutClrnc the allow_dischrg_without_clrnc value
	 */
	public void setAllowDischrgWithoutClrnc (java.lang.Integer allowDischrgWithoutClrnc) {
		this.allowDischrgWithoutClrnc = allowDischrgWithoutClrnc;
	}



	/**
	 * Return the value associated with the column: allow_op_advance
	 */
	public java.lang.Integer getAllowOpAdvance () {
		return allowOpAdvance;
	}

	/**
	 * Set the value related to the column: allow_op_advance
	 * @param allowOpAdvance the allow_op_advance value
	 */
	public void setAllowOpAdvance (java.lang.Integer allowOpAdvance) {
		this.allowOpAdvance = allowOpAdvance;
	}



	/**
	 * Return the value associated with the column: daily_charge_calculation
	 */
	public java.lang.String getDailyChargeCalculation () {
		return dailyChargeCalculation;
	}

	/**
	 * Set the value related to the column: daily_charge_calculation
	 * @param dailyChargeCalculation the daily_charge_calculation value
	 */
	public void setDailyChargeCalculation (java.lang.String dailyChargeCalculation) {
		this.dailyChargeCalculation = dailyChargeCalculation;
	}



	/**
	 * Return the value associated with the column: charge_calculation_type
	 */
	public java.lang.String getChargeCalculationType () {
		return chargeCalculationType;
	}

	/**
	 * Set the value related to the column: charge_calculation_type
	 * @param chargeCalculationType the charge_calculation_type value
	 */
	public void setChargeCalculationType (java.lang.String chargeCalculationType) {
		this.chargeCalculationType = chargeCalculationType;
	}



	/**
	 * Return the value associated with the column: calculation_time
	 */
	public java.lang.String getCalculationTime () {
		return calculationTime;
	}

	/**
	 * Set the value related to the column: calculation_time
	 * @param calculationTime the calculation_time value
	 */
	public void setCalculationTime (java.lang.String calculationTime) {
		this.calculationTime = calculationTime;
	}



	/**
	 * Return the value associated with the column: nursing_care_calculation
	 */
	public java.lang.String getNursingCareCalculation () {
		return nursingCareCalculation;
	}

	/**
	 * Set the value related to the column: nursing_care_calculation
	 * @param nursingCareCalculation the nursing_care_calculation value
	 */
	public void setNursingCareCalculation (java.lang.String nursingCareCalculation) {
		this.nursingCareCalculation = nursingCareCalculation;
	}



	/**
	 * Return the value associated with the column: last_processed_date
	 */
	public java.util.Date getLastProcessedDate () {
		return lastProcessedDate;
	}

	/**
	 * Set the value related to the column: last_processed_date
	 * @param lastProcessedDate the last_processed_date value
	 */
	public void setLastProcessedDate (java.util.Date lastProcessedDate) {
		this.lastProcessedDate = lastProcessedDate;
	}



	/**
	 * Return the value associated with the column: block
	 */
	public java.lang.String getBlock () {
		return block;
	}

	/**
	 * Set the value related to the column: block
	 * @param block the block value
	 */
	public void setBlock (java.lang.String block) {
		this.block = block;
	}



	/**
	 * Return the value associated with the column: postOffice
	 */
	public java.lang.String getPostOffice () {
		return postOffice;
	}

	/**
	 * Set the value related to the column: postOffice
	 * @param postOffice the postOffice value
	 */
	public void setPostOffice (java.lang.String postOffice) {
		this.postOffice = postOffice;
	}



	/**
	 * Return the value associated with the column: dispensing_required
	 */
	public java.lang.String getDispensingRequired () {
		return dispensingRequired;
	}

	/**
	 * Set the value related to the column: dispensing_required
	 * @param dispensingRequired the dispensing_required value
	 */
	public void setDispensingRequired (java.lang.String dispensingRequired) {
		this.dispensingRequired = dispensingRequired;
	}



	/**
	 * Return the value associated with the column: dept_id_store_code_rks
	 */
	public java.lang.Integer getDeptIdStoreCodeRKS () {
		return deptIdStoreCodeRKS;
	}

	/**
	 * Set the value related to the column: dept_id_store_code_rks
	 * @param deptIdStoreCodeRKS the dept_id_store_code_rks value
	 */
	public void setDeptIdStoreCodeRKS (java.lang.Integer deptIdStoreCodeRKS) {
		this.deptIdStoreCodeRKS = deptIdStoreCodeRKS;
	}



	/**
	 * Return the value associated with the column: dept_id_store_code_vbch
	 */
	public java.lang.Integer getDeptIdStoreCodeVBCH () {
		return deptIdStoreCodeVBCH;
	}

	/**
	 * Set the value related to the column: dept_id_store_code_vbch
	 * @param deptIdStoreCodeVBCH the dept_id_store_code_vbch value
	 */
	public void setDeptIdStoreCodeVBCH (java.lang.Integer deptIdStoreCodeVBCH) {
		this.deptIdStoreCodeVBCH = deptIdStoreCodeVBCH;
	}



	/**
	 * Return the value associated with the column: dept_id_store_code_nursing_college
	 */
	public java.lang.Integer getDeptIdStoreCodeNursingCollege () {
		return deptIdStoreCodeNursingCollege;
	}

	/**
	 * Set the value related to the column: dept_id_store_code_nursing_college
	 * @param deptIdStoreCodeNursingCollege the dept_id_store_code_nursing_college value
	 */
	public void setDeptIdStoreCodeNursingCollege (java.lang.Integer deptIdStoreCodeNursingCollege) {
		this.deptIdStoreCodeNursingCollege = deptIdStoreCodeNursingCollege;
	}



	/**
	 * Return the value associated with the column: dept_id_store_code_sickel_anemia
	 */
	public java.lang.Integer getDeptIdStoreCodeSickel () {
		return deptIdStoreCodeSickel;
	}

	/**
	 * Set the value related to the column: dept_id_store_code_sickel_anemia
	 * @param deptIdStoreCodeSickel the dept_id_store_code_sickel_anemia value
	 */
	public void setDeptIdStoreCodeSickel (java.lang.Integer deptIdStoreCodeSickel) {
		this.deptIdStoreCodeSickel = deptIdStoreCodeSickel;
	}



	/**
	 * Return the value associated with the column: diet_scheduling
	 */
	public java.lang.String getDietScheduling () {
		return dietScheduling;
	}

	/**
	 * Set the value related to the column: diet_scheduling
	 * @param dietScheduling the diet_scheduling value
	 */
	public void setDietScheduling (java.lang.String dietScheduling) {
		this.dietScheduling = dietScheduling;
	}



	/**
	 * Return the value associated with the column: dept_id_khanvel
	 */
	public java.lang.Integer getDeptIdStoreCodeKhanvel () {
		return deptIdStoreCodeKhanvel;
	}

	/**
	 * Set the value related to the column: dept_id_khanvel
	 * @param deptIdStoreCodeKhanvel the dept_id_khanvel value
	 */
	public void setDeptIdStoreCodeKhanvel (java.lang.Integer deptIdStoreCodeKhanvel) {
		this.deptIdStoreCodeKhanvel = deptIdStoreCodeKhanvel;
	}



	/**
	 * Return the value associated with the column: dept_id_dhms
	 */
	public java.lang.Integer getDeptIdStoreCodeDhms () {
		return deptIdStoreCodeDhms;
	}

	/**
	 * Set the value related to the column: dept_id_dhms
	 * @param deptIdStoreCodeDhms the dept_id_dhms value
	 */
	public void setDeptIdStoreCodeDhms (java.lang.Integer deptIdStoreCodeDhms) {
		this.deptIdStoreCodeDhms = deptIdStoreCodeDhms;
	}



	/**
	 * Return the value associated with the column: city_id
	 */
	public jkt.hms.masters.business.MasDistrict getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * @param city the city_id value
	 */
	public void setCity (jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: currency_id
	 */
	public jkt.hms.masters.business.MasCurrency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency_id
	 * @param currency the currency_id value
	 */
	public void setCurrency (jkt.hms.masters.business.MasCurrency currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: last_changed_by_id
	 */
	public jkt.hms.masters.business.Users getLastChangedBy () {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by_id
	 * @param lastChangedBy the last_changed_by_id value
	 */
	public void setLastChangedBy (jkt.hms.masters.business.Users lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
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
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param country the country_id value
	 */
	public void setCountry (jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HospitalParameters)) return false;
		else {
			jkt.hms.masters.business.HospitalParameters hospitalParameters = (jkt.hms.masters.business.HospitalParameters) obj;
			if (null == this.getId() || null == hospitalParameters.getId()) return false;
			else return (this.getId().equals(hospitalParameters.getId()));
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