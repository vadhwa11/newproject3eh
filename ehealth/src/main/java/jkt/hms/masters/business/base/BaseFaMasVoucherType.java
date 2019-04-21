package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_voucher_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_voucher_type"
 */

public abstract class BaseFaMasVoucherType  implements Serializable {

	public static String REF = "FaMasVoucherType";
	public static String PROP_STATUS = "Status";
	public static String PROP_VOUCHER_TYPE_DESC = "VoucherTypeDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VOUCHER_TYPE_CODE = "VoucherTypeCode";


	// constructors
	public BaseFaMasVoucherType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasVoucherType (java.lang.Integer id) {
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
	private java.lang.String status;
	private java.lang.String voucherTypeCode;
	private java.lang.String voucherTypeDesc;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaVoucherHeader> faVoucherHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="voucher_type_id"
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
	 * Return the value associated with the column: voucher_type_code
	 */
	public java.lang.String getVoucherTypeCode () {
		return voucherTypeCode;
	}

	/**
	 * Set the value related to the column: voucher_type_code
	 * @param voucherTypeCode the voucher_type_code value
	 */
	public void setVoucherTypeCode (java.lang.String voucherTypeCode) {
		this.voucherTypeCode = voucherTypeCode;
	}



	/**
	 * Return the value associated with the column: voucher_type_desc
	 */
	public java.lang.String getVoucherTypeDesc () {
		return voucherTypeDesc;
	}

	/**
	 * Set the value related to the column: voucher_type_desc
	 * @param voucherTypeDesc the voucher_type_desc value
	 */
	public void setVoucherTypeDesc (java.lang.String voucherTypeDesc) {
		this.voucherTypeDesc = voucherTypeDesc;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: FaVoucherHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.FaVoucherHeader> getFaVoucherHeaders () {
		return faVoucherHeaders;
	}

	/**
	 * Set the value related to the column: FaVoucherHeaders
	 * @param faVoucherHeaders the FaVoucherHeaders value
	 */
	public void setFaVoucherHeaders (java.util.Set<jkt.hms.masters.business.FaVoucherHeader> faVoucherHeaders) {
		this.faVoucherHeaders = faVoucherHeaders;
	}

	public void addToFaVoucherHeaders (jkt.hms.masters.business.FaVoucherHeader faVoucherHeader) {
		if (null == getFaVoucherHeaders()) setFaVoucherHeaders(new java.util.TreeSet<jkt.hms.masters.business.FaVoucherHeader>());
		getFaVoucherHeaders().add(faVoucherHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasVoucherType)) return false;
		else {
			jkt.hms.masters.business.FaMasVoucherType faMasVoucherType = (jkt.hms.masters.business.FaMasVoucherType) obj;
			if (null == this.getId() || null == faMasVoucherType.getId()) return false;
			else return (this.getId().equals(faMasVoucherType.getId()));
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