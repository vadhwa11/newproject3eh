package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_vacancy_post table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_vacancy_post"
 */

public abstract class BaseHrVacancyPost  implements Serializable {

	public static String REF = "HrVacancyPost";
	public static String PROP_STATUS = "Status";
	public static String PROP_VSUPERNUMERARY_POST = "VsupernumeraryPost";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VPERMANENT_POST = "VpermanentPost";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SANCTIONED_POST = "SanctionedPost";
	public static String PROP_ID = "Id";
	public static String PROP_ALLOCATED_POST = "AllocatedPost";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VTEMPORARY_POST = "VtemporaryPost";
	public static String PROP_BALANCE_POST = "BalancePost";


	// constructors
	public BaseHrVacancyPost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrVacancyPost (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer vpermanentPost;
	private java.lang.Integer vtemporaryPost;
	private java.lang.Integer vsupernumeraryPost;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer allocatedPost;
	private java.lang.Integer balancePost;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.HrInstitutionalSanctionedPost sanctionedPost;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="vacancy_post_id"
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
	 * Return the value associated with the column: vpermanent_post
	 */
	public java.lang.Integer getVpermanentPost () {
		return vpermanentPost;
	}

	/**
	 * Set the value related to the column: vpermanent_post
	 * @param vpermanentPost the vpermanent_post value
	 */
	public void setVpermanentPost (java.lang.Integer vpermanentPost) {
		this.vpermanentPost = vpermanentPost;
	}



	/**
	 * Return the value associated with the column: vtemporary_post
	 */
	public java.lang.Integer getVtemporaryPost () {
		return vtemporaryPost;
	}

	/**
	 * Set the value related to the column: vtemporary_post
	 * @param vtemporaryPost the vtemporary_post value
	 */
	public void setVtemporaryPost (java.lang.Integer vtemporaryPost) {
		this.vtemporaryPost = vtemporaryPost;
	}



	/**
	 * Return the value associated with the column: vsupernumerary_post
	 */
	public java.lang.Integer getVsupernumeraryPost () {
		return vsupernumeraryPost;
	}

	/**
	 * Set the value related to the column: vsupernumerary_post
	 * @param vsupernumeraryPost the vsupernumerary_post value
	 */
	public void setVsupernumeraryPost (java.lang.Integer vsupernumeraryPost) {
		this.vsupernumeraryPost = vsupernumeraryPost;
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
	 * Return the value associated with the column: allocated_post
	 */
	public java.lang.Integer getAllocatedPost () {
		return allocatedPost;
	}

	/**
	 * Set the value related to the column: allocated_post
	 * @param allocatedPost the allocated_post value
	 */
	public void setAllocatedPost (java.lang.Integer allocatedPost) {
		this.allocatedPost = allocatedPost;
	}



	/**
	 * Return the value associated with the column: balance_post
	 */
	public java.lang.Integer getBalancePost () {
		return balancePost;
	}

	/**
	 * Set the value related to the column: balance_post
	 * @param balancePost the balance_post value
	 */
	public void setBalancePost (java.lang.Integer balancePost) {
		this.balancePost = balancePost;
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
	 * Return the value associated with the column: sanctioned_post_id
	 */
	public jkt.hms.masters.business.HrInstitutionalSanctionedPost getSanctionedPost () {
		return sanctionedPost;
	}

	/**
	 * Set the value related to the column: sanctioned_post_id
	 * @param sanctionedPost the sanctioned_post_id value
	 */
	public void setSanctionedPost (jkt.hms.masters.business.HrInstitutionalSanctionedPost sanctionedPost) {
		this.sanctionedPost = sanctionedPost;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrVacancyPost)) return false;
		else {
			jkt.hms.masters.business.HrVacancyPost hrVacancyPost = (jkt.hms.masters.business.HrVacancyPost) obj;
			if (null == this.getId() || null == hrVacancyPost.getId()) return false;
			else return (this.getId().equals(hrVacancyPost.getId()));
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