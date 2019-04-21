package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ph_atp_jphn_jhi_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ph_atp_jphn_jhi_header"
 */

public abstract class BasePhAtpJphnJhiHeader  implements Serializable {

	public static String REF = "PhAtpJphnJhiHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HI_MO = "HiMo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FOR_MONTH = "ForMonth";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ASHA_WORKER = "AshaWorker";


	// constructors
	public BasePhAtpJphnJhiHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhAtpJphnJhiHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String forMonth;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MmMasRequestStatus status;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee ashaWorker;
	private jkt.hms.masters.business.MasEmployee hiMo;

	// collections
	private java.util.Set<jkt.hms.masters.business.PhAtpJphnJhiDetails> phAtpJphnJhiDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="atp_header_id"
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: for_month
	 */
	public java.lang.String getForMonth () {
		return forMonth;
	}

	/**
	 * Set the value related to the column: for_month
	 * @param forMonth the for_month value
	 */
	public void setForMonth (java.lang.String forMonth) {
		this.forMonth = forMonth;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (jkt.hms.masters.business.MmMasRequestStatus status) {
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



	/**
	 * Return the value associated with the column: asha_worker
	 */
	public jkt.hms.masters.business.MasEmployee getAshaWorker () {
		return ashaWorker;
	}

	/**
	 * Set the value related to the column: asha_worker
	 * @param ashaWorker the asha_worker value
	 */
	public void setAshaWorker (jkt.hms.masters.business.MasEmployee ashaWorker) {
		this.ashaWorker = ashaWorker;
	}



	/**
	 * Return the value associated with the column: hi_mo_id
	 */
	public jkt.hms.masters.business.MasEmployee getHiMo () {
		return hiMo;
	}

	/**
	 * Set the value related to the column: hi_mo_id
	 * @param hiMo the hi_mo_id value
	 */
	public void setHiMo (jkt.hms.masters.business.MasEmployee hiMo) {
		this.hiMo = hiMo;
	}



	/**
	 * Return the value associated with the column: PhAtpJphnJhiDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PhAtpJphnJhiDetails> getPhAtpJphnJhiDetails () {
		return phAtpJphnJhiDetails;
	}

	/**
	 * Set the value related to the column: PhAtpJphnJhiDetails
	 * @param phAtpJphnJhiDetails the PhAtpJphnJhiDetails value
	 */
	public void setPhAtpJphnJhiDetails (java.util.Set<jkt.hms.masters.business.PhAtpJphnJhiDetails> phAtpJphnJhiDetails) {
		this.phAtpJphnJhiDetails = phAtpJphnJhiDetails;
	}

	public void addToPhAtpJphnJhiDetails (jkt.hms.masters.business.PhAtpJphnJhiDetails phAtpJphnJhiDetails) {
		if (null == getPhAtpJphnJhiDetails()) setPhAtpJphnJhiDetails(new java.util.TreeSet<jkt.hms.masters.business.PhAtpJphnJhiDetails>());
		getPhAtpJphnJhiDetails().add(phAtpJphnJhiDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhAtpJphnJhiHeader)) return false;
		else {
			jkt.hms.masters.business.PhAtpJphnJhiHeader phAtpJphnJhiHeader = (jkt.hms.masters.business.PhAtpJphnJhiHeader) obj;
			if (null == this.getId() || null == phAtpJphnJhiHeader.getId()) return false;
			else return (this.getId().equals(phAtpJphnJhiHeader.getId()));
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