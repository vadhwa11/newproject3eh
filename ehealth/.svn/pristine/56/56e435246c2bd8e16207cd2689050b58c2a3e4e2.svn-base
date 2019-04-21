package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_category"
 */

public abstract class BaseMasCategory  implements Serializable {

	public static String REF = "MasCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY_CODE = "CategoryCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CATEGORY_NAME = "CategoryName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String categoryCode;
	private java.lang.String categoryName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="category_id"
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
	 * Return the value associated with the column: category_code
	 */
	public java.lang.String getCategoryCode () {
		return categoryCode;
	}

	/**
	 * Set the value related to the column: category_code
	 * @param categoryCode the category_code value
	 */
	public void setCategoryCode (java.lang.String categoryCode) {
		this.categoryCode = categoryCode;
	}



	/**
	 * Return the value associated with the column: category_name
	 */
	public java.lang.String getCategoryName () {
		return categoryName;
	}

	/**
	 * Set the value related to the column: category_name
	 * @param categoryName the category_name value
	 */
	public void setCategoryName (java.lang.String categoryName) {
		this.categoryName = categoryName;
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



	/**
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCategory)) return false;
		else {
			jkt.hms.masters.business.MasCategory masCategory = (jkt.hms.masters.business.MasCategory) obj;
			if (null == this.getId() || null == masCategory.getId()) return false;
			else return (this.getId().equals(masCategory.getId()));
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