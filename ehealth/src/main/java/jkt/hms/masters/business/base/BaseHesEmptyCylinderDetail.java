package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_empty_cylinder_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_empty_cylinder_detail"
 */

public abstract class BaseHesEmptyCylinderDetail  implements Serializable {

	public static String REF = "HesEmptyCylinderDetail";
	public static String PROP_CYLINDERID = "Cylinderid";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CYLINDER_HEADER = "CylinderHeader";
	public static String PROP_ID = "Id";


	// constructors
	public BaseHesEmptyCylinderDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEmptyCylinderDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHesEmptyCylinderDetail (
		java.lang.Integer id,
		jkt.hms.masters.business.HesEmptyCylinderHeader cylinderHeader,
		jkt.hms.masters.business.HesCylinderTypeMaster cylinderid,
		java.lang.Integer quantity,
		java.lang.String status) {

		this.setId(id);
		this.setCylinderHeader(cylinderHeader);
		this.setCylinderid(cylinderid);
		this.setQuantity(quantity);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.HesEmptyCylinderHeader cylinderHeader;
	private jkt.hms.masters.business.HesCylinderTypeMaster cylinderid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="emptyCylinderId"
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
	 * Return the value associated with the column: cylinderHeaderId
	 */
	public jkt.hms.masters.business.HesEmptyCylinderHeader getCylinderHeader () {
		return cylinderHeader;
	}

	/**
	 * Set the value related to the column: cylinderHeaderId
	 * @param cylinderHeader the cylinderHeaderId value
	 */
	public void setCylinderHeader (jkt.hms.masters.business.HesEmptyCylinderHeader cylinderHeader) {
		this.cylinderHeader = cylinderHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.HesEmptyCylinderDetail)) return false;
		else {
			jkt.hms.masters.business.HesEmptyCylinderDetail hesEmptyCylinderDetail = (jkt.hms.masters.business.HesEmptyCylinderDetail) obj;
			if (null == this.getId() || null == hesEmptyCylinderDetail.getId()) return false;
			else return (this.getId().equals(hesEmptyCylinderDetail.getId()));
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