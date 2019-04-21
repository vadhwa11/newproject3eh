package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_village table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_village"
 */

public abstract class BaseMasVillage  implements Serializable {

	public static String REF = "MasVillage";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VILLAGE_CODE = "VillageCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VILLAGE_NAME = "VillageName";
	public static String PROP_TALUK = "Taluk";
	public static String PROP_DISTRICT = "District";


	// constructors
	public BaseMasVillage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasVillage (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String villageCode;
	private java.lang.String villageName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasTaluk taluk;
	private jkt.hms.masters.business.MasDistrict district;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="village_id"
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
	 * Return the value associated with the column: village_code
	 */
	public java.lang.String getVillageCode () {
		return villageCode;
	}

	/**
	 * Set the value related to the column: village_code
	 * @param villageCode the village_code value
	 */
	public void setVillageCode (java.lang.String villageCode) {
		this.villageCode = villageCode;
	}



	/**
	 * Return the value associated with the column: village_name
	 */
	public java.lang.String getVillageName () {
		return villageName;
	}

	/**
	 * Set the value related to the column: village_name
	 * @param villageName the village_name value
	 */
	public void setVillageName (java.lang.String villageName) {
		this.villageName = villageName;
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
	 * Return the value associated with the column: taluk_id
	 */
	public jkt.hms.masters.business.MasTaluk getTaluk () {
		return taluk;
	}

	/**
	 * Set the value related to the column: taluk_id
	 * @param taluk the taluk_id value
	 */
	public void setTaluk (jkt.hms.masters.business.MasTaluk taluk) {
		this.taluk = taluk;
	}


	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasVillage)) return false;
		else {
			jkt.hms.masters.business.MasVillage masVillage = (jkt.hms.masters.business.MasVillage) obj;
			if (null == this.getId() || null == masVillage.getId()) return false;
			else return (this.getId().equals(masVillage.getId()));
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