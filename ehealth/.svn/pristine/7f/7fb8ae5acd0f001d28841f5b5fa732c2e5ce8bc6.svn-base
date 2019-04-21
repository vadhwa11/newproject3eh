package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_panchayat table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_panchayat"
 */

public abstract class BaseMasPanchayat  implements Serializable {

	public static String REF = "MasPanchayat";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PANCHAYAT_CODE = "PanchayatCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PANCHAYAT_NAME = "PanchayatName";
	public static String PROP_BLOCK = "Block";
	public static String PROP_TALUK = "Taluk";


	// constructors
	public BaseMasPanchayat () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPanchayat (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String panchayatCode;
	private java.lang.String panchayatName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasTaluk taluk;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasBlock block;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasWard> masWards;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="panchayat_id"
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
	 * Return the value associated with the column: panchayat_code
	 */
	public java.lang.String getPanchayatCode () {
		return panchayatCode;
	}

	/**
	 * Set the value related to the column: panchayat_code
	 * @param panchayatCode the panchayat_code value
	 */
	public void setPanchayatCode (java.lang.String panchayatCode) {
		this.panchayatCode = panchayatCode;
	}



	/**
	 * Return the value associated with the column: panchayat_name
	 */
	public java.lang.String getPanchayatName () {
		return panchayatName;
	}

	/**
	 * Set the value related to the column: panchayat_name
	 * @param panchayatName the panchayat_name value
	 */
	public void setPanchayatName (java.lang.String panchayatName) {
		this.panchayatName = panchayatName;
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



	/**
	 * Return the value associated with the column: block_id
	 */
	public jkt.hms.masters.business.MasBlock getBlock () {
		return block;
	}

	/**
	 * Set the value related to the column: block_id
	 * @param block the block_id value
	 */
	public void setBlock (jkt.hms.masters.business.MasBlock block) {
		this.block = block;
	}



	/**
	 * Return the value associated with the column: MasWards
	 */
	public java.util.Set<jkt.hms.masters.business.MasWard> getMasWards () {
		return masWards;
	}

	/**
	 * Set the value related to the column: MasWards
	 * @param masWards the MasWards value
	 */
	public void setMasWards (java.util.Set<jkt.hms.masters.business.MasWard> masWards) {
		this.masWards = masWards;
	}

	public void addToMasWards (jkt.hms.masters.business.MasWard masWard) {
		if (null == getMasWards()) setMasWards(new java.util.TreeSet<jkt.hms.masters.business.MasWard>());
		getMasWards().add(masWard);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPanchayat)) return false;
		else {
			jkt.hms.masters.business.MasPanchayat masPanchayat = (jkt.hms.masters.business.MasPanchayat) obj;
			if (null == this.getId() || null == masPanchayat.getId()) return false;
			else return (this.getId().equals(masPanchayat.getId()));
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