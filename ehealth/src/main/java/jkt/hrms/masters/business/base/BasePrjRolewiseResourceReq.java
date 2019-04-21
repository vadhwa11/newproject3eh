package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_rolewise_resource_req table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_rolewise_resource_req"
 */

public abstract class BasePrjRolewiseResourceReq  implements Serializable {

	public static String REF = "PrjRolewiseResourceReq";
	public static String PROP_PJR = "Pjr";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COST_PER_HR = "CostPerHr";
	public static String PROP_PRJ = "Prj";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_RES_COUNT = "ResCount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePrjRolewiseResourceReq () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjRolewiseResourceReq (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer resCount;
	private java.math.BigDecimal costPerHr;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hrms.masters.business.MstrProjectrole pjr;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="rolewise_resource_id"
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
	 * Return the value associated with the column: res_count
	 */
	public java.lang.Integer getResCount () {
		return resCount;
	}

	/**
	 * Set the value related to the column: res_count
	 * @param resCount the res_count value
	 */
	public void setResCount (java.lang.Integer resCount) {
		this.resCount = resCount;
	}



	/**
	 * Return the value associated with the column: cost_per_hr
	 */
	public java.math.BigDecimal getCostPerHr () {
		return costPerHr;
	}

	/**
	 * Set the value related to the column: cost_per_hr
	 * @param costPerHr the cost_per_hr value
	 */
	public void setCostPerHr (java.math.BigDecimal costPerHr) {
		this.costPerHr = costPerHr;
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



	/**
	 * Return the value associated with the column: prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: prj_id
	 * @param prj the prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}



	/**
	 * Return the value associated with the column: pjr_id
	 */
	public jkt.hrms.masters.business.MstrProjectrole getPjr () {
		return pjr;
	}

	/**
	 * Set the value related to the column: pjr_id
	 * @param pjr the pjr_id value
	 */
	public void setPjr (jkt.hrms.masters.business.MstrProjectrole pjr) {
		this.pjr = pjr;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjRolewiseResourceReq)) return false;
		else {
			jkt.hrms.masters.business.PrjRolewiseResourceReq prjRolewiseResourceReq = (jkt.hrms.masters.business.PrjRolewiseResourceReq) obj;
			if (null == this.getId() || null == prjRolewiseResourceReq.getId()) return false;
			else return (this.getId().equals(prjRolewiseResourceReq.getId()));
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