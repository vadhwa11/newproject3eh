package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_discount table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_discount"
 */

public abstract class BaseMasDiscount  implements Serializable {

	public static String REF = "MasDiscount";
	public static String PROP_ITEM_CLASS = "ItemClass";
	public static String PROP_FIXED_VALUE = "FixedValue";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TO_AGE = "ToAge";
	public static String PROP_FROM_AGE = "FromAge";
	public static String PROP_GROUP = "Group";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_EFFECTIVE_DATE_FROM = "EffectiveDateFrom";
	public static String PROP_EMPLOYEE_DEPENDENT = "EmployeeDependent";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_ITEM_TYPE = "ItemType";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_ROOM_TYPE = "RoomType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_OTHER_CATEGORY = "OtherCategory";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_BPL_STATUS = "BplStatus";
	public static String PROP_RSBY_CARD = "RsbyCard";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EFFECTIVE_DATE_TO = "EffectiveDateTo";
	public static String PROP_STATUS = "Status";
	public static String PROP_INSURANCE_AMT = "InsuranceAmt";
	public static String PROP_ACCOUNT_ID = "AccountId";
	public static String PROP_ITEM_CATEGORY = "ItemCategory";
	public static String PROP_ID = "Id";
	public static String PROP_ITEM_SECTION = "ItemSection";
	public static String PROP_DISCOUNT_PERCENTAGE = "DiscountPercentage";
	public static String PROP_BILL_TYPE = "BillType";
	public static String PROP_DISCOUNT_TYPE = "DiscountType";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_DISCOUNT_VALUE = "DiscountValue";


	// constructors
	public BaseMasDiscount () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDiscount (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer accountId;
	private java.lang.String bplStatus;
	private java.math.BigDecimal discountPercentage;
	private java.lang.String discountType;
	private java.math.BigDecimal discountValue;
	private java.util.Date effectiveDateFrom;
	private java.util.Date effectiveDateTo;
	private java.math.BigDecimal fixedValue;
	private java.math.BigDecimal fromAge;
	private java.math.BigDecimal insuranceAmt;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String patientCategory;
	private java.lang.String rsbyCard;
	private java.lang.String status;
	private java.math.BigDecimal toAge;

	// many to one
	private jkt.hms.masters.business.MasBillType billType;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasEmployeeDependent employeeDependent;
	private jkt.hms.masters.business.MasStoreGroup group;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasItemCategory itemCategory;
	private jkt.hms.masters.business.MasItemClass itemClass;
	private jkt.hms.masters.business.MasStoreSection itemSection;
	private jkt.hms.masters.business.MasItemType itemType;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.MasPatientType otherCategory;
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasRoomType roomType;
	private jkt.hms.masters.business.MasScheme scheme;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="discount_id"
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
	 * Return the value associated with the column: account_id
	 */
	public java.lang.Integer getAccountId () {
		return accountId;
	}

	/**
	 * Set the value related to the column: account_id
	 * @param accountId the account_id value
	 */
	public void setAccountId (java.lang.Integer accountId) {
		this.accountId = accountId;
	}



	/**
	 * Return the value associated with the column: bpl_status
	 */
	public java.lang.String getBplStatus () {
		return bplStatus;
	}

	/**
	 * Set the value related to the column: bpl_status
	 * @param bplStatus the bpl_status value
	 */
	public void setBplStatus (java.lang.String bplStatus) {
		this.bplStatus = bplStatus;
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
	 * Return the value associated with the column: discount_type
	 */
	public java.lang.String getDiscountType () {
		return discountType;
	}

	/**
	 * Set the value related to the column: discount_type
	 * @param discountType the discount_type value
	 */
	public void setDiscountType (java.lang.String discountType) {
		this.discountType = discountType;
	}



	/**
	 * Return the value associated with the column: discount_value
	 */
	public java.math.BigDecimal getDiscountValue () {
		return discountValue;
	}

	/**
	 * Set the value related to the column: discount_value
	 * @param discountValue the discount_value value
	 */
	public void setDiscountValue (java.math.BigDecimal discountValue) {
		this.discountValue = discountValue;
	}



	/**
	 * Return the value associated with the column: effective_date_from
	 */
	public java.util.Date getEffectiveDateFrom () {
		return effectiveDateFrom;
	}

	/**
	 * Set the value related to the column: effective_date_from
	 * @param effectiveDateFrom the effective_date_from value
	 */
	public void setEffectiveDateFrom (java.util.Date effectiveDateFrom) {
		this.effectiveDateFrom = effectiveDateFrom;
	}



	/**
	 * Return the value associated with the column: effective_date_to
	 */
	public java.util.Date getEffectiveDateTo () {
		return effectiveDateTo;
	}

	/**
	 * Set the value related to the column: effective_date_to
	 * @param effectiveDateTo the effective_date_to value
	 */
	public void setEffectiveDateTo (java.util.Date effectiveDateTo) {
		this.effectiveDateTo = effectiveDateTo;
	}



	/**
	 * Return the value associated with the column: fixed_value
	 */
	public java.math.BigDecimal getFixedValue () {
		return fixedValue;
	}

	/**
	 * Set the value related to the column: fixed_value
	 * @param fixedValue the fixed_value value
	 */
	public void setFixedValue (java.math.BigDecimal fixedValue) {
		this.fixedValue = fixedValue;
	}



	/**
	 * Return the value associated with the column: from_age
	 */
	public java.math.BigDecimal getFromAge () {
		return fromAge;
	}

	/**
	 * Set the value related to the column: from_age
	 * @param fromAge the from_age value
	 */
	public void setFromAge (java.math.BigDecimal fromAge) {
		this.fromAge = fromAge;
	}



	/**
	 * Return the value associated with the column: insurance_amt
	 */
	public java.math.BigDecimal getInsuranceAmt () {
		return insuranceAmt;
	}

	/**
	 * Set the value related to the column: insurance_amt
	 * @param insuranceAmt the insurance_amt value
	 */
	public void setInsuranceAmt (java.math.BigDecimal insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
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
	 * Return the value associated with the column: patient_category
	 */
	public java.lang.String getPatientCategory () {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category
	 * @param patientCategory the patient_category value
	 */
	public void setPatientCategory (java.lang.String patientCategory) {
		this.patientCategory = patientCategory;
	}



	/**
	 * Return the value associated with the column: rsby_card
	 */
	public java.lang.String getRsbyCard () {
		return rsbyCard;
	}

	/**
	 * Set the value related to the column: rsby_card
	 * @param rsbyCard the rsby_card value
	 */
	public void setRsbyCard (java.lang.String rsbyCard) {
		this.rsbyCard = rsbyCard;
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
	 * Return the value associated with the column: to_age
	 */
	public java.math.BigDecimal getToAge () {
		return toAge;
	}

	/**
	 * Set the value related to the column: to_age
	 * @param toAge the to_age value
	 */
	public void setToAge (java.math.BigDecimal toAge) {
		this.toAge = toAge;
	}



	/**
	 * Return the value associated with the column: bill_type_id
	 */
	public jkt.hms.masters.business.MasBillType getBillType () {
		return billType;
	}

	/**
	 * Set the value related to the column: bill_type_id
	 * @param billType the bill_type_id value
	 */
	public void setBillType (jkt.hms.masters.business.MasBillType billType) {
		this.billType = billType;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasCompany company) {
		this.company = company;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: employee_dependent_id
	 */
	public jkt.hms.masters.business.MasEmployeeDependent getEmployeeDependent () {
		return employeeDependent;
	}

	/**
	 * Set the value related to the column: employee_dependent_id
	 * @param employeeDependent the employee_dependent_id value
	 */
	public void setEmployeeDependent (jkt.hms.masters.business.MasEmployeeDependent employeeDependent) {
		this.employeeDependent = employeeDependent;
	}



	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: item_category_id
	 */
	public jkt.hms.masters.business.MasItemCategory getItemCategory () {
		return itemCategory;
	}

	/**
	 * Set the value related to the column: item_category_id
	 * @param itemCategory the item_category_id value
	 */
	public void setItemCategory (jkt.hms.masters.business.MasItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}



	/**
	 * Return the value associated with the column: item_class_id
	 */
	public jkt.hms.masters.business.MasItemClass getItemClass () {
		return itemClass;
	}

	/**
	 * Set the value related to the column: item_class_id
	 * @param itemClass the item_class_id value
	 */
	public void setItemClass (jkt.hms.masters.business.MasItemClass itemClass) {
		this.itemClass = itemClass;
	}



	/**
	 * Return the value associated with the column: item_section_id
	 */
	public jkt.hms.masters.business.MasStoreSection getItemSection () {
		return itemSection;
	}

	/**
	 * Set the value related to the column: item_section_id
	 * @param itemSection the item_section_id value
	 */
	public void setItemSection (jkt.hms.masters.business.MasStoreSection itemSection) {
		this.itemSection = itemSection;
	}



	/**
	 * Return the value associated with the column: item_type_id
	 */
	public jkt.hms.masters.business.MasItemType getItemType () {
		return itemType;
	}

	/**
	 * Set the value related to the column: item_type_id
	 * @param itemType the item_type_id value
	 */
	public void setItemType (jkt.hms.masters.business.MasItemType itemType) {
		this.itemType = itemType;
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
	 * Return the value associated with the column: other_category_id
	 */
	public jkt.hms.masters.business.MasPatientType getOtherCategory () {
		return otherCategory;
	}

	/**
	 * Set the value related to the column: other_category_id
	 * @param otherCategory the other_category_id value
	 */
	public void setOtherCategory (jkt.hms.masters.business.MasPatientType otherCategory) {
		this.otherCategory = otherCategory;
	}



	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * @param patientType the patient_type_id value
	 */
	public void setPatientType (jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: room_type_id
	 */
	public jkt.hms.masters.business.MasRoomType getRoomType () {
		return roomType;
	}

	/**
	 * Set the value related to the column: room_type_id
	 * @param roomType the room_type_id value
	 */
	public void setRoomType (jkt.hms.masters.business.MasRoomType roomType) {
		this.roomType = roomType;
	}



	/**
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDiscount)) return false;
		else {
			jkt.hms.masters.business.MasDiscount masDiscount = (jkt.hms.masters.business.MasDiscount) obj;
			if (null == this.getId() || null == masDiscount.getId()) return false;
			else return (this.getId().equals(masDiscount.getId()));
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