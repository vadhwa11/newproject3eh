package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_safety_procedure_materials table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_safety_procedure_materials"
 */

public abstract class BaseMmSafetyProcedureMaterials  implements Serializable {

	public static String REF = "MmSafetyProcedureMaterials";
	public static String PROP_ITEM_REMARKS = "ItemRemarks";
	public static String PROP_PO_DETAIL = "PoDetail";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPECIFICATION = "Specification";
	public static String PROP_INSPECTION_REPORT = "InspectionReport";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_ITEM_SERIAL_NO = "ItemSerialNo";
	public static String PROP_ITEM_MODEL_NO = "ItemModelNo";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_MAKE = "ItemMake";
	public static String PROP_REQUIRED_QTY = "RequiredQty";


	// constructors
	public BaseMmSafetyProcedureMaterials () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmSafetyProcedureMaterials (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal requiredQty;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String itemRemarks;
	private java.lang.String itemSerialNo;
	private java.lang.String itemModelNo;
	private java.lang.String itemMake;
	private java.lang.String specification;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MmInspectionReport inspectionReport;
	private jkt.hms.masters.business.StorePoDetail poDetail;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="materials_id"
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
	 * Return the value associated with the column: required_qty
	 */
	public java.math.BigDecimal getRequiredQty () {
		return requiredQty;
	}

	/**
	 * Set the value related to the column: required_qty
	 * @param requiredQty the required_qty value
	 */
	public void setRequiredQty (java.math.BigDecimal requiredQty) {
		this.requiredQty = requiredQty;
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
	 * Return the value associated with the column: item_remarks
	 */
	public java.lang.String getItemRemarks () {
		return itemRemarks;
	}

	/**
	 * Set the value related to the column: item_remarks
	 * @param itemRemarks the item_remarks value
	 */
	public void setItemRemarks (java.lang.String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}



	/**
	 * Return the value associated with the column: item_serial_no
	 */
	public java.lang.String getItemSerialNo () {
		return itemSerialNo;
	}

	/**
	 * Set the value related to the column: item_serial_no
	 * @param itemSerialNo the item_serial_no value
	 */
	public void setItemSerialNo (java.lang.String itemSerialNo) {
		this.itemSerialNo = itemSerialNo;
	}



	/**
	 * Return the value associated with the column: item_model_no
	 */
	public java.lang.String getItemModelNo () {
		return itemModelNo;
	}

	/**
	 * Set the value related to the column: item_model_no
	 * @param itemModelNo the item_model_no value
	 */
	public void setItemModelNo (java.lang.String itemModelNo) {
		this.itemModelNo = itemModelNo;
	}



	/**
	 * Return the value associated with the column: item_make
	 */
	public java.lang.String getItemMake () {
		return itemMake;
	}

	/**
	 * Set the value related to the column: item_make
	 * @param itemMake the item_make value
	 */
	public void setItemMake (java.lang.String itemMake) {
		this.itemMake = itemMake;
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
	 * Return the value associated with the column: inspection_report_id
	 */
	public jkt.hms.masters.business.MmInspectionReport getInspectionReport () {
		return inspectionReport;
	}

	/**
	 * Set the value related to the column: inspection_report_id
	 * @param inspectionReport the inspection_report_id value
	 */
	public void setInspectionReport (jkt.hms.masters.business.MmInspectionReport inspectionReport) {
		this.inspectionReport = inspectionReport;
	}



	/**
	 * Return the value associated with the column: po_detail_id
	 */
	public jkt.hms.masters.business.StorePoDetail getPoDetail () {
		return poDetail;
	}

	/**
	 * Set the value related to the column: po_detail_id
	 * @param poDetail the po_detail_id value
	 */
	public void setPoDetail (jkt.hms.masters.business.StorePoDetail poDetail) {
		this.poDetail = poDetail;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmSafetyProcedureMaterials)) return false;
		else {
			jkt.hms.masters.business.MmSafetyProcedureMaterials mmSafetyProcedureMaterials = (jkt.hms.masters.business.MmSafetyProcedureMaterials) obj;
			if (null == this.getId() || null == mmSafetyProcedureMaterials.getId()) return false;
			else return (this.getId().equals(mmSafetyProcedureMaterials.getId()));
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