package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_cylinder_usage_entry_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_cylinder_usage_entry_detail"
 */

public abstract class BaseHesCylinderUsageEntryDetail  implements Serializable {

	public static String REF = "HesCylinderUsageEntryDetail";
	public static String PROP_CYLINDER_USAGE_DATE = "CylinderUsageDate";
	public static String PROP_CYLINDERID = "Cylinderid";
	public static String PROP_STATUS = "Status";
	public static String PROP_CYLINDER_REMARKS = "CylinderRemarks";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CYLINDER_HEAD = "CylinderHead";
	public static String PROP_ID = "Id";
	public static String PROP_CYLINDER = "Cylinder";
	public static String PROP_CYLINDER_USAGE = "CylinderUsage";


	// constructors
	public BaseHesCylinderUsageEntryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesCylinderUsageEntryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date cylinderUsageDate;
	private java.lang.Integer quantity;
	private java.lang.String cylinderHead;
	private java.lang.String cylinderRemarks;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.HesCylinderUsageEntryHeader cylinderUsage;
	private jkt.hms.masters.business.HesCylinderUsageMaster cylinder;
	private jkt.hms.masters.business.HesCylinderTypeMaster cylinderid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="cylinder_detail_id"
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
	 * Return the value associated with the column: cylinder_usage_date
	 */
	public java.util.Date getCylinderUsageDate () {
		return cylinderUsageDate;
	}

	/**
	 * Set the value related to the column: cylinder_usage_date
	 * @param cylinderUsageDate the cylinder_usage_date value
	 */
	public void setCylinderUsageDate (java.util.Date cylinderUsageDate) {
		this.cylinderUsageDate = cylinderUsageDate;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: cylinder_head
	 */
	public java.lang.String getCylinderHead () {
		return cylinderHead;
	}

	/**
	 * Set the value related to the column: cylinder_head
	 * @param cylinderHead the cylinder_head value
	 */
	public void setCylinderHead (java.lang.String cylinderHead) {
		this.cylinderHead = cylinderHead;
	}



	/**
	 * Return the value associated with the column: cylinder_remarks
	 */
	public java.lang.String getCylinderRemarks () {
		return cylinderRemarks;
	}

	/**
	 * Set the value related to the column: cylinder_remarks
	 * @param cylinderRemarks the cylinder_remarks value
	 */
	public void setCylinderRemarks (java.lang.String cylinderRemarks) {
		this.cylinderRemarks = cylinderRemarks;
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
	 * Return the value associated with the column: cylinder_usage_id
	 */
	public jkt.hms.masters.business.HesCylinderUsageEntryHeader getCylinderUsage () {
		return cylinderUsage;
	}

	/**
	 * Set the value related to the column: cylinder_usage_id
	 * @param cylinderUsage the cylinder_usage_id value
	 */
	public void setCylinderUsage (jkt.hms.masters.business.HesCylinderUsageEntryHeader cylinderUsage) {
		this.cylinderUsage = cylinderUsage;
	}



	/**
	 * Return the value associated with the column: cylinder_id
	 */
	public jkt.hms.masters.business.HesCylinderUsageMaster getCylinder () {
		return cylinder;
	}

	/**
	 * Set the value related to the column: cylinder_id
	 * @param cylinder the cylinder_id value
	 */
	public void setCylinder (jkt.hms.masters.business.HesCylinderUsageMaster cylinder) {
		this.cylinder = cylinder;
	}



	/**
	 * Return the value associated with the column: cylinderid
	 */
	public jkt.hms.masters.business.HesCylinderTypeMaster getCylinderid () {
		return cylinderid;
	}

	/**
	 * Set the value related to the column: cylinderid
	 * @param cylinderid the cylinderid value
	 */
	public void setCylinderid (jkt.hms.masters.business.HesCylinderTypeMaster cylinderid) {
		this.cylinderid = cylinderid;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesCylinderUsageEntryDetail)) return false;
		else {
			jkt.hms.masters.business.HesCylinderUsageEntryDetail hesCylinderUsageEntryDetail = (jkt.hms.masters.business.HesCylinderUsageEntryDetail) obj;
			if (null == this.getId() || null == hesCylinderUsageEntryDetail.getId()) return false;
			else return (this.getId().equals(hesCylinderUsageEntryDetail.getId()));
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