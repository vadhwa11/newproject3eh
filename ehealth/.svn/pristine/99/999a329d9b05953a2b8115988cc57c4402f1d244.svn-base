package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prj_regl_sub table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prj_regl_sub"
 */

public abstract class BasePrjReglSub  implements Serializable {

	public static String REF = "PrjReglSub";
	public static String PROP_SUB_DATE = "SubDate";
	public static String PROP_COMMENTS = "Comments";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRJ = "Prj";
	public static String PROP_DOC_TYPE = "DocType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REFERENCE_CODE = "ReferenceCode";
	public static String PROP_REGULATORY_STATUS = "RegulatoryStatus";
	public static String PROP_ID = "Id";
	public static String PROP_REMARK = "Remark";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_APPR_DATE = "ApprDate";


	// constructors
	public BasePrjReglSub () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrjReglSub (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date subDate;
	private java.util.Date apprDate;
	private java.lang.String comments;
	private java.lang.String referenceCode;
	private java.lang.String remark;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hrms.masters.business.MstrRegulatoryStatus regulatoryStatus;
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hrms.masters.business.MstrProject prj;
	private jkt.hrms.masters.business.MstrDoctype docType;

	// collections
	private java.util.Set<jkt.hrms.masters.business.MstrDocument> doc;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ReqS_id"
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
	 * Return the value associated with the column: Sub_Date
	 */
	public java.util.Date getSubDate () {
		return subDate;
	}

	/**
	 * Set the value related to the column: Sub_Date
	 * @param subDate the Sub_Date value
	 */
	public void setSubDate (java.util.Date subDate) {
		this.subDate = subDate;
	}



	/**
	 * Return the value associated with the column: Appr_Date
	 */
	public java.util.Date getApprDate () {
		return apprDate;
	}

	/**
	 * Set the value related to the column: Appr_Date
	 * @param apprDate the Appr_Date value
	 */
	public void setApprDate (java.util.Date apprDate) {
		this.apprDate = apprDate;
	}



	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: reference_code
	 */
	public java.lang.String getReferenceCode () {
		return referenceCode;
	}

	/**
	 * Set the value related to the column: reference_code
	 * @param referenceCode the reference_code value
	 */
	public void setReferenceCode (java.lang.String referenceCode) {
		this.referenceCode = referenceCode;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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
	 * Return the value associated with the column: regulatory_status_id
	 */
	public jkt.hrms.masters.business.MstrRegulatoryStatus getRegulatoryStatus () {
		return regulatoryStatus;
	}

	/**
	 * Set the value related to the column: regulatory_status_id
	 * @param regulatoryStatus the regulatory_status_id value
	 */
	public void setRegulatoryStatus (jkt.hrms.masters.business.MstrRegulatoryStatus regulatoryStatus) {
		this.regulatoryStatus = regulatoryStatus;
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



	/**
	 * Return the value associated with the column: doc_type_id
	 */
	public jkt.hrms.masters.business.MstrDoctype getDocType () {
		return docType;
	}

	/**
	 * Set the value related to the column: doc_type_id
	 * @param docType the doc_type_id value
	 */
	public void setDocType (jkt.hrms.masters.business.MstrDoctype docType) {
		this.docType = docType;
	}



	/**
	 * Return the value associated with the column: Doc
	 */
	public java.util.Set<jkt.hrms.masters.business.MstrDocument> getDoc () {
		return doc;
	}

	/**
	 * Set the value related to the column: Doc
	 * @param doc the Doc value
	 */
	public void setDoc (java.util.Set<jkt.hrms.masters.business.MstrDocument> doc) {
		this.doc = doc;
	}

	public void addToDoc (jkt.hrms.masters.business.MstrDocument mstrDocument) {
		if (null == getDoc()) setDoc(new java.util.TreeSet<jkt.hrms.masters.business.MstrDocument>());
		getDoc().add(mstrDocument);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.PrjReglSub)) return false;
		else {
			jkt.hrms.masters.business.PrjReglSub prjReglSub = (jkt.hrms.masters.business.PrjReglSub) obj;
			if (null == this.getId() || null == prjReglSub.getId()) return false;
			else return (this.getId().equals(prjReglSub.getId()));
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