package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_broadcast_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_broadcast_status"
 */

public abstract class BaseStoreBroadcastStatus  implements Serializable {

	public static String REF = "StoreBroadcastStatus";
	public static String PROP_ENQUIRY_T = "EnquiryT";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AVAILABLE_STOCK = "AvailableStock";
	public static String PROP_DMO_STATUS = "DmoStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INSTITUTE_STATUS = "InstituteStatus";
	public static String PROP_SPARE_QTY = "SpareQty";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INSTITUTE = "Institute";


	// constructors
	public BaseStoreBroadcastStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBroadcastStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dmoStatus;
	private java.lang.String instituteStatus;
	private java.math.BigDecimal availableStock;
	private java.math.BigDecimal spareQty;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreBroadcastEnquiryT enquiryT;
	private jkt.hms.masters.business.MasHospital institute;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="broadcast_status_id"
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
	 * Return the value associated with the column: dmo_status
	 */
	public java.lang.String getDmoStatus () {
		return dmoStatus;
	}

	/**
	 * Set the value related to the column: dmo_status
	 * @param dmoStatus the dmo_status value
	 */
	public void setDmoStatus (java.lang.String dmoStatus) {
		this.dmoStatus = dmoStatus;
	}



	/**
	 * Return the value associated with the column: institute_status
	 */
	public java.lang.String getInstituteStatus () {
		return instituteStatus;
	}

	/**
	 * Set the value related to the column: institute_status
	 * @param instituteStatus the institute_status value
	 */
	public void setInstituteStatus (java.lang.String instituteStatus) {
		this.instituteStatus = instituteStatus;
	}



	/**
	 * Return the value associated with the column: available_stock
	 */
	public java.math.BigDecimal getAvailableStock () {
		return availableStock;
	}

	/**
	 * Set the value related to the column: available_stock
	 * @param availableStock the available_stock value
	 */
	public void setAvailableStock (java.math.BigDecimal availableStock) {
		this.availableStock = availableStock;
	}



	/**
	 * Return the value associated with the column: spare_qty
	 */
	public java.math.BigDecimal getSpareQty () {
		return spareQty;
	}

	/**
	 * Set the value related to the column: spare_qty
	 * @param spareQty the spare_qty value
	 */
	public void setSpareQty (java.math.BigDecimal spareQty) {
		this.spareQty = spareQty;
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



	/**
	 * Return the value associated with the column: enquiry_t_id
	 */
	public jkt.hms.masters.business.StoreBroadcastEnquiryT getEnquiryT () {
		return enquiryT;
	}

	/**
	 * Set the value related to the column: enquiry_t_id
	 * @param enquiryT the enquiry_t_id value
	 */
	public void setEnquiryT (jkt.hms.masters.business.StoreBroadcastEnquiryT enquiryT) {
		this.enquiryT = enquiryT;
	}



	/**
	 * Return the value associated with the column: institute_id
	 */
	public jkt.hms.masters.business.MasHospital getInstitute () {
		return institute;
	}

	/**
	 * Set the value related to the column: institute_id
	 * @param institute the institute_id value
	 */
	public void setInstitute (jkt.hms.masters.business.MasHospital institute) {
		this.institute = institute;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBroadcastStatus)) return false;
		else {
			jkt.hms.masters.business.StoreBroadcastStatus storeBroadcastStatus = (jkt.hms.masters.business.StoreBroadcastStatus) obj;
			if (null == this.getId() || null == storeBroadcastStatus.getId()) return false;
			else return (this.getId().equals(storeBroadcastStatus.getId()));
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