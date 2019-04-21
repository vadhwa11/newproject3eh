package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_nursing_care table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_nursing_care"
 */

public abstract class BaseMasNursingCare  implements Serializable {

	public static String REF = "MasNursingCare";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NURSING_NAME = "NursingName";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEFAULTSTATUS = "Defaultstatus";
	public static String PROP_NURSING_CODE = "NursingCode";


	// constructors
	public BaseMasNursingCare () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasNursingCare (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasNursingCare (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String nursingCode;
	private java.lang.String nursingName;
	private java.lang.String defaultstatus;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;
	private java.util.Set<jkt.hms.masters.business.Caresummary> caresummaries;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="nursing_id"
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
	 * Return the value associated with the column: nursing_code
	 */
	public java.lang.String getNursingCode () {
		return nursingCode;
	}

	/**
	 * Set the value related to the column: nursing_code
	 * @param nursingCode the nursing_code value
	 */
	public void setNursingCode (java.lang.String nursingCode) {
		this.nursingCode = nursingCode;
	}



	/**
	 * Return the value associated with the column: nursing_name
	 */
	public java.lang.String getNursingName () {
		return nursingName;
	}

	/**
	 * Set the value related to the column: nursing_name
	 * @param nursingName the nursing_name value
	 */
	public void setNursingName (java.lang.String nursingName) {
		this.nursingName = nursingName;
	}



	/**
	 * Return the value associated with the column: defaultstatus
	 */
	public java.lang.String getDefaultstatus () {
		return defaultstatus;
	}

	/**
	 * Set the value related to the column: defaultstatus
	 * @param defaultstatus the defaultstatus value
	 */
	public void setDefaultstatus (java.lang.String defaultstatus) {
		this.defaultstatus = defaultstatus;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: NursingcareSetups
	 */
	public java.util.Set<jkt.hms.masters.business.NursingcareSetup> getNursingcareSetups () {
		return nursingcareSetups;
	}

	/**
	 * Set the value related to the column: NursingcareSetups
	 * @param nursingcareSetups the NursingcareSetups value
	 */
	public void setNursingcareSetups (java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups) {
		this.nursingcareSetups = nursingcareSetups;
	}

	public void addToNursingcareSetups (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		if (null == getNursingcareSetups()) setNursingcareSetups(new java.util.TreeSet<jkt.hms.masters.business.NursingcareSetup>());
		getNursingcareSetups().add(nursingcareSetup);
	}



	/**
	 * Return the value associated with the column: Caresummaries
	 */
	public java.util.Set<jkt.hms.masters.business.Caresummary> getCaresummaries () {
		return caresummaries;
	}

	/**
	 * Set the value related to the column: Caresummaries
	 * @param caresummaries the Caresummaries value
	 */
	public void setCaresummaries (java.util.Set<jkt.hms.masters.business.Caresummary> caresummaries) {
		this.caresummaries = caresummaries;
	}

	public void addToCaresummaries (jkt.hms.masters.business.Caresummary caresummary) {
		if (null == getCaresummaries()) setCaresummaries(new java.util.TreeSet<jkt.hms.masters.business.Caresummary>());
		getCaresummaries().add(caresummary);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasNursingCare)) return false;
		else {
			jkt.hms.masters.business.MasNursingCare masNursingCare = (jkt.hms.masters.business.MasNursingCare) obj;
			if (null == this.getId() || null == masNursingCare.getId()) return false;
			else return (this.getId().equals(masNursingCare.getId()));
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