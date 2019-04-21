package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the injection_register table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="injection_register"
 */

public abstract class BaseInjectionRegister  implements Serializable {

	public static String REF = "InjectionRegister";
	public static String PROP_STATUS = "Status";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INJECTION_TIME = "InjectionTime";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INJECTION_DATE = "InjectionDate";


	// constructors
	public BaseInjectionRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInjectionRegister (java.lang.Long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.util.Date injectionDate;
	private java.lang.String injectionTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.util.Date requisitionDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.InjectionRegisterDetails> injectionRegisterDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="injection_register_id"
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
	 * Return the value associated with the column: injection_date
	 */
	public java.util.Date getInjectionDate () {
		return injectionDate;
	}

	/**
	 * Set the value related to the column: injection_date
	 * @param injectionDate the injection_date value
	 */
	public void setInjectionDate (java.util.Date injectionDate) {
		this.injectionDate = injectionDate;
	}



	/**
	 * Return the value associated with the column: injection_time
	 */
	public java.lang.String getInjectionTime () {
		return injectionTime;
	}

	/**
	 * Set the value related to the column: injection_time
	 * @param injectionTime the injection_time value
	 */
	public void setInjectionTime (java.lang.String injectionTime) {
		this.injectionTime = injectionTime;
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
	 * Return the value associated with the column: requisition_date
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: requisition_date
	 * @param requisitionDate the requisition_date value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
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



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: InjectionRegisterDetails
	 */
	public java.util.Set<jkt.hms.masters.business.InjectionRegisterDetails> getInjectionRegisterDetails () {
		return injectionRegisterDetails;
	}

	/**
	 * Set the value related to the column: InjectionRegisterDetails
	 * @param injectionRegisterDetails the InjectionRegisterDetails value
	 */
	public void setInjectionRegisterDetails (java.util.Set<jkt.hms.masters.business.InjectionRegisterDetails> injectionRegisterDetails) {
		this.injectionRegisterDetails = injectionRegisterDetails;
	}

	public void addToInjectionRegisterDetails (jkt.hms.masters.business.InjectionRegisterDetails injectionRegisterDetails) {
		if (null == getInjectionRegisterDetails()) setInjectionRegisterDetails(new java.util.TreeSet<jkt.hms.masters.business.InjectionRegisterDetails>());
		getInjectionRegisterDetails().add(injectionRegisterDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.InjectionRegister)) return false;
		else {
			jkt.hms.masters.business.InjectionRegister injectionRegister = (jkt.hms.masters.business.InjectionRegister) obj;
			if (null == this.getId() || null == injectionRegister.getId()) return false;
			else return (this.getId().equals(injectionRegister.getId()));
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