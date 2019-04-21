package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_caste table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_caste"
 */

public abstract class BaseMasCaste  implements Serializable {

	public static String REF = "MasCaste";
	public static String PROP_STATUS = "Status";
	public static String PROP_CASTE_CODE = "CasteCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CASTE_NAME = "CasteName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasCaste () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCaste (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String casteCode;
	private java.lang.String casteName;
	private java.lang.String status;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="caste_id"
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
	 * Return the value associated with the column: caste_code
	 */
	public java.lang.String getCasteCode () {
		return casteCode;
	}

	/**
	 * Set the value related to the column: caste_code
	 * @param casteCode the caste_code value
	 */
	public void setCasteCode (java.lang.String casteCode) {
		this.casteCode = casteCode;
	}



	/**
	 * Return the value associated with the column: caste_name
	 */
	public java.lang.String getCasteName () {
		return casteName;
	}

	/**
	 * Set the value related to the column: caste_name
	 * @param casteName the caste_name value
	 */
	public void setCasteName (java.lang.String casteName) {
		this.casteName = casteName;
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
	


	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	public java.lang.Integer getLastChgBy() {
		return lastChgBy;
	}

	public void setLastChgBy(java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCaste)) return false;
		else {
			jkt.hms.masters.business.MasCaste masCaste = (jkt.hms.masters.business.MasCaste) obj;
			if (null == this.getId() || null == masCaste.getId()) return false;
			else return (this.getId().equals(masCaste.getId()));
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