package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ip_ward_consumption_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ip_ward_consumption_details"
 */

public abstract class BaseIpWardConsumptionDetails  implements Serializable {

	public static String REF = "IpWardConsumptionDetails";
	public static String PROP_CONSUMPTION_STATUS = "ConsumptionStatus";
	public static String PROP_CONSUMPTION_TIME = "ConsumptionTime";
	public static String PROP_CONSUMPTION = "Consumption";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY_COUNT = "FrequencyCount";
	public static String PROP_STOCK = "Stock";
	public static String PROP_OUTSIDE_PRESCRIPTION = "OutsidePrescription";


	// constructors
	public BaseIpWardConsumptionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpWardConsumptionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String consumptionStatus;
	private java.lang.String consumptionTime;
	private java.lang.Integer frequencyCount;
	private java.lang.String outsidePrescription;

	// many to one
	private jkt.hms.masters.business.IpWardConsumptionHeader consumption;
	private jkt.hms.masters.business.StoreItemBatchStock stock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="consumption_details_id"
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
	 * Return the value associated with the column: consumption_status
	 */
	public java.lang.String getConsumptionStatus () {
		return consumptionStatus;
	}

	/**
	 * Set the value related to the column: consumption_status
	 * @param consumptionStatus the consumption_status value
	 */
	public void setConsumptionStatus (java.lang.String consumptionStatus) {
		this.consumptionStatus = consumptionStatus;
	}



	/**
	 * Return the value associated with the column: consumption_time
	 */
	public java.lang.String getConsumptionTime () {
		return consumptionTime;
	}

	/**
	 * Set the value related to the column: consumption_time
	 * @param consumptionTime the consumption_time value
	 */
	public void setConsumptionTime (java.lang.String consumptionTime) {
		this.consumptionTime = consumptionTime;
	}



	/**
	 * Return the value associated with the column: frequency_count
	 */
	public java.lang.Integer getFrequencyCount () {
		return frequencyCount;
	}

	/**
	 * Set the value related to the column: frequency_count
	 * @param frequencyCount the frequency_count value
	 */
	public void setFrequencyCount (java.lang.Integer frequencyCount) {
		this.frequencyCount = frequencyCount;
	}



	/**
	 * Return the value associated with the column: outside_prescription
	 */
	public java.lang.String getOutsidePrescription () {
		return outsidePrescription;
	}

	/**
	 * Set the value related to the column: outside_prescription
	 * @param outsidePrescription the outside_prescription value
	 */
	public void setOutsidePrescription (java.lang.String outsidePrescription) {
		this.outsidePrescription = outsidePrescription;
	}



	/**
	 * Return the value associated with the column: consumption_id
	 */
	public jkt.hms.masters.business.IpWardConsumptionHeader getConsumption () {
		return consumption;
	}

	/**
	 * Set the value related to the column: consumption_id
	 * @param consumption the consumption_id value
	 */
	public void setConsumption (jkt.hms.masters.business.IpWardConsumptionHeader consumption) {
		this.consumption = consumption;
	}



	/**
	 * Return the value associated with the column: stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStock () {
		return stock;
	}

	/**
	 * Set the value related to the column: stock_id
	 * @param stock the stock_id value
	 */
	public void setStock (jkt.hms.masters.business.StoreItemBatchStock stock) {
		this.stock = stock;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpWardConsumptionDetails)) return false;
		else {
			jkt.hms.masters.business.IpWardConsumptionDetails ipWardConsumptionDetails = (jkt.hms.masters.business.IpWardConsumptionDetails) obj;
			if (null == this.getId() || null == ipWardConsumptionDetails.getId()) return false;
			else return (this.getId().equals(ipWardConsumptionDetails.getId()));
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