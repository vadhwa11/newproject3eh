package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_advance_transfer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_advance_transfer"
 */

public abstract class BasePatientAdvanceTransfer  implements Serializable {

	public static String REF = "PatientAdvanceTransfer";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FROM_PATIENT = "FromPatient";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TRANSFER_TO = "TransferTo";
	public static String PROP_TO_PATIENT = "ToPatient";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TRANSFER_AMOUNT = "TransferAmount";


	// constructors
	public BasePatientAdvanceTransfer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientAdvanceTransfer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String transferTo;
	private java.math.BigDecimal transferAmount;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient fromPatient;
	private jkt.hms.masters.business.Patient toPatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="transfer_id"
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
	 * Return the value associated with the column: transfer_to
	 */
	public java.lang.String getTransferTo () {
		return transferTo;
	}

	/**
	 * Set the value related to the column: transfer_to
	 * @param transferTo the transfer_to value
	 */
	public void setTransferTo (java.lang.String transferTo) {
		this.transferTo = transferTo;
	}



	/**
	 * Return the value associated with the column: transfer_amount
	 */
	public java.math.BigDecimal getTransferAmount () {
		return transferAmount;
	}

	/**
	 * Set the value related to the column: transfer_amount
	 * @param transferAmount the transfer_amount value
	 */
	public void setTransferAmount (java.math.BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
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
	 * Return the value associated with the column: from_patient_id
	 */
	public jkt.hms.masters.business.Patient getFromPatient () {
		return fromPatient;
	}

	/**
	 * Set the value related to the column: from_patient_id
	 * @param fromPatient the from_patient_id value
	 */
	public void setFromPatient (jkt.hms.masters.business.Patient fromPatient) {
		this.fromPatient = fromPatient;
	}



	/**
	 * Return the value associated with the column: to_patient_id
	 */
	public jkt.hms.masters.business.Patient getToPatient () {
		return toPatient;
	}

	/**
	 * Set the value related to the column: to_patient_id
	 * @param toPatient the to_patient_id value
	 */
	public void setToPatient (jkt.hms.masters.business.Patient toPatient) {
		this.toPatient = toPatient;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientAdvanceTransfer)) return false;
		else {
			jkt.hms.masters.business.PatientAdvanceTransfer patientAdvanceTransfer = (jkt.hms.masters.business.PatientAdvanceTransfer) obj;
			if (null == this.getId() || null == patientAdvanceTransfer.getId()) return false;
			else return (this.getId().equals(patientAdvanceTransfer.getId()));
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