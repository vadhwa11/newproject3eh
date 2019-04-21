package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_allergy_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_allergy_t"
 */

public abstract class BaseOpdPatientAllergyT  implements Serializable {

	public static String REF = "OpdPatientAllergyT";
	public static String PROP_STATUS = "Status";
	public static String PROP_OPD_PATIENT_ALLERGY = "OpdPatientAllergy";
	public static String PROP_ALLERGY = "Allergy";
	public static String PROP_BLOCKED_STATUS = "BlockedStatus";
	public static String PROP_FROM_MONTH = "FromMonth";
	public static String PROP_ALLERGY_REMARKS = "AllergyRemarks";
	public static String PROP_SEVERITY = "Severity";
	public static String PROP_FROM_YEAR = "FromYear";
	public static String PROP_ID = "Id";
	public static String PROP_ALLERGEN = "Allergen";
	public static String PROP_BLOCK_DAYS = "BlockDays";


	// constructors
	public BaseOpdPatientAllergyT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientAllergyT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String allergen;
	private java.lang.String fromMonth;
	private java.lang.String fromYear;
	private java.lang.String status;
	private java.lang.String blockedStatus;
	private java.lang.Integer blockDays;
	private java.lang.String allergyRemarks;

	// many to one
	private jkt.hms.masters.business.MasAllergyProduct allergy;
	private jkt.hms.masters.business.OpdPatientAllergyM opdPatientAllergy;
	private jkt.hms.masters.business.MasSeverityCode severity;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="t_id"
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
	 * Return the value associated with the column: allergen
	 */
	public java.lang.String getAllergen () {
		return allergen;
	}

	/**
	 * Set the value related to the column: allergen
	 * @param allergen the allergen value
	 */
	public void setAllergen (java.lang.String allergen) {
		this.allergen = allergen;
	}



	/**
	 * Return the value associated with the column: from_month
	 */
	public java.lang.String getFromMonth () {
		return fromMonth;
	}

	/**
	 * Set the value related to the column: from_month
	 * @param fromMonth the from_month value
	 */
	public void setFromMonth (java.lang.String fromMonth) {
		this.fromMonth = fromMonth;
	}



	/**
	 * Return the value associated with the column: from_year
	 */
	public java.lang.String getFromYear () {
		return fromYear;
	}

	/**
	 * Set the value related to the column: from_year
	 * @param fromYear the from_year value
	 */
	public void setFromYear (java.lang.String fromYear) {
		this.fromYear = fromYear;
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
	 * Return the value associated with the column: blocked_status
	 */
	public java.lang.String getBlockedStatus () {
		return blockedStatus;
	}

	/**
	 * Set the value related to the column: blocked_status
	 * @param blockedStatus the blocked_status value
	 */
	public void setBlockedStatus (java.lang.String blockedStatus) {
		this.blockedStatus = blockedStatus;
	}



	/**
	 * Return the value associated with the column: block_days
	 */
	public java.lang.Integer getBlockDays () {
		return blockDays;
	}

	/**
	 * Set the value related to the column: block_days
	 * @param blockDays the block_days value
	 */
	public void setBlockDays (java.lang.Integer blockDays) {
		this.blockDays = blockDays;
	}



	/**
	 * Return the value associated with the column: allergy_remarks
	 */
	public java.lang.String getAllergyRemarks () {
		return allergyRemarks;
	}

	/**
	 * Set the value related to the column: allergy_remarks
	 * @param allergyRemarks the allergy_remarks value
	 */
	public void setAllergyRemarks (java.lang.String allergyRemarks) {
		this.allergyRemarks = allergyRemarks;
	}



	/**
	 * Return the value associated with the column: allergy_id
	 */
	public jkt.hms.masters.business.MasAllergyProduct getAllergy () {
		return allergy;
	}

	/**
	 * Set the value related to the column: allergy_id
	 * @param allergy the allergy_id value
	 */
	public void setAllergy (jkt.hms.masters.business.MasAllergyProduct allergy) {
		this.allergy = allergy;
	}



	/**
	 * Return the value associated with the column: opd_patient_allergy
	 */
	public jkt.hms.masters.business.OpdPatientAllergyM getOpdPatientAllergy () {
		return opdPatientAllergy;
	}

	/**
	 * Set the value related to the column: opd_patient_allergy
	 * @param opdPatientAllergy the opd_patient_allergy value
	 */
	public void setOpdPatientAllergy (jkt.hms.masters.business.OpdPatientAllergyM opdPatientAllergy) {
		this.opdPatientAllergy = opdPatientAllergy;
	}



	/**
	 * Return the value associated with the column: severity_id
	 */
	public jkt.hms.masters.business.MasSeverityCode getSeverity () {
		return severity;
	}

	/**
	 * Set the value related to the column: severity_id
	 * @param severity the severity_id value
	 */
	public void setSeverity (jkt.hms.masters.business.MasSeverityCode severity) {
		this.severity = severity;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientAllergyT)) return false;
		else {
			jkt.hms.masters.business.OpdPatientAllergyT opdPatientAllergyT = (jkt.hms.masters.business.OpdPatientAllergyT) obj;
			if (null == this.getId() || null == opdPatientAllergyT.getId()) return false;
			else return (this.getId().equals(opdPatientAllergyT.getId()));
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