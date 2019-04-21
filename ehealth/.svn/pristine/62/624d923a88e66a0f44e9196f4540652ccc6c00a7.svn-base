package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_phototherapy_proforma_detail_dosage table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_phototherapy_proforma_detail_dosage"
 */

public abstract class BaseOpdPhototherapyProformaDetailDosage  implements Serializable {

	public static String REF = "OpdPhototherapyProformaDetailDosage";
	public static String PROP_STATUS = "Status";
	public static String PROP_FLAG = "Flag";
	public static String PROP_DOSAGE_DATE = "DosageDate";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_PHOTOTHERAPY_PROFORMA = "PhototherapyProforma";
	public static String PROP_PARAMETER_NAME = "ParameterName";
	public static String PROP_HIN = "Hin";
	public static String PROP_SCORE = "Score";
	public static String PROP_INCREMENT_PERCENTAGE = "IncrementPercentage";


	// constructors
	public BaseOpdPhototherapyProformaDetailDosage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPhototherapyProformaDetailDosage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String parameterName;
	private java.lang.String status;
	private java.lang.String flag;
	private java.util.Date dosageDate;
	private java.lang.Float incrementPercentage;
	private java.lang.Float dosage;
	private java.lang.String score;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.OpdPhototherapyProformaHeader phototherapyProforma;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="phototherapy_proforma_detail_dosage_id"
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
	 * Return the value associated with the column: parameter_name
	 */
	public java.lang.String getParameterName () {
		return parameterName;
	}

	/**
	 * Set the value related to the column: parameter_name
	 * @param parameterName the parameter_name value
	 */
	public void setParameterName (java.lang.String parameterName) {
		this.parameterName = parameterName;
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
	 * Return the value associated with the column: dosage_date
	 */
	public java.util.Date getDosageDate () {
		return dosageDate;
	}

	/**
	 * Set the value related to the column: dosage_date
	 * @param dosageDate the dosage_date value
	 */
	public void setDosageDate (java.util.Date dosageDate) {
		this.dosageDate = dosageDate;
	}



	/**
	 * Return the value associated with the column: increment_percentage
	 */
	public java.lang.Float getIncrementPercentage () {
		return incrementPercentage;
	}

	/**
	 * Set the value related to the column: increment_percentage
	 * @param incrementPercentage the increment_percentage value
	 */
	public void setIncrementPercentage (java.lang.Float incrementPercentage) {
		this.incrementPercentage = incrementPercentage;
	}



	/**
	 * Return the value associated with the column: dosage
	 */
	public java.lang.Float getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.lang.Float dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: score
	 */
	public java.lang.String getScore () {
		return score;
	}

	/**
	 * Set the value related to the column: score
	 * @param score the score value
	 */
	public void setScore (java.lang.String score) {
		this.score = score;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: phototherapy_proforma_id
	 */
	public jkt.hms.masters.business.OpdPhototherapyProformaHeader getPhototherapyProforma () {
		return phototherapyProforma;
	}

	/**
	 * Set the value related to the column: phototherapy_proforma_id
	 * @param phototherapyProforma the phototherapy_proforma_id value
	 */
	public void setPhototherapyProforma (jkt.hms.masters.business.OpdPhototherapyProformaHeader phototherapyProforma) {
		this.phototherapyProforma = phototherapyProforma;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPhototherapyProformaDetailDosage)) return false;
		else {
			jkt.hms.masters.business.OpdPhototherapyProformaDetailDosage opdPhototherapyProformaDetailDosage = (jkt.hms.masters.business.OpdPhototherapyProformaDetailDosage) obj;
			if (null == this.getId() || null == opdPhototherapyProformaDetailDosage.getId()) return false;
			else return (this.getId().equals(opdPhototherapyProformaDetailDosage.getId()));
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