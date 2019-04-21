package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_defective_drug_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_defective_drug_t"
 */

public abstract class BaseStoreDefectiveDrugT  implements Serializable {

	public static String REF = "StoreDefectiveDrugT";
	public static String PROP_MANUFACTURED_BY = "ManufacturedBy";
	public static String PROP_BRAND = "Brand";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_DEFECT_QTY_REPLACE = "DefectQtyReplace";
	public static String PROP_MANUFACTURER_DATE = "ManufacturerDate";
	public static String PROP_RECEIVED_FROM = "ReceivedFrom";
	public static String PROP_DEFECT_M = "DefectM";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_DEFECT_QTY = "DefectQty";
	public static String PROP_ITEM = "Item";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_AUTHY_UNDER_DECLARED = "AuthyUnderDeclared";
	public static String PROP_ID = "Id";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseStoreDefectiveDrugT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDefectiveDrugT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal defectQty;
	private java.lang.String receivedFrom;
	private java.lang.String authyUnderDeclared;
	private java.lang.String disposal;
	private java.lang.String remarks;
	private java.lang.String manufacturerDate;
	private java.math.BigDecimal defectQtyReplace;

	// many to one
	private jkt.hms.masters.business.StoreDefectiveDrugM defectM;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasManufacturer manufacturedBy;



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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: defect_qty
	 */
	public java.math.BigDecimal getDefectQty () {
		return defectQty;
	}

	/**
	 * Set the value related to the column: defect_qty
	 * @param defectQty the defect_qty value
	 */
	public void setDefectQty (java.math.BigDecimal defectQty) {
		this.defectQty = defectQty;
	}



	/**
	 * Return the value associated with the column: received_from
	 */
	public java.lang.String getReceivedFrom () {
		return receivedFrom;
	}

	/**
	 * Set the value related to the column: received_from
	 * @param receivedFrom the received_from value
	 */
	public void setReceivedFrom (java.lang.String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}



	/**
	 * Return the value associated with the column: authy_under_declared
	 */
	public java.lang.String getAuthyUnderDeclared () {
		return authyUnderDeclared;
	}

	/**
	 * Set the value related to the column: authy_under_declared
	 * @param authyUnderDeclared the authy_under_declared value
	 */
	public void setAuthyUnderDeclared (java.lang.String authyUnderDeclared) {
		this.authyUnderDeclared = authyUnderDeclared;
	}



	/**
	 * Return the value associated with the column: disposal
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal
	 * @param disposal the disposal value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
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
	 * Return the value associated with the column: manufacturer_date
	 */
	public java.lang.String getManufacturerDate () {
		return manufacturerDate;
	}

	/**
	 * Set the value related to the column: manufacturer_date
	 * @param manufacturerDate the manufacturer_date value
	 */
	public void setManufacturerDate (java.lang.String manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}



	/**
	 * Return the value associated with the column: defect_qty_replace
	 */
	public java.math.BigDecimal getDefectQtyReplace () {
		return defectQtyReplace;
	}

	/**
	 * Set the value related to the column: defect_qty_replace
	 * @param defectQtyReplace the defect_qty_replace value
	 */
	public void setDefectQtyReplace (java.math.BigDecimal defectQtyReplace) {
		this.defectQtyReplace = defectQtyReplace;
	}



	/**
	 * Return the value associated with the column: defect_m_id
	 */
	public jkt.hms.masters.business.StoreDefectiveDrugM getDefectM () {
		return defectM;
	}

	/**
	 * Set the value related to the column: defect_m_id
	 * @param defectM the defect_m_id value
	 */
	public void setDefectM (jkt.hms.masters.business.StoreDefectiveDrugM defectM) {
		this.defectM = defectM;
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
	 * Return the value associated with the column: manufactured_by
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturedBy () {
		return manufacturedBy;
	}

	/**
	 * Set the value related to the column: manufactured_by
	 * @param manufacturedBy the manufactured_by value
	 */
	public void setManufacturedBy (jkt.hms.masters.business.MasManufacturer manufacturedBy) {
		this.manufacturedBy = manufacturedBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreDefectiveDrugT)) return false;
		else {
			jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT = (jkt.hms.masters.business.StoreDefectiveDrugT) obj;
			if (null == this.getId() || null == storeDefectiveDrugT.getId()) return false;
			else return (this.getId().equals(storeDefectiveDrugT.getId()));
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