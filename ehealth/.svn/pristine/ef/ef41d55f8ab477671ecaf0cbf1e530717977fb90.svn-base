package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_regl_sub_doc table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_regl_sub_doc"
 */

public abstract class BasePrjReglSubDoc  implements Serializable {

	public static String REF = "PrjReglSubDoc";
	public static String PROP_PJR_REGL_SUB = "PjrReglSub";
	public static String PROP_STATUS = "Status";
	public static String PROP_DOC_COMMENTS = "DocComments";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRJ_REGL_SUB_FILENAME = "PrjReglSubFilename";
	public static String PROP_ID = "Id";
	public static String PROP_PROJECT = "Project";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePrjReglSubDoc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjReglSubDoc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String prjReglSubFilename;
	private java.lang.String docComments;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.PrjReglSub pjrReglSub;
	private jkt.hrms.masters.business.MstrProject project;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="DSA_ID"
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
	 * Return the value associated with the column: prj_regl_sub_fileName
	 */
	public java.lang.String getPrjReglSubFilename () {
		return prjReglSubFilename;
	}

	/**
	 * Set the value related to the column: prj_regl_sub_fileName
	 * @param prjReglSubFilename the prj_regl_sub_fileName value
	 */
	public void setPrjReglSubFilename (java.lang.String prjReglSubFilename) {
		this.prjReglSubFilename = prjReglSubFilename;
	}



	/**
	 * Return the value associated with the column: doc_comments
	 */
	public java.lang.String getDocComments () {
		return docComments;
	}

	/**
	 * Set the value related to the column: doc_comments
	 * @param docComments the doc_comments value
	 */
	public void setDocComments (java.lang.String docComments) {
		this.docComments = docComments;
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
	 * Return the value associated with the column: pjr_regl_sub_id
	 */
	public jkt.hrms.masters.business.PrjReglSub getPjrReglSub () {
		return pjrReglSub;
	}

	/**
	 * Set the value related to the column: pjr_regl_sub_id
	 * @param pjrReglSub the pjr_regl_sub_id value
	 */
	public void setPjrReglSub (jkt.hrms.masters.business.PrjReglSub pjrReglSub) {
		this.pjrReglSub = pjrReglSub;
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
		if (!(obj instanceof jkt.hrms.masters.business.PrjReglSubDoc)) return false;
		else {
			jkt.hrms.masters.business.PrjReglSubDoc prjReglSubDoc = (jkt.hrms.masters.business.PrjReglSubDoc) obj;
			if (null == this.getId() || null == prjReglSubDoc.getId()) return false;
			else return (this.getId().equals(prjReglSubDoc.getId()));
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