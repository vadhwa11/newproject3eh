package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_empty_cylinder_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_empty_cylinder_header"
 */

public abstract class BaseHesEmptyCylinderHeader  implements Serializable {

	public static String REF = "HesEmptyCylinderHeader";
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
	public BaseHesEmptyCylinderHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEmptyCylinderHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHesEmptyCylinderHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasEmployee acMen,
		java.lang.String entryNo,
		java.util.Date entryDate,
		java.lang.String challanNo,
		java.util.Date challanDate,
		java.lang.String vehicleNo,
		java.lang.String status,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setAcMen(acMen);
		this.setEntryNo(entryNo);
		this.setEntryDate(entryDate);
		this.setChallanNo(challanNo);
		this.setChallanDate(challanDate);
		this.setVehicleNo(vehicleNo);
		this.setStatus(status);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
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
	private java.util.Set<jkt.hms.masters.business.HesEmptyCylinderDetail> hesEmptyCylinderDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cylinderheaderid"
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
	 * Return the value associated with the column: HesEmptyCylinderDetails
	 */
	public java.util.Set<jkt.hms.masters.business.HesEmptyCylinderDetail> getHesEmptyCylinderDetails () {
		return hesEmptyCylinderDetails;
	}

	/**
	 * Set the value related to the column: HesEmptyCylinderDetails
	 * @param hesEmptyCylinderDetails the HesEmptyCylinderDetails value
	 */
	public void setHesEmptyCylinderDetails (java.util.Set<jkt.hms.masters.business.HesEmptyCylinderDetail> hesEmptyCylinderDetails) {
		this.hesEmptyCylinderDetails = hesEmptyCylinderDetails;
	}

	public void addToHesEmptyCylinderDetails (jkt.hms.masters.business.HesEmptyCylinderDetail hesEmptyCylinderDetail) {
		if (null == getHesEmptyCylinderDetails()) setHesEmptyCylinderDetails(new java.util.TreeSet<jkt.hms.masters.business.HesEmptyCylinderDetail>());
		getHesEmptyCylinderDetails().add(hesEmptyCylinderDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEmptyCylinderHeader)) return false;
		else {
			jkt.hms.masters.business.HesEmptyCylinderHeader hesEmptyCylinderHeader = (jkt.hms.masters.business.HesEmptyCylinderHeader) obj;
			if (null == this.getId() || null == hesEmptyCylinderHeader.getId()) return false;
			else return (this.getId().equals(hesEmptyCylinderHeader.getId()));
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