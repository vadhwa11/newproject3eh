package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_cylinder_stock table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_cylinder_stock"
 */

public abstract class BaseHesCylinderStock  implements Serializable {

	public static String REF = "HesCylinderStock";
	public static String PROP_RECEIVED_QTY = "ReceivedQty";
	public static String PROP_CYLINDERID = "Cylinderid";
	public static String PROP_USAGE_EMPTY_CYLINDER = "UsageEmptyCylinder";
	public static String PROP_ISSUE_QTY = "IssueQty";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_OPENING_BALANCE_DATE = "OpeningBalanceDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_CLOSING_STOCK = "ClosingStock";
	public static String PROP_OPENING_BALANCE_QTY = "OpeningBalanceQty";


	// constructors
	public BaseHesCylinderStock () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesCylinderStock (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer closingStock;
	private java.lang.Integer issueQty;
	private java.util.Date openingBalanceDate;
	private java.lang.Integer openingBalanceQty;
	private java.lang.Integer receivedQty;
	private java.lang.Integer usageEmptyCylinder;

	// many to one
	private jkt.hms.masters.business.HesCylinderTypeMaster cylinderid;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="stock_id"
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
	 * Return the value associated with the column: closing_stock
	 */
	public java.lang.Integer getClosingStock () {
		return closingStock;
	}

	/**
	 * Set the value related to the column: closing_stock
	 * @param closingStock the closing_stock value
	 */
	public void setClosingStock (java.lang.Integer closingStock) {
		this.closingStock = closingStock;
	}



	/**
	 * Return the value associated with the column: issue_qty
	 */
	public java.lang.Integer getIssueQty () {
		return issueQty;
	}

	/**
	 * Set the value related to the column: issue_qty
	 * @param issueQty the issue_qty value
	 */
	public void setIssueQty (java.lang.Integer issueQty) {
		this.issueQty = issueQty;
	}



	/**
	 * Return the value associated with the column: opening_balance_date
	 */
	public java.util.Date getOpeningBalanceDate () {
		return openingBalanceDate;
	}

	/**
	 * Set the value related to the column: opening_balance_date
	 * @param openingBalanceDate the opening_balance_date value
	 */
	public void setOpeningBalanceDate (java.util.Date openingBalanceDate) {
		this.openingBalanceDate = openingBalanceDate;
	}



	/**
	 * Return the value associated with the column: opening_balance_qty
	 */
	public java.lang.Integer getOpeningBalanceQty () {
		return openingBalanceQty;
	}

	/**
	 * Set the value related to the column: opening_balance_qty
	 * @param openingBalanceQty the opening_balance_qty value
	 */
	public void setOpeningBalanceQty (java.lang.Integer openingBalanceQty) {
		this.openingBalanceQty = openingBalanceQty;
	}



	/**
	 * Return the value associated with the column: received_qty
	 */
	public java.lang.Integer getReceivedQty () {
		return receivedQty;
	}

	/**
	 * Set the value related to the column: received_qty
	 * @param receivedQty the received_qty value
	 */
	public void setReceivedQty (java.lang.Integer receivedQty) {
		this.receivedQty = receivedQty;
	}



	/**
	 * Return the value associated with the column: usage_empty_cylinder
	 */
	public java.lang.Integer getUsageEmptyCylinder () {
		return usageEmptyCylinder;
	}

	/**
	 * Set the value related to the column: usage_empty_cylinder
	 * @param usageEmptyCylinder the usage_empty_cylinder value
	 */
	public void setUsageEmptyCylinder (java.lang.Integer usageEmptyCylinder) {
		this.usageEmptyCylinder = usageEmptyCylinder;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesCylinderStock)) return false;
		else {
			jkt.hms.masters.business.HesCylinderStock hesCylinderStock = (jkt.hms.masters.business.HesCylinderStock) obj;
			if (null == this.getId() || null == hesCylinderStock.getId()) return false;
			else return (this.getId().equals(hesCylinderStock.getId()));
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