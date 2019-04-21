package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_query_entry_doc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_query_entry_doc"
 */

public abstract class BasePrjQueryEntryDoc  implements Serializable {

	public static String REF = "PrjQueryEntryDoc";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUERY_ENTRY = "QueryEntry";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_QED_DFILENAME = "QedDfilename";
	public static String PROP_QUERY_ENTRY_DOC_COMMENTS = "QueryEntryDocComments";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COMAPNY = "Comapny";
	public static String PROP_ID = "Id";
	public static String PROP_PROJECT = "Project";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_QUERY_ENTRY_DOC_FILENMAE = "QueryEntryDocFilenmae";


	// constructors
	public BasePrjQueryEntryDoc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjQueryEntryDoc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String queryEntryDocFilenmae;
	private java.lang.String qedDfilename;
	private java.lang.String queryEntryDocComments;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital comapny;
	private jkt.hrms.masters.business.MstrProject project;
	private jkt.hrms.masters.business.PrjQueryEntry queryEntry;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="query_entry_doc_id"
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
	 * Return the value associated with the column: query_entry_doc_fileNmae
	 */
	public java.lang.String getQueryEntryDocFilenmae () {
		return queryEntryDocFilenmae;
	}

	/**
	 * Set the value related to the column: query_entry_doc_fileNmae
	 * @param queryEntryDocFilenmae the query_entry_doc_fileNmae value
	 */
	public void setQueryEntryDocFilenmae (java.lang.String queryEntryDocFilenmae) {
		this.queryEntryDocFilenmae = queryEntryDocFilenmae;
	}



	/**
	 * Return the value associated with the column: QED_DFilename
	 */
	public java.lang.String getQedDfilename () {
		return qedDfilename;
	}

	/**
	 * Set the value related to the column: QED_DFilename
	 * @param qedDfilename the QED_DFilename value
	 */
	public void setQedDfilename (java.lang.String qedDfilename) {
		this.qedDfilename = qedDfilename;
	}



	/**
	 * Return the value associated with the column: query_entry_doc_comments
	 */
	public java.lang.String getQueryEntryDocComments () {
		return queryEntryDocComments;
	}

	/**
	 * Set the value related to the column: query_entry_doc_comments
	 * @param queryEntryDocComments the query_entry_doc_comments value
	 */
	public void setQueryEntryDocComments (java.lang.String queryEntryDocComments) {
		this.queryEntryDocComments = queryEntryDocComments;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjQueryEntryDoc)) return false;
		else {
			jkt.hrms.masters.business.PrjQueryEntryDoc prjQueryEntryDoc = (jkt.hrms.masters.business.PrjQueryEntryDoc) obj;
			if (null == this.getId() || null == prjQueryEntryDoc.getId()) return false;
			else return (this.getId().equals(prjQueryEntryDoc.getId()));
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