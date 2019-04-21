package jkt.hrms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hr_mas_infrastructure_requerment table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="hr_mas_infrastructure_requerment"
 */

public abstract class BaseMasInfrastructureRequerment implements Serializable {

	public static String REF = "MasInfrastructureRequerment";
	public static String PROP_STATUS = "Status";
	public static String PROP_INFRAST_CODE = "InfrastCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INFRAST_REQUIRMENT = "InfrastRequirment";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasInfrastructureRequerment() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasInfrastructureRequerment(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String infrastRequirment;
	private java.lang.Integer infrastCode;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital company;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: infrast_requirment
	 */
	public java.lang.String getInfrastRequirment() {
		return infrastRequirment;
	}

	/**
	 * Set the value related to the column: infrast_requirment
	 * 
	 * @param infrastRequirment
	 *            the infrast_requirment value
	 */
	public void setInfrastRequirment(java.lang.String infrastRequirment) {
		this.infrastRequirment = infrastRequirment;
	}

	/**
	 * Return the value associated with the column: infrast_code
	 */
	public java.lang.Integer getInfrastCode() {
		return infrastCode;
	}

	/**
	 * Set the value related to the column: infrast_code
	 * 
	 * @param infrastCode
	 *            the infrast_code value
	 */
	public void setInfrastCode(java.lang.Integer infrastCode) {
		this.infrastCode = infrastCode;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany() {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * 
	 * @param company
	 *            the company_id value
	 */
	public void setCompany(jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hrms.masters.business.MasInfrastructureRequerment)) {
			return false;
		} else {
			jkt.hrms.masters.business.MasInfrastructureRequerment masInfrastructureRequerment = (jkt.hrms.masters.business.MasInfrastructureRequerment) obj;
			if (null == this.getId()
					|| null == masInfrastructureRequerment.getId()) {
				return false;
			} else {
				return (this.getId()
						.equals(masInfrastructureRequerment.getId()));
			}
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) {
				return super.hashCode();
			} else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}