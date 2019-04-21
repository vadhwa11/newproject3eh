package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_pass_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_pass_type"
 */

public abstract class BaseMasPassType  implements Serializable {

	public static String REF = "MasPassType";
	public static String PROP_STATUS = "Status";
	public static String PROP_PASS_TYPE_NAME = "PassTypeName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PASS_TYPE_CODE = "PassTypeCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasPassType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPassType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String passTypeCode;
	private java.lang.String passTypeName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdGatepassDetails> ipdGatepassDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="pass_type_id"
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
	 * Return the value associated with the column: pass_type_code
	 */
	public java.lang.String getPassTypeCode () {
		return passTypeCode;
	}

	/**
	 * Set the value related to the column: pass_type_code
	 * @param passTypeCode the pass_type_code value
	 */
	public void setPassTypeCode (java.lang.String passTypeCode) {
		this.passTypeCode = passTypeCode;
	}



	/**
	 * Return the value associated with the column: pass_type_name
	 */
	public java.lang.String getPassTypeName () {
		return passTypeName;
	}

	/**
	 * Set the value related to the column: pass_type_name
	 * @param passTypeName the pass_type_name value
	 */
	public void setPassTypeName (java.lang.String passTypeName) {
		this.passTypeName = passTypeName;
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



	/**
	 * Return the value associated with the column: IpdGatepassDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdGatepassDetails> getIpdGatepassDetails () {
		return ipdGatepassDetails;
	}

	/**
	 * Set the value related to the column: IpdGatepassDetails
	 * @param ipdGatepassDetails the IpdGatepassDetails value
	 */
	public void setIpdGatepassDetails (java.util.Set<jkt.hms.masters.business.IpdGatepassDetails> ipdGatepassDetails) {
		this.ipdGatepassDetails = ipdGatepassDetails;
	}

	public void addToIpdGatepassDetails (jkt.hms.masters.business.IpdGatepassDetails ipdGatepassDetails) {
		if (null == getIpdGatepassDetails()) setIpdGatepassDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdGatepassDetails>());
		getIpdGatepassDetails().add(ipdGatepassDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPassType)) return false;
		else {
			jkt.hms.masters.business.MasPassType masPassType = (jkt.hms.masters.business.MasPassType) obj;
			if (null == this.getId() || null == masPassType.getId()) return false;
			else return (this.getId().equals(masPassType.getId()));
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