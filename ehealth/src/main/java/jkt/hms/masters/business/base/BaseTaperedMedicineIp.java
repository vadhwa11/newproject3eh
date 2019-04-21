package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the tapered_medicine_ip table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="tapered_medicine_ip"
 */

public abstract class BaseTaperedMedicineIp  implements Serializable {

	public static String REF = "TaperedMedicineIp";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_ITEM = "Item";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_TOTAL = "Total";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DOSAGE_DETAIL = "DosageDetail";
	public static String PROP_ID = "Id";
	public static String PROP_DOSAGE = "Dosage";


	// constructors
	public BaseTaperedMedicineIp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTaperedMedicineIp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dosageDetail;
	private java.math.BigDecimal dosage;
	private java.lang.Integer noOfDays;
	private java.math.BigDecimal total;

	// many to one
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.InpatientPrescriptionDetails prescription;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="tapered_id"
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
	 * Return the value associated with the column: dosage_detail
	 */
	public java.lang.String getDosageDetail () {
		return dosageDetail;
	}

	/**
	 * Set the value related to the column: dosage_detail
	 * @param dosageDetail the dosage_detail value
	 */
	public void setDosageDetail (java.lang.String dosageDetail) {
		this.dosageDetail = dosageDetail;
	}



	/**
	 * Return the value associated with the column: dosage
	 */
	public java.math.BigDecimal getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.math.BigDecimal dosage) {
		this.dosage = dosage;
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
	 * Return the value associated with the column: total
	 */
	public java.math.BigDecimal getTotal () {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * @param total the total value
	 */
	public void setTotal (java.math.BigDecimal total) {
		this.total = total;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
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
	 * Return the value associated with the column: prescription_id
	 */
	public jkt.hms.masters.business.InpatientPrescriptionDetails getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: prescription_id
	 * @param prescription the prescription_id value
	 */
	public void setPrescription (jkt.hms.masters.business.InpatientPrescriptionDetails prescription) {
		this.prescription = prescription;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TaperedMedicineIp)) return false;
		else {
			jkt.hms.masters.business.TaperedMedicineIp taperedMedicineIp = (jkt.hms.masters.business.TaperedMedicineIp) obj;
			if (null == this.getId() || null == taperedMedicineIp.getId()) return false;
			else return (this.getId().equals(taperedMedicineIp.getId()));
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