package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp1 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp1"
 */

public abstract class BaseTemp1  implements Serializable {

	public static String REF = "Temp1";
	public static String PROP_NOMENCLATURE = "Nomenclature";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_ISSUED = "QtyIssued";


	// constructors
	public BaseTemp1 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTemp1 (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String nomenclature;
	private java.lang.Integer qtyIssued;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: qty_issued
	 */
	public java.lang.Integer getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.lang.Integer qtyIssued) {
		this.qtyIssued = qtyIssued;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Temp1)) return false;
		else {
			jkt.hms.masters.business.Temp1 temp1 = (jkt.hms.masters.business.Temp1) obj;
			if (null == this.getId() || null == temp1.getId()) return false;
			else return (this.getId().equals(temp1.getId()));
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