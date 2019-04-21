package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_institutional_sanctioned_post table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_institutional_sanctioned_post"
 */

public abstract class BaseHrInstitutionalSanctionedPost  implements Serializable {

	public static String REF = "HrInstitutionalSanctionedPost";
	public static String PROP_RANK = "Rank";
	public static String PROP_POST_NO = "PostNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_REF_ORDER_ID = "RefOrderId";
	public static String PROP_INSTITUTION = "Institution";
	public static String PROP_PERMANENT_POST = "PermanentPost";
	public static String PROP_SUPERNUMERARY_POST = "SupernumeraryPost";
	public static String PROP_CADRE = "Cadre";
	public static String PROP_STATUS = "Status";
	public static String PROP_TEMPORARY_POST = "TemporaryPost";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_SPECIAL_OFFICIAL = "SpecialOfficial";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrInstitutionalSanctionedPost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrInstitutionalSanctionedPost (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String refOrderId;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer postNo;
	private java.lang.Integer permanentPost;
	private java.lang.Integer temporaryPost;
	private java.lang.Integer supernumeraryPost;

	// many to one
	private jkt.hms.masters.business.MasCadre cadre;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSpecialOfficial specialOfficial;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasEmployeeDepartment department;
	private jkt.hms.masters.business.MasHospital institution;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrVacancyPost> hrVacancyPosts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="post_id"
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
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}



	/**
	 * Return the value associated with the column: ref_order_id
	 */
	public java.lang.String getRefOrderId () {
		return refOrderId;
	}

	/**
	 * Set the value related to the column: ref_order_id
	 * @param refOrderId the ref_order_id value
	 */
	public void setRefOrderId (java.lang.String refOrderId) {
		this.refOrderId = refOrderId;
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
	 * Return the value associated with the column: post_no
	 */
	public java.lang.Integer getPostNo () {
		return postNo;
	}

	/**
	 * Set the value related to the column: post_no
	 * @param postNo the post_no value
	 */
	public void setPostNo (java.lang.Integer postNo) {
		this.postNo = postNo;
	}



	/**
	 * Return the value associated with the column: permanent_post
	 */
	public java.lang.Integer getPermanentPost () {
		return permanentPost;
	}

	/**
	 * Set the value related to the column: permanent_post
	 * @param permanentPost the permanent_post value
	 */
	public void setPermanentPost (java.lang.Integer permanentPost) {
		this.permanentPost = permanentPost;
	}



	/**
	 * Return the value associated with the column: temporary_post
	 */
	public java.lang.Integer getTemporaryPost () {
		return temporaryPost;
	}

	/**
	 * Set the value related to the column: temporary_post
	 * @param temporaryPost the temporary_post value
	 */
	public void setTemporaryPost (java.lang.Integer temporaryPost) {
		this.temporaryPost = temporaryPost;
	}



	/**
	 * Return the value associated with the column: supernumerary_post
	 */
	public java.lang.Integer getSupernumeraryPost () {
		return supernumeraryPost;
	}

	/**
	 * Set the value related to the column: supernumerary_post
	 * @param supernumeraryPost the supernumerary_post value
	 */
	public void setSupernumeraryPost (java.lang.Integer supernumeraryPost) {
		this.supernumeraryPost = supernumeraryPost;
	}



	/**
	 * Return the value associated with the column: cadre_id
	 */
	public jkt.hms.masters.business.MasCadre getCadre () {
		return cadre;
	}

	/**
	 * Set the value related to the column: cadre_id
	 * @param cadre the cadre_id value
	 */
	public void setCadre (jkt.hms.masters.business.MasCadre cadre) {
		this.cadre = cadre;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: special_official_id
	 */
	public jkt.hms.masters.business.MasSpecialOfficial getSpecialOfficial () {
		return specialOfficial;
	}

	/**
	 * Set the value related to the column: special_official_id
	 * @param specialOfficial the special_official_id value
	 */
	public void setSpecialOfficial (jkt.hms.masters.business.MasSpecialOfficial specialOfficial) {
		this.specialOfficial = specialOfficial;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasEmployeeDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasEmployeeDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: institution_id
	 */
	public jkt.hms.masters.business.MasHospital getInstitution () {
		return institution;
	}

	/**
	 * Set the value related to the column: institution_id
	 * @param institution the institution_id value
	 */
	public void setInstitution (jkt.hms.masters.business.MasHospital institution) {
		this.institution = institution;
	}



	/**
	 * Return the value associated with the column: HrVacancyPosts
	 */
	public java.util.Set<jkt.hms.masters.business.HrVacancyPost> getHrVacancyPosts () {
		return hrVacancyPosts;
	}

	/**
	 * Set the value related to the column: HrVacancyPosts
	 * @param hrVacancyPosts the HrVacancyPosts value
	 */
	public void setHrVacancyPosts (java.util.Set<jkt.hms.masters.business.HrVacancyPost> hrVacancyPosts) {
		this.hrVacancyPosts = hrVacancyPosts;
	}

	public void addToHrVacancyPosts (jkt.hms.masters.business.HrVacancyPost hrVacancyPost) {
		if (null == getHrVacancyPosts()) setHrVacancyPosts(new java.util.TreeSet<jkt.hms.masters.business.HrVacancyPost>());
		getHrVacancyPosts().add(hrVacancyPost);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrInstitutionalSanctionedPost)) return false;
		else {
			jkt.hms.masters.business.HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost = (jkt.hms.masters.business.HrInstitutionalSanctionedPost) obj;
			if (null == this.getId() || null == hrInstitutionalSanctionedPost.getId()) return false;
			else return (this.getId().equals(hrInstitutionalSanctionedPost.getId()));
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