package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_query_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_query_entry"
 */

public abstract class BasePrjQueryEntry  implements Serializable {

	public static String REF = "PrjQueryEntry";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QUERY_CODE = "QueryCode";
	public static String PROP_ID = "Id";
	public static String PROP_PROJECT = "Project";
	public static String PROP_PLANNED_ANS_DATE = "PlannedAnsDate";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_QUERY_DESC = "QueryDesc";
	public static String PROP_QUERY_DATE = "QueryDate";
	public static String PROP_REGL_SUB = "ReglSub";


	// constructors
	public BasePrjQueryEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjQueryEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date queryDate;
	private java.util.Date plannedAnsDate;
	private java.lang.String queryDesc;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String queryCode;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.PrjReglSub reglSub;
	private jkt.hrms.masters.business.MstrProject project;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjQueryEntryDoc> prjQueryEntryDocs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="query_entry_id"
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
	 * Return the value associated with the column: query_date
	 */
	public java.util.Date getQueryDate () {
		return queryDate;
	}

	/**
	 * Set the value related to the column: query_date
	 * @param queryDate the query_date value
	 */
	public void setQueryDate (java.util.Date queryDate) {
		this.queryDate = queryDate;
	}



	/**
	 * Return the value associated with the column: planned_ans_date
	 */
	public java.util.Date getPlannedAnsDate () {
		return plannedAnsDate;
	}

	/**
	 * Set the value related to the column: planned_ans_date
	 * @param plannedAnsDate the planned_ans_date value
	 */
	public void setPlannedAnsDate (java.util.Date plannedAnsDate) {
		this.plannedAnsDate = plannedAnsDate;
	}



	/**
	 * Return the value associated with the column: query_desc
	 */
	public java.lang.String getQueryDesc () {
		return queryDesc;
	}

	/**
	 * Set the value related to the column: query_desc
	 * @param queryDesc the query_desc value
	 */
	public void setQueryDesc (java.lang.String queryDesc) {
		this.queryDesc = queryDesc;
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
	 * Return the value associated with the column: query_code
	 */
	public java.lang.String getQueryCode () {
		return queryCode;
	}

	/**
	 * Set the value related to the column: query_code
	 * @param queryCode the query_code value
	 */
	public void setQueryCode (java.lang.String queryCode) {
		this.queryCode = queryCode;
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
	 * Return the value associated with the column: regl_sub_id
	 */
	public jkt.hrms.masters.business.PrjReglSub getReglSub () {
		return reglSub;
	}

	/**
	 * Set the value related to the column: regl_sub_id
	 * @param reglSub the regl_sub_id value
	 */
	public void setReglSub (jkt.hrms.masters.business.PrjReglSub reglSub) {
		this.reglSub = reglSub;
	}



	/**
	 * Return the value associated with the column: project_id
	 */
	public jkt.hrms.masters.business.MstrProject getProject () {
		return project;
	}

	/**
	 * Set the value related to the column: project_id
	 * @param project the project_id value
	 */
	public void setProject (jkt.hrms.masters.business.MstrProject project) {
		this.project = project;
	}



	/**
	 * Return the value associated with the column: PrjQueryEntryDocs
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjQueryEntryDoc> getPrjQueryEntryDocs () {
		return prjQueryEntryDocs;
	}

	/**
	 * Set the value related to the column: PrjQueryEntryDocs
	 * @param prjQueryEntryDocs the PrjQueryEntryDocs value
	 */
	public void setPrjQueryEntryDocs (java.util.Set<jkt.hrms.masters.business.PrjQueryEntryDoc> prjQueryEntryDocs) {
		this.prjQueryEntryDocs = prjQueryEntryDocs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjQueryEntry)) return false;
		else {
			jkt.hrms.masters.business.PrjQueryEntry prjQueryEntry = (jkt.hrms.masters.business.PrjQueryEntry) obj;
			if (null == this.getId() || null == prjQueryEntry.getId()) return false;
			else return (this.getId().equals(prjQueryEntry.getId()));
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