package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_menu_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_menu_type"
 */

public abstract class BaseMasMenuType  implements Serializable {

	public static String REF = "MasMenuType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MENU_NAME = "MenuName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MENU_CODE = "MenuCode";


	// constructors
	public BaseMasMenuType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMenuType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String menuCode;
	private java.lang.String menuName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDietCombination> masDietCombinations;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="menu_id"
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
	 * Return the value associated with the column: menu_code
	 */
	public java.lang.String getMenuCode () {
		return menuCode;
	}

	/**
	 * Set the value related to the column: menu_code
	 * @param menuCode the menu_code value
	 */
	public void setMenuCode (java.lang.String menuCode) {
		this.menuCode = menuCode;
	}



	/**
	 * Return the value associated with the column: menu_name
	 */
	public java.lang.String getMenuName () {
		return menuName;
	}

	/**
	 * Set the value related to the column: menu_name
	 * @param menuName the menu_name value
	 */
	public void setMenuName (java.lang.String menuName) {
		this.menuName = menuName;
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
	 * Return the value associated with the column: MasDietCombinations
	 */
	public java.util.Set<jkt.hms.masters.business.MasDietCombination> getMasDietCombinations () {
		return masDietCombinations;
	}

	/**
	 * Set the value related to the column: MasDietCombinations
	 * @param masDietCombinations the MasDietCombinations value
	 */
	public void setMasDietCombinations (java.util.Set<jkt.hms.masters.business.MasDietCombination> masDietCombinations) {
		this.masDietCombinations = masDietCombinations;
	}

	public void addToMasDietCombinations (jkt.hms.masters.business.MasDietCombination masDietCombination) {
		if (null == getMasDietCombinations()) setMasDietCombinations(new java.util.TreeSet<jkt.hms.masters.business.MasDietCombination>());
		getMasDietCombinations().add(masDietCombination);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMenuType)) return false;
		else {
			jkt.hms.masters.business.MasMenuType masMenuType = (jkt.hms.masters.business.MasMenuType) obj;
			if (null == this.getId() || null == masMenuType.getId()) return false;
			else return (this.getId().equals(masMenuType.getId()));
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