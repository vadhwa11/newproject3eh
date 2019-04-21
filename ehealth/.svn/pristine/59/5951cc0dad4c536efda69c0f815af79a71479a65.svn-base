package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_waste_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_waste_category"
 */

public abstract class BaseMasWasteCategory  implements Serializable {

	public static String REF = "MasWasteCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WASTE_CATEGORY_CODE = "WasteCategoryCode";
	public static String PROP_WASTE_CATEGORY_NAME = "WasteCategoryName";


	// constructors
	public BaseMasWasteCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasWasteCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String wasteCategoryCode;
	private java.lang.String wasteCategoryName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: waste_category_code
	 */
	public java.lang.String getWasteCategoryCode () {
		return wasteCategoryCode;
	}

	/**
	 * Set the value related to the column: waste_category_code
	 * @param wasteCategoryCode the waste_category_code value
	 */
	public void setWasteCategoryCode (java.lang.String wasteCategoryCode) {
		this.wasteCategoryCode = wasteCategoryCode;
	}



	/**
	 * Return the value associated with the column: waste_category_name
	 */
	public java.lang.String getWasteCategoryName () {
		return wasteCategoryName;
	}

	/**
	 * Set the value related to the column: waste_category_name
	 * @param wasteCategoryName the waste_category_name value
	 */
	public void setWasteCategoryName (java.lang.String wasteCategoryName) {
		this.wasteCategoryName = wasteCategoryName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasWasteCategory)) return false;
		else {
			jkt.hms.masters.business.MasWasteCategory masWasteCategory = (jkt.hms.masters.business.MasWasteCategory) obj;
			if (null == this.getId() || null == masWasteCategory.getId()) return false;
			else return (this.getId().equals(masWasteCategory.getId()));
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