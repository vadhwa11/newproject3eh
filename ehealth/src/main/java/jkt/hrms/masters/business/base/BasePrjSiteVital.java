package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_site_vital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_site_vital"
 */

public abstract class BasePrjSiteVital  implements Serializable {

	public static String REF = "PrjSiteVital";
	public static String PROP_ACTUAL_DATE = "ActualDate";
	public static String PROP_PLANNED_DATE = "PlannedDate";
	public static String PROP_PLANNED_VALUE = "PlannedValue";
	public static String PROP_VITAL = "Vital";
	public static String PROP_FLAG = "Flag";
	public static String PROP_REVISED_VALUE = "RevisedValue";
	public static String PROP_PRJ = "Prj";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AMOUNT_FLAG = "AmountFlag";
	public static String PROP_ACTUAL_VALUE = "ActualValue";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REVISED_DATE = "RevisedDate";
	public static String PROP_ACTUAL_REMARK = "ActualRemark";
	public static String PROP_ID = "Id";
	public static String PROP_PLANNED_REMARK = "PlannedRemark";
	public static String PROP_REVISED_REMARK = "RevisedRemark";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_SITE_HEADER = "SiteHeader";


	// constructors
	public BasePrjSiteVital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjSiteVital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date plannedDate;
	private java.util.Date revisedDate;
	private java.util.Date actualDate;
	private java.lang.String plannedRemark;
	private java.lang.String revisedRemark;
	private java.lang.String actualRemark;
	private java.lang.Integer plannedValue;
	private java.lang.Integer revisedValue;
	private java.lang.Integer actualValue;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String flag;
	private java.lang.String amountFlag;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasCurrency currency;
	private jkt.hrms.masters.business.MstrSiteHeader siteHeader;
	private jkt.hrms.masters.business.MstrVitals vital;
	private jkt.hrms.masters.business.MstrProject prj;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="site_vital_id"
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
	 * Return the value associated with the column: planned_date
	 */
	public java.util.Date getPlannedDate () {
		return plannedDate;
	}

	/**
	 * Set the value related to the column: planned_date
	 * @param plannedDate the planned_date value
	 */
	public void setPlannedDate (java.util.Date plannedDate) {
		this.plannedDate = plannedDate;
	}



	/**
	 * Return the value associated with the column: revised_date
	 */
	public java.util.Date getRevisedDate () {
		return revisedDate;
	}

	/**
	 * Set the value related to the column: revised_date
	 * @param revisedDate the revised_date value
	 */
	public void setRevisedDate (java.util.Date revisedDate) {
		this.revisedDate = revisedDate;
	}



	/**
	 * Return the value associated with the column: actual_date
	 */
	public java.util.Date getActualDate () {
		return actualDate;
	}

	/**
	 * Set the value related to the column: actual_date
	 * @param actualDate the actual_date value
	 */
	public void setActualDate (java.util.Date actualDate) {
		this.actualDate = actualDate;
	}



	/**
	 * Return the value associated with the column: planned_remark
	 */
	public java.lang.String getPlannedRemark () {
		return plannedRemark;
	}

	/**
	 * Set the value related to the column: planned_remark
	 * @param plannedRemark the planned_remark value
	 */
	public void setPlannedRemark (java.lang.String plannedRemark) {
		this.plannedRemark = plannedRemark;
	}



	/**
	 * Return the value associated with the column: revised_remark
	 */
	public java.lang.String getRevisedRemark () {
		return revisedRemark;
	}

	/**
	 * Set the value related to the column: revised_remark
	 * @param revisedRemark the revised_remark value
	 */
	public void setRevisedRemark (java.lang.String revisedRemark) {
		this.revisedRemark = revisedRemark;
	}



	/**
	 * Return the value associated with the column: actual_remark
	 */
	public java.lang.String getActualRemark () {
		return actualRemark;
	}

	/**
	 * Set the value related to the column: actual_remark
	 * @param actualRemark the actual_remark value
	 */
	public void setActualRemark (java.lang.String actualRemark) {
		this.actualRemark = actualRemark;
	}



	/**
	 * Return the value associated with the column: planned_value
	 */
	public java.lang.Integer getPlannedValue () {
		return plannedValue;
	}

	/**
	 * Set the value related to the column: planned_value
	 * @param plannedValue the planned_value value
	 */
	public void setPlannedValue (java.lang.Integer plannedValue) {
		this.plannedValue = plannedValue;
	}



	/**
	 * Return the value associated with the column: revised_value
	 */
	public java.lang.Integer getRevisedValue () {
		return revisedValue;
	}

	/**
	 * Set the value related to the column: revised_value
	 * @param revisedValue the revised_value value
	 */
	public void setRevisedValue (java.lang.Integer revisedValue) {
		this.revisedValue = revisedValue;
	}



	/**
	 * Return the value associated with the column: actual_value
	 */
	public java.lang.Integer getActualValue () {
		return actualValue;
	}

	/**
	 * Set the value related to the column: actual_value
	 * @param actualValue the actual_value value
	 */
	public void setActualValue (java.lang.Integer actualValue) {
		this.actualValue = actualValue;
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
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: amount_flag
	 */
	public java.lang.String getAmountFlag () {
		return amountFlag;
	}

	/**
	 * Set the value related to the column: amount_flag
	 * @param amountFlag the amount_flag value
	 */
	public void setAmountFlag (java.lang.String amountFlag) {
		this.amountFlag = amountFlag;
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
	 * Return the value associated with the column: currency_id
	 */
	public jkt.hms.masters.business.MasCurrency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency_id
	 * @param currency the currency_id value
	 */
	public void setCurrency (jkt.hms.masters.business.MasCurrency currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: site_header_id
	 */
	public jkt.hrms.masters.business.MstrSiteHeader getSiteHeader () {
		return siteHeader;
	}

	/**
	 * Set the value related to the column: site_header_id
	 * @param siteHeader the site_header_id value
	 */
	public void setSiteHeader (jkt.hrms.masters.business.MstrSiteHeader siteHeader) {
		this.siteHeader = siteHeader;
	}



	/**
	 * Return the value associated with the column: vital_id
	 */
	public jkt.hrms.masters.business.MstrVitals getVital () {
		return vital;
	}

	/**
	 * Set the value related to the column: vital_id
	 * @param vital the vital_id value
	 */
	public void setVital (jkt.hrms.masters.business.MstrVitals vital) {
		this.vital = vital;
	}



	/**
	 * Return the value associated with the column: Prj_id
	 */
	public jkt.hrms.masters.business.MstrProject getPrj () {
		return prj;
	}

	/**
	 * Set the value related to the column: Prj_id
	 * @param prj the Prj_id value
	 */
	public void setPrj (jkt.hrms.masters.business.MstrProject prj) {
		this.prj = prj;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjSiteVital)) return false;
		else {
			jkt.hrms.masters.business.PrjSiteVital prjSiteVital = (jkt.hrms.masters.business.PrjSiteVital) obj;
			if (null == this.getId() || null == prjSiteVital.getId()) return false;
			else return (this.getId().equals(prjSiteVital.getId()));
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