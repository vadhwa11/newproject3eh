package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prescription_mapping table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prescription_mapping"
 */

public abstract class BasePrescriptionMapping  implements Serializable {

	public static String REF = "PrescriptionMapping";
	public static String PROP_ITEM = "Item";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NOOFDAYS = "Noofdays";
	public static String PROP_ROUTE = "Route";


	// constructors
	public BasePrescriptionMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrescriptionMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dosage;
	private java.lang.Integer noofdays;

	// many to one
	private jkt.hms.masters.business.RouteOfAdministration route;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="prescription_mapping_id"
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
	 * Return the value associated with the column: dosage
	 */
	public java.lang.String getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.lang.String dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: noofdays
	 */
	public java.lang.Integer getNoofdays () {
		return noofdays;
	}

	/**
	 * Set the value related to the column: noofdays
	 * @param noofdays the noofdays value
	 */
	public void setNoofdays (java.lang.Integer noofdays) {
		this.noofdays = noofdays;
	}



	/**
	 * Return the value associated with the column: route_id
	 */
	public jkt.hms.masters.business.RouteOfAdministration getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route_id
	 * @param route the route_id value
	 */
	public void setRoute (jkt.hms.masters.business.RouteOfAdministration route) {
		this.route = route;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrescriptionMapping)) return false;
		else {
			jkt.hms.masters.business.PrescriptionMapping prescriptionMapping = (jkt.hms.masters.business.PrescriptionMapping) obj;
			if (null == this.getId() || null == prescriptionMapping.getId()) return false;
			else return (this.getId().equals(prescriptionMapping.getId()));
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