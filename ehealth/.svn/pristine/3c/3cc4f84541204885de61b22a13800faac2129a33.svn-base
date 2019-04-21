package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ip_ward_consumption_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ip_ward_consumption_header"
 */

public abstract class BaseIpWardConsumptionHeader  implements Serializable {

	public static String REF = "IpWardConsumptionHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONSUMPTION_DATE = "ConsumptionDate";
	public static String PROP_ID = "Id";
	public static String PROP_INPATIENT_PRESCRIPTION_DETAILS = "InpatientPrescriptionDetails";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_BILL_STATUS= "BillStatus";
	

	// constructors
	public BaseIpWardConsumptionHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpWardConsumptionHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date consumptionDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime; 
	private java.lang.String BillStatus;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.InpatientPrescriptionDetails inpatientPrescriptionDetails;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpWardConsumptionDetails> ipWardConsumptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="consumption_id"
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
	 * Return the value associated with the column: consumption_date
	 */
	public java.util.Date getConsumptionDate () {
		return consumptionDate;
	}

	/**
	 * Set the value related to the column: consumption_date
	 * @param consumptionDate the consumption_date value
	 */
	public void setConsumptionDate (java.util.Date consumptionDate) {
		this.consumptionDate = consumptionDate;
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
	 * Return the value associated with the column: bill_status
	 */
	public java.lang.String getBillStatus() {
		return BillStatus;
	}
	/**
	 * Set the value related to the column: bill_status
	 * @param billStatus the bill_status value
	 */
	public void setBillStatus(java.lang.String billStatus) {
		BillStatus = billStatus;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: inpatient_prescription_details_id
	 */
	public jkt.hms.masters.business.InpatientPrescriptionDetails getInpatientPrescriptionDetails () {
		return inpatientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: inpatient_prescription_details_id
	 * @param inpatientPrescriptionDetails the inpatient_prescription_details_id value
	 */
	public void setInpatientPrescriptionDetails (jkt.hms.masters.business.InpatientPrescriptionDetails inpatientPrescriptionDetails) {
		this.inpatientPrescriptionDetails = inpatientPrescriptionDetails;
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
	 * Return the value associated with the column: IpWardConsumptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpWardConsumptionDetails> getIpWardConsumptionDetails () {
		return ipWardConsumptionDetails;
	}

	/**
	 * Set the value related to the column: IpWardConsumptionDetails
	 * @param ipWardConsumptionDetails the IpWardConsumptionDetails value
	 */
	public void setIpWardConsumptionDetails (java.util.Set<jkt.hms.masters.business.IpWardConsumptionDetails> ipWardConsumptionDetails) {
		this.ipWardConsumptionDetails = ipWardConsumptionDetails;
	}

	public void addToIpWardConsumptionDetails (jkt.hms.masters.business.IpWardConsumptionDetails ipWardConsumptionDetails) {
		if (null == getIpWardConsumptionDetails()) setIpWardConsumptionDetails(new java.util.TreeSet<jkt.hms.masters.business.IpWardConsumptionDetails>());
		getIpWardConsumptionDetails().add(ipWardConsumptionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpWardConsumptionHeader)) return false;
		else {
			jkt.hms.masters.business.IpWardConsumptionHeader ipWardConsumptionHeader = (jkt.hms.masters.business.IpWardConsumptionHeader) obj;
			if (null == this.getId() || null == ipWardConsumptionHeader.getId()) return false;
			else return (this.getId().equals(ipWardConsumptionHeader.getId()));
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