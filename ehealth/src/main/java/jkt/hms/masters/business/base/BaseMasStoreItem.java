package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_item"
 */

public abstract class BaseMasStoreItem  implements Serializable {

	public static String REF = "MasStoreItem";
	public static String PROP_BRAND = "Brand";
	public static String PROP_STANDARD_AVAILABILITY = "StandardAvailability";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PVMS_NO = "PvmsNo";
	public static String PROP_SPECIFICATION = "Specification";
	public static String PROP_VED = "Ved";
	public static String PROP_GROUP = "Group";
	public static String PROP_SLOW_MOVING_DAYS = "SlowMovingDays";
	public static String PROP_TEMPRATURE = "Temprature";
	public static String PROP_PH_ITEM = "PhItem";
	public static String PROP_MIXTURE_UNIT = "MixtureUnit";
	public static String PROP_CONTROLLED_DRUG = "ControlledDrug";
	public static String PROP_ESSENTIAL_DRUG = "EssentialDrug";
	public static String PROP_PAC = "Pac";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ROUTE = "Route";
	public static String PROP_SNOMEDCT_CODE = "SnomedctCode";
	public static String PROP_BAG_QUANTITY = "BagQuantity";
	public static String PROP_ROL = "Rol";
	public static String PROP_REFFRED_BY = "ReffredBy";
	public static String PROP_ALLERGY = "Allergy";
	public static String PROP_MIN_STOCK = "MinStock";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_KMSCL_ITEM_CODE = "KmsclItemCode";
	public static String PROP_DILUTEABLE = "Diluteable";
	public static String PROP_EXPIRY_DAYS = "ExpiryDays";
	public static String PROP_LEAD_TIME = "LeadTime";
	public static String PROP_EMERGENCY_ITEM = "EmergencyItem";
	public static String PROP_ITEM_GENERIC = "ItemGeneric";
	public static String PROP_TAPERED = "Tapered";
	public static String PROP_SOPHISTICATED_ITEM = "SophisticatedItem";
	public static String PROP_CSSD_ITEM = "CssdItem";
	public static String PROP_RATE_CONTRACT_ITEM = "RateContractItem";
	public static String PROP_TEMPRATURE_MIN = "TempratureMin";
	public static String PROP_CREATED_ON = "CreatedOn";
	public static String PROP_ID = "Id";
	public static String PROP_WHO_ATC_CODE = "WhoAtcCode";
	public static String PROP_SALEBLE = "Saleble";
	public static String PROP_DILUTE_LIQUID_QUANTITY = "DiluteLiquidQuantity";
	public static String PROP_KMSCL_CATEGORY = "KmsclCategory";
	public static String PROP_SUB_ACCOUNT_GROUP = "SubAccountGroup";
	public static String PROP_NOMENCLATURE = "Nomenclature";
	public static String PROP_INSULIN_INJECTION = "InsulinInjection";
	public static String PROP_OLD_NIV_NO = "OldNivNo";
	public static String PROP_ITEM_CLASS = "ItemClass";
	public static String PROP_ITEM_CONVERSION = "ItemConversion";
	public static String PROP_MIXABLE = "Mixable";
	public static String PROP_DANGEROUS_DRUG = "DangerousDrug";
	public static String PROP_SALES_TAX = "SalesTax";
	public static String PROP_SELF_LIFE = "SelfLife";
	public static String PROP_DISP_UNIT = "DispUnit";
	public static String PROP_SOURCE_OF_SUPPLY = "SourceOfSupply";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_A_DISP_QTY = "ADispQty";
	public static String PROP_ITEM_TYPE = "ItemType";
	public static String PROP_ABC = "Abc";
	public static String PROP_MIXTURE_QUANTITY = "MixtureQuantity";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_OTC_TYPE = "OtcType";
	public static String PROP_COMMON_NAME = "CommonName";
	public static String PROP_PHARMA_INDEX = "PharmaIndex";
	public static String PROP_NON_PAC = "NonPac";
	public static String PROP_MAX_STOCK = "MaxStock";
	public static String PROP_LOCATION = "Location";
	public static String PROP_EXPIRY = "Expiry";
	public static String PROP_NON_MOVING_DAYS = "NonMovingDays";
	public static String PROP_SECTION = "Section";
	public static String PROP_ACCOUNT_GROUP = "AccountGroup";
	public static String PROP_STATUS = "Status";
	public static String PROP_STRENGTH = "Strength";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_FAST_MOVING_DAYS = "FastMovingDays";
	public static String PROP_TEMPRATURE_MAX = "TempratureMax";
	public static String PROP_ITEM_CATEGORY = "ItemCategory";
	public static String PROP_SALE_TAX = "SaleTax";
	public static String PROP_COST_PRICE = "CostPrice";
	public static String PROP_HIGH_VALUE_DRUG = "HighValueDrug";


	// constructors
	public BaseMasStoreItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreItem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pvmsNo;
	private java.lang.String nomenclature;
	private java.math.BigDecimal costPrice;
	private java.lang.String dangerousDrug;
	private java.lang.String pac;
	private java.lang.String controlledDrug;
	private java.lang.String highValueDrug;
	private java.math.BigDecimal salesTax;
	private java.lang.String rateContractItem;
	private java.lang.String rol;
	private java.math.BigDecimal maxStock;
	private java.math.BigDecimal minStock;
	private java.lang.String selfLife;
	private java.lang.String leadTime;
	private java.lang.String location;
	private java.lang.String specification;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String oldNivNo;
	private java.lang.String nonPac;
	private java.lang.String sourceOfSupply;
	private java.lang.Integer slowMovingDays;
	private java.lang.Integer fastMovingDays;
	private java.lang.Integer nonMovingDays;
	private java.lang.String strength;
	private java.lang.String expiry;
	private java.lang.String allergy;
	private java.lang.String sophisticatedItem;
	private java.lang.String emergencyItem;
	private java.lang.String saleble;
	private java.lang.String temprature;
	private java.util.Date createdOn;
	private java.lang.String essentialDrug;
	private java.lang.String cssdItem;
	private java.lang.String ved;
	private java.lang.String abc;
	private java.math.BigDecimal tempratureMin;
	private java.math.BigDecimal tempratureMax;
	private java.lang.String standardAvailability;
	private java.lang.String commonName;
	private java.lang.String otcType;
	private java.lang.String kmsclItemCode;
	private java.lang.String dispUnit;
	private java.math.BigDecimal aDispQty;
	private java.lang.String kmsclCategory;
	private java.lang.String insulinInjection;
	private java.lang.String bagQuantity;
	private java.lang.Integer expiryDays;
	private java.lang.Integer snomedctCode;
	private java.lang.String whoAtcCode;
	private java.lang.String phItem;
	private java.lang.String diluteable;
	private java.lang.Integer diluteLiquidQuantity;
	private java.lang.String mixable;
	private java.lang.Integer mixtureQuantity;
	private java.lang.String mixtureUnit;
	private java.lang.String tapered;

	// many to one
	private jkt.hms.masters.business.MasEmployee reffredBy;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreItemConversion itemConversion;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreGroup group;
	private jkt.hms.masters.business.FaMasAccountGroup accountGroup;
	private jkt.hms.masters.business.MasStoreSection section;
	private jkt.hms.masters.business.FaMasAccountSubGroup subAccountGroup;
	private jkt.hms.masters.business.MasStoreItemGeneric itemGeneric;
	private jkt.hms.masters.business.MasItemType itemType;
	private jkt.hms.masters.business.MasSalesTaxType saleTax;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.RouteOfAdministration route;
	private jkt.hms.masters.business.MasStorePharmaIndex pharmaIndex;
	private jkt.hms.masters.business.MasItemCategory itemCategory;
	private jkt.hms.masters.business.MasItemClass itemClass;
	private jkt.hms.masters.business.MasManufacturer manufacturer;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> storeTenderTechnicalBidTs;
	private java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> storeWorkOrderTs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;
	private java.util.Set<jkt.hms.masters.business.StoreAmcM> storeAmcMs;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers;
	private java.util.Set<jkt.hms.masters.business.StoreTenderProposal> storeTenderProposals;
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> storeQuaterReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs;
	private java.util.Set<jkt.hms.masters.business.StoreSoc> storeSocs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> storeGrnReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdRequire;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdIssue;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs;
	private java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails;
	private java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> masStoreItemTemplates;
	private java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks;
	private java.util.Set<jkt.hms.masters.business.StoreDisposalT> storeDisposalTs;
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> storeMmfDepartmentTs;
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> storeAdjustmentTs;
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationT> storeCondemnationTs;
	private java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> storeRepairCivilFirms;
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;
	private java.util.Set<jkt.hms.masters.business.StoreBosT> storeBosTs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItemIssued;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItem;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs;
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs;
	private java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands;
	private java.util.Set<jkt.hms.masters.business.StoreTenderT> storeTenderTs;
	private java.util.Set<jkt.hms.masters.business.MasStoreItemDetails> masStoreItemDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="item_id"
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
	 * Return the value associated with the column: pvms_no
	 */
	public java.lang.String getPvmsNo () {
		return pvmsNo;
	}

	/**
	 * Set the value related to the column: pvms_no
	 * @param pvmsNo the pvms_no value
	 */
	public void setPvmsNo (java.lang.String pvmsNo) {
		this.pvmsNo = pvmsNo;
	}



	/**
	 * Return the value associated with the column: nomenclature
	 */
	public java.lang.String getNomenclature () {
		return nomenclature;
	}

	/**
	 * Set the value related to the column: nomenclature
	 * @param nomenclature the nomenclature value
	 */
	public void setNomenclature (java.lang.String nomenclature) {
		this.nomenclature = nomenclature;
	}



	/**
	 * Return the value associated with the column: cost_price
	 */
	public java.math.BigDecimal getCostPrice () {
		return costPrice;
	}

	/**
	 * Set the value related to the column: cost_price
	 * @param costPrice the cost_price value
	 */
	public void setCostPrice (java.math.BigDecimal costPrice) {
		this.costPrice = costPrice;
	}



	/**
	 * Return the value associated with the column: dangerous_drug
	 */
	public java.lang.String getDangerousDrug () {
		return dangerousDrug;
	}

	/**
	 * Set the value related to the column: dangerous_drug
	 * @param dangerousDrug the dangerous_drug value
	 */
	public void setDangerousDrug (java.lang.String dangerousDrug) {
		this.dangerousDrug = dangerousDrug;
	}



	/**
	 * Return the value associated with the column: pac
	 */
	public java.lang.String getPac () {
		return pac;
	}

	/**
	 * Set the value related to the column: pac
	 * @param pac the pac value
	 */
	public void setPac (java.lang.String pac) {
		this.pac = pac;
	}



	/**
	 * Return the value associated with the column: controlled_drug
	 */
	public java.lang.String getControlledDrug () {
		return controlledDrug;
	}

	/**
	 * Set the value related to the column: controlled_drug
	 * @param controlledDrug the controlled_drug value
	 */
	public void setControlledDrug (java.lang.String controlledDrug) {
		this.controlledDrug = controlledDrug;
	}



	/**
	 * Return the value associated with the column: high_value_drug
	 */
	public java.lang.String getHighValueDrug () {
		return highValueDrug;
	}

	/**
	 * Set the value related to the column: high_value_drug
	 * @param highValueDrug the high_value_drug value
	 */
	public void setHighValueDrug (java.lang.String highValueDrug) {
		this.highValueDrug = highValueDrug;
	}



	/**
	 * Return the value associated with the column: sales_tax
	 */
	public java.math.BigDecimal getSalesTax () {
		return salesTax;
	}

	/**
	 * Set the value related to the column: sales_tax
	 * @param salesTax the sales_tax value
	 */
	public void setSalesTax (java.math.BigDecimal salesTax) {
		this.salesTax = salesTax;
	}



	/**
	 * Return the value associated with the column: rate_contract_item
	 */
	public java.lang.String getRateContractItem () {
		return rateContractItem;
	}

	/**
	 * Set the value related to the column: rate_contract_item
	 * @param rateContractItem the rate_contract_item value
	 */
	public void setRateContractItem (java.lang.String rateContractItem) {
		this.rateContractItem = rateContractItem;
	}



	/**
	 * Return the value associated with the column: rol
	 */
	public java.lang.String getRol () {
		return rol;
	}

	/**
	 * Set the value related to the column: rol
	 * @param rol the rol value
	 */
	public void setRol (java.lang.String rol) {
		this.rol = rol;
	}



	/**
	 * Return the value associated with the column: max_stock
	 */
	public java.math.BigDecimal getMaxStock () {
		return maxStock;
	}

	/**
	 * Set the value related to the column: max_stock
	 * @param maxStock the max_stock value
	 */
	public void setMaxStock (java.math.BigDecimal maxStock) {
		this.maxStock = maxStock;
	}



	/**
	 * Return the value associated with the column: min_stock
	 */
	public java.math.BigDecimal getMinStock () {
		return minStock;
	}

	/**
	 * Set the value related to the column: min_stock
	 * @param minStock the min_stock value
	 */
	public void setMinStock (java.math.BigDecimal minStock) {
		this.minStock = minStock;
	}



	/**
	 * Return the value associated with the column: self_life
	 */
	public java.lang.String getSelfLife () {
		return selfLife;
	}

	/**
	 * Set the value related to the column: self_life
	 * @param selfLife the self_life value
	 */
	public void setSelfLife (java.lang.String selfLife) {
		this.selfLife = selfLife;
	}



	/**
	 * Return the value associated with the column: lead_time
	 */
	public java.lang.String getLeadTime () {
		return leadTime;
	}

	/**
	 * Set the value related to the column: lead_time
	 * @param leadTime the lead_time value
	 */
	public void setLeadTime (java.lang.String leadTime) {
		this.leadTime = leadTime;
	}



	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * @param location the location value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: specification
	 */
	public java.lang.String getSpecification () {
		return specification;
	}

	/**
	 * Set the value related to the column: specification
	 * @param specification the specification value
	 */
	public void setSpecification (java.lang.String specification) {
		this.specification = specification;
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
	 * Return the value associated with the column: old_niv_no
	 */
	public java.lang.String getOldNivNo () {
		return oldNivNo;
	}

	/**
	 * Set the value related to the column: old_niv_no
	 * @param oldNivNo the old_niv_no value
	 */
	public void setOldNivNo (java.lang.String oldNivNo) {
		this.oldNivNo = oldNivNo;
	}



	/**
	 * Return the value associated with the column: non_pac
	 */
	public java.lang.String getNonPac () {
		return nonPac;
	}

	/**
	 * Set the value related to the column: non_pac
	 * @param nonPac the non_pac value
	 */
	public void setNonPac (java.lang.String nonPac) {
		this.nonPac = nonPac;
	}



	/**
	 * Return the value associated with the column: source_of_supply
	 */
	public java.lang.String getSourceOfSupply () {
		return sourceOfSupply;
	}

	/**
	 * Set the value related to the column: source_of_supply
	 * @param sourceOfSupply the source_of_supply value
	 */
	public void setSourceOfSupply (java.lang.String sourceOfSupply) {
		this.sourceOfSupply = sourceOfSupply;
	}



	/**
	 * Return the value associated with the column: slow_moving_days
	 */
	public java.lang.Integer getSlowMovingDays () {
		return slowMovingDays;
	}

	/**
	 * Set the value related to the column: slow_moving_days
	 * @param slowMovingDays the slow_moving_days value
	 */
	public void setSlowMovingDays (java.lang.Integer slowMovingDays) {
		this.slowMovingDays = slowMovingDays;
	}



	/**
	 * Return the value associated with the column: fast_moving_days
	 */
	public java.lang.Integer getFastMovingDays () {
		return fastMovingDays;
	}

	/**
	 * Set the value related to the column: fast_moving_days
	 * @param fastMovingDays the fast_moving_days value
	 */
	public void setFastMovingDays (java.lang.Integer fastMovingDays) {
		this.fastMovingDays = fastMovingDays;
	}



	/**
	 * Return the value associated with the column: non_moving_days
	 */
	public java.lang.Integer getNonMovingDays () {
		return nonMovingDays;
	}

	/**
	 * Set the value related to the column: non_moving_days
	 * @param nonMovingDays the non_moving_days value
	 */
	public void setNonMovingDays (java.lang.Integer nonMovingDays) {
		this.nonMovingDays = nonMovingDays;
	}



	/**
	 * Return the value associated with the column: strength
	 */
	public java.lang.String getStrength () {
		return strength;
	}

	/**
	 * Set the value related to the column: strength
	 * @param strength the strength value
	 */
	public void setStrength (java.lang.String strength) {
		this.strength = strength;
	}



	/**
	 * Return the value associated with the column: expiry
	 */
	public java.lang.String getExpiry () {
		return expiry;
	}

	/**
	 * Set the value related to the column: expiry
	 * @param expiry the expiry value
	 */
	public void setExpiry (java.lang.String expiry) {
		this.expiry = expiry;
	}



	/**
	 * Return the value associated with the column: allergy
	 */
	public java.lang.String getAllergy () {
		return allergy;
	}

	/**
	 * Set the value related to the column: allergy
	 * @param allergy the allergy value
	 */
	public void setAllergy (java.lang.String allergy) {
		this.allergy = allergy;
	}



	/**
	 * Return the value associated with the column: sophisticated_item
	 */
	public java.lang.String getSophisticatedItem () {
		return sophisticatedItem;
	}

	/**
	 * Set the value related to the column: sophisticated_item
	 * @param sophisticatedItem the sophisticated_item value
	 */
	public void setSophisticatedItem (java.lang.String sophisticatedItem) {
		this.sophisticatedItem = sophisticatedItem;
	}



	/**
	 * Return the value associated with the column: emergency_item
	 */
	public java.lang.String getEmergencyItem () {
		return emergencyItem;
	}

	/**
	 * Set the value related to the column: emergency_item
	 * @param emergencyItem the emergency_item value
	 */
	public void setEmergencyItem (java.lang.String emergencyItem) {
		this.emergencyItem = emergencyItem;
	}



	/**
	 * Return the value associated with the column: saleble
	 */
	public java.lang.String getSaleble () {
		return saleble;
	}

	/**
	 * Set the value related to the column: saleble
	 * @param saleble the saleble value
	 */
	public void setSaleble (java.lang.String saleble) {
		this.saleble = saleble;
	}



	/**
	 * Return the value associated with the column: temprature
	 */
	public java.lang.String getTemprature () {
		return temprature;
	}

	/**
	 * Set the value related to the column: temprature
	 * @param temprature the temprature value
	 */
	public void setTemprature (java.lang.String temprature) {
		this.temprature = temprature;
	}



	/**
	 * Return the value associated with the column: created_on
	 */
	public java.util.Date getCreatedOn () {
		return createdOn;
	}

	/**
	 * Set the value related to the column: created_on
	 * @param createdOn the created_on value
	 */
	public void setCreatedOn (java.util.Date createdOn) {
		this.createdOn = createdOn;
	}



	/**
	 * Return the value associated with the column: essential_drug
	 */
	public java.lang.String getEssentialDrug () {
		return essentialDrug;
	}

	/**
	 * Set the value related to the column: essential_drug
	 * @param essentialDrug the essential_drug value
	 */
	public void setEssentialDrug (java.lang.String essentialDrug) {
		this.essentialDrug = essentialDrug;
	}



	/**
	 * Return the value associated with the column: cssd_item
	 */
	public java.lang.String getCssdItem () {
		return cssdItem;
	}

	/**
	 * Set the value related to the column: cssd_item
	 * @param cssdItem the cssd_item value
	 */
	public void setCssdItem (java.lang.String cssdItem) {
		this.cssdItem = cssdItem;
	}



	/**
	 * Return the value associated with the column: ved
	 */
	public java.lang.String getVed () {
		return ved;
	}

	/**
	 * Set the value related to the column: ved
	 * @param ved the ved value
	 */
	public void setVed (java.lang.String ved) {
		this.ved = ved;
	}



	/**
	 * Return the value associated with the column: abc
	 */
	public java.lang.String getAbc () {
		return abc;
	}

	/**
	 * Set the value related to the column: abc
	 * @param abc the abc value
	 */
	public void setAbc (java.lang.String abc) {
		this.abc = abc;
	}



	/**
	 * Return the value associated with the column: temprature_min
	 */
	public java.math.BigDecimal getTempratureMin () {
		return tempratureMin;
	}

	/**
	 * Set the value related to the column: temprature_min
	 * @param tempratureMin the temprature_min value
	 */
	public void setTempratureMin (java.math.BigDecimal tempratureMin) {
		this.tempratureMin = tempratureMin;
	}



	/**
	 * Return the value associated with the column: temprature_max
	 */
	public java.math.BigDecimal getTempratureMax () {
		return tempratureMax;
	}

	/**
	 * Set the value related to the column: temprature_max
	 * @param tempratureMax the temprature_max value
	 */
	public void setTempratureMax (java.math.BigDecimal tempratureMax) {
		this.tempratureMax = tempratureMax;
	}



	/**
	 * Return the value associated with the column: standard_availability
	 */
	public java.lang.String getStandardAvailability () {
		return standardAvailability;
	}

	/**
	 * Set the value related to the column: standard_availability
	 * @param standardAvailability the standard_availability value
	 */
	public void setStandardAvailability (java.lang.String standardAvailability) {
		this.standardAvailability = standardAvailability;
	}



	/**
	 * Return the value associated with the column: common_name
	 */
	public java.lang.String getCommonName () {
		return commonName;
	}

	/**
	 * Set the value related to the column: common_name
	 * @param commonName the common_name value
	 */
	public void setCommonName (java.lang.String commonName) {
		this.commonName = commonName;
	}



	/**
	 * Return the value associated with the column: otc_type
	 */
	public java.lang.String getOtcType () {
		return otcType;
	}

	/**
	 * Set the value related to the column: otc_type
	 * @param otcType the otc_type value
	 */
	public void setOtcType (java.lang.String otcType) {
		this.otcType = otcType;
	}



	/**
	 * Return the value associated with the column: kmscl_item_code
	 */
	public java.lang.String getKmsclItemCode () {
		return kmsclItemCode;
	}

	/**
	 * Set the value related to the column: kmscl_item_code
	 * @param kmsclItemCode the kmscl_item_code value
	 */
	public void setKmsclItemCode (java.lang.String kmsclItemCode) {
		this.kmsclItemCode = kmsclItemCode;
	}



	/**
	 * Return the value associated with the column: disp_unit
	 */
	public java.lang.String getDispUnit () {
		return dispUnit;
	}

	/**
	 * Set the value related to the column: disp_unit
	 * @param dispUnit the disp_unit value
	 */
	public void setDispUnit (java.lang.String dispUnit) {
		this.dispUnit = dispUnit;
	}



	/**
	 * Return the value associated with the column: a_disp_qty
	 */
	public java.math.BigDecimal getADispQty () {
		return aDispQty;
	}

	/**
	 * Set the value related to the column: a_disp_qty
	 * @param aDispQty the a_disp_qty value
	 */
	public void setADispQty (java.math.BigDecimal aDispQty) {
		this.aDispQty = aDispQty;
	}



	/**
	 * Return the value associated with the column: kmscl_category
	 */
	public java.lang.String getKmsclCategory () {
		return kmsclCategory;
	}

	/**
	 * Set the value related to the column: kmscl_category
	 * @param kmsclCategory the kmscl_category value
	 */
	public void setKmsclCategory (java.lang.String kmsclCategory) {
		this.kmsclCategory = kmsclCategory;
	}



	/**
	 * Return the value associated with the column: insulin_injection
	 */
	public java.lang.String getInsulinInjection () {
		return insulinInjection;
	}

	/**
	 * Set the value related to the column: insulin_injection
	 * @param insulinInjection the insulin_injection value
	 */
	public void setInsulinInjection (java.lang.String insulinInjection) {
		this.insulinInjection = insulinInjection;
	}



	/**
	 * Return the value associated with the column: bag_quantity
	 */
	public java.lang.String getBagQuantity () {
		return bagQuantity;
	}

	/**
	 * Set the value related to the column: bag_quantity
	 * @param bagQuantity the bag_quantity value
	 */
	public void setBagQuantity (java.lang.String bagQuantity) {
		this.bagQuantity = bagQuantity;
	}



	/**
	 * Return the value associated with the column: expirydays
	 */
	public java.lang.Integer getExpiryDays () {
		return expiryDays;
	}

	/**
	 * Set the value related to the column: expirydays
	 * @param expiryDays the expirydays value
	 */
	public void setExpiryDays (java.lang.Integer expiryDays) {
		this.expiryDays = expiryDays;
	}



	/**
	 * Return the value associated with the column: snomedct_code
	 */
	public java.lang.Integer getSnomedctCode () {
		return snomedctCode;
	}

	/**
	 * Set the value related to the column: snomedct_code
	 * @param snomedctCode the snomedct_code value
	 */
	public void setSnomedctCode (java.lang.Integer snomedctCode) {
		this.snomedctCode = snomedctCode;
	}



	/**
	 * Return the value associated with the column: who_atc_code
	 */
	public java.lang.String getWhoAtcCode () {
		return whoAtcCode;
	}

	/**
	 * Set the value related to the column: who_atc_code
	 * @param whoAtcCode the who_atc_code value
	 */
	public void setWhoAtcCode (java.lang.String whoAtcCode) {
		this.whoAtcCode = whoAtcCode;
	}



	/**
	 * Return the value associated with the column: ph_item
	 */
	public java.lang.String getPhItem () {
		return phItem;
	}

	/**
	 * Set the value related to the column: ph_item
	 * @param phItem the ph_item value
	 */
	public void setPhItem (java.lang.String phItem) {
		this.phItem = phItem;
	}



	/**
	 * Return the value associated with the column: diluteable
	 */
	public java.lang.String getDiluteable () {
		return diluteable;
	}

	/**
	 * Set the value related to the column: diluteable
	 * @param diluteable the diluteable value
	 */
	public void setDiluteable (java.lang.String diluteable) {
		this.diluteable = diluteable;
	}



	/**
	 * Return the value associated with the column: dilute_liquid_quantity
	 */
	public java.lang.Integer getDiluteLiquidQuantity () {
		return diluteLiquidQuantity;
	}

	/**
	 * Set the value related to the column: dilute_liquid_quantity
	 * @param diluteLiquidQuantity the dilute_liquid_quantity value
	 */
	public void setDiluteLiquidQuantity (java.lang.Integer diluteLiquidQuantity) {
		this.diluteLiquidQuantity = diluteLiquidQuantity;
	}



	/**
	 * Return the value associated with the column: mixable
	 */
	public java.lang.String getMixable () {
		return mixable;
	}

	/**
	 * Set the value related to the column: mixable
	 * @param mixable the mixable value
	 */
	public void setMixable (java.lang.String mixable) {
		this.mixable = mixable;
	}



	/**
	 * Return the value associated with the column: mixture_quantity
	 */
	public java.lang.Integer getMixtureQuantity () {
		return mixtureQuantity;
	}

	/**
	 * Set the value related to the column: mixture_quantity
	 * @param mixtureQuantity the mixture_quantity value
	 */
	public void setMixtureQuantity (java.lang.Integer mixtureQuantity) {
		this.mixtureQuantity = mixtureQuantity;
	}



	/**
	 * Return the value associated with the column: mixture_unit
	 */
	public java.lang.String getMixtureUnit () {
		return mixtureUnit;
	}

	/**
	 * Set the value related to the column: mixture_unit
	 * @param mixtureUnit the mixture_unit value
	 */
	public void setMixtureUnit (java.lang.String mixtureUnit) {
		this.mixtureUnit = mixtureUnit;
	}



	/**
	 * Return the value associated with the column: tapered
	 */
	public java.lang.String getTapered () {
		return tapered;
	}

	/**
	 * Set the value related to the column: tapered
	 * @param tapered the tapered value
	 */
	public void setTapered (java.lang.String tapered) {
		this.tapered = tapered;
	}



	/**
	 * Return the value associated with the column: reffred_by
	 */
	public jkt.hms.masters.business.MasEmployee getReffredBy () {
		return reffredBy;
	}

	/**
	 * Set the value related to the column: reffred_by
	 * @param reffredBy the reffred_by value
	 */
	public void setReffredBy (jkt.hms.masters.business.MasEmployee reffredBy) {
		this.reffredBy = reffredBy;
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
	 * Return the value associated with the column: item_conversion_id
	 */
	public jkt.hms.masters.business.MasStoreItemConversion getItemConversion () {
		return itemConversion;
	}

	/**
	 * Set the value related to the column: item_conversion_id
	 * @param itemConversion the item_conversion_id value
	 */
	public void setItemConversion (jkt.hms.masters.business.MasStoreItemConversion itemConversion) {
		this.itemConversion = itemConversion;
	}



	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * @param supplier the supplier_id value
	 */
	public void setSupplier (jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
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
	 * Return the value associated with the column: brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getBrand () {
		return brand;
	}

	/**
	 * Set the value related to the column: brand_id
	 * @param brand the brand_id value
	 */
	public void setBrand (jkt.hms.masters.business.MasStoreBrand brand) {
		this.brand = brand;
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
	 * Return the value associated with the column: account_group
	 */
	public jkt.hms.masters.business.FaMasAccountGroup getAccountGroup () {
		return accountGroup;
	}

	/**
	 * Set the value related to the column: account_group
	 * @param accountGroup the account_group value
	 */
	public void setAccountGroup (jkt.hms.masters.business.FaMasAccountGroup accountGroup) {
		this.accountGroup = accountGroup;
	}



	/**
	 * Return the value associated with the column: section_id
	 */
	public jkt.hms.masters.business.MasStoreSection getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section_id
	 * @param section the section_id value
	 */
	public void setSection (jkt.hms.masters.business.MasStoreSection section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: sub_account_group
	 */
	public jkt.hms.masters.business.FaMasAccountSubGroup getSubAccountGroup () {
		return subAccountGroup;
	}

	/**
	 * Set the value related to the column: sub_account_group
	 * @param subAccountGroup the sub_account_group value
	 */
	public void setSubAccountGroup (jkt.hms.masters.business.FaMasAccountSubGroup subAccountGroup) {
		this.subAccountGroup = subAccountGroup;
	}



	/**
	 * Return the value associated with the column: item_generic_id
	 */
	public jkt.hms.masters.business.MasStoreItemGeneric getItemGeneric () {
		return itemGeneric;
	}

	/**
	 * Set the value related to the column: item_generic_id
	 * @param itemGeneric the item_generic_id value
	 */
	public void setItemGeneric (jkt.hms.masters.business.MasStoreItemGeneric itemGeneric) {
		this.itemGeneric = itemGeneric;
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
	 * Return the value associated with the column: sale_tax_id
	 */
	public jkt.hms.masters.business.MasSalesTaxType getSaleTax () {
		return saleTax;
	}

	/**
	 * Set the value related to the column: sale_tax_id
	 * @param saleTax the sale_tax_id value
	 */
	public void setSaleTax (jkt.hms.masters.business.MasSalesTaxType saleTax) {
		this.saleTax = saleTax;
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
	 * Return the value associated with the column: route_id
	 */
	public jkt.hms.masters.business.RouteOfAdministration getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route_id
	 * @param route the route_id value
	 */
	public void setRoute (jkt.hms.masters.business.RouteOfAdministration route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: pharma_index_id
	 */
	public jkt.hms.masters.business.MasStorePharmaIndex getPharmaIndex () {
		return pharmaIndex;
	}

	/**
	 * Set the value related to the column: pharma_index_id
	 * @param pharmaIndex the pharma_index_id value
	 */
	public void setPharmaIndex (jkt.hms.masters.business.MasStorePharmaIndex pharmaIndex) {
		this.pharmaIndex = pharmaIndex;
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
	 * Return the value associated with the column: manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * @param manufacturer the manufacturer_id value
	 */
	public void setManufacturer (jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}



	/**
	 * Return the value associated with the column: StoreTenderTechnicalBidTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> getStoreTenderTechnicalBidTs () {
		return storeTenderTechnicalBidTs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidTs
	 * @param storeTenderTechnicalBidTs the StoreTenderTechnicalBidTs value
	 */
	public void setStoreTenderTechnicalBidTs (java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> storeTenderTechnicalBidTs) {
		this.storeTenderTechnicalBidTs = storeTenderTechnicalBidTs;
	}

	public void addToStoreTenderTechnicalBidTs (jkt.hms.masters.business.StoreTenderTechnicalBidT storeTenderTechnicalBidT) {
		if (null == getStoreTenderTechnicalBidTs()) setStoreTenderTechnicalBidTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidT>());
		getStoreTenderTechnicalBidTs().add(storeTenderTechnicalBidT);
	}



	/**
	 * Return the value associated with the column: StoreWorkOrderTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> getStoreWorkOrderTs () {
		return storeWorkOrderTs;
	}

	/**
	 * Set the value related to the column: StoreWorkOrderTs
	 * @param storeWorkOrderTs the StoreWorkOrderTs value
	 */
	public void setStoreWorkOrderTs (java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> storeWorkOrderTs) {
		this.storeWorkOrderTs = storeWorkOrderTs;
	}

	public void addToStoreWorkOrderTs (jkt.hms.masters.business.StoreWorkOrderT storeWorkOrderT) {
		if (null == getStoreWorkOrderTs()) setStoreWorkOrderTs(new java.util.TreeSet<jkt.hms.masters.business.StoreWorkOrderT>());
		getStoreWorkOrderTs().add(storeWorkOrderT);
	}



	/**
	 * Return the value associated with the column: StoreIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentT> getStoreIndentTs () {
		return storeIndentTs;
	}

	/**
	 * Set the value related to the column: StoreIndentTs
	 * @param storeIndentTs the StoreIndentTs value
	 */
	public void setStoreIndentTs (java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs) {
		this.storeIndentTs = storeIndentTs;
	}

	public void addToStoreIndentTs (jkt.hms.masters.business.StoreIndentT storeIndentT) {
		if (null == getStoreIndentTs()) setStoreIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentT>());
		getStoreIndentTs().add(storeIndentT);
	}



	/**
	 * Return the value associated with the column: StoreSupplyOrderEntries
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> getStoreSupplyOrderEntries () {
		return storeSupplyOrderEntries;
	}

	/**
	 * Set the value related to the column: StoreSupplyOrderEntries
	 * @param storeSupplyOrderEntries the StoreSupplyOrderEntries value
	 */
	public void setStoreSupplyOrderEntries (java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries) {
		this.storeSupplyOrderEntries = storeSupplyOrderEntries;
	}

	public void addToStoreSupplyOrderEntries (jkt.hms.masters.business.StoreSupplyOrderEntry storeSupplyOrderEntry) {
		if (null == getStoreSupplyOrderEntries()) setStoreSupplyOrderEntries(new java.util.TreeSet<jkt.hms.masters.business.StoreSupplyOrderEntry>());
		getStoreSupplyOrderEntries().add(storeSupplyOrderEntry);
	}



	/**
	 * Return the value associated with the column: StoreAmcMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAmcM> getStoreAmcMs () {
		return storeAmcMs;
	}

	/**
	 * Set the value related to the column: StoreAmcMs
	 * @param storeAmcMs the StoreAmcMs value
	 */
	public void setStoreAmcMs (java.util.Set<jkt.hms.masters.business.StoreAmcM> storeAmcMs) {
		this.storeAmcMs = storeAmcMs;
	}

	public void addToStoreAmcMs (jkt.hms.masters.business.StoreAmcM storeAmcM) {
		if (null == getStoreAmcMs()) setStoreAmcMs(new java.util.TreeSet<jkt.hms.masters.business.StoreAmcM>());
		getStoreAmcMs().add(storeAmcM);
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> getStoreInternalIndentTs () {
		return storeInternalIndentTs;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentTs
	 * @param storeInternalIndentTs the StoreInternalIndentTs value
	 */
	public void setStoreInternalIndentTs (java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs) {
		this.storeInternalIndentTs = storeInternalIndentTs;
	}

	public void addToStoreInternalIndentTs (jkt.hms.masters.business.StoreInternalIndentT storeInternalIndentT) {
		if (null == getStoreInternalIndentTs()) setStoreInternalIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentT>());
		getStoreInternalIndentTs().add(storeInternalIndentT);
	}



	/**
	 * Return the value associated with the column: StoreIpIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueT> getStoreIpIssueTs () {
		return storeIpIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueTs
	 * @param storeIpIssueTs the StoreIpIssueTs value
	 */
	public void setStoreIpIssueTs (java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs) {
		this.storeIpIssueTs = storeIpIssueTs;
	}

	public void addToStoreIpIssueTs (jkt.hms.masters.business.StoreIpIssueT storeIpIssueT) {
		if (null == getStoreIpIssueTs()) setStoreIpIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueT>());
		getStoreIpIssueTs().add(storeIpIssueT);
	}



	/**
	 * Return the value associated with the column: StoreIndentSocTrackers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> getStoreIndentSocTrackers () {
		return storeIndentSocTrackers;
	}

	/**
	 * Set the value related to the column: StoreIndentSocTrackers
	 * @param storeIndentSocTrackers the StoreIndentSocTrackers value
	 */
	public void setStoreIndentSocTrackers (java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers) {
		this.storeIndentSocTrackers = storeIndentSocTrackers;
	}

	public void addToStoreIndentSocTrackers (jkt.hms.masters.business.StoreIndentSocTracker storeIndentSocTracker) {
		if (null == getStoreIndentSocTrackers()) setStoreIndentSocTrackers(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentSocTracker>());
		getStoreIndentSocTrackers().add(storeIndentSocTracker);
	}



	/**
	 * Return the value associated with the column: StoreTenderProposals
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderProposal> getStoreTenderProposals () {
		return storeTenderProposals;
	}

	/**
	 * Set the value related to the column: StoreTenderProposals
	 * @param storeTenderProposals the StoreTenderProposals value
	 */
	public void setStoreTenderProposals (java.util.Set<jkt.hms.masters.business.StoreTenderProposal> storeTenderProposals) {
		this.storeTenderProposals = storeTenderProposals;
	}

	public void addToStoreTenderProposals (jkt.hms.masters.business.StoreTenderProposal storeTenderProposal) {
		if (null == getStoreTenderProposals()) setStoreTenderProposals(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderProposal>());
		getStoreTenderProposals().add(storeTenderProposal);
	}



	/**
	 * Return the value associated with the column: StoreGrnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnT> getStoreGrnTs () {
		return storeGrnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnTs
	 * @param storeGrnTs the StoreGrnTs value
	 */
	public void setStoreGrnTs (java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs) {
		this.storeGrnTs = storeGrnTs;
	}

	public void addToStoreGrnTs (jkt.hms.masters.business.StoreGrnT storeGrnT) {
		if (null == getStoreGrnTs()) setStoreGrnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnT>());
		getStoreGrnTs().add(storeGrnT);
	}



	/**
	 * Return the value associated with the column: StoreQuaterReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> getStoreQuaterReturnTs () {
		return storeQuaterReturnTs;
	}

	/**
	 * Set the value related to the column: StoreQuaterReturnTs
	 * @param storeQuaterReturnTs the StoreQuaterReturnTs value
	 */
	public void setStoreQuaterReturnTs (java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> storeQuaterReturnTs) {
		this.storeQuaterReturnTs = storeQuaterReturnTs;
	}

	public void addToStoreQuaterReturnTs (jkt.hms.masters.business.StoreQuaterReturnT storeQuaterReturnT) {
		if (null == getStoreQuaterReturnTs()) setStoreQuaterReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuaterReturnT>());
		getStoreQuaterReturnTs().add(storeQuaterReturnT);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> getStoreInternalReturnTs () {
		return storeInternalReturnTs;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnTs
	 * @param storeInternalReturnTs the StoreInternalReturnTs value
	 */
	public void setStoreInternalReturnTs (java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs) {
		this.storeInternalReturnTs = storeInternalReturnTs;
	}

	public void addToStoreInternalReturnTs (jkt.hms.masters.business.StoreInternalReturnT storeInternalReturnT) {
		if (null == getStoreInternalReturnTs()) setStoreInternalReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnT>());
		getStoreInternalReturnTs().add(storeInternalReturnT);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> getStoreTenderCommBidMs () {
		return storeTenderCommBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderCommBidMs
	 * @param storeTenderCommBidMs the StoreTenderCommBidMs value
	 */
	public void setStoreTenderCommBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs) {
		this.storeTenderCommBidMs = storeTenderCommBidMs;
	}

	public void addToStoreTenderCommBidMs (jkt.hms.masters.business.StoreTenderCommBidM storeTenderCommBidM) {
		if (null == getStoreTenderCommBidMs()) setStoreTenderCommBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommBidM>());
		getStoreTenderCommBidMs().add(storeTenderCommBidM);
	}



	/**
	 * Return the value associated with the column: StoreSocs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSoc> getStoreSocs () {
		return storeSocs;
	}

	/**
	 * Set the value related to the column: StoreSocs
	 * @param storeSocs the StoreSocs value
	 */
	public void setStoreSocs (java.util.Set<jkt.hms.masters.business.StoreSoc> storeSocs) {
		this.storeSocs = storeSocs;
	}

	public void addToStoreSocs (jkt.hms.masters.business.StoreSoc storeSoc) {
		if (null == getStoreSocs()) setStoreSocs(new java.util.TreeSet<jkt.hms.masters.business.StoreSoc>());
		getStoreSocs().add(storeSoc);
	}



	/**
	 * Return the value associated with the column: StoreLoaninTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninT> getStoreLoaninTs () {
		return storeLoaninTs;
	}

	/**
	 * Set the value related to the column: StoreLoaninTs
	 * @param storeLoaninTs the StoreLoaninTs value
	 */
	public void setStoreLoaninTs (java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs) {
		this.storeLoaninTs = storeLoaninTs;
	}

	public void addToStoreLoaninTs (jkt.hms.masters.business.StoreLoaninT storeLoaninT) {
		if (null == getStoreLoaninTs()) setStoreLoaninTs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninT>());
		getStoreLoaninTs().add(storeLoaninT);
	}



	/**
	 * Return the value associated with the column: StoreDefectiveDrugTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> getStoreDefectiveDrugTs () {
		return storeDefectiveDrugTs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugTs
	 * @param storeDefectiveDrugTs the StoreDefectiveDrugTs value
	 */
	public void setStoreDefectiveDrugTs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs) {
		this.storeDefectiveDrugTs = storeDefectiveDrugTs;
	}

	public void addToStoreDefectiveDrugTs (jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT) {
		if (null == getStoreDefectiveDrugTs()) setStoreDefectiveDrugTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugT>());
		getStoreDefectiveDrugTs().add(storeDefectiveDrugT);
	}



	/**
	 * Return the value associated with the column: StoreQuotationRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> getStoreQuotationRequestTs () {
		return storeQuotationRequestTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestTs
	 * @param storeQuotationRequestTs the StoreQuotationRequestTs value
	 */
	public void setStoreQuotationRequestTs (java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs) {
		this.storeQuotationRequestTs = storeQuotationRequestTs;
	}

	public void addToStoreQuotationRequestTs (jkt.hms.masters.business.StoreQuotationRequestT storeQuotationRequestT) {
		if (null == getStoreQuotationRequestTs()) setStoreQuotationRequestTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestT>());
		getStoreQuotationRequestTs().add(storeQuotationRequestT);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> getStoreGrnReturnTs () {
		return storeGrnReturnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnTs
	 * @param storeGrnReturnTs the StoreGrnReturnTs value
	 */
	public void setStoreGrnReturnTs (java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> storeGrnReturnTs) {
		this.storeGrnReturnTs = storeGrnReturnTs;
	}

	public void addToStoreGrnReturnTs (jkt.hms.masters.business.StoreGrnReturnT storeGrnReturnT) {
		if (null == getStoreGrnReturnTs()) setStoreGrnReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnT>());
		getStoreGrnReturnTs().add(storeGrnReturnT);
	}



	/**
	 * Return the value associated with the column: StoreItemLogTransactions
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> getStoreItemLogTransactions () {
		return storeItemLogTransactions;
	}

	/**
	 * Set the value related to the column: StoreItemLogTransactions
	 * @param storeItemLogTransactions the StoreItemLogTransactions value
	 */
	public void setStoreItemLogTransactions (java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions) {
		this.storeItemLogTransactions = storeItemLogTransactions;
	}

	public void addToStoreItemLogTransactions (jkt.hms.masters.business.StoreItemLogTransaction storeItemLogTransaction) {
		if (null == getStoreItemLogTransactions()) setStoreItemLogTransactions(new java.util.TreeSet<jkt.hms.masters.business.StoreItemLogTransaction>());
		getStoreItemLogTransactions().add(storeItemLogTransaction);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueTsByItemIdRequire
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> getStoreOpPatientIssueTsByItemIdRequire () {
		return storeOpPatientIssueTsByItemIdRequire;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueTsByItemIdRequire
	 * @param storeOpPatientIssueTsByItemIdRequire the StoreOpPatientIssueTsByItemIdRequire value
	 */
	public void setStoreOpPatientIssueTsByItemIdRequire (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdRequire) {
		this.storeOpPatientIssueTsByItemIdRequire = storeOpPatientIssueTsByItemIdRequire;
	}

	public void addToStoreOpPatientIssueTsByItemIdRequire (jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT) {
		if (null == getStoreOpPatientIssueTsByItemIdRequire()) setStoreOpPatientIssueTsByItemIdRequire(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueT>());
		getStoreOpPatientIssueTsByItemIdRequire().add(storeOpPatientIssueT);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueTsByItemIdIssue
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> getStoreOpPatientIssueTsByItemIdIssue () {
		return storeOpPatientIssueTsByItemIdIssue;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueTsByItemIdIssue
	 * @param storeOpPatientIssueTsByItemIdIssue the StoreOpPatientIssueTsByItemIdIssue value
	 */
	public void setStoreOpPatientIssueTsByItemIdIssue (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdIssue) {
		this.storeOpPatientIssueTsByItemIdIssue = storeOpPatientIssueTsByItemIdIssue;
	}

	public void addToStoreOpPatientIssueTsByItemIdIssue (jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT) {
		if (null == getStoreOpPatientIssueTsByItemIdIssue()) setStoreOpPatientIssueTsByItemIdIssue(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueT>());
		getStoreOpPatientIssueTsByItemIdIssue().add(storeOpPatientIssueT);
	}



	/**
	 * Return the value associated with the column: StoreQuotationReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> getStoreQuotationReceiptTs () {
		return storeQuotationReceiptTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationReceiptTs
	 * @param storeQuotationReceiptTs the StoreQuotationReceiptTs value
	 */
	public void setStoreQuotationReceiptTs (java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs) {
		this.storeQuotationReceiptTs = storeQuotationReceiptTs;
	}

	public void addToStoreQuotationReceiptTs (jkt.hms.masters.business.StoreQuotationReceiptT storeQuotationReceiptT) {
		if (null == getStoreQuotationReceiptTs()) setStoreQuotationReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationReceiptT>());
		getStoreQuotationReceiptTs().add(storeQuotationReceiptT);
	}



	/**
	 * Return the value associated with the column: StoreMeScaleDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> getStoreMeScaleDetails () {
		return storeMeScaleDetails;
	}

	/**
	 * Set the value related to the column: StoreMeScaleDetails
	 * @param storeMeScaleDetails the StoreMeScaleDetails value
	 */
	public void setStoreMeScaleDetails (java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails) {
		this.storeMeScaleDetails = storeMeScaleDetails;
	}

	public void addToStoreMeScaleDetails (jkt.hms.masters.business.StoreMeScaleDetails storeMeScaleDetails) {
		if (null == getStoreMeScaleDetails()) setStoreMeScaleDetails(new java.util.TreeSet<jkt.hms.masters.business.StoreMeScaleDetails>());
		getStoreMeScaleDetails().add(storeMeScaleDetails);
	}



	/**
	 * Return the value associated with the column: MasStoreItemTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> getMasStoreItemTemplates () {
		return masStoreItemTemplates;
	}

	/**
	 * Set the value related to the column: MasStoreItemTemplates
	 * @param masStoreItemTemplates the MasStoreItemTemplates value
	 */
	public void setMasStoreItemTemplates (java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> masStoreItemTemplates) {
		this.masStoreItemTemplates = masStoreItemTemplates;
	}

	public void addToMasStoreItemTemplates (jkt.hms.masters.business.MasStoreItemTemplate masStoreItemTemplate) {
		if (null == getMasStoreItemTemplates()) setMasStoreItemTemplates(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemTemplate>());
		getMasStoreItemTemplates().add(masStoreItemTemplate);
	}



	/**
	 * Return the value associated with the column: StoreItemBatchStocks
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> getStoreItemBatchStocks () {
		return storeItemBatchStocks;
	}

	/**
	 * Set the value related to the column: StoreItemBatchStocks
	 * @param storeItemBatchStocks the StoreItemBatchStocks value
	 */
	public void setStoreItemBatchStocks (java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks) {
		this.storeItemBatchStocks = storeItemBatchStocks;
	}

	public void addToStoreItemBatchStocks (jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock) {
		if (null == getStoreItemBatchStocks()) setStoreItemBatchStocks(new java.util.TreeSet<jkt.hms.masters.business.StoreItemBatchStock>());
		getStoreItemBatchStocks().add(storeItemBatchStock);
	}



	/**
	 * Return the value associated with the column: StoreDisposalTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDisposalT> getStoreDisposalTs () {
		return storeDisposalTs;
	}

	/**
	 * Set the value related to the column: StoreDisposalTs
	 * @param storeDisposalTs the StoreDisposalTs value
	 */
	public void setStoreDisposalTs (java.util.Set<jkt.hms.masters.business.StoreDisposalT> storeDisposalTs) {
		this.storeDisposalTs = storeDisposalTs;
	}

	public void addToStoreDisposalTs (jkt.hms.masters.business.StoreDisposalT storeDisposalT) {
		if (null == getStoreDisposalTs()) setStoreDisposalTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDisposalT>());
		getStoreDisposalTs().add(storeDisposalT);
	}



	/**
	 * Return the value associated with the column: StoreMmfDepartmentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> getStoreMmfDepartmentTs () {
		return storeMmfDepartmentTs;
	}

	/**
	 * Set the value related to the column: StoreMmfDepartmentTs
	 * @param storeMmfDepartmentTs the StoreMmfDepartmentTs value
	 */
	public void setStoreMmfDepartmentTs (java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> storeMmfDepartmentTs) {
		this.storeMmfDepartmentTs = storeMmfDepartmentTs;
	}

	public void addToStoreMmfDepartmentTs (jkt.hms.masters.business.StoreMmfDepartmentT storeMmfDepartmentT) {
		if (null == getStoreMmfDepartmentTs()) setStoreMmfDepartmentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreMmfDepartmentT>());
		getStoreMmfDepartmentTs().add(storeMmfDepartmentT);
	}



	/**
	 * Return the value associated with the column: StoreAdjustmentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> getStoreAdjustmentTs () {
		return storeAdjustmentTs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentTs
	 * @param storeAdjustmentTs the StoreAdjustmentTs value
	 */
	public void setStoreAdjustmentTs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> storeAdjustmentTs) {
		this.storeAdjustmentTs = storeAdjustmentTs;
	}

	public void addToStoreAdjustmentTs (jkt.hms.masters.business.StoreAdjustmentT storeAdjustmentT) {
		if (null == getStoreAdjustmentTs()) setStoreAdjustmentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentT>());
		getStoreAdjustmentTs().add(storeAdjustmentT);
	}



	/**
	 * Return the value associated with the column: StoreCondemnationTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationT> getStoreCondemnationTs () {
		return storeCondemnationTs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationTs
	 * @param storeCondemnationTs the StoreCondemnationTs value
	 */
	public void setStoreCondemnationTs (java.util.Set<jkt.hms.masters.business.StoreCondemnationT> storeCondemnationTs) {
		this.storeCondemnationTs = storeCondemnationTs;
	}

	public void addToStoreCondemnationTs (jkt.hms.masters.business.StoreCondemnationT storeCondemnationT) {
		if (null == getStoreCondemnationTs()) setStoreCondemnationTs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationT>());
		getStoreCondemnationTs().add(storeCondemnationT);
	}



	/**
	 * Return the value associated with the column: StoreRepairCivilFirms
	 */
	public java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> getStoreRepairCivilFirms () {
		return storeRepairCivilFirms;
	}

	/**
	 * Set the value related to the column: StoreRepairCivilFirms
	 * @param storeRepairCivilFirms the StoreRepairCivilFirms value
	 */
	public void setStoreRepairCivilFirms (java.util.Set<jkt.hms.masters.business.StoreRepairCivilFirm> storeRepairCivilFirms) {
		this.storeRepairCivilFirms = storeRepairCivilFirms;
	}

	public void addToStoreRepairCivilFirms (jkt.hms.masters.business.StoreRepairCivilFirm storeRepairCivilFirm) {
		if (null == getStoreRepairCivilFirms()) setStoreRepairCivilFirms(new java.util.TreeSet<jkt.hms.masters.business.StoreRepairCivilFirm>());
		getStoreRepairCivilFirms().add(storeRepairCivilFirm);
	}



	/**
	 * Return the value associated with the column: StorePoDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoDetail> getStorePoDetails () {
		return storePoDetails;
	}

	/**
	 * Set the value related to the column: StorePoDetails
	 * @param storePoDetails the StorePoDetails value
	 */
	public void setStorePoDetails (java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails) {
		this.storePoDetails = storePoDetails;
	}

	public void addToStorePoDetails (jkt.hms.masters.business.StorePoDetail storePoDetail) {
		if (null == getStorePoDetails()) setStorePoDetails(new java.util.TreeSet<jkt.hms.masters.business.StorePoDetail>());
		getStorePoDetails().add(storePoDetail);
	}



	/**
	 * Return the value associated with the column: StoreBosTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBosT> getStoreBosTs () {
		return storeBosTs;
	}

	/**
	 * Set the value related to the column: StoreBosTs
	 * @param storeBosTs the StoreBosTs value
	 */
	public void setStoreBosTs (java.util.Set<jkt.hms.masters.business.StoreBosT> storeBosTs) {
		this.storeBosTs = storeBosTs;
	}

	public void addToStoreBosTs (jkt.hms.masters.business.StoreBosT storeBosT) {
		if (null == getStoreBosTs()) setStoreBosTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBosT>());
		getStoreBosTs().add(storeBosT);
	}



	/**
	 * Return the value associated with the column: StoreIssueTsByItemIssued
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTsByItemIssued () {
		return storeIssueTsByItemIssued;
	}

	/**
	 * Set the value related to the column: StoreIssueTsByItemIssued
	 * @param storeIssueTsByItemIssued the StoreIssueTsByItemIssued value
	 */
	public void setStoreIssueTsByItemIssued (java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItemIssued) {
		this.storeIssueTsByItemIssued = storeIssueTsByItemIssued;
	}

	public void addToStoreIssueTsByItemIssued (jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTsByItemIssued()) setStoreIssueTsByItemIssued(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTsByItemIssued().add(storeIssueT);
	}



	/**
	 * Return the value associated with the column: StoreIssueTsByItem
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTsByItem () {
		return storeIssueTsByItem;
	}

	/**
	 * Set the value related to the column: StoreIssueTsByItem
	 * @param storeIssueTsByItem the StoreIssueTsByItem value
	 */
	public void setStoreIssueTsByItem (java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItem) {
		this.storeIssueTsByItem = storeIssueTsByItem;
	}

	public void addToStoreIssueTsByItem (jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTsByItem()) setStoreIssueTsByItem(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTsByItem().add(storeIssueT);
	}



	/**
	 * Return the value associated with the column: StoreBalanceTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceT> getStoreBalanceTs () {
		return storeBalanceTs;
	}

	/**
	 * Set the value related to the column: StoreBalanceTs
	 * @param storeBalanceTs the StoreBalanceTs value
	 */
	public void setStoreBalanceTs (java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs) {
		this.storeBalanceTs = storeBalanceTs;
	}

	public void addToStoreBalanceTs (jkt.hms.masters.business.StoreBalanceT storeBalanceT) {
		if (null == getStoreBalanceTs()) setStoreBalanceTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceT>());
		getStoreBalanceTs().add(storeBalanceT);
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionDetails
	 * @param patientPrescriptionDetails the PatientPrescriptionDetails value
	 */
	public void setPatientPrescriptionDetails (java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}

	public void addToPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		if (null == getPatientPrescriptionDetails()) setPatientPrescriptionDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionDetails>());
		getPatientPrescriptionDetails().add(patientPrescriptionDetails);
	}



	/**
	 * Return the value associated with the column: StoreStockTakingTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingT> getStoreStockTakingTs () {
		return storeStockTakingTs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingTs
	 * @param storeStockTakingTs the StoreStockTakingTs value
	 */
	public void setStoreStockTakingTs (java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs) {
		this.storeStockTakingTs = storeStockTakingTs;
	}

	public void addToStoreStockTakingTs (jkt.hms.masters.business.StoreStockTakingT storeStockTakingT) {
		if (null == getStoreStockTakingTs()) setStoreStockTakingTs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingT>());
		getStoreStockTakingTs().add(storeStockTakingT);
	}



	/**
	 * Return the value associated with the column: MasStoreBrands
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreBrand> getMasStoreBrands () {
		return masStoreBrands;
	}

	/**
	 * Set the value related to the column: MasStoreBrands
	 * @param masStoreBrands the MasStoreBrands value
	 */
	public void setMasStoreBrands (java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands) {
		this.masStoreBrands = masStoreBrands;
	}

	public void addToMasStoreBrands (jkt.hms.masters.business.MasStoreBrand masStoreBrand) {
		if (null == getMasStoreBrands()) setMasStoreBrands(new java.util.TreeSet<jkt.hms.masters.business.MasStoreBrand>());
		getMasStoreBrands().add(masStoreBrand);
	}



	/**
	 * Return the value associated with the column: StoreTenderTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderT> getStoreTenderTs () {
		return storeTenderTs;
	}

	/**
	 * Set the value related to the column: StoreTenderTs
	 * @param storeTenderTs the StoreTenderTs value
	 */
	public void setStoreTenderTs (java.util.Set<jkt.hms.masters.business.StoreTenderT> storeTenderTs) {
		this.storeTenderTs = storeTenderTs;
	}

	public void addToStoreTenderTs (jkt.hms.masters.business.StoreTenderT storeTenderT) {
		if (null == getStoreTenderTs()) setStoreTenderTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderT>());
		getStoreTenderTs().add(storeTenderT);
	}



	/**
	 * Return the value associated with the column: MasStoreItemDetails
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemDetails> getMasStoreItemDetails () {
		return masStoreItemDetails;
	}

	/**
	 * Set the value related to the column: MasStoreItemDetails
	 * @param masStoreItemDetails the MasStoreItemDetails value
	 */
	public void setMasStoreItemDetails (java.util.Set<jkt.hms.masters.business.MasStoreItemDetails> masStoreItemDetails) {
		this.masStoreItemDetails = masStoreItemDetails;
	}

	public void addToMasStoreItemDetails (jkt.hms.masters.business.MasStoreItemDetails masStoreItemDetails) {
		if (null == getMasStoreItemDetails()) setMasStoreItemDetails(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemDetails>());
		getMasStoreItemDetails().add(masStoreItemDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreItem)) return false;
		else {
			jkt.hms.masters.business.MasStoreItem masStoreItem = (jkt.hms.masters.business.MasStoreItem) obj;
			if (null == this.getId() || null == masStoreItem.getId()) return false;
			else return (this.getId().equals(masStoreItem.getId()));
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