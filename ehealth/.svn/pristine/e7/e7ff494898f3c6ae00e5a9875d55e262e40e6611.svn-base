package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_cost_center_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_cost_center_code"
 */

public abstract class BaseFaMasCostCenterCode  implements Serializable {

	public static String REF = "FaMasCostCenterCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COST_CENTER_CODE_NAME = "CostCenterCodeName";
	public static String PROP_COST_CENTER_CODE_CODE = "CostCenterCodeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseFaMasCostCenterCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasCostCenterCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String costCenterCodeCode;
	private java.lang.String costCenterCodeName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cost_center_code_id"
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
	 * Return the value associated with the column: cost_center_code_code
	 */
	public java.lang.String getCostCenterCodeCode () {
		return costCenterCodeCode;
	}

	/**
	 * Set the value related to the column: cost_center_code_code
	 * @param costCenterCodeCode the cost_center_code_code value
	 */
	public void setCostCenterCodeCode (java.lang.String costCenterCodeCode) {
		this.costCenterCodeCode = costCenterCodeCode;
	}



	/**
	 * Return the value associated with the column: cost_center_code_name
	 */
	public java.lang.String getCostCenterCodeName () {
		return costCenterCodeName;
	}

	/**
	 * Set the value related to the column: cost_center_code_name
	 * @param costCenterCodeName the cost_center_code_name value
	 */
	public void setCostCenterCodeName (java.lang.String costCenterCodeName) {
		this.costCenterCodeName = costCenterCodeName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasCostCenterCode)) return false;
		else {
			jkt.hms.masters.business.FaMasCostCenterCode faMasCostCenterCode = (jkt.hms.masters.business.FaMasCostCenterCode) obj;
			if (null == this.getId() || null == faMasCostCenterCode.getId()) return false;
			else return (this.getId().equals(faMasCostCenterCode.getId()));
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