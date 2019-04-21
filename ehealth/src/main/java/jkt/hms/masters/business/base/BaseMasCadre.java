package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_cadre table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_cadre"
 */

public abstract class BaseMasCadre  implements Serializable {

	public static String REF = "MasCadre";
	public static String PROP_SUPERNUMERARY_POST = "SupernumeraryPost";
	public static String PROP_STATUS = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CADRE_STRENGTH = "CadreStrength";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_TEMP_POST = "TempPost";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PERMANENT_POST = "PermanentPost";
	public static String PROP_CADRE_CODE = "CadreCode";
	public static String PROP_CADRE_NAME = "CadreName";


	// constructors
	public BaseMasCadre () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCadre (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String cadreCode;
	private java.lang.String cadreName;
	private java.lang.Integer cadreStrength;
	private java.lang.String status;
	private java.lang.String description;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer permanentPost;
	private java.lang.Integer tempPost;
	private java.lang.Integer supernumeraryPost;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="cadre_id"
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
	 * Return the value associated with the column: cadre_code
	 */
	public java.lang.String getCadreCode () {
		return cadreCode;
	}

	/**
	 * Set the value related to the column: cadre_code
	 * @param cadreCode the cadre_code value
	 */
	public void setCadreCode (java.lang.String cadreCode) {
		this.cadreCode = cadreCode;
	}



	/**
	 * Return the value associated with the column: cadre_name
	 */
	public java.lang.String getCadreName () {
		return cadreName;
	}

	/**
	 * Set the value related to the column: cadre_name
	 * @param cadreName the cadre_name value
	 */
	public void setCadreName (java.lang.String cadreName) {
		this.cadreName = cadreName;
	}



	/**
	 * Return the value associated with the column: cadre_strength
	 */
	public java.lang.Integer getCadreStrength () {
		return cadreStrength;
	}

	/**
	 * Set the value related to the column: cadre_strength
	 * @param cadreStrength the cadre_strength value
	 */
	public void setCadreStrength (java.lang.Integer cadreStrength) {
		this.cadreStrength = cadreStrength;
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
	public java.lang.Integer getTempPost () {
		return tempPost;
	}

	/**
	 * Set the value related to the column: temporary_post
	 * @param tempPost the temporary_post value
	 */
	public void setTempPost (java.lang.Integer tempPost) {
		this.tempPost = tempPost;
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
		if (!(obj instanceof jkt.hms.masters.business.MasCadre)) return false;
		else {
			jkt.hms.masters.business.MasCadre masCadre = (jkt.hms.masters.business.MasCadre) obj;
			if (null == this.getId() || null == masCadre.getId()) return false;
			else return (this.getId().equals(masCadre.getId()));
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