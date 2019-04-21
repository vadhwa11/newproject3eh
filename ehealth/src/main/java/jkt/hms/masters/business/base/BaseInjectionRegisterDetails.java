package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the injection_register_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="injection_register_details"
 */

public abstract class BaseInjectionRegisterDetails  implements Serializable {

	public static String REF = "InjectionRegisterDetails";
	public static String PROP_DOSE = "Dose";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INJECTION_REGISTER = "InjectionRegister";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_ROUTE = "Route";


	// constructors
	public BaseInjectionRegisterDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInjectionRegisterDetails (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String dose;
	private java.lang.String route;
	private java.lang.Integer noOfDays;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.InjectionRegister injectionRegister;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="injection_register_details_id"
     */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: route
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route
	 * @param route the route value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
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
	 * Return the value associated with the column: injection_register
	 */
	public jkt.hms.masters.business.InjectionRegister getInjectionRegister () {
		return injectionRegister;
	}

	/**
	 * Set the value related to the column: injection_register
	 * @param injectionRegister the injection_register value
	 */
	public void setInjectionRegister (jkt.hms.masters.business.InjectionRegister injectionRegister) {
		this.injectionRegister = injectionRegister;
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
	 * Return the value associated with the column: frequency
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param frequency the frequency value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.InjectionRegisterDetails)) return false;
		else {
			jkt.hms.masters.business.InjectionRegisterDetails injectionRegisterDetails = (jkt.hms.masters.business.InjectionRegisterDetails) obj;
			if (null == this.getId() || null == injectionRegisterDetails.getId()) return false;
			else return (this.getId().equals(injectionRegisterDetails.getId()));
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