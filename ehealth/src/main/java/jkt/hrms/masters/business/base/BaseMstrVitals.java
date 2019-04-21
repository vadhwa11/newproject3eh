package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_vitals table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_vitals"
 */

public abstract class BaseMstrVitals  implements Serializable {

	public static String REF = "MstrVitals";
	public static String PROP_STATUS = "Status";
	public static String PROP_FLAG = "Flag";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VITAL_DESCRIPTION = "VitalDescription";
	public static String PROP_AMOUNT_FLAG = "AmountFlag";
	public static String PROP_ID = "Id";
	public static String PROP_VITAL_CODE = "VitalCode";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMstrVitals () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrVitals (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vitalCode;
	private java.lang.String vitalDescription;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String flag;
	private java.lang.String amountFlag;

	// many to one
	private jkt.hms.masters.business.MasHospital company;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="vital_id"
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
	 * Return the value associated with the column: vital_code
	 */
	public java.lang.String getVitalCode () {
		return vitalCode;
	}

	/**
	 * Set the value related to the column: vital_code
	 * @param vitalCode the vital_code value
	 */
	public void setVitalCode (java.lang.String vitalCode) {
		this.vitalCode = vitalCode;
	}



	/**
	 * Return the value associated with the column: vital_description
	 */
	public java.lang.String getVitalDescription () {
		return vitalDescription;
	}

	/**
	 * Set the value related to the column: vital_description
	 * @param vitalDescription the vital_description value
	 */
	public void setVitalDescription (java.lang.String vitalDescription) {
		this.vitalDescription = vitalDescription;
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
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: amount_flag
	 */
	public java.lang.String getAmountFlag () {
		return amountFlag;
	}

	/**
	 * Set the value related to the column: amount_flag
	 * @param amountFlag the amount_flag value
	 */
	public void setAmountFlag (java.lang.String amountFlag) {
		this.amountFlag = amountFlag;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrVitals)) return false;
		else {
			jkt.hrms.masters.business.MstrVitals mstrVitals = (jkt.hrms.masters.business.MstrVitals) obj;
			if (null == this.getId() || null == mstrVitals.getId()) return false;
			else return (this.getId().equals(mstrVitals.getId()));
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