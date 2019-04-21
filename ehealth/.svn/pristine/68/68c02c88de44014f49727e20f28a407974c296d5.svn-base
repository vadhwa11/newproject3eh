package jkt.hrms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_visit_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_visit_type"
 */

public abstract class BaseHrMasVisitType  implements Serializable {

	public static String REF = "HrMasVisitType";
	public static String PROP_STATUS = "Status";
	public static String PROP_VISIT_TYPE = "VisitType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VISIT_CODE = "VisitCode";
	public static String PROP_ID = "Id";
	public static String PROP_COMPANY = "Company";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPENDENCY = "Dependency";


	// constructors
	public BaseHrMasVisitType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasVisitType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String visitType;
	private java.lang.String visitCode;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lastChgBy;
	private java.lang.String status;
	private java.lang.String dependency;

	// many to one
	private jkt.hms.masters.business.MasHospital company;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="visit_id"
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
	 * Return the value associated with the column: visit_type
	 */
	public java.lang.String getVisitType () {
		return visitType;
	}

	/**
	 * Set the value related to the column: visit_type
	 * @param visitType the visit_type value
	 */
	public void setVisitType (java.lang.String visitType) {
		this.visitType = visitType;
	}



	/**
	 * Return the value associated with the column: visit_code
	 */
	public java.lang.String getVisitCode () {
		return visitCode;
	}

	/**
	 * Set the value related to the column: visit_code
	 * @param visitCode the visit_code value
	 */
	public void setVisitCode (java.lang.String visitCode) {
		this.visitCode = visitCode;
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
	 * Return the value associated with the column: dependency
	 */
	public java.lang.String getDependency () {
		return dependency;
	}

	/**
	 * Set the value related to the column: dependency
	 * @param dependency the dependency value
	 */
	public void setDependency (java.lang.String dependency) {
		this.dependency = dependency;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hrms.masters.business.HrMasVisitType)) return false;
		else {
			jkt.hrms.masters.business.HrMasVisitType hrMasVisitType = (jkt.hrms.masters.business.HrMasVisitType) obj;
			if (null == this.getId() || null == hrMasVisitType.getId()) return false;
			else return (this.getId().equals(hrMasVisitType.getId()));
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