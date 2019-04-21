package jkt.hrms.recruitment.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_req_prom_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_req_prom_status"
 */

public abstract class BaseHrReqPromStatus  implements Serializable {

	public static String REF = "HrReqPromStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RANK = "Rank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LOCATION = "Location";
	public static String PROP_PROM_STATUS = "PromStatus";
	public static String PROP_PROM_REQ = "PromReq";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_PROMOTION_DATE = "PromotionDate";
	public static String PROP_PROCESS_DATE = "ProcessDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CTC = "Ctc";


	// constructors
	public BaseHrReqPromStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrReqPromStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal ctc;
	private java.util.Date promotionDate;
	private java.util.Date processDate;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.HrRequisitionFrPromotion promReq;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hrms.recruitment.masters.business.Resumestatusmaster promStatus;
	private jkt.hms.masters.business.MasHospital location;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="prom_status_id"
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
	 * Return the value associated with the column: ctc
	 */
	public java.math.BigDecimal getCtc () {
		return ctc;
	}

	/**
	 * Set the value related to the column: ctc
	 * @param ctc the ctc value
	 */
	public void setCtc (java.math.BigDecimal ctc) {
		this.ctc = ctc;
	}



	/**
	 * Return the value associated with the column: promotion_date
	 */
	public java.util.Date getPromotionDate () {
		return promotionDate;
	}

	/**
	 * Set the value related to the column: promotion_date
	 * @param promotionDate the promotion_date value
	 */
	public void setPromotionDate (java.util.Date promotionDate) {
		this.promotionDate = promotionDate;
	}



	/**
	 * Return the value associated with the column: process_date
	 */
	public java.util.Date getProcessDate () {
		return processDate;
	}

	/**
	 * Set the value related to the column: process_date
	 * @param processDate the process_date value
	 */
	public void setProcessDate (java.util.Date processDate) {
		this.processDate = processDate;
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
	 * Return the value associated with the column: prom_req_id
	 */
	public jkt.hms.masters.business.HrRequisitionFrPromotion getPromReq () {
		return promReq;
	}

	/**
	 * Set the value related to the column: prom_req_id
	 * @param promReq the prom_req_id value
	 */
	public void setPromReq (jkt.hms.masters.business.HrRequisitionFrPromotion promReq) {
		this.promReq = promReq;
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
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: prom_status
	 */
	public jkt.hrms.recruitment.masters.business.Resumestatusmaster getPromStatus () {
		return promStatus;
	}

	/**
	 * Set the value related to the column: prom_status
	 * @param promStatus the prom_status value
	 */
	public void setPromStatus (jkt.hrms.recruitment.masters.business.Resumestatusmaster promStatus) {
		this.promStatus = promStatus;
	}



	/**
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param location the location_id value
	 */
	public void setLocation (jkt.hms.masters.business.MasHospital location) {
		this.location = location;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.recruitment.masters.business.HrReqPromStatus)) return false;
		else {
			jkt.hrms.recruitment.masters.business.HrReqPromStatus hrReqPromStatus = (jkt.hrms.recruitment.masters.business.HrReqPromStatus) obj;
			if (null == this.getId() || null == hrReqPromStatus.getId()) return false;
			else return (this.getId().equals(hrReqPromStatus.getId()));
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