package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the temp2 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="temp2"
 */

public abstract class BaseTemp2  implements Serializable {

	public static String REF = "Temp2";
	public static String PROP_UNIT_NAME = "UnitName";
	public static String PROP_STOCK_QTY = "StockQty";
	public static String PROP_ROL = "Rol";
	public static String PROP_PVMS_NO = "PvmsNo";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_ID = "Id";


	// constructors
	public BaseTemp2 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTemp2 (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemName;
	private java.lang.Integer rol;
	private java.lang.String pvmsNo;
	private java.lang.Integer stockQty;
	private java.lang.String unitName;



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
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName () {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * @param itemName the item_name value
	 */
	public void setItemName (java.lang.String itemName) {
		this.itemName = itemName;
	}



	/**
	 * Return the value associated with the column: rol
	 */
	public java.lang.Integer getRol () {
		return rol;
	}

	/**
	 * Set the value related to the column: rol
	 * @param rol the rol value
	 */
	public void setRol (java.lang.Integer rol) {
		this.rol = rol;
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
	 * Return the value associated with the column: stock_qty
	 */
	public java.lang.Integer getStockQty () {
		return stockQty;
	}

	/**
	 * Set the value related to the column: stock_qty
	 * @param stockQty the stock_qty value
	 */
	public void setStockQty (java.lang.Integer stockQty) {
		this.stockQty = stockQty;
	}



	/**
	 * Return the value associated with the column: unit_name
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: unit_name
	 * @param unitName the unit_name value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Temp2)) return false;
		else {
			jkt.hms.masters.business.Temp2 temp2 = (jkt.hms.masters.business.Temp2) obj;
			if (null == this.getId() || null == temp2.getId()) return false;
			else return (this.getId().equals(temp2.getId()));
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