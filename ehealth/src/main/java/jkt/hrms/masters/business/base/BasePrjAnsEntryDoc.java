package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_ans_entry_doc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_ans_entry_doc"
 */

public abstract class BasePrjAnsEntryDoc  implements Serializable {

	public static String REF = "PrjAnsEntryDoc";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ANS_ENTRY_DOC_FILENMAE = "AnsEntryDocFilenmae";
	public static String PROP_ID = "Id";
	public static String PROP_PROJECT = "Project";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ANS_ENTRY_DOC_COMMENTS = "AnsEntryDocComments";
	public static String PROP_ANS_ENTRY = "AnsEntry";


	// constructors
	public BasePrjAnsEntryDoc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjAnsEntryDoc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ansEntryDocFilenmae;
	private java.lang.String ansEntryDocComments;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.PrjAnsEntry ansEntry;
	private jkt.hrms.masters.business.MstrProject project;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="prj_ans_entry_doc_id"
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
	 * Return the value associated with the column: ans_entry_doc_fileNmae
	 */
	public java.lang.String getAnsEntryDocFilenmae () {
		return ansEntryDocFilenmae;
	}

	/**
	 * Set the value related to the column: ans_entry_doc_fileNmae
	 * @param ansEntryDocFilenmae the ans_entry_doc_fileNmae value
	 */
	public void setAnsEntryDocFilenmae (java.lang.String ansEntryDocFilenmae) {
		this.ansEntryDocFilenmae = ansEntryDocFilenmae;
	}



	/**
	 * Return the value associated with the column: ans_entry_doc_comments
	 */
	public java.lang.String getAnsEntryDocComments () {
		return ansEntryDocComments;
	}

	/**
	 * Set the value related to the column: ans_entry_doc_comments
	 * @param ansEntryDocComments the ans_entry_doc_comments value
	 */
	public void setAnsEntryDocComments (java.lang.String ansEntryDocComments) {
		this.ansEntryDocComments = ansEntryDocComments;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjAnsEntryDoc)) return false;
		else {
			jkt.hrms.masters.business.PrjAnsEntryDoc prjAnsEntryDoc = (jkt.hrms.masters.business.PrjAnsEntryDoc) obj;
			if (null == this.getId() || null == prjAnsEntryDoc.getId()) return false;
			else return (this.getId().equals(prjAnsEntryDoc.getId()));
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