package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_instruction_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_instruction_master"
 */

public abstract class BaseMasInstructionMaster  implements Serializable {

	public static String REF = "MasInstructionMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_INSTRUCTION_NAME = "InstructionName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_INSTRUCTION_CODE = "InstructionCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasInstructionMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasInstructionMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String instructionCode;
	private java.lang.String instructionName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="instruction_id"
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
	 * Return the value associated with the column: instruction_code
	 */
	public java.lang.String getInstructionCode () {
		return instructionCode;
	}

	/**
	 * Set the value related to the column: instruction_code
	 * @param instructionCode the instruction_code value
	 */
	public void setInstructionCode (java.lang.String instructionCode) {
		this.instructionCode = instructionCode;
	}



	/**
	 * Return the value associated with the column: instruction_name
	 */
	public java.lang.String getInstructionName () {
		return instructionName;
	}

	/**
	 * Set the value related to the column: instruction_name
	 * @param instructionName the instruction_name value
	 */
	public void setInstructionName (java.lang.String instructionName) {
		this.instructionName = instructionName;
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
	 * Return the value associated with the column: PatientPrescriptionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionDetails
	 * @param patientPrescriptionDetails the PatientPrescriptionDetails value
	 */
	public void setPatientPrescriptionDetails (java.util.Set<jkt.hms.masters.business.PatientPrescriptionDetails> patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}

	public void addToPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		if (null == getPatientPrescriptionDetails()) setPatientPrescriptionDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionDetails>());
		getPatientPrescriptionDetails().add(patientPrescriptionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasInstructionMaster)) return false;
		else {
			jkt.hms.masters.business.MasInstructionMaster masInstructionMaster = (jkt.hms.masters.business.MasInstructionMaster) obj;
			if (null == this.getId() || null == masInstructionMaster.getId()) return false;
			else return (this.getId().equals(masInstructionMaster.getId()));
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