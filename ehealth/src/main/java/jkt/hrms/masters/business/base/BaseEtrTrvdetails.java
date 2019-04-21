package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the etr_trvdetails table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="etr_trvdetails"
 */

public abstract class BaseEtrTrvdetails  implements Serializable {

	public static String REF = "EtrTrvdetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_B_DATE = "BDate";
	public static String PROP_TRV = "Trv";
	public static String PROP_TO_PLCE = "ToPlce";
	public static String PROP_FRM_PLCE = "FrmPlce";
	public static String PROP_TO_COUNTRY = "ToCountry";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_FROM_COUNTRY = "FromCountry";
	public static String PROP_BEFORE_TIME = "BeforeTime";
	public static String PROP_TRIP = "Trip";
	public static String PROP_TIME_SLOT = "TimeSlot";


	// constructors
	public BaseEtrTrvdetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEtrTrvdetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date bDate;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String beforeTime;
	private java.lang.String timeSlot;

	// many to one
	private jkt.hms.masters.business.MasCountry toCountry;
	private jkt.hrms.masters.business.EtrTravelreq trv;
	private jkt.hms.masters.business.MasDistrict frmPlce;
	private jkt.hms.masters.business.MasDistrict toPlce;
	private jkt.hrms.masters.business.MstrCode trip;
	private jkt.hms.masters.business.MasCountry fromCountry;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="Etr_TrvDet"
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
	 * Return the value associated with the column: B_date
	 */
	public java.util.Date getBDate () {
		return bDate;
	}

	/**
	 * Set the value related to the column: B_date
	 * @param bDate the B_date value
	 */
	public void setBDate (java.util.Date bDate) {
		this.bDate = bDate;
	}



	/**
	 * Return the value associated with the column: Remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: Remarks
	 * @param remarks the Remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: before_time
	 */
	public java.lang.String getBeforeTime () {
		return beforeTime;
	}

	/**
	 * Set the value related to the column: before_time
	 * @param beforeTime the before_time value
	 */
	public void setBeforeTime (java.lang.String beforeTime) {
		this.beforeTime = beforeTime;
	}



	/**
	 * Return the value associated with the column: time_slot
	 */
	public java.lang.String getTimeSlot () {
		return timeSlot;
	}

	/**
	 * Set the value related to the column: time_slot
	 * @param timeSlot the time_slot value
	 */
	public void setTimeSlot (java.lang.String timeSlot) {
		this.timeSlot = timeSlot;
	}



	/**
	 * Return the value associated with the column: to_country
	 */
	public jkt.hms.masters.business.MasCountry getToCountry () {
		return toCountry;
	}

	/**
	 * Set the value related to the column: to_country
	 * @param toCountry the to_country value
	 */
	public void setToCountry (jkt.hms.masters.business.MasCountry toCountry) {
		this.toCountry = toCountry;
	}



	/**
	 * Return the value associated with the column: trv_id
	 */
	public jkt.hrms.masters.business.EtrTravelreq getTrv () {
		return trv;
	}

	/**
	 * Set the value related to the column: trv_id
	 * @param trv the trv_id value
	 */
	public void setTrv (jkt.hrms.masters.business.EtrTravelreq trv) {
		this.trv = trv;
	}



	/**
	 * Return the value associated with the column: FrmPlce
	 */
	public jkt.hms.masters.business.MasDistrict getFrmPlce () {
		return frmPlce;
	}

	/**
	 * Set the value related to the column: FrmPlce
	 * @param frmPlce the FrmPlce value
	 */
	public void setFrmPlce (jkt.hms.masters.business.MasDistrict frmPlce) {
		this.frmPlce = frmPlce;
	}



	/**
	 * Return the value associated with the column: ToPlce
	 */
	public jkt.hms.masters.business.MasDistrict getToPlce () {
		return toPlce;
	}

	/**
	 * Set the value related to the column: ToPlce
	 * @param toPlce the ToPlce value
	 */
	public void setToPlce (jkt.hms.masters.business.MasDistrict toPlce) {
		this.toPlce = toPlce;
	}



	/**
	 * Return the value associated with the column: Trip_id
	 */
	public jkt.hrms.masters.business.MstrCode getTrip () {
		return trip;
	}

	/**
	 * Set the value related to the column: Trip_id
	 * @param trip the Trip_id value
	 */
	public void setTrip (jkt.hrms.masters.business.MstrCode trip) {
		this.trip = trip;
	}



	/**
	 * Return the value associated with the column: from_country
	 */
	public jkt.hms.masters.business.MasCountry getFromCountry () {
		return fromCountry;
	}

	/**
	 * Set the value related to the column: from_country
	 * @param fromCountry the from_country value
	 */
	public void setFromCountry (jkt.hms.masters.business.MasCountry fromCountry) {
		this.fromCountry = fromCountry;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.EtrTrvdetails)) return false;
		else {
			jkt.hrms.masters.business.EtrTrvdetails etrTrvdetails = (jkt.hrms.masters.business.EtrTrvdetails) obj;
			if (null == this.getId() || null == etrTrvdetails.getId()) return false;
			else return (this.getId().equals(etrTrvdetails.getId()));
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