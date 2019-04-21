package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_bill_scheme table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_bill_scheme"
 */

public abstract class BaseMasBillScheme  implements Serializable {

	public static String REF = "MasBillScheme";
	public static String PROP_BILL_SCHEME_CODE = "BillSchemeCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BILL_SCHEME_NAME = "BillSchemeName";


	// constructors
	public BaseMasBillScheme () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBillScheme (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String billSchemeCode;
	private java.lang.String billSchemeName;
	private java.lang.String status;
	private java.lang.String discount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bill_scheme_id"
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
	 * Return the value associated with the column: bill_scheme_code
	 */
	public java.lang.String getBillSchemeCode () {
		return billSchemeCode;
	}

	/**
	 * Set the value related to the column: bill_scheme_code
	 * @param billSchemeCode the bill_scheme_code value
	 */
	public void setBillSchemeCode (java.lang.String billSchemeCode) {
		this.billSchemeCode = billSchemeCode;
	}



	/**
	 * Return the value associated with the column: bill_scheme_name
	 */
	public java.lang.String getBillSchemeName () {
		return billSchemeName;
	}

	/**
	 * Set the value related to the column: bill_scheme_name
	 * @param billSchemeName the bill_scheme_name value
	 */
	public void setBillSchemeName (java.lang.String billSchemeName) {
		this.billSchemeName = billSchemeName;
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
	 * Return the value associated with the column: discount
	 */
	public java.lang.String getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.lang.String discount) {
		this.discount = discount;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBillScheme)) return false;
		else {
			jkt.hms.masters.business.MasBillScheme masBillScheme = (jkt.hms.masters.business.MasBillScheme) obj;
			if (null == this.getId() || null == masBillScheme.getId()) return false;
			else return (this.getId().equals(masBillScheme.getId()));
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