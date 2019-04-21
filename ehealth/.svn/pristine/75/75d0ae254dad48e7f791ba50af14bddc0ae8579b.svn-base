package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_asset_category table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_asset_category"
 */

public abstract class BaseMasAssetCategory  implements Serializable {

	public static String REF = "MasAssetCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_ASSET_CATEGORY_CODE = "AssetCategoryCode";
	public static String PROP_ASSET_CATEGORY_NAME = "AssetCategoryName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasAssetCategory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAssetCategory (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String assetCategoryCode;
	private java.lang.String assetCategoryName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="asset_category_id"
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
	 * Return the value associated with the column: asset_category_code
	 */
	public java.lang.String getAssetCategoryCode () {
		return assetCategoryCode;
	}

	/**
	 * Set the value related to the column: asset_category_code
	 * @param assetCategoryCode the asset_category_code value
	 */
	public void setAssetCategoryCode (java.lang.String assetCategoryCode) {
		this.assetCategoryCode = assetCategoryCode;
	}



	/**
	 * Return the value associated with the column: asset_category_name
	 */
	public java.lang.String getAssetCategoryName () {
		return assetCategoryName;
	}

	/**
	 * Set the value related to the column: asset_category_name
	 * @param assetCategoryName the asset_category_name value
	 */
	public void setAssetCategoryName (java.lang.String assetCategoryName) {
		this.assetCategoryName = assetCategoryName;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAssetCategory)) return false;
		else {
			jkt.hms.masters.business.MasAssetCategory masAssetCategory = (jkt.hms.masters.business.MasAssetCategory) obj;
			if (null == this.getId() || null == masAssetCategory.getId()) return false;
			else return (this.getId().equals(masAssetCategory.getId()));
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