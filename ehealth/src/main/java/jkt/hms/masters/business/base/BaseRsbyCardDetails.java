package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the rsby_card_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="rsby_card_details"
 */

public abstract class BaseRsbyCardDetails  implements Serializable {

	public static String REF = "RsbyCardDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_RSBY_CARD_NO = "RsbyCardNo";
	public static String PROP_BALANCE_UTILIZED = "BalanceUtilized";
	public static String PROP_PKG_SCHEME = "PkgScheme";
	public static String PROP_ID = "Id";


	// constructors
	public BaseRsbyCardDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRsbyCardDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRsbyCardDetails (
		java.lang.Integer id,
		java.lang.String rsbyCardNo,
		java.math.BigDecimal balanceUtilized,
		java.lang.String status) {

		this.setId(id);
		this.setRsbyCardNo(rsbyCardNo);
		this.setBalanceUtilized(balanceUtilized);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal balanceUtilized;
	private java.lang.String rsbyCardNo;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasScheme pkgScheme;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="rsby_card_id"
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
	 * Return the value associated with the column: balance_utilized
	 */
	public java.math.BigDecimal getBalanceUtilized () {
		return balanceUtilized;
	}

	/**
	 * Set the value related to the column: balance_utilized
	 * @param balanceUtilized the balance_utilized value
	 */
	public void setBalanceUtilized (java.math.BigDecimal balanceUtilized) {
		this.balanceUtilized = balanceUtilized;
	}



	/**
	 * Return the value associated with the column: rsby_card_no
	 */
	public java.lang.String getRsbyCardNo () {
		return rsbyCardNo;
	}

	/**
	 * Set the value related to the column: rsby_card_no
	 * @param rsbyCardNo the rsby_card_no value
	 */
	public void setRsbyCardNo (java.lang.String rsbyCardNo) {
		this.rsbyCardNo = rsbyCardNo;
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
	 * Return the value associated with the column: pkg_scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getPkgScheme () {
		return pkgScheme;
	}

	/**
	 * Set the value related to the column: pkg_scheme_id
	 * @param pkgScheme the pkg_scheme_id value
	 */
	public void setPkgScheme (jkt.hms.masters.business.MasScheme pkgScheme) {
		this.pkgScheme = pkgScheme;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.RsbyCardDetails)) return false;
		else {
			jkt.hms.masters.business.RsbyCardDetails rsbyCardDetails = (jkt.hms.masters.business.RsbyCardDetails) obj;
			if (null == this.getId() || null == rsbyCardDetails.getId()) return false;
			else return (this.getId().equals(rsbyCardDetails.getId()));
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