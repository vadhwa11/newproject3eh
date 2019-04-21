package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_scheme_wise_fund_allocate table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_scheme_wise_fund_allocate"
 */

public abstract class BaseFaSchemeWiseFundAllocate  implements Serializable {

	public static String REF = "FaSchemeWiseFundAllocate";
	public static String PROP_UNSPENT_AMT = "UnspentAmt";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_SANCTIONED_AMT = "SanctionedAmt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SPENT_AMT = "SpentAmt";
	public static String PROP_LETTER_NO = "LetterNo";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SANCTION_DATE = "SanctionDate";


	// constructors
	public BaseFaSchemeWiseFundAllocate () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaSchemeWiseFundAllocate (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseFaSchemeWiseFundAllocate (
		java.lang.Integer id,
		jkt.hms.masters.business.Users lastChgBy,
		jkt.hms.masters.business.MasStoreFinancial fYear,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasScheme scheme,
		java.math.BigDecimal sanctionedAmt,
		java.math.BigDecimal spentAmt,
		java.math.BigDecimal unspentAmt,
		java.lang.String status) {

		this.setId(id);
		this.setLastChgBy(lastChgBy);
		this.setFYear(fYear);
		this.setHospital(hospital);
		this.setScheme(scheme);
		this.setSanctionedAmt(sanctionedAmt);
		this.setSpentAmt(spentAmt);
		this.setUnspentAmt(unspentAmt);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal sanctionedAmt;
	private java.math.BigDecimal spentAmt;
	private java.math.BigDecimal unspentAmt;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String letterNo;
	private java.util.Date sanctionDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasScheme scheme;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="fund_allocate_id"
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
	 * Return the value associated with the column: sanctioned_amt
	 */
	public java.math.BigDecimal getSanctionedAmt () {
		return sanctionedAmt;
	}

	/**
	 * Set the value related to the column: sanctioned_amt
	 * @param sanctionedAmt the sanctioned_amt value
	 */
	public void setSanctionedAmt (java.math.BigDecimal sanctionedAmt) {
		this.sanctionedAmt = sanctionedAmt;
	}



	/**
	 * Return the value associated with the column: spent_amt
	 */
	public java.math.BigDecimal getSpentAmt () {
		return spentAmt;
	}

	/**
	 * Set the value related to the column: spent_amt
	 * @param spentAmt the spent_amt value
	 */
	public void setSpentAmt (java.math.BigDecimal spentAmt) {
		this.spentAmt = spentAmt;
	}



	/**
	 * Return the value associated with the column: unspent_amt
	 */
	public java.math.BigDecimal getUnspentAmt () {
		return unspentAmt;
	}

	/**
	 * Set the value related to the column: unspent_amt
	 * @param unspentAmt the unspent_amt value
	 */
	public void setUnspentAmt (java.math.BigDecimal unspentAmt) {
		this.unspentAmt = unspentAmt;
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
	 * Return the value associated with the column: letter_no
	 */
	public java.lang.String getLetterNo () {
		return letterNo;
	}

	/**
	 * Set the value related to the column: letter_no
	 * @param letterNo the letter_no value
	 */
	public void setLetterNo (java.lang.String letterNo) {
		this.letterNo = letterNo;
	}



	/**
	 * Return the value associated with the column: sanction_date
	 */
	public java.util.Date getSanctionDate () {
		return sanctionDate;
	}

	/**
	 * Set the value related to the column: sanction_date
	 * @param sanctionDate the sanction_date value
	 */
	public void setSanctionDate (java.util.Date sanctionDate) {
		this.sanctionDate = sanctionDate;
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
	 * Return the value associated with the column: f_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param fYear the f_year_id value
	 */
	public void setFYear (jkt.hms.masters.business.MasStoreFinancial fYear) {
		this.fYear = fYear;
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
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaSchemeWiseFundAllocate)) return false;
		else {
			jkt.hms.masters.business.FaSchemeWiseFundAllocate faSchemeWiseFundAllocate = (jkt.hms.masters.business.FaSchemeWiseFundAllocate) obj;
			if (null == this.getId() || null == faSchemeWiseFundAllocate.getId()) return false;
			else return (this.getId().equals(faSchemeWiseFundAllocate.getId()));
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