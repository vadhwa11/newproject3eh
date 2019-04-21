package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the cantra_indicative_drugs_to_deasease table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="cantra_indicative_drugs_to_deasease"
 */

public abstract class BaseCantraIndicativeDrugsToDeasease  implements Serializable {

	public static String REF = "CantraIndicativeDrugsToDeasease";
	public static String PROP_ICD = "Icd";
	public static String PROP_CANTRA_INDICATIVE_DRUGS = "CantraIndicativeDrugs";
	public static String PROP_ICD_CODE = "IcdCode";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCantraIndicativeDrugsToDeasease () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCantraIndicativeDrugsToDeasease (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String icdCode;

	// many to one
	private jkt.hms.masters.business.MasStoreItem cantraIndicativeDrugs;
	private jkt.hms.masters.business.MasIcd icd;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
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
	 * Return the value associated with the column: icd_code
	 */
	public java.lang.String getIcdCode () {
		return icdCode;
	}

	/**
	 * Set the value related to the column: icd_code
	 * @param icdCode the icd_code value
	 */
	public void setIcdCode (java.lang.String icdCode) {
		this.icdCode = icdCode;
	}



	/**
	 * Return the value associated with the column: cantra_indicative_drugs
	 */
	public jkt.hms.masters.business.MasStoreItem getCantraIndicativeDrugs () {
		return cantraIndicativeDrugs;
	}

	/**
	 * Set the value related to the column: cantra_indicative_drugs
	 * @param cantraIndicativeDrugs the cantra_indicative_drugs value
	 */
	public void setCantraIndicativeDrugs (jkt.hms.masters.business.MasStoreItem cantraIndicativeDrugs) {
		this.cantraIndicativeDrugs = cantraIndicativeDrugs;
	}



	/**
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icd the icd_id value
	 */
	public void setIcd (jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CantraIndicativeDrugsToDeasease)) return false;
		else {
			jkt.hms.masters.business.CantraIndicativeDrugsToDeasease cantraIndicativeDrugsToDeasease = (jkt.hms.masters.business.CantraIndicativeDrugsToDeasease) obj;
			if (null == this.getId() || null == cantraIndicativeDrugsToDeasease.getId()) return false;
			else return (this.getId().equals(cantraIndicativeDrugsToDeasease.getId()));
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