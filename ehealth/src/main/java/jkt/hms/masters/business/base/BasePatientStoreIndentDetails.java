package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * patient_store_indent_details table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="patient_store_indent_details"
 */

public abstract class BasePatientStoreIndentDetails implements Serializable {

	public static String REF = "PatientStoreIndentDetails";
	public static String PROP_PATIENT_STORE_INDENT_HEADER = "PatientStoreIndentHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_ITEM = "Item";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_STOCK_IN_HAND = "StockInHand";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_REQUEST = "QtyRequest";

	// constructors
	public BasePatientStoreIndentDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientStoreIndentDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.Integer stockInHand;
	private java.lang.Integer qtyRequest;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.PatientStoreIndentHeader patientStoreIndentHeader;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="patient_store_indent_details_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: stock_in_hand
	 */
	public java.lang.Integer getStockInHand() {
		return stockInHand;
	}

	/**
	 * Set the value related to the column: stock_in_hand
	 * 
	 * @param stockInHand
	 *            the stock_in_hand value
	 */
	public void setStockInHand(java.lang.Integer stockInHand) {
		this.stockInHand = stockInHand;
	}

	/**
	 * Return the value associated with the column: qty_request
	 */
	public java.lang.Integer getQtyRequest() {
		return qtyRequest;
	}

	/**
	 * Set the value related to the column: qty_request
	 * 
	 * @param qtyRequest
	 *            the qty_request value
	 */
	public void setQtyRequest(java.lang.Integer qtyRequest) {
		this.qtyRequest = qtyRequest;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column:
	 * patient_store_indent_header_id
	 */
	public jkt.hms.masters.business.PatientStoreIndentHeader getPatientStoreIndentHeader() {
		return patientStoreIndentHeader;
	}

	/**
	 * Set the value related to the column: patient_store_indent_header_id
	 * 
	 * @param patientStoreIndentHeader
	 *            the patient_store_indent_header_id value
	 */
	public void setPatientStoreIndentHeader(
			jkt.hms.masters.business.PatientStoreIndentHeader patientStoreIndentHeader) {
		this.patientStoreIndentHeader = patientStoreIndentHeader;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.PatientStoreIndentDetails)) {
			return false;
		} else {
			jkt.hms.masters.business.PatientStoreIndentDetails patientStoreIndentDetails = (jkt.hms.masters.business.PatientStoreIndentDetails) obj;
			if (null == this.getId()
					|| null == patientStoreIndentDetails.getId()) {
				return false;
			} else {
				return (this.getId().equals(patientStoreIndentDetails.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}