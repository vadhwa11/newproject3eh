package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bio_waste_hand_over table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bio_waste_hand_over"
 */

public abstract class BaseBioWasteHandOver  implements Serializable {

	public static String REF = "BioWasteHandOver";
	public static String PROP_QTY = "Qty";
	public static String PROP_COLOUR = "Colour";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_LAS_CHG_DATE = "LasChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CONTAINER = "Container";


	// constructors
	public BaseBioWasteHandOver () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBioWasteHandOver (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.util.Date lasChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String colour;
	private java.math.BigDecimal qty;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;
	public jkt.hms.masters.business.MasHospital getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	private jkt.hms.masters.business.MasWasteContainer container;
	private jkt.hms.masters.business.MasWasteCategory category;



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
	 * Return the value associated with the column: las_chg_date
	 */
	public java.util.Date getLasChgDate () {
		return lasChgDate;
	}

	/**
	 * Set the value related to the column: las_chg_date
	 * @param lasChgDate the las_chg_date value
	 */
	public void setLasChgDate (java.util.Date lasChgDate) {
		this.lasChgDate = lasChgDate;
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
	 * Return the value associated with the column: colour
	 */
	public java.lang.String getColour () {
		return colour;
	}

	/**
	 * Set the value related to the column: colour
	 * @param colour the colour value
	 */
	public void setColour (java.lang.String colour) {
		this.colour = colour;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.math.BigDecimal getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.math.BigDecimal qty) {
		this.qty = qty;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: waste_container_id
	 */
	public jkt.hms.masters.business.MasWasteContainer getContainer () {
		return container;
	}

	/**
	 * Set the value related to the column: waste_container_id
	 * @param container the waste_container_id value
	 */
	public void setContainer (jkt.hms.masters.business.MasWasteContainer container) {
		this.container = container;
	}



	/**
	 * Return the value associated with the column: waste_category_id
	 */
	public jkt.hms.masters.business.MasWasteCategory getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: waste_category_id
	 * @param category the waste_category_id value
	 */
	public void setCategory (jkt.hms.masters.business.MasWasteCategory category) {
		this.category = category;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BioWasteHandOver)) return false;
		else {
			jkt.hms.masters.business.BioWasteHandOver bioWasteHandOver = (jkt.hms.masters.business.BioWasteHandOver) obj;
			if (null == this.getId() || null == bioWasteHandOver.getId()) return false;
			else return (this.getId().equals(bioWasteHandOver.getId()));
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