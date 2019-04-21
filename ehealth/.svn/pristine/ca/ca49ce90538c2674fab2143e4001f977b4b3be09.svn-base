package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_dept_reorder_level table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_dept_reorder_level"
 */

public abstract class BaseStoreDeptReorderLevel  implements Serializable {

	public static String REF = "StoreDeptReorderLevel";
	public static String PROP_ROL = "Rol";
	public static String PROP_ITEM = "Item";
	public static String PROP_MAX_STOCK = "MaxStock";
	public static String PROP_MIN_STOCK = "MinStock";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseStoreDeptReorderLevel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDeptReorderLevel (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal maxStock;
	private java.math.BigDecimal minStock;
	private java.math.BigDecimal rol;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="reorder_id"
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
	 * Return the value associated with the column: rol
	 */
	public java.math.BigDecimal getRol () {
		return rol;
	}

	/**
	 * Set the value related to the column: rol
	 * @param rol the rol value
	 */
	public void setRol (java.math.BigDecimal rol) {
		this.rol = rol;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreDeptReorderLevel)) return false;
		else {
			jkt.hms.masters.business.StoreDeptReorderLevel storeDeptReorderLevel = (jkt.hms.masters.business.StoreDeptReorderLevel) obj;
			if (null == this.getId() || null == storeDeptReorderLevel.getId()) return false;
			else return (this.getId().equals(storeDeptReorderLevel.getId()));
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