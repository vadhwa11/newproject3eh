package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_query_flw_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_query_flw_entry"
 */

public abstract class BasePrjQueryFlwEntry  implements Serializable {

	public static String REF = "PrjQueryFlwEntry";
	public static String PROP_QUERY_ENTRY = "QueryEntry";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QUERY_STATUS = "QueryStatus";
	public static String PROP_NEXT_FLW_DATE = "NextFlwDate";
	public static String PROP_ANS_ENTRY = "AnsEntry";
	public static String PROP_ACTUAL_FLW_DATE = "ActualFlwDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_QUERY_FLW_COMMENTS = "QueryFlwComments";
	public static String PROP_PROJECT = "Project";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";


	// constructors
	public BasePrjQueryFlwEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjQueryFlwEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date actualFlwDate;
	private java.util.Date nextFlwDate;
	private java.lang.String queryFlwComments;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.PrjAnsEntry ansEntry;
	private jkt.hrms.masters.business.MstrProject project;
	private jkt.hrms.masters.business.MstrQueryStatus queryStatus;
	private jkt.hrms.masters.business.PrjQueryEntry queryEntry;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntryDoc> prjQueryFlwEntryDocs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="query_flw_entry_id"
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
	 * Return the value associated with the column: actual_flw_date
	 */
	public java.util.Date getActualFlwDate () {
		return actualFlwDate;
	}

	/**
	 * Set the value related to the column: actual_flw_date
	 * @param actualFlwDate the actual_flw_date value
	 */
	public void setActualFlwDate (java.util.Date actualFlwDate) {
		this.actualFlwDate = actualFlwDate;
	}



	/**
	 * Return the value associated with the column: next_flw_date
	 */
	public java.util.Date getNextFlwDate () {
		return nextFlwDate;
	}

	/**
	 * Set the value related to the column: next_flw_date
	 * @param nextFlwDate the next_flw_date value
	 */
	public void setNextFlwDate (java.util.Date nextFlwDate) {
		this.nextFlwDate = nextFlwDate;
	}



	/**
	 * Return the value associated with the column: query_flw_comments
	 */
	public java.lang.String getQueryFlwComments () {
		return queryFlwComments;
	}

	/**
	 * Set the value related to the column: query_flw_comments
	 * @param queryFlwComments the query_flw_comments value
	 */
	public void setQueryFlwComments (java.lang.String queryFlwComments) {
		this.queryFlwComments = queryFlwComments;
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
	 * Return the value associated with the column: ans_entry_id
	 */
	public jkt.hrms.masters.business.PrjAnsEntry getAnsEntry () {
		return ansEntry;
	}

	/**
	 * Set the value related to the column: ans_entry_id
	 * @param ansEntry the ans_entry_id value
	 */
	public void setAnsEntry (jkt.hrms.masters.business.PrjAnsEntry ansEntry) {
		this.ansEntry = ansEntry;
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
	 * Return the value associated with the column: query_status_id
	 */
	public jkt.hrms.masters.business.MstrQueryStatus getQueryStatus () {
		return queryStatus;
	}

	/**
	 * Set the value related to the column: query_status_id
	 * @param queryStatus the query_status_id value
	 */
	public void setQueryStatus (jkt.hrms.masters.business.MstrQueryStatus queryStatus) {
		this.queryStatus = queryStatus;
	}



	/**
	 * Return the value associated with the column: query_entry_id
	 */
	public jkt.hrms.masters.business.PrjQueryEntry getQueryEntry () {
		return queryEntry;
	}

	/**
	 * Set the value related to the column: query_entry_id
	 * @param queryEntry the query_entry_id value
	 */
	public void setQueryEntry (jkt.hrms.masters.business.PrjQueryEntry queryEntry) {
		this.queryEntry = queryEntry;
	}



	/**
	 * Return the value associated with the column: PrjQueryFlwEntryDocs
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntryDoc> getPrjQueryFlwEntryDocs () {
		return prjQueryFlwEntryDocs;
	}

	/**
	 * Set the value related to the column: PrjQueryFlwEntryDocs
	 * @param prjQueryFlwEntryDocs the PrjQueryFlwEntryDocs value
	 */
	public void setPrjQueryFlwEntryDocs (java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntryDoc> prjQueryFlwEntryDocs) {
		this.prjQueryFlwEntryDocs = prjQueryFlwEntryDocs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjQueryFlwEntry)) return false;
		else {
			jkt.hrms.masters.business.PrjQueryFlwEntry prjQueryFlwEntry = (jkt.hrms.masters.business.PrjQueryFlwEntry) obj;
			if (null == this.getId() || null == prjQueryFlwEntry.getId()) return false;
			else return (this.getId().equals(prjQueryFlwEntry.getId()));
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