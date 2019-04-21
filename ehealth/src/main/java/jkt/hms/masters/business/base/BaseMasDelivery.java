package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_delivery table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_delivery"
 */

public abstract class BaseMasDelivery  implements Serializable {

	public static String REF = "MasDelivery";
	public static String PROP_STATUS = "Status";
	public static String PROP_DELIVERY_CODE = "DeliveryCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DELIVERY_NAME = "DeliveryName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasDelivery () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDelivery (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deliveryCode;
	private java.lang.String deliveryName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="delivery_id"
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
	 * Return the value associated with the column: delivery_code
	 */
	public java.lang.String getDeliveryCode () {
		return deliveryCode;
	}

	/**
	 * Set the value related to the column: delivery_code
	 * @param deliveryCode the delivery_code value
	 */
	public void setDeliveryCode (java.lang.String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}



	/**
	 * Return the value associated with the column: delivery_name
	 */
	public java.lang.String getDeliveryName () {
		return deliveryName;
	}

	/**
	 * Set the value related to the column: delivery_name
	 * @param deliveryName the delivery_name value
	 */
	public void setDeliveryName (java.lang.String deliveryName) {
		this.deliveryName = deliveryName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDelivery)) return false;
		else {
			jkt.hms.masters.business.MasDelivery masDelivery = (jkt.hms.masters.business.MasDelivery) obj;
			if (null == this.getId() || null == masDelivery.getId()) return false;
			else return (this.getId().equals(masDelivery.getId()));
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