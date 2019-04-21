package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_query_flw_entry_doc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_query_flw_entry_doc"
 */

public abstract class BasePrjQueryFlwEntryDoc  implements Serializable {

	public static String REF = "PrjQueryFlwEntryDoc";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUERY_FLW_ENTRY = "QueryFlwEntry";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_QUERY_FLW_ENTRY_DOC_COMMENTS = "QueryFlwEntryDocComments";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_PROJECT = "Project";
	public static String PROP_QUERY_FLW_ENTRY_DOC_FILENAME = "QueryFlwEntryDocFilename";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePrjQueryFlwEntryDoc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjQueryFlwEntryDoc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String queryFlwEntryDocFilename;
	private java.lang.String queryFlwEntryDocComments;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.MstrProject project;
	private jkt.hrms.masters.business.PrjQueryFlwEntry queryFlwEntry;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="query_flw_entry_doc_id"
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
	 * Return the value associated with the column: query_flw_entry_doc_fileName
	 */
	public java.lang.String getQueryFlwEntryDocFilename () {
		return queryFlwEntryDocFilename;
	}

	/**
	 * Set the value related to the column: query_flw_entry_doc_fileName
	 * @param queryFlwEntryDocFilename the query_flw_entry_doc_fileName value
	 */
	public void setQueryFlwEntryDocFilename (java.lang.String queryFlwEntryDocFilename) {
		this.queryFlwEntryDocFilename = queryFlwEntryDocFilename;
	}



	/**
	 * Return the value associated with the column: query_flw_entry_doc_comments
	 */
	public java.lang.String getQueryFlwEntryDocComments () {
		return queryFlwEntryDocComments;
	}

	/**
	 * Set the value related to the column: query_flw_entry_doc_comments
	 * @param queryFlwEntryDocComments the query_flw_entry_doc_comments value
	 */
	public void setQueryFlwEntryDocComments (java.lang.String queryFlwEntryDocComments) {
		this.queryFlwEntryDocComments = queryFlwEntryDocComments;
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
	 * Return the value associated with the column: query_flw_entry_id
	 */
	public jkt.hrms.masters.business.PrjQueryFlwEntry getQueryFlwEntry () {
		return queryFlwEntry;
	}

	/**
	 * Set the value related to the column: query_flw_entry_id
	 * @param queryFlwEntry the query_flw_entry_id value
	 */
	public void setQueryFlwEntry (jkt.hrms.masters.business.PrjQueryFlwEntry queryFlwEntry) {
		this.queryFlwEntry = queryFlwEntry;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjQueryFlwEntryDoc)) return false;
		else {
			jkt.hrms.masters.business.PrjQueryFlwEntryDoc prjQueryFlwEntryDoc = (jkt.hrms.masters.business.PrjQueryFlwEntryDoc) obj;
			if (null == this.getId() || null == prjQueryFlwEntryDoc.getId()) return false;
			else return (this.getId().equals(prjQueryFlwEntryDoc.getId()));
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