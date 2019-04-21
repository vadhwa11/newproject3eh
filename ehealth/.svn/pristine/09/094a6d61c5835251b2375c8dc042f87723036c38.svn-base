package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_othervitals table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_othervitals"
 */

public abstract class BasePrjOthervitals  implements Serializable {

	public static String REF = "PrjOthervitals";
	public static String PROP_OVT_VAL = "OvtVal";
	public static String PROP_STATUS = "Status";
	public static String PROP_OVT_DESC = "OvtDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MASTERS = "Masters";
	public static String PROP_PRJ = "Prj";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePrjOthervitals () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjOthervitals (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ovtDesc;
	private java.lang.String ovtVal;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String masters;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.MstrProject prj;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="Ovt_id"
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
	 * Return the value associated with the column: Ovt_Desc
	 */
	public java.lang.String getOvtDesc () {
		return ovtDesc;
	}

	/**
	 * Set the value related to the column: Ovt_Desc
	 * @param ovtDesc the Ovt_Desc value
	 */
	public void setOvtDesc (java.lang.String ovtDesc) {
		this.ovtDesc = ovtDesc;
	}



	/**
	 * Return the value associated with the column: Ovt_Val
	 */
	public java.lang.String getOvtVal () {
		return ovtVal;
	}

	/**
	 * Set the value related to the column: Ovt_Val
	 * @param ovtVal the Ovt_Val value
	 */
	public void setOvtVal (java.lang.String ovtVal) {
		this.ovtVal = ovtVal;
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
	 * Return the value associated with the column: masters
	 */
	public java.lang.String getMasters () {
		return masters;
	}

	/**
	 * Set the value related to the column: masters
	 * @param masters the masters value
	 */
	public void setMasters (java.lang.String masters) {
		this.masters = masters;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
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
		if (!(obj instanceof jkt.hrms.masters.business.PrjOthervitals)) return false;
		else {
			jkt.hrms.masters.business.PrjOthervitals prjOthervitals = (jkt.hrms.masters.business.PrjOthervitals) obj;
			if (null == this.getId() || null == prjOthervitals.getId()) return false;
			else return (this.getId().equals(prjOthervitals.getId()));
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