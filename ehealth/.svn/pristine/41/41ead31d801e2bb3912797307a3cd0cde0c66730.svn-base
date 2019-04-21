package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_ans_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_ans_entry"
 */

public abstract class BasePrjAnsEntry  implements Serializable {

	public static String REF = "PrjAnsEntry";
	public static String PROP_ANS_CODE = "AnsCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_QUERY_ENTRY = "QueryEntry";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PLANNED_FLW_DATE = "PlannedFlwDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ANS_DESCRIPTION = "AnsDescription";
	public static String PROP_ID = "Id";
	public static String PROP_PROJECT = "Project";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ACTUAL_ANS_DATE = "ActualAnsDate";


	// constructors
	public BasePrjAnsEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjAnsEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ansCode;
	private java.util.Date actualAnsDate;
	private java.util.Date plannedFlwDate;
	private java.lang.String ansDescription;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.MstrProject project;
	private jkt.hrms.masters.business.PrjQueryEntry queryEntry;

	// collections
	private java.util.Set<jkt.hrms.masters.business.PrjQueryFlwEntry> prjQueryFlwEntries;
	private java.util.Set<jkt.hrms.masters.business.PrjAnsEntryDoc> prjAnsEntryDocs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ans_entry_id"
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
	 * Return the value associated with the column: ans_code
	 */
	public java.lang.String getAnsCode () {
		return ansCode;
	}

	/**
	 * Set the value related to the column: ans_code
	 * @param ansCode the ans_code value
	 */
	public void setAnsCode (java.lang.String ansCode) {
		this.ansCode = ansCode;
	}



	/**
	 * Return the value associated with the column: actual_ans_date
	 */
	public java.util.Date getActualAnsDate () {
		return actualAnsDate;
	}

	/**
	 * Set the value related to the column: actual_ans_date
	 * @param actualAnsDate the actual_ans_date value
	 */
	public void setActualAnsDate (java.util.Date actualAnsDate) {
		this.actualAnsDate = actualAnsDate;
	}



	/**
	 * Return the value associated with the column: planned_flw_date
	 */
	public java.util.Date getPlannedFlwDate () {
		return plannedFlwDate;
	}

	/**
	 * Set the value related to the column: planned_flw_date
	 * @param plannedFlwDate the planned_flw_date value
	 */
	public void setPlannedFlwDate (java.util.Date plannedFlwDate) {
		this.plannedFlwDate = plannedFlwDate;
	}



	/**
	 * Return the value associated with the column: ans_description
	 */
	public java.lang.String getAnsDescription () {
		return ansDescription;
	}

	/**
	 * Set the value related to the column: ans_description
	 * @param ansDescription the ans_description value
	 */
	public void setAnsDescription (java.lang.String ansDescription) {
		this.ansDescription = ansDescription;
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



	/**
	 * Return the value associated with the column: PrjAnsEntryDocs
	 */
	public java.util.Set<jkt.hrms.masters.business.PrjAnsEntryDoc> getPrjAnsEntryDocs () {
		return prjAnsEntryDocs;
	}

	/**
	 * Set the value related to the column: PrjAnsEntryDocs
	 * @param prjAnsEntryDocs the PrjAnsEntryDocs value
	 */
	public void setPrjAnsEntryDocs (java.util.Set<jkt.hrms.masters.business.PrjAnsEntryDoc> prjAnsEntryDocs) {
		this.prjAnsEntryDocs = prjAnsEntryDocs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjAnsEntry)) return false;
		else {
			jkt.hrms.masters.business.PrjAnsEntry prjAnsEntry = (jkt.hrms.masters.business.PrjAnsEntry) obj;
			if (null == this.getId() || null == prjAnsEntry.getId()) return false;
			else return (this.getId().equals(prjAnsEntry.getId()));
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