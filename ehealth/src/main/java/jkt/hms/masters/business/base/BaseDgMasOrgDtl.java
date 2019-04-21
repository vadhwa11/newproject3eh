package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_mas_org__dtl table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="dg_mas_org__dtl"
 */

public abstract class BaseDgMasOrgDtl implements Serializable {

	public static String REF = "DgMasOrgDtl";
	public static String PROP_STATUS = "Status";
	public static String PROP_ANTIBIOTIC_LAB_ID = "AntibioticLabId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_ORGANISM = "Organism";

	// constructors
	public BaseDgMasOrgDtl() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgMasOrgDtl(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer antibioticLabId;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.DgMasOrganism organism;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="org_dtl_id"
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
	 * Return the value associated with the column: antibiotic_lab_id
	 */
	public java.lang.Integer getAntibioticLabId() {
		return antibioticLabId;
	}

	/**
	 * Set the value related to the column: antibiotic_lab_id
	 * 
	 * @param antibioticLabId
	 *            the antibiotic_lab_id value
	 */
	public void setAntibioticLabId(java.lang.Integer antibioticLabId) {
		this.antibioticLabId = antibioticLabId;
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
	 * Return the value associated with the column: organism_id
	 */
	public jkt.hms.masters.business.DgMasOrganism getOrganism() {
		return organism;
	}

	/**
	 * Set the value related to the column: organism_id
	 * 
	 * @param organism
	 *            the organism_id value
	 */
	public void setOrganism(jkt.hms.masters.business.DgMasOrganism organism) {
		this.organism = organism;
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!(obj instanceof jkt.hms.masters.business.DgMasOrgDtl)) {
			return false;
		} else {
			jkt.hms.masters.business.DgMasOrgDtl dgMasOrgDtl = (jkt.hms.masters.business.DgMasOrgDtl) obj;
			if (null == this.getId() || null == dgMasOrgDtl.getId()) {
				return false;
			} else {
				return (this.getId().equals(dgMasOrgDtl.getId()));
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