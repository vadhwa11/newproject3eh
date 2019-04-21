package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mstr_query_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mstr_query_status"
 */

public abstract class BaseMstrQueryStatus  implements Serializable {

	public static String REF = "MstrQueryStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COMAPNY = "Comapny";
	public static String PROP_QUERY_STATUS_DESC = "QueryStatusDesc";
	public static String PROP_QUERY_STATUS_CODE = "QueryStatusCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMstrQueryStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMstrQueryStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String queryStatusCode;
	private java.lang.String queryStatusDesc;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital comapny;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntry> prjQueryFlwEntries;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="query_status_id"
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
	 * Return the value associated with the column: query_status_code
	 */
	public java.lang.String getQueryStatusCode () {
		return queryStatusCode;
	}

	/**
	 * Set the value related to the column: query_status_code
	 * @param queryStatusCode the query_status_code value
	 */
	public void setQueryStatusCode (java.lang.String queryStatusCode) {
		this.queryStatusCode = queryStatusCode;
	}



	/**
	 * Return the value associated with the column: query_status_desc
	 */
	public java.lang.String getQueryStatusDesc () {
		return queryStatusDesc;
	}

	/**
	 * Set the value related to the column: query_status_desc
	 * @param queryStatusDesc the query_status_desc value
	 */
	public void setQueryStatusDesc (java.lang.String queryStatusDesc) {
		this.queryStatusDesc = queryStatusDesc;
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
	 * Return the value associated with the column: comapny_id
	 */
	public jkt.hms.masters.business.MasHospital getComapny () {
		return comapny;
	}

	/**
	 * Set the value related to the column: comapny_id
	 * @param comapny the comapny_id value
	 */
	public void setComapny (jkt.hms.masters.business.MasHospital comapny) {
		this.comapny = comapny;
	}



	/**
	 * Return the value associated with the column: PrjQueryFlwEntries
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntry> getPrjQueryFlwEntries () {
		return prjQueryFlwEntries;
	}

	/**
	 * Set the value related to the column: PrjQueryFlwEntries
	 * @param prjQueryFlwEntries the PrjQueryFlwEntries value
	 */
	public void setPrjQueryFlwEntries (java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntry> prjQueryFlwEntries) {
		this.prjQueryFlwEntries = prjQueryFlwEntries;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.MstrQueryStatus)) return false;
		else {
			jkt.hrms.masters.business.MstrQueryStatus mstrQueryStatus = (jkt.hrms.masters.business.MstrQueryStatus) obj;
			if (null == this.getId() || null == mstrQueryStatus.getId()) return false;
			else return (this.getId().equals(mstrQueryStatus.getId()));
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