package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_out_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_out_item"
 */

public abstract class BaseMasStoreOutItem  implements Serializable {

	public static String REF = "MasStoreOutItem";
	public static String PROP_NOMENCLATURE = "Nomenclature";
	public static String PROP_COMMON_NAME = "CommonName";
	public static String PROP_REFFRED_BY = "ReffredBy";
	public static String PROP_PVMS = "Pvms";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ITEM_TYPE_ID = "ItemTypeId";
	public static String PROP_ITEM_CATEGORY_ID = "ItemCategoryId";
	public static String PROP_DANGEROUS_DRUG = "DangerousDrug";
	public static String PROP_ITEM_CONVERSION_ID = "ItemConversionId";
	public static String PROP_GROUP_ID = "GroupId";
	public static String PROP_DISP_UNIT = "DispUnit";
	public static String PROP_STATUS = "Status";
	public static String PROP_RATE_CONTRACT_ITEM = "RateContractItem";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_A_DISP_QTY = "ADispQty";
	public static String PROP_CONTROLLED_DRUG = "ControlledDrug";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_CREATED_ON = "CreatedOn";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COST_PRICE = "CostPrice";


	// constructors
	public BaseMasStoreOutItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreOutItem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pvms;
	private java.lang.String nomenclature;
	private java.lang.String dangerousDrug;
	private java.lang.Long itemTypeId;
	private java.lang.Long itemCategoryId;
	private java.lang.Long itemConversionId;
	private java.lang.Integer costPrice;
	private java.lang.String controlledDrug;
	private java.lang.String rateContractItem;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Long groupId;
	private java.util.Date createdOn;
	private java.lang.Long reffredBy;
	private java.lang.String commonName;
	private java.lang.String dispUnit;
	private java.lang.Integer aDispQty;

	// many to one
	private jkt.hms.masters.business.Users createdBy;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;



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
	 * Return the value associated with the column: pvms
	 */
	public java.lang.String getPvms () {
		return pvms;
	}

	/**
	 * Set the value related to the column: pvms
	 * @param pvms the pvms value
	 */
	public void setPvms (java.lang.String pvms) {
		this.pvms = pvms;
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
	 * Return the value associated with the column: item_type_id
	 */
	public java.lang.Long getItemTypeId () {
		return itemTypeId;
	}

	/**
	 * Set the value related to the column: item_type_id
	 * @param itemTypeId the item_type_id value
	 */
	public void setItemTypeId (java.lang.Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}



	/**
	 * Return the value associated with the column: item_category_id
	 */
	public java.lang.Long getItemCategoryId () {
		return itemCategoryId;
	}

	/**
	 * Set the value related to the column: item_category_id
	 * @param itemCategoryId the item_category_id value
	 */
	public void setItemCategoryId (java.lang.Long itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}



	/**
	 * Return the value associated with the column: item_conversion_id
	 */
	public java.lang.Long getItemConversionId () {
		return itemConversionId;
	}

	/**
	 * Set the value related to the column: item_conversion_id
	 * @param itemConversionId the item_conversion_id value
	 */
	public void setItemConversionId (java.lang.Long itemConversionId) {
		this.itemConversionId = itemConversionId;
	}



	/**
	 * Return the value associated with the column: cost_price
	 */
	public java.lang.Integer getCostPrice () {
		return costPrice;
	}

	/**
	 * Set the value related to the column: cost_price
	 * @param costPrice the cost_price value
	 */
	public void setCostPrice (java.lang.Integer costPrice) {
		this.costPrice = costPrice;
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
	 * Return the value associated with the column: group_id
	 */
	public java.lang.Long getGroupId () {
		return groupId;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param groupId the group_id value
	 */
	public void setGroupId (java.lang.Long groupId) {
		this.groupId = groupId;
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
	 * Return the value associated with the column: reffred_by
	 */
	public java.lang.Long getReffredBy () {
		return reffredBy;
	}

	/**
	 * Set the value related to the column: reffred_by
	 * @param reffredBy the reffred_by value
	 */
	public void setReffredBy (java.lang.Long reffredBy) {
		this.reffredBy = reffredBy;
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
	public java.lang.Integer getADispQty () {
		return aDispQty;
	}

	/**
	 * Set the value related to the column: a_disp_qty
	 * @param aDispQty the a_disp_qty value
	 */
	public void setADispQty (java.lang.Integer aDispQty) {
		this.aDispQty = aDispQty;
	}



	/**
	 * Return the value associated with the column: created_by
	 */
	public jkt.hms.masters.business.Users getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: created_by
	 * @param createdBy the created_by value
	 */
	public void setCreatedBy (jkt.hms.masters.business.Users createdBy) {
		this.createdBy = createdBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreOutItem)) return false;
		else {
			jkt.hms.masters.business.MasStoreOutItem masStoreOutItem = (jkt.hms.masters.business.MasStoreOutItem) obj;
			if (null == this.getId() || null == masStoreOutItem.getId()) return false;
			else return (this.getId().equals(masStoreOutItem.getId()));
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