package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_instruction_treatment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_instruction_treatment"
 */

public abstract class BaseOpdInstructionTreatment  implements Serializable {

	public static String REF = "OpdInstructionTreatment";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_OPD_INSTRUCTION_TREATMENT_CODE = "OpdInstructionTreatmentCode";
	public static String PROP_OPD_INSTRUCTION_TREATMENT_NAME = "OpdInstructionTreatmentName";


	// constructors
	public BaseOpdInstructionTreatment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdInstructionTreatment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String opdInstructionTreatmentCode;
	private java.lang.String opdInstructionTreatmentName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> opdTemplateTreatments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="opd_instruction_treatment_id"
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
	 * Return the value associated with the column: opd_instruction_treatment_code
	 */
	public java.lang.String getOpdInstructionTreatmentCode () {
		return opdInstructionTreatmentCode;
	}

	/**
	 * Set the value related to the column: opd_instruction_treatment_code
	 * @param opdInstructionTreatmentCode the opd_instruction_treatment_code value
	 */
	public void setOpdInstructionTreatmentCode (java.lang.String opdInstructionTreatmentCode) {
		this.opdInstructionTreatmentCode = opdInstructionTreatmentCode;
	}



	/**
	 * Return the value associated with the column: opd_instruction_treatment_name
	 */
	public java.lang.String getOpdInstructionTreatmentName () {
		return opdInstructionTreatmentName;
	}

	/**
	 * Set the value related to the column: opd_instruction_treatment_name
	 * @param opdInstructionTreatmentName the opd_instruction_treatment_name value
	 */
	public void setOpdInstructionTreatmentName (java.lang.String opdInstructionTreatmentName) {
		this.opdInstructionTreatmentName = opdInstructionTreatmentName;
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
	 * Return the value associated with the column: OpdTemplateTreatments
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> getOpdTemplateTreatments () {
		return opdTemplateTreatments;
	}

	/**
	 * Set the value related to the column: OpdTemplateTreatments
	 * @param opdTemplateTreatments the OpdTemplateTreatments value
	 */
	public void setOpdTemplateTreatments (java.util.Set<jkt.hms.masters.business.OpdTemplateTreatment> opdTemplateTreatments) {
		this.opdTemplateTreatments = opdTemplateTreatments;
	}

	public void addToOpdTemplateTreatments (jkt.hms.masters.business.OpdTemplateTreatment opdTemplateTreatment) {
		if (null == getOpdTemplateTreatments()) setOpdTemplateTreatments(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateTreatment>());
		getOpdTemplateTreatments().add(opdTemplateTreatment);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdInstructionTreatment)) return false;
		else {
			jkt.hms.masters.business.OpdInstructionTreatment opdInstructionTreatment = (jkt.hms.masters.business.OpdInstructionTreatment) obj;
			if (null == this.getId() || null == opdInstructionTreatment.getId()) return false;
			else return (this.getId().equals(opdInstructionTreatment.getId()));
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