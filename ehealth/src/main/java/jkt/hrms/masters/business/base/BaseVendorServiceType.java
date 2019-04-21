package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the vendor_service_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="vendor_service_type"
 */

public abstract class BaseVendorServiceType  implements Serializable {

	public static String REF = "VendorServiceType";
	public static String PROP_STATUS = "Status";
	public static String PROP_VENDOR_SERVICE_CODE = "VendorServiceCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VENDOR_SERVICE_NAME = "VendorServiceName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseVendorServiceType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVendorServiceType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vendorServiceCode;
	private java.lang.String vendorServiceName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="vendor_service_type_id"
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
	 * Return the value associated with the column: vendor_service_code
	 */
	public java.lang.String getVendorServiceCode () {
		return vendorServiceCode;
	}

	/**
	 * Set the value related to the column: vendor_service_code
	 * @param vendorServiceCode the vendor_service_code value
	 */
	public void setVendorServiceCode (java.lang.String vendorServiceCode) {
		this.vendorServiceCode = vendorServiceCode;
	}



	/**
	 * Return the value associated with the column: vendor_service_name
	 */
	public java.lang.String getVendorServiceName () {
		return vendorServiceName;
	}

	/**
	 * Set the value related to the column: vendor_service_name
	 * @param vendorServiceName the vendor_service_name value
	 */
	public void setVendorServiceName (java.lang.String vendorServiceName) {
		this.vendorServiceName = vendorServiceName;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.VendorServiceType)) return false;
		else {
			jkt.hrms.masters.business.VendorServiceType vendorServiceType = (jkt.hrms.masters.business.VendorServiceType) obj;
			if (null == this.getId() || null == vendorServiceType.getId()) return false;
			else return (this.getId().equals(vendorServiceType.getId()));
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