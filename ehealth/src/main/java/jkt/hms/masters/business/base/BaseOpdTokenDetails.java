package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_token_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_token_details"
 */

public abstract class BaseOpdTokenDetails  implements Serializable {

	public static String REF = "OpdTokenDetails";
	public static String PROP_TOKEN_ID = "TokenId";
	public static String PROP_STATUS = "Status";
	public static String PROP_TOKEN_NUMBER = "TokenNumber";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseOpdTokenDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdTokenDetails (java.lang.Integer tokenId) {
		this.setTokenId(tokenId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer tokenId;

	// fields
	private java.lang.Integer tokenNumber;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="token_id"
     */
	public java.lang.Integer getTokenId () {
		return tokenId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param tokenId the new ID
	 */
	public void setTokenId (java.lang.Integer tokenId) {
		this.tokenId = tokenId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: token_number
	 */
	public java.lang.Integer getTokenNumber () {
		return tokenNumber;
	}

	/**
	 * Set the value related to the column: token_number
	 * @param tokenNumber the token_number value
	 */
	public void setTokenNumber (java.lang.Integer tokenNumber) {
		this.tokenNumber = tokenNumber;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdTokenDetails)) return false;
		else {
			jkt.hms.masters.business.OpdTokenDetails opdTokenDetails = (jkt.hms.masters.business.OpdTokenDetails) obj;
			if (null == this.getTokenId() || null == opdTokenDetails.getTokenId()) return false;
			else return (this.getTokenId().equals(opdTokenDetails.getTokenId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTokenId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTokenId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}