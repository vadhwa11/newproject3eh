package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_refilled_cylinder_delivery_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_refilled_cylinder_delivery_header"
 */

public abstract class BaseHesRefilledCylinderDeliveryHeader  implements Serializable {

	public static String REF = "HesRefilledCylinderDeliveryHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_VEHICLE_NO = "VehicleNo";
	public static String PROP_ID = "Id";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_AC_MEN = "AcMen";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CHALLAN_NO = "ChallanNo";
	public static String PROP_CHALLAN_DATE = "ChallanDate";


	// constructors
	public BaseHesRefilledCylinderDeliveryHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesRefilledCylinderDeliveryHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date challanDate;
	private java.lang.String challanNo;
	private java.util.Date entryDate;
	private java.lang.String entryNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String vehicleNo;

	// many to one
	private jkt.hms.masters.business.MasEmployee acMen;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail> hesRefilledCylinderDeliveryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="refilled_id"
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
	 * Return the value associated with the column: challan_date
	 */
	public java.util.Date getChallanDate () {
		return challanDate;
	}

	/**
	 * Set the value related to the column: challan_date
	 * @param challanDate the challan_date value
	 */
	public void setChallanDate (java.util.Date challanDate) {
		this.challanDate = challanDate;
	}



	/**
	 * Return the value associated with the column: challan_no
	 */
	public java.lang.String getChallanNo () {
		return challanNo;
	}

	/**
	 * Set the value related to the column: challan_no
	 * @param challanNo the challan_no value
	 */
	public void setChallanNo (java.lang.String challanNo) {
		this.challanNo = challanNo;
	}



	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
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
	 * Return the value associated with the column: vehicle_no
	 */
	public java.lang.String getVehicleNo () {
		return vehicleNo;
	}

	/**
	 * Set the value related to the column: vehicle_no
	 * @param vehicleNo the vehicle_no value
	 */
	public void setVehicleNo (java.lang.String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}



	/**
	 * Return the value associated with the column: ac_men_id
	 */
	public jkt.hms.masters.business.MasEmployee getAcMen () {
		return acMen;
	}

	/**
	 * Set the value related to the column: ac_men_id
	 * @param acMen the ac_men_id value
	 */
	public void setAcMen (jkt.hms.masters.business.MasEmployee acMen) {
		this.acMen = acMen;
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
	 * Return the value associated with the column: HesRefilledCylinderDeliveryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail> getHesRefilledCylinderDeliveryDetails () {
		return hesRefilledCylinderDeliveryDetails;
	}

	/**
	 * Set the value related to the column: HesRefilledCylinderDeliveryDetails
	 * @param hesRefilledCylinderDeliveryDetails the HesRefilledCylinderDeliveryDetails value
	 */
	public void setHesRefilledCylinderDeliveryDetails (java.util.Set<jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail> hesRefilledCylinderDeliveryDetails) {
		this.hesRefilledCylinderDeliveryDetails = hesRefilledCylinderDeliveryDetails;
	}

	public void addToHesRefilledCylinderDeliveryDetails (jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail hesRefilledCylinderDeliveryDetail) {
		if (null == getHesRefilledCylinderDeliveryDetails()) setHesRefilledCylinderDeliveryDetails(new java.util.TreeSet<jkt.hms.masters.business.HesRefilledCylinderDeliveryDetail>());
		getHesRefilledCylinderDeliveryDetails().add(hesRefilledCylinderDeliveryDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesRefilledCylinderDeliveryHeader)) return false;
		else {
			jkt.hms.masters.business.HesRefilledCylinderDeliveryHeader hesRefilledCylinderDeliveryHeader = (jkt.hms.masters.business.HesRefilledCylinderDeliveryHeader) obj;
			if (null == this.getId() || null == hesRefilledCylinderDeliveryHeader.getId()) return false;
			else return (this.getId().equals(hesRefilledCylinderDeliveryHeader.getId()));
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