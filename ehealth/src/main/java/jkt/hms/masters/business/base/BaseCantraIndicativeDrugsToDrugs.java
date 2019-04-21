package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the cantra_indicative_drugs_to_drugs table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="cantra_indicative_drugs_to_drugs"
 */

public abstract class BaseCantraIndicativeDrugsToDrugs  implements Serializable {

	public static String REF = "CantraIndicativeDrugsToDrugs";
	public static String PROP_CANTRA_INDICATIVE_DRUGS_B = "CantraIndicativeDrugsB";
	public static String PROP_CANTRA_INDICATIVE_DRUGS_A = "CantraIndicativeDrugsA";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCantraIndicativeDrugsToDrugs () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCantraIndicativeDrugsToDrugs (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasStoreItem cantraIndicativeDrugsB;
	private jkt.hms.masters.business.MasStoreItem cantraIndicativeDrugsA;



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
	 * Return the value associated with the column: cantra_indicative_drugs_b
	 */
	public jkt.hms.masters.business.MasStoreItem getCantraIndicativeDrugsB () {
		return cantraIndicativeDrugsB;
	}

	/**
	 * Set the value related to the column: cantra_indicative_drugs_b
	 * @param cantraIndicativeDrugsB the cantra_indicative_drugs_b value
	 */
	public void setCantraIndicativeDrugsB (jkt.hms.masters.business.MasStoreItem cantraIndicativeDrugsB) {
		this.cantraIndicativeDrugsB = cantraIndicativeDrugsB;
	}



	/**
	 * Return the value associated with the column: cantra_indicative_drugs_a
	 */
	public jkt.hms.masters.business.MasStoreItem getCantraIndicativeDrugsA () {
		return cantraIndicativeDrugsA;
	}

	/**
	 * Set the value related to the column: cantra_indicative_drugs_a
	 * @param cantraIndicativeDrugsA the cantra_indicative_drugs_a value
	 */
	public void setCantraIndicativeDrugsA (jkt.hms.masters.business.MasStoreItem cantraIndicativeDrugsA) {
		this.cantraIndicativeDrugsA = cantraIndicativeDrugsA;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CantraIndicativeDrugsToDrugs)) return false;
		else {
			jkt.hms.masters.business.CantraIndicativeDrugsToDrugs cantraIndicativeDrugsToDrugs = (jkt.hms.masters.business.CantraIndicativeDrugsToDrugs) obj;
			if (null == this.getId() || null == cantraIndicativeDrugsToDrugs.getId()) return false;
			else return (this.getId().equals(cantraIndicativeDrugsToDrugs.getId()));
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